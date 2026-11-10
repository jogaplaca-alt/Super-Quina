package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e implements m, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f2818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LayoutInflater f2819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    g f2820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ExpandedMenuView f2821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f2822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f2823f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f2824g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private m.a f2825h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    a f2826i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2827j;

    private class a extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2828a = -1;

        public a() {
            a();
        }

        void a() {
            i iVarX = e.this.f2820c.x();
            if (iVarX != null) {
                ArrayList arrayListB = e.this.f2820c.B();
                int size = arrayListB.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (((i) arrayListB.get(i3)) == iVarX) {
                        this.f2828a = i3;
                        return;
                    }
                }
            }
            this.f2828a = -1;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i getItem(int i3) {
            ArrayList arrayListB = e.this.f2820c.B();
            int i4 = i3 + e.this.f2822e;
            int i5 = this.f2828a;
            if (i5 >= 0 && i4 >= i5) {
                i4++;
            }
            return (i) arrayListB.get(i4);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = e.this.f2820c.B().size() - e.this.f2822e;
            return this.f2828a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.f2819b.inflate(eVar.f2824g, viewGroup, false);
            }
            ((n.a) view).e(getItem(i3), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(Context context, int i3) {
        this(i3, 0);
        this.f2818a = context;
        this.f2819b = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(g gVar, boolean z3) {
        m.a aVar = this.f2825h;
        if (aVar != null) {
            aVar.a(gVar, z3);
        }
    }

    public ListAdapter b() {
        if (this.f2826i == null) {
            this.f2826i = new a();
        }
        return this.f2826i;
    }

    @Override // androidx.appcompat.view.menu.m
    public int c() {
        return this.f2827j;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable e() {
        if (this.f2821d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        o(bundle);
        return bundle;
    }

    public n f(ViewGroup viewGroup) {
        if (this.f2821d == null) {
            this.f2821d = (ExpandedMenuView) this.f2819b.inflate(p012d.g.f9224g, viewGroup, false);
            if (this.f2826i == null) {
                this.f2826i = new a();
            }
            this.f2821d.setAdapter((ListAdapter) this.f2826i);
            this.f2821d.setOnItemClickListener(this);
        }
        return this.f2821d;
    }

    @Override // androidx.appcompat.view.menu.m
    public void g(Context context, g gVar) {
        if (this.f2823f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f2823f);
            this.f2818a = contextThemeWrapper;
            this.f2819b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f2818a != null) {
            this.f2818a = context;
            if (this.f2819b == null) {
                this.f2819b = LayoutInflater.from(context);
            }
        }
        this.f2820c = gVar;
        a aVar = this.f2826i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void h(Parcelable parcelable) {
        k((Bundle) parcelable);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean i(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean j(g gVar, i iVar) {
        return false;
    }

    public void k(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f2821d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void l(m.a aVar) {
        this.f2825h = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean m(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        new h(rVar).d(null);
        m.a aVar = this.f2825h;
        if (aVar == null) {
            return true;
        }
        aVar.b(rVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public void n(boolean z3) {
        a aVar = this.f2826i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void o(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f2821d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
        this.f2820c.O(this.f2826i.getItem(i3), this, 0);
    }

    public e(int i3, int i4) {
        this.f2824g = i3;
        this.f2823f = i4;
    }
}
