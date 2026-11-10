package F0;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* JADX INFO: renamed from: F0.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0229x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final p046n.g f998a = new p046n.g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Locale f999b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return K0.d.a(context).b(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context, int i3) {
        Resources resources = context.getResources();
        if (i3 == 1) {
            return resources.getString(B0.b.f71d);
        }
        if (i3 != 2) {
            return i3 != 3 ? resources.getString(R.string.ok) : resources.getString(B0.b.f68a);
        }
        return resources.getString(B0.b.f77j);
    }

    public static String c(Context context, int i3) {
        Resources resources = context.getResources();
        String strA = a(context);
        if (i3 == 1) {
            return resources.getString(B0.b.f72e, strA);
        }
        if (i3 == 2) {
            return J0.d.c(context) ? resources.getString(B0.b.f81n) : resources.getString(B0.b.f78k, strA);
        }
        if (i3 == 3) {
            return resources.getString(B0.b.f69b, strA);
        }
        if (i3 == 5) {
            return g(context, "common_google_play_services_invalid_account_text", strA);
        }
        if (i3 == 7) {
            return g(context, "common_google_play_services_network_error_text", strA);
        }
        if (i3 == 9) {
            return resources.getString(B0.b.f76i, strA);
        }
        if (i3 == 20) {
            return g(context, "common_google_play_services_restricted_profile_text", strA);
        }
        switch (i3) {
            case 16:
                return g(context, "common_google_play_services_api_unavailable_text", strA);
            case 17:
                return g(context, "common_google_play_services_sign_in_failed_text", strA);
            case 18:
                return resources.getString(B0.b.f80m, strA);
            default:
                return resources.getString(C0.q.f143a, strA);
        }
    }

    public static String d(Context context, int i3) {
        return (i3 == 6 || i3 == 19) ? g(context, "common_google_play_services_resolution_required_text", a(context)) : c(context, i3);
    }

    public static String e(Context context, int i3) {
        String strH = i3 == 6 ? h(context, "common_google_play_services_resolution_required_title") : f(context, i3);
        return strH == null ? context.getResources().getString(B0.b.f75h) : strH;
    }

    public static String f(Context context, int i3) {
        Resources resources = context.getResources();
        switch (i3) {
            case 1:
                return resources.getString(B0.b.f73f);
            case 2:
                return resources.getString(B0.b.f79l);
            case 3:
                return resources.getString(B0.b.f70c);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return h(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return h(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i3);
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return h(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return h(context, "common_google_play_services_restricted_profile_title");
        }
    }

    private static String g(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strH = h(context, str);
        if (strH == null) {
            strH = resources.getString(C0.q.f143a);
        }
        return String.format(resources.getConfiguration().locale, strH, str2);
    }

    private static String h(Context context, String str) {
        p046n.g gVar = f998a;
        synchronized (gVar) {
            try {
                Locale localeD = androidx.core.os.i.a(context.getResources().getConfiguration()).d(0);
                if (!localeD.equals(f999b)) {
                    gVar.clear();
                    f999b = localeD;
                }
                String str2 = (String) gVar.get(str);
                if (str2 != null) {
                    return str2;
                }
                Resources resourcesB = C0.j.b(context);
                if (resourcesB == null) {
                    return null;
                }
                int identifier = resourcesB.getIdentifier(str, "string", "com.google.android.gms");
                if (identifier == 0) {
                    Log.w("GoogleApiAvailability", "Missing resource: " + str);
                    return null;
                }
                String string = resourcesB.getString(identifier);
                if (!TextUtils.isEmpty(string)) {
                    gVar.put(str, string);
                    return string;
                }
                Log.w("GoogleApiAvailability", "Got empty resource: " + str);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
