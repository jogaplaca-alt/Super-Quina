package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.C0297h0;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class T extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f3252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f3258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3260i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private C0297h0 f3262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private androidx.core.widget.f f3263l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    f f3264m;

    static class a {
        static void a(View view, float f3, float f4) {
            view.drawableHotspotChanged(f3, f4);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Method f3265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Method f3266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static Method f3267c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static boolean f3268d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
                f3265a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f3266b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f3267c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f3268d = true;
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            }
        }

        static boolean a() {
            return f3268d;
        }

        static void b(T t3, int i3, View view) {
            try {
                f3265a.invoke(t3, Integer.valueOf(i3), view, Boolean.FALSE, -1, -1);
                f3266b.invoke(t3, Integer.valueOf(i3));
                f3267c.invoke(t3, Integer.valueOf(i3));
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
    }

    static class c {
        static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        static void b(AbsListView absListView, boolean z3) {
            absListView.setSelectedChildViewEnabled(z3);
        }
    }

    private static class d extends p020f.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3269b;

        d(Drawable drawable) {
            super(drawable);
            this.f3269b = true;
        }

        void b(boolean z3) {
            this.f3269b = z3;
        }

        @Override // p020f.c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f3269b) {
                super.draw(canvas);
            }
        }

        @Override // p020f.c, android.graphics.drawable.Drawable
        public void setHotspot(float f3, float f4) {
            if (this.f3269b) {
                super.setHotspot(f3, f4);
            }
        }

        @Override // p020f.c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i3, int i4, int i5, int i6) {
            if (this.f3269b) {
                super.setHotspotBounds(i3, i4, i5, i6);
            }
        }

        @Override // p020f.c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f3269b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // p020f.c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z3, boolean z4) {
            if (this.f3269b) {
                return super.setVisible(z3, z4);
            }
            return false;
        }
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Field f3270a;

        static {
            Field declaredField = null;
            try {
                declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            }
            f3270a = declaredField;
        }

        static boolean a(AbsListView absListView) {
            Field field = f3270a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return false;
            }
        }

        static void b(AbsListView absListView, boolean z3) {
            Field field = f3270a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z3));
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private class f implements Runnable {
        f() {
        }

        public void a() {
            T t3 = T.this;
            t3.f3264m = null;
            t3.removeCallbacks(this);
        }

        public void b() {
            T.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            T t3 = T.this;
            t3.f3264m = null;
            t3.drawableStateChanged();
        }
    }

    T(Context context, boolean z3) {
        super(context, null, p012d.a.f9108z);
        this.f3252a = new Rect();
        this.f3253b = 0;
        this.f3254c = 0;
        this.f3255d = 0;
        this.f3256e = 0;
        this.f3260i = z3;
        setCacheColorHint(0);
    }

    private void a() {
        this.f3261j = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f3257f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        C0297h0 c0297h0 = this.f3262k;
        if (c0297h0 != null) {
            c0297h0.c();
            this.f3262k = null;
        }
    }

    private void b(View view, int i3) {
        performItemClick(view, i3, getItemIdAtPosition(i3));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (this.f3252a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f3252a);
        selector.draw(canvas);
    }

    private void f(int i3, View view) {
        Rect rect = this.f3252a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f3253b;
        rect.top -= this.f3254c;
        rect.right += this.f3255d;
        rect.bottom += this.f3256e;
        boolean zK = k();
        if (view.isEnabled() != zK) {
            l(!zK);
            if (i3 != -1) {
                refreshDrawableState();
            }
        }
    }

    private void g(int i3, View view) {
        Drawable selector = getSelector();
        boolean z3 = (selector == null || i3 == -1) ? false : true;
        if (z3) {
            selector.setVisible(false, false);
        }
        f(i3, view);
        if (z3) {
            Rect rect = this.f3252a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            androidx.core.graphics.drawable.a.k(selector, fExactCenterX, fExactCenterY);
        }
    }

    private void h(int i3, View view, float f3, float f4) {
        g(i3, view);
        Drawable selector = getSelector();
        if (selector == null || i3 == -1) {
            return;
        }
        androidx.core.graphics.drawable.a.k(selector, f3, f4);
    }

    private void i(View view, int i3, float f3, float f4) {
        View childAt;
        this.f3261j = true;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            a.a(this, f3, f4);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i5 = this.f3257f;
        if (i5 != -1 && (childAt = getChildAt(i5 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f3257f = i3;
        float left = f3 - view.getLeft();
        float top = f4 - view.getTop();
        if (i4 >= 21) {
            a.a(view, left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i3, view, f3, f4);
        j(false);
        refreshDrawableState();
    }

    private void j(boolean z3) {
        d dVar = this.f3258g;
        if (dVar != null) {
            dVar.b(z3);
        }
    }

    private boolean k() {
        return androidx.core.os.a.b() ? c.a(this) : e.a(this);
    }

    private void l(boolean z3) {
        if (androidx.core.os.a.b()) {
            c.b(this, z3);
        } else {
            e.b(this, z3);
        }
    }

    private boolean m() {
        return this.f3261j;
    }

    private void n() {
        Drawable selector = getSelector();
        if (selector != null && m() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public int d(int i3, int i4, int i5, int i6, int i7) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < count) {
            int itemViewType = adapter.getItemViewType(i8);
            if (itemViewType != i9) {
                view = null;
                i9 = itemViewType;
            }
            view = adapter.getView(i8, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i11 = layoutParams.height;
            view.measure(i3, i11 > 0 ? View.MeasureSpec.makeMeasureSpec(i11, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i8 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i6) {
                return (i7 < 0 || i8 <= i7 || i10 <= 0 || measuredHeight == i6) ? i6 : i10;
            }
            if (i7 >= 0 && i8 >= i7) {
                i10 = measuredHeight;
            }
            i8++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f3264m != null) {
            return;
        }
        super.drawableStateChanged();
        j(true);
        n();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:25:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    /* JADX WARN: Code duplicated, block: B:9:0x0011  */
    public boolean e(MotionEvent motionEvent, int i3) {
        boolean z3;
        boolean z4;
        androidx.core.widget.f fVar;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            z3 = false;
        } else {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    z4 = false;
                    z3 = true;
                } else {
                    z4 = false;
                    z3 = false;
                }
                if (z3 || z4) {
                    a();
                }
                if (z3) {
                    if (this.f3263l == null) {
                        this.f3263l = new androidx.core.widget.f(this);
                    }
                    this.f3263l.m(true);
                    this.f3263l.onTouch(this, motionEvent);
                } else {
                    fVar = this.f3263l;
                    if (fVar != null) {
                        fVar.m(false);
                    }
                }
                return z3;
            }
            z3 = true;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i3);
        if (iFindPointerIndex < 0) {
            z4 = false;
            z3 = false;
        } else {
            int x3 = (int) motionEvent.getX(iFindPointerIndex);
            int y3 = (int) motionEvent.getY(iFindPointerIndex);
            int iPointToPosition = pointToPosition(x3, y3);
            if (iPointToPosition == -1) {
                z4 = true;
            } else {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                i(childAt, iPointToPosition, x3, y3);
                if (actionMasked == 1) {
                    b(childAt, iPointToPosition);
                }
                z4 = false;
                z3 = true;
            }
        }
        if (z3) {
            a();
        } else {
            a();
        }
        if (z3) {
            if (this.f3263l == null) {
                this.f3263l = new androidx.core.widget.f(this);
            }
            this.f3263l.m(true);
            this.f3263l.onTouch(this, motionEvent);
        } else {
            fVar = this.f3263l;
            if (fVar != null) {
                fVar.m(false);
            }
        }
        return z3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f3260i || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f3260i || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f3260i || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f3260i && this.f3259h) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f3264m = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f3264m == null) {
            f fVar = new f();
            this.f3264m = fVar;
            fVar.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i3 < 30 || !b.a()) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        b.b(this, iPointToPosition, childAt);
                    }
                }
                n();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f3257f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        f fVar = this.f3264m;
        if (fVar != null) {
            fVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z3) {
        this.f3259h = z3;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar = drawable != null ? new d(drawable) : null;
        this.f3258g = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f3253b = rect.left;
        this.f3254c = rect.top;
        this.f3255d = rect.right;
        this.f3256e = rect.bottom;
    }
}
