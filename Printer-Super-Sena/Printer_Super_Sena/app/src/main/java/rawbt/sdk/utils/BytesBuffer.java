package rawbt.sdk.utils;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class BytesBuffer {
    private final ArrayList<byte[]> buf = new ArrayList<>();

    public void add(byte[] bArr) {
        this.buf.add(bArr);
    }

    public void clear() {
        this.buf.clear();
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
        return bArr;
    }
}
