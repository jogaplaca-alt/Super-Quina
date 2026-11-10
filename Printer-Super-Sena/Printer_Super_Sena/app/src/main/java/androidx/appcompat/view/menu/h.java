package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.DialogInterfaceC0247c;
import com.hoho.android.usbserial.driver.UsbId;

/* JADX INFO: loaded from: classes.dex */
class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, m.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f2863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DialogInterfaceC0247c f2864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    e f2865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private m.a f2866d;

    public h(g gVar) {
        this.f2863a = gVar;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void a(g gVar, boolean z3) {
        if (z3 || gVar == this.f2863a) {
            c();
        }
        m.a aVar = this.f2866d;
        if (aVar != null) {
            aVar.a(gVar, z3);
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean b(g gVar) {
        m.a aVar = this.f2866d;
        if (aVar != null) {
            return aVar.b(gVar);
        }
        return false;
    }

    public void c() {
        DialogInterfaceC0247c dialogInterfaceC0247c = this.f2864b;
        if (dialogInterfaceC0247c != null) {
            dialogInterfaceC0247c.dismiss();
        }
    }

    public void d(IBinder iBinder) {
        g gVar = this.f2863a;
        DialogInterfaceC0247c.a aVar = new DialogInterfaceC0247c.a(gVar.w());
        e eVar = new e(aVar.b(), p012d.g.f9227j);
        this.f2865c = eVar;
        eVar.l(this);
        this.f2863a.b(this.f2865c);
        aVar.c(this.f2865c.b(), this);
        View viewA = gVar.A();
        if (viewA != null) {
            aVar.d(viewA);
        } else {
            aVar.e(gVar.y()).j(gVar.z());
        }
        aVar.g(this);
        DialogInterfaceC0247c dialogInterfaceC0247cA = aVar.a();
        this.f2864b = dialogInterfaceC0247cA;
        dialogInterfaceC0247cA.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f2864b.getWindow().getAttributes();
        attributes.type = UsbId.VENDOR_ATMEL;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f2864b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        this.f2863a.N((i) this.f2865c.b().getItem(i3), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f2865c.a(this.f2863a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i3 == 82 || i3 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f2864b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f2864b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f2863a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f2863a.performShortcut(i3, keyEvent, 0);
    }
}
