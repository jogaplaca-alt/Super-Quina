package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static a0 f3418i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakHashMap f3420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private p046n.g f3421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p046n.h f3422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakHashMap f3423d = new WeakHashMap(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TypedValue f3424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private f f3426g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final PorterDuff.Mode f3417h = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final c f3419j = new c(6);

    static class a implements e {
        a() {
        }

        @Override // androidx.appcompat.widget.a0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return p020f.a.l(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e3) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e3);
                return null;
            }
        }
    }

    private static class b implements e {
        b() {
        }

        @Override // androidx.appcompat.widget.a0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.i.b(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e3) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e3);
                return null;
            }
        }
    }

    private static class c extends p046n.e {
        public c(int i3) {
            super(i3);
        }

        private static int h(int i3, PorterDuff.Mode mode) {
            return ((i3 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter i(int i3, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) c(Integer.valueOf(h(i3, mode)));
        }

        PorterDuffColorFilter j(int i3, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) d(Integer.valueOf(h(i3, mode)), porterDuffColorFilter);
        }
    }

    static class d implements e {
        d() {
        }

        @Override // androidx.appcompat.widget.a0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(null).newInstance(null);
                    if (Build.VERSION.SDK_INT >= 21) {
                        p024g.c.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    } else {
                        drawable.inflate(context.getResources(), xmlPullParser, attributeSet);
                    }
                    return drawable;
                } catch (Exception e3) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e3);
                }
            }
            return null;
        }
    }

    private interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface f {
        Drawable a(a0 a0Var, Context context, int i3);

        boolean b(Context context, int i3, Drawable drawable);

        ColorStateList c(Context context, int i3);

        boolean d(Context context, int i3, Drawable drawable);

        PorterDuff.Mode e(int i3);
    }

    private static class g implements e {
        g() {
        }

        @Override // androidx.appcompat.widget.a0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.q.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e3) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e3);
                return null;
            }
        }
    }

    private void a(String str, e eVar) {
        if (this.f3421b == null) {
            this.f3421b = new p046n.g();
        }
        this.f3421b.put(str, eVar);
    }

    private synchronized boolean b(Context context, long j3, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            p046n.d dVar = (p046n.d) this.f3423d.get(context);
            if (dVar == null) {
                dVar = new p046n.d();
                this.f3423d.put(context, dVar);
            }
            dVar.l(j3, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void c(Context context, int i3, ColorStateList colorStateList) {
        if (this.f3420a == null) {
            this.f3420a = new WeakHashMap();
        }
        p046n.h hVar = (p046n.h) this.f3420a.get(context);
        if (hVar == null) {
            hVar = new p046n.h();
            this.f3420a.put(context, hVar);
        }
        hVar.a(i3, colorStateList);
    }

    private void d(Context context) {
        if (this.f3425f) {
            return;
        }
        this.f3425f = true;
        Drawable drawableJ = j(context, p024g.d.f9571a);
        if (drawableJ == null || !q(drawableJ)) {
            this.f3425f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long e(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable f(Context context, int i3) {
        if (this.f3424e == null) {
            this.f3424e = new TypedValue();
        }
        TypedValue typedValue = this.f3424e;
        context.getResources().getValue(i3, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        f fVar = this.f3426g;
        Drawable drawableA = fVar == null ? null : fVar.a(this, context, i3);
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, jE, drawableA);
        }
        return drawableA;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized a0 h() {
        try {
            if (f3418i == null) {
                a0 a0Var = new a0();
                f3418i = a0Var;
                p(a0Var);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3418i;
    }

    private synchronized Drawable i(Context context, long j3) {
        p046n.d dVar = (p046n.d) this.f3423d.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) dVar.g(j3);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.m(j3);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i3, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterI;
        c cVar = f3419j;
        porterDuffColorFilterI = cVar.i(i3, mode);
        if (porterDuffColorFilterI == null) {
            porterDuffColorFilterI = new PorterDuffColorFilter(i3, mode);
            cVar.j(i3, mode, porterDuffColorFilterI);
        }
        return porterDuffColorFilterI;
    }

    private ColorStateList n(Context context, int i3) {
        p046n.h hVar;
        WeakHashMap weakHashMap = this.f3420a;
        if (weakHashMap == null || (hVar = (p046n.h) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) hVar.f(i3);
    }

    private static void p(a0 a0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            a0Var.a("vector", new g());
            a0Var.a("animated-vector", new b());
            a0Var.a("animated-selector", new a());
            a0Var.a("drawable", new d());
        }
    }

    private static boolean q(Drawable drawable) {
        return (drawable instanceof androidx.vectordrawable.graphics.drawable.q) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable r(Context context, int i3) {
        int next;
        p046n.g gVar = this.f3421b;
        if (gVar == null || gVar.isEmpty()) {
            return null;
        }
        p046n.h hVar = this.f3422c;
        if (hVar != null) {
            String str = (String) hVar.f(i3);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f3421b.get(str) == null)) {
                return null;
            }
        } else {
            this.f3422c = new p046n.h();
        }
        if (this.f3424e == null) {
            this.f3424e = new TypedValue();
        }
        TypedValue typedValue = this.f3424e;
        Resources resources = context.getResources();
        resources.getValue(i3, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i3);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f3422c.a(i3, name);
                e eVar = (e) this.f3421b.get(name);
                if (eVar != null) {
                    drawableI = eVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableI != null) {
                    drawableI.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, jE, drawableI);
                }
            } catch (Exception e3) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e3);
            }
        }
        if (drawableI == null) {
            this.f3422c.a(i3, "appcompat_skip_skip");
        }
        return drawableI;
    }

    private Drawable v(Context context, int i3, boolean z3, Drawable drawable) {
        ColorStateList colorStateListM = m(context, i3);
        if (colorStateListM == null) {
            f fVar = this.f3426g;
            if ((fVar == null || !fVar.d(context, i3, drawable)) && !x(context, i3, drawable) && z3) {
                return null;
            }
            return drawable;
        }
        if (S.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableR = androidx.core.graphics.drawable.a.r(drawable);
        androidx.core.graphics.drawable.a.o(drawableR, colorStateListM);
        PorterDuff.Mode modeO = o(i3);
        if (modeO == null) {
            return drawableR;
        }
        androidx.core.graphics.drawable.a.p(drawableR, modeO);
        return drawableR;
    }

    static void w(Drawable drawable, h0 h0Var, int[] iArr) {
        int[] state = drawable.getState();
        if (S.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z3 = h0Var.f3527d;
        if (z3 || h0Var.f3526c) {
            drawable.setColorFilter(g(z3 ? h0Var.f3524a : null, h0Var.f3526c ? h0Var.f3525b : f3417h, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public synchronized Drawable j(Context context, int i3) {
        return k(context, i3, false);
    }

    synchronized Drawable k(Context context, int i3, boolean z3) {
        Drawable drawableR;
        try {
            d(context);
            drawableR = r(context, i3);
            if (drawableR == null) {
                drawableR = f(context, i3);
            }
            if (drawableR == null) {
                drawableR = androidx.core.content.a.d(context, i3);
            }
            if (drawableR != null) {
                drawableR = v(context, i3, z3, drawableR);
            }
            if (drawableR != null) {
                S.b(drawableR);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableR;
    }

    synchronized ColorStateList m(Context context, int i3) {
        ColorStateList colorStateListN;
        colorStateListN = n(context, i3);
        if (colorStateListN == null) {
            f fVar = this.f3426g;
            colorStateListN = fVar == null ? null : fVar.c(context, i3);
            if (colorStateListN != null) {
                c(context, i3, colorStateListN);
            }
        }
        return colorStateListN;
    }

    PorterDuff.Mode o(int i3) {
        f fVar = this.f3426g;
        if (fVar == null) {
            return null;
        }
        return fVar.e(i3);
    }

    public synchronized void s(Context context) {
        p046n.d dVar = (p046n.d) this.f3423d.get(context);
        if (dVar != null) {
            dVar.b();
        }
    }

    synchronized Drawable t(Context context, t0 t0Var, int i3) {
        try {
            Drawable drawableR = r(context, i3);
            if (drawableR == null) {
                drawableR = t0Var.a(i3);
            }
            if (drawableR == null) {
                return null;
            }
            return v(context, i3, false, drawableR);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void u(f fVar) {
        this.f3426g = fVar;
    }

    boolean x(Context context, int i3, Drawable drawable) {
        f fVar = this.f3426g;
        return fVar != null && fVar.b(context, i3, drawable);
    }
}
