package K;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p082z.h;

/* JADX INFO: loaded from: classes.dex */
public final class c extends SpannableStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f1200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f1201b;

    private static class a implements TextWatcher, SpanWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f1202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f1203b = new AtomicInteger(0);

        a(Object obj) {
            this.f1202a = obj;
        }

        private boolean b(Object obj) {
            return obj instanceof b;
        }

        final void a() {
            this.f1203b.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f1202a).afterTextChanged(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            ((TextWatcher) this.f1202a).beforeTextChanged(charSequence, i3, i4, i5);
        }

        final void c() {
            this.f1203b.decrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i3, int i4) {
            if (this.f1203b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f1202a).onSpanAdded(spannable, obj, i3, i4);
            }
        }

        /* JADX WARN: Code duplicated, block: B:14:0x001e A[PHI: r11
          0x001e: PHI (r11v1 int) = (r11v0 int), (r11v3 int) binds: [B:8:0x0013, B:12:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i3, int i4, int i5, int i6) {
            int i7;
            int i8;
            if (this.f1203b.get() <= 0 || !b(obj)) {
                if (Build.VERSION.SDK_INT >= 28) {
                    i7 = i3;
                    i8 = i5;
                } else {
                    if (i3 > i4) {
                        i3 = 0;
                    }
                    if (i5 > i6) {
                        i7 = i3;
                        i8 = 0;
                    } else {
                        i7 = i3;
                        i8 = i5;
                    }
                }
                ((SpanWatcher) this.f1202a).onSpanChanged(spannable, obj, i7, i4, i8, i6);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i3, int i4) {
            if (this.f1203b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f1202a).onSpanRemoved(spannable, obj, i3, i4);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            ((TextWatcher) this.f1202a).onTextChanged(charSequence, i3, i4, i5);
        }
    }

    c(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f1201b = new ArrayList();
        h.h(cls, "watcherClass cannot be null");
        this.f1200a = cls;
    }

    private void b() {
        for (int i3 = 0; i3 < this.f1201b.size(); i3++) {
            ((a) this.f1201b.get(i3)).a();
        }
    }

    public static c c(Class cls, CharSequence charSequence) {
        return new c(cls, charSequence);
    }

    private void e() {
        for (int i3 = 0; i3 < this.f1201b.size(); i3++) {
            ((a) this.f1201b.get(i3)).onTextChanged(this, 0, length(), length());
        }
    }

    private a f(Object obj) {
        for (int i3 = 0; i3 < this.f1201b.size(); i3++) {
            a aVar = (a) this.f1201b.get(i3);
            if (aVar.f1202a == obj) {
                return aVar;
            }
        }
        return null;
    }

    private boolean g(Class cls) {
        return this.f1200a == cls;
    }

    private boolean h(Object obj) {
        return obj != null && g(obj.getClass());
    }

    private void i() {
        for (int i3 = 0; i3 < this.f1201b.size(); i3++) {
            ((a) this.f1201b.get(i3)).c();
        }
    }

    public void a() {
        b();
    }

    public void d() {
        i();
        e();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public Object[] getSpans(int i3, int i4, Class cls) {
        if (!g(cls)) {
            return super.getSpans(i3, i4, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i3, i4, a.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, aVarArr.length);
        for (int i5 = 0; i5 < aVarArr.length; i5++) {
            objArr[i5] = aVarArr[i5].f1202a;
        }
        return objArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int i3, int i4, Class cls) {
        if (cls == null || g(cls)) {
            cls = a.class;
        }
        return super.nextSpanTransition(i3, i4, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object obj) {
        a aVarF;
        if (h(obj)) {
            aVarF = f(obj);
            if (aVarF != null) {
                obj = aVarF;
            }
        } else {
            aVarF = null;
        }
        super.removeSpan(obj);
        if (aVarF != null) {
            this.f1201b.remove(aVarF);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i3, int i4, int i5) {
        if (h(obj)) {
            a aVar = new a(obj);
            this.f1201b.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i3, i4, i5);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int i3, int i4) {
        return new c(this.f1200a, this, i3, i4);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder delete(int i3, int i4) {
        super.delete(i3, i4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i3, CharSequence charSequence) {
        super.insert(i3, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i3, int i4, CharSequence charSequence) {
        b();
        super.replace(i3, i4, charSequence);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i3, CharSequence charSequence, int i4, int i5) {
        super.insert(i3, charSequence, i4, i5);
        return this;
    }

    c(Class cls, CharSequence charSequence, int i3, int i4) {
        super(charSequence, i3, i4);
        this.f1201b = new ArrayList();
        h.h(cls, "watcherClass cannot be null");
        this.f1200a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i3, int i4, CharSequence charSequence, int i5, int i6) {
        b();
        super.replace(i3, i4, charSequence, i5, i6);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char c3) {
        super.append(c3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence, int i3, int i4) {
        super.append(charSequence, i3, i4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i3) {
        super.append(charSequence, obj, i3);
        return this;
    }
}
