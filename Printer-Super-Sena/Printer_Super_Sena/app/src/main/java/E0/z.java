package E0;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class z extends Fragment implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final WeakHashMap f244d = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f245a = Collections.synchronizedMap(new p046n.a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f246b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f247c;

    public static z f(Activity activity) {
        z zVar;
        WeakHashMap weakHashMap = f244d;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (zVar = (z) weakReference.get()) != null) {
            return zVar;
        }
        try {
            z zVar2 = (z) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (zVar2 == null || zVar2.isRemoving()) {
                zVar2 = new z();
                activity.getFragmentManager().beginTransaction().add(zVar2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(zVar2));
            return zVar2;
        } catch (ClassCastException e3) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e3);
        }
    }

    @Override // E0.e
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f245a.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f245a.put(str, lifecycleCallback);
        if (this.f246b > 0) {
            new N0.e(Looper.getMainLooper()).post(new y(this, lifecycleCallback, str));
        }
    }

    @Override // E0.e
    public final LifecycleCallback c(String str, Class cls) {
        return (LifecycleCallback) cls.cast(this.f245a.get(str));
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.f245a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // E0.e
    public final Activity e() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        Iterator it = this.f245a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).e(i3, i4, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f246b = 1;
        this.f247c = bundle;
        for (Map.Entry entry : this.f245a.entrySet()) {
            ((LifecycleCallback) entry.getValue()).f(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f246b = 5;
        Iterator it = this.f245a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).g();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f246b = 3;
        Iterator it = this.f245a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).h();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f245a.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).i(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f246b = 2;
        Iterator it = this.f245a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).j();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f246b = 4;
        Iterator it = this.f245a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).k();
        }
    }
}
