package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
final class t implements Parcelable {
    public static final Parcelable.Creator<t> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f5365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f5366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f5367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f5368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f5369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String f5370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f5371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f5372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f5373i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Bundle f5374j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f5375k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final int f5376l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Bundle f5377m;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public t createFromParcel(Parcel parcel) {
            return new t(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public t[] newArray(int i3) {
            return new t[i3];
        }
    }

    t(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        this.f5365a = abstractComponentCallbacksC0337e.getClass().getName();
        this.f5366b = abstractComponentCallbacksC0337e.f5189f;
        this.f5367c = abstractComponentCallbacksC0337e.f5197n;
        this.f5368d = abstractComponentCallbacksC0337e.f5206w;
        this.f5369e = abstractComponentCallbacksC0337e.f5207x;
        this.f5370f = abstractComponentCallbacksC0337e.f5208y;
        this.f5371g = abstractComponentCallbacksC0337e.f5159B;
        this.f5372h = abstractComponentCallbacksC0337e.f5196m;
        this.f5373i = abstractComponentCallbacksC0337e.f5158A;
        this.f5374j = abstractComponentCallbacksC0337e.f5190g;
        this.f5375k = abstractComponentCallbacksC0337e.f5209z;
        this.f5376l = abstractComponentCallbacksC0337e.f5175R.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f5365a);
        sb.append(" (");
        sb.append(this.f5366b);
        sb.append(")}:");
        if (this.f5367c) {
            sb.append(" fromLayout");
        }
        if (this.f5369e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f5369e));
        }
        String str = this.f5370f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f5370f);
        }
        if (this.f5371g) {
            sb.append(" retainInstance");
        }
        if (this.f5372h) {
            sb.append(" removing");
        }
        if (this.f5373i) {
            sb.append(" detached");
        }
        if (this.f5375k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f5365a);
        parcel.writeString(this.f5366b);
        parcel.writeInt(this.f5367c ? 1 : 0);
        parcel.writeInt(this.f5368d);
        parcel.writeInt(this.f5369e);
        parcel.writeString(this.f5370f);
        parcel.writeInt(this.f5371g ? 1 : 0);
        parcel.writeInt(this.f5372h ? 1 : 0);
        parcel.writeInt(this.f5373i ? 1 : 0);
        parcel.writeBundle(this.f5374j);
        parcel.writeInt(this.f5375k ? 1 : 0);
        parcel.writeBundle(this.f5377m);
        parcel.writeInt(this.f5376l);
    }

    t(Parcel parcel) {
        this.f5365a = parcel.readString();
        this.f5366b = parcel.readString();
        this.f5367c = parcel.readInt() != 0;
        this.f5368d = parcel.readInt();
        this.f5369e = parcel.readInt();
        this.f5370f = parcel.readString();
        this.f5371g = parcel.readInt() != 0;
        this.f5372h = parcel.readInt() != 0;
        this.f5373i = parcel.readInt() != 0;
        this.f5374j = parcel.readBundle();
        this.f5375k = parcel.readInt() != 0;
        this.f5377m = parcel.readBundle();
        this.f5376l = parcel.readInt();
    }
}
