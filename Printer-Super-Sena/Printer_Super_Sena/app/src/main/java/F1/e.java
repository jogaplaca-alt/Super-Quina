package F1;

import S1.k;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1015b;

    public e(int i3, String str) {
        k.e(str, "tag");
        this.f1014a = i3;
        this.f1015b = str;
    }

    @Override // F1.f
    public void a(Exception exc) {
        k.e(exc, "e");
        Log.w(this.f1015b, exc.getMessage(), exc);
    }

    @Override // F1.f
    public void b(String str) {
        k.e(str, "msg");
        Log.println(this.f1014a, this.f1015b, str);
    }
}
