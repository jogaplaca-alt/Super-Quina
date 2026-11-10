package rawbt.api.attributes;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class AttributesPdf implements Parcelable {
    public static final Parcelable.Creator<AttributesPdf> CREATOR = new Parcelable.Creator<AttributesPdf>() { // from class: rawbt.api.attributes.AttributesPdf.1
        @Override // android.os.Parcelable.Creator
        public AttributesPdf createFromParcel(Parcel parcel) {
            return new AttributesPdf(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AttributesPdf[] newArray(int i3) {
            return new AttributesPdf[i3];
        }
    };
    public static final int WIDTH_TRUNCATE_1_2 = 1;
    public static final int WIDTH_TRUNCATE_MAX = 2;
    public static final int WIDTH_TRUNCATE_NONE = 0;
    private boolean clearHeaderAndFooter;
    private boolean cutFrame;
    private int cutFrameVal;
    private boolean cutTop;
    private int cutTopVal;
    private int page;
    private boolean paperCutAfterEachPage;
    private boolean roll;
    private int rotate;
    private int widthTruncateMode;

    public AttributesPdf() {
        this.page = -1;
        this.roll = true;
        this.widthTruncateMode = 2;
        this.rotate = 0;
        this.clearHeaderAndFooter = false;
        this.cutTop = false;
        this.cutTopVal = 0;
        this.cutFrame = false;
        this.cutFrameVal = 0;
        this.paperCutAfterEachPage = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCutFrameVal() {
        return this.cutFrameVal;
    }

    public int getCutTopVal() {
        return this.cutTopVal;
    }

    public int getPage() {
        return this.page;
    }

    public int getRotate() {
        return this.rotate;
    }

    public int getWidthTruncateMode() {
        return this.widthTruncateMode;
    }

    public boolean isClearHeaderAndFooter() {
        return this.clearHeaderAndFooter;
    }

    public boolean isCutFrame() {
        return this.cutFrame;
    }

    public boolean isCutTop() {
        return this.cutTop;
    }

    public boolean isPaperCutAfterEachPage() {
        return this.paperCutAfterEachPage;
    }

    public boolean isRoll() {
        return this.roll;
    }

    public AttributesPdf setClearHeaderAndFooter(boolean z3) {
        this.clearHeaderAndFooter = z3;
        return this;
    }

    public AttributesPdf setCutFrame(boolean z3) {
        this.cutFrame = z3;
        return this;
    }

    public AttributesPdf setCutFrameVal(int i3) {
        this.cutFrameVal = i3;
        return this;
    }

    public AttributesPdf setCutTop(boolean z3) {
        this.cutTop = z3;
        return this;
    }

    public AttributesPdf setCutTopVal(int i3) {
        this.cutTopVal = i3;
        return this;
    }

    public AttributesPdf setPage(int i3) {
        this.page = i3;
        return this;
    }

    public AttributesPdf setPaperCutAfterEachPage(boolean z3) {
        this.paperCutAfterEachPage = z3;
        return this;
    }

    public AttributesPdf setRoll(boolean z3) {
        this.roll = z3;
        return this;
    }

    public AttributesPdf setRotate(int i3) {
        this.rotate = i3;
        return this;
    }

    public AttributesPdf setWidthTruncateMode(int i3) {
        this.widthTruncateMode = i3;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.page);
        parcel.writeInt(this.widthTruncateMode);
        parcel.writeByte(this.clearHeaderAndFooter ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.cutTop ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.cutTopVal);
        parcel.writeByte(this.paperCutAfterEachPage ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.roll ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.rotate);
        parcel.writeByte(this.cutFrame ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.cutFrameVal);
    }

    protected AttributesPdf(Parcel parcel) {
        this.page = -1;
        this.roll = true;
        this.widthTruncateMode = 2;
        this.rotate = 0;
        this.clearHeaderAndFooter = false;
        this.cutTop = false;
        this.cutTopVal = 0;
        this.cutFrame = false;
        this.cutFrameVal = 0;
        this.paperCutAfterEachPage = false;
        this.page = parcel.readInt();
        this.widthTruncateMode = parcel.readInt();
        this.clearHeaderAndFooter = parcel.readByte() != 0;
        this.cutTop = parcel.readByte() != 0;
        this.cutTopVal = parcel.readInt();
        this.paperCutAfterEachPage = parcel.readByte() != 0;
        this.roll = parcel.readByte() != 0;
        this.rotate = parcel.readInt();
        this.cutFrame = parcel.readByte() != 0;
        this.cutFrameVal = parcel.readInt();
    }
}
