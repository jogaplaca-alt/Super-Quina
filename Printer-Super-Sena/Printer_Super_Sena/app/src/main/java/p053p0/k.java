package p053p0;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f10484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f10485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f10486c;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f10487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map f10488b = null;

        a(Context context) {
            this.f10487a = context;
        }

        private Map a(Context context) {
            Bundle bundleD = d(context);
            if (bundleD == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap map = new HashMap();
            for (String str : bundleD.keySet()) {
                Object obj = bundleD.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String strTrim = str2.trim();
                        if (!strTrim.isEmpty()) {
                            map.put(strTrim, str.substring(8));
                        }
                    }
                }
            }
            return map;
        }

        private Map c() {
            if (this.f10488b == null) {
                this.f10488b = a(this.f10487a);
            }
            return this.f10488b;
        }

        private static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        d b(String str) {
            String str2 = (String) c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (d) Class.forName(str2).asSubclass(d.class).getDeclaredConstructor(null).newInstance(null);
            } catch (ClassNotFoundException e3) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str2), e3);
                return null;
            } catch (IllegalAccessException e4) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e4);
                return null;
            } catch (InstantiationException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e5);
                return null;
            } catch (NoSuchMethodException e6) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e6);
                return null;
            } catch (InvocationTargetException e7) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e7);
                return null;
            }
        }
    }

    k(Context context, i iVar) {
        this(new a(context), iVar);
    }

    @Override // p053p0.e
    public synchronized m a(String str) {
        if (this.f10486c.containsKey(str)) {
            return (m) this.f10486c.get(str);
        }
        d dVarB = this.f10484a.b(str);
        if (dVarB == null) {
            return null;
        }
        m mVarCreate = dVarB.create(this.f10485b.a(str));
        this.f10486c.put(str, mVarCreate);
        return mVarCreate;
    }

    k(a aVar, i iVar) {
        this.f10486c = new HashMap();
        this.f10484a = aVar;
        this.f10485b = iVar;
    }
}
