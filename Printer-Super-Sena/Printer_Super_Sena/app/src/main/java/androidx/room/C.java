package androidx.room;

import java.io.File;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class C implements Z.h.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f6249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Callable f6250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Z.h.c f6251d;

    public C(String str, File file, Callable callable, Z.h.c cVar) {
        S1.k.e(cVar, "mDelegate");
        this.f6248a = str;
        this.f6249b = file;
        this.f6250c = callable;
        this.f6251d = cVar;
    }

    @Override // Z.h.c
    public Z.h a(Z.h.b bVar) {
        S1.k.e(bVar, "configuration");
        return new B(bVar.f2165a, this.f6248a, this.f6249b, this.f6250c, bVar.f2167c.f2163a, this.f6251d.a(bVar));
    }
}
