package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
final class y {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final int f8342n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static boolean f8343o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static Constructor f8344p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static Object f8345q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CharSequence f8346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextPaint f8347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f8348c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8350e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8357l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8349d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Layout.Alignment f8351f = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8352g = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f8353h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f8354i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f8355j = f8342n;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f8356k = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextUtils.TruncateAt f8358m = null;

    static class a extends Exception {
        a(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    static {
        f8342n = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    private y(CharSequence charSequence, TextPaint textPaint, int i3) {
        this.f8346a = charSequence;
        this.f8347b = textPaint;
        this.f8348c = i3;
        this.f8350e = charSequence.length();
    }

    private void b() throws a {
        if (f8343o) {
            return;
        }
        try {
            f8345q = this.f8357l && Build.VERSION.SDK_INT >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Constructor declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
            f8344p = declaredConstructor;
            declaredConstructor.setAccessible(true);
            f8343o = true;
        } catch (Exception e3) {
            throw new a(e3);
        }
    }

    public static y c(CharSequence charSequence, TextPaint textPaint, int i3) {
        return new y(charSequence, textPaint, i3);
    }

    public StaticLayout a() throws a {
        if (this.f8346a == null) {
            this.f8346a = "";
        }
        int iMax = Math.max(0, this.f8348c);
        CharSequence charSequenceEllipsize = this.f8346a;
        if (this.f8352g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f8347b, iMax, this.f8358m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f8350e);
        this.f8350e = iMin;
        if (Build.VERSION.SDK_INT < 23) {
            b();
            try {
                return (StaticLayout) ((Constructor) p082z.h.g(f8344p)).newInstance(charSequenceEllipsize, Integer.valueOf(this.f8349d), Integer.valueOf(this.f8350e), this.f8347b, Integer.valueOf(iMax), this.f8351f, p082z.h.g(f8345q), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f8356k), null, Integer.valueOf(iMax), Integer.valueOf(this.f8352g));
            } catch (Exception e3) {
                throw new a(e3);
            }
        }
        if (this.f8357l && this.f8352g == 1) {
            this.f8351f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f8349d, iMin, this.f8347b, iMax);
        builderObtain.setAlignment(this.f8351f);
        builderObtain.setIncludePad(this.f8356k);
        builderObtain.setTextDirection(this.f8357l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f8358m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f8352g);
        float f3 = this.f8353h;
        if (f3 != 0.0f || this.f8354i != 1.0f) {
            builderObtain.setLineSpacing(f3, this.f8354i);
        }
        if (this.f8352g > 1) {
            builderObtain.setHyphenationFrequency(this.f8355j);
        }
        return builderObtain.build();
    }

    public y d(Layout.Alignment alignment) {
        this.f8351f = alignment;
        return this;
    }

    public y e(TextUtils.TruncateAt truncateAt) {
        this.f8358m = truncateAt;
        return this;
    }

    public y f(int i3) {
        this.f8355j = i3;
        return this;
    }

    public y g(boolean z3) {
        this.f8356k = z3;
        return this;
    }

    public y h(boolean z3) {
        this.f8357l = z3;
        return this;
    }

    public y i(float f3, float f4) {
        this.f8353h = f3;
        this.f8354i = f4;
        return this;
    }

    public y j(int i3) {
        this.f8352g = i3;
        return this;
    }

    public y k(z zVar) {
        return this;
    }
}
