package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.core.app.o;
import java.io.File;
import java.util.HashMap;
import rawbt.api.command.CommandString;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f4364a = new Object();

    /* JADX INFO: renamed from: androidx.core.content.a$a, reason: collision with other inner class name */
    static class C0052a {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }

        static Drawable b(Context context, int i3) {
            return context.getDrawable(i3);
        }

        static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    static class b {
        static int a(Context context, int i3) {
            return context.getColor(i3);
        }

        static <T> T b(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap f4365a;

        static {
            HashMap map = new HashMap();
            f4365a = map;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 22) {
                map.put(androidx.core.content.b.a(), "telephony_subscription_service");
                map.put(androidx.core.content.c.a(), "usagestats");
            }
            if (i3 >= 21) {
                map.put(AppWidgetManager.class, "appwidget");
                map.put(BatteryManager.class, "batterymanager");
                map.put(d.a(), "camera");
                map.put(e.a(), "jobscheduler");
                map.put(f.a(), "launcherapps");
                map.put(g.a(), "media_projection");
                map.put(h.a(), "media_session");
                map.put(i.a(), "restrictions");
                map.put(j.a(), "telecom");
                map.put(k.a(), "tv_input");
            }
            map.put(AppOpsManager.class, "appops");
            map.put(CaptioningManager.class, "captioning");
            map.put(ConsumerIrManager.class, "consumer_ir");
            map.put(PrintManager.class, CommandString.TAG);
            map.put(BluetoothManager.class, "bluetooth");
            map.put(DisplayManager.class, "display");
            map.put(UserManager.class, "user");
            map.put(InputManager.class, "input");
            map.put(MediaRouter.class, "media_router");
            map.put(NsdManager.class, "servicediscovery");
            map.put(AccessibilityManager.class, "accessibility");
            map.put(AccountManager.class, "account");
            map.put(ActivityManager.class, "activity");
            map.put(AlarmManager.class, "alarm");
            map.put(AudioManager.class, "audio");
            map.put(ClipboardManager.class, "clipboard");
            map.put(ConnectivityManager.class, "connectivity");
            map.put(DevicePolicyManager.class, "device_policy");
            map.put(DownloadManager.class, "download");
            map.put(DropBoxManager.class, "dropbox");
            map.put(InputMethodManager.class, "input_method");
            map.put(KeyguardManager.class, "keyguard");
            map.put(LayoutInflater.class, "layout_inflater");
            map.put(LocationManager.class, "location");
            map.put(NfcManager.class, "nfc");
            map.put(NotificationManager.class, "notification");
            map.put(PowerManager.class, "power");
            map.put(SearchManager.class, "search");
            map.put(SensorManager.class, "sensor");
            map.put(StorageManager.class, "storage");
            map.put(TelephonyManager.class, "phone");
            map.put(TextServicesManager.class, "textservices");
            map.put(UiModeManager.class, "uimode");
            map.put(UsbManager.class, "usb");
            map.put(Vibrator.class, "vibrator");
            map.put(WallpaperManager.class, "wallpaper");
            map.put(WifiP2pManager.class, "wifip2p");
            map.put(WifiManager.class, "wifi");
            map.put(WindowManager.class, "window");
        }
    }

    public static int a(Context context, String str) {
        p082z.c.d(str, "permission must be non-null");
        if (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        return o.b(context).a() ? 0 : -1;
    }

    public static int b(Context context, int i3) {
        return Build.VERSION.SDK_INT >= 23 ? b.a(context, i3) : context.getResources().getColor(i3);
    }

    public static ColorStateList c(Context context, int i3) {
        return androidx.core.content.res.h.d(context.getResources(), i3, context.getTheme());
    }

    public static Drawable d(Context context, int i3) {
        return Build.VERSION.SDK_INT >= 21 ? C0052a.b(context, i3) : context.getResources().getDrawable(i3);
    }

    public static File[] e(Context context) {
        return context.getExternalCacheDirs();
    }

    public static File[] f(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static Object g(Context context, Class cls) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.b(context, cls);
        }
        String strH = h(context, cls);
        if (strH != null) {
            return context.getSystemService(strH);
        }
        return null;
    }

    public static String h(Context context, Class cls) {
        return Build.VERSION.SDK_INT >= 23 ? b.c(context, cls) : (String) c.f4365a.get(cls);
    }

    public static boolean i(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }

    public static void j(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }
}
