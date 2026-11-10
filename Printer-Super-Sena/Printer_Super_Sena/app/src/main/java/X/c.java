package X;

import S1.k;
import android.os.Build;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static final void a(ReadableByteChannel readableByteChannel, FileChannel fileChannel) throws IOException {
        k.e(readableByteChannel, "input");
        k.e(fileChannel, "output");
        try {
            if (Build.VERSION.SDK_INT <= 23) {
                InputStream inputStreamNewInputStream = Channels.newInputStream(readableByteChannel);
                OutputStream outputStreamNewOutputStream = Channels.newOutputStream(fileChannel);
                byte[] bArr = new byte[4096];
                while (true) {
                    int i3 = inputStreamNewInputStream.read(bArr);
                    if (i3 <= 0) {
                        break;
                    } else {
                        outputStreamNewOutputStream.write(bArr, 0, i3);
                    }
                }
            } else {
                fileChannel.transferFrom(readableByteChannel, 0L, Long.MAX_VALUE);
            }
            fileChannel.force(false);
        } finally {
            readableByteChannel.close();
            fileChannel.close();
        }
    }
}
