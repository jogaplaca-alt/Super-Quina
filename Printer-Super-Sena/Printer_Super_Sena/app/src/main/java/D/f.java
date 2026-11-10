package D;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f167a;

    private interface c {
        void a();

        Uri b();

        ClipDescription c();

        Object d();

        Uri e();
    }

    public f(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f167a = new a(uri, clipDescription, uri2);
        } else {
            this.f167a = new b(uri, clipDescription, uri2);
        }
    }

    public static f f(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new f(new a(obj));
        }
        return null;
    }

    public Uri a() {
        return this.f167a.e();
    }

    public ClipDescription b() {
        return this.f167a.c();
    }

    public Uri c() {
        return this.f167a.b();
    }

    public void d() {
        this.f167a.a();
    }

    public Object e() {
        return this.f167a.d();
    }

    private static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final InputContentInfo f168a;

        a(Object obj) {
            this.f168a = (InputContentInfo) obj;
        }

        @Override // D.f.c
        public void a() {
            this.f168a.requestPermission();
        }

        @Override // D.f.c
        public Uri b() {
            return this.f168a.getLinkUri();
        }

        @Override // D.f.c
        public ClipDescription c() {
            return this.f168a.getDescription();
        }

        @Override // D.f.c
        public Object d() {
            return this.f168a;
        }

        @Override // D.f.c
        public Uri e() {
            return this.f168a.getContentUri();
        }

        a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f168a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    private f(c cVar) {
        this.f167a = cVar;
    }

    private static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ClipDescription f170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Uri f171c;

        b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f169a = uri;
            this.f170b = clipDescription;
            this.f171c = uri2;
        }

        @Override // D.f.c
        public Uri b() {
            return this.f171c;
        }

        @Override // D.f.c
        public ClipDescription c() {
            return this.f170b;
        }

        @Override // D.f.c
        public Object d() {
            return null;
        }

        @Override // D.f.c
        public Uri e() {
            return this.f169a;
        }

        @Override // D.f.c
        public void a() {
        }
    }
}
