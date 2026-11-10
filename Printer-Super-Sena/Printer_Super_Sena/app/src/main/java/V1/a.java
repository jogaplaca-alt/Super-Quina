package V1;

import K1.C;
import S1.g;

/* JADX INFO: loaded from: classes.dex */
public class a implements Iterable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0028a f2065d = new C0028a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2068c;

    /* JADX INFO: renamed from: V1.a$a, reason: collision with other inner class name */
    public static final class C0028a {
        public /* synthetic */ C0028a(g gVar) {
            this();
        }

        public final a a(int i3, int i4, int i5) {
            return new a(i3, i4, i5);
        }

        private C0028a() {
        }
    }

    public a(int i3, int i4, int i5) {
        if (i5 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i5 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f2066a = i3;
        this.f2067b = M1.c.b(i3, i4, i5);
        this.f2068c = i5;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f2066a != aVar.f2066a || this.f2067b != aVar.f2067b || this.f2068c != aVar.f2068c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f2066a * 31) + this.f2067b) * 31) + this.f2068c;
    }

    public boolean isEmpty() {
        if (this.f2068c > 0) {
            if (this.f2066a <= this.f2067b) {
                return false;
            }
        } else if (this.f2066a >= this.f2067b) {
            return false;
        }
        return true;
    }

    public final int j() {
        return this.f2066a;
    }

    public final int k() {
        return this.f2067b;
    }

    public final int l() {
        return this.f2068c;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public C iterator() {
        return new b(this.f2066a, this.f2067b, this.f2068c);
    }

    public String toString() {
        StringBuilder sb;
        int i3;
        if (this.f2068c > 0) {
            sb = new StringBuilder();
            sb.append(this.f2066a);
            sb.append("..");
            sb.append(this.f2067b);
            sb.append(" step ");
            i3 = this.f2068c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f2066a);
            sb.append(" downTo ");
            sb.append(this.f2067b);
            sb.append(" step ");
            i3 = -this.f2068c;
        }
        sb.append(i3);
        return sb.toString();
    }
}
