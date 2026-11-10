package androidx.room;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: androidx.room.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0372d implements Z.h, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Z.h f6280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0371c f6281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f6282c;

    /* JADX INFO: renamed from: androidx.room.d$a */
    public static final class a implements Z.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final C0371c f6283a;

        /* JADX INFO: renamed from: androidx.room.d$a$a, reason: collision with other inner class name */
        static final class C0086a extends S1.l implements R1.l {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C0086a f6284b = new C0086a();

            C0086a() {
                super(1);
            }

            @Override // R1.l
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public final List c(Z.g gVar) {
                S1.k.e(gVar, "obj");
                return gVar.h();
            }
        }

        /* JADX INFO: renamed from: androidx.room.d$a$b */
        static final class b extends S1.l implements R1.l {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f6285b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(String str) {
                super(1);
                this.f6285b = str;
            }

            @Override // R1.l
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public final Object c(Z.g gVar) {
                S1.k.e(gVar, "db");
                gVar.j(this.f6285b);
                return null;
            }
        }

        /* JADX INFO: renamed from: androidx.room.d$a$c */
        /* synthetic */ class c extends S1.j implements R1.l {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public static final c f6286j = new c();

            c() {
                super(1, Z.g.class, "inTransaction", "inTransaction()Z", 0);
            }

            @Override // R1.l
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public final Boolean c(Z.g gVar) {
                S1.k.e(gVar, "p0");
                return Boolean.valueOf(gVar.F());
            }
        }

        /* JADX INFO: renamed from: androidx.room.d$a$d, reason: collision with other inner class name */
        static final class C0087d extends S1.l implements R1.l {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C0087d f6287b = new C0087d();

            C0087d() {
                super(1);
            }

            @Override // R1.l
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public final Boolean c(Z.g gVar) {
                S1.k.e(gVar, "db");
                return Boolean.valueOf(gVar.i());
            }
        }

        /* JADX INFO: renamed from: androidx.room.d$a$e */
        static final class e extends S1.l implements R1.l {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final e f6288b = new e();

            e() {
                super(1);
            }

            @Override // R1.l
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public final String c(Z.g gVar) {
                S1.k.e(gVar, "obj");
                return gVar.E();
            }
        }

        /* JADX INFO: renamed from: androidx.room.d$a$f */
        static final class f extends S1.l implements R1.l {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final f f6289b = new f();

            f() {
                super(1);
            }

            @Override // R1.l
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public final Object c(Z.g gVar) {
                S1.k.e(gVar, "it");
                return null;
            }
        }

        public a(C0371c c0371c) {
            S1.k.e(c0371c, "autoCloser");
            this.f6283a = c0371c;
        }

        @Override // Z.g
        public Cursor C(Z.j jVar) {
            S1.k.e(jVar, "query");
            try {
                return new c(this.f6283a.j().C(jVar), this.f6283a);
            } catch (Throwable th) {
                this.f6283a.e();
                throw th;
            }
        }

        @Override // Z.g
        public Cursor D(String str) {
            S1.k.e(str, "query");
            try {
                return new c(this.f6283a.j().D(str), this.f6283a);
            } catch (Throwable th) {
                this.f6283a.e();
                throw th;
            }
        }

        @Override // Z.g
        public String E() {
            return (String) this.f6283a.g(e.f6288b);
        }

        @Override // Z.g
        public boolean F() {
            if (this.f6283a.h() == null) {
                return false;
            }
            return ((Boolean) this.f6283a.g(c.f6286j)).booleanValue();
        }

        @Override // Z.g
        public void a() {
            if (this.f6283a.h() == null) {
                throw new IllegalStateException("End transaction called but delegateDb is null");
            }
            try {
                Z.g gVarH = this.f6283a.h();
                S1.k.b(gVarH);
                gVarH.a();
            } finally {
                this.f6283a.e();
            }
        }

        @Override // Z.g
        public void b() {
            try {
                this.f6283a.j().b();
            } catch (Throwable th) {
                this.f6283a.e();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f6283a.d();
        }

        public final void g() {
            this.f6283a.g(f.f6289b);
        }

        @Override // Z.g
        public List h() {
            return (List) this.f6283a.g(C0086a.f6284b);
        }

        @Override // Z.g
        public boolean i() {
            return ((Boolean) this.f6283a.g(C0087d.f6287b)).booleanValue();
        }

        @Override // Z.g
        public boolean isOpen() {
            Z.g gVarH = this.f6283a.h();
            if (gVarH == null) {
                return false;
            }
            return gVarH.isOpen();
        }

        @Override // Z.g
        public void j(String str) {
            S1.k.e(str, "sql");
            this.f6283a.g(new b(str));
        }

        @Override // Z.g
        public void m() {
            J1.l lVar;
            Z.g gVarH = this.f6283a.h();
            if (gVarH != null) {
                gVarH.m();
                lVar = J1.l.f1194a;
            } else {
                lVar = null;
            }
            if (lVar == null) {
                throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
            }
        }

        @Override // Z.g
        public Z.k p(String str) {
            S1.k.e(str, "sql");
            return new b(str, this.f6283a);
        }

        @Override // Z.g
        public void q() {
            try {
                this.f6283a.j().q();
            } catch (Throwable th) {
                this.f6283a.e();
                throw th;
            }
        }

        @Override // Z.g
        public Cursor r(Z.j jVar, CancellationSignal cancellationSignal) {
            S1.k.e(jVar, "query");
            try {
                return new c(this.f6283a.j().r(jVar, cancellationSignal), this.f6283a);
            } catch (Throwable th) {
                this.f6283a.e();
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.room.d$b */
    private static final class b implements Z.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C0371c f6291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayList f6292c;

        /* JADX INFO: renamed from: androidx.room.d$b$a */
        static final class a extends S1.l implements R1.l {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final a f6293b = new a();

            a() {
                super(1);
            }

            @Override // R1.l
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public final Long c(Z.k kVar) {
                S1.k.e(kVar, "obj");
                return Long.valueOf(kVar.B());
            }
        }

        /* JADX INFO: renamed from: androidx.room.d$b$b, reason: collision with other inner class name */
        static final class C0088b extends S1.l implements R1.l {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ R1.l f6295c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0088b(R1.l lVar) {
                super(1);
                this.f6295c = lVar;
            }

            @Override // R1.l
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public final Object c(Z.g gVar) {
                S1.k.e(gVar, "db");
                Z.k kVarP = gVar.p(b.this.f6290a);
                b.this.y(kVarP);
                return this.f6295c.c(kVarP);
            }
        }

        /* JADX INFO: renamed from: androidx.room.d$b$c */
        static final class c extends S1.l implements R1.l {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f6296b = new c();

            c() {
                super(1);
            }

            @Override // R1.l
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public final Integer c(Z.k kVar) {
                S1.k.e(kVar, "obj");
                return Integer.valueOf(kVar.n());
            }
        }

        public b(String str, C0371c c0371c) {
            S1.k.e(str, "sql");
            S1.k.e(c0371c, "autoCloser");
            this.f6290a = str;
            this.f6291b = c0371c;
            this.f6292c = new ArrayList();
        }

        private final Object G(R1.l lVar) {
            return this.f6291b.g(new C0088b(lVar));
        }

        private final void I(int i3, Object obj) {
            int size;
            int i4 = i3 - 1;
            if (i4 >= this.f6292c.size() && (size = this.f6292c.size()) <= i4) {
                while (true) {
                    this.f6292c.add(null);
                    if (size == i4) {
                        break;
                    } else {
                        size++;
                    }
                }
            }
            this.f6292c.set(i4, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void y(Z.k kVar) {
            Iterator it = this.f6292c.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                it.next();
                int i4 = i3 + 1;
                if (i3 < 0) {
                    K1.n.j();
                }
                Object obj = this.f6292c.get(i3);
                if (obj == null) {
                    kVar.x(i4);
                } else if (obj instanceof Long) {
                    kVar.l(i4, ((Number) obj).longValue());
                } else if (obj instanceof Double) {
                    kVar.z(i4, ((Number) obj).doubleValue());
                } else if (obj instanceof String) {
                    kVar.k(i4, (String) obj);
                } else if (obj instanceof byte[]) {
                    kVar.u(i4, (byte[]) obj);
                }
                i3 = i4;
            }
        }

        @Override // Z.k
        public long B() {
            return ((Number) G(a.f6293b)).longValue();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // Z.i
        public void k(int i3, String str) {
            S1.k.e(str, "value");
            I(i3, str);
        }

        @Override // Z.i
        public void l(int i3, long j3) {
            I(i3, Long.valueOf(j3));
        }

        @Override // Z.k
        public int n() {
            return ((Number) G(c.f6296b)).intValue();
        }

        @Override // Z.i
        public void u(int i3, byte[] bArr) {
            S1.k.e(bArr, "value");
            I(i3, bArr);
        }

        @Override // Z.i
        public void x(int i3) {
            I(i3, null);
        }

        @Override // Z.i
        public void z(int i3, double d3) {
            I(i3, Double.valueOf(d3));
        }
    }

    /* JADX INFO: renamed from: androidx.room.d$c */
    private static final class c implements Cursor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Cursor f6297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C0371c f6298b;

        public c(Cursor cursor, C0371c c0371c) {
            S1.k.e(cursor, "delegate");
            S1.k.e(c0371c, "autoCloser");
            this.f6297a = cursor;
            this.f6298b = c0371c;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f6297a.close();
            this.f6298b.e();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i3, CharArrayBuffer charArrayBuffer) {
            this.f6297a.copyStringToBuffer(i3, charArrayBuffer);
        }

        @Override // android.database.Cursor
        public void deactivate() {
            this.f6297a.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i3) {
            return this.f6297a.getBlob(i3);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.f6297a.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.f6297a.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) {
            return this.f6297a.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i3) {
            return this.f6297a.getColumnName(i3);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.f6297a.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.f6297a.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i3) {
            return this.f6297a.getDouble(i3);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.f6297a.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i3) {
            return this.f6297a.getFloat(i3);
        }

        @Override // android.database.Cursor
        public int getInt(int i3) {
            return this.f6297a.getInt(i3);
        }

        @Override // android.database.Cursor
        public long getLong(int i3) {
            return this.f6297a.getLong(i3);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return Z.c.a(this.f6297a);
        }

        @Override // android.database.Cursor
        public List getNotificationUris() {
            return Z.f.a(this.f6297a);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.f6297a.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i3) {
            return this.f6297a.getShort(i3);
        }

        @Override // android.database.Cursor
        public String getString(int i3) {
            return this.f6297a.getString(i3);
        }

        @Override // android.database.Cursor
        public int getType(int i3) {
            return this.f6297a.getType(i3);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.f6297a.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.f6297a.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.f6297a.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.f6297a.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.f6297a.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.f6297a.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i3) {
            return this.f6297a.isNull(i3);
        }

        @Override // android.database.Cursor
        public boolean move(int i3) {
            return this.f6297a.move(i3);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.f6297a.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.f6297a.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.f6297a.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i3) {
            return this.f6297a.moveToPosition(i3);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.f6297a.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.f6297a.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f6297a.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        public boolean requery() {
            return this.f6297a.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.f6297a.respond(bundle);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle bundle) {
            S1.k.e(bundle, "extras");
            Z.e.a(this.f6297a, bundle);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.f6297a.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        public void setNotificationUris(ContentResolver contentResolver, List list) {
            S1.k.e(contentResolver, "cr");
            S1.k.e(list, "uris");
            Z.f.b(this.f6297a, contentResolver, list);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.f6297a.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f6297a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public C0372d(Z.h hVar, C0371c c0371c) {
        S1.k.e(hVar, "delegate");
        S1.k.e(c0371c, "autoCloser");
        this.f6280a = hVar;
        this.f6281b = c0371c;
        c0371c.k(g());
        this.f6282c = new a(c0371c);
    }

    @Override // Z.h
    public Z.g A() {
        this.f6282c.g();
        return this.f6282c;
    }

    @Override // Z.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f6282c.close();
    }

    @Override // androidx.room.g
    public Z.h g() {
        return this.f6280a;
    }

    @Override // Z.h
    public String getDatabaseName() {
        return this.f6280a.getDatabaseName();
    }

    @Override // Z.h
    public void setWriteAheadLoggingEnabled(boolean z3) {
        this.f6280a.setWriteAheadLoggingEnabled(z3);
    }
}
