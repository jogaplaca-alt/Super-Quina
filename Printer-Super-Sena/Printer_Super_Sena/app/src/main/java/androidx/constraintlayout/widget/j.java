package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f3862f = {0, 4, 8};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static SparseIntArray f3863g = new SparseIntArray();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static SparseIntArray f3864h = new SparseIntArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3865a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3866b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap f3867c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3868d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap f3869e = new HashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f3871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f3872c = new d();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f3873d = new c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f3874e = new b();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final e f3875f = new e();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public HashMap f3876g = new HashMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        C0049a f3877h;

        /* JADX INFO: renamed from: androidx.constraintlayout.widget.j$a$a, reason: collision with other inner class name */
        static class C0049a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int[] f3878a = new int[10];

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int[] f3879b = new int[10];

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f3880c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int[] f3881d = new int[10];

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            float[] f3882e = new float[10];

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f3883f = 0;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            int[] f3884g = new int[5];

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            String[] f3885h = new String[5];

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            int f3886i = 0;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int[] f3887j = new int[4];

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            boolean[] f3888k = new boolean[4];

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            int f3889l = 0;

            C0049a() {
            }

            void a(int i3, float f3) {
                int i4 = this.f3883f;
                int[] iArr = this.f3881d;
                if (i4 >= iArr.length) {
                    this.f3881d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f3882e;
                    this.f3882e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f3881d;
                int i5 = this.f3883f;
                iArr2[i5] = i3;
                float[] fArr2 = this.f3882e;
                this.f3883f = i5 + 1;
                fArr2[i5] = f3;
            }

            void b(int i3, int i4) {
                int i5 = this.f3880c;
                int[] iArr = this.f3878a;
                if (i5 >= iArr.length) {
                    this.f3878a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f3879b;
                    this.f3879b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f3878a;
                int i6 = this.f3880c;
                iArr3[i6] = i3;
                int[] iArr4 = this.f3879b;
                this.f3880c = i6 + 1;
                iArr4[i6] = i4;
            }

            void c(int i3, String str) {
                int i4 = this.f3886i;
                int[] iArr = this.f3884g;
                if (i4 >= iArr.length) {
                    this.f3884g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f3885h;
                    this.f3885h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f3884g;
                int i5 = this.f3886i;
                iArr2[i5] = i3;
                String[] strArr2 = this.f3885h;
                this.f3886i = i5 + 1;
                strArr2[i5] = str;
            }

            void d(int i3, boolean z3) {
                int i4 = this.f3889l;
                int[] iArr = this.f3887j;
                if (i4 >= iArr.length) {
                    this.f3887j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f3888k;
                    this.f3888k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f3887j;
                int i5 = this.f3889l;
                iArr2[i5] = i3;
                boolean[] zArr2 = this.f3888k;
                this.f3889l = i5 + 1;
                zArr2[i5] = z3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(int i3, ConstraintLayout.b bVar) {
            this.f3870a = i3;
            b bVar2 = this.f3874e;
            bVar2.f3935j = bVar.f3766e;
            bVar2.f3937k = bVar.f3768f;
            bVar2.f3939l = bVar.f3770g;
            bVar2.f3941m = bVar.f3772h;
            bVar2.f3943n = bVar.f3774i;
            bVar2.f3945o = bVar.f3776j;
            bVar2.f3947p = bVar.f3778k;
            bVar2.f3949q = bVar.f3780l;
            bVar2.f3951r = bVar.f3782m;
            bVar2.f3952s = bVar.f3784n;
            bVar2.f3953t = bVar.f3786o;
            bVar2.f3954u = bVar.f3794s;
            bVar2.f3955v = bVar.f3796t;
            bVar2.f3956w = bVar.f3798u;
            bVar2.f3957x = bVar.f3800v;
            bVar2.f3958y = bVar.f3738G;
            bVar2.f3959z = bVar.f3739H;
            bVar2.f3891A = bVar.f3740I;
            bVar2.f3892B = bVar.f3788p;
            bVar2.f3893C = bVar.f3790q;
            bVar2.f3894D = bVar.f3792r;
            bVar2.f3895E = bVar.f3755X;
            bVar2.f3896F = bVar.f3756Y;
            bVar2.f3897G = bVar.f3757Z;
            bVar2.f3931h = bVar.f3762c;
            bVar2.f3927f = bVar.f3758a;
            bVar2.f3929g = bVar.f3760b;
            bVar2.f3923d = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar2.f3925e = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar2.f3898H = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar2.f3899I = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar2.f3900J = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar2.f3901K = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar2.f3904N = bVar.f3735D;
            bVar2.f3912V = bVar.f3744M;
            bVar2.f3913W = bVar.f3743L;
            bVar2.f3915Y = bVar.f3746O;
            bVar2.f3914X = bVar.f3745N;
            bVar2.f3944n0 = bVar.f3759a0;
            bVar2.f3946o0 = bVar.f3761b0;
            bVar2.f3916Z = bVar.f3747P;
            bVar2.f3918a0 = bVar.f3748Q;
            bVar2.f3920b0 = bVar.f3751T;
            bVar2.f3922c0 = bVar.f3752U;
            bVar2.f3924d0 = bVar.f3749R;
            bVar2.f3926e0 = bVar.f3750S;
            bVar2.f3928f0 = bVar.f3753V;
            bVar2.f3930g0 = bVar.f3754W;
            bVar2.f3942m0 = bVar.f3763c0;
            bVar2.f3906P = bVar.f3804x;
            bVar2.f3908R = bVar.f3806z;
            bVar2.f3905O = bVar.f3802w;
            bVar2.f3907Q = bVar.f3805y;
            bVar2.f3910T = bVar.f3732A;
            bVar2.f3909S = bVar.f3733B;
            bVar2.f3911U = bVar.f3734C;
            bVar2.f3950q0 = bVar.f3765d0;
            bVar2.f3902L = bVar.getMarginEnd();
            this.f3874e.f3903M = bVar.getMarginStart();
        }

        public void b(ConstraintLayout.b bVar) {
            b bVar2 = this.f3874e;
            bVar.f3766e = bVar2.f3935j;
            bVar.f3768f = bVar2.f3937k;
            bVar.f3770g = bVar2.f3939l;
            bVar.f3772h = bVar2.f3941m;
            bVar.f3774i = bVar2.f3943n;
            bVar.f3776j = bVar2.f3945o;
            bVar.f3778k = bVar2.f3947p;
            bVar.f3780l = bVar2.f3949q;
            bVar.f3782m = bVar2.f3951r;
            bVar.f3784n = bVar2.f3952s;
            bVar.f3786o = bVar2.f3953t;
            bVar.f3794s = bVar2.f3954u;
            bVar.f3796t = bVar2.f3955v;
            bVar.f3798u = bVar2.f3956w;
            bVar.f3800v = bVar2.f3957x;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.f3898H;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.f3899I;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.f3900J;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.f3901K;
            bVar.f3732A = bVar2.f3910T;
            bVar.f3733B = bVar2.f3909S;
            bVar.f3804x = bVar2.f3906P;
            bVar.f3806z = bVar2.f3908R;
            bVar.f3738G = bVar2.f3958y;
            bVar.f3739H = bVar2.f3959z;
            bVar.f3788p = bVar2.f3892B;
            bVar.f3790q = bVar2.f3893C;
            bVar.f3792r = bVar2.f3894D;
            bVar.f3740I = bVar2.f3891A;
            bVar.f3755X = bVar2.f3895E;
            bVar.f3756Y = bVar2.f3896F;
            bVar.f3744M = bVar2.f3912V;
            bVar.f3743L = bVar2.f3913W;
            bVar.f3746O = bVar2.f3915Y;
            bVar.f3745N = bVar2.f3914X;
            bVar.f3759a0 = bVar2.f3944n0;
            bVar.f3761b0 = bVar2.f3946o0;
            bVar.f3747P = bVar2.f3916Z;
            bVar.f3748Q = bVar2.f3918a0;
            bVar.f3751T = bVar2.f3920b0;
            bVar.f3752U = bVar2.f3922c0;
            bVar.f3749R = bVar2.f3924d0;
            bVar.f3750S = bVar2.f3926e0;
            bVar.f3753V = bVar2.f3928f0;
            bVar.f3754W = bVar2.f3930g0;
            bVar.f3757Z = bVar2.f3897G;
            bVar.f3762c = bVar2.f3931h;
            bVar.f3758a = bVar2.f3927f;
            bVar.f3760b = bVar2.f3929g;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar2.f3923d;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar2.f3925e;
            String str = bVar2.f3942m0;
            if (str != null) {
                bVar.f3763c0 = str;
            }
            bVar.f3765d0 = bVar2.f3950q0;
            bVar.setMarginStart(bVar2.f3903M);
            bVar.setMarginEnd(this.f3874e.f3902L);
            bVar.a();
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f3874e.a(this.f3874e);
            aVar.f3873d.a(this.f3873d);
            aVar.f3872c.a(this.f3872c);
            aVar.f3875f.a(this.f3875f);
            aVar.f3870a = this.f3870a;
            aVar.f3877h = this.f3877h;
            return aVar;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        private static SparseIntArray f3890r0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3923d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3925e;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int[] f3938k0;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public String f3940l0;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public String f3942m0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3917a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3919b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3921c = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3927f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3929g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f3931h = -1.0f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f3933i = true;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f3935j = -1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f3937k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f3939l = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f3941m = -1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f3943n = -1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f3945o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f3947p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f3949q = -1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f3951r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f3952s = -1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f3953t = -1;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f3954u = -1;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f3955v = -1;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f3956w = -1;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f3957x = -1;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f3958y = 0.5f;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public float f3959z = 0.5f;

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public String f3891A = null;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public int f3892B = -1;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public int f3893C = 0;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public float f3894D = 0.0f;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public int f3895E = -1;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public int f3896F = -1;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public int f3897G = -1;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public int f3898H = 0;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public int f3899I = 0;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f3900J = 0;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public int f3901K = 0;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public int f3902L = 0;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public int f3903M = 0;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public int f3904N = 0;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public int f3905O = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public int f3906P = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public int f3907Q = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public int f3908R = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public int f3909S = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public int f3910T = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public int f3911U = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        public float f3912V = -1.0f;

        /* JADX INFO: renamed from: W, reason: collision with root package name */
        public float f3913W = -1.0f;

        /* JADX INFO: renamed from: X, reason: collision with root package name */
        public int f3914X = 0;

        /* JADX INFO: renamed from: Y, reason: collision with root package name */
        public int f3915Y = 0;

        /* JADX INFO: renamed from: Z, reason: collision with root package name */
        public int f3916Z = 0;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public int f3918a0 = 0;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f3920b0 = 0;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f3922c0 = 0;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f3924d0 = 0;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int f3926e0 = 0;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public float f3928f0 = 1.0f;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public float f3930g0 = 1.0f;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f3932h0 = -1;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f3934i0 = 0;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f3936j0 = -1;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public boolean f3944n0 = false;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public boolean f3946o0 = false;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public boolean f3948p0 = true;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public int f3950q0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f3890r0 = sparseIntArray;
            sparseIntArray.append(m.X5, 24);
            f3890r0.append(m.Y5, 25);
            f3890r0.append(m.a6, 28);
            f3890r0.append(m.b6, 29);
            f3890r0.append(m.g6, 35);
            f3890r0.append(m.f6, 34);
            f3890r0.append(m.H5, 4);
            f3890r0.append(m.G5, 3);
            f3890r0.append(m.E5, 1);
            f3890r0.append(m.m6, 6);
            f3890r0.append(m.n6, 7);
            f3890r0.append(m.O5, 17);
            f3890r0.append(m.P5, 18);
            f3890r0.append(m.Q5, 19);
            f3890r0.append(m.A5, 90);
            f3890r0.append(m.m5, 26);
            f3890r0.append(m.c6, 31);
            f3890r0.append(m.d6, 32);
            f3890r0.append(m.N5, 10);
            f3890r0.append(m.M5, 9);
            f3890r0.append(m.q6, 13);
            f3890r0.append(m.t6, 16);
            f3890r0.append(m.r6, 14);
            f3890r0.append(m.o6, 11);
            f3890r0.append(m.s6, 15);
            f3890r0.append(m.p6, 12);
            f3890r0.append(m.j6, 38);
            f3890r0.append(m.V5, 37);
            f3890r0.append(m.U5, 39);
            f3890r0.append(m.i6, 40);
            f3890r0.append(m.T5, 20);
            f3890r0.append(m.h6, 36);
            f3890r0.append(m.L5, 5);
            f3890r0.append(m.W5, 91);
            f3890r0.append(m.e6, 91);
            f3890r0.append(m.Z5, 91);
            f3890r0.append(m.F5, 91);
            f3890r0.append(m.D5, 91);
            f3890r0.append(m.p5, 23);
            f3890r0.append(m.r5, 27);
            f3890r0.append(m.t5, 30);
            f3890r0.append(m.u5, 8);
            f3890r0.append(m.q5, 33);
            f3890r0.append(m.s5, 2);
            f3890r0.append(m.n5, 22);
            f3890r0.append(m.o5, 21);
            f3890r0.append(m.k6, 41);
            f3890r0.append(m.R5, 42);
            f3890r0.append(m.C5, 41);
            f3890r0.append(m.B5, 42);
            f3890r0.append(m.u6, 76);
            f3890r0.append(m.I5, 61);
            f3890r0.append(m.K5, 62);
            f3890r0.append(m.J5, 63);
            f3890r0.append(m.l6, 69);
            f3890r0.append(m.S5, 70);
            f3890r0.append(m.y5, 71);
            f3890r0.append(m.w5, 72);
            f3890r0.append(m.x5, 73);
            f3890r0.append(m.z5, 74);
            f3890r0.append(m.v5, 75);
        }

        public void a(b bVar) {
            this.f3917a = bVar.f3917a;
            this.f3923d = bVar.f3923d;
            this.f3919b = bVar.f3919b;
            this.f3925e = bVar.f3925e;
            this.f3927f = bVar.f3927f;
            this.f3929g = bVar.f3929g;
            this.f3931h = bVar.f3931h;
            this.f3933i = bVar.f3933i;
            this.f3935j = bVar.f3935j;
            this.f3937k = bVar.f3937k;
            this.f3939l = bVar.f3939l;
            this.f3941m = bVar.f3941m;
            this.f3943n = bVar.f3943n;
            this.f3945o = bVar.f3945o;
            this.f3947p = bVar.f3947p;
            this.f3949q = bVar.f3949q;
            this.f3951r = bVar.f3951r;
            this.f3952s = bVar.f3952s;
            this.f3953t = bVar.f3953t;
            this.f3954u = bVar.f3954u;
            this.f3955v = bVar.f3955v;
            this.f3956w = bVar.f3956w;
            this.f3957x = bVar.f3957x;
            this.f3958y = bVar.f3958y;
            this.f3959z = bVar.f3959z;
            this.f3891A = bVar.f3891A;
            this.f3892B = bVar.f3892B;
            this.f3893C = bVar.f3893C;
            this.f3894D = bVar.f3894D;
            this.f3895E = bVar.f3895E;
            this.f3896F = bVar.f3896F;
            this.f3897G = bVar.f3897G;
            this.f3898H = bVar.f3898H;
            this.f3899I = bVar.f3899I;
            this.f3900J = bVar.f3900J;
            this.f3901K = bVar.f3901K;
            this.f3902L = bVar.f3902L;
            this.f3903M = bVar.f3903M;
            this.f3904N = bVar.f3904N;
            this.f3905O = bVar.f3905O;
            this.f3906P = bVar.f3906P;
            this.f3907Q = bVar.f3907Q;
            this.f3908R = bVar.f3908R;
            this.f3909S = bVar.f3909S;
            this.f3910T = bVar.f3910T;
            this.f3911U = bVar.f3911U;
            this.f3912V = bVar.f3912V;
            this.f3913W = bVar.f3913W;
            this.f3914X = bVar.f3914X;
            this.f3915Y = bVar.f3915Y;
            this.f3916Z = bVar.f3916Z;
            this.f3918a0 = bVar.f3918a0;
            this.f3920b0 = bVar.f3920b0;
            this.f3922c0 = bVar.f3922c0;
            this.f3924d0 = bVar.f3924d0;
            this.f3926e0 = bVar.f3926e0;
            this.f3928f0 = bVar.f3928f0;
            this.f3930g0 = bVar.f3930g0;
            this.f3932h0 = bVar.f3932h0;
            this.f3934i0 = bVar.f3934i0;
            this.f3936j0 = bVar.f3936j0;
            this.f3942m0 = bVar.f3942m0;
            int[] iArr = bVar.f3938k0;
            if (iArr == null || bVar.f3940l0 != null) {
                this.f3938k0 = null;
            } else {
                this.f3938k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f3940l0 = bVar.f3940l0;
            this.f3944n0 = bVar.f3944n0;
            this.f3946o0 = bVar.f3946o0;
            this.f3948p0 = bVar.f3948p0;
            this.f3950q0 = bVar.f3950q0;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.l5);
            this.f3919b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                int i4 = f3890r0.get(index);
                switch (i4) {
                    case 1:
                        this.f3951r = j.m(typedArrayObtainStyledAttributes, index, this.f3951r);
                        break;
                    case 2:
                        this.f3901K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3901K);
                        break;
                    case 3:
                        this.f3949q = j.m(typedArrayObtainStyledAttributes, index, this.f3949q);
                        break;
                    case 4:
                        this.f3947p = j.m(typedArrayObtainStyledAttributes, index, this.f3947p);
                        break;
                    case 5:
                        this.f3891A = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.f3895E = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3895E);
                        break;
                    case 7:
                        this.f3896F = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3896F);
                        break;
                    case 8:
                        this.f3902L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3902L);
                        break;
                    case 9:
                        this.f3957x = j.m(typedArrayObtainStyledAttributes, index, this.f3957x);
                        break;
                    case 10:
                        this.f3956w = j.m(typedArrayObtainStyledAttributes, index, this.f3956w);
                        break;
                    case 11:
                        this.f3908R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3908R);
                        break;
                    case 12:
                        this.f3909S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3909S);
                        break;
                    case 13:
                        this.f3905O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3905O);
                        break;
                    case 14:
                        this.f3907Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3907Q);
                        break;
                    case 15:
                        this.f3910T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3910T);
                        break;
                    case 16:
                        this.f3906P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3906P);
                        break;
                    case 17:
                        this.f3927f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3927f);
                        break;
                    case 18:
                        this.f3929g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3929g);
                        break;
                    case 19:
                        this.f3931h = typedArrayObtainStyledAttributes.getFloat(index, this.f3931h);
                        break;
                    case 20:
                        this.f3958y = typedArrayObtainStyledAttributes.getFloat(index, this.f3958y);
                        break;
                    case 21:
                        this.f3925e = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f3925e);
                        break;
                    case 22:
                        this.f3923d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f3923d);
                        break;
                    case 23:
                        this.f3898H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3898H);
                        break;
                    case 24:
                        this.f3935j = j.m(typedArrayObtainStyledAttributes, index, this.f3935j);
                        break;
                    case 25:
                        this.f3937k = j.m(typedArrayObtainStyledAttributes, index, this.f3937k);
                        break;
                    case 26:
                        this.f3897G = typedArrayObtainStyledAttributes.getInt(index, this.f3897G);
                        break;
                    case 27:
                        this.f3899I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3899I);
                        break;
                    case 28:
                        this.f3939l = j.m(typedArrayObtainStyledAttributes, index, this.f3939l);
                        break;
                    case 29:
                        this.f3941m = j.m(typedArrayObtainStyledAttributes, index, this.f3941m);
                        break;
                    case 30:
                        this.f3903M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3903M);
                        break;
                    case 31:
                        this.f3954u = j.m(typedArrayObtainStyledAttributes, index, this.f3954u);
                        break;
                    case 32:
                        this.f3955v = j.m(typedArrayObtainStyledAttributes, index, this.f3955v);
                        break;
                    case 33:
                        this.f3900J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3900J);
                        break;
                    case 34:
                        this.f3945o = j.m(typedArrayObtainStyledAttributes, index, this.f3945o);
                        break;
                    case 35:
                        this.f3943n = j.m(typedArrayObtainStyledAttributes, index, this.f3943n);
                        break;
                    case 36:
                        this.f3959z = typedArrayObtainStyledAttributes.getFloat(index, this.f3959z);
                        break;
                    case 37:
                        this.f3913W = typedArrayObtainStyledAttributes.getFloat(index, this.f3913W);
                        break;
                    case 38:
                        this.f3912V = typedArrayObtainStyledAttributes.getFloat(index, this.f3912V);
                        break;
                    case 39:
                        this.f3914X = typedArrayObtainStyledAttributes.getInt(index, this.f3914X);
                        break;
                    case 40:
                        this.f3915Y = typedArrayObtainStyledAttributes.getInt(index, this.f3915Y);
                        break;
                    case 41:
                        j.n(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        j.n(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i4) {
                            case 61:
                                this.f3892B = j.m(typedArrayObtainStyledAttributes, index, this.f3892B);
                                break;
                            case 62:
                                this.f3893C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3893C);
                                break;
                            case 63:
                                this.f3894D = typedArrayObtainStyledAttributes.getFloat(index, this.f3894D);
                                break;
                            default:
                                switch (i4) {
                                    case 69:
                                        this.f3928f0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f3930g0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.f3932h0 = typedArrayObtainStyledAttributes.getInt(index, this.f3932h0);
                                        break;
                                    case 73:
                                        this.f3934i0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3934i0);
                                        break;
                                    case 74:
                                        this.f3940l0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f3948p0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f3948p0);
                                        break;
                                    case 76:
                                        this.f3950q0 = typedArrayObtainStyledAttributes.getInt(index, this.f3950q0);
                                        break;
                                    case 77:
                                        this.f3952s = j.m(typedArrayObtainStyledAttributes, index, this.f3952s);
                                        break;
                                    case 78:
                                        this.f3953t = j.m(typedArrayObtainStyledAttributes, index, this.f3953t);
                                        break;
                                    case 79:
                                        this.f3911U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3911U);
                                        break;
                                    case 80:
                                        this.f3904N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3904N);
                                        break;
                                    case 81:
                                        this.f3916Z = typedArrayObtainStyledAttributes.getInt(index, this.f3916Z);
                                        break;
                                    case 82:
                                        this.f3918a0 = typedArrayObtainStyledAttributes.getInt(index, this.f3918a0);
                                        break;
                                    case 83:
                                        this.f3922c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3922c0);
                                        break;
                                    case 84:
                                        this.f3920b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3920b0);
                                        break;
                                    case 85:
                                        this.f3926e0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3926e0);
                                        break;
                                    case 86:
                                        this.f3924d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3924d0);
                                        break;
                                    case 87:
                                        this.f3944n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f3944n0);
                                        break;
                                    case 88:
                                        this.f3946o0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f3946o0);
                                        break;
                                    case 89:
                                        this.f3942m0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f3933i = typedArrayObtainStyledAttributes.getBoolean(index, this.f3933i);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f3890r0.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f3890r0.get(index));
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static SparseIntArray f3960o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3961a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3962b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3963c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f3964d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3965e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3966f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f3967g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3968h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f3969i = Float.NaN;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f3970j = Float.NaN;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f3971k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f3972l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f3973m = -3;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f3974n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f3960o = sparseIntArray;
            sparseIntArray.append(m.G6, 1);
            f3960o.append(m.I6, 2);
            f3960o.append(m.M6, 3);
            f3960o.append(m.F6, 4);
            f3960o.append(m.E6, 5);
            f3960o.append(m.D6, 6);
            f3960o.append(m.H6, 7);
            f3960o.append(m.L6, 8);
            f3960o.append(m.K6, 9);
            f3960o.append(m.J6, 10);
        }

        public void a(c cVar) {
            this.f3961a = cVar.f3961a;
            this.f3962b = cVar.f3962b;
            this.f3964d = cVar.f3964d;
            this.f3965e = cVar.f3965e;
            this.f3966f = cVar.f3966f;
            this.f3969i = cVar.f3969i;
            this.f3967g = cVar.f3967g;
            this.f3968h = cVar.f3968h;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.C6);
            this.f3961a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                switch (f3960o.get(index)) {
                    case 1:
                        this.f3969i = typedArrayObtainStyledAttributes.getFloat(index, this.f3969i);
                        break;
                    case 2:
                        this.f3965e = typedArrayObtainStyledAttributes.getInt(index, this.f3965e);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.f3964d = typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            this.f3964d = p052p.a.f10461c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        this.f3966f = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f3962b = j.m(typedArrayObtainStyledAttributes, index, this.f3962b);
                        break;
                    case 6:
                        this.f3963c = typedArrayObtainStyledAttributes.getInteger(index, this.f3963c);
                        break;
                    case 7:
                        this.f3967g = typedArrayObtainStyledAttributes.getFloat(index, this.f3967g);
                        break;
                    case 8:
                        this.f3971k = typedArrayObtainStyledAttributes.getInteger(index, this.f3971k);
                        break;
                    case 9:
                        this.f3970j = typedArrayObtainStyledAttributes.getFloat(index, this.f3970j);
                        break;
                    case 10:
                        int i4 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i4 == 1) {
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            this.f3974n = resourceId;
                            if (resourceId != -1) {
                                this.f3973m = -2;
                            }
                        } else if (i4 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.f3972l = string;
                            if (string.indexOf("/") > 0) {
                                this.f3974n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                this.f3973m = -2;
                            } else {
                                this.f3973m = -1;
                            }
                        } else {
                            this.f3973m = typedArrayObtainStyledAttributes.getInteger(index, this.f3974n);
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3975a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3976b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3977c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f3978d = 1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f3979e = Float.NaN;

        public void a(d dVar) {
            this.f3975a = dVar.f3975a;
            this.f3976b = dVar.f3976b;
            this.f3978d = dVar.f3978d;
            this.f3979e = dVar.f3979e;
            this.f3977c = dVar.f3977c;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.X6);
            this.f3975a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == m.Z6) {
                    this.f3978d = typedArrayObtainStyledAttributes.getFloat(index, this.f3978d);
                } else if (index == m.Y6) {
                    this.f3976b = typedArrayObtainStyledAttributes.getInt(index, this.f3976b);
                    this.f3976b = j.f3862f[this.f3976b];
                } else if (index == m.b7) {
                    this.f3977c = typedArrayObtainStyledAttributes.getInt(index, this.f3977c);
                } else if (index == m.a7) {
                    this.f3979e = typedArrayObtainStyledAttributes.getFloat(index, this.f3979e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static SparseIntArray f3980o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3981a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f3982b = 0.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f3983c = 0.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f3984d = 0.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f3985e = 1.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f3986f = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f3987g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f3988h = Float.NaN;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f3989i = -1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f3990j = 0.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f3991k = 0.0f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f3992l = 0.0f;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f3993m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f3994n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f3980o = sparseIntArray;
            sparseIntArray.append(m.w7, 1);
            f3980o.append(m.x7, 2);
            f3980o.append(m.y7, 3);
            f3980o.append(m.u7, 4);
            f3980o.append(m.v7, 5);
            f3980o.append(m.q7, 6);
            f3980o.append(m.r7, 7);
            f3980o.append(m.s7, 8);
            f3980o.append(m.t7, 9);
            f3980o.append(m.z7, 10);
            f3980o.append(m.A7, 11);
            f3980o.append(m.B7, 12);
        }

        public void a(e eVar) {
            this.f3981a = eVar.f3981a;
            this.f3982b = eVar.f3982b;
            this.f3983c = eVar.f3983c;
            this.f3984d = eVar.f3984d;
            this.f3985e = eVar.f3985e;
            this.f3986f = eVar.f3986f;
            this.f3987g = eVar.f3987g;
            this.f3988h = eVar.f3988h;
            this.f3989i = eVar.f3989i;
            this.f3990j = eVar.f3990j;
            this.f3991k = eVar.f3991k;
            this.f3992l = eVar.f3992l;
            this.f3993m = eVar.f3993m;
            this.f3994n = eVar.f3994n;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.p7);
            this.f3981a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                switch (f3980o.get(index)) {
                    case 1:
                        this.f3982b = typedArrayObtainStyledAttributes.getFloat(index, this.f3982b);
                        break;
                    case 2:
                        this.f3983c = typedArrayObtainStyledAttributes.getFloat(index, this.f3983c);
                        break;
                    case 3:
                        this.f3984d = typedArrayObtainStyledAttributes.getFloat(index, this.f3984d);
                        break;
                    case 4:
                        this.f3985e = typedArrayObtainStyledAttributes.getFloat(index, this.f3985e);
                        break;
                    case 5:
                        this.f3986f = typedArrayObtainStyledAttributes.getFloat(index, this.f3986f);
                        break;
                    case 6:
                        this.f3987g = typedArrayObtainStyledAttributes.getDimension(index, this.f3987g);
                        break;
                    case 7:
                        this.f3988h = typedArrayObtainStyledAttributes.getDimension(index, this.f3988h);
                        break;
                    case 8:
                        this.f3990j = typedArrayObtainStyledAttributes.getDimension(index, this.f3990j);
                        break;
                    case 9:
                        this.f3991k = typedArrayObtainStyledAttributes.getDimension(index, this.f3991k);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.f3992l = typedArrayObtainStyledAttributes.getDimension(index, this.f3992l);
                        }
                        break;
                    case 11:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.f3993m = true;
                            this.f3994n = typedArrayObtainStyledAttributes.getDimension(index, this.f3994n);
                        }
                        break;
                    case 12:
                        this.f3989i = j.m(typedArrayObtainStyledAttributes, index, this.f3989i);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        f3863g.append(m.f3996A0, 25);
        f3863g.append(m.f4000B0, 26);
        f3863g.append(m.f4008D0, 29);
        f3863g.append(m.f4012E0, 30);
        f3863g.append(m.f4033K0, 36);
        f3863g.append(m.f4030J0, 35);
        f3863g.append(m.f4109h0, 4);
        f3863g.append(m.f4105g0, 3);
        f3863g.append(m.f4089c0, 1);
        f3863g.append(m.f4097e0, 91);
        f3863g.append(m.f4093d0, 92);
        f3863g.append(m.f4060T0, 6);
        f3863g.append(m.f4063U0, 7);
        f3863g.append(m.f4137o0, 17);
        f3863g.append(m.f4141p0, 18);
        f3863g.append(m.f4145q0, 19);
        f3863g.append(m.f4074Y, 99);
        f3863g.append(m.f4160u, 27);
        f3863g.append(m.f4016F0, 32);
        f3863g.append(m.f4020G0, 33);
        f3863g.append(m.f4133n0, 10);
        f3863g.append(m.f4129m0, 9);
        f3863g.append(m.f4072X0, 13);
        f3863g.append(m.f4082a1, 16);
        f3863g.append(m.f4075Y0, 14);
        f3863g.append(m.f4066V0, 11);
        f3863g.append(m.f4078Z0, 15);
        f3863g.append(m.f4069W0, 12);
        f3863g.append(m.f4042N0, 40);
        f3863g.append(m.f4177y0, 39);
        f3863g.append(m.f4173x0, 41);
        f3863g.append(m.f4039M0, 42);
        f3863g.append(m.f4169w0, 20);
        f3863g.append(m.f4036L0, 37);
        f3863g.append(m.f4125l0, 5);
        f3863g.append(m.f4181z0, 87);
        f3863g.append(m.f4027I0, 87);
        f3863g.append(m.f4004C0, 87);
        f3863g.append(m.f4101f0, 87);
        f3863g.append(m.f4085b0, 87);
        f3863g.append(m.f4180z, 24);
        f3863g.append(m.f3999B, 28);
        f3863g.append(m.f4041N, 31);
        f3863g.append(m.f4044O, 8);
        f3863g.append(m.f3995A, 34);
        f3863g.append(m.f4003C, 2);
        f3863g.append(m.f4172x, 23);
        f3863g.append(m.f4176y, 21);
        f3863g.append(m.f4045O0, 95);
        f3863g.append(m.f4149r0, 96);
        f3863g.append(m.f4168w, 22);
        f3863g.append(m.f4007D, 43);
        f3863g.append(m.f4050Q, 44);
        f3863g.append(m.f4035L, 45);
        f3863g.append(m.f4038M, 46);
        f3863g.append(m.f4032K, 60);
        f3863g.append(m.f4026I, 47);
        f3863g.append(m.f4029J, 48);
        f3863g.append(m.f4011E, 49);
        f3863g.append(m.f4015F, 50);
        f3863g.append(m.f4019G, 51);
        f3863g.append(m.f4023H, 52);
        f3863g.append(m.f4047P, 53);
        f3863g.append(m.f4048P0, 54);
        f3863g.append(m.f4153s0, 55);
        f3863g.append(m.f4051Q0, 56);
        f3863g.append(m.f4157t0, 57);
        f3863g.append(m.f4054R0, 58);
        f3863g.append(m.f4161u0, 59);
        f3863g.append(m.f4113i0, 61);
        f3863g.append(m.f4121k0, 62);
        f3863g.append(m.f4117j0, 63);
        f3863g.append(m.f4053R, 64);
        f3863g.append(m.f4122k1, 65);
        f3863g.append(m.f4071X, 66);
        f3863g.append(m.f4126l1, 67);
        f3863g.append(m.f4094d1, 79);
        f3863g.append(m.f4164v, 38);
        f3863g.append(m.f4090c1, 68);
        f3863g.append(m.f4057S0, 69);
        f3863g.append(m.f4165v0, 70);
        f3863g.append(m.f4086b1, 97);
        f3863g.append(m.f4065V, 71);
        f3863g.append(m.f4059T, 72);
        f3863g.append(m.f4062U, 73);
        f3863g.append(m.f4068W, 74);
        f3863g.append(m.f4056S, 75);
        f3863g.append(m.f4098e1, 76);
        f3863g.append(m.f4024H0, 77);
        f3863g.append(m.f4130m1, 78);
        f3863g.append(m.f4081a0, 80);
        f3863g.append(m.f4077Z, 81);
        f3863g.append(m.f4102f1, 82);
        f3863g.append(m.f4118j1, 83);
        f3863g.append(m.f4114i1, 84);
        f3863g.append(m.f4110h1, 85);
        f3863g.append(m.f4106g1, 86);
        SparseIntArray sparseIntArray = f3864h;
        int i3 = m.q4;
        sparseIntArray.append(i3, 6);
        f3864h.append(i3, 7);
        f3864h.append(m.l3, 27);
        f3864h.append(m.t4, 13);
        f3864h.append(m.w4, 16);
        f3864h.append(m.u4, 14);
        f3864h.append(m.r4, 11);
        f3864h.append(m.v4, 15);
        f3864h.append(m.s4, 12);
        f3864h.append(m.k4, 40);
        f3864h.append(m.d4, 39);
        f3864h.append(m.c4, 41);
        f3864h.append(m.j4, 42);
        f3864h.append(m.b4, 20);
        f3864h.append(m.i4, 37);
        f3864h.append(m.V3, 5);
        f3864h.append(m.e4, 87);
        f3864h.append(m.h4, 87);
        f3864h.append(m.f4, 87);
        f3864h.append(m.S3, 87);
        f3864h.append(m.R3, 87);
        f3864h.append(m.q3, 24);
        f3864h.append(m.s3, 28);
        f3864h.append(m.E3, 31);
        f3864h.append(m.F3, 8);
        f3864h.append(m.r3, 34);
        f3864h.append(m.t3, 2);
        f3864h.append(m.o3, 23);
        f3864h.append(m.p3, 21);
        f3864h.append(m.l4, 95);
        f3864h.append(m.W3, 96);
        f3864h.append(m.n3, 22);
        f3864h.append(m.u3, 43);
        f3864h.append(m.H3, 44);
        f3864h.append(m.C3, 45);
        f3864h.append(m.D3, 46);
        f3864h.append(m.B3, 60);
        f3864h.append(m.z3, 47);
        f3864h.append(m.A3, 48);
        f3864h.append(m.v3, 49);
        f3864h.append(m.w3, 50);
        f3864h.append(m.x3, 51);
        f3864h.append(m.y3, 52);
        f3864h.append(m.G3, 53);
        f3864h.append(m.m4, 54);
        f3864h.append(m.X3, 55);
        f3864h.append(m.n4, 56);
        f3864h.append(m.Y3, 57);
        f3864h.append(m.o4, 58);
        f3864h.append(m.Z3, 59);
        f3864h.append(m.U3, 62);
        f3864h.append(m.T3, 63);
        f3864h.append(m.I3, 64);
        f3864h.append(m.H4, 65);
        f3864h.append(m.O3, 66);
        f3864h.append(m.I4, 67);
        f3864h.append(m.z4, 79);
        f3864h.append(m.m3, 38);
        f3864h.append(m.A4, 98);
        f3864h.append(m.y4, 68);
        f3864h.append(m.p4, 69);
        f3864h.append(m.a4, 70);
        f3864h.append(m.M3, 71);
        f3864h.append(m.K3, 72);
        f3864h.append(m.L3, 73);
        f3864h.append(m.N3, 74);
        f3864h.append(m.J3, 75);
        f3864h.append(m.B4, 76);
        f3864h.append(m.g4, 77);
        f3864h.append(m.J4, 78);
        f3864h.append(m.Q3, 80);
        f3864h.append(m.P3, 81);
        f3864h.append(m.C4, 82);
        f3864h.append(m.G4, 83);
        f3864h.append(m.F4, 84);
        f3864h.append(m.E4, 85);
        f3864h.append(m.D4, 86);
        f3864h.append(m.x4, 97);
    }

    private int[] h(View view, String str) {
        int iIntValue;
        Object objG;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < strArrSplit.length) {
            String strTrim = strArrSplit[i3].trim();
            try {
                iIntValue = l.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objG = ((ConstraintLayout) view.getParent()).g(0, strTrim)) != null && (objG instanceof Integer)) {
                iIntValue = ((Integer) objG).intValue();
            }
            iArr[i4] = iIntValue;
            i3++;
            i4++;
        }
        return i4 != strArrSplit.length ? Arrays.copyOf(iArr, i4) : iArr;
    }

    private a i(Context context, AttributeSet attributeSet, boolean z3) {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z3 ? m.k3 : m.f4156t);
        q(context, aVar, typedArrayObtainStyledAttributes, z3);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    private a j(int i3) {
        if (!this.f3869e.containsKey(Integer.valueOf(i3))) {
            this.f3869e.put(Integer.valueOf(i3), new a());
        }
        return (a) this.f3869e.get(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(TypedArray typedArray, int i3, int i4) {
        int resourceId = typedArray.getResourceId(i3, i4);
        return resourceId == -1 ? typedArray.getInt(i3, -1) : resourceId;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0031  */
    /* JADX WARN: Code duplicated, block: B:23:0x0035  */
    /* JADX WARN: Code duplicated, block: B:24:0x003a  */
    /* JADX WARN: Code duplicated, block: B:25:0x003f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0043  */
    /* JADX WARN: Code duplicated, block: B:29:0x0047  */
    /* JADX WARN: Code duplicated, block: B:30:0x004c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0051  */
    /* JADX WARN: Code duplicated, block: B:33:0x0055  */
    /* JADX WARN: Code duplicated, block: B:35:0x0059  */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    static void n(Object obj, TypedArray typedArray, int i3, int i4) {
        int dimensionPixelSize;
        boolean z3;
        a.C0049a c0049a;
        b bVar;
        ConstraintLayout.b bVar2;
        if (obj == null) {
            return;
        }
        int i5 = typedArray.peekValue(i3).type;
        if (i5 == 3) {
            o(obj, typedArray.getString(i3), i4);
            return;
        }
        int i6 = 0;
        if (i5 != 5) {
            dimensionPixelSize = typedArray.getInt(i3, 0);
            if (dimensionPixelSize != -4) {
                if (dimensionPixelSize != -3 && (dimensionPixelSize == -2 || dimensionPixelSize == -1)) {
                }
                z3 = false;
            } else {
                z3 = true;
                i6 = -2;
            }
            if (obj instanceof ConstraintLayout.b) {
                bVar2 = (ConstraintLayout.b) obj;
                if (i4 == 0) {
                    ((ViewGroup.MarginLayoutParams) bVar2).width = i6;
                    bVar2.f3759a0 = z3;
                    return;
                } else {
                    ((ViewGroup.MarginLayoutParams) bVar2).height = i6;
                    bVar2.f3761b0 = z3;
                    return;
                }
            }
            if (obj instanceof b) {
                bVar = (b) obj;
                if (i4 == 0) {
                    bVar.f3923d = i6;
                    bVar.f3944n0 = z3;
                    return;
                } else {
                    bVar.f3925e = i6;
                    bVar.f3946o0 = z3;
                    return;
                }
            }
            if (obj instanceof a.C0049a) {
                c0049a = (a.C0049a) obj;
                if (i4 == 0) {
                    c0049a.b(23, i6);
                    c0049a.d(80, z3);
                } else {
                    c0049a.b(21, i6);
                    c0049a.d(81, z3);
                }
            }
        }
        dimensionPixelSize = typedArray.getDimensionPixelSize(i3, 0);
        i6 = dimensionPixelSize;
        z3 = false;
        if (obj instanceof ConstraintLayout.b) {
            bVar2 = (ConstraintLayout.b) obj;
            if (i4 == 0) {
                ((ViewGroup.MarginLayoutParams) bVar2).width = i6;
                bVar2.f3759a0 = z3;
                return;
            } else {
                ((ViewGroup.MarginLayoutParams) bVar2).height = i6;
                bVar2.f3761b0 = z3;
                return;
            }
        }
        if (obj instanceof b) {
            bVar = (b) obj;
            if (i4 == 0) {
                bVar.f3923d = i6;
                bVar.f3944n0 = z3;
                return;
            } else {
                bVar.f3925e = i6;
                bVar.f3946o0 = z3;
                return;
            }
        }
        if (obj instanceof a.C0049a) {
            c0049a = (a.C0049a) obj;
            if (i4 == 0) {
                c0049a.b(23, i6);
                c0049a.d(80, z3);
            } else {
                c0049a.b(21, i6);
                c0049a.d(81, z3);
            }
        }
    }

    static void o(Object obj, String str, int i3) {
        if (str == null) {
            return;
        }
        int iIndexOf = str.indexOf(61);
        int length = str.length();
        if (iIndexOf <= 0 || iIndexOf >= length - 1) {
            return;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        if (strSubstring2.length() > 0) {
            String strTrim = strSubstring.trim();
            String strTrim2 = strSubstring2.trim();
            if ("ratio".equalsIgnoreCase(strTrim)) {
                if (obj instanceof ConstraintLayout.b) {
                    ConstraintLayout.b bVar = (ConstraintLayout.b) obj;
                    if (i3 == 0) {
                        ((ViewGroup.MarginLayoutParams) bVar).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                    }
                    p(bVar, strTrim2);
                    return;
                }
                if (obj instanceof b) {
                    ((b) obj).f3891A = strTrim2;
                    return;
                } else {
                    if (obj instanceof a.C0049a) {
                        ((a.C0049a) obj).c(5, strTrim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(strTrim)) {
                    float f3 = Float.parseFloat(strTrim2);
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) obj;
                        if (i3 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar2).width = 0;
                            bVar2.f3743L = f3;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar2).height = 0;
                            bVar2.f3744M = f3;
                        }
                    } else if (obj instanceof b) {
                        b bVar3 = (b) obj;
                        if (i3 == 0) {
                            bVar3.f3923d = 0;
                            bVar3.f3913W = f3;
                        } else {
                            bVar3.f3925e = 0;
                            bVar3.f3912V = f3;
                        }
                    } else if (obj instanceof a.C0049a) {
                        a.C0049a c0049a = (a.C0049a) obj;
                        if (i3 == 0) {
                            c0049a.b(23, 0);
                            c0049a.a(39, f3);
                        } else {
                            c0049a.b(21, 0);
                            c0049a.a(40, f3);
                        }
                    }
                } else {
                    if (!"parent".equalsIgnoreCase(strTrim)) {
                        return;
                    }
                    float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar4 = (ConstraintLayout.b) obj;
                        if (i3 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar4).width = 0;
                            bVar4.f3753V = fMax;
                            bVar4.f3747P = 2;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar4).height = 0;
                            bVar4.f3754W = fMax;
                            bVar4.f3748Q = 2;
                        }
                    } else if (obj instanceof b) {
                        b bVar5 = (b) obj;
                        if (i3 == 0) {
                            bVar5.f3923d = 0;
                            bVar5.f3928f0 = fMax;
                            bVar5.f3916Z = 2;
                        } else {
                            bVar5.f3925e = 0;
                            bVar5.f3930g0 = fMax;
                            bVar5.f3918a0 = 2;
                        }
                    } else if (obj instanceof a.C0049a) {
                        a.C0049a c0049a2 = (a.C0049a) obj;
                        if (i3 == 0) {
                            c0049a2.b(23, 0);
                            c0049a2.b(54, 2);
                        } else {
                            c0049a2.b(21, 0);
                            c0049a2.b(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    static void p(ConstraintLayout.b bVar, String str) {
        float fAbs = Float.NaN;
        int i3 = -1;
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i4 = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase("W")) {
                    i3 = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    i3 = 1;
                }
                i4 = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i4);
                    if (strSubstring2.length() > 0) {
                        fAbs = Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i4, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f3 = Float.parseFloat(strSubstring3);
                        float f4 = Float.parseFloat(strSubstring4);
                        if (f3 > 0.0f && f4 > 0.0f) {
                            fAbs = i3 == 1 ? Math.abs(f4 / f3) : Math.abs(f3 / f4);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        bVar.f3740I = str;
        bVar.f3741J = fAbs;
        bVar.f3742K = i3;
    }

    private void q(Context context, a aVar, TypedArray typedArray, boolean z3) {
        if (z3) {
            r(context, aVar, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArray.getIndex(i3);
            if (index != m.f4164v && m.f4041N != index && m.f4044O != index) {
                aVar.f3873d.f3961a = true;
                aVar.f3874e.f3919b = true;
                aVar.f3872c.f3975a = true;
                aVar.f3875f.f3981a = true;
            }
            switch (f3863g.get(index)) {
                case 1:
                    b bVar = aVar.f3874e;
                    bVar.f3951r = m(typedArray, index, bVar.f3951r);
                    break;
                case 2:
                    b bVar2 = aVar.f3874e;
                    bVar2.f3901K = typedArray.getDimensionPixelSize(index, bVar2.f3901K);
                    break;
                case 3:
                    b bVar3 = aVar.f3874e;
                    bVar3.f3949q = m(typedArray, index, bVar3.f3949q);
                    break;
                case 4:
                    b bVar4 = aVar.f3874e;
                    bVar4.f3947p = m(typedArray, index, bVar4.f3947p);
                    break;
                case 5:
                    aVar.f3874e.f3891A = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f3874e;
                    bVar5.f3895E = typedArray.getDimensionPixelOffset(index, bVar5.f3895E);
                    break;
                case 7:
                    b bVar6 = aVar.f3874e;
                    bVar6.f3896F = typedArray.getDimensionPixelOffset(index, bVar6.f3896F);
                    break;
                case 8:
                    b bVar7 = aVar.f3874e;
                    bVar7.f3902L = typedArray.getDimensionPixelSize(index, bVar7.f3902L);
                    break;
                case 9:
                    b bVar8 = aVar.f3874e;
                    bVar8.f3957x = m(typedArray, index, bVar8.f3957x);
                    break;
                case 10:
                    b bVar9 = aVar.f3874e;
                    bVar9.f3956w = m(typedArray, index, bVar9.f3956w);
                    break;
                case 11:
                    b bVar10 = aVar.f3874e;
                    bVar10.f3908R = typedArray.getDimensionPixelSize(index, bVar10.f3908R);
                    break;
                case 12:
                    b bVar11 = aVar.f3874e;
                    bVar11.f3909S = typedArray.getDimensionPixelSize(index, bVar11.f3909S);
                    break;
                case 13:
                    b bVar12 = aVar.f3874e;
                    bVar12.f3905O = typedArray.getDimensionPixelSize(index, bVar12.f3905O);
                    break;
                case 14:
                    b bVar13 = aVar.f3874e;
                    bVar13.f3907Q = typedArray.getDimensionPixelSize(index, bVar13.f3907Q);
                    break;
                case 15:
                    b bVar14 = aVar.f3874e;
                    bVar14.f3910T = typedArray.getDimensionPixelSize(index, bVar14.f3910T);
                    break;
                case 16:
                    b bVar15 = aVar.f3874e;
                    bVar15.f3906P = typedArray.getDimensionPixelSize(index, bVar15.f3906P);
                    break;
                case 17:
                    b bVar16 = aVar.f3874e;
                    bVar16.f3927f = typedArray.getDimensionPixelOffset(index, bVar16.f3927f);
                    break;
                case 18:
                    b bVar17 = aVar.f3874e;
                    bVar17.f3929g = typedArray.getDimensionPixelOffset(index, bVar17.f3929g);
                    break;
                case 19:
                    b bVar18 = aVar.f3874e;
                    bVar18.f3931h = typedArray.getFloat(index, bVar18.f3931h);
                    break;
                case 20:
                    b bVar19 = aVar.f3874e;
                    bVar19.f3958y = typedArray.getFloat(index, bVar19.f3958y);
                    break;
                case 21:
                    b bVar20 = aVar.f3874e;
                    bVar20.f3925e = typedArray.getLayoutDimension(index, bVar20.f3925e);
                    break;
                case 22:
                    d dVar = aVar.f3872c;
                    dVar.f3976b = typedArray.getInt(index, dVar.f3976b);
                    d dVar2 = aVar.f3872c;
                    dVar2.f3976b = f3862f[dVar2.f3976b];
                    break;
                case 23:
                    b bVar21 = aVar.f3874e;
                    bVar21.f3923d = typedArray.getLayoutDimension(index, bVar21.f3923d);
                    break;
                case 24:
                    b bVar22 = aVar.f3874e;
                    bVar22.f3898H = typedArray.getDimensionPixelSize(index, bVar22.f3898H);
                    break;
                case 25:
                    b bVar23 = aVar.f3874e;
                    bVar23.f3935j = m(typedArray, index, bVar23.f3935j);
                    break;
                case 26:
                    b bVar24 = aVar.f3874e;
                    bVar24.f3937k = m(typedArray, index, bVar24.f3937k);
                    break;
                case 27:
                    b bVar25 = aVar.f3874e;
                    bVar25.f3897G = typedArray.getInt(index, bVar25.f3897G);
                    break;
                case 28:
                    b bVar26 = aVar.f3874e;
                    bVar26.f3899I = typedArray.getDimensionPixelSize(index, bVar26.f3899I);
                    break;
                case 29:
                    b bVar27 = aVar.f3874e;
                    bVar27.f3939l = m(typedArray, index, bVar27.f3939l);
                    break;
                case 30:
                    b bVar28 = aVar.f3874e;
                    bVar28.f3941m = m(typedArray, index, bVar28.f3941m);
                    break;
                case 31:
                    b bVar29 = aVar.f3874e;
                    bVar29.f3903M = typedArray.getDimensionPixelSize(index, bVar29.f3903M);
                    break;
                case 32:
                    b bVar30 = aVar.f3874e;
                    bVar30.f3954u = m(typedArray, index, bVar30.f3954u);
                    break;
                case 33:
                    b bVar31 = aVar.f3874e;
                    bVar31.f3955v = m(typedArray, index, bVar31.f3955v);
                    break;
                case 34:
                    b bVar32 = aVar.f3874e;
                    bVar32.f3900J = typedArray.getDimensionPixelSize(index, bVar32.f3900J);
                    break;
                case 35:
                    b bVar33 = aVar.f3874e;
                    bVar33.f3945o = m(typedArray, index, bVar33.f3945o);
                    break;
                case 36:
                    b bVar34 = aVar.f3874e;
                    bVar34.f3943n = m(typedArray, index, bVar34.f3943n);
                    break;
                case 37:
                    b bVar35 = aVar.f3874e;
                    bVar35.f3959z = typedArray.getFloat(index, bVar35.f3959z);
                    break;
                case 38:
                    aVar.f3870a = typedArray.getResourceId(index, aVar.f3870a);
                    break;
                case 39:
                    b bVar36 = aVar.f3874e;
                    bVar36.f3913W = typedArray.getFloat(index, bVar36.f3913W);
                    break;
                case 40:
                    b bVar37 = aVar.f3874e;
                    bVar37.f3912V = typedArray.getFloat(index, bVar37.f3912V);
                    break;
                case 41:
                    b bVar38 = aVar.f3874e;
                    bVar38.f3914X = typedArray.getInt(index, bVar38.f3914X);
                    break;
                case 42:
                    b bVar39 = aVar.f3874e;
                    bVar39.f3915Y = typedArray.getInt(index, bVar39.f3915Y);
                    break;
                case 43:
                    d dVar3 = aVar.f3872c;
                    dVar3.f3978d = typedArray.getFloat(index, dVar3.f3978d);
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar = aVar.f3875f;
                        eVar.f3993m = true;
                        eVar.f3994n = typedArray.getDimension(index, eVar.f3994n);
                    }
                    break;
                case 45:
                    e eVar2 = aVar.f3875f;
                    eVar2.f3983c = typedArray.getFloat(index, eVar2.f3983c);
                    break;
                case 46:
                    e eVar3 = aVar.f3875f;
                    eVar3.f3984d = typedArray.getFloat(index, eVar3.f3984d);
                    break;
                case 47:
                    e eVar4 = aVar.f3875f;
                    eVar4.f3985e = typedArray.getFloat(index, eVar4.f3985e);
                    break;
                case 48:
                    e eVar5 = aVar.f3875f;
                    eVar5.f3986f = typedArray.getFloat(index, eVar5.f3986f);
                    break;
                case 49:
                    e eVar6 = aVar.f3875f;
                    eVar6.f3987g = typedArray.getDimension(index, eVar6.f3987g);
                    break;
                case 50:
                    e eVar7 = aVar.f3875f;
                    eVar7.f3988h = typedArray.getDimension(index, eVar7.f3988h);
                    break;
                case 51:
                    e eVar8 = aVar.f3875f;
                    eVar8.f3990j = typedArray.getDimension(index, eVar8.f3990j);
                    break;
                case 52:
                    e eVar9 = aVar.f3875f;
                    eVar9.f3991k = typedArray.getDimension(index, eVar9.f3991k);
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar10 = aVar.f3875f;
                        eVar10.f3992l = typedArray.getDimension(index, eVar10.f3992l);
                    }
                    break;
                case 54:
                    b bVar40 = aVar.f3874e;
                    bVar40.f3916Z = typedArray.getInt(index, bVar40.f3916Z);
                    break;
                case 55:
                    b bVar41 = aVar.f3874e;
                    bVar41.f3918a0 = typedArray.getInt(index, bVar41.f3918a0);
                    break;
                case 56:
                    b bVar42 = aVar.f3874e;
                    bVar42.f3920b0 = typedArray.getDimensionPixelSize(index, bVar42.f3920b0);
                    break;
                case 57:
                    b bVar43 = aVar.f3874e;
                    bVar43.f3922c0 = typedArray.getDimensionPixelSize(index, bVar43.f3922c0);
                    break;
                case 58:
                    b bVar44 = aVar.f3874e;
                    bVar44.f3924d0 = typedArray.getDimensionPixelSize(index, bVar44.f3924d0);
                    break;
                case 59:
                    b bVar45 = aVar.f3874e;
                    bVar45.f3926e0 = typedArray.getDimensionPixelSize(index, bVar45.f3926e0);
                    break;
                case 60:
                    e eVar11 = aVar.f3875f;
                    eVar11.f3982b = typedArray.getFloat(index, eVar11.f3982b);
                    break;
                case 61:
                    b bVar46 = aVar.f3874e;
                    bVar46.f3892B = m(typedArray, index, bVar46.f3892B);
                    break;
                case 62:
                    b bVar47 = aVar.f3874e;
                    bVar47.f3893C = typedArray.getDimensionPixelSize(index, bVar47.f3893C);
                    break;
                case 63:
                    b bVar48 = aVar.f3874e;
                    bVar48.f3894D = typedArray.getFloat(index, bVar48.f3894D);
                    break;
                case 64:
                    c cVar = aVar.f3873d;
                    cVar.f3962b = m(typedArray, index, cVar.f3962b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f3873d.f3964d = typedArray.getString(index);
                    } else {
                        aVar.f3873d.f3964d = p052p.a.f10461c[typedArray.getInteger(index, 0)];
                    }
                    break;
                case 66:
                    aVar.f3873d.f3966f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    c cVar2 = aVar.f3873d;
                    cVar2.f3969i = typedArray.getFloat(index, cVar2.f3969i);
                    break;
                case 68:
                    d dVar4 = aVar.f3872c;
                    dVar4.f3979e = typedArray.getFloat(index, dVar4.f3979e);
                    break;
                case 69:
                    aVar.f3874e.f3928f0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f3874e.f3930g0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = aVar.f3874e;
                    bVar49.f3932h0 = typedArray.getInt(index, bVar49.f3932h0);
                    break;
                case 73:
                    b bVar50 = aVar.f3874e;
                    bVar50.f3934i0 = typedArray.getDimensionPixelSize(index, bVar50.f3934i0);
                    break;
                case 74:
                    aVar.f3874e.f3940l0 = typedArray.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f3874e;
                    bVar51.f3948p0 = typedArray.getBoolean(index, bVar51.f3948p0);
                    break;
                case 76:
                    c cVar3 = aVar.f3873d;
                    cVar3.f3965e = typedArray.getInt(index, cVar3.f3965e);
                    break;
                case 77:
                    aVar.f3874e.f3942m0 = typedArray.getString(index);
                    break;
                case 78:
                    d dVar5 = aVar.f3872c;
                    dVar5.f3977c = typedArray.getInt(index, dVar5.f3977c);
                    break;
                case 79:
                    c cVar4 = aVar.f3873d;
                    cVar4.f3967g = typedArray.getFloat(index, cVar4.f3967g);
                    break;
                case 80:
                    b bVar52 = aVar.f3874e;
                    bVar52.f3944n0 = typedArray.getBoolean(index, bVar52.f3944n0);
                    break;
                case 81:
                    b bVar53 = aVar.f3874e;
                    bVar53.f3946o0 = typedArray.getBoolean(index, bVar53.f3946o0);
                    break;
                case 82:
                    c cVar5 = aVar.f3873d;
                    cVar5.f3963c = typedArray.getInteger(index, cVar5.f3963c);
                    break;
                case 83:
                    e eVar12 = aVar.f3875f;
                    eVar12.f3989i = m(typedArray, index, eVar12.f3989i);
                    break;
                case 84:
                    c cVar6 = aVar.f3873d;
                    cVar6.f3971k = typedArray.getInteger(index, cVar6.f3971k);
                    break;
                case 85:
                    c cVar7 = aVar.f3873d;
                    cVar7.f3970j = typedArray.getFloat(index, cVar7.f3970j);
                    break;
                case 86:
                    int i4 = typedArray.peekValue(index).type;
                    if (i4 == 1) {
                        aVar.f3873d.f3974n = typedArray.getResourceId(index, -1);
                        c cVar8 = aVar.f3873d;
                        if (cVar8.f3974n != -1) {
                            cVar8.f3973m = -2;
                        }
                    } else if (i4 == 3) {
                        aVar.f3873d.f3972l = typedArray.getString(index);
                        if (aVar.f3873d.f3972l.indexOf("/") > 0) {
                            aVar.f3873d.f3974n = typedArray.getResourceId(index, -1);
                            aVar.f3873d.f3973m = -2;
                        } else {
                            aVar.f3873d.f3973m = -1;
                        }
                    } else {
                        c cVar9 = aVar.f3873d;
                        cVar9.f3973m = typedArray.getInteger(index, cVar9.f3974n);
                    }
                    break;
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f3863g.get(index));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f3863g.get(index));
                    break;
                case 91:
                    b bVar54 = aVar.f3874e;
                    bVar54.f3952s = m(typedArray, index, bVar54.f3952s);
                    break;
                case 92:
                    b bVar55 = aVar.f3874e;
                    bVar55.f3953t = m(typedArray, index, bVar55.f3953t);
                    break;
                case 93:
                    b bVar56 = aVar.f3874e;
                    bVar56.f3904N = typedArray.getDimensionPixelSize(index, bVar56.f3904N);
                    break;
                case 94:
                    b bVar57 = aVar.f3874e;
                    bVar57.f3911U = typedArray.getDimensionPixelSize(index, bVar57.f3911U);
                    break;
                case 95:
                    n(aVar.f3874e, typedArray, index, 0);
                    break;
                case 96:
                    n(aVar.f3874e, typedArray, index, 1);
                    break;
                case 97:
                    b bVar58 = aVar.f3874e;
                    bVar58.f3950q0 = typedArray.getInt(index, bVar58.f3950q0);
                    break;
            }
        }
        b bVar59 = aVar.f3874e;
        if (bVar59.f3940l0 != null) {
            bVar59.f3938k0 = null;
        }
    }

    private static void r(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        a.C0049a c0049a = new a.C0049a();
        aVar.f3877h = c0049a;
        aVar.f3873d.f3961a = false;
        aVar.f3874e.f3919b = false;
        aVar.f3872c.f3975a = false;
        aVar.f3875f.f3981a = false;
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArray.getIndex(i3);
            switch (f3864h.get(index)) {
                case 2:
                    c0049a.b(2, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3901K));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f3863g.get(index));
                    break;
                case 5:
                    c0049a.c(5, typedArray.getString(index));
                    break;
                case 6:
                    c0049a.b(6, typedArray.getDimensionPixelOffset(index, aVar.f3874e.f3895E));
                    break;
                case 7:
                    c0049a.b(7, typedArray.getDimensionPixelOffset(index, aVar.f3874e.f3896F));
                    break;
                case 8:
                    c0049a.b(8, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3902L));
                    break;
                case 11:
                    c0049a.b(11, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3908R));
                    break;
                case 12:
                    c0049a.b(12, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3909S));
                    break;
                case 13:
                    c0049a.b(13, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3905O));
                    break;
                case 14:
                    c0049a.b(14, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3907Q));
                    break;
                case 15:
                    c0049a.b(15, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3910T));
                    break;
                case 16:
                    c0049a.b(16, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3906P));
                    break;
                case 17:
                    c0049a.b(17, typedArray.getDimensionPixelOffset(index, aVar.f3874e.f3927f));
                    break;
                case 18:
                    c0049a.b(18, typedArray.getDimensionPixelOffset(index, aVar.f3874e.f3929g));
                    break;
                case 19:
                    c0049a.a(19, typedArray.getFloat(index, aVar.f3874e.f3931h));
                    break;
                case 20:
                    c0049a.a(20, typedArray.getFloat(index, aVar.f3874e.f3958y));
                    break;
                case 21:
                    c0049a.b(21, typedArray.getLayoutDimension(index, aVar.f3874e.f3925e));
                    break;
                case 22:
                    c0049a.b(22, f3862f[typedArray.getInt(index, aVar.f3872c.f3976b)]);
                    break;
                case 23:
                    c0049a.b(23, typedArray.getLayoutDimension(index, aVar.f3874e.f3923d));
                    break;
                case 24:
                    c0049a.b(24, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3898H));
                    break;
                case 27:
                    c0049a.b(27, typedArray.getInt(index, aVar.f3874e.f3897G));
                    break;
                case 28:
                    c0049a.b(28, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3899I));
                    break;
                case 31:
                    c0049a.b(31, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3903M));
                    break;
                case 34:
                    c0049a.b(34, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3900J));
                    break;
                case 37:
                    c0049a.a(37, typedArray.getFloat(index, aVar.f3874e.f3959z));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, aVar.f3870a);
                    aVar.f3870a = resourceId;
                    c0049a.b(38, resourceId);
                    break;
                case 39:
                    c0049a.a(39, typedArray.getFloat(index, aVar.f3874e.f3913W));
                    break;
                case 40:
                    c0049a.a(40, typedArray.getFloat(index, aVar.f3874e.f3912V));
                    break;
                case 41:
                    c0049a.b(41, typedArray.getInt(index, aVar.f3874e.f3914X));
                    break;
                case 42:
                    c0049a.b(42, typedArray.getInt(index, aVar.f3874e.f3915Y));
                    break;
                case 43:
                    c0049a.a(43, typedArray.getFloat(index, aVar.f3872c.f3978d));
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        c0049a.d(44, true);
                        c0049a.a(44, typedArray.getDimension(index, aVar.f3875f.f3994n));
                    }
                    break;
                case 45:
                    c0049a.a(45, typedArray.getFloat(index, aVar.f3875f.f3983c));
                    break;
                case 46:
                    c0049a.a(46, typedArray.getFloat(index, aVar.f3875f.f3984d));
                    break;
                case 47:
                    c0049a.a(47, typedArray.getFloat(index, aVar.f3875f.f3985e));
                    break;
                case 48:
                    c0049a.a(48, typedArray.getFloat(index, aVar.f3875f.f3986f));
                    break;
                case 49:
                    c0049a.a(49, typedArray.getDimension(index, aVar.f3875f.f3987g));
                    break;
                case 50:
                    c0049a.a(50, typedArray.getDimension(index, aVar.f3875f.f3988h));
                    break;
                case 51:
                    c0049a.a(51, typedArray.getDimension(index, aVar.f3875f.f3990j));
                    break;
                case 52:
                    c0049a.a(52, typedArray.getDimension(index, aVar.f3875f.f3991k));
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        c0049a.a(53, typedArray.getDimension(index, aVar.f3875f.f3992l));
                    }
                    break;
                case 54:
                    c0049a.b(54, typedArray.getInt(index, aVar.f3874e.f3916Z));
                    break;
                case 55:
                    c0049a.b(55, typedArray.getInt(index, aVar.f3874e.f3918a0));
                    break;
                case 56:
                    c0049a.b(56, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3920b0));
                    break;
                case 57:
                    c0049a.b(57, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3922c0));
                    break;
                case 58:
                    c0049a.b(58, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3924d0));
                    break;
                case 59:
                    c0049a.b(59, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3926e0));
                    break;
                case 60:
                    c0049a.a(60, typedArray.getFloat(index, aVar.f3875f.f3982b));
                    break;
                case 62:
                    c0049a.b(62, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3893C));
                    break;
                case 63:
                    c0049a.a(63, typedArray.getFloat(index, aVar.f3874e.f3894D));
                    break;
                case 64:
                    c0049a.b(64, m(typedArray, index, aVar.f3873d.f3962b));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        c0049a.c(65, typedArray.getString(index));
                    } else {
                        c0049a.c(65, p052p.a.f10461c[typedArray.getInteger(index, 0)]);
                    }
                    break;
                case 66:
                    c0049a.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    c0049a.a(67, typedArray.getFloat(index, aVar.f3873d.f3969i));
                    break;
                case 68:
                    c0049a.a(68, typedArray.getFloat(index, aVar.f3872c.f3979e));
                    break;
                case 69:
                    c0049a.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    c0049a.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    c0049a.b(72, typedArray.getInt(index, aVar.f3874e.f3932h0));
                    break;
                case 73:
                    c0049a.b(73, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3934i0));
                    break;
                case 74:
                    c0049a.c(74, typedArray.getString(index));
                    break;
                case 75:
                    c0049a.d(75, typedArray.getBoolean(index, aVar.f3874e.f3948p0));
                    break;
                case 76:
                    c0049a.b(76, typedArray.getInt(index, aVar.f3873d.f3965e));
                    break;
                case 77:
                    c0049a.c(77, typedArray.getString(index));
                    break;
                case 78:
                    c0049a.b(78, typedArray.getInt(index, aVar.f3872c.f3977c));
                    break;
                case 79:
                    c0049a.a(79, typedArray.getFloat(index, aVar.f3873d.f3967g));
                    break;
                case 80:
                    c0049a.d(80, typedArray.getBoolean(index, aVar.f3874e.f3944n0));
                    break;
                case 81:
                    c0049a.d(81, typedArray.getBoolean(index, aVar.f3874e.f3946o0));
                    break;
                case 82:
                    c0049a.b(82, typedArray.getInteger(index, aVar.f3873d.f3963c));
                    break;
                case 83:
                    c0049a.b(83, m(typedArray, index, aVar.f3875f.f3989i));
                    break;
                case 84:
                    c0049a.b(84, typedArray.getInteger(index, aVar.f3873d.f3971k));
                    break;
                case 85:
                    c0049a.a(85, typedArray.getFloat(index, aVar.f3873d.f3970j));
                    break;
                case 86:
                    int i4 = typedArray.peekValue(index).type;
                    if (i4 == 1) {
                        aVar.f3873d.f3974n = typedArray.getResourceId(index, -1);
                        c0049a.b(89, aVar.f3873d.f3974n);
                        c cVar = aVar.f3873d;
                        if (cVar.f3974n != -1) {
                            cVar.f3973m = -2;
                            c0049a.b(88, -2);
                        }
                    } else if (i4 == 3) {
                        aVar.f3873d.f3972l = typedArray.getString(index);
                        c0049a.c(90, aVar.f3873d.f3972l);
                        if (aVar.f3873d.f3972l.indexOf("/") > 0) {
                            aVar.f3873d.f3974n = typedArray.getResourceId(index, -1);
                            c0049a.b(89, aVar.f3873d.f3974n);
                            aVar.f3873d.f3973m = -2;
                            c0049a.b(88, -2);
                        } else {
                            aVar.f3873d.f3973m = -1;
                            c0049a.b(88, -1);
                        }
                    } else {
                        c cVar2 = aVar.f3873d;
                        cVar2.f3973m = typedArray.getInteger(index, cVar2.f3974n);
                        c0049a.b(88, aVar.f3873d.f3973m);
                    }
                    break;
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f3863g.get(index));
                    break;
                case 93:
                    c0049a.b(93, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3904N));
                    break;
                case 94:
                    c0049a.b(94, typedArray.getDimensionPixelSize(index, aVar.f3874e.f3911U));
                    break;
                case 95:
                    n(c0049a, typedArray, index, 0);
                    break;
                case 96:
                    n(c0049a, typedArray, index, 1);
                    break;
                case 97:
                    c0049a.b(97, typedArray.getInt(index, aVar.f3874e.f3950q0));
                    break;
                case 98:
                    if (p064t.b.f11748y) {
                        int resourceId2 = typedArray.getResourceId(index, aVar.f3870a);
                        aVar.f3870a = resourceId2;
                        if (resourceId2 == -1) {
                            aVar.f3871b = typedArray.getString(index);
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        aVar.f3871b = typedArray.getString(index);
                    } else {
                        aVar.f3870a = typedArray.getResourceId(index, aVar.f3870a);
                    }
                    break;
                case 99:
                    c0049a.d(99, typedArray.getBoolean(index, aVar.f3874e.f3933i));
                    break;
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    void d(ConstraintLayout constraintLayout, boolean z3) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.f3869e.keySet());
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            int id = childAt.getId();
            if (!this.f3869e.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + p064t.a.a(childAt));
            } else {
                if (this.f3868d && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f3869e.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = (a) this.f3869e.get(Integer.valueOf(id));
                        if (aVar != null) {
                            if (childAt instanceof androidx.constraintlayout.widget.a) {
                                aVar.f3874e.f3936j0 = 1;
                                androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) childAt;
                                aVar2.setId(id);
                                aVar2.setType(aVar.f3874e.f3932h0);
                                aVar2.setMargin(aVar.f3874e.f3934i0);
                                aVar2.setAllowsGoneWidget(aVar.f3874e.f3948p0);
                                b bVar = aVar.f3874e;
                                int[] iArr = bVar.f3938k0;
                                if (iArr != null) {
                                    aVar2.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.f3940l0;
                                    if (str != null) {
                                        bVar.f3938k0 = h(aVar2, str);
                                        aVar2.setReferencedIds(aVar.f3874e.f3938k0);
                                    }
                                }
                            }
                            ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                            bVar2.a();
                            aVar.b(bVar2);
                            if (z3) {
                                androidx.constraintlayout.widget.b.c(childAt, aVar.f3876g);
                            }
                            childAt.setLayoutParams(bVar2);
                            d dVar = aVar.f3872c;
                            if (dVar.f3977c == 0) {
                                childAt.setVisibility(dVar.f3976b);
                            }
                            int i4 = Build.VERSION.SDK_INT;
                            childAt.setAlpha(aVar.f3872c.f3978d);
                            childAt.setRotation(aVar.f3875f.f3982b);
                            childAt.setRotationX(aVar.f3875f.f3983c);
                            childAt.setRotationY(aVar.f3875f.f3984d);
                            childAt.setScaleX(aVar.f3875f.f3985e);
                            childAt.setScaleY(aVar.f3875f.f3986f);
                            e eVar = aVar.f3875f;
                            if (eVar.f3989i != -1) {
                                View viewFindViewById = ((View) childAt.getParent()).findViewById(aVar.f3875f.f3989i);
                                if (viewFindViewById != null) {
                                    float top = (viewFindViewById.getTop() + viewFindViewById.getBottom()) / 2.0f;
                                    float left = (viewFindViewById.getLeft() + viewFindViewById.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        float left2 = left - childAt.getLeft();
                                        float top2 = top - childAt.getTop();
                                        childAt.setPivotX(left2);
                                        childAt.setPivotY(top2);
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f3987g)) {
                                    childAt.setPivotX(aVar.f3875f.f3987g);
                                }
                                if (!Float.isNaN(aVar.f3875f.f3988h)) {
                                    childAt.setPivotY(aVar.f3875f.f3988h);
                                }
                            }
                            childAt.setTranslationX(aVar.f3875f.f3990j);
                            childAt.setTranslationY(aVar.f3875f.f3991k);
                            if (i4 >= 21) {
                                childAt.setTranslationZ(aVar.f3875f.f3992l);
                                e eVar2 = aVar.f3875f;
                                if (eVar2.f3993m) {
                                    childAt.setElevation(eVar2.f3994n);
                                }
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            a aVar3 = (a) this.f3869e.get(num);
            if (aVar3 != null) {
                if (aVar3.f3874e.f3936j0 == 1) {
                    androidx.constraintlayout.widget.a aVar4 = new androidx.constraintlayout.widget.a(constraintLayout.getContext());
                    aVar4.setId(num.intValue());
                    b bVar3 = aVar3.f3874e;
                    int[] iArr2 = bVar3.f3938k0;
                    if (iArr2 != null) {
                        aVar4.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar3.f3940l0;
                        if (str2 != null) {
                            bVar3.f3938k0 = h(aVar4, str2);
                            aVar4.setReferencedIds(aVar3.f3874e.f3938k0);
                        }
                    }
                    aVar4.setType(aVar3.f3874e.f3932h0);
                    aVar4.setMargin(aVar3.f3874e.f3934i0);
                    ConstraintLayout.b bVarE = constraintLayout.generateDefaultLayoutParams();
                    aVar4.o();
                    aVar3.b(bVarE);
                    constraintLayout.addView(aVar4, bVarE);
                }
                if (aVar3.f3874e.f3917a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.b bVarE2 = constraintLayout.generateDefaultLayoutParams();
                    aVar3.b(bVarE2);
                    constraintLayout.addView(guideline, bVarE2);
                }
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt2 = constraintLayout.getChildAt(i5);
            if (childAt2 instanceof f) {
                ((f) childAt2).f(constraintLayout);
            }
        }
    }

    public void e(Context context, int i3) {
        f((ConstraintLayout) LayoutInflater.from(context).inflate(i3, (ViewGroup) null));
    }

    public void f(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f3869e.clear();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f3868d && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f3869e.containsKey(Integer.valueOf(id))) {
                this.f3869e.put(Integer.valueOf(id), new a());
            }
            a aVar = (a) this.f3869e.get(Integer.valueOf(id));
            if (aVar != null) {
                aVar.f3876g = androidx.constraintlayout.widget.b.a(this.f3867c, childAt);
                aVar.d(id, bVar);
                aVar.f3872c.f3976b = childAt.getVisibility();
                int i4 = Build.VERSION.SDK_INT;
                aVar.f3872c.f3978d = childAt.getAlpha();
                aVar.f3875f.f3982b = childAt.getRotation();
                aVar.f3875f.f3983c = childAt.getRotationX();
                aVar.f3875f.f3984d = childAt.getRotationY();
                aVar.f3875f.f3985e = childAt.getScaleX();
                aVar.f3875f.f3986f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar.f3875f;
                    eVar.f3987g = pivotX;
                    eVar.f3988h = pivotY;
                }
                aVar.f3875f.f3990j = childAt.getTranslationX();
                aVar.f3875f.f3991k = childAt.getTranslationY();
                if (i4 >= 21) {
                    aVar.f3875f.f3992l = childAt.getTranslationZ();
                    e eVar2 = aVar.f3875f;
                    if (eVar2.f3993m) {
                        eVar2.f3994n = childAt.getElevation();
                    }
                }
                if (childAt instanceof androidx.constraintlayout.widget.a) {
                    androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) childAt;
                    aVar.f3874e.f3948p0 = aVar2.getAllowsGoneWidget();
                    aVar.f3874e.f3938k0 = aVar2.getReferencedIds();
                    aVar.f3874e.f3932h0 = aVar2.getType();
                    aVar.f3874e.f3934i0 = aVar2.getMargin();
                }
            }
        }
    }

    public void g(int i3, int i4, int i5, float f3) {
        b bVar = j(i3).f3874e;
        bVar.f3892B = i4;
        bVar.f3893C = i5;
        bVar.f3894D = f3;
    }

    public void k(Context context, int i3) {
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarI = i(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarI.f3874e.f3917a = true;
                    }
                    this.f3869e.put(Integer.valueOf(aVarI.f3870a), aVarI);
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void l(Context context, XmlPullParser xmlPullParser) {
        try {
            int eventType = xmlPullParser.getEventType();
            a aVarI = null;
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    switch (xmlPullParser.getName()) {
                        case "Constraint":
                            aVarI = i(context, Xml.asAttributeSet(xmlPullParser), false);
                            break;
                        case "ConstraintOverride":
                            aVarI = i(context, Xml.asAttributeSet(xmlPullParser), true);
                            break;
                        case "Guideline":
                            aVarI = i(context, Xml.asAttributeSet(xmlPullParser), false);
                            b bVar = aVarI.f3874e;
                            bVar.f3917a = true;
                            bVar.f3919b = true;
                            break;
                        case "Barrier":
                            aVarI = i(context, Xml.asAttributeSet(xmlPullParser), false);
                            aVarI.f3874e.f3936j0 = 1;
                            break;
                        case "PropertySet":
                            if (aVarI == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            aVarI.f3872c.b(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                            break;
                        case "Transform":
                            if (aVarI == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            aVarI.f3875f.b(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                            break;
                        case "Layout":
                            if (aVarI == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            aVarI.f3874e.b(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                            break;
                        case "Motion":
                            if (aVarI == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            aVarI.f3873d.b(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                            break;
                        case "CustomAttribute":
                        case "CustomMethod":
                            if (aVarI == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            androidx.constraintlayout.widget.b.b(context, xmlPullParser, aVarI.f3876g);
                            break;
                            break;
                    }
                } else if (eventType == 3) {
                    String lowerCase = xmlPullParser.getName().toLowerCase(Locale.ROOT);
                    switch (lowerCase.hashCode()) {
                        case -2075718416:
                            if (lowerCase.equals("guideline")) {
                            }
                            break;
                        case -190376483:
                            if (lowerCase.equals("constraint")) {
                            }
                            break;
                        case 426575017:
                            if (lowerCase.equals("constraintoverride")) {
                            }
                            break;
                        case 2146106725:
                            if (lowerCase.equals("constraintset")) {
                            }
                            break;
                    }
                    if (r4 == 0) {
                        return;
                    }
                    if (r4 == 1 || r4 == 2 || r4 == 3) {
                        this.f3869e.put(Integer.valueOf(aVarI.f3870a), aVarI);
                        aVarI = null;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }
}
