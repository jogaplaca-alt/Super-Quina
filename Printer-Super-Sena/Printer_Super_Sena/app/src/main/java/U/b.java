package U;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends Application {
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.k(this);
    }
}
