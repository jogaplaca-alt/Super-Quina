package v2;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final InterfaceC0136a f12538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f12539b;

    /* JADX INFO: renamed from: v2.a$a, reason: collision with other inner class name */
    public interface InterfaceC0136a {
        void a(int i3, View view);
    }

    public a(InterfaceC0136a interfaceC0136a, int i3) {
        this.f12538a = interfaceC0136a;
        this.f12539b = i3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12538a.a(this.f12539b, view);
    }
}
