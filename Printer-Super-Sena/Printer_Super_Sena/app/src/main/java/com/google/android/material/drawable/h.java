package com.google.android.material.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    private static class a {
        static void a(Outline outline, Path path) {
            outline.setConvexPath(path);
        }
    }

    private static class b {
        static void a(Outline outline, Path path) {
            outline.setPath(path);
        }
    }

    public static Drawable a(Drawable drawable, Drawable drawable2) {
        return b(drawable, drawable2, -1, -1);
    }

    public static Drawable b(Drawable drawable, Drawable drawable2, int i3, int i4) {
        if (drawable == null) {
            return drawable2;
        }
        if (drawable2 == null) {
            return drawable;
        }
        boolean z3 = (i3 == -1 || i4 == -1) ? false : true;
        if (i3 == -1) {
            i3 = h(drawable, drawable2);
        }
        if (i4 == -1) {
            i4 = g(drawable, drawable2);
        }
        if (i3 > drawable.getIntrinsicWidth() || i4 > drawable.getIntrinsicHeight()) {
            float f3 = i3 / i4;
            if (f3 >= drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                i4 = (int) (intrinsicWidth / f3);
                i3 = intrinsicWidth;
            } else {
                i4 = drawable.getIntrinsicHeight();
                i3 = (int) (f3 * i4);
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
            layerDrawable.setLayerSize(1, i3, i4);
            layerDrawable.setLayerGravity(1, 17);
            return layerDrawable;
        }
        if (z3) {
            drawable2 = new j(drawable2, i3, i4);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{drawable, drawable2});
        int iMax = Math.max((drawable.getIntrinsicWidth() - i3) / 2, 0);
        int iMax2 = Math.max((drawable.getIntrinsicHeight() - i4) / 2, 0);
        layerDrawable2.setLayerInset(1, iMax, iMax2, iMax, iMax2);
        return layerDrawable2;
    }

    public static Drawable c(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        return d(drawable, colorStateList, mode, Build.VERSION.SDK_INT < 23);
    }

    private static Drawable d(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode, boolean z3) {
        if (drawable == null) {
            return null;
        }
        if (colorStateList != null) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            if (mode != null) {
                androidx.core.graphics.drawable.a.p(drawable, mode);
            }
        } else if (z3) {
            drawable.mutate();
        }
        return drawable;
    }

    public static int[] e(int[] iArr) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            if (i4 == 16842912) {
                return iArr;
            }
            if (i4 == 0) {
                int[] iArr2 = (int[]) iArr.clone();
                iArr2[i3] = 16842912;
                return iArr2;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length + 1);
        iArrCopyOf[iArr.length] = 16842912;
        return iArrCopyOf;
    }

    public static ColorStateList f(Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !c.a(drawable)) {
            return null;
        }
        return d.a(drawable).getColorStateList();
    }

    private static int g(Drawable drawable, Drawable drawable2) {
        int intrinsicHeight = drawable2.getIntrinsicHeight();
        return intrinsicHeight != -1 ? intrinsicHeight : drawable.getIntrinsicHeight();
    }

    private static int h(Drawable drawable, Drawable drawable2) {
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        return intrinsicWidth != -1 ? intrinsicWidth : drawable.getIntrinsicWidth();
    }

    public static AttributeSet i(Context context, int i3, CharSequence charSequence) {
        int next;
        try {
            XmlResourceParser xml = context.getResources().getXml(i3);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            if (TextUtils.equals(xml.getName(), charSequence)) {
                return Xml.asAttributeSet(xml);
            }
            throw new XmlPullParserException("Must have a <" + ((Object) charSequence) + "> start tag");
        } catch (IOException e3) {
            e = e3;
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i3));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (XmlPullParserException e4) {
            e = e4;
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i3));
            notFoundException2.initCause(e);
            throw notFoundException2;
        }
    }

    public static void j(Outline outline, Path path) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            b.a(outline, path);
            return;
        }
        if (i3 >= 29) {
            try {
                a.a(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else {
            if (i3 < 21 || !path.isConvex()) {
                return;
            }
            a.a(outline, path);
        }
    }

    public static void k(Drawable drawable, int i3) {
        boolean z3 = i3 != 0;
        if (Build.VERSION.SDK_INT == 21) {
            if (z3) {
                drawable.setColorFilter(i3, PorterDuff.Mode.SRC_IN);
                return;
            } else {
                drawable.setColorFilter(null);
                return;
            }
        }
        if (z3) {
            androidx.core.graphics.drawable.a.n(drawable, i3);
        } else {
            androidx.core.graphics.drawable.a.o(drawable, null);
        }
    }

    public static PorterDuffColorFilter l(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }
}
