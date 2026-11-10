package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.C0288d;
import androidx.core.view.J;

/* JADX INFO: loaded from: classes.dex */
public final class l implements J {
    private static CharSequence b(Context context, ClipData.Item item, int i3) {
        if ((i3 & 1) == 0) {
            return item.coerceToStyledText(context);
        }
        CharSequence charSequenceCoerceToText = item.coerceToText(context);
        return charSequenceCoerceToText instanceof Spanned ? charSequenceCoerceToText.toString() : charSequenceCoerceToText;
    }

    private static void c(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int iMax = Math.max(0, Math.min(selectionStart, selectionEnd));
        int iMax2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, iMax2);
        editable.replace(iMax, iMax2, charSequence);
    }

    @Override // androidx.core.view.J
    public C0288d a(View view, C0288d c0288d) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + c0288d);
        }
        if (c0288d.d() == 2) {
            return c0288d;
        }
        ClipData clipDataB = c0288d.b();
        int iC = c0288d.c();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z3 = false;
        for (int i3 = 0; i3 < clipDataB.getItemCount(); i3++) {
            CharSequence charSequenceB = b(context, clipDataB.getItemAt(i3), iC);
            if (charSequenceB != null) {
                if (z3) {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), charSequenceB);
                } else {
                    c(editable, charSequenceB);
                    z3 = true;
                }
            }
        }
        return null;
    }
}
