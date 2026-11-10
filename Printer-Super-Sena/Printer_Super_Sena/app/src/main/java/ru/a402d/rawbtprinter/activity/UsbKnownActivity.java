package ru.a402d.rawbtprinter.activity;

import android.app.Activity;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rawbt.sdk.btpair.BtScanActivity;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
public class UsbKnownActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ExecutorService f11518a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Handler f11519b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private UsbDevice f11520c;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void e() {
        Intent intent = new Intent(this, (Class<?>) Magic.class);
        intent.putExtra("usbDevice", this.f11520c);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(UsbDevice usbDevice) {
        if (RawPrinterApp.h().D().getByUsbParam("" + usbDevice.getProductId(), "" + usbDevice.getVendorId()) == null) {
            this.f11519b.post(new Runnable() { // from class: r2.S2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10970a.e();
                }
            });
        } else {
            this.f11519b.post(new Runnable() { // from class: r2.T2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10975a.f();
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_usb_dialog);
        Intent intent = getIntent();
        if (!intent.hasExtra(BtScanActivity.RESULT_OK_EXTRA)) {
            finish();
            return;
        }
        final UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra(BtScanActivity.RESULT_OK_EXTRA);
        if (usbDevice == null) {
            finish();
        } else {
            this.f11520c = usbDevice;
            this.f11518a.execute(new Runnable() { // from class: r2.R2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10964a.g(usbDevice);
                }
            });
        }
    }
}
