package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class Z extends X implements Y {

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private static Method f3400K;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private Y f3401J;

    static class a {
        static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    static class b {
        static void a(PopupWindow popupWindow, boolean z3) {
            popupWindow.setTouchModal(z3);
        }
    }

    public static class c extends T {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final int f3402n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final int f3403o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private Y f3404p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private MenuItem f3405q;

        static class a {
            static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public c(Context context, boolean z3) {
            super(context, z3);
            if (1 == a.a(context.getResources().getConfiguration())) {
                this.f3402n = 21;
                this.f3403o = 22;
            } else {
                this.f3402n = 22;
                this.f3403o = 21;
            }
        }

        @Override // androidx.appcompat.widget.T
        public /* bridge */ /* synthetic */ int d(int i3, int i4, int i5, int i6, int i7) {
            return super.d(i3, i4, i5, i6, i7);
        }

        @Override // androidx.appcompat.widget.T
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i3) {
            return super.e(motionEvent, i3);
        }

        @Override // androidx.appcompat.widget.T, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.T, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.T, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.T, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.T, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            androidx.appcompat.view.menu.f fVar;
            int headersCount;
            int iPointToPosition;
            int i3;
            if (this.f3404p != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    fVar = (androidx.appcompat.view.menu.f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    fVar = (androidx.appcompat.view.menu.f) adapter;
                    headersCount = 0;
                }
                androidx.appcompat.view.menu.i item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i3 = iPointToPosition - headersCount) < 0 || i3 >= fVar.getCount()) ? null : fVar.getItem(i3);
                MenuItem menuItem = this.f3405q;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.g gVarB = fVar.b();
                    if (menuItem != null) {
                        this.f3404p.h(gVarB, menuItem);
                    }
                    this.f3405q = item;
                    if (item != null) {
                        this.f3404p.e(gVarB, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i3, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i3 == this.f3402n) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i3 != this.f3403o) {
                return super.onKeyDown(i3, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (androidx.appcompat.view.menu.f) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (androidx.appcompat.view.menu.f) adapter).b().e(false);
            return true;
        }

        @Override // androidx.appcompat.widget.T, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(Y y3) {
            this.f3404p = y3;
        }

        @Override // androidx.appcompat.widget.T, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f3400K = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public Z(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
    }

    public void S(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.a(this.f3366F, (Transition) obj);
        }
    }

    public void T(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.b(this.f3366F, (Transition) obj);
        }
    }

    public void U(Y y3) {
        this.f3401J = y3;
    }

    public void V(boolean z3) {
        if (Build.VERSION.SDK_INT > 28) {
            b.a(this.f3366F, z3);
            return;
        }
        Method method = f3400K;
        if (method != null) {
            try {
                method.invoke(this.f3366F, Boolean.valueOf(z3));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // androidx.appcompat.widget.Y
    public void e(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        Y y3 = this.f3401J;
        if (y3 != null) {
            y3.e(gVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.Y
    public void h(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        Y y3 = this.f3401J;
        if (y3 != null) {
            y3.h(gVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.X
    T s(Context context, boolean z3) {
        c cVar = new c(context, z3);
        cVar.setHoverListener(this);
        return cVar;
    }
}
