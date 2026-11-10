package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    static class a {
        static ColorStateList a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        static PorterDuff.Mode b(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        static void c(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
        }

        static void d(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList a(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.a(imageView);
        }
        if (imageView instanceof p) {
            return ((p) imageView).getSupportImageTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode b(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.b(imageView);
        }
        if (imageView instanceof p) {
            return ((p) imageView).getSupportImageTintMode();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(ImageView imageView, ColorStateList colorStateList) {
        Drawable drawable;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 21) {
            if (imageView instanceof p) {
                ((p) imageView).setSupportImageTintList(colorStateList);
                return;
            }
            return;
        }
        a.c(imageView, colorStateList);
        if (i3 != 21 || (drawable = imageView.getDrawable()) == null || a.a(imageView) == null) {
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(imageView.getDrawableState());
        }
        imageView.setImageDrawable(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(ImageView imageView, PorterDuff.Mode mode) {
        Drawable drawable;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 21) {
            if (imageView instanceof p) {
                ((p) imageView).setSupportImageTintMode(mode);
                return;
            }
            return;
        }
        a.d(imageView, mode);
        if (i3 != 21 || (drawable = imageView.getDrawable()) == null || a.a(imageView) == null) {
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(imageView.getDrawableState());
        }
        imageView.setImageDrawable(drawable);
    }
}
