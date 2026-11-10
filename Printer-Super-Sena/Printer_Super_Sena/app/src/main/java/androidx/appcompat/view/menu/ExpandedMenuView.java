package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.j0;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements g.b, n, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f2728c = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f2729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2730b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean a(i iVar) {
        return this.f2729a.N(iVar, 0);
    }

    @Override // androidx.appcompat.view.menu.n
    public void b(g gVar) {
        this.f2729a = gVar;
    }

    public int getWindowAnimations() {
        return this.f2730b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
        a((i) getAdapter().getItem(i3));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        j0 j0VarV = j0.v(context, attributeSet, f2728c, i3, 0);
        if (j0VarV.s(0)) {
            setBackgroundDrawable(j0VarV.g(0));
        }
        if (j0VarV.s(1)) {
            setDivider(j0VarV.g(1));
        }
        j0VarV.w();
    }
}
