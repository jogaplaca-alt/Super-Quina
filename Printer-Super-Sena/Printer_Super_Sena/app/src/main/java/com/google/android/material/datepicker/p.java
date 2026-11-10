package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.Z;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
class p extends RecyclerView.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C0486a f8142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j.m f8143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f8144e;

    class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f8145a;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f8145a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            if (this.f8145a.getAdapter().p(i3)) {
                p.this.f8143d.a(this.f8145a.getAdapter().getItem(i3).longValue());
            }
        }
    }

    public static class b extends RecyclerView.D {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final TextView f8147t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final MaterialCalendarGridView f8148u;

        b(LinearLayout linearLayout, boolean z3) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(S0.e.f1652u);
            this.f8147t = textView;
            Z.r0(textView, true);
            this.f8148u = (MaterialCalendarGridView) linearLayout.findViewById(S0.e.f1648q);
            if (z3) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    p(Context context, d dVar, C0486a c0486a, h hVar, j.m mVar) {
        n nVarM = c0486a.m();
        n nVarI = c0486a.i();
        n nVarL = c0486a.l();
        if (nVarM.compareTo(nVarL) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (nVarL.compareTo(nVarI) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f8144e = (o.f8136e * j.d2(context)) + (l.o2(context) ? j.d2(context) : 0);
        this.f8142c = c0486a;
        this.f8143d = mVar;
        u(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public void l(b bVar, int i3) {
        n nVarL = this.f8142c.m().l(i3);
        bVar.f8147t.setText(nVarL.j());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f8148u.findViewById(S0.e.f1648q);
        if (materialCalendarGridView.getAdapter() == null || !nVarL.equals(materialCalendarGridView.getAdapter().f8138a)) {
            o oVar = new o(nVarL, null, this.f8142c, null);
            materialCalendarGridView.setNumColumns(nVarL.f8132d);
            materialCalendarGridView.setAdapter((ListAdapter) oVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().o(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public b n(ViewGroup viewGroup, int i3) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(S0.g.f1680u, viewGroup, false);
        if (!l.o2(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.p(-1, this.f8144e));
        return new b(linearLayout, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f8142c.k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long f(int i3) {
        return this.f8142c.m().l(i3).k();
    }

    n x(int i3) {
        return this.f8142c.m().l(i3);
    }

    CharSequence y(int i3) {
        return x(i3).j();
    }

    int z(n nVar) {
        return this.f8142c.m().m(nVar);
    }
}
