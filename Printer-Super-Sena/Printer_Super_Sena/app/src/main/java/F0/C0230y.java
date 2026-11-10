package F0;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: renamed from: F0.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0230y extends A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f1000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f1001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f1002c;

    C0230y(Intent intent, Activity activity, int i3) {
        this.f1000a = intent;
        this.f1001b = activity;
        this.f1002c = i3;
    }

    @Override // F0.A
    public final void a() {
        Intent intent = this.f1000a;
        if (intent != null) {
            this.f1001b.startActivityForResult(intent, this.f1002c);
        }
    }
}
