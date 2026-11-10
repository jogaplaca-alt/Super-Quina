package p074w0;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class U extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f12569c = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static int f12570d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final a f12571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final a f12572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final a f12573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final a f12574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final a f12575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final List f12576j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12578b;

    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        a aVar = new a() { // from class: w0.O
            @Override // w0.U.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                U.K(sQLiteDatabase);
            }
        };
        f12571e = aVar;
        a aVar2 = new a() { // from class: w0.P
            @Override // w0.U.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                U.L(sQLiteDatabase);
            }
        };
        f12572f = aVar2;
        a aVar3 = new a() { // from class: w0.Q
            @Override // w0.U.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
            }
        };
        f12573g = aVar3;
        a aVar4 = new a() { // from class: w0.S
            @Override // w0.U.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                U.N(sQLiteDatabase);
            }
        };
        f12574h = aVar4;
        a aVar5 = new a() { // from class: w0.T
            @Override // w0.U.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                U.O(sQLiteDatabase);
            }
        };
        f12575i = aVar5;
        f12576j = Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    U(Context context, String str, int i3) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i3);
        this.f12578b = false;
        this.f12577a = i3;
    }

    private void J(SQLiteDatabase sQLiteDatabase) {
        if (this.f12578b) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f12569c);
    }

    private void P(SQLiteDatabase sQLiteDatabase, int i3) {
        J(sQLiteDatabase);
        Q(sQLiteDatabase, 0, i3);
    }

    private void Q(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        List list = f12576j;
        if (i4 <= list.size()) {
            while (i3 < i4) {
                ((a) f12576j.get(i3)).a(sQLiteDatabase);
                i3++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i3 + " to " + i4 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f12578b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        P(sQLiteDatabase, this.f12577a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        P(sQLiteDatabase, i4);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        J(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        J(sQLiteDatabase);
        Q(sQLiteDatabase, i3, i4);
    }
}
