package org.java_websocket.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.java_websocket.d;
import p015d2.e;
import p027g2.f;
import p027g2.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends org.java_websocket.a implements Runnable, org.java_websocket.b {
    private CountDownLatch closeLatch;
    private CountDownLatch connectLatch;
    private Thread connectReadThread;
    private int connectTimeout;
    private org.java_websocket.client.a dnsResolver;
    private p007b2.a draft;
    private d engine;
    private Map<String, String> headers;
    private OutputStream ostream;
    private Proxy proxy;
    private Socket socket;
    private SocketFactory socketFactory;
    protected URI uri;
    private Thread writeThread;

    class a implements org.java_websocket.client.a {
        a() {
        }

        @Override // org.java_websocket.client.a
        public InetAddress a(URI uri) {
            return InetAddress.getByName(uri.getHost());
        }
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f10438a;

        b(c cVar) {
            this.f10438a = cVar;
        }

        private void a() {
            try {
                if (c.this.socket != null) {
                    c.this.socket.close();
                }
            } catch (IOException e3) {
                c.this.onWebsocketError(this.f10438a, e3);
            }
        }

        private void b() throws IOException {
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer byteBuffer = (ByteBuffer) c.this.engine.f10441b.take();
                    c.this.ostream.write(byteBuffer.array(), 0, byteBuffer.limit());
                    c.this.ostream.flush();
                } catch (InterruptedException unused) {
                    for (ByteBuffer byteBuffer2 : c.this.engine.f10441b) {
                        c.this.ostream.write(byteBuffer2.array(), 0, byteBuffer2.limit());
                        c.this.ostream.flush();
                    }
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebSocketWriteThread-" + Thread.currentThread().getId());
            try {
                try {
                    b();
                } catch (IOException e3) {
                    c.this.e(e3);
                }
            } finally {
                a();
                c.this.writeThread = null;
            }
        }
    }

    public c(URI uri) {
        this(uri, new p007b2.b());
    }

    private int d() {
        int port = this.uri.getPort();
        String scheme = this.uri.getScheme();
        if ("wss".equals(scheme)) {
            if (port == -1) {
                return 443;
            }
            return port;
        }
        if ("ws".equals(scheme)) {
            if (port == -1) {
                return 80;
            }
            return port;
        }
        throw new IllegalArgumentException("unknown scheme: " + scheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(IOException iOException) {
        if (iOException instanceof SSLException) {
            onError(iOException);
        }
        this.engine.m();
    }

    private boolean f() throws IOException {
        if (this.proxy != Proxy.NO_PROXY) {
            this.socket = new Socket(this.proxy);
            return true;
        }
        SocketFactory socketFactory = this.socketFactory;
        if (socketFactory != null) {
            this.socket = socketFactory.createSocket();
        } else {
            Socket socket = this.socket;
            if (socket == null) {
                this.socket = new Socket(this.proxy);
                return true;
            }
            if (socket.isClosed()) {
                throw new IOException();
            }
        }
        return false;
    }

    private void g() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread == this.writeThread || threadCurrentThread == this.connectReadThread) {
            throw new IllegalStateException("You cannot initialize a reconnect out of the websocket thread. Use reconnect in another thread to ensure a successful cleanup.");
        }
        try {
            closeBlocking();
            Thread thread = this.writeThread;
            if (thread != null) {
                thread.interrupt();
                this.writeThread = null;
            }
            Thread thread2 = this.connectReadThread;
            if (thread2 != null) {
                thread2.interrupt();
                this.connectReadThread = null;
            }
            this.draft.s();
            Socket socket = this.socket;
            if (socket != null) {
                socket.close();
                this.socket = null;
            }
            this.connectLatch = new CountDownLatch(1);
            this.closeLatch = new CountDownLatch(1);
            this.engine = new d(this, this.draft);
        } catch (Exception e3) {
            onError(e3);
            this.engine.e(1006, e3.getMessage());
        }
    }

    private void h() throws e {
        String rawPath = this.uri.getRawPath();
        String rawQuery = this.uri.getRawQuery();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        if (rawQuery != null) {
            rawPath = rawPath + '?' + rawQuery;
        }
        int iD = d();
        StringBuilder sb = new StringBuilder();
        sb.append(this.uri.getHost());
        sb.append((iD == 80 || iD == 443) ? "" : ":" + iD);
        String string = sb.toString();
        p027g2.d dVar = new p027g2.d();
        dVar.f(rawPath);
        dVar.b("Host", string);
        Map<String, String> map = this.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                dVar.b(entry.getKey(), entry.getValue());
            }
        }
        this.engine.K(dVar);
    }

    private void i() throws NoSuchAlgorithmException, KeyManagementException {
        SSLSocketFactory socketFactory;
        SocketFactory socketFactory2 = this.socketFactory;
        if (socketFactory2 instanceof SSLSocketFactory) {
            socketFactory = (SSLSocketFactory) socketFactory2;
        } else {
            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
            sSLContext.init(null, null, null);
            socketFactory = sSLContext.getSocketFactory();
        }
        this.socket = socketFactory.createSocket(this.socket, this.uri.getHost(), d(), true);
    }

    public void addHeader(String str, String str2) {
        if (this.headers == null) {
            this.headers = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        }
        this.headers.put(str, str2);
    }

    public void clearHeaders() {
        this.headers = null;
    }

    public void close() {
        if (this.writeThread != null) {
            this.engine.a(1000);
        }
    }

    public void closeBlocking() throws InterruptedException {
        close();
        this.closeLatch.await();
    }

    public void closeConnection(int i3, String str) {
        this.engine.e(i3, str);
    }

    public void connect() {
        if (this.connectReadThread != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        Thread thread = new Thread(this);
        this.connectReadThread = thread;
        thread.setName("WebSocketConnectReadThread-" + this.connectReadThread.getId());
        this.connectReadThread.start();
    }

    public boolean connectBlocking() throws InterruptedException {
        connect();
        this.connectLatch.await();
        return this.engine.A();
    }

    public <T> T getAttachment() {
        return (T) this.engine.p();
    }

    public org.java_websocket.b getConnection() {
        return this.engine;
    }

    @Override // org.java_websocket.a
    protected Collection<org.java_websocket.b> getConnections() {
        return Collections.singletonList(this.engine);
    }

    public p007b2.a getDraft() {
        return this.draft;
    }

    @Override // org.java_websocket.e
    public InetSocketAddress getLocalSocketAddress(org.java_websocket.b bVar) {
        Socket socket = this.socket;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
    }

    public h2.a getProtocol() {
        return this.engine.s();
    }

    public p011c2.d getReadyState() {
        return this.engine.t();
    }

    @Override // org.java_websocket.e
    public InetSocketAddress getRemoteSocketAddress(org.java_websocket.b bVar) {
        Socket socket = this.socket;
        if (socket != null) {
            return (InetSocketAddress) socket.getRemoteSocketAddress();
        }
        return null;
    }

    public String getResourceDescriptor() {
        return this.uri.getPath();
    }

    public SSLSession getSSLSession() {
        if (hasSSLSupport()) {
            return ((SSLSocket) this.socket).getSession();
        }
        throw new IllegalArgumentException("This websocket uses ws instead of wss. No SSLSession available.");
    }

    public Socket getSocket() {
        return this.socket;
    }

    public URI getURI() {
        return this.uri;
    }

    public boolean hasBufferedData() {
        return this.engine.w();
    }

    public boolean hasSSLSupport() {
        return this.socket instanceof SSLSocket;
    }

    public boolean isClosed() {
        return this.engine.x();
    }

    public boolean isClosing() {
        return this.engine.y();
    }

    public boolean isFlushAndClose() {
        return this.engine.z();
    }

    public boolean isOpen() {
        return this.engine.A();
    }

    public abstract void onClose(int i3, String str, boolean z3);

    public void onCloseInitiated(int i3, String str) {
    }

    public void onClosing(int i3, String str, boolean z3) {
    }

    public abstract void onError(Exception exc);

    public abstract void onMessage(String str);

    public void onMessage(ByteBuffer byteBuffer) {
    }

    public abstract void onOpen(h hVar);

    protected void onSetSSLParameters(SSLParameters sSLParameters) {
        sSLParameters.setEndpointIdentificationAlgorithm("HTTPS");
    }

    @Override // org.java_websocket.e
    public final void onWebsocketClose(org.java_websocket.b bVar, int i3, String str, boolean z3) {
        stopConnectionLostTimer();
        Thread thread = this.writeThread;
        if (thread != null) {
            thread.interrupt();
        }
        onClose(i3, str, z3);
        this.connectLatch.countDown();
        this.closeLatch.countDown();
    }

    @Override // org.java_websocket.e
    public void onWebsocketCloseInitiated(org.java_websocket.b bVar, int i3, String str) {
        onCloseInitiated(i3, str);
    }

    @Override // org.java_websocket.e
    public void onWebsocketClosing(org.java_websocket.b bVar, int i3, String str, boolean z3) {
        onClosing(i3, str, z3);
    }

    @Override // org.java_websocket.e
    public final void onWebsocketError(org.java_websocket.b bVar, Exception exc) {
        onError(exc);
    }

    @Override // org.java_websocket.e
    public final void onWebsocketMessage(org.java_websocket.b bVar, String str) {
        onMessage(str);
    }

    @Override // org.java_websocket.e
    public final void onWebsocketOpen(org.java_websocket.b bVar, f fVar) {
        startConnectionLostTimer();
        onOpen((h) fVar);
        this.connectLatch.countDown();
    }

    @Override // org.java_websocket.e
    public final void onWriteDemand(org.java_websocket.b bVar) {
    }

    public void reconnect() {
        g();
        connect();
    }

    public boolean reconnectBlocking() {
        g();
        return connectBlocking();
    }

    public String removeHeader(String str) {
        Map<String, String> map = this.headers;
        if (map == null) {
            return null;
        }
        return map.remove(str);
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        int i3;
        try {
            boolean zF = f();
            this.socket.setTcpNoDelay(isTcpNoDelay());
            this.socket.setReuseAddress(isReuseAddr());
            if (!this.socket.isConnected()) {
                this.socket.connect(this.dnsResolver == null ? InetSocketAddress.createUnresolved(this.uri.getHost(), d()) : new InetSocketAddress(this.dnsResolver.a(this.uri), d()), this.connectTimeout);
            }
            if (zF && "wss".equals(this.uri.getScheme())) {
                i();
            }
            Socket socket = this.socket;
            if (socket instanceof SSLSocket) {
                SSLSocket sSLSocket = (SSLSocket) socket;
                SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                onSetSSLParameters(sSLParameters);
                sSLSocket.setSSLParameters(sSLParameters);
            }
            InputStream inputStream = this.socket.getInputStream();
            this.ostream = this.socket.getOutputStream();
            h();
            Thread thread = new Thread(new b(this));
            this.writeThread = thread;
            thread.start();
            byte[] bArr = new byte[16384];
            while (!isClosing() && !isClosed() && (i3 = inputStream.read(bArr)) != -1) {
                try {
                    this.engine.j(ByteBuffer.wrap(bArr, 0, i3));
                } catch (IOException e3) {
                    e(e3);
                } catch (RuntimeException e4) {
                    onError(e4);
                    this.engine.e(1006, e4.getMessage());
                }
            }
            this.engine.m();
            this.connectReadThread = null;
        } catch (Exception e5) {
            onWebsocketError(this.engine, e5);
            this.engine.e(-1, e5.getMessage());
        } catch (InternalError e6) {
            if (!(e6.getCause() instanceof InvocationTargetException) || !(e6.getCause().getCause() instanceof IOException)) {
                throw e6;
            }
            IOException iOException = (IOException) e6.getCause().getCause();
            onWebsocketError(this.engine, iOException);
            this.engine.e(-1, iOException.getMessage());
        }
    }

    public void send(String str) {
        this.engine.C(str);
    }

    public void sendFragmentedFrame(p011c2.c cVar, ByteBuffer byteBuffer, boolean z3) {
        this.engine.G(cVar, byteBuffer, z3);
    }

    @Override // org.java_websocket.b
    public void sendFrame(p023f2.f fVar) {
        this.engine.sendFrame(fVar);
    }

    public void sendPing() {
        this.engine.I();
    }

    public <T> void setAttachment(T t3) {
        this.engine.J(t3);
    }

    public void setDnsResolver(org.java_websocket.client.a aVar) {
        this.dnsResolver = aVar;
    }

    public void setProxy(Proxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException();
        }
        this.proxy = proxy;
    }

    @Deprecated
    public void setSocket(Socket socket) {
        if (this.socket != null) {
            throw new IllegalStateException("socket has already been set");
        }
        this.socket = socket;
    }

    public void setSocketFactory(SocketFactory socketFactory) {
        this.socketFactory = socketFactory;
    }

    public c(URI uri, p007b2.a aVar) {
        this(uri, aVar, null, 0);
    }

    @Override // org.java_websocket.e
    public final void onWebsocketMessage(org.java_websocket.b bVar, ByteBuffer byteBuffer) {
        onMessage(byteBuffer);
    }

    public void send(byte[] bArr) {
        this.engine.F(bArr);
    }

    public void sendFrame(Collection<p023f2.f> collection) {
        this.engine.H(collection);
    }

    public c(URI uri, p007b2.a aVar, Map map, int i3) {
        this.uri = null;
        this.engine = null;
        this.socket = null;
        this.socketFactory = null;
        this.proxy = Proxy.NO_PROXY;
        this.connectLatch = new CountDownLatch(1);
        this.closeLatch = new CountDownLatch(1);
        this.connectTimeout = 0;
        this.dnsResolver = null;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (aVar != null) {
            this.uri = uri;
            this.draft = aVar;
            this.dnsResolver = new a();
            if (map != null) {
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                this.headers = treeMap;
                treeMap.putAll(map);
            }
            this.connectTimeout = i3;
            setTcpNoDelay(false);
            setReuseAddr(false);
            this.engine = new d(this, aVar);
            return;
        }
        throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }

    public void close(int i3) {
        this.engine.a(i3);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.engine.r();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.engine.u();
    }

    public void send(ByteBuffer byteBuffer) {
        this.engine.D(byteBuffer);
    }

    public void close(int i3, String str) {
        this.engine.b(i3, str);
    }

    public boolean connectBlocking(long j3, TimeUnit timeUnit) {
        connect();
        return this.connectLatch.await(j3, timeUnit) && this.engine.A();
    }
}
