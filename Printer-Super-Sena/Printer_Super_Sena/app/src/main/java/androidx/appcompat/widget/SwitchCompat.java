package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private static final Property f3205S = new a(Float.class, "thumbPos");

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private static final int[] f3206T = {R.attr.state_checked};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private int f3207A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private int f3208B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private int f3209C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private int f3210D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private int f3211E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private int f3212F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private int f3213G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private boolean f3214H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private final TextPaint f3215I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private ColorStateList f3216J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private Layout f3217K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private Layout f3218L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private TransformationMethod f3219M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    ObjectAnimator f3220N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private final E f3221O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private C0269m f3222P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private c f3223Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private final Rect f3224R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f3225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f3226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f3227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f3230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ColorStateList f3231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private PorterDuff.Mode f3232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3233i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3234j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3235k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3236l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f3237m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f3238n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private CharSequence f3239o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f3240p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CharSequence f3241q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CharSequence f3242r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f3243s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f3244t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f3245u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f3246v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f3247w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private VelocityTracker f3248x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f3249y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    float f3250z;

    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f3250z);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f3) {
            switchCompat.setThumbPosition(f3.floatValue());
        }
    }

    static class b {
        static void a(ObjectAnimator objectAnimator, boolean z3) {
            objectAnimator.setAutoCancel(z3);
        }
    }

    static class c extends androidx.emoji2.text.e.AbstractC0069e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Reference f3251a;

        c(SwitchCompat switchCompat) {
            this.f3251a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.e.AbstractC0069e
        public void a(Throwable th) {
            SwitchCompat switchCompat = (SwitchCompat) this.f3251a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        @Override // androidx.emoji2.text.e.AbstractC0069e
        public void b() {
            SwitchCompat switchCompat = (SwitchCompat) this.f3251a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p012d.a.f9079L);
    }

    private void a(boolean z3) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<SwitchCompat, Float>) f3205S, z3 ? 1.0f : 0.0f);
        this.f3220N = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        b.a(this.f3220N, true);
        this.f3220N.start();
    }

    private void b() {
        Drawable drawable = this.f3225a;
        if (drawable != null) {
            if (this.f3228d || this.f3229e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
                this.f3225a = drawableMutate;
                if (this.f3228d) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f3226b);
                }
                if (this.f3229e) {
                    androidx.core.graphics.drawable.a.p(this.f3225a, this.f3227c);
                }
                if (this.f3225a.isStateful()) {
                    this.f3225a.setState(getDrawableState());
                }
            }
        }
    }

    private void c() {
        Drawable drawable = this.f3230f;
        if (drawable != null) {
            if (this.f3233i || this.f3234j) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
                this.f3230f = drawableMutate;
                if (this.f3233i) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f3231g);
                }
                if (this.f3234j) {
                    androidx.core.graphics.drawable.a.p(this.f3230f, this.f3232h);
                }
                if (this.f3230f.isStateful()) {
                    this.f3230f.setState(getDrawableState());
                }
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.f3220N;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private static float f(float f3, float f4, float f5) {
        if (f3 < f4) {
            return f4;
        }
        return f3 > f5 ? f5 : f3;
    }

    private CharSequence g(CharSequence charSequence) {
        TransformationMethod transformationMethodF = getEmojiTextViewHelper().f(this.f3219M);
        return transformationMethodF != null ? transformationMethodF.getTransformation(charSequence, this) : charSequence;
    }

    private C0269m getEmojiTextViewHelper() {
        if (this.f3222P == null) {
            this.f3222P = new C0269m(this);
        }
        return this.f3222P;
    }

    private boolean getTargetCheckedState() {
        return this.f3250z > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((u0.b(this) ? 1.0f - this.f3250z : this.f3250z) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f3230f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f3224R;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f3225a;
        Rect rectD = drawable2 != null ? S.d(drawable2) : S.f3125c;
        return ((((this.f3207A - this.f3209C) - rect.left) - rect.right) - rectD.left) - rectD.right;
    }

    private boolean h(float f3, float f4) {
        if (this.f3225a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f3225a.getPadding(this.f3224R);
        int i3 = this.f3211E;
        int i4 = this.f3245u;
        int i5 = i3 - i4;
        int i6 = (this.f3210D + thumbOffset) - i4;
        int i7 = this.f3209C + i6;
        Rect rect = this.f3224R;
        return f3 > ((float) i6) && f3 < ((float) (((i7 + rect.left) + rect.right) + i4)) && f4 > ((float) i5) && f4 < ((float) (this.f3213G + i4));
    }

    private Layout i(CharSequence charSequence) {
        TextPaint textPaint = this.f3215I;
        return new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void k() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f3241q;
            if (string == null) {
                string = getResources().getString(p012d.h.f9239b);
            }
            androidx.core.view.Z.I0(this, string);
        }
    }

    private void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f3239o;
            if (string == null) {
                string = getResources().getString(p012d.h.f9240c);
            }
            androidx.core.view.Z.I0(this, string);
        }
    }

    private void o(int i3, int i4) {
        Typeface typeface;
        if (i3 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i3 != 2) {
            typeface = i3 != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        n(typeface, i4);
    }

    private void p() {
        if (this.f3223Q == null && this.f3222P.b() && androidx.emoji2.text.e.h()) {
            androidx.emoji2.text.e eVarB = androidx.emoji2.text.e.b();
            int iD = eVarB.d();
            if (iD == 3 || iD == 0) {
                c cVar = new c(this);
                this.f3223Q = cVar;
                eVarB.s(cVar);
            }
        }
    }

    private void q(MotionEvent motionEvent) {
        this.f3244t = 0;
        boolean targetCheckedState = true;
        boolean z3 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z3) {
            this.f3248x.computeCurrentVelocity(1000);
            float xVelocity = this.f3248x.getXVelocity();
            if (Math.abs(xVelocity) <= this.f3249y) {
                targetCheckedState = getTargetCheckedState();
            } else if (!u0.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                targetCheckedState = false;
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        e(motionEvent);
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f3241q = charSequence;
        this.f3242r = g(charSequence);
        this.f3218L = null;
        if (this.f3243s) {
            p();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f3239o = charSequence;
        this.f3240p = g(charSequence);
        this.f3217K = null;
        if (this.f3243s) {
            p();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i3;
        int i4;
        Rect rect = this.f3224R;
        int i5 = this.f3210D;
        int i6 = this.f3211E;
        int i7 = this.f3212F;
        int i8 = this.f3213G;
        int thumbOffset = getThumbOffset() + i5;
        Drawable drawable = this.f3225a;
        Rect rectD = drawable != null ? S.d(drawable) : S.f3125c;
        Drawable drawable2 = this.f3230f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i9 = rect.left;
            thumbOffset += i9;
            if (rectD != null) {
                int i10 = rectD.left;
                if (i10 > i9) {
                    i5 += i10 - i9;
                }
                int i11 = rectD.top;
                int i12 = rect.top;
                i3 = i11 > i12 ? (i11 - i12) + i6 : i6;
                int i13 = rectD.right;
                int i14 = rect.right;
                if (i13 > i14) {
                    i7 -= i13 - i14;
                }
                int i15 = rectD.bottom;
                int i16 = rect.bottom;
                if (i15 > i16) {
                    i4 = i8 - (i15 - i16);
                }
                this.f3230f.setBounds(i5, i3, i7, i4);
            } else {
                i3 = i6;
            }
            i4 = i8;
            this.f3230f.setBounds(i5, i3, i7, i4);
        }
        Drawable drawable3 = this.f3225a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i17 = thumbOffset - rect.left;
            int i18 = thumbOffset + this.f3209C + rect.right;
            this.f3225a.setBounds(i17, i6, i18, i8);
            Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a.l(background, i17, i6, i18, i8);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f3, float f4) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f3, f4);
        }
        Drawable drawable = this.f3225a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, f3, f4);
        }
        Drawable drawable2 = this.f3230f;
        if (drawable2 != null) {
            androidx.core.graphics.drawable.a.k(drawable2, f3, f4);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f3225a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f3230f;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!u0.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f3207A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f3237m : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (u0.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f3207A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f3237m : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.j.q(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f3243s;
    }

    public boolean getSplitTrack() {
        return this.f3238n;
    }

    public int getSwitchMinWidth() {
        return this.f3236l;
    }

    public int getSwitchPadding() {
        return this.f3237m;
    }

    public CharSequence getTextOff() {
        return this.f3241q;
    }

    public CharSequence getTextOn() {
        return this.f3239o;
    }

    public Drawable getThumbDrawable() {
        return this.f3225a;
    }

    protected final float getThumbPosition() {
        return this.f3250z;
    }

    public int getThumbTextPadding() {
        return this.f3235k;
    }

    public ColorStateList getThumbTintList() {
        return this.f3226b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f3227c;
    }

    public Drawable getTrackDrawable() {
        return this.f3230f;
    }

    public ColorStateList getTrackTintList() {
        return this.f3231g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f3232h;
    }

    void j() {
        setTextOnInternal(this.f3239o);
        setTextOffInternal(this.f3241q);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f3225a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f3230f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f3220N;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f3220N.end();
        this.f3220N = null;
    }

    public void m(Context context, int i3) {
        j0 j0VarT = j0.t(context, i3, p012d.j.a3);
        ColorStateList colorStateListC = j0VarT.c(p012d.j.e3);
        if (colorStateListC != null) {
            this.f3216J = colorStateListC;
        } else {
            this.f3216J = getTextColors();
        }
        int iF = j0VarT.f(p012d.j.b3, 0);
        if (iF != 0) {
            float f3 = iF;
            if (f3 != this.f3215I.getTextSize()) {
                this.f3215I.setTextSize(f3);
                requestLayout();
            }
        }
        o(j0VarT.k(p012d.j.c3, -1), j0VarT.k(p012d.j.d3, -1));
        if (j0VarT.a(p012d.j.l3, false)) {
            this.f3219M = new p028h.a(getContext());
        } else {
            this.f3219M = null;
        }
        setTextOnInternal(this.f3239o);
        setTextOffInternal(this.f3241q);
        j0VarT.w();
    }

    public void n(Typeface typeface, int i3) {
        if (i3 <= 0) {
            this.f3215I.setFakeBoldText(false);
            this.f3215I.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i3) : Typeface.create(typeface, i3);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int style = ((typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0) ^ (-1)) & i3;
            this.f3215I.setFakeBoldText((style & 1) != 0);
            this.f3215I.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f3206T);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.f3224R;
        Drawable drawable = this.f3230f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i3 = this.f3211E;
        int i4 = this.f3213G;
        int i5 = i3 + rect.top;
        int i6 = i4 - rect.bottom;
        Drawable drawable2 = this.f3225a;
        if (drawable != null) {
            if (!this.f3238n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectD = S.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectD.left;
                rect.right -= rectD.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f3217K : this.f3218L;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f3216J;
            if (colorStateList != null) {
                this.f3215I.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.f3215I.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i5 + i6) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f3239o : this.f3241q;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int iMax;
        int width;
        int paddingLeft;
        int i7;
        int paddingTop;
        int height;
        super.onLayout(z3, i3, i4, i5, i6);
        int iMax2 = 0;
        if (this.f3225a != null) {
            Rect rect = this.f3224R;
            Drawable drawable = this.f3230f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectD = S.d(this.f3225a);
            iMax = Math.max(0, rectD.left - rect.left);
            iMax2 = Math.max(0, rectD.right - rect.right);
        } else {
            iMax = 0;
        }
        if (u0.b(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.f3207A + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.f3207A) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity != 16) {
            if (gravity != 80) {
                paddingTop = getPaddingTop();
                i7 = this.f3208B;
            } else {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.f3208B;
            }
            this.f3210D = paddingLeft;
            this.f3211E = paddingTop;
            this.f3213G = height;
            this.f3212F = width;
        }
        int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        i7 = this.f3208B;
        paddingTop = paddingTop2 - (i7 / 2);
        height = i7 + paddingTop;
        this.f3210D = paddingLeft;
        this.f3211E = paddingTop;
        this.f3213G = height;
        this.f3212F = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i3, int i4) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.f3243s) {
            if (this.f3217K == null) {
                this.f3217K = i(this.f3240p);
            }
            if (this.f3218L == null) {
                this.f3218L = i(this.f3242r);
            }
        }
        Rect rect = this.f3224R;
        Drawable drawable = this.f3225a;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f3225a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f3225a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.f3209C = Math.max(this.f3243s ? Math.max(this.f3217K.getWidth(), this.f3218L.getWidth()) + (this.f3235k * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.f3230f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f3230f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f3225a;
        if (drawable3 != null) {
            Rect rectD = S.d(drawable3);
            iMax = Math.max(iMax, rectD.left);
            iMax2 = Math.max(iMax2, rectD.right);
        }
        int iMax3 = this.f3214H ? Math.max(this.f3236l, (this.f3209C * 2) + iMax + iMax2) : this.f3236l;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f3207A = iMax3;
        this.f3208B = iMax4;
        super.onMeasure(i3, i4);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f3239o : this.f3241q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008b  */
    /* JADX WARN: Code duplicated, block: B:36:0x008f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0096  */
    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f3;
        this.f3248x.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            if (isEnabled() && h(x3, y3)) {
                this.f3244t = 1;
                this.f3246v = x3;
                this.f3247w = y3;
            }
        } else if (actionMasked == 1) {
            if (this.f3244t == 2) {
                q(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.f3244t = 0;
            this.f3248x.clear();
        } else if (actionMasked == 2) {
            int i3 = this.f3244t;
            if (i3 == 1) {
                float x4 = motionEvent.getX();
                float y4 = motionEvent.getY();
                if (Math.abs(x4 - this.f3246v) > this.f3245u || Math.abs(y4 - this.f3247w) > this.f3245u) {
                    this.f3244t = 2;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    this.f3246v = x4;
                    this.f3247w = y4;
                    return true;
                }
            } else if (i3 == 2) {
                float x5 = motionEvent.getX();
                int thumbScrollRange = getThumbScrollRange();
                float f4 = x5 - this.f3246v;
                if (thumbScrollRange != 0) {
                    f3 = f4 / thumbScrollRange;
                } else {
                    f3 = f4 > 0.0f ? 1.0f : -1.0f;
                }
                if (u0.b(this)) {
                    f3 = -f3;
                }
                float f5 = f(this.f3250z + f3, 0.0f, 1.0f);
                if (f5 != this.f3250z) {
                    this.f3246v = x5;
                    setThumbPosition(f5);
                }
                return true;
            }
        } else if (actionMasked == 3) {
            if (this.f3244t == 2) {
                q(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.f3244t = 0;
            this.f3248x.clear();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().d(z3);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z3) {
        super.setChecked(z3);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            l();
        } else {
            k();
        }
        if (getWindowToken() != null && androidx.core.view.Z.U(this)) {
            a(zIsChecked);
        } else {
            d();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.j.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        getEmojiTextViewHelper().e(z3);
        setTextOnInternal(this.f3239o);
        setTextOffInternal(this.f3241q);
        requestLayout();
    }

    protected final void setEnforceSwitchWidth(boolean z3) {
        this.f3214H = z3;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z3) {
        if (this.f3243s != z3) {
            this.f3243s = z3;
            requestLayout();
            if (z3) {
                p();
            }
        }
    }

    public void setSplitTrack(boolean z3) {
        this.f3238n = z3;
        invalidate();
    }

    public void setSwitchMinWidth(int i3) {
        this.f3236l = i3;
        requestLayout();
    }

    public void setSwitchPadding(int i3) {
        this.f3237m = i3;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.f3215I.getTypeface() == null || this.f3215I.getTypeface().equals(typeface)) && (this.f3215I.getTypeface() != null || typeface == null)) {
            return;
        }
        this.f3215I.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            return;
        }
        k();
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            l();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f3225a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f3225a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f3) {
        this.f3250z = f3;
        invalidate();
    }

    public void setThumbResource(int i3) {
        setThumbDrawable(p016e.a.b(getContext(), i3));
    }

    public void setThumbTextPadding(int i3) {
        this.f3235k = i3;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f3226b = colorStateList;
        this.f3228d = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f3227c = mode;
        this.f3229e = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f3230f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f3230f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i3) {
        setTrackDrawable(p016e.a.b(getContext(), i3));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f3231g = colorStateList;
        this.f3233i = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f3232h = mode;
        this.f3234j = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3225a || drawable == this.f3230f;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3226b = null;
        this.f3227c = null;
        this.f3228d = false;
        this.f3229e = false;
        this.f3231g = null;
        this.f3232h = null;
        this.f3233i = false;
        this.f3234j = false;
        this.f3248x = VelocityTracker.obtain();
        this.f3214H = true;
        this.f3224R = new Rect();
        f0.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.f3215I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = p012d.j.L2;
        j0 j0VarV = j0.v(context, attributeSet, iArr, i3, 0);
        androidx.core.view.Z.o0(this, context, iArr, attributeSet, j0VarV.r(), i3, 0);
        Drawable drawableG = j0VarV.g(p012d.j.O2);
        this.f3225a = drawableG;
        if (drawableG != null) {
            drawableG.setCallback(this);
        }
        Drawable drawableG2 = j0VarV.g(p012d.j.X2);
        this.f3230f = drawableG2;
        if (drawableG2 != null) {
            drawableG2.setCallback(this);
        }
        setTextOnInternal(j0VarV.p(p012d.j.M2));
        setTextOffInternal(j0VarV.p(p012d.j.N2));
        this.f3243s = j0VarV.a(p012d.j.P2, true);
        this.f3235k = j0VarV.f(p012d.j.U2, 0);
        this.f3236l = j0VarV.f(p012d.j.R2, 0);
        this.f3237m = j0VarV.f(p012d.j.S2, 0);
        this.f3238n = j0VarV.a(p012d.j.Q2, false);
        ColorStateList colorStateListC = j0VarV.c(p012d.j.V2);
        if (colorStateListC != null) {
            this.f3226b = colorStateListC;
            this.f3228d = true;
        }
        PorterDuff.Mode modeE = S.e(j0VarV.k(p012d.j.W2, -1), null);
        if (this.f3227c != modeE) {
            this.f3227c = modeE;
            this.f3229e = true;
        }
        if (this.f3228d || this.f3229e) {
            b();
        }
        ColorStateList colorStateListC2 = j0VarV.c(p012d.j.Y2);
        if (colorStateListC2 != null) {
            this.f3231g = colorStateListC2;
            this.f3233i = true;
        }
        PorterDuff.Mode modeE2 = S.e(j0VarV.k(p012d.j.Z2, -1), null);
        if (this.f3232h != modeE2) {
            this.f3232h = modeE2;
            this.f3234j = true;
        }
        if (this.f3233i || this.f3234j) {
            c();
        }
        int iN = j0VarV.n(p012d.j.T2, 0);
        if (iN != 0) {
            m(context, iN);
        }
        E e3 = new E(this);
        this.f3221O = e3;
        e3.m(attributeSet, i3);
        j0VarV.w();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3245u = viewConfiguration.getScaledTouchSlop();
        this.f3249y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i3);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
