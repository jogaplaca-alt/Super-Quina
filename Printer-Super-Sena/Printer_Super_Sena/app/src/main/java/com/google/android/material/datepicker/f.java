package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
abstract class f {
    static String a(Context context, long j3, boolean z3, boolean z4, boolean z5) {
        String strD = d(j3);
        if (z3) {
            strD = String.format(context.getString(S0.i.f1709v), strD);
        }
        if (z4) {
            return String.format(context.getString(S0.i.f1708u), strD);
        }
        return z5 ? String.format(context.getString(S0.i.f1705r), strD) : strD;
    }

    static String b(long j3) {
        return c(j3, Locale.getDefault());
    }

    static String c(long j3, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? z.f(locale).format(new Date(j3)) : z.e(locale).format(new Date(j3));
    }

    static String d(long j3) {
        return i(j3) ? b(j3) : g(j3);
    }

    static String e(Context context, int i3) {
        return z.i().get(1) == i3 ? String.format(context.getString(S0.i.f1706s), Integer.valueOf(i3)) : String.format(context.getString(S0.i.f1707t), Integer.valueOf(i3));
    }

    static String f(long j3) {
        return Build.VERSION.SDK_INT >= 24 ? z.m(Locale.getDefault()).format(new Date(j3)) : DateUtils.formatDateTime(null, j3, 8228);
    }

    static String g(long j3) {
        return h(j3, Locale.getDefault());
    }

    static String h(long j3, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? z.n(locale).format(new Date(j3)) : z.e(locale).format(new Date(j3));
    }

    private static boolean i(long j3) {
        Calendar calendarI = z.i();
        Calendar calendarK = z.k();
        calendarK.setTimeInMillis(j3);
        return calendarI.get(1) == calendarK.get(1);
    }
}
