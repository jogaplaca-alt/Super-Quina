package F0;

import android.content.Intent;

/* JADX INFO: renamed from: F0.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0231z extends A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f1003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ E0.e f1004b;

    C0231z(Intent intent, E0.e eVar, int i3) {
        this.f1003a = intent;
        this.f1004b = eVar;
    }

    @Override // F0.A
    public final void a() {
        Intent intent = this.f1003a;
        if (intent != null) {
            this.f1004b.startActivityForResult(intent, 2);
        }
    }
}
