package p079y;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b[] f12805b;

        public a(int i3, b[] bVarArr) {
            this.f12804a = i3;
            this.f12805b = bVarArr;
        }

        static a a(int i3, b[] bVarArr) {
            return new a(i3, bVarArr);
        }

        public b[] b() {
            return this.f12805b;
        }

        public int c() {
            return this.f12804a;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f12806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f12807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f12808c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f12809d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f12810e;

        public b(Uri uri, int i3, int i4, boolean z3, int i5) {
            this.f12806a = (Uri) p082z.h.g(uri);
            this.f12807b = i3;
            this.f12808c = i4;
            this.f12809d = z3;
            this.f12810e = i5;
        }

        static b a(Uri uri, int i3, int i4, boolean z3, int i5) {
            return new b(uri, i3, i4, z3, i5);
        }

        public int b() {
            return this.f12810e;
        }

        public int c() {
            return this.f12807b;
        }

        public Uri d() {
            return this.f12806a;
        }

        public int e() {
            return this.f12808c;
        }

        public boolean f() {
            return this.f12809d;
        }
    }

    public static class c {
        public abstract void a(int i3);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return androidx.core.graphics.h.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, f fVar) {
        return e.e(context, fVar, cancellationSignal);
    }

    public static Typeface c(Context context, f fVar, int i3, boolean z3, int i4, Handler handler, c cVar) {
        p079y.a aVar = new p079y.a(cVar, handler);
        return z3 ? g.e(context, fVar, aVar, i3, i4) : g.d(context, fVar, i3, null, aVar);
    }
}
