package L;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class a extends c {
    public a f(int i3, ByteBuffer byteBuffer) {
        g(i3, byteBuffer);
        return this;
    }

    public void g(int i3, ByteBuffer byteBuffer) {
        c(i3, byteBuffer);
    }

    public int h(int i3) {
        int iB = b(16);
        if (iB != 0) {
            return this.f1223b.getInt(d(iB) + (i3 * 4));
        }
        return 0;
    }

    public int i() {
        int iB = b(16);
        if (iB != 0) {
            return e(iB);
        }
        return 0;
    }

    public boolean j() {
        int iB = b(6);
        return (iB == 0 || this.f1223b.get(iB + this.f1222a) == 0) ? false : true;
    }

    public short k() {
        int iB = b(14);
        if (iB != 0) {
            return this.f1223b.getShort(iB + this.f1222a);
        }
        return (short) 0;
    }

    public int l() {
        int iB = b(4);
        if (iB != 0) {
            return this.f1223b.getInt(iB + this.f1222a);
        }
        return 0;
    }

    public short m() {
        int iB = b(8);
        if (iB != 0) {
            return this.f1223b.getShort(iB + this.f1222a);
        }
        return (short) 0;
    }

    public short n() {
        int iB = b(12);
        if (iB != 0) {
            return this.f1223b.getShort(iB + this.f1222a);
        }
        return (short) 0;
    }
}
