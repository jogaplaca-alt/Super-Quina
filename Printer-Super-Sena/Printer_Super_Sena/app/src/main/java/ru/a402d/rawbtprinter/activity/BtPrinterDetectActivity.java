package ru.a402d.rawbtprinter.activity;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.appcompat.app.AbstractActivityC0248d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rawbt.sdk.RawbtConstants;
import rawbt.sdk.drivers.RealRAW;
import rawbt.sdk.profiles.FictivePrinterProfile;
import rawbt.sdk.transport.BLE;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class BtPrinterDetectActivity extends AbstractActivityC0248d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ExecutorService f11286a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Handler f11287b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    BluetoothDevice f11288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    BLE f11289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    TextView f11290e;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(String str) {
        C("Device name: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(String str) {
        C("Manufacturer: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(String str) {
        C("Model: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(String str) {
        C("SN: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(String str) {
        C("Firmware: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(String str) {
        C("Hardware: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(String str) {
        C("Software: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(int i3, int i4, int i5) {
        C("r:" + i3 + " w:" + i4 + " n:" + i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(y2.b bVar) {
        final String strConnect = this.f11289d.connect();
        this.f11287b.post(new Runnable() { // from class: r2.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f11053a.C(strConnect);
            }
        });
        if (RawbtConstants.OK.equals(strConnect)) {
            final String deviceName = this.f11289d.getDeviceName();
            this.f11287b.post(new Runnable() { // from class: r2.n
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11060a.D(deviceName);
                }
            });
            final String deviceManufacturer = this.f11289d.getDeviceManufacturer();
            this.f11287b.post(new Runnable() { // from class: r2.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11067a.E(deviceManufacturer);
                }
            });
            final String deviceModel = this.f11289d.getDeviceModel();
            this.f11287b.post(new Runnable() { // from class: r2.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11073a.F(deviceModel);
                }
            });
            final String deviceSerialNumber = this.f11289d.getDeviceSerialNumber();
            this.f11287b.post(new Runnable() { // from class: r2.q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11077a.G(deviceSerialNumber);
                }
            });
            final String deviceFirmware = this.f11289d.getDeviceFirmware();
            this.f11287b.post(new Runnable() { // from class: r2.r
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11081a.H(deviceFirmware);
                }
            });
            final String deviceHardware = this.f11289d.getDeviceHardware();
            this.f11287b.post(new Runnable() { // from class: r2.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11086a.I(deviceHardware);
                }
            });
            final String deviceSoftware = this.f11289d.getDeviceSoftware();
            this.f11287b.post(new Runnable() { // from class: r2.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11091a.J(deviceSoftware);
                }
            });
            final int size = this.f11289d.getReadCharacteristics().size();
            final int size2 = this.f11289d.getWriteCharacteristics().size();
            final int size3 = this.f11289d.getNotifyCharacteristics().size();
            this.f11287b.post(new Runnable() { // from class: r2.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11096a.K(size, size2, size3);
                }
            });
            if (size2 <= 0 || size3 <= 0) {
                return;
            }
            bVar.R0();
            bVar.M0(this.f11289d.getMacAddress());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public void C(String str) {
        this.f11290e.append(str + "\n");
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bt_printer_detect);
        BluetoothDevice bluetoothDevice = (BluetoothDevice) getIntent().getParcelableExtra("bt_dev");
        this.f11288c = bluetoothDevice;
        if (bluetoothDevice == null) {
            finish();
        }
        this.f11290e = (TextView) findViewById(R.id.textView);
        C(this.f11288c.getAddress());
        BLE ble = new BLE();
        this.f11289d = ble;
        ble.setConnectParam(this.f11288c.getAddress());
        this.f11289d.injectDriver(new RealRAW(new FictivePrinterProfile(0, 0, 0, 0), this));
        final y2.b bVarW = y2.b.w();
        this.f11286a.execute(new Runnable() { // from class: r2.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f11048a.L(bVarW);
            }
        });
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f11289d.disconnect();
    }
}
