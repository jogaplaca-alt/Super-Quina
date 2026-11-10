package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes.dex */
public class d extends ContextWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Configuration f2646f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Resources.Theme f2648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutInflater f2649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Configuration f2650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Resources f2651e;

    static class a {
        static Context a(d dVar, Configuration configuration) {
            return dVar.createConfigurationContext(configuration);
        }
    }

    public d(Context context, int i3) {
        super(context);
        this.f2647a = i3;
    }

    private Resources b() {
        if (this.f2651e == null) {
            Configuration configuration = this.f2650d;
            if (configuration == null || (Build.VERSION.SDK_INT >= 26 && e(configuration))) {
                this.f2651e = super.getResources();
            } else {
                this.f2651e = a.a(this, this.f2650d).getResources();
            }
        }
        return this.f2651e;
    }

    private void d() {
        boolean z3 = this.f2648b == null;
        if (z3) {
            this.f2648b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f2648b.setTo(theme);
            }
        }
        f(this.f2648b, this.f2647a, z3);
    }

    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f2646f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f2646f = configuration2;
        }
        return configuration.equals(f2646f);
    }

    public void a(Configuration configuration) {
        if (this.f2651e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f2650d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f2650d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f2647a;
    }

    protected void f(Resources.Theme theme, int i3, boolean z3) {
        theme.applyStyle(i3, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f2649c == null) {
            this.f2649c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f2649c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f2648b;
        if (theme != null) {
            return theme;
        }
        if (this.f2647a == 0) {
            this.f2647a = p012d.i.f9256e;
        }
        d();
        return this.f2648b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        if (this.f2647a != i3) {
            this.f2647a = i3;
            d();
        }
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f2648b = theme;
    }
}
