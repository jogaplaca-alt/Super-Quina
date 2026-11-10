package androidx.concurrent.futures;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Future {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final boolean f3682d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Logger f3683e = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final b f3684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f3685g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile Object f3686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile e f3687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile h f3688c;

    private static abstract class b {
        private b() {
        }

        abstract boolean a(a aVar, e eVar, e eVar2);

        abstract boolean b(a aVar, Object obj, Object obj2);

        abstract boolean c(a aVar, h hVar, h hVar2);

        abstract void d(h hVar, h hVar2);

        abstract void e(h hVar, Thread thread);
    }

    private static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final c f3689c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final c f3690d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f3691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Throwable f3692b;

        static {
            if (a.f3682d) {
                f3690d = null;
                f3689c = null;
            } else {
                f3690d = new c(false, null);
                f3689c = new c(true, null);
            }
        }

        c(boolean z3, Throwable th) {
            this.f3691a = z3;
            this.f3692b = th;
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Throwable f3693a;
    }

    private static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final e f3694d = new e(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f3695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f3696b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e f3697c;

        e(Runnable runnable, Executor executor) {
            this.f3695a = runnable;
            this.f3696b = executor;
        }
    }

    private static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f3698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f3699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f3700c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f3701d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f3702e;

        f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f3698a = atomicReferenceFieldUpdater;
            this.f3699b = atomicReferenceFieldUpdater2;
            this.f3700c = atomicReferenceFieldUpdater3;
            this.f3701d = atomicReferenceFieldUpdater4;
            this.f3702e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a aVar, e eVar, e eVar2) {
            return androidx.concurrent.futures.b.a(this.f3701d, aVar, eVar, eVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a aVar, Object obj, Object obj2) {
            return androidx.concurrent.futures.b.a(this.f3702e, aVar, obj, obj2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a aVar, h hVar, h hVar2) {
            return androidx.concurrent.futures.b.a(this.f3700c, aVar, hVar, hVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void d(h hVar, h hVar2) {
            this.f3699b.lazySet(hVar, hVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void e(h hVar, Thread thread) {
            this.f3698a.lazySet(hVar, thread);
        }
    }

    private static final class g extends b {
        g() {
            super();
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f3687b != eVar) {
                        return false;
                    }
                    aVar.f3687b = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                try {
                    if (aVar.f3686a != obj) {
                        return false;
                    }
                    aVar.f3686a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a aVar, h hVar, h hVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f3688c != hVar) {
                        return false;
                    }
                    aVar.f3688c = hVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        void d(h hVar, h hVar2) {
            hVar.f3705b = hVar2;
        }

        @Override // androidx.concurrent.futures.a.b
        void e(h hVar, Thread thread) {
            hVar.f3704a = thread;
        }
    }

    private static final class h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final h f3703c = new h(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile Thread f3704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile h f3705b;

        h(boolean z3) {
        }

        void a(h hVar) {
            a.f3684f.d(this, hVar);
        }

        void b() {
            Thread thread = this.f3704a;
            if (thread != null) {
                this.f3704a = null;
                LockSupport.unpark(thread);
            }
        }

        h() {
            a.f3684f.e(this, Thread.currentThread());
        }
    }

    static {
        b gVar;
        try {
            gVar = new f(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f3684f = gVar;
        if (th != null) {
            f3683e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f3685g = new Object();
    }

    protected a() {
    }

    private void a(StringBuilder sb) {
        try {
            Object objH = h(this);
            sb.append("SUCCESS, result=[");
            sb.append(n(objH));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e4) {
            sb.append("FAILURE, cause=[");
            sb.append(e4.getCause());
            sb.append("]");
        }
    }

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private e d(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f3687b;
        } while (!f3684f.a(this, eVar2, e.f3694d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f3697c;
            eVar4.f3697c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    static void e(a aVar) {
        aVar.k();
        aVar.b();
        e eVarD = aVar.d(null);
        while (eVarD != null) {
            e eVar = eVarD.f3697c;
            f(eVarD.f3695a, eVarD.f3696b);
            eVarD = eVar;
        }
    }

    private static void f(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e3) {
            f3683e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e3);
        }
    }

    private Object g(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).f3692b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f3693a);
        }
        if (obj == f3685g) {
            return null;
        }
        return obj;
    }

    static Object h(Future future) {
        Object obj;
        boolean z3 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z3 = true;
            } catch (Throwable th) {
                if (z3) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private void k() {
        h hVar;
        do {
            hVar = this.f3688c;
        } while (!f3684f.c(this, hVar, h.f3703c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.f3705b;
        }
    }

    private void l(h hVar) {
        hVar.f3704a = null;
        while (true) {
            h hVar2 = this.f3688c;
            if (hVar2 == h.f3703c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f3705b;
                if (hVar2.f3704a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f3705b = hVar4;
                    if (hVar3.f3704a == null) {
                    }
                } else if (!f3684f.c(this, hVar2, hVar4)) {
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    private String n(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    protected void b() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z3) {
        c cVar;
        Object obj = this.f3686a;
        if (obj == null) {
            if (f3682d) {
                cVar = new c(z3, new CancellationException("Future.cancel() was called."));
            } else {
                cVar = z3 ? c.f3689c : c.f3690d;
            }
            if (f3684f.b(this, obj, cVar)) {
                if (z3) {
                    i();
                }
                e(this);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j3, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j3);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f3686a;
        if (obj != null) {
            return g(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.f3688c;
            if (hVar != h.f3703c) {
                h hVar2 = new h();
                while (true) {
                    hVar2.a(hVar);
                    if (f3684f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                l(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f3686a;
                            if (obj2 != null) {
                                return g(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        l(hVar2);
                        break;
                    }
                    hVar = this.f3688c;
                    if (hVar == h.f3703c) {
                    }
                }
            }
            return g(this.f3686a);
        }
        while (nanos > 0) {
            Object obj3 = this.f3686a;
            if (obj3 != null) {
                return g(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j3 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j4 = -nanos;
            long jConvert = timeUnit.convert(j4, TimeUnit.NANOSECONDS);
            long nanos2 = j4 - timeUnit.toNanos(jConvert);
            boolean z3 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z3) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z3) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    protected void i() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f3686a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f3686a != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String j() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected boolean m(Object obj) {
        if (obj == null) {
            obj = f3685g;
        }
        if (!f3684f.b(this, null, obj)) {
            return false;
        }
        e(this);
        return true;
    }

    public String toString() {
        String strJ;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strJ = j();
            } catch (RuntimeException e3) {
                strJ = "Exception thrown from implementation: " + e3.getClass();
            }
            if (strJ != null && !strJ.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strJ);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f3686a;
            if (obj2 != null) {
                return g(obj2);
            }
            h hVar = this.f3688c;
            if (hVar != h.f3703c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f3684f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f3686a;
                            } else {
                                l(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!(obj != null));
                        return g(obj);
                    }
                    hVar = this.f3688c;
                } while (hVar != h.f3703c);
            }
            return g(this.f3686a);
        }
        throw new InterruptedException();
    }
}
