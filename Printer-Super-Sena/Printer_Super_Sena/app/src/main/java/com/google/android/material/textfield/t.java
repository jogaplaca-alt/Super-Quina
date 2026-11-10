package com.google.android.material.textfield;

import A.AbstractC0157c;
import A.T;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes.dex */
abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TextInputLayout f8703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final s f8704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Context f8705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final CheckableImageButton f8706d;

    t(s sVar) {
        this.f8703a = sVar.f8673a;
        this.f8704b = sVar;
        this.f8705c = sVar.getContext();
        this.f8706d = sVar.r();
    }

    void a(Editable editable) {
    }

    void b(CharSequence charSequence, int i3, int i4, int i5) {
    }

    int c() {
        return 0;
    }

    int d() {
        return 0;
    }

    View.OnFocusChangeListener e() {
        return null;
    }

    View.OnClickListener f() {
        return null;
    }

    View.OnFocusChangeListener g() {
        return null;
    }

    AbstractC0157c.a h() {
        return null;
    }

    boolean i(int i3) {
        return true;
    }

    boolean j() {
        return false;
    }

    boolean k() {
        return false;
    }

    boolean l() {
        return false;
    }

    boolean m() {
        return false;
    }

    void n(EditText editText) {
    }

    void p(View view, AccessibilityEvent accessibilityEvent) {
    }

    void q(boolean z3) {
    }

    final void r() {
        this.f8704b.L(false);
    }

    void s() {
    }

    boolean t() {
        return false;
    }

    void u() {
    }

    void o(View view, T t3) {
    }
}
