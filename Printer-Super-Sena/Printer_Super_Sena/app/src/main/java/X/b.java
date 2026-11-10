package X;

import J1.l;
import K1.n;
import S1.k;
import Z.g;
import Z.j;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final void a(g gVar) throws IOException {
        k.e(gVar, "db");
        List listC = n.c();
        Cursor cursorD = gVar.D("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorD.moveToNext()) {
            try {
                listC.add(cursorD.getString(0));
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    P1.a.a(cursorD, th);
                    throw th2;
                }
            }
        }
        l lVar = l.f1194a;
        P1.a.a(cursorD, null);
        for (String str : n.a(listC)) {
            k.d(str, "triggerName");
            if (X1.c.l(str, "room_fts_content_sync_", false, 2, null)) {
                gVar.j("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    public static final Cursor b(u uVar, j jVar, boolean z3, CancellationSignal cancellationSignal) {
        k.e(uVar, "db");
        k.e(jVar, "sqLiteQuery");
        Cursor cursorY = uVar.y(jVar, cancellationSignal);
        if (!z3 || !(cursorY instanceof AbstractWindowedCursor)) {
            return cursorY;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorY;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? a.a(cursorY) : cursorY;
    }

    public static final int c(File file) throws IOException {
        k.e(file, "databaseFile");
        FileChannel channel = new FileInputStream(file).getChannel();
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i3 = byteBufferAllocate.getInt();
            P1.a.a(channel, null);
            return i3;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                P1.a.a(channel, th);
                throw th2;
            }
        }
    }
}
