package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.InterfaceC0356n;
import androidx.lifecycle.InterfaceC0358p;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
final class p implements InterfaceC0356n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f2263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f2264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Field f2265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Field f2266e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f2267a;

    p(Activity activity) {
        this.f2267a = activity;
    }

    private static void h() {
        try {
            f2263b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f2265d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f2266e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f2264c = declaredField3;
            declaredField3.setAccessible(true);
            f2263b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.InterfaceC0356n
    public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
        if (aVar != AbstractC0354l.a.ON_DESTROY) {
            return;
        }
        if (f2263b == 0) {
            h();
        }
        if (f2263b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f2267a.getSystemService("input_method");
            try {
                Object obj = f2264c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            try {
                                View view = (View) f2265d.get(inputMethodManager);
                                if (view == null) {
                                    return;
                                }
                                if (view.isAttachedToWindow()) {
                                    return;
                                }
                                try {
                                    f2266e.set(inputMethodManager, null);
                                    inputMethodManager.isActive();
                                } catch (IllegalAccessException unused) {
                                }
                            } catch (ClassCastException unused2) {
                            }
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
