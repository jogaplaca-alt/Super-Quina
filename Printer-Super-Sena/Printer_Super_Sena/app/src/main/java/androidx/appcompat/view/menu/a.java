package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.view.AbstractC0284b;

/* JADX INFO: loaded from: classes.dex */
public class a implements p073w.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CharSequence f2751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f2752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Intent f2753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private char f2754g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private char f2756i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Drawable f2758k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Context f2759l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f2760m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private CharSequence f2761n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private CharSequence f2762o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2755h = 4096;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2757j = 4096;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ColorStateList f2763p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private PorterDuff.Mode f2764q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f2765r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f2766s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f2767t = 16;

    public a(Context context, int i3, int i4, int i5, int i6, CharSequence charSequence) {
        this.f2759l = context;
        this.f2748a = i4;
        this.f2749b = i3;
        this.f2750c = i6;
        this.f2751d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f2758k;
        if (drawable != null) {
            if (this.f2765r || this.f2766s) {
                Drawable drawableR = androidx.core.graphics.drawable.a.r(drawable);
                this.f2758k = drawableR;
                Drawable drawableMutate = drawableR.mutate();
                this.f2758k = drawableMutate;
                if (this.f2765r) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f2763p);
                }
                if (this.f2766s) {
                    androidx.core.graphics.drawable.a.p(this.f2758k, this.f2764q);
                }
            }
        }
    }

    @Override // p073w.b
    public p073w.b a(AbstractC0284b abstractC0284b) {
        throw new UnsupportedOperationException();
    }

    @Override // p073w.b
    public AbstractC0284b b() {
        return null;
    }

    @Override // p073w.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // p073w.b, android.view.MenuItem
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public p073w.b setActionView(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // p073w.b, android.view.MenuItem
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public p073w.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // p073w.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // p073w.b, android.view.MenuItem
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public p073w.b setShowAsActionFlags(int i3) {
        setShowAsAction(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // p073w.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // p073w.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f2757j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f2756i;
    }

    @Override // p073w.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f2761n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f2749b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f2758k;
    }

    @Override // p073w.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f2763p;
    }

    @Override // p073w.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f2764q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f2753f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f2748a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // p073w.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f2755h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f2754g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f2750c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f2751d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f2752e;
        return charSequence != null ? charSequence : this.f2751d;
    }

    @Override // p073w.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f2762o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // p073w.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f2767t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f2767t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f2767t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f2767t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3) {
        this.f2756i = Character.toLowerCase(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z3) {
        this.f2767t = (z3 ? 1 : 0) | (this.f2767t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z3) {
        this.f2767t = (z3 ? 2 : 0) | (this.f2767t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z3) {
        this.f2767t = (z3 ? 16 : 0) | (this.f2767t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f2758k = drawable;
        c();
        return this;
    }

    @Override // p073w.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f2763p = colorStateList;
        this.f2765r = true;
        c();
        return this;
    }

    @Override // p073w.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f2764q = mode;
        this.f2766s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f2753f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c3) {
        this.f2754g = c3;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f2760m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4) {
        this.f2754g = c3;
        this.f2756i = Character.toLowerCase(c4);
        return this;
    }

    @Override // p073w.b, android.view.MenuItem
    public void setShowAsAction(int i3) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f2751d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2752e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z3) {
        this.f2767t = (this.f2767t & 8) | (z3 ? 0 : 8);
        return this;
    }

    @Override // p073w.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3, int i3) {
        this.f2756i = Character.toLowerCase(c3);
        this.f2757j = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public p073w.b setContentDescription(CharSequence charSequence) {
        this.f2761n = charSequence;
        return this;
    }

    @Override // p073w.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c3, int i3) {
        this.f2754g = c3;
        this.f2755h = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i3) {
        this.f2751d = this.f2759l.getResources().getString(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public p073w.b setTooltipText(CharSequence charSequence) {
        this.f2762o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i3) {
        this.f2758k = androidx.core.content.a.d(this.f2759l, i3);
        c();
        return this;
    }

    @Override // p073w.b, android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4, int i3, int i4) {
        this.f2754g = c3;
        this.f2755h = KeyEvent.normalizeMetaState(i3);
        this.f2756i = Character.toLowerCase(c4);
        this.f2757j = KeyEvent.normalizeMetaState(i4);
        return this;
    }
}
