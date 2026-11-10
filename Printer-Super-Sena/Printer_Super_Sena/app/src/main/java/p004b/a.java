package p004b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0097a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Intent f6899b;

    /* JADX INFO: renamed from: b.a$a, reason: collision with other inner class name */
    class C0097a implements Parcelable.Creator {
        C0097a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    public a(int i3, Intent intent) {
        this.f6898a = i3;
        this.f6899b = intent;
    }

    public static String e(int i3) {
        if (i3 != -1) {
            return i3 != 0 ? String.valueOf(i3) : "RESULT_CANCELED";
        }
        return "RESULT_OK";
    }

    public Intent c() {
        return this.f6899b;
    }

    public int d() {
        return this.f6898a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + e(this.f6898a) + ", data=" + this.f6899b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f6898a);
        parcel.writeInt(this.f6899b == null ? 0 : 1);
        Intent intent = this.f6899b;
        if (intent != null) {
            intent.writeToParcel(parcel, i3);
        }
    }

    a(Parcel parcel) {
        this.f6898a = parcel.readInt();
        this.f6899b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
