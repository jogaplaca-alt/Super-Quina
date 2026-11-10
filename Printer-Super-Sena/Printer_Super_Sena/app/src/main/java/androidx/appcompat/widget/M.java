package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.C0297h0;

/* JADX INFO: loaded from: classes.dex */
public interface M {
    void a(Menu menu, androidx.appcompat.view.menu.m.a aVar);

    boolean b();

    boolean c();

    void collapseActionView();

    boolean d();

    boolean e();

    void f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    void h();

    void i(androidx.appcompat.view.menu.m.a aVar, androidx.appcompat.view.menu.g.a aVar2);

    int j();

    void k(int i3);

    Menu l();

    void m(int i3);

    void n(d0 d0Var);

    ViewGroup o();

    void p(int i3);

    void q(boolean z3);

    int r();

    C0297h0 s(int i3, long j3);

    void setIcon(int i3);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t();

    boolean u();

    void v();

    void w(Drawable drawable);

    void x(boolean z3);

    void y(int i3);
}
