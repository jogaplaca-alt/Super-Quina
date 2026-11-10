package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0354l;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f5389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClassLoader f5390b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f5392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f5393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f5394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f5395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f5396h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f5397i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    String f5399k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f5400l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    CharSequence f5401m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f5402n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    CharSequence f5403o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ArrayList f5404p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ArrayList f5405q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    ArrayList f5407s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ArrayList f5391c = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f5398j = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f5406r = false;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        AbstractComponentCallbacksC0337e f5409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f5410c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f5411d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f5412e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f5413f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        AbstractC0354l.b f5414g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        AbstractC0354l.b f5415h;

        a() {
        }

        a(int i3, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
            this.f5408a = i3;
            this.f5409b = abstractComponentCallbacksC0337e;
            AbstractC0354l.b bVar = AbstractC0354l.b.RESUMED;
            this.f5414g = bVar;
            this.f5415h = bVar;
        }

        a(int i3, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, AbstractC0354l.b bVar) {
            this.f5408a = i3;
            this.f5409b = abstractComponentCallbacksC0337e;
            this.f5414g = abstractComponentCallbacksC0337e.f5175R;
            this.f5415h = bVar;
        }
    }

    w(k kVar, ClassLoader classLoader) {
        this.f5389a = kVar;
        this.f5390b = classLoader;
    }

    public w b(int i3, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, String str) {
        k(i3, abstractComponentCallbacksC0337e, str, 1);
        return this;
    }

    w c(ViewGroup viewGroup, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, String str) {
        abstractComponentCallbacksC0337e.f5164G = viewGroup;
        return b(viewGroup.getId(), abstractComponentCallbacksC0337e, str);
    }

    public w d(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, String str) {
        k(0, abstractComponentCallbacksC0337e, str, 1);
        return this;
    }

    void e(a aVar) {
        this.f5391c.add(aVar);
        aVar.f5410c = this.f5392d;
        aVar.f5411d = this.f5393e;
        aVar.f5412e = this.f5394f;
        aVar.f5413f = this.f5395g;
    }

    public abstract int f();

    public abstract int g();

    public abstract void h();

    public abstract void i();

    public w j() {
        if (this.f5397i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f5398j = false;
        return this;
    }

    void k(int i3, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, String str, int i4) {
        Class<?> cls = abstractComponentCallbacksC0337e.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = abstractComponentCallbacksC0337e.f5208y;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + abstractComponentCallbacksC0337e + ": was " + abstractComponentCallbacksC0337e.f5208y + " now " + str);
            }
            abstractComponentCallbacksC0337e.f5208y = str;
        }
        if (i3 != 0) {
            if (i3 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + abstractComponentCallbacksC0337e + " with tag " + str + " to container view with no id");
            }
            int i5 = abstractComponentCallbacksC0337e.f5206w;
            if (i5 != 0 && i5 != i3) {
                throw new IllegalStateException("Can't change container ID of fragment " + abstractComponentCallbacksC0337e + ": was " + abstractComponentCallbacksC0337e.f5206w + " now " + i3);
            }
            abstractComponentCallbacksC0337e.f5206w = i3;
            abstractComponentCallbacksC0337e.f5207x = i3;
        }
        e(new a(i4, abstractComponentCallbacksC0337e));
    }

    public abstract boolean l();

    public w m(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        e(new a(3, abstractComponentCallbacksC0337e));
        return this;
    }

    public w n(int i3, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        return o(i3, abstractComponentCallbacksC0337e, null);
    }

    public w o(int i3, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, String str) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        k(i3, abstractComponentCallbacksC0337e, str, 2);
        return this;
    }

    public w p(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, AbstractC0354l.b bVar) {
        e(new a(10, abstractComponentCallbacksC0337e, bVar));
        return this;
    }

    public w q(boolean z3) {
        this.f5406r = z3;
        return this;
    }
}
