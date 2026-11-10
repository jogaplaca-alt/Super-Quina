package p060r1;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f10873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f10874b;

    static {
        HashMap map = new HashMap();
        f10873a = map;
        HashMap map2 = new HashMap();
        f10874b = map2;
        map.put(-1, "The Play Store app is either not installed or not the official version.");
        map.put(-2, "Call first requestReviewFlow to get the ReviewInfo.");
        map.put(-100, "Retry with an exponential backoff. Consider filing a bug if fails consistently.");
        map2.put(-1, "PLAY_STORE_NOT_FOUND");
        map2.put(-2, "INVALID_REQUEST");
        map2.put(-100, "INTERNAL_ERROR");
    }

    public static String a(int i3) {
        Map map = f10873a;
        Integer numValueOf = Integer.valueOf(i3);
        if (!map.containsKey(numValueOf)) {
            return "";
        }
        return ((String) map.get(numValueOf)) + " (https://developer.android.com/reference/com/google/android/play/core/review/model/ReviewErrorCode.html#" + ((String) f10874b.get(numValueOf)) + ")";
    }
}
