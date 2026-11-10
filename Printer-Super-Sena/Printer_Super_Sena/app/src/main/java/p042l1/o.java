package p042l1;

import W0.b;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    k f9976c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f9974a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f9975b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    RectF f9977d = new RectF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Path f9978e = new Path();

    public static o a(View view) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33) {
            return new t(view);
        }
        return i3 >= 22 ? new s(view) : new p();
    }

    private boolean c() {
        RectF rectF = this.f9977d;
        return rectF.left <= rectF.right && rectF.top <= rectF.bottom;
    }

    private void j() {
        if (!c() || this.f9976c == null) {
            return;
        }
        l.k().d(this.f9976c, 1.0f, this.f9977d, this.f9978e);
    }

    abstract void b(View view);

    public void d(Canvas canvas, b.a aVar) {
        if (!i() || this.f9978e.isEmpty()) {
            aVar.a(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(this.f9978e);
        aVar.a(canvas);
        canvas.restore();
    }

    public void e(View view, RectF rectF) {
        this.f9977d = rectF;
        j();
        b(view);
    }

    public void f(View view, k kVar) {
        this.f9976c = kVar;
        j();
        b(view);
    }

    public void g(View view, boolean z3) {
        if (z3 != this.f9974a) {
            this.f9974a = z3;
            b(view);
        }
    }

    public void h(View view, boolean z3) {
        this.f9975b = z3;
        b(view);
    }

    abstract boolean i();
}
