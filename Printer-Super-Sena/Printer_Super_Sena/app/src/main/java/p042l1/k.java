package p042l1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final p042l1.c f9903m = new i(0.5f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    d f9904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    d f9905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    d f9906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    d f9907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    p042l1.c f9908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    p042l1.c f9909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    p042l1.c f9910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    p042l1.c f9911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    f f9912i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    f f9913j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    f f9914k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    f f9915l;

    public interface c {
        p042l1.c a(p042l1.c cVar);
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i3, int i4) {
        return c(context, i3, i4, 0);
    }

    private static b c(Context context, int i3, int i4, int i5) {
        return d(context, i3, i4, new p042l1.a(i5));
    }

    private static b d(Context context, int i3, int i4, p042l1.c cVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i3);
        if (i4 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i4);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(S0.k.E5);
        try {
            int i5 = typedArrayObtainStyledAttributes.getInt(S0.k.F5, 0);
            int i6 = typedArrayObtainStyledAttributes.getInt(S0.k.I5, i5);
            int i7 = typedArrayObtainStyledAttributes.getInt(S0.k.J5, i5);
            int i8 = typedArrayObtainStyledAttributes.getInt(S0.k.H5, i5);
            int i9 = typedArrayObtainStyledAttributes.getInt(S0.k.G5, i5);
            p042l1.c cVarM = m(typedArrayObtainStyledAttributes, S0.k.K5, cVar);
            p042l1.c cVarM2 = m(typedArrayObtainStyledAttributes, S0.k.N5, cVarM);
            p042l1.c cVarM3 = m(typedArrayObtainStyledAttributes, S0.k.O5, cVarM);
            p042l1.c cVarM4 = m(typedArrayObtainStyledAttributes, S0.k.M5, cVarM);
            return new b().y(i6, cVarM2).C(i7, cVarM3).u(i8, cVarM4).q(i9, m(typedArrayObtainStyledAttributes, S0.k.L5, cVarM));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i3, int i4) {
        return f(context, attributeSet, i3, i4, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i3, int i4, int i5) {
        return g(context, attributeSet, i3, i4, new p042l1.a(i5));
    }

    public static b g(Context context, AttributeSet attributeSet, int i3, int i4, p042l1.c cVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, S0.k.a4, i3, i4);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(S0.k.b4, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(S0.k.c4, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    private static p042l1.c m(TypedArray typedArray, int i3, p042l1.c cVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i3);
        if (typedValuePeekValue == null) {
            return cVar;
        }
        int i4 = typedValuePeekValue.type;
        if (i4 == 5) {
            return new p042l1.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i4 == 6 ? new i(typedValuePeekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public f h() {
        return this.f9914k;
    }

    public d i() {
        return this.f9907d;
    }

    public p042l1.c j() {
        return this.f9911h;
    }

    public d k() {
        return this.f9906c;
    }

    public p042l1.c l() {
        return this.f9910g;
    }

    public f n() {
        return this.f9915l;
    }

    public f o() {
        return this.f9913j;
    }

    public f p() {
        return this.f9912i;
    }

    public d q() {
        return this.f9904a;
    }

    public p042l1.c r() {
        return this.f9908e;
    }

    public d s() {
        return this.f9905b;
    }

    public p042l1.c t() {
        return this.f9909f;
    }

    public boolean u(RectF rectF) {
        boolean z3 = this.f9915l.getClass().equals(f.class) && this.f9913j.getClass().equals(f.class) && this.f9912i.getClass().equals(f.class) && this.f9914k.getClass().equals(f.class);
        float fA = this.f9908e.a(rectF);
        return z3 && ((this.f9909f.a(rectF) > fA ? 1 : (this.f9909f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f9911h.a(rectF) > fA ? 1 : (this.f9911h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f9910g.a(rectF) > fA ? 1 : (this.f9910g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f9905b instanceof j) && (this.f9904a instanceof j) && (this.f9906c instanceof j) && (this.f9907d instanceof j));
    }

    public b v() {
        return new b(this);
    }

    public k w(float f3) {
        return v().o(f3).m();
    }

    public k x(p042l1.c cVar) {
        return v().p(cVar).m();
    }

    public k y(c cVar) {
        return v().B(cVar.a(r())).F(cVar.a(t())).t(cVar.a(j())).x(cVar.a(l())).m();
    }

    private k(b bVar) {
        this.f9904a = bVar.f9916a;
        this.f9905b = bVar.f9917b;
        this.f9906c = bVar.f9918c;
        this.f9907d = bVar.f9919d;
        this.f9908e = bVar.f9920e;
        this.f9909f = bVar.f9921f;
        this.f9910g = bVar.f9922g;
        this.f9911h = bVar.f9923h;
        this.f9912i = bVar.f9924i;
        this.f9913j = bVar.f9925j;
        this.f9914k = bVar.f9926k;
        this.f9915l = bVar.f9927l;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f9916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f9917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private d f9918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d f9919d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private p042l1.c f9920e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private p042l1.c f9921f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private p042l1.c f9922g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private p042l1.c f9923h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private f f9924i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private f f9925j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private f f9926k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private f f9927l;

        public b() {
            this.f9916a = h.b();
            this.f9917b = h.b();
            this.f9918c = h.b();
            this.f9919d = h.b();
            this.f9920e = new p042l1.a(0.0f);
            this.f9921f = new p042l1.a(0.0f);
            this.f9922g = new p042l1.a(0.0f);
            this.f9923h = new p042l1.a(0.0f);
            this.f9924i = h.c();
            this.f9925j = h.c();
            this.f9926k = h.c();
            this.f9927l = h.c();
        }

        private static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).f9902a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f9850a;
            }
            return -1.0f;
        }

        public b A(float f3) {
            this.f9920e = new p042l1.a(f3);
            return this;
        }

        public b B(p042l1.c cVar) {
            this.f9920e = cVar;
            return this;
        }

        public b C(int i3, p042l1.c cVar) {
            return D(h.a(i3)).F(cVar);
        }

        public b D(d dVar) {
            this.f9917b = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                E(fN);
            }
            return this;
        }

        public b E(float f3) {
            this.f9921f = new p042l1.a(f3);
            return this;
        }

        public b F(p042l1.c cVar) {
            this.f9921f = cVar;
            return this;
        }

        public k m() {
            return new k(this);
        }

        public b o(float f3) {
            return A(f3).E(f3).w(f3).s(f3);
        }

        public b p(p042l1.c cVar) {
            return B(cVar).F(cVar).x(cVar).t(cVar);
        }

        public b q(int i3, p042l1.c cVar) {
            return r(h.a(i3)).t(cVar);
        }

        public b r(d dVar) {
            this.f9919d = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                s(fN);
            }
            return this;
        }

        public b s(float f3) {
            this.f9923h = new p042l1.a(f3);
            return this;
        }

        public b t(p042l1.c cVar) {
            this.f9923h = cVar;
            return this;
        }

        public b u(int i3, p042l1.c cVar) {
            return v(h.a(i3)).x(cVar);
        }

        public b v(d dVar) {
            this.f9918c = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                w(fN);
            }
            return this;
        }

        public b w(float f3) {
            this.f9922g = new p042l1.a(f3);
            return this;
        }

        public b x(p042l1.c cVar) {
            this.f9922g = cVar;
            return this;
        }

        public b y(int i3, p042l1.c cVar) {
            return z(h.a(i3)).B(cVar);
        }

        public b z(d dVar) {
            this.f9916a = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                A(fN);
            }
            return this;
        }

        public b(k kVar) {
            this.f9916a = h.b();
            this.f9917b = h.b();
            this.f9918c = h.b();
            this.f9919d = h.b();
            this.f9920e = new p042l1.a(0.0f);
            this.f9921f = new p042l1.a(0.0f);
            this.f9922g = new p042l1.a(0.0f);
            this.f9923h = new p042l1.a(0.0f);
            this.f9924i = h.c();
            this.f9925j = h.c();
            this.f9926k = h.c();
            this.f9927l = h.c();
            this.f9916a = kVar.f9904a;
            this.f9917b = kVar.f9905b;
            this.f9918c = kVar.f9906c;
            this.f9919d = kVar.f9907d;
            this.f9920e = kVar.f9908e;
            this.f9921f = kVar.f9909f;
            this.f9922g = kVar.f9910g;
            this.f9923h = kVar.f9911h;
            this.f9924i = kVar.f9912i;
            this.f9925j = kVar.f9913j;
            this.f9926k = kVar.f9914k;
            this.f9927l = kVar.f9915l;
        }
    }

    public k() {
        this.f9904a = h.b();
        this.f9905b = h.b();
        this.f9906c = h.b();
        this.f9907d = h.b();
        this.f9908e = new p042l1.a(0.0f);
        this.f9909f = new p042l1.a(0.0f);
        this.f9910g = new p042l1.a(0.0f);
        this.f9911h = new p042l1.a(0.0f);
        this.f9912i = h.c();
        this.f9913j = h.c();
        this.f9914k = h.c();
        this.f9915l = h.c();
    }
}
