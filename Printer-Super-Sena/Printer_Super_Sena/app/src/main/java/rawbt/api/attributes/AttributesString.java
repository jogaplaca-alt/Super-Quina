package rawbt.api.attributes;

import android.os.Parcel;
import android.os.Parcelable;
import rawbt.api.Constant;
import rawbt.api.RawbtPrintJob;

/* JADX INFO: loaded from: classes.dex */
public class AttributesString implements Parcelable {
    public static final Parcelable.Creator<AttributesString> CREATOR = new Parcelable.Creator<AttributesString>() { // from class: rawbt.api.attributes.AttributesString.1
        @Override // android.os.Parcelable.Creator
        public AttributesString createFromParcel(Parcel parcel) {
            return new AttributesString(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AttributesString[] newArray(int i3) {
            return new AttributesString[i3];
        }
    };
    private String alignment;
    private boolean bold;
    private boolean doubleHeight;
    private boolean doubleWidth;
    private int fontsCpi;
    private int internationalChars;
    private String lang;
    private int printerFont;
    private int truetypeFontSize;
    private boolean underline;

    public AttributesString() {
        this.fontsCpi = 0;
        this.internationalChars = 0;
        this.truetypeFontSize = 21;
        this.printerFont = 0;
        this.alignment = Constant.ALIGNMENT_LEFT;
        this.bold = false;
        this.doubleHeight = false;
        this.doubleWidth = false;
        this.underline = false;
        this.lang = RawbtPrintJob.TEMPLATE_DEFAULT;
    }

    public AttributesString build() {
        return new AttributesString().setFontsCpi(this.fontsCpi).setInternationalChars(this.internationalChars).setTruetypeFontSize(this.truetypeFontSize).setPrinterFont(this.printerFont).setAlignment(this.alignment).setBold(this.bold).setDoubleWidth(this.doubleWidth).setDoubleHeight(this.doubleHeight).setUnderline(this.underline).setLang(this.lang);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlignment() {
        return this.alignment;
    }

    public int getFontsCpi() {
        return this.fontsCpi;
    }

    public int getInternationalChars() {
        return this.internationalChars;
    }

    public String getLang() {
        return this.lang;
    }

    public int getPrinterFont() {
        return this.printerFont;
    }

    public int getTruetypeFontSize() {
        return this.truetypeFontSize;
    }

    public boolean isBold() {
        return this.bold;
    }

    public boolean isDoubleHeight() {
        return this.doubleHeight;
    }

    public boolean isDoubleWidth() {
        return this.doubleWidth;
    }

    public boolean isFontA() {
        return getPrinterFont() == 1;
    }

    public boolean isFontB() {
        return getPrinterFont() == 2;
    }

    public boolean isFontC() {
        return getPrinterFont() == 3;
    }

    public boolean isUnderline() {
        return this.underline;
    }

    public AttributesString setAlignment(String str) {
        this.alignment = str;
        return this;
    }

    public AttributesString setBold(boolean z3) {
        this.bold = z3;
        return this;
    }

    public AttributesString setDoubleHeight(boolean z3) {
        this.doubleHeight = z3;
        return this;
    }

    public AttributesString setDoubleWidth(boolean z3) {
        this.doubleWidth = z3;
        return this;
    }

    public AttributesString setFontsCpi(int i3) {
        this.fontsCpi = i3;
        return this;
    }

    public AttributesString setInternationalChars(int i3) {
        this.internationalChars = i3;
        return this;
    }

    public AttributesString setLang(String str) {
        this.lang = str;
        return this;
    }

    public AttributesString setPrinterFont(int i3) {
        this.printerFont = i3;
        return this;
    }

    public AttributesString setTruetypeFontSize(int i3) {
        this.truetypeFontSize = i3;
        return this;
    }

    public AttributesString setUnderline(boolean z3) {
        this.underline = z3;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.printerFont);
        parcel.writeInt(this.fontsCpi);
        parcel.writeInt(this.internationalChars);
        parcel.writeInt(this.truetypeFontSize);
        parcel.writeString(this.alignment);
        parcel.writeByte(this.bold ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.doubleHeight ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.doubleWidth ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.underline ? (byte) 1 : (byte) 0);
        parcel.writeString(this.lang);
    }

    protected AttributesString(Parcel parcel) {
        this.fontsCpi = 0;
        this.internationalChars = 0;
        this.truetypeFontSize = 21;
        this.printerFont = 0;
        this.alignment = Constant.ALIGNMENT_LEFT;
        this.bold = false;
        this.doubleHeight = false;
        this.doubleWidth = false;
        this.underline = false;
        this.lang = RawbtPrintJob.TEMPLATE_DEFAULT;
        this.printerFont = parcel.readInt();
        this.fontsCpi = parcel.readInt();
        this.internationalChars = parcel.readInt();
        this.truetypeFontSize = parcel.readInt();
        this.alignment = parcel.readString();
        this.bold = parcel.readByte() != 0;
        this.doubleHeight = parcel.readByte() != 0;
        this.doubleWidth = parcel.readByte() != 0;
        this.underline = parcel.readByte() != 0;
        this.lang = parcel.readString();
    }
}
