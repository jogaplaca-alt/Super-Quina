package p042l1;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m[] f9928a = new m[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Matrix[] f9929b = new Matrix[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix[] f9930c = new Matrix[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointF f9931d = new PointF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Path f9932e = new Path();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Path f9933f = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m f9934g = new m();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f9935h = new float[2];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f9936i = new float[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Path f9937j = new Path();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Path f9938k = new Path();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f9939l = true;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final l f9940a = new l();
    }

    public interface b {
        void a(m mVar, Matrix matrix, int i3);

        void b(m mVar, Matrix matrix, int i3);
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f9941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f9942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RectF f9943c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f9944d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f9945e;

        c(k kVar, float f3, RectF rectF, b bVar, Path path) {
            this.f9944d = bVar;
            this.f9941a = kVar;
            this.f9945e = f3;
            this.f9943c = rectF;
            this.f9942b = path;
        }
    }

    public l() {
        for (int i3 = 0; i3 < 4; i3++) {
            this.f9928a[i3] = new m();
            this.f9929b[i3] = new Matrix();
            this.f9930c[i3] = new Matrix();
        }
    }

    private float a(int i3) {
        return ((i3 + 1) % 4) * 90;
    }

    private void b(c cVar, int i3) {
        this.f9935h[0] = this.f9928a[i3].k();
        this.f9935h[1] = this.f9928a[i3].l();
        this.f9929b[i3].mapPoints(this.f9935h);
        if (i3 == 0) {
            Path path = cVar.f9942b;
            float[] fArr = this.f9935h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f9942b;
            float[] fArr2 = this.f9935h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f9928a[i3].d(this.f9929b[i3], cVar.f9942b);
        b bVar = cVar.f9944d;
        if (bVar != null) {
            bVar.a(this.f9928a[i3], this.f9929b[i3], i3);
        }
    }

    private void c(c cVar, int i3) {
        int i4 = (i3 + 1) % 4;
        this.f9935h[0] = this.f9928a[i3].i();
        this.f9935h[1] = this.f9928a[i3].j();
        this.f9929b[i3].mapPoints(this.f9935h);
        this.f9936i[0] = this.f9928a[i4].k();
        this.f9936i[1] = this.f9928a[i4].l();
        this.f9929b[i4].mapPoints(this.f9936i);
        float[] fArr = this.f9935h;
        float f3 = fArr[0];
        float[] fArr2 = this.f9936i;
        float fMax = Math.max(((float) Math.hypot(f3 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float fI = i(cVar.f9943c, i3);
        this.f9934g.n(0.0f, 0.0f);
        f fVarJ = j(i3, cVar.f9941a);
        fVarJ.b(fMax, fI, cVar.f9945e, this.f9934g);
        this.f9937j.reset();
        this.f9934g.d(this.f9930c[i3], this.f9937j);
        if (this.f9939l && (fVarJ.a() || l(this.f9937j, i3) || l(this.f9937j, i4))) {
            Path path = this.f9937j;
            path.op(path, this.f9933f, Path.Op.DIFFERENCE);
            this.f9935h[0] = this.f9934g.k();
            this.f9935h[1] = this.f9934g.l();
            this.f9930c[i3].mapPoints(this.f9935h);
            Path path2 = this.f9932e;
            float[] fArr3 = this.f9935h;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.f9934g.d(this.f9930c[i3], this.f9932e);
        } else {
            this.f9934g.d(this.f9930c[i3], cVar.f9942b);
        }
        b bVar = cVar.f9944d;
        if (bVar != null) {
            bVar.b(this.f9934g, this.f9930c[i3], i3);
        }
    }

    private void f(int i3, RectF rectF, PointF pointF) {
        if (i3 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i3 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i3 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private p042l1.c g(int i3, k kVar) {
        if (i3 == 1) {
            return kVar.l();
        }
        if (i3 != 2) {
            return i3 != 3 ? kVar.t() : kVar.r();
        }
        return kVar.j();
    }

    private d h(int i3, k kVar) {
        if (i3 == 1) {
            return kVar.k();
        }
        if (i3 != 2) {
            return i3 != 3 ? kVar.s() : kVar.q();
        }
        return kVar.i();
    }

    private float i(RectF rectF, int i3) {
        float[] fArr = this.f9935h;
        m mVar = this.f9928a[i3];
        fArr[0] = mVar.f9948c;
        fArr[1] = mVar.f9949d;
        this.f9929b[i3].mapPoints(fArr);
        return (i3 == 1 || i3 == 3) ? Math.abs(rectF.centerX() - this.f9935h[0]) : Math.abs(rectF.centerY() - this.f9935h[1]);
    }

    private f j(int i3, k kVar) {
        if (i3 == 1) {
            return kVar.h();
        }
        if (i3 != 2) {
            return i3 != 3 ? kVar.o() : kVar.p();
        }
        return kVar.n();
    }

    public static l k() {
        return a.f9940a;
    }

    private boolean l(Path path, int i3) {
        this.f9938k.reset();
        this.f9928a[i3].d(this.f9929b[i3], this.f9938k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f9938k.computeBounds(rectF, true);
        path.op(this.f9938k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void m(c cVar, int i3) {
        h(i3, cVar.f9941a).b(this.f9928a[i3], 90.0f, cVar.f9945e, cVar.f9943c, g(i3, cVar.f9941a));
        float fA = a(i3);
        this.f9929b[i3].reset();
        f(i3, cVar.f9943c, this.f9931d);
        Matrix matrix = this.f9929b[i3];
        PointF pointF = this.f9931d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f9929b[i3].preRotate(fA);
    }

    private void n(int i3) {
        this.f9935h[0] = this.f9928a[i3].i();
        this.f9935h[1] = this.f9928a[i3].j();
        this.f9929b[i3].mapPoints(this.f9935h);
        float fA = a(i3);
        this.f9930c[i3].reset();
        Matrix matrix = this.f9930c[i3];
        float[] fArr = this.f9935h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f9930c[i3].preRotate(fA);
    }

    public void d(k kVar, float f3, RectF rectF, Path path) {
        e(kVar, f3, rectF, null, path);
    }

    public void e(k kVar, float f3, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f9932e.rewind();
        this.f9933f.rewind();
        this.f9933f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(kVar, f3, rectF, bVar, path);
        for (int i3 = 0; i3 < 4; i3++) {
            m(cVar, i3);
            n(i3);
        }
        for (int i4 = 0; i4 < 4; i4++) {
            b(cVar, i4);
            c(cVar, i4);
        }
        path.close();
        this.f9932e.close();
        if (this.f9932e.isEmpty()) {
            return;
        }
        path.op(this.f9932e, Path.Op.UNION);
    }
}
