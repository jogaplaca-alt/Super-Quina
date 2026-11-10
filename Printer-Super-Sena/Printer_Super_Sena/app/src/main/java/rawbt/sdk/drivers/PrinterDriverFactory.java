package rawbt.sdk.drivers;

import android.content.Context;
import rawbt.sdk.dao.PrinterEntity;

/* JADX INFO: loaded from: classes.dex */
public class PrinterDriverFactory {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:53:0x00bb  */
    public static PosDriverInterface getByProfile(PrinterEntity printerEntity, Context context) {
        switch (printerEntity.getProfileClass()) {
            case "raw_transfer":
                return new RealRAW(printerEntity, context);
            case "paperang":
                return new PaperangP1Driver(printerEntity, context);
            case "paperang2":
                return new PaperangP2Driver(printerEntity, context);
            case "peripage":
                return new PeripageDriver(printerEntity, context);
            case "esc_gs_v_0":
                return new GSv0Driver(printerEntity, context);
            case "cat_printer":
                return new CatPrinterDriver(printerEntity, context);
            case "dothan_printer":
                return new DothanTechDriver(printerEntity, context);
            case "cpcl_general":
                return new CpclDriver(printerEntity, context);
            case "epl_general":
                return new EplDriver(printerEntity, context);
            case "tspl_general":
                return new TsplDriver(printerEntity, context);
            case "zpl_general":
                return new ZplDriver(printerEntity, context);
            case "DRIVER_AIDL_WOYOU_IPOS":
                return new Aidl_woyou_iPOS_Printer(printerEntity, context);
            case "DRIVER_AIDL_WOYOU_JIUIV5":
                return new Aidl_jiuiv5(printerEntity, context);
            case "DRIVER_AIDL_ATOL10":
                return new Aidl_Atol10(printerEntity, context);
            case "DRIVER_AIDL_COM_IPOS":
                return new Aidl_iPOS_Printer(printerEntity, context);
            case "esc_general":
            default:
                return new EscGeneral(printerEntity, context);
        }
    }
}
