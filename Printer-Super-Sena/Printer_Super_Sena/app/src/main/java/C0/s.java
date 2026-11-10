package C0;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class s extends M0.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f148c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(h hVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f148c = hVar;
        this.f147b = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i3);
            return;
        }
        h hVar = this.f148c;
        int iE = hVar.e(this.f147b);
        if (hVar.h(iE)) {
            this.f148c.m(this.f147b, iE);
        }
    }
}
