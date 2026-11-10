package com.google.android.material.internal;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: renamed from: com.google.android.material.internal.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0495i {
    private static String a() {
        String str = Build.MANUFACTURER;
        return str != null ? str.toLowerCase(Locale.ENGLISH) : "";
    }

    public static boolean b() {
        return a().equals("meizu");
    }
}
