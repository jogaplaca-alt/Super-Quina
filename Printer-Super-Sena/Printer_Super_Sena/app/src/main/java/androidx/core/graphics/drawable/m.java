package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
final class m extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f4477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Drawable.ConstantState f4478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ColorStateList f4479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    PorterDuff.Mode f4480d;

    m(m mVar) {
        this.f4479c = null;
        this.f4480d = d.f4469g;
        if (mVar != null) {
            this.f4477a = mVar.f4477a;
            this.f4478b = mVar.f4478b;
            this.f4479c = mVar.f4479c;
            this.f4480d = mVar.f4480d;
        }
    }

    boolean a() {
        return this.f4478b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i3 = this.f4477a;
        Drawable.ConstantState constantState = this.f4478b;
        return i3 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new l(this, resources) : new d(this, resources);
    }
}
