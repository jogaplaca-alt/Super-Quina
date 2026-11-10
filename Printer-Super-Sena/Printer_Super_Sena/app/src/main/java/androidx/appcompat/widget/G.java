package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class G {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final RectF f3106l = new RectF();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap f3107m = new ConcurrentHashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static ConcurrentHashMap f3108n = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3109a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3110b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f3111c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f3112d = -1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f3113e = -1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f3114f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3115g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextPaint f3116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TextView f3117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f3118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final f f3119k;

    private static final class a {
        static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i3, TextView textView, TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i3, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        static int b(TextView textView) {
            return textView.getMaxLines();
        }
    }

    private static final class b {
        static boolean a(View view) {
            return view.isInLayout();
        }
    }

    private static final class c {
        static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i3, int i4, TextView textView, TextPaint textPaint, f fVar) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i3);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i4 == -1) {
                i4 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i4);
            try {
                fVar.a(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    private static class d extends f {
        d() {
        }

        @Override // androidx.appcompat.widget.G.f
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) G.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    private static class e extends d {
        e() {
        }

        @Override // androidx.appcompat.widget.G.d, androidx.appcompat.widget.G.f
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.G.f
        boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    private static class f {
        f() {
        }

        void a(StaticLayout.Builder builder, TextView textView) {
        }

        boolean b(TextView textView) {
            return ((Boolean) G.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    G(TextView textView) {
        this.f3117i = textView;
        this.f3118j = textView.getContext();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            this.f3119k = new e();
        } else if (i3 >= 23) {
            this.f3119k = new d();
        } else {
            this.f3119k = new f();
        }
    }

    private int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i3 : iArr) {
            if (i3 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i3)) < 0) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = ((Integer) arrayList.get(i4)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f3109a = 0;
        this.f3112d = -1.0f;
        this.f3113e = -1.0f;
        this.f3111c = -1.0f;
        this.f3114f = new int[0];
        this.f3110b = false;
    }

    private int e(RectF rectF) {
        int length = this.f3114f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i3 = 1;
        int i4 = length - 1;
        int i5 = 0;
        while (i3 <= i4) {
            int i6 = (i3 + i4) / 2;
            if (x(this.f3114f[i6], rectF)) {
                int i7 = i6 + 1;
                i5 = i3;
                i3 = i7;
            } else {
                i5 = i6 - 1;
                i4 = i5;
            }
        }
        return this.f3114f[i5];
    }

    private static Method k(String str) {
        try {
            Method declaredMethod = (Method) f3107m.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, null)) != null) {
                declaredMethod.setAccessible(true);
                f3107m.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e3) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e3);
            return null;
        }
    }

    static Object m(Object obj, String str, Object obj2) {
        try {
            return k(str).invoke(obj, null);
        } catch (Exception e3) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e3);
            return obj2;
        }
    }

    private void s(float f3) {
        if (f3 != this.f3117i.getPaint().getTextSize()) {
            this.f3117i.getPaint().setTextSize(f3);
            boolean zA = b.a(this.f3117i);
            if (this.f3117i.getLayout() != null) {
                this.f3110b = false;
                try {
                    Method methodK = k("nullLayouts");
                    if (methodK != null) {
                        methodK.invoke(this.f3117i, null);
                    }
                } catch (Exception e3) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e3);
                }
                if (zA) {
                    this.f3117i.forceLayout();
                } else {
                    this.f3117i.requestLayout();
                }
                this.f3117i.invalidate();
            }
        }
    }

    private boolean u() {
        if (y() && this.f3109a == 1) {
            if (!this.f3115g || this.f3114f.length == 0) {
                int iFloor = ((int) Math.floor((this.f3113e - this.f3112d) / this.f3111c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i3 = 0; i3 < iFloor; i3++) {
                    iArr[i3] = Math.round(this.f3112d + (i3 * this.f3111c));
                }
                this.f3114f = b(iArr);
            }
            this.f3110b = true;
        } else {
            this.f3110b = false;
        }
        return this.f3110b;
    }

    private void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = typedArray.getDimensionPixelSize(i3, -1);
            }
            this.f3114f = b(iArr);
            w();
        }
    }

    private boolean w() {
        int[] iArr = this.f3114f;
        int length = iArr.length;
        boolean z3 = length > 0;
        this.f3115g = z3;
        if (z3) {
            this.f3109a = 1;
            this.f3112d = iArr[0];
            this.f3113e = iArr[length - 1];
            this.f3111c = -1.0f;
        }
        return z3;
    }

    private boolean x(int i3, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f3117i.getText();
        TransformationMethod transformationMethod = this.f3117i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f3117i)) != null) {
            text = transformation;
        }
        int iB = a.b(this.f3117i);
        l(i3);
        StaticLayout staticLayoutD = d(text, (Layout.Alignment) m(this.f3117i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), iB);
        return (iB == -1 || (staticLayoutD.getLineCount() <= iB && staticLayoutD.getLineEnd(staticLayoutD.getLineCount() - 1) == text.length())) && ((float) staticLayoutD.getHeight()) <= rectF.bottom;
    }

    private boolean y() {
        return !(this.f3117i instanceof C0267k);
    }

    private void z(float f3, float f4, float f5) {
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f3 + "px) is less or equal to (0px)");
        }
        if (f4 <= f3) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f4 + "px) is less or equal to minimum auto-size text size (" + f3 + "px)");
        }
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f5 + "px) is less or equal to (0px)");
        }
        this.f3109a = 1;
        this.f3112d = f3;
        this.f3113e = f4;
        this.f3111c = f5;
        this.f3115g = false;
    }

    void a() {
        if (n()) {
            if (this.f3110b) {
                if (this.f3117i.getMeasuredHeight() <= 0 || this.f3117i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f3119k.b(this.f3117i) ? 1048576 : (this.f3117i.getMeasuredWidth() - this.f3117i.getTotalPaddingLeft()) - this.f3117i.getTotalPaddingRight();
                int height = (this.f3117i.getHeight() - this.f3117i.getCompoundPaddingBottom()) - this.f3117i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f3106l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fE = e(rectF);
                        if (fE != this.f3117i.getTextSize()) {
                            t(0, fE);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            this.f3110b = true;
        }
    }

    StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i3, int i4) {
        return Build.VERSION.SDK_INT >= 23 ? c.a(charSequence, alignment, i3, i4, this.f3117i, this.f3116h, this.f3119k) : a.a(charSequence, alignment, i3, this.f3117i, this.f3116h);
    }

    int f() {
        return Math.round(this.f3113e);
    }

    int g() {
        return Math.round(this.f3112d);
    }

    int h() {
        return Math.round(this.f3111c);
    }

    int[] i() {
        return this.f3114f;
    }

    int j() {
        return this.f3109a;
    }

    void l(int i3) {
        TextPaint textPaint = this.f3116h;
        if (textPaint == null) {
            this.f3116h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f3116h.set(this.f3117i.getPaint());
        this.f3116h.setTextSize(i3);
    }

    boolean n() {
        return y() && this.f3109a != 0;
    }

    void o(AttributeSet attributeSet, int i3) {
        int resourceId;
        Context context = this.f3118j;
        int[] iArr = p012d.j.f9367g0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, 0);
        TextView textView = this.f3117i;
        androidx.core.view.Z.o0(textView, textView.getContext(), iArr, attributeSet, typedArrayObtainStyledAttributes, i3, 0);
        int i4 = p012d.j.f9387l0;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            this.f3109a = typedArrayObtainStyledAttributes.getInt(i4, 0);
        }
        int i5 = p012d.j.f9383k0;
        float dimension = typedArrayObtainStyledAttributes.hasValue(i5) ? typedArrayObtainStyledAttributes.getDimension(i5, -1.0f) : -1.0f;
        int i6 = p012d.j.f9375i0;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(i6) ? typedArrayObtainStyledAttributes.getDimension(i6, -1.0f) : -1.0f;
        int i7 = p012d.j.f9371h0;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(i7) ? typedArrayObtainStyledAttributes.getDimension(i7, -1.0f) : -1.0f;
        int i8 = p012d.j.f9379j0;
        if (typedArrayObtainStyledAttributes.hasValue(i8) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i8, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!y()) {
            this.f3109a = 0;
            return;
        }
        if (this.f3109a == 1) {
            if (!this.f3115g) {
                DisplayMetrics displayMetrics = this.f3118j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                z(dimension2, dimension3, dimension);
            }
            u();
        }
    }

    void p(int i3, int i4, int i5, int i6) {
        if (y()) {
            DisplayMetrics displayMetrics = this.f3118j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i6, i3, displayMetrics), TypedValue.applyDimension(i6, i4, displayMetrics), TypedValue.applyDimension(i6, i5, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    void q(int[] iArr, int i3) {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i3 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f3118j.getResources().getDisplayMetrics();
                    for (int i4 = 0; i4 < length; i4++) {
                        iArrCopyOf[i4] = Math.round(TypedValue.applyDimension(i3, iArr[i4], displayMetrics));
                    }
                }
                this.f3114f = b(iArrCopyOf);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f3115g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    void r(int i3) {
        if (y()) {
            if (i3 == 0) {
                c();
                return;
            }
            if (i3 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i3);
            }
            DisplayMetrics displayMetrics = this.f3118j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        }
    }

    void t(int i3, float f3) {
        Context context = this.f3118j;
        s(TypedValue.applyDimension(i3, f3, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
