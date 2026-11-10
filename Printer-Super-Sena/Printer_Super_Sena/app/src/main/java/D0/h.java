package D0;

import C0.C0181c;

/* JADX INFO: loaded from: classes.dex */
public final class h extends UnsupportedOperationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0181c f192a;

    public h(C0181c c0181c) {
        this.f192a = c0181c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.f192a));
    }
}
