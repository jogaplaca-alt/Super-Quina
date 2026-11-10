package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: com.google.android.material.datepicker.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0486a implements Parcelable {
    public static final Parcelable.Creator<C0486a> CREATOR = new C0104a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f8019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f8020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f8021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private n f8022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f8023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f8024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f8025g;

    /* JADX INFO: renamed from: com.google.android.material.datepicker.a$a, reason: collision with other inner class name */
    class C0104a implements Parcelable.Creator {
        C0104a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0486a createFromParcel(Parcel parcel) {
            return new C0486a((n) parcel.readParcelable(n.class.getClassLoader()), (n) parcel.readParcelable(n.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (n) parcel.readParcelable(n.class.getClassLoader()), parcel.readInt(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0486a[] newArray(int i3) {
            return new C0486a[i3];
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.a$b */
    public static final class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final long f8026f = z.a(n.d(1900, 0).f8134f);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final long f8027g = z.a(n.d(2100, 11).f8134f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f8028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f8029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f8030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f8031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private c f8032e;

        b(C0486a c0486a) {
            this.f8028a = f8026f;
            this.f8029b = f8027g;
            this.f8032e = g.c(Long.MIN_VALUE);
            this.f8028a = c0486a.f8019a.f8134f;
            this.f8029b = c0486a.f8020b.f8134f;
            this.f8030c = Long.valueOf(c0486a.f8022d.f8134f);
            this.f8031d = c0486a.f8023e;
            this.f8032e = c0486a.f8021c;
        }

        public C0486a a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f8032e);
            n nVarE = n.e(this.f8028a);
            n nVarE2 = n.e(this.f8029b);
            c cVar = (c) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l3 = this.f8030c;
            return new C0486a(nVarE, nVarE2, cVar, l3 == null ? null : n.e(l3.longValue()), this.f8031d, null);
        }

        public b b(long j3) {
            this.f8030c = Long.valueOf(j3);
            return this;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.a$c */
    public interface c extends Parcelable {
        boolean a(long j3);
    }

    /* synthetic */ C0486a(n nVar, n nVar2, c cVar, n nVar3, int i3, C0104a c0104a) {
        this(nVar, nVar2, cVar, nVar3, i3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0486a)) {
            return false;
        }
        C0486a c0486a = (C0486a) obj;
        return this.f8019a.equals(c0486a.f8019a) && this.f8020b.equals(c0486a.f8020b) && p082z.c.a(this.f8022d, c0486a.f8022d) && this.f8023e == c0486a.f8023e && this.f8021c.equals(c0486a.f8021c);
    }

    public c h() {
        return this.f8021c;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8019a, this.f8020b, this.f8022d, Integer.valueOf(this.f8023e), this.f8021c});
    }

    n i() {
        return this.f8020b;
    }

    int j() {
        return this.f8023e;
    }

    int k() {
        return this.f8025g;
    }

    n l() {
        return this.f8022d;
    }

    n m() {
        return this.f8019a;
    }

    int n() {
        return this.f8024f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f8019a, 0);
        parcel.writeParcelable(this.f8020b, 0);
        parcel.writeParcelable(this.f8022d, 0);
        parcel.writeParcelable(this.f8021c, 0);
        parcel.writeInt(this.f8023e);
    }

    private C0486a(n nVar, n nVar2, c cVar, n nVar3, int i3) {
        Objects.requireNonNull(nVar, "start cannot be null");
        Objects.requireNonNull(nVar2, "end cannot be null");
        Objects.requireNonNull(cVar, "validator cannot be null");
        this.f8019a = nVar;
        this.f8020b = nVar2;
        this.f8022d = nVar3;
        this.f8023e = i3;
        this.f8021c = cVar;
        if (nVar3 != null && nVar.compareTo(nVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (nVar3 != null && nVar3.compareTo(nVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i3 < 0 || i3 > z.k().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.f8025g = nVar.m(nVar2) + 1;
        this.f8024f = (nVar2.f8131c - nVar.f8131c) + 1;
    }
}
