package androidx.room;

/* JADX INFO: renamed from: androidx.room.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0373e implements Z.h.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Z.h.c f6299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0371c f6300b;

    public C0373e(Z.h.c cVar, C0371c c0371c) {
        S1.k.e(cVar, "delegate");
        S1.k.e(c0371c, "autoCloser");
        this.f6299a = cVar;
        this.f6300b = c0371c;
    }

    @Override // Z.h.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0372d a(Z.h.b bVar) {
        S1.k.e(bVar, "configuration");
        return new C0372d(this.f6299a.a(bVar), this.f6300b);
    }
}
