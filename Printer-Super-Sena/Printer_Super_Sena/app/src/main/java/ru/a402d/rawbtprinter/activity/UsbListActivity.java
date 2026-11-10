package ru.a402d.rawbtprinter.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AbstractActivityC0248d;
import androidx.core.view.AbstractC0323v;
import java.util.Objects;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class UsbListActivity extends AbstractActivityC0248d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private s2.i f11521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    UsbManager f11522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11523c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Context f11525e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f11524d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AdapterView.OnItemClickListener f11526f = new AdapterView.OnItemClickListener() { // from class: r2.V2
        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            this.f10985a.v(adapterView, view, i3, j3);
        }
    };

    class a extends BroadcastReceiver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            UsbListActivity.this.finish();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (UsbListActivity.this.f11523c.equals(intent.getAction())) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.O
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11413a.b();
                    }
                }, 1000L);
            }
            UsbListActivity.this.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        s2.i iVar = this.f11521a;
        if (iVar != null) {
            UsbManager usbManager = this.f11522b;
            Objects.requireNonNull(usbManager);
            iVar.b(usbManager.getDeviceList());
            this.f11521a.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(AdapterView adapterView, View view, int i3, long j3) {
        UsbDevice item = this.f11521a.getItem(i3);
        Intent intent = new Intent();
        intent.putExtra("usbDevice", item);
        setResult(-1, intent);
        finish();
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11523c = getPackageName() + ".USB_PERMISSION";
        this.f11525e = this;
        try {
            setContentView(R.layout.device_usb_list);
            setTitle(R.string.select_device);
            if (getSupportActionBar() != null) {
                getSupportActionBar().s(true);
                getSupportActionBar().t(true);
            }
            if (!getPackageManager().hasSystemFeature("android.hardware.usb.host")) {
                ((TextView) findViewById(R.id.txt_usb_help)).setText(R.string.error_no_otg);
                return;
            }
            UsbManager usbManager = (UsbManager) getSystemService("usb");
            this.f11522b = usbManager;
            if (usbManager == null) {
                ((TextView) findViewById(R.id.txt_usb_help)).setText(R.string.error_no_otg);
                return;
            }
            this.f11521a = new s2.i(this, this.f11522b);
            ListView listView = (ListView) findViewById(R.id.usb_devices);
            listView.setAdapter((ListAdapter) this.f11521a);
            listView.setOnItemClickListener(this.f11526f);
            this.f11524d = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
            intentFilter.addAction(this.f11523c);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 26) {
                registerReceiver(this.f11524d, intentFilter, i3 >= 33 ? 2 : 0);
            } else {
                registerReceiver(this.f11524d, intentFilter);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            ((TextView) findViewById(R.id.txt_usb_help)).setText(e3.getLocalizedMessage());
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_usb_select, menu);
        AbstractC0323v.a(menu, true);
        return true;
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = this.f11524d;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        if (menuItem.getItemId() == R.id.action_system_settings) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + getPackageName()));
            intent.addFlags(268435456);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onResume() {
        super.onResume();
        refresh();
    }
}
