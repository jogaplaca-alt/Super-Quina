package rawbt.sdk.transport;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Constant {
    public static final int AIDL_ATOL10 = 3;
    public static final int AIDL_COM_IPOS = 0;
    public static final int AIDL_WOYOU_IPOS = 1;
    public static final int AIDL_WOYOU_JIUIV5 = 2;
    public static final String COM_CdcAcm = "CdcAcm";
    public static final String COM_Ch34 = "Ch34";
    public static final String COM_Cp21 = "Cp21";
    public static final String COM_Ftdi = "Ftdi";
    public static final String COM_Prolific = "Prolific";
    public static final String DRIVER_AIDL_ATOL10 = "DRIVER_AIDL_ATOL10";
    public static final String DRIVER_AIDL_COM_IPOS = "DRIVER_AIDL_COM_IPOS";
    public static final String DRIVER_AIDL_WOYOU_IPOS = "DRIVER_AIDL_WOYOU_IPOS";
    public static final String DRIVER_AIDL_WOYOU_JIUIV5 = "DRIVER_AIDL_WOYOU_JIUIV5";
    public static final String DRIVER_CAT_PRINTER = "cat_printer";
    public static final String DRIVER_CPCL = "cpcl_general";
    public static final String DRIVER_DOTHAN_TECH = "dothan_printer";
    public static final String DRIVER_EPL = "epl_general";
    public static final String DRIVER_ESC_GENERAL = "esc_general";
    public static final String DRIVER_GSv0 = "esc_gs_v_0";
    public static final String DRIVER_PAPERANG = "paperang";
    public static final String DRIVER_PAPERANG2 = "paperang2";
    public static final String DRIVER_PERIPAGE = "peripage";
    public static final String DRIVER_RAW_TRANSFER = "raw_transfer";
    public static final String DRIVER_TSPL = "tspl_general";
    public static final String DRIVER_ZPL = "zpl_general";
    public static final int PROTOCOL_AIDL = 4;
    public static final int PROTOCOL_BLE = 6;
    public static final int PROTOCOL_BT = 1;
    public static final int PROTOCOL_COM = 8;
    public static final int PROTOCOL_IMAGE = 7;
    public static final int PROTOCOL_LAN = 2;
    public static final int PROTOCOL_NOTSET = 0;
    public static final int PROTOCOL_PRN = 5;
    public static final int PROTOCOL_USB = 3;

    public static ArrayList<String> getAidlDriversList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("com.iposprinter");
        arrayList.add("woyou.iposprinter");
        arrayList.add("woyou..jiuiv5");
        arrayList.add("ru.atol v10");
        return arrayList;
    }

    public static String getProtocolName(int i3) {
        switch (i3) {
            case 1:
                return "Bluetooth";
            case 2:
                return "Network";
            case 3:
                return "USB cable";
            case 4:
                return "Integrated printer";
            case 5:
                return "Virtual printer";
            case 6:
                return "Bluetooth Low Energy";
            case 7:
            default:
                return "Unknown";
            case 8:
                return "COM over USB";
        }
    }
}
