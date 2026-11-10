package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final t f8151c = new t(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Long f8152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeZone f8153b;

    private t(Long l3, TimeZone timeZone) {
        this.f8152a = l3;
        this.f8153b = timeZone;
    }

    static t c() {
        return f8151c;
    }

    Calendar a() {
        return b(this.f8153b);
    }

    Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l3 = this.f8152a;
        if (l3 != null) {
            calendar.setTimeInMillis(l3.longValue());
        }
        return calendar;
    }
}
