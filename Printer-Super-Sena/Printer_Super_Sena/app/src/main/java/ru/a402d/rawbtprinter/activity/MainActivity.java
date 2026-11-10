package ru.a402d.rawbtprinter.activity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AbstractActivityC0248d;
import androidx.appcompat.app.C0246b;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import r2.W2;
import r2.X2;
import rawbt.api.Constant;
import rawbt.api.RawbtApiHelper;
import rawbt.api.RawbtMediaTypes;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesPdf;
import rawbt.sdk.AbstractRawBtPrintService;
import rawbt.sdk.ICallback;
import rawbt.sdk.IConsole;
import rawbt.sdk.IRawBtPrintService;
import ru.a402d.prnviewer.ViewActivity;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;
import ru.a402d.rawbtprinter.activity.MainActivity;
import u2.B1;
import u2.C0650e0;
import u2.C0659h0;
import u2.C0667k;
import u2.F0;
import u2.L1;
import u2.Q0;
import u2.T;
import u2.U;
import u2.ViewOnClickListenerC0651e1;
import u2.ViewOnClickListenerC0684s;
import u2.W;
import u2.q1;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends AbstractActivityC0248d implements NavigationView.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    y2.b f11387c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Intent f11392h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    TextView f11395k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    TextView f11396l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ProgressBar f11397m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    View f11398n;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private DrawerLayout f11403s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    NavigationView f11404t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ExecutorService f11385a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Handler f11386b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ICallback f11388d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final IConsole f11389e = new b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f11390f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f11391g = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f11393i = "ahz";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f11394j = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public IRawBtPrintService f11399o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ServiceConnection f11400p = new c();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final androidx.fragment.app.o f11401q = getSupportFragmentManager();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AbstractComponentCallbacksC0337e f11402r = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f11405u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Boolean f11406v = Boolean.FALSE;

    class a extends ICallback.Stub {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void R() {
            MainActivity.this.f11398n.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void S() {
            MainActivity.this.f11398n.setVisibility(8);
            MainActivity mainActivity = MainActivity.this;
            mainActivity.startActivity(mainActivity.f11392h);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void T() {
            MainActivity.this.f11398n.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void U(float f3) {
            MainActivity.this.f11397m.setVisibility(0);
            MainActivity.this.f11397m.setProgress((int) (f3 * 100.0f));
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintCancel(String str) {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.f11394j = false;
            if (mainActivity.f11393i.equals(str)) {
                MainActivity.this.f11386b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11586a.R();
                    }
                });
            }
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintError(String str, String str2) {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.f11394j = false;
            if (mainActivity.f11393i.equals(str)) {
                MainActivity.this.f11392h.setFlags(269025280);
                MainActivity.this.f11392h.putExtra("android.intent.extra.SUBJECT", str2);
                MainActivity.this.f11386b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11584a.S();
                    }
                });
            }
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintSuccess(String str) {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.f11394j = false;
            if (mainActivity.f11393i.equals(str)) {
                MainActivity.this.f11386b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11585a.T();
                    }
                });
            }
        }

        @Override // rawbt.sdk.ICallback
        public void onProgress(String str, final float f3) {
            if (MainActivity.this.f11393i.equals(str)) {
                MainActivity.this.f11386b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11587a.U(f3);
                    }
                });
            }
        }
    }

    class b extends IConsole.Stub {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void R() {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.f11396l.setText(String.format(Locale.US, "Sent: %s / Received: %s", Long.valueOf(mainActivity.f11390f), Long.valueOf(MainActivity.this.f11391g)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void S() {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.f11396l.setText(String.format(Locale.US, "Sent: %s / Received: %s", Long.valueOf(mainActivity.f11390f), Long.valueOf(MainActivity.this.f11391g)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void T(String str) {
            MainActivity.this.f11395k.setText(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void U() {
            MainActivity.this.f11395k.setText(R.string.connected);
        }

        @Override // rawbt.sdk.IConsole
        public void onDeviceReceived(byte[] bArr) {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.f11391g += (long) bArr.length;
            mainActivity.f11386b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.C
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11291a.R();
                }
            });
        }

        @Override // rawbt.sdk.IConsole
        public void onDeviceSent(byte[] bArr) {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.f11390f += (long) bArr.length;
            mainActivity.f11386b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.D
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11298a.S();
                }
            });
        }

        @Override // rawbt.sdk.IConsole
        public void onError(String str) {
        }

        @Override // rawbt.sdk.IConsole
        public void onNotify(final String str) {
            MainActivity.this.f11386b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.B
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11284a.T(str);
                }
            });
        }

        @Override // rawbt.sdk.IConsole
        public void onPrinterConnect() {
            MainActivity.this.f11386b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.A
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11283a.U();
                }
            });
        }

        @Override // rawbt.sdk.IConsole
        public void onPrinterDisconnect() {
            MainActivity.this.f11395k.setText(R.string.printer_not_connected);
        }
    }

    class c implements ServiceConnection {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            MainActivity.this.f11395k.setText(str);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MainActivity.this.f11399o = IRawBtPrintService.Stub.asInterface(iBinder);
            try {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.f11399o.registerCallback(mainActivity.f11388d);
                MainActivity mainActivity2 = MainActivity.this;
                mainActivity2.f11399o.registerConsole(mainActivity2.f11389e);
            } catch (Exception e3) {
                final String localizedMessage = e3.getLocalizedMessage();
                MainActivity.this.f11386b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.E
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11332a.b(localizedMessage);
                    }
                });
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MainActivity.this.f11399o = null;
        }
    }

    static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11410a;

        static {
            int[] iArr = new int[Constant.RAWBT_CONTENT_TYPE.values().length];
            f11410a = iArr;
            try {
                iArr[Constant.RAWBT_CONTENT_TYPE.image.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11410a[Constant.RAWBT_CONTENT_TYPE.pdf.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11410a[Constant.RAWBT_CONTENT_TYPE.html.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11410a[Constant.RAWBT_CONTENT_TYPE.prn.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11410a[Constant.RAWBT_CONTENT_TYPE.txt.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:50:0x00a3  */
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public void V(Intent intent) {
        CharSequence charSequenceExtra;
        String action = intent.getAction();
        if (action == null) {
        }
        try {
            String type = intent.getType();
            Bundle extras = intent.getExtras();
            if (RawPrinterApp.l() && this.f11387c.j() > 25) {
                L();
                return;
            }
            switch (action) {
                case "android.intent.action.MAIN":
                    this.f11405u = false;
                    M();
                    break;
                case "NOT_EXPORTED_PREVIEW_ACTION":
                    y((Uri) intent.getExtras().getParcelable("URI"), (Constant.RAWBT_CONTENT_TYPE) intent.getExtras().getSerializable("tip"));
                    break;
                case "rawbtprinter.a402d.ru.FAQ_ERROR":
                    A();
                    break;
                case "rawbtprinter.a402d.ru.CONFIG":
                    Q();
                    break;
                case "rawbtprinter.a402d.ru.LICENSE":
                    L();
                    break;
                case "rawbtprinter.a402d.ru.PREVIEW_IMAGE":
                    E((Uri) intent.getParcelableExtra("android.intent.extra.STREAM"), true);
                    break;
                case "rawbtprinter.a402d.ru.PREVIEW_IMAGE_NOT_FINISH":
                    E((Uri) intent.getParcelableExtra("android.intent.extra.STREAM"), false);
                    break;
                case "rawbtprinter.a402d.ru.PDF_DEBUG":
                    try {
                        File file = new File(getCacheDir(), "for_debug.pdf");
                        Objects.requireNonNull(extras);
                        O(Uri.fromFile(file), (AttributesPdf) extras.getParcelable("attrPdf"), (AttributesImage) extras.getParcelable("attrImg"));
                        break;
                    } catch (Exception unused) {
                        Toast.makeText(this, R.string.error_no_data, 0).show();
                        return;
                    }
                    break;
                case "com.google.android.gm.action.AUTO_SEND":
                    if (extras != null) {
                        K(extras.getString("android.intent.extra.TEXT"));
                        break;
                    }
                    Toast.makeText(this, action, 0).show();
                    M();
                    break;
                case "android.intent.action.VIEW":
                    String scheme = intent.getScheme();
                    if (!"http".equals(scheme) && !"https".equals(scheme)) {
                        b0(intent.getData());
                        break;
                    }
                    I(intent.getDataString());
                    break;
                case "android.intent.action.SEND":
                    try {
                        Set<String> categories = intent.getCategories();
                        Objects.requireNonNull(categories);
                        if ("com.google.android.voicesearch.SELF_NOTE".equals(categories.toString())) {
                            Objects.requireNonNull(extras);
                            K(extras.getString("android.intent.extra.TEXT"));
                        }
                        break;
                    } catch (Exception unused2) {
                    }
                    try {
                        Objects.requireNonNull(extras);
                        Uri uri = (Uri) extras.getParcelable("android.intent.extra.STREAM");
                        if (uri != null) {
                            b0(uri);
                        }
                        break;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    Objects.requireNonNull(extras);
                    String string = extras.getString("android.intent.extra.TEXT");
                    if (string == null && (charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TEXT")) != null) {
                        string = charSequenceExtra.toString();
                    }
                    if (string == null) {
                        Toast.makeText(this, R.string.error_no_data, 0).show();
                        M();
                        break;
                    } else {
                        if (!string.startsWith("http://") && !string.startsWith("https://") && !string.startsWith("file:///")) {
                            if (!"text/html".equals(type)) {
                                K(string);
                            } else {
                                G(string);
                            }
                            break;
                        }
                        I(string);
                        break;
                    }
                    break;
                default:
                    Toast.makeText(this, action, 0).show();
                    M();
                    break;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U() {
        this.f11406v = Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(boolean z3) {
        if (z3) {
            Z(getResources().getColor(R.color.red));
        } else {
            Z(getResources().getColor(R.color.color_menu));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X() {
        final boolean zL = RawPrinterApp.l();
        this.f11386b.post(new Runnable() { // from class: r2.o1
            @Override // java.lang.Runnable
            public final void run() {
                this.f11070a.W(zL);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(WeakReference weakReference, p054p1.c cVar, R0.d dVar) {
        if (dVar.g()) {
            p054p1.b bVar = (p054p1.b) dVar.d();
            MainActivity mainActivity = (MainActivity) weakReference.get();
            if (mainActivity != null) {
                cVar.a(mainActivity, bVar);
            }
        }
    }

    private void d0() {
        this.f11387c.u0(true);
        final WeakReference weakReference = new WeakReference(this);
        final p054p1.c cVarA = p054p1.d.a(this);
        cVarA.b().a(new R0.b() { // from class: r2.n1
            @Override // R0.b
            public final void a(R0.d dVar) {
                MainActivity.Y(weakReference, cVarA, dVar);
            }
        });
    }

    private Intent e0(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("%s?id=%s", str, getPackageName())));
        intent.addFlags(1208483840);
        return intent;
    }

    private void f0() {
        this.f11403s.j();
        setTitle(R.string.send_email);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_send_email).getItemId());
        try {
            this.f11402r = (AbstractComponentCallbacksC0337e) C0650e0.class.newInstance();
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void g0() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", "https://play.google.com/store/apps/details?id=ru.a402d.rawbtprinter");
        intent.setType("text/plain");
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        this.f11395k.setText(R.string.wait);
        if (!this.f11394j) {
            this.f11398n.setVisibility(8);
            return;
        }
        Intent intent = new Intent();
        intent.setAction(AbstractRawBtPrintService.ACTION_CANCEL);
        sendBroadcast(intent);
    }

    private void y(Uri uri, Constant.RAWBT_CONTENT_TYPE rawbt_content_type) {
        int i3 = d.f11410a[rawbt_content_type.ordinal()];
        if (i3 == 1) {
            E(uri, false);
            return;
        }
        if (i3 == 2) {
            O(uri, this.f11387c.b(), this.f11387c.a());
            return;
        }
        if (i3 == 3) {
            H(uri);
            return;
        }
        if (i3 == 4) {
            Intent intent = new Intent(this, (Class<?>) ViewActivity.class);
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uri);
            startActivity(intent);
            return;
        }
        if (i3 == 5) {
            S(uri);
        } else {
            M();
            RawPrinterApp.r(getString(R.string.not_allowed_media_type));
        }
    }

    public void A() {
        setTitle(getString(R.string.title_faq_error));
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_send_email).getItemId());
        try {
            this.f11402r = (AbstractComponentCallbacksC0337e) W.class.newInstance();
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void B() {
        setTitle(R.string.mitem_license);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_send_email).getItemId());
        try {
            this.f11402r = (AbstractComponentCallbacksC0337e) C0659h0.class.newInstance();
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void C() {
        this.f11403s.j();
        setTitle(R.string.barcode);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_barcode).getItemId());
        try {
            this.f11402r = (AbstractComponentCallbacksC0337e) C0667k.class.newInstance();
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void D() {
        this.f11403s.j();
        setTitle(R.string.mitem_imgfile);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_bmpfile).getItemId());
        try {
            this.f11402r = (AbstractComponentCallbacksC0337e) ViewOnClickListenerC0684s.class.newInstance();
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void E(Uri uri, boolean z3) {
        this.f11403s.j();
        setTitle(R.string.mitem_imgfile);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_bmpfile).getItemId());
        try {
            if (z3) {
                this.f11402r = ViewOnClickListenerC0684s.m2(uri);
            } else {
                this.f11402r = ViewOnClickListenerC0684s.n2(uri);
            }
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void F() {
        this.f11403s.j();
        setTitle(R.string.wait);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_home).getItemId());
        try {
            this.f11402r = (AbstractComponentCallbacksC0337e) u2.E.class.newInstance();
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void G(String str) {
        this.f11403s.j();
        setTitle(R.string.wait);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_home).getItemId());
        try {
            this.f11402r = u2.E.n2(str);
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void H(Uri uri) {
        this.f11403s.j();
        setTitle(R.string.wait);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_home).getItemId());
        try {
            this.f11402r = u2.E.o2(uri);
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void I(String str) {
        this.f11403s.j();
        setTitle(R.string.wait);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_home).getItemId());
        try {
            this.f11402r = u2.E.p2(str);
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void J() {
        this.f11403s.j();
        setTitle(R.string.mitem_editor);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_editor).getItemId());
        try {
            this.f11402r = (AbstractComponentCallbacksC0337e) T.class.newInstance();
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void K(String str) {
        this.f11403s.j();
        setTitle(R.string.mitem_editor);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_editor).getItemId());
        try {
            this.f11402r = T.v2(str);
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void L() {
        this.f11403s.j();
        setTitle(R.string.mitem_license);
        try {
            this.f11402r = (AbstractComponentCallbacksC0337e) F0.class.newInstance();
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void M() {
        this.f11403s.j();
        setTitle(R.string.app_name);
        try {
            this.f11402r = (AbstractComponentCallbacksC0337e) Q0.class.newInstance();
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void N() {
        this.f11403s.j();
        setTitle(R.string.mitem_pdffile);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_pdffile).getItemId());
        try {
            this.f11402r = (AbstractComponentCallbacksC0337e) ViewOnClickListenerC0651e1.class.newInstance();
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void O(Uri uri, AttributesPdf attributesPdf, AttributesImage attributesImage) {
        this.f11403s.j();
        setTitle(R.string.mitem_pdffile);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_pdffile).getItemId());
        try {
            this.f11402r = ViewOnClickListenerC0651e1.G2(uri, attributesPdf, attributesImage);
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void P() {
        this.f11403s.j();
        setTitle(R.string.qrcode);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_qrcode).getItemId());
        try {
            this.f11402r = (AbstractComponentCallbacksC0337e) q1.class.newInstance();
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void Q() {
        this.f11403s.j();
        setTitle(R.string.mitem_settings);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_setting).getItemId());
        try {
            this.f11402r = (AbstractComponentCallbacksC0337e) B1.class.newInstance();
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void R() {
        this.f11403s.j();
        setTitle(R.string.mitem_txtfile);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_txtfile).getItemId());
        try {
            this.f11402r = (AbstractComponentCallbacksC0337e) L1.class.newInstance();
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void S(Uri uri) {
        this.f11403s.j();
        setTitle(R.string.mitem_txtfile);
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_txtfile).getItemId());
        try {
            this.f11402r = L1.o2(uri);
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void Z(int i3) {
        MenuItem menuItemFindItem = this.f11404t.getMenu().findItem(R.id.nav_license);
        SpannableString spannableString = new SpannableString(menuItemFindItem.getTitle());
        spannableString.setSpan(new ForegroundColorSpan(i3), 0, spannableString.length(), 0);
        menuItemFindItem.setTitle(spannableString);
        Drawable icon = menuItemFindItem.getIcon();
        icon.mutate();
        icon.setColorFilter(androidx.core.graphics.a.a(i3, androidx.core.graphics.b.SRC_ATOP));
    }

    public void a0(String str) {
        Uri uri = Uri.parse(str);
        PackageManager packageManager = getPackageManager();
        Intent data = new Intent("android.intent.action.VIEW").setData(uri);
        Intent intentCreateChooser = Intent.createChooser(data, getString(R.string.open_url_with));
        if (data.resolveActivity(packageManager) != null) {
            startActivity(intentCreateChooser);
            return;
        }
        try {
            startActivity(data);
        } catch (Exception unused) {
            Toast.makeText(this, getString(R.string.browser_not_found), 0).show();
        }
    }

    public void b0(Uri uri) {
        y(uri, RawbtMediaTypes.detectContentType(this, uri, null));
    }

    @Override // com.google.android.material.navigation.NavigationView.d
    public boolean c(MenuItem menuItem) {
        menuItem.setChecked(true);
        int itemId = menuItem.getItemId();
        Log.d("RAWBT MENU", "item id " + itemId);
        if (RawPrinterApp.l() && this.f11387c.j() > 25) {
            L();
        } else if (itemId == R.id.nav_home) {
            F();
        } else if (itemId == R.id.nav_editor) {
            J();
        } else if (itemId == R.id.nav_pdffile) {
            N();
        } else if (itemId == R.id.nav_txtfile) {
            R();
        } else if (itemId == R.id.nav_bmpfile) {
            D();
        } else {
            if (itemId == R.id.nav_barcode) {
                C();
                return true;
            }
            if (itemId == R.id.nav_qrcode) {
                P();
                return true;
            }
            if (itemId == R.id.nav_setting) {
                Q();
            } else {
                if (itemId == R.id.nav_send_email) {
                    f0();
                    return true;
                }
                if (itemId == R.id.nav_share) {
                    g0();
                    return true;
                }
                if (itemId == R.id.nav_rate) {
                    c0();
                    return true;
                }
                if (itemId == R.id.nav_license) {
                    L();
                    return true;
                }
                if (itemId == R.id.nav_policy) {
                    I("file:///android_asset/privacy_policy.html");
                    return true;
                }
                if (itemId == R.id.nav_go_site) {
                    a0("https://rawbt.ru/");
                    return true;
                }
                if (itemId == R.id.nav_go_play) {
                    a0("https://play.google.com/store/search?q=pub:402d&c=apps");
                    return true;
                }
                if (itemId == R.id.nav_exit) {
                    finish();
                    return true;
                }
                if (itemId == R.id.nav_go_youtube) {
                    a0("https://www.youtube.com/c/402d_apps");
                    return true;
                }
            }
        }
        ((DrawerLayout) findViewById(R.id.drawer_layout)).f(8388611);
        return true;
    }

    public void c0() {
        if (!this.f11387c.g0()) {
            d0();
            return;
        }
        try {
            startActivity(e0("market://details"));
        } catch (ActivityNotFoundException unused) {
            startActivity(e0("https://play.google.com/store/apps/details"));
        }
    }

    public void h0(String str, String str2) {
        ((TextView) findViewById(R.id.txtCurrentPrinterName)).setText(str2);
        this.f11394j = true;
        this.f11393i = str;
        this.f11391g = 0L;
        this.f11390f = 0L;
        this.f11397m.setProgress(0);
        this.f11396l.setText(String.format(Locale.US, "Sent: %s / Received: %s", Long.valueOf(this.f11390f), Long.valueOf(this.f11391g)));
        this.f11398n.setVisibility(0);
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onBackPressed() {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e;
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.E(8388611)) {
            drawerLayout.f(8388611);
            this.f11406v = Boolean.FALSE;
            return;
        }
        int iI0 = this.f11401q.i0();
        if (iI0 <= -1) {
            finish();
            return;
        }
        try {
            List listP0 = this.f11401q.p0();
            if (iI0 > 0) {
                iI0--;
            }
            abstractComponentCallbacksC0337e = (AbstractComponentCallbacksC0337e) listP0.get(iI0);
        } catch (Exception unused) {
            abstractComponentCallbacksC0337e = null;
        }
        if (abstractComponentCallbacksC0337e instanceof u2.E ? ((u2.E) abstractComponentCallbacksC0337e).d2() : true) {
            if (this.f11405u) {
                finish();
                return;
            }
            if (abstractComponentCallbacksC0337e instanceof Q0) {
                if (this.f11406v.booleanValue()) {
                    finish();
                    return;
                }
                Toast.makeText(this, R.string.Back_to_exit, 0).show();
                this.f11406v = Boolean.TRUE;
                this.f11386b.postDelayed(new Runnable() { // from class: r2.j1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11041a.U();
                    }
                }, 1000L);
                return;
            }
            if (abstractComponentCallbacksC0337e instanceof C0659h0) {
                f0();
                this.f11406v = Boolean.FALSE;
            } else if (abstractComponentCallbacksC0337e instanceof U) {
                f0();
                this.f11406v = Boolean.FALSE;
            } else if (abstractComponentCallbacksC0337e instanceof W) {
                f0();
                this.f11406v = Boolean.FALSE;
            } else {
                M();
                this.f11406v = Boolean.FALSE;
            }
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(128);
        this.f11392h = new Intent(this, (Class<?>) ErrorActivity.class);
        this.f11395k = (TextView) findViewById(R.id.txtProgress);
        this.f11397m = (ProgressBar) findViewById(R.id.progressPercent);
        this.f11396l = (TextView) findViewById(R.id.txtStat);
        this.f11398n = findViewById(R.id.panel_progress);
        findViewById(R.id.btnProgressClose).setOnClickListener(new View.OnClickListener() { // from class: r2.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11046a.lambda$onCreate$0(view);
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.f11403s = drawerLayout;
        C0246b c0246b = new C0246b(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.f11403s.c(c0246b);
        c0246b.i();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        this.f11404t = navigationView;
        navigationView.setNavigationItemSelectedListener(this);
        Z(getResources().getColor(R.color.gray));
        if (this.f11399o == null) {
            bindService(RawbtApiHelper.createExplicitIntent(), this.f11400p, 1);
        }
        this.f11385a.execute(new Runnable() { // from class: r2.l1
            @Override // java.lang.Runnable
            public final void run() {
                B2.c.a();
            }
        });
        this.f11387c = y2.b.w();
        if (bundle == null) {
            V(getIntent());
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onDestroy() {
        if (this.f11399o != null) {
            unbindService(this.f11400p);
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            int id = currentFocus.getId();
            if ((id == R.id.btnEditPrint || id == R.id.btnEditSelect || id == R.id.btnSelectTxt || id == R.id.btnTxtPrint) && i3 == 19) {
                BottomSheetBehavior.q0(findViewById(R.id.bottom_sheet)).T0(4);
            }
            if (id == R.id.spinnerNumbersCopies && i3 == 61 && !keyEvent.isShiftPressed()) {
                BottomSheetBehavior.q0(findViewById(R.id.bottom_sheet)).T0(4);
            }
            if (id == R.id.input_area && i3 == 61 && keyEvent.isShiftPressed()) {
                BottomSheetBehavior.q0(findViewById(R.id.bottom_sheet)).T0(3);
            }
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i3, KeyEvent keyEvent) {
        if ((keyEvent.getMetaState() & 8192) != 0) {
            if (i3 == 44) {
                Y.f fVar = this.f11402r;
                if (fVar != null && (fVar instanceof X2)) {
                    ((X2) fVar).b();
                }
                return true;
            }
            if (i3 == 43) {
                Y.f fVar2 = this.f11402r;
                if (fVar2 != null && (fVar2 instanceof W2)) {
                    ((W2) fVar2).d();
                }
                return true;
            }
        }
        return super.onKeyShortcut(i3, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null && currentFocus.getId() == R.id.rbAlignLeft && (i3 == 20 || i3 == 61)) {
            BottomSheetBehavior.q0(findViewById(R.id.bottom_sheet)).T0(3);
        }
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, android.app.Activity
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        this.f11386b.postDelayed(new Runnable() { // from class: r2.m1
            @Override // java.lang.Runnable
            public final void run() {
                this.f11057a.V(intent);
            }
        }, 50L);
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f11385a.execute(new Runnable() { // from class: r2.i1
            @Override // java.lang.Runnable
            public final void run() {
                this.f11037a.X();
            }
        });
    }

    public void z() {
        setTitle(getString(R.string.title_faq_connect));
        this.f11404t.setCheckedItem(this.f11404t.getMenu().findItem(R.id.nav_send_email).getItemId());
        try {
            this.f11402r = (AbstractComponentCallbacksC0337e) U.class.newInstance();
            this.f11401q.j().n(R.id.flContent, this.f11402r).f();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
