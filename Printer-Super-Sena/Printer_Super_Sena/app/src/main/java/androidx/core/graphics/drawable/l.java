package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0272p;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class l extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Method f4476h;

    l(Drawable drawable) {
        super(drawable);
        g();
    }

    private void g() {
        if (f4476h == null) {
            try {
                f4476h = Drawable.class.getDeclaredMethod("isProjected", null);
            } catch (Exception e3) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e3);
            }
        }
    }

    @Override // androidx.core.graphics.drawable.d
    protected boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f4475f;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || AbstractC0272p.a(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f4475f.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f4475f.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f4475f;
        if (drawable == null || (method = f4476h) == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(drawable, null)).booleanValue();
        } catch (Exception e3) {
            Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e3);
            return false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f3, float f4) {
        this.f4475f.setHotspot(f3, f4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i3, int i4, int i5, int i6) {
        this.f4475f.setHotspotBounds(i3, i4, i5, i6);
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i3) {
        if (c()) {
            super.setTint(i3);
        } else {
            this.f4475f.setTint(i3);
        }
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.f4475f.setTintList(colorStateList);
        }
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.f4475f.setTintMode(mode);
        }
    }

    l(m mVar, Resources resources) {
        super(mVar, resources);
        g();
    }
}
