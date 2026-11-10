package rawbt.api.attributes;

import android.os.Parcel;
import android.os.Parcelable;
import rawbt.api.Constant;

/* JADX INFO: loaded from: classes.dex */
public class AttributesBarcode implements Parcelable {
    public static final Parcelable.Creator<AttributesBarcode> CREATOR = new Parcelable.Creator<AttributesBarcode>() { // from class: rawbt.api.attributes.AttributesBarcode.1
        @Override // android.os.Parcelable.Creator
        public AttributesBarcode createFromParcel(Parcel parcel) {
            return new AttributesBarcode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AttributesBarcode[] newArray(int i3) {
            return new AttributesBarcode[i3];
        }
    };
    String alignment;
    int font;
    int height;
    String hri;
    String type;
    int width;

    public AttributesBarcode() {
        this.hri = "none";
        this.font = 1;
        this.height = 162;
        this.width = 3;
        this.alignment = Constant.ALIGNMENT_LEFT;
    }

    public AttributesBarcode build() {
        return new AttributesBarcode().setType(this.type).setHri(this.hri).setFont(this.font).setHeight(this.height).setWidth(this.width).setAlignment(this.alignment);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlignment() {
        return this.alignment;
    }

    public int getFont() {
        return this.font;
    }

    public int getHeight() {
        return this.height;
    }

    public String getHri() {
        return this.hri;
    }

    public String getType() {
        return this.type;
    }

    public int getWidth() {
        return this.width;
    }

    public AttributesBarcode setAlignment(String str) {
        this.alignment = str;
        return this;
    }

    public AttributesBarcode setFont(int i3) {
        this.font = i3;
        return this;
    }

    public AttributesBarcode setHeight(int i3) {
        this.height = i3;
        return this;
    }

    public AttributesBarcode setHri(String str) {
        this.hri = str;
        return this;
    }

    public AttributesBarcode setType(String str) {
        this.type = str;
        return this;
    }

    public AttributesBarcode setWidth(int i3) {
        this.width = i3;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.type);
        parcel.writeString(this.hri);
        parcel.writeInt(this.font);
        parcel.writeInt(this.height);
        parcel.writeInt(this.width);
        parcel.writeString(this.alignment);
    }

    protected AttributesBarcode(Parcel parcel) {
        this.hri = "none";
        this.font = 1;
        this.height = 162;
        this.width = 3;
        this.alignment = Constant.ALIGNMENT_LEFT;
        this.type = parcel.readString();
        this.hri = parcel.readString();
        this.font = parcel.readInt();
        this.height = parcel.readInt();
        this.width = parcel.readInt();
        this.alignment = parcel.readString();
    }
}
