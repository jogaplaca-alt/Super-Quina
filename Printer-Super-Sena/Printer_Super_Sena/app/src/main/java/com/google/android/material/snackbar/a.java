package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.appcompat.app.H;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f8449c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8450a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f8451b = new Handler(Looper.getMainLooper(), new C0107a());

    /* JADX INFO: renamed from: com.google.android.material.snackbar.a$a, reason: collision with other inner class name */
    class C0107a implements Handler.Callback {
        C0107a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a aVar = a.this;
            H.a(message.obj);
            aVar.c(null);
            return true;
        }
    }

    interface b {
    }

    private static class c {
    }

    private a() {
    }

    private boolean a(c cVar, int i3) {
        throw null;
    }

    static a b() {
        if (f8449c == null) {
            f8449c = new a();
        }
        return f8449c;
    }

    private boolean d(b bVar) {
        return false;
    }

    void c(c cVar) {
        synchronized (this.f8450a) {
            a(cVar, 2);
        }
    }

    public void e(b bVar) {
        synchronized (this.f8450a) {
            try {
                if (d(bVar)) {
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.f8450a) {
            try {
                if (d(bVar)) {
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
