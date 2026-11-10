package p007b2;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p011c2.c;
import p011c2.e;
import p015d2.b;
import p023f2.g;
import p023f2.j;
import p027g2.d;
import p027g2.f;
import p027g2.h;
import p027g2.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected e f6940a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected c f6941b = null;

    public static ByteBuffer p(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b3 = 48;
        while (byteBuffer.hasRemaining()) {
            byte b4 = byteBuffer.get();
            byteBufferAllocate.put(b4);
            if (b3 == 13 && b4 == 10) {
                byteBufferAllocate.limit(byteBufferAllocate.position() - 2);
                byteBufferAllocate.position(0);
                return byteBufferAllocate;
            }
            b3 = b4;
        }
        byteBuffer.position(byteBuffer.position() - byteBufferAllocate.position());
        return null;
    }

    public static String q(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferP = p(byteBuffer);
        if (byteBufferP == null) {
            return null;
        }
        return i2.c.d(byteBufferP.array(), 0, byteBufferP.limit());
    }

    public static p027g2.c w(ByteBuffer byteBuffer, e eVar) throws p015d2.e {
        String strQ = q(byteBuffer);
        if (strQ == null) {
            throw new b(byteBuffer.capacity() + 128);
        }
        String[] strArrSplit = strQ.split(" ", 3);
        if (strArrSplit.length != 3) {
            throw new p015d2.e();
        }
        p027g2.c cVarX = eVar == e.CLIENT ? x(strArrSplit, strQ) : y(strArrSplit, strQ);
        String strQ2 = q(byteBuffer);
        while (strQ2 != null && strQ2.length() > 0) {
            String[] strArrSplit2 = strQ2.split(":", 2);
            if (strArrSplit2.length != 2) {
                throw new p015d2.e("not an http header");
            }
            if (cVarX.a(strArrSplit2[0])) {
                cVarX.b(strArrSplit2[0], cVarX.h(strArrSplit2[0]) + "; " + strArrSplit2[1].replaceFirst("^ +", ""));
            } else {
                cVarX.b(strArrSplit2[0], strArrSplit2[1].replaceFirst("^ +", ""));
            }
            strQ2 = q(byteBuffer);
        }
        if (strQ2 != null) {
            return cVarX;
        }
        throw new b();
    }

    private static p027g2.c x(String[] strArr, String str) throws p015d2.e {
        if (!"101".equals(strArr[1])) {
            throw new p015d2.e(String.format("Invalid status code received: %s Status line: %s", strArr[1], str));
        }
        if (!"HTTP/1.1".equalsIgnoreCase(strArr[0])) {
            throw new p015d2.e(String.format("Invalid status line received: %s Status line: %s", strArr[0], str));
        }
        p027g2.e eVar = new p027g2.e();
        eVar.e(Short.parseShort(strArr[1]));
        eVar.j(strArr[2]);
        return eVar;
    }

    private static p027g2.c y(String[] strArr, String str) throws p015d2.e {
        if (!"GET".equalsIgnoreCase(strArr[0])) {
            throw new p015d2.e(String.format("Invalid request method received: %s Status line: %s", strArr[0], str));
        }
        if (!"HTTP/1.1".equalsIgnoreCase(strArr[2])) {
            throw new p015d2.e(String.format("Invalid status line received: %s Status line: %s", strArr[2], str));
        }
        d dVar = new d();
        dVar.f(strArr[1]);
        return dVar;
    }

    public abstract p011c2.b a(p027g2.a aVar, h hVar);

    public abstract p011c2.b b(p027g2.a aVar);

    protected boolean c(f fVar) {
        return fVar.h("Upgrade").equalsIgnoreCase("websocket") && fVar.h("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public int d(int i3) throws p015d2.c {
        if (i3 >= 0) {
            return i3;
        }
        throw new p015d2.c(1002, "Negative count");
    }

    public List e(c cVar, ByteBuffer byteBuffer, boolean z3) {
        g jVar;
        c cVar2 = c.BINARY;
        if (cVar != cVar2 && cVar != c.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.f6941b != null) {
            jVar = new p023f2.c();
        } else {
            this.f6941b = cVar;
            if (cVar == cVar2) {
                jVar = new p023f2.a();
            } else {
                jVar = cVar == c.TEXT ? new j() : null;
            }
        }
        jVar.j(byteBuffer);
        jVar.i(z3);
        try {
            jVar.h();
            if (z3) {
                this.f6941b = null;
            } else {
                this.f6941b = cVar;
            }
            return Collections.singletonList(jVar);
        } catch (p015d2.c e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public abstract a f();

    public abstract ByteBuffer g(p023f2.f fVar);

    public abstract List h(String str, boolean z3);

    public abstract List i(ByteBuffer byteBuffer, boolean z3);

    public List j(f fVar) {
        return k(fVar, true);
    }

    public List k(f fVar, boolean z3) {
        StringBuilder sb = new StringBuilder(100);
        if (fVar instanceof p027g2.a) {
            sb.append("GET ");
            sb.append(((p027g2.a) fVar).c());
            sb.append(" HTTP/1.1");
        } else {
            if (!(fVar instanceof h)) {
                throw new IllegalArgumentException("unknown role");
            }
            sb.append("HTTP/1.1 101 ");
            sb.append(((h) fVar).g());
        }
        sb.append("\r\n");
        Iterator itD = fVar.d();
        while (itD.hasNext()) {
            String str = (String) itD.next();
            String strH = fVar.h(str);
            sb.append(str);
            sb.append(": ");
            sb.append(strH);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] bArrA = i2.c.a(sb.toString());
        byte[] bArrI = z3 ? fVar.i() : null;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((bArrI == null ? 0 : bArrI.length) + bArrA.length);
        byteBufferAllocate.put(bArrA);
        if (bArrI != null) {
            byteBufferAllocate.put(bArrI);
        }
        byteBufferAllocate.flip();
        return Collections.singletonList(byteBufferAllocate);
    }

    public abstract p011c2.a l();

    public abstract p027g2.b m(p027g2.b bVar);

    public abstract p027g2.c n(p027g2.a aVar, i iVar);

    public abstract void o(org.java_websocket.d dVar, p023f2.f fVar);

    int r(f fVar) {
        String strH = fVar.h("Sec-WebSocket-Version");
        if (strH.length() > 0) {
            try {
                return new Integer(strH.trim()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public abstract void s();

    public void t(e eVar) {
        this.f6940a = eVar;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public abstract List u(ByteBuffer byteBuffer);

    public f v(ByteBuffer byteBuffer) {
        return w(byteBuffer, this.f6940a);
    }
}
