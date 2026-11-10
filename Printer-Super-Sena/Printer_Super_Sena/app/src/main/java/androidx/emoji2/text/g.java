package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ThreadLocal f4968d = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f4970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f4971c = 0;

    g(l lVar, int i3) {
        this.f4970b = lVar;
        this.f4969a = i3;
    }

    private L.a g() {
        ThreadLocal threadLocal = f4968d;
        L.a aVar = (L.a) threadLocal.get();
        if (aVar == null) {
            aVar = new L.a();
            threadLocal.set(aVar);
        }
        this.f4970b.d().j(aVar, this.f4969a);
        return aVar;
    }

    public void a(Canvas canvas, float f3, float f4, Paint paint) {
        Typeface typefaceG = this.f4970b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceG);
        canvas.drawText(this.f4970b.c(), this.f4969a * 2, 2, f3, f4, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i3) {
        return g().h(i3);
    }

    public int c() {
        return g().i();
    }

    public int d() {
        return this.f4971c;
    }

    public short e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public short h() {
        return g().m();
    }

    public short i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    public void k(boolean z3) {
        this.f4971c = z3 ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int iC = c();
        for (int i3 = 0; i3 < iC; i3++) {
            sb.append(Integer.toHexString(b(i3)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
