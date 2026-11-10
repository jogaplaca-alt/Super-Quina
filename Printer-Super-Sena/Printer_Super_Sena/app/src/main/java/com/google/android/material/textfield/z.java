package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
class z extends t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private EditText f8755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final View.OnClickListener f8756g;

    z(s sVar, int i3) {
        super(sVar);
        this.f8754e = S0.d.f1605c;
        this.f8756g = new View.OnClickListener() { // from class: com.google.android.material.textfield.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f8753a.y(view);
            }
        };
        if (i3 != 0) {
            this.f8754e = i3;
        }
    }

    private boolean w() {
        EditText editText = this.f8755f;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean x(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EditText editText = this.f8755f;
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        if (w()) {
            this.f8755f.setTransformationMethod(null);
        } else {
            this.f8755f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            this.f8755f.setSelection(selectionEnd);
        }
        r();
    }

    @Override // com.google.android.material.textfield.t
    void b(CharSequence charSequence, int i3, int i4, int i5) {
        r();
    }

    @Override // com.google.android.material.textfield.t
    int c() {
        return S0.i.f1686A;
    }

    @Override // com.google.android.material.textfield.t
    int d() {
        return this.f8754e;
    }

    @Override // com.google.android.material.textfield.t
    View.OnClickListener f() {
        return this.f8756g;
    }

    @Override // com.google.android.material.textfield.t
    boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.t
    boolean m() {
        return !w();
    }

    @Override // com.google.android.material.textfield.t
    void n(EditText editText) {
        this.f8755f = editText;
        r();
    }

    @Override // com.google.android.material.textfield.t
    void s() {
        if (x(this.f8755f)) {
            this.f8755f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // com.google.android.material.textfield.t
    void u() {
        EditText editText = this.f8755f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
