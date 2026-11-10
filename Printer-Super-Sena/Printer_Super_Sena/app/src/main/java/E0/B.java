package E0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.AbstractActivityC0338f;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class B extends AbstractComponentCallbacksC0337e implements e {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final WeakHashMap f213e0 = new WeakHashMap();

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final Map f214b0 = Collections.synchronizedMap(new p046n.a());

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private int f215c0 = 0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private Bundle f216d0;

    public static B S1(AbstractActivityC0338f abstractActivityC0338f) {
        B b3;
        WeakHashMap weakHashMap = f213e0;
        WeakReference weakReference = (WeakReference) weakHashMap.get(abstractActivityC0338f);
        if (weakReference != null && (b3 = (B) weakReference.get()) != null) {
            return b3;
        }
        try {
            B b4 = (B) abstractActivityC0338f.getSupportFragmentManager().e0("SupportLifecycleFragmentImpl");
            if (b4 == null || b4.f0()) {
                b4 = new B();
                abstractActivityC0338f.getSupportFragmentManager().j().d(b4, "SupportLifecycleFragmentImpl").g();
            }
            weakHashMap.put(abstractActivityC0338f, new WeakReference(b4));
            return b4;
        } catch (ClassCastException e3) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e3);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public final void K0() {
        super.K0();
        this.f215c0 = 3;
        Iterator it = this.f214b0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).h();
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public final void L0(Bundle bundle) {
        super.L0(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f214b0.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).i(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public final void M0() {
        super.M0();
        this.f215c0 = 2;
        Iterator it = this.f214b0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).j();
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public final void N0() {
        super.N0();
        this.f215c0 = 4;
        Iterator it = this.f214b0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).k();
        }
    }

    @Override // E0.e
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f214b0.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f214b0.put(str, lifecycleCallback);
        if (this.f215c0 > 0) {
            new N0.e(Looper.getMainLooper()).post(new A(this, lifecycleCallback, str));
        }
    }

    @Override // E0.e
    public final LifecycleCallback c(String str, Class cls) {
        return (LifecycleCallback) cls.cast(this.f214b0.get(str));
    }

    @Override // E0.e
    public final /* synthetic */ Activity e() {
        return m();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public final void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.i(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.f214b0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public final void k0(int i3, int i4, Intent intent) {
        super.k0(i3, i4, intent);
        Iterator it = this.f214b0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).e(i3, i4, intent);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public final void p0(Bundle bundle) {
        super.p0(bundle);
        this.f215c0 = 1;
        this.f216d0 = bundle;
        for (Map.Entry entry : this.f214b0.entrySet()) {
            ((LifecycleCallback) entry.getValue()).f(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public final void u0() {
        super.u0();
        this.f215c0 = 5;
        Iterator it = this.f214b0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).g();
        }
    }
}
