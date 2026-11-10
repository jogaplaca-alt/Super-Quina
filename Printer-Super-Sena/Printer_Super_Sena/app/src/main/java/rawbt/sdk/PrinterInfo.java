package rawbt.sdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class PrinterInfo implements Parcelable {
    public static final Parcelable.Creator<PrinterInfo> CREATOR = new Parcelable.Creator<PrinterInfo>() { // from class: rawbt.sdk.PrinterInfo.1
        @Override // android.os.Parcelable.Creator
        public PrinterInfo createFromParcel(Parcel parcel) {
            PrinterInfo printerInfo = new PrinterInfo();
            printerInfo.readFromParcel(parcel);
            return printerInfo;
        }

        @Override // android.os.Parcelable.Creator
        public PrinterInfo[] newArray(int i3) {
            return new PrinterInfo[i3];
        }
    };
    public String description;
    public String name;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel parcel) {
        int iDataPosition = parcel.dataPosition();
        int i3 = parcel.readInt();
        if (i3 < 0) {
            return;
        }
        try {
            this.name = parcel.readString();
            if (parcel.dataPosition() - iDataPosition < i3) {
                this.description = parcel.readString();
                if (parcel.dataPosition() - iDataPosition < i3) {
                    parcel.setDataPosition(iDataPosition + i3);
                }
            }
        } finally {
            parcel.setDataPosition(iDataPosition + i3);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(0);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        int iDataPosition2 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition2 - iDataPosition);
        parcel.setDataPosition(iDataPosition2);
    }
}
