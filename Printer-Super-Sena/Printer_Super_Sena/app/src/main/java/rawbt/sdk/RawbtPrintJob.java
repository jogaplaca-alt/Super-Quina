package rawbt.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Base64;
import android.widget.Toast;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import rawbt.api.Constant;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesPdf;
import rawbt.api.attributes.AttributesString;
import rawbt.api.command.CommandBarcode;
import rawbt.api.command.CommandBytesInBase64;
import rawbt.api.command.CommandCut;
import rawbt.api.command.CommandDelimiterImages;
import rawbt.api.command.CommandDrawLine;
import rawbt.api.command.CommandEmulate;
import rawbt.api.command.CommandImageInBase64;
import rawbt.api.command.CommandLeftRightText;
import rawbt.api.command.CommandNewLine;
import rawbt.api.command.CommandParcelable;
import rawbt.api.command.CommandPdfInBase64;
import rawbt.api.command.CommandQRcode;
import rawbt.api.command.CommandString;
import rawbt.api.command.RawbtCommand;
import rawbt.sdk.drivers.IVirtualEscPos;
import rawbt.sdk.drivers.PosDriverInterface;
import rawbt.sdk.emulator.escpos.EscPosEmulator;
import rawbt.sdk.emulator.escpos.PrinterCommand;
import rawbt.sdk.utils.GraphLibrary;

/* JADX INFO: loaded from: classes.dex */
public class RawbtPrintJob extends rawbt.api.RawbtPrintJob {
    RawbtPrintJobCallback callback;

    /* JADX INFO: renamed from: rawbt.sdk.RawbtPrintJob$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$rawbt$api$Constant$RAWBT_CONTENT_TYPE;

        static {
            int[] iArr = new int[Constant.RAWBT_CONTENT_TYPE.values().length];
            $SwitchMap$rawbt$api$Constant$RAWBT_CONTENT_TYPE = iArr;
            try {
                iArr[Constant.RAWBT_CONTENT_TYPE.image.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$rawbt$api$Constant$RAWBT_CONTENT_TYPE[Constant.RAWBT_CONTENT_TYPE.prn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$rawbt$api$Constant$RAWBT_CONTENT_TYPE[Constant.RAWBT_CONTENT_TYPE.pdf.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface RawbtPrintJobCallback {
        PosDriverInterface driver_get(String str);

        Context getContext();

        int getLimitFileSize();

        int getLimitPages();

        boolean isCancelled();

        boolean isFreeVersion();

        boolean isPrintAfterPageCut();

        void jobCancelled(String str);

        void jobSuccess(String str);

        void print_footer(PosDriverInterface posDriverInterface, String str);

        void print_free_note(PosDriverInterface posDriverInterface);

        void print_header(PosDriverInterface posDriverInterface, String str);

        void setProgress(String str, float f3);

        void showError(String str, String str2);

        void showProgress(String str);
    }

    /* JADX WARN: Code duplicated, block: B:223:0x05b7  */
    /* JADX WARN: Code duplicated, block: B:225:0x05bd  */
    /* JADX WARN: Code duplicated, block: B:226:0x05d8  */
    /* JADX WARN: Code duplicated, block: B:311:0x05a8 A[SYNTHETIC] */
    public void execute(RawbtPrintJobCallback rawbtPrintJobCallback) throws Throwable {
        PosDriverInterface posDriverInterface;
        this.callback = rawbtPrintJobCallback;
        rawbtPrintJobCallback.setProgress(getIdJob(), 0.01f);
        int copies = getCopies();
        ArrayList<RawbtCommand> commands = getCommands();
        int size = commands.size();
        if (copies <= 0 || size <= 0) {
            rawbtPrintJobCallback.showError(getIdJob(), "Empty print job");
            return;
        }
        double d3 = copies;
        Double.isNaN(d3);
        double d4 = 0.9d / d3;
        double d5 = size;
        Double.isNaN(d5);
        double d6 = d4 / d5;
        PrintThread printThread = (PrintThread) rawbtPrintJobCallback;
        double d7 = 0.05d;
        printThread.getCallback().initCommandProgress(getIdJob(), 0.05d, d6);
        try {
            PosDriverInterface posDriverInterfaceDriver_get = rawbtPrintJobCallback.driver_get(getPrinter());
            if (posDriverInterfaceDriver_get == null) {
                return;
            }
            if (posDriverInterfaceDriver_get.getPrinterProfile().getProtocol() == 7) {
                setPremium(true);
            }
            setDefaultAttrString(posDriverInterfaceDriver_get.getPrinterProfile().getAttributesString());
            rawbtPrintJobCallback.setProgress(getIdJob(), (float) 0.05d);
            int i3 = 0;
            while (i3 < copies) {
                if (isCancelled()) {
                    posDriverInterfaceDriver_get.disconnectPrinter();
                    rawbtPrintJobCallback.jobCancelled(getIdJob());
                    return;
                }
                if (posDriverInterfaceDriver_get.isError()) {
                    posDriverInterfaceDriver_get.disconnectPrinter();
                    rawbtPrintJobCallback.showError(getIdJob(), posDriverInterfaceDriver_get.getErrorMessage());
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Copy # ");
                int i4 = i3 + 1;
                sb.append(i4);
                sb.append(". Printing ...");
                rawbtPrintJobCallback.showProgress(sb.toString());
                posDriverInterfaceDriver_get.initialize();
                if (posDriverInterfaceDriver_get.isError()) {
                    posDriverInterfaceDriver_get.disconnectPrinter();
                    rawbtPrintJobCallback.showError(getIdJob(), posDriverInterfaceDriver_get.getErrorMessage());
                    return;
                }
                rawbtPrintJobCallback.print_header(posDriverInterfaceDriver_get, getTemplate());
                for (RawbtCommand rawbtCommand : commands) {
                    if (isCancelled()) {
                        posDriverInterfaceDriver_get.disconnectPrinter();
                        rawbtPrintJobCallback.jobCancelled(getIdJob());
                        return;
                    }
                    if (rawbtCommand instanceof CommandString) {
                        CommandString commandString = (CommandString) rawbtCommand;
                        AttributesString attributesString = commandString.getAttributesString();
                        if (posDriverInterfaceDriver_get.getPrinterProfile().isPrintTextAsImage() || attributesString.getPrinterFont() == 4) {
                            posDriverInterfaceDriver_get.text_as_image(commandString.getText(), attributesString);
                        } else {
                            posDriverInterfaceDriver_get.text(commandString.getText() + "\n", attributesString);
                        }
                    } else if (rawbtCommand instanceof CommandBytesInBase64) {
                        try {
                            if (posDriverInterfaceDriver_get instanceof IVirtualEscPos) {
                                int dots_per_line = posDriverInterfaceDriver_get.getPrinterProfile().getDots_per_line();
                                if (posDriverInterfaceDriver_get.getPrinterProfile().getDensity() == 304) {
                                    dots_per_line = (dots_per_line * 8) / 12;
                                }
                                ((IVirtualEscPos) posDriverInterfaceDriver_get).injectVirtual(posDriverInterfaceDriver_get.getPrinterProfile().getEncoding().getEncoding(), dots_per_line);
                                setPremium(true);
                            }
                            posDriverInterfaceDriver_get.bytes(Base64.decode(((CommandBytesInBase64) rawbtCommand).getBase64(), 0));
                        } catch (Exception unused) {
                            rawbtPrintJobCallback.showError(getIdJob(), "Wrong base64");
                        }
                    } else if (rawbtCommand instanceof CommandImageInBase64) {
                        try {
                            byte[] bArrDecode = Base64.decode(((CommandImageInBase64) rawbtCommand).getBase64(), 0);
                            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                            AttributesImage attributesImage = ((CommandImageInBase64) rawbtCommand).getAttributesImage();
                            if (attributesImage == null) {
                                attributesImage = getDefaultAttrImage();
                            }
                            posDriverInterfaceDriver_get.printImage(bitmapDecodeByteArray, attributesImage);
                        } catch (Exception unused2) {
                            rawbtPrintJobCallback.showError(getIdJob(), "Wrong base64 image");
                        }
                    } else if (rawbtCommand instanceof CommandPdfInBase64) {
                        setPremium(true);
                        try {
                            File file = new File(rawbtPrintJobCallback.getContext().getCacheDir(), "share");
                            if (file.mkdir()) {
                                Toast.makeText(rawbtPrintJobCallback.getContext(), "share dir created", 0).show();
                            }
                            File file2 = new File(file.getPath(), "temp.pdf");
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                            try {
                                bufferedOutputStream.write(Base64.decode(((CommandPdfInBase64) rawbtCommand).getBase64(), 0));
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                Uri uriFromFile = Uri.fromFile(file2);
                                if (Build.VERSION.SDK_INT >= 21) {
                                    pdfDecode(posDriverInterfaceDriver_get, uriFromFile, ((CommandPdfInBase64) rawbtCommand).getAttributesPdf(), ((CommandPdfInBase64) rawbtCommand).getAttributesImage());
                                } else {
                                    rawbtPrintJobCallback.showError(getIdJob(), rawbtPrintJobCallback.getContext().getString(R.string.letter50));
                                }
                            } catch (Exception e3) {
                                e = e3;
                                rawbtPrintJobCallback.showError(getIdJob(), "Wrong base64 pdf");
                                e.printStackTrace();
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } else if (rawbtCommand instanceof CommandCut) {
                        posDriverInterfaceDriver_get.cutPaper();
                    } else {
                        if (rawbtCommand instanceof CommandLeftRightText) {
                            posDriverInterfaceDriver_get.leftRight((CommandLeftRightText) rawbtCommand);
                        } else if (rawbtCommand instanceof CommandDelimiterImages) {
                            if (!posDriverInterfaceDriver_get.isError() && isPremium() && !isCancelled()) {
                                printThread.getCallback().initCommandProgress(getIdJob(), d7, 0.0d);
                                rawbtPrintJobCallback.print_free_note(posDriverInterfaceDriver_get);
                                printThread.getCallback().initCommandProgress(getIdJob(), d7, d6);
                            }
                            if (rawbtPrintJobCallback.isPrintAfterPageCut()) {
                                int skipLinesAfterJob = posDriverInterfaceDriver_get.getPrinterProfile().getSkipLinesAfterJob();
                                posDriverInterfaceDriver_get = posDriverInterfaceDriver_get;
                                posDriverInterfaceDriver_get.scrollPaper(skipLinesAfterJob);
                                posDriverInterfaceDriver_get.cutPaper();
                            } else {
                                posDriverInterfaceDriver_get = posDriverInterfaceDriver_get;
                            }
                            try {
                                long jCurrentTimeMillis = System.currentTimeMillis() + posDriverInterfaceDriver_get.getPrinterProfile().getSleepAfter();
                                while (System.currentTimeMillis() < jCurrentTimeMillis && !isCancelled()) {
                                    Thread.sleep(500L);
                                }
                            } catch (InterruptedException e5) {
                                e5.printStackTrace();
                            }
                        } else {
                            copies = copies;
                            i4 = i4;
                            if (rawbtCommand instanceof CommandBarcode) {
                                try {
                                    posDriverInterfaceDriver_get.barcode((CommandBarcode) rawbtCommand);
                                } catch (Exception e6) {
                                    String localizedMessage = e6.getLocalizedMessage();
                                    if (localizedMessage == null) {
                                        localizedMessage = e6.getClass().getSimpleName();
                                    }
                                    posDriverInterfaceDriver_get.text(localizedMessage + "\n", getDefaultAttrString());
                                }
                                if (posDriverInterfaceDriver_get.isError()) {
                                    posDriverInterfaceDriver_get.text(posDriverInterfaceDriver_get.getErrorMessage() + "\n", getDefaultAttrString());
                                    posDriverInterfaceDriver_get.resetError();
                                }
                            } else if (rawbtCommand instanceof CommandQRcode) {
                                try {
                                    posDriverInterfaceDriver_get.qrcode((CommandQRcode) rawbtCommand);
                                } catch (Exception e7) {
                                    String localizedMessage2 = e7.getLocalizedMessage();
                                    if (localizedMessage2 == null) {
                                        localizedMessage2 = e7.getClass().getSimpleName();
                                    }
                                    posDriverInterfaceDriver_get.text(localizedMessage2 + "\n", getDefaultAttrString());
                                }
                                if (posDriverInterfaceDriver_get.isError()) {
                                    posDriverInterfaceDriver_get.text(posDriverInterfaceDriver_get.getErrorMessage() + "\n", getDefaultAttrString());
                                    posDriverInterfaceDriver_get.resetError();
                                }
                            } else if (rawbtCommand instanceof CommandNewLine) {
                                posDriverInterfaceDriver_get.scrollPaper(((CommandNewLine) rawbtCommand).getCount());
                            } else if (rawbtCommand instanceof CommandDrawLine) {
                                posDriverInterfaceDriver_get.drawCharLine((CommandDrawLine) rawbtCommand);
                            } else if (rawbtCommand instanceof CommandEmulate) {
                                Uri uri = Uri.parse(((CommandEmulate) rawbtCommand).getParcelable());
                                setPremium(true);
                                try {
                                    InputStream inputStreamOpenInputStream = rawbtPrintJobCallback.getContext().getContentResolver().openInputStream(uri);
                                    int dots_per_line2 = posDriverInterfaceDriver_get.getPrinterProfile().getDots_per_line();
                                    if (posDriverInterfaceDriver_get.getPrinterProfile().getDensity() == 304) {
                                        dots_per_line2 = (dots_per_line2 * 8) / 12;
                                    }
                                    Context context = rawbtPrintJobCallback.getContext();
                                    Objects.requireNonNull(inputStreamOpenInputStream);
                                    EscPosEmulator escPosEmulator = new EscPosEmulator(context, rawbt.sdk.utils.File.readBinary(inputStreamOpenInputStream), posDriverInterfaceDriver_get.getPrinterProfile().getEncoding().getEncoding(), dots_per_line2);
                                    while (!escPosEmulator.isEnd()) {
                                        escPosEmulator.commandMessage = null;
                                        PrinterCommand command = escPosEmulator.getCommand();
                                        try {
                                            command.apply(escPosEmulator);
                                        } catch (Error | Exception unused3) {
                                        }
                                        escPosEmulator.input_pointer += command.get_length();
                                        if (escPosEmulator.output_height > 32000) {
                                            break;
                                        }
                                    }
                                    int i5 = escPosEmulator.output_height;
                                    if (i5 > 0) {
                                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(escPosEmulator.max_dots, i5, Bitmap.Config.ARGB_8888);
                                        FileChannel channel = escPosEmulator.randomAccessFile.getChannel();
                                        bitmapCreateBitmap.copyPixelsFromBuffer(channel.map(FileChannel.MapMode.READ_WRITE, 0L, bitmapCreateBitmap.getRowBytes() * bitmapCreateBitmap.getHeight()));
                                        channel.close();
                                        try {
                                            posDriverInterfaceDriver_get.printImage(bitmapCreateBitmap, new AttributesImage(0));
                                        } catch (Exception e8) {
                                            e = e8;
                                            e.printStackTrace();
                                        }
                                    }
                                    escPosEmulator.randomAccessFile.close();
                                    escPosEmulator.file.delete();
                                } catch (Exception e9) {
                                    e = e9;
                                }
                            } else if (rawbtCommand instanceof CommandParcelable) {
                                CommandParcelable commandParcelable = (CommandParcelable) rawbtCommand;
                                Constant.RAWBT_CONTENT_TYPE type = commandParcelable.getType();
                                AttributesImage attributesImage2 = commandParcelable.getAttributesImage();
                                if (attributesImage2 == null) {
                                    attributesImage2 = getDefaultAttrImage();
                                }
                                AttributesString attributesString2 = commandParcelable.getAttributesString();
                                if (attributesString2 == null) {
                                    attributesString2 = getDefaultAttrString();
                                }
                                AttributesString attributesString3 = attributesString2;
                                AttributesPdf attributesPdf = commandParcelable.getAttributesPdf();
                                if (attributesPdf == null) {
                                    attributesPdf = getDefaultAttrPdf();
                                }
                                AttributesPdf attributesPdf2 = attributesPdf;
                                Uri uri2 = Uri.parse(commandParcelable.getParcelable());
                                try {
                                    InputStream inputStreamOpenInputStream2 = rawbtPrintJobCallback.getContext().getContentResolver().openInputStream(uri2);
                                    Objects.requireNonNull(inputStreamOpenInputStream2);
                                    int i6 = AnonymousClass1.$SwitchMap$rawbt$api$Constant$RAWBT_CONTENT_TYPE[type.ordinal()];
                                    if (i6 == 1) {
                                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2);
                                        if (attributesImage2.getGraphicFilter() != 0 && attributesImage2.getGraphicFilter() != 9) {
                                            setPremium(true);
                                        }
                                        posDriverInterfaceDriver_get.printImage(bitmapDecodeStream, attributesImage2);
                                    } else if (i6 == 2) {
                                        if (posDriverInterfaceDriver_get instanceof IVirtualEscPos) {
                                            int dots_per_line3 = posDriverInterfaceDriver_get.getPrinterProfile().getDots_per_line();
                                            if (posDriverInterfaceDriver_get.getPrinterProfile().getDensity() == 304) {
                                                dots_per_line3 = (dots_per_line3 * 8) / 12;
                                            }
                                            ((IVirtualEscPos) posDriverInterfaceDriver_get).injectVirtual(posDriverInterfaceDriver_get.getPrinterProfile().getEncoding().getEncoding(), dots_per_line3);
                                            setPremium(true);
                                        }
                                        posDriverInterfaceDriver_get.bytes(rawbt.sdk.utils.File.readBinary(inputStreamOpenInputStream2));
                                    } else if (i6 != 3) {
                                        try {
                                            String txtFile = rawbt.sdk.utils.File.readTxtFile(inputStreamOpenInputStream2, rawbtPrintJobCallback.getLimitFileSize(), rawbtPrintJobCallback.getContext());
                                            if (posDriverInterfaceDriver_get.getPrinterProfile().isPrintTextAsImage() || attributesString3.getPrinterFont() == 4) {
                                                posDriverInterfaceDriver_get.text_as_image(txtFile, attributesString3);
                                            } else {
                                                posDriverInterfaceDriver_get.text(txtFile + "\n", attributesString3);
                                            }
                                        } catch (Exception e10) {
                                            e = e10;
                                            e.printStackTrace();
                                        }
                                    } else {
                                        setPremium(true);
                                        if (Build.VERSION.SDK_INT >= 21) {
                                            pdfDecode(posDriverInterfaceDriver_get, uri2, attributesPdf2, attributesImage2);
                                        } else {
                                            rawbtPrintJobCallback.showError(getIdJob(), rawbtPrintJobCallback.getContext().getString(R.string.letter50));
                                        }
                                    }
                                    inputStreamOpenInputStream2.close();
                                } catch (Exception e11) {
                                    e = e11;
                                }
                            } else {
                                rawbtPrintJobCallback.showError(getIdJob(), "Unknown command " + rawbtCommand.getClass());
                            }
                        }
                        if (posDriverInterfaceDriver_get.isError()) {
                            posDriverInterfaceDriver_get.disconnectPrinter();
                            rawbtPrintJobCallback.showError(getIdJob(), posDriverInterfaceDriver_get.getErrorMessage());
                            return;
                        }
                        if (!isCancelled()) {
                            d7 += d6;
                            rawbtPrintJobCallback.setProgress(getIdJob(), (float) d7);
                            printThread.getCallback().initCommandProgress(getIdJob(), d7, d6);
                        }
                        i4 = i4;
                        copies = copies;
                        posDriverInterfaceDriver_get = posDriverInterfaceDriver_get;
                    }
                    copies = copies;
                    i4 = i4;
                    if (posDriverInterfaceDriver_get.isError()) {
                        posDriverInterfaceDriver_get.disconnectPrinter();
                        rawbtPrintJobCallback.showError(getIdJob(), posDriverInterfaceDriver_get.getErrorMessage());
                        return;
                    }
                    if (!isCancelled()) {
                        d7 += d6;
                        rawbtPrintJobCallback.setProgress(getIdJob(), (float) d7);
                        printThread.getCallback().initCommandProgress(getIdJob(), d7, d6);
                    }
                    i4 = i4;
                    copies = copies;
                    posDriverInterfaceDriver_get = posDriverInterfaceDriver_get;
                }
                int i7 = copies;
                int i8 = i4;
                PosDriverInterface posDriverInterface2 = posDriverInterfaceDriver_get;
                if (!posDriverInterface2.isError() && isPremium() && !isCancelled()) {
                    printThread.getCallback().initCommandProgress(getIdJob(), d7, 0.0d);
                    rawbtPrintJobCallback.print_free_note(posDriverInterface2);
                    printThread.getCallback().initCommandProgress(getIdJob(), d7, d6);
                }
                if (posDriverInterface2.isError() || isCancelled()) {
                    posDriverInterface = posDriverInterface2;
                } else {
                    posDriverInterface = posDriverInterface2;
                    rawbtPrintJobCallback.print_footer(posDriverInterface, getTemplate());
                }
                posDriverInterface.finish();
                if (isCancelled()) {
                    posDriverInterface.disconnectPrinter();
                    rawbtPrintJobCallback.jobCancelled(getIdJob());
                    return;
                }
                if (!posDriverInterface.isError() && !getPrinter().equals(rawbt.api.RawbtPrintJob.PRINTER_VIRTUAL) && posDriverInterface.getPrinterProfile().getSleepAfter() > 0) {
                    rawbtPrintJobCallback.showProgress("timeout at the end of the copy");
                    try {
                        long jCurrentTimeMillis2 = System.currentTimeMillis() + posDriverInterface.getPrinterProfile().getSleepAfter();
                        while (System.currentTimeMillis() < jCurrentTimeMillis2 && !isCancelled()) {
                            Thread.sleep(500L);
                        }
                    } catch (InterruptedException e12) {
                        e12.printStackTrace();
                    }
                }
                posDriverInterfaceDriver_get = posDriverInterface;
                i3 = i8;
                copies = i7;
            }
            PosDriverInterface posDriverInterface3 = posDriverInterfaceDriver_get;
            rawbtPrintJobCallback.setProgress(getIdJob(), 1.0f);
            if (posDriverInterface3.isError()) {
                rawbtPrintJobCallback.showError(getIdJob(), posDriverInterface3.getErrorMessage());
            } else {
                rawbtPrintJobCallback.showProgress("Job done success");
                rawbtPrintJobCallback.jobSuccess(getIdJob());
            }
            posDriverInterface3.disconnectPrinter();
        } catch (Exception e13) {
            e13.printStackTrace();
            String localizedMessage3 = e13.getLocalizedMessage();
            if (localizedMessage3 == null) {
                localizedMessage3 = e13.getClass().getSimpleName();
            }
            if (isCancelled()) {
                return;
            }
            rawbtPrintJobCallback.showError(getIdJob(), localizedMessage3);
        }
    }

    public boolean isCancelled() {
        return this.callback.isCancelled();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public void pdfDecode(PosDriverInterface posDriverInterface, Uri uri, AttributesPdf attributesPdf, AttributesImage attributesImage) throws Throwable {
        PdfRenderer pdfRendererA;
        PdfRenderer pdfRenderer;
        int i3;
        int i4;
        char c3 = 1;
        ?? r3 = 0;
        pdfRenderer = null;
        PdfRenderer pdfRenderer2 = null;
        try {
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.callback.getContext().getContentResolver().openFileDescriptor(uri, "r");
                Objects.requireNonNull(parcelFileDescriptorOpenFileDescriptor);
                PdfRenderer pdfRenderer3 = new PdfRenderer(parcelFileDescriptorOpenFileDescriptor);
                try {
                    try {
                        int pageCount = pdfRenderer3.getPageCount();
                        if (pageCount > this.callback.getLimitPages()) {
                            try {
                                if (attributesPdf.getPage() == -1) {
                                    RawbtPrintJobCallback rawbtPrintJobCallback = this.callback;
                                    String idJob = getIdJob();
                                    Context context = this.callback.getContext();
                                    Objects.requireNonNull(context);
                                    rawbtPrintJobCallback.showError(idJob, context.getString(R.string.ErrorOverPages));
                                    try {
                                        y.a(pdfRenderer3).close();
                                        return;
                                    } catch (Exception unused) {
                                        return;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                pdfRenderer2 = pdfRenderer3;
                                e.printStackTrace();
                                this.callback.showError(getIdJob(), e.getLocalizedMessage());
                                Objects.requireNonNull(pdfRenderer2);
                                pdfRendererA = y.a(pdfRenderer2);
                                r3 = pdfRenderer2;
                            } catch (OutOfMemoryError e4) {
                                e = e4;
                                pdfRenderer2 = pdfRenderer3;
                                e.printStackTrace();
                                this.callback.showError(getIdJob(), e.getLocalizedMessage());
                                Objects.requireNonNull(pdfRenderer2);
                                pdfRendererA = y.a(pdfRenderer2);
                                r3 = pdfRenderer2;
                            } catch (Throwable th) {
                                th = th;
                                r3 = pdfRenderer3;
                            }
                        }
                        if (attributesPdf.getPage() > -1) {
                            int page = attributesPdf.getPage();
                            i3 = page + 1;
                            i4 = page;
                        } else {
                            i3 = pageCount;
                            i4 = 0;
                        }
                        double step = ((PrintThread) this.callback).getCallback().getStep();
                        double d3 = i3 - (i4 == true ? 1 : 0);
                        Double.isNaN(d3);
                        double d4 = step / d3;
                        double start = ((PrintThread) this.callback).getCallback().getStart();
                        int i5 = 0;
                        int i6 = i4;
                        while (i6 < i3 && !isCancelled()) {
                            AbstractRawBtPrintService callback = ((PrintThread) this.callback).getCallback();
                            String idJob2 = getIdJob();
                            double d5 = i5;
                            Double.isNaN(d5);
                            callback.initCommandProgress(idJob2, start + (d5 * d4), d4);
                            int i7 = i5 + 1;
                            if (posDriverInterface.isError()) {
                                try {
                                    y.a(pdfRenderer3).close();
                                    return;
                                } catch (Exception unused2) {
                                    return;
                                }
                            }
                            posDriverInterface.clearBuf();
                            PdfRenderer.Page pageOpenPage = pdfRenderer3.openPage(i6);
                            Locale locale = Locale.getDefault();
                            int i8 = i6 + 1;
                            Integer numValueOf = Integer.valueOf(i8);
                            Integer numValueOf2 = Integer.valueOf(pageCount);
                            try {
                                Object[] objArr = new Object[2];
                                objArr[0] = numValueOf;
                                objArr[c3] = numValueOf2;
                                posDriverInterface.transportMessage(String.format(locale, "Render page %d / %d", objArr));
                                pdfRenderer = pdfRenderer3;
                                double d6 = d4;
                                try {
                                    if (GraphLibrary.myRenderPdfPage(this.callback.getContext(), pageOpenPage, attributesPdf, attributesImage, posDriverInterface.getPrinterProfile().getDots_per_line(), -1, -16777216, posDriverInterface) != null) {
                                        if (!posDriverInterface.isError() && this.callback.isFreeVersion()) {
                                            ((PrintThread) this.callback).getCallback().setStep(0.0d);
                                            this.callback.print_free_note(posDriverInterface);
                                            ((PrintThread) this.callback).getCallback().setStep(d6);
                                            setPremium(false);
                                        }
                                        if (attributesPdf.getRotate() > 0) {
                                            posDriverInterface.scrollPaper(2);
                                        }
                                        if (attributesPdf.isPaperCutAfterEachPage()) {
                                            posDriverInterface.scrollPaper(posDriverInterface.getPrinterProfile().getSkipLinesAfterJob());
                                            posDriverInterface.cutPaper();
                                        }
                                    }
                                    pageOpenPage.close();
                                    d4 = d6;
                                    i5 = i7;
                                    i6 = i8;
                                    pdfRenderer3 = pdfRenderer;
                                    c3 = 1;
                                } catch (Exception e5) {
                                    e = e5;
                                    pdfRenderer2 = pdfRenderer;
                                    e.printStackTrace();
                                    this.callback.showError(getIdJob(), e.getLocalizedMessage());
                                    Objects.requireNonNull(pdfRenderer2);
                                    pdfRendererA = y.a(pdfRenderer2);
                                    r3 = pdfRenderer2;
                                    pdfRendererA.close();
                                } catch (OutOfMemoryError e6) {
                                    e = e6;
                                    pdfRenderer2 = pdfRenderer;
                                    e.printStackTrace();
                                    this.callback.showError(getIdJob(), e.getLocalizedMessage());
                                    Objects.requireNonNull(pdfRenderer2);
                                    pdfRendererA = y.a(pdfRenderer2);
                                    r3 = pdfRenderer2;
                                    pdfRendererA.close();
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Exception e7) {
                                e = e7;
                                pdfRenderer = pdfRenderer3;
                                pdfRenderer2 = pdfRenderer;
                                e.printStackTrace();
                                this.callback.showError(getIdJob(), e.getLocalizedMessage());
                                Objects.requireNonNull(pdfRenderer2);
                                pdfRendererA = y.a(pdfRenderer2);
                                r3 = pdfRenderer2;
                                pdfRendererA.close();
                            } catch (OutOfMemoryError e8) {
                                e = e8;
                                pdfRenderer = pdfRenderer3;
                                pdfRenderer2 = pdfRenderer;
                                e.printStackTrace();
                                this.callback.showError(getIdJob(), e.getLocalizedMessage());
                                Objects.requireNonNull(pdfRenderer2);
                                pdfRendererA = y.a(pdfRenderer2);
                                r3 = pdfRenderer2;
                                pdfRendererA.close();
                            }
                            r3 = pdfRenderer;
                            try {
                                Objects.requireNonNull(r3);
                                y.a(r3).close();
                            } catch (Exception unused3) {
                            }
                            throw th;
                        }
                        pdfRendererA = y.a(pdfRenderer3);
                        r3 = i6;
                    } catch (Throwable th3) {
                        th = th3;
                        pdfRenderer = pdfRenderer3;
                    }
                } catch (Exception e9) {
                    e = e9;
                } catch (OutOfMemoryError e10) {
                    e = e10;
                }
            } catch (Exception e11) {
                e = e11;
            } catch (OutOfMemoryError e12) {
                e = e12;
            }
            pdfRendererA.close();
        } catch (Exception unused4) {
        }
    }
}
