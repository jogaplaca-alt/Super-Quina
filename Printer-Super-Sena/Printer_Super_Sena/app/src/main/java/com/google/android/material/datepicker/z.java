package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static AtomicReference f8154a = new AtomicReference();

    static long a(long j3) {
        Calendar calendarK = k();
        calendarK.setTimeInMillis(j3);
        return c(calendarK).getTimeInMillis();
    }

    private static DateFormat b(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(j());
        instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        return instanceForSkeleton;
    }

    static Calendar c(Calendar calendar) {
        Calendar calendarL = l(calendar);
        Calendar calendarK = k();
        calendarK.set(calendarL.get(1), calendarL.get(2), calendarL.get(5));
        return calendarK;
    }

    private static java.text.DateFormat d(int i3, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i3, locale);
        dateInstance.setTimeZone(h());
        return dateInstance;
    }

    static java.text.DateFormat e(Locale locale) {
        return d(0, locale);
    }

    static DateFormat f(Locale locale) {
        return b("MMMMEEEEd", locale);
    }

    static t g() {
        t tVar = (t) f8154a.get();
        return tVar == null ? t.c() : tVar;
    }

    private static TimeZone h() {
        return TimeZone.getTimeZone("UTC");
    }

    static Calendar i() {
        Calendar calendarA = g().a();
        calendarA.set(11, 0);
        calendarA.set(12, 0);
        calendarA.set(13, 0);
        calendarA.set(14, 0);
        calendarA.setTimeZone(h());
        return calendarA;
    }

    private static android.icu.util.TimeZone j() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    static Calendar k() {
        return l(null);
    }

    static Calendar l(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(h());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    static DateFormat m(Locale locale) {
        return b("yMMMM", locale);
    }

    static DateFormat n(Locale locale) {
        return b("yMMMMEEEEd", locale);
    }
}
