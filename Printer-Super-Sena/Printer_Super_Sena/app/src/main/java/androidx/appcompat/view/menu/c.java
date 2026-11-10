package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f2778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private p046n.g f2779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p046n.g f2780c;

    c(Context context) {
        this.f2778a = context;
    }

    final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof p073w.b)) {
            return menuItem;
        }
        p073w.b bVar = (p073w.b) menuItem;
        if (this.f2779b == null) {
            this.f2779b = new p046n.g();
        }
        MenuItem menuItem2 = (MenuItem) this.f2779b.get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.f2778a, bVar);
        this.f2779b.put(bVar, jVar);
        return jVar;
    }

    final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }

    final void e() {
        p046n.g gVar = this.f2779b;
        if (gVar != null) {
            gVar.clear();
        }
        p046n.g gVar2 = this.f2780c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    final void f(int i3) {
        if (this.f2779b == null) {
            return;
        }
        int i4 = 0;
        while (i4 < this.f2779b.size()) {
            if (((p073w.b) this.f2779b.i(i4)).getGroupId() == i3) {
                this.f2779b.k(i4);
                i4--;
            }
            i4++;
        }
    }

    final void g(int i3) {
        if (this.f2779b == null) {
            return;
        }
        for (int i4 = 0; i4 < this.f2779b.size(); i4++) {
            if (((p073w.b) this.f2779b.i(i4)).getItemId() == i3) {
                this.f2779b.k(i4);
                return;
            }
        }
    }
}
