package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.H;

/* JADX INFO: loaded from: classes.dex */
public final class m<S> extends r {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private int f8126c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private C0486a f8127d0;

    class a extends q {
        a() {
        }
    }

    static m S1(d dVar, int i3, C0486a c0486a) {
        m mVar = new m();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i3);
        bundle.putParcelable("DATE_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", c0486a);
        mVar.A1(bundle);
        return mVar;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void L0(Bundle bundle) {
        super.L0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f8126c0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f8127d0);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void p0(Bundle bundle) {
        super.p0(bundle);
        if (bundle == null) {
            bundle = r();
        }
        this.f8126c0 = bundle.getInt("THEME_RES_ID_KEY");
        H.a(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.f8127d0 = (C0486a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.cloneInContext(new ContextThemeWrapper(t(), this.f8126c0));
        new a();
        throw null;
    }
}
