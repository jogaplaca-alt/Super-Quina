package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class i extends p implements Animatable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f6731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f6732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArgbEvaluator f6733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    d f6734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Animator.AnimatorListener f6735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList f6736g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Drawable.Callback f6737h;

    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            i.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
            i.this.scheduleSelf(runnable, j3);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            i.this.unscheduleSelf(runnable);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ArrayList arrayList = new ArrayList(i.this.f6736g);
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((androidx.vectordrawable.graphics.drawable.b) arrayList.get(i3)).b(i.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ArrayList arrayList = new ArrayList(i.this.f6736g);
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((androidx.vectordrawable.graphics.drawable.b) arrayList.get(i3)).c(i.this);
            }
        }
    }

    private static class c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        q f6741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        AnimatorSet f6742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList f6743d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        p046n.a f6744e;

        public c(Context context, c cVar, Drawable.Callback callback, Resources resources) {
            if (cVar != null) {
                this.f6740a = cVar.f6740a;
                q qVar = cVar.f6741b;
                if (qVar != null) {
                    Drawable.ConstantState constantState = qVar.getConstantState();
                    if (resources != null) {
                        this.f6741b = (q) constantState.newDrawable(resources);
                    } else {
                        this.f6741b = (q) constantState.newDrawable();
                    }
                    q qVar2 = (q) this.f6741b.mutate();
                    this.f6741b = qVar2;
                    qVar2.setCallback(callback);
                    this.f6741b.setBounds(cVar.f6741b.getBounds());
                    this.f6741b.h(false);
                }
                ArrayList arrayList = cVar.f6743d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f6743d = new ArrayList(size);
                    this.f6744e = new p046n.a(size);
                    for (int i3 = 0; i3 < size; i3++) {
                        Animator animator = (Animator) cVar.f6743d.get(i3);
                        Animator animatorClone = animator.clone();
                        String str = (String) cVar.f6744e.get(animator);
                        animatorClone.setTarget(this.f6741b.d(str));
                        this.f6743d.add(animatorClone);
                        this.f6744e.put(animatorClone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f6742c == null) {
                this.f6742c = new AnimatorSet();
            }
            this.f6742c.playTogether(this.f6743d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f6740a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    i() {
        this(null, null, null);
    }

    public static i a(Context context, int i3) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            i iVar = new i(context);
            Drawable drawableE = androidx.core.content.res.h.e(context.getResources(), i3, context.getTheme());
            iVar.f6750a = drawableE;
            drawableE.setCallback(iVar.f6737h);
            iVar.f6734e = new d(iVar.f6750a.getConstantState());
            return iVar;
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(i3);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return b(context, context.getResources(), xml, attributeSetAsAttributeSet, context.getTheme());
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e3) {
            Log.e("AnimatedVDCompat", "parser error", e3);
            return null;
        } catch (XmlPullParserException e4) {
            Log.e("AnimatedVDCompat", "parser error", e4);
            return null;
        }
    }

    public static i b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        i iVar = new i(context);
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    private static void d(AnimatedVectorDrawable animatedVectorDrawable, androidx.vectordrawable.graphics.drawable.b bVar) {
        animatedVectorDrawable.registerAnimationCallback(bVar.a());
    }

    private void e() {
        Animator.AnimatorListener animatorListener = this.f6735f;
        if (animatorListener != null) {
            this.f6731b.f6742c.removeListener(animatorListener);
            this.f6735f = null;
        }
    }

    private void f(String str, Animator animator) {
        animator.setTarget(this.f6731b.f6741b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            g(animator);
        }
        c cVar = this.f6731b;
        if (cVar.f6743d == null) {
            cVar.f6743d = new ArrayList();
            this.f6731b.f6744e = new p046n.a();
        }
        this.f6731b.f6743d.add(animator);
        this.f6731b.f6744e.put(animator, str);
    }

    private void g(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i3 = 0; i3 < childAnimations.size(); i3++) {
                g(childAnimations.get(i3));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f6733d == null) {
                    this.f6733d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f6733d);
            }
        }
    }

    private static boolean i(AnimatedVectorDrawable animatedVectorDrawable, androidx.vectordrawable.graphics.drawable.b bVar) {
        return animatedVectorDrawable.unregisterAnimationCallback(bVar.a());
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    public void c(androidx.vectordrawable.graphics.drawable.b bVar) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            d(androidx.vectordrawable.graphics.drawable.c.a(drawable), bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        if (this.f6736g == null) {
            this.f6736g = new ArrayList();
        }
        if (this.f6736g.contains(bVar)) {
            return;
        }
        this.f6736g.add(bVar);
        if (this.f6735f == null) {
            this.f6735f = new b();
        }
        this.f6731b.f6742c.addListener(this.f6735f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.b(drawable);
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f6731b.f6741b.draw(canvas);
        if (this.f6731b.f6742c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f6750a;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f6731b.f6741b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f6750a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f6731b.f6740a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f6750a;
        return drawable != null ? androidx.core.graphics.drawable.a.e(drawable) : this.f6731b.f6741b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f6750a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new d(this.f6750a.getConstantState());
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f6750a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f6731b.f6741b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f6750a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f6731b.f6741b.getIntrinsicWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f6750a;
        return drawable != null ? drawable.getOpacity() : this.f6731b.f6741b.getOpacity();
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public boolean h(androidx.vectordrawable.graphics.drawable.b bVar) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            i(androidx.vectordrawable.graphics.drawable.c.a(drawable), bVar);
        }
        ArrayList arrayList = this.f6736g;
        if (arrayList == null || bVar == null) {
            return false;
        }
        boolean zRemove = arrayList.remove(bVar);
        if (this.f6736g.size() == 0) {
            e();
        }
        return zRemove;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayK = androidx.core.content.res.k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f6721e);
                    int resourceId = typedArrayK.getResourceId(0, 0);
                    if (resourceId != 0) {
                        q qVarB = q.b(resources, resourceId, theme);
                        qVarB.h(false);
                        qVarB.setCallback(this.f6737h);
                        q qVar = this.f6731b.f6741b;
                        if (qVar != null) {
                            qVar.setCallback(null);
                        }
                        this.f6731b.f6741b = qVarB;
                    }
                    typedArrayK.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.vectordrawable.graphics.drawable.a.f6722f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f6732c;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        f(string, m.i(context, resourceId2));
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f6731b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f6750a;
        return drawable != null ? androidx.core.graphics.drawable.a.h(drawable) : this.f6731b.f6741b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f6750a;
        return drawable != null ? androidx.vectordrawable.graphics.drawable.c.a(drawable).isRunning() : this.f6731b.f6742c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f6750a;
        return drawable != null ? drawable.isStateful() : this.f6731b.f6741b.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f6731b.f6741b.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        Drawable drawable = this.f6750a;
        return drawable != null ? drawable.setLevel(i3) : this.f6731b.f6741b.setLevel(i3);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f6750a;
        return drawable != null ? drawable.setState(iArr) : this.f6731b.f6741b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            drawable.setAlpha(i3);
        } else {
            this.f6731b.f6741b.setAlpha(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z3) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z3);
        } else {
            this.f6731b.f6741b.setAutoMirrored(z3);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i3) {
        super.setChangingConfigurations(i3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i3, PorterDuff.Mode mode) {
        super.setColorFilter(i3, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z3) {
        super.setFilterBitmap(z3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f3, float f4) {
        super.setHotspot(f3, f4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i3, int i4, int i5, int i6) {
        super.setHotspotBounds(i3, i4, i5, i6);
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i3) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i3);
        } else {
            this.f6731b.f6741b.setTint(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        } else {
            this.f6731b.f6741b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
        } else {
            this.f6731b.f6741b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            return drawable.setVisible(z3, z4);
        }
        this.f6731b.f6741b.setVisible(z3, z4);
        return super.setVisible(z3, z4);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            androidx.vectordrawable.graphics.drawable.c.a(drawable).start();
        } else {
            if (this.f6731b.f6742c.isStarted()) {
                return;
            }
            this.f6731b.f6742c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            androidx.vectordrawable.graphics.drawable.c.a(drawable).stop();
        } else {
            this.f6731b.f6742c.end();
        }
    }

    private i(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f6731b.f6741b.setColorFilter(colorFilter);
        }
    }

    private static class d extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f6745a;

        public d(Drawable.ConstantState constantState) {
            this.f6745a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f6745a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f6745a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i();
            Drawable drawableNewDrawable = this.f6745a.newDrawable();
            iVar.f6750a = drawableNewDrawable;
            drawableNewDrawable.setCallback(iVar.f6737h);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            Drawable drawableNewDrawable = this.f6745a.newDrawable(resources);
            iVar.f6750a = drawableNewDrawable;
            drawableNewDrawable.setCallback(iVar.f6737h);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            Drawable drawableNewDrawable = this.f6745a.newDrawable(resources, theme);
            iVar.f6750a = drawableNewDrawable;
            drawableNewDrawable.setCallback(iVar.f6737h);
            return iVar;
        }
    }

    private i(Context context, c cVar, Resources resources) {
        this.f6733d = null;
        this.f6735f = null;
        this.f6736g = null;
        a aVar = new a();
        this.f6737h = aVar;
        this.f6732c = context;
        if (cVar != null) {
            this.f6731b = cVar;
        } else {
            this.f6731b = new c(context, cVar, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
