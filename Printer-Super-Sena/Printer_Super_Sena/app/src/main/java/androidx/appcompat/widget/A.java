package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.DialogInterfaceC0247c;

/* JADX INFO: loaded from: classes.dex */
public class A extends Spinner implements androidx.core.view.T {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f2950i = {R.attr.spinnerMode};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0261e f2951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private V f2953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SpinnerAdapter f2954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f2955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private j f2956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f2957g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Rect f2958h;

    class a extends V {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ h f2959j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, h hVar) {
            super(view);
            this.f2959j = hVar;
        }

        @Override // androidx.appcompat.widget.V
        public androidx.appcompat.view.menu.p b() {
            return this.f2959j;
        }

        @Override // androidx.appcompat.widget.V
        public boolean c() {
            if (A.this.getInternalPopup().b()) {
                return true;
            }
            A.this.b();
            return true;
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!A.this.getInternalPopup().b()) {
                A.this.b();
            }
            ViewTreeObserver viewTreeObserver = A.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                c.a(viewTreeObserver, this);
            }
        }
    }

    private static final class c {
        static void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    private static final class d {
        static int a(View view) {
            return view.getTextAlignment();
        }

        static int b(View view) {
            return view.getTextDirection();
        }

        static void c(View view, int i3) {
            view.setTextAlignment(i3);
        }

        static void d(View view, int i3) {
            view.setTextDirection(i3);
        }
    }

    private static final class e {
        static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (p082z.c.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                return;
            }
            themedSpinnerAdapter.setDropDownViewTheme(theme);
        }
    }

    class f implements j, DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        DialogInterfaceC0247c f2962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ListAdapter f2963b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f2964c;

        f() {
        }

        @Override // androidx.appcompat.widget.A.j
        public void a(int i3) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.A.j
        public boolean b() {
            DialogInterfaceC0247c dialogInterfaceC0247c = this.f2962a;
            if (dialogInterfaceC0247c != null) {
                return dialogInterfaceC0247c.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.A.j
        public int c() {
            return 0;
        }

        @Override // androidx.appcompat.widget.A.j
        public void d(int i3, int i4) {
            if (this.f2963b == null) {
                return;
            }
            DialogInterfaceC0247c.a aVar = new DialogInterfaceC0247c.a(A.this.getPopupContext());
            CharSequence charSequence = this.f2964c;
            if (charSequence != null) {
                aVar.j(charSequence);
            }
            DialogInterfaceC0247c dialogInterfaceC0247cA = aVar.i(this.f2963b, A.this.getSelectedItemPosition(), this).a();
            this.f2962a = dialogInterfaceC0247cA;
            ListView listViewH = dialogInterfaceC0247cA.h();
            d.d(listViewH, i3);
            d.c(listViewH, i4);
            this.f2962a.show();
        }

        @Override // androidx.appcompat.widget.A.j
        public void dismiss() {
            DialogInterfaceC0247c dialogInterfaceC0247c = this.f2962a;
            if (dialogInterfaceC0247c != null) {
                dialogInterfaceC0247c.dismiss();
                this.f2962a = null;
            }
        }

        @Override // androidx.appcompat.widget.A.j
        public int g() {
            return 0;
        }

        @Override // androidx.appcompat.widget.A.j
        public Drawable i() {
            return null;
        }

        @Override // androidx.appcompat.widget.A.j
        public CharSequence j() {
            return this.f2964c;
        }

        @Override // androidx.appcompat.widget.A.j
        public void l(CharSequence charSequence) {
            this.f2964c = charSequence;
        }

        @Override // androidx.appcompat.widget.A.j
        public void m(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.A.j
        public void n(int i3) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.A.j
        public void o(ListAdapter listAdapter) {
            this.f2963b = listAdapter;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            A.this.setSelection(i3);
            if (A.this.getOnItemClickListener() != null) {
                A.this.performItemClick(null, i3, this.f2963b.getItemId(i3));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.A.j
        public void p(int i3) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }
    }

    private static class g implements ListAdapter, SpinnerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SpinnerAdapter f2966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ListAdapter f2967b;

        public g(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f2966a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f2967b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null || Build.VERSION.SDK_INT < 23 || !B.a(spinnerAdapter)) {
                return;
            }
            e.a(C.a(spinnerAdapter), theme);
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f2967b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f2966a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f2966a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i3, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            SpinnerAdapter spinnerAdapter = this.f2966a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            SpinnerAdapter spinnerAdapter = this.f2966a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i3);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i3) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            return getDropDownView(i3, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f2966a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i3) {
            ListAdapter listAdapter = this.f2967b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i3);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f2966a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f2966a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    class h extends X implements j {

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private CharSequence f2968J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        ListAdapter f2969K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        private final Rect f2970L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        private int f2971M;

        class a implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ A f2973a;

            a(A a3) {
                this.f2973a = a3;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
                A.this.setSelection(i3);
                if (A.this.getOnItemClickListener() != null) {
                    h hVar = h.this;
                    A.this.performItemClick(view, i3, hVar.f2969K.getItemId(i3));
                }
                h.this.dismiss();
            }
        }

        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                h hVar = h.this;
                if (!hVar.V(A.this)) {
                    h.this.dismiss();
                } else {
                    h.this.T();
                    h.super.f();
                }
            }
        }

        class c implements PopupWindow.OnDismissListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f2976a;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f2976a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = A.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f2976a);
                }
            }
        }

        public h(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            this.f2970L = new Rect();
            D(A.this);
            J(true);
            P(0);
            L(new a(A.this));
        }

        void T() {
            int i3;
            Drawable drawableI = i();
            if (drawableI != null) {
                drawableI.getPadding(A.this.f2958h);
                i3 = u0.b(A.this) ? A.this.f2958h.right : -A.this.f2958h.left;
            } else {
                Rect rect = A.this.f2958h;
                rect.right = 0;
                rect.left = 0;
                i3 = 0;
            }
            int paddingLeft = A.this.getPaddingLeft();
            int paddingRight = A.this.getPaddingRight();
            int width = A.this.getWidth();
            A a3 = A.this;
            int i4 = a3.f2957g;
            if (i4 == -2) {
                int iA = a3.a((SpinnerAdapter) this.f2969K, i());
                int i5 = A.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = A.this.f2958h;
                int i6 = (i5 - rect2.left) - rect2.right;
                if (iA > i6) {
                    iA = i6;
                }
                F(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (i4 == -1) {
                F((width - paddingLeft) - paddingRight);
            } else {
                F(i4);
            }
            a(u0.b(A.this) ? i3 + (((width - paddingRight) - z()) - U()) : i3 + paddingLeft + U());
        }

        public int U() {
            return this.f2971M;
        }

        boolean V(View view) {
            return androidx.core.view.Z.T(view) && view.getGlobalVisibleRect(this.f2970L);
        }

        @Override // androidx.appcompat.widget.A.j
        public void d(int i3, int i4) {
            ViewTreeObserver viewTreeObserver;
            boolean zB = b();
            T();
            I(2);
            super.f();
            ListView listViewK = k();
            listViewK.setChoiceMode(1);
            d.d(listViewK, i3);
            d.c(listViewK, i4);
            Q(A.this.getSelectedItemPosition());
            if (zB || (viewTreeObserver = A.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            K(new c(bVar));
        }

        @Override // androidx.appcompat.widget.A.j
        public CharSequence j() {
            return this.f2968J;
        }

        @Override // androidx.appcompat.widget.A.j
        public void l(CharSequence charSequence) {
            this.f2968J = charSequence;
        }

        @Override // androidx.appcompat.widget.X, androidx.appcompat.widget.A.j
        public void o(ListAdapter listAdapter) {
            super.o(listAdapter);
            this.f2969K = listAdapter;
        }

        @Override // androidx.appcompat.widget.A.j
        public void p(int i3) {
            this.f2971M = i3;
        }
    }

    static class i extends View.BaseSavedState {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2978a;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i3) {
                return new i[i3];
            }
        }

        i(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeByte(this.f2978a ? (byte) 1 : (byte) 0);
        }

        i(Parcel parcel) {
            super(parcel);
            this.f2978a = parcel.readByte() != 0;
        }
    }

    interface j {
        void a(int i3);

        boolean b();

        int c();

        void d(int i3, int i4);

        void dismiss();

        int g();

        Drawable i();

        CharSequence j();

        void l(CharSequence charSequence);

        void m(Drawable drawable);

        void n(int i3);

        void o(ListAdapter listAdapter);

        void p(int i3);
    }

    public A(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p012d.a.f9078K);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i3 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.f2958h);
        Rect rect = this.f2958h;
        return iMax2 + rect.left + rect.right;
    }

    void b() {
        this.f2956f.d(d.b(this), d.a(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0261e c0261e = this.f2951a;
        if (c0261e != null) {
            c0261e.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        j jVar = this.f2956f;
        return jVar != null ? jVar.c() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        j jVar = this.f2956f;
        return jVar != null ? jVar.g() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f2956f != null ? this.f2957g : super.getDropDownWidth();
    }

    final j getInternalPopup() {
        return this.f2956f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        j jVar = this.f2956f;
        return jVar != null ? jVar.i() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f2952b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        j jVar = this.f2956f;
        return jVar != null ? jVar.j() : super.getPrompt();
    }

    @Override // androidx.core.view.T
    public ColorStateList getSupportBackgroundTintList() {
        C0261e c0261e = this.f2951a;
        if (c0261e != null) {
            return c0261e.c();
        }
        return null;
    }

    @Override // androidx.core.view.T
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0261e c0261e = this.f2951a;
        if (c0261e != null) {
            return c0261e.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j jVar = this.f2956f;
        if (jVar == null || !jVar.b()) {
            return;
        }
        this.f2956f.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (this.f2956f == null || View.MeasureSpec.getMode(i3) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i3)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.getSuperState());
        if (!iVar.f2978a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        i iVar = new i(super.onSaveInstanceState());
        j jVar = this.f2956f;
        iVar.f2978a = jVar != null && jVar.b();
        return iVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        V v3 = this.f2953c;
        if (v3 == null || !v3.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        j jVar = this.f2956f;
        if (jVar == null) {
            return super.performClick();
        }
        if (jVar.b()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0261e c0261e = this.f2951a;
        if (c0261e != null) {
            c0261e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0261e c0261e = this.f2951a;
        if (c0261e != null) {
            c0261e.g(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i3) {
        j jVar = this.f2956f;
        if (jVar == null) {
            super.setDropDownHorizontalOffset(i3);
        } else {
            jVar.p(i3);
            this.f2956f.a(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i3) {
        j jVar = this.f2956f;
        if (jVar != null) {
            jVar.n(i3);
        } else {
            super.setDropDownVerticalOffset(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i3) {
        if (this.f2956f != null) {
            this.f2957g = i3;
        } else {
            super.setDropDownWidth(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        j jVar = this.f2956f;
        if (jVar != null) {
            jVar.m(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i3) {
        setPopupBackgroundDrawable(p016e.a.b(getPopupContext(), i3));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        j jVar = this.f2956f;
        if (jVar != null) {
            jVar.l(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0261e c0261e = this.f2951a;
        if (c0261e != null) {
            c0261e.i(colorStateList);
        }
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0261e c0261e = this.f2951a;
        if (c0261e != null) {
            c0261e.j(mode);
        }
    }

    public A(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, -1);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f2955e) {
            this.f2954d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f2956f != null) {
            Context context = this.f2952b;
            if (context == null) {
                context = getContext();
            }
            this.f2956f.o(new g(spinnerAdapter, context.getTheme()));
        }
    }

    public A(Context context, AttributeSet attributeSet, int i3, int i4) {
        this(context, attributeSet, i3, i4, null);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0070 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0073  */
    /* JADX WARN: Code duplicated, block: B:36:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:42:0x00db  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, androidx.appcompat.widget.A] */
    public A(Context context, AttributeSet attributeSet, int i3, int i4, Resources.Theme theme) throws Throwable {
        TypedArray typedArrayObtainStyledAttributes;
        CharSequence[] charSequenceArrQ;
        SpinnerAdapter spinnerAdapter;
        super(context, attributeSet, i3);
        this.f2958h = new Rect();
        f0.a(this, getContext());
        j0 j0VarV = j0.v(context, attributeSet, p012d.j.f9280F2, i3, 0);
        this.f2951a = new C0261e(this);
        if (theme != null) {
            this.f2952b = new androidx.appcompat.view.d(context, theme);
        } else {
            int iN = j0VarV.n(p012d.j.K2, 0);
            if (iN != 0) {
                this.f2952b = new androidx.appcompat.view.d(context, iN);
            } else {
                this.f2952b = context;
            }
        }
        ?? r11 = -1;
        ?? r3 = 0;
        try {
            if (i4 == -1) {
                try {
                    typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2950i, i3, 0);
                    try {
                        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(0);
                        r11 = typedArrayObtainStyledAttributes;
                        if (zHasValue) {
                            i4 = typedArrayObtainStyledAttributes.getInt(0, 0);
                            r11 = typedArrayObtainStyledAttributes;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        r11 = typedArrayObtainStyledAttributes;
                        if (typedArrayObtainStyledAttributes != null) {
                        }
                        if (i4 != 0) {
                            f fVar = new f();
                            this.f2956f = fVar;
                            fVar.l(j0VarV.o(p012d.j.I2));
                        } else if (i4 == 1) {
                            h hVar = new h(this.f2952b, attributeSet, i3);
                            j0 j0VarV2 = j0.v(this.f2952b, attributeSet, p012d.j.f9280F2, i3, 0);
                            this.f2957g = j0VarV2.m(p012d.j.J2, -2);
                            hVar.m(j0VarV2.g(p012d.j.H2));
                            hVar.l(j0VarV.o(p012d.j.I2));
                            j0VarV2.w();
                            this.f2956f = hVar;
                            this.f2953c = new a(this, hVar);
                        }
                        charSequenceArrQ = j0VarV.q(p012d.j.f9284G2);
                        if (charSequenceArrQ != null) {
                            ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, charSequenceArrQ);
                            arrayAdapter.setDropDownViewResource(p012d.g.f9237t);
                            setAdapter(arrayAdapter);
                        }
                        j0VarV.w();
                        this.f2955e = true;
                        spinnerAdapter = this.f2954d;
                        if (spinnerAdapter != null) {
                            setAdapter(spinnerAdapter);
                            this.f2954d = null;
                        }
                        this.f2951a.e(attributeSet, i3);
                    }
                } catch (Exception e4) {
                    e = e4;
                    typedArrayObtainStyledAttributes = null;
                } catch (Throwable th) {
                    th = th;
                    if (r3 != 0) {
                        r3.recycle();
                    }
                    throw th;
                }
                r11.recycle();
            }
            if (i4 != 0) {
                f fVar2 = new f();
                this.f2956f = fVar2;
                fVar2.l(j0VarV.o(p012d.j.I2));
            } else if (i4 == 1) {
                h hVar2 = new h(this.f2952b, attributeSet, i3);
                j0 j0VarV3 = j0.v(this.f2952b, attributeSet, p012d.j.f9280F2, i3, 0);
                this.f2957g = j0VarV3.m(p012d.j.J2, -2);
                hVar2.m(j0VarV3.g(p012d.j.H2));
                hVar2.l(j0VarV.o(p012d.j.I2));
                j0VarV3.w();
                this.f2956f = hVar2;
                this.f2953c = new a(this, hVar2);
            }
            charSequenceArrQ = j0VarV.q(p012d.j.f9284G2);
            if (charSequenceArrQ != null) {
                ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, R.layout.simple_spinner_item, charSequenceArrQ);
                arrayAdapter2.setDropDownViewResource(p012d.g.f9237t);
                setAdapter(arrayAdapter2);
            }
            j0VarV.w();
            this.f2955e = true;
            spinnerAdapter = this.f2954d;
            if (spinnerAdapter != null) {
                setAdapter(spinnerAdapter);
                this.f2954d = null;
            }
            this.f2951a.e(attributeSet, i3);
        } catch (Throwable th2) {
            th = th2;
            r3 = r11;
        }
    }
}
