package com.google.android.material.datepicker;

import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
abstract class r extends AbstractComponentCallbacksC0337e {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    protected final LinkedHashSet f8149b0 = new LinkedHashSet();

    r() {
    }

    boolean Q1(q qVar) {
        return this.f8149b0.add(qVar);
    }

    void R1() {
        this.f8149b0.clear();
    }
}
