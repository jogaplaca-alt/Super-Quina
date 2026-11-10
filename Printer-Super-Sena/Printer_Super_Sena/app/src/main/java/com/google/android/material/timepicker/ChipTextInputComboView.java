package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.Z;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.B;
import com.google.android.material.internal.F;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Chip f8757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextInputLayout f8758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EditText f8759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextWatcher f8760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f8761e;

    private class b extends B {
        private b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f8757a.setText(ChipTextInputComboView.this.c("00"));
                return;
            }
            String strC = ChipTextInputComboView.this.c(editable);
            Chip chip = ChipTextInputComboView.this.f8757a;
            if (TextUtils.isEmpty(strC)) {
                strC = ChipTextInputComboView.this.c("00");
            }
            chip.setText(strC);
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(CharSequence charSequence) {
        return f.c(getResources(), charSequence);
    }

    private void d() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f8759c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f8757a.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z3) {
        this.f8757a.setChecked(z3);
        this.f8759c.setVisibility(z3 ? 0 : 4);
        this.f8757a.setVisibility(z3 ? 8 : 0);
        if (isChecked()) {
            F.k(this.f8759c, false);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f8757a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i3, Object obj) {
        this.f8757a.setTag(i3, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f8757a.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(S0.g.f1673n, (ViewGroup) this, false);
        this.f8757a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(S0.g.f1674o, (ViewGroup) this, false);
        this.f8758b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f8759c = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f8760d = bVar;
        editText.addTextChangedListener(bVar);
        d();
        addView(chip);
        addView(textInputLayout);
        this.f8761e = (TextView) findViewById(S0.e.f1645n);
        editText.setId(Z.m());
        Z.C0(this.f8761e, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
