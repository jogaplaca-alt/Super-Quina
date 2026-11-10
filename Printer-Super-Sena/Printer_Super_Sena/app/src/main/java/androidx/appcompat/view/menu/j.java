package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.AbstractC0284b;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class j extends androidx.appcompat.view.menu.c implements MenuItem {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final p073w.b f2899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Method f2900e;

    private class a extends AbstractC0284b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final ActionProvider f2901d;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f2901d = actionProvider;
        }

        @Override // androidx.core.view.AbstractC0284b
        public boolean a() {
            return this.f2901d.hasSubMenu();
        }

        @Override // androidx.core.view.AbstractC0284b
        public boolean d() {
            return this.f2901d.onPerformDefaultAction();
        }

        @Override // androidx.core.view.AbstractC0284b
        public void e(SubMenu subMenu) {
            this.f2901d.onPrepareSubMenu(j.this.d(subMenu));
        }
    }

    private class b extends a implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private AbstractC0284b.InterfaceC0061b f2903f;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.view.AbstractC0284b
        public boolean b() {
            return this.f2901d.isVisible();
        }

        @Override // androidx.core.view.AbstractC0284b
        public View c(MenuItem menuItem) {
            return this.f2901d.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.AbstractC0284b
        public boolean f() {
            return this.f2901d.overridesItemVisibility();
        }

        @Override // androidx.core.view.AbstractC0284b
        public void i(AbstractC0284b.InterfaceC0061b interfaceC0061b) {
            this.f2903f = interfaceC0061b;
            this.f2901d.setVisibilityListener(interfaceC0061b != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z3) {
            AbstractC0284b.InterfaceC0061b interfaceC0061b = this.f2903f;
            if (interfaceC0061b != null) {
                interfaceC0061b.onActionProviderVisibilityChanged(z3);
            }
        }
    }

    static class c extends FrameLayout implements androidx.appcompat.view.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CollapsibleActionView f2905a;

        /* JADX WARN: Multi-variable type inference failed */
        c(View view) {
            super(view.getContext());
            this.f2905a = (CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f2905a;
        }

        @Override // androidx.appcompat.view.c
        public void c() {
            this.f2905a.onActionViewExpanded();
        }

        @Override // androidx.appcompat.view.c
        public void f() {
            this.f2905a.onActionViewCollapsed();
        }
    }

    private class d implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f2906a;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f2906a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f2906a.onMenuItemActionCollapse(j.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f2906a.onMenuItemActionExpand(j.this.c(menuItem));
        }
    }

    private class e implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f2908a;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f2908a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f2908a.onMenuItemClick(j.this.c(menuItem));
        }
    }

    public j(Context context, p073w.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f2899d = bVar;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f2899d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f2899d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        AbstractC0284b abstractC0284bB = this.f2899d.b();
        if (abstractC0284bB instanceof a) {
            return ((a) abstractC0284bB).f2901d;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f2899d.getActionView();
        return actionView instanceof c ? ((c) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f2899d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f2899d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f2899d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f2899d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f2899d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f2899d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f2899d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f2899d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f2899d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f2899d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f2899d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f2899d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f2899d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.f2899d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f2899d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f2899d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f2899d.getTooltipText();
    }

    public void h(boolean z3) {
        try {
            if (this.f2900e == null) {
                this.f2900e = this.f2899d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f2900e.invoke(this.f2899d, Boolean.valueOf(z3));
        } catch (Exception e3) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e3);
        }
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f2899d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f2899d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f2899d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f2899d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f2899d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f2899d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this.f2778a, actionProvider);
        p073w.b bVar2 = this.f2899d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f2899d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3) {
        this.f2899d.setAlphabeticShortcut(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z3) {
        this.f2899d.setCheckable(z3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z3) {
        this.f2899d.setChecked(z3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f2899d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z3) {
        this.f2899d.setEnabled(z3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f2899d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f2899d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f2899d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f2899d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c3) {
        this.f2899d.setNumericShortcut(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f2899d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f2899d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4) {
        this.f2899d.setShortcut(c3, c4);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i3) {
        this.f2899d.setShowAsAction(i3);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i3) {
        this.f2899d.setShowAsActionFlags(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f2899d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2899d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f2899d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z3) {
        return this.f2899d.setVisible(z3);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3, int i3) {
        this.f2899d.setAlphabeticShortcut(c3, i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i3) {
        this.f2899d.setIcon(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c3, int i3) {
        this.f2899d.setNumericShortcut(c3, i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4, int i3, int i4) {
        this.f2899d.setShortcut(c3, c4, i3, i4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i3) {
        this.f2899d.setTitle(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i3) {
        this.f2899d.setActionView(i3);
        View actionView = this.f2899d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f2899d.setActionView(new c(actionView));
        }
        return this;
    }
}
