package V1;

import S1.g;

/* JADX INFO: loaded from: classes.dex */
public final class c extends V1.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f2073e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final c f2074f = new c(1, 0);

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    public c(int i3, int i4) {
        super(i3, i4, 1);
    }

    @Override // V1.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (j() != cVar.j() || k() != cVar.k()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // V1.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (j() * 31) + k();
    }

    @Override // V1.a
    public boolean isEmpty() {
        return j() > k();
    }

    @Override // V1.a
    public String toString() {
        return j() + ".." + k();
    }
}
