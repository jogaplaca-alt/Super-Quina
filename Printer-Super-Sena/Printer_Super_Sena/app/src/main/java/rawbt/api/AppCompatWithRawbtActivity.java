package rawbt.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.Spinner;
import androidx.appcompat.app.AbstractActivityC0248d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rawbt.sdk.ICallback;
import rawbt.sdk.IGetPrintersCallback;
import rawbt.sdk.IRawBtPrintService;
import rawbt.sdk.PrinterInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppCompatWithRawbtActivity extends AbstractActivityC0248d {
    protected Spinner spinnerSelectPrinter;
    protected final Handler handler = new Handler(Looper.getMainLooper());
    final ExecutorService executor = Executors.newSingleThreadExecutor();
    final ICallback serviceCallback = new AnonymousClass1();
    public volatile IRawBtPrintService serviceRawBT = null;
    protected SelectPrinterAdapter adapterSelectPrinter = null;
    private final IGetPrintersCallback getPrintersCallback = new AnonymousClass2();
    private final ServiceConnection connectService = new AnonymousClass3();
    private final p004b.c mRequestPermission = registerForActivityResult(new p008c.d(), new p004b.b() { // from class: rawbt.api.b
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            this.f11124a.lambda$new$4((Boolean) obj);
        }
    });

    /* JADX INFO: renamed from: rawbt.api.AppCompatWithRawbtActivity$1, reason: invalid class name */
    class AnonymousClass1 extends ICallback.Stub {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPrintCancel$2(String str) {
            AppCompatWithRawbtActivity.this.handlePrintCancel(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPrintError$1(String str, String str2) {
            AppCompatWithRawbtActivity.this.handlePrintError(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPrintSuccess$0(String str) {
            AppCompatWithRawbtActivity.this.handlePrintSuccess(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onProgress$3(String str, float f3) {
            AppCompatWithRawbtActivity.this.handlePrintProgress(str, Float.valueOf(f3));
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintCancel(final String str) {
            AppCompatWithRawbtActivity.this.handler.post(new Runnable() { // from class: rawbt.api.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11133a.lambda$onPrintCancel$2(str);
                }
            });
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintError(final String str, final String str2) {
            AppCompatWithRawbtActivity.this.handler.post(new Runnable() { // from class: rawbt.api.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11140a.lambda$onPrintError$1(str, str2);
                }
            });
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintSuccess(final String str) {
            AppCompatWithRawbtActivity.this.handler.post(new Runnable() { // from class: rawbt.api.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11138a.lambda$onPrintSuccess$0(str);
                }
            });
        }

        @Override // rawbt.sdk.ICallback
        public void onProgress(final String str, final float f3) {
            AppCompatWithRawbtActivity.this.handler.post(new Runnable() { // from class: rawbt.api.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11135a.lambda$onProgress$3(str, f3);
                }
            });
        }
    }

    /* JADX INFO: renamed from: rawbt.api.AppCompatWithRawbtActivity$2, reason: invalid class name */
    class AnonymousClass2 extends IGetPrintersCallback.Stub {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResult$0(PrinterInfo[] printerInfoArr) {
            AppCompatWithRawbtActivity appCompatWithRawbtActivity = AppCompatWithRawbtActivity.this;
            if (appCompatWithRawbtActivity.adapterSelectPrinter == null) {
                return;
            }
            String selectedPrinterName = appCompatWithRawbtActivity.getSelectedPrinterName();
            AppCompatWithRawbtActivity.this.adapterSelectPrinter.clear();
            PrinterInfo printerInfo = new PrinterInfo();
            printerInfo.name = RawbtPrintJob.PRINTER_CURRENT;
            printerInfo.description = "Default";
            AppCompatWithRawbtActivity.this.adapterSelectPrinter.add(printerInfo);
            int i3 = -1;
            int i4 = 1;
            for (PrinterInfo printerInfo2 : printerInfoArr) {
                AppCompatWithRawbtActivity.this.adapterSelectPrinter.add(printerInfo2);
                if (selectedPrinterName.equals(printerInfo2.name)) {
                    i3 = i4;
                }
                i4++;
            }
            AppCompatWithRawbtActivity.this.adapterSelectPrinter.notifyDataSetChanged();
            if (i3 > -1) {
                AppCompatWithRawbtActivity.this.spinnerSelectPrinter.setSelection(i3);
            }
        }

        @Override // rawbt.sdk.IGetPrintersCallback
        public void onResult(final PrinterInfo[] printerInfoArr) {
            AppCompatWithRawbtActivity.this.handler.post(new Runnable() { // from class: rawbt.api.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11143a.lambda$onResult$0(printerInfoArr);
                }
            });
        }
    }

    /* JADX INFO: renamed from: rawbt.api.AppCompatWithRawbtActivity$3, reason: invalid class name */
    class AnonymousClass3 implements ServiceConnection {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onServiceConnected$0() {
            AppCompatWithRawbtActivity.this.handleServiceConnected();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onServiceDisconnected$1() {
            AppCompatWithRawbtActivity.this.bindRawBT(false);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppCompatWithRawbtActivity.this.serviceRawBT = IRawBtPrintService.Stub.asInterface(iBinder);
            try {
                AppCompatWithRawbtActivity.this.serviceRawBT.registerCallback(AppCompatWithRawbtActivity.this.serviceCallback);
                AppCompatWithRawbtActivity.this.handler.post(new Runnable() { // from class: rawbt.api.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11145a.lambda$onServiceConnected$0();
                    }
                });
                AppCompatWithRawbtActivity.this.getPrinters();
            } catch (Exception e3) {
                AppCompatWithRawbtActivity.this.handlePrintError(null, e3.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AppCompatWithRawbtActivity.this.serviceRawBT = null;
            AppCompatWithRawbtActivity.this.handler.postDelayed(new Runnable() { // from class: rawbt.api.m
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11146a.lambda$onServiceDisconnected$1();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(Boolean bool) {
        bindRawBT(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        bindRawBT(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$printJob$1(RawbtPrintJob rawbtPrintJob) {
        handlePrintError(rawbtPrintJob.idJob, getString(R.string.rawbt_permission_not_granted));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$printJob$2(RawbtPrintJob rawbtPrintJob, Exception exc) {
        handlePrintError(rawbtPrintJob.idJob, exc.getLocalizedMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$printJob$3(final RawbtPrintJob rawbtPrintJob) {
        try {
            this.serviceRawBT.printRawbtPrintJob(rawbtPrintJob.GSON());
        } catch (SecurityException unused) {
            this.handler.post(new Runnable() { // from class: rawbt.api.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11127a.lambda$printJob$1(rawbtPrintJob);
                }
            });
        } catch (Exception e3) {
            this.handler.post(new Runnable() { // from class: rawbt.api.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11129a.lambda$printJob$2(rawbtPrintJob, e3);
                }
            });
        }
    }

    protected void bindRawBT(boolean z3) {
        if (!RawbtApiHelper.isServiceInstalled(this)) {
            handlePrintError(null, getString(R.string.rawb_not_installed));
            return;
        }
        try {
            bindService(RawbtApiHelper.createExplicitIntent(), this.connectService, 1);
        } catch (SecurityException unused) {
            if (!z3) {
                handlePrintError(null, getString(R.string.rawbt_permission_not_granted));
            } else {
                if (Build.VERSION.SDK_INT < 23 || checkSelfPermission(RawbtApiHelper.SERVICE_PERMISSION) == 0) {
                    return;
                }
                this.mRequestPermission.a(RawbtApiHelper.SERVICE_PERMISSION);
            }
        } catch (Exception unused2) {
            handlePrintError(null, getString(R.string.rawbt_connect_error));
        }
    }

    protected void getPrinters() {
        if (this.adapterSelectPrinter == null) {
            return;
        }
        try {
            if (this.serviceRawBT.getPrinters(this.getPrintersCallback)) {
                return;
            }
            PrinterInfo printerInfo = new PrinterInfo();
            printerInfo.name = RawbtPrintJob.PRINTER_CURRENT;
            printerInfo.description = "Default";
            this.adapterSelectPrinter.add(printerInfo);
            this.adapterSelectPrinter.notifyDataSetChanged();
        } catch (Exception unused) {
        }
    }

    protected abstract String getSelectedPrinterName();

    protected abstract void handlePrintCancel(String str);

    protected abstract void handlePrintError(String str, String str2);

    protected abstract void handlePrintProgress(String str, Float f3);

    protected abstract void handlePrintSuccess(String str);

    protected abstract void handleServiceConnected();

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.serviceRawBT == null) {
            this.handler.postDelayed(new Runnable() { // from class: rawbt.api.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11132a.lambda$onCreate$0();
                }
            }, 500L);
        }
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.serviceRawBT != null) {
            unbindService(this.connectService);
        }
    }

    protected void printJob(final RawbtPrintJob rawbtPrintJob) {
        if (this.serviceRawBT != null) {
            this.executor.execute(new Runnable() { // from class: rawbt.api.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11125a.lambda$printJob$3(rawbtPrintJob);
                }
            });
        } else if (!RawbtApiHelper.isServiceInstalled(this)) {
            handlePrintError(rawbtPrintJob.idJob, getString(R.string.rawb_not_installed));
        } else {
            bindRawBT(false);
            handlePrintError(rawbtPrintJob.idJob, getString(R.string.rawbt_please_wait));
        }
    }
}
