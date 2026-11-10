package com.google.android.material.drawable;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class j extends p020f.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f8156c;

    public j(Drawable drawable, int i3, int i4) {
        super(drawable);
        this.f8155b = i3;
        this.f8156c = i4;
    }

    @Override // p020f.c, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f8156c;
    }

    @Override // p020f.c, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f8155b;
    }
}
