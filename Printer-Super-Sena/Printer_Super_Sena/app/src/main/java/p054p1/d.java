package p054p1;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static c a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return new h(new m(context));
    }
}
