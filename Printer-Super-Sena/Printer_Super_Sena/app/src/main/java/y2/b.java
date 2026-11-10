package y2;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesPdf;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.PrinterEncoding;
import rawbt.sdk.transport.Constant;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static Context f12899f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static b f12900g0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private String f12901A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private String f12902B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private int f12903C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private int f12904D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private boolean f12905E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private boolean f12906F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private boolean f12907G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private int f12908H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private boolean f12909I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f12910J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private int f12911K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private boolean f12912L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private boolean f12913M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private boolean f12914N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private String f12915O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private String f12916P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private boolean f12917Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private int f12918R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private int f12919S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private int f12920T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private int f12921U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private int f12922V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private String f12923W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    private int f12924X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    private String f12925Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    private boolean f12926Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12927a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f12928a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12929b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private boolean f12930b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12931c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    boolean f12932c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12933d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f12934d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f12935e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private SharedPreferences f12936e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f12937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f12938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f12939h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12940i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f12941j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f12942k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f12943l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f12944m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f12945n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f12946o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f12947p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f12948q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f12949r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f12950s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f12951t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f12952u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f12953v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f12954w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f12955x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f12956y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f12957z;

    private b() {
        this.f12941j = Constant.DRIVER_ESC_GENERAL;
        this.f12943l = 0;
        this.f12944m = 0;
        this.f12945n = 384;
        this.f12946o = 203;
        this.f12947p = 1;
        this.f12948q = 0;
        this.f12951t = 0;
        this.f12952u = 0;
        this.f12953v = 0;
        this.f12954w = 0;
        this.f12955x = 0;
        this.f12957z = 21;
        this.f12907G = false;
        this.f12909I = false;
        this.f12910J = false;
        this.f12913M = false;
        this.f12914N = false;
        this.f12915O = "";
        this.f12916P = "";
        this.f12917Q = true;
        this.f12919S = 999;
        this.f12920T = 999;
        this.f12921U = 2097152;
        this.f12922V = 524288;
        this.f12928a0 = false;
        this.f12930b0 = false;
        this.f12936e0 = null;
        try {
            Context context = f12899f0;
            Objects.requireNonNull(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences("printer_settings", 0);
            this.f12936e0 = sharedPreferences;
            this.f12927a = sharedPreferences.getInt("TRANSPORT_TYPE", 0);
            this.f12929b = this.f12936e0.getString("TRANSPORT_CONNECTING_MAC", "00:00:00:00:00:00");
            this.f12931c = this.f12936e0.getString("TRANSPORT_CONNECTING_HOST", "192.168.1.1");
            this.f12933d = this.f12936e0.getInt("TRANSPORT_CONNECTING_PORT", 9100);
            this.f12937f = this.f12936e0.getString("TRANSPORT_CONNECTING_PID", "20497");
            this.f12935e = this.f12936e0.getString("TRANSPORT_CONNECTING_VID", "1046");
            this.f12938g = this.f12936e0.getInt("COM_BAUD", 115200);
            this.f12939h = this.f12936e0.getString("COM_DRIVER", Constant.COM_CdcAcm);
            this.f12940i = this.f12936e0.getInt("APP_AIDL_DRIVER", 0);
            this.f12941j = this.f12936e0.getString("PRINTER_DRIVER", Constant.DRIVER_ESC_GENERAL);
            this.f12942k = this.f12936e0.getInt("LAN_DELAY_MS", 0);
            this.f12943l = this.f12936e0.getInt("DRV_FC_SLEEP_AFTER", 3000);
            this.f12944m = this.f12936e0.getInt("DRV_FC_ABS_MODE", 0);
            this.f12945n = this.f12936e0.getInt("DOTS_PER_LINE", 384);
            this.f12946o = this.f12936e0.getInt("DOTS_PER_INCH", 203);
            this.f12947p = this.f12936e0.getInt("DRV_DARKNESS", 1);
            int i3 = 2;
            this.f12948q = this.f12936e0.getInt("APP_END_LINES", 2);
            this.f12949r = this.f12936e0.getString("APP_BYTES_INIT", "");
            this.f12950s = this.f12936e0.getString("APP_BYTES_FINISH", "");
            this.f12951t = this.f12936e0.getInt("DRIVER", 0);
            this.f12952u = this.f12936e0.getInt("APP_END_CUT", 0);
            this.f12953v = this.f12936e0.getInt("CP_TYPE", 0);
            this.f12954w = this.f12936e0.getInt("INTERNAL_PRINTER_FONTS", 0);
            this.f12955x = this.f12936e0.getInt("INTERNAL_PRINTER_CPI", 0);
            this.f12957z = this.f12936e0.getInt("APP_TRUETYPE_FONT_SIZE", 21);
            this.f12956y = this.f12936e0.getInt("INTERNATIONAL_CHARS", 0);
            this.f12901A = this.f12936e0.getString("CP_LANGUAGE", PrinterEncoding.getCurrentLocale(f12899f0).getLanguage());
            this.f12902B = this.f12936e0.getString("CODEPAFE", f12899f0.getString(c.f12964g));
            this.f12903C = this.f12936e0.getInt("APP_GRAPHICS_MODE_BMP", 1);
            boolean z3 = this.f12936e0.getBoolean("PDF_TRUNCATE", true);
            this.f12906F = this.f12936e0.getBoolean("MOZILA_TRUNCATE", false);
            this.f12907G = this.f12936e0.getBoolean("APP_CUT_TOP", false);
            this.f12908H = this.f12936e0.getInt("APP_CUT_TOP_VAL", 36);
            this.f12910J = this.f12936e0.getBoolean("APP_CUT_FRAME", false);
            this.f12911K = this.f12936e0.getInt("APP_CUT_FRAME_VAL", 5);
            this.f12909I = this.f12936e0.getBoolean("APP_PAGE_CUT", false);
            this.f12905E = this.f12936e0.getBoolean("PDF_ROLL", true);
            SharedPreferences sharedPreferences2 = this.f12936e0;
            if (!z3) {
                i3 = 1;
            }
            this.f12904D = sharedPreferences2.getInt("PDF_WIDTH_TRUNCATED", i3);
            this.f12912L = this.f12936e0.getBoolean("UTF_ASCII", true);
            this.f12913M = this.f12936e0.getBoolean("APP_START_LOGO", false);
            this.f12914N = this.f12936e0.getBoolean("APP_END_DATE", false);
            this.f12915O = this.f12936e0.getString("TEMPLATE_TOP_TEXT", "");
            this.f12916P = this.f12936e0.getString("TEMPLATE_BOTTOM_TEXT", "");
            this.f12917Q = this.f12936e0.getBoolean("TEMPLATE_PAPER_CUT", true);
            this.f12918R = this.f12936e0.getInt("APP_PRINT_COPIES", 1);
            this.f12919S = this.f12936e0.getInt("APP_LIMIT_PAGES", 999);
            this.f12920T = this.f12936e0.getInt("APP_LIMIT_IMAGES", 999);
            this.f12921U = this.f12936e0.getInt("APP_LIMIT_FILE_SIZE", 2097152);
            this.f12922V = this.f12936e0.getInt("APP_LIMIT_DOWNLOAD_FILE_SIZE", 524288);
            this.f12924X = this.f12936e0.getInt("APP_GRAPHICS_MODE_PRN", 1);
            this.f12923W = this.f12936e0.getString("APP_PAGE_SIZE", "58mm Roll");
            this.f12926Z = this.f12936e0.getBoolean("APP_DONTASK_URL", false);
            this.f12925Y = this.f12936e0.getString("APP_START_URL", "file:///android_asset/app/index.html");
            this.f12928a0 = this.f12936e0.getBoolean("APP_PREVIEW_MODE", false);
            this.f12930b0 = this.f12936e0.getBoolean("APP_START_PRINT", false);
            this.f12932c0 = this.f12936e0.getBoolean("APP_RATE", false);
            this.f12934d0 = this.f12936e0.getInt("APP_COUNTER", 0);
        } catch (Exception unused) {
            a1("FATAL ERROR");
        }
    }

    public static ArrayList H() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");
        return arrayList;
    }

    public static ArrayList S() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Base");
        arrayList.add("Empty");
        return arrayList;
    }

    private void a1(String str) {
        Toast.makeText(f12899f0, str, 1).show();
    }

    public static void f0(Context context) {
        f12899f0 = context;
    }

    public static ArrayList v() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1/16");
        arrayList.add("2/16");
        arrayList.add("3/16");
        arrayList.add("  25%");
        arrayList.add("5/16");
        arrayList.add("6/16");
        arrayList.add("7/16");
        arrayList.add("  50%");
        arrayList.add("9/16");
        arrayList.add("10/16");
        arrayList.add("11/16");
        arrayList.add("  75%");
        arrayList.add("13/16");
        arrayList.add("14/16");
        arrayList.add("15/16");
        arrayList.add("100%");
        return arrayList;
    }

    public static b w() {
        if (f12900g0 == null) {
            f12900g0 = new b();
        }
        return f12900g0;
    }

    public int A() {
        return this.f12954w;
    }

    public void A0(int i3) {
        if (this.f12911K == i3) {
            return;
        }
        this.f12911K = i3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putInt("APP_CUT_FRAME_VAL", this.f12911K);
        editorEdit.commit();
    }

    public int B() {
        return this.f12956y;
    }

    public void B0(boolean z3) {
        if (this.f12907G == z3) {
            return;
        }
        this.f12907G = z3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putBoolean("APP_CUT_TOP", this.f12907G);
        editorEdit.commit();
    }

    public int C() {
        return this.f12922V;
    }

    public void C0(int i3) {
        if (this.f12908H == i3) {
            return;
        }
        this.f12908H = i3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putInt("APP_CUT_TOP_VAL", this.f12908H);
        editorEdit.commit();
    }

    public int D() {
        return this.f12921U;
    }

    public void D0(boolean z3) {
        if (this.f12926Z == z3) {
            return;
        }
        this.f12926Z = z3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putBoolean("APP_DONTASK_URL", this.f12926Z);
        editorEdit.commit();
    }

    public int E() {
        return this.f12920T;
    }

    public void E0(int i3) {
        if (this.f12903C == i3) {
            return;
        }
        this.f12903C = i3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putInt("APP_GRAPHICS_MODE_BMP", this.f12903C);
        editorEdit.commit();
    }

    public int F() {
        return this.f12919S;
    }

    public void F0(int i3) {
        if (this.f12955x == i3) {
            return;
        }
        this.f12955x = i3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putInt("INTERNAL_PRINTER_CPI", this.f12955x);
        editorEdit.commit();
    }

    public Drawable G() {
        InputStream inputStreamOpen;
        try {
            if (l0()) {
                inputStreamOpen = new FileInputStream(I());
            } else {
                Context context = f12899f0;
                Objects.requireNonNull(context);
                inputStreamOpen = context.getAssets().open("rawbtlogo.webp");
            }
            Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamOpen, null);
            inputStreamOpen.close();
            return drawableCreateFromStream;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public void G0(int i3) {
        if (this.f12954w == i3) {
            return;
        }
        this.f12954w = i3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putInt("INTERNAL_PRINTER_FONTS", this.f12954w);
        editorEdit.commit();
    }

    public void H0(int i3) {
        if (this.f12956y == i3) {
            return;
        }
        this.f12956y = i3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putInt("INTERNATIONAL_CHARS", this.f12956y);
        editorEdit.commit();
    }

    public String I() {
        if (Build.VERSION.SDK_INT >= 24) {
            StringBuilder sb = new StringBuilder();
            Context context = f12899f0;
            Objects.requireNonNull(context);
            sb.append(context.getDataDir());
            sb.append("/user_logo.img");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        Context context2 = f12899f0;
        Objects.requireNonNull(context2);
        sb2.append(context2.getFilesDir());
        sb2.append("/user_logo.img");
        return sb2.toString();
    }

    public void I0(int i3) {
        if (this.f12922V == i3) {
            return;
        }
        this.f12922V = i3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putInt("APP_LIMIT_DOWNLOAD_FILE_SIZE", this.f12922V);
        editorEdit.commit();
    }

    public int J() {
        return this.f12948q;
    }

    public void J0(int i3) {
        if (this.f12921U == i3) {
            return;
        }
        this.f12921U = i3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putInt("APP_LIMIT_FILE_SIZE", this.f12921U);
        editorEdit.commit();
    }

    public String K() {
        return this.f12901A;
    }

    public void K0(int i3) {
        if (this.f12920T == i3) {
            return;
        }
        this.f12920T = i3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putInt("APP_LIMIT_IMAGES", this.f12920T);
        editorEdit.commit();
    }

    public int L() {
        return this.f12953v;
    }

    public void L0(int i3) {
        if (this.f12919S == i3) {
            return;
        }
        this.f12919S = i3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putInt("APP_LIMIT_PAGES", this.f12919S);
        editorEdit.commit();
    }

    public int M() {
        return this.f12952u;
    }

    public void M0(String str) {
        if (this.f12929b.equals(str)) {
            return;
        }
        this.f12929b = str;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putString("TRANSPORT_CONNECTING_MAC", this.f12929b);
        editorEdit.commit();
    }

    public int N() {
        return this.f12927a;
    }

    public void N0(boolean z3) {
        if (this.f12909I == z3) {
            return;
        }
        this.f12909I = z3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putBoolean("APP_PAGE_CUT", this.f12909I);
        editorEdit.commit();
    }

    public String O() {
        return this.f12939h;
    }

    public void O0(boolean z3) {
        if (this.f12928a0 == z3) {
            return;
        }
        this.f12928a0 = z3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putBoolean("APP_PREVIEW_MODE", this.f12928a0);
        editorEdit.commit();
    }

    public TreeMap P() {
        TreeMap treeMap = new TreeMap();
        Context context = f12899f0;
        Objects.requireNonNull(context);
        treeMap.put(Constant.COM_CdcAcm, context.getString(c.f12959b));
        Context context2 = f12899f0;
        Objects.requireNonNull(context2);
        treeMap.put(Constant.COM_Cp21, context2.getString(c.f12961d));
        Context context3 = f12899f0;
        Objects.requireNonNull(context3);
        treeMap.put(Constant.COM_Ch34, context3.getString(c.f12960c));
        Context context4 = f12899f0;
        Objects.requireNonNull(context4);
        treeMap.put(Constant.COM_Ftdi, context4.getString(c.f12962e));
        Context context5 = f12899f0;
        Objects.requireNonNull(context5);
        treeMap.put(Constant.COM_Prolific, context5.getString(c.f12963f));
        return treeMap;
    }

    public void P0(boolean z3) {
        if (this.f12914N == z3) {
            return;
        }
        this.f12914N = z3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putBoolean("APP_END_DATE", this.f12914N);
        editorEdit.commit();
    }

    public long Q() {
        return this.f12943l;
    }

    public void Q0(boolean z3) {
        if (this.f12913M == z3) {
            return;
        }
        this.f12913M = z3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putBoolean("APP_START_LOGO", this.f12913M);
        editorEdit.commit();
    }

    public String R() {
        return this.f12925Y;
    }

    public void R0() {
        if (this.f12927a == 6) {
            return;
        }
        this.f12927a = 6;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putInt("TRANSPORT_TYPE", this.f12927a);
        editorEdit.commit();
    }

    public void S0(boolean z3) {
        if (this.f12905E == z3) {
            return;
        }
        this.f12905E = z3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putBoolean("PDF_ROLL", this.f12905E);
        editorEdit.commit();
    }

    public String T() {
        return this.f12915O;
    }

    public void T0(boolean z3) {
        if (this.f12930b0 == z3) {
            return;
        }
        this.f12930b0 = z3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putBoolean("APP_START_PRINT", this.f12930b0);
        editorEdit.commit();
    }

    public int U() {
        return this.f12957z;
    }

    public void U0(String str) {
        if (this.f12925Y.equals(str)) {
            return;
        }
        this.f12925Y = str;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putString("APP_START_URL", this.f12925Y);
        editorEdit.commit();
    }

    public int V() {
        return this.f12904D;
    }

    public void V0(boolean z3) {
        if (this.f12917Q == z3) {
            return;
        }
        this.f12917Q = z3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putBoolean("TEMPLATE_PAPER_CUT", this.f12917Q);
        editorEdit.commit();
    }

    public int W() {
        return this.f12944m;
    }

    public void W0(String str) {
        if (this.f12915O.equals(str)) {
            return;
        }
        this.f12915O = str;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putString("TEMPLATE_TOP_TEXT", this.f12915O);
        editorEdit.commit();
    }

    public int X() {
        return this.f12938g;
    }

    public void X0(int i3) {
        if (this.f12957z == i3) {
            return;
        }
        this.f12957z = i3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putInt("APP_TRUETYPE_FONT_SIZE", this.f12957z);
        editorEdit.commit();
    }

    public String Y() {
        return this.f12931c;
    }

    public void Y0(boolean z3) {
        if (this.f12912L == z3) {
            return;
        }
        this.f12912L = z3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putBoolean("UTF_ASCII", this.f12912L);
        editorEdit.commit();
    }

    public int Z() {
        return this.f12942k;
    }

    public void Z0(int i3) {
        if (this.f12904D == i3) {
            return;
        }
        this.f12904D = i3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putInt("PDF_WIDTH_TRUNCATED", this.f12904D);
        editorEdit.commit();
    }

    public AttributesImage a() {
        AttributesImage attributesImage = new AttributesImage();
        attributesImage.setInverseColor(false);
        attributesImage.setRotateImage(false);
        attributesImage.setGraphicFilter(t());
        attributesImage.setScale(16);
        return attributesImage;
    }

    public String a0() {
        return this.f12929b;
    }

    public AttributesPdf b() {
        AttributesPdf attributesPdf = new AttributesPdf();
        attributesPdf.setWidthTruncateMode(V());
        attributesPdf.setCutTop(j0());
        attributesPdf.setCutTopVal(l());
        attributesPdf.setCutFrame(i0());
        attributesPdf.setCutFrameVal(k());
        attributesPdf.setClearHeaderAndFooter(h0());
        attributesPdf.setPaperCutAfterEachPage(m0());
        return attributesPdf;
    }

    public String b0() {
        return this.f12923W;
    }

    public AttributesString c() {
        AttributesString attributesString = new AttributesString();
        int iA = A();
        if (L() == 1) {
            iA = 4;
        }
        attributesString.setPrinterFont(iA);
        attributesString.setFontsCpi(z());
        attributesString.setInternationalChars(B());
        attributesString.setTruetypeFontSize(U());
        return attributesString;
    }

    public String c0() {
        return this.f12937f;
    }

    public int d() {
        return this.f12940i;
    }

    public int d0() {
        return this.f12933d;
    }

    public String e() {
        return this.f12916P;
    }

    public String e0() {
        return this.f12935e;
    }

    public String f() {
        return this.f12950s;
    }

    public String g() {
        return this.f12949r;
    }

    public boolean g0() {
        return this.f12932c0;
    }

    public String h() {
        return this.f12902B;
    }

    public boolean h0() {
        return this.f12906F;
    }

    public int i() {
        return this.f12918R;
    }

    public boolean i0() {
        return this.f12910J;
    }

    public int j() {
        return this.f12934d0;
    }

    public boolean j0() {
        return this.f12907G;
    }

    public int k() {
        return this.f12911K;
    }

    public boolean k0() {
        return this.f12926Z;
    }

    public int l() {
        return this.f12908H;
    }

    public boolean l0() {
        return new File(I()).exists();
    }

    public int m() {
        return this.f12947p;
    }

    public boolean m0() {
        return this.f12909I;
    }

    public int n() {
        return this.f12946o;
    }

    public boolean n0() {
        return this.f12928a0;
    }

    public int o() {
        return this.f12945n;
    }

    public boolean o0() {
        return this.f12914N;
    }

    public String p() {
        return this.f12941j;
    }

    public boolean p0() {
        return this.f12913M;
    }

    public int q() {
        return this.f12951t;
    }

    public boolean q0() {
        return this.f12905E;
    }

    public ArrayList r() {
        ArrayList arrayList = new ArrayList();
        Context context = f12899f0;
        Objects.requireNonNull(context);
        arrayList.add(context.getString(c.f12974q));
        arrayList.add("ESC;R;00 - USA");
        arrayList.add("ESC;R;01 - France");
        arrayList.add("ESC;R;02 - Germany");
        arrayList.add("ESC;R;03 - UK");
        arrayList.add("ESC;R;04 - Denmark I");
        arrayList.add("ESC;R;05 - Sweden");
        arrayList.add("ESC;R;06 - Italy");
        arrayList.add("ESC;R;07 - Spain");
        arrayList.add("ESC;R;08 - Japan");
        arrayList.add("ESC;R;09 - Norway");
        arrayList.add("ESC;R;0A - Denmark II");
        arrayList.add("ESC;R;0B - Spain II");
        arrayList.add("ESC;R;0C - Latin america");
        arrayList.add("ESC;R;0D - Korea");
        arrayList.add("ESC;R;0E - Ireland");
        return arrayList;
    }

    public boolean r0() {
        return this.f12930b0;
    }

    public ArrayList s() {
        ArrayList arrayList = new ArrayList();
        Context context = f12899f0;
        Objects.requireNonNull(context);
        arrayList.add(context.getString(c.f12958a));
        Context context2 = f12899f0;
        Objects.requireNonNull(context2);
        arrayList.add(context2.getString(c.f12973p));
        Context context3 = f12899f0;
        Objects.requireNonNull(context3);
        arrayList.add(context3.getString(c.f12966i));
        Context context4 = f12899f0;
        Objects.requireNonNull(context4);
        arrayList.add(context4.getString(c.f12968k));
        Context context5 = f12899f0;
        Objects.requireNonNull(context5);
        arrayList.add(context5.getString(c.f12969l));
        Context context6 = f12899f0;
        Objects.requireNonNull(context6);
        arrayList.add(context6.getString(c.f12970m));
        Context context7 = f12899f0;
        Objects.requireNonNull(context7);
        arrayList.add(context7.getString(c.f12967j));
        Context context8 = f12899f0;
        Objects.requireNonNull(context8);
        arrayList.add(context8.getString(c.f12971n));
        Context context9 = f12899f0;
        Objects.requireNonNull(context9);
        arrayList.add(context9.getString(c.f12972o));
        Context context10 = f12899f0;
        Objects.requireNonNull(context10);
        arrayList.add(context10.getString(c.f12965h));
        return arrayList;
    }

    public boolean s0() {
        return this.f12917Q;
    }

    public int t() {
        return this.f12903C;
    }

    public boolean t0() {
        return this.f12912L;
    }

    public int u() {
        return this.f12924X;
    }

    public void u0(boolean z3) {
        if (z3 == this.f12932c0) {
            return;
        }
        this.f12932c0 = z3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putBoolean("APP_RATE", this.f12932c0);
        editorEdit.commit();
    }

    public void v0(String str) {
        if (this.f12916P.equals(str)) {
            return;
        }
        this.f12916P = str;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putString("TEMPLATE_BOTTOM_TEXT", this.f12916P);
        editorEdit.commit();
    }

    public void w0(boolean z3) {
        if (this.f12906F == z3) {
            return;
        }
        this.f12906F = z3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putBoolean("MOZILA_TRUNCATE", this.f12906F);
        editorEdit.commit();
    }

    public ArrayList x() {
        ArrayList arrayList = new ArrayList();
        Context context = f12899f0;
        Objects.requireNonNull(context);
        arrayList.add(context.getString(c.f12976s));
        arrayList.add("Normal ESC;C1;0");
        arrayList.add("Condensed ESC;C1;1");
        arrayList.add("Mono width ESC;C1;2");
        return arrayList;
    }

    public void x0(int i3) {
        if (this.f12918R == i3) {
            return;
        }
        this.f12918R = i3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putInt("APP_PRINT_COPIES", this.f12918R);
        editorEdit.commit();
    }

    public ArrayList y() {
        ArrayList arrayList = new ArrayList();
        Context context = f12899f0;
        Objects.requireNonNull(context);
        arrayList.add(context.getString(c.f12975r));
        arrayList.add("Font A (12*24)");
        arrayList.add("Font B (9*17)");
        arrayList.add("Font C (8*16) not all printers");
        return arrayList;
    }

    public void y0(int i3) {
        this.f12934d0 = i3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putInt("APP_COUNTER", this.f12934d0);
        editorEdit.commit();
    }

    public int z() {
        return this.f12955x;
    }

    public void z0(boolean z3) {
        if (this.f12910J == z3) {
            return;
        }
        this.f12910J = z3;
        SharedPreferences.Editor editorEdit = this.f12936e0.edit();
        editorEdit.putBoolean("APP_CUT_FRAME", this.f12910J);
        editorEdit.commit();
    }
}
