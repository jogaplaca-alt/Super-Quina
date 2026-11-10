package M;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f1260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1261b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1262c = 0;

    /* JADX INFO: renamed from: M.a$a, reason: collision with other inner class name */
    private static class C0019a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EditText f1263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f1264b;

        C0019a(EditText editText, boolean z3) {
            this.f1263a = editText;
            g gVar = new g(editText, z3);
            this.f1264b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(M.b.getInstance());
        }

        @Override // M.a.b
        KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        @Override // M.a.b
        InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f1263a, inputConnection, editorInfo);
        }

        @Override // M.a.b
        void c(boolean z3) {
            this.f1264b.c(z3);
        }
    }

    static class b {
        b() {
        }

        abstract KeyListener a(KeyListener keyListener);

        abstract InputConnection b(InputConnection inputConnection, EditorInfo editorInfo);

        abstract void c(boolean z3);
    }

    public a(EditText editText, boolean z3) {
        p082z.h.h(editText, "editText cannot be null");
        this.f1260a = new C0019a(editText, z3);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f1260a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f1260a.b(inputConnection, editorInfo);
    }

    public void c(boolean z3) {
        this.f1260a.c(z3);
    }
}
