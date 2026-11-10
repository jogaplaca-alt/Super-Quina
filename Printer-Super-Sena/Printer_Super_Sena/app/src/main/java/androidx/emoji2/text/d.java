package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
class d implements e.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f4931b = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextPaint f4932a;

    d() {
        TextPaint textPaint = new TextPaint();
        this.f4932a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal threadLocal = f4931b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    @Override // androidx.emoji2.text.e.d
    public boolean a(CharSequence charSequence, int i3, int i4, int i5) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 23 && i5 > i6) {
            return false;
        }
        StringBuilder sbB = b();
        sbB.setLength(0);
        while (i3 < i4) {
            sbB.append(charSequence.charAt(i3));
            i3++;
        }
        return androidx.core.graphics.f.a(this.f4932a, sbB.toString());
    }
}
