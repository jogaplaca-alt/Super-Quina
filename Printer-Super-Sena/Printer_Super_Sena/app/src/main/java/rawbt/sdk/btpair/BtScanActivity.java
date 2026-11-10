package rawbt.sdk.btpair;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes.dex */
public class BtScanActivity extends Activity {
    public static final String PARAMETER_CUR_MAC = "cur_mac";
    public static final int RESULT_BLUETOOTH_NONE = 20;
    public static final int RESULT_BLUETOOTH_NOT_ENABLED = 21;
    public static final int RESULT_LOCATION_OFF = 24;
    public static final String RESULT_OK_EXTRA = "device";
    public static final int RESULT_PERMISSION_BLUETOOTH_SCAN_NOT_GRANTED = 23;
    public static final int RESULT_PERMISSION_LOCATION_NOT_GRANTED = 22;
    private BluetoothAdapter mBtAdapter;
    private BtDevAdapter mNewDevicesArrayAdapter;
    private ProgressBar progressBar;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: rawbt.sdk.btpair.BtScanActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"android.bluetooth.device.action.FOUND".equals(action)) {
                if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                    BtScanActivity.this.progressBar.setVisibility(8);
                    return;
                }
                return;
            }
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice != null) {
                String address = bluetoothDevice.getAddress();
                boolean z3 = false;
                for (int i3 = 0; i3 < BtScanActivity.this.mNewDevicesArrayAdapter.getCount(); i3++) {
                    if (address.equals(BtScanActivity.this.mNewDevicesArrayAdapter.getAddress(i3))) {
                        z3 = true;
                    }
                }
                if (z3) {
                    return;
                }
                BtScanActivity.this.mNewDevicesArrayAdapter.add(bluetoothDevice);
                BtScanActivity.this.mNewDevicesArrayAdapter.notifyDataSetChanged();
            }
        }
    };
    private final AdapterView.OnItemClickListener mDeviceClickListener = new AdapterView.OnItemClickListener() { // from class: rawbt.sdk.btpair.t
        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            this.f11180a.lambda$new$1(adapterView, view, i3, j3);
        }
    };

    public static Intent getRunIntent(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) BtScanActivity.class);
        intent.putExtra(PARAMETER_CUR_MAC, str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(AdapterView adapterView, View view, int i3, long j3) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) adapterView.getItemAtPosition(i3);
        Intent intent = new Intent();
        intent.putExtra(RESULT_OK_EXTRA, bluetoothDevice);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        setContentView(R.layout.btscan_activity);
        setFinishOnTouchOutside(false);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mBtAdapter = defaultAdapter;
        if (defaultAdapter == null) {
            setResult(20);
            finish();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        registerReceiver(this.mReceiver, intentFilter);
        if (!this.mBtAdapter.isEnabled()) {
            setResult(21);
            finish();
        }
        if (!BtDeviceSelectHelper.checkSearchAvailability(this)) {
            setResult(24);
            finish();
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            if (i3 >= 26) {
                if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                    setResult(22);
                    finish();
                }
            } else if (checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
                setResult(22);
                finish();
            }
            if (i3 >= 31 && checkSelfPermission("android.permission.BLUETOOTH_SCAN") != 0) {
                setResult(23);
                finish();
            }
        }
        Intent intent = getIntent();
        String string = "00:00:00:00:00";
        if (intent != null && (extras = intent.getExtras()) != null) {
            string = extras.getString(PARAMETER_CUR_MAC, "00:00:00:00:00");
        }
        this.mNewDevicesArrayAdapter = new BtDevAdapter(this, string);
        ListView listView = (ListView) findViewById(R.id.new_devices);
        listView.setAdapter((ListAdapter) this.mNewDevicesArrayAdapter);
        listView.setOnItemClickListener(this.mDeviceClickListener);
        findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() { // from class: rawbt.sdk.btpair.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11181a.lambda$onCreate$0(view);
            }
        });
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BluetoothAdapter bluetoothAdapter = this.mBtAdapter;
        if (bluetoothAdapter != null) {
            if (bluetoothAdapter.isDiscovering()) {
                this.mBtAdapter.cancelDiscovery();
            }
            unregisterReceiver(this.mReceiver);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.mBtAdapter.isDiscovering()) {
            this.mBtAdapter.cancelDiscovery();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.mBtAdapter.isDiscovering()) {
            this.mBtAdapter.startDiscovery();
        }
        this.progressBar.setVisibility(0);
    }
}
