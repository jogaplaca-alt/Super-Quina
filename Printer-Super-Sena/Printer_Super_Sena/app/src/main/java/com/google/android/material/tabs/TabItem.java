package com.google.android.material.tabs;

import S0.k;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.j0;

/* JADX INFO: loaded from: classes.dex */
public class TabItem extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f8453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f8454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8455c;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j0 j0VarU = j0.u(context, attributeSet, k.q6);
        this.f8453a = j0VarU.p(k.t6);
        this.f8454b = j0VarU.g(k.r6);
        this.f8455c = j0VarU.n(k.s6, 0);
        j0VarU.w();
    }
}
