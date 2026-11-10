package rawbt.sdk.drivers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import com.iposprinter.iposprinterservice.a;
import com.iposprinter.iposprinterservice.b;
import java.nio.channels.FileChannel;
import rawbt.api.Constant;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.RawbtConstants;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.emulator.escpos.EscPosEmulator;
import rawbt.sdk.emulator.escpos.PrinterCommand;
import rawbt.sdk.transport.ConnectParameters;

/* JADX INFO: loaded from: classes.dex */
public class Aidl_iPOS_Printer extends AbstractDriver implements IVirtualEscPos {
    private static final String SERVICE_ACTION = "com.iposprinter.iposprinterservice.IPosPrintService";
    private static final String SERVICE_PACKAGE = "com.iposprinter.iposprinterservice";
    private b iPosService;
    PrinterEntity printerProfile;
    private final a callback = new a.AbstractBinderC0108a() { // from class: rawbt.sdk.drivers.Aidl_iPOS_Printer.1
        @Override // com.iposprinter.iposprinterservice.a
        public void onReturnString(String str) {
            try {
                Aidl_iPOS_Printer aidl_iPOS_Printer = Aidl_iPOS_Printer.this;
                aidl_iPOS_Printer.statusNotify(aidl_iPOS_Printer.iPosService.B());
            } catch (RemoteException e3) {
                e3.printStackTrace();
            }
        }

        @Override // com.iposprinter.iposprinterservice.a
        public void onRunResult(boolean z3) {
        }
    };
    private final ServiceConnection connectService = new ServiceConnection() { // from class: rawbt.sdk.drivers.Aidl_iPOS_Printer.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Aidl_iPOS_Printer.this.iPosService = b.a.c(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Aidl_iPOS_Printer.this.iPosService = null;
        }
    };
    private String virtual_code_page = "cp437";
    private int virtual_width = 384;
    boolean isConnected = false;

    public Aidl_iPOS_Printer(PrinterEntity printerEntity, Context context) {
        this.printerProfile = printerEntity;
        setContext(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean statusNotify(int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                setErrorMessage("Paper less");
            } else {
                if (i3 == 2) {
                    setErrorMessage("Thermal head high temperature");
                    return false;
                }
                if (i3 == 3) {
                    setErrorMessage("Motor high temperature");
                    return false;
                }
                if (i3 == 4) {
                    transportMessage("Printer is busy");
                    return true;
                }
                if (i3 == 5) {
                    setErrorMessage("Printer abnormal");
                    return false;
                }
            }
        }
        return false;
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
        getContext().bindService(intent, this.connectService, 64);
        for (int i3 = 0; this.iPosService == null && i3 < 30 && !isCancelled(); i3++) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
        if (this.iPosService == null) {
            return "not binding";
        }
        this.isConnected = true;
        return RawbtConstants.OK;
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void cutPaper() {
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void disconnectPrinter() {
        this.isConnected = false;
        if (this.iPosService != null) {
            getContext().unbindService(this.connectService);
            this.iPosService = null;
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void finish() {
        int iB;
        int i3 = 0;
        while (i3 < 90) {
            try {
                int iB2 = this.iPosService.B();
                if (iB2 == 0) {
                    break;
                }
                if (statusNotify(iB2)) {
                    Thread.sleep(500L);
                    i3++;
                } else if (iB2 != 0) {
                    return;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        if (i3 < 1) {
            this.iPosService.q(0, this.callback);
            while (i3 < 30 && (iB = this.iPosService.B()) != 0) {
                if (statusNotify(iB)) {
                    Thread.sleep(500L);
                    i3++;
                } else if (iB != 0) {
                    return;
                }
            }
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface, rawbt.sdk.transport.Transport.CallBack
    public PrinterEntity getPrinterProfile() {
        return this.printerProfile;
    }

    @Override // rawbt.sdk.drivers.AbstractDriver
    protected void graphics(byte[] bArr, int i3, int i4) {
        try {
            int[] iArr = new int[i3 * i4];
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                for (int i7 = 0; i7 < i3; i7++) {
                    if (bArr[i5] == 0) {
                        iArr[i5] = -1;
                    } else {
                        iArr[i5] = -16777216;
                    }
                    i5++;
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, i3, 0, 0, i3, i4);
            this.iPosService.z(0, 16, bitmapCreateBitmap, this.callback);
        } catch (Exception e3) {
            transportError(e3.getLocalizedMessage());
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void initialize() {
        int i3 = 0;
        int iB = 0;
        while (i3 < 30) {
            try {
                iB = this.iPosService.B();
                if (iB == 0) {
                    break;
                }
                if (statusNotify(iB)) {
                    Thread.sleep(500L);
                    i3++;
                } else if (iB != 0) {
                    return;
                }
            } catch (Exception e3) {
                transportError(e3.getLocalizedMessage());
                return;
            }
        }
        if (iB != 0) {
            transportError("Printer not ready");
        } else {
            this.iPosService.n(this.callback);
        }
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
        try {
            this.iPosService.q(i3 * 24, this.callback);
        } catch (RemoteException e3) {
            e3.printStackTrace();
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
        int i3;
        String strTrim = str.trim();
        if (strTrim.length() < 1) {
            return;
        }
        int i4 = attributesString.getPrinterFont() == 2 ? 16 : 24;
        if (attributesString.isDoubleWidth() || attributesString.isDoubleHeight()) {
            i4 = 32;
        }
        int i5 = (attributesString.isDoubleWidth() && attributesString.isDoubleHeight()) ? 48 : i4;
        String alignment = attributesString.getAlignment();
        alignment.hashCode();
        if (alignment.equals(Constant.ALIGNMENT_CENTER)) {
            i3 = 1;
        } else {
            i3 = !alignment.equals(Constant.ALIGNMENT_RIGHT) ? 0 : 2;
        }
        try {
            this.iPosService.N(strTrim, "ST", i5, i3, this.callback);
        } catch (RemoteException e3) {
            e3.printStackTrace();
        }
    }
}
