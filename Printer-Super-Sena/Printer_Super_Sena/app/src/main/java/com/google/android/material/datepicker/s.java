package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
abstract class s extends LinearLayoutManager {

    class a extends androidx.recyclerview.widget.h {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.h
        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    s(Context context, int i3, boolean z3) {
        super(context, i3, z3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void M1(RecyclerView recyclerView, RecyclerView.A a3, int i3) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i3);
        N1(aVar);
    }
}
