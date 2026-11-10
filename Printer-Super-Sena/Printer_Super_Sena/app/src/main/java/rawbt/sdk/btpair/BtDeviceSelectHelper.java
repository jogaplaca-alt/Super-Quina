package rawbt.sdk.btpair;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.util.Base64;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class BtDeviceSelectHelper {
    public static boolean checkSearchAvailability(Context context) {
        boolean zIsProviderEnabled;
        boolean zIsProviderEnabled2;
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        try {
            zIsProviderEnabled = locationManager.isProviderEnabled("network");
        } catch (Exception e3) {
            e3.printStackTrace();
            zIsProviderEnabled = false;
        }
        try {
            zIsProviderEnabled2 = locationManager.isProviderEnabled("gps");
        } catch (Exception e4) {
            e4.printStackTrace();
            zIsProviderEnabled2 = false;
        }
        return zIsProviderEnabled || zIsProviderEnabled2;
    }

    public static String fixDevName(String str) {
        if (str == null) {
            str = "unknown";
        }
        if (!str.endsWith("=")) {
            return str;
        }
        try {
            return new String(Base64.decode(str, 0), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return "Name in Base64";
        }
    }

    public static void openBtSettings(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.BLUETOOTH_SETTINGS");
        context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.open_bt_settings)));
    }
}
