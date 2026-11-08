package com.superquina.app;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Build;
import android.util.Base64;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.PermissionState;
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

@CapacitorPlugin(
    name = "BluetoothPrinter",
    permissions = {
        @Permission(
            alias = "bluetoothConnect",
            strings = { Manifest.permission.BLUETOOTH_CONNECT }
        )
    }
)
public class BluetoothPrinterPlugin extends Plugin {
    private static final UUID SPP_UUID =
        UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final ExecutorService IO = Executors.newSingleThreadExecutor();
    private static final ScheduledExecutorService TIMEOUTS = Executors.newSingleThreadScheduledExecutor();
    private static final long CONNECT_TIMEOUT_SECONDS = 15;

    @PluginMethod
    public void listPairedDevices(PluginCall call) {
        if (!ensureBluetoothPermission(call, "listPairedDevicesPermissionCallback")) return;
        IO.execute(() -> {
            try {
                BluetoothAdapter adapter = getBluetoothAdapter();
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
                    item.put("name", device.getName() == null ? "Impressora Bluetooth" : device.getName());
                    item.put("type", device.getType());
                    devices.put(item);
                }
                JSObject result = new JSObject();
                result.put("devices", devices);
                call.resolve(result);
            } catch (SecurityException error) {
                call.reject("Permissão para conectar ao Bluetooth não concedida.", "PERMISSION_DENIED", error);
            } catch (Exception error) {
                call.reject("Não foi possível listar os dispositivos pareados.", "DEVICE_UNAVAILABLE", error);
            }
        });
    }

    @PermissionCallback
    private void listPairedDevicesPermissionCallback(PluginCall call) {
        if (getPermissionState("bluetoothConnect") == PermissionState.GRANTED) {
            listPairedDevices(call);
        } else {
            call.reject("Permissão Bluetooth necessária.", "PERMISSION_DENIED");
        }
    }

    @PluginMethod
    public void printEscPos(PluginCall call) {
        if (!ensureBluetoothPermission(call, "printEscPosPermissionCallback")) return;
        String address = call.getString("deviceId");
        String base64 = call.getString("data");
        if (address == null || !address.matches("(?i)^([0-9a-f]{2}:){5}[0-9a-f]{2}$")) {
            call.reject("Identificador da impressora inválido.", "DEVICE_UNAVAILABLE");
            return;
        }
        if (base64 == null || base64.isEmpty()) {
            call.reject("Dados ESC/POS não informados.", "ENCODING_FAILED");
            return;
        }

        final byte[] payload;
        try {
            payload = Base64.decode(base64, Base64.DEFAULT);
            if (payload.length == 0) {
                call.reject("O conteúdo da impressão está vazio.", "ENCODING_FAILED");
                return;
            }
        } catch (IllegalArgumentException error) {
            call.reject("Os dados da impressão não estão em Base64 válido.", "ENCODING_FAILED", error);
            return;
        }

        IO.execute(() -> sendToPrinter(call, address, payload));
    }

    @PermissionCallback
    private void printEscPosPermissionCallback(PluginCall call) {
        if (getPermissionState("bluetoothConnect") == PermissionState.GRANTED) {
            printEscPos(call);
        } else {
            call.reject("Permissão Bluetooth necessária.", "PERMISSION_DENIED");
        }
    }

    private boolean ensureBluetoothPermission(PluginCall call, String callback) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
            getPermissionState("bluetoothConnect") == PermissionState.GRANTED) {
            return true;
        }
        requestPermissionForAlias("bluetoothConnect", call, callback);
        return false;
    }

    private BluetoothAdapter getBluetoothAdapter() {
        BluetoothManager manager = (BluetoothManager) getContext().getSystemService(Context.BLUETOOTH_SERVICE);
        return manager == null ? BluetoothAdapter.getDefaultAdapter() : manager.getAdapter();
    }

    private void connectWithTimeout(BluetoothSocket socket) throws IOException {
        final BluetoothSocket connectingSocket = socket;
        ScheduledFuture<?> connectTimeout = TIMEOUTS.schedule(() -> {
            try { connectingSocket.close(); } catch (Exception ignored) { }
        }, CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        try {
            socket.connect();
        } finally {
            connectTimeout.cancel(false);
        }
    }

    private void sendToPrinter(PluginCall call, String address, byte[] payload) {
        BluetoothSocket socket = null;
        try {
            BluetoothAdapter adapter = getBluetoothAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                call.reject("Bluetooth indisponível ou desligado.", "DEVICE_UNAVAILABLE");
                return;
            }

            // RawBT-style compatibility: try the secure SPP channel first, then
            // the insecure RFCOMM channel used by some low-cost thermal printers.
            // No active device discovery is performed; BLUETOOTH_SCAN is not requested.
            BluetoothDevice device = adapter.getRemoteDevice(address);
            socket = device.createRfcommSocketToServiceRecord(SPP_UUID);
            try {
                connectWithTimeout(socket);
            } catch (IOException secureError) {
                try { socket.close(); } catch (Exception ignored) { }
                socket = device.createInsecureRfcommSocketToServiceRecord(SPP_UUID);
                try {
                    connectWithTimeout(socket);
                } catch (IOException insecureError) {
                    insecureError.addSuppressed(secureError);
                    throw insecureError;
                }
            }
            OutputStream output = socket.getOutputStream();
            final BluetoothSocket sendingSocket = socket;
            ScheduledFuture<?> sendTimeout = TIMEOUTS.schedule(() -> {
                try { sendingSocket.close(); } catch (Exception ignored) { }
            }, 30, TimeUnit.SECONDS);
            try {
                output.write(payload);
                output.flush();
            } finally {
                sendTimeout.cancel(false);
            }

            JSObject result = new JSObject();
            result.put("bytesWritten", payload.length);
            result.put("transport", "RFCOMM_SPP");
            call.resolve(result);
        } catch (SecurityException error) {
            call.reject("Permissão para conectar ao Bluetooth não concedida.", "PERMISSION_DENIED", error);
        } catch (Exception error) {
            call.reject("Falha ao conectar ou enviar dados à impressora. Verifique se ela está pareada e ligada.", "CONNECTION_FAILED", error);
        } finally {
            if (socket != null) {
                try { socket.close(); } catch (Exception ignored) { }
            }
        }
    }
}
