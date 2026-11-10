package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.H;
import androidx.core.view.AbstractC0317s;
import androidx.lifecycle.A;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.C0359q;
import androidx.lifecycle.InterfaceC0358p;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends Activity implements InterfaceC0358p, AbstractC0317s.a {
    private final p046n.g extraDataMap = new p046n.g();
    private final C0359q lifecycleRegistry = new C0359q(this);

    public static class a {
    }

    private final boolean f(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String str = strArr[0];
        switch (str.hashCode()) {
            case -645125871:
                return str.equals("--translation") && Build.VERSION.SDK_INT >= 31;
            case 100470631:
                if (!str.equals("--dump-dumpable")) {
                    return false;
                }
                break;
            case 472614934:
                if (!str.equals("--list-dumpables")) {
                    return false;
                }
                break;
            case 1159329357:
                return str.equals("--contentcapture") && Build.VERSION.SDK_INT >= 29;
            case 1455016274:
                return str.equals("--autofill") && Build.VERSION.SDK_INT >= 26;
            default:
                return false;
        }
        return Build.VERSION.SDK_INT >= 33;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        S1.k.e(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        S1.k.d(decorView, "window.decorView");
        if (AbstractC0317s.d(decorView, keyEvent)) {
            return true;
        }
        return AbstractC0317s.e(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        S1.k.e(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        S1.k.d(decorView, "window.decorView");
        if (AbstractC0317s.d(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public <T extends a> T getExtraData(Class<T> cls) {
        S1.k.e(cls, "extraDataClass");
        H.a(this.extraDataMap.get(cls));
        return null;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        A.f5557b.c(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        S1.k.e(bundle, "outState");
        this.lifecycleRegistry.m(AbstractC0354l.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public void putExtraData(a aVar) {
        S1.k.e(aVar, "extraData");
        throw null;
    }

    protected final boolean shouldDumpInternalState(String[] strArr) {
        return !f(strArr);
    }

    @Override // androidx.core.view.AbstractC0317s.a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        S1.k.e(keyEvent, "event");
        return super.dispatchKeyEvent(keyEvent);
    }
}
