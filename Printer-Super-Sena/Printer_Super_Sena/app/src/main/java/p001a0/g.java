package p001a0;

import S1.k;
import Z.i;
import android.database.sqlite.SQLiteProgram;

/* JADX INFO: loaded from: classes.dex */
public class g implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteProgram f2218a;

    public g(SQLiteProgram sQLiteProgram) {
        k.e(sQLiteProgram, "delegate");
        this.f2218a = sQLiteProgram;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2218a.close();
    }

    @Override // Z.i
    public void k(int i3, String str) {
        k.e(str, "value");
        this.f2218a.bindString(i3, str);
    }

    @Override // Z.i
    public void l(int i3, long j3) {
        this.f2218a.bindLong(i3, j3);
    }

    @Override // Z.i
    public void u(int i3, byte[] bArr) {
        k.e(bArr, "value");
        this.f2218a.bindBlob(i3, bArr);
    }

    @Override // Z.i
    public void x(int i3) {
        this.f2218a.bindNull(i3);
    }

    @Override // Z.i
    public void z(int i3, double d3) {
        this.f2218a.bindDouble(i3, d3);
    }
}
