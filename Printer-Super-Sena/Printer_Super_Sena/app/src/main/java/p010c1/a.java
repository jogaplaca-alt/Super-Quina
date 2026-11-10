package p010c1;

import android.content.Context;
import android.graphics.Color;
import androidx.core.graphics.d;
import p030h1.b;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f6962f = (int) Math.round(5.1000000000000005d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f6966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f6967e;

    public a(Context context) {
        this(b.b(context, S0.a.f1525q, false), p002a1.a.b(context, S0.a.f1524p, 0), p002a1.a.b(context, S0.a.f1523o, 0), p002a1.a.b(context, S0.a.f1521m, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean e(int i3) {
        return d.k(i3, 255) == this.f6966d;
    }

    public float a(float f3) {
        float f4 = this.f6967e;
        if (f4 <= 0.0f || f3 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f3 / f4)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i3, float f3) {
        int i4;
        float fA = a(f3);
        int iAlpha = Color.alpha(i3);
        int iK = p002a1.a.k(d.k(i3, 255), this.f6964b, fA);
        if (fA > 0.0f && (i4 = this.f6965c) != 0) {
            iK = p002a1.a.j(iK, d.k(i4, f6962f));
        }
        return d.k(iK, iAlpha);
    }

    public int c(int i3, float f3) {
        return (this.f6963a && e(i3)) ? b(i3, f3) : i3;
    }

    public boolean d() {
        return this.f6963a;
    }

    public a(boolean z3, int i3, int i4, int i5, float f3) {
        this.f6963a = z3;
        this.f6964b = i3;
        this.f6965c = i4;
        this.f6966d = i5;
        this.f6967e = f3;
    }
}
