package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f4486a = new ThreadLocal();

    static class a {
        static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    public static boolean a(Paint paint, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.a(paint, str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float fMeasureText = paint.measureText("\udfffd");
        float fMeasureText2 = paint.measureText("m");
        float fMeasureText3 = paint.measureText(str);
        float fMeasureText4 = 0.0f;
        if (fMeasureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (fMeasureText3 > fMeasureText2 * 2.0f) {
                return false;
            }
            int i3 = 0;
            while (i3 < length) {
                int iCharCount = Character.charCount(str.codePointAt(i3)) + i3;
                fMeasureText4 += paint.measureText(str, i3, iCharCount);
                i3 = iCharCount;
            }
            if (fMeasureText3 >= fMeasureText4) {
                return false;
            }
        }
        if (fMeasureText3 != fMeasureText) {
            return true;
        }
        p082z.d dVarB = b();
        paint.getTextBounds("\udfffd", 0, 2, (Rect) dVarB.f12977a);
        paint.getTextBounds(str, 0, length, (Rect) dVarB.f12978b);
        return !((Rect) dVarB.f12977a).equals(dVarB.f12978b);
    }

    private static p082z.d b() {
        ThreadLocal threadLocal = f4486a;
        p082z.d dVar = (p082z.d) threadLocal.get();
        if (dVar == null) {
            p082z.d dVar2 = new p082z.d(new Rect(), new Rect());
            threadLocal.set(dVar2);
            return dVar2;
        }
        ((Rect) dVar.f12977a).setEmpty();
        ((Rect) dVar.f12978b).setEmpty();
        return dVar;
    }
}
