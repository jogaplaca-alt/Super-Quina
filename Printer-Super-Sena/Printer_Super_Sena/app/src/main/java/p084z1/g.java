package p084z1;

import E1.c;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p075w1.f;
import p075w1.i;
import p075w1.k;
import p075w1.l;
import p075w1.n;

/* JADX INFO: loaded from: classes.dex */
public final class g extends c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Writer f13004p = new a();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final n f13005q = new n("closed");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final List f13006m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f13007n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private i f13008o;

    class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i3, int i4) {
            throw new AssertionError();
        }
    }

    public g() {
        super(f13004p);
        this.f13006m = new ArrayList();
        this.f13008o = k.f12683a;
    }

    private i j0() {
        List list = this.f13006m;
        return (i) list.get(list.size() - 1);
    }

    private void k0(i iVar) {
        if (this.f13007n != null) {
            if (!iVar.n() || L()) {
                ((l) j0()).q(this.f13007n, iVar);
            }
            this.f13007n = null;
            return;
        }
        if (this.f13006m.isEmpty()) {
            this.f13008o = iVar;
            return;
        }
        i iVarJ0 = j0();
        if (!(iVarJ0 instanceof f)) {
            throw new IllegalStateException();
        }
        ((f) iVarJ0).q(iVar);
    }

    @Override // E1.c
    public c G() {
        l lVar = new l();
        k0(lVar);
        this.f13006m.add(lVar);
        return this;
    }

    @Override // E1.c
    public c J() {
        if (this.f13006m.isEmpty() || this.f13007n != null) {
            throw new IllegalStateException();
        }
        if (!(j0() instanceof f)) {
            throw new IllegalStateException();
        }
        List list = this.f13006m;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // E1.c
    public c K() {
        if (this.f13006m.isEmpty() || this.f13007n != null) {
            throw new IllegalStateException();
        }
        if (!(j0() instanceof l)) {
            throw new IllegalStateException();
        }
        List list = this.f13006m;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // E1.c
    public c P(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f13006m.isEmpty() || this.f13007n != null) {
            throw new IllegalStateException();
        }
        if (!(j0() instanceof l)) {
            throw new IllegalStateException();
        }
        this.f13007n = str;
        return this;
    }

    @Override // E1.c
    public c R() {
        k0(k.f12683a);
        return this;
    }

    @Override // E1.c
    public c b0(double d3) {
        if (N() || !(Double.isNaN(d3) || Double.isInfinite(d3))) {
            k0(new n(Double.valueOf(d3)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d3);
    }

    @Override // E1.c
    public c c0(long j3) {
        k0(new n(Long.valueOf(j3)));
        return this;
    }

    @Override // E1.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f13006m.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f13006m.add(f13005q);
    }

    @Override // E1.c
    public c d0(Boolean bool) {
        if (bool == null) {
            return R();
        }
        k0(new n(bool));
        return this;
    }

    @Override // E1.c
    public c e0(Number number) {
        if (number == null) {
            return R();
        }
        if (!N()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        k0(new n(number));
        return this;
    }

    @Override // E1.c
    public c f0(String str) {
        if (str == null) {
            return R();
        }
        k0(new n(str));
        return this;
    }

    @Override // E1.c
    public c g0(boolean z3) {
        k0(new n(Boolean.valueOf(z3)));
        return this;
    }

    public i i0() {
        if (this.f13006m.isEmpty()) {
            return this.f13008o;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f13006m);
    }

    @Override // E1.c
    public c y() {
        f fVar = new f();
        k0(fVar);
        this.f13006m.add(fVar);
        return this;
    }

    @Override // E1.c, java.io.Flushable
    public void flush() {
    }
}
