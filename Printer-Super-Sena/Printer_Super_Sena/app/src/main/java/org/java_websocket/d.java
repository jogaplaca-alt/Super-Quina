package org.java_websocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import p015d2.h;
import p027g2.f;

/* JADX INFO: loaded from: classes.dex */
public class d implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BlockingQueue f10441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BlockingQueue f10442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f10443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SelectionKey f10444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ByteChannel f10445f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List f10448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private p007b2.a f10449j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private p011c2.e f10450k;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Object f10459t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j2.a f10440a = j2.b.i(d.class);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10446g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile p011c2.d f10447h = p011c2.d.NOT_YET_CONNECTED;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ByteBuffer f10451l = ByteBuffer.allocate(0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private p027g2.a f10452m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f10453n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Integer f10454o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Boolean f10455p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f10456q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f10457r = System.nanoTime();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Object f10458s = new Object();

    public d(e eVar, p007b2.a aVar) {
        this.f10449j = null;
        if (eVar == null || (aVar == null && this.f10450k == p011c2.e.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.f10441b = new LinkedBlockingQueue();
        this.f10442c = new LinkedBlockingQueue();
        this.f10443d = eVar;
        this.f10450k = p011c2.e.CLIENT;
        if (aVar != null) {
            this.f10449j = aVar.f();
        }
    }

    private void B(f fVar) {
        this.f10440a.d("open using draft: {}", this.f10449j);
        this.f10447h = p011c2.d.OPEN;
        L();
        try {
            this.f10443d.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e3) {
            this.f10443d.onWebsocketError(this, e3);
        }
    }

    private void E(Collection collection) {
        if (!A()) {
            throw new h();
        }
        if (collection == null) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            p023f2.f fVar = (p023f2.f) it.next();
            this.f10440a.d("send frame: {}", fVar);
            arrayList.add(this.f10449j.g(fVar));
        }
        N(arrayList);
    }

    private void M(ByteBuffer byteBuffer) {
        this.f10440a.f("write({}): {}", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
        this.f10441b.add(byteBuffer);
        this.f10443d.onWriteDemand(this);
    }

    private void N(List list) {
        synchronized (this.f10458s) {
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    M((ByteBuffer) it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void h(RuntimeException runtimeException) {
        M(o(500));
        n(-1, runtimeException.getMessage(), false);
    }

    private void i(p015d2.c cVar) {
        M(o(404));
        n(cVar.a(), cVar.getMessage(), false);
    }

    private void k(ByteBuffer byteBuffer) throws Throwable {
        try {
            for (p023f2.f fVar : this.f10449j.u(byteBuffer)) {
                this.f10440a.d("matched frame: {}", fVar);
                this.f10449j.o(this, fVar);
            }
        } catch (p015d2.f e3) {
            if (e3.b() == Integer.MAX_VALUE) {
                this.f10440a.e("Closing due to invalid size of frame", e3);
                this.f10443d.onWebsocketError(this, e3);
            }
            d(e3);
        } catch (p015d2.c e4) {
            this.f10440a.e("Closing due to invalid data in frame", e4);
            this.f10443d.onWebsocketError(this, e4);
            d(e4);
        } catch (LinkageError e5) {
            e = e5;
            this.f10440a.a("Got fatal error during frame processing");
            throw e;
        } catch (ThreadDeath e6) {
            e = e6;
            this.f10440a.a("Got fatal error during frame processing");
            throw e;
        } catch (VirtualMachineError e7) {
            e = e7;
            this.f10440a.a("Got fatal error during frame processing");
            throw e;
        } catch (Error e8) {
            this.f10440a.a("Closing web socket due to an error during frame processing");
            this.f10443d.onWebsocketError(this, new Exception(e8));
            b(1011, "Got error " + e8.getClass().getName());
        }
    }

    private boolean l(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        if (this.f10451l.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.f10451l.remaining() < byteBuffer.remaining()) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.f10451l.capacity() + byteBuffer.remaining());
                this.f10451l.flip();
                byteBufferAllocate.put(this.f10451l);
                this.f10451l = byteBufferAllocate;
            }
            this.f10451l.put(byteBuffer);
            this.f10451l.flip();
            byteBuffer2 = this.f10451l;
        }
        byteBuffer2.mark();
        try {
            try {
                p011c2.e eVar = this.f10450k;
                if (eVar != p011c2.e.SERVER) {
                    if (eVar == p011c2.e.CLIENT) {
                        this.f10449j.t(eVar);
                        f fVarV = this.f10449j.v(byteBuffer2);
                        if (!(fVarV instanceof p027g2.h)) {
                            this.f10440a.g("Closing due to protocol error: wrong http function");
                            n(1002, "wrong http function", false);
                            return false;
                        }
                        p027g2.h hVar = (p027g2.h) fVarV;
                        if (this.f10449j.a(this.f10452m, hVar) == p011c2.b.MATCHED) {
                            try {
                                this.f10443d.onWebsocketHandshakeReceivedAsClient(this, this.f10452m, hVar);
                                B(hVar);
                                return true;
                            } catch (p015d2.c e3) {
                                this.f10440a.b("Closing due to invalid data exception. Possible handshake rejection", e3);
                                n(e3.a(), e3.getMessage(), false);
                                return false;
                            } catch (RuntimeException e4) {
                                this.f10440a.e("Closing since client was never connected", e4);
                                this.f10443d.onWebsocketError(this, e4);
                                n(-1, e4.getMessage(), false);
                                return false;
                            }
                        }
                        this.f10440a.d("Closing due to protocol error: draft {} refuses handshake", this.f10449j);
                        b(1002, "draft " + this.f10449j + " refuses handshake");
                    }
                    return false;
                }
                p007b2.a aVar = this.f10449j;
                if (aVar != null) {
                    f fVarV2 = aVar.v(byteBuffer2);
                    if (!(fVarV2 instanceof p027g2.a)) {
                        this.f10440a.g("Closing due to protocol error: wrong http function");
                        n(1002, "wrong http function", false);
                        return false;
                    }
                    p027g2.a aVar2 = (p027g2.a) fVarV2;
                    if (this.f10449j.b(aVar2) == p011c2.b.MATCHED) {
                        B(aVar2);
                        return true;
                    }
                    this.f10440a.g("Closing due to protocol error: the handshake did finally not match");
                    b(1002, "the handshake did finally not match");
                    return false;
                }
                Iterator it = this.f10448i.iterator();
                while (it.hasNext()) {
                    p007b2.a aVarF = ((p007b2.a) it.next()).f();
                    try {
                        aVarF.t(this.f10450k);
                        byteBuffer2.reset();
                        f fVarV3 = aVarF.v(byteBuffer2);
                        if (!(fVarV3 instanceof p027g2.a)) {
                            this.f10440a.g("Closing due to wrong handshake");
                            i(new p015d2.c(1002, "wrong http function"));
                            return false;
                        }
                        p027g2.a aVar3 = (p027g2.a) fVarV3;
                        if (aVarF.b(aVar3) == p011c2.b.MATCHED) {
                            this.f10456q = aVar3.c();
                            try {
                                N(aVarF.j(aVarF.n(aVar3, this.f10443d.onWebsocketHandshakeReceivedAsServer(this, aVarF, aVar3))));
                                this.f10449j = aVarF;
                                B(aVar3);
                                return true;
                            } catch (p015d2.c e5) {
                                this.f10440a.b("Closing due to wrong handshake. Possible handshake rejection", e5);
                                i(e5);
                                return false;
                            } catch (RuntimeException e6) {
                                this.f10440a.e("Closing due to internal server error", e6);
                                this.f10443d.onWebsocketError(this, e6);
                                h(e6);
                                return false;
                            }
                        }
                    } catch (p015d2.e unused) {
                    }
                }
                if (this.f10449j == null) {
                    this.f10440a.g("Closing due to protocol error: no draft matches");
                    i(new p015d2.c(1002, "no draft matches"));
                }
                return false;
            } catch (p015d2.e e7) {
                this.f10440a.b("Closing due to invalid handshake", e7);
                d(e7);
            }
        } catch (p015d2.b e8) {
            if (this.f10451l.capacity() == 0) {
                byteBuffer2.reset();
                int iA = e8.a();
                if (iA == 0) {
                    iA = byteBuffer2.capacity() + 16;
                }
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(iA);
                this.f10451l = byteBufferAllocate2;
                byteBufferAllocate2.put(byteBuffer);
            } else {
                ByteBuffer byteBuffer3 = this.f10451l;
                byteBuffer3.position(byteBuffer3.limit());
                ByteBuffer byteBuffer4 = this.f10451l;
                byteBuffer4.limit(byteBuffer4.capacity());
            }
        }
    }

    private ByteBuffer o(int i3) {
        String str = i3 != 404 ? "500 Internal Server Error" : "404 WebSocket Upgrade Failure";
        return ByteBuffer.wrap(i2.c.a("HTTP/1.1 " + str + "\r\nContent-Type: text/html\r\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public boolean A() {
        return this.f10447h == p011c2.d.OPEN;
    }

    public void C(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        E(this.f10449j.h(str, this.f10450k == p011c2.e.CLIENT));
    }

    public void D(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        E(this.f10449j.i(byteBuffer, this.f10450k == p011c2.e.CLIENT));
    }

    public void F(byte[] bArr) {
        D(ByteBuffer.wrap(bArr));
    }

    public void G(p011c2.c cVar, ByteBuffer byteBuffer, boolean z3) {
        E(this.f10449j.e(cVar, byteBuffer, z3));
    }

    public void H(Collection collection) {
        E(collection);
    }

    public void I() {
        p023f2.h hVarOnPreparePing = this.f10443d.onPreparePing(this);
        if (hVarOnPreparePing == null) {
            throw new NullPointerException("onPreparePing(WebSocket) returned null. PingFrame to sent can't be null.");
        }
        sendFrame(hVarOnPreparePing);
    }

    public void J(Object obj) {
        this.f10459t = obj;
    }

    public void K(p027g2.b bVar) throws p015d2.e {
        this.f10452m = this.f10449j.m(bVar);
        this.f10456q = bVar.c();
        try {
            this.f10443d.onWebsocketHandshakeSentAsClient(this, this.f10452m);
            N(this.f10449j.j(this.f10452m));
        } catch (p015d2.c unused) {
            throw new p015d2.e("Handshake data rejected by client.");
        } catch (RuntimeException e3) {
            this.f10440a.e("Exception in startHandshake", e3);
            this.f10443d.onWebsocketError(this, e3);
            throw new p015d2.e("rejected because of " + e3);
        }
    }

    public void L() {
        this.f10457r = System.nanoTime();
    }

    public void a(int i3) {
        c(i3, "", false);
    }

    public void b(int i3, String str) {
        c(i3, str, false);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0041 A[Catch: all -> 0x001f, c -> 0x0033, TRY_LEAVE, TryCatch #1 {c -> 0x0033, blocks: (B:19:0x002d, B:25:0x003b, B:27:0x0041, B:24:0x0036), top: B:45:0x002d, outer: #2 }] */
    public synchronized void c(int i3, String str, boolean z3) {
        p011c2.d dVar = this.f10447h;
        p011c2.d dVar2 = p011c2.d.CLOSING;
        if (dVar == dVar2 || this.f10447h == p011c2.d.CLOSED) {
            return;
        }
        if (this.f10447h == p011c2.d.OPEN) {
            if (i3 == 1006) {
                this.f10447h = dVar2;
                n(i3, str, false);
                return;
            }
            if (this.f10449j.l() != p011c2.a.NONE) {
                if (!z3) {
                    try {
                        try {
                            this.f10443d.onWebsocketCloseInitiated(this, i3, str);
                        } catch (RuntimeException e3) {
                            this.f10443d.onWebsocketError(this, e3);
                        }
                        if (A()) {
                            p023f2.b bVar = new p023f2.b();
                            bVar.r(str);
                            bVar.q(i3);
                            bVar.h();
                            sendFrame(bVar);
                        }
                    } catch (p015d2.c e4) {
                        this.f10440a.e("generated frame is invalid", e4);
                        this.f10443d.onWebsocketError(this, e4);
                        n(1006, "generated frame is invalid", false);
                    }
                } else if (A()) {
                    p023f2.b bVar2 = new p023f2.b();
                    bVar2.r(str);
                    bVar2.q(i3);
                    bVar2.h();
                    sendFrame(bVar2);
                }
            }
            n(i3, str, z3);
        } else if (i3 == -3) {
            n(-3, str, true);
        } else if (i3 == 1002) {
            n(i3, str, z3);
        } else {
            n(-1, str, false);
        }
        this.f10447h = p011c2.d.CLOSING;
        this.f10451l = null;
    }

    public void d(p015d2.c cVar) {
        c(cVar.a(), cVar.getMessage(), false);
    }

    public void e(int i3, String str) {
        f(i3, str, false);
    }

    public synchronized void f(int i3, String str, boolean z3) {
        try {
            if (this.f10447h == p011c2.d.CLOSED) {
                return;
            }
            if (this.f10447h == p011c2.d.OPEN && i3 == 1006) {
                this.f10447h = p011c2.d.CLOSING;
            }
            SelectionKey selectionKey = this.f10444e;
            if (selectionKey != null) {
                selectionKey.cancel();
            }
            ByteChannel byteChannel = this.f10445f;
            if (byteChannel != null) {
                try {
                    byteChannel.close();
                } catch (IOException e3) {
                    if (e3.getMessage() == null || !e3.getMessage().equals("Broken pipe")) {
                        this.f10440a.e("Exception during channel.close()", e3);
                        this.f10443d.onWebsocketError(this, e3);
                    } else {
                        this.f10440a.b("Caught IOException: Broken pipe during closeConnection()", e3);
                    }
                }
            }
            try {
                this.f10443d.onWebsocketClose(this, i3, str, z3);
            } catch (RuntimeException e4) {
                this.f10443d.onWebsocketError(this, e4);
            }
            p007b2.a aVar = this.f10449j;
            if (aVar != null) {
                aVar.s();
            }
            this.f10452m = null;
            this.f10447h = p011c2.d.CLOSED;
        } catch (Throwable th) {
            throw th;
        }
    }

    protected void g(int i3, boolean z3) {
        f(i3, "", z3);
    }

    public void j(ByteBuffer byteBuffer) throws Throwable {
        this.f10440a.f("process({}): ({})", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
        if (this.f10447h != p011c2.d.NOT_YET_CONNECTED) {
            if (this.f10447h == p011c2.d.OPEN) {
                k(byteBuffer);
            }
        } else {
            if (!l(byteBuffer) || y() || x()) {
                return;
            }
            if (byteBuffer.hasRemaining()) {
                k(byteBuffer);
            } else if (this.f10451l.hasRemaining()) {
                k(this.f10451l);
            }
        }
    }

    public void m() {
        if (this.f10447h == p011c2.d.NOT_YET_CONNECTED) {
            g(-1, true);
            return;
        }
        if (this.f10446g) {
            f(this.f10454o.intValue(), this.f10453n, this.f10455p.booleanValue());
            return;
        }
        if (this.f10449j.l() == p011c2.a.NONE) {
            g(1000, true);
            return;
        }
        if (this.f10449j.l() != p011c2.a.ONEWAY) {
            g(1006, true);
        } else if (this.f10450k == p011c2.e.SERVER) {
            g(1006, true);
        } else {
            g(1000, true);
        }
    }

    public synchronized void n(int i3, String str, boolean z3) {
        if (this.f10446g) {
            return;
        }
        this.f10454o = Integer.valueOf(i3);
        this.f10453n = str;
        this.f10455p = Boolean.valueOf(z3);
        this.f10446g = true;
        this.f10443d.onWriteDemand(this);
        try {
            this.f10443d.onWebsocketClosing(this, i3, str, z3);
        } catch (RuntimeException e3) {
            this.f10440a.e("Exception in onWebsocketClosing", e3);
            this.f10443d.onWebsocketError(this, e3);
        }
        p007b2.a aVar = this.f10449j;
        if (aVar != null) {
            aVar.s();
        }
        this.f10452m = null;
    }

    public Object p() {
        return this.f10459t;
    }

    long q() {
        return this.f10457r;
    }

    public InetSocketAddress r() {
        return this.f10443d.getLocalSocketAddress(this);
    }

    public h2.a s() {
        p007b2.a aVar = this.f10449j;
        if (aVar == null) {
            return null;
        }
        if (aVar instanceof p007b2.b) {
            return ((p007b2.b) aVar).N();
        }
        throw new IllegalArgumentException("This draft does not support Sec-WebSocket-Protocol");
    }

    @Override // org.java_websocket.b
    public void sendFrame(p023f2.f fVar) {
        E(Collections.singletonList(fVar));
    }

    public p011c2.d t() {
        return this.f10447h;
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress u() {
        return this.f10443d.getRemoteSocketAddress(this);
    }

    public e v() {
        return this.f10443d;
    }

    public boolean w() {
        return !this.f10441b.isEmpty();
    }

    public boolean x() {
        return this.f10447h == p011c2.d.CLOSED;
    }

    public boolean y() {
        return this.f10447h == p011c2.d.CLOSING;
    }

    public boolean z() {
        return this.f10446g;
    }
}
