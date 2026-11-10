package F0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: F0.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0219m {

    /* JADX INFO: renamed from: F0.m$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f984b;

        /* synthetic */ a(Object obj, O o3) {
            AbstractC0220n.f(obj);
            this.f984b = obj;
            this.f983a = new ArrayList();
        }

        public a a(String str, Object obj) {
            AbstractC0220n.f(str);
            this.f983a.add(str + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f984b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f983a.size();
            for (int i3 = 0; i3 < size; i3++) {
                sb.append((String) this.f983a.get(i3));
                if (i3 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj, null);
    }
}
