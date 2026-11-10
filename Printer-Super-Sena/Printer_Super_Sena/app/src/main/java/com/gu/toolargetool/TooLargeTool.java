package com.gu.toolargetool;

import F1.a;
import F1.b;
import F1.c;
import F1.e;
import F1.f;
import F1.g;
import F1.h;
import S1.k;
import S1.p;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class TooLargeTool {
    public static final TooLargeTool INSTANCE = new TooLargeTool();
    private static a activityLogger;

    private TooLargeTool() {
    }

    private final float KB(int i3) {
        return i3 / 1000.0f;
    }

    public static final String bundleBreakdown(Bundle bundle) {
        k.e(bundle, "bundle");
        g gVarB = h.b(bundle);
        String strA = gVarB.a();
        int iB = gVarB.b();
        List<g> listC = gVarB.c();
        p pVar = p.f1952a;
        String string = String.format(Locale.UK, "%s contains %d keys and measures %,.1f KB when serialized as a Parcel", Arrays.copyOf(new Object[]{strA, Integer.valueOf(listC.size()), Float.valueOf(INSTANCE.KB(iB))}, 3));
        k.d(string, "java.lang.String.format(locale, format, *args)");
        for (g gVar : listC) {
            String strA2 = gVar.a();
            int iB2 = gVar.b();
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            p pVar2 = p.f1952a;
            String str = String.format(Locale.UK, "\n* %s = %,.1f KB", Arrays.copyOf(new Object[]{strA2, Float.valueOf(INSTANCE.KB(iB2))}, 2));
            k.d(str, "java.lang.String.format(locale, format, *args)");
            sb.append(str);
            string = sb.toString();
        }
        return string;
    }

    public static final boolean isLogging() {
        a aVar = activityLogger;
        k.b(aVar);
        return aVar.a();
    }

    public static /* synthetic */ void isLogging$annotations() {
    }

    public static final void logBundleBreakdown(String str, Bundle bundle) {
        k.e(str, "tag");
        k.e(bundle, "bundle");
        Log.println(3, str, bundleBreakdown(bundle));
    }

    public static final void startLogging(Application application) {
        startLogging$default(application, 0, null, 6, null);
    }

    public static /* synthetic */ void startLogging$default(Application application, int i3, String str, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 3;
        }
        if ((i4 & 4) != 0) {
            str = "TooLargeTool";
        }
        startLogging(application, i3, str);
    }

    public static final void stopLogging(Application application) {
        k.e(application, "application");
        a aVar = activityLogger;
        k.b(aVar);
        if (aVar.a()) {
            a aVar2 = activityLogger;
            k.b(aVar2);
            aVar2.d();
            application.unregisterActivityLifecycleCallbacks(activityLogger);
        }
    }

    public static final void logBundleBreakdown(String str, int i3, Bundle bundle) {
        k.e(str, "tag");
        k.e(bundle, "bundle");
        Log.println(i3, str, bundleBreakdown(bundle));
    }

    public static final void startLogging(Application application, int i3) {
        startLogging$default(application, i3, null, 4, null);
    }

    public static final void startLogging(Application application, int i3, String str) {
        k.e(application, "application");
        k.e(str, "tag");
        startLogging(application, new b(), new e(i3, str));
    }

    public static final void startLogging(Application application, c cVar, f fVar) {
        k.e(application, "application");
        k.e(cVar, "formatter");
        k.e(fVar, "logger");
        if (activityLogger == null) {
            activityLogger = new a(cVar, fVar, true);
        }
        a aVar = activityLogger;
        k.b(aVar);
        if (aVar.a()) {
            return;
        }
        a aVar2 = activityLogger;
        k.b(aVar2);
        aVar2.c();
        application.registerActivityLifecycleCallbacks(activityLogger);
    }
}
