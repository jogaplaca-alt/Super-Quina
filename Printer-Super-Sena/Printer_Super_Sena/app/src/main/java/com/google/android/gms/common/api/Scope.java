package com.google.android.gms.common.api;

import F0.AbstractC0220n;
import G0.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Scope extends G0.a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f7206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7207b;

    Scope(int i3, String str) {
        AbstractC0220n.e(str, "scopeUri must not be null or empty");
        this.f7206a = i3;
        this.f7207b = str;
    }

    public String c() {
        return this.f7207b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f7207b.equals(((Scope) obj).f7207b);
        }
        return false;
    }

    public int hashCode() {
        return this.f7207b.hashCode();
    }

    public String toString() {
        return this.f7207b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f7206a;
        int iA = c.a(parcel);
        c.f(parcel, 1, i4);
        c.j(parcel, 2, c(), false);
        c.b(parcel, iA);
    }

    public Scope(String str) {
        this(1, str);
    }
}
