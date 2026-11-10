package p001a0;

import S1.g;
import S1.k;
import S1.l;
import Z.h;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class d implements h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f2189h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h.a f2192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f2193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f2194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final J1.c f2195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2196g;

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private p001a0.c f2197a;

        public b(p001a0.c cVar) {
            this.f2197a = cVar;
        }

        public final p001a0.c a() {
            return this.f2197a;
        }

        public final void b(p001a0.c cVar) {
            this.f2197a = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class c extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final C0035c f2198h = new C0035c(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f2199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f2200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final h.a f2201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f2202d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2203e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final p005b0.a f2204f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f2205g;

        private static final class a extends RuntimeException {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final b f2206a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Throwable f2207b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, Throwable th) {
                super(th);
                k.e(bVar, "callbackName");
                k.e(th, "cause");
                this.f2206a = bVar;
                this.f2207b = th;
            }

            public final b a() {
                return this.f2206a;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.f2207b;
            }
        }

        public enum b {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN
        }

        /* JADX INFO: renamed from: a0.d$c$c, reason: collision with other inner class name */
        public static final class C0035c {
            public /* synthetic */ C0035c(g gVar) {
                this();
            }

            public final p001a0.c a(b bVar, SQLiteDatabase sQLiteDatabase) {
                k.e(bVar, "refHolder");
                k.e(sQLiteDatabase, "sqLiteDatabase");
                p001a0.c cVarA = bVar.a();
                if (cVarA != null && cVarA.y(sQLiteDatabase)) {
                    return cVarA;
                }
                p001a0.c cVar = new p001a0.c(sQLiteDatabase);
                bVar.b(cVar);
                return cVar;
            }

            private C0035c() {
            }
        }

        /* JADX INFO: renamed from: a0.d$c$d, reason: collision with other inner class name */
        public /* synthetic */ class C0036d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f2214a;

            static {
                int[] iArr = new int[b.values().length];
                try {
                    iArr[b.ON_CONFIGURE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[b.ON_CREATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[b.ON_UPGRADE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[b.ON_DOWNGRADE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[b.ON_OPEN.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f2214a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, String str, final b bVar, final h.a aVar, boolean z3) {
            super(context, str, null, aVar.f2163a, new DatabaseErrorHandler() { // from class: a0.e
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    d.c.t(aVar, bVar, sQLiteDatabase);
                }
            });
            k.e(context, "context");
            k.e(bVar, "dbRef");
            k.e(aVar, "callback");
            this.f2199a = context;
            this.f2200b = bVar;
            this.f2201c = aVar;
            this.f2202d = z3;
            if (str == null) {
                str = UUID.randomUUID().toString();
                k.d(str, "randomUUID().toString()");
            }
            this.f2204f = new p005b0.a(str, context.getCacheDir(), false);
        }

        private final SQLiteDatabase I(boolean z3) {
            if (z3) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                k.d(writableDatabase, "{\n                super.…eDatabase()\n            }");
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            k.d(readableDatabase, "{\n                super.…eDatabase()\n            }");
            return readableDatabase;
        }

        private final SQLiteDatabase J(boolean z3) throws Throwable {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z4 = this.f2205g;
            if (databaseName != null && !z4 && (parentFile = this.f2199a.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return I(z3);
            } catch (Throwable unused) {
                super.close();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return I(z3);
                } catch (Throwable th) {
                    super.close();
                    if (th instanceof a) {
                        a aVar = th;
                        Throwable cause = aVar.getCause();
                        int i3 = C0036d.f2214a[aVar.a().ordinal()];
                        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || !(cause instanceof SQLiteException)) {
                            throw cause;
                        }
                    } else if (!(th instanceof SQLiteException) || databaseName == null || !this.f2202d) {
                        throw th;
                    }
                    this.f2199a.deleteDatabase(databaseName);
                    try {
                        return I(z3);
                    } catch (a e3) {
                        throw e3.getCause();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(h.a aVar, b bVar, SQLiteDatabase sQLiteDatabase) {
            k.e(aVar, "$callback");
            k.e(bVar, "$dbRef");
            C0035c c0035c = f2198h;
            k.d(sQLiteDatabase, "dbObj");
            aVar.c(c0035c.a(bVar, sQLiteDatabase));
        }

        public final p001a0.c G(SQLiteDatabase sQLiteDatabase) {
            k.e(sQLiteDatabase, "sqLiteDatabase");
            return f2198h.a(this.f2200b, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            try {
                p005b0.a.c(this.f2204f, false, 1, null);
                super.close();
                this.f2200b.b(null);
                this.f2205g = false;
            } finally {
                this.f2204f.d();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            k.e(sQLiteDatabase, "db");
            if (!this.f2203e && this.f2201c.f2163a != sQLiteDatabase.getVersion()) {
                sQLiteDatabase.setMaxSqlCacheSize(1);
            }
            try {
                this.f2201c.b(G(sQLiteDatabase));
            } catch (Throwable th) {
                throw new a(b.ON_CONFIGURE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            k.e(sQLiteDatabase, "sqLiteDatabase");
            try {
                this.f2201c.d(G(sQLiteDatabase));
            } catch (Throwable th) {
                throw new a(b.ON_CREATE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
            k.e(sQLiteDatabase, "db");
            this.f2203e = true;
            try {
                this.f2201c.e(G(sQLiteDatabase), i3, i4);
            } catch (Throwable th) {
                throw new a(b.ON_DOWNGRADE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            k.e(sQLiteDatabase, "db");
            if (!this.f2203e) {
                try {
                    this.f2201c.f(G(sQLiteDatabase));
                } catch (Throwable th) {
                    throw new a(b.ON_OPEN, th);
                }
            }
            this.f2205g = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
            k.e(sQLiteDatabase, "sqLiteDatabase");
            this.f2203e = true;
            try {
                this.f2201c.g(G(sQLiteDatabase), i3, i4);
            } catch (Throwable th) {
                throw new a(b.ON_UPGRADE, th);
            }
        }

        public final Z.g y(boolean z3) {
            try {
                this.f2204f.b((this.f2205g || getDatabaseName() == null) ? false : true);
                this.f2203e = false;
                SQLiteDatabase sQLiteDatabaseJ = J(z3);
                if (!this.f2203e) {
                    return G(sQLiteDatabaseJ);
                }
                close();
                return y(z3);
            } finally {
                this.f2204f.d();
            }
        }
    }

    /* JADX INFO: renamed from: a0.d$d, reason: collision with other inner class name */
    static final class C0037d extends l implements R1.a {
        C0037d() {
            super(0);
        }

        @Override // R1.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public final c a() {
            c cVar;
            if (Build.VERSION.SDK_INT < 23 || d.this.f2191b == null || !d.this.f2193d) {
                cVar = new c(d.this.f2190a, d.this.f2191b, new b(null), d.this.f2192c, d.this.f2194e);
            } else {
                cVar = new c(d.this.f2190a, new File(Z.d.a(d.this.f2190a), d.this.f2191b).getAbsolutePath(), new b(null), d.this.f2192c, d.this.f2194e);
            }
            Z.b.d(cVar, d.this.f2196g);
            return cVar;
        }
    }

    public d(Context context, String str, h.a aVar, boolean z3, boolean z4) {
        k.e(context, "context");
        k.e(aVar, "callback");
        this.f2190a = context;
        this.f2191b = str;
        this.f2192c = aVar;
        this.f2193d = z3;
        this.f2194e = z4;
        this.f2195f = J1.d.a(new C0037d());
    }

    private final c K() {
        return (c) this.f2195f.getValue();
    }

    @Override // Z.h
    public Z.g A() {
        return K().y(true);
    }

    @Override // Z.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f2195f.a()) {
            K().close();
        }
    }

    @Override // Z.h
    public String getDatabaseName() {
        return this.f2191b;
    }

    @Override // Z.h
    public void setWriteAheadLoggingEnabled(boolean z3) {
        if (this.f2195f.a()) {
            Z.b.d(K(), z3);
        }
        this.f2196g = z3;
    }
}
