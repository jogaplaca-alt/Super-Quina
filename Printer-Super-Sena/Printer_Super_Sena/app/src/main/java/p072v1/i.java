package p072v1;

import java.io.IOException;
import p063s1.b;
import p063s1.c;
import p063s1.g;

/* JADX INFO: loaded from: classes.dex */
class i implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12534a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12535b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f12536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f12537d;

    i(f fVar) {
        this.f12537d = fVar;
    }

    private void c() {
        if (this.f12534a) {
            throw new b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f12534a = true;
    }

    @Override // p063s1.g
    public g a(String str) throws IOException {
        c();
        this.f12537d.f(this.f12536c, str, this.f12535b);
        return this;
    }

    @Override // p063s1.g
    public g b(boolean z3) {
        c();
        this.f12537d.k(this.f12536c, z3, this.f12535b);
        return this;
    }

    void d(c cVar, boolean z3) {
        this.f12534a = false;
        this.f12536c = cVar;
        this.f12535b = z3;
    }
}
