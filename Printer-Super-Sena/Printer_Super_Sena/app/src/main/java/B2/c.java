package B2;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import rawbt.api.RawbtPrintJob;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.dao.PrintersModel;
import rawbt.sdk.transport.Constant;
import ru.a402d.rawbtprinter.AppDatabase;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static void a() {
        boolean z3;
        try {
            AppDatabase appDatabaseH = RawPrinterApp.h();
            Objects.requireNonNull(appDatabaseH);
            PrintersModel printersModelD = appDatabaseH.D();
            if (printersModelD == null) {
                return;
            }
            if (printersModelD.getById(1) == null) {
                PrinterEntity printerEntity = new PrinterEntity();
                printerEntity.setId(1);
                printerEntity.setName(RawbtPrintJob.PRINTER_VIRTUAL);
                printerEntity.setDescription("Emulator");
                printerEntity.setProtocol(5);
                printerEntity.setProfileClass(Constant.DRIVER_ESC_GENERAL);
                printerEntity.setPrintLanguageType(3);
                printerEntity.setSkipLinesAfterJob(2);
                printerEntity.setSleepAfter(0);
                printerEntity.setAddFrame(true);
                printersModelD.insert(printerEntity);
                z3 = true;
            } else {
                z3 = false;
            }
            if (printersModelD.getById(2) == null) {
                PrinterEntity printerEntity2 = new PrinterEntity();
                printerEntity2.setId(2);
                printerEntity2.setName(RawbtPrintJob.PRINTER_GALLERY);
                printerEntity2.setDescription("Save into gallery");
                printerEntity2.setProtocol(7);
                printerEntity2.setProfileClass(Constant.DRIVER_ESC_GENERAL);
                printerEntity2.setPrintLanguageType(3);
                printerEntity2.setSkipLinesAfterJob(0);
                printerEntity2.setSleepAfter(0);
                printerEntity2.setAddFrame(false);
                printersModelD.insert(printerEntity2);
            }
            if (z3) {
                PrinterEntity printerEntity3 = new PrinterEntity();
                printerEntity3.setId(3);
                printerEntity3.setName("your_printer");
                printerEntity3.setDescription("Converted from settings");
                printerEntity3.setCurrent(true);
                y2.b bVarW = y2.b.w();
                int iN = bVarW.N();
                boolean z4 = iN != 0;
                if (iN == 5) {
                    printersModelD.setDefault(1);
                    z4 = false;
                }
                if (iN == 7) {
                    printersModelD.setDefault(2);
                    z4 = false;
                }
                if (z4) {
                    printerEntity3.setProtocol(bVarW.N());
                    printerEntity3.setMac(bVarW.a0());
                    printerEntity3.setHost(bVarW.Y());
                    printerEntity3.setPort(bVarW.d0());
                    printerEntity3.setVid(bVarW.e0());
                    printerEntity3.setPid(bVarW.c0());
                    printerEntity3.setSerialComDriver(bVarW.O());
                    printerEntity3.setBaud(bVarW.X());
                    printerEntity3.setProfileClass(bVarW.p());
                    if (iN == 4) {
                        int iD = bVarW.d();
                        if (iD == 0) {
                            printerEntity3.setProfileClass(Constant.DRIVER_AIDL_COM_IPOS);
                        } else if (iD == 1) {
                            printerEntity3.setProfileClass(Constant.DRIVER_AIDL_WOYOU_IPOS);
                        } else if (iD == 2) {
                            printerEntity3.setProfileClass(Constant.DRIVER_AIDL_WOYOU_JIUIV5);
                        } else if (iD == 3) {
                            printerEntity3.setProfileClass(Constant.DRIVER_AIDL_ATOL10);
                        }
                    }
                    printerEntity3.setDots_per_line(bVarW.o());
                    printerEntity3.setDensity(bVarW.n());
                    printerEntity3.setPrintLanguageType(bVarW.L());
                    printerEntity3.setPrintLanguage(bVarW.K());
                    printerEntity3.setCodePage(bVarW.h());
                    printerEntity3.setGraphicsCommand(bVarW.q());
                    printerEntity3.setSkipLinesAfterJob(bVarW.J());
                    printerEntity3.setCutCommand(bVarW.M());
                    printerEntity3.setSleepAfter((int) bVarW.Q());
                    printerEntity3.setLan_delayMS(bVarW.Z());
                    printerEntity3.setAbs_mode(bVarW.W());
                    printerEntity3.setDarkness(bVarW.m());
                    printerEntity3.setBytes_init(bVarW.g());
                    printerEntity3.setBytes_finish(bVarW.f());
                    printerEntity3.setPageName(bVarW.b0());
                    printerEntity3.setUseDithering(bVarW.u() == 1);
                    printersModelD.insert(printerEntity3);
                }
            }
            if (printersModelD.getDefault() == null) {
                printersModelD.setDefault(1);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static String b(String str) {
        if (str == null) {
            str = "unknown";
        }
        if (!str.endsWith("=")) {
            return str;
        }
        try {
            return new String(Base64.decode(str, 0), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return "Name in Base64";
        }
    }
}
