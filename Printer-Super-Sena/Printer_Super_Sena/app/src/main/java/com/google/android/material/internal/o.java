package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public class o extends SparseArray implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new a();

    class a implements Parcelable.ClassLoaderCreator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public o createFromParcel(Parcel parcel) {
            return new o(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public o createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new o(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public o[] newArray(int i3) {
            return new o[i3];
        }
    }

    public o() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int size = size();
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr[i4] = keyAt(i4);
            parcelableArr[i4] = (Parcelable) valueAt(i4);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i3);
    }

    public o(Parcel parcel, ClassLoader classLoader) {
        int i3 = parcel.readInt();
        int[] iArr = new int[i3];
        parcel.readIntArray(iArr);
        Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
        for (int i4 = 0; i4 < i3; i4++) {
            put(iArr[i4], parcelableArray[i4]);
        }
    }
}
