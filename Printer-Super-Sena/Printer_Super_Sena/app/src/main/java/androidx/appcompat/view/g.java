package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.S;
import androidx.appcompat.widget.j0;
import androidx.core.view.AbstractC0284b;
import androidx.core.view.AbstractC0331z;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class g extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Class[] f2665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Class[] f2666f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object[] f2667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object[] f2668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Context f2669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f2670d;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Class[] f2671c = {MenuItem.class};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f2672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Method f2673b;

        public a(Object obj, String str) {
            this.f2672a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f2673b = cls.getMethod(str, f2671c);
            } catch (Exception e3) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e3);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f2673b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f2673b.invoke(this.f2672a, menuItem)).booleanValue();
                }
                this.f2673b.invoke(this.f2672a, menuItem);
                return true;
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    private class b {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        AbstractC0284b f2674A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        private CharSequence f2675B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        private CharSequence f2676C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        private ColorStateList f2677D = null;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        private PorterDuff.Mode f2678E = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Menu f2680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2681b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2682c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2683d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f2684e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f2685f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f2686g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f2687h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f2688i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f2689j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private CharSequence f2690k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private CharSequence f2691l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f2692m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private char f2693n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f2694o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private char f2695p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f2696q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f2697r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f2698s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f2699t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private boolean f2700u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f2701v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private int f2702w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private String f2703x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private String f2704y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private String f2705z;

        public b(Menu menu) {
            this.f2680a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f2669c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e3) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e3);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z3 = false;
            menuItem.setChecked(this.f2698s).setVisible(this.f2699t).setEnabled(this.f2700u).setCheckable(this.f2697r >= 1).setTitleCondensed(this.f2691l).setIcon(this.f2692m);
            int i3 = this.f2701v;
            if (i3 >= 0) {
                menuItem.setShowAsAction(i3);
            }
            if (this.f2705z != null) {
                if (g.this.f2669c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f2705z));
            }
            if (this.f2697r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.i) {
                    ((androidx.appcompat.view.menu.i) menuItem).t(true);
                } else if (menuItem instanceof j) {
                    ((j) menuItem).h(true);
                }
            }
            String str = this.f2703x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f2665e, g.this.f2667a));
                z3 = true;
            }
            int i4 = this.f2702w;
            if (i4 > 0) {
                if (z3) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i4);
                }
            }
            AbstractC0284b abstractC0284b = this.f2674A;
            if (abstractC0284b != null) {
                AbstractC0331z.a(menuItem, abstractC0284b);
            }
            AbstractC0331z.c(menuItem, this.f2675B);
            AbstractC0331z.g(menuItem, this.f2676C);
            AbstractC0331z.b(menuItem, this.f2693n, this.f2694o);
            AbstractC0331z.f(menuItem, this.f2695p, this.f2696q);
            PorterDuff.Mode mode = this.f2678E;
            if (mode != null) {
                AbstractC0331z.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.f2677D;
            if (colorStateList != null) {
                AbstractC0331z.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f2687h = true;
            i(this.f2680a.add(this.f2681b, this.f2688i, this.f2689j, this.f2690k));
        }

        public SubMenu b() {
            this.f2687h = true;
            SubMenu subMenuAddSubMenu = this.f2680a.addSubMenu(this.f2681b, this.f2688i, this.f2689j, this.f2690k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d() {
            return this.f2687h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f2669c.obtainStyledAttributes(attributeSet, p012d.j.f9432w1);
            this.f2681b = typedArrayObtainStyledAttributes.getResourceId(p012d.j.f9440y1, 0);
            this.f2682c = typedArrayObtainStyledAttributes.getInt(p012d.j.f9259A1, 0);
            this.f2683d = typedArrayObtainStyledAttributes.getInt(p012d.j.f9263B1, 0);
            this.f2684e = typedArrayObtainStyledAttributes.getInt(p012d.j.f9267C1, 0);
            this.f2685f = typedArrayObtainStyledAttributes.getBoolean(p012d.j.f9444z1, true);
            this.f2686g = typedArrayObtainStyledAttributes.getBoolean(p012d.j.f9436x1, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            j0 j0VarU = j0.u(g.this.f2669c, attributeSet, p012d.j.f9271D1);
            this.f2688i = j0VarU.n(p012d.j.f9283G1, 0);
            this.f2689j = (j0VarU.k(p012d.j.f9293J1, this.f2682c) & (-65536)) | (j0VarU.k(p012d.j.f9296K1, this.f2683d) & 65535);
            this.f2690k = j0VarU.p(p012d.j.f9299L1);
            this.f2691l = j0VarU.p(p012d.j.f9302M1);
            this.f2692m = j0VarU.n(p012d.j.f9275E1, 0);
            this.f2693n = c(j0VarU.o(p012d.j.f9305N1));
            this.f2694o = j0VarU.k(p012d.j.f9326U1, 4096);
            this.f2695p = c(j0VarU.o(p012d.j.f9308O1));
            this.f2696q = j0VarU.k(p012d.j.f9338Y1, 4096);
            int i3 = p012d.j.f9311P1;
            if (j0VarU.s(i3)) {
                this.f2697r = j0VarU.a(i3, false) ? 1 : 0;
            } else {
                this.f2697r = this.f2684e;
            }
            this.f2698s = j0VarU.a(p012d.j.f9287H1, false);
            this.f2699t = j0VarU.a(p012d.j.f9290I1, this.f2685f);
            this.f2700u = j0VarU.a(p012d.j.f9279F1, this.f2686g);
            this.f2701v = j0VarU.k(p012d.j.f9341Z1, -1);
            this.f2705z = j0VarU.o(p012d.j.f9314Q1);
            this.f2702w = j0VarU.n(p012d.j.f9317R1, 0);
            this.f2703x = j0VarU.o(p012d.j.f9323T1);
            String strO = j0VarU.o(p012d.j.f9320S1);
            this.f2704y = strO;
            boolean z3 = strO != null;
            if (z3 && this.f2702w == 0 && this.f2703x == null) {
                this.f2674A = (AbstractC0284b) e(strO, g.f2666f, g.this.f2668b);
            } else {
                if (z3) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f2674A = null;
            }
            this.f2675B = j0VarU.p(p012d.j.f9329V1);
            this.f2676C = j0VarU.p(p012d.j.f9345a2);
            int i4 = p012d.j.f9335X1;
            if (j0VarU.s(i4)) {
                this.f2678E = S.e(j0VarU.k(i4, -1), this.f2678E);
            } else {
                this.f2678E = null;
            }
            int i5 = p012d.j.f9332W1;
            if (j0VarU.s(i5)) {
                this.f2677D = j0VarU.c(i5);
            } else {
                this.f2677D = null;
            }
            j0VarU.w();
            this.f2687h = false;
        }

        public void h() {
            this.f2681b = 0;
            this.f2682c = 0;
            this.f2683d = 0;
            this.f2684e = 0;
            this.f2685f = true;
            this.f2686g = true;
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f2665e = clsArr;
        f2666f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f2669c = context;
        Object[] objArr = {context};
        this.f2667a = objArr;
        this.f2668b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                    break;
                }
                throw new RuntimeException("Expecting menu, got " + name);
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        String str = null;
        boolean z3 = false;
        boolean z4 = false;
        while (!z3) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z4 && name2.equals(str)) {
                        str = null;
                        z4 = false;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            AbstractC0284b abstractC0284b = bVar.f2674A;
                            if (abstractC0284b == null || !abstractC0284b.a()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z3 = true;
                    }
                }
            } else if (!z4) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z4 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    Object b() {
        if (this.f2670d == null) {
            this.f2670d = a(this.f2669c);
        }
        return this.f2670d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i3, Menu menu) {
        if (!(menu instanceof p073w.a)) {
            super.inflate(i3, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f2669c.getResources().getLayout(i3);
                    c(layout, Xml.asAttributeSet(layout), menu);
                    if (layout != null) {
                        layout.close();
                    }
                } catch (IOException e3) {
                    throw new InflateException("Error inflating menu XML", e3);
                }
            } catch (XmlPullParserException e4) {
                throw new InflateException("Error inflating menu XML", e4);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
