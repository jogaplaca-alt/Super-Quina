package ru.a402d.rawbtprinter.activity;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.hardware.usb.UsbDevice;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AbstractC0245a;
import androidx.lifecycle.InterfaceC0363v;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.TreeMap;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.RawbtConstants;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.drivers.PosDriverInterface;
import rawbt.sdk.drivers.PrinterDriverFactory;
import rawbt.sdk.transport.Constant;
import ru.a402d.rawbtprinter.AppDatabase;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
public class Magic extends AbstractActivityC0634m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final p004b.c f11368d = registerForActivityResult(new p008c.e(), new p004b.b() { // from class: r2.J0
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            this.f10919a.v0((p004b.a) obj);
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final p004b.c f11369e = registerForActivityResult(new p008c.e(), new p004b.b() { // from class: r2.U0
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            this.f10979a.w0((p004b.a) obj);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Spinner f11370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayAdapter f11371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Spinner f11372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Magic f11373i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private t2.b f11374j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private y2.b f11375k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    ArrayAdapter f11376l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ArrayAdapter f11377m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    ArrayAdapter f11378n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    ArrayAdapter f11379o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ArrayAdapter f11380p;

    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Magic.this.getResources().getColor(R.color.colorAccent));
            } catch (Exception unused) {
            }
            Magic magic = Magic.this;
            magic.f11571c.S0((String) magic.f11376l.getItem(i3));
            Magic.this.g0();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            Magic.this.f11571c.z0(Integer.parseInt(adapterView.getSelectedItem().toString()));
            Magic.this.i0();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Magic.this.getResources().getColor(R.color.colorAccent));
            } catch (Exception unused) {
            }
            Magic magic = Magic.this;
            magic.f11571c.U0((String) magic.f11377m.getItem(i3));
            Magic.this.i0();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Magic.this.getResources().getColor(R.color.colorAccent));
            } catch (Exception unused) {
            }
            Magic magic = Magic.this;
            magic.f11571c.S0((String) magic.f11379o.getItem(i3));
            Magic.this.g0();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(final Intent intent, View view) {
        this.f11374j.f11800f.requestFocus();
        this.f11374j.f11812r.clearFocus();
        this.f11374j.f11811q.clearFocus();
        this.f11569a.execute(new Runnable() { // from class: r2.O0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10946a.z0(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(BluetoothDevice bluetoothDevice) {
        i0();
        this.f11374j.f11818x.setVisibility(8);
        if (bluetoothDevice == null) {
            return;
        }
        if (bluetoothDevice.getType() == 2) {
            this.f11374j.f11817w.setEnabled(false);
            this.f11374j.f11816v.setEnabled(true);
            this.f11571c.T0(6);
        } else {
            this.f11374j.f11817w.setEnabled(true);
            this.f11571c.T0(1);
            if (bluetoothDevice.getType() == 1) {
                this.f11374j.f11816v.setEnabled(false);
            }
        }
        this.f11374j.f11818x.setVisibility(0);
        W0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(Boolean bool) {
        this.f11374j.f11789I.setVisibility(bool.booleanValue() ? 0 : 8);
        this.f11374j.f11805k.setVisibility(bool.booleanValue() ? 0 : 8);
        this.f11374j.f11804j.setVisibility(bool.booleanValue() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(View view) {
        this.f11374j.f11809o.clearFocus();
        this.f11374j.f11810p.clearFocus();
        this.f11374j.f11804j.requestFocus();
        h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0() {
        this.f11571c.D0(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(String str) {
        this.f11571c.D0(Boolean.FALSE);
        Toast.makeText(this.f11373i, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0() {
        this.f11374j.f11813s.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(RadioGroup radioGroup, int i3) {
        if (i3 == R.id.radioTransportBT) {
            this.f11571c.T0(1);
            return;
        }
        if (i3 == R.id.radioTransportUSB) {
            this.f11571c.T0(3);
            return;
        }
        if (i3 == R.id.radioTransportLAN) {
            this.f11571c.T0(2);
            this.f11571c.O0("lan_printer");
            this.f11571c.H0("network printer");
        } else if (i3 == R.id.radioTransportAIDL) {
            this.f11571c.T0(4);
            this.f11571c.O0("aidl_printer");
            this.f11571c.H0("integrated printer");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0() {
        PosDriverInterface posDriverInterfaceN = this.f11571c.N();
        if (posDriverInterfaceN == null) {
            return;
        }
        if (!posDriverInterfaceN.isConnected()) {
            this.f11570b.post(new Runnable() { // from class: r2.T0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10973a.E0();
                }
            });
            return;
        }
        try {
            posDriverInterfaceN.resetError();
            f0();
            posDriverInterfaceN.initialize();
            f0();
            posDriverInterfaceN.text("It is work", new AttributesString());
            f0();
            posDriverInterfaceN.scrollPaper(3);
            f0();
            posDriverInterfaceN.finish();
            f0();
        } catch (Exception e3) {
            posDriverInterfaceN.disconnectPrinter();
            final String message = e3.getMessage();
            Log.e("RAWBT", message);
            this.f11570b.post(new Runnable() { // from class: r2.V0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10982a.F0(message);
                }
            });
        }
        this.f11570b.post(new Runnable() { // from class: r2.W0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10987a.G0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0(View view) {
        this.f11374j.f11813s.setEnabled(false);
        this.f11569a.execute(new Runnable() { // from class: r2.L0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10929a.I0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0(Boolean bool) {
        this.f11374j.f11806l.setVisibility(bool.booleanValue() ? 0 : 8);
        this.f11374j.f11800f.setVisibility(bool.booleanValue() ? 0 : 8);
        this.f11374j.f11813s.setVisibility(bool.booleanValue() ? 0 : 8);
        this.f11374j.f11804j.setEnabled(!bool.booleanValue());
        this.f11374j.f11809o.setEnabled(!bool.booleanValue());
        this.f11374j.f11810p.setEnabled(!bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(View view, boolean z3) {
        if (z3) {
            return;
        }
        this.f11571c.L0(((EditText) view).getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(View view, boolean z3) {
        if (z3) {
            return;
        }
        try {
            this.f11571c.P0(Integer.parseInt(((EditText) view).getText().toString()));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(View view, boolean z3) {
        if (z3) {
            return;
        }
        try {
            this.f11571c.O0(((EditText) view).getText().toString());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(View view, boolean z3) {
        if (z3) {
            return;
        }
        try {
            this.f11571c.H0(((EditText) view).getText().toString());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(CompoundButton compoundButton, boolean z3) {
        if (z3) {
            this.f11571c.T0(6);
        }
        W0();
        i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(CompoundButton compoundButton, boolean z3) {
        if (z3) {
            this.f11571c.T0(1);
        }
        W0();
        i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(View view) {
        this.f11368d.a(new Intent(this.f11373i, (Class<?>) DeviceListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(View view) {
        this.f11369e.a(new Intent(this.f11373i, (Class<?>) UsbListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(View view) {
        this.f11571c.T0(3);
        i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(View view) {
        this.f11571c.T0(8);
        i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0() {
        Toast.makeText(this.f11373i, "Name is required", 1).show();
    }

    private void W0() {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) this.f11571c.K().e();
        if (bluetoothDevice == null) {
            return;
        }
        l0(B2.c.b(bluetoothDevice.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:47:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:48:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:51:0x026a  */
    /* JADX WARN: Code duplicated, block: B:53:0x029b  */
    /* JADX WARN: Code duplicated, block: B:54:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:57:0x02c6  */
    public void X0(PrinterEntity printerEntity) {
        String description;
        this.f11374j.f11809o.setText(printerEntity.getHost());
        this.f11374j.f11810p.setText("" + printerEntity.getPort());
        this.f11374j.f11812r.setText(printerEntity.getName());
        this.f11374j.f11811q.setText(printerEntity.getDescription());
        this.f11374j.f11796b.setVisibility(8);
        this.f11374j.f11798d.setVisibility(8);
        this.f11374j.f11799e.setVisibility(8);
        this.f11374j.f11797c.setVisibility(8);
        this.f11374j.f11787G.setVisibility(8);
        this.f11374j.f11788H.setVisibility(0);
        this.f11374j.f11800f.setVisibility(this.f11571c.R().booleanValue() ? 0 : 8);
        this.f11374j.f11813s.setVisibility(this.f11571c.R().booleanValue() ? 0 : 8);
        if (this.f11571c.K().e() == null) {
            this.f11374j.f11818x.setVisibility(8);
        } else {
            this.f11374j.f11818x.setVisibility(0);
        }
        if (this.f11571c.Q().e() == null) {
            this.f11374j.f11819y.setVisibility(8);
        } else {
            this.f11374j.f11819y.setVisibility(0);
        }
        if (printerEntity.getProtocol() == 0) {
            try {
                if (!getPackageManager().hasSystemFeature("android.hardware.usb.host")) {
                    this.f11374j.f11784D.setEnabled(false);
                }
            } catch (Exception unused) {
                this.f11374j.f11784D.setEnabled(false);
            }
            try {
                if (!getPackageManager().hasSystemFeature("android.hardware.bluetooth")) {
                    this.f11374j.f11781A.setEnabled(false);
                }
            } catch (Exception unused2) {
                this.f11374j.f11781A.setEnabled(false);
            }
            this.f11374j.f11807m.setVisibility(0);
            this.f11374j.f11791K.setVisibility(0);
            this.f11374j.f11790J.setVisibility(8);
            this.f11374j.f11814t.setVisibility(8);
        } else {
            this.f11374j.f11807m.setVisibility(8);
            this.f11374j.f11791K.setVisibility(8);
            this.f11374j.f11790J.setVisibility(0);
            this.f11374j.f11814t.setVisibility(0);
        }
        this.f11374j.f11792L.setTextColor(getResources().getColor(R.color.black));
        int protocol = printerEntity.getProtocol();
        if (protocol == 1) {
            this.f11374j.f11790J.setText(R.string.panel_bt_title);
            this.f11374j.f11790J.setCompoundDrawablesWithIntrinsicBounds(p016e.a.b(this.f11373i, R.drawable.ic_bluetooth_black_24dp), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f11374j.f11792L.setText(printerEntity.getMac());
            if ("00:00:00:00:00:00".equals(printerEntity.getMac())) {
                this.f11374j.f11803i.setTextColor(getResources().getColor(R.color.red));
            } else {
                this.f11374j.f11803i.setTextColor(getResources().getColor(R.color.black));
            }
            description = printerEntity.getDescription();
            if (description.equals("unknown")) {
                description = getResources().getString(R.string.not_selected);
            }
            this.f11374j.f11803i.setText(description);
            this.f11374j.f11796b.setVisibility(0);
        } else if (protocol == 2) {
            this.f11374j.f11809o.setText(printerEntity.getHost());
            this.f11374j.f11810p.setText(String.format(Locale.ENGLISH, "%d", Integer.valueOf(printerEntity.getPort())));
            this.f11374j.f11798d.setVisibility(0);
            this.f11374j.f11790J.setCompoundDrawablesWithIntrinsicBounds(p016e.a.b(this.f11373i, R.drawable.ic_wifi_black_24dp), (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (protocol == 3) {
            if (printerEntity.getVid().isEmpty()) {
                this.f11374j.f11794N.setTextColor(getResources().getColor(R.color.red));
                this.f11374j.f11794N.setText(getResources().getString(R.string.not_selected));
                this.f11374j.f11793M.setText(getResources().getString(R.string.panel_usb_title));
            } else {
                this.f11374j.f11793M.setText(String.format("VID:%s PID:%s", printerEntity.getVid(), printerEntity.getPid()));
                this.f11374j.f11794N.setText(printerEntity.getDescription());
                this.f11374j.f11794N.setTextColor(getResources().getColor(R.color.black));
            }
            this.f11374j.f11799e.setVisibility(0);
            this.f11374j.f11790J.setCompoundDrawablesWithIntrinsicBounds(p016e.a.b(this.f11373i, R.drawable.ic_usb_black_24dp), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f11374j.f11790J.setText(R.string.select_device);
        } else if (protocol == 4) {
            this.f11374j.f11790J.setVisibility(8);
            this.f11374j.f11814t.setVisibility(8);
            this.f11374j.f11787G.setVisibility(0);
            this.f11374j.f11788H.setVisibility(8);
        } else if (protocol == 6) {
            this.f11374j.f11790J.setText(R.string.panel_bt_title);
            this.f11374j.f11790J.setCompoundDrawablesWithIntrinsicBounds(p016e.a.b(this.f11373i, R.drawable.ic_bluetooth_black_24dp), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f11374j.f11792L.setText(printerEntity.getMac());
            if ("00:00:00:00:00:00".equals(printerEntity.getMac())) {
                this.f11374j.f11803i.setTextColor(getResources().getColor(R.color.red));
            } else {
                this.f11374j.f11803i.setTextColor(getResources().getColor(R.color.black));
            }
            description = printerEntity.getDescription();
            if (description.equals("unknown")) {
                description = getResources().getString(R.string.not_selected);
            }
            this.f11374j.f11803i.setText(description);
            this.f11374j.f11796b.setVisibility(0);
        } else if (protocol == 8) {
            this.f11374j.f11797c.setVisibility(0);
            if (printerEntity.getVid().isEmpty()) {
                this.f11374j.f11793M.setText(String.format("VID:%s PID:%s", printerEntity.getVid(), printerEntity.getPid()));
                this.f11374j.f11794N.setText(printerEntity.getDescription());
                this.f11374j.f11794N.setTextColor(getResources().getColor(R.color.black));
            } else {
                this.f11374j.f11794N.setTextColor(getResources().getColor(R.color.red));
                this.f11374j.f11794N.setText(getResources().getString(R.string.not_selected));
                this.f11374j.f11793M.setText(getResources().getString(R.string.panel_usb_title));
            }
            this.f11374j.f11799e.setVisibility(0);
            this.f11374j.f11790J.setCompoundDrawablesWithIntrinsicBounds(p016e.a.b(this.f11373i, R.drawable.ic_usb_black_24dp), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f11374j.f11790J.setText(R.string.select_device);
        }
        try {
            this.f11370f.setSelection(this.f11371g.getPosition("" + printerEntity.getBaud()));
            this.f11372h.setSelection(this.f11377m.getPosition(printerEntity.getSerialComDriver()));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        switch (printerEntity.getProtocol()) {
            case 1:
                this.f11374j.f11816v.setChecked(false);
                this.f11374j.f11817w.setChecked(true);
                this.f11374j.f11802h.setVisibility(8);
                this.f11374j.f11788H.setSelection(this.f11376l.getPosition(printerEntity.getProfileClass()));
                break;
            case 2:
            default:
                this.f11374j.f11788H.setSelection(this.f11376l.getPosition(printerEntity.getProfileClass()));
                break;
            case 3:
                this.f11374j.f11786F.setChecked(true);
                this.f11374j.f11785E.setChecked(false);
                this.f11374j.f11788H.setSelection(this.f11376l.getPosition(printerEntity.getProfileClass()));
                break;
            case 4:
                this.f11374j.f11787G.setSelection(this.f11379o.getPosition(printerEntity.getProfileClass()));
                break;
            case 5:
            case 7:
                break;
            case 6:
                this.f11374j.f11817w.setChecked(false);
                this.f11374j.f11816v.setChecked(true);
                this.f11374j.f11802h.setVisibility(0);
                this.f11374j.f11788H.setSelection(this.f11376l.getPosition(printerEntity.getProfileClass()));
                break;
            case 8:
                this.f11374j.f11786F.setChecked(false);
                this.f11374j.f11785E.setChecked(true);
                this.f11374j.f11788H.setSelection(this.f11376l.getPosition(printerEntity.getProfileClass()));
                break;
        }
    }

    private void Y0(UsbDevice usbDevice) {
        this.f11571c.X0(usbDevice);
        int vendorId = usbDevice.getVendorId();
        int productId = usbDevice.getProductId();
        this.f11571c.Y0("" + vendorId, "" + productId);
        this.f11571c.T0(3);
        if (vendorId == 2501 && productId == 512) {
            this.f11571c.S0(Constant.DRIVER_PERIPAGE);
            this.f11571c.H0("Peripage Printer");
            this.f11571c.O0("usb_peripage");
            return;
        }
        if (vendorId == 17224 && productId == 21892) {
            this.f11571c.S0(Constant.DRIVER_PAPERANG);
            this.f11571c.H0("Paperang Printer");
            this.f11571c.O0("usb_paperang");
            return;
        }
        this.f11571c.S0(Constant.DRIVER_ESC_GENERAL);
        String productName = Build.VERSION.SDK_INT >= 21 ? usbDevice.getProductName() : null;
        if (productName == null) {
            productName = "USB Printer";
        }
        this.f11571c.H0(productName);
        this.f11571c.O0("usb_" + vendorId + "_" + productId);
    }

    private void e0(BluetoothDevice bluetoothDevice) {
        this.f11571c.A0(bluetoothDevice);
        String address = bluetoothDevice.getAddress();
        this.f11571c.N0(address);
        String strB = B2.c.b(bluetoothDevice.getName());
        l0(strB);
        this.f11571c.H0(strB);
        String strReplace = address.replace(":", "");
        this.f11571c.O0(strB + "_" + strReplace.substring(strReplace.length() - 4));
    }

    private void f0() throws Exception {
        if (this.f11571c.N().isError()) {
            throw new Exception(this.f11571c.N().getErrorMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        w2.D d3 = this.f11571c;
        if (d3 == null) {
            return;
        }
        if (d3.R().booleanValue()) {
            this.f11569a.execute(new Runnable() { // from class: r2.P0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10952a.p0();
                }
            });
        } else {
            this.f11571c.J0(null);
        }
    }

    private void h0() {
        final PosDriverInterface posDriverInterfaceN = this.f11571c.N();
        if (posDriverInterfaceN == null) {
            n0();
            return;
        }
        this.f11374j.f11815u.setVisibility(0);
        this.f11374j.f11804j.setVisibility(8);
        this.f11569a.execute(new Runnable() { // from class: r2.M0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10933a.s0(posDriverInterfaceN);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        if (this.f11571c.R().booleanValue()) {
            this.f11374j.f11815u.setVisibility(0);
            this.f11571c.D0(Boolean.FALSE);
            this.f11569a.execute(new Runnable() { // from class: r2.N0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10941a.u0();
                }
            });
        }
    }

    private void j0() {
        TreeMap treeMap = new TreeMap(B2.b.g(this, R.raw.drivers_aidl));
        this.f11380p = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new ArrayList(treeMap.values()));
        this.f11379o = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new ArrayList(treeMap.keySet()));
        this.f11380p.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11374j.f11787G.setAdapter((SpinnerAdapter) this.f11380p);
        this.f11374j.f11787G.setOnItemSelectedListener(new d());
    }

    private void k0() {
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.f11373i, R.array.baud_rates, android.R.layout.simple_spinner_item);
        this.f11371g = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11370f.setAdapter((SpinnerAdapter) this.f11371g);
        this.f11370f.setOnItemSelectedListener(new b());
    }

    private void m0() {
        TreeMap treeMapP = this.f11375k.P();
        this.f11378n = new ArrayAdapter(this.f11373i, android.R.layout.simple_spinner_item, new ArrayList(treeMapP.values()));
        this.f11377m = new ArrayAdapter(this.f11373i, android.R.layout.simple_spinner_item, new ArrayList(treeMapP.keySet()));
        this.f11378n.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11372h.setAdapter((SpinnerAdapter) this.f11378n);
        this.f11372h.setOnItemSelectedListener(new c());
    }

    private void n0() {
        PrinterEntity printerEntity = (PrinterEntity) this.f11571c.P().e();
        if (printerEntity == null) {
            return;
        }
        this.f11571c.J0(PrinterDriverFactory.getByProfile(printerEntity, this));
        h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0() {
        this.f11571c.D0(Boolean.FALSE);
        g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0() {
        PosDriverInterface posDriverInterfaceN = this.f11571c.N();
        if (posDriverInterfaceN == null) {
            return;
        }
        posDriverInterfaceN.disconnectPrinter();
        this.f11570b.post(new Runnable() { // from class: r2.X0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10990a.o0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0() {
        this.f11374j.f11815u.setVisibility(8);
        this.f11571c.D0(Boolean.FALSE);
        Toast.makeText(this.f11373i, "params is null", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(String str, String str2) {
        this.f11374j.f11815u.setVisibility(8);
        this.f11374j.f11804j.setVisibility(0);
        this.f11571c.D0(Boolean.valueOf(RawbtConstants.OK.equals(str)));
        if (RawbtConstants.OK.equals(str)) {
            return;
        }
        Toast.makeText(this.f11373i, str2 + " " + str, 1).show();
    }

    private void s() {
        Intent intent = getIntent();
        if (intent.hasExtra("usbDevice")) {
            Y0((UsbDevice) intent.getParcelableExtra("usbDevice"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(PosDriverInterface posDriverInterface) {
        PrinterEntity printerEntity = (PrinterEntity) this.f11571c.P().e();
        if (printerEntity == null) {
            this.f11570b.post(new Runnable() { // from class: r2.Z0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10997a.q0();
                }
            });
            return;
        }
        final String strConnectPrinter = posDriverInterface.connectPrinter(printerEntity.connectParameters);
        final String simpleName = posDriverInterface.getClass().getSimpleName();
        this.f11570b.post(new Runnable() { // from class: r2.a1
            @Override // java.lang.Runnable
            public final void run() {
                this.f11002a.r0(strConnectPrinter, simpleName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0() {
        this.f11374j.f11815u.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0() {
        PosDriverInterface posDriverInterfaceN = this.f11571c.N();
        if (posDriverInterfaceN != null) {
            posDriverInterfaceN.disconnectPrinter();
        }
        this.f11570b.post(new Runnable() { // from class: r2.Y0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10993a.t0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(p004b.a aVar) {
        Intent intentC;
        Bundle extras;
        if (aVar.d() != -1 || (intentC = aVar.c()) == null || (extras = intentC.getExtras()) == null) {
            return;
        }
        e0((BluetoothDevice) extras.getParcelable("btDevice"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(p004b.a aVar) {
        Intent intentC;
        Bundle extras;
        if (aVar.d() != -1 || (intentC = aVar.c()) == null || (extras = intentC.getExtras()) == null) {
            return;
        }
        Y0((UsbDevice) extras.getParcelable("usbDevice"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(Intent intent, long j3) {
        intent.putExtra("id", (int) j3);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(Exception exc) {
        Toast.makeText(this.f11373i, exc.getLocalizedMessage(), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(final Intent intent) {
        try {
            PrinterEntity printerEntity = (PrinterEntity) this.f11571c.P().e();
            if (printerEntity == null) {
                return;
            }
            if (printerEntity.getName().length() < 2) {
                this.f11570b.post(new Runnable() { // from class: r2.Q0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10957a.V0();
                    }
                });
                return;
            }
            AppDatabase appDatabaseH = RawPrinterApp.h();
            Objects.requireNonNull(appDatabaseH);
            final long jInsert = appDatabaseH.D().insert(printerEntity);
            AppDatabase appDatabaseH2 = RawPrinterApp.h();
            Objects.requireNonNull(appDatabaseH2);
            if (appDatabaseH2.D().getDefault().getId() < 3) {
                AppDatabase appDatabaseH3 = RawPrinterApp.h();
                Objects.requireNonNull(appDatabaseH3);
                appDatabaseH3.D().setDefault((int) jInsert);
            }
            this.f11571c.N().disconnectPrinter();
            this.f11570b.post(new Runnable() { // from class: r2.R0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10960a.x0(intent, jInsert);
                }
            });
        } catch (Exception e3) {
            e3.printStackTrace();
            this.f11570b.post(new Runnable() { // from class: r2.S0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10967a.y0(e3);
                }
            });
        }
    }

    public void l0(String str) {
        if (str == null) {
            str = "unknown";
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("peripage_a8+") || lowerCase.startsWith("peripage_a8p")) {
            this.f11571c.S0(Constant.DRIVER_PERIPAGE);
            this.f11571c.I0(576);
            this.f11571c.G0(304);
            this.f11571c.M0(500);
            return;
        }
        if (lowerCase.startsWith("peripage_a9+") || lowerCase.startsWith("peripage_q9p") || lowerCase.startsWith("peripage_q9s")) {
            this.f11571c.S0(Constant.DRIVER_PERIPAGE);
            this.f11571c.I0(864);
            this.f11571c.G0(304);
            this.f11571c.M0(650);
            this.f11571c.V0(3);
            return;
        }
        if (lowerCase.startsWith("peripage_q9") || lowerCase.startsWith("peripage_q7p") || lowerCase.startsWith("peripage_a7") || lowerCase.startsWith("peripage+")) {
            this.f11571c.S0(Constant.DRIVER_PERIPAGE);
            this.f11571c.I0(576);
            this.f11571c.G0(304);
            this.f11571c.M0(500);
            return;
        }
        if (lowerCase.startsWith("peripage_a3_") || lowerCase.startsWith("peripage_a9_")) {
            this.f11571c.S0(Constant.DRIVER_PERIPAGE);
            this.f11571c.I0(576);
            this.f11571c.G0(203);
            this.f11571c.M0(500);
            this.f11571c.V0(3);
            return;
        }
        if (lowerCase.startsWith(Constant.DRIVER_PERIPAGE)) {
            this.f11571c.S0(Constant.DRIVER_PERIPAGE);
            this.f11571c.I0(384);
            this.f11571c.G0(203);
            this.f11571c.M0(250);
            return;
        }
        if (lowerCase.startsWith(Constant.DRIVER_PAPERANG)) {
            this.f11571c.S0(Constant.DRIVER_PAPERANG);
            this.f11571c.I0(384);
            this.f11571c.G0(203);
            this.f11571c.w0(2);
            return;
        }
        if (lowerCase.startsWith("gt01") || lowerCase.startsWith("gb02") || lowerCase.startsWith("xw005") || lowerCase.startsWith("xw007") || lowerCase.startsWith("xw009") || lowerCase.startsWith("jx001") || lowerCase.startsWith("jx006") || lowerCase.startsWith("xw003") || lowerCase.startsWith("m01") || lowerCase.startsWith("pr07") || lowerCase.startsWith("pr02") || lowerCase.startsWith("gb01") || lowerCase.startsWith("gb03") || lowerCase.startsWith("gb04") || lowerCase.startsWith("ly01") || lowerCase.startsWith("ly02") || lowerCase.startsWith("ly03") || lowerCase.startsWith("ly10")) {
            this.f11571c.T0(6);
            this.f11571c.S0(Constant.DRIVER_CAT_PRINTER);
            this.f11571c.w0(1);
            this.f11571c.I0(384);
            this.f11571c.G0(203);
            this.f11571c.M0(0);
            this.f11571c.V0(4);
            return;
        }
        if (lowerCase.startsWith("xw004") || lowerCase.startsWith("xw006") || lowerCase.startsWith("xw008") || lowerCase.startsWith("jx002")) {
            this.f11571c.T0(6);
            this.f11571c.S0(Constant.DRIVER_CAT_PRINTER);
            this.f11571c.w0(1);
            this.f11571c.I0(576);
            this.f11571c.G0(304);
            this.f11571c.M0(0);
            this.f11571c.V0(4);
            return;
        }
        if (lowerCase.startsWith("yt01") || lowerCase.startsWith("yt02") || lowerCase.startsWith("mx01") || lowerCase.startsWith("mx02") || lowerCase.startsWith("mx03") || lowerCase.startsWith("mx05") || lowerCase.startsWith("mx06") || lowerCase.startsWith("mx07") || lowerCase.startsWith("mx08") || lowerCase.startsWith("mx09") || lowerCase.startsWith("jl-br22") || lowerCase.startsWith("miniprinter")) {
            this.f11571c.T0(6);
            this.f11571c.S0(Constant.DRIVER_CAT_PRINTER);
            this.f11571c.I0(384);
            this.f11571c.G0(203);
            this.f11571c.w0(0);
            this.f11571c.M0(250);
            this.f11571c.V0(4);
            return;
        }
        if (lowerCase.startsWith("mr.in") || lowerCase.startsWith("mht-")) {
            this.f11571c.S0(Constant.DRIVER_GSv0);
            this.f11571c.I0(384);
            this.f11571c.G0(203);
            this.f11571c.V0(2);
            this.f11571c.w0(0);
            this.f11571c.M0(100);
            if (((PrinterEntity) this.f11571c.P().e()).getProtocol() == 6) {
                this.f11571c.M0(0);
                return;
            }
            return;
        }
        if (lowerCase.startsWith("g5-")) {
            this.f11571c.S0(Constant.DRIVER_DOTHAN_TECH);
            this.f11571c.I0(384);
            this.f11571c.G0(203);
            this.f11571c.V0(2);
            this.f11571c.w0(0);
            this.f11571c.M0(10);
            return;
        }
        this.f11571c.S0(Constant.DRIVER_ESC_GENERAL);
        this.f11571c.K0(0);
        this.f11571c.I0(384);
        this.f11571c.G0(203);
        this.f11571c.R0(0);
        this.f11571c.w0(0);
        this.f11571c.M0(25);
        this.f11571c.V0(2);
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0634m, androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f11373i = this;
        super.onCreate(bundle);
        t2.b bVarC = t2.b.c(getLayoutInflater());
        this.f11374j = bVarC;
        setContentView(bVarC.b());
        setTitle("Add printer");
        AbstractC0245a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.s(true);
        }
        this.f11375k = y2.b.w();
        String[][] strArrF = B2.b.f(this.f11373i, R.raw.drivers);
        this.f11374j.f11783C.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: r2.b1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i3) {
                this.f11008a.H0(radioGroup, i3);
            }
        });
        this.f11374j.f11816v.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: r2.B0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                this.f10880a.P0(compoundButton, z3);
            }
        });
        this.f11374j.f11817w.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: r2.C0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                this.f10884a.Q0(compoundButton, z3);
            }
        });
        this.f11374j.f11796b.setOnClickListener(new View.OnClickListener() { // from class: r2.D0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10889a.R0(view);
            }
        });
        this.f11374j.f11799e.setOnClickListener(new View.OnClickListener() { // from class: r2.E0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10894a.S0(view);
            }
        });
        this.f11374j.f11786F.setOnClickListener(new View.OnClickListener() { // from class: r2.F0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10899a.T0(view);
            }
        });
        this.f11374j.f11785E.setOnClickListener(new View.OnClickListener() { // from class: r2.G0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10904a.U0(view);
            }
        });
        final Intent intent = new Intent(this, (Class<?>) EditPrinterActivity.class);
        this.f11374j.f11800f.setOnClickListener(new View.OnClickListener() { // from class: r2.H0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10909a.A0(intent, view);
            }
        });
        j0();
        this.f11370f = this.f11374j.f11801g;
        k0();
        this.f11372h = this.f11374j.f11808n;
        m0();
        Spinner spinner = this.f11374j.f11788H;
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, strArrF[1]);
        this.f11376l = new ArrayAdapter(this, android.R.layout.simple_spinner_item, strArrF[0]);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setOnItemSelectedListener(new a());
        this.f11571c.P().g(this, new InterfaceC0363v() { // from class: r2.I0
            @Override // androidx.lifecycle.InterfaceC0363v
            public final void a(Object obj) {
                this.f10915a.X0((PrinterEntity) obj);
            }
        });
        this.f11571c.K().g(this, new InterfaceC0363v() { // from class: r2.K0
            @Override // androidx.lifecycle.InterfaceC0363v
            public final void a(Object obj) {
                this.f10925a.B0((BluetoothDevice) obj);
            }
        });
        this.f11571c.M().g(this, new InterfaceC0363v() { // from class: r2.c1
            @Override // androidx.lifecycle.InterfaceC0363v
            public final void a(Object obj) {
                this.f11011a.C0((Boolean) obj);
            }
        });
        this.f11374j.f11804j.setOnClickListener(new View.OnClickListener() { // from class: r2.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11015a.D0(view);
            }
        });
        this.f11374j.f11813s.setOnClickListener(new View.OnClickListener() { // from class: r2.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11019a.J0(view);
            }
        });
        this.f11571c.L().g(this, new InterfaceC0363v() { // from class: r2.f1
            @Override // androidx.lifecycle.InterfaceC0363v
            public final void a(Object obj) {
                this.f11023a.K0((Boolean) obj);
            }
        });
        this.f11374j.f11809o.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: r2.g1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z3) {
                this.f11027a.L0(view, z3);
            }
        });
        this.f11374j.f11810p.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: r2.h1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z3) {
                this.f11032a.M0(view, z3);
            }
        });
        this.f11374j.f11812r.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: r2.z0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z3) {
                this.f11121a.N0(view, z3);
            }
        });
        this.f11374j.f11811q.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: r2.A0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z3) {
                this.f10876a.O0(view, z3);
            }
        });
        if (bundle == null) {
            s();
        }
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0634m, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
