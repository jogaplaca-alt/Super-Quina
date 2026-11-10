package F;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Parcelable f835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f834b = new C0010a();
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* JADX INFO: renamed from: F.a$a, reason: collision with other inner class name */
    class C0010a extends a {
        C0010a() {
            super((C0010a) null);
        }
    }

    class b implements Parcelable.ClassLoaderCreator {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.f834b;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    /* synthetic */ a(C0010a c0010a) {
        this();
    }

    public final Parcelable c() {
        return this.f835a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f835a, i3);
    }

    private a() {
        this.f835a = null;
    }

    protected a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f835a = parcelable == f834b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected a(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f835a = parcelable == null ? f834b : parcelable;
    }
}
