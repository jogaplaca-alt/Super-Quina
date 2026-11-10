package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes.dex */
class m implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5006a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Spannable f5007b;

    private static class a {
        static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    static class b {
        b() {
        }

        boolean a(CharSequence charSequence) {
            return false;
        }
    }

    static class c extends b {
        c() {
        }

        @Override // androidx.emoji2.text.m.b
        boolean a(CharSequence charSequence) {
            return K.g.a(charSequence);
        }
    }

    m(Spannable spannable) {
        this.f5007b = spannable;
    }

    private void a() {
        Spannable spannable = this.f5007b;
        if (!this.f5006a && c().a(spannable)) {
            this.f5007b = new SpannableString(spannable);
        }
        this.f5006a = true;
    }

    static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    Spannable b() {
        return this.f5007b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i3) {
        return this.f5007b.charAt(i3);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.a(this.f5007b);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.b(this.f5007b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f5007b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f5007b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f5007b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public Object[] getSpans(int i3, int i4, Class cls) {
        return this.f5007b.getSpans(i3, i4, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f5007b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i3, int i4, Class cls) {
        return this.f5007b.nextSpanTransition(i3, i4, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f5007b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i3, int i4, int i5) {
        a();
        this.f5007b.setSpan(obj, i3, i4, i5);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i3, int i4) {
        return this.f5007b.subSequence(i3, i4);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f5007b.toString();
    }

    m(CharSequence charSequence) {
        this.f5007b = new SpannableString(charSequence);
    }
}
