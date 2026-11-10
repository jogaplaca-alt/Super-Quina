package p058r;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p049o.d;
import p049o.i;
import p061s.c;
import p061s.f;
import p061s.l;
import p061s.n;
import p061s.p;
import rawbt.api.Constant;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: K0, reason: collision with root package name */
    public static float f10637K0 = 0.5f;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    int f10639A0;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    boolean f10641B0;

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    boolean f10643C0;

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    public float[] f10645D0;

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    protected e[] f10647E0;

    /* JADX INFO: renamed from: F0, reason: collision with root package name */
    protected e[] f10649F0;

    /* JADX INFO: renamed from: G0, reason: collision with root package name */
    e f10651G0;

    /* JADX INFO: renamed from: H0, reason: collision with root package name */
    e f10653H0;

    /* JADX INFO: renamed from: I0, reason: collision with root package name */
    public int f10655I0;

    /* JADX INFO: renamed from: J0, reason: collision with root package name */
    public int f10657J0;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private boolean f10658K;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public d f10669V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public d[] f10670W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    protected ArrayList f10671X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    private boolean[] f10672Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public b[] f10673Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public e f10675a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    int f10677b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f10678c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    int f10679c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f10680d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f10681d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    protected int f10683e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    protected int f10685f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    protected int f10687g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    int f10689h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    int f10691i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    protected int f10693j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    protected int f10695k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    int f10697l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    protected int f10699m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    protected int f10701n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f10702o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    float f10703o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    float f10705p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private Object f10707q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f10709r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f10711s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private boolean f10713t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private String f10715u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private String f10717v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    boolean f10719w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    boolean f10721x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    boolean f10723y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    int f10725z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10674a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p[] f10676b = new p[2];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f10682e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f10684f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean[] f10686g = {true, true};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f10688h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10690i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f10692j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f10694k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f10696l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f10698m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public p055q.a f10700n = new p055q.a(this);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f10704p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f10706q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f10708r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f10710s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f10712t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10714u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f10716v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10718w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10720x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f10722y = new int[2];

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f10724z = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f10638A = 0;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public float f10640B = 1.0f;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f10642C = 0;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f10644D = 0;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public float f10646E = 1.0f;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    int f10648F = -1;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    float f10650G = 1.0f;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private int[] f10652H = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private float f10654I = 0.0f;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f10656J = false;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private boolean f10659L = false;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private int f10660M = 0;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private int f10661N = 0;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public d f10662O = new d(this, d.b.LEFT);

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public d f10663P = new d(this, d.b.TOP);

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public d f10664Q = new d(this, d.b.RIGHT);

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public d f10665R = new d(this, d.b.BOTTOM);

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public d f10666S = new d(this, d.b.BASELINE);

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    d f10667T = new d(this, d.b.CENTER_X);

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    d f10668U = new d(this, d.b.CENTER_Y);

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f10727b;

        static {
            int[] iArr = new int[b.values().length];
            f10727b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10727b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10727b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10727b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.b.values().length];
            f10726a = iArr2;
            try {
                iArr2[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10726a[d.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10726a[d.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10726a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10726a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10726a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f10726a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f10726a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f10726a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        d dVar = new d(this, d.b.CENTER);
        this.f10669V = dVar;
        this.f10670W = new d[]{this.f10662O, this.f10664Q, this.f10663P, this.f10665R, this.f10666S, dVar};
        this.f10671X = new ArrayList();
        this.f10672Y = new boolean[2];
        b bVar = b.FIXED;
        this.f10673Z = new b[]{bVar, bVar};
        this.f10675a0 = null;
        this.f10677b0 = 0;
        this.f10679c0 = 0;
        this.f10681d0 = 0.0f;
        this.f10683e0 = -1;
        this.f10685f0 = 0;
        this.f10687g0 = 0;
        this.f10689h0 = 0;
        this.f10691i0 = 0;
        this.f10693j0 = 0;
        this.f10695k0 = 0;
        this.f10697l0 = 0;
        float f3 = f10637K0;
        this.f10703o0 = f3;
        this.f10705p0 = f3;
        this.f10709r0 = 0;
        this.f10711s0 = 0;
        this.f10713t0 = false;
        this.f10715u0 = null;
        this.f10717v0 = null;
        this.f10723y0 = false;
        this.f10725z0 = 0;
        this.f10639A0 = 0;
        this.f10645D0 = new float[]{-1.0f, -1.0f};
        this.f10647E0 = new e[]{null, null};
        this.f10649F0 = new e[]{null, null};
        this.f10651G0 = null;
        this.f10653H0 = null;
        this.f10655I0 = -1;
        this.f10657J0 = -1;
        d();
    }

    private void P(StringBuilder sb, String str, int i3, int i4, int i5, int i6, int i7, int i8, float f3, float f4) {
        sb.append(str);
        sb.append(" :  {\n");
        y0(sb, "      size", i3, 0);
        y0(sb, "      min", i4, 0);
        y0(sb, "      max", i5, Integer.MAX_VALUE);
        y0(sb, "      matchMin", i7, 0);
        y0(sb, "      matchDef", i8, 0);
        x0(sb, "      matchPercent", f3, 1.0f);
        sb.append("    },\n");
    }

    private void Q(StringBuilder sb, String str, d dVar) {
        if (dVar.f10622f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(dVar.f10622f);
        sb.append("'");
        if (dVar.f10624h != Integer.MIN_VALUE || dVar.f10623g != 0) {
            sb.append(",");
            sb.append(dVar.f10623g);
            if (dVar.f10624h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(dVar.f10624h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    private void d() {
        this.f10671X.add(this.f10662O);
        this.f10671X.add(this.f10663P);
        this.f10671X.add(this.f10664Q);
        this.f10671X.add(this.f10665R);
        this.f10671X.add(this.f10667T);
        this.f10671X.add(this.f10668U);
        this.f10671X.add(this.f10669V);
        this.f10671X.add(this.f10666S);
    }

    private boolean f0(int i3) {
        d dVar;
        d dVar2;
        int i4 = i3 * 2;
        d[] dVarArr = this.f10670W;
        d dVar3 = dVarArr[i4];
        d dVar4 = dVar3.f10622f;
        return (dVar4 == null || dVar4.f10622f == dVar3 || (dVar2 = (dVar = dVarArr[i4 + 1]).f10622f) == null || dVar2.f10622f != dVar) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0188  */
    /* JADX WARN: Code duplicated, block: B:107:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:109:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:111:0x01d8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:239:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:241:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:247:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:250:0x0430  */
    /* JADX WARN: Code duplicated, block: B:258:0x0452  */
    /* JADX WARN: Code duplicated, block: B:268:0x0469  */
    /* JADX WARN: Code duplicated, block: B:271:0x0483  */
    /* JADX WARN: Code duplicated, block: B:281:0x049d  */
    /* JADX WARN: Code duplicated, block: B:284:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:285:0x04a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:305:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:307:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:309:0x04d6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:315:0x04ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:316:0x04f0  */
    /* JADX WARN: Code duplicated, block: B:317:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:319:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:320:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:322:0x0500 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:32:0x0088  */
    /* JADX WARN: Code duplicated, block: B:353:0x0548 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:35:0x0092  */
    /* JADX WARN: Code duplicated, block: B:36:0x0096  */
    /* JADX WARN: Code duplicated, block: B:372:0x057a  */
    /* JADX WARN: Code duplicated, block: B:383:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x009a  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:47:0x00bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:69:0x010a  */
    /* JADX WARN: Code duplicated, block: B:70:0x010c  */
    /* JADX WARN: Code duplicated, block: B:72:0x010f  */
    /* JADX WARN: Code duplicated, block: B:73:0x0111  */
    /* JADX WARN: Code duplicated, block: B:80:0x011c  */
    /* JADX WARN: Code duplicated, block: B:83:0x0126  */
    /* JADX WARN: Code duplicated, block: B:86:0x012b  */
    /* JADX WARN: Code duplicated, block: B:89:0x0134 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x0136  */
    /* JADX WARN: Code duplicated, block: B:91:0x013a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x013c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0144  */
    /* JADX WARN: Code duplicated, block: B:95:0x0159  */
    /* JADX WARN: Code duplicated, block: B:97:0x015c  */
    private void i(d dVar, boolean z3, boolean z4, boolean z5, boolean z6, i iVar, i iVar2, b bVar, boolean z7, d dVar2, d dVar3, int i3, int i4, int i5, int i6, float f3, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, int i7, int i8, int i9, int i10, float f4, boolean z13) {
        int i11;
        boolean z14;
        int i12;
        int i13;
        int i14;
        int iMin;
        int i15;
        int i16;
        int i17;
        boolean z15;
        d.b bVarK;
        d.b bVar2;
        i iVarQ;
        i iVarQ2;
        d dVar4;
        int i18;
        int i19;
        boolean z16;
        boolean z17;
        int i20;
        boolean z18;
        boolean z19;
        i iVar3;
        int i21;
        boolean z20;
        boolean z21;
        i iVar4;
        e eVar;
        e eVar2;
        i iVar5;
        e eVar3;
        int i22;
        int i23;
        int i24;
        i iVar6;
        int iF;
        int iF2;
        int iMin2;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        e eVar4;
        e eVar5;
        int i31 = i10;
        i iVarQ3 = dVar.q(dVar2);
        i iVarQ4 = dVar.q(dVar3);
        i iVarQ5 = dVar.q(dVar2.j());
        i iVarQ6 = dVar.q(dVar3.j());
        d.w();
        boolean zO = dVar2.o();
        boolean zO2 = dVar3.o();
        boolean zO3 = this.f10669V.o();
        int i32 = zO2 ? (zO ? 1 : 0) + 1 : zO ? 1 : 0;
        if (zO3) {
            i32++;
        }
        int i33 = z8 ? 3 : i7;
        int i34 = a.f10727b[bVar.ordinal()];
        if (i34 != 1 && i34 != 2 && i34 != 3 && i34 == 4) {
            i11 = i33;
            z14 = i11 != 4;
            i12 = this.f10696l;
            if (i12 != -1 && z3) {
                this.f10696l = -1;
                i4 = i12;
                z14 = false;
            }
            i13 = this.f10698m;
            if (i13 != -1 || z3) {
                i13 = i4;
            } else {
                this.f10698m = -1;
                z14 = false;
            }
            i14 = i13;
            if (this.f10711s0 == 8) {
                iMin = 0;
                z14 = false;
            } else {
                iMin = i14;
            }
            if (!z13) {
                if (zO && !zO2 && !zO3) {
                    dVar.f(iVarQ3, i3);
                } else if (!zO && !zO2) {
                    dVar.e(iVarQ3, iVarQ5, dVar2.f(), 8);
                }
            }
            if (!z14) {
                if (i32 == 2 && !z8 && (i11 == 1 || i11 == 0)) {
                    int iMax = Math.max(i9, iMin);
                    if (i31 > 0) {
                        iMax = Math.min(i31, iMax);
                    }
                    dVar.e(iVarQ4, iVarQ3, iMax, 8);
                    z15 = false;
                } else {
                    if (i9 == -2) {
                        i15 = iMin;
                    } else {
                        i15 = i9;
                    }
                    if (i31 == -2) {
                        i16 = iMin;
                    } else {
                        i16 = i31;
                    }
                    if (iMin > 0 && i11 != 1) {
                        iMin = 0;
                    }
                    if (i15 > 0) {
                        dVar.h(iVarQ4, iVarQ3, i15, 8);
                        iMin = Math.max(iMin, i15);
                    }
                    if (i16 > 0) {
                        if (z4 || i11 != 1) {
                            dVar.j(iVarQ4, iVarQ3, i16, 8);
                        }
                        iMin = Math.min(iMin, i16);
                    }
                    if (i11 == 1) {
                        if (z4) {
                            dVar.e(iVarQ4, iVarQ3, iMin, 8);
                        } else if (z10) {
                            dVar.e(iVarQ4, iVarQ3, iMin, 5);
                            dVar.j(iVarQ4, iVarQ3, iMin, 8);
                        } else {
                            dVar.e(iVarQ4, iVarQ3, iMin, 5);
                            dVar.j(iVarQ4, iVarQ3, iMin, 8);
                        }
                        i31 = i16;
                        i32 = i32 == true ? 1 : 0;
                        iVarQ4 = iVarQ4;
                        z15 = z14;
                        iVarQ6 = iVarQ6;
                        z6 = z6;
                        i17 = i15;
                        iVarQ5 = iVarQ5;
                    } else if (i11 == 2) {
                        bVarK = dVar2.k();
                        bVar2 = d.b.TOP;
                        if (bVarK != bVar2 || dVar2.k() == d.b.BOTTOM) {
                            iVarQ = dVar.q(this.f10675a0.o(bVar2));
                            iVarQ2 = dVar.q(this.f10675a0.o(d.b.BOTTOM));
                        } else {
                            iVarQ = dVar.q(this.f10675a0.o(d.b.LEFT));
                            iVarQ2 = dVar.q(this.f10675a0.o(d.b.RIGHT));
                        }
                        i iVar7 = iVarQ;
                        i iVar8 = iVarQ2;
                        p049o.b bVarR = dVar.r();
                        int i35 = i16;
                        i32 = i32 == true ? 1 : 0;
                        iVarQ6 = iVarQ6;
                        int i36 = i15;
                        iVarQ5 = iVarQ5;
                        iVarQ4 = iVarQ4;
                        dVar.d(bVarR.k(iVarQ4, iVarQ3, iVar8, iVar7, f4));
                        if (z4) {
                            z14 = false;
                        }
                        i31 = i35;
                        i17 = i36;
                        z15 = z14;
                        z6 = z6;
                    } else {
                        int i37 = i16;
                        int i38 = i15;
                        i32 = i32 == true ? 1 : 0;
                        iVarQ5 = iVarQ5;
                        iVarQ4 = iVarQ4;
                        iVarQ6 = iVarQ6;
                        i31 = i37;
                        i17 = i38;
                        z15 = z14;
                        z6 = true;
                    }
                }
                if (z13 || z10) {
                    if (i32 >= 2 && z4 && z6) {
                        dVar.h(iVarQ3, iVar, 0, 8);
                        boolean z22 = z3 || this.f10666S.f10622f == null;
                        if (!z3 && (dVar4 = this.f10666S.f10622f) != null) {
                            e eVar6 = dVar4.f10620d;
                            if (eVar6.f10681d0 != 0.0f) {
                                b[] bVarArr = eVar6.f10673Z;
                                b bVar3 = bVarArr[0];
                                b bVar4 = b.MATCH_CONSTRAINT;
                                if (bVar3 == bVar4 && bVarArr[1] == bVar4) {
                                    z22 = true;
                                } else {
                                    z22 = false;
                                }
                            } else {
                                z22 = false;
                            }
                        }
                        if (z22) {
                            dVar.h(iVar2, iVarQ4, 0, 8);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (zO || zO2 || zO3) {
                    if (!zO || zO2) {
                        if (!zO && zO2) {
                            dVar.e(iVarQ4, iVarQ6, -dVar3.f(), 8);
                            if (z4) {
                                if (this.f10692j && iVarQ3.f10305g && (eVar4 = this.f10675a0) != null) {
                                    f fVar = (f) eVar4;
                                    if (z3) {
                                        fVar.z1(dVar2);
                                    } else {
                                        fVar.E1(dVar2);
                                    }
                                } else {
                                    dVar.h(iVarQ3, iVar, 0, 5);
                                }
                            }
                        } else if (zO && zO2) {
                            e eVar7 = dVar2.f10622f.f10620d;
                            e eVar8 = dVar3.f10622f.f10620d;
                            e eVarK = K();
                            if (z15) {
                                if (i11 == 0) {
                                    if (i31 != 0 || i17 != 0) {
                                        i29 = 5;
                                        i30 = 5;
                                        z16 = true;
                                        z18 = false;
                                        z17 = true;
                                    } else if (iVarQ5.f10305g && iVarQ6.f10305g) {
                                        dVar.e(iVarQ3, iVarQ5, dVar2.f(), 8);
                                        dVar.e(iVarQ4, iVarQ6, -dVar3.f(), 8);
                                        return;
                                    } else {
                                        i29 = 8;
                                        i30 = 8;
                                        z16 = false;
                                        z18 = true;
                                        z17 = false;
                                    }
                                    if ((eVar7 instanceof p058r.a) || (eVar8 instanceof p058r.a)) {
                                        i18 = 6;
                                        i19 = 4;
                                    } else {
                                        i19 = i30;
                                        i18 = 6;
                                    }
                                    i20 = i29;
                                } else if (i11 == 2) {
                                    if (!(eVar7 instanceof p058r.a) && !(eVar8 instanceof p058r.a)) {
                                        iVar2 = iVar2;
                                        i18 = 6;
                                        i19 = 5;
                                    }
                                    i20 = 5;
                                    z17 = true;
                                    z16 = true;
                                    z18 = false;
                                } else if (i11 == 1) {
                                    iVar2 = iVar2;
                                    i18 = 6;
                                    i19 = 4;
                                    i20 = 8;
                                    z17 = true;
                                    z16 = true;
                                    z18 = false;
                                } else if (i11 == 3) {
                                    if (this.f10648F == -1) {
                                        if (z11) {
                                            iVar2 = iVar2;
                                            i18 = z4 ? 5 : 4;
                                        } else {
                                            iVar2 = iVar2;
                                            i18 = 8;
                                        }
                                        i19 = 5;
                                        i20 = 8;
                                    } else if (z8) {
                                        if (i8 == 2 || i8 == 1) {
                                            i27 = 5;
                                            i28 = 4;
                                        } else {
                                            i27 = 8;
                                            i28 = 5;
                                        }
                                        i20 = i27;
                                        i19 = i28;
                                        i18 = 6;
                                        z17 = true;
                                        z16 = true;
                                        z18 = true;
                                        iVar2 = iVar2;
                                    } else {
                                        if (i31 > 0) {
                                            i18 = 6;
                                            i19 = 5;
                                        } else if (i31 != 0 || i17 != 0) {
                                            i18 = 6;
                                            i19 = 4;
                                        } else if (z11) {
                                            iVar2 = iVar2;
                                            i20 = (eVar7 == eVarK || eVar8 == eVarK) ? 5 : 4;
                                            i18 = 6;
                                            i19 = 4;
                                        } else {
                                            i18 = 6;
                                            i19 = 8;
                                        }
                                        i20 = 5;
                                    }
                                    z17 = true;
                                    z16 = true;
                                    z18 = true;
                                } else {
                                    iVar2 = iVar2;
                                    i18 = 6;
                                    i19 = 4;
                                    i20 = 5;
                                    z17 = false;
                                    z16 = false;
                                    z18 = false;
                                }
                                if (z17 || iVarQ5 != iVarQ6 || eVar7 == eVarK) {
                                    z19 = true;
                                } else {
                                    z17 = false;
                                    z19 = false;
                                }
                                if (z16) {
                                    if (z15 && !z9 && !z11 && iVarQ5 == iVar && iVarQ6 == iVar2) {
                                        z20 = false;
                                        i20 = 8;
                                        i26 = 8;
                                        z19 = false;
                                    } else {
                                        i26 = i18;
                                        z20 = z4;
                                    }
                                    iVar3 = iVarQ5;
                                    i21 = 8;
                                    dVar.c(iVarQ3, iVar3, dVar2.f(), f3, iVarQ6, iVarQ4, dVar3.f(), i26);
                                } else {
                                    iVar3 = iVarQ5;
                                    i21 = 8;
                                    z20 = z4;
                                }
                                z21 = z19;
                                if (this.f10711s0 != i21 && !dVar3.m()) {
                                    return;
                                }
                                iVar4 = iVar3;
                                if (z17) {
                                    if (z20 || iVar4 == iVarQ6 || z15) {
                                        eVar = eVar8;
                                        eVar2 = eVar7;
                                    } else {
                                        eVar2 = eVar7;
                                        if (eVar2 instanceof p058r.a) {
                                            eVar = eVar8;
                                        } else {
                                            eVar = eVar8;
                                            if (eVar instanceof p058r.a) {
                                            }
                                            iVar5 = iVarQ3;
                                            dVar.h(iVar5, iVar4, dVar2.f(), i25);
                                            dVar.j(iVarQ4, iVarQ6, -dVar3.f(), i25);
                                            i20 = i25;
                                        }
                                        i25 = 6;
                                        iVar5 = iVarQ3;
                                        dVar.h(iVar5, iVar4, dVar2.f(), i25);
                                        dVar.j(iVarQ4, iVarQ6, -dVar3.f(), i25);
                                        i20 = i25;
                                    }
                                    i25 = i20;
                                    iVar5 = iVarQ3;
                                    dVar.h(iVar5, iVar4, dVar2.f(), i25);
                                    dVar.j(iVarQ4, iVarQ6, -dVar3.f(), i25);
                                    i20 = i25;
                                } else {
                                    eVar = eVar8;
                                    eVar2 = eVar7;
                                    iVar5 = iVarQ3;
                                }
                                if (z20 || !z12 || (eVar2 instanceof p058r.a) || (eVar instanceof p058r.a)) {
                                    eVar3 = eVarK;
                                } else {
                                    eVar3 = eVarK;
                                    if (eVar != eVar3) {
                                        z21 = true;
                                        i22 = 6;
                                        i23 = 6;
                                    }
                                    if (z21) {
                                        if (z18 || (z11 && !z5)) {
                                            iMin2 = i22;
                                        } else {
                                            int i39 = (eVar2 == eVar3 || eVar == eVar3) ? 6 : i22;
                                            if ((eVar2 instanceof h) || (eVar instanceof h)) {
                                                i39 = 5;
                                            }
                                            if ((eVar2 instanceof p058r.a) || (eVar instanceof p058r.a)) {
                                                i39 = 5;
                                            }
                                            if (z11) {
                                                i39 = 5;
                                            }
                                            iMin2 = Math.max(i39, i22);
                                        }
                                        if (z20) {
                                            iMin2 = Math.min(i23, iMin2);
                                            if (z8 && !z11 && (eVar2 == eVar3 || eVar == eVar3)) {
                                                iMin2 = 4;
                                            }
                                        }
                                        dVar.e(iVar5, iVar4, dVar2.f(), iMin2);
                                        dVar.e(iVarQ4, iVarQ6, -dVar3.f(), iMin2);
                                    }
                                    if (z20) {
                                        if (iVar == iVar4) {
                                            iF2 = dVar2.f();
                                        } else {
                                            iF2 = 0;
                                        }
                                        if (iVar4 != iVar) {
                                            i24 = 5;
                                            dVar.h(iVar5, iVar, iF2, 5);
                                        } else {
                                            i24 = 5;
                                        }
                                    } else {
                                        i24 = 5;
                                    }
                                    if (!z20 && z15) {
                                        iVar6 = iVarQ6;
                                        if (i5 == 0 && i17 == 0) {
                                            if (z15 && i11 == 3) {
                                                iF = 0;
                                                dVar.h(iVarQ4, iVar5, 0, i21);
                                            } else {
                                                iF = 0;
                                                dVar.h(iVarQ4, iVar5, 0, i24);
                                            }
                                        }
                                    }
                                    iF = 0;
                                }
                                i22 = i19;
                                i23 = i20;
                                if (z21) {
                                    if (z18) {
                                        iMin2 = i22;
                                    } else {
                                        iMin2 = i22;
                                    }
                                    if (z20) {
                                        iMin2 = Math.min(i23, iMin2);
                                        if (z8) {
                                            iMin2 = 4;
                                        }
                                    }
                                    dVar.e(iVar5, iVar4, dVar2.f(), iMin2);
                                    dVar.e(iVarQ4, iVarQ6, -dVar3.f(), iMin2);
                                }
                                if (z20) {
                                    i24 = 5;
                                } else {
                                    if (iVar == iVar4) {
                                        iF2 = dVar2.f();
                                    } else {
                                        iF2 = 0;
                                    }
                                    if (iVar4 != iVar) {
                                        i24 = 5;
                                        dVar.h(iVar5, iVar, iF2, 5);
                                    } else {
                                        i24 = 5;
                                    }
                                }
                                if (!z20) {
                                }
                            } else if (iVarQ5.f10305g && iVarQ6.f10305g) {
                                dVar.c(iVarQ3, iVarQ5, dVar2.f(), f3, iVarQ6, iVarQ4, dVar3.f(), 8);
                                if (z4 && z6) {
                                    int iF3 = dVar3.f10622f != null ? dVar3.f() : 0;
                                    if (iVarQ6 != iVar2) {
                                        dVar.h(iVar2, iVarQ4, iF3, 5);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            i18 = 6;
                            i19 = 4;
                            i20 = 5;
                            z17 = true;
                            z16 = true;
                            z18 = false;
                            if (z17) {
                                z19 = true;
                            } else {
                                z19 = true;
                            }
                            if (z16) {
                                if (z15) {
                                    i26 = i18;
                                    z20 = z4;
                                } else {
                                    i26 = i18;
                                    z20 = z4;
                                }
                                iVar3 = iVarQ5;
                                i21 = 8;
                                dVar.c(iVarQ3, iVar3, dVar2.f(), f3, iVarQ6, iVarQ4, dVar3.f(), i26);
                            } else {
                                iVar3 = iVarQ5;
                                i21 = 8;
                                z20 = z4;
                            }
                            z21 = z19;
                            if (this.f10711s0 != i21) {
                            }
                            iVar4 = iVar3;
                            if (z17) {
                                if (z20) {
                                    eVar = eVar8;
                                    eVar2 = eVar7;
                                    i25 = i20;
                                } else {
                                    eVar = eVar8;
                                    eVar2 = eVar7;
                                    i25 = i20;
                                }
                                iVar5 = iVarQ3;
                                dVar.h(iVar5, iVar4, dVar2.f(), i25);
                                dVar.j(iVarQ4, iVarQ6, -dVar3.f(), i25);
                                i20 = i25;
                            } else {
                                eVar = eVar8;
                                eVar2 = eVar7;
                                iVar5 = iVarQ3;
                            }
                            if (z20) {
                                eVar3 = eVarK;
                                i22 = i19;
                                i23 = i20;
                            } else {
                                eVar3 = eVarK;
                                i22 = i19;
                                i23 = i20;
                            }
                            if (z21) {
                                if (z18) {
                                    iMin2 = i22;
                                } else {
                                    iMin2 = i22;
                                }
                                if (z20) {
                                    iMin2 = Math.min(i23, iMin2);
                                    if (z8) {
                                        iMin2 = 4;
                                    }
                                }
                                dVar.e(iVar5, iVar4, dVar2.f(), iMin2);
                                dVar.e(iVarQ4, iVarQ6, -dVar3.f(), iMin2);
                            }
                            if (z20) {
                                i24 = 5;
                            } else {
                                if (iVar == iVar4) {
                                    iF2 = dVar2.f();
                                } else {
                                    iF2 = 0;
                                }
                                if (iVar4 != iVar) {
                                    i24 = 5;
                                    dVar.h(iVar5, iVar, iF2, 5);
                                } else {
                                    i24 = 5;
                                }
                            }
                            if (!z20) {
                            }
                        }
                        iVar6 = iVarQ6;
                        i24 = 5;
                        iF = 0;
                        z20 = z4;
                    } else {
                        z20 = z4;
                        i24 = (z4 && (dVar2.f10622f.f10620d instanceof p058r.a)) ? 8 : 5;
                    }
                    iVar6 = iVarQ6;
                    iF = 0;
                } else {
                    iVar6 = iVarQ6;
                    i24 = 5;
                    iF = 0;
                    z20 = z4;
                }
                if (z20 && z6) {
                    if (dVar3.f10622f != null) {
                        iF = dVar3.f();
                    }
                    if (iVar6 != iVar2) {
                        if (!this.f10692j || !iVarQ4.f10305g || (eVar5 = this.f10675a0) == null) {
                            dVar.h(iVar2, iVarQ4, iF, i24);
                            return;
                        }
                        f fVar2 = (f) eVar5;
                        if (z3) {
                            fVar2.y1(dVar3);
                            return;
                        } else {
                            fVar2.D1(dVar3);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (z7) {
                dVar.e(iVarQ4, iVarQ3, 0, 3);
                if (i5 > 0) {
                    dVar.h(iVarQ4, iVarQ3, i5, 8);
                }
                if (i6 < Integer.MAX_VALUE) {
                    dVar.j(iVarQ4, iVarQ3, i6, 8);
                }
            } else {
                dVar.e(iVarQ4, iVarQ3, iMin, 8);
            }
            z15 = z14;
            i17 = i9;
            if (z13) {
            }
            if (i32 >= 2) {
            }
        }
        i11 = i33;
        i12 = this.f10696l;
        if (i12 != -1) {
            this.f10696l = -1;
            i4 = i12;
            z14 = false;
        }
        i13 = this.f10698m;
        if (i13 != -1) {
            i13 = i4;
        } else {
            i13 = i4;
        }
        i14 = i13;
        if (this.f10711s0 == 8) {
            iMin = 0;
            z14 = false;
        } else {
            iMin = i14;
        }
        if (!z13) {
            if (zO) {
                if (!zO) {
                }
            } else if (!zO) {
            }
        }
        if (!z14) {
            if (i32 == 2) {
            }
            if (i9 == -2) {
                i15 = iMin;
            } else {
                i15 = i9;
            }
            if (i31 == -2) {
                i16 = iMin;
            } else {
                i16 = i31;
            }
            if (iMin > 0) {
                iMin = 0;
            }
            if (i15 > 0) {
                dVar.h(iVarQ4, iVarQ3, i15, 8);
                iMin = Math.max(iMin, i15);
            }
            if (i16 > 0) {
                if (z4) {
                    dVar.j(iVarQ4, iVarQ3, i16, 8);
                } else {
                    dVar.j(iVarQ4, iVarQ3, i16, 8);
                }
                iMin = Math.min(iMin, i16);
            }
            if (i11 == 1) {
                if (z4) {
                    dVar.e(iVarQ4, iVarQ3, iMin, 8);
                } else if (z10) {
                    dVar.e(iVarQ4, iVarQ3, iMin, 5);
                    dVar.j(iVarQ4, iVarQ3, iMin, 8);
                } else {
                    dVar.e(iVarQ4, iVarQ3, iMin, 5);
                    dVar.j(iVarQ4, iVarQ3, iMin, 8);
                }
                i31 = i16;
                i32 = i32 == true ? 1 : 0;
                iVarQ4 = iVarQ4;
                z15 = z14;
                iVarQ6 = iVarQ6;
                z6 = z6;
                i17 = i15;
                iVarQ5 = iVarQ5;
            } else if (i11 == 2) {
                bVarK = dVar2.k();
                bVar2 = d.b.TOP;
                if (bVarK != bVar2) {
                    iVarQ = dVar.q(this.f10675a0.o(bVar2));
                    iVarQ2 = dVar.q(this.f10675a0.o(d.b.BOTTOM));
                } else {
                    iVarQ = dVar.q(this.f10675a0.o(bVar2));
                    iVarQ2 = dVar.q(this.f10675a0.o(d.b.BOTTOM));
                }
                i iVar9 = iVarQ;
                i iVar10 = iVarQ2;
                p049o.b bVarR2 = dVar.r();
                int i310 = i16;
                i32 = i32 == true ? 1 : 0;
                iVarQ6 = iVarQ6;
                int i311 = i15;
                iVarQ5 = iVarQ5;
                iVarQ4 = iVarQ4;
                dVar.d(bVarR2.k(iVarQ4, iVarQ3, iVar10, iVar9, f4));
                if (z4) {
                    z14 = false;
                }
                i31 = i310;
                i17 = i311;
                z15 = z14;
                z6 = z6;
            } else {
                int i312 = i16;
                int i313 = i15;
                i32 = i32 == true ? 1 : 0;
                iVarQ5 = iVarQ5;
                iVarQ4 = iVarQ4;
                iVarQ6 = iVarQ6;
                i31 = i312;
                i17 = i313;
                z15 = z14;
                z6 = true;
            }
            if (z13) {
            }
            if (i32 >= 2) {
            }
        }
        if (z7) {
            dVar.e(iVarQ4, iVarQ3, 0, 3);
            if (i5 > 0) {
                dVar.h(iVarQ4, iVarQ3, i5, 8);
            }
            if (i6 < Integer.MAX_VALUE) {
                dVar.j(iVarQ4, iVarQ3, i6, 8);
            }
        } else {
            dVar.e(iVarQ4, iVarQ3, iMin, 8);
        }
        z15 = z14;
        i17 = i9;
        if (z13) {
        }
        if (i32 >= 2) {
        }
    }

    private void x0(StringBuilder sb, String str, float f3, float f4) {
        if (f3 == f4) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f3);
        sb.append(",\n");
    }

    private void y0(StringBuilder sb, String str, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i3);
        sb.append(",\n");
    }

    private void z0(StringBuilder sb, String str, float f3, int i3) {
        if (f3 == 0.0f) {
            return;
        }
        sb.append(str);
        sb.append(" :  [");
        sb.append(f3);
        sb.append(",");
        sb.append(i3);
        sb.append("");
        sb.append("],\n");
    }

    public b A() {
        return this.f10673Z[0];
    }

    public void A0(int i3) {
        this.f10697l0 = i3;
        this.f10656J = i3 > 0;
    }

    public int B() {
        d dVar = this.f10662O;
        int i3 = dVar != null ? dVar.f10623g : 0;
        d dVar2 = this.f10664Q;
        return dVar2 != null ? i3 + dVar2.f10623g : i3;
    }

    public void B0(Object obj) {
        this.f10707q0 = obj;
    }

    public int C() {
        return this.f10660M;
    }

    public void C0(String str) {
        this.f10715u0 = str;
    }

    public int D() {
        return this.f10661N;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0087 A[PHI: r0
      0x0087: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:39:0x0086, B:36:0x007f, B:24:0x0051, B:26:0x0057, B:28:0x0063, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0087 -> B:41:0x0088). Please report as a decompilation issue!!! */
    public void D0(String str) {
        float fAbs;
        int i3 = 0;
        if (str == null || str.length() == 0) {
            this.f10681d0 = 0.0f;
            return;
        }
        int length = str.length();
        int iIndexOf = str.indexOf(44);
        int i4 = 0;
        int i5 = -1;
        if (iIndexOf > 0 && iIndexOf < length - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            if (!strSubstring.equalsIgnoreCase("W")) {
                i4 = strSubstring.equalsIgnoreCase("H") ? 1 : -1;
            }
            i5 = i4;
            i4 = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(58);
        try {
            if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                String strSubstring2 = str.substring(i4);
                if (strSubstring2.length() > 0) {
                    fAbs = Float.parseFloat(strSubstring2);
                } else {
                    fAbs = 0.0f;
                }
            } else {
                String strSubstring3 = str.substring(i4, iIndexOf2);
                String strSubstring4 = str.substring(iIndexOf2 + 1);
                if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                    fAbs = 0.0f;
                } else {
                    float f3 = Float.parseFloat(strSubstring3);
                    float f4 = Float.parseFloat(strSubstring4);
                    if (f3 <= 0.0f || f4 <= 0.0f) {
                        fAbs = 0.0f;
                    } else {
                        fAbs = i5 == 1 ? Math.abs(f4 / f3) : Math.abs(f3 / f4);
                    }
                }
            }
        } catch (NumberFormatException unused) {
        }
        i3 = (fAbs > i3 ? 1 : (fAbs == i3 ? 0 : -1));
        if (i3 > 0) {
            this.f10681d0 = fAbs;
            this.f10683e0 = i5;
        }
    }

    public int E(int i3) {
        if (i3 == 0) {
            return W();
        }
        if (i3 == 1) {
            return x();
        }
        return 0;
    }

    public void E0(int i3) {
        if (this.f10656J) {
            int i4 = i3 - this.f10697l0;
            int i5 = this.f10679c0 + i4;
            this.f10687g0 = i4;
            this.f10663P.t(i4);
            this.f10665R.t(i5);
            this.f10666S.t(i3);
            this.f10706q = true;
        }
    }

    public int F() {
        return this.f10652H[1];
    }

    public void F0(int i3, int i4) {
        if (this.f10704p) {
            return;
        }
        this.f10662O.t(i3);
        this.f10664Q.t(i4);
        this.f10685f0 = i3;
        this.f10677b0 = i4 - i3;
        this.f10704p = true;
    }

    public int G() {
        return this.f10652H[0];
    }

    public void G0(int i3) {
        this.f10662O.t(i3);
        this.f10685f0 = i3;
    }

    public int H() {
        return this.f10701n0;
    }

    public void H0(int i3) {
        this.f10663P.t(i3);
        this.f10687g0 = i3;
    }

    public int I() {
        return this.f10699m0;
    }

    public void I0(int i3, int i4) {
        if (this.f10706q) {
            return;
        }
        this.f10663P.t(i3);
        this.f10665R.t(i4);
        this.f10687g0 = i3;
        this.f10679c0 = i4 - i3;
        if (this.f10656J) {
            this.f10666S.t(i3 + this.f10697l0);
        }
        this.f10706q = true;
    }

    public e J(int i3) {
        d dVar;
        d dVar2;
        if (i3 != 0) {
            if (i3 == 1 && (dVar2 = (dVar = this.f10665R).f10622f) != null && dVar2.f10622f == dVar) {
                return dVar2.f10620d;
            }
            return null;
        }
        d dVar3 = this.f10664Q;
        d dVar4 = dVar3.f10622f;
        if (dVar4 == null || dVar4.f10622f != dVar3) {
            return null;
        }
        return dVar4.f10620d;
    }

    public void J0(int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9 = i5 - i3;
        int i10 = i6 - i4;
        this.f10685f0 = i3;
        this.f10687g0 = i4;
        if (this.f10711s0 == 8) {
            this.f10677b0 = 0;
            this.f10679c0 = 0;
            return;
        }
        b[] bVarArr = this.f10673Z;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i9 < (i8 = this.f10677b0)) {
            i9 = i8;
        }
        if (bVarArr[1] == bVar2 && i10 < (i7 = this.f10679c0)) {
            i10 = i7;
        }
        this.f10677b0 = i9;
        this.f10679c0 = i10;
        int i11 = this.f10701n0;
        if (i10 < i11) {
            this.f10679c0 = i11;
        }
        int i12 = this.f10699m0;
        if (i9 < i12) {
            this.f10677b0 = i12;
        }
        int i13 = this.f10638A;
        if (i13 > 0 && bVar == b.MATCH_CONSTRAINT) {
            this.f10677b0 = Math.min(this.f10677b0, i13);
        }
        int i14 = this.f10644D;
        if (i14 > 0 && this.f10673Z[1] == b.MATCH_CONSTRAINT) {
            this.f10679c0 = Math.min(this.f10679c0, i14);
        }
        int i15 = this.f10677b0;
        if (i9 != i15) {
            this.f10696l = i15;
        }
        int i16 = this.f10679c0;
        if (i10 != i16) {
            this.f10698m = i16;
        }
    }

    public e K() {
        return this.f10675a0;
    }

    public void K0(boolean z3) {
        this.f10656J = z3;
    }

    public e L(int i3) {
        d dVar;
        d dVar2;
        if (i3 != 0) {
            if (i3 == 1 && (dVar2 = (dVar = this.f10663P).f10622f) != null && dVar2.f10622f == dVar) {
                return dVar2.f10620d;
            }
            return null;
        }
        d dVar3 = this.f10662O;
        d dVar4 = dVar3.f10622f;
        if (dVar4 == null || dVar4.f10622f != dVar3) {
            return null;
        }
        return dVar4.f10620d;
    }

    public void L0(int i3) {
        this.f10679c0 = i3;
        int i4 = this.f10701n0;
        if (i3 < i4) {
            this.f10679c0 = i4;
        }
    }

    public int M() {
        return X() + this.f10677b0;
    }

    public void M0(float f3) {
        this.f10703o0 = f3;
    }

    public p N(int i3) {
        if (i3 == 0) {
            return this.f10682e;
        }
        if (i3 == 1) {
            return this.f10684f;
        }
        return null;
    }

    public void N0(int i3) {
        this.f10725z0 = i3;
    }

    public void O(StringBuilder sb) {
        sb.append("  " + this.f10702o + ":{\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    actualWidth:");
        sb2.append(this.f10677b0);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.f10679c0);
        sb.append("\n");
        sb.append("    actualLeft:" + this.f10685f0);
        sb.append("\n");
        sb.append("    actualTop:" + this.f10687g0);
        sb.append("\n");
        Q(sb, Constant.ALIGNMENT_LEFT, this.f10662O);
        Q(sb, "top", this.f10663P);
        Q(sb, Constant.ALIGNMENT_RIGHT, this.f10664Q);
        Q(sb, "bottom", this.f10665R);
        Q(sb, "baseline", this.f10666S);
        Q(sb, "centerX", this.f10667T);
        Q(sb, "centerY", this.f10668U);
        P(sb, "    width", this.f10677b0, this.f10699m0, this.f10652H[0], this.f10696l, this.f10724z, this.f10718w, this.f10640B, this.f10645D0[0]);
        P(sb, "    height", this.f10679c0, this.f10701n0, this.f10652H[1], this.f10698m, this.f10642C, this.f10720x, this.f10646E, this.f10645D0[1]);
        z0(sb, "    dimensionRatio", this.f10681d0, this.f10683e0);
        x0(sb, "    horizontalBias", this.f10703o0, f10637K0);
        x0(sb, "    verticalBias", this.f10705p0, f10637K0);
        y0(sb, "    horizontalChainStyle", this.f10725z0, 0);
        y0(sb, "    verticalChainStyle", this.f10639A0, 0);
        sb.append("  }");
    }

    public void O0(int i3, int i4) {
        this.f10685f0 = i3;
        int i5 = i4 - i3;
        this.f10677b0 = i5;
        int i6 = this.f10699m0;
        if (i5 < i6) {
            this.f10677b0 = i6;
        }
    }

    public void P0(b bVar) {
        this.f10673Z[0] = bVar;
    }

    public void Q0(int i3, int i4, int i5, float f3) {
        this.f10718w = i3;
        this.f10724z = i4;
        if (i5 == Integer.MAX_VALUE) {
            i5 = 0;
        }
        this.f10638A = i5;
        this.f10640B = f3;
        if (f3 <= 0.0f || f3 >= 1.0f || i3 != 0) {
            return;
        }
        this.f10718w = 2;
    }

    public float R() {
        return this.f10705p0;
    }

    public void R0(float f3) {
        this.f10645D0[0] = f3;
    }

    public int S() {
        return this.f10639A0;
    }

    protected void S0(int i3, boolean z3) {
        this.f10672Y[i3] = z3;
    }

    public b T() {
        return this.f10673Z[1];
    }

    public void T0(boolean z3) {
        this.f10658K = z3;
    }

    public int U() {
        int i3 = this.f10662O != null ? this.f10663P.f10623g : 0;
        return this.f10664Q != null ? i3 + this.f10665R.f10623g : i3;
    }

    public void U0(boolean z3) {
        this.f10659L = z3;
    }

    public int V() {
        return this.f10711s0;
    }

    public void V0(int i3, int i4) {
        this.f10660M = i3;
        this.f10661N = i4;
        Y0(false);
    }

    public int W() {
        if (this.f10711s0 == 8) {
            return 0;
        }
        return this.f10677b0;
    }

    public void W0(int i3) {
        this.f10652H[1] = i3;
    }

    public int X() {
        e eVar = this.f10675a0;
        return (eVar == null || !(eVar instanceof f)) ? this.f10685f0 : ((f) eVar).f10739S0 + this.f10685f0;
    }

    public void X0(int i3) {
        this.f10652H[0] = i3;
    }

    public int Y() {
        e eVar = this.f10675a0;
        return (eVar == null || !(eVar instanceof f)) ? this.f10687g0 : ((f) eVar).f10740T0 + this.f10687g0;
    }

    public void Y0(boolean z3) {
        this.f10690i = z3;
    }

    public boolean Z() {
        return this.f10656J;
    }

    public void Z0(int i3) {
        if (i3 < 0) {
            this.f10701n0 = 0;
        } else {
            this.f10701n0 = i3;
        }
    }

    public boolean a0(int i3) {
        if (i3 == 0) {
            return (this.f10662O.f10622f != null ? 1 : 0) + (this.f10664Q.f10622f != null ? 1 : 0) < 2;
        }
        return ((this.f10663P.f10622f != null ? 1 : 0) + (this.f10665R.f10622f != null ? 1 : 0)) + (this.f10666S.f10622f != null ? 1 : 0) < 2;
    }

    public void a1(int i3) {
        if (i3 < 0) {
            this.f10699m0 = 0;
        } else {
            this.f10699m0 = i3;
        }
    }

    public boolean b0() {
        int size = this.f10671X.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((d) this.f10671X.get(i3)).m()) {
                return true;
            }
        }
        return false;
    }

    public void b1(int i3, int i4) {
        this.f10685f0 = i3;
        this.f10687g0 = i4;
    }

    public boolean c0() {
        return (this.f10696l == -1 && this.f10698m == -1) ? false : true;
    }

    public void c1(e eVar) {
        this.f10675a0 = eVar;
    }

    public boolean d0(int i3, int i4) {
        d dVar;
        d dVar2;
        if (i3 == 0) {
            d dVar3 = this.f10662O.f10622f;
            return dVar3 != null && dVar3.n() && (dVar2 = this.f10664Q.f10622f) != null && dVar2.n() && (this.f10664Q.f10622f.e() - this.f10664Q.f()) - (this.f10662O.f10622f.e() + this.f10662O.f()) >= i4;
        }
        d dVar4 = this.f10663P.f10622f;
        return dVar4 != null && dVar4.n() && (dVar = this.f10665R.f10622f) != null && dVar.n() && (this.f10665R.f10622f.e() - this.f10665R.f()) - (this.f10663P.f10622f.e() + this.f10663P.f()) >= i4;
        return false;
    }

    public void d1(float f3) {
        this.f10705p0 = f3;
    }

    public void e(f fVar, d dVar, HashSet hashSet, int i3, boolean z3) {
        if (z3) {
            if (!hashSet.contains(this)) {
                return;
            }
            k.a(fVar, dVar, this);
            hashSet.remove(this);
            g(dVar, fVar.T1(64));
        }
        if (i3 == 0) {
            HashSet hashSetD = this.f10662O.d();
            if (hashSetD != null) {
                Iterator it = hashSetD.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).f10620d.e(fVar, dVar, hashSet, i3, true);
                }
            }
            HashSet hashSetD2 = this.f10664Q.d();
            if (hashSetD2 != null) {
                Iterator it2 = hashSetD2.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).f10620d.e(fVar, dVar, hashSet, i3, true);
                }
                return;
            }
            return;
        }
        HashSet hashSetD3 = this.f10663P.d();
        if (hashSetD3 != null) {
            Iterator it3 = hashSetD3.iterator();
            while (it3.hasNext()) {
                ((d) it3.next()).f10620d.e(fVar, dVar, hashSet, i3, true);
            }
        }
        HashSet hashSetD4 = this.f10665R.d();
        if (hashSetD4 != null) {
            Iterator it4 = hashSetD4.iterator();
            while (it4.hasNext()) {
                ((d) it4.next()).f10620d.e(fVar, dVar, hashSet, i3, true);
            }
        }
        HashSet hashSetD5 = this.f10666S.d();
        if (hashSetD5 != null) {
            Iterator it5 = hashSetD5.iterator();
            while (it5.hasNext()) {
                ((d) it5.next()).f10620d.e(fVar, dVar, hashSet, i3, true);
            }
        }
    }

    public void e0(d.b bVar, e eVar, d.b bVar2, int i3, int i4) {
        o(bVar).b(eVar.o(bVar2), i3, i4, true);
    }

    public void e1(int i3) {
        this.f10639A0 = i3;
    }

    boolean f() {
        return (this instanceof l) || (this instanceof h);
    }

    public void f1(int i3, int i4) {
        this.f10687g0 = i3;
        int i5 = i4 - i3;
        this.f10679c0 = i5;
        int i6 = this.f10701n0;
        if (i5 < i6) {
            this.f10679c0 = i6;
        }
    }

    /* JADX WARN: Code duplicated, block: B:194:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:19:0x004f  */
    /* JADX WARN: Code duplicated, block: B:200:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:202:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:203:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:215:0x0318  */
    /* JADX WARN: Code duplicated, block: B:227:0x0370  */
    /* JADX WARN: Code duplicated, block: B:230:0x038a  */
    /* JADX WARN: Code duplicated, block: B:231:0x0392  */
    /* JADX WARN: Code duplicated, block: B:234:0x0398  */
    /* JADX WARN: Code duplicated, block: B:235:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:238:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:239:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:242:0x0429  */
    /* JADX WARN: Code duplicated, block: B:244:0x042f  */
    /* JADX WARN: Code duplicated, block: B:259:0x048d  */
    /* JADX WARN: Code duplicated, block: B:263:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:264:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:266:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:304:0x0585  */
    /* JADX WARN: Code duplicated, block: B:307:0x058d  */
    /* JADX WARN: Code duplicated, block: B:309:0x0594  */
    /* JADX WARN: Code duplicated, block: B:310:0x05a4  */
    /* JADX WARN: Code duplicated, block: B:313:0x05bb  */
    public void g(d dVar, boolean z3) {
        boolean z4;
        boolean z5;
        e eVar;
        e eVar2;
        boolean z6;
        boolean z7;
        int i3;
        int i4;
        boolean z8;
        int i5;
        boolean z9;
        b bVar;
        b bVar2;
        boolean z10;
        int i6;
        i iVar;
        i iVar2;
        int i7;
        int i8;
        char c3;
        e eVar3;
        boolean z11;
        boolean z12;
        boolean z13;
        n nVar;
        f fVar;
        e eVar4;
        i iVarQ;
        e eVar5;
        i iVarQ2;
        b[] bVarArr;
        boolean z14;
        l lVar;
        int i9;
        int i10;
        boolean zI0;
        boolean zK0;
        l lVar2;
        n nVar2;
        i iVarQ3 = dVar.q(this.f10662O);
        i iVarQ4 = dVar.q(this.f10664Q);
        i iVarQ5 = dVar.q(this.f10663P);
        i iVarQ6 = dVar.q(this.f10665R);
        i iVarQ7 = dVar.q(this.f10666S);
        e eVar6 = this.f10675a0;
        if (eVar6 == null) {
            z4 = false;
            z5 = false;
        } else {
            boolean z15 = eVar6 != null && eVar6.f10673Z[0] == b.WRAP_CONTENT;
            boolean z16 = eVar6 != null && eVar6.f10673Z[1] == b.WRAP_CONTENT;
            int i11 = this.f10716v;
            if (i11 == 1) {
                z4 = z15;
                z5 = false;
            } else if (i11 == 2) {
                z5 = z16;
                z4 = false;
            } else if (i11 != 3) {
                z5 = z16;
                z4 = z15;
            } else {
                z4 = false;
                z5 = false;
            }
        }
        if (this.f10711s0 == 8 && !this.f10713t0 && !b0()) {
            boolean[] zArr = this.f10672Y;
            if (!zArr[0] && !zArr[1]) {
                return;
            }
        }
        boolean z17 = this.f10704p;
        if (z17 || this.f10706q) {
            if (z17) {
                dVar.f(iVarQ3, this.f10685f0);
                dVar.f(iVarQ4, this.f10685f0 + this.f10677b0);
                if (z4 && (eVar2 = this.f10675a0) != null) {
                    if (this.f10694k) {
                        f fVar2 = (f) eVar2;
                        fVar2.z1(this.f10662O);
                        fVar2.y1(this.f10664Q);
                    } else {
                        dVar.h(dVar.q(eVar2.f10664Q), iVarQ4, 0, 5);
                    }
                }
            }
            if (this.f10706q) {
                dVar.f(iVarQ5, this.f10687g0);
                dVar.f(iVarQ6, this.f10687g0 + this.f10679c0);
                if (this.f10666S.m()) {
                    dVar.f(iVarQ7, this.f10687g0 + this.f10697l0);
                }
                if (z5 && (eVar = this.f10675a0) != null) {
                    if (this.f10694k) {
                        f fVar3 = (f) eVar;
                        fVar3.E1(this.f10663P);
                        fVar3.D1(this.f10665R);
                    } else {
                        dVar.h(dVar.q(eVar.f10665R), iVarQ6, 0, 5);
                    }
                }
            }
            if (this.f10704p && this.f10706q) {
                this.f10704p = false;
                this.f10706q = false;
                return;
            }
        }
        boolean z18 = d.f10260r;
        if (z3 && (lVar2 = this.f10682e) != null && (nVar2 = this.f10684f) != null) {
            f fVar4 = lVar2.f11698h;
            if (fVar4.f11647j && lVar2.f11699i.f11647j && nVar2.f11698h.f11647j && nVar2.f11699i.f11647j) {
                dVar.f(iVarQ3, fVar4.f11644g);
                dVar.f(iVarQ4, this.f10682e.f11699i.f11644g);
                dVar.f(iVarQ5, this.f10684f.f11698h.f11644g);
                dVar.f(iVarQ6, this.f10684f.f11699i.f11644g);
                dVar.f(iVarQ7, this.f10684f.f11673k.f11644g);
                if (this.f10675a0 != null) {
                    if (z4 && this.f10686g[0] && !i0()) {
                        dVar.h(dVar.q(this.f10675a0.f10664Q), iVarQ4, 0, 8);
                    }
                    if (z5 && this.f10686g[1] && !k0()) {
                        dVar.h(dVar.q(this.f10675a0.f10665R), iVarQ6, 0, 8);
                    }
                }
                this.f10704p = false;
                this.f10706q = false;
                return;
            }
        }
        if (this.f10675a0 != null) {
            if (f0(0)) {
                ((f) this.f10675a0).v1(this, 0);
                zI0 = true;
            } else {
                zI0 = i0();
            }
            if (f0(1)) {
                ((f) this.f10675a0).v1(this, 1);
                zK0 = true;
            } else {
                zK0 = k0();
            }
            if (!zI0 && z4 && this.f10711s0 != 8 && this.f10662O.f10622f == null && this.f10664Q.f10622f == null) {
                dVar.h(dVar.q(this.f10675a0.f10664Q), iVarQ4, 0, 1);
            }
            if (!zK0 && z5 && this.f10711s0 != 8 && this.f10663P.f10622f == null && this.f10665R.f10622f == null && this.f10666S == null) {
                dVar.h(dVar.q(this.f10675a0.f10665R), iVarQ6, 0, 1);
            }
            z7 = zI0;
            z6 = zK0;
        } else {
            z6 = false;
            z7 = false;
        }
        int i12 = this.f10677b0;
        int i13 = this.f10699m0;
        if (i12 >= i13) {
            i13 = i12;
        }
        int i14 = this.f10679c0;
        int i15 = this.f10701n0;
        if (i14 >= i15) {
            i15 = i14;
        }
        b[] bVarArr2 = this.f10673Z;
        b bVar3 = bVarArr2[0];
        b bVar4 = b.MATCH_CONSTRAINT;
        int i16 = i13;
        boolean z19 = bVar3 != bVar4;
        b bVar5 = bVarArr2[1];
        int i17 = i15;
        i iVar3 = iVarQ7;
        boolean z20 = bVar5 != bVar4;
        int i18 = this.f10683e0;
        this.f10648F = i18;
        i iVar4 = iVarQ6;
        float f3 = this.f10681d0;
        this.f10650G = f3;
        i iVar5 = iVarQ5;
        int i19 = this.f10718w;
        int i20 = this.f10720x;
        if (f3 <= 0.0f || this.f10711s0 == 8) {
            i19 = i19;
            i20 = i20;
            i3 = i16;
            i4 = i17;
            z8 = false;
        } else {
            if (bVar3 == bVar4 && i19 == 0) {
                i19 = 3;
            }
            if (bVar5 == bVar4 && i20 == 0) {
                i20 = 3;
            }
            if (bVar3 == bVar4 && bVar5 == bVar4) {
                i10 = 3;
                if (i19 == 3 && i20 == 3) {
                    o1(z4, z5, z19, z20);
                }
                i3 = i16;
                i4 = i17;
                z8 = true;
            } else {
                i10 = 3;
            }
            if (bVar3 == bVar4 && i19 == i10) {
                this.f10648F = 0;
                i3 = (int) (f3 * i14);
                if (bVar5 != bVar4) {
                    i20 = i20;
                    i4 = i17;
                    z8 = false;
                    i19 = 4;
                } else {
                    i4 = i17;
                    z8 = true;
                }
            } else if (bVar5 == bVar4 && i20 == i10) {
                this.f10648F = 1;
                if (i18 == -1) {
                    this.f10650G = 1.0f / f3;
                }
                i4 = (int) (this.f10650G * i12);
                i19 = i19;
                if (bVar3 != bVar4) {
                    i3 = i16;
                    z8 = false;
                    i20 = 4;
                } else {
                    i20 = i20;
                    i3 = i16;
                    z8 = true;
                }
            } else {
                i3 = i16;
                i4 = i17;
                z8 = true;
            }
        }
        int[] iArr = this.f10722y;
        iArr[0] = i19;
        iArr[1] = i20;
        this.f10688h = z8;
        if (z8) {
            int i21 = this.f10648F;
            i5 = -1;
            boolean z21 = i21 == 0 || i21 == -1;
            if (z8 || !((i9 = this.f10648F) == 1 || i9 == i5)) {
                z9 = false;
            } else {
                z9 = true;
            }
            bVar = this.f10673Z[0];
            bVar2 = b.WRAP_CONTENT;
            if (bVar == bVar2 || !(this instanceof f)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                i6 = 0;
            } else {
                i6 = i3;
            }
            boolean z22 = !this.f10669V.o();
            boolean[] zArr2 = this.f10672Y;
            boolean z23 = zArr2[0];
            boolean z24 = zArr2[1];
            if (this.f10712t != 2 || this.f10704p) {
                iVar = iVarQ4;
                iVar2 = iVarQ3;
            } else if (!z3 || (lVar = this.f10682e) == null) {
                eVar4 = this.f10675a0;
                if (eVar4 != null) {
                    iVarQ = dVar.q(eVar4.f10664Q);
                } else {
                    iVarQ = null;
                }
                eVar5 = this.f10675a0;
                if (eVar5 != null) {
                    iVarQ2 = dVar.q(eVar5.f10662O);
                } else {
                    iVarQ2 = null;
                }
                boolean z25 = this.f10686g[0];
                bVarArr = this.f10673Z;
                b bVar6 = bVarArr[0];
                d dVar2 = this.f10662O;
                d dVar3 = this.f10664Q;
                int i22 = this.f10685f0;
                int i23 = this.f10699m0;
                int i24 = this.f10652H[0];
                float f4 = this.f10703o0;
                if (bVarArr[1] == bVar4) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                iVar = iVarQ4;
                iVar2 = iVarQ3;
                i(dVar, true, z4, z5, z25, iVarQ2, iVarQ, bVar6, z10, dVar2, dVar3, i22, i6, i23, i24, f4, z21, z14, z7, z6, z23, i19, i20, this.f10724z, this.f10638A, this.f10640B, z22);
            } else {
                f fVar5 = lVar.f11698h;
                if (!fVar5.f11647j || !lVar.f11699i.f11647j) {
                    eVar4 = this.f10675a0;
                    if (eVar4 != null) {
                        iVarQ = dVar.q(eVar4.f10664Q);
                    } else {
                        iVarQ = null;
                    }
                    eVar5 = this.f10675a0;
                    if (eVar5 != null) {
                        iVarQ2 = dVar.q(eVar5.f10662O);
                    } else {
                        iVarQ2 = null;
                    }
                    boolean z26 = this.f10686g[0];
                    bVarArr = this.f10673Z;
                    b bVar7 = bVarArr[0];
                    d dVar4 = this.f10662O;
                    d dVar5 = this.f10664Q;
                    int i25 = this.f10685f0;
                    int i26 = this.f10699m0;
                    int i27 = this.f10652H[0];
                    float f5 = this.f10703o0;
                    if (bVarArr[1] == bVar4) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    iVar = iVarQ4;
                    iVar2 = iVarQ3;
                    i(dVar, true, z4, z5, z26, iVarQ2, iVarQ, bVar7, z10, dVar4, dVar5, i25, i6, i26, i27, f5, z21, z14, z7, z6, z23, i19, i20, this.f10724z, this.f10638A, this.f10640B, z22);
                } else if (z3) {
                    dVar.f(iVarQ3, fVar5.f11644g);
                    dVar.f(iVarQ4, this.f10682e.f11699i.f11644g);
                    if (this.f10675a0 != null && z4 && this.f10686g[0] && !i0()) {
                        dVar.h(dVar.q(this.f10675a0.f10664Q), iVarQ4, 0, 8);
                    }
                    iVar = iVarQ4;
                    iVar2 = iVarQ3;
                } else {
                    iVar = iVarQ4;
                    iVar2 = iVarQ3;
                }
            }
            if (z3) {
                eVar3 = this;
                nVar = eVar3.f10684f;
                if (nVar != null) {
                    fVar = nVar.f11698h;
                    if (!fVar.f11647j && nVar.f11699i.f11647j) {
                        dVar = dVar;
                        iVar5 = iVar5;
                        dVar.f(iVar5, fVar.f11644g);
                        iVar4 = iVar4;
                        dVar.f(iVar4, eVar3.f10684f.f11699i.f11644g);
                        iVar3 = iVar3;
                        dVar.f(iVar3, eVar3.f10684f.f11673k.f11644g);
                        e eVar7 = eVar3.f10675a0;
                        if (eVar7 == null || z6 || !z5) {
                            i7 = 8;
                            i8 = 0;
                            c3 = 1;
                        } else {
                            c3 = 1;
                            if (eVar3.f10686g[1]) {
                                i7 = 8;
                                i8 = 0;
                                dVar.h(dVar.q(eVar7.f10665R), iVar4, 0, 8);
                            } else {
                                i7 = 8;
                                i8 = 0;
                            }
                        }
                        z11 = false;
                    }
                    if (eVar3.f10714u == 2) {
                        z12 = false;
                    } else {
                        z12 = z11;
                    }
                    if (!z12 && !eVar3.f10706q) {
                        boolean z27 = eVar3.f10673Z[c3] == bVar2 && (eVar3 instanceof f);
                        if (z27) {
                            i4 = 0;
                        }
                        e eVar8 = eVar3.f10675a0;
                        i iVarQ8 = eVar8 != null ? dVar.q(eVar8.f10665R) : null;
                        e eVar9 = eVar3.f10675a0;
                        i iVarQ9 = eVar9 != null ? dVar.q(eVar9.f10663P) : null;
                        if (eVar3.f10697l0 > 0 || eVar3.f10711s0 == i7) {
                            d dVar6 = eVar3.f10666S;
                            if (dVar6.f10622f != null) {
                                dVar.e(iVar3, iVar5, p(), i7);
                                dVar.e(iVar3, dVar.q(eVar3.f10666S.f10622f), eVar3.f10666S.f(), i7);
                                if (z5 != 0) {
                                    dVar.h(iVarQ8, dVar.q(eVar3.f10665R), i8, 5);
                                }
                                z13 = false;
                            } else {
                                if (eVar3.f10711s0 == i7) {
                                    dVar.e(iVar3, iVar5, dVar6.f(), i7);
                                } else {
                                    dVar.e(iVar3, iVar5, p(), i7);
                                }
                                z13 = z22;
                            }
                        } else {
                            z13 = z22;
                        }
                        boolean z28 = eVar3.f10686g[c3];
                        b[] bVarArr3 = eVar3.f10673Z;
                        i(dVar, false, z5, z4, z28, iVarQ9, iVarQ8, bVarArr3[c3], z27, eVar3.f10663P, eVar3.f10665R, eVar3.f10687g0, i4, eVar3.f10701n0, eVar3.f10652H[c3], eVar3.f10705p0, z9, bVarArr3[0] == bVar4, z6, z7, z24, i20, i19, eVar3.f10642C, eVar3.f10644D, eVar3.f10646E, z13);
                    }
                    if (z8) {
                        if (this.f10648F == 1) {
                            dVar.k(iVar4, iVar5, iVar, iVar2, this.f10650G, 8);
                        } else {
                            dVar.k(iVar, iVar2, iVar4, iVar5, this.f10650G, 8);
                        }
                    }
                    if (this.f10669V.o()) {
                        dVar.b(this, this.f10669V.j().h(), (float) Math.toRadians(this.f10654I + 90.0f), this.f10669V.f());
                    }
                    this.f10704p = false;
                    this.f10706q = false;
                }
                i7 = 8;
                i8 = 0;
                c3 = 1;
            } else {
                i7 = 8;
                i8 = 0;
                c3 = 1;
                eVar3 = this;
            }
            z11 = true;
            if (eVar3.f10714u == 2) {
                z12 = false;
            } else {
                z12 = z11;
            }
            if (!z12) {
            }
            if (z8) {
                if (this.f10648F == 1) {
                    dVar.k(iVar4, iVar5, iVar, iVar2, this.f10650G, 8);
                } else {
                    dVar.k(iVar, iVar2, iVar4, iVar5, this.f10650G, 8);
                }
            }
            if (this.f10669V.o()) {
                dVar.b(this, this.f10669V.j().h(), (float) Math.toRadians(this.f10654I + 90.0f), this.f10669V.f());
            }
            this.f10704p = false;
            this.f10706q = false;
        }
        i5 = -1;
        if (z8) {
            z9 = false;
        } else {
            z9 = false;
        }
        bVar = this.f10673Z[0];
        bVar2 = b.WRAP_CONTENT;
        if (bVar == bVar2) {
            z10 = false;
        } else {
            z10 = false;
        }
        if (z10) {
            i6 = 0;
        } else {
            i6 = i3;
        }
        boolean z29 = !this.f10669V.o();
        boolean[] zArr3 = this.f10672Y;
        boolean z210 = zArr3[0];
        boolean z211 = zArr3[1];
        if (this.f10712t != 2) {
            iVar = iVarQ4;
            iVar2 = iVarQ3;
        } else {
            iVar = iVarQ4;
            iVar2 = iVarQ3;
        }
        if (z3) {
            eVar3 = this;
            nVar = eVar3.f10684f;
            if (nVar != null) {
                fVar = nVar.f11698h;
                if (!fVar.f11647j) {
                }
            }
            i7 = 8;
            i8 = 0;
            c3 = 1;
        } else {
            i7 = 8;
            i8 = 0;
            c3 = 1;
            eVar3 = this;
        }
        z11 = true;
        if (eVar3.f10714u == 2) {
            z12 = false;
        } else {
            z12 = z11;
        }
        if (!z12) {
        }
        if (z8) {
            if (this.f10648F == 1) {
                dVar.k(iVar4, iVar5, iVar, iVar2, this.f10650G, 8);
            } else {
                dVar.k(iVar, iVar2, iVar4, iVar5, this.f10650G, 8);
            }
        }
        if (this.f10669V.o()) {
            dVar.b(this, this.f10669V.j().h(), (float) Math.toRadians(this.f10654I + 90.0f), this.f10669V.f());
        }
        this.f10704p = false;
        this.f10706q = false;
    }

    public boolean g0() {
        return this.f10708r;
    }

    public void g1(b bVar) {
        this.f10673Z[1] = bVar;
    }

    public boolean h() {
        return this.f10711s0 != 8;
    }

    public boolean h0(int i3) {
        return this.f10672Y[i3];
    }

    public void h1(int i3, int i4, int i5, float f3) {
        this.f10720x = i3;
        this.f10642C = i4;
        if (i5 == Integer.MAX_VALUE) {
            i5 = 0;
        }
        this.f10644D = i5;
        this.f10646E = f3;
        if (f3 <= 0.0f || f3 >= 1.0f || i3 != 0) {
            return;
        }
        this.f10720x = 2;
    }

    public boolean i0() {
        d dVar = this.f10662O;
        d dVar2 = dVar.f10622f;
        if (dVar2 != null && dVar2.f10622f == dVar) {
            return true;
        }
        d dVar3 = this.f10664Q;
        d dVar4 = dVar3.f10622f;
        return dVar4 != null && dVar4.f10622f == dVar3;
    }

    public void i1(float f3) {
        this.f10645D0[1] = f3;
    }

    public void j(d.b bVar, e eVar, d.b bVar2, int i3) {
        d.b bVar3;
        d.b bVar4;
        boolean z3;
        d.b bVar5 = d.b.CENTER;
        if (bVar == bVar5) {
            if (bVar2 != bVar5) {
                d.b bVar6 = d.b.LEFT;
                if (bVar2 == bVar6 || bVar2 == d.b.RIGHT) {
                    j(bVar6, eVar, bVar2, 0);
                    j(d.b.RIGHT, eVar, bVar2, 0);
                    o(bVar5).a(eVar.o(bVar2), 0);
                    return;
                }
                d.b bVar7 = d.b.TOP;
                if (bVar2 == bVar7 || bVar2 == d.b.BOTTOM) {
                    j(bVar7, eVar, bVar2, 0);
                    j(d.b.BOTTOM, eVar, bVar2, 0);
                    o(bVar5).a(eVar.o(bVar2), 0);
                    return;
                }
                return;
            }
            d.b bVar8 = d.b.LEFT;
            d dVarO = o(bVar8);
            d.b bVar9 = d.b.RIGHT;
            d dVarO2 = o(bVar9);
            d.b bVar10 = d.b.TOP;
            d dVarO3 = o(bVar10);
            d.b bVar11 = d.b.BOTTOM;
            d dVarO4 = o(bVar11);
            boolean z4 = true;
            if ((dVarO == null || !dVarO.o()) && (dVarO2 == null || !dVarO2.o())) {
                j(bVar8, eVar, bVar8, 0);
                j(bVar9, eVar, bVar9, 0);
                z3 = true;
            } else {
                z3 = false;
            }
            if ((dVarO3 == null || !dVarO3.o()) && (dVarO4 == null || !dVarO4.o())) {
                j(bVar10, eVar, bVar10, 0);
                j(bVar11, eVar, bVar11, 0);
            } else {
                z4 = false;
            }
            if (z3 && z4) {
                o(bVar5).a(eVar.o(bVar5), 0);
                return;
            }
            if (z3) {
                d.b bVar12 = d.b.CENTER_X;
                o(bVar12).a(eVar.o(bVar12), 0);
                return;
            } else {
                if (z4) {
                    d.b bVar13 = d.b.CENTER_Y;
                    o(bVar13).a(eVar.o(bVar13), 0);
                    return;
                }
                return;
            }
        }
        d.b bVar14 = d.b.CENTER_X;
        if (bVar == bVar14 && (bVar2 == (bVar4 = d.b.LEFT) || bVar2 == d.b.RIGHT)) {
            d dVarO5 = o(bVar4);
            d dVarO6 = eVar.o(bVar2);
            d dVarO7 = o(d.b.RIGHT);
            dVarO5.a(dVarO6, 0);
            dVarO7.a(dVarO6, 0);
            o(bVar14).a(dVarO6, 0);
            return;
        }
        d.b bVar15 = d.b.CENTER_Y;
        if (bVar == bVar15 && (bVar2 == (bVar3 = d.b.TOP) || bVar2 == d.b.BOTTOM)) {
            d dVarO8 = eVar.o(bVar2);
            o(bVar3).a(dVarO8, 0);
            o(d.b.BOTTOM).a(dVarO8, 0);
            o(bVar15).a(dVarO8, 0);
            return;
        }
        if (bVar == bVar14 && bVar2 == bVar14) {
            d.b bVar16 = d.b.LEFT;
            o(bVar16).a(eVar.o(bVar16), 0);
            d.b bVar17 = d.b.RIGHT;
            o(bVar17).a(eVar.o(bVar17), 0);
            o(bVar14).a(eVar.o(bVar2), 0);
            return;
        }
        if (bVar == bVar15 && bVar2 == bVar15) {
            d.b bVar18 = d.b.TOP;
            o(bVar18).a(eVar.o(bVar18), 0);
            d.b bVar19 = d.b.BOTTOM;
            o(bVar19).a(eVar.o(bVar19), 0);
            o(bVar15).a(eVar.o(bVar2), 0);
            return;
        }
        d dVarO9 = o(bVar);
        d dVarO10 = eVar.o(bVar2);
        if (dVarO9.p(dVarO10)) {
            d.b bVar20 = d.b.BASELINE;
            if (bVar == bVar20) {
                d dVarO11 = o(d.b.TOP);
                d dVarO12 = o(d.b.BOTTOM);
                if (dVarO11 != null) {
                    dVarO11.q();
                }
                if (dVarO12 != null) {
                    dVarO12.q();
                }
            } else if (bVar == d.b.TOP || bVar == d.b.BOTTOM) {
                d dVarO13 = o(bVar20);
                if (dVarO13 != null) {
                    dVarO13.q();
                }
                d dVarO14 = o(bVar5);
                if (dVarO14.j() != dVarO10) {
                    dVarO14.q();
                }
                d dVarG = o(bVar).g();
                d dVarO15 = o(bVar15);
                if (dVarO15.o()) {
                    dVarG.q();
                    dVarO15.q();
                }
            } else if (bVar == d.b.LEFT || bVar == d.b.RIGHT) {
                d dVarO16 = o(bVar5);
                if (dVarO16.j() != dVarO10) {
                    dVarO16.q();
                }
                d dVarG2 = o(bVar).g();
                d dVarO17 = o(bVar14);
                if (dVarO17.o()) {
                    dVarG2.q();
                    dVarO17.q();
                }
            }
            dVarO9.a(dVarO10, i3);
        }
    }

    public boolean j0() {
        return this.f10658K;
    }

    public void j1(int i3) {
        this.f10711s0 = i3;
    }

    public void k(d dVar, d dVar2, int i3) {
        if (dVar.h() == this) {
            j(dVar.k(), dVar2.h(), dVar2.k(), i3);
        }
    }

    public boolean k0() {
        d dVar = this.f10663P;
        d dVar2 = dVar.f10622f;
        if (dVar2 != null && dVar2.f10622f == dVar) {
            return true;
        }
        d dVar3 = this.f10665R;
        d dVar4 = dVar3.f10622f;
        return dVar4 != null && dVar4.f10622f == dVar3;
    }

    public void k1(int i3) {
        this.f10677b0 = i3;
        int i4 = this.f10699m0;
        if (i3 < i4) {
            this.f10677b0 = i4;
        }
    }

    public void l(e eVar, float f3, int i3) {
        d.b bVar = d.b.CENTER;
        e0(bVar, eVar, bVar, i3, 0);
        this.f10654I = f3;
    }

    public boolean l0() {
        return this.f10659L;
    }

    public void l1(int i3) {
        if (i3 < 0 || i3 > 3) {
            return;
        }
        this.f10716v = i3;
    }

    public void m(d dVar) {
        dVar.q(this.f10662O);
        dVar.q(this.f10663P);
        dVar.q(this.f10664Q);
        dVar.q(this.f10665R);
        if (this.f10697l0 > 0) {
            dVar.q(this.f10666S);
        }
    }

    public boolean m0() {
        return this.f10690i && this.f10711s0 != 8;
    }

    public void m1(int i3) {
        this.f10685f0 = i3;
    }

    public void n() {
        if (this.f10682e == null) {
            this.f10682e = new l(this);
        }
        if (this.f10684f == null) {
            this.f10684f = new n(this);
        }
    }

    public boolean n0() {
        return this.f10704p || (this.f10662O.n() && this.f10664Q.n());
    }

    public void n1(int i3) {
        this.f10687g0 = i3;
    }

    public d o(d.b bVar) {
        switch (a.f10726a[bVar.ordinal()]) {
            case 1:
                return this.f10662O;
            case 2:
                return this.f10663P;
            case 3:
                return this.f10664Q;
            case 4:
                return this.f10665R;
            case 5:
                return this.f10666S;
            case 6:
                return this.f10669V;
            case 7:
                return this.f10667T;
            case 8:
                return this.f10668U;
            case 9:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public boolean o0() {
        return this.f10706q || (this.f10663P.n() && this.f10665R.n());
    }

    public void o1(boolean z3, boolean z4, boolean z5, boolean z6) {
        if (this.f10648F == -1) {
            if (z5 && !z6) {
                this.f10648F = 0;
            } else if (!z5 && z6) {
                this.f10648F = 1;
                if (this.f10683e0 == -1) {
                    this.f10650G = 1.0f / this.f10650G;
                }
            }
        }
        if (this.f10648F == 0 && (!this.f10663P.o() || !this.f10665R.o())) {
            this.f10648F = 1;
        } else if (this.f10648F == 1 && (!this.f10662O.o() || !this.f10664Q.o())) {
            this.f10648F = 0;
        }
        if (this.f10648F == -1 && (!this.f10663P.o() || !this.f10665R.o() || !this.f10662O.o() || !this.f10664Q.o())) {
            if (this.f10663P.o() && this.f10665R.o()) {
                this.f10648F = 0;
            } else if (this.f10662O.o() && this.f10664Q.o()) {
                this.f10650G = 1.0f / this.f10650G;
                this.f10648F = 1;
            }
        }
        if (this.f10648F == -1) {
            int i3 = this.f10724z;
            if (i3 > 0 && this.f10642C == 0) {
                this.f10648F = 0;
            } else {
                if (i3 != 0 || this.f10642C <= 0) {
                    return;
                }
                this.f10650G = 1.0f / this.f10650G;
                this.f10648F = 1;
            }
        }
    }

    public int p() {
        return this.f10697l0;
    }

    public boolean p0() {
        return this.f10710s;
    }

    public void p1(boolean z3, boolean z4) {
        int i3;
        int i4;
        boolean zK = z3 & this.f10682e.k();
        boolean zK2 = z4 & this.f10684f.k();
        l lVar = this.f10682e;
        int i5 = lVar.f11698h.f11644g;
        n nVar = this.f10684f;
        int i6 = nVar.f11698h.f11644g;
        int i7 = lVar.f11699i.f11644g;
        int i8 = nVar.f11699i.f11644g;
        int i9 = i8 - i6;
        if (i7 - i5 < 0 || i9 < 0 || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE || i8 == Integer.MIN_VALUE || i8 == Integer.MAX_VALUE) {
            i7 = 0;
            i5 = 0;
            i8 = 0;
            i6 = 0;
        }
        int i10 = i7 - i5;
        int i11 = i8 - i6;
        if (zK) {
            this.f10685f0 = i5;
        }
        if (zK2) {
            this.f10687g0 = i6;
        }
        if (this.f10711s0 == 8) {
            this.f10677b0 = 0;
            this.f10679c0 = 0;
            return;
        }
        if (zK) {
            if (this.f10673Z[0] == b.FIXED && i10 < (i4 = this.f10677b0)) {
                i10 = i4;
            }
            this.f10677b0 = i10;
            int i12 = this.f10699m0;
            if (i10 < i12) {
                this.f10677b0 = i12;
            }
        }
        if (zK2) {
            if (this.f10673Z[1] == b.FIXED && i11 < (i3 = this.f10679c0)) {
                i11 = i3;
            }
            this.f10679c0 = i11;
            int i13 = this.f10701n0;
            if (i11 < i13) {
                this.f10679c0 = i13;
            }
        }
    }

    public float q(int i3) {
        if (i3 == 0) {
            return this.f10703o0;
        }
        if (i3 == 1) {
            return this.f10705p0;
        }
        return -1.0f;
    }

    public void q0() {
        this.f10708r = true;
    }

    public void q1(d dVar, boolean z3) {
        n nVar;
        l lVar;
        int iX = dVar.x(this.f10662O);
        int iX2 = dVar.x(this.f10663P);
        int iX3 = dVar.x(this.f10664Q);
        int iX4 = dVar.x(this.f10665R);
        if (z3 && (lVar = this.f10682e) != null) {
            f fVar = lVar.f11698h;
            if (fVar.f11647j) {
                f fVar2 = lVar.f11699i;
                if (fVar2.f11647j) {
                    iX = fVar.f11644g;
                    iX3 = fVar2.f11644g;
                }
            }
        }
        if (z3 && (nVar = this.f10684f) != null) {
            f fVar3 = nVar.f11698h;
            if (fVar3.f11647j) {
                f fVar4 = nVar.f11699i;
                if (fVar4.f11647j) {
                    iX2 = fVar3.f11644g;
                    iX4 = fVar4.f11644g;
                }
            }
        }
        int i3 = iX4 - iX2;
        if (iX3 - iX < 0 || i3 < 0 || iX == Integer.MIN_VALUE || iX == Integer.MAX_VALUE || iX2 == Integer.MIN_VALUE || iX2 == Integer.MAX_VALUE || iX3 == Integer.MIN_VALUE || iX3 == Integer.MAX_VALUE || iX4 == Integer.MIN_VALUE || iX4 == Integer.MAX_VALUE) {
            iX = 0;
            iX4 = 0;
            iX2 = 0;
            iX3 = 0;
        }
        J0(iX, iX2, iX3, iX4);
    }

    public int r() {
        return Y() + this.f10679c0;
    }

    public void r0() {
        this.f10710s = true;
    }

    public Object s() {
        return this.f10707q0;
    }

    public boolean s0() {
        b[] bVarArr = this.f10673Z;
        b bVar = bVarArr[0];
        b bVar2 = b.MATCH_CONSTRAINT;
        return bVar == bVar2 && bVarArr[1] == bVar2;
    }

    public String t() {
        return this.f10715u0;
    }

    public void t0() {
        this.f10662O.q();
        this.f10663P.q();
        this.f10664Q.q();
        this.f10665R.q();
        this.f10666S.q();
        this.f10667T.q();
        this.f10668U.q();
        this.f10669V.q();
        this.f10675a0 = null;
        this.f10654I = 0.0f;
        this.f10677b0 = 0;
        this.f10679c0 = 0;
        this.f10681d0 = 0.0f;
        this.f10683e0 = -1;
        this.f10685f0 = 0;
        this.f10687g0 = 0;
        this.f10693j0 = 0;
        this.f10695k0 = 0;
        this.f10697l0 = 0;
        this.f10699m0 = 0;
        this.f10701n0 = 0;
        float f3 = f10637K0;
        this.f10703o0 = f3;
        this.f10705p0 = f3;
        b[] bVarArr = this.f10673Z;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.f10707q0 = null;
        this.f10709r0 = 0;
        this.f10711s0 = 0;
        this.f10717v0 = null;
        this.f10719w0 = false;
        this.f10721x0 = false;
        this.f10725z0 = 0;
        this.f10639A0 = 0;
        this.f10641B0 = false;
        this.f10643C0 = false;
        float[] fArr = this.f10645D0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f10712t = -1;
        this.f10714u = -1;
        int[] iArr = this.f10652H;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f10718w = 0;
        this.f10720x = 0;
        this.f10640B = 1.0f;
        this.f10646E = 1.0f;
        this.f10638A = Integer.MAX_VALUE;
        this.f10644D = Integer.MAX_VALUE;
        this.f10724z = 0;
        this.f10642C = 0;
        this.f10688h = false;
        this.f10648F = -1;
        this.f10650G = 1.0f;
        this.f10723y0 = false;
        boolean[] zArr = this.f10686g;
        zArr[0] = true;
        zArr[1] = true;
        this.f10659L = false;
        boolean[] zArr2 = this.f10672Y;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f10690i = true;
        int[] iArr2 = this.f10722y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f10696l = -1;
        this.f10698m = -1;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.f10717v0 != null) {
            str = "type: " + this.f10717v0 + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.f10715u0 != null) {
            str2 = "id: " + this.f10715u0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.f10685f0);
        sb.append(", ");
        sb.append(this.f10687g0);
        sb.append(") - (");
        sb.append(this.f10677b0);
        sb.append(" x ");
        sb.append(this.f10679c0);
        sb.append(")");
        return sb.toString();
    }

    public b u(int i3) {
        if (i3 == 0) {
            return A();
        }
        if (i3 == 1) {
            return T();
        }
        return null;
    }

    public void u0() {
        e eVarK = K();
        if (eVarK != null && (eVarK instanceof f) && ((f) K()).L1()) {
            return;
        }
        int size = this.f10671X.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((d) this.f10671X.get(i3)).q();
        }
    }

    public float v() {
        return this.f10681d0;
    }

    public void v0() {
        this.f10704p = false;
        this.f10706q = false;
        this.f10708r = false;
        this.f10710s = false;
        int size = this.f10671X.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((d) this.f10671X.get(i3)).r();
        }
    }

    public int w() {
        return this.f10683e0;
    }

    public void w0(p049o.c cVar) {
        this.f10662O.s(cVar);
        this.f10663P.s(cVar);
        this.f10664Q.s(cVar);
        this.f10665R.s(cVar);
        this.f10666S.s(cVar);
        this.f10669V.s(cVar);
        this.f10667T.s(cVar);
        this.f10668U.s(cVar);
    }

    public int x() {
        if (this.f10711s0 == 8) {
            return 0;
        }
        return this.f10679c0;
    }

    public float y() {
        return this.f10703o0;
    }

    public int z() {
        return this.f10725z0;
    }
}
