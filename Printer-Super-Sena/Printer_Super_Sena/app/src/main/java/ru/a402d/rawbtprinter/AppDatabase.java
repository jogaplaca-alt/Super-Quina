package ru.a402d.rawbtprinter;

import Z.g;
import androidx.room.u;
import rawbt.sdk.dao.PrintersModel;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppDatabase extends u {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final W.a f11257p = new a(1, 2);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final W.a f11258q = new b(2, 3);

    class a extends W.a {
        a(int i3, int i4) {
            super(i3, i4);
        }

        @Override // W.a
        public void a(g gVar) {
            gVar.j("CREATE TABLE IF NOT EXISTS `console_history` (`data` TEXT, `codePage` TEXT, `mode` INTEGER NOT NULL, `howLF` INTEGER NOT NULL, `hash` INTEGER NOT NULL, `lastSend` INTEGER NOT NULL, PRIMARY KEY(`hash`))");
            gVar.j("CREATE UNIQUE INDEX IF NOT EXISTS `index_console_history_hash` ON `console_history` (`hash`)");
            gVar.j("CREATE INDEX IF NOT EXISTS `index_console_history_lastSend` ON `console_history` (`lastSend`)");
        }
    }

    class b extends W.a {
        b(int i3, int i4) {
            super(i3, i4);
        }

        @Override // W.a
        public void a(g gVar) {
            gVar.j("CREATE TABLE IF NOT EXISTS `printers` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `description` TEXT, `current` INTEGER NOT NULL, `protocol` INTEGER NOT NULL, `mac` TEXT, `host` TEXT, `port` INTEGER NOT NULL, `vid` TEXT, `pid` TEXT, `baud` INTEGER NOT NULL, `serialComDriver` TEXT, `profileClass` TEXT, `dots` INTEGER NOT NULL, `dpi` INTEGER NOT NULL, `printLanguageType` INTEGER NOT NULL, `printLanguage` TEXT, `codePage` TEXT, `graphicsCommand` INTEGER NOT NULL, `skipLinesAfterJob` INTEGER NOT NULL, `cutCommand` INTEGER NOT NULL, `pulseCommand` INTEGER NOT NULL, `addFrame` INTEGER NOT NULL, `sleepAfter` INTEGER NOT NULL, `lan_delayMS` INTEGER NOT NULL, `abs` INTEGER NOT NULL, `darkness` INTEGER NOT NULL, `bytes_init` TEXT, `bytes_finish` TEXT, `pageName` TEXT, `useDithering` INTEGER NOT NULL)");
            gVar.j("CREATE UNIQUE INDEX IF NOT EXISTS `index_printers_id` ON `printers` (`id`)");
            gVar.j("CREATE UNIQUE INDEX IF NOT EXISTS `index_printers_name` ON `printers` (`name`)");
        }
    }

    public abstract n2.a C();

    public abstract PrintersModel D();
}
