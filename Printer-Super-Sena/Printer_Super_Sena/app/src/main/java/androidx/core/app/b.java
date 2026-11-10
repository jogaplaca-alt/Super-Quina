package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends androidx.core.content.a {

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f4247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f4248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f4249c;

        a(String[] strArr, Activity activity, int i3) {
            this.f4247a = strArr;
            this.f4248b = activity;
            this.f4249c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f4247a.length];
            PackageManager packageManager = this.f4248b.getPackageManager();
            String packageName = this.f4248b.getPackageName();
            int length = this.f4247a.length;
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = packageManager.checkPermission(this.f4247a[i3], packageName);
            }
            ((d) this.f4248b).onRequestPermissionsResult(this.f4249c, this.f4247a, iArr);
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.b$b, reason: collision with other inner class name */
    static class C0050b {
        static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    static class c {
        static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        static void b(Activity activity, String[] strArr, int i3) {
            activity.requestPermissions(strArr, i3);
        }

        static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface d {
        void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr);
    }

    public interface e {
        void validateRequestPermissionsRequestCode(int i3);
    }

    public static void l(Activity activity) {
        activity.finishAffinity();
    }

    public static void m(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0050b.a(activity);
        } else {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(Activity activity) {
        if (activity.isFinishing() || androidx.core.app.d.i(activity)) {
            return;
        }
        activity.recreate();
    }

    public static void o(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0050b.b(activity);
        }
    }

    public static void p(final Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.n(activity);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void q(Activity activity, String[] strArr, int i3) {
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (TextUtils.isEmpty(strArr[i4])) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i4], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i4));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < strArr.length; i6++) {
                if (!hashSet.contains(Integer.valueOf(i6))) {
                    strArr2[i5] = strArr[i6];
                    i5++;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof e) {
                ((e) activity).validateRequestPermissionsRequestCode(i3);
            }
            c.b(activity, strArr, i3);
        } else if (activity instanceof d) {
            new Handler(Looper.getMainLooper()).post(new a(strArr2, activity, i3));
        }
    }

    public static void r(Activity activity, r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0050b.c(activity, null);
        }
    }

    public static void s(Activity activity, r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0050b.d(activity, null);
        }
    }

    public static void t(Activity activity, Intent intent, int i3, Bundle bundle) {
        activity.startActivityForResult(intent, i3, bundle);
    }

    public static void u(Activity activity, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        activity.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6, bundle);
    }

    public static void v(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0050b.e(activity);
        }
    }
}
