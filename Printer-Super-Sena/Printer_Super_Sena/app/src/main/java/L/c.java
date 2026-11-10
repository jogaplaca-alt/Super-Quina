package L;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f1222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ByteBuffer f1223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    d f1226e = d.a();

    protected int a(int i3) {
        return i3 + this.f1223b.getInt(i3);
    }

    protected int b(int i3) {
        if (i3 < this.f1225d) {
            return this.f1223b.getShort(this.f1224c + i3);
        }
        return 0;
    }

    protected void c(int i3, ByteBuffer byteBuffer) {
        this.f1223b = byteBuffer;
        if (byteBuffer == null) {
            this.f1222a = 0;
            this.f1224c = 0;
            this.f1225d = 0;
        } else {
            this.f1222a = i3;
            int i4 = i3 - byteBuffer.getInt(i3);
            this.f1224c = i4;
            this.f1225d = this.f1223b.getShort(i4);
        }
    }

    protected int d(int i3) {
        int i4 = i3 + this.f1222a;
        return i4 + this.f1223b.getInt(i4) + 4;
    }

    protected int e(int i3) {
        int i4 = i3 + this.f1222a;
        return this.f1223b.getInt(i4 + this.f1223b.getInt(i4));
    }
}
