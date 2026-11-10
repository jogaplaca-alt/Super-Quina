package rawbt.sdk.transport;

/* JADX INFO: loaded from: classes.dex */
public class TransportFactory {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x008f  */
    public static Transport get(ConnectParameters connectParameters) throws Exception {
        Transport aidl;
        Bt bt;
        BLE ble;
        switch (connectParameters.getProtocol()) {
            case 1:
                String str = connectParameters.get_mac();
                if (!"00:00:00:00:00:00".equals(str)) {
                    bt = new Bt();
                    bt.setConnectParam(str);
                } else {
                    aidl = null;
                }
                break;
            case 2:
                P910nd p910nd = new P910nd();
                p910nd.setConnectParam(connectParameters.get_host(), "" + connectParameters.get_port());
                aidl = p910nd;
                break;
            case 3:
                USB usb = new USB();
                usb.setConnectParam(connectParameters.get_vid(), connectParameters.get_pid());
                aidl = usb;
                break;
            case 4:
                aidl = new AIDL();
                break;
            case 5:
                aidl = new PrintToFile();
                break;
            case 6:
                String str2 = connectParameters.get_mac();
                if (!"00:00:00:00:00:00".equals(str2)) {
                    ble = new BLE();
                    ble.setConnectParam(str2);
                } else {
                    aidl = null;
                }
                break;
            case 7:
                aidl = new PrintToGallery();
                break;
            case 8:
                SerialCom serialCom = new SerialCom();
                serialCom.setConnectParam(connectParameters.get_vid(), connectParameters.get_pid(), connectParameters.get_baud(), connectParameters.getSerialComDriver());
                aidl = serialCom;
                break;
            default:
                aidl = null;
                break;
        }
        if (aidl != null) {
            aidl = bt;
            aidl = ble;
            return aidl;
        }
        aidl = bt;
        aidl = ble;
        throw new Exception("Printer not configured");
    }
}
