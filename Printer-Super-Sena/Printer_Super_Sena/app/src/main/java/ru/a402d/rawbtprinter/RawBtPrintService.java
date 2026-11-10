package ru.a402d.rawbtprinter;

import B2.c;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import rawbt.api.Constant;
import rawbt.api.RawbtPrintJob;
import rawbt.api.attributes.AttributesString;
import rawbt.api.command.CommandDrawLine;
import rawbt.sdk.AbstractRawBtPrintService;
import rawbt.sdk.RawbtConstants;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.drivers.PosDriverInterface;
import rawbt.sdk.drivers.PrinterDriverFactory;
import rawbt.sdk.templates.DocumentTemplate;
import rawbt.sdk.templates.DocumentTemplateNone;
import y2.b;

/* JADX INFO: loaded from: classes.dex */
public class RawBtPrintService extends AbstractRawBtPrintService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f11263a;

    @Override // rawbt.sdk.AbstractRawBtPrintService
    protected void countSuccessJob() {
        if (RawPrinterApp.l()) {
            b bVar = this.f11263a;
            bVar.y0(bVar.j() + 1);
        }
    }

    @Override // rawbt.sdk.AbstractRawBtPrintService
    public PosDriverInterface driver_get(String str) throws Exception {
        PrinterEntity byName;
        if (str == null) {
            throw new Exception("Printer's name is empty");
        }
        AppDatabase appDatabaseH = RawPrinterApp.h();
        if (appDatabaseH == null) {
            throw new Exception("Database error");
        }
        if (RawbtPrintJob.PRINTER_CURRENT.equals(str)) {
            byName = appDatabaseH.D().getDefault();
            if (byName == null) {
                c.a();
                byName = appDatabaseH.D().getDefault();
            }
        } else if ("raw_transfer".equals(str)) {
            byName = appDatabaseH.D().getDefault();
            byName.setProfileClass("raw_transfer");
        } else {
            byName = appDatabaseH.D().getByName(str);
        }
        if (byName == null) {
            throw new Exception("Printer not found");
        }
        byName.initEncoding(RawPrinterApp.g());
        PosDriverInterface byProfile = PrinterDriverFactory.getByProfile(byName, this);
        byProfile.interactiveTask(this.taskIteration);
        String strConnectPrinter = byProfile.connectPrinter(byName.connectParameters);
        if (RawbtConstants.OK.equals(strConnectPrinter) || isCancelled()) {
            return byProfile;
        }
        throw new Exception(strConnectPrinter);
    }

    @Override // rawbt.sdk.AbstractRawBtPrintService
    public int getLimitFileSizes() {
        return this.f11263a.D();
    }

    @Override // rawbt.sdk.AbstractRawBtPrintService
    public int getLimitPages() {
        return this.f11263a.F();
    }

    @Override // rawbt.sdk.AbstractRawBtPrintService
    public List getPrintersList() {
        AppDatabase appDatabaseH = RawPrinterApp.h();
        Objects.requireNonNull(appDatabaseH);
        return appDatabaseH.D().getAll();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0033  */
    @Override // rawbt.sdk.AbstractRawBtPrintService
    public DocumentTemplate get_template(String str) {
        byte b3;
        int iHashCode = str.hashCode();
        if (iHashCode != -902286926) {
            if (iHashCode != 3387192) {
                if (iHashCode == 1544803905 && str.equals(RawbtPrintJob.TEMPLATE_DEFAULT)) {
                    b3 = 2;
                } else {
                    b3 = -1;
                }
            } else if (str.equals("none")) {
                b3 = 1;
            } else {
                b3 = -1;
            }
        } else if (str.equals(RawbtPrintJob.TEMPLATE_SIMPLE)) {
            b3 = 0;
        } else {
            b3 = -1;
        }
        if (b3 != 0) {
            return b3 != 1 ? new A2.a() : new DocumentTemplateNone();
        }
        return new A2.b();
    }

    @Override // rawbt.sdk.AbstractRawBtPrintService
    protected rawbt.sdk.RawbtPrintJob injectDefaults(rawbt.sdk.RawbtPrintJob rawbtPrintJob) {
        if (rawbtPrintJob.isNullDefaultAttrImage()) {
            rawbtPrintJob.setDefaultAttrImage(this.f11263a.a());
        }
        if (rawbtPrintJob.isNullDefaultAttrPdf()) {
            rawbtPrintJob.setDefaultAttrPdf(this.f11263a.b());
        }
        return rawbtPrintJob;
    }

    @Override // rawbt.sdk.AbstractRawBtPrintService
    public boolean isFreeVersion() {
        return RawPrinterApp.l();
    }

    @Override // rawbt.sdk.AbstractRawBtPrintService
    public boolean isPrintAfterPageCut() {
        return this.f11263a.m0();
    }

    @Override // rawbt.sdk.AbstractRawBtPrintService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f11263a = b.w();
    }

    @Override // rawbt.sdk.AbstractRawBtPrintService
    public void print_free_note(PosDriverInterface posDriverInterface) {
        try {
            if (isFreeVersion()) {
                AttributesString attributesString = new AttributesString();
                attributesString.setAlignment(Constant.ALIGNMENT_CENTER);
                AttributesString attributesString2 = new AttributesString();
                attributesString2.setDoubleHeight(true);
                attributesString2.setBold(true);
                attributesString2.setAlignment(Constant.ALIGNMENT_CENTER);
                CommandDrawLine commandDrawLine = new CommandDrawLine('*', attributesString);
                posDriverInterface.drawCharLine(commandDrawLine);
                if (new Random().nextInt(10) < 4) {
                    posDriverInterface.text_as_image(getContext().getString(R.string.free_notice_hard), attributesString);
                } else {
                    posDriverInterface.text_as_image(getContext().getString(R.string.free_notice), attributesString2);
                    posDriverInterface.text_as_image(getContext().getString(R.string.free_notice_personal_only), attributesString);
                }
                posDriverInterface.drawCharLine(commandDrawLine);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // rawbt.sdk.AbstractRawBtPrintService
    public PosDriverInterface raw_driver_get(String str) throws Exception {
        if (str == null) {
            throw new Exception("Printer's name is empty");
        }
        AppDatabase appDatabaseH = RawPrinterApp.h();
        if (appDatabaseH == null) {
            throw new Exception("Database error");
        }
        PrinterEntity byName = appDatabaseH.D().getByName(str);
        if (byName == null) {
            throw new Exception("Printer not found");
        }
        byName.setProfileClass("raw_transfer");
        PosDriverInterface byProfile = PrinterDriverFactory.getByProfile(byName, this);
        byProfile.interactiveTask(this.taskIteration);
        String strConnectPrinter = byProfile.connectPrinter(byName.connectParameters);
        if (RawbtConstants.OK.equals(strConnectPrinter)) {
            return byProfile;
        }
        throw new Exception(strConnectPrinter);
    }
}
