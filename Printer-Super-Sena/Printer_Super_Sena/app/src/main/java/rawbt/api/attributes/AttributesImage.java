package rawbt.api.attributes;

import android.os.Parcel;
import android.os.Parcelable;
import rawbt.api.Constant;

/* JADX INFO: loaded from: classes.dex */
public class AttributesImage implements Parcelable {
    public static final Parcelable.Creator<AttributesImage> CREATOR = new Parcelable.Creator<AttributesImage>() { // from class: rawbt.api.attributes.AttributesImage.1
        @Override // android.os.Parcelable.Creator
        public AttributesImage createFromParcel(Parcel parcel) {
            return new AttributesImage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AttributesImage[] newArray(int i3) {
            return new AttributesImage[i3];
        }
    };
    private String alignment;
    private boolean doScale;
    int graphicFilter;
    boolean inverseColor;
    boolean rotateImage;
    private int scale;

    public AttributesImage() {
        this.graphicFilter = 0;
        this.rotateImage = false;
        this.inverseColor = false;
        this.scale = 16;
        this.doScale = true;
        this.alignment = Constant.ALIGNMENT_LEFT;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlignment() {
        return this.alignment;
    }

    public int getGraphicFilter() {
        return this.graphicFilter;
    }

    public int getScale() {
        return this.scale;
    }

    public boolean isDoScale() {
        return this.doScale;
    }

    public boolean isInverseColor() {
        return this.inverseColor;
    }

    public boolean isRotateImage() {
        return this.rotateImage;
    }

    public AttributesImage setAlignment(String str) {
        this.alignment = str;
        return this;
    }

    public AttributesImage setDoScale(boolean z3) {
        this.doScale = z3;
        return this;
    }

    public AttributesImage setGraphicFilter(int i3) {
        this.graphicFilter = i3;
        return this;
    }

    public AttributesImage setInverseColor(boolean z3) {
        this.inverseColor = z3;
        return this;
    }

    public AttributesImage setRotateImage(boolean z3) {
        this.rotateImage = z3;
        return this;
    }

    public AttributesImage setScale(int i3) {
        this.scale = i3;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.graphicFilter);
        parcel.writeByte(this.rotateImage ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.inverseColor ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.scale);
        parcel.writeString(this.alignment);
        parcel.writeByte(this.doScale ? (byte) 1 : (byte) 0);
    }

    public AttributesImage(int i3) {
        this.rotateImage = false;
        this.inverseColor = false;
        this.scale = 16;
        this.doScale = true;
        this.alignment = Constant.ALIGNMENT_LEFT;
        this.graphicFilter = i3;
    }

    protected AttributesImage(Parcel parcel) {
        this.graphicFilter = 0;
        this.rotateImage = false;
        this.inverseColor = false;
        this.scale = 16;
        this.doScale = true;
        this.alignment = Constant.ALIGNMENT_LEFT;
        this.graphicFilter = parcel.readInt();
        this.rotateImage = parcel.readByte() != 0;
        this.inverseColor = parcel.readByte() != 0;
        this.scale = parcel.readInt();
        this.alignment = parcel.readString();
        this.doScale = parcel.readByte() != 0;
    }
}
