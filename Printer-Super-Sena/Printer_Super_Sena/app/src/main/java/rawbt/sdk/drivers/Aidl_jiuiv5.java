package rawbt.sdk.drivers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import java.nio.channels.FileChannel;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.RawbtConstants;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.emulator.escpos.EscPosEmulator;
import rawbt.sdk.emulator.escpos.PrinterCommand;
import rawbt.sdk.transport.ConnectParameters;
import woyou.aidlservice.jiuiv5.a;
import woyou.aidlservice.jiuiv5.b;

/* JADX INFO: loaded from: classes.dex */
public class Aidl_jiuiv5 extends AbstractDriver implements IVirtualEscPos {
    private static final String SERVICE_ACTION = "woyou.aidlservice.jiuiv5.IWoyouService";
    private static final String SERVICE_PACKAGE = "woyou.aidlservice.jiuiv5";
    private static final String TAG = "Aidl_jiuiv5";
    private b IposService;
    final PrinterEntity printerProfile;
    private a callback = null;
    private final ServiceConnection connectService = new ServiceConnection() { // from class: rawbt.sdk.drivers.Aidl_jiuiv5.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Aidl_jiuiv5.this.IposService = b.a.c(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Aidl_jiuiv5.this.IposService = null;
        }
    };
    private String virtual_code_page = "cp437";
    private int virtual_width = 384;
    boolean isConnected = false;

    public Aidl_jiuiv5(PrinterEntity printerEntity, Context context) {
        this.printerProfile = printerEntity;
        setContext(context);
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
        this.callback = new a.AbstractBinderC0140a() { // from class: rawbt.sdk.drivers.Aidl_jiuiv5.2
            @Override // woyou.aidlservice.jiuiv5.a
            public void onPrintResult(int i3, String str) {
            }

            @Override // woyou.aidlservice.jiuiv5.a
            public void onRaiseException(int i3, String str) {
                Aidl_jiuiv5.this.transportError("raise exception");
            }

            @Override // woyou.aidlservice.jiuiv5.a
            public void onReturnString(String str) {
            }

            @Override // woyou.aidlservice.jiuiv5.a
            public void onRunResult(boolean z3) {
            }
        };
        Intent intent = new Intent();
        intent.setPackage(SERVICE_PACKAGE);
        intent.setAction(SERVICE_ACTION);
        getContext().bindService(intent, this.connectService, 64);
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        if (this.IposService == null) {
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
            this.IposService.j(bitmapCreateBitmap, this.callback);
        } catch (Exception e3) {
            transportError(e3.getLocalizedMessage());
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void initialize() {
        try {
            this.IposService.s(this.callback);
        } catch (RemoteException unused) {
            transportError("not init");
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
            this.IposService.J(i3, this.callback);
        } catch (RemoteException unused) {
            transportError("not line scroll");
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
            this.IposService.k(str, this.callback);
        } catch (RemoteException unused) {
            transportError("not print text");
        }
    }
}
