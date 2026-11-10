package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class i0 extends b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference f3534b;

    public i0(Context context, Resources resources) {
        super(resources);
        this.f3534b = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i3) {
        Drawable drawableA = a(i3);
        Context context = (Context) this.f3534b.get();
        if (drawableA != null && context != null) {
            a0.h().x(context, i3, drawableA);
        }
        return drawableA;
    }
}
