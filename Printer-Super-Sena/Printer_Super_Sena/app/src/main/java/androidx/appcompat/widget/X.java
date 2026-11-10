package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class X implements androidx.appcompat.view.menu.p {

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static Method f3358G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static Method f3359H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private static Method f3360I;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private Runnable f3361A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    final Handler f3362B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private final Rect f3363C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private Rect f3364D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private boolean f3365E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    PopupWindow f3366F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ListAdapter f3368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    T f3369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3378l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f3379m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f3380n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f3381o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private View f3382p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f3383q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private DataSetObserver f3384r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private View f3385s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Drawable f3386t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private AdapterView.OnItemClickListener f3387u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f3388v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final i f3389w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final h f3390x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final g f3391y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final e f3392z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewT = X.this.t();
            if (viewT == null || viewT.getWindowToken() == null) {
                return;
            }
            X.this.f();
        }
    }

    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            T t3;
            if (i3 == -1 || (t3 = X.this.f3369c) == null) {
                return;
            }
            t3.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    static class c {
        static int a(PopupWindow popupWindow, View view, int i3, boolean z3) {
            return popupWindow.getMaxAvailableHeight(view, i3, z3);
        }
    }

    static class d {
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void b(PopupWindow popupWindow, boolean z3) {
            popupWindow.setIsClippedToScreen(z3);
        }
    }

    private class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            X.this.r();
        }
    }

    private class f extends DataSetObserver {
        f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (X.this.b()) {
                X.this.f();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            X.this.dismiss();
        }
    }

    private class g implements AbsListView.OnScrollListener {
        g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 != 1 || X.this.A() || X.this.f3366F.getContentView() == null) {
                return;
            }
            X x3 = X.this;
            x3.f3362B.removeCallbacks(x3.f3389w);
            X.this.f3389w.run();
        }
    }

    private class h implements View.OnTouchListener {
        h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x3 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = X.this.f3366F) != null && popupWindow.isShowing() && x3 >= 0 && x3 < X.this.f3366F.getWidth() && y3 >= 0 && y3 < X.this.f3366F.getHeight()) {
                X x4 = X.this;
                x4.f3362B.postDelayed(x4.f3389w, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            X x5 = X.this;
            x5.f3362B.removeCallbacks(x5.f3389w);
            return false;
        }
    }

    private class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            T t3 = X.this.f3369c;
            if (t3 == null || !androidx.core.view.Z.T(t3) || X.this.f3369c.getCount() <= X.this.f3369c.getChildCount()) {
                return;
            }
            int childCount = X.this.f3369c.getChildCount();
            X x3 = X.this;
            if (childCount <= x3.f3381o) {
                x3.f3366F.setInputMethodMode(2);
                X.this.f();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f3358G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f3360I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f3359H = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public X(Context context) {
        this(context, null, p012d.a.f9072E);
    }

    private void C() {
        View view = this.f3382p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f3382p);
            }
        }
    }

    private void O(boolean z3) {
        if (Build.VERSION.SDK_INT > 28) {
            d.b(this.f3366F, z3);
            return;
        }
        Method method = f3358G;
        if (method != null) {
            try {
                method.invoke(this.f3366F, Boolean.valueOf(z3));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int q() {
        int measuredHeight;
        int i3;
        int iMakeMeasureSpec;
        View view;
        int i4;
        if (this.f3369c == null) {
            Context context = this.f3367a;
            this.f3361A = new a();
            T tS = s(context, !this.f3365E);
            this.f3369c = tS;
            Drawable drawable = this.f3386t;
            if (drawable != null) {
                tS.setSelector(drawable);
            }
            this.f3369c.setAdapter(this.f3368b);
            this.f3369c.setOnItemClickListener(this.f3387u);
            this.f3369c.setFocusable(true);
            this.f3369c.setFocusableInTouchMode(true);
            this.f3369c.setOnItemSelectedListener(new b());
            this.f3369c.setOnScrollListener(this.f3391y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f3388v;
            if (onItemSelectedListener != null) {
                this.f3369c.setOnItemSelectedListener(onItemSelectedListener);
            }
            T t3 = this.f3369c;
            View view2 = this.f3382p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i5 = this.f3383q;
                if (i5 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(t3, layoutParams);
                } else if (i5 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f3383q);
                } else {
                    linearLayout.addView(t3, layoutParams);
                    linearLayout.addView(view2);
                }
                int i6 = this.f3371e;
                if (i6 >= 0) {
                    i4 = Integer.MIN_VALUE;
                } else {
                    i6 = 0;
                    i4 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i6, i4), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = t3;
            }
            this.f3366F.setContentView(view);
        } else {
            View view3 = this.f3382p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f3366F.getBackground();
        if (background != null) {
            background.getPadding(this.f3363C);
            Rect rect = this.f3363C;
            int i7 = rect.top;
            i3 = rect.bottom + i7;
            if (!this.f3375i) {
                this.f3373g = -i7;
            }
        } else {
            this.f3363C.setEmpty();
            i3 = 0;
        }
        int iU = u(t(), this.f3373g, this.f3366F.getInputMethodMode() == 2);
        if (this.f3379m || this.f3370d == -1) {
            return iU + i3;
        }
        int i8 = this.f3371e;
        if (i8 == -2) {
            int i9 = this.f3367a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.f3363C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i8 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
        } else {
            int i10 = this.f3367a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.f3363C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 - (rect3.left + rect3.right), 1073741824);
        }
        int iD = this.f3369c.d(iMakeMeasureSpec, 0, -1, iU - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i3 + this.f3369c.getPaddingTop() + this.f3369c.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    private int u(View view, int i3, boolean z3) {
        if (Build.VERSION.SDK_INT > 23) {
            return c.a(this.f3366F, view, i3, z3);
        }
        Method method = f3359H;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f3366F, view, Integer.valueOf(i3), Boolean.valueOf(z3))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f3366F.getMaxAvailableHeight(view, i3);
    }

    public boolean A() {
        return this.f3366F.getInputMethodMode() == 2;
    }

    public boolean B() {
        return this.f3365E;
    }

    public void D(View view) {
        this.f3385s = view;
    }

    public void E(int i3) {
        this.f3366F.setAnimationStyle(i3);
    }

    public void F(int i3) {
        Drawable background = this.f3366F.getBackground();
        if (background == null) {
            R(i3);
            return;
        }
        background.getPadding(this.f3363C);
        Rect rect = this.f3363C;
        this.f3371e = rect.left + rect.right + i3;
    }

    public void G(int i3) {
        this.f3378l = i3;
    }

    public void H(Rect rect) {
        this.f3364D = rect != null ? new Rect(rect) : null;
    }

    public void I(int i3) {
        this.f3366F.setInputMethodMode(i3);
    }

    public void J(boolean z3) {
        this.f3365E = z3;
        this.f3366F.setFocusable(z3);
    }

    public void K(PopupWindow.OnDismissListener onDismissListener) {
        this.f3366F.setOnDismissListener(onDismissListener);
    }

    public void L(AdapterView.OnItemClickListener onItemClickListener) {
        this.f3387u = onItemClickListener;
    }

    public void M(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f3388v = onItemSelectedListener;
    }

    public void N(boolean z3) {
        this.f3377k = true;
        this.f3376j = z3;
    }

    public void P(int i3) {
        this.f3383q = i3;
    }

    public void Q(int i3) {
        T t3 = this.f3369c;
        if (!b() || t3 == null) {
            return;
        }
        t3.setListSelectionHidden(false);
        t3.setSelection(i3);
        if (t3.getChoiceMode() != 0) {
            t3.setItemChecked(i3, true);
        }
    }

    public void R(int i3) {
        this.f3371e = i3;
    }

    public void a(int i3) {
        this.f3372f = i3;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean b() {
        return this.f3366F.isShowing();
    }

    public int c() {
        return this.f3372f;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        this.f3366F.dismiss();
        C();
        this.f3366F.setContentView(null);
        this.f3369c = null;
        this.f3362B.removeCallbacks(this.f3389w);
    }

    @Override // androidx.appcompat.view.menu.p
    public void f() {
        int iQ = q();
        boolean zA = A();
        androidx.core.widget.h.b(this.f3366F, this.f3374h);
        if (this.f3366F.isShowing()) {
            if (androidx.core.view.Z.T(t())) {
                int width = this.f3371e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = t().getWidth();
                }
                int i3 = this.f3370d;
                if (i3 == -1) {
                    if (!zA) {
                        iQ = -1;
                    }
                    if (zA) {
                        this.f3366F.setWidth(this.f3371e == -1 ? -1 : 0);
                        this.f3366F.setHeight(0);
                    } else {
                        this.f3366F.setWidth(this.f3371e == -1 ? -1 : 0);
                        this.f3366F.setHeight(-1);
                    }
                } else if (i3 != -2) {
                    iQ = i3;
                }
                this.f3366F.setOutsideTouchable((this.f3380n || this.f3379m) ? false : true);
                this.f3366F.update(t(), this.f3372f, this.f3373g, width < 0 ? -1 : width, iQ < 0 ? -1 : iQ);
                return;
            }
            return;
        }
        int width2 = this.f3371e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = t().getWidth();
        }
        int i4 = this.f3370d;
        if (i4 == -1) {
            iQ = -1;
        } else if (i4 != -2) {
            iQ = i4;
        }
        this.f3366F.setWidth(width2);
        this.f3366F.setHeight(iQ);
        O(true);
        this.f3366F.setOutsideTouchable((this.f3380n || this.f3379m) ? false : true);
        this.f3366F.setTouchInterceptor(this.f3390x);
        if (this.f3377k) {
            androidx.core.widget.h.a(this.f3366F, this.f3376j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f3360I;
            if (method != null) {
                try {
                    method.invoke(this.f3366F, this.f3364D);
                } catch (Exception e3) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e3);
                }
            }
        } else {
            d.a(this.f3366F, this.f3364D);
        }
        androidx.core.widget.h.c(this.f3366F, t(), this.f3372f, this.f3373g, this.f3378l);
        this.f3369c.setSelection(-1);
        if (!this.f3365E || this.f3369c.isInTouchMode()) {
            r();
        }
        if (this.f3365E) {
            return;
        }
        this.f3362B.post(this.f3392z);
    }

    public int g() {
        if (this.f3375i) {
            return this.f3373g;
        }
        return 0;
    }

    public Drawable i() {
        return this.f3366F.getBackground();
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView k() {
        return this.f3369c;
    }

    public void m(Drawable drawable) {
        this.f3366F.setBackgroundDrawable(drawable);
    }

    public void n(int i3) {
        this.f3373g = i3;
        this.f3375i = true;
    }

    public void o(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f3384r;
        if (dataSetObserver == null) {
            this.f3384r = new f();
        } else {
            ListAdapter listAdapter2 = this.f3368b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f3368b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f3384r);
        }
        T t3 = this.f3369c;
        if (t3 != null) {
            t3.setAdapter(this.f3368b);
        }
    }

    public void r() {
        T t3 = this.f3369c;
        if (t3 != null) {
            t3.setListSelectionHidden(true);
            t3.requestLayout();
        }
    }

    T s(Context context, boolean z3) {
        return new T(context, z3);
    }

    public View t() {
        return this.f3385s;
    }

    public Object v() {
        if (b()) {
            return this.f3369c.getSelectedItem();
        }
        return null;
    }

    public long w() {
        if (b()) {
            return this.f3369c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int x() {
        if (b()) {
            return this.f3369c.getSelectedItemPosition();
        }
        return -1;
    }

    public View y() {
        if (b()) {
            return this.f3369c.getSelectedView();
        }
        return null;
    }

    public int z() {
        return this.f3371e;
    }

    public X(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public X(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.f3370d = -2;
        this.f3371e = -2;
        this.f3374h = 1002;
        this.f3378l = 0;
        this.f3379m = false;
        this.f3380n = false;
        this.f3381o = Integer.MAX_VALUE;
        this.f3383q = 0;
        this.f3389w = new i();
        this.f3390x = new h();
        this.f3391y = new g();
        this.f3392z = new e();
        this.f3363C = new Rect();
        this.f3367a = context;
        this.f3362B = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p012d.j.f9420t1, i3, i4);
        this.f3372f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(p012d.j.f9424u1, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(p012d.j.f9428v1, 0);
        this.f3373g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f3375i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        C0275t c0275t = new C0275t(context, attributeSet, i3, i4);
        this.f3366F = c0275t;
        c0275t.setInputMethodMode(1);
    }
}
