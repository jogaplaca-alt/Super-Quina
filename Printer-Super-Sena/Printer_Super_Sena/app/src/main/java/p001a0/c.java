package p001a0;

import R1.r;
import S1.k;
import S1.l;
import Z.g;
import Z.j;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.os.CancellationSignal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f2184b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f2185c = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f2186d = new String[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f2187a;

    public static final class a {
        public /* synthetic */ a(S1.g gVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f2188b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(j jVar) {
            super(4);
            this.f2188b = jVar;
        }

        @Override // R1.r
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public final SQLiteCursor b(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            j jVar = this.f2188b;
            k.b(sQLiteQuery);
            jVar.g(new g(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public c(SQLiteDatabase sQLiteDatabase) {
        k.e(sQLiteDatabase, "delegate");
        this.f2187a = sQLiteDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor G(r rVar, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        k.e(rVar, "$tmp0");
        return (Cursor) rVar.b(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor I(j jVar, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        k.e(jVar, "$query");
        k.b(sQLiteQuery);
        jVar.g(new g(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    @Override // Z.g
    public Cursor C(j jVar) {
        k.e(jVar, "query");
        final b bVar = new b(jVar);
        Cursor cursorRawQueryWithFactory = this.f2187a.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: a0.b
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return c.G(bVar, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, jVar.t(), f2186d, null);
        k.d(cursorRawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return cursorRawQueryWithFactory;
    }

    @Override // Z.g
    public Cursor D(String str) {
        k.e(str, "query");
        return C(new Z.a(str));
    }

    @Override // Z.g
    public String E() {
        return this.f2187a.getPath();
    }

    @Override // Z.g
    public boolean F() {
        return this.f2187a.inTransaction();
    }

    @Override // Z.g
    public void a() {
        this.f2187a.endTransaction();
    }

    @Override // Z.g
    public void b() {
        this.f2187a.beginTransaction();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2187a.close();
    }

    @Override // Z.g
    public List h() {
        return this.f2187a.getAttachedDbs();
    }

    @Override // Z.g
    public boolean i() {
        return Z.b.b(this.f2187a);
    }

    @Override // Z.g
    public boolean isOpen() {
        return this.f2187a.isOpen();
    }

    @Override // Z.g
    public void j(String str) {
        k.e(str, "sql");
        this.f2187a.execSQL(str);
    }

    @Override // Z.g
    public void m() {
        this.f2187a.setTransactionSuccessful();
    }

    @Override // Z.g
    public Z.k p(String str) {
        k.e(str, "sql");
        SQLiteStatement sQLiteStatementCompileStatement = this.f2187a.compileStatement(str);
        k.d(sQLiteStatementCompileStatement, "delegate.compileStatement(sql)");
        return new h(sQLiteStatementCompileStatement);
    }

    @Override // Z.g
    public void q() {
        this.f2187a.beginTransactionNonExclusive();
    }

    @Override // Z.g
    public Cursor r(final j jVar, CancellationSignal cancellationSignal) {
        k.e(jVar, "query");
        SQLiteDatabase sQLiteDatabase = this.f2187a;
        String strT = jVar.t();
        String[] strArr = f2186d;
        k.b(cancellationSignal);
        return Z.b.c(sQLiteDatabase, strT, strArr, null, cancellationSignal, new SQLiteDatabase.CursorFactory() { // from class: a0.a
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase2, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return c.I(jVar, sQLiteDatabase2, sQLiteCursorDriver, str, sQLiteQuery);
            }
        });
    }

    public final boolean y(SQLiteDatabase sQLiteDatabase) {
        k.e(sQLiteDatabase, "sqLiteDatabase");
        return k.a(this.f2187a, sQLiteDatabase);
    }
}
