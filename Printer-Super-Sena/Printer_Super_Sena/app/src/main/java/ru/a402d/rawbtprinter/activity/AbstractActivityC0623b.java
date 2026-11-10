package ru.a402d.rawbtprinter.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Base64;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AbstractActivityC0248d;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rawbt.api.RawbtApiHelper;
import rawbt.api.RawbtResponse;
import rawbt.sdk.AbstractRawBtPrintService;
import rawbt.sdk.ICallback;
import rawbt.sdk.IConsole;
import rawbt.sdk.IRawBtPrintService;
import rawbt.sdk.RawbtConstants;
import rawbt.sdk.RawbtPrintJob;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: renamed from: ru.a402d.rawbtprinter.activity.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractActivityC0623b extends AbstractActivityC0248d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ProgressBar f11530a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    B2.b.C0001b f11533d;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    y2.b f11543n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f11544o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    TextView f11545p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    TextView f11546q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    TextView f11547r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Spinner f11548s;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RawbtPrintJob f11531b = new RawbtPrintJob();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RawbtPrintJob f11532c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Handler f11534e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final ExecutorService f11535f = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IRawBtPrintService f11536g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ServiceConnection f11537h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final String f11538i = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final ICallback f11539j = new BinderC0132b();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final IConsole f11540k = new c();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    long f11541l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    long f11542m = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f11549t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected boolean f11550u = false;

    /* JADX INFO: renamed from: ru.a402d.rawbtprinter.activity.b$a */
    class a implements ServiceConnection {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            AbstractActivityC0623b.this.f11545p.setText(str);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AbstractActivityC0623b.this.f11536g = IRawBtPrintService.Stub.asInterface(iBinder);
            try {
                AbstractActivityC0623b abstractActivityC0623b = AbstractActivityC0623b.this;
                abstractActivityC0623b.f11536g.registerCallback(abstractActivityC0623b.f11539j);
                AbstractActivityC0623b abstractActivityC0623b2 = AbstractActivityC0623b.this;
                abstractActivityC0623b2.f11536g.registerConsole(abstractActivityC0623b2.f11540k);
            } catch (Exception e3) {
                final String localizedMessage = e3.getLocalizedMessage();
                AbstractActivityC0623b.this.f11534e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11528a.b(localizedMessage);
                    }
                });
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AbstractActivityC0623b.this.f11536g = null;
        }
    }

    /* JADX INFO: renamed from: ru.a402d.rawbtprinter.activity.b$b, reason: collision with other inner class name */
    class BinderC0132b extends ICallback.Stub {
        BinderC0132b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void S() {
            AbstractActivityC0623b.this.N(false, "cancel");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void T(String str) {
            AbstractActivityC0623b.this.N(false, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void U(String str) {
            AbstractActivityC0623b.this.f11545p.setText(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void V() {
            AbstractActivityC0623b.this.N(true, RawbtConstants.OK);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void W(float f3) {
            AbstractActivityC0623b.this.f11530a.setVisibility(0);
            AbstractActivityC0623b.this.f11530a.setProgress((int) (f3 * 100.0f));
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintCancel(String str) {
            AbstractActivityC0623b abstractActivityC0623b = AbstractActivityC0623b.this;
            abstractActivityC0623b.f11550u = false;
            if (abstractActivityC0623b.f11538i.equals(str)) {
                AbstractActivityC0623b.this.f11534e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11557a.S();
                    }
                });
            }
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintError(String str, final String str2) {
            AbstractActivityC0623b abstractActivityC0623b = AbstractActivityC0623b.this;
            abstractActivityC0623b.f11550u = false;
            if (abstractActivityC0623b.f11538i.equals(str)) {
                AbstractActivityC0623b abstractActivityC0623b2 = AbstractActivityC0623b.this;
                if (abstractActivityC0623b2.f11544o) {
                    abstractActivityC0623b2.f11534e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11558a.T(str2);
                        }
                    });
                } else {
                    abstractActivityC0623b2.f11534e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11560a.U(str2);
                        }
                    });
                }
            }
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintSuccess(String str) {
            AbstractActivityC0623b abstractActivityC0623b = AbstractActivityC0623b.this;
            abstractActivityC0623b.f11550u = false;
            if (abstractActivityC0623b.f11538i.equals(str)) {
                AbstractActivityC0623b.this.f11534e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11554a.V();
                    }
                });
            }
        }

        @Override // rawbt.sdk.ICallback
        public void onProgress(String str, final float f3) {
            if (AbstractActivityC0623b.this.f11538i.equals(str)) {
                AbstractActivityC0623b.this.f11534e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11555a.W(f3);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: ru.a402d.rawbtprinter.activity.b$c */
    class c extends IConsole.Stub {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void S() {
            AbstractActivityC0623b abstractActivityC0623b = AbstractActivityC0623b.this;
            abstractActivityC0623b.f11547r.setText(String.format(Locale.US, "Sent: %s / Received: %s", Long.valueOf(abstractActivityC0623b.f11541l), Long.valueOf(AbstractActivityC0623b.this.f11542m)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void T() {
            AbstractActivityC0623b abstractActivityC0623b = AbstractActivityC0623b.this;
            abstractActivityC0623b.f11547r.setText(String.format(Locale.US, "Sent: %s / Received: %s", Long.valueOf(abstractActivityC0623b.f11541l), Long.valueOf(AbstractActivityC0623b.this.f11542m)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void U(String str) {
            AbstractActivityC0623b.this.f11546q.setText(str);
            AbstractActivityC0623b.this.f11546q.setVisibility(0);
            AbstractActivityC0623b.this.f11545p.setVisibility(8);
            AbstractActivityC0623b.this.f11530a.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void V(String str) {
            AbstractActivityC0623b.this.f11545p.setText(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void W() {
            AbstractActivityC0623b.this.f11545p.setText(R.string.connected);
        }

        @Override // rawbt.sdk.IConsole
        public void onDeviceReceived(byte[] bArr) {
            AbstractActivityC0623b abstractActivityC0623b = AbstractActivityC0623b.this;
            abstractActivityC0623b.f11542m += (long) bArr.length;
            abstractActivityC0623b.f11534e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11564a.S();
                }
            });
        }

        @Override // rawbt.sdk.IConsole
        public void onDeviceSent(byte[] bArr) {
            AbstractActivityC0623b abstractActivityC0623b = AbstractActivityC0623b.this;
            abstractActivityC0623b.f11541l += (long) bArr.length;
            abstractActivityC0623b.f11534e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11563a.T();
                }
            });
        }

        @Override // rawbt.sdk.IConsole
        public void onError(final String str) {
            AbstractActivityC0623b.this.f11534e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11567a.U(str);
                }
            });
        }

        @Override // rawbt.sdk.IConsole
        public void onNotify(final String str) {
            AbstractActivityC0623b.this.f11534e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11565a.V(str);
                }
            });
        }

        @Override // rawbt.sdk.IConsole
        public void onPrinterConnect() {
            AbstractActivityC0623b.this.f11534e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11562a.W();
                }
            });
        }

        @Override // rawbt.sdk.IConsole
        public void onPrinterDisconnect() {
            AbstractActivityC0623b.this.f11545p.setText(R.string.printer_not_connected);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        findViewById(R.id.progressBar).setVisibility(8);
        RawbtPrintJob rawbtPrintJob = this.f11532c;
        if (rawbtPrintJob == null) {
            return;
        }
        rawbtPrintJob.setIdJob(this.f11538i);
        if (this.f11543n.r0()) {
            b();
        } else {
            findViewById(R.id.btnPrint).setEnabled(true);
            this.f11545p.setText(R.string.select_printer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        if (this.f11533d.f93b != null) {
            intent.setAction("NOT_EXPORTED_PREVIEW_ACTION");
            intent.putExtra("URI", this.f11533d.f93b);
            intent.putExtra("tip", this.f11533d.f92a);
        } else {
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", this.f11533d.f94c);
        }
        intent.setFlags(65536);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(Exception exc) {
        N(false, exc.getLocalizedMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(String str) {
        this.f11545p.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        try {
            this.f11536g.printRawbtPrintJob(this.f11532c.GSON());
        } catch (Exception e3) {
            if (this.f11544o) {
                this.f11534e.post(new Runnable() { // from class: r2.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11043a.H(e3);
                    }
                });
            } else {
                final String string = e3.getLocalizedMessage() == null ? getString(R.string.error) : e3.getLocalizedMessage();
                this.f11534e.post(new Runnable() { // from class: r2.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11006a.I(string);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(Exception exc) {
        this.f11545p.setText(exc.getLocalizedMessage());
        findViewById(R.id.progressBar).setVisibility(8);
        this.f11548s.setVisibility(8);
        findViewById(R.id.printerLabel).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        try {
            if (G()) {
                P();
                this.f11534e.post(new Runnable() { // from class: r2.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11025a.E();
                    }
                });
            } else {
                this.f11532c = O();
                this.f11534e.post(new Runnable() { // from class: r2.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11029a.D();
                    }
                });
            }
        } catch (Exception e3) {
            this.f11534e.post(new Runnable() { // from class: r2.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11034a.K(e3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        N(false, "open in browser");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f11547r.setVisibility(0);
        this.f11550u = true;
        if (!this.f11543n.r0()) {
            this.f11532c.setPrinter(this.f11531b.getPrinter());
        }
        if (this.f11536g != null) {
            findViewById(R.id.btnPrint).setEnabled(false);
            this.f11545p.setText(R.string.print_started);
            this.f11548s.setVisibility(8);
            findViewById(R.id.printerLabel).setVisibility(8);
            this.f11535f.execute(new Runnable() { // from class: r2.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11021a.J();
                }
            });
            return;
        }
        int i3 = this.f11549t + 1;
        this.f11549t = i3;
        if (i3 <= 10) {
            this.f11534e.postDelayed(new Runnable() { // from class: r2.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11017a.b();
                }
            }, 1000L);
            return;
        }
        this.f11545p.setText(R.string.error);
        findViewById(R.id.progressBar).setVisibility(8);
        this.f11548s.setVisibility(8);
        findViewById(R.id.printerLabel).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        b();
    }

    protected void F() {
        this.f11545p.setText(R.string.wait);
        if (!this.f11550u) {
            N(false, RawbtResponse.RESPONSE_CANCELED);
            return;
        }
        Intent intent = new Intent();
        intent.setAction(AbstractRawBtPrintService.ACTION_CANCEL);
        sendBroadcast(intent);
    }

    protected abstract boolean G();

    void N(boolean z3, String str) {
        if (this.f11544o) {
            Intent intent = new Intent();
            intent.putExtra("result", z3);
            intent.putExtra("message", str);
            setResult(-1, intent);
        }
        finish();
    }

    protected abstract RawbtPrintJob O();

    protected void P() throws Exception {
        B2.b.C0001b c0001bD = B2.b.d(getIntent());
        this.f11533d = c0001bD;
        if (c0001bD == null) {
            throw new Exception(getString(R.string.no_data_to_print));
        }
    }

    protected RawbtPrintJob Q(String str) {
        if (!str.startsWith("url:")) {
            RawbtPrintJob rawbtPrintJobE = B2.b.e(str, this.f11543n, this);
            if (rawbtPrintJobE == null) {
                return null;
            }
            rawbtPrintJobE.setCopies(this.f11543n.i());
            return rawbtPrintJobE;
        }
        String str2 = str.startsWith("url:base64,") ? new String(Base64.decode(str.substring(11), 0)) : str.substring(4);
        Intent intent = new Intent(getApplicationContext(), (Class<?>) MainActivity.class);
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(65536);
        intent.setData(Uri.parse(str2));
        startActivity(intent);
        this.f11534e.post(new Runnable() { // from class: r2.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f11039a.M();
            }
        });
        return null;
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        supportRequestWindowFeature(1);
        this.f11544o = getCallingActivity() != null;
        setContentView(R.layout.dialog_select_printer);
        setFinishOnTouchOutside(false);
        this.f11545p = (TextView) findViewById(R.id.txtProgress);
        this.f11546q = (TextView) findViewById(R.id.txtError);
        this.f11530a = (ProgressBar) findViewById(R.id.progressPercent);
        this.f11547r = (TextView) findViewById(R.id.txtStat);
        findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() { // from class: r2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11000a.lambda$onCreate$0(view);
            }
        });
        this.f11543n = y2.b.w();
        this.f11548s = (Spinner) findViewById(R.id.spinnerSelectPrinter);
        if (this.f11543n.r0()) {
            this.f11548s.setVisibility(8);
            findViewById(R.id.printerLabel).setVisibility(8);
        } else {
            s2.g.c(this, this.f11548s, this.f11531b);
        }
        findViewById(R.id.btnPrint).setOnClickListener(new View.OnClickListener() { // from class: r2.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11010a.lambda$onCreate$1(view);
            }
        });
        bindService(RawbtApiHelper.createExplicitIntent(), this.f11537h, 1);
        this.f11535f.execute(new Runnable() { // from class: r2.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f11013a.L();
            }
        });
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        IRawBtPrintService iRawBtPrintService = this.f11536g;
        if (iRawBtPrintService != null) {
            try {
                iRawBtPrintService.unregisterCallback(this.f11539j);
                this.f11536g.unregisterConsole(this.f11540k);
            } catch (RemoteException e3) {
                e3.printStackTrace();
            }
            unbindService(this.f11537h);
            this.f11536g = null;
        }
    }
}
