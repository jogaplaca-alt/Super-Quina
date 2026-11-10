package rawbt.sdk.dao;

import X.a;
import X.b;
import Z.k;
import android.database.Cursor;
import androidx.lifecycle.AbstractC0360s;
import androidx.room.D;
import androidx.room.h;
import androidx.room.i;
import androidx.room.u;
import androidx.room.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import rawbt.api.RawbtPrintJob;
import rawbt.api.RawbtResponse;

/* JADX INFO: loaded from: classes.dex */
public final class PrintersModel_Impl implements PrintersModel {
    private final u __db;
    private final h __deletionAdapterOfPrinterEntity;
    private final i __insertionAdapterOfPrinterEntity;
    private final D __preparedStmtOfSetDefault;
    private final D __preparedStmtOfStoreLastPrintParam;
    private final h __updateAdapterOfPrinterEntity;

    public PrintersModel_Impl(u uVar) {
        this.__db = uVar;
        this.__insertionAdapterOfPrinterEntity = new i(uVar) { // from class: rawbt.sdk.dao.PrintersModel_Impl.1
            @Override // androidx.room.D
            protected String createQuery() {
                return "INSERT OR ABORT INTO `printers` (`id`,`name`,`description`,`current`,`protocol`,`mac`,`host`,`port`,`vid`,`pid`,`baud`,`serialComDriver`,`profileClass`,`dots`,`dpi`,`printLanguageType`,`printLanguage`,`codePage`,`graphicsCommand`,`skipLinesAfterJob`,`cutCommand`,`pulseCommand`,`addFrame`,`sleepAfter`,`lan_delayMS`,`abs`,`darkness`,`bytes_init`,`bytes_finish`,`pageName`,`useDithering`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.i
            public void bind(k kVar, PrinterEntity printerEntity) {
                kVar.l(1, printerEntity.getId());
                if (printerEntity.getName() == null) {
                    kVar.x(2);
                } else {
                    kVar.k(2, printerEntity.getName());
                }
                if (printerEntity.getDescription() == null) {
                    kVar.x(3);
                } else {
                    kVar.k(3, printerEntity.getDescription());
                }
                kVar.l(4, printerEntity.isCurrent() ? 1L : 0L);
                kVar.l(5, printerEntity.getProtocol());
                if (printerEntity.getMac() == null) {
                    kVar.x(6);
                } else {
                    kVar.k(6, printerEntity.getMac());
                }
                if (printerEntity.getHost() == null) {
                    kVar.x(7);
                } else {
                    kVar.k(7, printerEntity.getHost());
                }
                kVar.l(8, printerEntity.getPort());
                if (printerEntity.getVid() == null) {
                    kVar.x(9);
                } else {
                    kVar.k(9, printerEntity.getVid());
                }
                if (printerEntity.getPid() == null) {
                    kVar.x(10);
                } else {
                    kVar.k(10, printerEntity.getPid());
                }
                kVar.l(11, printerEntity.getBaud());
                if (printerEntity.getSerialComDriver() == null) {
                    kVar.x(12);
                } else {
                    kVar.k(12, printerEntity.getSerialComDriver());
                }
                if (printerEntity.getProfileClass() == null) {
                    kVar.x(13);
                } else {
                    kVar.k(13, printerEntity.getProfileClass());
                }
                kVar.l(14, printerEntity.dots);
                kVar.l(15, printerEntity.dpi);
                kVar.l(16, printerEntity.getPrintLanguageType());
                if (printerEntity.getPrintLanguage() == null) {
                    kVar.x(17);
                } else {
                    kVar.k(17, printerEntity.getPrintLanguage());
                }
                if (printerEntity.getCodePage() == null) {
                    kVar.x(18);
                } else {
                    kVar.k(18, printerEntity.getCodePage());
                }
                kVar.l(19, printerEntity.getGraphicsCommand());
                kVar.l(20, printerEntity.getSkipLinesAfterJob());
                kVar.l(21, printerEntity.getCutCommand());
                kVar.l(22, printerEntity.pulseCommand);
                kVar.l(23, printerEntity.isAddFrame() ? 1L : 0L);
                kVar.l(24, printerEntity.sleepAfter);
                kVar.l(25, printerEntity.lan_delayMS);
                kVar.l(26, printerEntity.abs);
                kVar.l(27, printerEntity.getDarkness());
                if (printerEntity.getBytes_init() == null) {
                    kVar.x(28);
                } else {
                    kVar.k(28, printerEntity.getBytes_init());
                }
                if (printerEntity.getBytes_finish() == null) {
                    kVar.x(29);
                } else {
                    kVar.k(29, printerEntity.getBytes_finish());
                }
                if (printerEntity.getPageName() == null) {
                    kVar.x(30);
                } else {
                    kVar.k(30, printerEntity.getPageName());
                }
                kVar.l(31, printerEntity.isUseDithering() ? 1L : 0L);
            }
        };
        this.__deletionAdapterOfPrinterEntity = new h(uVar) { // from class: rawbt.sdk.dao.PrintersModel_Impl.2
            @Override // androidx.room.D
            protected String createQuery() {
                return "DELETE FROM `printers` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.h
            public void bind(k kVar, PrinterEntity printerEntity) {
                kVar.l(1, printerEntity.getId());
            }
        };
        this.__updateAdapterOfPrinterEntity = new h(uVar) { // from class: rawbt.sdk.dao.PrintersModel_Impl.3
            @Override // androidx.room.D
            protected String createQuery() {
                return "UPDATE OR ABORT `printers` SET `id` = ?,`name` = ?,`description` = ?,`current` = ?,`protocol` = ?,`mac` = ?,`host` = ?,`port` = ?,`vid` = ?,`pid` = ?,`baud` = ?,`serialComDriver` = ?,`profileClass` = ?,`dots` = ?,`dpi` = ?,`printLanguageType` = ?,`printLanguage` = ?,`codePage` = ?,`graphicsCommand` = ?,`skipLinesAfterJob` = ?,`cutCommand` = ?,`pulseCommand` = ?,`addFrame` = ?,`sleepAfter` = ?,`lan_delayMS` = ?,`abs` = ?,`darkness` = ?,`bytes_init` = ?,`bytes_finish` = ?,`pageName` = ?,`useDithering` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.h
            public void bind(k kVar, PrinterEntity printerEntity) {
                kVar.l(1, printerEntity.getId());
                if (printerEntity.getName() == null) {
                    kVar.x(2);
                } else {
                    kVar.k(2, printerEntity.getName());
                }
                if (printerEntity.getDescription() == null) {
                    kVar.x(3);
                } else {
                    kVar.k(3, printerEntity.getDescription());
                }
                kVar.l(4, printerEntity.isCurrent() ? 1L : 0L);
                kVar.l(5, printerEntity.getProtocol());
                if (printerEntity.getMac() == null) {
                    kVar.x(6);
                } else {
                    kVar.k(6, printerEntity.getMac());
                }
                if (printerEntity.getHost() == null) {
                    kVar.x(7);
                } else {
                    kVar.k(7, printerEntity.getHost());
                }
                kVar.l(8, printerEntity.getPort());
                if (printerEntity.getVid() == null) {
                    kVar.x(9);
                } else {
                    kVar.k(9, printerEntity.getVid());
                }
                if (printerEntity.getPid() == null) {
                    kVar.x(10);
                } else {
                    kVar.k(10, printerEntity.getPid());
                }
                kVar.l(11, printerEntity.getBaud());
                if (printerEntity.getSerialComDriver() == null) {
                    kVar.x(12);
                } else {
                    kVar.k(12, printerEntity.getSerialComDriver());
                }
                if (printerEntity.getProfileClass() == null) {
                    kVar.x(13);
                } else {
                    kVar.k(13, printerEntity.getProfileClass());
                }
                kVar.l(14, printerEntity.dots);
                kVar.l(15, printerEntity.dpi);
                kVar.l(16, printerEntity.getPrintLanguageType());
                if (printerEntity.getPrintLanguage() == null) {
                    kVar.x(17);
                } else {
                    kVar.k(17, printerEntity.getPrintLanguage());
                }
                if (printerEntity.getCodePage() == null) {
                    kVar.x(18);
                } else {
                    kVar.k(18, printerEntity.getCodePage());
                }
                kVar.l(19, printerEntity.getGraphicsCommand());
                kVar.l(20, printerEntity.getSkipLinesAfterJob());
                kVar.l(21, printerEntity.getCutCommand());
                kVar.l(22, printerEntity.pulseCommand);
                kVar.l(23, printerEntity.isAddFrame() ? 1L : 0L);
                kVar.l(24, printerEntity.sleepAfter);
                kVar.l(25, printerEntity.lan_delayMS);
                kVar.l(26, printerEntity.abs);
                kVar.l(27, printerEntity.getDarkness());
                if (printerEntity.getBytes_init() == null) {
                    kVar.x(28);
                } else {
                    kVar.k(28, printerEntity.getBytes_init());
                }
                if (printerEntity.getBytes_finish() == null) {
                    kVar.x(29);
                } else {
                    kVar.k(29, printerEntity.getBytes_finish());
                }
                if (printerEntity.getPageName() == null) {
                    kVar.x(30);
                } else {
                    kVar.k(30, printerEntity.getPageName());
                }
                kVar.l(31, printerEntity.isUseDithering() ? 1L : 0L);
                kVar.l(32, printerEntity.getId());
            }
        };
        this.__preparedStmtOfSetDefault = new D(uVar) { // from class: rawbt.sdk.dao.PrintersModel_Impl.4
            @Override // androidx.room.D
            public String createQuery() {
                return "UPDATE printers SET current = CASE WHEN id = ? THEN 1 ELSE 0 END ";
            }
        };
        this.__preparedStmtOfStoreLastPrintParam = new D(uVar) { // from class: rawbt.sdk.dao.PrintersModel_Impl.5
            @Override // androidx.room.D
            public String createQuery() {
                return "UPDATE printers SET pageName = ?, useDithering = ?  WHERE name = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // rawbt.sdk.dao.PrintersModel
    public void delete(PrinterEntity printerEntity) {
        this.__db.d();
        this.__db.e();
        try {
            this.__deletionAdapterOfPrinterEntity.handle(printerEntity);
            this.__db.A();
        } finally {
            this.__db.i();
        }
    }

    @Override // rawbt.sdk.dao.PrintersModel
    public List<PrinterEntity> getAll() throws Throwable {
        x xVar;
        x xVarY = x.y("SELECT * from printers ORDER BY id DESC", 0);
        this.__db.d();
        Cursor cursorB = b.b(this.__db, xVarY, false, null);
        try {
            int iE = a.e(cursorB, "id");
            int iE2 = a.e(cursorB, "name");
            int iE3 = a.e(cursorB, "description");
            int iE4 = a.e(cursorB, RawbtPrintJob.PRINTER_CURRENT);
            int iE5 = a.e(cursorB, "protocol");
            int iE6 = a.e(cursorB, "mac");
            int iE7 = a.e(cursorB, "host");
            int iE8 = a.e(cursorB, "port");
            int iE9 = a.e(cursorB, "vid");
            int iE10 = a.e(cursorB, "pid");
            int iE11 = a.e(cursorB, "baud");
            int iE12 = a.e(cursorB, "serialComDriver");
            int iE13 = a.e(cursorB, "profileClass");
            int iE14 = a.e(cursorB, "dots");
            xVar = xVarY;
            try {
                int iE15 = a.e(cursorB, "dpi");
                int iE16 = a.e(cursorB, "printLanguageType");
                int iE17 = a.e(cursorB, "printLanguage");
                int iE18 = a.e(cursorB, "codePage");
                int iE19 = a.e(cursorB, "graphicsCommand");
                int iE20 = a.e(cursorB, "skipLinesAfterJob");
                int iE21 = a.e(cursorB, "cutCommand");
                int iE22 = a.e(cursorB, "pulseCommand");
                int iE23 = a.e(cursorB, "addFrame");
                int iE24 = a.e(cursorB, "sleepAfter");
                int iE25 = a.e(cursorB, "lan_delayMS");
                int iE26 = a.e(cursorB, "abs");
                int iE27 = a.e(cursorB, "darkness");
                int iE28 = a.e(cursorB, "bytes_init");
                int iE29 = a.e(cursorB, "bytes_finish");
                int iE30 = a.e(cursorB, "pageName");
                int iE31 = a.e(cursorB, "useDithering");
                int i3 = iE14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    PrinterEntity printerEntity = new PrinterEntity();
                    ArrayList arrayList2 = arrayList;
                    printerEntity.setId(cursorB.getInt(iE));
                    printerEntity.setName(cursorB.isNull(iE2) ? null : cursorB.getString(iE2));
                    printerEntity.setDescription(cursorB.isNull(iE3) ? null : cursorB.getString(iE3));
                    printerEntity.setCurrent(cursorB.getInt(iE4) != 0);
                    printerEntity.setProtocol(cursorB.getInt(iE5));
                    printerEntity.setMac(cursorB.isNull(iE6) ? null : cursorB.getString(iE6));
                    printerEntity.setHost(cursorB.isNull(iE7) ? null : cursorB.getString(iE7));
                    printerEntity.setPort(cursorB.getInt(iE8));
                    printerEntity.setVid(cursorB.isNull(iE9) ? null : cursorB.getString(iE9));
                    printerEntity.setPid(cursorB.isNull(iE10) ? null : cursorB.getString(iE10));
                    printerEntity.setBaud(cursorB.getInt(iE11));
                    printerEntity.setSerialComDriver(cursorB.isNull(iE12) ? null : cursorB.getString(iE12));
                    printerEntity.setProfileClass(cursorB.isNull(iE13) ? null : cursorB.getString(iE13));
                    int i4 = i3;
                    int i5 = iE;
                    printerEntity.dots = cursorB.getInt(i4);
                    int i6 = iE15;
                    int i7 = iE12;
                    printerEntity.dpi = cursorB.getInt(i6);
                    int i8 = iE16;
                    printerEntity.setPrintLanguageType(cursorB.getInt(i8));
                    int i9 = iE17;
                    printerEntity.setPrintLanguage(cursorB.isNull(i9) ? null : cursorB.getString(i9));
                    iE18 = iE18;
                    printerEntity.setCodePage(cursorB.isNull(iE18) ? null : cursorB.getString(iE18));
                    int i10 = iE19;
                    printerEntity.setGraphicsCommand(cursorB.getInt(i10));
                    iE19 = i10;
                    int i11 = iE20;
                    printerEntity.setSkipLinesAfterJob(cursorB.getInt(i11));
                    iE20 = i11;
                    int i12 = iE21;
                    printerEntity.setCutCommand(cursorB.getInt(i12));
                    iE21 = i12;
                    int i13 = iE22;
                    printerEntity.pulseCommand = cursorB.getInt(i13);
                    int i14 = iE23;
                    iE23 = i14;
                    printerEntity.setAddFrame(cursorB.getInt(i14) != 0);
                    iE22 = i13;
                    int i15 = iE24;
                    printerEntity.setSleepAfter(cursorB.getInt(i15));
                    iE24 = i15;
                    int i16 = iE25;
                    printerEntity.setLan_delayMS(cursorB.getInt(i16));
                    iE25 = i16;
                    int i17 = iE26;
                    printerEntity.abs = cursorB.getInt(i17);
                    iE26 = i17;
                    int i18 = iE27;
                    printerEntity.setDarkness(cursorB.getInt(i18));
                    iE28 = iE28;
                    printerEntity.setBytes_init(cursorB.isNull(iE28) ? null : cursorB.getString(iE28));
                    iE29 = iE29;
                    printerEntity.setBytes_finish(cursorB.isNull(iE29) ? null : cursorB.getString(iE29));
                    iE30 = iE30;
                    printerEntity.setPageName(cursorB.isNull(iE30) ? null : cursorB.getString(iE30));
                    int i19 = iE31;
                    iE31 = i19;
                    printerEntity.setUseDithering(cursorB.getInt(i19) != 0);
                    arrayList2.add(printerEntity);
                    iE27 = i18;
                    iE12 = i7;
                    iE15 = i6;
                    iE16 = i8;
                    iE17 = i9;
                    arrayList = arrayList2;
                    iE = i5;
                    i3 = i4;
                }
                ArrayList arrayList3 = arrayList;
                cursorB.close();
                xVar.J();
                return arrayList3;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                xVar.J();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            xVar = xVarY;
        }
    }

    @Override // rawbt.sdk.dao.PrintersModel
    public AbstractC0360s getAllLive() {
        final x xVarY = x.y("SELECT * from printers ORDER BY id DESC", 0);
        return this.__db.l().e(new String[]{RawbtResponse.RESPONSE_PRINTERS}, false, new Callable<List<PrinterEntity>>() { // from class: rawbt.sdk.dao.PrintersModel_Impl.6
            protected void finalize() {
                xVarY.J();
            }

            @Override // java.util.concurrent.Callable
            public List<PrinterEntity> call() {
                Cursor cursorB = b.b(PrintersModel_Impl.this.__db, xVarY, false, null);
                try {
                    int iE = a.e(cursorB, "id");
                    int iE2 = a.e(cursorB, "name");
                    int iE3 = a.e(cursorB, "description");
                    int iE4 = a.e(cursorB, RawbtPrintJob.PRINTER_CURRENT);
                    int iE5 = a.e(cursorB, "protocol");
                    int iE6 = a.e(cursorB, "mac");
                    int iE7 = a.e(cursorB, "host");
                    int iE8 = a.e(cursorB, "port");
                    int iE9 = a.e(cursorB, "vid");
                    int iE10 = a.e(cursorB, "pid");
                    int iE11 = a.e(cursorB, "baud");
                    int iE12 = a.e(cursorB, "serialComDriver");
                    int iE13 = a.e(cursorB, "profileClass");
                    int iE14 = a.e(cursorB, "dots");
                    int iE15 = a.e(cursorB, "dpi");
                    int iE16 = a.e(cursorB, "printLanguageType");
                    int iE17 = a.e(cursorB, "printLanguage");
                    int iE18 = a.e(cursorB, "codePage");
                    int iE19 = a.e(cursorB, "graphicsCommand");
                    int iE20 = a.e(cursorB, "skipLinesAfterJob");
                    int iE21 = a.e(cursorB, "cutCommand");
                    int iE22 = a.e(cursorB, "pulseCommand");
                    int iE23 = a.e(cursorB, "addFrame");
                    int iE24 = a.e(cursorB, "sleepAfter");
                    int iE25 = a.e(cursorB, "lan_delayMS");
                    int iE26 = a.e(cursorB, "abs");
                    int iE27 = a.e(cursorB, "darkness");
                    int iE28 = a.e(cursorB, "bytes_init");
                    int iE29 = a.e(cursorB, "bytes_finish");
                    int iE30 = a.e(cursorB, "pageName");
                    int iE31 = a.e(cursorB, "useDithering");
                    int i3 = iE14;
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        PrinterEntity printerEntity = new PrinterEntity();
                        ArrayList arrayList2 = arrayList;
                        printerEntity.setId(cursorB.getInt(iE));
                        printerEntity.setName(cursorB.isNull(iE2) ? null : cursorB.getString(iE2));
                        printerEntity.setDescription(cursorB.isNull(iE3) ? null : cursorB.getString(iE3));
                        printerEntity.setCurrent(cursorB.getInt(iE4) != 0);
                        printerEntity.setProtocol(cursorB.getInt(iE5));
                        printerEntity.setMac(cursorB.isNull(iE6) ? null : cursorB.getString(iE6));
                        printerEntity.setHost(cursorB.isNull(iE7) ? null : cursorB.getString(iE7));
                        printerEntity.setPort(cursorB.getInt(iE8));
                        printerEntity.setVid(cursorB.isNull(iE9) ? null : cursorB.getString(iE9));
                        printerEntity.setPid(cursorB.isNull(iE10) ? null : cursorB.getString(iE10));
                        printerEntity.setBaud(cursorB.getInt(iE11));
                        printerEntity.setSerialComDriver(cursorB.isNull(iE12) ? null : cursorB.getString(iE12));
                        printerEntity.setProfileClass(cursorB.isNull(iE13) ? null : cursorB.getString(iE13));
                        int i4 = i3;
                        int i5 = iE;
                        printerEntity.dots = cursorB.getInt(i4);
                        int i6 = iE15;
                        printerEntity.dpi = cursorB.getInt(i6);
                        int i7 = iE16;
                        printerEntity.setPrintLanguageType(cursorB.getInt(i7));
                        int i8 = iE17;
                        printerEntity.setPrintLanguage(cursorB.isNull(i8) ? null : cursorB.getString(i8));
                        iE18 = iE18;
                        printerEntity.setCodePage(cursorB.isNull(iE18) ? null : cursorB.getString(iE18));
                        int i9 = iE19;
                        printerEntity.setGraphicsCommand(cursorB.getInt(i9));
                        iE19 = i9;
                        int i10 = iE20;
                        printerEntity.setSkipLinesAfterJob(cursorB.getInt(i10));
                        iE20 = i10;
                        int i11 = iE21;
                        printerEntity.setCutCommand(cursorB.getInt(i11));
                        iE21 = i11;
                        int i12 = iE22;
                        printerEntity.pulseCommand = cursorB.getInt(i12);
                        int i13 = iE23;
                        iE23 = i13;
                        printerEntity.setAddFrame(cursorB.getInt(i13) != 0);
                        iE22 = i12;
                        int i14 = iE24;
                        printerEntity.setSleepAfter(cursorB.getInt(i14));
                        iE24 = i14;
                        int i15 = iE25;
                        printerEntity.setLan_delayMS(cursorB.getInt(i15));
                        iE25 = i15;
                        int i16 = iE26;
                        printerEntity.abs = cursorB.getInt(i16);
                        iE26 = i16;
                        int i17 = iE27;
                        printerEntity.setDarkness(cursorB.getInt(i17));
                        iE28 = iE28;
                        printerEntity.setBytes_init(cursorB.isNull(iE28) ? null : cursorB.getString(iE28));
                        iE29 = iE29;
                        printerEntity.setBytes_finish(cursorB.isNull(iE29) ? null : cursorB.getString(iE29));
                        iE30 = iE30;
                        printerEntity.setPageName(cursorB.isNull(iE30) ? null : cursorB.getString(iE30));
                        int i18 = iE31;
                        iE31 = i18;
                        printerEntity.setUseDithering(cursorB.getInt(i18) != 0);
                        arrayList2.add(printerEntity);
                        iE27 = i17;
                        arrayList = arrayList2;
                        iE = i5;
                        i3 = i4;
                        iE15 = i6;
                        iE16 = i7;
                        iE17 = i8;
                    }
                    return arrayList;
                } finally {
                    cursorB.close();
                }
            }
        });
    }

    @Override // rawbt.sdk.dao.PrintersModel
    public PrinterEntity getById(int i3) throws Throwable {
        x xVar;
        PrinterEntity printerEntity;
        x xVarY = x.y("SELECT * from printers where id =? ", 1);
        xVarY.l(1, i3);
        this.__db.d();
        Cursor cursorB = b.b(this.__db, xVarY, false, null);
        try {
            int iE = a.e(cursorB, "id");
            int iE2 = a.e(cursorB, "name");
            int iE3 = a.e(cursorB, "description");
            int iE4 = a.e(cursorB, RawbtPrintJob.PRINTER_CURRENT);
            int iE5 = a.e(cursorB, "protocol");
            int iE6 = a.e(cursorB, "mac");
            int iE7 = a.e(cursorB, "host");
            int iE8 = a.e(cursorB, "port");
            int iE9 = a.e(cursorB, "vid");
            int iE10 = a.e(cursorB, "pid");
            int iE11 = a.e(cursorB, "baud");
            int iE12 = a.e(cursorB, "serialComDriver");
            int iE13 = a.e(cursorB, "profileClass");
            int iE14 = a.e(cursorB, "dots");
            xVar = xVarY;
            try {
                int iE15 = a.e(cursorB, "dpi");
                int iE16 = a.e(cursorB, "printLanguageType");
                int iE17 = a.e(cursorB, "printLanguage");
                int iE18 = a.e(cursorB, "codePage");
                int iE19 = a.e(cursorB, "graphicsCommand");
                int iE20 = a.e(cursorB, "skipLinesAfterJob");
                int iE21 = a.e(cursorB, "cutCommand");
                int iE22 = a.e(cursorB, "pulseCommand");
                int iE23 = a.e(cursorB, "addFrame");
                int iE24 = a.e(cursorB, "sleepAfter");
                int iE25 = a.e(cursorB, "lan_delayMS");
                int iE26 = a.e(cursorB, "abs");
                int iE27 = a.e(cursorB, "darkness");
                int iE28 = a.e(cursorB, "bytes_init");
                int iE29 = a.e(cursorB, "bytes_finish");
                int iE30 = a.e(cursorB, "pageName");
                int iE31 = a.e(cursorB, "useDithering");
                if (cursorB.moveToFirst()) {
                    PrinterEntity printerEntity2 = new PrinterEntity();
                    printerEntity2.setId(cursorB.getInt(iE));
                    printerEntity2.setName(cursorB.isNull(iE2) ? null : cursorB.getString(iE2));
                    printerEntity2.setDescription(cursorB.isNull(iE3) ? null : cursorB.getString(iE3));
                    printerEntity2.setCurrent(cursorB.getInt(iE4) != 0);
                    printerEntity2.setProtocol(cursorB.getInt(iE5));
                    printerEntity2.setMac(cursorB.isNull(iE6) ? null : cursorB.getString(iE6));
                    printerEntity2.setHost(cursorB.isNull(iE7) ? null : cursorB.getString(iE7));
                    printerEntity2.setPort(cursorB.getInt(iE8));
                    printerEntity2.setVid(cursorB.isNull(iE9) ? null : cursorB.getString(iE9));
                    printerEntity2.setPid(cursorB.isNull(iE10) ? null : cursorB.getString(iE10));
                    printerEntity2.setBaud(cursorB.getInt(iE11));
                    printerEntity2.setSerialComDriver(cursorB.isNull(iE12) ? null : cursorB.getString(iE12));
                    printerEntity2.setProfileClass(cursorB.isNull(iE13) ? null : cursorB.getString(iE13));
                    printerEntity2.dots = cursorB.getInt(iE14);
                    printerEntity2.dpi = cursorB.getInt(iE15);
                    printerEntity2.setPrintLanguageType(cursorB.getInt(iE16));
                    printerEntity2.setPrintLanguage(cursorB.isNull(iE17) ? null : cursorB.getString(iE17));
                    printerEntity2.setCodePage(cursorB.isNull(iE18) ? null : cursorB.getString(iE18));
                    printerEntity2.setGraphicsCommand(cursorB.getInt(iE19));
                    printerEntity2.setSkipLinesAfterJob(cursorB.getInt(iE20));
                    printerEntity2.setCutCommand(cursorB.getInt(iE21));
                    printerEntity2.pulseCommand = cursorB.getInt(iE22);
                    printerEntity2.setAddFrame(cursorB.getInt(iE23) != 0);
                    printerEntity2.setSleepAfter(cursorB.getInt(iE24));
                    printerEntity2.setLan_delayMS(cursorB.getInt(iE25));
                    printerEntity2.abs = cursorB.getInt(iE26);
                    printerEntity2.setDarkness(cursorB.getInt(iE27));
                    printerEntity2.setBytes_init(cursorB.isNull(iE28) ? null : cursorB.getString(iE28));
                    printerEntity2.setBytes_finish(cursorB.isNull(iE29) ? null : cursorB.getString(iE29));
                    printerEntity2.setPageName(cursorB.isNull(iE30) ? null : cursorB.getString(iE30));
                    printerEntity2.setUseDithering(cursorB.getInt(iE31) != 0);
                    printerEntity = printerEntity2;
                } else {
                    printerEntity = null;
                }
                cursorB.close();
                xVar.J();
                return printerEntity;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                xVar.J();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            xVar = xVarY;
        }
    }

    @Override // rawbt.sdk.dao.PrintersModel
    public PrinterEntity getByName(String str) throws Throwable {
        x xVar;
        PrinterEntity printerEntity;
        x xVarY = x.y("SELECT * from printers where name =? ", 1);
        if (str == null) {
            xVarY.x(1);
        } else {
            xVarY.k(1, str);
        }
        this.__db.d();
        Cursor cursorB = b.b(this.__db, xVarY, false, null);
        try {
            int iE = a.e(cursorB, "id");
            int iE2 = a.e(cursorB, "name");
            int iE3 = a.e(cursorB, "description");
            int iE4 = a.e(cursorB, RawbtPrintJob.PRINTER_CURRENT);
            int iE5 = a.e(cursorB, "protocol");
            int iE6 = a.e(cursorB, "mac");
            int iE7 = a.e(cursorB, "host");
            int iE8 = a.e(cursorB, "port");
            int iE9 = a.e(cursorB, "vid");
            int iE10 = a.e(cursorB, "pid");
            int iE11 = a.e(cursorB, "baud");
            int iE12 = a.e(cursorB, "serialComDriver");
            int iE13 = a.e(cursorB, "profileClass");
            int iE14 = a.e(cursorB, "dots");
            xVar = xVarY;
            try {
                int iE15 = a.e(cursorB, "dpi");
                int iE16 = a.e(cursorB, "printLanguageType");
                int iE17 = a.e(cursorB, "printLanguage");
                int iE18 = a.e(cursorB, "codePage");
                int iE19 = a.e(cursorB, "graphicsCommand");
                int iE20 = a.e(cursorB, "skipLinesAfterJob");
                int iE21 = a.e(cursorB, "cutCommand");
                int iE22 = a.e(cursorB, "pulseCommand");
                int iE23 = a.e(cursorB, "addFrame");
                int iE24 = a.e(cursorB, "sleepAfter");
                int iE25 = a.e(cursorB, "lan_delayMS");
                int iE26 = a.e(cursorB, "abs");
                int iE27 = a.e(cursorB, "darkness");
                int iE28 = a.e(cursorB, "bytes_init");
                int iE29 = a.e(cursorB, "bytes_finish");
                int iE30 = a.e(cursorB, "pageName");
                int iE31 = a.e(cursorB, "useDithering");
                if (cursorB.moveToFirst()) {
                    PrinterEntity printerEntity2 = new PrinterEntity();
                    printerEntity2.setId(cursorB.getInt(iE));
                    printerEntity2.setName(cursorB.isNull(iE2) ? null : cursorB.getString(iE2));
                    printerEntity2.setDescription(cursorB.isNull(iE3) ? null : cursorB.getString(iE3));
                    printerEntity2.setCurrent(cursorB.getInt(iE4) != 0);
                    printerEntity2.setProtocol(cursorB.getInt(iE5));
                    printerEntity2.setMac(cursorB.isNull(iE6) ? null : cursorB.getString(iE6));
                    printerEntity2.setHost(cursorB.isNull(iE7) ? null : cursorB.getString(iE7));
                    printerEntity2.setPort(cursorB.getInt(iE8));
                    printerEntity2.setVid(cursorB.isNull(iE9) ? null : cursorB.getString(iE9));
                    printerEntity2.setPid(cursorB.isNull(iE10) ? null : cursorB.getString(iE10));
                    printerEntity2.setBaud(cursorB.getInt(iE11));
                    printerEntity2.setSerialComDriver(cursorB.isNull(iE12) ? null : cursorB.getString(iE12));
                    printerEntity2.setProfileClass(cursorB.isNull(iE13) ? null : cursorB.getString(iE13));
                    printerEntity2.dots = cursorB.getInt(iE14);
                    printerEntity2.dpi = cursorB.getInt(iE15);
                    printerEntity2.setPrintLanguageType(cursorB.getInt(iE16));
                    printerEntity2.setPrintLanguage(cursorB.isNull(iE17) ? null : cursorB.getString(iE17));
                    printerEntity2.setCodePage(cursorB.isNull(iE18) ? null : cursorB.getString(iE18));
                    printerEntity2.setGraphicsCommand(cursorB.getInt(iE19));
                    printerEntity2.setSkipLinesAfterJob(cursorB.getInt(iE20));
                    printerEntity2.setCutCommand(cursorB.getInt(iE21));
                    printerEntity2.pulseCommand = cursorB.getInt(iE22);
                    printerEntity2.setAddFrame(cursorB.getInt(iE23) != 0);
                    printerEntity2.setSleepAfter(cursorB.getInt(iE24));
                    printerEntity2.setLan_delayMS(cursorB.getInt(iE25));
                    printerEntity2.abs = cursorB.getInt(iE26);
                    printerEntity2.setDarkness(cursorB.getInt(iE27));
                    printerEntity2.setBytes_init(cursorB.isNull(iE28) ? null : cursorB.getString(iE28));
                    printerEntity2.setBytes_finish(cursorB.isNull(iE29) ? null : cursorB.getString(iE29));
                    printerEntity2.setPageName(cursorB.isNull(iE30) ? null : cursorB.getString(iE30));
                    printerEntity2.setUseDithering(cursorB.getInt(iE31) != 0);
                    printerEntity = printerEntity2;
                } else {
                    printerEntity = null;
                }
                cursorB.close();
                xVar.J();
                return printerEntity;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                xVar.J();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            xVar = xVarY;
        }
    }

    @Override // rawbt.sdk.dao.PrintersModel
    public PrinterEntity getByUsbParam(String str, String str2) throws Throwable {
        x xVar;
        PrinterEntity printerEntity;
        x xVarY = x.y("SELECT * from printers where pid = ? and vid = ?", 2);
        if (str == null) {
            xVarY.x(1);
        } else {
            xVarY.k(1, str);
        }
        if (str2 == null) {
            xVarY.x(2);
        } else {
            xVarY.k(2, str2);
        }
        this.__db.d();
        Cursor cursorB = b.b(this.__db, xVarY, false, null);
        try {
            int iE = a.e(cursorB, "id");
            int iE2 = a.e(cursorB, "name");
            int iE3 = a.e(cursorB, "description");
            int iE4 = a.e(cursorB, RawbtPrintJob.PRINTER_CURRENT);
            int iE5 = a.e(cursorB, "protocol");
            int iE6 = a.e(cursorB, "mac");
            int iE7 = a.e(cursorB, "host");
            int iE8 = a.e(cursorB, "port");
            int iE9 = a.e(cursorB, "vid");
            int iE10 = a.e(cursorB, "pid");
            int iE11 = a.e(cursorB, "baud");
            int iE12 = a.e(cursorB, "serialComDriver");
            int iE13 = a.e(cursorB, "profileClass");
            int iE14 = a.e(cursorB, "dots");
            xVar = xVarY;
            try {
                int iE15 = a.e(cursorB, "dpi");
                int iE16 = a.e(cursorB, "printLanguageType");
                int iE17 = a.e(cursorB, "printLanguage");
                int iE18 = a.e(cursorB, "codePage");
                int iE19 = a.e(cursorB, "graphicsCommand");
                int iE20 = a.e(cursorB, "skipLinesAfterJob");
                int iE21 = a.e(cursorB, "cutCommand");
                int iE22 = a.e(cursorB, "pulseCommand");
                int iE23 = a.e(cursorB, "addFrame");
                int iE24 = a.e(cursorB, "sleepAfter");
                int iE25 = a.e(cursorB, "lan_delayMS");
                int iE26 = a.e(cursorB, "abs");
                int iE27 = a.e(cursorB, "darkness");
                int iE28 = a.e(cursorB, "bytes_init");
                int iE29 = a.e(cursorB, "bytes_finish");
                int iE30 = a.e(cursorB, "pageName");
                int iE31 = a.e(cursorB, "useDithering");
                if (cursorB.moveToFirst()) {
                    PrinterEntity printerEntity2 = new PrinterEntity();
                    printerEntity2.setId(cursorB.getInt(iE));
                    printerEntity2.setName(cursorB.isNull(iE2) ? null : cursorB.getString(iE2));
                    printerEntity2.setDescription(cursorB.isNull(iE3) ? null : cursorB.getString(iE3));
                    printerEntity2.setCurrent(cursorB.getInt(iE4) != 0);
                    printerEntity2.setProtocol(cursorB.getInt(iE5));
                    printerEntity2.setMac(cursorB.isNull(iE6) ? null : cursorB.getString(iE6));
                    printerEntity2.setHost(cursorB.isNull(iE7) ? null : cursorB.getString(iE7));
                    printerEntity2.setPort(cursorB.getInt(iE8));
                    printerEntity2.setVid(cursorB.isNull(iE9) ? null : cursorB.getString(iE9));
                    printerEntity2.setPid(cursorB.isNull(iE10) ? null : cursorB.getString(iE10));
                    printerEntity2.setBaud(cursorB.getInt(iE11));
                    printerEntity2.setSerialComDriver(cursorB.isNull(iE12) ? null : cursorB.getString(iE12));
                    printerEntity2.setProfileClass(cursorB.isNull(iE13) ? null : cursorB.getString(iE13));
                    printerEntity2.dots = cursorB.getInt(iE14);
                    printerEntity2.dpi = cursorB.getInt(iE15);
                    printerEntity2.setPrintLanguageType(cursorB.getInt(iE16));
                    printerEntity2.setPrintLanguage(cursorB.isNull(iE17) ? null : cursorB.getString(iE17));
                    printerEntity2.setCodePage(cursorB.isNull(iE18) ? null : cursorB.getString(iE18));
                    printerEntity2.setGraphicsCommand(cursorB.getInt(iE19));
                    printerEntity2.setSkipLinesAfterJob(cursorB.getInt(iE20));
                    printerEntity2.setCutCommand(cursorB.getInt(iE21));
                    printerEntity2.pulseCommand = cursorB.getInt(iE22);
                    printerEntity2.setAddFrame(cursorB.getInt(iE23) != 0);
                    printerEntity2.setSleepAfter(cursorB.getInt(iE24));
                    printerEntity2.setLan_delayMS(cursorB.getInt(iE25));
                    printerEntity2.abs = cursorB.getInt(iE26);
                    printerEntity2.setDarkness(cursorB.getInt(iE27));
                    printerEntity2.setBytes_init(cursorB.isNull(iE28) ? null : cursorB.getString(iE28));
                    printerEntity2.setBytes_finish(cursorB.isNull(iE29) ? null : cursorB.getString(iE29));
                    printerEntity2.setPageName(cursorB.isNull(iE30) ? null : cursorB.getString(iE30));
                    printerEntity2.setUseDithering(cursorB.getInt(iE31) != 0);
                    printerEntity = printerEntity2;
                } else {
                    printerEntity = null;
                }
                cursorB.close();
                xVar.J();
                return printerEntity;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                xVar.J();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            xVar = xVarY;
        }
    }

    @Override // rawbt.sdk.dao.PrintersModel
    public PrinterEntity getDefault() throws Throwable {
        x xVar;
        PrinterEntity printerEntity;
        x xVarY = x.y("SELECT * from printers where current = 1", 0);
        this.__db.d();
        Cursor cursorB = b.b(this.__db, xVarY, false, null);
        try {
            int iE = a.e(cursorB, "id");
            int iE2 = a.e(cursorB, "name");
            int iE3 = a.e(cursorB, "description");
            int iE4 = a.e(cursorB, RawbtPrintJob.PRINTER_CURRENT);
            int iE5 = a.e(cursorB, "protocol");
            int iE6 = a.e(cursorB, "mac");
            int iE7 = a.e(cursorB, "host");
            int iE8 = a.e(cursorB, "port");
            int iE9 = a.e(cursorB, "vid");
            int iE10 = a.e(cursorB, "pid");
            int iE11 = a.e(cursorB, "baud");
            int iE12 = a.e(cursorB, "serialComDriver");
            int iE13 = a.e(cursorB, "profileClass");
            int iE14 = a.e(cursorB, "dots");
            xVar = xVarY;
            try {
                int iE15 = a.e(cursorB, "dpi");
                int iE16 = a.e(cursorB, "printLanguageType");
                int iE17 = a.e(cursorB, "printLanguage");
                int iE18 = a.e(cursorB, "codePage");
                int iE19 = a.e(cursorB, "graphicsCommand");
                int iE20 = a.e(cursorB, "skipLinesAfterJob");
                int iE21 = a.e(cursorB, "cutCommand");
                int iE22 = a.e(cursorB, "pulseCommand");
                int iE23 = a.e(cursorB, "addFrame");
                int iE24 = a.e(cursorB, "sleepAfter");
                int iE25 = a.e(cursorB, "lan_delayMS");
                int iE26 = a.e(cursorB, "abs");
                int iE27 = a.e(cursorB, "darkness");
                int iE28 = a.e(cursorB, "bytes_init");
                int iE29 = a.e(cursorB, "bytes_finish");
                int iE30 = a.e(cursorB, "pageName");
                int iE31 = a.e(cursorB, "useDithering");
                if (cursorB.moveToFirst()) {
                    PrinterEntity printerEntity2 = new PrinterEntity();
                    printerEntity2.setId(cursorB.getInt(iE));
                    printerEntity2.setName(cursorB.isNull(iE2) ? null : cursorB.getString(iE2));
                    printerEntity2.setDescription(cursorB.isNull(iE3) ? null : cursorB.getString(iE3));
                    printerEntity2.setCurrent(cursorB.getInt(iE4) != 0);
                    printerEntity2.setProtocol(cursorB.getInt(iE5));
                    printerEntity2.setMac(cursorB.isNull(iE6) ? null : cursorB.getString(iE6));
                    printerEntity2.setHost(cursorB.isNull(iE7) ? null : cursorB.getString(iE7));
                    printerEntity2.setPort(cursorB.getInt(iE8));
                    printerEntity2.setVid(cursorB.isNull(iE9) ? null : cursorB.getString(iE9));
                    printerEntity2.setPid(cursorB.isNull(iE10) ? null : cursorB.getString(iE10));
                    printerEntity2.setBaud(cursorB.getInt(iE11));
                    printerEntity2.setSerialComDriver(cursorB.isNull(iE12) ? null : cursorB.getString(iE12));
                    printerEntity2.setProfileClass(cursorB.isNull(iE13) ? null : cursorB.getString(iE13));
                    printerEntity2.dots = cursorB.getInt(iE14);
                    printerEntity2.dpi = cursorB.getInt(iE15);
                    printerEntity2.setPrintLanguageType(cursorB.getInt(iE16));
                    printerEntity2.setPrintLanguage(cursorB.isNull(iE17) ? null : cursorB.getString(iE17));
                    printerEntity2.setCodePage(cursorB.isNull(iE18) ? null : cursorB.getString(iE18));
                    printerEntity2.setGraphicsCommand(cursorB.getInt(iE19));
                    printerEntity2.setSkipLinesAfterJob(cursorB.getInt(iE20));
                    printerEntity2.setCutCommand(cursorB.getInt(iE21));
                    printerEntity2.pulseCommand = cursorB.getInt(iE22);
                    printerEntity2.setAddFrame(cursorB.getInt(iE23) != 0);
                    printerEntity2.setSleepAfter(cursorB.getInt(iE24));
                    printerEntity2.setLan_delayMS(cursorB.getInt(iE25));
                    printerEntity2.abs = cursorB.getInt(iE26);
                    printerEntity2.setDarkness(cursorB.getInt(iE27));
                    printerEntity2.setBytes_init(cursorB.isNull(iE28) ? null : cursorB.getString(iE28));
                    printerEntity2.setBytes_finish(cursorB.isNull(iE29) ? null : cursorB.getString(iE29));
                    printerEntity2.setPageName(cursorB.isNull(iE30) ? null : cursorB.getString(iE30));
                    printerEntity2.setUseDithering(cursorB.getInt(iE31) != 0);
                    printerEntity = printerEntity2;
                } else {
                    printerEntity = null;
                }
                cursorB.close();
                xVar.J();
                return printerEntity;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                xVar.J();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            xVar = xVarY;
        }
    }

    @Override // rawbt.sdk.dao.PrintersModel
    public List<PrinterEntity> getReal() throws Throwable {
        x xVar;
        x xVarY = x.y("SELECT * from printers WHERE id>2 ORDER BY id DESC", 0);
        this.__db.d();
        Cursor cursorB = b.b(this.__db, xVarY, false, null);
        try {
            int iE = a.e(cursorB, "id");
            int iE2 = a.e(cursorB, "name");
            int iE3 = a.e(cursorB, "description");
            int iE4 = a.e(cursorB, RawbtPrintJob.PRINTER_CURRENT);
            int iE5 = a.e(cursorB, "protocol");
            int iE6 = a.e(cursorB, "mac");
            int iE7 = a.e(cursorB, "host");
            int iE8 = a.e(cursorB, "port");
            int iE9 = a.e(cursorB, "vid");
            int iE10 = a.e(cursorB, "pid");
            int iE11 = a.e(cursorB, "baud");
            int iE12 = a.e(cursorB, "serialComDriver");
            int iE13 = a.e(cursorB, "profileClass");
            int iE14 = a.e(cursorB, "dots");
            xVar = xVarY;
            try {
                int iE15 = a.e(cursorB, "dpi");
                int iE16 = a.e(cursorB, "printLanguageType");
                int iE17 = a.e(cursorB, "printLanguage");
                int iE18 = a.e(cursorB, "codePage");
                int iE19 = a.e(cursorB, "graphicsCommand");
                int iE20 = a.e(cursorB, "skipLinesAfterJob");
                int iE21 = a.e(cursorB, "cutCommand");
                int iE22 = a.e(cursorB, "pulseCommand");
                int iE23 = a.e(cursorB, "addFrame");
                int iE24 = a.e(cursorB, "sleepAfter");
                int iE25 = a.e(cursorB, "lan_delayMS");
                int iE26 = a.e(cursorB, "abs");
                int iE27 = a.e(cursorB, "darkness");
                int iE28 = a.e(cursorB, "bytes_init");
                int iE29 = a.e(cursorB, "bytes_finish");
                int iE30 = a.e(cursorB, "pageName");
                int iE31 = a.e(cursorB, "useDithering");
                int i3 = iE14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    PrinterEntity printerEntity = new PrinterEntity();
                    ArrayList arrayList2 = arrayList;
                    printerEntity.setId(cursorB.getInt(iE));
                    printerEntity.setName(cursorB.isNull(iE2) ? null : cursorB.getString(iE2));
                    printerEntity.setDescription(cursorB.isNull(iE3) ? null : cursorB.getString(iE3));
                    printerEntity.setCurrent(cursorB.getInt(iE4) != 0);
                    printerEntity.setProtocol(cursorB.getInt(iE5));
                    printerEntity.setMac(cursorB.isNull(iE6) ? null : cursorB.getString(iE6));
                    printerEntity.setHost(cursorB.isNull(iE7) ? null : cursorB.getString(iE7));
                    printerEntity.setPort(cursorB.getInt(iE8));
                    printerEntity.setVid(cursorB.isNull(iE9) ? null : cursorB.getString(iE9));
                    printerEntity.setPid(cursorB.isNull(iE10) ? null : cursorB.getString(iE10));
                    printerEntity.setBaud(cursorB.getInt(iE11));
                    printerEntity.setSerialComDriver(cursorB.isNull(iE12) ? null : cursorB.getString(iE12));
                    printerEntity.setProfileClass(cursorB.isNull(iE13) ? null : cursorB.getString(iE13));
                    int i4 = i3;
                    int i5 = iE;
                    printerEntity.dots = cursorB.getInt(i4);
                    int i6 = iE15;
                    int i7 = iE12;
                    printerEntity.dpi = cursorB.getInt(i6);
                    int i8 = iE16;
                    printerEntity.setPrintLanguageType(cursorB.getInt(i8));
                    int i9 = iE17;
                    printerEntity.setPrintLanguage(cursorB.isNull(i9) ? null : cursorB.getString(i9));
                    iE18 = iE18;
                    printerEntity.setCodePage(cursorB.isNull(iE18) ? null : cursorB.getString(iE18));
                    int i10 = iE19;
                    printerEntity.setGraphicsCommand(cursorB.getInt(i10));
                    iE19 = i10;
                    int i11 = iE20;
                    printerEntity.setSkipLinesAfterJob(cursorB.getInt(i11));
                    iE20 = i11;
                    int i12 = iE21;
                    printerEntity.setCutCommand(cursorB.getInt(i12));
                    iE21 = i12;
                    int i13 = iE22;
                    printerEntity.pulseCommand = cursorB.getInt(i13);
                    int i14 = iE23;
                    iE23 = i14;
                    printerEntity.setAddFrame(cursorB.getInt(i14) != 0);
                    iE22 = i13;
                    int i15 = iE24;
                    printerEntity.setSleepAfter(cursorB.getInt(i15));
                    iE24 = i15;
                    int i16 = iE25;
                    printerEntity.setLan_delayMS(cursorB.getInt(i16));
                    iE25 = i16;
                    int i17 = iE26;
                    printerEntity.abs = cursorB.getInt(i17);
                    iE26 = i17;
                    int i18 = iE27;
                    printerEntity.setDarkness(cursorB.getInt(i18));
                    iE28 = iE28;
                    printerEntity.setBytes_init(cursorB.isNull(iE28) ? null : cursorB.getString(iE28));
                    iE29 = iE29;
                    printerEntity.setBytes_finish(cursorB.isNull(iE29) ? null : cursorB.getString(iE29));
                    iE30 = iE30;
                    printerEntity.setPageName(cursorB.isNull(iE30) ? null : cursorB.getString(iE30));
                    int i19 = iE31;
                    iE31 = i19;
                    printerEntity.setUseDithering(cursorB.getInt(i19) != 0);
                    arrayList2.add(printerEntity);
                    iE27 = i18;
                    iE12 = i7;
                    iE15 = i6;
                    iE16 = i8;
                    iE17 = i9;
                    arrayList = arrayList2;
                    iE = i5;
                    i3 = i4;
                }
                ArrayList arrayList3 = arrayList;
                cursorB.close();
                xVar.J();
                return arrayList3;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                xVar.J();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            xVar = xVarY;
        }
    }

    @Override // rawbt.sdk.dao.PrintersModel
    public long insert(PrinterEntity printerEntity) {
        this.__db.d();
        this.__db.e();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfPrinterEntity.insertAndReturnId(printerEntity);
            this.__db.A();
            return jInsertAndReturnId;
        } finally {
            this.__db.i();
        }
    }

    @Override // rawbt.sdk.dao.PrintersModel
    public void setDefault(int i3) {
        this.__db.d();
        k kVarAcquire = this.__preparedStmtOfSetDefault.acquire();
        kVarAcquire.l(1, i3);
        try {
            this.__db.e();
            try {
                kVarAcquire.n();
                this.__db.A();
                this.__db.i();
                this.__preparedStmtOfSetDefault.release(kVarAcquire);
            } catch (Throwable th) {
                this.__db.i();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfSetDefault.release(kVarAcquire);
            throw th2;
        }
    }

    @Override // rawbt.sdk.dao.PrintersModel
    public void storeLastPrintParam(String str, String str2, boolean z3) {
        this.__db.d();
        k kVarAcquire = this.__preparedStmtOfStoreLastPrintParam.acquire();
        if (str2 == null) {
            kVarAcquire.x(1);
        } else {
            kVarAcquire.k(1, str2);
        }
        kVarAcquire.l(2, z3 ? 1L : 0L);
        if (str == null) {
            kVarAcquire.x(3);
        } else {
            kVarAcquire.k(3, str);
        }
        try {
            this.__db.e();
            try {
                kVarAcquire.n();
                this.__db.A();
                this.__db.i();
                this.__preparedStmtOfStoreLastPrintParam.release(kVarAcquire);
            } catch (Throwable th) {
                this.__db.i();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfStoreLastPrintParam.release(kVarAcquire);
            throw th2;
        }
    }

    @Override // rawbt.sdk.dao.PrintersModel
    public void update(PrinterEntity printerEntity) {
        this.__db.d();
        this.__db.e();
        try {
            this.__updateAdapterOfPrinterEntity.handle(printerEntity);
            this.__db.A();
        } finally {
            this.__db.i();
        }
    }
}
