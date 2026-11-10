package rawbt.api.attributes;

import android.os.Parcel;
import android.os.Parcelable;
import rawbt.api.Constant;

/* JADX INFO: loaded from: classes.dex */
public class AttributesQRcode implements Parcelable {
    public static final Parcelable.Creator<AttributesQRcode> CREATOR = new Parcelable.Creator<AttributesQRcode>() { // from class: rawbt.api.attributes.AttributesQRcode.1
        @Override // android.os.Parcelable.Creator
        public AttributesQRcode createFromParcel(Parcel parcel) {
            return new AttributesQRcode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AttributesQRcode[] newArray(int i3) {
            return new AttributesQRcode[i3];
        }
    };
    String alignment;
    int multiply;

    public AttributesQRcode() {
        this.alignment = Constant.ALIGNMENT_CENTER;
        this.multiply = 3;
    }

    public AttributesQRcode build() {
        return new AttributesQRcode().setAlignment(this.alignment).setMultiply(this.multiply);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlignment() {
        return this.alignment;
    }

    public int getMultiply() {
        return this.multiply;
    }

    public AttributesQRcode setAlignment(String str) {
        this.alignment = str;
        return this;
    }

    public AttributesQRcode setMultiply(int i3) {
        this.multiply = i3;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.alignment);
        parcel.writeInt(this.multiply);
    }

    protected AttributesQRcode(Parcel parcel) {
        this.alignment = Constant.ALIGNMENT_CENTER;
        this.multiply = 3;
        this.alignment = parcel.readString();
        this.multiply = parcel.readInt();
    }
}
