package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Objects;

/* JADX INFO: renamed from: androidx.core.view.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0288d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f4633a;

    /* JADX INFO: renamed from: androidx.core.view.d$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f4634a;

        public a(ClipData clipData, int i3) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f4634a = new b(clipData, i3);
            } else {
                this.f4634a = new C0062d(clipData, i3);
            }
        }

        public C0288d a() {
            return this.f4634a.a();
        }

        public a b(Bundle bundle) {
            this.f4634a.setExtras(bundle);
            return this;
        }

        public a c(int i3) {
            this.f4634a.c(i3);
            return this;
        }

        public a d(Uri uri) {
            this.f4634a.b(uri);
            return this;
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.d$b */
    private static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentInfo.Builder f4635a;

        b(ClipData clipData, int i3) {
            this.f4635a = new ContentInfo.Builder(clipData, i3);
        }

        @Override // androidx.core.view.C0288d.c
        public C0288d a() {
            return new C0288d(new e(this.f4635a.build()));
        }

        @Override // androidx.core.view.C0288d.c
        public void b(Uri uri) {
            this.f4635a.setLinkUri(uri);
        }

        @Override // androidx.core.view.C0288d.c
        public void c(int i3) {
            this.f4635a.setFlags(i3);
        }

        @Override // androidx.core.view.C0288d.c
        public void setExtras(Bundle bundle) {
            this.f4635a.setExtras(bundle);
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.d$c */
    private interface c {
        C0288d a();

        void b(Uri uri);

        void c(int i3);

        void setExtras(Bundle bundle);
    }

    /* JADX INFO: renamed from: androidx.core.view.d$d, reason: collision with other inner class name */
    private static final class C0062d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ClipData f4636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f4638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Uri f4639d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Bundle f4640e;

        C0062d(ClipData clipData, int i3) {
            this.f4636a = clipData;
            this.f4637b = i3;
        }

        @Override // androidx.core.view.C0288d.c
        public C0288d a() {
            return new C0288d(new g(this));
        }

        @Override // androidx.core.view.C0288d.c
        public void b(Uri uri) {
            this.f4639d = uri;
        }

        @Override // androidx.core.view.C0288d.c
        public void c(int i3) {
            this.f4638c = i3;
        }

        @Override // androidx.core.view.C0288d.c
        public void setExtras(Bundle bundle) {
            this.f4640e = bundle;
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.d$e */
    private static final class e implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentInfo f4641a;

        e(ContentInfo contentInfo) {
            this.f4641a = AbstractC0286c.a(p082z.h.g(contentInfo));
        }

        @Override // androidx.core.view.C0288d.f
        public ClipData a() {
            return this.f4641a.getClip();
        }

        @Override // androidx.core.view.C0288d.f
        public int b() {
            return this.f4641a.getFlags();
        }

        @Override // androidx.core.view.C0288d.f
        public ContentInfo c() {
            return this.f4641a;
        }

        @Override // androidx.core.view.C0288d.f
        public int d() {
            return this.f4641a.getSource();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f4641a + "}";
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.d$f */
    private interface f {
        ClipData a();

        int b();

        ContentInfo c();

        int d();
    }

    /* JADX INFO: renamed from: androidx.core.view.d$g */
    private static final class g implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ClipData f4642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f4643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f4644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Uri f4645d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Bundle f4646e;

        g(C0062d c0062d) {
            this.f4642a = (ClipData) p082z.h.g(c0062d.f4636a);
            this.f4643b = p082z.h.c(c0062d.f4637b, 0, 5, "source");
            this.f4644c = p082z.h.f(c0062d.f4638c, 1);
            this.f4645d = c0062d.f4639d;
            this.f4646e = c0062d.f4640e;
        }

        @Override // androidx.core.view.C0288d.f
        public ClipData a() {
            return this.f4642a;
        }

        @Override // androidx.core.view.C0288d.f
        public int b() {
            return this.f4644c;
        }

        @Override // androidx.core.view.C0288d.f
        public ContentInfo c() {
            return null;
        }

        @Override // androidx.core.view.C0288d.f
        public int d() {
            return this.f4643b;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f4642a.getDescription());
            sb.append(", source=");
            sb.append(C0288d.e(this.f4643b));
            sb.append(", flags=");
            sb.append(C0288d.a(this.f4644c));
            if (this.f4645d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f4645d.toString().length() + ")";
            }
            sb.append(str);
            sb.append(this.f4646e != null ? ", hasExtras" : "");
            sb.append("}");
            return sb.toString();
        }
    }

    C0288d(f fVar) {
        this.f4633a = fVar;
    }

    static String a(int i3) {
        return (i3 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i3);
    }

    static String e(int i3) {
        if (i3 == 0) {
            return "SOURCE_APP";
        }
        if (i3 == 1) {
            return "SOURCE_CLIPBOARD";
        }
        if (i3 == 2) {
            return "SOURCE_INPUT_METHOD";
        }
        if (i3 == 3) {
            return "SOURCE_DRAG_AND_DROP";
        }
        if (i3 != 4) {
            return i3 != 5 ? String.valueOf(i3) : "SOURCE_PROCESS_TEXT";
        }
        return "SOURCE_AUTOFILL";
    }

    public static C0288d g(ContentInfo contentInfo) {
        return new C0288d(new e(contentInfo));
    }

    public ClipData b() {
        return this.f4633a.a();
    }

    public int c() {
        return this.f4633a.b();
    }

    public int d() {
        return this.f4633a.d();
    }

    public ContentInfo f() {
        ContentInfo contentInfoC = this.f4633a.c();
        Objects.requireNonNull(contentInfoC);
        return AbstractC0286c.a(contentInfoC);
    }

    public String toString() {
        return this.f4633a.toString();
    }
}
