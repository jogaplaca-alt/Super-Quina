package M;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EditText f1281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f1282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.emoji2.text.e.AbstractC0069e f1283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1284d = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1285e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1286f = true;

    private static class a extends androidx.emoji2.text.e.AbstractC0069e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Reference f1287a;

        a(EditText editText) {
            this.f1287a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.e.AbstractC0069e
        public void b() {
            super.b();
            g.b((EditText) this.f1287a.get(), 1);
        }
    }

    g(EditText editText, boolean z3) {
        this.f1281a = editText;
        this.f1282b = z3;
    }

    private androidx.emoji2.text.e.AbstractC0069e a() {
        if (this.f1283c == null) {
            this.f1283c = new a(this.f1281a);
        }
        return this.f1283c;
    }

    static void b(EditText editText, int i3) {
        if (i3 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.e.b().o(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean d() {
        return (this.f1286f && (this.f1282b || androidx.emoji2.text.e.h())) ? false : true;
    }

    public void c(boolean z3) {
        if (this.f1286f != z3) {
            if (this.f1283c != null) {
                androidx.emoji2.text.e.b().t(this.f1283c);
            }
            this.f1286f = z3;
            if (z3) {
                b(this.f1281a, androidx.emoji2.text.e.b().d());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        if (this.f1281a.isInEditMode() || d() || i4 > i5 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iD = androidx.emoji2.text.e.b().d();
        if (iD != 0) {
            if (iD == 1) {
                androidx.emoji2.text.e.b().r((Spannable) charSequence, i3, i3 + i5, this.f1284d, this.f1285e);
                return;
            } else if (iD != 3) {
                return;
            }
        }
        androidx.emoji2.text.e.b().s(a());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
    }
}
