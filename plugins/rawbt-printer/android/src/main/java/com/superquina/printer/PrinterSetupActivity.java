package com.superquina.printer;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class PrinterSetupActivity extends Activity {
    private static final int REQUEST_BLUETOOTH = 5810;
    private TextView status;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        int pad = (int) (24 * getResources().getDisplayMetrics().density);
        layout.setPadding(pad, pad, pad, pad);
        layout.setGravity(Gravity.CENTER_VERTICAL);

        TextView title = new TextView(this);
        title.setText("Super Quina · Impressora Bluetooth");
        title.setTextSize(21);
        title.setPadding(0, 0, 0, pad);
        layout.addView(title);

        status = new TextView(this);
        status.setText("Autorize o acesso aos dispositivos Bluetooth para localizar sua impressora pareada no serviço de impressão do Android.");
        status.setTextSize(16);
        status.setPadding(0, 0, 0, pad);
        layout.addView(status);

        Button permission = new Button(this);
        permission.setText("Autorizar Bluetooth");
        permission.setOnClickListener(view -> requestBluetoothPermission());
        layout.addView(permission);

        Button close = new Button(this);
        close.setText("Fechar");
        close.setOnClickListener(view -> finish());
        layout.addView(close);

        setContentView(layout);
        refreshStatus();
    }

    private void requestBluetoothPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
            checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.BLUETOOTH_CONNECT}, REQUEST_BLUETOOTH);
        } else {
            refreshStatus();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_BLUETOOTH) refreshStatus();
    }

    private void refreshStatus() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
            checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED) {
            status.setText("Permissão Bluetooth concedida. Pareie a impressora nas configurações do Android e selecione “Super Quina Bluetooth” em Serviços de impressão.");
        } else {
            status.setText("Permissão Bluetooth ainda não concedida. Toque em “Autorizar Bluetooth” para continuar.");
        }
    }
}
