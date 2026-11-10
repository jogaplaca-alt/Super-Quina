package rawbt.sdk.transport;

import android.content.Intent;
import android.graphics.Bitmap;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import rawbt.sdk.RawbtConstants;
import rawbt.sdk.emulator.escpos.EscPosEmulator;
import rawbt.sdk.emulator.escpos.PrinterCommand;
import rawbt.sdk.utils.Saver;

/* JADX INFO: loaded from: classes.dex */
public class PrintToGallery implements Transport {
    Transport.CallBack driver = null;
    private final ArrayList<byte[]> buf = new ArrayList<>();
    boolean isConnect = false;

    public void clear() {
        this.buf.clear();
    }

    @Override // rawbt.sdk.transport.Transport
    public String connect() {
        this.isConnect = true;
        return RawbtConstants.OK;
    }

    @Override // rawbt.sdk.transport.Transport
    public void disconnect() {
        this.isConnect = false;
        if (this.driver.isCancelled() || this.driver.isError()) {
            return;
        }
        try {
            EscPosEmulator escPosEmulator = new EscPosEmulator(this.driver.getContext(), getBuffer(), "cp437", this.driver.getPrinterProfile().getDots_per_line());
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
                String strSaveToGallery = new Saver(this.driver.getContext()).saveToGallery(bitmapCreateBitmap);
                Intent intent = new Intent("rawbt.sdk.emulator.new_image");
                intent.putExtra("NAME", strSaveToGallery);
                this.driver.getContext().sendBroadcast(intent);
            }
            escPosEmulator.randomAccessFile.close();
            escPosEmulator.file.delete();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public byte[] getBuffer() {
        Iterator<byte[]> it = this.buf.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += it.next().length;
        }
        byte[] bArr = new byte[length];
        int i3 = 0;
        for (byte[] bArr2 : this.buf) {
            for (byte b3 : bArr2) {
                bArr[i3] = b3;
                i3++;
            }
        }
        clear();
        return bArr;
    }

    @Override // rawbt.sdk.transport.Transport
    public void injectDriver(Transport.CallBack callBack) {
        this.driver = callBack;
    }

    @Override // rawbt.sdk.transport.Transport
    public boolean isConnected() {
        return this.isConnect;
    }

    @Override // rawbt.sdk.transport.Transport
    public String write(byte[] bArr) {
        this.buf.add(bArr);
        if (bArr.length <= 0) {
            return RawbtConstants.OK;
        }
        this.driver.sentToDevice(bArr);
        return RawbtConstants.OK;
    }
}
