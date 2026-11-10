package p007b2;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.java_websocket.d;
import p011c2.c;
import p011c2.e;
import p023f2.f;
import p023f2.g;
import p023f2.j;
import p027g2.h;
import p027g2.i;

/* JADX INFO: loaded from: classes.dex */
public class b extends p007b2.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j2.a f6942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private p019e2.b f6943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p019e2.b f6944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f6945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private p019e2.b f6946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private h2.a f6947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List f6948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private f f6949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f6950k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ByteBuffer f6951l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final SecureRandom f6952m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f6953n;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f6955b;

        a(int i3, int i4) {
            this.f6954a = i3;
            this.f6955b = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int c() {
            return this.f6954a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int d() {
            return this.f6955b;
        }
    }

    public b() {
        this(Collections.emptyList());
    }

    private void A() throws p015d2.f {
        long jG = G();
        if (jG <= this.f6953n) {
            return;
        }
        B();
        this.f6942c.f("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(this.f6953n), Long.valueOf(jG));
        throw new p015d2.f(this.f6953n);
    }

    private void B() {
        synchronized (this.f6950k) {
            this.f6950k.clear();
        }
    }

    private p011c2.b C(String str) {
        for (h2.a aVar : this.f6948i) {
            if (aVar.b(str)) {
                this.f6947h = aVar;
                this.f6942c.d("acceptHandshake - Matching protocol found: {}", aVar);
                return p011c2.b.MATCHED;
            }
        }
        return p011c2.b.NOT_MATCHED;
    }

    private ByteBuffer D(f fVar) {
        ByteBuffer byteBufferF = fVar.f();
        int i3 = 0;
        boolean z3 = this.f6940a == e.CLIENT;
        int iQ = Q(byteBufferF);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((iQ > 1 ? iQ + 1 : iQ) + 1 + (z3 ? 4 : 0) + byteBufferF.remaining());
        byte bE = (byte) (E(fVar.a()) | ((byte) (fVar.d() ? -128 : 0)));
        if (fVar.b()) {
            bE = (byte) (bE | O(1));
        }
        if (fVar.e()) {
            bE = (byte) (bE | O(2));
        }
        if (fVar.c()) {
            bE = (byte) (O(3) | bE);
        }
        byteBufferAllocate.put(bE);
        byte[] bArrY = Y(byteBufferF.remaining(), iQ);
        if (iQ == 1) {
            byteBufferAllocate.put((byte) (bArrY[0] | K(z3)));
        } else if (iQ == 2) {
            byteBufferAllocate.put((byte) (K(z3) | 126));
            byteBufferAllocate.put(bArrY);
        } else {
            if (iQ != 8) {
                throw new IllegalStateException("Size representation not supported/specified");
            }
            byteBufferAllocate.put((byte) (K(z3) | 127));
            byteBufferAllocate.put(bArrY);
        }
        if (z3) {
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
            byteBufferAllocate2.putInt(this.f6952m.nextInt());
            byteBufferAllocate.put(byteBufferAllocate2.array());
            while (byteBufferF.hasRemaining()) {
                byteBufferAllocate.put((byte) (byteBufferF.get() ^ byteBufferAllocate2.get(i3 % 4)));
                i3++;
            }
        } else {
            byteBufferAllocate.put(byteBufferF);
            byteBufferF.flip();
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private byte E(c cVar) {
        if (cVar == c.CONTINUOUS) {
            return (byte) 0;
        }
        if (cVar == c.TEXT) {
            return (byte) 1;
        }
        if (cVar == c.BINARY) {
            return (byte) 2;
        }
        if (cVar == c.CLOSING) {
            return (byte) 8;
        }
        if (cVar == c.PING) {
            return (byte) 9;
        }
        if (cVar == c.PONG) {
            return (byte) 10;
        }
        throw new IllegalArgumentException("Don't know how to handle " + cVar.toString());
    }

    private String F(String str) {
        try {
            return i2.a.g(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e3) {
            throw new IllegalStateException(e3);
        }
    }

    private long G() {
        long jLimit;
        synchronized (this.f6950k) {
            try {
                Iterator it = this.f6950k.iterator();
                jLimit = 0;
                while (it.hasNext()) {
                    jLimit += (long) ((ByteBuffer) it.next()).limit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jLimit;
    }

    private byte K(boolean z3) {
        return z3 ? (byte) -128 : (byte) 0;
    }

    private ByteBuffer M() {
        ByteBuffer byteBufferAllocate;
        synchronized (this.f6950k) {
            try {
                Iterator it = this.f6950k.iterator();
                long jLimit = 0;
                while (it.hasNext()) {
                    jLimit += (long) ((ByteBuffer) it.next()).limit();
                }
                A();
                byteBufferAllocate = ByteBuffer.allocate((int) jLimit);
                Iterator it2 = this.f6950k.iterator();
                while (it2.hasNext()) {
                    byteBufferAllocate.put((ByteBuffer) it2.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private byte O(int i3) {
        if (i3 == 1) {
            return (byte) 64;
        }
        if (i3 != 2) {
            return i3 != 3 ? (byte) 0 : (byte) 16;
        }
        return (byte) 32;
    }

    private String P() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private int Q(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 125) {
            return 1;
        }
        return byteBuffer.remaining() <= 65535 ? 2 : 8;
    }

    private void R(d dVar, RuntimeException runtimeException) {
        this.f6942c.e("Runtime exception during onWebsocketMessage", runtimeException);
        dVar.v().onWebsocketError(dVar, runtimeException);
    }

    private void S(d dVar, f fVar) {
        try {
            dVar.v().onWebsocketMessage(dVar, fVar.f());
        } catch (RuntimeException e3) {
            R(dVar, e3);
        }
    }

    private void T(d dVar, f fVar) {
        int iO;
        String strP;
        if (fVar instanceof p023f2.b) {
            p023f2.b bVar = (p023f2.b) fVar;
            iO = bVar.o();
            strP = bVar.p();
        } else {
            iO = 1005;
            strP = "";
        }
        if (dVar.t() == p011c2.d.CLOSING) {
            dVar.f(iO, strP, true);
        } else if (l() == p011c2.a.TWOWAY) {
            dVar.c(iO, strP, true);
        } else {
            dVar.n(iO, strP, false);
        }
    }

    private void U(d dVar, f fVar, c cVar) throws p015d2.c {
        c cVar2 = c.CONTINUOUS;
        if (cVar != cVar2) {
            W(fVar);
        } else if (fVar.d()) {
            V(dVar, fVar);
        } else if (this.f6949j == null) {
            this.f6942c.a("Protocol error: Continuous frame sequence was not started.");
            throw new p015d2.c(1002, "Continuous frame sequence was not started.");
        }
        if (cVar == c.TEXT && !i2.c.b(fVar.f())) {
            this.f6942c.a("Protocol error: Payload is not UTF8");
            throw new p015d2.c(1007);
        }
        if (cVar != cVar2 || this.f6949j == null) {
            return;
        }
        z(fVar.f());
    }

    private void V(d dVar, f fVar) throws p015d2.c {
        if (this.f6949j == null) {
            this.f6942c.g("Protocol error: Previous continuous frame sequence not completed.");
            throw new p015d2.c(1002, "Continuous frame sequence was not started.");
        }
        z(fVar.f());
        A();
        if (this.f6949j.a() == c.TEXT) {
            ((g) this.f6949j).j(M());
            ((g) this.f6949j).h();
            try {
                dVar.v().onWebsocketMessage(dVar, i2.c.e(this.f6949j.f()));
            } catch (RuntimeException e3) {
                R(dVar, e3);
            }
        } else if (this.f6949j.a() == c.BINARY) {
            ((g) this.f6949j).j(M());
            ((g) this.f6949j).h();
            try {
                dVar.v().onWebsocketMessage(dVar, this.f6949j.f());
            } catch (RuntimeException e4) {
                R(dVar, e4);
            }
        }
        this.f6949j = null;
        B();
    }

    private void W(f fVar) throws p015d2.c {
        if (this.f6949j != null) {
            this.f6942c.g("Protocol error: Previous continuous frame sequence not completed.");
            throw new p015d2.c(1002, "Previous continuous frame sequence not completed.");
        }
        this.f6949j = fVar;
        z(fVar.f());
        A();
    }

    private void X(d dVar, f fVar) {
        try {
            dVar.v().onWebsocketMessage(dVar, i2.c.e(fVar.f()));
        } catch (RuntimeException e3) {
            R(dVar, e3);
        }
    }

    private byte[] Y(long j3, int i3) {
        byte[] bArr = new byte[i3];
        int i4 = (i3 * 8) - 8;
        for (int i5 = 0; i5 < i3; i5++) {
            bArr[i5] = (byte) (j3 >>> (i4 - (i5 * 8)));
        }
        return bArr;
    }

    private c Z(byte b3) throws p015d2.d {
        if (b3 == 0) {
            return c.CONTINUOUS;
        }
        if (b3 == 1) {
            return c.TEXT;
        }
        if (b3 == 2) {
            return c.BINARY;
        }
        switch (b3) {
            case 8:
                return c.CLOSING;
            case 9:
                return c.PING;
            case 10:
                return c.PONG;
            default:
                throw new p015d2.d("Unknown opcode " + ((int) b3));
        }
    }

    private f a0(ByteBuffer byteBuffer) throws p015d2.f, p015d2.d, p015d2.a {
        if (byteBuffer == null) {
            throw new IllegalArgumentException();
        }
        int iRemaining = byteBuffer.remaining();
        int iD = 2;
        c0(iRemaining, 2);
        byte b3 = byteBuffer.get();
        boolean z3 = (b3 >> 8) != 0;
        boolean z4 = (b3 & 64) != 0;
        boolean z5 = (b3 & 32) != 0;
        boolean z6 = (b3 & 16) != 0;
        byte b4 = byteBuffer.get();
        boolean z7 = (b4 & (-128)) != 0;
        int iC = (byte) (b4 & 127);
        c cVarZ = Z((byte) (b3 & 15));
        if (iC < 0 || iC > 125) {
            a aVarD0 = d0(byteBuffer, cVarZ, iC, iRemaining, 2);
            iC = aVarD0.c();
            iD = aVarD0.d();
        }
        b0(iC);
        c0(iRemaining, iD + (z7 ? 4 : 0) + iC);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(d(iC));
        if (z7) {
            byte[] bArr = new byte[4];
            byteBuffer.get(bArr);
            for (int i3 = 0; i3 < iC; i3++) {
                byteBufferAllocate.put((byte) (byteBuffer.get() ^ bArr[i3 % 4]));
            }
        } else {
            byteBufferAllocate.put(byteBuffer.array(), byteBuffer.position(), byteBufferAllocate.limit());
            byteBuffer.position(byteBuffer.position() + byteBufferAllocate.limit());
        }
        g gVarG = g.g(cVarZ);
        gVarG.i(z3);
        gVarG.k(z4);
        gVarG.l(z5);
        gVarG.m(z6);
        byteBufferAllocate.flip();
        gVarG.j(byteBufferAllocate);
        if (gVarG.a() != c.CONTINUOUS) {
            if (gVarG.b() || gVarG.e() || gVarG.c()) {
                this.f6946g = H();
            } else {
                this.f6946g = this.f6944e;
            }
        }
        if (this.f6946g == null) {
            this.f6946g = this.f6944e;
        }
        this.f6946g.f(gVarG);
        this.f6946g.d(gVarG);
        if (this.f6942c.c()) {
            this.f6942c.f("afterDecoding({}): {}", Integer.valueOf(gVarG.f().remaining()), gVarG.f().remaining() > 1000 ? "too big to display" : new String(gVarG.f().array()));
        }
        gVarG.h();
        return gVarG;
    }

    private void b0(long j3) throws p015d2.f {
        if (j3 > 2147483647L) {
            this.f6942c.g("Limit exedeed: Payloadsize is to big...");
            throw new p015d2.f("Payloadsize is to big...");
        }
        int i3 = this.f6953n;
        if (j3 > i3) {
            this.f6942c.f("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(i3), Long.valueOf(j3));
            throw new p015d2.f("Payload limit reached.", this.f6953n);
        }
        if (j3 >= 0) {
            return;
        }
        this.f6942c.g("Limit underflow: Payloadsize is to little...");
        throw new p015d2.f("Payloadsize is to little...");
    }

    private void c0(int i3, int i4) throws p015d2.a {
        if (i3 >= i4) {
            return;
        }
        this.f6942c.g("Incomplete frame: maxpacketsize < realpacketsize");
        throw new p015d2.a(i4);
    }

    private a d0(ByteBuffer byteBuffer, c cVar, int i3, int i4, int i5) throws p015d2.f, p015d2.d, p015d2.a {
        int i6;
        int iIntValue;
        if (cVar == c.PING || cVar == c.PONG || cVar == c.CLOSING) {
            this.f6942c.g("Invalid frame: more than 125 octets");
            throw new p015d2.d("more than 125 octets");
        }
        if (i3 == 126) {
            i6 = i5 + 2;
            c0(i4, i6);
            iIntValue = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
        } else {
            i6 = i5 + 8;
            c0(i4, i6);
            byte[] bArr = new byte[8];
            for (int i7 = 0; i7 < 8; i7++) {
                bArr[i7] = byteBuffer.get();
            }
            long jLongValue = new BigInteger(bArr).longValue();
            b0(jLongValue);
            iIntValue = (int) jLongValue;
        }
        return new a(iIntValue, i6);
    }

    private void z(ByteBuffer byteBuffer) {
        synchronized (this.f6950k) {
            this.f6950k.add(byteBuffer);
        }
    }

    public p019e2.b H() {
        return this.f6943d;
    }

    public List I() {
        return this.f6945f;
    }

    public List J() {
        return this.f6948i;
    }

    public int L() {
        return this.f6953n;
    }

    public h2.a N() {
        return this.f6947h;
    }

    @Override // p007b2.a
    public p011c2.b a(p027g2.a aVar, h hVar) {
        if (!c(hVar)) {
            this.f6942c.g("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return p011c2.b.NOT_MATCHED;
        }
        if (!aVar.a("Sec-WebSocket-Key") || !hVar.a("Sec-WebSocket-Accept")) {
            this.f6942c.g("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return p011c2.b.NOT_MATCHED;
        }
        if (!F(aVar.h("Sec-WebSocket-Key")).equals(hVar.h("Sec-WebSocket-Accept"))) {
            this.f6942c.g("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
            return p011c2.b.NOT_MATCHED;
        }
        p011c2.b bVar = p011c2.b.NOT_MATCHED;
        String strH = hVar.h("Sec-WebSocket-Extensions");
        for (p019e2.b bVar2 : this.f6945f) {
            if (bVar2.h(strH)) {
                this.f6943d = bVar2;
                bVar = p011c2.b.MATCHED;
                this.f6942c.d("acceptHandshakeAsClient - Matching extension found: {}", bVar2);
                break;
            }
        }
        p011c2.b bVarC = C(hVar.h("Sec-WebSocket-Protocol"));
        p011c2.b bVar3 = p011c2.b.MATCHED;
        if (bVarC == bVar3 && bVar == bVar3) {
            return bVar3;
        }
        this.f6942c.g("acceptHandshakeAsClient - No matching extension or protocol found.");
        return p011c2.b.NOT_MATCHED;
    }

    @Override // p007b2.a
    public p011c2.b b(p027g2.a aVar) {
        if (r(aVar) != 13) {
            this.f6942c.g("acceptHandshakeAsServer - Wrong websocket version.");
            return p011c2.b.NOT_MATCHED;
        }
        p011c2.b bVar = p011c2.b.NOT_MATCHED;
        String strH = aVar.h("Sec-WebSocket-Extensions");
        for (p019e2.b bVar2 : this.f6945f) {
            if (bVar2.b(strH)) {
                this.f6943d = bVar2;
                bVar = p011c2.b.MATCHED;
                this.f6942c.d("acceptHandshakeAsServer - Matching extension found: {}", bVar2);
                break;
            }
        }
        p011c2.b bVarC = C(aVar.h("Sec-WebSocket-Protocol"));
        p011c2.b bVar3 = p011c2.b.MATCHED;
        if (bVarC == bVar3 && bVar == bVar3) {
            return bVar3;
        }
        this.f6942c.g("acceptHandshakeAsServer - No matching extension or protocol found.");
        return p011c2.b.NOT_MATCHED;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f6953n != bVar.L()) {
            return false;
        }
        p019e2.b bVar2 = this.f6943d;
        if (bVar2 == null ? bVar.H() != null : !bVar2.equals(bVar.H())) {
            return false;
        }
        h2.a aVar = this.f6947h;
        h2.a aVarN = bVar.N();
        if (aVar != null) {
            return aVar.equals(aVarN);
        }
        return aVarN == null;
    }

    @Override // p007b2.a
    public p007b2.a f() {
        ArrayList arrayList = new ArrayList();
        Iterator it = I().iterator();
        while (it.hasNext()) {
            arrayList.add(((p019e2.b) it.next()).a());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = J().iterator();
        while (it2.hasNext()) {
            arrayList2.add(((h2.a) it2.next()).a());
        }
        return new b(arrayList, arrayList2, this.f6953n);
    }

    @Override // p007b2.a
    public ByteBuffer g(f fVar) {
        H().c(fVar);
        if (this.f6942c.c()) {
            this.f6942c.f("afterEnconding({}): {}", Integer.valueOf(fVar.f().remaining()), fVar.f().remaining() > 1000 ? "too big to display" : new String(fVar.f().array()));
        }
        return D(fVar);
    }

    @Override // p007b2.a
    public List h(String str, boolean z3) {
        j jVar = new j();
        jVar.j(ByteBuffer.wrap(i2.c.f(str)));
        jVar.n(z3);
        try {
            jVar.h();
            return Collections.singletonList(jVar);
        } catch (p015d2.c e3) {
            throw new p015d2.g(e3);
        }
    }

    public int hashCode() {
        p019e2.b bVar = this.f6943d;
        int iHashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
        h2.a aVar = this.f6947h;
        int iHashCode2 = (iHashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
        int i3 = this.f6953n;
        return iHashCode2 + (i3 ^ (i3 >>> 32));
    }

    @Override // p007b2.a
    public List i(ByteBuffer byteBuffer, boolean z3) {
        p023f2.a aVar = new p023f2.a();
        aVar.j(byteBuffer);
        aVar.n(z3);
        try {
            aVar.h();
            return Collections.singletonList(aVar);
        } catch (p015d2.c e3) {
            throw new p015d2.g(e3);
        }
    }

    @Override // p007b2.a
    public p011c2.a l() {
        return p011c2.a.TWOWAY;
    }

    @Override // p007b2.a
    public p027g2.b m(p027g2.b bVar) {
        bVar.b("Upgrade", "websocket");
        bVar.b("Connection", "Upgrade");
        byte[] bArr = new byte[16];
        this.f6952m.nextBytes(bArr);
        bVar.b("Sec-WebSocket-Key", i2.a.g(bArr));
        bVar.b("Sec-WebSocket-Version", "13");
        StringBuilder sb = new StringBuilder();
        for (p019e2.b bVar2 : this.f6945f) {
            if (bVar2.g() != null && bVar2.g().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.g());
            }
        }
        if (sb.length() != 0) {
            bVar.b("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (h2.a aVar : this.f6948i) {
            if (aVar.c().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.c());
            }
        }
        if (sb2.length() != 0) {
            bVar.b("Sec-WebSocket-Protocol", sb2.toString());
        }
        return bVar;
    }

    @Override // p007b2.a
    public p027g2.c n(p027g2.a aVar, i iVar) throws p015d2.e {
        iVar.b("Upgrade", "websocket");
        iVar.b("Connection", aVar.h("Connection"));
        String strH = aVar.h("Sec-WebSocket-Key");
        if (strH == null || "".equals(strH)) {
            throw new p015d2.e("missing Sec-WebSocket-Key");
        }
        iVar.b("Sec-WebSocket-Accept", F(strH));
        if (H().e().length() != 0) {
            iVar.b("Sec-WebSocket-Extensions", H().e());
        }
        if (N() != null && N().c().length() != 0) {
            iVar.b("Sec-WebSocket-Protocol", N().c());
        }
        iVar.j("Web Socket Protocol Handshake");
        iVar.b("Server", "TooTallNate Java-WebSocket");
        iVar.b("Date", P());
        return iVar;
    }

    @Override // p007b2.a
    public void o(d dVar, f fVar) throws p015d2.c {
        c cVarA = fVar.a();
        if (cVarA == c.CLOSING) {
            T(dVar, fVar);
            return;
        }
        if (cVarA == c.PING) {
            dVar.v().onWebsocketPing(dVar, fVar);
            return;
        }
        if (cVarA == c.PONG) {
            dVar.L();
            dVar.v().onWebsocketPong(dVar, fVar);
            return;
        }
        if (!fVar.d() || cVarA == c.CONTINUOUS) {
            U(dVar, fVar, cVarA);
            return;
        }
        if (this.f6949j != null) {
            this.f6942c.a("Protocol error: Continuous frame sequence not completed.");
            throw new p015d2.c(1002, "Continuous frame sequence not completed.");
        }
        if (cVarA == c.TEXT) {
            X(dVar, fVar);
        } else if (cVarA == c.BINARY) {
            S(dVar, fVar);
        } else {
            this.f6942c.a("non control or continious frame expected");
            throw new p015d2.c(1002, "non control or continious frame expected");
        }
    }

    @Override // p007b2.a
    public void s() {
        this.f6951l = null;
        p019e2.b bVar = this.f6943d;
        if (bVar != null) {
            bVar.i();
        }
        this.f6943d = new p019e2.a();
        this.f6947h = null;
    }

    @Override // p007b2.a
    public String toString() {
        String string = super.toString();
        if (H() != null) {
            string = string + " extension: " + H().toString();
        }
        if (N() != null) {
            string = string + " protocol: " + N().toString();
        }
        return string + " max frame size: " + this.f6953n;
    }

    @Override // p007b2.a
    public List u(ByteBuffer byteBuffer) {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.f6951l == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int iRemaining = byteBuffer.remaining();
                int iRemaining2 = this.f6951l.remaining();
                if (iRemaining2 <= iRemaining) {
                    this.f6951l.put(byteBuffer.array(), byteBuffer.position(), iRemaining2);
                    byteBuffer.position(byteBuffer.position() + iRemaining2);
                    linkedList.add(a0((ByteBuffer) this.f6951l.duplicate().position(0)));
                    this.f6951l = null;
                    break;
                }
                this.f6951l.put(byteBuffer.array(), byteBuffer.position(), iRemaining);
                byteBuffer.position(byteBuffer.position() + iRemaining);
                return Collections.emptyList();
            } catch (p015d2.a e3) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(d(e3.a()));
                this.f6951l.rewind();
                byteBufferAllocate.put(this.f6951l);
                this.f6951l = byteBufferAllocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(a0(byteBuffer));
            } catch (p015d2.a e4) {
                byteBuffer.reset();
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(d(e4.a()));
                this.f6951l = byteBufferAllocate2;
                byteBufferAllocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public b(List list) {
        this(list, Collections.singletonList(new h2.b("")));
    }

    public b(List list, List list2) {
        this(list, list2, Integer.MAX_VALUE);
    }

    public b(List list, List list2, int i3) {
        this.f6942c = j2.b.i(b.class);
        this.f6943d = new p019e2.a();
        this.f6944e = new p019e2.a();
        this.f6952m = new SecureRandom();
        if (list != null && list2 != null && i3 >= 1) {
            this.f6945f = new ArrayList(list.size());
            this.f6948i = new ArrayList(list2.size());
            this.f6950k = new ArrayList();
            Iterator it = list.iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                if (((p019e2.b) it.next()).getClass().equals(p019e2.a.class)) {
                    z3 = true;
                }
            }
            this.f6945f.addAll(list);
            if (!z3) {
                List list3 = this.f6945f;
                list3.add(list3.size(), this.f6943d);
            }
            this.f6948i.addAll(list2);
            this.f6953n = i3;
            this.f6946g = null;
            return;
        }
        throw new IllegalArgumentException();
    }
}
