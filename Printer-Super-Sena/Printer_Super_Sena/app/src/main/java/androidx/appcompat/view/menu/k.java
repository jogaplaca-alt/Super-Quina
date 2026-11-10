package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class k implements p, m, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Rect f2910a;

    k() {
    }

    protected static boolean A(g gVar) {
        int size = gVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = gVar.getItem(i3);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    protected static f B(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (f) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (f) listAdapter;
    }

    protected static int r(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        View view = null;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < count; i6++) {
            int itemViewType = listAdapter.getItemViewType(i6);
            if (itemViewType != i5) {
                view = null;
                i5 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i6, view, viewGroup);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i3) {
                return i3;
            }
            if (measuredWidth > i4) {
                i4 = measuredWidth;
            }
        }
        return i4;
    }

    @Override // androidx.appcompat.view.menu.m
    public int c() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.m
    public void g(Context context, g gVar) {
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean i(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean j(g gVar, i iVar) {
        return false;
    }

    public abstract void o(g gVar);

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        B(listAdapter).f2830a.O((MenuItem) listAdapter.getItem(i3), this, p() ? 0 : 4);
    }

    protected boolean p() {
        return true;
    }

    public Rect q() {
        return this.f2910a;
    }

    public abstract void s(View view);

    public void t(Rect rect) {
        this.f2910a = rect;
    }

    public abstract void u(boolean z3);

    public abstract void v(int i3);

    public abstract void w(int i3);

    public abstract void x(PopupWindow.OnDismissListener onDismissListener);

    public abstract void y(boolean z3);

    public abstract void z(int i3);
}
