package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f8817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f8818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f8819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f8820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f8821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f8822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f8823g;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i3) {
            return new f[i3];
        }
    }

    public f(int i3, int i4, int i5, int i6) {
        this.f8820d = i3;
        this.f8821e = i4;
        this.f8822f = i5;
        this.f8819c = i6;
        this.f8823g = e(i3);
        this.f8817a = new c(59);
        this.f8818b = new c(i6 == 1 ? 23 : 12);
    }

    public static String c(Resources resources, CharSequence charSequence) {
        return d(resources, charSequence, "%02d");
    }

    public static String d(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static int e(int i3) {
        return i3 >= 12 ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f8820d == fVar.f8820d && this.f8821e == fVar.f8821e && this.f8819c == fVar.f8819c && this.f8822f == fVar.f8822f;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8819c), Integer.valueOf(this.f8820d), Integer.valueOf(this.f8821e), Integer.valueOf(this.f8822f)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f8820d);
        parcel.writeInt(this.f8821e);
        parcel.writeInt(this.f8822f);
        parcel.writeInt(this.f8819c);
    }

    protected f(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
