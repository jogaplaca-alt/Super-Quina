package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class r extends g implements SubMenu {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private g f2948B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private i f2949C;

    public r(Context context, g gVar, i iVar) {
        super(context);
        this.f2948B = gVar;
        this.f2949C = iVar;
    }

    @Override // androidx.appcompat.view.menu.g
    public g F() {
        return this.f2948B.F();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean H() {
        return this.f2948B.H();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean I() {
        return this.f2948B.I();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean J() {
        return this.f2948B.J();
    }

    @Override // androidx.appcompat.view.menu.g
    public void V(g.a aVar) {
        this.f2948B.V(aVar);
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean f(i iVar) {
        return this.f2948B.f(iVar);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f2949C;
    }

    @Override // androidx.appcompat.view.menu.g
    boolean h(g gVar, MenuItem menuItem) {
        return super.h(gVar, menuItem) || this.f2948B.h(gVar, menuItem);
    }

    public Menu i0() {
        return this.f2948B;
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean m(i iVar) {
        return this.f2948B.m(iVar);
    }

    @Override // androidx.appcompat.view.menu.g, p073w.a, android.view.Menu
    public void setGroupDividerEnabled(boolean z3) {
        this.f2948B.setGroupDividerEnabled(z3);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.Z(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.c0(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.d0(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f2949C.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.g, android.view.Menu
    public void setQwertyMode(boolean z3) {
        this.f2948B.setQwertyMode(z3);
    }

    @Override // androidx.appcompat.view.menu.g
    public String v() {
        i iVar = this.f2949C;
        int itemId = iVar != null ? iVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.v() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i3) {
        return (SubMenu) super.Y(i3);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i3) {
        return (SubMenu) super.b0(i3);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i3) {
        this.f2949C.setIcon(i3);
        return this;
    }
}
