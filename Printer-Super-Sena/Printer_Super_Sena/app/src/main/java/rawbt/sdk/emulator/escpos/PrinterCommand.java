package rawbt.sdk.emulator.escpos;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class PrinterCommand {
    static final boolean OFF = false;
    static final boolean ON = true;
    private int paramPos = 0;

    public abstract void apply(EscPosEmulator escPosEmulator);

    public int get_length() {
        return 1;
    }

    boolean paramOnOff(byte b3) throws Exception {
        if (b3 == 0 || b3 == 48) {
            return false;
        }
        if (b3 == 1 || b3 == 49) {
            return ON;
        }
        throw new Exception("ON/OFF param error");
    }

    int read32(EscPosEmulator escPosEmulator) {
        int i3 = escPosEmulator.input_pointer;
        int i4 = this.paramPos;
        int i5 = i3 + i4;
        byte[] bArr = escPosEmulator.input;
        int i6 = ((bArr[i5 + 1] & 255) * 256) + (bArr[i5] & 255);
        this.paramPos = i4 + 2;
        return i6;
    }

    byte readByte(EscPosEmulator escPosEmulator) {
        byte[] bArr = escPosEmulator.input;
        int i3 = escPosEmulator.input_pointer;
        int i4 = this.paramPos;
        byte b3 = bArr[i3 + i4];
        this.paramPos = i4 + 1;
        return b3;
    }

    int readByteNormParam(EscPosEmulator escPosEmulator) {
        int i3 = readByte(escPosEmulator) & 255;
        return i3 > 48 ? i3 - 48 : i3;
    }

    byte[] readBytes(EscPosEmulator escPosEmulator, int i3) throws Exception {
        int i4 = escPosEmulator.input_pointer;
        int i5 = this.paramPos;
        int i6 = i4 + i5;
        int i7 = i6 + i3;
        if (i7 > escPosEmulator.input_length) {
            throw new Exception("out of input stream");
        }
        this.paramPos = i5 + i3;
        return Arrays.copyOfRange(escPosEmulator.input, i6, i7);
    }

    void setParamPos(int i3) {
        this.paramPos = i3;
    }
}
