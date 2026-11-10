package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
public class k extends androidx.appcompat.view.menu.g {
    public k(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.g, android.view.Menu
    public SubMenu addSubMenu(int i3, int i4, int i5, CharSequence charSequence) {
        androidx.appcompat.view.menu.i iVar = (androidx.appcompat.view.menu.i) a(i3, i4, i5, charSequence);
        n nVar = new n(w(), this, iVar);
        iVar.x(nVar);
        return nVar;
    }
}
