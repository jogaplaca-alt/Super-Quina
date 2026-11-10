package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
final class G extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StringBuilder f5046b = new StringBuilder(128);

    G(String str) {
        this.f5045a = str;
    }

    private void g() {
        if (this.f5046b.length() > 0) {
            Log.d(this.f5045a, this.f5046b.toString());
            StringBuilder sb = this.f5046b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        g();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        g();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            char c3 = cArr[i3 + i5];
            if (c3 == '\n') {
                g();
            } else {
                this.f5046b.append(c3);
            }
        }
    }
}
