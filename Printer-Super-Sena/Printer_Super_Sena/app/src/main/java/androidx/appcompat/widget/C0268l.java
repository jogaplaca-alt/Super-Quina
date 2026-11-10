package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* JADX INFO: renamed from: androidx.appcompat.widget.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0268l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EditText f3555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final M.a f3556b;

    C0268l(EditText editText) {
        this.f3555a = editText;
        this.f3556b = new M.a(editText, false);
    }

    KeyListener a(KeyListener keyListener) {
        return b(keyListener) ? this.f3556b.a(keyListener) : keyListener;
    }

    boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    void c(AttributeSet attributeSet, int i3) {
        TypedArray typedArrayObtainStyledAttributes = this.f3555a.getContext().obtainStyledAttributes(attributeSet, p012d.j.f9367g0, i3, 0);
        try {
            int i4 = p012d.j.f9423u0;
            boolean z3 = typedArrayObtainStyledAttributes.hasValue(i4) ? typedArrayObtainStyledAttributes.getBoolean(i4, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z3);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    InputConnection d(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f3556b.b(inputConnection, editorInfo);
    }

    void e(boolean z3) {
        this.f3556b.c(z3);
    }
}
