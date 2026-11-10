package com.android.billingclient.api;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7165a = false;

    static synchronized boolean a(Context context) {
        if (f7165a) {
            return false;
        }
        f7165a = true;
        return false;
    }
}
