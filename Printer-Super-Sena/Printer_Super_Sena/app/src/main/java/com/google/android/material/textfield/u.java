package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.Z;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
abstract class u {
    static void a(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            } else {
                androidx.core.graphics.drawable.a.o(drawable, ColorStateList.valueOf(colorStateList.getColorForState(c(textInputLayout, checkableImageButton), colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                androidx.core.graphics.drawable.a.p(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    static ImageView.ScaleType b(int i3) {
        if (i3 == 0) {
            return ImageView.ScaleType.FIT_XY;
        }
        if (i3 == 1) {
            return ImageView.ScaleType.FIT_START;
        }
        if (i3 == 2) {
            return ImageView.ScaleType.FIT_CENTER;
        }
        if (i3 == 3) {
            return ImageView.ScaleType.FIT_END;
        }
        if (i3 != 5) {
            return i3 != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE;
        }
        return ImageView.ScaleType.CENTER_CROP;
    }

    private static int[] c(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton) {
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        return iArrCopyOf;
    }

    static void d(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(c(textInputLayout, checkableImageButton), colorStateList.getDefaultColor());
        Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
        androidx.core.graphics.drawable.a.o(drawableMutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    static void e(CheckableImageButton checkableImageButton) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 21 || i3 > 22) {
            return;
        }
        checkableImageButton.setBackground(p033i1.b.b(checkableImageButton.getContext(), (int) com.google.android.material.internal.F.c(checkableImageButton.getContext(), 4)));
    }

    private static void f(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zQ = Z.Q(checkableImageButton);
        boolean z3 = onLongClickListener != null;
        boolean z4 = zQ || z3;
        checkableImageButton.setFocusable(z4);
        checkableImageButton.setClickable(zQ);
        checkableImageButton.setPressable(zQ);
        checkableImageButton.setLongClickable(z3);
        Z.z0(checkableImageButton, z4 ? 1 : 2);
    }

    static void g(CheckableImageButton checkableImageButton, int i3) {
        checkableImageButton.setMinimumWidth(i3);
        checkableImageButton.setMinimumHeight(i3);
    }

    static void h(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        f(checkableImageButton, onLongClickListener);
    }

    static void i(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        f(checkableImageButton, onLongClickListener);
    }

    static void j(CheckableImageButton checkableImageButton, ImageView.ScaleType scaleType) {
        checkableImageButton.setScaleType(scaleType);
    }
}
