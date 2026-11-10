package p022f1;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.activity.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimeInterpolator f9539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final View f9540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f9541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f9542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final int f9543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f9544f;

    public a(View view) {
        this.f9540b = view;
        Context context = view.getContext();
        this.f9539a = h.g(context, S0.a.f1490H, androidx.core.view.animation.b.a(0.0f, 0.0f, 0.0f, 1.0f));
        this.f9541c = h.f(context, S0.a.f1534z, 300);
        this.f9542d = h.f(context, S0.a.f1485C, 150);
        this.f9543e = h.f(context, S0.a.f1484B, 100);
    }

    public float a(float f3) {
        return this.f9539a.getInterpolation(f3);
    }

    protected b b() {
        if (this.f9544f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        b bVar = this.f9544f;
        this.f9544f = null;
        return bVar;
    }

    public b c() {
        b bVar = this.f9544f;
        this.f9544f = null;
        return bVar;
    }

    protected void d(b bVar) {
        this.f9544f = bVar;
    }

    protected b e(b bVar) {
        if (this.f9544f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        b bVar2 = this.f9544f;
        this.f9544f = bVar;
        return bVar2;
    }
}
