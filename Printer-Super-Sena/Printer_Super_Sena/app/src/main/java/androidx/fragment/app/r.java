package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.O;
import androidx.lifecycle.P;
import androidx.lifecycle.Q;
import androidx.lifecycle.T;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class r extends O {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final P.b f5357k = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f5361g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap f5358d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap f5359e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap f5360f = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f5362h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f5363i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f5364j = false;

    class a implements P.b {
        a() {
        }

        @Override // androidx.lifecycle.P.b
        public O a(Class cls) {
            return new r(true);
        }

        @Override // androidx.lifecycle.P.b
        public /* synthetic */ O b(Class cls, T.a aVar) {
            return Q.b(this, cls, aVar);
        }
    }

    r(boolean z3) {
        this.f5361g = z3;
    }

    static r j(T t3) {
        return (r) new P(t3, f5357k).a(r.class);
    }

    @Override // androidx.lifecycle.O
    protected void d() {
        if (o.C0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f5362h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        return this.f5358d.equals(rVar.f5358d) && this.f5359e.equals(rVar.f5359e) && this.f5360f.equals(rVar.f5360f);
    }

    void f(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (this.f5364j) {
            if (o.C0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f5358d.containsKey(abstractComponentCallbacksC0337e.f5189f)) {
                return;
            }
            this.f5358d.put(abstractComponentCallbacksC0337e.f5189f, abstractComponentCallbacksC0337e);
            if (o.C0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + abstractComponentCallbacksC0337e);
            }
        }
    }

    void g(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (o.C0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + abstractComponentCallbacksC0337e);
        }
        r rVar = (r) this.f5359e.get(abstractComponentCallbacksC0337e.f5189f);
        if (rVar != null) {
            rVar.d();
            this.f5359e.remove(abstractComponentCallbacksC0337e.f5189f);
        }
        T t3 = (T) this.f5360f.get(abstractComponentCallbacksC0337e.f5189f);
        if (t3 != null) {
            t3.a();
            this.f5360f.remove(abstractComponentCallbacksC0337e.f5189f);
        }
    }

    AbstractComponentCallbacksC0337e h(String str) {
        return (AbstractComponentCallbacksC0337e) this.f5358d.get(str);
    }

    public int hashCode() {
        return (((this.f5358d.hashCode() * 31) + this.f5359e.hashCode()) * 31) + this.f5360f.hashCode();
    }

    r i(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        r rVar = (r) this.f5359e.get(abstractComponentCallbacksC0337e.f5189f);
        if (rVar != null) {
            return rVar;
        }
        r rVar2 = new r(this.f5361g);
        this.f5359e.put(abstractComponentCallbacksC0337e.f5189f, rVar2);
        return rVar2;
    }

    Collection k() {
        return new ArrayList(this.f5358d.values());
    }

    T l(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        T t3 = (T) this.f5360f.get(abstractComponentCallbacksC0337e.f5189f);
        if (t3 != null) {
            return t3;
        }
        T t4 = new T();
        this.f5360f.put(abstractComponentCallbacksC0337e.f5189f, t4);
        return t4;
    }

    boolean m() {
        return this.f5362h;
    }

    void n(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (this.f5364j) {
            if (o.C0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f5358d.remove(abstractComponentCallbacksC0337e.f5189f) == null || !o.C0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + abstractComponentCallbacksC0337e);
        }
    }

    void o(boolean z3) {
        this.f5364j = z3;
    }

    boolean p(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (this.f5358d.containsKey(abstractComponentCallbacksC0337e.f5189f)) {
            return this.f5361g ? this.f5362h : !this.f5363i;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f5358d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f5359e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f5360f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
