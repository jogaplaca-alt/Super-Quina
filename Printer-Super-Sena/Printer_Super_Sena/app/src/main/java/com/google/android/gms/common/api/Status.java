package com.google.android.gms.common.api;

import C0.C0179a;
import D0.c;
import F0.AbstractC0219m;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Status extends G0.a implements ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PendingIntent f7218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C0179a f7219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Status f7208e = new Status(-1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Status f7209f = new Status(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Status f7210g = new Status(14);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Status f7211h = new Status(8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Status f7212i = new Status(15);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Status f7213j = new Status(16);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Status f7215l = new Status(17);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Status f7214k = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new b();

    Status(int i3, String str, PendingIntent pendingIntent, C0179a c0179a) {
        this.f7216a = i3;
        this.f7217b = str;
        this.f7218c = pendingIntent;
        this.f7219d = c0179a;
    }

    public C0179a c() {
        return this.f7219d;
    }

    public int d() {
        return this.f7216a;
    }

    public String e() {
        return this.f7217b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f7216a == status.f7216a && AbstractC0219m.a(this.f7217b, status.f7217b) && AbstractC0219m.a(this.f7218c, status.f7218c) && AbstractC0219m.a(this.f7219d, status.f7219d);
    }

    public boolean f() {
        return this.f7218c != null;
    }

    public final String g() {
        String str = this.f7217b;
        return str != null ? str : c.a(this.f7216a);
    }

    public int hashCode() {
        return AbstractC0219m.b(Integer.valueOf(this.f7216a), this.f7217b, this.f7218c, this.f7219d);
    }

    public String toString() {
        AbstractC0219m.a aVarC = AbstractC0219m.c(this);
        aVarC.a("statusCode", g());
        aVarC.a("resolution", this.f7218c);
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = G0.c.a(parcel);
        G0.c.f(parcel, 1, d());
        G0.c.j(parcel, 2, e(), false);
        G0.c.i(parcel, 3, this.f7218c, i3, false);
        G0.c.i(parcel, 4, c(), i3, false);
        G0.c.b(parcel, iA);
    }

    public Status(int i3) {
        this(i3, (String) null);
    }

    public Status(C0179a c0179a, String str) {
        this(c0179a, str, 17);
    }

    public Status(int i3, String str) {
        this(i3, str, (PendingIntent) null);
    }

    public Status(C0179a c0179a, String str, int i3) {
        this(i3, str, c0179a.e(), c0179a);
    }

    public Status(int i3, String str, PendingIntent pendingIntent) {
        this(i3, str, pendingIntent, null);
    }
}
