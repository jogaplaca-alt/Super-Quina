package com.superquina.printer;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.pm.PackageManager;
import android.os.Build;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@CapacitorPlugin(
    name = "SuperQuinaPrinter",
    permissions = {
        @Permission(alias = "bluetoothConnect", strings = { Manifest.permission.BLUETOOTH_CONNECT })
    }
)
public class RawBtPrinterPlugin extends Plugin {
    private static final UUID SPP_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final long CONNECT_TIMEOUT_SECONDS = 15;
    private static final int MAX_PRINT_BYTES = 512 * 1024;
    private static final int WRITE_CHUNK_BYTES = 256;
    private static final long WRITE_PAUSE_MILLIS = 30;

    // Serialize socket operations so connect/disconnect/send cannot race.
    private final ExecutorService ioExecutor = Executors.newSingleThreadExecutor();
    private final ScheduledExecutorService timeoutExecutor = Executors.newSingleThreadScheduledExecutor();
    private BluetoothSocket socket;
    private String connectedDeviceId;
    private String connectedDeviceName;


    @PluginMethod
    public void discoverDevices(PluginCall call) {
        if (!ensureScanPermission(call)) return;
        ioExecutor.execute(() -> {
            BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                call.reject("Ative o Bluetooth para localizar a impressora.", "BLUETOOTH_DISABLED");
                return;
            }
            try {
                if (adapter.isDiscovering()) adapter.cancelDiscovery();
                JSArray found = new JSArray();
                Set<String> seen = new java.util.HashSet<>();
                for (BluetoothDevice device : adapter.getBondedDevices()) {
                    JSObject item = new JSObject();
                    item.put("id", device.getAddress());
                    item.put("name", safeDeviceName(device));
                    item.put("paired", true);
                    found.put(item);
                    seen.add(device.getAddress());
                }
                final android.content.BroadcastReceiver[] receiver = new android.content.BroadcastReceiver[1];
                final android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
                final Runnable finish = () -> {
                    try { if (adapter.isDiscovering()) adapter.cancelDiscovery(); } catch (SecurityException ignored) { }
                    if (receiver[0] != null) {
                        try { getContext().unregisterReceiver(receiver[0]); } catch (Exception ignored) { }
                    }
                    JSObject result = new JSObject();
                    result.put("devices", found);
                    call.resolve(result);
                };
                receiver[0] = new android.content.BroadcastReceiver() {
                    @Override public void onReceive(android.content.Context context, android.content.Intent intent) {
                        String action = intent.getAction();
                        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                            if (device == null) return;
                            try {
                                String id = device.getAddress();
                                if (seen.add(id)) {
                                    JSObject item = new JSObject();
                                    item.put("id", id);
                                    item.put("name", safeDeviceName(device));
                                    item.put("paired", device.getBondState() == BluetoothDevice.BOND_BONDED);
                                    found.put(item);
                                }
                            } catch (SecurityException ignored) { }
                        } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                            handler.removeCallbacks(finish);
                            finish.run();
                        }
                    }
                };
                android.content.IntentFilter filter = new android.content.IntentFilter(BluetoothDevice.ACTION_FOUND);
                filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
                if (Build.VERSION.SDK_INT >= 33) {
                    getContext().registerReceiver(receiver[0], filter, android.content.Context.RECEIVER_NOT_EXPORTED);
                } else {
                    getContext().registerReceiver(receiver[0], filter);
                }
                if (!adapter.startDiscovery()) {
                    finish.run();
                    return;
                }
                handler.postDelayed(finish, 18000);
            } catch (SecurityException error) {
                call.reject("Permissão para localizar dispositivos Bluetooth negada.", "PERMISSION_DENIED");
            } catch (Exception error) {
                call.reject("Não foi possível procurar impressoras Bluetooth.", "DISCOVERY_FAILED");
            }
        });
    }

    @PluginMethod
    public void pairDevice(PluginCall call) {
        String deviceId = call.getString("deviceId");
        if (deviceId == null || !deviceId.matches("(?i)[0-9A-F]{2}(:[0-9A-F]{2}){5}")) {
            call.reject("Identificador da impressora inválido.", "INVALID_DEVICE_ID");
            return;
        }
        if (!ensureConnectPermission(call, "pair")) return;
        ioExecutor.execute(() -> {
            try {
                BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
                if (adapter == null || !adapter.isEnabled()) {
                    call.reject("Ative o Bluetooth antes de emparelhar.", "BLUETOOTH_DISABLED");
                    return;
                }
                BluetoothDevice device = adapter.getRemoteDevice(deviceId);
                if (device.getBondState() == BluetoothDevice.BOND_BONDED) {
                    JSObject result = new JSObject();
                    result.put("paired", true);
                    result.put("deviceId", deviceId);
                    call.resolve(result);
                    return;
                }
                boolean started = device.createBond();
                if (!started) {
                    call.reject("O Android não iniciou o emparelhamento. Tente novamente.", "PAIRING_FAILED");
                    return;
                }
                JSObject result = new JSObject();
                result.put("paired", false);
                result.put("pairingStarted", true);
                result.put("deviceId", deviceId);
                call.resolve(result);
            } catch (SecurityException error) {
                call.reject("Permissão Bluetooth não concedida.", "PERMISSION_DENIED");
            } catch (Exception error) {
                call.reject("Não foi possível iniciar o emparelhamento.", "PAIRING_FAILED");
            }
        });
    }

    private String safeDeviceName(BluetoothDevice device) {
        try {
            String name = device.getName();
            return name == null || name.trim().isEmpty() ? "Dispositivo Bluetooth" : name;
        } catch (SecurityException ignored) {
            return "Dispositivo Bluetooth";
        }
    }

    @PluginMethod
    public void openBluetoothSettings(PluginCall call) {
        try {
            android.content.Intent intent = new android.content.Intent(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);
            intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
            getContext().startActivity(intent);
            JSObject result = new JSObject();
            result.put("opened", true);
            call.resolve(result);
        } catch (Exception error) {
            call.reject("Não foi possível abrir as configurações Bluetooth do Android.", "BLUETOOTH_SETTINGS_FAILED");
        }
    }

    @PluginMethod
    public void listPairedDevices(PluginCall call) {
        if (!ensureConnectPermission(call, "list")) return;
        ioExecutor.execute(() -> {
            try {
                BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
                if (adapter == null) {
                    call.reject("Este aparelho não possui Bluetooth.", "BLUETOOTH_UNAVAILABLE");
                    return;
                }
                if (!adapter.isEnabled()) {
                    call.reject("Ative o Bluetooth nas configurações do Android.", "BLUETOOTH_DISABLED");
                    return;
                }
                Set<BluetoothDevice> bonded = adapter.getBondedDevices();
                JSArray devices = new JSArray();
                for (BluetoothDevice device : bonded) {
                    JSObject item = new JSObject();
                    item.put("id", device.getAddress());
                    String name = device.getName();
                    item.put("name", name == null || name.trim().isEmpty() ? "Impressora Bluetooth" : name);
                    devices.put(item);
                }
                JSObject result = new JSObject();
                result.put("devices", devices);
                call.resolve(result);
            } catch (SecurityException error) {
                call.reject("Permissão Bluetooth não concedida.", "PERMISSION_DENIED");
            } catch (Exception error) {
                call.reject("Não foi possível listar os dispositivos pareados.", "DEVICE_LIST_FAILED");
            }
        });
    }

    @PluginMethod
    public void connect(PluginCall call) {
        String deviceId = call.getString("deviceId");
        if (deviceId == null || !deviceId.matches("(?i)[0-9A-F]{2}(:[0-9A-F]{2}){5}")) {
            call.reject("Identificador da impressora inválido.", "INVALID_DEVICE_ID");
            return;
        }
        if (!ensureConnectPermission(call, "connect")) return;
        ioExecutor.execute(() -> {
            BluetoothSocket candidate = null;
            try {
                BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
                if (adapter == null || !adapter.isEnabled()) {
                    call.reject("Bluetooth indisponível ou desligado.", "BLUETOOTH_DISABLED");
                    return;
                }
                BluetoothDevice device = adapter.getRemoteDevice(deviceId);
                closeSocket();
                try {
                    candidate = device.createRfcommSocketToServiceRecord(SPP_UUID);
                    connectWithTimeout(candidate);
                } catch (ConnectTimeoutException timeoutError) {
                    throw timeoutError;
                } catch (IOException secureError) {
                    closeQuietly(candidate);
                    candidate = device.createInsecureRfcommSocketToServiceRecord(SPP_UUID);
                    connectWithTimeout(candidate);
                }
                socket = candidate;
                connectedDeviceId = device.getAddress();
                String name = device.getName();
                connectedDeviceName = name == null ? "Impressora Bluetooth" : name;
                JSObject result = new JSObject();
                result.put("connected", true);
                result.put("deviceId", connectedDeviceId);
                result.put("name", connectedDeviceName);
                call.resolve(result);
            } catch (ConnectTimeoutException error) {
                closeQuietly(candidate);
                call.reject("A impressora não respondeu dentro de 15 segundos.", "CONNECTION_TIMEOUT");
            } catch (SecurityException error) {
                closeQuietly(candidate);
                call.reject("Permissão Bluetooth não concedida.", "PERMISSION_DENIED");
            } catch (IOException error) {
                closeQuietly(candidate);
                call.reject("Não foi possível abrir o canal Bluetooth SPP. Verifique se a impressora está ligada, pareada e disponível.", "CONNECTION_FAILED");
            } catch (Exception error) {
                closeQuietly(candidate);
                call.reject("Falha ao conectar à impressora.", "CONNECTION_FAILED");
            }
        });
    }

    @PluginMethod
    public void send(PluginCall call) {
        String encoded = call.getString("dataBase64");
        if (encoded == null || encoded.isEmpty()) {
            call.reject("Nenhum dado de impressão foi recebido.", "EMPTY_PRINT_DATA");
            return;
        }
        if (!ensureConnectPermission(call, "send")) return;
        ioExecutor.execute(() -> {
            try {
                if (socket == null || !socket.isConnected()) {
                    call.reject("A impressora não está conectada.", "DEVICE_UNAVAILABLE");
                    return;
                }
                if (encoded.length() > 700000) {
                    call.reject("Trabalho de impressão excede o limite permitido.", "PRINT_DATA_TOO_LARGE");
                    return;
                }
                byte[] data = android.util.Base64.decode(encoded, android.util.Base64.DEFAULT);
                if (data.length == 0 || data.length > MAX_PRINT_BYTES) {
                    call.reject("Tamanho dos dados de impressão inválido.", "PRINT_DATA_TOO_LARGE");
                    return;
                }
                OutputStream output = socket.getOutputStream();
                for (int offset = 0; offset < data.length; offset += WRITE_CHUNK_BYTES) {
                    int length = Math.min(WRITE_CHUNK_BYTES, data.length - offset);
                    output.write(data, offset, length);
                    output.flush();
                    if (offset + length < data.length) {
                        try {
                            Thread.sleep(WRITE_PAUSE_MILLIS);
                        } catch (InterruptedException interrupted) {
                            Thread.currentThread().interrupt();
                            throw new IOException("Bluetooth write interrupted.", interrupted);
                        }
                    }
                }
                JSObject result = new JSObject();
                result.put("bytesWritten", data.length);
                result.put("transportAccepted", true);
                call.resolve(result);
            } catch (SecurityException error) {
                call.reject("Permissão Bluetooth não concedida.", "PERMISSION_DENIED");
            } catch (IOException error) {
                closeSocket();
                call.reject("Falha ao transmitir os dados. O resultado físico pode ser incerto.", "WRITE_FAILED");
            } catch (IllegalArgumentException error) {
                call.reject("Os dados de impressão não estão em Base64 válido.", "INVALID_PRINT_DATA");
            } catch (Exception error) {
                call.reject("Falha inesperada durante a impressão.", "WRITE_FAILED");
            }
        });
    }

    @PluginMethod
    public void disconnect(PluginCall call) {
        ioExecutor.execute(() -> {
            closeSocket();
            JSObject result = new JSObject();
            result.put("disconnected", true);
            call.resolve(result);
        });
    }

    @PluginMethod
    public void getConnectionState(PluginCall call) {
        ioExecutor.execute(() -> {
            JSObject result = new JSObject();
            boolean connected = socket != null && socket.isConnected();
            result.put("connected", connected);
            if (connected) {
                result.put("deviceId", connectedDeviceId);
                result.put("name", connectedDeviceName);
            } else {
                closeSocket();
            }
            call.resolve(result);
        });
    }

    private void connectWithTimeout(BluetoothSocket candidate) throws IOException {
        AtomicBoolean timedOut = new AtomicBoolean(false);
        ScheduledFuture<?> timeout = timeoutExecutor.schedule(() -> {
            timedOut.set(true);
            closeQuietly(candidate);
        }, CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        try {
            candidate.connect();
            if (timedOut.get()) throw new ConnectTimeoutException();
        } catch (IOException error) {
            if (timedOut.get()) {
                ConnectTimeoutException timeoutError = new ConnectTimeoutException();
                timeoutError.initCause(error);
                throw timeoutError;
            }
            throw error;
        } finally {
            timeout.cancel(false);
        }
    }

    private static final class ConnectTimeoutException extends IOException {
        ConnectTimeoutException() { super("Bluetooth RFCOMM connection timed out."); }
    }

    private boolean ensureConnectPermission(PluginCall call, String operation) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
            getContext().checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        saveCall(call);
        String callback = "list".equals(operation) ? "listPermissionCallback" :
            ("connect".equals(operation) ? "connectPermissionCallback" : ("pair".equals(operation) ? "pairPermissionCallback" : "sendPermissionCallback"));
        requestPermissionForAlias("bluetoothConnect", call, callback);
        return false;
    }

    @PermissionCallback
    private void listPermissionCallback(PluginCall call) {
        if (hasPermission("bluetoothConnect")) listPairedDevices(call);
        else call.reject("Permissão para acessar dispositivos Bluetooth negada.", "PERMISSION_DENIED");
    }

    @PermissionCallback
    private void connectPermissionCallback(PluginCall call) {
        if (hasPermission("bluetoothConnect")) connect(call);
        else call.reject("Permissão para conectar à impressora negada.", "PERMISSION_DENIED");
    }

    @PermissionCallback
    private void pairPermissionCallback(PluginCall call) {
        if (hasPermission("bluetoothConnect")) pairDevice(call);
        else call.reject("Permissão para emparelhar dispositivos Bluetooth negada.", "PERMISSION_DENIED");
    }

    private boolean ensureScanPermission(PluginCall call) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (getContext().checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_GRANTED) return true;
            saveCall(call);
            requestPermissionForAlias("bluetoothScan", call, "scanPermissionCallback");
            return false;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && getContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            saveCall(call);
            requestPermissionForAlias("location", call, "scanPermissionCallback");
            return false;
        }
        return true;
    }

    @PermissionCallback
    private void scanPermissionCallback(PluginCall call) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S ? hasPermission("bluetoothScan") : hasPermission("location")) discoverDevices(call);
        else call.reject("Permissão necessária para localizar impressoras Bluetooth não concedida.", "PERMISSION_DENIED");
    }

    @PermissionCallback
    private void sendPermissionCallback(PluginCall call) {
        if (hasPermission("bluetoothConnect")) send(call);
        else call.reject("Permissão para enviar dados à impressora negada.", "PERMISSION_DENIED");
    }

    private void closeSocket() {
        closeQuietly(socket);
        socket = null;
        connectedDeviceId = null;
        connectedDeviceName = null;
    }

    private void closeQuietly(BluetoothSocket value) {
        if (value == null) return;
        try { value.close(); } catch (IOException ignored) { }
    }

    @Override
    protected void handleOnDestroy() {
        ioExecutor.execute(this::closeSocket);
        ioExecutor.shutdown();
        timeoutExecutor.shutdownNow();
        super.handleOnDestroy();
    }
}
