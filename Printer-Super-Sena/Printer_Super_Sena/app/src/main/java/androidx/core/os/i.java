package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    static class a {
        static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }

        static void b(Configuration configuration, j jVar) {
            configuration.setLocales((LocaleList) jVar.i());
        }
    }

    public static j a(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? j.j(a.a(configuration)) : j.a(configuration.locale);
    }
}
