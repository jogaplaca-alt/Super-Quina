package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    private static class a implements TypeEvaluator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private androidx.core.graphics.g.b[] f6746a;

        a() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public androidx.core.graphics.g.b[] evaluate(float f3, androidx.core.graphics.g.b[] bVarArr, androidx.core.graphics.g.b[] bVarArr2) {
            if (!androidx.core.graphics.g.b(bVarArr, bVarArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!androidx.core.graphics.g.b(this.f6746a, bVarArr)) {
                this.f6746a = androidx.core.graphics.g.f(bVarArr);
            }
            for (int i3 = 0; i3 < bVarArr.length; i3++) {
                this.f6746a[i3].h(bVarArr[i3], bVarArr2[i3], f3);
            }
            return this.f6746a;
        }
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f3) {
        return b(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f3);
    }

    private static Animator b(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i3, float f3) throws XmlPullParserException, IOException {
        int i4;
        int depth = xmlPullParser.getDepth();
        Animator animatorL = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            i4 = 0;
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("objectAnimator")) {
                    animatorL = n(context, resources, theme, attributeSet, f3, xmlPullParser);
                } else {
                    if (name.equals("animator")) {
                        animatorL = l(context, resources, theme, attributeSet, null, f3, xmlPullParser);
                    } else if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray typedArrayK = androidx.core.content.res.k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f6724h);
                        b(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, androidx.core.content.res.k.g(typedArrayK, xmlPullParser, "ordering", 0, 0), f3);
                        typedArrayK.recycle();
                        animatorL = animatorSet2;
                    } else {
                        if (!name.equals("propertyValuesHolder")) {
                            throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                        }
                        PropertyValuesHolder[] propertyValuesHolderArrP = p(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                        if (propertyValuesHolderArrP != null && (animatorL instanceof ValueAnimator)) {
                            ((ValueAnimator) animatorL).setValues(propertyValuesHolderArrP);
                        }
                        i4 = 1;
                    }
                    if (animatorSet == null && i4 == 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(animatorL);
                    }
                }
                if (animatorSet == null) {
                }
            }
        }
        if (animatorSet != null && arrayList != null) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i4] = (Animator) it.next();
                i4++;
            }
            if (i3 == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animatorL;
    }

    private static Keyframe c(Keyframe keyframe, float f3) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f3);
        }
        return keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f3) : Keyframe.ofObject(f3);
    }

    private static void d(Keyframe[] keyframeArr, float f3, int i3, int i4) {
        float f4 = f3 / ((i4 - i3) + 2);
        while (i3 <= i4) {
            keyframeArr[i3].setFraction(keyframeArr[i3 - 1].getFraction() + f4);
            i3++;
        }
    }

    private static PropertyValuesHolder e(TypedArray typedArray, int i3, int i4, int i5, String str) {
        int color;
        int color2;
        int color3;
        PropertyValuesHolder propertyValuesHolderOfFloat;
        PropertyValuesHolder propertyValuesHolderOfObject;
        TypedValue typedValuePeekValue = typedArray.peekValue(i4);
        boolean z3 = typedValuePeekValue != null;
        int i6 = z3 ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i5);
        boolean z4 = typedValuePeekValue2 != null;
        int i7 = z4 ? typedValuePeekValue2.type : 0;
        if (i3 == 4) {
            i3 = ((z3 && h(i6)) || (z4 && h(i7))) ? 3 : 0;
        }
        boolean z5 = i3 == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (i3 == 2) {
            String string = typedArray.getString(i4);
            String string2 = typedArray.getString(i5);
            androidx.core.graphics.g.b[] bVarArrD = androidx.core.graphics.g.d(string);
            androidx.core.graphics.g.b[] bVarArrD2 = androidx.core.graphics.g.d(string2);
            if (bVarArrD == null && bVarArrD2 == null) {
                return null;
            }
            if (bVarArrD == null) {
                if (bVarArrD2 != null) {
                    return PropertyValuesHolder.ofObject(str, new a(), bVarArrD2);
                }
                return null;
            }
            a aVar = new a();
            if (bVarArrD2 == null) {
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, bVarArrD);
            } else {
                if (!androidx.core.graphics.g.b(bVarArrD, bVarArrD2)) {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, bVarArrD, bVarArrD2);
            }
            return propertyValuesHolderOfObject;
        }
        n nVarA = i3 == 3 ? n.a() : null;
        if (z5) {
            if (z3) {
                float dimension = i6 == 5 ? typedArray.getDimension(i4, 0.0f) : typedArray.getFloat(i4, 0.0f);
                if (z4) {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension, i7 == 5 ? typedArray.getDimension(i5, 0.0f) : typedArray.getFloat(i5, 0.0f));
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
                }
            } else {
                propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, i7 == 5 ? typedArray.getDimension(i5, 0.0f) : typedArray.getFloat(i5, 0.0f));
            }
            propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
        } else if (z3) {
            if (i6 == 5) {
                color2 = (int) typedArray.getDimension(i4, 0.0f);
            } else {
                color2 = h(i6) ? typedArray.getColor(i4, 0) : typedArray.getInt(i4, 0);
            }
            if (z4) {
                if (i7 == 5) {
                    color3 = (int) typedArray.getDimension(i5, 0.0f);
                } else {
                    color3 = h(i7) ? typedArray.getColor(i5, 0) : typedArray.getInt(i5, 0);
                }
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2, color3);
            } else {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2);
            }
        } else if (z4) {
            if (i7 == 5) {
                color = (int) typedArray.getDimension(i5, 0.0f);
            } else {
                color = h(i7) ? typedArray.getColor(i5, 0) : typedArray.getInt(i5, 0);
            }
            propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color);
        }
        if (propertyValuesHolderOfInt == null || nVarA == null) {
            return propertyValuesHolderOfInt;
        }
        propertyValuesHolderOfInt.setEvaluator(nVarA);
        return propertyValuesHolderOfInt;
    }

    private static int f(TypedArray typedArray, int i3, int i4) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i3);
        boolean z3 = typedValuePeekValue != null;
        int i5 = z3 ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i4);
        boolean z4 = typedValuePeekValue2 != null;
        return ((z3 && h(i5)) || (z4 && h(z4 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
    }

    private static int g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayK = androidx.core.content.res.k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f6726j);
        int i3 = 0;
        TypedValue typedValueL = androidx.core.content.res.k.l(typedArrayK, xmlPullParser, "value", 0);
        if (typedValueL != null && h(typedValueL.type)) {
            i3 = 3;
        }
        typedArrayK.recycle();
        return i3;
    }

    private static boolean h(int i3) {
        return i3 >= 28 && i3 <= 31;
    }

    public static Animator i(Context context, int i3) {
        return Build.VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i3) : j(context, context.getResources(), context.getTheme(), i3);
    }

    public static Animator j(Context context, Resources resources, Resources.Theme theme, int i3) {
        return k(context, resources, theme, i3, 1.0f);
    }

    public static Animator k(Context context, Resources resources, Resources.Theme theme, int i3, float f3) {
        XmlResourceParser animation = null;
        try {
            try {
                try {
                    animation = resources.getAnimation(i3);
                    Animator animatorA = a(context, resources, theme, animation, f3);
                    if (animation != null) {
                        animation.close();
                    }
                    return animatorA;
                } catch (IOException e3) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i3));
                    notFoundException.initCause(e3);
                    throw notFoundException;
                }
            } catch (XmlPullParserException e4) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i3));
                notFoundException2.initCause(e4);
                throw notFoundException2;
            }
        } catch (Throwable th) {
            if (animation != null) {
                animation.close();
            }
            throw th;
        }
    }

    private static ValueAnimator l(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f3, XmlPullParser xmlPullParser) {
        TypedArray typedArrayK = androidx.core.content.res.k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f6723g);
        TypedArray typedArrayK2 = androidx.core.content.res.k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f6727k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        q(valueAnimator, typedArrayK, typedArrayK2, f3, xmlPullParser);
        int iH = androidx.core.content.res.k.h(typedArrayK, xmlPullParser, "interpolator", 0, 0);
        if (iH > 0) {
            valueAnimator.setInterpolator(l.b(context, iH));
        }
        typedArrayK.recycle();
        if (typedArrayK2 != null) {
            typedArrayK2.recycle();
        }
        return valueAnimator;
    }

    private static Keyframe m(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i3, XmlPullParser xmlPullParser) {
        Keyframe keyframeOfFloat;
        TypedArray typedArrayK = androidx.core.content.res.k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f6726j);
        float f3 = androidx.core.content.res.k.f(typedArrayK, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue typedValueL = androidx.core.content.res.k.l(typedArrayK, xmlPullParser, "value", 0);
        boolean z3 = typedValueL != null;
        if (i3 == 4) {
            i3 = (z3 && h(typedValueL.type)) ? 3 : 0;
        }
        if (!z3) {
            keyframeOfFloat = i3 == 0 ? Keyframe.ofFloat(f3) : Keyframe.ofInt(f3);
        } else if (i3 != 0) {
            keyframeOfFloat = (i3 == 1 || i3 == 3) ? Keyframe.ofInt(f3, androidx.core.content.res.k.g(typedArrayK, xmlPullParser, "value", 0, 0)) : null;
        } else {
            keyframeOfFloat = Keyframe.ofFloat(f3, androidx.core.content.res.k.f(typedArrayK, xmlPullParser, "value", 0, 0.0f));
        }
        int iH = androidx.core.content.res.k.h(typedArrayK, xmlPullParser, "interpolator", 1, 0);
        if (iH > 0) {
            keyframeOfFloat.setInterpolator(l.b(context, iH));
        }
        typedArrayK.recycle();
        return keyframeOfFloat;
    }

    private static ObjectAnimator n(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f3, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        l(context, resources, theme, attributeSet, objectAnimator, f3, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder o(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i3) throws XmlPullParserException, IOException {
        int size;
        PropertyValuesHolder propertyValuesHolderOfKeyframe = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (i3 == 4) {
                    i3 = g(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe keyframeM = m(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i3, xmlPullParser);
                if (keyframeM != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(keyframeM);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), c(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, c(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i4 = 0; i4 < size; i4++) {
                Keyframe keyframe3 = keyframeArr[i4];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i4 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i5 = size - 1;
                        if (i4 == i5) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i6 = i4;
                            for (int i7 = i4 + 1; i7 < i5 && keyframeArr[i7].getFraction() < 0.0f; i7++) {
                                i6 = i7;
                            }
                            d(keyframeArr, keyframeArr[i6 + 1].getFraction() - keyframeArr[i4 - 1].getFraction(), i4, i6);
                        }
                    }
                }
            }
            propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i3 == 3) {
                propertyValuesHolderOfKeyframe.setEvaluator(n.a());
            }
        }
        return propertyValuesHolderOfKeyframe;
    }

    private static PropertyValuesHolder[] p(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int i3;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray typedArrayK = androidx.core.content.res.k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f6725i);
                    String strI = androidx.core.content.res.k.i(typedArrayK, xmlPullParser, "propertyName", 3);
                    int iG = androidx.core.content.res.k.g(typedArrayK, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder propertyValuesHolderO = o(context, resources, theme, xmlPullParser, strI, iG);
                    if (propertyValuesHolderO == null) {
                        propertyValuesHolderO = e(typedArrayK, iG, 0, 1, strI);
                    }
                    if (propertyValuesHolderO != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(propertyValuesHolderO);
                    }
                    typedArrayK.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i3 = 0; i3 < size; i3++) {
                propertyValuesHolderArr[i3] = (PropertyValuesHolder) arrayList.get(i3);
            }
        }
        return propertyValuesHolderArr;
    }

    private static void q(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f3, XmlPullParser xmlPullParser) {
        long jG = androidx.core.content.res.k.g(typedArray, xmlPullParser, "duration", 1, 300);
        long jG2 = androidx.core.content.res.k.g(typedArray, xmlPullParser, "startOffset", 2, 0);
        int iG = androidx.core.content.res.k.g(typedArray, xmlPullParser, "valueType", 7, 4);
        if (androidx.core.content.res.k.j(xmlPullParser, "valueFrom") && androidx.core.content.res.k.j(xmlPullParser, "valueTo")) {
            if (iG == 4) {
                iG = f(typedArray, 5, 6);
            }
            PropertyValuesHolder propertyValuesHolderE = e(typedArray, iG, 5, 6, "");
            if (propertyValuesHolderE != null) {
                valueAnimator.setValues(propertyValuesHolderE);
            }
        }
        valueAnimator.setDuration(jG);
        valueAnimator.setStartDelay(jG2);
        valueAnimator.setRepeatCount(androidx.core.content.res.k.g(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(androidx.core.content.res.k.g(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            r(valueAnimator, typedArray2, iG, f3, xmlPullParser);
        }
    }

    private static void r(ValueAnimator valueAnimator, TypedArray typedArray, int i3, float f3, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String strI = androidx.core.content.res.k.i(typedArray, xmlPullParser, "pathData", 1);
        if (strI == null) {
            objectAnimator.setPropertyName(androidx.core.content.res.k.i(typedArray, xmlPullParser, "propertyName", 0));
            return;
        }
        String strI2 = androidx.core.content.res.k.i(typedArray, xmlPullParser, "propertyXName", 2);
        String strI3 = androidx.core.content.res.k.i(typedArray, xmlPullParser, "propertyYName", 3);
        if (i3 != 2) {
        }
        if (strI2 != null || strI3 != null) {
            s(androidx.core.graphics.g.e(strI), objectAnimator, f3 * 0.5f, strI2, strI3);
            return;
        }
        throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    }

    private static void s(Path path, ObjectAnimator objectAnimator, float f3, String str, String str2) {
        int i3 = 1;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        float f4 = 0.0f;
        arrayList.add(Float.valueOf(0.0f));
        float length = 0.0f;
        do {
            length += pathMeasure.getLength();
            arrayList.add(Float.valueOf(length));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int iMin = Math.min(100, ((int) (length / f3)) + 1);
        float[] fArr = new float[iMin];
        float[] fArr2 = new float[iMin];
        float[] fArr3 = new float[2];
        float f5 = length / (iMin - 1);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= iMin) {
                break;
            }
            pathMeasure2.getPosTan(f4 - ((Float) arrayList.get(i5)).floatValue(), fArr3, null);
            fArr[i4] = fArr3[0];
            fArr2[i4] = fArr3[1];
            f4 += f5;
            int i6 = i5 + 1;
            if (i6 < arrayList.size() && f4 > ((Float) arrayList.get(i6)).floatValue()) {
                pathMeasure2.nextContour();
                i5 = i6;
            }
            i3 = 1;
            i4++;
        }
        PropertyValuesHolder propertyValuesHolderOfFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder propertyValuesHolderOfFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (propertyValuesHolderOfFloat == null) {
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[i3];
            propertyValuesHolderArr[0] = propertyValuesHolderOfFloat2;
            objectAnimator.setValues(propertyValuesHolderArr);
        } else if (propertyValuesHolderOfFloat2 == null) {
            PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[i3];
            propertyValuesHolderArr2[0] = propertyValuesHolderOfFloat;
            objectAnimator.setValues(propertyValuesHolderArr2);
        } else {
            PropertyValuesHolder[] propertyValuesHolderArr3 = new PropertyValuesHolder[2];
            propertyValuesHolderArr3[0] = propertyValuesHolderOfFloat;
            propertyValuesHolderArr3[i3] = propertyValuesHolderOfFloat2;
            objectAnimator.setValues(propertyValuesHolderArr3);
        }
    }
}
