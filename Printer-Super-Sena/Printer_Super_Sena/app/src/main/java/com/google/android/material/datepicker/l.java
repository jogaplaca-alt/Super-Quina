package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.H;
import androidx.core.view.C0332z0;
import androidx.core.view.I;
import androidx.core.view.Z;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0336d;
import com.google.android.material.internal.AbstractC0493g;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.F;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class l<S> extends DialogInterfaceOnCancelListenerC0336d {

    /* JADX INFO: renamed from: T0, reason: collision with root package name */
    static final Object f8090T0 = "CONFIRM_BUTTON_TAG";

    /* JADX INFO: renamed from: U0, reason: collision with root package name */
    static final Object f8091U0 = "CANCEL_BUTTON_TAG";

    /* JADX INFO: renamed from: V0, reason: collision with root package name */
    static final Object f8092V0 = "TOGGLE_BUTTON_TAG";

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    private CharSequence f8093A0;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    private boolean f8094B0;

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    private int f8095C0;

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    private int f8096D0;

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    private CharSequence f8097E0;

    /* JADX INFO: renamed from: F0, reason: collision with root package name */
    private int f8098F0;

    /* JADX INFO: renamed from: G0, reason: collision with root package name */
    private CharSequence f8099G0;

    /* JADX INFO: renamed from: H0, reason: collision with root package name */
    private int f8100H0;

    /* JADX INFO: renamed from: I0, reason: collision with root package name */
    private CharSequence f8101I0;

    /* JADX INFO: renamed from: J0, reason: collision with root package name */
    private int f8102J0;

    /* JADX INFO: renamed from: K0, reason: collision with root package name */
    private CharSequence f8103K0;

    /* JADX INFO: renamed from: L0, reason: collision with root package name */
    private TextView f8104L0;

    /* JADX INFO: renamed from: M0, reason: collision with root package name */
    private TextView f8105M0;

    /* JADX INFO: renamed from: N0, reason: collision with root package name */
    private CheckableImageButton f8106N0;

    /* JADX INFO: renamed from: O0, reason: collision with root package name */
    private p042l1.g f8107O0;

    /* JADX INFO: renamed from: P0, reason: collision with root package name */
    private Button f8108P0;

    /* JADX INFO: renamed from: Q0, reason: collision with root package name */
    private boolean f8109Q0;

    /* JADX INFO: renamed from: R0, reason: collision with root package name */
    private CharSequence f8110R0;

    /* JADX INFO: renamed from: S0, reason: collision with root package name */
    private CharSequence f8111S0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private final LinkedHashSet f8112r0 = new LinkedHashSet();

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private final LinkedHashSet f8113s0 = new LinkedHashSet();

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private final LinkedHashSet f8114t0 = new LinkedHashSet();

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private final LinkedHashSet f8115u0 = new LinkedHashSet();

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private int f8116v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private r f8117w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private C0486a f8118x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private j f8119y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private int f8120z0;

    class a implements I {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f8122b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8123c;

        a(int i3, View view, int i4) {
            this.f8121a = i3;
            this.f8122b = view;
            this.f8123c = i4;
        }

        @Override // androidx.core.view.I
        public C0332z0 a(View view, C0332z0 c0332z0) {
            int i3 = c0332z0.f(C0332z0.m.d()).f4483b;
            if (this.f8121a >= 0) {
                this.f8122b.getLayoutParams().height = this.f8121a + i3;
                View view2 = this.f8122b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.f8122b;
            view3.setPadding(view3.getPaddingLeft(), this.f8123c + i3, this.f8122b.getPaddingRight(), this.f8122b.getPaddingBottom());
            return c0332z0;
        }
    }

    class b extends q {
        b() {
        }
    }

    private static Drawable f2(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, p016e.a.b(context, S0.d.f1606d));
        stateListDrawable.addState(new int[0], p016e.a.b(context, S0.d.f1607e));
        return stateListDrawable;
    }

    private void g2(Window window) {
        if (this.f8109Q0) {
            return;
        }
        View viewFindViewById = t1().findViewById(S0.e.f1638g);
        AbstractC0493g.a(window, true, F.d(viewFindViewById), null);
        Z.D0(viewFindViewById, new a(viewFindViewById.getLayoutParams().height, viewFindViewById, viewFindViewById.getPaddingTop()));
        this.f8109Q0 = true;
    }

    private d h2() {
        H.a(r().getParcelable("DATE_SELECTOR_KEY"));
        return null;
    }

    private static CharSequence i2(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String[] strArrSplit = TextUtils.split(String.valueOf(charSequence), "\n");
        return strArrSplit.length > 1 ? strArrSplit[0] : charSequence;
    }

    private String j2() {
        h2();
        s1();
        throw null;
    }

    private static int l2(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(S0.c.f1558R);
        int i3 = n.f().f8132d;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(S0.c.f1560T) * i3) + ((i3 - 1) * resources.getDimensionPixelOffset(S0.c.f1563W));
    }

    private int m2(Context context) {
        int i3 = this.f8116v0;
        if (i3 != 0) {
            return i3;
        }
        h2();
        throw null;
    }

    private void n2(Context context) {
        this.f8106N0.setTag(f8092V0);
        this.f8106N0.setImageDrawable(f2(context));
        this.f8106N0.setChecked(this.f8095C0 != 0);
        Z.q0(this.f8106N0, null);
        w2(this.f8106N0);
        this.f8106N0.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f8089a.r2(view);
            }
        });
    }

    static boolean o2(Context context) {
        return s2(context, R.attr.windowFullscreen);
    }

    private boolean p2() {
        return M().getConfiguration().orientation == 2;
    }

    static boolean q2(Context context) {
        return s2(context, S0.a.f1493K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(View view) {
        h2();
        throw null;
    }

    static boolean s2(Context context, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(p030h1.b.d(context, S0.a.f1530v, j.class.getCanonicalName()), new int[]{i3});
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z3;
    }

    private void t2() {
        int iM2 = m2(s1());
        h2();
        j jVarG2 = j.g2(null, iM2, this.f8118x0, null);
        this.f8119y0 = jVarG2;
        r rVarS1 = jVarG2;
        if (this.f8095C0 == 1) {
            h2();
            rVarS1 = m.S1(null, iM2, this.f8118x0);
        }
        this.f8117w0 = rVarS1;
        v2();
        u2(k2());
        androidx.fragment.app.w wVarJ = s().j();
        wVarJ.n(S0.e.f1656y, this.f8117w0);
        wVarJ.h();
        this.f8117w0.Q1(new b());
    }

    private void v2() {
        this.f8104L0.setText((this.f8095C0 == 1 && p2()) ? this.f8111S0 : this.f8110R0);
    }

    private void w2(CheckableImageButton checkableImageButton) {
        this.f8106N0.setContentDescription(this.f8095C0 == 1 ? checkableImageButton.getContext().getString(S0.i.f1710w) : checkableImageButton.getContext().getString(S0.i.f1712y));
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0336d, androidx.fragment.app.AbstractComponentCallbacksC0337e
    public final void L0(Bundle bundle) {
        super.L0(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f8116v0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        C0486a.b bVar = new C0486a.b(this.f8118x0);
        j jVar = this.f8119y0;
        n nVarB2 = jVar == null ? null : jVar.b2();
        if (nVarB2 != null) {
            bVar.b(nVarB2.f8134f);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f8120z0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f8093A0);
        bundle.putInt("INPUT_MODE_KEY", this.f8095C0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f8096D0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f8097E0);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f8098F0);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f8099G0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f8100H0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f8101I0);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f8102J0);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f8103K0);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0336d, androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void M0() {
        super.M0();
        Window window = a2().getWindow();
        if (this.f8094B0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f8107O0);
            g2(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = M().getDimensionPixelOffset(S0.c.f1562V);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f8107O0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new p006b1.a(a2(), rect));
        }
        t2();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0336d, androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void N0() {
        this.f8117w0.R1();
        super.N0();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0336d
    public final Dialog W1(Bundle bundle) {
        Dialog dialog = new Dialog(s1(), m2(s1()));
        Context context = dialog.getContext();
        this.f8094B0 = o2(context);
        int i3 = S0.a.f1530v;
        int i4 = S0.j.f1735v;
        this.f8107O0 = new p042l1.g(context, null, i3, i4);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, S0.k.o3, i3, i4);
        int color = typedArrayObtainStyledAttributes.getColor(S0.k.p3, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f8107O0.K(context);
        this.f8107O0.V(ColorStateList.valueOf(color));
        this.f8107O0.U(Z.w(dialog.getWindow().getDecorView()));
        return dialog;
    }

    public String k2() {
        h2();
        t();
        throw null;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0336d, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f8114t0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0336d, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f8115u0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) U();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0336d, androidx.fragment.app.AbstractComponentCallbacksC0337e
    public final void p0(Bundle bundle) {
        super.p0(bundle);
        if (bundle == null) {
            bundle = r();
        }
        this.f8116v0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        H.a(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.f8118x0 = (C0486a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        H.a(bundle.getParcelable("DAY_VIEW_DECORATOR_KEY"));
        this.f8120z0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f8093A0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f8095C0 = bundle.getInt("INPUT_MODE_KEY");
        this.f8096D0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f8097E0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f8098F0 = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f8099G0 = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.f8100H0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f8101I0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.f8102J0 = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f8103K0 = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.f8093A0;
        if (text == null) {
            text = s1().getResources().getText(this.f8120z0);
        }
        this.f8110R0 = text;
        this.f8111S0 = i2(text);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public final View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.f8094B0 ? S0.g.f1684y : S0.g.f1683x, viewGroup);
        Context context = viewInflate.getContext();
        if (this.f8094B0) {
            viewInflate.findViewById(S0.e.f1656y).setLayoutParams(new LinearLayout.LayoutParams(l2(context), -2));
        } else {
            viewInflate.findViewById(S0.e.f1657z).setLayoutParams(new LinearLayout.LayoutParams(l2(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(S0.e.f1617C);
        this.f8105M0 = textView;
        Z.s0(textView, 1);
        this.f8106N0 = (CheckableImageButton) viewInflate.findViewById(S0.e.f1618D);
        this.f8104L0 = (TextView) viewInflate.findViewById(S0.e.f1619E);
        n2(context);
        this.f8108P0 = (Button) viewInflate.findViewById(S0.e.f1635d);
        h2();
        throw null;
    }

    void u2(String str) {
        this.f8105M0.setContentDescription(j2());
        this.f8105M0.setText(str);
    }
}
