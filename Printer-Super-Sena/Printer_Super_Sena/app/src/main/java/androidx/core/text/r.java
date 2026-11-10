package androidx.core.text;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f4567a = new e(null, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f4568b = new e(null, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f4569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q f4570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final q f4571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q f4572f;

    private static class a implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final a f4573b = new a(true);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f4574a;

        private a(boolean z3) {
            this.f4574a = z3;
        }

        @Override // androidx.core.text.r.c
        public int a(CharSequence charSequence, int i3, int i4) {
            int i5 = i4 + i3;
            boolean z3 = false;
            while (i3 < i5) {
                int iA = r.a(Character.getDirectionality(charSequence.charAt(i3)));
                if (iA != 0) {
                    if (iA != 1) {
                        continue;
                    } else if (!this.f4574a) {
                        return 1;
                    }
                    i3++;
                } else if (this.f4574a) {
                    return 0;
                }
                z3 = true;
                i3++;
            }
            if (z3) {
                return this.f4574a ? 1 : 0;
            }
            return 2;
        }
    }

    private static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f4575a = new b();

        private b() {
        }

        @Override // androidx.core.text.r.c
        public int a(CharSequence charSequence, int i3, int i4) {
            int i5 = i4 + i3;
            int iB = 2;
            while (i3 < i5 && iB == 2) {
                iB = r.b(Character.getDirectionality(charSequence.charAt(i3)));
                i3++;
            }
            return iB;
        }
    }

    private interface c {
        int a(CharSequence charSequence, int i3, int i4);
    }

    private static abstract class d implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f4576a;

        d(c cVar) {
            this.f4576a = cVar;
        }

        private boolean c(CharSequence charSequence, int i3, int i4) {
            int iA = this.f4576a.a(charSequence, i3, i4);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return b();
            }
            return false;
        }

        @Override // androidx.core.text.q
        public boolean a(CharSequence charSequence, int i3, int i4) {
            if (charSequence == null || i3 < 0 || i4 < 0 || charSequence.length() - i4 < i3) {
                throw new IllegalArgumentException();
            }
            return this.f4576a == null ? b() : c(charSequence, i3, i4);
        }

        protected abstract boolean b();
    }

    private static class e extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f4577b;

        e(c cVar, boolean z3) {
            super(cVar);
            this.f4577b = z3;
        }

        @Override // androidx.core.text.r.d
        protected boolean b() {
            return this.f4577b;
        }
    }

    private static class f extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final f f4578b = new f();

        f() {
            super(null);
        }

        @Override // androidx.core.text.r.d
        protected boolean b() {
            return s.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f4575a;
        f4569c = new e(bVar, false);
        f4570d = new e(bVar, true);
        f4571e = new e(a.f4573b, false);
        f4572f = f.f4578b;
    }

    static int a(int i3) {
        if (i3 != 0) {
            return (i3 == 1 || i3 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i3) {
        if (i3 != 0) {
            if (i3 == 1 || i3 == 2) {
                return 0;
            }
            switch (i3) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
