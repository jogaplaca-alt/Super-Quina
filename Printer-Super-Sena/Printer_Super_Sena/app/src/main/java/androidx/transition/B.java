package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
abstract class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final E f6546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Property f6547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Property f6548c;

    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(B.b(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f3) {
            B.e(view, f3.floatValue());
        }
    }

    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return view.getClipBounds();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            f6546a = new N();
        } else if (i3 >= 23) {
            f6546a = new M();
        } else if (i3 >= 22) {
            f6546a = new K();
        } else if (i3 >= 21) {
            f6546a = new I();
        } else {
            f6546a = new E();
        }
        f6547b = new a(Float.class, "translationAlpha");
        f6548c = new b(Rect.class, "clipBounds");
    }

    static void a(View view) {
        f6546a.a(view);
    }

    static float b(View view) {
        return f6546a.c(view);
    }

    static void c(View view) {
        f6546a.d(view);
    }

    static void d(View view, int i3, int i4, int i5, int i6) {
        f6546a.e(view, i3, i4, i5, i6);
    }

    static void e(View view, float f3) {
        f6546a.f(view, f3);
    }

    static void f(View view, int i3) {
        f6546a.g(view, i3);
    }

    static void g(View view, Matrix matrix) {
        f6546a.h(view, matrix);
    }

    static void h(View view, Matrix matrix) {
        f6546a.i(view, matrix);
    }
}
