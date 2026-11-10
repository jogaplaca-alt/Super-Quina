package ru.a402d.rawbtprinter;

import X.d;
import Z.g;
import Z.h;
import androidx.appcompat.app.H;
import androidx.room.C0374f;
import androidx.room.o;
import androidx.room.u;
import androidx.room.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import n2.b;
import rawbt.api.RawbtPrintJob;
import rawbt.api.RawbtResponse;
import rawbt.sdk.dao.PrintersModel;
import rawbt.sdk.dao.PrintersModel_Impl;

/* JADX INFO: loaded from: classes.dex */
public final class AppDatabase_Impl extends AppDatabase {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private volatile n2.a f11259r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private volatile PrintersModel f11260s;

    @Override // ru.a402d.rawbtprinter.AppDatabase
    public n2.a C() {
        n2.a aVar;
        if (this.f11259r != null) {
            return this.f11259r;
        }
        synchronized (this) {
            try {
                if (this.f11259r == null) {
                    this.f11259r = new b(this);
                }
                aVar = this.f11259r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    @Override // ru.a402d.rawbtprinter.AppDatabase
    public PrintersModel D() {
        PrintersModel printersModel;
        if (this.f11260s != null) {
            return this.f11260s;
        }
        synchronized (this) {
            try {
                if (this.f11260s == null) {
                    this.f11260s = new PrintersModel_Impl(this);
                }
                printersModel = this.f11260s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return printersModel;
    }

    @Override // androidx.room.u
    protected o g() {
        return new o(this, new HashMap(0), new HashMap(0), "console_history", RawbtResponse.RESPONSE_PRINTERS);
    }

    @Override // androidx.room.u
    protected h h(C0374f c0374f) {
        return c0374f.f6303c.a(h.b.a(c0374f.f6301a).c(c0374f.f6302b).b(new w(c0374f, new a(3), "9d3040f9a93c65ca9f21228984cd5b94", "e62f64377f43a33bbbb030a85b9a3863")).a());
    }

    @Override // androidx.room.u
    public List j(Map map) {
        return new ArrayList();
    }

    @Override // androidx.room.u
    public Set o() {
        return new HashSet();
    }

    @Override // androidx.room.u
    protected Map p() {
        HashMap map = new HashMap();
        map.put(n2.a.class, b.e());
        map.put(PrintersModel.class, PrintersModel_Impl.getRequiredConverters());
        return map;
    }

    class a extends w.b {
        a(int i3) {
            super(i3);
        }

        @Override // androidx.room.w.b
        public void a(g gVar) {
            gVar.j("CREATE TABLE IF NOT EXISTS `console_history` (`data` TEXT, `codePage` TEXT, `mode` INTEGER NOT NULL, `howLF` INTEGER NOT NULL, `hash` INTEGER NOT NULL, `lastSend` INTEGER NOT NULL, PRIMARY KEY(`hash`))");
            gVar.j("CREATE UNIQUE INDEX IF NOT EXISTS `index_console_history_hash` ON `console_history` (`hash`)");
            gVar.j("CREATE INDEX IF NOT EXISTS `index_console_history_lastSend` ON `console_history` (`lastSend`)");
            gVar.j("CREATE TABLE IF NOT EXISTS `printers` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `description` TEXT, `current` INTEGER NOT NULL, `protocol` INTEGER NOT NULL, `mac` TEXT, `host` TEXT, `port` INTEGER NOT NULL, `vid` TEXT, `pid` TEXT, `baud` INTEGER NOT NULL, `serialComDriver` TEXT, `profileClass` TEXT, `dots` INTEGER NOT NULL, `dpi` INTEGER NOT NULL, `printLanguageType` INTEGER NOT NULL, `printLanguage` TEXT, `codePage` TEXT, `graphicsCommand` INTEGER NOT NULL, `skipLinesAfterJob` INTEGER NOT NULL, `cutCommand` INTEGER NOT NULL, `pulseCommand` INTEGER NOT NULL, `addFrame` INTEGER NOT NULL, `sleepAfter` INTEGER NOT NULL, `lan_delayMS` INTEGER NOT NULL, `abs` INTEGER NOT NULL, `darkness` INTEGER NOT NULL, `bytes_init` TEXT, `bytes_finish` TEXT, `pageName` TEXT, `useDithering` INTEGER NOT NULL)");
            gVar.j("CREATE UNIQUE INDEX IF NOT EXISTS `index_printers_id` ON `printers` (`id`)");
            gVar.j("CREATE UNIQUE INDEX IF NOT EXISTS `index_printers_name` ON `printers` (`name`)");
            gVar.j("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.j("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9d3040f9a93c65ca9f21228984cd5b94')");
        }

        @Override // androidx.room.w.b
        public void b(g gVar) {
            gVar.j("DROP TABLE IF EXISTS `console_history`");
            gVar.j("DROP TABLE IF EXISTS `printers`");
            List list = ((u) AppDatabase_Impl.this).f6389h;
            if (list != null) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    H.a(it.next());
                    throw null;
                }
            }
        }

        @Override // androidx.room.w.b
        public void c(g gVar) {
            List list = ((u) AppDatabase_Impl.this).f6389h;
            if (list != null) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    H.a(it.next());
                    throw null;
                }
            }
        }

        @Override // androidx.room.w.b
        public void d(g gVar) {
            ((u) AppDatabase_Impl.this).f6382a = gVar;
            AppDatabase_Impl.this.v(gVar);
            List list = ((u) AppDatabase_Impl.this).f6389h;
            if (list != null) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    H.a(it.next());
                    throw null;
                }
            }
        }

        @Override // androidx.room.w.b
        public void f(g gVar) throws IOException {
            X.b.a(gVar);
        }

        @Override // androidx.room.w.b
        public w.c g(g gVar) {
            HashMap map = new HashMap(6);
            map.put("data", new d.a("data", "TEXT", false, 0, null, 1));
            map.put("codePage", new d.a("codePage", "TEXT", false, 0, null, 1));
            map.put("mode", new d.a("mode", "INTEGER", true, 0, null, 1));
            map.put("howLF", new d.a("howLF", "INTEGER", true, 0, null, 1));
            map.put("hash", new d.a("hash", "INTEGER", true, 1, null, 1));
            map.put("lastSend", new d.a("lastSend", "INTEGER", true, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new d.e("index_console_history_hash", true, Arrays.asList("hash"), Arrays.asList("ASC")));
            hashSet2.add(new d.e("index_console_history_lastSend", false, Arrays.asList("lastSend"), Arrays.asList("ASC")));
            d dVar = new d("console_history", map, hashSet, hashSet2);
            d dVarA = d.a(gVar, "console_history");
            if (!dVar.equals(dVarA)) {
                return new w.c(false, "console_history(ru.a402d.dao.SendItem).\n Expected:\n" + dVar + "\n Found:\n" + dVarA);
            }
            HashMap map2 = new HashMap(31);
            map2.put("id", new d.a("id", "INTEGER", true, 1, null, 1));
            map2.put("name", new d.a("name", "TEXT", false, 0, null, 1));
            map2.put("description", new d.a("description", "TEXT", false, 0, null, 1));
            map2.put(RawbtPrintJob.PRINTER_CURRENT, new d.a(RawbtPrintJob.PRINTER_CURRENT, "INTEGER", true, 0, null, 1));
            map2.put("protocol", new d.a("protocol", "INTEGER", true, 0, null, 1));
            map2.put("mac", new d.a("mac", "TEXT", false, 0, null, 1));
            map2.put("host", new d.a("host", "TEXT", false, 0, null, 1));
            map2.put("port", new d.a("port", "INTEGER", true, 0, null, 1));
            map2.put("vid", new d.a("vid", "TEXT", false, 0, null, 1));
            map2.put("pid", new d.a("pid", "TEXT", false, 0, null, 1));
            map2.put("baud", new d.a("baud", "INTEGER", true, 0, null, 1));
            map2.put("serialComDriver", new d.a("serialComDriver", "TEXT", false, 0, null, 1));
            map2.put("profileClass", new d.a("profileClass", "TEXT", false, 0, null, 1));
            map2.put("dots", new d.a("dots", "INTEGER", true, 0, null, 1));
            map2.put("dpi", new d.a("dpi", "INTEGER", true, 0, null, 1));
            map2.put("printLanguageType", new d.a("printLanguageType", "INTEGER", true, 0, null, 1));
            map2.put("printLanguage", new d.a("printLanguage", "TEXT", false, 0, null, 1));
            map2.put("codePage", new d.a("codePage", "TEXT", false, 0, null, 1));
            map2.put("graphicsCommand", new d.a("graphicsCommand", "INTEGER", true, 0, null, 1));
            map2.put("skipLinesAfterJob", new d.a("skipLinesAfterJob", "INTEGER", true, 0, null, 1));
            map2.put("cutCommand", new d.a("cutCommand", "INTEGER", true, 0, null, 1));
            map2.put("pulseCommand", new d.a("pulseCommand", "INTEGER", true, 0, null, 1));
            map2.put("addFrame", new d.a("addFrame", "INTEGER", true, 0, null, 1));
            map2.put("sleepAfter", new d.a("sleepAfter", "INTEGER", true, 0, null, 1));
            map2.put("lan_delayMS", new d.a("lan_delayMS", "INTEGER", true, 0, null, 1));
            map2.put("abs", new d.a("abs", "INTEGER", true, 0, null, 1));
            map2.put("darkness", new d.a("darkness", "INTEGER", true, 0, null, 1));
            map2.put("bytes_init", new d.a("bytes_init", "TEXT", false, 0, null, 1));
            map2.put("bytes_finish", new d.a("bytes_finish", "TEXT", false, 0, null, 1));
            map2.put("pageName", new d.a("pageName", "TEXT", false, 0, null, 1));
            map2.put("useDithering", new d.a("useDithering", "INTEGER", true, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new d.e("index_printers_id", true, Arrays.asList("id"), Arrays.asList("ASC")));
            hashSet4.add(new d.e("index_printers_name", true, Arrays.asList("name"), Arrays.asList("ASC")));
            d dVar2 = new d(RawbtResponse.RESPONSE_PRINTERS, map2, hashSet3, hashSet4);
            d dVarA2 = d.a(gVar, RawbtResponse.RESPONSE_PRINTERS);
            if (dVar2.equals(dVarA2)) {
                return new w.c(true, null);
            }
            return new w.c(false, "printers(rawbt.sdk.dao.PrinterEntity).\n Expected:\n" + dVar2 + "\n Found:\n" + dVarA2);
        }

        @Override // androidx.room.w.b
        public void e(g gVar) {
        }
    }
}
