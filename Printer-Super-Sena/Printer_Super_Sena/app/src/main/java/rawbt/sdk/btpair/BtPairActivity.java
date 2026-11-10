package rawbt.sdk.btpair;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.companion.AssociationRequest;
import android.companion.BluetoothDeviceFilter;
import android.companion.CompanionDeviceManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AbstractActivityC0248d;
import androidx.core.view.AbstractC0323v;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public abstract class BtPairActivity extends AbstractActivityC0248d {
    Context ctx;
    private TextView hint;
    private BluetoothAdapter mBtAdapter;
    private BtDevAdapter mPairedDevicesArrayAdapter;
    private Timer mTimer;
    private Button permButton;
    private ProgressBar progressBar;
    private Button scanButton;
    private final int WaitBeforeReScan = 15;
    private final p004b.c mRequestPermission = registerForActivityResult(new p008c.d(), new p004b.b() { // from class: rawbt.sdk.btpair.k
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            this.f11172a.lambda$new$2((Boolean) obj);
        }
    });
    private final AdapterView.OnItemClickListener mDeviceClickListener = new AdapterView.OnItemClickListener() { // from class: rawbt.sdk.btpair.l
        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            this.f11173a.lambda$new$3(adapterView, view, i3, j3);
        }
    };
    private boolean isBtOnDismiss = false;
    private final p004b.c btOnLauncher = registerForActivityResult(new p008c.e(), new p004b.b() { // from class: rawbt.sdk.btpair.m
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            this.f11174a.lambda$new$4((p004b.a) obj);
        }
    });
    private final p004b.c runBtScanActivity = registerForActivityResult(new p008c.e(), new p004b.b() { // from class: rawbt.sdk.btpair.n
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            this.f11175a.lambda$new$5((p004b.a) obj);
        }
    });
    private final p004b.c btCompanionLauncher = registerForActivityResult(new p008c.f(), new p004b.b() { // from class: rawbt.sdk.btpair.BtPairActivity.2
        @Override // p004b.b
        public void onActivityResult(p004b.a aVar) {
            BtPairActivity.this.scanButton.setVisibility(0);
            try {
                Intent intentC = aVar.c();
                Objects.requireNonNull(intentC);
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intentC.getParcelableExtra("android.companion.extra.DEVICE");
                if (bluetoothDevice != null) {
                    BtPairActivity.this.done(bluetoothDevice);
                }
            } catch (Exception unused) {
            }
        }
    });
    private boolean complainWait = false;
    private int waitSec = 0;

    /* JADX INFO: Access modifiers changed from: private */
    class CheckComplainDialog extends TimerTask {
        private CheckComplainDialog() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            BtPairActivity.this.scanButton.setVisibility(0);
            BtPairActivity.this.progressBar.setVisibility(8);
            if (BtPairActivity.this.complainWait) {
                BtPairActivity.this.complainWait = false;
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            BtPairActivity.this.runOnUiThread(new Runnable() { // from class: rawbt.sdk.btpair.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11177a.lambda$run$0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class CheckLocationOnTask extends TimerTask {
        private CheckLocationOnTask() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            if (BtPairActivity.this.mTimer != null) {
                BtPairActivity.this.mTimer.cancel();
            }
            BtPairActivity.this.mTimer = null;
            BtPairActivity.this.refresh();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (BtDeviceSelectHelper.checkSearchAvailability(BtPairActivity.this.ctx)) {
                BtPairActivity.this.runOnUiThread(new Runnable() { // from class: rawbt.sdk.btpair.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11178a.lambda$run$0();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class WaitBeforeScanTask extends TimerTask {
        private WaitBeforeScanTask() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            if (BtPairActivity.this.waitSec < 1) {
                if (BtPairActivity.this.mTimer != null) {
                    BtPairActivity.this.mTimer.cancel();
                }
                BtPairActivity.this.mTimer = null;
                BtPairActivity.this.scanButton.setText(R.string.button_scan);
                BtPairActivity.this.scanButton.setEnabled(true);
            } else {
                BtPairActivity.this.scanButton.setText(String.valueOf(BtPairActivity.this.waitSec));
                BtPairActivity.this.scanButton.setEnabled(false);
            }
            BtPairActivity.access$310(BtPairActivity.this);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            BtPairActivity.this.runOnUiThread(new Runnable() { // from class: rawbt.sdk.btpair.r
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11179a.lambda$run$0();
                }
            });
        }
    }

    static /* synthetic */ int access$310(BtPairActivity btPairActivity) {
        int i3 = btPairActivity.waitSec;
        btPairActivity.waitSec = i3 - 1;
        return i3;
    }

    private void doComplain() {
        CompanionDeviceManager companionDeviceManagerA = h.a(getSystemService(f.a()));
        this.scanButton.setVisibility(8);
        this.progressBar.setVisibility(0);
        this.complainWait = true;
        companionDeviceManagerA.associate(getAssociationRequest(), new CompanionDeviceManager.Callback() { // from class: rawbt.sdk.btpair.BtPairActivity.1
            @Override // android.companion.CompanionDeviceManager.Callback
            public void onDeviceFound(IntentSender intentSender) {
                BtPairActivity.this.btCompanionLauncher.a(new b.f.a(intentSender).a());
            }

            @Override // android.companion.CompanionDeviceManager.Callback
            public void onFailure(CharSequence charSequence) {
                if (BtPairActivity.this.mTimer != null) {
                    BtPairActivity.this.mTimer.cancel();
                    BtPairActivity.this.mTimer = null;
                }
                BtPairActivity.this.waitSec = 15;
                BtPairActivity.this.mTimer = new Timer();
                BtPairActivity.this.mTimer.schedule(new WaitBeforeScanTask(), 100L, 1000L);
            }
        }, (Handler) null);
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        Timer timer2 = new Timer();
        this.mTimer = timer2;
        timer2.schedule(new CheckComplainDialog(), 10000L);
    }

    private static AssociationRequest getAssociationRequest() {
        return new AssociationRequest.Builder().addDeviceFilter(new BluetoothDeviceFilter.Builder().build()).setSingleDevice(false).build();
    }

    private void getPaired(BluetoothAdapter bluetoothAdapter) {
        this.mPairedDevicesArrayAdapter.setList(new ArrayList(bluetoothAdapter.getBondedDevices()));
        this.mPairedDevicesArrayAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(Boolean bool) {
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(AdapterView adapterView, View view, int i3, long j3) {
        done((BluetoothDevice) adapterView.getItemAtPosition(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(p004b.a aVar) {
        if (aVar.d() == -1) {
            getPaired(this.mBtAdapter);
            this.scanButton.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(p004b.a aVar) {
        Bundle extras;
        if (aVar.d() != -1) {
            this.waitSec = 15;
            Timer timer = new Timer();
            this.mTimer = timer;
            timer.schedule(new WaitBeforeScanTask(), 100L, 1000L);
            return;
        }
        Intent intentC = aVar.c();
        if (intentC == null || (extras = intentC.getExtras()) == null) {
            return;
        }
        done((BluetoothDevice) extras.getParcelable(BtScanActivity.RESULT_OK_EXTRA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        if (!this.mBtAdapter.isEnabled()) {
            refresh();
            return;
        }
        if (!BtDeviceSelectHelper.checkSearchAvailability(this.ctx)) {
            refresh();
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            doComplain();
            return;
        }
        if (i3 < 23 || checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.runBtScanActivity.a(BtScanActivity.getRunIntent(this.ctx, getCurrentMac()));
            return;
        }
        this.hint.setText(R.string.near_location);
        this.hint.setVisibility(0);
        this.permButton.setVisibility(0);
        this.scanButton.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31) {
            this.mRequestPermission.a("android.permission.BLUETOOTH_CONNECT");
        } else if (i3 >= 23) {
            this.mRequestPermission.a("android.permission.ACCESS_COARSE_LOCATION");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        this.progressBar.setVisibility(8);
        this.hint.setVisibility(8);
        this.scanButton.setVisibility(0);
        this.permButton.setVisibility(8);
        if (Build.VERSION.SDK_INT >= 31 && checkSelfPermission("android.permission.BLUETOOTH_CONNECT") != 0) {
            this.hint.setText(R.string.faq_BT_12);
            this.hint.setVisibility(0);
            this.permButton.setVisibility(0);
            this.scanButton.setVisibility(8);
            return;
        }
        try {
            if (!this.mBtAdapter.isEnabled()) {
                if (!this.isBtOnDismiss) {
                    this.btOnLauncher.a(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));
                    this.isBtOnDismiss = true;
                    return;
                } else {
                    this.hint.setText(R.string.bluetooth_must_be_on);
                    this.hint.setVisibility(0);
                    this.scanButton.setVisibility(8);
                    return;
                }
            }
            if (!BtDeviceSelectHelper.checkSearchAvailability(this.ctx)) {
                this.hint.setText(R.string.hint_location_service_is_off);
                this.hint.setVisibility(0);
                this.scanButton.setVisibility(8);
                Timer timer = this.mTimer;
                if (timer != null) {
                    timer.cancel();
                    this.mTimer = null;
                }
                Timer timer2 = new Timer();
                this.mTimer = timer2;
                timer2.schedule(new CheckLocationOnTask(), 1000L, 500L);
            }
            getPaired(this.mBtAdapter);
        } catch (NullPointerException unused) {
            showError(getResources().getString(R.string.error_bluetooth_not_avaible));
            finish();
        }
    }

    protected abstract void done(BluetoothDevice bluetoothDevice);

    protected abstract String getCurrentMac();

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ctx = this;
        setContentView(R.layout.device_list);
        setTitle(R.string.select_device);
        if (getSupportActionBar() != null) {
            getSupportActionBar().s(true);
            getSupportActionBar().t(true);
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mBtAdapter = defaultAdapter;
        if (defaultAdapter == null) {
            showError(getResources().getString(R.string.error_bluetooth_not_avaible));
            finish();
        }
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.hint = (TextView) findViewById(R.id.txt_hint);
        Button button = (Button) findViewById(R.id.button_scan);
        this.scanButton = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: rawbt.sdk.btpair.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11176a.lambda$onCreate$0(view);
            }
        });
        Button button2 = (Button) findViewById(R.id.button_grant);
        this.permButton = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: rawbt.sdk.btpair.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11171a.lambda$onCreate$1(view);
            }
        });
        this.mPairedDevicesArrayAdapter = new BtDevAdapter(this, getCurrentMac());
        ListView listView = (ListView) findViewById(R.id.paired_devices);
        listView.setAdapter((ListAdapter) this.mPairedDevicesArrayAdapter);
        listView.setOnItemClickListener(this.mDeviceClickListener);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bt_select, menu);
        AbstractC0323v.a(menu, true);
        return true;
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
        }
        if (itemId == R.id.action_bt_settings) {
            BtDeviceSelectHelper.openBtSettings(this.ctx);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.progressBar.setVisibility(8);
        this.complainWait = false;
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onResume() {
        super.onResume();
        refresh();
    }

    protected abstract void showError(String str);
}
