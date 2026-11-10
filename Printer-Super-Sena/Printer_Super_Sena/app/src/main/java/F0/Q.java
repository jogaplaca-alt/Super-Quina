package F0;

import C0.C0179a;
import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class Q extends N0.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AbstractC0209c f857b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(AbstractC0209c abstractC0209c, Looper looper) {
        super(looper);
        this.f857b = abstractC0209c;
    }

    private static final void a(Message message) {
        S s3 = (S) message.obj;
        s3.b();
        s3.e();
    }

    private static final boolean b(Message message) {
        int i3 = message.what;
        return i3 == 2 || i3 == 1 || i3 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f857b.f882C.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i3 = message.what;
        if ((i3 == 1 || i3 == 7 || ((i3 == 4 && !this.f857b.q()) || message.what == 5)) && !this.f857b.a()) {
            a(message);
            return;
        }
        int i4 = message.what;
        if (i4 == 4) {
            this.f857b.f908z = new C0179a(message.arg2);
            if (AbstractC0209c.d0(this.f857b)) {
                AbstractC0209c abstractC0209c = this.f857b;
                if (!abstractC0209c.f880A) {
                    abstractC0209c.e0(3, null);
                    return;
                }
            }
            AbstractC0209c abstractC0209c2 = this.f857b;
            C0179a c0179a = abstractC0209c2.f908z != null ? abstractC0209c2.f908z : new C0179a(8);
            this.f857b.f898p.c(c0179a);
            this.f857b.I(c0179a);
            return;
        }
        if (i4 == 5) {
            AbstractC0209c abstractC0209c3 = this.f857b;
            C0179a c0179a2 = abstractC0209c3.f908z != null ? abstractC0209c3.f908z : new C0179a(8);
            this.f857b.f898p.c(c0179a2);
            this.f857b.I(c0179a2);
            return;
        }
        if (i4 == 3) {
            Object obj = message.obj;
            C0179a c0179a3 = new C0179a(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f857b.f898p.c(c0179a3);
            this.f857b.I(c0179a3);
            return;
        }
        if (i4 == 6) {
            this.f857b.e0(5, null);
            AbstractC0209c abstractC0209c4 = this.f857b;
            if (abstractC0209c4.f903u != null) {
                abstractC0209c4.f903u.c(message.arg2);
            }
            this.f857b.J(message.arg2);
            AbstractC0209c.c0(this.f857b, 5, 1, null);
            return;
        }
        if (i4 == 2 && !this.f857b.isConnected()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((S) message.obj).c();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
    }
}
