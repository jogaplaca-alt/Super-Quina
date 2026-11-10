package p058r;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p049o.c;
import p049o.i;
import p061s.o;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f10620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f10621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f10622f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    i f10625i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashSet f10617a = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10623g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f10624h = Integer.MIN_VALUE;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10626a;

        static {
            int[] iArr = new int[b.values().length];
            f10626a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10626a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10626a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10626a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10626a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10626a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10626a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10626a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10626a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, b bVar) {
        this.f10620d = eVar;
        this.f10621e = bVar;
    }

    public boolean a(d dVar, int i3) {
        return b(dVar, i3, Integer.MIN_VALUE, false);
    }

    public boolean b(d dVar, int i3, int i4, boolean z3) {
        if (dVar == null) {
            q();
            return true;
        }
        if (!z3 && !p(dVar)) {
            return false;
        }
        this.f10622f = dVar;
        if (dVar.f10617a == null) {
            dVar.f10617a = new HashSet();
        }
        HashSet hashSet = this.f10622f.f10617a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f10623g = i3;
        this.f10624h = i4;
        return true;
    }

    public void c(int i3, ArrayList arrayList, o oVar) {
        HashSet hashSet = this.f10617a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                p061s.i.a(((d) it.next()).f10620d, i3, arrayList, oVar);
            }
        }
    }

    public HashSet d() {
        return this.f10617a;
    }

    public int e() {
        if (this.f10619c) {
            return this.f10618b;
        }
        return 0;
    }

    public int f() {
        d dVar;
        if (this.f10620d.V() == 8) {
            return 0;
        }
        return (this.f10624h == Integer.MIN_VALUE || (dVar = this.f10622f) == null || dVar.f10620d.V() != 8) ? this.f10623g : this.f10624h;
    }

    public final d g() {
        switch (a.f10626a[this.f10621e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f10620d.f10664Q;
            case 3:
                return this.f10620d.f10662O;
            case 4:
                return this.f10620d.f10665R;
            case 5:
                return this.f10620d.f10663P;
            default:
                throw new AssertionError(this.f10621e.name());
        }
    }

    public e h() {
        return this.f10620d;
    }

    public i i() {
        return this.f10625i;
    }

    public d j() {
        return this.f10622f;
    }

    public b k() {
        return this.f10621e;
    }

    public boolean l() {
        HashSet hashSet = this.f10617a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((d) it.next()).g().o()) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        HashSet hashSet = this.f10617a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean n() {
        return this.f10619c;
    }

    public boolean o() {
        return this.f10622f != null;
    }

    public boolean p(d dVar) {
        if (dVar == null) {
            return false;
        }
        b bVarK = dVar.k();
        b bVar = this.f10621e;
        if (bVarK == bVar) {
            return bVar != b.BASELINE || (dVar.h().Z() && h().Z());
        }
        switch (a.f10626a[bVar.ordinal()]) {
            case 1:
                return (bVarK == b.BASELINE || bVarK == b.CENTER_X || bVarK == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z3 = bVarK == b.LEFT || bVarK == b.RIGHT;
                if (dVar.h() instanceof h) {
                    return z3 || bVarK == b.CENTER_X;
                }
                return z3;
            case 4:
            case 5:
                boolean z4 = bVarK == b.TOP || bVarK == b.BOTTOM;
                if (dVar.h() instanceof h) {
                    return z4 || bVarK == b.CENTER_Y;
                }
                return z4;
            case 6:
                return (bVarK == b.LEFT || bVarK == b.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f10621e.name());
        }
    }

    public void q() {
        HashSet hashSet;
        d dVar = this.f10622f;
        if (dVar != null && (hashSet = dVar.f10617a) != null) {
            hashSet.remove(this);
            if (this.f10622f.f10617a.size() == 0) {
                this.f10622f.f10617a = null;
            }
        }
        this.f10617a = null;
        this.f10622f = null;
        this.f10623g = 0;
        this.f10624h = Integer.MIN_VALUE;
        this.f10619c = false;
        this.f10618b = 0;
    }

    public void r() {
        this.f10619c = false;
        this.f10618b = 0;
    }

    public void s(c cVar) {
        i iVar = this.f10625i;
        if (iVar == null) {
            this.f10625i = new i(i.a.UNRESTRICTED, null);
        } else {
            iVar.e();
        }
    }

    public void t(int i3) {
        this.f10618b = i3;
        this.f10619c = true;
    }

    public String toString() {
        return this.f10620d.t() + ":" + this.f10621e.toString();
    }

    public void u(int i3) {
        if (o()) {
            this.f10624h = i3;
        }
    }
}
