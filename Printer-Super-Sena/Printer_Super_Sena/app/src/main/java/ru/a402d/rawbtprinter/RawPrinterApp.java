package ru.a402d.rawbtprinter;

import B2.f;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import androidx.room.t;
import com.android.billingclient.api.AbstractC0390a;
import com.android.billingclient.api.C0392c;
import com.android.billingclient.api.C0394e;
import com.android.billingclient.api.Purchase;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p038k0.C0510a;
import p038k0.C0515f;
import p038k0.InterfaceC0511b;
import p038k0.InterfaceC0513d;
import p038k0.InterfaceC0514e;
import p038k0.InterfaceC0516g;
import p038k0.h;
import p038k0.i;
import rawbt.sdk.transport.PrintToFile;
import ru.a402d.rawbtprinter.RawPrinterApp;
import ru.a402d.rawbtprinter.activity.ErrorActivity;

/* JADX INFO: loaded from: classes.dex */
public class RawPrinterApp extends U.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static WeakReference f11264e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static AppDatabase f11265f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static SharedPreferences f11266g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f11267h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f11268i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f11269j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f11270k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f11271l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static AbstractC0390a f11272m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static ArrayList f11273n = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    BroadcastReceiver f11274a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    BroadcastReceiver f11275b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC0513d f11276c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h f11277d = new h() { // from class: q2.b
        @Override // p038k0.h
        public final void a(C0394e c0394e, List list) {
            RawPrinterApp.n(c0394e, list);
        }
    };

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String stringExtra = intent.getStringExtra("NAME");
                if (stringExtra == null) {
                    Toast.makeText(context, R.string.faq_WRITE_EXTERNAL_STORAGE, 1).show();
                } else {
                    Context contextG = RawPrinterApp.g();
                    Objects.requireNonNull(contextG);
                    Toast.makeText(context, String.format(contextG.getString(R.string.save_as_mask), stringExtra), 1).show();
                }
            } catch (Exception unused) {
            }
        }
    }

    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                Intent intent2 = new Intent();
                intent2.setAction(PrintToFile.ACTION_PRN_VIEW);
                intent2.setFlags(269025280);
                intent2.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(new File(context.getCacheDir(), "share").getPath(), "rawbt_temp_prn.prn")));
                context.startActivity(intent2);
            } catch (Exception e3) {
                Toast.makeText(context, e3.getMessage(), 1).show();
                e3.printStackTrace();
            }
        }
    }

    class c implements InterfaceC0513d {

        class a implements InterfaceC0514e {
            a() {
            }

            @Override // p038k0.InterfaceC0514e
            public void a(C0394e c0394e, C0392c c0392c) {
                if (c0394e.b() == 0 && c0392c != null) {
                    if ("RU".equals(c0392c.a())) {
                        RawPrinterApp.f11270k = true;
                        RawPrinterApp.j("day", System.currentTimeMillis(), "aaa");
                        return;
                    }
                    return;
                }
                if (c0392c == null) {
                    if ((Build.VERSION.SDK_INT >= 24 ? RawPrinterApp.this.getResources().getConfiguration().getLocales().get(0) : RawPrinterApp.this.getResources().getConfiguration().locale).getLanguage().equals("ru")) {
                        RawPrinterApp.f11270k = true;
                        RawPrinterApp.j("day", System.currentTimeMillis(), "aaa");
                    }
                }
            }
        }

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            try {
                RawPrinterApp.f11272m.h(RawPrinterApp.this.f11276c);
            } catch (Exception unused) {
            }
        }

        @Override // p038k0.InterfaceC0513d
        public void a() {
            RawPrinterApp.f11271l = false;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: ru.a402d.rawbtprinter.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11282a.d();
                }
            }, 5000L);
        }

        @Override // p038k0.InterfaceC0513d
        public void b(C0394e c0394e) {
            if (c0394e.b() == 0) {
                RawPrinterApp.f11271l = true;
                RawPrinterApp.q(null);
                RawPrinterApp.f11272m.b(C0515f.a().a(), new a());
            }
        }
    }

    public static Context g() {
        return (Context) f11264e.get();
    }

    public static AppDatabase h() {
        return f11265f;
    }

    public static Date i() {
        if (f11268i < 1740815408000L) {
            f11268i = 1740815408000L;
        }
        return new Date(f11268i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(String str, long j3, String str2) {
        long j4;
        SharedPreferences.Editor editorEdit = f11266g.edit();
        boolean z3 = !f11267h;
        str.hashCode();
        switch (str) {
            case "day":
                j4 = 86400000;
                j3 += j4;
                break;
            case "hour":
                j4 = 3600000;
                j3 += j4;
                break;
            case "year":
                j4 = 31622400000L;
                j3 += j4;
                break;
            case "month":
                j4 = 2764800000L;
                j3 += j4;
                break;
            case "quarter":
                j4 = 8035200000L;
                j3 += j4;
                break;
            case "lifetime":
                j3 = 7258118399000L;
                break;
        }
        if (j3 > f11268i) {
            z3 = true;
        }
        if (z3) {
            if ("hour".equals(str)) {
                f11269j++;
            } else {
                f11269j = 0;
            }
            int i3 = f11269j;
            if (i3 < 3) {
                editorEdit.putInt("APP_PREPEND", i3);
                if (j3 > f11268i) {
                    f11268i = j3;
                    editorEdit.putLong("APP_EXPIRED", j3);
                }
                f11267h = true;
                editorEdit.putBoolean("APP_PURCHASE", true);
                editorEdit.commit();
            }
        }
    }

    public static void k(EditText editText, Activity activity) {
        Objects.requireNonNull(activity);
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
        }
        editText.setEnabled(false);
        editText.setSelected(false);
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(false);
        editText.setEnabled(true);
        editText.setSelected(true);
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
    }

    public static boolean l() {
        if (System.currentTimeMillis() < 1740815408000L) {
            return false;
        }
        if (f11267h) {
            return System.currentTimeMillis() > f11268i;
        }
        return !f11270k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(C0394e c0394e) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(C0394e c0394e, List list) {
        if (c0394e.b() != 0 || list == null || list.size() <= 0) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Purchase purchase = (Purchase) it.next();
            if (purchase.e() == 1) {
                j((String) purchase.d().get(0), purchase.f(), purchase.g());
                f11272m.a(C0510a.b().b(purchase.g()).a(), new InterfaceC0511b() { // from class: q2.d
                    @Override // p038k0.InterfaceC0511b
                    public final void a(C0394e c0394e2) {
                        RawPrinterApp.m(c0394e2);
                    }
                });
            }
            if (purchase.e() == 2) {
                j("hour", purchase.f(), purchase.g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(C0394e c0394e) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(Runnable runnable, C0394e c0394e, List list) {
        f11273n.clear();
        if (c0394e.b() == 0 && list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                f11273n.add(purchase);
                if (purchase.e() == 1) {
                    j((String) purchase.d().get(0), purchase.f(), purchase.g());
                    if (!purchase.j()) {
                        f11272m.a(C0510a.b().b(purchase.g()).a(), new InterfaceC0511b() { // from class: q2.e
                            @Override // p038k0.InterfaceC0511b
                            public final void a(C0394e c0394e2) {
                                RawPrinterApp.o(c0394e2);
                            }
                        });
                    }
                }
                if (purchase.e() == 2) {
                    j("hour", purchase.f(), purchase.g());
                }
            }
        }
        if (runnable != null) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static void q(final Runnable runnable) {
        if (f11271l && f11272m.c()) {
            f11272m.f(i.a().b("inapp").a(), new InterfaceC0516g() { // from class: q2.c
                @Override // p038k0.InterfaceC0516g
                public final void a(C0394e c0394e, List list) {
                    RawPrinterApp.p(runnable, c0394e, list);
                }
            });
        } else if (runnable != null) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static void r(String str) {
        Log.d("myApp", Log.getStackTraceString(new Exception(str)));
        Intent intent = new Intent(g(), (Class<?>) ErrorActivity.class);
        intent.setFlags(269025280);
        intent.putExtra("android.intent.extra.SUBJECT", str);
        g().startActivity(intent);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f11264e = new WeakReference(getApplicationContext());
        y2.b.f0(this);
        f11265f = (AppDatabase) t.a(this, AppDatabase.class, "database").a(AppDatabase.f11257p).a(AppDatabase.f11258q).b();
        SharedPreferences sharedPreferences = getSharedPreferences("rawbt_settings", 0);
        f11266g = sharedPreferences;
        f11267h = sharedPreferences.getBoolean("APP_PURCHASE", false);
        f11268i = f11266g.getLong("APP_EXPIRED", 0L);
        f11269j = f11266g.getInt("APP_PREPEND", 0);
        try {
            AbstractC0390a abstractC0390aA = AbstractC0390a.e(this).c(this.f11277d).b().a();
            f11272m = abstractC0390aA;
            abstractC0390aA.h(this.f11276c);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        IntentFilter intentFilter = new IntentFilter("rawbt.sdk.emulator.new_image");
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            registerReceiver(this.f11274a, intentFilter, i3 >= 33 ? 2 : 0);
        } else {
            registerReceiver(this.f11274a, intentFilter);
        }
        IntentFilter intentFilter2 = new IntentFilter("rawbt.sdk.emulator.new_preview");
        if (i3 >= 26) {
            registerReceiver(this.f11275b, intentFilter2, i3 >= 33 ? 2 : 0);
        } else {
            registerReceiver(this.f11275b, intentFilter2);
        }
        f.e();
    }

    @Override // android.app.Application
    public void onTerminate() {
        unregisterReceiver(this.f11274a);
        unregisterReceiver(this.f11275b);
        super.onTerminate();
    }
}
