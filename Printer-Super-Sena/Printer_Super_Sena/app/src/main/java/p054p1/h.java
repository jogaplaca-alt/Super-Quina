package p054p1;

import R0.d;
import R0.e;
import R0.g;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;

/* JADX INFO: loaded from: classes.dex */
public final class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f10494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f10495b = new Handler(Looper.getMainLooper());

    h(m mVar) {
        this.f10494a = mVar;
    }

    @Override // p054p1.c
    public final d a(Activity activity, b bVar) {
        if (bVar.d()) {
            return g.b(null);
        }
        Intent intent = new Intent(activity, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", bVar.c());
        intent.putExtra("window_flags", activity.getWindow().getDecorView().getWindowSystemUiVisibility());
        e eVar = new e();
        intent.putExtra("result_receiver", new g(this, this.f10495b, eVar));
        activity.startActivity(intent);
        return eVar.a();
    }

    @Override // p054p1.c
    public final d b() {
        return this.f10494a.a();
    }
}
