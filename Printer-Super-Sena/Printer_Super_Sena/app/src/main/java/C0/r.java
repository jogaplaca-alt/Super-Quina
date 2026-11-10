package C0;

import F0.AbstractC0220n;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0336d;

/* JADX INFO: loaded from: classes.dex */
public class r extends DialogInterfaceOnCancelListenerC0336d {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private Dialog f144r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private DialogInterface.OnCancelListener f145s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private Dialog f146t0;

    public static r e2(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        r rVar = new r();
        Dialog dialog2 = (Dialog) AbstractC0220n.g(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        rVar.f144r0 = dialog2;
        if (onCancelListener != null) {
            rVar.f145s0 = onCancelListener;
        }
        return rVar;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0336d
    public Dialog W1(Bundle bundle) {
        Dialog dialog = this.f144r0;
        if (dialog != null) {
            return dialog;
        }
        b2(false);
        if (this.f146t0 == null) {
            this.f146t0 = new AlertDialog.Builder((Context) AbstractC0220n.f(t())).create();
        }
        return this.f146t0;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0336d
    public void d2(androidx.fragment.app.o oVar, String str) {
        super.d2(oVar, str);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0336d, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f145s0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
