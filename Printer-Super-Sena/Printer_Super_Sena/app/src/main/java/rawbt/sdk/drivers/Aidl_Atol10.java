package rawbt.sdk.drivers;

import C2.a;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.util.Base64;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import p075w1.e;
import rawbt.api.Constant;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.RawbtConstants;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.emulator.escpos.EscPosEmulator;
import rawbt.sdk.emulator.escpos.PrinterCommand;
import rawbt.sdk.transport.ConnectParameters;

/* JADX INFO: loaded from: classes.dex */
public class Aidl_Atol10 extends AbstractDriver implements IVirtualEscPos {
    private static final String SERVICE_ACTION = "ru.atol.drivers10.service.SERVICE";
    private static final String SERVICE_PACKAGE = "ru.atol.drivers10.service";
    private a IposService;
    final PrinterEntity printerProfile;
    private final ServiceConnection connectService = new ServiceConnection() { // from class: rawbt.sdk.drivers.Aidl_Atol10.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Aidl_Atol10.this.IposService = a.AbstractBinderC0003a.c(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Aidl_Atol10.this.IposService = null;
        }
    };
    private String virtual_code_page = "cp437";
    private int virtual_width = 384;
    boolean isConnected = false;

    static abstract class docItems {
        docItems() {
        }
    }

    static class itemPicture extends docItems {
        public String pixels;
        public int width;
        public String type = "pixels";
        public int scale = 100;
        public String aligment = Constant.ALIGNMENT_LEFT;

        itemPicture(byte[] bArr, int i3) {
            this.pixels = Base64.encodeToString(bArr, 0);
            this.width = i3;
        }
    }

    static class itemText extends docItems {
        public String text;
        public String type = "text";
        public String aligment = Constant.ALIGNMENT_LEFT;
        public String wrap = "chars";
        public int font = 0;
        public boolean doubleWidth = false;
        public boolean doubleHeight = false;

        itemText(String str) {
            this.text = str;
        }
    }

    static class nonFiscal {
        public String type = "nonFiscal";
        ArrayList<docItems> items = new ArrayList<>();
        public boolean printFooter = false;

        nonFiscal() {
        }
    }

    public Aidl_Atol10(PrinterEntity printerEntity, Context context) {
        this.printerProfile = printerEntity;
        setContext(context);
    }

    private void printPixels(byte[] bArr, int i3) {
        try {
            nonFiscal nonfiscal = new nonFiscal();
            nonfiscal.items.add(new itemPicture(bArr, i3));
            this.IposService.h(new e().b().s(nonfiscal));
        } catch (Exception e3) {
            transportError(e3.getLocalizedMessage());
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void bytes(byte[] bArr) {
        try {
            EscPosEmulator escPosEmulator = new EscPosEmulator(getContext(), bArr, this.virtual_code_page, this.virtual_width);
            while (!escPosEmulator.isEnd()) {
                escPosEmulator.commandMessage = null;
                PrinterCommand command = escPosEmulator.getCommand();
                try {
                    command.apply(escPosEmulator);
                } catch (Error | Exception unused) {
                }
                escPosEmulator.input_pointer += command.get_length();
                if (escPosEmulator.output_height > 32000) {
                    break;
                }
            }
            int i3 = escPosEmulator.output_height;
            if (i3 > 0) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(escPosEmulator.max_dots, i3, Bitmap.Config.ARGB_8888);
                FileChannel channel = escPosEmulator.randomAccessFile.getChannel();
                bitmapCreateBitmap.copyPixelsFromBuffer(channel.map(FileChannel.MapMode.READ_WRITE, 0L, bitmapCreateBitmap.getRowBytes() * bitmapCreateBitmap.getHeight()));
                channel.close();
                printImage(bitmapCreateBitmap, new AttributesImage(0));
            }
            escPosEmulator.randomAccessFile.close();
            escPosEmulator.file.delete();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public String connectPrinter(ConnectParameters connectParameters) {
        Intent intent = new Intent();
        intent.setPackage(SERVICE_PACKAGE);
        intent.setAction(SERVICE_ACTION);
        transportMessage("binding ...");
        getContext().bindService(intent, this.connectService, 1);
        for (int i3 = 0; this.IposService == null && i3 < 30 && !isCancelled(); i3++) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
        if (this.IposService == null) {
            return "not binding";
        }
        transportMessage("bind ok");
        this.isConnected = true;
        return RawbtConstants.OK;
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void cutPaper() {
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void disconnectPrinter() {
        this.isConnected = false;
        if (this.IposService != null) {
            getContext().unbindService(this.connectService);
            this.IposService = null;
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void finish() {
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface, rawbt.sdk.transport.Transport.CallBack
    public PrinterEntity getPrinterProfile() {
        return this.printerProfile;
    }

    @Override // rawbt.sdk.drivers.AbstractDriver
    public void graphics(byte[] bArr, int i3, int i4) {
        int i5;
        try {
            byte[] bArr2 = new byte[i3 * 384];
            if (i4 > 384) {
                i5 = 0;
                int i6 = 0;
                for (int i7 = 0; i7 < i4 - 384; i7 += 384) {
                    for (int i8 = 0; i8 < 384; i8++) {
                        for (int i9 = 0; i9 < i3; i9++) {
                            int i10 = i8 * i3;
                            bArr2[i10 + i9] = bArr[(i7 * i3) + i10 + i9];
                        }
                    }
                    printPixels(bArr2, i3);
                    int i11 = (i7 * 100) / i4;
                    if (i11 > i6 + 5) {
                        stepPercent(i11);
                        i6 = i11;
                    }
                    i5++;
                }
            } else {
                i5 = 0;
            }
            int i12 = 384 * i5;
            int i13 = i4 - i12;
            if (i13 > 0) {
                byte[] bArr3 = new byte[i3 * i13];
                for (int i14 = 0; i14 < i13; i14++) {
                    for (int i15 = 0; i15 < i3; i15++) {
                        int i16 = i14 * i3;
                        bArr3[i16 + i15] = bArr[(i12 * i3) + i16 + i15];
                    }
                }
                printPixels(bArr3, i3);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void initialize() {
    }

    @Override // rawbt.sdk.drivers.IVirtualEscPos
    public void injectVirtual(String str, int i3) {
        this.virtual_code_page = str;
        this.virtual_width = i3;
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public boolean isConnected() {
        return this.isConnected;
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public void receiveFromDevice(byte[] bArr) {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.receiveFromDevice(bArr);
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void scrollPaper(int i3) {
        while (i3 > 0) {
            text("", new AttributesString());
            i3--;
        }
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public void sentToDevice(byte[] bArr) {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.sentToDevice(bArr);
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void text(String str, AttributesString attributesString) {
        try {
            nonFiscal nonfiscal = new nonFiscal();
            itemText itemtext = new itemText(str);
            itemtext.aligment = attributesString.getAlignment();
            itemtext.doubleHeight = attributesString.isDoubleHeight();
            itemtext.doubleWidth = attributesString.isDoubleWidth();
            int printerFont = attributesString.getPrinterFont() - 1;
            if (printerFont > 0 && printerFont < 4) {
                itemtext.font = printerFont;
            }
            nonfiscal.items.add(itemtext);
            this.IposService.h(new e().b().s(nonfiscal));
        } catch (Exception e3) {
            transportError(e3.getLocalizedMessage());
        }
    }
}
