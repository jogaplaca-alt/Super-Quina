package U0;

import S0.h;
import S0.i;
import S0.j;
import S0.k;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.material.internal.C;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f2001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f2002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final float f2003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final float f2004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final float f2005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final float f2006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final float f2007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final float f2008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int f2009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final int f2010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f2011k;

    d(Context context, int i3, int i4, int i5, a aVar) {
        a aVar2 = new a();
        this.f2002b = aVar2;
        aVar = aVar == null ? new a() : aVar;
        if (i3 != 0) {
            aVar.f2016a = i3;
        }
        TypedArray typedArrayA = a(context, aVar.f2016a, i4, i5);
        Resources resources = context.getResources();
        this.f2003c = typedArrayA.getDimensionPixelSize(k.f1775K, -1);
        this.f2009i = context.getResources().getDimensionPixelSize(S0.c.f1554N);
        this.f2010j = context.getResources().getDimensionPixelSize(S0.c.f1556P);
        this.f2004d = typedArrayA.getDimensionPixelSize(k.f1805U, -1);
        int i6 = k.f1799S;
        int i7 = S0.c.f1591o;
        this.f2005e = typedArrayA.getDimension(i6, resources.getDimension(i7));
        int i8 = k.f1814X;
        int i9 = S0.c.f1592p;
        this.f2007g = typedArrayA.getDimension(i8, resources.getDimension(i9));
        this.f2006f = typedArrayA.getDimension(k.f1772J, resources.getDimension(i7));
        this.f2008h = typedArrayA.getDimension(k.f1802T, resources.getDimension(i9));
        boolean z3 = true;
        this.f2011k = typedArrayA.getInt(k.f1840e0, 1);
        aVar2.f2024i = aVar.f2024i == -2 ? 255 : aVar.f2024i;
        if (aVar.f2026k != -2) {
            aVar2.f2026k = aVar.f2026k;
        } else {
            int i10 = k.f1836d0;
            if (typedArrayA.hasValue(i10)) {
                aVar2.f2026k = typedArrayA.getInt(i10, 0);
            } else {
                aVar2.f2026k = -1;
            }
        }
        if (aVar.f2025j != null) {
            aVar2.f2025j = aVar.f2025j;
        } else {
            int i11 = k.f1784N;
            if (typedArrayA.hasValue(i11)) {
                aVar2.f2025j = typedArrayA.getString(i11);
            }
        }
        aVar2.f2030o = aVar.f2030o;
        aVar2.f2031p = aVar.f2031p == null ? context.getString(i.f1697j) : aVar.f2031p;
        aVar2.f2032q = aVar.f2032q == 0 ? h.f1685a : aVar.f2032q;
        aVar2.f2033r = aVar.f2033r == 0 ? i.f1702o : aVar.f2033r;
        if (aVar.f2035t != null && !aVar.f2035t.booleanValue()) {
            z3 = false;
        }
        aVar2.f2035t = Boolean.valueOf(z3);
        aVar2.f2027l = aVar.f2027l == -2 ? typedArrayA.getInt(k.f1828b0, -2) : aVar.f2027l;
        aVar2.f2028m = aVar.f2028m == -2 ? typedArrayA.getInt(k.f1832c0, -2) : aVar.f2028m;
        aVar2.f2020e = Integer.valueOf(aVar.f2020e == null ? typedArrayA.getResourceId(k.f1778L, j.f1714a) : aVar.f2020e.intValue());
        aVar2.f2021f = Integer.valueOf(aVar.f2021f == null ? typedArrayA.getResourceId(k.f1781M, 0) : aVar.f2021f.intValue());
        aVar2.f2022g = Integer.valueOf(aVar.f2022g == null ? typedArrayA.getResourceId(k.f1808V, j.f1714a) : aVar.f2022g.intValue());
        aVar2.f2023h = Integer.valueOf(aVar.f2023h == null ? typedArrayA.getResourceId(k.f1811W, 0) : aVar.f2023h.intValue());
        aVar2.f2017b = Integer.valueOf(aVar.f2017b == null ? G(context, typedArrayA, k.f1766H) : aVar.f2017b.intValue());
        aVar2.f2019d = Integer.valueOf(aVar.f2019d == null ? typedArrayA.getResourceId(k.f1787O, j.f1717d) : aVar.f2019d.intValue());
        if (aVar.f2018c != null) {
            aVar2.f2018c = aVar.f2018c;
        } else {
            int i12 = k.f1790P;
            if (typedArrayA.hasValue(i12)) {
                aVar2.f2018c = Integer.valueOf(G(context, typedArrayA, i12));
            } else {
                aVar2.f2018c = Integer.valueOf(new p030h1.d(context, aVar2.f2019d.intValue()).i().getDefaultColor());
            }
        }
        aVar2.f2034s = Integer.valueOf(aVar.f2034s == null ? typedArrayA.getInt(k.f1769I, 8388661) : aVar.f2034s.intValue());
        aVar2.f2036u = Integer.valueOf(aVar.f2036u == null ? typedArrayA.getDimensionPixelSize(k.f1796R, resources.getDimensionPixelSize(S0.c.f1555O)) : aVar.f2036u.intValue());
        aVar2.f2037v = Integer.valueOf(aVar.f2037v == null ? typedArrayA.getDimensionPixelSize(k.f1793Q, resources.getDimensionPixelSize(S0.c.f1593q)) : aVar.f2037v.intValue());
        aVar2.f2038w = Integer.valueOf(aVar.f2038w == null ? typedArrayA.getDimensionPixelOffset(k.f1817Y, 0) : aVar.f2038w.intValue());
        aVar2.f2039x = Integer.valueOf(aVar.f2039x == null ? typedArrayA.getDimensionPixelOffset(k.f1844f0, 0) : aVar.f2039x.intValue());
        aVar2.f2040y = Integer.valueOf(aVar.f2040y == null ? typedArrayA.getDimensionPixelOffset(k.f1820Z, aVar2.f2038w.intValue()) : aVar.f2040y.intValue());
        aVar2.f2041z = Integer.valueOf(aVar.f2041z == null ? typedArrayA.getDimensionPixelOffset(k.f1848g0, aVar2.f2039x.intValue()) : aVar.f2041z.intValue());
        aVar2.f2014C = Integer.valueOf(aVar.f2014C == null ? typedArrayA.getDimensionPixelOffset(k.f1824a0, 0) : aVar.f2014C.intValue());
        aVar2.f2012A = Integer.valueOf(aVar.f2012A == null ? 0 : aVar.f2012A.intValue());
        aVar2.f2013B = Integer.valueOf(aVar.f2013B == null ? 0 : aVar.f2013B.intValue());
        aVar2.f2015D = Boolean.valueOf(aVar.f2015D == null ? typedArrayA.getBoolean(k.f1762G, false) : aVar.f2015D.booleanValue());
        typedArrayA.recycle();
        if (aVar.f2029n == null) {
            aVar2.f2029n = Build.VERSION.SDK_INT >= 24 ? Locale.getDefault(Locale.Category.FORMAT) : Locale.getDefault();
        } else {
            aVar2.f2029n = aVar.f2029n;
        }
        this.f2001a = aVar;
    }

    private static int G(Context context, TypedArray typedArray, int i3) {
        return p030h1.c.a(context, typedArray, i3).getDefaultColor();
    }

    private TypedArray a(Context context, int i3, int i4, int i5) {
        AttributeSet attributeSet;
        int styleAttribute;
        if (i3 != 0) {
            AttributeSet attributeSetI = com.google.android.material.drawable.h.i(context, i3, "badge");
            styleAttribute = attributeSetI.getStyleAttribute();
            attributeSet = attributeSetI;
        } else {
            attributeSet = null;
            styleAttribute = 0;
        }
        return C.i(context, attributeSet, k.f1758F, i4, styleAttribute == 0 ? i5 : styleAttribute, new int[0]);
    }

    int A() {
        return this.f2002b.f2041z.intValue();
    }

    int B() {
        return this.f2002b.f2039x.intValue();
    }

    boolean C() {
        return this.f2002b.f2026k != -1;
    }

    boolean D() {
        return this.f2002b.f2025j != null;
    }

    boolean E() {
        return this.f2002b.f2015D.booleanValue();
    }

    boolean F() {
        return this.f2002b.f2035t.booleanValue();
    }

    void H(int i3) {
        this.f2001a.f2024i = i3;
        this.f2002b.f2024i = i3;
    }

    int b() {
        return this.f2002b.f2012A.intValue();
    }

    int c() {
        return this.f2002b.f2013B.intValue();
    }

    int d() {
        return this.f2002b.f2024i;
    }

    int e() {
        return this.f2002b.f2017b.intValue();
    }

    int f() {
        return this.f2002b.f2034s.intValue();
    }

    int g() {
        return this.f2002b.f2036u.intValue();
    }

    int h() {
        return this.f2002b.f2021f.intValue();
    }

    int i() {
        return this.f2002b.f2020e.intValue();
    }

    int j() {
        return this.f2002b.f2018c.intValue();
    }

    int k() {
        return this.f2002b.f2037v.intValue();
    }

    int l() {
        return this.f2002b.f2023h.intValue();
    }

    int m() {
        return this.f2002b.f2022g.intValue();
    }

    int n() {
        return this.f2002b.f2033r;
    }

    CharSequence o() {
        return this.f2002b.f2030o;
    }

    CharSequence p() {
        return this.f2002b.f2031p;
    }

    int q() {
        return this.f2002b.f2032q;
    }

    int r() {
        return this.f2002b.f2040y.intValue();
    }

    int s() {
        return this.f2002b.f2038w.intValue();
    }

    int t() {
        return this.f2002b.f2014C.intValue();
    }

    int u() {
        return this.f2002b.f2027l;
    }

    int v() {
        return this.f2002b.f2028m;
    }

    int w() {
        return this.f2002b.f2026k;
    }

    Locale x() {
        return this.f2002b.f2029n;
    }

    String y() {
        return this.f2002b.f2025j;
    }

    int z() {
        return this.f2002b.f2019d.intValue();
    }

    public static final class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new C0027a();

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        private Integer f2012A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        private Integer f2013B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        private Integer f2014C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        private Boolean f2015D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f2017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer f2018c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f2019d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Integer f2020e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Integer f2021f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Integer f2022g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Integer f2023h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f2024i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f2025j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f2026k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f2027l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f2028m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Locale f2029n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private CharSequence f2030o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private CharSequence f2031p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f2032q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f2033r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private Integer f2034s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private Boolean f2035t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private Integer f2036u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private Integer f2037v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private Integer f2038w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private Integer f2039x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private Integer f2040y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private Integer f2041z;

        /* JADX INFO: renamed from: U0.d$a$a, reason: collision with other inner class name */
        class C0027a implements Parcelable.Creator {
            C0027a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i3) {
                return new a[i3];
            }
        }

        public a() {
            this.f2024i = 255;
            this.f2026k = -2;
            this.f2027l = -2;
            this.f2028m = -2;
            this.f2035t = Boolean.TRUE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f2016a);
            parcel.writeSerializable(this.f2017b);
            parcel.writeSerializable(this.f2018c);
            parcel.writeSerializable(this.f2019d);
            parcel.writeSerializable(this.f2020e);
            parcel.writeSerializable(this.f2021f);
            parcel.writeSerializable(this.f2022g);
            parcel.writeSerializable(this.f2023h);
            parcel.writeInt(this.f2024i);
            parcel.writeString(this.f2025j);
            parcel.writeInt(this.f2026k);
            parcel.writeInt(this.f2027l);
            parcel.writeInt(this.f2028m);
            CharSequence charSequence = this.f2030o;
            parcel.writeString(charSequence != null ? charSequence.toString() : null);
            CharSequence charSequence2 = this.f2031p;
            parcel.writeString(charSequence2 != null ? charSequence2.toString() : null);
            parcel.writeInt(this.f2032q);
            parcel.writeSerializable(this.f2034s);
            parcel.writeSerializable(this.f2036u);
            parcel.writeSerializable(this.f2037v);
            parcel.writeSerializable(this.f2038w);
            parcel.writeSerializable(this.f2039x);
            parcel.writeSerializable(this.f2040y);
            parcel.writeSerializable(this.f2041z);
            parcel.writeSerializable(this.f2014C);
            parcel.writeSerializable(this.f2012A);
            parcel.writeSerializable(this.f2013B);
            parcel.writeSerializable(this.f2035t);
            parcel.writeSerializable(this.f2029n);
            parcel.writeSerializable(this.f2015D);
        }

        a(Parcel parcel) {
            this.f2024i = 255;
            this.f2026k = -2;
            this.f2027l = -2;
            this.f2028m = -2;
            this.f2035t = Boolean.TRUE;
            this.f2016a = parcel.readInt();
            this.f2017b = (Integer) parcel.readSerializable();
            this.f2018c = (Integer) parcel.readSerializable();
            this.f2019d = (Integer) parcel.readSerializable();
            this.f2020e = (Integer) parcel.readSerializable();
            this.f2021f = (Integer) parcel.readSerializable();
            this.f2022g = (Integer) parcel.readSerializable();
            this.f2023h = (Integer) parcel.readSerializable();
            this.f2024i = parcel.readInt();
            this.f2025j = parcel.readString();
            this.f2026k = parcel.readInt();
            this.f2027l = parcel.readInt();
            this.f2028m = parcel.readInt();
            this.f2030o = parcel.readString();
            this.f2031p = parcel.readString();
            this.f2032q = parcel.readInt();
            this.f2034s = (Integer) parcel.readSerializable();
            this.f2036u = (Integer) parcel.readSerializable();
            this.f2037v = (Integer) parcel.readSerializable();
            this.f2038w = (Integer) parcel.readSerializable();
            this.f2039x = (Integer) parcel.readSerializable();
            this.f2040y = (Integer) parcel.readSerializable();
            this.f2041z = (Integer) parcel.readSerializable();
            this.f2014C = (Integer) parcel.readSerializable();
            this.f2012A = (Integer) parcel.readSerializable();
            this.f2013B = (Integer) parcel.readSerializable();
            this.f2035t = (Boolean) parcel.readSerializable();
            this.f2029n = (Locale) parcel.readSerializable();
            this.f2015D = (Boolean) parcel.readSerializable();
        }
    }
}
