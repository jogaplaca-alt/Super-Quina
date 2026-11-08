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

@CapacitorPlugin(
    name = "RawBtPrinter",
    permissions = {
        @Permission(
            alias = "bluetoothConnect",
            strings = { Manifest.permission.BLUETOOTH_CONNECT }
        )
    }
)
public class RawBtPrinterPlugin extends Plugin {
    private static final UUID SPP_UUID =
        UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    private final ExecutorService ioExecutor = Executors.newSingleThreadExecutor();
    private BluetoothSocket socket;
    private String connectedDeviceId;
    private String connectedDeviceName;

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
                candidate = device.createRfcommSocketToServiceRecord(SPP_UUID);
                candidate.connect();
                socket = candidate;
                connectedDeviceId = device.getAddress();
                String name = device.getName();
                connectedDeviceName = name == null ? "Impressora Bluetooth" : name;

                JSObject result = new JSObject();
                result.put("connected", true);
                result.put("deviceId", connectedDeviceId);
                result.put("name", connectedDeviceName);
                call.resolve(result);
            } catch (SecurityException error) {
                closeQuietly(candidate);
                call.reject("Permissão Bluetooth não concedida.", "PERMISSION_DENIED");
            } catch (IOException error) {
                closeQuietly(candidate);
                call.reject("Não foi possível conectar. Verifique se a impressora está ligada e pareada.", "CONNECTION_FAILED");
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
                byte[] data = android.util.Base64.decode(encoded, android.util.Base64.DEFAULT);
                OutputStream output = socket.getOutputStream();
                output.write(data);
                output.flush();

                JSObject result = new JSObject();
                result.put("bytesWritten", data.length);
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
        JSObject result = new JSObject();
        boolean connected = socket != null && socket.isConnected();
        result.put("connected", connected);
        if (connected) {
            result.put("deviceId", connectedDeviceId);
            result.put("name", connectedDeviceName);
        }
        call.resolve(result);
    }

    private boolean ensureConnectPermission(PluginCall call, String operation) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
            getContext().checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        saveCall(call);
        if ("list".equals(operation)) {
            requestPermissionForAlias("bluetoothConnect", call, "listPermissionCallback");
        } else if ("connect".equals(operation)) {
            requestPermissionForAlias("bluetoothConnect", call, "connectPermissionCallback");
        } else {
            requestPermissionForAlias("bluetoothConnect", call, "sendPermissionCallback");
        }
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
        super.handleOnDestroy();
    }
}
