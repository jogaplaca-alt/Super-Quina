package p081y1;

import androidx.appcompat.app.H;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import p075w1.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    private static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12887a;

        class a extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Method f12888b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Method method) {
                super();
                this.f12888b = method;
            }

            @Override // y1.l.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f12888b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e3) {
                    throw new RuntimeException("Failed invoking canAccess", e3);
                }
            }
        }

        /* JADX INFO: renamed from: y1.l$b$b, reason: collision with other inner class name */
        class C0152b extends b {
            C0152b() {
                super();
            }

            @Override // y1.l.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        static {
            b aVar;
            if (e.d()) {
                try {
                    aVar = new a(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
                } catch (NoSuchMethodException unused) {
                    aVar = null;
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                aVar = new C0152b();
            }
            f12887a = aVar;
        }

        private b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return b.f12887a.a(accessibleObject, obj);
    }

    public static r b(List list, Class cls) {
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return r.ALLOW;
        }
        H.a(it.next());
        throw null;
    }
}
