package androidx.recyclerview.widget;

import A.T;
import A.W;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.C0282a;
import androidx.core.view.Z;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class m extends C0282a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final RecyclerView f6206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f6207e;

    public static class a extends C0282a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final m f6208d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map f6209e = new WeakHashMap();

        public a(m mVar) {
            this.f6208d = mVar;
        }

        @Override // androidx.core.view.C0282a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            C0282a c0282a = (C0282a) this.f6209e.get(view);
            return c0282a != null ? c0282a.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Override // androidx.core.view.C0282a
        public W b(View view) {
            C0282a c0282a = (C0282a) this.f6209e.get(view);
            return c0282a != null ? c0282a.b(view) : super.b(view);
        }

        @Override // androidx.core.view.C0282a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            C0282a c0282a = (C0282a) this.f6209e.get(view);
            if (c0282a != null) {
                c0282a.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.C0282a
        public void g(View view, T t3) {
            if (this.f6208d.o() || this.f6208d.f6206d.getLayoutManager() == null) {
                super.g(view, t3);
                return;
            }
            this.f6208d.f6206d.getLayoutManager().S0(view, t3);
            C0282a c0282a = (C0282a) this.f6209e.get(view);
            if (c0282a != null) {
                c0282a.g(view, t3);
            } else {
                super.g(view, t3);
            }
        }

        @Override // androidx.core.view.C0282a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            C0282a c0282a = (C0282a) this.f6209e.get(view);
            if (c0282a != null) {
                c0282a.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.C0282a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            C0282a c0282a = (C0282a) this.f6209e.get(viewGroup);
            return c0282a != null ? c0282a.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.view.C0282a
        public boolean j(View view, int i3, Bundle bundle) {
            if (this.f6208d.o() || this.f6208d.f6206d.getLayoutManager() == null) {
                return super.j(view, i3, bundle);
            }
            C0282a c0282a = (C0282a) this.f6209e.get(view);
            if (c0282a != null) {
                if (c0282a.j(view, i3, bundle)) {
                    return true;
                }
            } else if (super.j(view, i3, bundle)) {
                return true;
            }
            return this.f6208d.f6206d.getLayoutManager().m1(view, i3, bundle);
        }

        @Override // androidx.core.view.C0282a
        public void l(View view, int i3) {
            C0282a c0282a = (C0282a) this.f6209e.get(view);
            if (c0282a != null) {
                c0282a.l(view, i3);
            } else {
                super.l(view, i3);
            }
        }

        @Override // androidx.core.view.C0282a
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            C0282a c0282a = (C0282a) this.f6209e.get(view);
            if (c0282a != null) {
                c0282a.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        C0282a n(View view) {
            return (C0282a) this.f6209e.remove(view);
        }

        void o(View view) {
            C0282a c0282aN = Z.n(view);
            if (c0282aN == null || c0282aN == this) {
                return;
            }
            this.f6209e.put(view, c0282aN);
        }
    }

    public m(RecyclerView recyclerView) {
        this.f6206d = recyclerView;
        C0282a c0282aN = n();
        if (c0282aN == null || !(c0282aN instanceof a)) {
            this.f6207e = new a(this);
        } else {
            this.f6207e = (a) c0282aN;
        }
    }

    @Override // androidx.core.view.C0282a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().O0(accessibilityEvent);
        }
    }

    @Override // androidx.core.view.C0282a
    public void g(View view, T t3) {
        super.g(view, t3);
        if (o() || this.f6206d.getLayoutManager() == null) {
            return;
        }
        this.f6206d.getLayoutManager().Q0(t3);
    }

    @Override // androidx.core.view.C0282a
    public boolean j(View view, int i3, Bundle bundle) {
        if (super.j(view, i3, bundle)) {
            return true;
        }
        if (o() || this.f6206d.getLayoutManager() == null) {
            return false;
        }
        return this.f6206d.getLayoutManager().k1(i3, bundle);
    }

    public C0282a n() {
        return this.f6207e;
    }

    boolean o() {
        return this.f6206d.n0();
    }
}
