package com.google.android.gms.internal.play_billing;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.x0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0478x0 {
    static C0460r0 a(Class cls) {
        String str;
        ClassLoader classLoader = AbstractC0478x0.class.getClassLoader();
        if (cls.equals(C0460r0.class)) {
            str = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else {
            if (!cls.getPackage().equals(AbstractC0478x0.class.getPackage())) {
                throw new IllegalArgumentException(cls.getName());
            }
            str = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        }
        try {
            try {
                try {
                    try {
                        androidx.appcompat.app.H.a(Class.forName(str, true, classLoader).getConstructor(null).newInstance(null));
                        throw null;
                    } catch (InstantiationException e3) {
                        throw new IllegalStateException(e3);
                    }
                } catch (IllegalAccessException e4) {
                    throw new IllegalStateException(e4);
                }
            } catch (NoSuchMethodException e5) {
                throw new IllegalStateException(e5);
            } catch (InvocationTargetException e6) {
                throw new IllegalStateException(e6);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(AbstractC0478x0.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    androidx.appcompat.app.H.a(it.next());
                    throw null;
                } catch (ServiceConfigurationError e7) {
                    Logger.getLogger(AbstractC0449n0.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(cls.getSimpleName()), (Throwable) e7);
                }
            }
            if (arrayList.size() == 1) {
                return (C0460r0) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (C0460r0) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e8) {
                throw new IllegalStateException(e8);
            } catch (NoSuchMethodException e9) {
                throw new IllegalStateException(e9);
            } catch (InvocationTargetException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }
}
