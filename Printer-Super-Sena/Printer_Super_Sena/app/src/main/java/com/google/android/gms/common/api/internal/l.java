package com.google.android.gms.common.api.internal;

import C0.C0179a;
import C0.C0181c;
import E0.C0184b;
import F0.AbstractC0219m;
import F0.AbstractC0220n;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.appcompat.app.H;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class l implements D0.f.a, D0.f.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final D0.a.f f7265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final C0184b f7266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f7267f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f7270i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final E0.v f7271j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7272k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ b f7276o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue f7264c = new LinkedList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set f7268g = new HashSet();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f7269h = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f7273l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private C0179a f7274m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7275n = 0;

    public l(b bVar, D0.e eVar) {
        this.f7276o = bVar;
        D0.a.f fVarH = eVar.h(bVar.f7243n.getLooper(), this);
        this.f7265d = fVarH;
        this.f7266e = eVar.e();
        this.f7267f = new e();
        this.f7270i = eVar.g();
        if (fVarH.j()) {
            this.f7271j = eVar.i(bVar.f7234e, bVar.f7243n);
        } else {
            this.f7271j = null;
        }
    }

    static /* bridge */ /* synthetic */ void B(l lVar, m mVar) {
        if (lVar.f7273l.contains(mVar) && !lVar.f7272k) {
            if (lVar.f7265d.isConnected()) {
                lVar.j();
            } else {
                lVar.E();
            }
        }
    }

    static /* bridge */ /* synthetic */ void C(l lVar, m mVar) {
        C0181c[] c0181cArrG;
        if (lVar.f7273l.remove(mVar)) {
            lVar.f7276o.f7243n.removeMessages(15, mVar);
            lVar.f7276o.f7243n.removeMessages(16, mVar);
            C0181c c0181c = mVar.f7278b;
            ArrayList arrayList = new ArrayList(lVar.f7264c.size());
            for (v vVar : lVar.f7264c) {
                if ((vVar instanceof E0.q) && (c0181cArrG = ((E0.q) vVar).g(lVar)) != null && J0.a.b(c0181cArrG, c0181c)) {
                    arrayList.add(vVar);
                }
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                v vVar2 = (v) arrayList.get(i3);
                lVar.f7264c.remove(vVar2);
                vVar2.b(new D0.h(c0181c));
            }
        }
    }

    private final C0181c f(C0181c[] c0181cArr) {
        if (c0181cArr != null && c0181cArr.length != 0) {
            C0181c[] c0181cArrB = this.f7265d.b();
            if (c0181cArrB == null) {
                c0181cArrB = new C0181c[0];
            }
            p046n.a aVar = new p046n.a(c0181cArrB.length);
            for (C0181c c0181c : c0181cArrB) {
                aVar.put(c0181c.c(), Long.valueOf(c0181c.d()));
            }
            for (C0181c c0181c2 : c0181cArr) {
                Long l3 = (Long) aVar.get(c0181c2.c());
                if (l3 == null || l3.longValue() < c0181c2.d()) {
                    return c0181c2;
                }
            }
        }
        return null;
    }

    private final void g(C0179a c0179a) {
        Iterator it = this.f7268g.iterator();
        if (!it.hasNext()) {
            this.f7268g.clear();
            return;
        }
        H.a(it.next());
        if (AbstractC0219m.a(c0179a, C0179a.f120e)) {
            this.f7265d.c();
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Status status) {
        AbstractC0220n.c(this.f7276o.f7243n);
        i(status, null, false);
    }

    private final void i(Status status, Exception exc, boolean z3) {
        AbstractC0220n.c(this.f7276o.f7243n);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f7264c.iterator();
        while (it.hasNext()) {
            v vVar = (v) it.next();
            if (!z3 || vVar.f7301a == 2) {
                if (status != null) {
                    vVar.a(status);
                } else {
                    vVar.b(exc);
                }
                it.remove();
            }
        }
    }

    private final void j() {
        ArrayList arrayList = new ArrayList(this.f7264c);
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            v vVar = (v) arrayList.get(i3);
            if (!this.f7265d.isConnected()) {
                return;
            }
            if (p(vVar)) {
                this.f7264c.remove(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        D();
        g(C0179a.f120e);
        o();
        Iterator it = this.f7269h.values().iterator();
        if (it.hasNext()) {
            H.a(it.next());
            throw null;
        }
        j();
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(int i3) {
        D();
        this.f7272k = true;
        this.f7267f.c(i3, this.f7265d.e());
        C0184b c0184b = this.f7266e;
        b bVar = this.f7276o;
        bVar.f7243n.sendMessageDelayed(Message.obtain(bVar.f7243n, 9, c0184b), 5000L);
        C0184b c0184b2 = this.f7266e;
        b bVar2 = this.f7276o;
        bVar2.f7243n.sendMessageDelayed(Message.obtain(bVar2.f7243n, 11, c0184b2), 120000L);
        this.f7276o.f7236g.c();
        Iterator it = this.f7269h.values().iterator();
        if (it.hasNext()) {
            H.a(it.next());
            throw null;
        }
    }

    private final void m() {
        this.f7276o.f7243n.removeMessages(12, this.f7266e);
        C0184b c0184b = this.f7266e;
        b bVar = this.f7276o;
        bVar.f7243n.sendMessageDelayed(bVar.f7243n.obtainMessage(12, c0184b), this.f7276o.f7230a);
    }

    private final void n(v vVar) {
        vVar.d(this.f7267f, a());
        try {
            vVar.c(this);
        } catch (DeadObjectException unused) {
            c(1);
            this.f7265d.g("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void o() {
        if (this.f7272k) {
            b bVar = this.f7276o;
            bVar.f7243n.removeMessages(11, this.f7266e);
            b bVar2 = this.f7276o;
            bVar2.f7243n.removeMessages(9, this.f7266e);
            this.f7272k = false;
        }
    }

    private final boolean p(v vVar) {
        if (!(vVar instanceof E0.q)) {
            n(vVar);
            return true;
        }
        E0.q qVar = (E0.q) vVar;
        C0181c c0181cF = f(qVar.g(this));
        if (c0181cF == null) {
            n(vVar);
            return true;
        }
        Log.w("GoogleApiManager", this.f7265d.getClass().getName() + " could not execute call because it requires feature (" + c0181cF.c() + ", " + c0181cF.d() + ").");
        if (!this.f7276o.f7244o || !qVar.f(this)) {
            qVar.b(new D0.h(c0181cF));
            return true;
        }
        m mVar = new m(this.f7266e, c0181cF, null);
        int iIndexOf = this.f7273l.indexOf(mVar);
        if (iIndexOf >= 0) {
            m mVar2 = (m) this.f7273l.get(iIndexOf);
            this.f7276o.f7243n.removeMessages(15, mVar2);
            b bVar = this.f7276o;
            bVar.f7243n.sendMessageDelayed(Message.obtain(bVar.f7243n, 15, mVar2), 5000L);
            return false;
        }
        this.f7273l.add(mVar);
        b bVar2 = this.f7276o;
        bVar2.f7243n.sendMessageDelayed(Message.obtain(bVar2.f7243n, 15, mVar), 5000L);
        b bVar3 = this.f7276o;
        bVar3.f7243n.sendMessageDelayed(Message.obtain(bVar3.f7243n, 16, mVar), 120000L);
        C0179a c0179a = new C0179a(2, null);
        if (q(c0179a)) {
            return false;
        }
        this.f7276o.e(c0179a, this.f7270i);
        return false;
    }

    private final boolean q(C0179a c0179a) {
        synchronized (b.f7228r) {
            try {
                b bVar = this.f7276o;
                if (bVar.f7240k == null || !bVar.f7241l.contains(this.f7266e)) {
                    return false;
                }
                this.f7276o.f7240k.s(c0179a, this.f7270i);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final boolean r(boolean z3) {
        AbstractC0220n.c(this.f7276o.f7243n);
        if (!this.f7265d.isConnected() || !this.f7269h.isEmpty()) {
            return false;
        }
        if (!this.f7267f.e()) {
            this.f7265d.g("Timing out service connection.");
            return true;
        }
        if (!z3) {
            return false;
        }
        m();
        return false;
    }

    public final void D() {
        AbstractC0220n.c(this.f7276o.f7243n);
        this.f7274m = null;
    }

    public final void E() {
        AbstractC0220n.c(this.f7276o.f7243n);
        if (this.f7265d.isConnected() || this.f7265d.a()) {
            return;
        }
        try {
            b bVar = this.f7276o;
            int iB = bVar.f7236g.b(bVar.f7234e, this.f7265d);
            if (iB == 0) {
                b bVar2 = this.f7276o;
                D0.a.f fVar = this.f7265d;
                o oVar = new o(bVar2, fVar, this.f7266e);
                if (fVar.j()) {
                    ((E0.v) AbstractC0220n.f(this.f7271j)).T(oVar);
                }
                try {
                    this.f7265d.i(oVar);
                    return;
                } catch (SecurityException e3) {
                    H(new C0179a(10), e3);
                    return;
                }
            }
            C0179a c0179a = new C0179a(iB, null);
            Log.w("GoogleApiManager", "The service for " + this.f7265d.getClass().getName() + " is not available: " + c0179a.toString());
            H(c0179a, null);
        } catch (IllegalStateException e4) {
            H(new C0179a(10), e4);
        }
    }

    public final void F(v vVar) {
        AbstractC0220n.c(this.f7276o.f7243n);
        if (this.f7265d.isConnected()) {
            if (p(vVar)) {
                m();
                return;
            } else {
                this.f7264c.add(vVar);
                return;
            }
        }
        this.f7264c.add(vVar);
        C0179a c0179a = this.f7274m;
        if (c0179a == null || !c0179a.f()) {
            E();
        } else {
            H(this.f7274m, null);
        }
    }

    final void G() {
        this.f7275n++;
    }

    public final void H(C0179a c0179a, Exception exc) {
        AbstractC0220n.c(this.f7276o.f7243n);
        E0.v vVar = this.f7271j;
        if (vVar != null) {
            vVar.U();
        }
        D();
        this.f7276o.f7236g.c();
        g(c0179a);
        if ((this.f7265d instanceof H0.e) && c0179a.c() != 24) {
            this.f7276o.f7231b = true;
            b bVar = this.f7276o;
            bVar.f7243n.sendMessageDelayed(bVar.f7243n.obtainMessage(19), 300000L);
        }
        if (c0179a.c() == 4) {
            h(b.f7227q);
            return;
        }
        if (this.f7264c.isEmpty()) {
            this.f7274m = c0179a;
            return;
        }
        if (exc != null) {
            AbstractC0220n.c(this.f7276o.f7243n);
            i(null, exc, false);
            return;
        }
        if (!this.f7276o.f7244o) {
            h(b.f(this.f7266e, c0179a));
            return;
        }
        i(b.f(this.f7266e, c0179a), null, true);
        if (this.f7264c.isEmpty() || q(c0179a) || this.f7276o.e(c0179a, this.f7270i)) {
            return;
        }
        if (c0179a.c() == 18) {
            this.f7272k = true;
        }
        if (!this.f7272k) {
            h(b.f(this.f7266e, c0179a));
            return;
        }
        b bVar2 = this.f7276o;
        bVar2.f7243n.sendMessageDelayed(Message.obtain(bVar2.f7243n, 9, this.f7266e), 5000L);
    }

    public final void I(C0179a c0179a) {
        AbstractC0220n.c(this.f7276o.f7243n);
        D0.a.f fVar = this.f7265d;
        fVar.g("onSignInFailed for " + fVar.getClass().getName() + " with " + String.valueOf(c0179a));
        H(c0179a, null);
    }

    public final void J() {
        AbstractC0220n.c(this.f7276o.f7243n);
        if (this.f7272k) {
            E();
        }
    }

    public final void K() {
        AbstractC0220n.c(this.f7276o.f7243n);
        h(b.f7226p);
        this.f7267f.d();
        for (E0.f fVar : (E0.f[]) this.f7269h.keySet().toArray(new E0.f[0])) {
            F(new u(null, new R0.e()));
        }
        g(new C0179a(4));
        if (this.f7265d.isConnected()) {
            this.f7265d.d(new k(this));
        }
    }

    public final void L() {
        AbstractC0220n.c(this.f7276o.f7243n);
        if (this.f7272k) {
            o();
            b bVar = this.f7276o;
            h(bVar.f7235f.e(bVar.f7234e) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f7265d.g("Timing out connection while resuming.");
        }
    }

    public final boolean a() {
        return this.f7265d.j();
    }

    public final boolean b() {
        return r(true);
    }

    @Override // E0.c
    public final void c(int i3) {
        if (Looper.myLooper() == this.f7276o.f7243n.getLooper()) {
            l(i3);
        } else {
            this.f7276o.f7243n.post(new i(this, i3));
        }
    }

    @Override // E0.h
    public final void d(C0179a c0179a) {
        H(c0179a, null);
    }

    @Override // E0.c
    public final void e(Bundle bundle) {
        if (Looper.myLooper() == this.f7276o.f7243n.getLooper()) {
            k();
        } else {
            this.f7276o.f7243n.post(new h(this));
        }
    }

    public final int s() {
        return this.f7270i;
    }

    final int t() {
        return this.f7275n;
    }

    public final D0.a.f v() {
        return this.f7265d;
    }

    public final Map x() {
        return this.f7269h;
    }
}
