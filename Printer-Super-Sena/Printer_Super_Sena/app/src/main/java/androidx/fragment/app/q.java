package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class q implements Parcelable {
    public static final Parcelable.Creator<q> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList f5349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList f5350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    C0334b[] f5351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f5352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f5353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList f5354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList f5355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ArrayList f5356h;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public q createFromParcel(Parcel parcel) {
            return new q(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public q[] newArray(int i3) {
            return new q[i3];
        }
    }

    public q() {
        this.f5353e = null;
        this.f5354f = new ArrayList();
        this.f5355g = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.f5349a);
        parcel.writeStringList(this.f5350b);
        parcel.writeTypedArray(this.f5351c, i3);
        parcel.writeInt(this.f5352d);
        parcel.writeString(this.f5353e);
        parcel.writeStringList(this.f5354f);
        parcel.writeTypedList(this.f5355g);
        parcel.writeTypedList(this.f5356h);
    }

    public q(Parcel parcel) {
        this.f5353e = null;
        this.f5354f = new ArrayList();
        this.f5355g = new ArrayList();
        this.f5349a = parcel.createTypedArrayList(t.CREATOR);
        this.f5350b = parcel.createStringArrayList();
        this.f5351c = (C0334b[]) parcel.createTypedArray(C0334b.CREATOR);
        this.f5352d = parcel.readInt();
        this.f5353e = parcel.readString();
        this.f5354f = parcel.createStringArrayList();
        this.f5355g = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f5356h = parcel.createTypedArrayList(o.m.CREATOR);
    }
}
