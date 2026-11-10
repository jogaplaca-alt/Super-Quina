package androidx.activity;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {
    public static final void a(View view, t tVar) {
        S1.k.e(view, "<this>");
        S1.k.e(tVar, "onBackPressedDispatcherOwner");
        view.setTag(u.f2298b, tVar);
    }
}
