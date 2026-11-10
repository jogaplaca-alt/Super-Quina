package C0;

import F0.AbstractC0220n;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: renamed from: C0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class DialogFragmentC0180b extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Dialog f125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DialogInterface.OnCancelListener f126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Dialog f127c;

    public static DialogFragmentC0180b a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        DialogFragmentC0180b dialogFragmentC0180b = new DialogFragmentC0180b();
        Dialog dialog2 = (Dialog) AbstractC0220n.g(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        dialogFragmentC0180b.f125a = dialog2;
        if (onCancelListener != null) {
            dialogFragmentC0180b.f126b = onCancelListener;
        }
        return dialogFragmentC0180b;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f126b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f125a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f127c == null) {
            this.f127c = new AlertDialog.Builder((Context) AbstractC0220n.f(getActivity())).create();
        }
        return this.f127c;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
