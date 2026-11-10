package ru.a402d.rawbtprinter.activity;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import rawbt.sdk.btpair.BtPairActivity;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
public class DeviceListActivity extends BtPairActivity {
    @Override // rawbt.sdk.btpair.BtPairActivity
    protected void done(BluetoothDevice bluetoothDevice) {
        Intent intent = new Intent();
        intent.putExtra("btDevice", bluetoothDevice);
        setResult(-1, intent);
        finish();
    }

    @Override // rawbt.sdk.btpair.BtPairActivity
    protected String getCurrentMac() {
        return "00:00:00:00:00:00";
    }

    @Override // rawbt.sdk.btpair.BtPairActivity
    protected void showError(String str) {
        RawPrinterApp.r(str);
    }
}
