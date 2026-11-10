package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    g f2830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2831b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f2833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LayoutInflater f2834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f2835f;

    public f(g gVar, LayoutInflater layoutInflater, boolean z3, int i3) {
        this.f2833d = z3;
        this.f2834e = layoutInflater;
        this.f2830a = gVar;
        this.f2835f = i3;
        a();
    }

    void a() {
        i iVarX = this.f2830a.x();
        if (iVarX != null) {
            ArrayList arrayListB = this.f2830a.B();
            int size = arrayListB.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((i) arrayListB.get(i3)) == iVarX) {
                    this.f2831b = i3;
                    return;
                }
            }
        }
        this.f2831b = -1;
    }

    public g b() {
        return this.f2830a;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public i getItem(int i3) {
        ArrayList arrayListB = this.f2833d ? this.f2830a.B() : this.f2830a.G();
        int i4 = this.f2831b;
        if (i4 >= 0 && i3 >= i4) {
            i3++;
        }
        return (i) arrayListB.get(i3);
    }

    public void d(boolean z3) {
        this.f2832c = z3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList arrayListB = this.f2833d ? this.f2830a.B() : this.f2830a.G();
        return this.f2831b < 0 ? arrayListB.size() : arrayListB.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f2834e.inflate(this.f2835f, viewGroup, false);
        }
        int groupId = getItem(i3).getGroupId();
        int i4 = i3 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f2830a.H() && groupId != (i4 >= 0 ? getItem(i4).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.f2832c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i3), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
