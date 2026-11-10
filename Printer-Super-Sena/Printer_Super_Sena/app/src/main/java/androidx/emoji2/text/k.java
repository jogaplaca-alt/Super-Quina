package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
abstract class k {

    private static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f4997a;

        a(ByteBuffer byteBuffer) {
            this.f4997a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.k.c
        public long a() {
            return k.c(this.f4997a.getInt());
        }

        @Override // androidx.emoji2.text.k.c
        public void b(int i3) {
            ByteBuffer byteBuffer = this.f4997a;
            byteBuffer.position(byteBuffer.position() + i3);
        }

        @Override // androidx.emoji2.text.k.c
        public int c() {
            return this.f4997a.getInt();
        }

        @Override // androidx.emoji2.text.k.c
        public long getPosition() {
            return this.f4997a.position();
        }

        @Override // androidx.emoji2.text.k.c
        public int readUnsignedShort() {
            return k.d(this.f4997a.getShort());
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f4998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f4999b;

        b(long j3, long j4) {
            this.f4998a = j3;
            this.f4999b = j4;
        }

        long a() {
            return this.f4998a;
        }
    }

    private interface c {
        long a();

        void b(int i3);

        int c();

        long getPosition();

        int readUnsignedShort();
    }

    private static b a(c cVar) throws IOException {
        long jA;
        cVar.b(4);
        int unsignedShort = cVar.readUnsignedShort();
        if (unsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.b(6);
        int i3 = 0;
        while (true) {
            if (i3 >= unsignedShort) {
                jA = -1;
                break;
            }
            int iC = cVar.c();
            cVar.b(4);
            jA = cVar.a();
            cVar.b(4);
            if (1835365473 == iC) {
                break;
            }
            i3++;
        }
        if (jA != -1) {
            cVar.b((int) (jA - cVar.getPosition()));
            cVar.b(12);
            long jA2 = cVar.a();
            for (int i4 = 0; i4 < jA2; i4++) {
                int iC2 = cVar.c();
                long jA3 = cVar.a();
                long jA4 = cVar.a();
                if (1164798569 == iC2 || 1701669481 == iC2) {
                    return new b(jA3 + jA, jA4);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    static L.b b(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) a(new a(byteBufferDuplicate)).a());
        return L.b.h(byteBufferDuplicate);
    }

    static long c(int i3) {
        return ((long) i3) & 4294967295L;
    }

    static int d(short s3) {
        return s3 & 65535;
    }
}
