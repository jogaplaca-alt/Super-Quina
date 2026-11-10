package ru.a402d.rawbtprinter;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import com.dantsu.escposprinter.connection.bluetooth.BluetoothConnection;
import java.util.Base64;

public class PrintRawBtActivity extends Activity {
    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        TextView message = new TextView(this);
        message.setPadding(32, 48, 32, 32);
        message.setText("Recebendo comprovante para impressão…");
        setContentView(message);
        if (Build.VERSION.SDK_INT >= 31 && checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            message.setText("Abra o Printer Super Sena e conceda a permissão Bluetooth antes de imprimir.");
            return;
        }
        new Thread(() -> {
            try {
                byte[] payload = decodePayload(getIntent());
                String mac = getSharedPreferences("Printer Super Sena", MODE_PRIVATE).getString("printer_mac", "");
                if (mac.isEmpty()) mac = getPreferences(MODE_PRIVATE).getString("printer_mac", "");
                if (mac.isEmpty()) throw new IllegalStateException("Nenhuma impressora salva. Abra o aplicativo e selecione uma impressora.");
                BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
                if (adapter == null) throw new IllegalStateException("Bluetooth indisponível neste aparelho.");
                BluetoothConnection connection = new BluetoothConnection(mac);
                connection.connect();
                connection.write(payload);
                connection.send();
                connection.disconnect();
                runOnUiThread(() -> message.setText("Comprovante enviado para a impressora."));
            } catch (Exception e) {
                runOnUiThread(() -> message.setText("Não foi possível imprimir: " + e.getMessage()));
            }
        }).start();
    }

    private byte[] decodePayload(Intent intent) {
        Uri uri = intent.getData();
        if (uri == null) throw new IllegalArgumentException("Endereço de impressão vazio.");
        String value = uri.getSchemeSpecificPart();
        if (value == null || !value.startsWith("base64,")) {
            throw new IllegalArgumentException("Formato recebido não reconhecido. Esperado: rawbt:base64,...");
        }
        String encoded = value.substring("base64,".length());
        return Base64.getDecoder().decode(encoded);
    }
}
