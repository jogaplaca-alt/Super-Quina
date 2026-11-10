package F0;

import android.os.Bundle;

/* JADX INFO: renamed from: F0.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0225t implements D0.a.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0225t f995b = a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f996a;

    /* JADX INFO: renamed from: F0.t$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f997a;

        /* synthetic */ a(AbstractC0227v abstractC0227v) {
        }

        public C0225t a() {
            return new C0225t(this.f997a, null);
        }
    }

    /* synthetic */ C0225t(String str, AbstractC0228w abstractC0228w) {
        this.f996a = str;
    }

    public static a a() {
        return new a(null);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f996a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0225t) {
            return AbstractC0219m.a(this.f996a, ((C0225t) obj).f996a);
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0219m.b(this.f996a);
    }
}
