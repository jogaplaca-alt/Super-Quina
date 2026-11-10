package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.i f4972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f4973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e.d f4974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f4975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f4976e;

    private static final class a {
        static int a(CharSequence charSequence, int i3, int i4) {
            int length = charSequence.length();
            if (i3 < 0 || length < i3 || i4 < 0) {
                return -1;
            }
            while (true) {
                boolean z3 = false;
                while (i4 != 0) {
                    i3--;
                    if (i3 < 0) {
                        return z3 ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i3);
                    if (z3) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i4--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i4--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z3 = true;
                    }
                }
                return i3;
            }
        }

        static int b(CharSequence charSequence, int i3, int i4) {
            int length = charSequence.length();
            if (i3 < 0 || length < i3 || i4 < 0) {
                return -1;
            }
            while (true) {
                boolean z3 = false;
                while (i4 != 0) {
                    if (i3 >= length) {
                        if (z3) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i3);
                    if (z3) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i4--;
                        i3++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i4--;
                        i3++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i3++;
                        z3 = true;
                    }
                }
                return i3;
            }
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4977a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final l.a f4978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private l.a f4979c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private l.a f4980d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f4981e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f4982f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f4983g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int[] f4984h;

        b(l.a aVar, boolean z3, int[] iArr) {
            this.f4978b = aVar;
            this.f4979c = aVar;
            this.f4983g = z3;
            this.f4984h = iArr;
        }

        private static boolean d(int i3) {
            return i3 == 65039;
        }

        private static boolean f(int i3) {
            return i3 == 65038;
        }

        private int g() {
            this.f4977a = 1;
            this.f4979c = this.f4978b;
            this.f4982f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f4979c.b().j() || d(this.f4981e)) {
                return true;
            }
            if (this.f4983g) {
                if (this.f4984h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f4984h, this.f4979c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int a(int i3) {
            l.a aVarA = this.f4979c.a(i3);
            int iG = 2;
            if (this.f4977a != 2) {
                if (aVarA == null) {
                    iG = g();
                } else {
                    this.f4977a = 2;
                    this.f4979c = aVarA;
                    this.f4982f = 1;
                }
            } else if (aVarA != null) {
                this.f4979c = aVarA;
                this.f4982f++;
            } else if (f(i3)) {
                iG = g();
            } else if (!d(i3)) {
                if (this.f4979c.b() != null) {
                    iG = 3;
                    if (this.f4982f != 1 || h()) {
                        this.f4980d = this.f4979c;
                        g();
                    } else {
                        iG = g();
                    }
                } else {
                    iG = g();
                }
            }
            this.f4981e = i3;
            return iG;
        }

        g b() {
            return this.f4979c.b();
        }

        g c() {
            return this.f4980d.b();
        }

        boolean e() {
            return this.f4977a == 2 && this.f4979c.b() != null && (this.f4982f > 1 || h());
        }
    }

    h(l lVar, e.i iVar, e.d dVar, boolean z3, int[] iArr) {
        this.f4972a = iVar;
        this.f4973b = lVar;
        this.f4974c = dVar;
        this.f4975d = z3;
        this.f4976e = iArr;
    }

    private void a(Spannable spannable, g gVar, int i3, int i4) {
        spannable.setSpan(this.f4972a.a(gVar), i3, i4, 33);
    }

    private static boolean b(Editable editable, KeyEvent keyEvent, boolean z3) {
        K.b[] bVarArr;
        if (g(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!f(selectionStart, selectionEnd) && (bVarArr = (K.b[]) editable.getSpans(selectionStart, selectionEnd, K.b.class)) != null && bVarArr.length > 0) {
            for (K.b bVar : bVarArr) {
                int spanStart = editable.getSpanStart(bVar);
                int spanEnd = editable.getSpanEnd(bVar);
                if ((z3 && spanStart == selectionStart) || ((!z3 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean c(InputConnection inputConnection, Editable editable, int i3, int i4, boolean z3) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i3 >= 0 && i4 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (f(selectionStart, selectionEnd)) {
                return false;
            }
            if (z3) {
                iMax = a.a(editable, selectionStart, Math.max(i3, 0));
                iMin = a.b(editable, selectionEnd, Math.max(i4, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i3, 0);
                iMin = Math.min(selectionEnd + i4, editable.length());
            }
            K.b[] bVarArr = (K.b[]) editable.getSpans(iMax, iMin, K.b.class);
            if (bVarArr != null && bVarArr.length > 0) {
                for (K.b bVar : bVarArr) {
                    int spanStart = editable.getSpanStart(bVar);
                    int spanEnd = editable.getSpanEnd(bVar);
                    iMax = Math.min(spanStart, iMax);
                    iMin = Math.max(spanEnd, iMin);
                }
                int iMax2 = Math.max(iMax, 0);
                int iMin2 = Math.min(iMin, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(iMax2, iMin2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    static boolean d(Editable editable, int i3, KeyEvent keyEvent) {
        boolean zB;
        if (i3 != 67) {
            zB = i3 != 112 ? false : b(editable, keyEvent, true);
        } else {
            zB = b(editable, keyEvent, false);
        }
        if (!zB) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean e(CharSequence charSequence, int i3, int i4, g gVar) {
        if (gVar.d() == 0) {
            gVar.k(this.f4974c.a(charSequence, i3, i4, gVar.h()));
        }
        return gVar.d() == 2;
    }

    private static boolean f(int i3, int i4) {
        return i3 == -1 || i4 == -1 || i3 != i4;
    }

    private static boolean g(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    CharSequence h(CharSequence charSequence, int i3, int i4, int i5, boolean z3) {
        m mVar;
        int iCharCount;
        K.b[] bVarArr;
        boolean z4 = charSequence instanceof K.c;
        if (z4) {
            ((K.c) charSequence).a();
        }
        if (!z4) {
            try {
                mVar = charSequence instanceof Spannable ? new m((Spannable) charSequence) : (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i3 + (-1), i4 + 1, K.b.class) > i4) ? null : new m(charSequence);
            } finally {
                if (z4) {
                    ((K.c) charSequence).d();
                }
            }
        }
        if (mVar != null && (bVarArr = (K.b[]) mVar.getSpans(i3, i4, K.b.class)) != null && bVarArr.length > 0) {
            for (K.b bVar : bVarArr) {
                int spanStart = mVar.getSpanStart(bVar);
                int spanEnd = mVar.getSpanEnd(bVar);
                if (spanStart != i4) {
                    mVar.removeSpan(bVar);
                }
                i3 = Math.min(spanStart, i3);
                i4 = Math.max(spanEnd, i4);
            }
        }
        if (i3 != i4 && i3 < charSequence.length()) {
            if (i5 != Integer.MAX_VALUE && mVar != null) {
                i5 -= ((K.b[]) mVar.getSpans(0, mVar.length(), K.b.class)).length;
            }
            b bVar2 = new b(this.f4973b.f(), this.f4975d, this.f4976e);
            m mVar2 = mVar;
            int iCodePointAt = Character.codePointAt(charSequence, i3);
            int i6 = 0;
            loop1: while (true) {
                iCharCount = i3;
                while (true) {
                    if (i3 >= i4 || i6 >= i5) {
                        break loop1;
                    }
                    int iA = bVar2.a(iCodePointAt);
                    if (iA == 1) {
                        iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                        if (iCharCount < i4) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        }
                        i3 = iCharCount;
                    } else if (iA == 2) {
                        i3 += Character.charCount(iCodePointAt);
                        if (i3 < i4) {
                            iCodePointAt = Character.codePointAt(charSequence, i3);
                        }
                    } else if (iA != 3) {
                    }
                }
                if (z3 || !e(charSequence, iCharCount, i3, bVar2.c())) {
                    if (mVar2 == null) {
                        mVar2 = new m((Spannable) new SpannableString(charSequence));
                    }
                    a(mVar2, bVar2.c(), iCharCount, i3);
                    i6++;
                }
            }
            if (bVar2.e() && i6 < i5 && (z3 || !e(charSequence, iCharCount, i3, bVar2.b()))) {
                if (mVar2 == null) {
                    mVar2 = new m(charSequence);
                }
                a(mVar2, bVar2.b(), iCharCount, i3);
            }
            return mVar2 != null ? mVar2.b() : charSequence;
        }
        return charSequence;
    }
}
