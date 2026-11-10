package androidx.room;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class x implements Z.j, Z.i {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f6434i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final TreeMap f6435j = new TreeMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile String f6437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f6438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double[] f6439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f6440e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[][] f6441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f6442g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6443h;

    public static final class a {
        public /* synthetic */ a(S1.g gVar) {
            this();
        }

        public final x a(String str, int i3) {
            S1.k.e(str, "query");
            TreeMap treeMap = x.f6435j;
            synchronized (treeMap) {
                Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i3));
                if (entryCeilingEntry == null) {
                    J1.l lVar = J1.l.f1194a;
                    x xVar = new x(i3, null);
                    xVar.I(str, i3);
                    return xVar;
                }
                treeMap.remove(entryCeilingEntry.getKey());
                x xVar2 = (x) entryCeilingEntry.getValue();
                xVar2.I(str, i3);
                S1.k.d(xVar2, "sqliteQuery");
                return xVar2;
            }
        }

        public final void b() {
            TreeMap treeMap = x.f6435j;
            if (treeMap.size() <= 15) {
                return;
            }
            int size = treeMap.size() - 10;
            Iterator it = treeMap.descendingKeySet().iterator();
            S1.k.d(it, "queryPool.descendingKeySet().iterator()");
            while (true) {
                int i3 = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i3;
            }
        }

        private a() {
        }
    }

    public /* synthetic */ x(int i3, S1.g gVar) {
        this(i3);
    }

    public static final x y(String str, int i3) {
        return f6434i.a(str, i3);
    }

    public int G() {
        return this.f6443h;
    }

    public final void I(String str, int i3) {
        S1.k.e(str, "query");
        this.f6437b = str;
        this.f6443h = i3;
    }

    public final void J() {
        TreeMap treeMap = f6435j;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f6436a), this);
            f6434i.b();
            J1.l lVar = J1.l.f1194a;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // Z.j
    public void g(Z.i iVar) {
        S1.k.e(iVar, "statement");
        int iG = G();
        if (1 > iG) {
            return;
        }
        int i3 = 1;
        while (true) {
            int i4 = this.f6442g[i3];
            if (i4 == 1) {
                iVar.x(i3);
            } else if (i4 == 2) {
                iVar.l(i3, this.f6438c[i3]);
            } else if (i4 == 3) {
                iVar.z(i3, this.f6439d[i3]);
            } else if (i4 == 4) {
                String str = this.f6440e[i3];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                iVar.k(i3, str);
            } else if (i4 == 5) {
                byte[] bArr = this.f6441f[i3];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                iVar.u(i3, bArr);
            }
            if (i3 == iG) {
                return;
            } else {
                i3++;
            }
        }
    }

    @Override // Z.i
    public void k(int i3, String str) {
        S1.k.e(str, "value");
        this.f6442g[i3] = 4;
        this.f6440e[i3] = str;
    }

    @Override // Z.i
    public void l(int i3, long j3) {
        this.f6442g[i3] = 2;
        this.f6438c[i3] = j3;
    }

    @Override // Z.j
    public String t() {
        String str = this.f6437b;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // Z.i
    public void u(int i3, byte[] bArr) {
        S1.k.e(bArr, "value");
        this.f6442g[i3] = 5;
        this.f6441f[i3] = bArr;
    }

    @Override // Z.i
    public void x(int i3) {
        this.f6442g[i3] = 1;
    }

    @Override // Z.i
    public void z(int i3, double d3) {
        this.f6442g[i3] = 3;
        this.f6439d[i3] = d3;
    }

    private x(int i3) {
        this.f6436a = i3;
        int i4 = i3 + 1;
        this.f6442g = new int[i4];
        this.f6438c = new long[i4];
        this.f6439d = new double[i4];
        this.f6440e = new String[i4];
        this.f6441f = new byte[i4][];
    }
}
