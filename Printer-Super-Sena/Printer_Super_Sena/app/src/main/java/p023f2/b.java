package p023f2;

import java.nio.ByteBuffer;
import p011c2.c;
import p015d2.d;

/* JADX INFO: loaded from: classes.dex */
public class b extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f9562i;

    public b() {
        super(c.CLOSING);
        r("");
        q(1000);
    }

    private void s() {
        byte[] bArrF = i2.c.f(this.f9562i);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(this.f9561h);
        byteBufferAllocate.position(2);
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(bArrF.length + 2);
        byteBufferAllocate2.put(byteBufferAllocate);
        byteBufferAllocate2.put(bArrF);
        byteBufferAllocate2.rewind();
        super.j(byteBufferAllocate2);
    }

    private void t(ByteBuffer byteBuffer, int i3) {
        try {
            try {
                byteBuffer.position(byteBuffer.position() + 2);
                this.f9562i = i2.c.e(byteBuffer);
                byteBuffer.position(i3);
            } catch (IllegalArgumentException unused) {
                throw new p015d2.c(1007);
            }
        } catch (Throwable th) {
            byteBuffer.position(i3);
            throw th;
        }
    }

    @Override // p023f2.g
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f9561h != bVar.f9561h) {
            return false;
        }
        String str = this.f9562i;
        String str2 = bVar.f9562i;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    @Override // p023f2.g, p023f2.f
    public ByteBuffer f() {
        return this.f9561h == 1005 ? i2.b.a() : super.f();
    }

    @Override // p023f2.d, p023f2.g
    public void h() throws p015d2.c {
        super.h();
        if (this.f9561h == 1007 && this.f9562i.isEmpty()) {
            throw new p015d2.c(1007, "Received text is no valid utf8 string!");
        }
        if (this.f9561h == 1005 && this.f9562i.length() > 0) {
            throw new p015d2.c(1002, "A close frame must have a closecode if it has a reason");
        }
        int i3 = this.f9561h;
        if (i3 > 1015 && i3 < 3000) {
            throw new p015d2.c(1002, "Trying to send an illegal close code!");
        }
        if (i3 == 1006 || i3 == 1015 || i3 == 1005 || i3 > 4999 || i3 < 1000 || i3 == 1004) {
            throw new d("closecode must not be sent over the wire: " + this.f9561h);
        }
    }

    @Override // p023f2.g
    public int hashCode() {
        int iHashCode = ((super.hashCode() * 31) + this.f9561h) * 31;
        String str = this.f9562i;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    @Override // p023f2.g
    public void j(ByteBuffer byteBuffer) {
        this.f9561h = 1005;
        this.f9562i = "";
        byteBuffer.mark();
        if (byteBuffer.remaining() == 0) {
            this.f9561h = 1000;
            return;
        }
        if (byteBuffer.remaining() == 1) {
            this.f9561h = 1002;
            return;
        }
        if (byteBuffer.remaining() >= 2) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.position(2);
            byteBufferAllocate.putShort(byteBuffer.getShort());
            byteBufferAllocate.position(0);
            this.f9561h = byteBufferAllocate.getInt();
        }
        byteBuffer.reset();
        try {
            t(byteBuffer, byteBuffer.position());
        } catch (p015d2.c unused) {
            this.f9561h = 1007;
            this.f9562i = null;
        }
    }

    public int o() {
        return this.f9561h;
    }

    public String p() {
        return this.f9562i;
    }

    public void q(int i3) {
        this.f9561h = i3;
        if (i3 == 1015) {
            this.f9561h = 1005;
            this.f9562i = "";
        }
        s();
    }

    public void r(String str) {
        if (str == null) {
            str = "";
        }
        this.f9562i = str;
        s();
    }

    @Override // p023f2.g
    public String toString() {
        return super.toString() + "code: " + this.f9561h;
    }
}
