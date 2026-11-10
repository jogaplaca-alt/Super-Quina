package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class o extends BaseAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f8136e = z.k().getMaximum(4);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f8137f = (z.k().getMaximum(5) + z.k().getMaximum(7)) - 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final n f8138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Collection f8139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    c f8140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final C0486a f8141d;

    o(n nVar, d dVar, C0486a c0486a, h hVar) {
        this.f8138a = nVar;
        this.f8141d = c0486a;
        this.f8139b = dVar.b();
    }

    private String c(Context context, long j3) {
        return f.a(context, j3, j(j3), i(j3), g(j3));
    }

    private void f(Context context) {
        if (this.f8140c == null) {
            this.f8140c = new c(context);
        }
    }

    private boolean h(long j3) {
        throw null;
    }

    private boolean j(long j3) {
        return z.i().getTimeInMillis() == j3;
    }

    private void m(TextView textView, long j3, int i3) {
        b bVar;
        if (textView == null) {
            return;
        }
        textView.setContentDescription(c(textView.getContext(), j3));
        if (this.f8141d.h().a(j3)) {
            textView.setEnabled(true);
            boolean zH = h(j3);
            textView.setSelected(zH);
            if (zH) {
                bVar = this.f8140c.f8040b;
            } else {
                bVar = j(j3) ? this.f8140c.f8041c : this.f8140c.f8039a;
            }
        } else {
            textView.setEnabled(false);
            bVar = this.f8140c.f8045g;
        }
        bVar.b(textView);
    }

    private void n(MaterialCalendarGridView materialCalendarGridView, long j3) {
        if (n.e(j3).equals(this.f8138a)) {
            int i3 = this.f8138a.i(j3);
            m((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(i3) - materialCalendarGridView.getFirstVisiblePosition()), j3, i3);
        }
    }

    int a(int i3) {
        return b() + (i3 - 1);
    }

    int b() {
        return this.f8138a.g(this.f8141d.j());
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i3) {
        if (i3 < b() || i3 > k()) {
            return null;
        }
        return Long.valueOf(this.f8138a.h(l(i3)));
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0054  */
    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public TextView getView(int i3, View view, ViewGroup viewGroup) {
        int i4;
        f(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(S0.g.f1677r, viewGroup, false);
        }
        int iB = i3 - b();
        if (iB >= 0) {
            n nVar = this.f8138a;
            if (iB >= nVar.f8133e) {
                textView.setVisibility(8);
                textView.setEnabled(false);
                i4 = -1;
            } else {
                i4 = iB + 1;
                textView.setTag(nVar);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i4)));
                textView.setVisibility(0);
                textView.setEnabled(true);
            }
        } else {
            textView.setVisibility(8);
            textView.setEnabled(false);
            i4 = -1;
        }
        Long item = getItem(i3);
        if (item == null) {
            return textView;
        }
        m(textView, item.longValue(), i4);
        return textView;
    }

    boolean g(long j3) {
        throw null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return f8137f;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3 / this.f8138a.f8132d;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    boolean i(long j3) {
        throw null;
    }

    int k() {
        return (b() + this.f8138a.f8133e) - 1;
    }

    int l(int i3) {
        return (i3 - b()) + 1;
    }

    public void o(MaterialCalendarGridView materialCalendarGridView) {
        Iterator it = this.f8139b.iterator();
        while (it.hasNext()) {
            n(materialCalendarGridView, ((Long) it.next()).longValue());
        }
    }

    boolean p(int i3) {
        return i3 >= b() && i3 <= k();
    }
}
