package p004b;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.InterfaceC0356n;
import androidx.lifecycle.InterfaceC0358p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f6900a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map f6901b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f6902c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList f6903d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final transient Map f6904e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Map f6905f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Bundle f6906g = new Bundle();

    class a implements InterfaceC0356n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ p004b.b f6908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ p008c.a f6909c;

        a(String str, p004b.b bVar, p008c.a aVar) {
            this.f6907a = str;
            this.f6908b = bVar;
            this.f6909c = aVar;
        }

        @Override // androidx.lifecycle.InterfaceC0356n
        public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
            if (!AbstractC0354l.a.ON_START.equals(aVar)) {
                if (AbstractC0354l.a.ON_STOP.equals(aVar)) {
                    d.this.f6904e.remove(this.f6907a);
                    return;
                } else {
                    if (AbstractC0354l.a.ON_DESTROY.equals(aVar)) {
                        d.this.l(this.f6907a);
                        return;
                    }
                    return;
                }
            }
            d.this.f6904e.put(this.f6907a, new C0098d(this.f6908b, this.f6909c));
            if (d.this.f6905f.containsKey(this.f6907a)) {
                Object obj = d.this.f6905f.get(this.f6907a);
                d.this.f6905f.remove(this.f6907a);
                this.f6908b.onActivityResult(obj);
            }
            p004b.a aVar2 = (p004b.a) d.this.f6906g.getParcelable(this.f6907a);
            if (aVar2 != null) {
                d.this.f6906g.remove(this.f6907a);
                this.f6908b.onActivityResult(this.f6909c.c(aVar2.d(), aVar2.c()));
            }
        }
    }

    class b extends p004b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ p008c.a f6912b;

        b(String str, p008c.a aVar) {
            this.f6911a = str;
            this.f6912b = aVar;
        }

        @Override // p004b.c
        public void b(Object obj, androidx.core.app.c cVar) throws Exception {
            Integer num = (Integer) d.this.f6901b.get(this.f6911a);
            if (num != null) {
                d.this.f6903d.add(this.f6911a);
                try {
                    d.this.f(num.intValue(), this.f6912b, obj, cVar);
                    return;
                } catch (Exception e3) {
                    d.this.f6903d.remove(this.f6911a);
                    throw e3;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f6912b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // p004b.c
        public void c() {
            d.this.l(this.f6911a);
        }
    }

    class c extends p004b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ p008c.a f6915b;

        c(String str, p008c.a aVar) {
            this.f6914a = str;
            this.f6915b = aVar;
        }

        @Override // p004b.c
        public void b(Object obj, androidx.core.app.c cVar) throws Exception {
            Integer num = (Integer) d.this.f6901b.get(this.f6914a);
            if (num != null) {
                d.this.f6903d.add(this.f6914a);
                try {
                    d.this.f(num.intValue(), this.f6915b, obj, cVar);
                    return;
                } catch (Exception e3) {
                    d.this.f6903d.remove(this.f6914a);
                    throw e3;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f6915b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // p004b.c
        public void c() {
            d.this.l(this.f6914a);
        }
    }

    /* JADX INFO: renamed from: b.d$d, reason: collision with other inner class name */
    private static class C0098d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final p004b.b f6917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final p008c.a f6918b;

        C0098d(p004b.b bVar, p008c.a aVar) {
            this.f6917a = bVar;
            this.f6918b = aVar;
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AbstractC0354l f6919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList f6920b = new ArrayList();

        e(AbstractC0354l abstractC0354l) {
            this.f6919a = abstractC0354l;
        }

        void a(InterfaceC0356n interfaceC0356n) {
            this.f6919a.a(interfaceC0356n);
            this.f6920b.add(interfaceC0356n);
        }

        void b() {
            Iterator it = this.f6920b.iterator();
            while (it.hasNext()) {
                this.f6919a.c((InterfaceC0356n) it.next());
            }
            this.f6920b.clear();
        }
    }

    private void a(int i3, String str) {
        this.f6900a.put(Integer.valueOf(i3), str);
        this.f6901b.put(str, Integer.valueOf(i3));
    }

    private void d(String str, int i3, Intent intent, C0098d c0098d) {
        if (c0098d == null || c0098d.f6917a == null || !this.f6903d.contains(str)) {
            this.f6905f.remove(str);
            this.f6906g.putParcelable(str, new p004b.a(i3, intent));
        } else {
            c0098d.f6917a.onActivityResult(c0098d.f6918b.c(i3, intent));
            this.f6903d.remove(str);
        }
    }

    private int e() {
        int iB = T1.c.f1969a.b(2147418112);
        while (true) {
            int i3 = iB + 65536;
            if (!this.f6900a.containsKey(Integer.valueOf(i3))) {
                return i3;
            }
            iB = T1.c.f1969a.b(2147418112);
        }
    }

    private void k(String str) {
        if (((Integer) this.f6901b.get(str)) != null) {
            return;
        }
        a(e(), str);
    }

    public final boolean b(int i3, int i4, Intent intent) {
        String str = (String) this.f6900a.get(Integer.valueOf(i3));
        if (str == null) {
            return false;
        }
        d(str, i4, intent, (C0098d) this.f6904e.get(str));
        return true;
    }

    public final boolean c(int i3, Object obj) {
        p004b.b bVar;
        String str = (String) this.f6900a.get(Integer.valueOf(i3));
        if (str == null) {
            return false;
        }
        C0098d c0098d = (C0098d) this.f6904e.get(str);
        if (c0098d == null || (bVar = c0098d.f6917a) == null) {
            this.f6906g.remove(str);
            this.f6905f.put(str, obj);
            return true;
        }
        if (!this.f6903d.remove(str)) {
            return true;
        }
        bVar.onActivityResult(obj);
        return true;
    }

    public abstract void f(int i3, p008c.a aVar, Object obj, androidx.core.app.c cVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f6903d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f6906g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
            String str = stringArrayList.get(i3);
            if (this.f6901b.containsKey(str)) {
                Integer num = (Integer) this.f6901b.remove(str);
                if (!this.f6906g.containsKey(str)) {
                    this.f6900a.remove(num);
                }
            }
            a(integerArrayList.get(i3).intValue(), stringArrayList.get(i3));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f6901b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f6901b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f6903d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f6906g.clone());
    }

    public final p004b.c i(String str, InterfaceC0358p interfaceC0358p, p008c.a aVar, p004b.b bVar) {
        AbstractC0354l lifecycle = interfaceC0358p.getLifecycle();
        if (lifecycle.b().b(AbstractC0354l.b.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + interfaceC0358p + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        k(str);
        e eVar = (e) this.f6902c.get(str);
        if (eVar == null) {
            eVar = new e(lifecycle);
        }
        eVar.a(new a(str, bVar, aVar));
        this.f6902c.put(str, eVar);
        return new b(str, aVar);
    }

    public final p004b.c j(String str, p008c.a aVar, p004b.b bVar) {
        k(str);
        this.f6904e.put(str, new C0098d(bVar, aVar));
        if (this.f6905f.containsKey(str)) {
            Object obj = this.f6905f.get(str);
            this.f6905f.remove(str);
            bVar.onActivityResult(obj);
        }
        p004b.a aVar2 = (p004b.a) this.f6906g.getParcelable(str);
        if (aVar2 != null) {
            this.f6906g.remove(str);
            bVar.onActivityResult(aVar.c(aVar2.d(), aVar2.c()));
        }
        return new c(str, aVar);
    }

    final void l(String str) {
        Integer num;
        if (!this.f6903d.contains(str) && (num = (Integer) this.f6901b.remove(str)) != null) {
            this.f6900a.remove(num);
        }
        this.f6904e.remove(str);
        if (this.f6905f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f6905f.get(str));
            this.f6905f.remove(str);
        }
        if (this.f6906g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f6906g.getParcelable(str));
            this.f6906g.remove(str);
        }
        e eVar = (e) this.f6902c.get(str);
        if (eVar != null) {
            eVar.b();
            this.f6902c.remove(str);
        }
    }
}
