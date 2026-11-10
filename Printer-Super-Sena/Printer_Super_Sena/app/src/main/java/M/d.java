package M;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class d implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f1270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private androidx.emoji2.text.e.AbstractC0069e f1271b;

    private static class a extends androidx.emoji2.text.e.AbstractC0069e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Reference f1272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Reference f1273b;

        a(TextView textView, d dVar) {
            this.f1272a = new WeakReference(textView);
            this.f1273b = new WeakReference(dVar);
        }

        private boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.emoji2.text.e.AbstractC0069e
        public void b() {
            CharSequence text;
            CharSequence charSequenceO;
            super.b();
            TextView textView = (TextView) this.f1272a.get();
            if (c(textView, (InputFilter) this.f1273b.get()) && textView.isAttachedToWindow() && text != (charSequenceO = androidx.emoji2.text.e.b().o((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceO);
                int selectionEnd = Selection.getSelectionEnd(charSequenceO);
                textView.setText(charSequenceO);
                if (charSequenceO instanceof Spannable) {
                    d.b((Spannable) charSequenceO, selectionStart, selectionEnd);
                }
            }
        }
    }

    d(TextView textView) {
        this.f1270a = textView;
    }

    private androidx.emoji2.text.e.AbstractC0069e a() {
        if (this.f1271b == null) {
            this.f1271b = new a(this.f1270a, this);
        }
        return this.f1271b;
    }

    static void b(Spannable spannable, int i3, int i4) {
        if (i3 >= 0 && i4 >= 0) {
            Selection.setSelection(spannable, i3, i4);
        } else if (i3 >= 0) {
            Selection.setSelection(spannable, i3);
        } else if (i4 >= 0) {
            Selection.setSelection(spannable, i4);
        }
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i3, int i4, Spanned spanned, int i5, int i6) {
        if (this.f1270a.isInEditMode()) {
            return charSequence;
        }
        int iD = androidx.emoji2.text.e.b().d();
        if (iD != 0) {
            if (iD == 1) {
                if ((i6 == 0 && i5 == 0 && spanned.length() == 0 && charSequence == this.f1270a.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i3 != 0 || i4 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i3, i4);
                }
                return androidx.emoji2.text.e.b().p(charSequence, 0, charSequence.length());
            }
            if (iD != 3) {
                return charSequence;
            }
        }
        androidx.emoji2.text.e.b().s(a());
        return charSequence;
    }
}
