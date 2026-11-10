package p054p1;

import android.os.Bundle;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p057q1.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set f10506a = new HashSet(Arrays.asList("native", "unity"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f10507b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final i f10508c = new i("PlayCoreVersion");

    public static Bundle a() {
        Bundle bundle = new Bundle();
        Map mapB = b();
        bundle.putInt("playcore_version_code", ((Integer) mapB.get("java")).intValue());
        if (mapB.containsKey("native")) {
            bundle.putInt("playcore_native_version", ((Integer) mapB.get("native")).intValue());
        }
        if (mapB.containsKey("unity")) {
            bundle.putInt("playcore_unity_version", ((Integer) mapB.get("unity")).intValue());
        }
        return bundle;
    }

    public static synchronized Map b() {
        Map map;
        map = f10507b;
        map.put("java", 11004);
        return map;
    }
}
