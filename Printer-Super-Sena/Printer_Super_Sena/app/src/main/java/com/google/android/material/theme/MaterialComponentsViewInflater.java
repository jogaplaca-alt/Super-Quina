package com.google.android.material.theme;

import Y0.i;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.A;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.C0260d;
import androidx.appcompat.widget.C0262f;
import androidx.appcompat.widget.C0277v;
import androidx.appcompat.widget.F;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.w;
import p026g1.a;

/* JADX INFO: loaded from: classes.dex */
public class MaterialComponentsViewInflater extends A {
    @Override // androidx.appcompat.app.A
    protected C0260d c(Context context, AttributeSet attributeSet) {
        return new w(context, attributeSet);
    }

    @Override // androidx.appcompat.app.A
    protected AppCompatButton d(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // androidx.appcompat.app.A
    protected C0262f e(Context context, AttributeSet attributeSet) {
        return new i(context, attributeSet);
    }

    @Override // androidx.appcompat.app.A
    protected C0277v k(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.A
    protected F o(Context context, AttributeSet attributeSet) {
        return new p048n1.a(context, attributeSet);
    }
}
