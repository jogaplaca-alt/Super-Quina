package M;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
final class e implements KeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeyListener f1274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f1275b;

    public static class a {
        public boolean a(Editable editable, int i3, KeyEvent keyEvent) {
            return androidx.emoji2.text.e.f(editable, i3, keyEvent);
        }
    }

    e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i3) {
        this.f1274a.clearMetaKeyState(view, editable, i3);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f1274a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i3, KeyEvent keyEvent) {
        return this.f1275b.a(editable, i3, keyEvent) || this.f1274a.onKeyDown(view, editable, i3, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f1274a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i3, KeyEvent keyEvent) {
        return this.f1274a.onKeyUp(view, editable, i3, keyEvent);
    }

    e(KeyListener keyListener, a aVar) {
        this.f1274a = keyListener;
        this.f1275b = aVar;
    }
}
