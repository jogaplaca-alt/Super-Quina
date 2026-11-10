package androidx.databinding;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.InterfaceC0358p;
import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends androidx.databinding.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f4835m = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f4844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private androidx.databinding.i[] f4847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final View f4848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Choreographer f4850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Choreographer.FrameCallback f4851h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f4852i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h f4853j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private InterfaceC0358p f4854k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static int f4834l = Build.VERSION.SDK_INT;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final boolean f4836n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final androidx.databinding.c f4837o = new a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final androidx.databinding.c f4838p = new b();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final androidx.databinding.c f4839q = new c();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final androidx.databinding.c f4840r = new d();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final androidx.databinding.b f4841s = new e();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final ReferenceQueue f4842t = new ReferenceQueue();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final View.OnAttachStateChangeListener f4843u = new f();

    class a implements androidx.databinding.c {
        a() {
        }
    }

    class b implements androidx.databinding.c {
        b() {
        }
    }

    class c implements androidx.databinding.c {
        c() {
        }
    }

    class d implements androidx.databinding.c {
        d() {
        }
    }

    class e extends androidx.databinding.b {
        e() {
        }
    }

    class f implements View.OnAttachStateChangeListener {
        f() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            h.o(view).f4844a.run();
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                h.this.f4845b = false;
            }
            h.w();
            if (h.this.f4848e.isAttachedToWindow()) {
                h.this.l();
            } else {
                h.this.f4848e.removeOnAttachStateChangeListener(h.f4843u);
                h.this.f4848e.addOnAttachStateChangeListener(h.f4843u);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.databinding.h$h, reason: collision with other inner class name */
    class ChoreographerFrameCallbackC0066h implements Choreographer.FrameCallback {
        ChoreographerFrameCallbackC0066h() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            h.this.f4844a.run();
        }
    }

    protected static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[][] f4857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[][] f4858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[][] f4859c;

        public i(int i3) {
            this.f4857a = new String[i3][];
            this.f4858b = new int[i3][];
            this.f4859c = new int[i3][];
        }

        public void a(int i3, String[] strArr, int[] iArr, int[] iArr2) {
            this.f4857a[i3] = strArr;
            this.f4858b[i3] = iArr;
            this.f4859c[i3] = iArr2;
        }
    }

    protected h(androidx.databinding.e eVar, View view, int i3) {
        this.f4844a = new g();
        this.f4845b = false;
        this.f4846c = false;
        this.f4847d = new androidx.databinding.i[i3];
        this.f4848e = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        }
        if (f4836n) {
            this.f4850g = Choreographer.getInstance();
            this.f4851h = new ChoreographerFrameCallbackC0066h();
        } else {
            this.f4851h = null;
            this.f4852i = new Handler(Looper.myLooper());
        }
    }

    private static androidx.databinding.e h(Object obj) {
        if (obj == null) {
            return null;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    private void j() {
        if (this.f4849f) {
            x();
        } else if (q()) {
            this.f4849f = true;
            this.f4846c = false;
            i();
            this.f4849f = false;
        }
    }

    protected static void k(h hVar) {
        hVar.j();
    }

    private static int m(String str, int i3, i iVar, int i4) {
        CharSequence charSequenceSubSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = iVar.f4857a[i4];
        int length = strArr.length;
        while (i3 < length) {
            if (TextUtils.equals(charSequenceSubSequence, strArr[i3])) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    private static int n(ViewGroup viewGroup, int i3) {
        String str = (String) viewGroup.getChildAt(i3).getTag();
        String strSubstring = str.substring(0, str.length() - 1);
        int length = strSubstring.length();
        int childCount = viewGroup.getChildCount();
        for (int i4 = i3 + 1; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            String str2 = childAt.getTag() instanceof String ? (String) childAt.getTag() : null;
            if (str2 != null && str2.startsWith(strSubstring)) {
                if (str2.length() == str.length() && str2.charAt(str2.length() - 1) == '0') {
                    return i3;
                }
                if (s(str2, length)) {
                    i3 = i4;
                }
            }
        }
        return i3;
    }

    static h o(View view) {
        if (view != null) {
            return (h) view.getTag(I.a.f1175a);
        }
        return null;
    }

    private static boolean s(String str, int i3) {
        int length = str.length();
        if (length == i3) {
            return false;
        }
        while (i3 < length) {
            if (!Character.isDigit(str.charAt(i3))) {
                return false;
            }
            i3++;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:69:0x0100  */
    private static void t(androidx.databinding.e eVar, View view, Object[] objArr, i iVar, SparseIntArray sparseIntArray, boolean z3) {
        boolean z4;
        int i3;
        int i4;
        int i5;
        boolean z5;
        int iM;
        int id;
        int i6;
        int iV;
        if (o(view) != null) {
            return;
        }
        Object tag = view.getTag();
        String str = tag instanceof String ? (String) tag : null;
        if (z3 && str != null && str.startsWith("layout")) {
            int iLastIndexOf = str.lastIndexOf(95);
            if (iLastIndexOf > 0) {
                int i7 = iLastIndexOf + 1;
                if (s(str, i7)) {
                    iV = v(str, i7);
                    if (objArr[iV] == null) {
                        objArr[iV] = view;
                    }
                    if (iVar == null) {
                        iV = -1;
                    }
                    z4 = true;
                } else {
                    iV = -1;
                    z4 = false;
                }
            } else {
                iV = -1;
                z4 = false;
            }
            i3 = iV;
        } else if (str == null || !str.startsWith("binding_")) {
            z4 = false;
            i3 = -1;
        } else {
            int iV2 = v(str, f4835m);
            if (objArr[iV2] == null) {
                objArr[iV2] = view;
            }
            if (iVar == null) {
                iV2 = -1;
            }
            i3 = iV2;
            z4 = true;
        }
        if (!z4 && (id = view.getId()) > 0 && sparseIntArray != null && (i6 = sparseIntArray.get(id, -1)) >= 0 && objArr[i6] == null) {
            objArr[i6] = view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            int i8 = 0;
            int i9 = 0;
            while (i8 < childCount) {
                View childAt = viewGroup.getChildAt(i8);
                if (i3 < 0 || !(childAt.getTag() instanceof String)) {
                    i4 = i8;
                    i5 = i9;
                    z5 = false;
                } else {
                    String str2 = (String) childAt.getTag();
                    if (!str2.endsWith("_0") || !str2.startsWith("layout") || str2.indexOf(47) <= 0 || (iM = m(str2, i9, iVar, i3)) < 0) {
                        i4 = i8;
                        i5 = i9;
                        z5 = false;
                    } else {
                        int i10 = iM + 1;
                        int i11 = iVar.f4858b[i3][iM];
                        int i12 = iVar.f4859c[i3][iM];
                        int iN = n(viewGroup, i8);
                        if (iN == i8) {
                            objArr[i11] = androidx.databinding.f.a(eVar, childAt, i12);
                            i4 = i8;
                            i5 = i10;
                        } else {
                            int i13 = iN - i8;
                            int i14 = i13 + 1;
                            View[] viewArr = new View[i14];
                            int i15 = 0;
                            while (i15 < i14) {
                                viewArr[i15] = viewGroup.getChildAt(i8 + i15);
                                i15++;
                                i10 = i10;
                            }
                            objArr[i11] = androidx.databinding.f.b(eVar, viewArr, i12);
                            i5 = i10;
                            i4 = i8 + i13;
                        }
                        z5 = true;
                    }
                }
                if (!z5) {
                    t(eVar, childAt, objArr, iVar, sparseIntArray, false);
                }
                i8 = i4 + 1;
                i9 = i5;
            }
        }
    }

    protected static Object[] u(androidx.databinding.e eVar, View view, int i3, i iVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i3];
        t(eVar, view, objArr, iVar, sparseIntArray, true);
        return objArr;
    }

    private static int v(String str, int i3) {
        int length = str.length();
        int iCharAt = 0;
        while (i3 < length) {
            iCharAt = (iCharAt * 10) + (str.charAt(i3) - '0');
            i3++;
        }
        return iCharAt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w() {
        while (f4842t.poll() != null) {
        }
    }

    protected abstract void i();

    public void l() {
        h hVar = this.f4853j;
        if (hVar == null) {
            j();
        } else {
            hVar.l();
        }
    }

    public View p() {
        return this.f4848e;
    }

    public abstract boolean q();

    public abstract void r();

    protected void x() {
        h hVar = this.f4853j;
        if (hVar != null) {
            hVar.x();
            return;
        }
        InterfaceC0358p interfaceC0358p = this.f4854k;
        if (interfaceC0358p == null || interfaceC0358p.getLifecycle().b().b(AbstractC0354l.b.STARTED)) {
            synchronized (this) {
                try {
                    if (this.f4845b) {
                        return;
                    }
                    this.f4845b = true;
                    if (f4836n) {
                        this.f4850g.postFrameCallback(this.f4851h);
                    } else {
                        this.f4852i.post(this.f4844a);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    protected void y(h hVar) {
        if (hVar != null) {
            hVar.f4853j = this;
        }
    }

    protected void z(View view) {
        view.setTag(I.a.f1175a, this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    protected h(Object obj, View view, int i3) {
        this((androidx.databinding.e) null, view, i3);
        h(obj);
    }
}
