package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
final class n implements Comparable, Parcelable {
    public static final Parcelable.Creator<n> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Calendar f8129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f8130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f8131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f8132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f8133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final long f8134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f8135g;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n createFromParcel(Parcel parcel) {
            return n.d(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public n[] newArray(int i3) {
            return new n[i3];
        }
    }

    private n(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarC = z.c(calendar);
        this.f8129a = calendarC;
        this.f8130b = calendarC.get(2);
        this.f8131c = calendarC.get(1);
        this.f8132d = calendarC.getMaximum(7);
        this.f8133e = calendarC.getActualMaximum(5);
        this.f8134f = calendarC.getTimeInMillis();
    }

    static n d(int i3, int i4) {
        Calendar calendarK = z.k();
        calendarK.set(1, i3);
        calendarK.set(2, i4);
        return new n(calendarK);
    }

    static n e(long j3) {
        Calendar calendarK = z.k();
        calendarK.setTimeInMillis(j3);
        return new n(calendarK);
    }

    static n f() {
        return new n(z.i());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(n nVar) {
        return this.f8129a.compareTo(nVar.f8129a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f8130b == nVar.f8130b && this.f8131c == nVar.f8131c;
    }

    int g(int i3) {
        int i4 = this.f8129a.get(7);
        if (i3 <= 0) {
            i3 = this.f8129a.getFirstDayOfWeek();
        }
        int i5 = i4 - i3;
        return i5 < 0 ? i5 + this.f8132d : i5;
    }

    long h(int i3) {
        Calendar calendarC = z.c(this.f8129a);
        calendarC.set(5, i3);
        return calendarC.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8130b), Integer.valueOf(this.f8131c)});
    }

    int i(long j3) {
        Calendar calendarC = z.c(this.f8129a);
        calendarC.setTimeInMillis(j3);
        return calendarC.get(5);
    }

    String j() {
        if (this.f8135g == null) {
            this.f8135g = f.f(this.f8129a.getTimeInMillis());
        }
        return this.f8135g;
    }

    long k() {
        return this.f8129a.getTimeInMillis();
    }

    n l(int i3) {
        Calendar calendarC = z.c(this.f8129a);
        calendarC.add(2, i3);
        return new n(calendarC);
    }

    int m(n nVar) {
        if (this.f8129a instanceof GregorianCalendar) {
            return ((nVar.f8131c - this.f8131c) * 12) + (nVar.f8130b - this.f8130b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f8131c);
        parcel.writeInt(this.f8130b);
    }
}
