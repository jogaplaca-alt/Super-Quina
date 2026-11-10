package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
abstract class f {
    private static a a(a aVar, int i3, int i4, boolean z3, int i5) {
        if (aVar != null) {
            return aVar;
        }
        return z3 ? new a(i3, i5, i4) : new a(i3, i4);
    }

    static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayK = k.k(resources, theme, attributeSet, p070v.c.f12389A);
        float f3 = k.f(typedArrayK, xmlPullParser, "startX", p070v.c.f12398J, 0.0f);
        float f4 = k.f(typedArrayK, xmlPullParser, "startY", p070v.c.f12399K, 0.0f);
        float f5 = k.f(typedArrayK, xmlPullParser, "endX", p070v.c.f12400L, 0.0f);
        float f6 = k.f(typedArrayK, xmlPullParser, "endY", p070v.c.f12401M, 0.0f);
        float f7 = k.f(typedArrayK, xmlPullParser, "centerX", p070v.c.f12393E, 0.0f);
        float f8 = k.f(typedArrayK, xmlPullParser, "centerY", p070v.c.f12394F, 0.0f);
        int iG = k.g(typedArrayK, xmlPullParser, "type", p070v.c.f12392D, 0);
        int iB = k.b(typedArrayK, xmlPullParser, "startColor", p070v.c.f12390B, 0);
        boolean zJ = k.j(xmlPullParser, "centerColor");
        int iB2 = k.b(typedArrayK, xmlPullParser, "centerColor", p070v.c.f12397I, 0);
        int iB3 = k.b(typedArrayK, xmlPullParser, "endColor", p070v.c.f12391C, 0);
        int iG2 = k.g(typedArrayK, xmlPullParser, "tileMode", p070v.c.f12396H, 0);
        float f9 = k.f(typedArrayK, xmlPullParser, "gradientRadius", p070v.c.f12395G, 0.0f);
        typedArrayK.recycle();
        a aVarA = a(c(resources, xmlPullParser, attributeSet, theme), iB, iB3, zJ, iB2);
        if (iG != 1) {
            return iG != 2 ? new LinearGradient(f3, f4, f5, f6, aVarA.f4394a, aVarA.f4395b, d(iG2)) : new SweepGradient(f7, f8, aVarA.f4394a, aVarA.f4395b);
        }
        if (f9 > 0.0f) {
            return new RadialGradient(f7, f8, f9, aVarA.f4394a, aVarA.f4395b, d(iG2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    private static a c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayK = k.k(resources, theme, attributeSet, p070v.c.f12402N);
                int i3 = p070v.c.f12403O;
                boolean zHasValue = typedArrayK.hasValue(i3);
                int i4 = p070v.c.f12404P;
                boolean zHasValue2 = typedArrayK.hasValue(i4);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color = typedArrayK.getColor(i3, 0);
                float f3 = typedArrayK.getFloat(i4, 0.0f);
                typedArrayK.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f3));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    private static Shader.TileMode d(int i3) {
        if (i3 != 1) {
            return i3 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f4394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float[] f4395b;

        a(List list, List list2) {
            int size = list.size();
            this.f4394a = new int[size];
            this.f4395b = new float[size];
            for (int i3 = 0; i3 < size; i3++) {
                this.f4394a[i3] = ((Integer) list.get(i3)).intValue();
                this.f4395b[i3] = ((Float) list2.get(i3)).floatValue();
            }
        }

        a(int i3, int i4) {
            this.f4394a = new int[]{i3, i4};
            this.f4395b = new float[]{0.0f, 1.0f};
        }

        a(int i3, int i4, int i5) {
            this.f4394a = new int[]{i3, i4, i5};
            this.f4395b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
