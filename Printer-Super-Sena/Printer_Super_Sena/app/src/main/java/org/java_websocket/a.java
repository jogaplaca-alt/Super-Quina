package org.java_websocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends c {
    private ScheduledFuture<?> connectionLostCheckerFuture;
    private ScheduledExecutorService connectionLostCheckerService;
    private boolean reuseAddr;
    private boolean tcpNoDelay;
    private final j2.a log = j2.b.i(a.class);
    private long connectionLostTimeout = TimeUnit.SECONDS.toNanos(60);
    private boolean websocketRunning = false;
    private final Object syncConnectionLost = new Object();

    /* JADX INFO: renamed from: org.java_websocket.a$a, reason: collision with other inner class name */
    class RunnableC0129a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ArrayList f10435a = new ArrayList();

        RunnableC0129a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long j3;
            this.f10435a.clear();
            try {
                this.f10435a.addAll(a.this.getConnections());
                synchronized (a.this.syncConnectionLost) {
                    double dNanoTime = System.nanoTime();
                    double d3 = a.this.connectionLostTimeout;
                    Double.isNaN(d3);
                    Double.isNaN(dNanoTime);
                    j3 = (long) (dNanoTime - (d3 * 1.5d));
                }
                Iterator it = this.f10435a.iterator();
                while (it.hasNext()) {
                    a.this.b((b) it.next(), j3);
                }
            } catch (Exception unused) {
            }
            this.f10435a.clear();
        }
    }

    private void a() {
        ScheduledExecutorService scheduledExecutorService = this.connectionLostCheckerService;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.connectionLostCheckerService = null;
        }
        ScheduledFuture<?> scheduledFuture = this.connectionLostCheckerFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.connectionLostCheckerFuture = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar, long j3) {
        if (bVar instanceof d) {
            d dVar = (d) bVar;
            if (dVar.q() < j3) {
                this.log.d("Closing connection due to no pong received: {}", dVar);
                dVar.e(1006, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
            } else if (dVar.A()) {
                dVar.I();
            } else {
                this.log.d("Trying to ping a non open connection: {}", dVar);
            }
        }
    }

    private void c() {
        a();
        this.connectionLostCheckerService = Executors.newSingleThreadScheduledExecutor(new i2.d("connectionLostChecker"));
        RunnableC0129a runnableC0129a = new RunnableC0129a();
        ScheduledExecutorService scheduledExecutorService = this.connectionLostCheckerService;
        long j3 = this.connectionLostTimeout;
        this.connectionLostCheckerFuture = scheduledExecutorService.scheduleAtFixedRate(runnableC0129a, j3, j3, TimeUnit.NANOSECONDS);
    }

    public int getConnectionLostTimeout() {
        int seconds;
        synchronized (this.syncConnectionLost) {
            seconds = (int) TimeUnit.NANOSECONDS.toSeconds(this.connectionLostTimeout);
        }
        return seconds;
    }

    protected abstract Collection getConnections();

    public boolean isReuseAddr() {
        return this.reuseAddr;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    public void setConnectionLostTimeout(int i3) {
        synchronized (this.syncConnectionLost) {
            try {
                long nanos = TimeUnit.SECONDS.toNanos(i3);
                this.connectionLostTimeout = nanos;
                if (nanos <= 0) {
                    this.log.g("Connection lost timer stopped");
                    a();
                    return;
                }
                if (this.websocketRunning) {
                    this.log.g("Connection lost timer restarted");
                    try {
                        for (b bVar : new ArrayList(getConnections())) {
                            if (bVar instanceof d) {
                                ((d) bVar).L();
                            }
                        }
                    } catch (Exception e3) {
                        this.log.e("Exception during connection lost restart", e3);
                    }
                    c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setReuseAddr(boolean z3) {
        this.reuseAddr = z3;
    }

    public void setTcpNoDelay(boolean z3) {
        this.tcpNoDelay = z3;
    }

    protected void startConnectionLostTimer() {
        synchronized (this.syncConnectionLost) {
            try {
                if (this.connectionLostTimeout <= 0) {
                    this.log.g("Connection lost timer deactivated");
                    return;
                }
                this.log.g("Connection lost timer started");
                this.websocketRunning = true;
                c();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void stopConnectionLostTimer() {
        synchronized (this.syncConnectionLost) {
            try {
                if (this.connectionLostCheckerService != null || this.connectionLostCheckerFuture != null) {
                    this.websocketRunning = false;
                    this.log.g("Connection lost timer stopped");
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
