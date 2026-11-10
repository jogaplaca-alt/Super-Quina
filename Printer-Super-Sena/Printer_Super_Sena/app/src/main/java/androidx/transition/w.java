package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class w extends AbstractC0386l {

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    int f6703O;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    ArrayList f6701M = new ArrayList();

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private boolean f6702N = true;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    boolean f6704P = false;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private int f6705Q = 0;

    class a extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractC0386l f6706a;

        a(AbstractC0386l abstractC0386l) {
            this.f6706a = abstractC0386l;
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void f(AbstractC0386l abstractC0386l) {
            this.f6706a.X();
            abstractC0386l.T(this);
        }
    }

    static class b extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        w f6708a;

        b(w wVar) {
            this.f6708a = wVar;
        }

        @Override // androidx.transition.t, androidx.transition.AbstractC0386l.f
        public void d(AbstractC0386l abstractC0386l) {
            w wVar = this.f6708a;
            if (wVar.f6704P) {
                return;
            }
            wVar.e0();
            this.f6708a.f6704P = true;
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void f(AbstractC0386l abstractC0386l) {
            w wVar = this.f6708a;
            int i3 = wVar.f6703O - 1;
            wVar.f6703O = i3;
            if (i3 == 0) {
                wVar.f6704P = false;
                wVar.q();
            }
            abstractC0386l.T(this);
        }
    }

    private void j0(AbstractC0386l abstractC0386l) {
        this.f6701M.add(abstractC0386l);
        abstractC0386l.f6671r = this;
    }

    private void s0() {
        b bVar = new b(this);
        Iterator it = this.f6701M.iterator();
        while (it.hasNext()) {
            ((AbstractC0386l) it.next()).a(bVar);
        }
        this.f6703O = this.f6701M.size();
    }

    @Override // androidx.transition.AbstractC0386l
    public void R(View view) {
        super.R(view);
        int size = this.f6701M.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC0386l) this.f6701M.get(i3)).R(view);
        }
    }

    @Override // androidx.transition.AbstractC0386l
    public void V(View view) {
        super.V(view);
        int size = this.f6701M.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC0386l) this.f6701M.get(i3)).V(view);
        }
    }

    @Override // androidx.transition.AbstractC0386l
    protected void X() {
        if (this.f6701M.isEmpty()) {
            e0();
            q();
            return;
        }
        s0();
        if (this.f6702N) {
            Iterator it = this.f6701M.iterator();
            while (it.hasNext()) {
                ((AbstractC0386l) it.next()).X();
            }
            return;
        }
        for (int i3 = 1; i3 < this.f6701M.size(); i3++) {
            ((AbstractC0386l) this.f6701M.get(i3 - 1)).a(new a((AbstractC0386l) this.f6701M.get(i3)));
        }
        AbstractC0386l abstractC0386l = (AbstractC0386l) this.f6701M.get(0);
        if (abstractC0386l != null) {
            abstractC0386l.X();
        }
    }

    @Override // androidx.transition.AbstractC0386l
    public void Z(AbstractC0386l.e eVar) {
        super.Z(eVar);
        this.f6705Q |= 8;
        int size = this.f6701M.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC0386l) this.f6701M.get(i3)).Z(eVar);
        }
    }

    @Override // androidx.transition.AbstractC0386l
    public void b0(AbstractC0381g abstractC0381g) {
        super.b0(abstractC0381g);
        this.f6705Q |= 4;
        if (this.f6701M != null) {
            for (int i3 = 0; i3 < this.f6701M.size(); i3++) {
                ((AbstractC0386l) this.f6701M.get(i3)).b0(abstractC0381g);
            }
        }
    }

    @Override // androidx.transition.AbstractC0386l
    public void c0(v vVar) {
        super.c0(vVar);
        this.f6705Q |= 2;
        int size = this.f6701M.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC0386l) this.f6701M.get(i3)).c0(vVar);
        }
    }

    @Override // androidx.transition.AbstractC0386l
    String f0(String str) {
        String strF0 = super.f0(str);
        for (int i3 = 0; i3 < this.f6701M.size(); i3++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strF0);
            sb.append("\n");
            sb.append(((AbstractC0386l) this.f6701M.get(i3)).f0(str + "  "));
            strF0 = sb.toString();
        }
        return strF0;
    }

    @Override // androidx.transition.AbstractC0386l
    protected void g() {
        super.g();
        int size = this.f6701M.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC0386l) this.f6701M.get(i3)).g();
        }
    }

    @Override // androidx.transition.AbstractC0386l
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public w a(AbstractC0386l.f fVar) {
        return (w) super.a(fVar);
    }

    @Override // androidx.transition.AbstractC0386l
    public void h(y yVar) {
        if (I(yVar.f6711b)) {
            for (AbstractC0386l abstractC0386l : this.f6701M) {
                if (abstractC0386l.I(yVar.f6711b)) {
                    abstractC0386l.h(yVar);
                    yVar.f6712c.add(abstractC0386l);
                }
            }
        }
    }

    @Override // androidx.transition.AbstractC0386l
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public w b(View view) {
        for (int i3 = 0; i3 < this.f6701M.size(); i3++) {
            ((AbstractC0386l) this.f6701M.get(i3)).b(view);
        }
        return (w) super.b(view);
    }

    public w i0(AbstractC0386l abstractC0386l) {
        j0(abstractC0386l);
        long j3 = this.f6656c;
        if (j3 >= 0) {
            abstractC0386l.Y(j3);
        }
        if ((this.f6705Q & 1) != 0) {
            abstractC0386l.a0(t());
        }
        if ((this.f6705Q & 2) != 0) {
            x();
            abstractC0386l.c0(null);
        }
        if ((this.f6705Q & 4) != 0) {
            abstractC0386l.b0(w());
        }
        if ((this.f6705Q & 8) != 0) {
            abstractC0386l.Z(s());
        }
        return this;
    }

    @Override // androidx.transition.AbstractC0386l
    void j(y yVar) {
        super.j(yVar);
        int size = this.f6701M.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC0386l) this.f6701M.get(i3)).j(yVar);
        }
    }

    @Override // androidx.transition.AbstractC0386l
    public void k(y yVar) {
        if (I(yVar.f6711b)) {
            for (AbstractC0386l abstractC0386l : this.f6701M) {
                if (abstractC0386l.I(yVar.f6711b)) {
                    abstractC0386l.k(yVar);
                    yVar.f6712c.add(abstractC0386l);
                }
            }
        }
    }

    public AbstractC0386l k0(int i3) {
        if (i3 < 0 || i3 >= this.f6701M.size()) {
            return null;
        }
        return (AbstractC0386l) this.f6701M.get(i3);
    }

    public int l0() {
        return this.f6701M.size();
    }

    @Override // androidx.transition.AbstractC0386l
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public w T(AbstractC0386l.f fVar) {
        return (w) super.T(fVar);
    }

    @Override // androidx.transition.AbstractC0386l
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public AbstractC0386l clone() {
        w wVar = (w) super.clone();
        wVar.f6701M = new ArrayList();
        int size = this.f6701M.size();
        for (int i3 = 0; i3 < size; i3++) {
            wVar.j0(((AbstractC0386l) this.f6701M.get(i3)).clone());
        }
        return wVar;
    }

    @Override // androidx.transition.AbstractC0386l
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public w U(View view) {
        for (int i3 = 0; i3 < this.f6701M.size(); i3++) {
            ((AbstractC0386l) this.f6701M.get(i3)).U(view);
        }
        return (w) super.U(view);
    }

    @Override // androidx.transition.AbstractC0386l
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public w Y(long j3) {
        ArrayList arrayList;
        super.Y(j3);
        if (this.f6656c >= 0 && (arrayList = this.f6701M) != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((AbstractC0386l) this.f6701M.get(i3)).Y(j3);
            }
        }
        return this;
    }

    @Override // androidx.transition.AbstractC0386l
    void p(ViewGroup viewGroup, z zVar, z zVar2, ArrayList arrayList, ArrayList arrayList2) {
        long jA = A();
        int size = this.f6701M.size();
        for (int i3 = 0; i3 < size; i3++) {
            AbstractC0386l abstractC0386l = (AbstractC0386l) this.f6701M.get(i3);
            if (jA > 0 && (this.f6702N || i3 == 0)) {
                long jA2 = abstractC0386l.A();
                if (jA2 > 0) {
                    abstractC0386l.d0(jA2 + jA);
                } else {
                    abstractC0386l.d0(jA);
                }
            }
            abstractC0386l.p(viewGroup, zVar, zVar2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.AbstractC0386l
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public w a0(TimeInterpolator timeInterpolator) {
        this.f6705Q |= 1;
        ArrayList arrayList = this.f6701M;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((AbstractC0386l) this.f6701M.get(i3)).a0(timeInterpolator);
            }
        }
        return (w) super.a0(timeInterpolator);
    }

    public w q0(int i3) {
        if (i3 == 0) {
            this.f6702N = true;
        } else {
            if (i3 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i3);
            }
            this.f6702N = false;
        }
        return this;
    }

    @Override // androidx.transition.AbstractC0386l
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public w d0(long j3) {
        return (w) super.d0(j3);
    }
}
