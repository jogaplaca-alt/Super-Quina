package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CheckedTextView;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    private static class a {
        static void a(CheckedTextView checkedTextView, ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        static void b(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    public static Drawable a(CheckedTextView checkedTextView) {
        return checkedTextView.getCheckMarkDrawable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(CheckedTextView checkedTextView, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            a.a(checkedTextView, colorStateList);
        } else if (checkedTextView instanceof m) {
            ((m) checkedTextView).setSupportCheckMarkTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            a.b(checkedTextView, mode);
        } else if (checkedTextView instanceof m) {
            ((m) checkedTextView).setSupportCheckMarkTintMode(mode);
        }
    }
}
