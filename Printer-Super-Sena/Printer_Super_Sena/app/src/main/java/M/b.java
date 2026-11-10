package M;

import android.text.Editable;

/* JADX INFO: loaded from: classes.dex */
final class b extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f1265a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Editable.Factory f1266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Class f1267c;

    private b() {
        try {
            f1267c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f1266b == null) {
            synchronized (f1265a) {
                try {
                    if (f1266b == null) {
                        f1266b = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1266b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = f1267c;
        return cls != null ? K.c.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
