package p042l1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f9946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f9947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f9948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f9949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f9950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f9951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f9952g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f9953h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f9954i;

    class a extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f9955c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Matrix f9956d;

        a(List list, Matrix matrix) {
            this.f9955c = list;
            this.f9956d = matrix;
        }

        @Override // l1.m.g
        public void a(Matrix matrix, p039k1.a aVar, int i3, Canvas canvas) {
            Iterator it = this.f9955c.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.f9956d, aVar, i3, canvas);
            }
        }
    }

    static class b extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d f9958c;

        public b(d dVar) {
            this.f9958c = dVar;
        }

        @Override // l1.m.g
        public void a(Matrix matrix, p039k1.a aVar, int i3, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f9958c.k(), this.f9958c.o(), this.f9958c.l(), this.f9958c.j()), i3, this.f9958c.m(), this.f9958c.n());
        }
    }

    static class c extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final e f9959c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f9960d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f9961e;

        public c(e eVar, float f3, float f4) {
            this.f9959c = eVar;
            this.f9960d = f3;
            this.f9961e = f4;
        }

        @Override // l1.m.g
        public void a(Matrix matrix, p039k1.a aVar, int i3, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f9959c.f9970c - this.f9961e, this.f9959c.f9969b - this.f9960d), 0.0f);
            this.f9973a.set(matrix);
            this.f9973a.preTranslate(this.f9960d, this.f9961e);
            this.f9973a.preRotate(c());
            aVar.b(canvas, this.f9973a, rectF, i3);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f9959c.f9970c - this.f9961e) / (this.f9959c.f9969b - this.f9960d)));
        }
    }

    public static class d extends f {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final RectF f9962h = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f9963b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f9964c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f9965d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f9966e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f9967f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f9968g;

        public d(float f3, float f4, float f5, float f6) {
            q(f3);
            u(f4);
            r(f5);
            p(f6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f9966e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f9963b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f9965d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f9967f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f9968g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f9964c;
        }

        private void p(float f3) {
            this.f9966e = f3;
        }

        private void q(float f3) {
            this.f9963b = f3;
        }

        private void r(float f3) {
            this.f9965d = f3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f3) {
            this.f9967f = f3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f3) {
            this.f9968g = f3;
        }

        private void u(float f3) {
            this.f9964c = f3;
        }

        @Override // l1.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f9971a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f9962h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    public static class e extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f9969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f9970c;

        @Override // l1.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f9971a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f9969b, this.f9970c);
            path.transform(matrix);
        }
    }

    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Matrix f9971a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    static abstract class g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Matrix f9972b = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Matrix f9973a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, p039k1.a aVar, int i3, Canvas canvas);

        public final void b(p039k1.a aVar, int i3, Canvas canvas) {
            a(f9972b, aVar, i3, canvas);
        }
    }

    public m() {
        n(0.0f, 0.0f);
    }

    private void b(float f3) {
        if (g() == f3) {
            return;
        }
        float fG = ((f3 - g()) + 360.0f) % 360.0f;
        if (fG > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(fG);
        this.f9953h.add(new b(dVar));
        p(f3);
    }

    private void c(g gVar, float f3, float f4) {
        b(f3);
        this.f9953h.add(gVar);
        p(f4);
    }

    private float g() {
        return this.f9950e;
    }

    private float h() {
        return this.f9951f;
    }

    private void p(float f3) {
        this.f9950e = f3;
    }

    private void q(float f3) {
        this.f9951f = f3;
    }

    private void r(float f3) {
        this.f9948c = f3;
    }

    private void s(float f3) {
        this.f9949d = f3;
    }

    private void t(float f3) {
        this.f9946a = f3;
    }

    private void u(float f3) {
        this.f9947b = f3;
    }

    public void a(float f3, float f4, float f5, float f6, float f7, float f8) {
        d dVar = new d(f3, f4, f5, f6);
        dVar.s(f7);
        dVar.t(f8);
        this.f9952g.add(dVar);
        b bVar = new b(dVar);
        float f9 = f7 + f8;
        boolean z3 = f8 < 0.0f;
        if (z3) {
            f7 = (f7 + 180.0f) % 360.0f;
        }
        c(bVar, f7, z3 ? (180.0f + f9) % 360.0f : f9);
        double d3 = f9;
        r(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.cos(Math.toRadians(d3)))));
        s(((f4 + f6) * 0.5f) + (((f6 - f4) / 2.0f) * ((float) Math.sin(Math.toRadians(d3)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f9952g.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((f) this.f9952g.get(i3)).a(matrix, path);
        }
    }

    boolean e() {
        return this.f9954i;
    }

    g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f9953h), new Matrix(matrix));
    }

    float i() {
        return this.f9948c;
    }

    float j() {
        return this.f9949d;
    }

    float k() {
        return this.f9946a;
    }

    float l() {
        return this.f9947b;
    }

    public void m(float f3, float f4) {
        e eVar = new e();
        eVar.f9969b = f3;
        eVar.f9970c = f4;
        this.f9952g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f3);
        s(f4);
    }

    public void n(float f3, float f4) {
        o(f3, f4, 270.0f, 0.0f);
    }

    public void o(float f3, float f4, float f5, float f6) {
        t(f3);
        u(f4);
        r(f3);
        s(f4);
        p(f5);
        q((f5 + f6) % 360.0f);
        this.f9952g.clear();
        this.f9953h.clear();
        this.f9954i = false;
    }
}
