package ru.a402d.rawbtprinter;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends Activity {
    private static final int REQUEST_BT = 41;
    private Spinner printers;
    private TextView status;
    private final ArrayList<String> addresses = new ArrayList<>();

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        buildScreen();
        if (Build.VERSION.SDK_INT >= 31 && (checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED)) {
            requestPermissions(new String[]{Manifest.permission.BLUETOOTH_CONNECT, Manifest.permission.BLUETOOTH_SCAN}, REQUEST_BT);
        } else loadPrinters();
    }

    private void buildScreen() {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(28, 36, 28, 28);
        TextView title = new TextView(this);
        title.setText("Printer Super Sena");
        title.setTextSize(25);
        title.setPadding(0, 0, 0, 18);
        root.addView(title);
        TextView help = new TextView(this);
        help.setText("Selecione uma impressora térmica Bluetooth já pareada com o Android. Depois, o site poderá enviar comprovantes pelo endereço rawbt:.");
        help.setTextSize(16);
        root.addView(help);
        printers = new Spinner(this);
        root.addView(printers, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        Button refresh = new Button(this);
        refresh.setText("Atualizar impressoras");
        refresh.setOnClickListener(v -> loadPrinters());
        root.addView(refresh);
        Button save = new Button(this);
        save.setText("Salvar impressora selecionada");
        save.setOnClickListener(v -> savePrinter());
        root.addView(save);
        status = new TextView(this);
        status.setTextSize(14);
        status.setPadding(0, 18, 0, 0);
        root.addView(status);
        setContentView(root);
    }

    private void loadPrinters() {
        try {
            BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
            if (adapter == null) { status.setText("Este aparelho não possui Bluetooth."); return; }
            if (Build.VERSION.SDK_INT >= 31 && (checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED)) {
                requestPermissions(new String[]{Manifest.permission.BLUETOOTH_CONNECT, Manifest.permission.BLUETOOTH_SCAN}, REQUEST_BT); return;
            }
            Set<BluetoothDevice> paired = adapter.getBondedDevices();
            addresses.clear();
            ArrayList<String> labels = new ArrayList<>();
            for (BluetoothDevice device : paired) {
                addresses.add(device.getAddress());
                labels.add(device.getName() + " — " + device.getAddress());
            }
            if (labels.isEmpty()) labels.add("Nenhuma impressora pareada");
            printers.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, labels));
            String saved = getSharedPreferences("printer_settings", MODE_PRIVATE).getString("printer_mac", "");
            int index = addresses.indexOf(saved);
            if (index >= 0) printers.setSelection(index);
            status.setText(labels.size() + " dispositivo(s) encontrado(s).");
        } catch (SecurityException e) {
            status.setText("Permissão Bluetooth não concedida.");
        }
    }

    private void savePrinter() {
        int index = printers.getSelectedItemPosition();
        if (index < 0 || index >= addresses.size()) { status.setText("Pareie uma impressora Bluetooth primeiro."); return; }
        getSharedPreferences("printer_settings", MODE_PRIVATE).edit().putString("printer_mac", addresses.get(index)).apply();
        status.setText("Impressora salva. O aplicativo está pronto para receber trabalhos rawbt:.");
    }

    @Override public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] results) {
        super.onRequestPermissionsResult(requestCode, permissions, results);
        if (requestCode == REQUEST_BT && results.length >= 2 && results[0] == PackageManager.PERMISSION_GRANTED && results[1] == PackageManager.PERMISSION_GRANTED) loadPrinters();
        else status.setText("A permissão Bluetooth é necessária para localizar a impressora.");
    }
}
