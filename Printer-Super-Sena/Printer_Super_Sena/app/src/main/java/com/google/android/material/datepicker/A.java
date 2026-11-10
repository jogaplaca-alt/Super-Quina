package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class A extends RecyclerView.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f8014c;

    public static class a extends RecyclerView.D {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final TextView f8015t;

        a(TextView textView) {
            super(textView);
            this.f8015t = textView;
        }
    }

    A(j jVar) {
        this.f8014c = jVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f8014c.Z1().n();
    }

    int w(int i3) {
        return i3 - this.f8014c.Z1().m().f8131c;
    }

    int x(int i3) {
        return this.f8014c.Z1().m().f8131c + i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void l(a aVar, int i3) {
        int iX = x(i3);
        aVar.f8015t.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(iX)));
        TextView textView = aVar.f8015t;
        textView.setContentDescription(f.e(textView.getContext(), iX));
        c cVarA2 = this.f8014c.a2();
        if (z.i().get(1) == iX) {
            b bVar = cVarA2.f8044f;
        } else {
            b bVar2 = cVarA2.f8042d;
        }
        this.f8014c.c2();
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public a n(ViewGroup viewGroup, int i3) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(S0.g.f1682w, viewGroup, false));
    }
}
