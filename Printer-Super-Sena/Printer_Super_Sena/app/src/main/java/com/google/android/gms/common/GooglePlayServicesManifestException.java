package com.google.android.gms.common;

/* JADX INFO: loaded from: classes.dex */
public abstract class GooglePlayServicesManifestException extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7204a;

    public GooglePlayServicesManifestException(int i3, String str) {
        super(str);
        this.f7204a = i3;
    }
}
