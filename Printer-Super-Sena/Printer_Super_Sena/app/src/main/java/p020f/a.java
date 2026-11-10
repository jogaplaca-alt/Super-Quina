package p020f;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.a0;
import androidx.core.content.res.k;
import androidx.vectordrawable.graphics.drawable.i;
import androidx.vectordrawable.graphics.drawable.q;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p046n.h;

/* JADX INFO: loaded from: classes.dex */
public class a extends p020f.e implements androidx.core.graphics.drawable.b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private c f9459o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private g f9460p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9461q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f9462r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f9463s;

    private static class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Animatable f9464a;

        b(Animatable animatable) {
            super();
            this.f9464a = animatable;
        }

        @Override // f.a.g
        public void c() {
            this.f9464a.start();
        }

        @Override // f.a.g
        public void d() {
            this.f9464a.stop();
        }
    }

    static class c extends f.e.a {

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        p046n.d f9465K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        h f9466L;

        c(c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            if (cVar != null) {
                this.f9465K = cVar.f9465K;
                this.f9466L = cVar.f9466L;
            } else {
                this.f9465K = new p046n.d();
                this.f9466L = new h();
            }
        }

        private static long D(int i3, int i4) {
            return ((long) i4) | (((long) i3) << 32);
        }

        int B(int[] iArr, Drawable drawable, int i3) {
            int iZ = super.z(iArr, drawable);
            this.f9466L.j(iZ, Integer.valueOf(i3));
            return iZ;
        }

        int C(int i3, int i4, Drawable drawable, boolean z3) {
            int iA = super.a(drawable);
            long jD = D(i3, i4);
            long j3 = z3 ? 8589934592L : 0L;
            long j4 = iA;
            this.f9465K.a(jD, Long.valueOf(j4 | j3));
            if (z3) {
                this.f9465K.a(D(i4, i3), Long.valueOf(4294967296L | j4 | j3));
            }
            return iA;
        }

        int E(int i3) {
            if (i3 < 0) {
                return 0;
            }
            return ((Integer) this.f9466L.g(i3, 0)).intValue();
        }

        int F(int[] iArr) {
            int iA = super.A(iArr);
            return iA >= 0 ? iA : super.A(StateSet.WILD_CARD);
        }

        int G(int i3, int i4) {
            return (int) ((Long) this.f9465K.h(D(i3, i4), -1L)).longValue();
        }

        boolean H(int i3, int i4) {
            return (((Long) this.f9465K.h(D(i3, i4), -1L)).longValue() & 4294967296L) != 0;
        }

        boolean I(int i3, int i4) {
            return (((Long) this.f9465K.h(D(i3, i4), -1L)).longValue() & 8589934592L) != 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // f.e.a, f.b.d
        void r() {
            this.f9465K = this.f9465K.clone();
            this.f9466L = this.f9466L.clone();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    private static class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final i f9467a;

        d(i iVar) {
            super();
            this.f9467a = iVar;
        }

        @Override // f.a.g
        public void c() {
            this.f9467a.start();
        }

        @Override // f.a.g
        public void d() {
            this.f9467a.stop();
        }
    }

    private static class e extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ObjectAnimator f9468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f9469b;

        e(AnimationDrawable animationDrawable, boolean z3, boolean z4) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i3 = z3 ? numberOfFrames - 1 : 0;
            int i4 = z3 ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z3);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i3, i4);
            p024g.b.a(objectAnimatorOfInt, true);
            objectAnimatorOfInt.setDuration(fVar.a());
            objectAnimatorOfInt.setInterpolator(fVar);
            this.f9469b = z4;
            this.f9468a = objectAnimatorOfInt;
        }

        @Override // f.a.g
        public boolean a() {
            return this.f9469b;
        }

        @Override // f.a.g
        public void b() {
            this.f9468a.reverse();
        }

        @Override // f.a.g
        public void c() {
            this.f9468a.start();
        }

        @Override // f.a.g
        public void d() {
            this.f9468a.cancel();
        }
    }

    private static class f implements TimeInterpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int[] f9470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f9471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f9472c;

        f(AnimationDrawable animationDrawable, boolean z3) {
            b(animationDrawable, z3);
        }

        int a() {
            return this.f9472c;
        }

        int b(AnimationDrawable animationDrawable, boolean z3) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f9471b = numberOfFrames;
            int[] iArr = this.f9470a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f9470a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f9470a;
            int i3 = 0;
            for (int i4 = 0; i4 < numberOfFrames; i4++) {
                int duration = animationDrawable.getDuration(z3 ? (numberOfFrames - i4) - 1 : i4);
                iArr2[i4] = duration;
                i3 += duration;
            }
            this.f9472c = i3;
            return i3;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            int i3 = (int) ((f3 * this.f9472c) + 0.5f);
            int i4 = this.f9471b;
            int[] iArr = this.f9470a;
            int i5 = 0;
            while (i5 < i4) {
                int i6 = iArr[i5];
                if (i3 < i6) {
                    break;
                }
                i3 -= i6;
                i5++;
            }
            return (i5 / i4) + (i5 < i4 ? i3 / this.f9472c : 0.0f);
        }
    }

    public a() {
        this(null, null);
    }

    public static a l(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.m(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    p(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    q(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private void o() {
        onStateChange(getState());
    }

    private int p(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayK = k.k(resources, theme, attributeSet, p024g.e.f9579h);
        int resourceId = typedArrayK.getResourceId(p024g.e.f9580i, 0);
        int resourceId2 = typedArrayK.getResourceId(p024g.e.f9581j, -1);
        Drawable drawableJ = resourceId2 > 0 ? a0.h().j(context, resourceId2) : null;
        typedArrayK.recycle();
        int[] iArrJ = j(attributeSet);
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            if (xmlPullParser.getName().equals("vector")) {
                drawableJ = q.c(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableJ = Build.VERSION.SDK_INT >= 21 ? p024g.c.a(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableJ != null) {
            return this.f9459o.B(iArrJ, drawableJ, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayK = k.k(resources, theme, attributeSet, p024g.e.f9582k);
        int resourceId = typedArrayK.getResourceId(p024g.e.f9585n, -1);
        int resourceId2 = typedArrayK.getResourceId(p024g.e.f9584m, -1);
        int resourceId3 = typedArrayK.getResourceId(p024g.e.f9583l, -1);
        Drawable drawableJ = resourceId3 > 0 ? a0.h().j(context, resourceId3) : null;
        boolean z3 = typedArrayK.getBoolean(p024g.e.f9586o, false);
        typedArrayK.recycle();
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            if (xmlPullParser.getName().equals("animated-vector")) {
                drawableJ = i.b(context, resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableJ = Build.VERSION.SDK_INT >= 21 ? p024g.c.a(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableJ == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.f9459o.C(resourceId, resourceId2, drawableJ, z3);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    }

    private boolean r(int i3) {
        int iC;
        int iG;
        g bVar;
        g gVar = this.f9460p;
        if (gVar == null) {
            iC = c();
        } else {
            if (i3 == this.f9461q) {
                return true;
            }
            if (i3 == this.f9462r && gVar.a()) {
                gVar.b();
                this.f9461q = this.f9462r;
                this.f9462r = i3;
                return true;
            }
            iC = this.f9461q;
            gVar.d();
        }
        this.f9460p = null;
        this.f9462r = -1;
        this.f9461q = -1;
        c cVar = this.f9459o;
        int iE = cVar.E(iC);
        int iE2 = cVar.E(i3);
        if (iE2 == 0 || iE == 0 || (iG = cVar.G(iE, iE2)) < 0) {
            return false;
        }
        boolean zI = cVar.I(iE, iE2);
        g(iG);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.H(iE, iE2), zI);
        } else {
            if (!(current instanceof i)) {
                if (current instanceof Animatable) {
                    bVar = new b((Animatable) current);
                }
                return false;
            }
            bVar = new d((i) current);
        }
        bVar.c();
        this.f9460p = bVar;
        this.f9462r = iC;
        this.f9461q = i3;
        return true;
    }

    private void s(TypedArray typedArray) {
        c cVar = this.f9459o;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.f9499d |= p024g.c.b(typedArray);
        }
        cVar.x(typedArray.getBoolean(p024g.e.f9575d, cVar.f9504i));
        cVar.t(typedArray.getBoolean(p024g.e.f9576e, cVar.f9507l));
        cVar.u(typedArray.getInt(p024g.e.f9577f, cVar.f9487A));
        cVar.v(typedArray.getInt(p024g.e.f9578g, cVar.f9488B));
        setDither(typedArray.getBoolean(p024g.e.f9573b, cVar.f9519x));
    }

    @Override // p020f.e, p020f.b
    void h(f.b.d dVar) {
        super.h(dVar);
        if (dVar instanceof c) {
            this.f9459o = (c) dVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // p020f.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.f9460p;
        if (gVar != null) {
            gVar.d();
            this.f9460p = null;
            g(this.f9461q);
            this.f9461q = -1;
            this.f9462r = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // p020f.b
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public c b() {
        return new c(this.f9459o, this, null);
    }

    public void m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayK = k.k(resources, theme, attributeSet, p024g.e.f9572a);
        setVisible(typedArrayK.getBoolean(p024g.e.f9574c, true), true);
        s(typedArrayK);
        i(resources);
        typedArrayK.recycle();
        n(context, resources, xmlPullParser, attributeSet, theme);
        o();
    }

    @Override // p020f.e, p020f.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f9463s && super.mutate() == this) {
            this.f9459o.r();
            this.f9463s = true;
        }
        return this;
    }

    @Override // p020f.e, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int iF = this.f9459o.F(iArr);
        boolean z3 = iF != c() && (r(iF) || g(iF));
        Drawable current = getCurrent();
        return current != null ? z3 | current.setState(iArr) : z3;
    }

    @Override // p020f.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        boolean visible = super.setVisible(z3, z4);
        g gVar = this.f9460p;
        if (gVar != null && (visible || z4)) {
            if (z3) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    a(c cVar, Resources resources) {
        super(null);
        this.f9461q = -1;
        this.f9462r = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    private static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public abstract void c();

        public abstract void d();

        public void b() {
        }
    }
}
