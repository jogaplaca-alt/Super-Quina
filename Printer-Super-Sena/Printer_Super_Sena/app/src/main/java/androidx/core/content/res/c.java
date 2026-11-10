package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f4379a = new ThreadLocal();

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return e(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static TypedValue c() {
        ThreadLocal threadLocal = f4379a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList d(Resources resources, int i3, Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i3), theme);
        } catch (Exception e3) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e3);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0095  */
    private static ColorStateList e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int color;
        float f3;
        int i3 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrA = new int[20];
        int i4 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i3 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayH = h(resources, theme, attributeSet, p070v.c.f12406b);
                int i5 = p070v.c.f12407c;
                int resourceId = typedArrayH.getResourceId(i5, -1);
                if (resourceId == -1 || f(resources, resourceId)) {
                    color = typedArrayH.getColor(i5, -65281);
                } else {
                    try {
                        color = a(resources, resources.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        color = typedArrayH.getColor(p070v.c.f12407c, -65281);
                    }
                }
                int i6 = p070v.c.f12408d;
                float f4 = 1.0f;
                if (typedArrayH.hasValue(i6)) {
                    f4 = typedArrayH.getFloat(i6, 1.0f);
                } else {
                    int i7 = p070v.c.f12410f;
                    if (typedArrayH.hasValue(i7)) {
                        f4 = typedArrayH.getFloat(i7, 1.0f);
                    }
                }
                if (Build.VERSION.SDK_INT >= 31) {
                    int i8 = p070v.c.f12409e;
                    if (typedArrayH.hasValue(i8)) {
                        f3 = typedArrayH.getFloat(i8, -1.0f);
                    } else {
                        f3 = typedArrayH.getFloat(p070v.c.f12411g, -1.0f);
                    }
                } else {
                    f3 = typedArrayH.getFloat(p070v.c.f12411g, -1.0f);
                }
                typedArrayH.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i9 = 0;
                for (int i10 = 0; i10 < attributeCount; i10++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i10);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != p070v.a.f12340a && attributeNameResource != p070v.a.f12341b) {
                        int i11 = i9 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i10, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i9] = attributeNameResource;
                        i9 = i11;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i9);
                iArrA = g.a(iArrA, i4, g(color, f4, f3));
                iArr = (int[][]) g.b(iArr, i4, iArrTrimStateSet);
                i4++;
            }
            i3 = 1;
        }
        int[] iArr3 = new int[i4];
        int[][] iArr4 = new int[i4][];
        System.arraycopy(iArrA, 0, iArr3, 0, i4);
        System.arraycopy(iArr, 0, iArr4, 0, i4);
        return new ColorStateList(iArr4, iArr3);
    }

    private static boolean f(Resources resources, int i3) {
        TypedValue typedValueC = c();
        resources.getValue(i3, typedValueC, true);
        int i4 = typedValueC.type;
        return i4 >= 28 && i4 <= 31;
    }

    private static int g(int i3, float f3, float f4) {
        boolean z3 = f4 >= 0.0f && f4 <= 100.0f;
        if (f3 == 1.0f && !z3) {
            return i3;
        }
        int iB = p076x.a.b((int) ((Color.alpha(i3) * f3) + 0.5f), 0, 255);
        if (z3) {
            a aVarC = a.c(i3);
            i3 = a.m(aVarC.j(), aVarC.i(), f4);
        }
        return (i3 & 16777215) | (iB << 24);
    }

    private static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
