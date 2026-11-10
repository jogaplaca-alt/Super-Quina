package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes.dex */
class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseIntArray f6824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Parcel f6825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f6827g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f6828h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6829i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6830j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f6831k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new p046n.a(), new p046n.a(), new p046n.a());
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f6825e.writeInt(-1);
        } else {
            this.f6825e.writeInt(bArr.length);
            this.f6825e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f6825e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i3) {
        this.f6825e.writeInt(i3);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f6825e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f6825e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i3 = this.f6829i;
        if (i3 >= 0) {
            int i4 = this.f6824d.get(i3);
            int iDataPosition = this.f6825e.dataPosition();
            this.f6825e.setDataPosition(i4);
            this.f6825e.writeInt(iDataPosition - i4);
            this.f6825e.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f6825e;
        int iDataPosition = parcel.dataPosition();
        int i3 = this.f6830j;
        if (i3 == this.f6826f) {
            i3 = this.f6827g;
        }
        return new b(parcel, iDataPosition, i3, this.f6828h + "  ", this.f6821a, this.f6822b, this.f6823c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.f6825e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int i3 = this.f6825e.readInt();
        if (i3 < 0) {
            return null;
        }
        byte[] bArr = new byte[i3];
        this.f6825e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f6825e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i3) {
        while (this.f6830j < this.f6827g) {
            int i4 = this.f6831k;
            if (i4 == i3) {
                return true;
            }
            if (String.valueOf(i4).compareTo(String.valueOf(i3)) > 0) {
                return false;
            }
            this.f6825e.setDataPosition(this.f6830j);
            int i5 = this.f6825e.readInt();
            this.f6831k = this.f6825e.readInt();
            this.f6830j += i5;
        }
        return this.f6831k == i3;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f6825e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public Parcelable q() {
        return this.f6825e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f6825e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i3) {
        a();
        this.f6829i = i3;
        this.f6824d.put(i3, this.f6825e.dataPosition());
        E(0);
        E(i3);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z3) {
        this.f6825e.writeInt(z3 ? 1 : 0);
    }

    private b(Parcel parcel, int i3, int i4, String str, p046n.a aVar, p046n.a aVar2, p046n.a aVar3) {
        super(aVar, aVar2, aVar3);
        this.f6824d = new SparseIntArray();
        this.f6829i = -1;
        this.f6831k = -1;
        this.f6825e = parcel;
        this.f6826f = i3;
        this.f6827g = i4;
        this.f6830j = i3;
        this.f6828h = str;
    }
}
