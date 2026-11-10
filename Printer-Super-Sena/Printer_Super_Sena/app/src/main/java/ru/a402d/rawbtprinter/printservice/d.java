package ru.a402d.rawbtprinter.printservice;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.print.PrintAttributes;
import android.print.PrinterCapabilitiesInfo;
import android.print.PrinterId;
import android.print.PrinterInfo;
import android.printservice.PrintService;
import android.printservice.PrinterDiscoverySession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rawbt.sdk.dao.PrinterEntity;
import ru.a402d.rawbtprinter.AppDatabase;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
class d extends PrinterDiscoverySession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ExecutorService f11606a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Handler f11607b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PrintService f11608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    List f11609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    List f11610e;

    d(PrintService printService, x2.a aVar) {
        this.f11608c = printService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT < 21) {
            arrayList.add(new PrinterInfo.Builder(this.f11608c.generatePrinterId("RAW BT Printer"), "require Android 5.1", 3).build());
            addPrinters(arrayList);
            return;
        }
        for (PrinterEntity printerEntity : this.f11609d) {
            PrinterId printerIdGeneratePrinterId = this.f11608c.generatePrinterId(printerEntity.getName());
            int i3 = 1;
            PrinterInfo.Builder builder = new PrinterInfo.Builder(printerIdGeneratePrinterId, printerEntity.getName(), 1);
            String pageName = printerEntity.getPageName();
            int dots_per_line = printerEntity.getDots_per_line();
            if (printerEntity.isUseDithering()) {
                i3 = 2;
            }
            builder.setCapabilities(e(pageName, dots_per_line, i3, printerIdGeneratePrinterId));
            builder.setDescription(printerEntity.getDescription());
            arrayList.add(builder.build());
        }
        addPrinters(arrayList);
        for (PrinterId printerId : this.f11610e) {
            String localId = printerId.getLocalId();
            Iterator<PrinterInfo> it = arrayList.iterator();
            do {
                if (!it.hasNext()) {
                    arrayList2.add(printerId);
                    break;
                }
            } while (!localId.equals(it.next().getName()));
        }
        removePrinters(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        try {
            AppDatabase appDatabaseH = RawPrinterApp.h();
            Objects.requireNonNull(appDatabaseH);
            this.f11609d = appDatabaseH.D().getReal();
            this.f11607b.post(new c(this));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        try {
            AppDatabase appDatabaseH = RawPrinterApp.h();
            Objects.requireNonNull(appDatabaseH);
            this.f11609d = appDatabaseH.D().getReal();
            this.f11607b.post(new c(this));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00f9  */
    PrinterCapabilitiesInfo e(String str, int i3, int i4, PrinterId printerId) {
        String str2;
        String str3;
        boolean z3;
        boolean z4;
        int i5 = (i3 * 8) / 8;
        if (i5 < 136) {
            i5 = 136;
        }
        double d3 = i5;
        Double.isNaN(d3);
        double d4 = ((d3 * 1000.0d) / 72.0d) + 13.0d;
        String str4 = "110mm Roll";
        if (!str.equals("Paper_Roll") && !str.equals("Paper_Roll_Long") && !str.equals("Paper_Roll_not_cut") && !str.equals("58mm_Roll_Max") && !str.equals("80mm_Roll_Max") && !str.equals("A4") && !str.equals("for_LETTER") && !str.equals("for_LEGAL") && !str.equals("for_ROC_16K") && !str.equals("for_JIS_B4") && !str.equals("for_photos") && !str.equals("for_photos_not_cut") && !str.equals("for_square") && !str.equals("58mm Roll")) {
            str3 = "80mm Roll";
            if (str.equals(str3)) {
                str2 = "for_square_not_cut";
            } else if (str.equals(str4)) {
                str4 = str4;
                str2 = "for_square_not_cut";
            } else {
                str2 = "for_square_not_cut";
                if (!str.equals(str2)) {
                    str4 = str4;
                    z3 = true;
                }
            }
            String str5 = str3;
            PrinterCapabilitiesInfo.Builder builder = new PrinterCapabilitiesInfo.Builder(printerId);
            String str6 = str2;
            int i6 = (int) (d4 + 1000.0d);
            PrintAttributes.MediaSize mediaSize = new PrintAttributes.MediaSize("Paper_Roll", "Paper Roll", i6, 12488);
            if (!str.equals("Paper_Roll") || z3) {
                z4 = true;
            } else {
                z4 = false;
            }
            builder.addMediaSize(mediaSize, z4);
            double d5 = 4.0d * d4;
            builder.addMediaSize(new PrintAttributes.MediaSize("Paper_Roll_Long", "Paper Roll Long", i6, (int) (d5 + 1000.0d)), str.equals("Paper_Roll_Long"));
            int i7 = (int) d4;
            builder.addMediaSize(new PrintAttributes.MediaSize("Paper_Roll_not_cut", "Paper Roll not cut", i7, 11488), str.equals("Paper_Roll_not_cut"));
            builder.addMediaSize(new PrintAttributes.MediaSize("A4", "A4", 8270, 11690), str.equals("A4"));
            builder.addMediaSize(new PrintAttributes.MediaSize("for_A4", "for A4", i6, (int) (((297.0d * d4) / 210.0d) + 1000.0d)), false);
            builder.addMediaSize(new PrintAttributes.MediaSize("for_LETTER", "for LETTER", i6, (int) (((279.0d * d4) / 216.0d) + 1000.0d)), str.equals("for_LETTER"));
            builder.addMediaSize(new PrintAttributes.MediaSize("for_LEGAL", "for LEGAL", i6, (int) (((356.0d * d4) / 216.0d) + 1000.0d)), str.equals("for_LEGAL"));
            builder.addMediaSize(new PrintAttributes.MediaSize("for_ROC_16K", "for ROC_16K", i6, (int) (((270.0d * d4) / 195.0d) + 1000.0d)), str.equals("for_ROC_16K"));
            builder.addMediaSize(new PrintAttributes.MediaSize("for_JIS_B4", "for JIS_B4", i6, (int) (((364.0d * d4) / 257.0d) + 1000.0d)), str.equals("for_JIS_B4"));
            double d6 = d5 / 3.0d;
            builder.addMediaSize(new PrintAttributes.MediaSize("for_photos", "for photos", i6, (int) (1000.0d + d6)), str.equals("for_photos"));
            builder.addMediaSize(new PrintAttributes.MediaSize("for_photos_not_cut", "for photos not cut", i7, (int) d6), str.equals("for_photos_not_cut"));
            builder.addMediaSize(new PrintAttributes.MediaSize("for_square", "for square", i6, i6), str.equals("for_square"));
            builder.addMediaSize(new PrintAttributes.MediaSize(str6, "for square not cut", i7, i7), str.equals(str6));
            builder.addMediaSize(new PrintAttributes.MediaSize("58mm Roll", "58mm Roll", 3000, 6000), str.equals("58mm Roll"));
            builder.addMediaSize(new PrintAttributes.MediaSize("58mm_Roll_Max", "58mm Roll Max", 3000, 32000), str.equals("58mm_Roll_Max"));
            builder.addMediaSize(new PrintAttributes.MediaSize(str5, str5, 4000, 12000), str.equals(str5));
            builder.addMediaSize(new PrintAttributes.MediaSize("80mm_Roll_Max", "80mm Roll Max", 4000, 32000), str.equals("80mm_Roll_Max"));
            String str7 = str4;
            builder.addMediaSize(new PrintAttributes.MediaSize(str7, str7, 5000, 12000), str.equals(str7));
            builder.addResolution(new PrintAttributes.Resolution("Default", "72dpi: 1pt=1dot", 72, 72), true);
            builder.setColorModes(3, i4);
            builder.setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0));
            return builder.build();
        }
        str2 = "for_square_not_cut";
        str3 = "80mm Roll";
        str4 = str4;
        z3 = false;
        String str8 = str3;
        PrinterCapabilitiesInfo.Builder builder2 = new PrinterCapabilitiesInfo.Builder(printerId);
        String str9 = str2;
        int i8 = (int) (d4 + 1000.0d);
        PrintAttributes.MediaSize mediaSize2 = new PrintAttributes.MediaSize("Paper_Roll", "Paper Roll", i8, 12488);
        if (str.equals("Paper_Roll")) {
            z4 = true;
        } else {
            z4 = true;
        }
        builder2.addMediaSize(mediaSize2, z4);
        double d7 = 4.0d * d4;
        builder2.addMediaSize(new PrintAttributes.MediaSize("Paper_Roll_Long", "Paper Roll Long", i8, (int) (d7 + 1000.0d)), str.equals("Paper_Roll_Long"));
        int i9 = (int) d4;
        builder2.addMediaSize(new PrintAttributes.MediaSize("Paper_Roll_not_cut", "Paper Roll not cut", i9, 11488), str.equals("Paper_Roll_not_cut"));
        builder2.addMediaSize(new PrintAttributes.MediaSize("A4", "A4", 8270, 11690), str.equals("A4"));
        builder2.addMediaSize(new PrintAttributes.MediaSize("for_A4", "for A4", i8, (int) (((297.0d * d4) / 210.0d) + 1000.0d)), false);
        builder2.addMediaSize(new PrintAttributes.MediaSize("for_LETTER", "for LETTER", i8, (int) (((279.0d * d4) / 216.0d) + 1000.0d)), str.equals("for_LETTER"));
        builder2.addMediaSize(new PrintAttributes.MediaSize("for_LEGAL", "for LEGAL", i8, (int) (((356.0d * d4) / 216.0d) + 1000.0d)), str.equals("for_LEGAL"));
        builder2.addMediaSize(new PrintAttributes.MediaSize("for_ROC_16K", "for ROC_16K", i8, (int) (((270.0d * d4) / 195.0d) + 1000.0d)), str.equals("for_ROC_16K"));
        builder2.addMediaSize(new PrintAttributes.MediaSize("for_JIS_B4", "for JIS_B4", i8, (int) (((364.0d * d4) / 257.0d) + 1000.0d)), str.equals("for_JIS_B4"));
        double d8 = d7 / 3.0d;
        builder2.addMediaSize(new PrintAttributes.MediaSize("for_photos", "for photos", i8, (int) (1000.0d + d8)), str.equals("for_photos"));
        builder2.addMediaSize(new PrintAttributes.MediaSize("for_photos_not_cut", "for photos not cut", i9, (int) d8), str.equals("for_photos_not_cut"));
        builder2.addMediaSize(new PrintAttributes.MediaSize("for_square", "for square", i8, i8), str.equals("for_square"));
        builder2.addMediaSize(new PrintAttributes.MediaSize(str9, "for square not cut", i9, i9), str.equals(str9));
        builder2.addMediaSize(new PrintAttributes.MediaSize("58mm Roll", "58mm Roll", 3000, 6000), str.equals("58mm Roll"));
        builder2.addMediaSize(new PrintAttributes.MediaSize("58mm_Roll_Max", "58mm Roll Max", 3000, 32000), str.equals("58mm_Roll_Max"));
        builder2.addMediaSize(new PrintAttributes.MediaSize(str8, str8, 4000, 12000), str.equals(str8));
        builder2.addMediaSize(new PrintAttributes.MediaSize("80mm_Roll_Max", "80mm Roll Max", 4000, 32000), str.equals("80mm_Roll_Max"));
        String str10 = str4;
        builder2.addMediaSize(new PrintAttributes.MediaSize(str10, str10, 5000, 12000), str.equals(str10));
        builder2.addResolution(new PrintAttributes.Resolution("Default", "72dpi: 1pt=1dot", 72, 72), true);
        builder2.setColorModes(3, i4);
        builder2.setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0));
        return builder2.build();
    }

    @Override // android.printservice.PrinterDiscoverySession
    public void onDestroy() {
    }

    @Override // android.printservice.PrinterDiscoverySession
    public void onStartPrinterDiscovery(List list) {
        this.f11610e = list;
        this.f11606a.execute(new Runnable() { // from class: ru.a402d.rawbtprinter.printservice.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f11604a.f();
            }
        });
    }

    @Override // android.printservice.PrinterDiscoverySession
    public void onStartPrinterStateTracking(PrinterId printerId) {
    }

    @Override // android.printservice.PrinterDiscoverySession
    public void onStopPrinterDiscovery() {
    }

    @Override // android.printservice.PrinterDiscoverySession
    public void onStopPrinterStateTracking(PrinterId printerId) {
    }

    @Override // android.printservice.PrinterDiscoverySession
    public void onValidatePrinters(List list) {
        this.f11610e = list;
        this.f11606a.execute(new Runnable() { // from class: ru.a402d.rawbtprinter.printservice.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f11603a.g();
            }
        });
    }
}
