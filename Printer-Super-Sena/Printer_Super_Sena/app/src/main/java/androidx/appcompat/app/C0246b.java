package androidx.appcompat.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: renamed from: androidx.appcompat.app.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0246b implements DrawerLayout.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0041b f2505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DrawerLayout f2506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p020f.d f2507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f2509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f2510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f2511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f2512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    View.OnClickListener f2513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2514j;

    /* JADX INFO: renamed from: androidx.appcompat.app.b$a */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C0246b c0246b = C0246b.this;
            if (c0246b.f2510f) {
                c0246b.j();
                return;
            }
            View.OnClickListener onClickListener = c0246b.f2513i;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.b$b, reason: collision with other inner class name */
    public interface InterfaceC0041b {
        void a(int i3);

        void b(Drawable drawable, int i3);

        Context c();

        boolean d();

        Drawable e();
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.b$c */
    public interface c {
        InterfaceC0041b getDrawerToggleDelegate();
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.b$d */
    private static class d implements InterfaceC0041b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f2516a;

        /* JADX INFO: renamed from: androidx.appcompat.app.b$d$a */
        static class a {
            static void a(ActionBar actionBar, int i3) {
                actionBar.setHomeActionContentDescription(i3);
            }

            static void b(ActionBar actionBar, Drawable drawable) {
                actionBar.setHomeAsUpIndicator(drawable);
            }
        }

        d(Activity activity) {
            this.f2516a = activity;
        }

        @Override // androidx.appcompat.app.C0246b.InterfaceC0041b
        public void a(int i3) {
            ActionBar actionBar = this.f2516a.getActionBar();
            if (actionBar != null) {
                a.a(actionBar, i3);
            }
        }

        @Override // androidx.appcompat.app.C0246b.InterfaceC0041b
        public void b(Drawable drawable, int i3) {
            ActionBar actionBar = this.f2516a.getActionBar();
            if (actionBar != null) {
                a.b(actionBar, drawable);
                a.a(actionBar, i3);
            }
        }

        @Override // androidx.appcompat.app.C0246b.InterfaceC0041b
        public Context c() {
            ActionBar actionBar = this.f2516a.getActionBar();
            return actionBar != null ? actionBar.getThemedContext() : this.f2516a;
        }

        @Override // androidx.appcompat.app.C0246b.InterfaceC0041b
        public boolean d() {
            ActionBar actionBar = this.f2516a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.C0246b.InterfaceC0041b
        public Drawable e() {
            TypedArray typedArrayObtainStyledAttributes = c().obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
            return drawable;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.b$e */
    static class e implements InterfaceC0041b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Toolbar f2517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Drawable f2518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CharSequence f2519c;

        e(Toolbar toolbar) {
            this.f2517a = toolbar;
            this.f2518b = toolbar.getNavigationIcon();
            this.f2519c = toolbar.getNavigationContentDescription();
        }

        @Override // androidx.appcompat.app.C0246b.InterfaceC0041b
        public void a(int i3) {
            if (i3 == 0) {
                this.f2517a.setNavigationContentDescription(this.f2519c);
            } else {
                this.f2517a.setNavigationContentDescription(i3);
            }
        }

        @Override // androidx.appcompat.app.C0246b.InterfaceC0041b
        public void b(Drawable drawable, int i3) {
            this.f2517a.setNavigationIcon(drawable);
            a(i3);
        }

        @Override // androidx.appcompat.app.C0246b.InterfaceC0041b
        public Context c() {
            return this.f2517a.getContext();
        }

        @Override // androidx.appcompat.app.C0246b.InterfaceC0041b
        public boolean d() {
            return true;
        }

        @Override // androidx.appcompat.app.C0246b.InterfaceC0041b
        public Drawable e() {
            return this.f2518b;
        }
    }

    public C0246b(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int i3, int i4) {
        this(activity, toolbar, drawerLayout, null, i3, i4);
    }

    private void h(float f3) {
        if (f3 == 1.0f) {
            this.f2507c.g(true);
        } else if (f3 == 0.0f) {
            this.f2507c.g(false);
        }
        this.f2507c.e(f3);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.d
    public void a(int i3) {
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.d
    public void b(View view) {
        h(1.0f);
        if (this.f2510f) {
            f(this.f2512h);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.d
    public void c(View view, float f3) {
        if (this.f2508d) {
            h(Math.min(1.0f, Math.max(0.0f, f3)));
        } else {
            h(0.0f);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.d
    public void d(View view) {
        h(0.0f);
        if (this.f2510f) {
            f(this.f2511g);
        }
    }

    Drawable e() {
        return this.f2505a.e();
    }

    void f(int i3) {
        this.f2505a.a(i3);
    }

    void g(Drawable drawable, int i3) {
        if (!this.f2514j && !this.f2505a.d()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.f2514j = true;
        }
        this.f2505a.b(drawable, i3);
    }

    public void i() {
        if (this.f2506b.E(8388611)) {
            h(1.0f);
        } else {
            h(0.0f);
        }
        if (this.f2510f) {
            g(this.f2507c, this.f2506b.E(8388611) ? this.f2512h : this.f2511g);
        }
    }

    void j() {
        int iS = this.f2506b.s(8388611);
        if (this.f2506b.H(8388611) && iS != 2) {
            this.f2506b.f(8388611);
        } else if (iS != 1) {
            this.f2506b.O(8388611);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    C0246b(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, p020f.d dVar, int i3, int i4) {
        this.f2508d = true;
        this.f2510f = true;
        this.f2514j = false;
        if (toolbar != null) {
            this.f2505a = new e(toolbar);
            toolbar.setNavigationOnClickListener(new a());
        } else if (activity instanceof c) {
            this.f2505a = ((c) activity).getDrawerToggleDelegate();
        } else {
            this.f2505a = new d(activity);
        }
        this.f2506b = drawerLayout;
        this.f2511g = i3;
        this.f2512h = i4;
        if (dVar == null) {
            this.f2507c = new p020f.d(this.f2505a.c());
        } else {
            this.f2507c = dVar;
        }
        this.f2509e = e();
    }
}
