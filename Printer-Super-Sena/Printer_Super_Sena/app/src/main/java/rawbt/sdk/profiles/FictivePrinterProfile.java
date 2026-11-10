package rawbt.sdk.profiles;

import rawbt.sdk.dao.PrinterEntity;

/* JADX INFO: loaded from: classes.dex */
public class FictivePrinterProfile extends PrinterEntity {
    public FictivePrinterProfile(int i3, int i4, int i5, int i6) {
        this.dots = i3;
        this.sleepAfter = i4;
        this.dpi = i5;
        this.skipLinesAfterJob = i6;
    }
}
