package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.AbstractC0284b;
import androidx.core.view.AbstractC0289d0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class g implements p073w.a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final int[] f2836A = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f2838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f2841e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f2849m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    CharSequence f2850n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Drawable f2851o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    View f2852p;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private i f2860x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f2862z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f2848l = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f2853q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f2854r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f2855s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f2856t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f2857u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ArrayList f2858v = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private CopyOnWriteArrayList f2859w = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f2861y = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList f2842f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList f2843g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2844h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList f2845i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList f2846j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2847k = true;

    public interface a {
        boolean a(g gVar, MenuItem menuItem);

        void b(g gVar);
    }

    public interface b {
        boolean a(i iVar);
    }

    public g(Context context) {
        this.f2837a = context;
        this.f2838b = context.getResources();
        f0(true);
    }

    private static int D(int i3) {
        int i4 = ((-65536) & i3) >> 16;
        if (i4 >= 0) {
            int[] iArr = f2836A;
            if (i4 < iArr.length) {
                return (i3 & 65535) | (iArr[i4] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void P(int i3, boolean z3) {
        if (i3 < 0 || i3 >= this.f2842f.size()) {
            return;
        }
        this.f2842f.remove(i3);
        if (z3) {
            M(true);
        }
    }

    private void a0(int i3, CharSequence charSequence, int i4, Drawable drawable, View view) {
        Resources resourcesE = E();
        if (view != null) {
            this.f2852p = view;
            this.f2850n = null;
            this.f2851o = null;
        } else {
            if (i3 > 0) {
                this.f2850n = resourcesE.getText(i3);
            } else if (charSequence != null) {
                this.f2850n = charSequence;
            }
            if (i4 > 0) {
                this.f2851o = androidx.core.content.a.d(w(), i4);
            } else if (drawable != null) {
                this.f2851o = drawable;
            }
            this.f2852p = null;
        }
        M(false);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    private void f0(boolean z3) {
        boolean z4;
        if (z3) {
            z4 = this.f2838b.getConfiguration().keyboard != 1 && AbstractC0289d0.l(ViewConfiguration.get(this.f2837a), this.f2837a);
        }
        this.f2840d = z4;
    }

    private i g(int i3, int i4, int i5, int i6, CharSequence charSequence, int i7) {
        return new i(this, i3, i4, i5, i6, charSequence, i7);
    }

    private void i(boolean z3) {
        if (this.f2859w.isEmpty()) {
            return;
        }
        h0();
        for (WeakReference weakReference : this.f2859w) {
            m mVar = (m) weakReference.get();
            if (mVar == null) {
                this.f2859w.remove(weakReference);
            } else {
                mVar.n(z3);
            }
        }
        g0();
    }

    private void j(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.f2859w.isEmpty()) {
            return;
        }
        for (WeakReference weakReference : this.f2859w) {
            m mVar = (m) weakReference.get();
            if (mVar == null) {
                this.f2859w.remove(weakReference);
            } else {
                int iC = mVar.c();
                if (iC > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(iC)) != null) {
                    mVar.h(parcelable);
                }
            }
        }
    }

    private void k(Bundle bundle) {
        Parcelable parcelableE;
        if (this.f2859w.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        for (WeakReference weakReference : this.f2859w) {
            m mVar = (m) weakReference.get();
            if (mVar == null) {
                this.f2859w.remove(weakReference);
            } else {
                int iC = mVar.c();
                if (iC > 0 && (parcelableE = mVar.e()) != null) {
                    sparseArray.put(iC, parcelableE);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    private boolean l(r rVar, m mVar) {
        if (this.f2859w.isEmpty()) {
            return false;
        }
        boolean zM = mVar != null ? mVar.m(rVar) : false;
        for (WeakReference weakReference : this.f2859w) {
            m mVar2 = (m) weakReference.get();
            if (mVar2 == null) {
                this.f2859w.remove(weakReference);
            } else if (!zM) {
                zM = mVar2.m(rVar);
            }
        }
        return zM;
    }

    private static int p(ArrayList arrayList, int i3) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((i) arrayList.get(size)).f() <= i3) {
                return size + 1;
            }
        }
        return 0;
    }

    public View A() {
        return this.f2852p;
    }

    public ArrayList B() {
        t();
        return this.f2846j;
    }

    boolean C() {
        return this.f2856t;
    }

    Resources E() {
        return this.f2838b;
    }

    public g F() {
        return this;
    }

    public ArrayList G() {
        if (!this.f2844h) {
            return this.f2843g;
        }
        this.f2843g.clear();
        int size = this.f2842f.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = (i) this.f2842f.get(i3);
            if (iVar.isVisible()) {
                this.f2843g.add(iVar);
            }
        }
        this.f2844h = false;
        this.f2847k = true;
        return this.f2843g;
    }

    public boolean H() {
        return this.f2861y;
    }

    boolean I() {
        return this.f2839c;
    }

    public boolean J() {
        return this.f2840d;
    }

    void K(i iVar) {
        this.f2847k = true;
        M(true);
    }

    void L(i iVar) {
        this.f2844h = true;
        M(true);
    }

    public void M(boolean z3) {
        if (this.f2853q) {
            this.f2854r = true;
            if (z3) {
                this.f2855s = true;
                return;
            }
            return;
        }
        if (z3) {
            this.f2844h = true;
            this.f2847k = true;
        }
        i(z3);
    }

    public boolean N(MenuItem menuItem, int i3) {
        return O(menuItem, null, i3);
    }

    public boolean O(MenuItem menuItem, m mVar, int i3) {
        i iVar = (i) menuItem;
        if (iVar == null || !iVar.isEnabled()) {
            return false;
        }
        boolean zK = iVar.k();
        AbstractC0284b abstractC0284bB = iVar.b();
        boolean z3 = abstractC0284bB != null && abstractC0284bB.a();
        if (iVar.j()) {
            zK |= iVar.expandActionView();
            if (zK) {
                e(true);
            }
        } else if (iVar.hasSubMenu() || z3) {
            if ((i3 & 4) == 0) {
                e(false);
            }
            if (!iVar.hasSubMenu()) {
                iVar.x(new r(w(), this, iVar));
            }
            r rVar = (r) iVar.getSubMenu();
            if (z3) {
                abstractC0284bB.e(rVar);
            }
            zK |= l(rVar, mVar);
            if (!zK) {
                e(true);
            }
        } else if ((i3 & 1) == 0) {
            e(true);
        }
        return zK;
    }

    public void Q(m mVar) {
        for (WeakReference weakReference : this.f2859w) {
            m mVar2 = (m) weakReference.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.f2859w.remove(weakReference);
            }
        }
    }

    public void R(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(v());
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = getItem(i3);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((r) item.getSubMenu()).R(bundle);
            }
        }
        int i4 = bundle.getInt("android:menu:expandedactionview");
        if (i4 <= 0 || (menuItemFindItem = findItem(i4)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void S(Bundle bundle) {
        j(bundle);
    }

    public void T(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = getItem(i3);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((r) item.getSubMenu()).T(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(v(), sparseArray);
        }
    }

    public void U(Bundle bundle) {
        k(bundle);
    }

    public void V(a aVar) {
        this.f2841e = aVar;
    }

    public g W(int i3) {
        this.f2848l = i3;
        return this;
    }

    void X(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f2842f.size();
        h0();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = (i) this.f2842f.get(i3);
            if (iVar.getGroupId() == groupId && iVar.m() && iVar.isCheckable()) {
                iVar.s(iVar == menuItem);
            }
        }
        g0();
    }

    protected g Y(int i3) {
        a0(0, null, i3, null, null);
        return this;
    }

    protected g Z(Drawable drawable) {
        a0(0, null, 0, drawable, null);
        return this;
    }

    protected MenuItem a(int i3, int i4, int i5, CharSequence charSequence) {
        int iD = D(i5);
        i iVarG = g(i3, i4, i5, iD, charSequence, this.f2848l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f2849m;
        if (contextMenuInfo != null) {
            iVarG.v(contextMenuInfo);
        }
        ArrayList arrayList = this.f2842f;
        arrayList.add(p(arrayList, iD), iVarG);
        M(true);
        return iVarG;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i3, int i4, int i5, ComponentName componentName, Intent[] intentArr, Intent intent, int i6, MenuItem[] menuItemArr) {
        int i7;
        PackageManager packageManager = this.f2837a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i6 & 1) == 0) {
            removeGroup(i3);
        }
        for (int i8 = 0; i8 < size; i8++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i8);
            int i9 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i9 < 0 ? intent : intentArr[i9]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i3, i4, i5, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i7 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i7] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(m mVar) {
        c(mVar, this.f2837a);
    }

    protected g b0(int i3) {
        a0(i3, null, 0, null, null);
        return this;
    }

    public void c(m mVar, Context context) {
        this.f2859w.add(new WeakReference(mVar));
        mVar.g(context, this);
        this.f2847k = true;
    }

    protected g c0(CharSequence charSequence) {
        a0(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        i iVar = this.f2860x;
        if (iVar != null) {
            f(iVar);
        }
        this.f2842f.clear();
        M(true);
    }

    public void clearHeader() {
        this.f2851o = null;
        this.f2850n = null;
        this.f2852p = null;
        M(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f2841e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    protected g d0(View view) {
        a0(0, null, 0, null, view);
        return this;
    }

    public final void e(boolean z3) {
        if (this.f2857u) {
            return;
        }
        this.f2857u = true;
        for (WeakReference weakReference : this.f2859w) {
            m mVar = (m) weakReference.get();
            if (mVar == null) {
                this.f2859w.remove(weakReference);
            } else {
                mVar.a(this, z3);
            }
        }
        this.f2857u = false;
    }

    public void e0(boolean z3) {
        this.f2862z = z3;
    }

    public boolean f(i iVar) {
        boolean zI = false;
        if (!this.f2859w.isEmpty() && this.f2860x == iVar) {
            h0();
            for (WeakReference weakReference : this.f2859w) {
                m mVar = (m) weakReference.get();
                if (mVar != null) {
                    zI = mVar.i(this, iVar);
                    if (zI) {
                        break;
                    }
                } else {
                    this.f2859w.remove(weakReference);
                }
            }
            g0();
            if (zI) {
                this.f2860x = null;
            }
        }
        return zI;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i3) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            i iVar = (i) this.f2842f.get(i4);
            if (iVar.getItemId() == i3) {
                return iVar;
            }
            if (iVar.hasSubMenu() && (menuItemFindItem = iVar.getSubMenu().findItem(i3)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public void g0() {
        this.f2853q = false;
        if (this.f2854r) {
            this.f2854r = false;
            M(this.f2855s);
        }
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i3) {
        return (MenuItem) this.f2842f.get(i3);
    }

    boolean h(g gVar, MenuItem menuItem) {
        a aVar = this.f2841e;
        return aVar != null && aVar.a(gVar, menuItem);
    }

    public void h0() {
        if (this.f2853q) {
            return;
        }
        this.f2853q = true;
        this.f2854r = false;
        this.f2855s = false;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f2862z) {
            return true;
        }
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((i) this.f2842f.get(i3)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i3, KeyEvent keyEvent) {
        return r(i3, keyEvent) != null;
    }

    public boolean m(i iVar) {
        boolean zJ = false;
        if (this.f2859w.isEmpty()) {
            return false;
        }
        h0();
        for (WeakReference weakReference : this.f2859w) {
            m mVar = (m) weakReference.get();
            if (mVar != null) {
                zJ = mVar.j(this, iVar);
                if (zJ) {
                    break;
                }
            } else {
                this.f2859w.remove(weakReference);
            }
        }
        g0();
        if (zJ) {
            this.f2860x = iVar;
        }
        return zJ;
    }

    public int n(int i3) {
        return o(i3, 0);
    }

    public int o(int i3, int i4) {
        int size = size();
        if (i4 < 0) {
            i4 = 0;
        }
        while (i4 < size) {
            if (((i) this.f2842f.get(i4)).getGroupId() == i3) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i3, int i4) {
        return N(findItem(i3), i4);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i3, KeyEvent keyEvent, int i4) {
        i iVarR = r(i3, keyEvent);
        boolean zN = iVarR != null ? N(iVarR, i4) : false;
        if ((i4 & 2) != 0) {
            e(true);
        }
        return zN;
    }

    public int q(int i3) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (((i) this.f2842f.get(i4)).getItemId() == i3) {
                return i4;
            }
        }
        return -1;
    }

    i r(int i3, KeyEvent keyEvent) {
        ArrayList arrayList = this.f2858v;
        arrayList.clear();
        s(arrayList, i3, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (i) arrayList.get(0);
        }
        boolean zI = I();
        for (int i4 = 0; i4 < size; i4++) {
            i iVar = (i) arrayList.get(i4);
            char alphabeticShortcut = zI ? iVar.getAlphabeticShortcut() : iVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zI && alphabeticShortcut == '\b' && i3 == 67))) {
                return iVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public void removeGroup(int i3) {
        int iN = n(i3);
        if (iN >= 0) {
            int size = this.f2842f.size() - iN;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                if (i4 >= size || ((i) this.f2842f.get(iN)).getGroupId() != i3) {
                    break;
                }
                P(iN, false);
                i4 = i5;
            }
            M(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i3) {
        P(q(i3), true);
    }

    void s(List list, int i3, KeyEvent keyEvent) {
        boolean zI = I();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i3 == 67) {
            int size = this.f2842f.size();
            for (int i4 = 0; i4 < size; i4++) {
                i iVar = (i) this.f2842f.get(i4);
                if (iVar.hasSubMenu()) {
                    ((g) iVar.getSubMenu()).s(list, i3, keyEvent);
                }
                char alphabeticShortcut = zI ? iVar.getAlphabeticShortcut() : iVar.getNumericShortcut();
                if ((modifiers & 69647) == ((zI ? iVar.getAlphabeticModifiers() : iVar.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zI && alphabeticShortcut == '\b' && i3 == 67)) && iVar.isEnabled()) {
                        list.add(iVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i3, boolean z3, boolean z4) {
        int size = this.f2842f.size();
        for (int i4 = 0; i4 < size; i4++) {
            i iVar = (i) this.f2842f.get(i4);
            if (iVar.getGroupId() == i3) {
                iVar.t(z4);
                iVar.setCheckable(z3);
            }
        }
    }

    @Override // p073w.a, android.view.Menu
    public void setGroupDividerEnabled(boolean z3) {
        this.f2861y = z3;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i3, boolean z3) {
        int size = this.f2842f.size();
        for (int i4 = 0; i4 < size; i4++) {
            i iVar = (i) this.f2842f.get(i4);
            if (iVar.getGroupId() == i3) {
                iVar.setEnabled(z3);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i3, boolean z3) {
        int size = this.f2842f.size();
        boolean z4 = false;
        for (int i4 = 0; i4 < size; i4++) {
            i iVar = (i) this.f2842f.get(i4);
            if (iVar.getGroupId() == i3 && iVar.y(z3)) {
                z4 = true;
            }
        }
        if (z4) {
            M(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z3) {
        this.f2839c = z3;
        M(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f2842f.size();
    }

    public void t() {
        ArrayList arrayListG = G();
        if (this.f2847k) {
            boolean zD = false;
            for (WeakReference weakReference : this.f2859w) {
                m mVar = (m) weakReference.get();
                if (mVar == null) {
                    this.f2859w.remove(weakReference);
                } else {
                    zD |= mVar.d();
                }
            }
            if (zD) {
                this.f2845i.clear();
                this.f2846j.clear();
                int size = arrayListG.size();
                for (int i3 = 0; i3 < size; i3++) {
                    i iVar = (i) arrayListG.get(i3);
                    if (iVar.l()) {
                        this.f2845i.add(iVar);
                    } else {
                        this.f2846j.add(iVar);
                    }
                }
            } else {
                this.f2845i.clear();
                this.f2846j.clear();
                this.f2846j.addAll(G());
            }
            this.f2847k = false;
        }
    }

    public ArrayList u() {
        t();
        return this.f2845i;
    }

    protected String v() {
        return "android:menu:actionviewstates";
    }

    public Context w() {
        return this.f2837a;
    }

    public i x() {
        return this.f2860x;
    }

    public Drawable y() {
        return this.f2851o;
    }

    public CharSequence z() {
        return this.f2850n;
    }

    @Override // android.view.Menu
    public MenuItem add(int i3) {
        return a(0, 0, 0, this.f2838b.getString(i3));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3) {
        return addSubMenu(0, 0, 0, this.f2838b.getString(i3));
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i4, int i5, CharSequence charSequence) {
        return a(i3, i4, i5, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i4, int i5, CharSequence charSequence) {
        i iVar = (i) a(i3, i4, i5, charSequence);
        r rVar = new r(this.f2837a, this, iVar);
        iVar.x(rVar);
        return rVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i4, int i5, int i6) {
        return a(i3, i4, i5, this.f2838b.getString(i6));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i4, int i5, int i6) {
        return addSubMenu(i3, i4, i5, this.f2838b.getString(i6));
    }
}
