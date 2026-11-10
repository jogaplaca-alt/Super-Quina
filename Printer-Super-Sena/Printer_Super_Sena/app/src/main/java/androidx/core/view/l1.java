package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: loaded from: classes.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f4654a;

    private static class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Window f4655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final O f4656b;

        a(Window window, O o3) {
            this.f4655a = window;
            this.f4656b = o3;
        }

        private void f(int i3) {
            if (i3 == 1) {
                g(4);
                h(1024);
            } else if (i3 == 2) {
                g(2);
            } else {
                if (i3 != 8) {
                    return;
                }
                this.f4656b.a();
            }
        }

        @Override // androidx.core.view.l1.e
        void c(int i3) {
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i3 & i4) != 0) {
                    f(i4);
                }
            }
        }

        protected void d(int i3) {
            View decorView = this.f4655a.getDecorView();
            decorView.setSystemUiVisibility(i3 | decorView.getSystemUiVisibility());
        }

        protected void e(int i3) {
            this.f4655a.addFlags(i3);
        }

        protected void g(int i3) {
            View decorView = this.f4655a.getDecorView();
            decorView.setSystemUiVisibility((i3 ^ (-1)) & decorView.getSystemUiVisibility());
        }

        protected void h(int i3) {
            this.f4655a.clearFlags(i3);
        }
    }

    private static class b extends a {
        b(Window window, O o3) {
            super(window, o3);
        }

        @Override // androidx.core.view.l1.e
        public void b(boolean z3) {
            if (!z3) {
                g(8192);
                return;
            }
            h(67108864);
            e(Integer.MIN_VALUE);
            d(8192);
        }
    }

    private static class c extends b {
        c(Window window, O o3) {
            super(window, o3);
        }

        @Override // androidx.core.view.l1.e
        public void a(boolean z3) {
            if (!z3) {
                g(16);
                return;
            }
            h(134217728);
            e(Integer.MIN_VALUE);
            d(16);
        }
    }

    private static class e {
        e() {
        }

        public void a(boolean z3) {
        }

        public void b(boolean z3) {
        }

        void c(int i3) {
        }
    }

    private l1(WindowInsetsController windowInsetsController) {
        this.f4654a = new d(windowInsetsController, this, new O(windowInsetsController));
    }

    public static l1 d(WindowInsetsController windowInsetsController) {
        return new l1(windowInsetsController);
    }

    public void a(boolean z3) {
        this.f4654a.a(z3);
    }

    public void b(boolean z3) {
        this.f4654a.b(z3);
    }

    public void c(int i3) {
        this.f4654a.c(i3);
    }

    private static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final l1 f4657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowInsetsController f4658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final O f4659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final p046n.g f4660d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected Window f4661e;

        d(Window window, l1 l1Var, O o3) {
            this(window.getInsetsController(), l1Var, o3);
            this.f4661e = window;
        }

        @Override // androidx.core.view.l1.e
        public void a(boolean z3) {
            if (z3) {
                if (this.f4661e != null) {
                    d(16);
                }
                this.f4658b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f4661e != null) {
                    e(16);
                }
                this.f4658b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.l1.e
        public void b(boolean z3) {
            if (z3) {
                if (this.f4661e != null) {
                    d(8192);
                }
                this.f4658b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f4661e != null) {
                    e(8192);
                }
                this.f4658b.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // androidx.core.view.l1.e
        void c(int i3) {
            if ((i3 & 8) != 0) {
                this.f4659c.a();
            }
            this.f4658b.show(i3 & (-9));
        }

        protected void d(int i3) {
            View decorView = this.f4661e.getDecorView();
            decorView.setSystemUiVisibility(i3 | decorView.getSystemUiVisibility());
        }

        protected void e(int i3) {
            View decorView = this.f4661e.getDecorView();
            decorView.setSystemUiVisibility((i3 ^ (-1)) & decorView.getSystemUiVisibility());
        }

        d(WindowInsetsController windowInsetsController, l1 l1Var, O o3) {
            this.f4660d = new p046n.g();
            this.f4658b = windowInsetsController;
            this.f4657a = l1Var;
            this.f4659c = o3;
        }
    }

    public l1(Window window, View view) {
        O o3 = new O(view);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            this.f4654a = new d(window, this, o3);
            return;
        }
        if (i3 >= 26) {
            this.f4654a = new c(window, o3);
            return;
        }
        if (i3 >= 23) {
            this.f4654a = new b(window, o3);
        } else if (i3 >= 20) {
            this.f4654a = new a(window, o3);
        } else {
            this.f4654a = new e();
        }
    }
}
