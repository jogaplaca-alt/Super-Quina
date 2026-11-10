package Z;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface h extends Closeable {

    public static abstract class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0033a f2162b = new C0033a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2163a;

        /* JADX INFO: renamed from: Z.h$a$a, reason: collision with other inner class name */
        public static final class C0033a {
            public /* synthetic */ C0033a(S1.g gVar) {
                this();
            }

            private C0033a() {
            }
        }

        public a(int i3) {
            this.f2163a = i3;
        }

        private final void a(String str) {
            if (X1.c.d(str, ":memory:", true)) {
                return;
            }
            int length = str.length() - 1;
            int i3 = 0;
            boolean z3 = false;
            while (i3 <= length) {
                boolean z4 = S1.k.f(str.charAt(!z3 ? i3 : length), 32) <= 0;
                if (z3) {
                    if (!z4) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z4) {
                    i3++;
                } else {
                    z3 = true;
                }
            }
            if (str.subSequence(i3, length + 1).toString().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                Z.b.a(new File(str));
            } catch (Exception e3) {
                Log.w("SupportSQLite", "delete failed: ", e3);
            }
        }

        public void b(g gVar) {
            S1.k.e(gVar, "db");
        }

        public void c(g gVar) {
            S1.k.e(gVar, "db");
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + gVar + ".path");
            if (!gVar.isOpen()) {
                String strE = gVar.E();
                if (strE != null) {
                    a(strE);
                    return;
                }
                return;
            }
            List listH = null;
            try {
                try {
                    listH = gVar.h();
                } catch (SQLiteException unused) {
                }
                try {
                    gVar.close();
                } catch (IOException unused2) {
                }
                if (listH != null) {
                    return;
                }
            } finally {
                if (listH != null) {
                    Iterator it = listH.iterator();
                    while (it.hasNext()) {
                        Object obj = ((Pair) it.next()).second;
                        S1.k.d(obj, "p.second");
                        a((String) obj);
                    }
                } else {
                    String strE2 = gVar.E();
                    if (strE2 != null) {
                        a(strE2);
                    }
                }
            }
        }

        public abstract void d(g gVar);

        public abstract void e(g gVar, int i3, int i4);

        public void f(g gVar) {
            S1.k.e(gVar, "db");
        }

        public abstract void g(g gVar, int i3, int i4);
    }

    public static final class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0034b f2164f = new C0034b(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f2165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f2167c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f2168d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f2169e;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Context f2170a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f2171b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private a f2172c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f2173d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private boolean f2174e;

            public a(Context context) {
                S1.k.e(context, "context");
                this.f2170a = context;
            }

            public b a() {
                String str;
                a aVar = this.f2172c;
                if (aVar == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.f2173d && ((str = this.f2171b) == null || str.length() == 0)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new b(this.f2170a, this.f2171b, aVar, this.f2173d, this.f2174e);
            }

            public a b(a aVar) {
                S1.k.e(aVar, "callback");
                this.f2172c = aVar;
                return this;
            }

            public a c(String str) {
                this.f2171b = str;
                return this;
            }
        }

        /* JADX INFO: renamed from: Z.h$b$b, reason: collision with other inner class name */
        public static final class C0034b {
            public /* synthetic */ C0034b(S1.g gVar) {
                this();
            }

            public final a a(Context context) {
                S1.k.e(context, "context");
                return new a(context);
            }

            private C0034b() {
            }
        }

        public b(Context context, String str, a aVar, boolean z3, boolean z4) {
            S1.k.e(context, "context");
            S1.k.e(aVar, "callback");
            this.f2165a = context;
            this.f2166b = str;
            this.f2167c = aVar;
            this.f2168d = z3;
            this.f2169e = z4;
        }

        public static final a a(Context context) {
            return f2164f.a(context);
        }
    }

    public interface c {
        h a(b bVar);
    }

    g A();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    void setWriteAheadLoggingEnabled(boolean z3);
}
