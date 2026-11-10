package p030h1;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Typeface f9599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0116a f9600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9601c;

    /* JADX INFO: renamed from: h1.a$a, reason: collision with other inner class name */
    public interface InterfaceC0116a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0116a interfaceC0116a, Typeface typeface) {
        this.f9599a = typeface;
        this.f9600b = interfaceC0116a;
    }

    private void d(Typeface typeface) {
        if (this.f9601c) {
            return;
        }
        this.f9600b.a(typeface);
    }

    @Override // p030h1.f
    public void a(int i3) {
        d(this.f9599a);
    }

    @Override // p030h1.f
    public void b(Typeface typeface, boolean z3) {
        d(typeface);
    }

    public void c() {
        this.f9601c = true;
    }
}
