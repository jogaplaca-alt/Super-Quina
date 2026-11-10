package androidx.room;

import android.database.Cursor;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class w extends Z.h.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f6426g = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C0374f f6427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f6428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f6429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f6430f;

    public static final class a {
        public /* synthetic */ a(S1.g gVar) {
            this();
        }

        public final boolean a(Z.g gVar) throws IOException {
            S1.k.e(gVar, "db");
            Cursor cursorD = gVar.D("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                boolean z3 = false;
                if (cursorD.moveToFirst() && cursorD.getInt(0) == 0) {
                    z3 = true;
                }
                P1.a.a(cursorD, null);
                return z3;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    P1.a.a(cursorD, th);
                    throw th2;
                }
            }
        }

        public final boolean b(Z.g gVar) throws IOException {
            S1.k.e(gVar, "db");
            Cursor cursorD = gVar.D("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            try {
                boolean z3 = false;
                if (cursorD.moveToFirst() && cursorD.getInt(0) != 0) {
                    z3 = true;
                }
                P1.a.a(cursorD, null);
                return z3;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    P1.a.a(cursorD, th);
                    throw th2;
                }
            }
        }

        private a() {
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6431a;

        public b(int i3) {
            this.f6431a = i3;
        }

        public abstract void a(Z.g gVar);

        public abstract void b(Z.g gVar);

        public abstract void c(Z.g gVar);

        public abstract void d(Z.g gVar);

        public abstract void e(Z.g gVar);

        public abstract void f(Z.g gVar);

        public abstract c g(Z.g gVar);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f6432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f6433b;

        public c(boolean z3, String str) {
            this.f6432a = z3;
            this.f6433b = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(C0374f c0374f, b bVar, String str, String str2) {
        super(bVar.f6431a);
        S1.k.e(c0374f, "configuration");
        S1.k.e(bVar, "delegate");
        S1.k.e(str, "identityHash");
        S1.k.e(str2, "legacyHash");
        this.f6427c = c0374f;
        this.f6428d = bVar;
        this.f6429e = str;
        this.f6430f = str2;
    }

    private final void h(Z.g gVar) throws IOException {
        if (!f6426g.b(gVar)) {
            c cVarG = this.f6428d.g(gVar);
            if (cVarG.f6432a) {
                this.f6428d.e(gVar);
                j(gVar);
                return;
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + cVarG.f6433b);
            }
        }
        Cursor cursorC = gVar.C(new Z.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
        try {
            String string = cursorC.moveToFirst() ? cursorC.getString(0) : null;
            P1.a.a(cursorC, null);
            if (S1.k.a(this.f6429e, string) || S1.k.a(this.f6430f, string)) {
                return;
            }
            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + this.f6429e + ", found: " + string);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                P1.a.a(cursorC, th);
                throw th2;
            }
        }
    }

    private final void i(Z.g gVar) {
        gVar.j("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private final void j(Z.g gVar) {
        i(gVar);
        gVar.j(v.a(this.f6429e));
    }

    @Override // Z.h.a
    public void b(Z.g gVar) {
        S1.k.e(gVar, "db");
        super.b(gVar);
    }

    @Override // Z.h.a
    public void d(Z.g gVar) throws IOException {
        S1.k.e(gVar, "db");
        boolean zA = f6426g.a(gVar);
        this.f6428d.a(gVar);
        if (!zA) {
            c cVarG = this.f6428d.g(gVar);
            if (!cVarG.f6432a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + cVarG.f6433b);
            }
        }
        j(gVar);
        this.f6428d.c(gVar);
    }

    @Override // Z.h.a
    public void e(Z.g gVar, int i3, int i4) {
        S1.k.e(gVar, "db");
        g(gVar, i3, i4);
    }

    @Override // Z.h.a
    public void f(Z.g gVar) throws IOException {
        S1.k.e(gVar, "db");
        super.f(gVar);
        h(gVar);
        this.f6428d.d(gVar);
        this.f6427c = null;
    }

    @Override // Z.h.a
    public void g(Z.g gVar, int i3, int i4) {
        List listD;
        S1.k.e(gVar, "db");
        C0374f c0374f = this.f6427c;
        if (c0374f == null || (listD = c0374f.f6304d.d(i3, i4)) == null) {
            C0374f c0374f2 = this.f6427c;
            if (c0374f2 != null && !c0374f2.a(i3, i4)) {
                this.f6428d.b(gVar);
                this.f6428d.a(gVar);
                return;
            }
            throw new IllegalStateException("A migration from " + i3 + " to " + i4 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
        this.f6428d.f(gVar);
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            ((W.a) it.next()).a(gVar);
        }
        c cVarG = this.f6428d.g(gVar);
        if (cVarG.f6432a) {
            this.f6428d.e(gVar);
            j(gVar);
        } else {
            throw new IllegalStateException("Migration didn't properly handle: " + cVarG.f6433b);
        }
    }
}
