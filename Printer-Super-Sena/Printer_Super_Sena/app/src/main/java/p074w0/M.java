package p074w0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p050o0.h;
import p050o0.i;
import p050o0.o;
import p059r0.e;
import p059r0.f;

/* JADX INFO: loaded from: classes.dex */
public class M implements InterfaceC0721d, p077x0.b, InterfaceC0720c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final p044m0.b f12556f = p044m0.b.b("proto");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final U f12557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p080y0.a f12558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p080y0.a f12559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AbstractC0722e f12560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final I1.a f12561e;

    interface b {
        Object a(Object obj);
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f12562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f12563b;

        private c(String str, String str2) {
            this.f12562a = str;
            this.f12563b = str2;
        }
    }

    interface d {
        Object a();
    }

    M(p080y0.a aVar, p080y0.a aVar2, AbstractC0722e abstractC0722e, U u3, I1.a aVar3) {
        this.f12557a = u3;
        this.f12558b = aVar;
        this.f12559c = aVar2;
        this.f12560d = abstractC0722e;
        this.f12561e = aVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f A0(long j3, Cursor cursor) {
        cursor.moveToNext();
        return f.c().c(cursor.getLong(0)).b(j3).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f B0(final long j3, SQLiteDatabase sQLiteDatabase) {
        return (f) b1(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new b() { // from class: w0.D
            @Override // w0.M.b
            public final Object a(Object obj) {
                return M.A0(j3, (Cursor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long C0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean D0(o oVar, SQLiteDatabase sQLiteDatabase) {
        Long lQ0 = q0(sQLiteDatabase, oVar);
        return lQ0 == null ? Boolean.FALSE : (Boolean) b1(l0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lQ0.toString()}), new b() { // from class: w0.t
            @Override // w0.M.b
            public final Object a(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List E0(SQLiteDatabase sQLiteDatabase) {
        return (List) b1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: w0.q
            @Override // w0.M.b
            public final Object a(Object obj) {
                return M.F0((Cursor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List F0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(o.a().b(cursor.getString(1)).d(p083z0.a.b(cursor.getInt(2))).c(V0(cursor.getString(3))).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List G0(o oVar, SQLiteDatabase sQLiteDatabase) {
        List listT0 = T0(sQLiteDatabase, oVar, this.f12560d.d());
        for (p044m0.d dVar : p044m0.d.values()) {
            if (dVar != oVar.d()) {
                int iD = this.f12560d.d() - listT0.size();
                if (iD <= 0) {
                    break;
                }
                listT0.addAll(T0(sQLiteDatabase, oVar.f(dVar), iD));
            }
        }
        return t0(listT0, U0(sQLiteDatabase, listT0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ p059r0.a H0(Map map, p059r0.a.C0131a c0131a, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            r0.c.b bVarH0 = h0(cursor.getInt(1));
            long j3 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(p059r0.c.c().c(bVarH0).b(j3).a());
        }
        W0(c0131a, map);
        c0131a.e(p0());
        c0131a.d(m0());
        c0131a.c((String) this.f12561e.get());
        return c0131a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ p059r0.a I0(String str, final Map map, final p059r0.a.C0131a c0131a, SQLiteDatabase sQLiteDatabase) {
        return (p059r0.a) b1(sQLiteDatabase.rawQuery(str, new String[0]), new b() { // from class: w0.A
            @Override // w0.M.b
            public final Object a(Object obj) {
                return this.f12540a.H0(map, c0131a, (Cursor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object J0(List list, o oVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j3 = cursor.getLong(0);
            boolean z3 = cursor.getInt(7) != 0;
            i.a aVarK = i.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            if (z3) {
                aVarK.h(new h(Z0(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                aVarK.h(new h(Z0(cursor.getString(4)), X0(j3)));
            }
            if (!cursor.isNull(6)) {
                aVarK.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(AbstractC0728k.a(j3, oVar, aVarK.d()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object K0(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j3 = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j3));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j3), hashSet);
            }
            hashSet.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long L0(i iVar, o oVar, SQLiteDatabase sQLiteDatabase) {
        if (s0()) {
            G(1L, r0.c.b.CACHE_FULL, iVar.j());
            return -1L;
        }
        long jJ0 = j0(sQLiteDatabase, oVar);
        int iE = this.f12560d.e();
        byte[] bArrA = iVar.e().a();
        boolean z3 = bArrA.length <= iE;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(jJ0));
        contentValues.put("transport_name", iVar.j());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.k()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put("code", iVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z3));
        contentValues.put("payload", z3 ? bArrA : new byte[0]);
        long jInsert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z3) {
            double length = bArrA.length;
            double d3 = iE;
            Double.isNaN(length);
            Double.isNaN(d3);
            int iCeil = (int) Math.ceil(length / d3);
            for (int i3 = 1; i3 <= iCeil; i3++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrA, (i3 - 1) * iE, Math.min(i3 * iE, bArrA.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i3));
                contentValues2.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry entry : iVar.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(jInsert));
            contentValues3.put("name", (String) entry.getKey());
            contentValues3.put("value", (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(jInsert);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] M0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            byte[] bArr2 = (byte[]) arrayList.get(i3);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object N0(Cursor cursor) {
        while (cursor.moveToNext()) {
            G(cursor.getInt(0), r0.c.b.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object O0(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        b1(sQLiteDatabase.rawQuery(str2, null), new b() { // from class: w0.u
            @Override // w0.M.b
            public final Object a(Object obj) {
                return this.f12614a.N0((Cursor) obj);
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean P0(Cursor cursor) {
        return Boolean.valueOf(cursor.getCount() > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object Q0(String str, r0.c.b bVar, long j3, SQLiteDatabase sQLiteDatabase) {
        if (((Boolean) b1(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.a())}), new b() { // from class: w0.y
            @Override // w0.M.b
            public final Object a(Object obj) {
                return M.P0((Cursor) obj);
            }
        })).booleanValue()) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j3 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.a())});
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(bVar.a()));
            contentValues.put("events_dropped_count", Long.valueOf(j3));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object R0(long j3, o oVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j3));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{oVar.b(), String.valueOf(p083z0.a.a(oVar.d()))}) < 1) {
            contentValues.put("backend_name", oVar.b());
            contentValues.put("priority", Integer.valueOf(p083z0.a.a(oVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object S0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.f12558b.a()).execute();
        return null;
    }

    private List T0(SQLiteDatabase sQLiteDatabase, final o oVar, int i3) {
        final ArrayList arrayList = new ArrayList();
        Long lQ0 = q0(sQLiteDatabase, oVar);
        if (lQ0 == null) {
            return arrayList;
        }
        b1(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lQ0.toString()}, null, null, null, String.valueOf(i3)), new b() { // from class: w0.v
            @Override // w0.M.b
            public final Object a(Object obj) {
                return this.f12615a.J0(arrayList, oVar, (Cursor) obj);
            }
        });
        return arrayList;
    }

    private Map U0(SQLiteDatabase sQLiteDatabase, List list) {
        final HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i3 = 0; i3 < list.size(); i3++) {
            sb.append(((AbstractC0728k) list.get(i3)).c());
            if (i3 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        b1(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), new b() { // from class: w0.z
            @Override // w0.M.b
            public final Object a(Object obj) {
                return M.K0(map, (Cursor) obj);
            }
        });
        return map;
    }

    private static byte[] V0(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private void W0(p059r0.a.C0131a c0131a, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            c0131a.a(p059r0.d.c().c((String) entry.getKey()).b((List) entry.getValue()).a());
        }
    }

    private byte[] X0(long j3) {
        return (byte[]) b1(l0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j3)}, null, null, "sequence_num"), new b() { // from class: w0.B
            @Override // w0.M.b
            public final Object a(Object obj) {
                return M.M0((Cursor) obj);
            }
        });
    }

    private Object Y0(d dVar, b bVar) {
        long jA = this.f12559c.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e3) {
                if (this.f12559c.a() >= ((long) this.f12560d.b()) + jA) {
                    return bVar.a(e3);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    private static p044m0.b Z0(String str) {
        return str == null ? f12556f : p044m0.b.b(str);
    }

    private static String a1(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((AbstractC0728k) it.next()).c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    static Object b1(Cursor cursor, b bVar) {
        try {
            return bVar.a(cursor);
        } finally {
            cursor.close();
        }
    }

    private r0.c.b h0(int i3) {
        r0.c.b bVar = r0.c.b.REASON_UNKNOWN;
        if (i3 == bVar.a()) {
            return bVar;
        }
        r0.c.b bVar2 = r0.c.b.MESSAGE_TOO_OLD;
        if (i3 == bVar2.a()) {
            return bVar2;
        }
        r0.c.b bVar3 = r0.c.b.CACHE_FULL;
        if (i3 == bVar3.a()) {
            return bVar3;
        }
        r0.c.b bVar4 = r0.c.b.PAYLOAD_TOO_BIG;
        if (i3 == bVar4.a()) {
            return bVar4;
        }
        r0.c.b bVar5 = r0.c.b.MAX_RETRIES_REACHED;
        if (i3 == bVar5.a()) {
            return bVar5;
        }
        r0.c.b bVar6 = r0.c.b.INVALID_PAYLOD;
        if (i3 == bVar6.a()) {
            return bVar6;
        }
        r0.c.b bVar7 = r0.c.b.SERVER_ERROR;
        if (i3 == bVar7.a()) {
            return bVar7;
        }
        p062s0.a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i3));
        return bVar;
    }

    private void i0(final SQLiteDatabase sQLiteDatabase) {
        Y0(new d() { // from class: w0.l
            @Override // w0.M.d
            public final Object a() {
                return M.w0(sQLiteDatabase);
            }
        }, new b() { // from class: w0.w
            @Override // w0.M.b
            public final Object a(Object obj) {
                return M.x0((Throwable) obj);
            }
        });
    }

    private long j0(SQLiteDatabase sQLiteDatabase, o oVar) {
        Long lQ0 = q0(sQLiteDatabase, oVar);
        if (lQ0 != null) {
            return lQ0.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", oVar.b());
        contentValues.put("priority", Integer.valueOf(p083z0.a.a(oVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (oVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(oVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    private p059r0.b m0() {
        return p059r0.b.b().b(e.c().b(k0()).c(AbstractC0722e.f12595a.f()).a()).a();
    }

    private long n0() {
        return l0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private long o0() {
        return l0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private f p0() {
        final long jA = this.f12558b.a();
        return (f) r0(new b() { // from class: w0.C
            @Override // w0.M.b
            public final Object a(Object obj) {
                return M.B0(jA, (SQLiteDatabase) obj);
            }
        });
    }

    private Long q0(SQLiteDatabase sQLiteDatabase, o oVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(oVar.b(), String.valueOf(p083z0.a.a(oVar.d()))));
        if (oVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(oVar.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) b1(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new b() { // from class: w0.x
            @Override // w0.M.b
            public final Object a(Object obj) {
                return M.C0((Cursor) obj);
            }
        });
    }

    private boolean s0() {
        return n0() * o0() >= this.f12560d.f();
    }

    private List t0(List list, Map map) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            AbstractC0728k abstractC0728k = (AbstractC0728k) listIterator.next();
            if (map.containsKey(Long.valueOf(abstractC0728k.c()))) {
                i.a aVarL = abstractC0728k.b().l();
                for (c cVar : (Set) map.get(Long.valueOf(abstractC0728k.c()))) {
                    aVarL.c(cVar.f12562a, cVar.f12563b);
                }
                listIterator.set(AbstractC0728k.a(abstractC0728k.c(), abstractC0728k.d(), aVarL.d()));
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object u0(Cursor cursor) {
        while (cursor.moveToNext()) {
            G(cursor.getInt(0), r0.c.b.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer v0(long j3, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j3)};
        b1(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new b() { // from class: w0.r
            @Override // w0.M.b
            public final Object a(Object obj) {
                return this.f12609a.u0((Cursor) obj);
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object w0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object x0(Throwable th) {
        throw new p077x0.a("Timed out while trying to acquire the lock.", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SQLiteDatabase y0(Throwable th) {
        throw new p077x0.a("Timed out while trying to open db.", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long z0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    @Override // p074w0.InterfaceC0720c
    public void G(final long j3, final r0.c.b bVar, final String str) {
        r0(new b() { // from class: w0.p
            @Override // w0.M.b
            public final Object a(Object obj) {
                return M.Q0(str, bVar, j3, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // p074w0.InterfaceC0721d
    public Iterable H() {
        return (Iterable) r0(new b() { // from class: w0.H
            @Override // w0.M.b
            public final Object a(Object obj) {
                return M.E0((SQLiteDatabase) obj);
            }
        });
    }

    @Override // p074w0.InterfaceC0721d
    public int c() {
        final long jA = this.f12558b.a() - this.f12560d.c();
        return ((Integer) r0(new b() { // from class: w0.G
            @Override // w0.M.b
            public final Object a(Object obj) {
                return this.f12546a.v0(jA, (SQLiteDatabase) obj);
            }
        })).intValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12557a.close();
    }

    @Override // p074w0.InterfaceC0721d
    public Iterable d(final o oVar) {
        return (Iterable) r0(new b() { // from class: w0.K
            @Override // w0.M.b
            public final Object a(Object obj) {
                return this.f12551a.G0(oVar, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // p074w0.InterfaceC0721d
    public void e(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            l0().compileStatement("DELETE FROM events WHERE _id in " + a1(iterable)).execute();
        }
    }

    @Override // p074w0.InterfaceC0721d
    public boolean f(final o oVar) {
        return ((Boolean) r0(new b() { // from class: w0.m
            @Override // w0.M.b
            public final Object a(Object obj) {
                return this.f12601a.D0(oVar, (SQLiteDatabase) obj);
            }
        })).booleanValue();
    }

    @Override // p074w0.InterfaceC0720c
    public void g() {
        r0(new b() { // from class: w0.o
            @Override // w0.M.b
            public final Object a(Object obj) {
                return this.f12605a.S0((SQLiteDatabase) obj);
            }
        });
    }

    long k0() {
        return n0() * o0();
    }

    SQLiteDatabase l0() {
        final U u3 = this.f12557a;
        Objects.requireNonNull(u3);
        return (SQLiteDatabase) Y0(new d() { // from class: w0.E
            @Override // w0.M.d
            public final Object a() {
                return u3.getWritableDatabase();
            }
        }, new b() { // from class: w0.F
            @Override // w0.M.b
            public final Object a(Object obj) {
                return M.y0((Throwable) obj);
            }
        });
    }

    @Override // p074w0.InterfaceC0721d
    public long o(o oVar) {
        return ((Long) b1(l0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{oVar.b(), String.valueOf(p083z0.a.a(oVar.d()))}), new b() { // from class: w0.I
            @Override // w0.M.b
            public final Object a(Object obj) {
                return M.z0((Cursor) obj);
            }
        })).longValue();
    }

    Object r0(b bVar) {
        SQLiteDatabase sQLiteDatabaseL0 = l0();
        sQLiteDatabaseL0.beginTransaction();
        try {
            Object objA = bVar.a(sQLiteDatabaseL0);
            sQLiteDatabaseL0.setTransactionSuccessful();
            return objA;
        } finally {
            sQLiteDatabaseL0.endTransaction();
        }
    }

    @Override // p074w0.InterfaceC0721d
    public AbstractC0728k s(final o oVar, final i iVar) {
        p062s0.a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", oVar.d(), iVar.j(), oVar.b());
        long jLongValue = ((Long) r0(new b() { // from class: w0.L
            @Override // w0.M.b
            public final Object a(Object obj) {
                return this.f12553a.L0(iVar, oVar, (SQLiteDatabase) obj);
            }
        })).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return AbstractC0728k.a(jLongValue, oVar, iVar);
    }

    @Override // p074w0.InterfaceC0720c
    public p059r0.a t() {
        final p059r0.a.C0131a c0131aE = p059r0.a.e();
        final HashMap map = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (p059r0.a) r0(new b() { // from class: w0.s
            @Override // w0.M.b
            public final Object a(Object obj) {
                return this.f12610a.I0(str, map, c0131aE, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // p074w0.InterfaceC0721d
    public void v(final o oVar, final long j3) {
        r0(new b() { // from class: w0.n
            @Override // w0.M.b
            public final Object a(Object obj) {
                return M.R0(j3, oVar, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // p074w0.InterfaceC0721d
    public void w(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + a1(iterable);
            final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
            r0(new b() { // from class: w0.J
                @Override // w0.M.b
                public final Object a(Object obj) {
                    return this.f12548a.O0(str, str2, (SQLiteDatabase) obj);
                }
            });
        }
    }

    @Override // p077x0.b
    public Object y(x0.b.a aVar) {
        SQLiteDatabase sQLiteDatabaseL0 = l0();
        i0(sQLiteDatabaseL0);
        try {
            Object objA = aVar.a();
            sQLiteDatabaseL0.setTransactionSuccessful();
            return objA;
        } finally {
            sQLiteDatabaseL0.endTransaction();
        }
    }
}
