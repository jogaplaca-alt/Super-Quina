package com.google.android.gms.common.api.internal;

import androidx.appcompat.app.H;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f7254a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f7255b = Collections.synchronizedMap(new WeakHashMap());

    private final void f(boolean z3, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.f7254a) {
            map = new HashMap(this.f7254a);
        }
        synchronized (this.f7255b) {
            map2 = new HashMap(this.f7255b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z3 || ((Boolean) entry.getValue()).booleanValue()) {
                H.a(entry.getKey());
                throw null;
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z3 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((R0.e) entry2.getKey()).c(new D0.b(status));
            }
        }
    }

    final void b(R0.e eVar, boolean z3) {
        this.f7255b.put(eVar, Boolean.valueOf(z3));
        eVar.a().a(new d(this, eVar));
    }

    final void c(int i3, String str) {
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i3 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i3 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        f(true, new Status(20, sb.toString()));
    }

    public final void d() {
        f(false, b.f7226p);
    }

    final boolean e() {
        return (this.f7254a.isEmpty() && this.f7255b.isEmpty()) ? false : true;
    }
}
