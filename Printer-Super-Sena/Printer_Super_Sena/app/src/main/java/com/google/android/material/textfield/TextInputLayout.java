package com.google.android.material.textfield;

import A.T;
import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.C0266j;
import androidx.appcompat.widget.S;
import androidx.appcompat.widget.j0;
import androidx.core.view.AbstractC0321u;
import androidx.core.view.C0282a;
import androidx.core.view.Z;
import androidx.transition.C0377c;
import com.google.android.material.internal.AbstractC0490d;
import com.google.android.material.internal.C0488b;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    private static final int f8545C0 = S0.j.f1725l;

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    private static final int[][] f8546D0 = {new int[]{R.attr.state_pressed}, new int[0]};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private ColorStateList f8547A;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    private boolean f8548A0;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private ColorStateList f8549B;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    private boolean f8550B0;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private boolean f8551C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private CharSequence f8552D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private boolean f8553E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private p042l1.g f8554F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private p042l1.g f8555G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private StateListDrawable f8556H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private boolean f8557I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private p042l1.g f8558J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private p042l1.g f8559K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private p042l1.k f8560L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private boolean f8561M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private final int f8562N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private int f8563O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private int f8564P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private int f8565Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private int f8566R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private int f8567S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private int f8568T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private int f8569U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private final Rect f8570V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private final Rect f8571W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f8572a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final RectF f8573a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final A f8574b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private Typeface f8575b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s f8576c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private Drawable f8577c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    EditText f8578d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f8579d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f8580e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final LinkedHashSet f8581e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8582f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private Drawable f8583f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8584g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private int f8585g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f8586h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private Drawable f8587h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f8588i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private ColorStateList f8589i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final v f8590j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private ColorStateList f8591j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f8592k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private int f8593k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f8594l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private int f8595l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f8596m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private int f8597m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private e f8598n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private ColorStateList f8599n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f8600o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f8601o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f8602p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f8603p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f8604q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f8605q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CharSequence f8606r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f8607r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f8608s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f8609s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f8610t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    int f8611t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ColorStateList f8612u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private boolean f8613u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f8614v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    final C0488b f8615v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private C0377c f8616w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private boolean f8617w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private C0377c f8618x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private boolean f8619x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ColorStateList f8620y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private ValueAnimator f8621y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ColorStateList f8622z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private boolean f8623z0;

    class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f8625b;

        a(EditText editText) {
            this.f8625b = editText;
            this.f8624a = editText.getLineCount();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.u0(!textInputLayout.f8548A0);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f8592k) {
                textInputLayout2.k0(editable);
            }
            if (TextInputLayout.this.f8608s) {
                TextInputLayout.this.y0(editable);
            }
            int lineCount = this.f8625b.getLineCount();
            int i3 = this.f8624a;
            if (lineCount != i3) {
                if (lineCount < i3) {
                    int iD = Z.D(this.f8625b);
                    int i4 = TextInputLayout.this.f8611t0;
                    if (iD != i4) {
                        this.f8625b.setMinimumHeight(i4);
                    }
                }
                this.f8624a = lineCount;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f8576c.h();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.f8615v0.c0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class d extends C0282a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TextInputLayout f8629d;

        public d(TextInputLayout textInputLayout) {
            this.f8629d = textInputLayout;
        }

        @Override // androidx.core.view.C0282a
        public void g(View view, T t3) {
            super.g(view, t3);
            EditText editText = this.f8629d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f8629d.getHint();
            CharSequence error = this.f8629d.getError();
            CharSequence placeholderText = this.f8629d.getPlaceholderText();
            int counterMaxLength = this.f8629d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f8629d.getCounterOverflowDescription();
            boolean zIsEmpty = TextUtils.isEmpty(text);
            boolean zIsEmpty2 = TextUtils.isEmpty(hint);
            boolean zP = this.f8629d.P();
            boolean zIsEmpty3 = TextUtils.isEmpty(error);
            boolean z3 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
            String string = !zIsEmpty2 ? hint.toString() : "";
            this.f8629d.f8574b.A(t3);
            if (!zIsEmpty) {
                t3.L0(text);
            } else if (!TextUtils.isEmpty(string)) {
                t3.L0(string);
                if (!zP && placeholderText != null) {
                    t3.L0(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                t3.L0(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    t3.w0(string);
                } else {
                    if (!zIsEmpty) {
                        string = ((Object) text) + ", " + string;
                    }
                    t3.L0(string);
                }
                t3.H0(zIsEmpty);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            t3.y0(counterMaxLength);
            if (z3) {
                if (zIsEmpty3) {
                    error = counterOverflowDescription;
                }
                t3.s0(error);
            }
            View viewT = this.f8629d.f8590j.t();
            if (viewT != null) {
                t3.x0(viewT);
            }
            this.f8629d.f8576c.m().o(view, t3);
        }

        @Override // androidx.core.view.C0282a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            this.f8629d.f8576c.m().p(view, accessibilityEvent);
        }
    }

    public interface e {
        int a(Editable editable);
    }

    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    static class g extends F.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CharSequence f8630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f8631d;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i3) {
                return new g[i3];
            }
        }

        g(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f8630c) + "}";
        }

        @Override // F.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            TextUtils.writeToParcel(this.f8630c, parcel, i3);
            parcel.writeInt(this.f8631d ? 1 : 0);
        }

        g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8630c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f8631d = parcel.readInt() == 1;
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, S0.a.f1506X);
    }

    private C0377c A() {
        C0377c c0377c = new C0377c();
        c0377c.Y(p022f1.h.f(getContext(), S0.a.f1484B, 87));
        c0377c.a0(p022f1.h.g(getContext(), S0.a.f1489G, T0.a.f1956a));
        return c0377c;
    }

    private boolean B() {
        return this.f8551C && !TextUtils.isEmpty(this.f8552D) && (this.f8554F instanceof AbstractC0504h);
    }

    private void C() {
        Iterator it = this.f8581e0.iterator();
        while (it.hasNext()) {
            ((f) it.next()).a(this);
        }
    }

    private void D(Canvas canvas) {
        p042l1.g gVar;
        if (this.f8559K == null || (gVar = this.f8558J) == null) {
            return;
        }
        gVar.draw(canvas);
        if (this.f8578d.isFocused()) {
            Rect bounds = this.f8559K.getBounds();
            Rect bounds2 = this.f8558J.getBounds();
            float fX = this.f8615v0.x();
            int iCenterX = bounds2.centerX();
            bounds.left = T0.a.c(iCenterX, bounds2.left, fX);
            bounds.right = T0.a.c(iCenterX, bounds2.right, fX);
            this.f8559K.draw(canvas);
        }
    }

    private void E(Canvas canvas) {
        if (this.f8551C) {
            this.f8615v0.l(canvas);
        }
    }

    private void F(boolean z3) {
        ValueAnimator valueAnimator = this.f8621y0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f8621y0.cancel();
        }
        if (z3 && this.f8619x0) {
            l(0.0f);
        } else {
            this.f8615v0.c0(0.0f);
        }
        if (B() && ((AbstractC0504h) this.f8554F).j0()) {
            y();
        }
        this.f8613u0 = true;
        L();
        this.f8574b.l(true);
        this.f8576c.H(true);
    }

    private p042l1.g G(boolean z3) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(S0.c.f1576e0);
        float f3 = z3 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f8578d;
        float popupElevation = editText instanceof w ? ((w) editText).getPopupElevation() : getResources().getDimensionPixelOffset(S0.c.f1598v);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(S0.c.f1572c0);
        p042l1.k kVarM = p042l1.k.a().A(f3).E(f3).s(dimensionPixelOffset).w(dimensionPixelOffset).m();
        EditText editText2 = this.f8578d;
        p042l1.g gVarM = p042l1.g.m(getContext(), popupElevation, editText2 instanceof w ? ((w) editText2).getDropDownBackgroundTintList() : null);
        gVarM.setShapeAppearanceModel(kVarM);
        gVarM.X(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        return gVarM;
    }

    private static Drawable H(p042l1.g gVar, int i3, int i4, int[][] iArr) {
        LayerDrawable layerDrawable;
        int[] iArr2 = {p002a1.a.k(i4, i3, 0.1f), i3};
        if (Build.VERSION.SDK_INT >= 21) {
            layerDrawable = new RippleDrawable(new ColorStateList(iArr, iArr2), gVar, gVar);
        } else {
            p042l1.g gVar2 = new p042l1.g(gVar.B());
            gVar2.V(new ColorStateList(iArr, iArr2));
            layerDrawable = new LayerDrawable(new Drawable[]{gVar, gVar2});
        }
        return layerDrawable;
    }

    private int I(int i3, boolean z3) {
        int compoundPaddingLeft;
        if (z3 || getPrefixText() == null) {
            compoundPaddingLeft = (!z3 || getSuffixText() == null) ? this.f8578d.getCompoundPaddingLeft() : this.f8576c.y();
        } else {
            compoundPaddingLeft = this.f8574b.c();
        }
        return i3 + compoundPaddingLeft;
    }

    private int J(int i3, boolean z3) {
        int compoundPaddingRight;
        if (z3 || getSuffixText() == null) {
            compoundPaddingRight = (!z3 || getPrefixText() == null) ? this.f8578d.getCompoundPaddingRight() : this.f8574b.c();
        } else {
            compoundPaddingRight = this.f8576c.y();
        }
        return i3 - compoundPaddingRight;
    }

    private static Drawable K(Context context, p042l1.g gVar, int i3, int[][] iArr) {
        int iC = p002a1.a.c(context, S0.a.f1521m, "TextInputLayout");
        p042l1.g gVar2 = new p042l1.g(gVar.B());
        int iK = p002a1.a.k(i3, iC, 0.1f);
        gVar2.V(new ColorStateList(iArr, new int[]{iK, 0}));
        if (Build.VERSION.SDK_INT < 21) {
            return new LayerDrawable(new Drawable[]{gVar2, gVar});
        }
        gVar2.setTint(iC);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iK, iC});
        p042l1.g gVar3 = new p042l1.g(gVar.B());
        gVar3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar2, gVar3), gVar});
    }

    private void L() {
        TextView textView = this.f8610t;
        if (textView == null || !this.f8608s) {
            return;
        }
        textView.setText((CharSequence) null);
        androidx.transition.u.a(this.f8572a, this.f8618x);
        this.f8610t.setVisibility(4);
    }

    private boolean Q() {
        return d0() || (this.f8600o != null && this.f8596m);
    }

    private boolean S() {
        return this.f8563O == 1 && this.f8578d.getMinLines() <= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int T(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U() {
        this.f8578d.requestLayout();
    }

    private void V() {
        p();
        r0();
        A0();
        h0();
        k();
        if (this.f8563O != 0) {
            t0();
        }
        b0();
    }

    private void W() {
        if (B()) {
            RectF rectF = this.f8573a0;
            this.f8615v0.o(rectF, this.f8578d.getWidth(), this.f8578d.getGravity());
            if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
                return;
            }
            o(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.f8565Q);
            ((AbstractC0504h) this.f8554F).m0(rectF);
        }
    }

    private void X() {
        if (!B() || this.f8613u0) {
            return;
        }
        y();
        W();
    }

    private static void Y(ViewGroup viewGroup, boolean z3) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            childAt.setEnabled(z3);
            if (childAt instanceof ViewGroup) {
                Y((ViewGroup) childAt, z3);
            }
        }
    }

    private void a0() {
        TextView textView = this.f8610t;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void b0() {
        EditText editText = this.f8578d;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (Build.VERSION.SDK_INT < 21 || autoCompleteTextView.getDropDownBackground() != null) {
                return;
            }
            int i3 = this.f8563O;
            if (i3 == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
            } else if (i3 == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
            }
        }
    }

    private boolean e0() {
        return (this.f8576c.G() || ((this.f8576c.A() && M()) || this.f8576c.w() != null)) && this.f8576c.getMeasuredWidth() > 0;
    }

    private boolean f0() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f8574b.getMeasuredWidth() > 0;
    }

    private void g0() {
        if (this.f8610t == null || !this.f8608s || TextUtils.isEmpty(this.f8606r)) {
            return;
        }
        this.f8610t.setText(this.f8606r);
        androidx.transition.u.a(this.f8572a, this.f8616w);
        this.f8610t.setVisibility(0);
        this.f8610t.bringToFront();
        announceForAccessibility(this.f8606r);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f8578d;
        if (!(editText instanceof AutoCompleteTextView) || r.a(editText)) {
            return this.f8554F;
        }
        int iD = p002a1.a.d(this.f8578d, S0.a.f1516h);
        int i3 = this.f8563O;
        if (i3 == 2) {
            return K(getContext(), this.f8554F, iD, f8546D0);
        }
        if (i3 == 1) {
            return H(this.f8554F, this.f8569U, iD, f8546D0);
        }
        return null;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.f8556H == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f8556H = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.f8556H.addState(new int[0], G(false));
        }
        return this.f8556H;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.f8555G == null) {
            this.f8555G = G(true);
        }
        return this.f8555G;
    }

    private void h0() {
        if (this.f8563O == 1) {
            if (p030h1.c.i(getContext())) {
                this.f8564P = getResources().getDimensionPixelSize(S0.c.f1547G);
            } else if (p030h1.c.h(getContext())) {
                this.f8564P = getResources().getDimensionPixelSize(S0.c.f1546F);
            }
        }
    }

    private void i0(Rect rect) {
        p042l1.g gVar = this.f8558J;
        if (gVar != null) {
            int i3 = rect.bottom;
            gVar.setBounds(rect.left, i3 - this.f8566R, rect.right, i3);
        }
        p042l1.g gVar2 = this.f8559K;
        if (gVar2 != null) {
            int i4 = rect.bottom;
            gVar2.setBounds(rect.left, i4 - this.f8567S, rect.right, i4);
        }
    }

    private void j() {
        TextView textView = this.f8610t;
        if (textView != null) {
            this.f8572a.addView(textView);
            this.f8610t.setVisibility(0);
        }
    }

    private void j0() {
        if (this.f8600o != null) {
            EditText editText = this.f8578d;
            k0(editText == null ? null : editText.getText());
        }
    }

    private void k() {
        if (this.f8578d == null || this.f8563O != 1) {
            return;
        }
        if (p030h1.c.i(getContext())) {
            EditText editText = this.f8578d;
            Z.E0(editText, Z.H(editText), getResources().getDimensionPixelSize(S0.c.f1545E), Z.G(this.f8578d), getResources().getDimensionPixelSize(S0.c.f1544D));
        } else if (p030h1.c.h(getContext())) {
            EditText editText2 = this.f8578d;
            Z.E0(editText2, Z.H(editText2), getResources().getDimensionPixelSize(S0.c.f1543C), Z.G(this.f8578d), getResources().getDimensionPixelSize(S0.c.f1542B));
        }
    }

    private static void l0(Context context, TextView textView, int i3, int i4, boolean z3) {
        textView.setContentDescription(context.getString(z3 ? S0.i.f1690c : S0.i.f1689b, Integer.valueOf(i3), Integer.valueOf(i4)));
    }

    private void m() {
        p042l1.g gVar = this.f8554F;
        if (gVar == null) {
            return;
        }
        p042l1.k kVarB = gVar.B();
        p042l1.k kVar = this.f8560L;
        if (kVarB != kVar) {
            this.f8554F.setShapeAppearanceModel(kVar);
        }
        if (w()) {
            this.f8554F.Z(this.f8565Q, this.f8568T);
        }
        int iQ = q();
        this.f8569U = iQ;
        this.f8554F.V(ColorStateList.valueOf(iQ));
        n();
        r0();
    }

    private void m0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f8600o;
        if (textView != null) {
            c0(textView, this.f8596m ? this.f8602p : this.f8604q);
            if (!this.f8596m && (colorStateList2 = this.f8620y) != null) {
                this.f8600o.setTextColor(colorStateList2);
            }
            if (!this.f8596m || (colorStateList = this.f8622z) == null) {
                return;
            }
            this.f8600o.setTextColor(colorStateList);
        }
    }

    private void n() {
        if (this.f8558J == null || this.f8559K == null) {
            return;
        }
        if (x()) {
            this.f8558J.V(this.f8578d.isFocused() ? ColorStateList.valueOf(this.f8593k0) : ColorStateList.valueOf(this.f8568T));
            this.f8559K.V(ColorStateList.valueOf(this.f8568T));
        }
        invalidate();
    }

    private void n0() {
        ColorStateList colorStateList;
        ColorStateList colorStateListH = this.f8547A;
        if (colorStateListH == null) {
            colorStateListH = p002a1.a.h(getContext(), S0.a.f1515g);
        }
        EditText editText = this.f8578d;
        if (editText == null || editText.getTextCursorDrawable() == null) {
            return;
        }
        Drawable drawableMutate = androidx.core.graphics.drawable.a.r(this.f8578d.getTextCursorDrawable()).mutate();
        if (Q() && (colorStateList = this.f8549B) != null) {
            colorStateListH = colorStateList;
        }
        androidx.core.graphics.drawable.a.o(drawableMutate, colorStateListH);
    }

    private void o(RectF rectF) {
        float f3 = rectF.left;
        int i3 = this.f8562N;
        rectF.left = f3 - i3;
        rectF.right += i3;
    }

    private void p() {
        int i3 = this.f8563O;
        if (i3 == 0) {
            this.f8554F = null;
            this.f8558J = null;
            this.f8559K = null;
            return;
        }
        if (i3 == 1) {
            this.f8554F = new p042l1.g(this.f8560L);
            this.f8558J = new p042l1.g();
            this.f8559K = new p042l1.g();
        } else {
            if (i3 != 2) {
                throw new IllegalArgumentException(this.f8563O + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.f8551C || (this.f8554F instanceof AbstractC0504h)) {
                this.f8554F = new p042l1.g(this.f8560L);
            } else {
                this.f8554F = AbstractC0504h.i0(this.f8560L);
            }
            this.f8558J = null;
            this.f8559K = null;
        }
    }

    private int q() {
        return this.f8563O == 1 ? p002a1.a.j(p002a1.a.e(this, S0.a.f1521m, 0), this.f8569U) : this.f8569U;
    }

    private void q0() {
        Drawable editTextBoxBackground = getEditTextBoxBackground();
        if (Build.VERSION.SDK_INT >= 21 || !(editTextBoxBackground instanceof LayerDrawable)) {
            Z.u0(this.f8578d, editTextBoxBackground);
            return;
        }
        int paddingLeft = this.f8578d.getPaddingLeft();
        int paddingTop = this.f8578d.getPaddingTop();
        int paddingRight = this.f8578d.getPaddingRight();
        int paddingBottom = this.f8578d.getPaddingBottom();
        Z.u0(this.f8578d, editTextBoxBackground);
        this.f8578d.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    private Rect r(Rect rect) {
        if (this.f8578d == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f8571W;
        boolean zG = com.google.android.material.internal.F.g(this);
        rect2.bottom = rect.bottom;
        int i3 = this.f8563O;
        if (i3 == 1) {
            rect2.left = I(rect.left, zG);
            rect2.top = rect.top + this.f8564P;
            rect2.right = J(rect.right, zG);
            return rect2;
        }
        if (i3 != 2) {
            rect2.left = I(rect.left, zG);
            rect2.top = getPaddingTop();
            rect2.right = J(rect.right, zG);
            return rect2;
        }
        rect2.left = rect.left + this.f8578d.getPaddingLeft();
        rect2.top = rect.top - v();
        rect2.right = rect.right - this.f8578d.getPaddingRight();
        return rect2;
    }

    private int s(Rect rect, Rect rect2, float f3) {
        return S() ? (int) (rect2.top + f3) : rect.bottom - this.f8578d.getCompoundPaddingBottom();
    }

    private boolean s0() {
        int iMax;
        if (this.f8578d == null || this.f8578d.getMeasuredHeight() >= (iMax = Math.max(this.f8576c.getMeasuredHeight(), this.f8574b.getMeasuredHeight()))) {
            return false;
        }
        this.f8578d.setMinimumHeight(iMax);
        return true;
    }

    private void setEditText(EditText editText) {
        if (this.f8578d != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f8578d = editText;
        int i3 = this.f8582f;
        if (i3 != -1) {
            setMinEms(i3);
        } else {
            setMinWidth(this.f8586h);
        }
        int i4 = this.f8584g;
        if (i4 != -1) {
            setMaxEms(i4);
        } else {
            setMaxWidth(this.f8588i);
        }
        this.f8557I = false;
        V();
        setTextInputAccessibilityDelegate(new d(this));
        this.f8615v0.i0(this.f8578d.getTypeface());
        this.f8615v0.a0(this.f8578d.getTextSize());
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 21) {
            this.f8615v0.X(this.f8578d.getLetterSpacing());
        }
        int gravity = this.f8578d.getGravity();
        this.f8615v0.S((gravity & (-113)) | 48);
        this.f8615v0.Z(gravity);
        this.f8611t0 = Z.D(editText);
        this.f8578d.addTextChangedListener(new a(editText));
        if (this.f8589i0 == null) {
            this.f8589i0 = this.f8578d.getHintTextColors();
        }
        if (this.f8551C) {
            if (TextUtils.isEmpty(this.f8552D)) {
                CharSequence hint = this.f8578d.getHint();
                this.f8580e = hint;
                setHint(hint);
                this.f8578d.setHint((CharSequence) null);
            }
            this.f8553E = true;
        }
        if (i5 >= 29) {
            n0();
        }
        if (this.f8600o != null) {
            k0(this.f8578d.getText());
        }
        p0();
        this.f8590j.f();
        this.f8574b.bringToFront();
        this.f8576c.bringToFront();
        C();
        this.f8576c.x0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        v0(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f8552D)) {
            return;
        }
        this.f8552D = charSequence;
        this.f8615v0.g0(charSequence);
        if (this.f8613u0) {
            return;
        }
        W();
    }

    private void setPlaceholderTextEnabled(boolean z3) {
        if (this.f8608s == z3) {
            return;
        }
        if (z3) {
            j();
        } else {
            a0();
            this.f8610t = null;
        }
        this.f8608s = z3;
    }

    private int t(Rect rect, float f3) {
        return S() ? (int) (rect.centerY() - (f3 / 2.0f)) : rect.top + this.f8578d.getCompoundPaddingTop();
    }

    private void t0() {
        if (this.f8563O != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f8572a.getLayoutParams();
            int iV = v();
            if (iV != layoutParams.topMargin) {
                layoutParams.topMargin = iV;
                this.f8572a.requestLayout();
            }
        }
    }

    private Rect u(Rect rect) {
        if (this.f8578d == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f8571W;
        float fW = this.f8615v0.w();
        rect2.left = rect.left + this.f8578d.getCompoundPaddingLeft();
        rect2.top = t(rect, fW);
        rect2.right = rect.right - this.f8578d.getCompoundPaddingRight();
        rect2.bottom = s(rect, rect2, fW);
        return rect2;
    }

    private int v() {
        float fQ;
        if (!this.f8551C) {
            return 0;
        }
        int i3 = this.f8563O;
        if (i3 == 0) {
            fQ = this.f8615v0.q();
        } else {
            if (i3 != 2) {
                return 0;
            }
            fQ = this.f8615v0.q() / 2.0f;
        }
        return (int) fQ;
    }

    private void v0(boolean z3, boolean z4) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f8578d;
        boolean z5 = false;
        boolean z6 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f8578d;
        if (editText2 != null && editText2.hasFocus()) {
            z5 = true;
        }
        ColorStateList colorStateList2 = this.f8589i0;
        if (colorStateList2 != null) {
            this.f8615v0.M(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.f8589i0;
            this.f8615v0.M(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f8609s0) : this.f8609s0));
        } else if (d0()) {
            this.f8615v0.M(this.f8590j.r());
        } else if (this.f8596m && (textView = this.f8600o) != null) {
            this.f8615v0.M(textView.getTextColors());
        } else if (z5 && (colorStateList = this.f8591j0) != null) {
            this.f8615v0.R(colorStateList);
        }
        if (z6 || !this.f8617w0 || (isEnabled() && z5)) {
            if (z4 || this.f8613u0) {
                z(z3);
                return;
            }
            return;
        }
        if (z4 || !this.f8613u0) {
            F(z3);
        }
    }

    private boolean w() {
        return this.f8563O == 2 && x();
    }

    private void w0() {
        EditText editText;
        if (this.f8610t == null || (editText = this.f8578d) == null) {
            return;
        }
        this.f8610t.setGravity(editText.getGravity());
        this.f8610t.setPadding(this.f8578d.getCompoundPaddingLeft(), this.f8578d.getCompoundPaddingTop(), this.f8578d.getCompoundPaddingRight(), this.f8578d.getCompoundPaddingBottom());
    }

    private boolean x() {
        return this.f8565Q > -1 && this.f8568T != 0;
    }

    private void x0() {
        EditText editText = this.f8578d;
        y0(editText == null ? null : editText.getText());
    }

    private void y() {
        if (B()) {
            ((AbstractC0504h) this.f8554F).k0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(Editable editable) {
        if (this.f8598n.a(editable) != 0 || this.f8613u0) {
            L();
        } else {
            g0();
        }
    }

    private void z(boolean z3) {
        ValueAnimator valueAnimator = this.f8621y0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f8621y0.cancel();
        }
        if (z3 && this.f8619x0) {
            l(1.0f);
        } else {
            this.f8615v0.c0(1.0f);
        }
        this.f8613u0 = false;
        if (B()) {
            W();
        }
        x0();
        this.f8574b.l(false);
        this.f8576c.H(false);
    }

    private void z0(boolean z3, boolean z4) {
        int defaultColor = this.f8599n0.getDefaultColor();
        int colorForState = this.f8599n0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f8599n0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z3) {
            this.f8568T = colorForState2;
        } else if (z4) {
            this.f8568T = colorForState;
        } else {
            this.f8568T = defaultColor;
        }
    }

    void A0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.f8554F == null || this.f8563O == 0) {
            return;
        }
        boolean z3 = false;
        boolean z4 = isFocused() || ((editText2 = this.f8578d) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f8578d) != null && editText.isHovered())) {
            z3 = true;
        }
        if (!isEnabled()) {
            this.f8568T = this.f8609s0;
        } else if (d0()) {
            if (this.f8599n0 != null) {
                z0(z4, z3);
            } else {
                this.f8568T = getErrorCurrentTextColors();
            }
        } else if (!this.f8596m || (textView = this.f8600o) == null) {
            if (z4) {
                this.f8568T = this.f8597m0;
            } else if (z3) {
                this.f8568T = this.f8595l0;
            } else {
                this.f8568T = this.f8593k0;
            }
        } else if (this.f8599n0 != null) {
            z0(z4, z3);
        } else {
            this.f8568T = textView.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            n0();
        }
        this.f8576c.I();
        Z();
        if (this.f8563O == 2) {
            int i3 = this.f8565Q;
            if (z4 && isEnabled()) {
                this.f8565Q = this.f8567S;
            } else {
                this.f8565Q = this.f8566R;
            }
            if (this.f8565Q != i3) {
                X();
            }
        }
        if (this.f8563O == 1) {
            if (!isEnabled()) {
                this.f8569U = this.f8603p0;
            } else if (z3 && !z4) {
                this.f8569U = this.f8607r0;
            } else if (z4) {
                this.f8569U = this.f8605q0;
            } else {
                this.f8569U = this.f8601o0;
            }
        }
        m();
    }

    public boolean M() {
        return this.f8576c.F();
    }

    public boolean N() {
        return this.f8590j.A();
    }

    public boolean O() {
        return this.f8590j.B();
    }

    final boolean P() {
        return this.f8613u0;
    }

    public boolean R() {
        return this.f8553E;
    }

    public void Z() {
        this.f8574b.m();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i3, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f8572a.addView(view, layoutParams2);
        this.f8572a.setLayoutParams(layoutParams);
        t0();
        setEditText((EditText) view);
    }

    void c0(TextView textView, int i3) {
        try {
            androidx.core.widget.j.o(textView, i3);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        androidx.core.widget.j.o(textView, S0.j.f1715b);
        textView.setTextColor(androidx.core.content.a.b(getContext(), S0.b.f1535a));
    }

    boolean d0() {
        return this.f8590j.l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i3) {
        EditText editText = this.f8578d;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i3);
            return;
        }
        if (this.f8580e != null) {
            boolean z3 = this.f8553E;
            this.f8553E = false;
            CharSequence hint = editText.getHint();
            this.f8578d.setHint(this.f8580e);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i3);
                return;
            } finally {
                this.f8578d.setHint(hint);
                this.f8553E = z3;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i3);
        onProvideAutofillVirtualStructure(viewStructure, i3);
        viewStructure.setChildCount(this.f8572a.getChildCount());
        for (int i4 = 0; i4 < this.f8572a.getChildCount(); i4++) {
            View childAt = this.f8572a.getChildAt(i4);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i4);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i3);
            if (childAt == this.f8578d) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.f8548A0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f8548A0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f8623z0) {
            return;
        }
        this.f8623z0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        C0488b c0488b = this.f8615v0;
        boolean zF0 = c0488b != null ? c0488b.f0(drawableState) : false;
        if (this.f8578d != null) {
            u0(Z.U(this) && isEnabled());
        }
        p0();
        A0();
        if (zF0) {
            invalidate();
        }
        this.f8623z0 = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f8578d;
        return editText != null ? editText.getBaseline() + getPaddingTop() + v() : super.getBaseline();
    }

    p042l1.g getBoxBackground() {
        int i3 = this.f8563O;
        if (i3 == 1 || i3 == 2) {
            return this.f8554F;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f8569U;
    }

    public int getBoxBackgroundMode() {
        return this.f8563O;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f8564P;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return com.google.android.material.internal.F.g(this) ? this.f8560L.j().a(this.f8573a0) : this.f8560L.l().a(this.f8573a0);
    }

    public float getBoxCornerRadiusBottomStart() {
        return com.google.android.material.internal.F.g(this) ? this.f8560L.l().a(this.f8573a0) : this.f8560L.j().a(this.f8573a0);
    }

    public float getBoxCornerRadiusTopEnd() {
        return com.google.android.material.internal.F.g(this) ? this.f8560L.r().a(this.f8573a0) : this.f8560L.t().a(this.f8573a0);
    }

    public float getBoxCornerRadiusTopStart() {
        return com.google.android.material.internal.F.g(this) ? this.f8560L.t().a(this.f8573a0) : this.f8560L.r().a(this.f8573a0);
    }

    public int getBoxStrokeColor() {
        return this.f8597m0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f8599n0;
    }

    public int getBoxStrokeWidth() {
        return this.f8566R;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f8567S;
    }

    public int getCounterMaxLength() {
        return this.f8594l;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f8592k && this.f8596m && (textView = this.f8600o) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f8622z;
    }

    public ColorStateList getCounterTextColor() {
        return this.f8620y;
    }

    public ColorStateList getCursorColor() {
        return this.f8547A;
    }

    public ColorStateList getCursorErrorColor() {
        return this.f8549B;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f8589i0;
    }

    public EditText getEditText() {
        return this.f8578d;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f8576c.l();
    }

    public Drawable getEndIconDrawable() {
        return this.f8576c.n();
    }

    public int getEndIconMinSize() {
        return this.f8576c.o();
    }

    public int getEndIconMode() {
        return this.f8576c.p();
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f8576c.q();
    }

    CheckableImageButton getEndIconView() {
        return this.f8576c.r();
    }

    public CharSequence getError() {
        if (this.f8590j.A()) {
            return this.f8590j.p();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f8590j.n();
    }

    public CharSequence getErrorContentDescription() {
        return this.f8590j.o();
    }

    public int getErrorCurrentTextColors() {
        return this.f8590j.q();
    }

    public Drawable getErrorIconDrawable() {
        return this.f8576c.s();
    }

    public CharSequence getHelperText() {
        if (this.f8590j.B()) {
            return this.f8590j.s();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f8590j.u();
    }

    public CharSequence getHint() {
        if (this.f8551C) {
            return this.f8552D;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.f8615v0.q();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.f8615v0.t();
    }

    public ColorStateList getHintTextColor() {
        return this.f8591j0;
    }

    public e getLengthCounter() {
        return this.f8598n;
    }

    public int getMaxEms() {
        return this.f8584g;
    }

    public int getMaxWidth() {
        return this.f8588i;
    }

    public int getMinEms() {
        return this.f8582f;
    }

    public int getMinWidth() {
        return this.f8586h;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f8576c.u();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f8576c.v();
    }

    public CharSequence getPlaceholderText() {
        if (this.f8608s) {
            return this.f8606r;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f8614v;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f8612u;
    }

    public CharSequence getPrefixText() {
        return this.f8574b.a();
    }

    public ColorStateList getPrefixTextColor() {
        return this.f8574b.b();
    }

    public TextView getPrefixTextView() {
        return this.f8574b.d();
    }

    public p042l1.k getShapeAppearanceModel() {
        return this.f8560L;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f8574b.e();
    }

    public Drawable getStartIconDrawable() {
        return this.f8574b.f();
    }

    public int getStartIconMinSize() {
        return this.f8574b.g();
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f8574b.h();
    }

    public CharSequence getSuffixText() {
        return this.f8576c.w();
    }

    public ColorStateList getSuffixTextColor() {
        return this.f8576c.x();
    }

    public TextView getSuffixTextView() {
        return this.f8576c.z();
    }

    public Typeface getTypeface() {
        return this.f8575b0;
    }

    public void i(f fVar) {
        this.f8581e0.add(fVar);
        if (this.f8578d != null) {
            fVar.a(this);
        }
    }

    void k0(Editable editable) {
        int iA = this.f8598n.a(editable);
        boolean z3 = this.f8596m;
        int i3 = this.f8594l;
        if (i3 == -1) {
            this.f8600o.setText(String.valueOf(iA));
            this.f8600o.setContentDescription(null);
            this.f8596m = false;
        } else {
            this.f8596m = iA > i3;
            l0(getContext(), this.f8600o, iA, this.f8594l, this.f8596m);
            if (z3 != this.f8596m) {
                m0();
            }
            this.f8600o.setText(androidx.core.text.a.c().j(getContext().getString(S0.i.f1691d, Integer.valueOf(iA), Integer.valueOf(this.f8594l))));
        }
        if (this.f8578d == null || z3 == this.f8596m) {
            return;
        }
        u0(false);
        A0();
        p0();
    }

    void l(float f3) {
        if (this.f8615v0.x() == f3) {
            return;
        }
        if (this.f8621y0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f8621y0 = valueAnimator;
            valueAnimator.setInterpolator(p022f1.h.g(getContext(), S0.a.f1488F, T0.a.f1957b));
            this.f8621y0.setDuration(p022f1.h.f(getContext(), S0.a.f1483A, 167));
            this.f8621y0.addUpdateListener(new c());
        }
        this.f8621y0.setFloatValues(this.f8615v0.x(), f3);
        this.f8621y0.start();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    boolean o0() {
        boolean z3;
        if (this.f8578d == null) {
            return false;
        }
        boolean z4 = true;
        if (f0()) {
            int measuredWidth = this.f8574b.getMeasuredWidth() - this.f8578d.getPaddingLeft();
            if (this.f8577c0 == null || this.f8579d0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f8577c0 = colorDrawable;
                this.f8579d0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] drawableArrA = androidx.core.widget.j.a(this.f8578d);
            Drawable drawable = drawableArrA[0];
            Drawable drawable2 = this.f8577c0;
            if (drawable != drawable2) {
                androidx.core.widget.j.j(this.f8578d, drawable2, drawableArrA[1], drawableArrA[2], drawableArrA[3]);
                z3 = true;
            } else {
                z3 = false;
            }
        } else if (this.f8577c0 != null) {
            Drawable[] drawableArrA2 = androidx.core.widget.j.a(this.f8578d);
            androidx.core.widget.j.j(this.f8578d, null, drawableArrA2[1], drawableArrA2[2], drawableArrA2[3]);
            this.f8577c0 = null;
            z3 = true;
        } else {
            z3 = false;
        }
        if (e0()) {
            int measuredWidth2 = this.f8576c.z().getMeasuredWidth() - this.f8578d.getPaddingRight();
            CheckableImageButton checkableImageButtonK = this.f8576c.k();
            if (checkableImageButtonK != null) {
                measuredWidth2 = measuredWidth2 + checkableImageButtonK.getMeasuredWidth() + AbstractC0321u.b((ViewGroup.MarginLayoutParams) checkableImageButtonK.getLayoutParams());
            }
            Drawable[] drawableArrA3 = androidx.core.widget.j.a(this.f8578d);
            Drawable drawable3 = this.f8583f0;
            if (drawable3 == null || this.f8585g0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f8583f0 = colorDrawable2;
                    this.f8585g0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = drawableArrA3[2];
                Drawable drawable5 = this.f8583f0;
                if (drawable4 != drawable5) {
                    this.f8587h0 = drawable4;
                    androidx.core.widget.j.j(this.f8578d, drawableArrA3[0], drawableArrA3[1], drawable5, drawableArrA3[3]);
                } else {
                    z4 = z3;
                }
            } else {
                this.f8585g0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                androidx.core.widget.j.j(this.f8578d, drawableArrA3[0], drawableArrA3[1], this.f8583f0, drawableArrA3[3]);
            }
        } else {
            if (this.f8583f0 == null) {
                return z3;
            }
            Drawable[] drawableArrA4 = androidx.core.widget.j.a(this.f8578d);
            if (drawableArrA4[2] == this.f8583f0) {
                androidx.core.widget.j.j(this.f8578d, drawableArrA4[0], drawableArrA4[1], this.f8587h0, drawableArrA4[3]);
            } else {
                z4 = z3;
            }
            this.f8583f0 = null;
        }
        return z4;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f8615v0.H(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f8576c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f8550B0 = false;
        boolean zS0 = s0();
        boolean zO0 = o0();
        if (zS0 || zO0) {
            this.f8578d.post(new Runnable() { // from class: com.google.android.material.textfield.L
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8542a.U();
                }
            });
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        EditText editText = this.f8578d;
        if (editText != null) {
            Rect rect = this.f8570V;
            AbstractC0490d.a(this, editText, rect);
            i0(rect);
            if (this.f8551C) {
                this.f8615v0.a0(this.f8578d.getTextSize());
                int gravity = this.f8578d.getGravity();
                this.f8615v0.S((gravity & (-113)) | 48);
                this.f8615v0.Z(gravity);
                this.f8615v0.O(r(rect));
                this.f8615v0.W(u(rect));
                this.f8615v0.J();
                if (!B() || this.f8613u0) {
                    return;
                }
                W();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (!this.f8550B0) {
            this.f8576c.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.f8550B0 = true;
        }
        w0();
        this.f8576c.x0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.c());
        setError(gVar.f8630c);
        if (gVar.f8631d) {
            post(new b());
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        boolean z3 = i3 == 1;
        if (z3 != this.f8561M) {
            float fA = this.f8560L.r().a(this.f8573a0);
            float fA2 = this.f8560L.t().a(this.f8573a0);
            p042l1.k kVarM = p042l1.k.a().z(this.f8560L.s()).D(this.f8560L.q()).r(this.f8560L.k()).v(this.f8560L.i()).A(fA2).E(fA).s(this.f8560L.l().a(this.f8573a0)).w(this.f8560L.j().a(this.f8573a0)).m();
            this.f8561M = z3;
            setShapeAppearanceModel(kVarM);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        g gVar = new g(super.onSaveInstanceState());
        if (d0()) {
            gVar.f8630c = getError();
        }
        gVar.f8631d = this.f8576c.E();
        return gVar;
    }

    void p0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f8578d;
        if (editText == null || this.f8563O != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (S.a(background)) {
            background = background.mutate();
        }
        if (d0()) {
            background.setColorFilter(C0266j.e(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f8596m && (textView = this.f8600o) != null) {
            background.setColorFilter(C0266j.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            androidx.core.graphics.drawable.a.c(background);
            this.f8578d.refreshDrawableState();
        }
    }

    void r0() {
        EditText editText = this.f8578d;
        if (editText == null || this.f8554F == null) {
            return;
        }
        if ((this.f8557I || editText.getBackground() == null) && this.f8563O != 0) {
            q0();
            this.f8557I = true;
        }
    }

    public void setBoxBackgroundColor(int i3) {
        if (this.f8569U != i3) {
            this.f8569U = i3;
            this.f8601o0 = i3;
            this.f8605q0 = i3;
            this.f8607r0 = i3;
            m();
        }
    }

    public void setBoxBackgroundColorResource(int i3) {
        setBoxBackgroundColor(androidx.core.content.a.b(getContext(), i3));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f8601o0 = defaultColor;
        this.f8569U = defaultColor;
        this.f8603p0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f8605q0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f8607r0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        m();
    }

    public void setBoxBackgroundMode(int i3) {
        if (i3 == this.f8563O) {
            return;
        }
        this.f8563O = i3;
        if (this.f8578d != null) {
            V();
        }
    }

    public void setBoxCollapsedPaddingTop(int i3) {
        this.f8564P = i3;
    }

    public void setBoxCornerFamily(int i3) {
        this.f8560L = this.f8560L.v().y(i3, this.f8560L.r()).C(i3, this.f8560L.t()).q(i3, this.f8560L.j()).u(i3, this.f8560L.l()).m();
        m();
    }

    public void setBoxStrokeColor(int i3) {
        if (this.f8597m0 != i3) {
            this.f8597m0 = i3;
            A0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f8593k0 = colorStateList.getDefaultColor();
            this.f8609s0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f8595l0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f8597m0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f8597m0 != colorStateList.getDefaultColor()) {
            this.f8597m0 = colorStateList.getDefaultColor();
        }
        A0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f8599n0 != colorStateList) {
            this.f8599n0 = colorStateList;
            A0();
        }
    }

    public void setBoxStrokeWidth(int i3) {
        this.f8566R = i3;
        A0();
    }

    public void setBoxStrokeWidthFocused(int i3) {
        this.f8567S = i3;
        A0();
    }

    public void setBoxStrokeWidthFocusedResource(int i3) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i3));
    }

    public void setBoxStrokeWidthResource(int i3) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i3));
    }

    public void setCounterEnabled(boolean z3) {
        if (this.f8592k != z3) {
            if (z3) {
                androidx.appcompat.widget.F f3 = new androidx.appcompat.widget.F(getContext());
                this.f8600o = f3;
                f3.setId(S0.e.f1625K);
                Typeface typeface = this.f8575b0;
                if (typeface != null) {
                    this.f8600o.setTypeface(typeface);
                }
                this.f8600o.setMaxLines(1);
                this.f8590j.e(this.f8600o, 2);
                AbstractC0321u.d((ViewGroup.MarginLayoutParams) this.f8600o.getLayoutParams(), getResources().getDimensionPixelOffset(S0.c.f1586j0));
                m0();
                j0();
            } else {
                this.f8590j.C(this.f8600o, 2);
                this.f8600o = null;
            }
            this.f8592k = z3;
        }
    }

    public void setCounterMaxLength(int i3) {
        if (this.f8594l != i3) {
            if (i3 > 0) {
                this.f8594l = i3;
            } else {
                this.f8594l = -1;
            }
            if (this.f8592k) {
                j0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i3) {
        if (this.f8602p != i3) {
            this.f8602p = i3;
            m0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f8622z != colorStateList) {
            this.f8622z = colorStateList;
            m0();
        }
    }

    public void setCounterTextAppearance(int i3) {
        if (this.f8604q != i3) {
            this.f8604q = i3;
            m0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f8620y != colorStateList) {
            this.f8620y = colorStateList;
            m0();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.f8547A != colorStateList) {
            this.f8547A = colorStateList;
            n0();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.f8549B != colorStateList) {
            this.f8549B = colorStateList;
            if (Q()) {
                n0();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f8589i0 = colorStateList;
        this.f8591j0 = colorStateList;
        if (this.f8578d != null) {
            u0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z3) {
        Y(this, z3);
        super.setEnabled(z3);
    }

    public void setEndIconActivated(boolean z3) {
        this.f8576c.N(z3);
    }

    public void setEndIconCheckable(boolean z3) {
        this.f8576c.O(z3);
    }

    public void setEndIconContentDescription(int i3) {
        this.f8576c.P(i3);
    }

    public void setEndIconDrawable(int i3) {
        this.f8576c.R(i3);
    }

    public void setEndIconMinSize(int i3) {
        this.f8576c.T(i3);
    }

    public void setEndIconMode(int i3) {
        this.f8576c.U(i3);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        this.f8576c.V(onClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f8576c.W(onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        this.f8576c.X(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        this.f8576c.Y(colorStateList);
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        this.f8576c.Z(mode);
    }

    public void setEndIconVisible(boolean z3) {
        this.f8576c.a0(z3);
    }

    public void setError(CharSequence charSequence) {
        if (!this.f8590j.A()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f8590j.w();
        } else {
            this.f8590j.Q(charSequence);
        }
    }

    public void setErrorAccessibilityLiveRegion(int i3) {
        this.f8590j.E(i3);
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f8590j.F(charSequence);
    }

    public void setErrorEnabled(boolean z3) {
        this.f8590j.G(z3);
    }

    public void setErrorIconDrawable(int i3) {
        this.f8576c.b0(i3);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        this.f8576c.d0(onClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f8576c.e0(onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.f8576c.f0(colorStateList);
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        this.f8576c.g0(mode);
    }

    public void setErrorTextAppearance(int i3) {
        this.f8590j.H(i3);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f8590j.I(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z3) {
        if (this.f8617w0 != z3) {
            this.f8617w0 = z3;
            u0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (O()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!O()) {
                setHelperTextEnabled(true);
            }
            this.f8590j.R(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f8590j.L(colorStateList);
    }

    public void setHelperTextEnabled(boolean z3) {
        this.f8590j.K(z3);
    }

    public void setHelperTextTextAppearance(int i3) {
        this.f8590j.J(i3);
    }

    public void setHint(CharSequence charSequence) {
        if (this.f8551C) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z3) {
        this.f8619x0 = z3;
    }

    public void setHintEnabled(boolean z3) {
        if (z3 != this.f8551C) {
            this.f8551C = z3;
            if (z3) {
                CharSequence hint = this.f8578d.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f8552D)) {
                        setHint(hint);
                    }
                    this.f8578d.setHint((CharSequence) null);
                }
                this.f8553E = true;
            } else {
                this.f8553E = false;
                if (!TextUtils.isEmpty(this.f8552D) && TextUtils.isEmpty(this.f8578d.getHint())) {
                    this.f8578d.setHint(this.f8552D);
                }
                setHintInternal(null);
            }
            if (this.f8578d != null) {
                t0();
            }
        }
    }

    public void setHintTextAppearance(int i3) {
        this.f8615v0.P(i3);
        this.f8591j0 = this.f8615v0.p();
        if (this.f8578d != null) {
            u0(false);
            t0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f8591j0 != colorStateList) {
            if (this.f8589i0 == null) {
                this.f8615v0.R(colorStateList);
            }
            this.f8591j0 = colorStateList;
            if (this.f8578d != null) {
                u0(false);
            }
        }
    }

    public void setLengthCounter(e eVar) {
        this.f8598n = eVar;
    }

    public void setMaxEms(int i3) {
        this.f8584g = i3;
        EditText editText = this.f8578d;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMaxEms(i3);
    }

    public void setMaxWidth(int i3) {
        this.f8588i = i3;
        EditText editText = this.f8578d;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMaxWidth(i3);
    }

    public void setMaxWidthResource(int i3) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i3));
    }

    public void setMinEms(int i3) {
        this.f8582f = i3;
        EditText editText = this.f8578d;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMinEms(i3);
    }

    public void setMinWidth(int i3) {
        this.f8586h = i3;
        EditText editText = this.f8578d;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMinWidth(i3);
    }

    public void setMinWidthResource(int i3) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i3));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i3) {
        this.f8576c.i0(i3);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i3) {
        this.f8576c.k0(i3);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z3) {
        this.f8576c.m0(z3);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f8576c.n0(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f8576c.o0(mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f8610t == null) {
            androidx.appcompat.widget.F f3 = new androidx.appcompat.widget.F(getContext());
            this.f8610t = f3;
            f3.setId(S0.e.f1628N);
            Z.z0(this.f8610t, 2);
            C0377c c0377cA = A();
            this.f8616w = c0377cA;
            c0377cA.d0(67L);
            this.f8618x = A();
            setPlaceholderTextAppearance(this.f8614v);
            setPlaceholderTextColor(this.f8612u);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f8608s) {
                setPlaceholderTextEnabled(true);
            }
            this.f8606r = charSequence;
        }
        x0();
    }

    public void setPlaceholderTextAppearance(int i3) {
        this.f8614v = i3;
        TextView textView = this.f8610t;
        if (textView != null) {
            androidx.core.widget.j.o(textView, i3);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f8612u != colorStateList) {
            this.f8612u = colorStateList;
            TextView textView = this.f8610t;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f8574b.n(charSequence);
    }

    public void setPrefixTextAppearance(int i3) {
        this.f8574b.o(i3);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f8574b.p(colorStateList);
    }

    public void setShapeAppearanceModel(p042l1.k kVar) {
        p042l1.g gVar = this.f8554F;
        if (gVar == null || gVar.B() == kVar) {
            return;
        }
        this.f8560L = kVar;
        m();
    }

    public void setStartIconCheckable(boolean z3) {
        this.f8574b.q(z3);
    }

    public void setStartIconContentDescription(int i3) {
        setStartIconContentDescription(i3 != 0 ? getResources().getText(i3) : null);
    }

    public void setStartIconDrawable(int i3) {
        setStartIconDrawable(i3 != 0 ? p016e.a.b(getContext(), i3) : null);
    }

    public void setStartIconMinSize(int i3) {
        this.f8574b.t(i3);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.f8574b.u(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f8574b.v(onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        this.f8574b.w(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.f8574b.x(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.f8574b.y(mode);
    }

    public void setStartIconVisible(boolean z3) {
        this.f8574b.z(z3);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f8576c.p0(charSequence);
    }

    public void setSuffixTextAppearance(int i3) {
        this.f8576c.q0(i3);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f8576c.r0(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(d dVar) {
        EditText editText = this.f8578d;
        if (editText != null) {
            Z.q0(editText, dVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f8575b0) {
            this.f8575b0 = typeface;
            this.f8615v0.i0(typeface);
            this.f8590j.N(typeface);
            TextView textView = this.f8600o;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    void u0(boolean z3) {
        v0(z3, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f8545C0;
        super(p051o1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f8582f = -1;
        this.f8584g = -1;
        this.f8586h = -1;
        this.f8588i = -1;
        this.f8590j = new v(this);
        this.f8598n = new e() { // from class: com.google.android.material.textfield.M
            @Override // com.google.android.material.textfield.TextInputLayout.e
            public final int a(Editable editable) {
                return TextInputLayout.T(editable);
            }
        };
        this.f8570V = new Rect();
        this.f8571W = new Rect();
        this.f8573a0 = new RectF();
        this.f8581e0 = new LinkedHashSet();
        C0488b c0488b = new C0488b(this);
        this.f8615v0 = c0488b;
        this.f8550B0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f8572a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        TimeInterpolator timeInterpolator = T0.a.f1956a;
        c0488b.h0(timeInterpolator);
        c0488b.e0(timeInterpolator);
        c0488b.S(8388659);
        int[] iArr = S0.k.m7;
        int i5 = S0.k.J7;
        int i6 = S0.k.H7;
        int i7 = S0.k.b8;
        int i8 = S0.k.g8;
        int i9 = S0.k.k8;
        j0 j0VarJ = com.google.android.material.internal.C.j(context2, attributeSet, iArr, i3, i4, i5, i6, i7, i8, i9);
        A a3 = new A(this, j0VarJ);
        this.f8574b = a3;
        this.f8551C = j0VarJ.a(S0.k.j8, true);
        setHint(j0VarJ.p(S0.k.r7));
        this.f8619x0 = j0VarJ.a(S0.k.i8, true);
        this.f8617w0 = j0VarJ.a(S0.k.d8, true);
        int i10 = S0.k.t7;
        if (j0VarJ.s(i10)) {
            setMinEms(j0VarJ.k(i10, -1));
        } else {
            int i11 = S0.k.q7;
            if (j0VarJ.s(i11)) {
                setMinWidth(j0VarJ.f(i11, -1));
            }
        }
        int i12 = S0.k.s7;
        if (j0VarJ.s(i12)) {
            setMaxEms(j0VarJ.k(i12, -1));
        } else {
            int i13 = S0.k.p7;
            if (j0VarJ.s(i13)) {
                setMaxWidth(j0VarJ.f(i13, -1));
            }
        }
        this.f8560L = p042l1.k.e(context2, attributeSet, i3, i4).m();
        this.f8562N = context2.getResources().getDimensionPixelOffset(S0.c.f1580g0);
        this.f8564P = j0VarJ.e(S0.k.w7, 0);
        this.f8566R = j0VarJ.f(S0.k.D7, context2.getResources().getDimensionPixelSize(S0.c.f1582h0));
        this.f8567S = j0VarJ.f(S0.k.E7, context2.getResources().getDimensionPixelSize(S0.c.f1584i0));
        this.f8565Q = this.f8566R;
        float fD = j0VarJ.d(S0.k.A7, -1.0f);
        float fD2 = j0VarJ.d(S0.k.z7, -1.0f);
        float fD3 = j0VarJ.d(S0.k.x7, -1.0f);
        float fD4 = j0VarJ.d(S0.k.y7, -1.0f);
        l1.k.b bVarV = this.f8560L.v();
        if (fD >= 0.0f) {
            bVarV.A(fD);
        }
        if (fD2 >= 0.0f) {
            bVarV.E(fD2);
        }
        if (fD3 >= 0.0f) {
            bVarV.w(fD3);
        }
        if (fD4 >= 0.0f) {
            bVarV.s(fD4);
        }
        this.f8560L = bVarV.m();
        ColorStateList colorStateListB = p030h1.c.b(context2, j0VarJ, S0.k.u7);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.f8601o0 = defaultColor;
            this.f8569U = defaultColor;
            if (colorStateListB.isStateful()) {
                this.f8603p0 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.f8605q0 = colorStateListB.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f8607r0 = colorStateListB.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f8605q0 = this.f8601o0;
                ColorStateList colorStateListA = p016e.a.a(context2, S0.b.f1537c);
                this.f8603p0 = colorStateListA.getColorForState(new int[]{-16842910}, -1);
                this.f8607r0 = colorStateListA.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.f8569U = 0;
            this.f8601o0 = 0;
            this.f8603p0 = 0;
            this.f8605q0 = 0;
            this.f8607r0 = 0;
        }
        int i14 = S0.k.o7;
        if (j0VarJ.s(i14)) {
            ColorStateList colorStateListC = j0VarJ.c(i14);
            this.f8591j0 = colorStateListC;
            this.f8589i0 = colorStateListC;
        }
        int i15 = S0.k.B7;
        ColorStateList colorStateListB2 = p030h1.c.b(context2, j0VarJ, i15);
        this.f8597m0 = j0VarJ.b(i15, 0);
        this.f8593k0 = androidx.core.content.a.b(context2, S0.b.f1538d);
        this.f8609s0 = androidx.core.content.a.b(context2, S0.b.f1539e);
        this.f8595l0 = androidx.core.content.a.b(context2, S0.b.f1540f);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        int i16 = S0.k.C7;
        if (j0VarJ.s(i16)) {
            setBoxStrokeErrorColor(p030h1.c.b(context2, j0VarJ, i16));
        }
        if (j0VarJ.n(i9, -1) != -1) {
            setHintTextAppearance(j0VarJ.n(i9, 0));
        }
        this.f8547A = j0VarJ.c(S0.k.L7);
        this.f8549B = j0VarJ.c(S0.k.M7);
        int iN = j0VarJ.n(i7, 0);
        CharSequence charSequenceP = j0VarJ.p(S0.k.W7);
        int iK = j0VarJ.k(S0.k.V7, 1);
        boolean zA = j0VarJ.a(S0.k.X7, false);
        int iN2 = j0VarJ.n(i8, 0);
        boolean zA2 = j0VarJ.a(S0.k.f8, false);
        CharSequence charSequenceP2 = j0VarJ.p(S0.k.e8);
        int iN3 = j0VarJ.n(S0.k.s8, 0);
        CharSequence charSequenceP3 = j0VarJ.p(S0.k.r8);
        boolean zA3 = j0VarJ.a(S0.k.F7, false);
        setCounterMaxLength(j0VarJ.k(S0.k.G7, -1));
        this.f8604q = j0VarJ.n(i5, 0);
        this.f8602p = j0VarJ.n(i6, 0);
        setBoxBackgroundMode(j0VarJ.k(S0.k.v7, 0));
        setErrorContentDescription(charSequenceP);
        setErrorAccessibilityLiveRegion(iK);
        setCounterOverflowTextAppearance(this.f8602p);
        setHelperTextTextAppearance(iN2);
        setErrorTextAppearance(iN);
        setCounterTextAppearance(this.f8604q);
        setPlaceholderText(charSequenceP3);
        setPlaceholderTextAppearance(iN3);
        int i17 = S0.k.c8;
        if (j0VarJ.s(i17)) {
            setErrorTextColor(j0VarJ.c(i17));
        }
        int i18 = S0.k.h8;
        if (j0VarJ.s(i18)) {
            setHelperTextColor(j0VarJ.c(i18));
        }
        int i19 = S0.k.l8;
        if (j0VarJ.s(i19)) {
            setHintTextColor(j0VarJ.c(i19));
        }
        int i20 = S0.k.K7;
        if (j0VarJ.s(i20)) {
            setCounterTextColor(j0VarJ.c(i20));
        }
        int i21 = S0.k.I7;
        if (j0VarJ.s(i21)) {
            setCounterOverflowTextColor(j0VarJ.c(i21));
        }
        int i22 = S0.k.t8;
        if (j0VarJ.s(i22)) {
            setPlaceholderTextColor(j0VarJ.c(i22));
        }
        s sVar = new s(this, j0VarJ);
        this.f8576c = sVar;
        boolean zA4 = j0VarJ.a(S0.k.n7, true);
        j0VarJ.w();
        Z.z0(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            Z.B0(this, 1);
        }
        frameLayout.addView(a3);
        frameLayout.addView(sVar);
        addView(frameLayout);
        setEnabled(zA4);
        setHelperTextEnabled(zA2);
        setErrorEnabled(zA);
        setCounterEnabled(zA3);
        setHelperText(charSequenceP2);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        this.f8576c.Q(charSequence);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f8576c.S(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f8576c.c0(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f8576c.j0(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f8576c.l0(drawable);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.f8574b.r(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f8574b.s(drawable);
    }

    public void setHint(int i3) {
        setHint(i3 != 0 ? getResources().getText(i3) : null);
    }
}
