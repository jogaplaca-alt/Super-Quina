package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.AbstractC0284b;

/* JADX INFO: loaded from: classes.dex */
public final class i implements p073w.b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private View f2867A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private AbstractC0284b f2868B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private MenuItem.OnActionExpandListener f2869C;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f2871E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f2876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f2877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Intent f2878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private char f2879h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private char f2881j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Drawable f2883l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    g f2885n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private r f2886o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Runnable f2887p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f2888q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CharSequence f2889r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CharSequence f2890s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f2897z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2880i = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f2882k = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f2884m = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ColorStateList f2891t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private PorterDuff.Mode f2892u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f2893v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f2894w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f2895x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f2896y = 16;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private boolean f2870D = false;

    class a implements AbstractC0284b.InterfaceC0061b {
        a() {
        }

        @Override // androidx.core.view.AbstractC0284b.InterfaceC0061b
        public void onActionProviderVisibilityChanged(boolean z3) {
            i iVar = i.this;
            iVar.f2885n.L(iVar);
        }
    }

    i(g gVar, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7) {
        this.f2885n = gVar;
        this.f2872a = i4;
        this.f2873b = i3;
        this.f2874c = i5;
        this.f2875d = i6;
        this.f2876e = charSequence;
        this.f2897z = i7;
    }

    private static void d(StringBuilder sb, int i3, int i4, String str) {
        if ((i3 & i4) == i4) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f2895x && (this.f2893v || this.f2894w)) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            if (this.f2893v) {
                androidx.core.graphics.drawable.a.o(drawable, this.f2891t);
            }
            if (this.f2894w) {
                androidx.core.graphics.drawable.a.p(drawable, this.f2892u);
            }
            this.f2895x = false;
        }
        return drawable;
    }

    boolean A() {
        return this.f2885n.J() && g() != 0;
    }

    public boolean B() {
        return (this.f2897z & 4) == 4;
    }

    @Override // p073w.b
    public p073w.b a(AbstractC0284b abstractC0284b) {
        AbstractC0284b abstractC0284b2 = this.f2868B;
        if (abstractC0284b2 != null) {
            abstractC0284b2.g();
        }
        this.f2867A = null;
        this.f2868B = abstractC0284b;
        this.f2885n.M(true);
        AbstractC0284b abstractC0284b3 = this.f2868B;
        if (abstractC0284b3 != null) {
            abstractC0284b3.i(new a());
        }
        return this;
    }

    @Override // p073w.b
    public AbstractC0284b b() {
        return this.f2868B;
    }

    public void c() {
        this.f2885n.K(this);
    }

    @Override // p073w.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f2897z & 8) == 0) {
            return false;
        }
        if (this.f2867A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f2869C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f2885n.f(this);
        }
        return false;
    }

    @Override // p073w.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f2869C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f2885n.m(this);
        }
        return false;
    }

    public int f() {
        return this.f2875d;
    }

    char g() {
        return this.f2885n.I() ? this.f2881j : this.f2879h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // p073w.b, android.view.MenuItem
    public View getActionView() {
        View view = this.f2867A;
        if (view != null) {
            return view;
        }
        AbstractC0284b abstractC0284b = this.f2868B;
        if (abstractC0284b == null) {
            return null;
        }
        View viewC = abstractC0284b.c(this);
        this.f2867A = viewC;
        return viewC;
    }

    @Override // p073w.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f2882k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f2881j;
    }

    @Override // p073w.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f2889r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f2873b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f2883l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f2884m == 0) {
            return null;
        }
        Drawable drawableB = p016e.a.b(this.f2885n.w(), this.f2884m);
        this.f2884m = 0;
        this.f2883l = drawableB;
        return e(drawableB);
    }

    @Override // p073w.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f2891t;
    }

    @Override // p073w.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f2892u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f2878g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f2872a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f2871E;
    }

    @Override // p073w.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f2880i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f2879h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f2874c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f2886o;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f2876e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f2877f;
        return charSequence != null ? charSequence : this.f2876e;
    }

    @Override // p073w.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f2890s;
    }

    String h() {
        char cG = g();
        if (cG == 0) {
            return "";
        }
        Resources resources = this.f2885n.w().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f2885n.w()).hasPermanentMenuKey()) {
            sb.append(resources.getString(p012d.h.f9250m));
        }
        int i3 = this.f2885n.I() ? this.f2882k : this.f2880i;
        d(sb, i3, 65536, resources.getString(p012d.h.f9246i));
        d(sb, i3, 4096, resources.getString(p012d.h.f9242e));
        d(sb, i3, 2, resources.getString(p012d.h.f9241d));
        d(sb, i3, 1, resources.getString(p012d.h.f9247j));
        d(sb, i3, 4, resources.getString(p012d.h.f9249l));
        d(sb, i3, 8, resources.getString(p012d.h.f9245h));
        if (cG == '\b') {
            sb.append(resources.getString(p012d.h.f9243f));
        } else if (cG == '\n') {
            sb.append(resources.getString(p012d.h.f9244g));
        } else if (cG != ' ') {
            sb.append(cG);
        } else {
            sb.append(resources.getString(p012d.h.f9248k));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f2886o != null;
    }

    CharSequence i(n.a aVar) {
        return (aVar == null || !aVar.d()) ? getTitle() : getTitleCondensed();
    }

    @Override // p073w.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f2870D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f2896y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f2896y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f2896y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        AbstractC0284b abstractC0284b = this.f2868B;
        if (abstractC0284b == null || !abstractC0284b.f()) {
            return (this.f2896y & 8) == 0;
        }
        return (this.f2896y & 8) == 0 && this.f2868B.b();
    }

    public boolean j() {
        AbstractC0284b abstractC0284b;
        if ((this.f2897z & 8) == 0) {
            return false;
        }
        if (this.f2867A == null && (abstractC0284b = this.f2868B) != null) {
            this.f2867A = abstractC0284b.c(this);
        }
        return this.f2867A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f2888q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        g gVar = this.f2885n;
        if (gVar.h(gVar, this)) {
            return true;
        }
        Runnable runnable = this.f2887p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f2878g != null) {
            try {
                this.f2885n.w().startActivity(this.f2878g);
                return true;
            } catch (ActivityNotFoundException e3) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e3);
            }
        }
        AbstractC0284b abstractC0284b = this.f2868B;
        return abstractC0284b != null && abstractC0284b.d();
    }

    public boolean l() {
        return (this.f2896y & 32) == 32;
    }

    public boolean m() {
        return (this.f2896y & 4) != 0;
    }

    public boolean n() {
        return (this.f2897z & 1) == 1;
    }

    public boolean o() {
        return (this.f2897z & 2) == 2;
    }

    @Override // p073w.b, android.view.MenuItem
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public p073w.b setActionView(int i3) {
        Context contextW = this.f2885n.w();
        setActionView(LayoutInflater.from(contextW).inflate(i3, (ViewGroup) new LinearLayout(contextW), false));
        return this;
    }

    @Override // p073w.b, android.view.MenuItem
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public p073w.b setActionView(View view) {
        int i3;
        this.f2867A = view;
        this.f2868B = null;
        if (view != null && view.getId() == -1 && (i3 = this.f2872a) > 0) {
            view.setId(i3);
        }
        this.f2885n.K(this);
        return this;
    }

    public void r(boolean z3) {
        this.f2870D = z3;
        this.f2885n.M(false);
    }

    void s(boolean z3) {
        int i3 = this.f2896y;
        int i4 = (z3 ? 2 : 0) | (i3 & (-3));
        this.f2896y = i4;
        if (i3 != i4) {
            this.f2885n.M(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3) {
        if (this.f2881j == c3) {
            return this;
        }
        this.f2881j = Character.toLowerCase(c3);
        this.f2885n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z3) {
        int i3 = this.f2896y;
        int i4 = (z3 ? 1 : 0) | (i3 & (-2));
        this.f2896y = i4;
        if (i3 != i4) {
            this.f2885n.M(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z3) {
        if ((this.f2896y & 4) != 0) {
            this.f2885n.X(this);
        } else {
            s(z3);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z3) {
        if (z3) {
            this.f2896y |= 16;
        } else {
            this.f2896y &= -17;
        }
        this.f2885n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f2884m = 0;
        this.f2883l = drawable;
        this.f2895x = true;
        this.f2885n.M(false);
        return this;
    }

    @Override // p073w.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f2891t = colorStateList;
        this.f2893v = true;
        this.f2895x = true;
        this.f2885n.M(false);
        return this;
    }

    @Override // p073w.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f2892u = mode;
        this.f2894w = true;
        this.f2895x = true;
        this.f2885n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f2878g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c3) {
        if (this.f2879h == c3) {
            return this;
        }
        this.f2879h = c3;
        this.f2885n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f2869C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f2888q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4) {
        this.f2879h = c3;
        this.f2881j = Character.toLowerCase(c4);
        this.f2885n.M(false);
        return this;
    }

    @Override // p073w.b, android.view.MenuItem
    public void setShowAsAction(int i3) {
        int i4 = i3 & 3;
        if (i4 != 0 && i4 != 1 && i4 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f2897z = i3;
        this.f2885n.K(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f2876e = charSequence;
        this.f2885n.M(false);
        r rVar = this.f2886o;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2877f = charSequence;
        this.f2885n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z3) {
        if (y(z3)) {
            this.f2885n.L(this);
        }
        return this;
    }

    public void t(boolean z3) {
        this.f2896y = (z3 ? 4 : 0) | (this.f2896y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f2876e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z3) {
        if (z3) {
            this.f2896y |= 32;
        } else {
            this.f2896y &= -33;
        }
    }

    void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f2871E = contextMenuInfo;
    }

    @Override // p073w.b, android.view.MenuItem
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public p073w.b setShowAsActionFlags(int i3) {
        setShowAsAction(i3);
        return this;
    }

    public void x(r rVar) {
        this.f2886o = rVar;
        rVar.setHeaderTitle(getTitle());
    }

    boolean y(boolean z3) {
        int i3 = this.f2896y;
        int i4 = (z3 ? 0 : 8) | (i3 & (-9));
        this.f2896y = i4;
        return i3 != i4;
    }

    public boolean z() {
        return this.f2885n.C();
    }

    @Override // android.view.MenuItem
    public p073w.b setContentDescription(CharSequence charSequence) {
        this.f2889r = charSequence;
        this.f2885n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public p073w.b setTooltipText(CharSequence charSequence) {
        this.f2890s = charSequence;
        this.f2885n.M(false);
        return this;
    }

    @Override // p073w.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3, int i3) {
        if (this.f2881j == c3 && this.f2882k == i3) {
            return this;
        }
        this.f2881j = Character.toLowerCase(c3);
        this.f2882k = KeyEvent.normalizeMetaState(i3);
        this.f2885n.M(false);
        return this;
    }

    @Override // p073w.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c3, int i3) {
        if (this.f2879h == c3 && this.f2880i == i3) {
            return this;
        }
        this.f2879h = c3;
        this.f2880i = KeyEvent.normalizeMetaState(i3);
        this.f2885n.M(false);
        return this;
    }

    @Override // p073w.b, android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4, int i3, int i4) {
        this.f2879h = c3;
        this.f2880i = KeyEvent.normalizeMetaState(i3);
        this.f2881j = Character.toLowerCase(c4);
        this.f2882k = KeyEvent.normalizeMetaState(i4);
        this.f2885n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i3) {
        this.f2883l = null;
        this.f2884m = i3;
        this.f2895x = true;
        this.f2885n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i3) {
        return setTitle(this.f2885n.w().getString(i3));
    }
}
