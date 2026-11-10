package androidx.room;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class B implements Z.h, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f6242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Callable f6243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f6244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Z.h f6245f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private C0374f f6246g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6247h;

    public B(Context context, String str, File file, Callable callable, int i3, Z.h hVar) {
        S1.k.e(context, "context");
        S1.k.e(hVar, "delegate");
        this.f6240a = context;
        this.f6241b = str;
        this.f6242c = file;
        this.f6243d = callable;
        this.f6244e = i3;
        this.f6245f = hVar;
    }

    private final void I(boolean z3) {
        String databaseName = getDatabaseName();
        if (databaseName == null) {
            throw new IllegalStateException("Required value was null.");
        }
        File databasePath = this.f6240a.getDatabasePath(databaseName);
        C0374f c0374f = this.f6246g;
        C0374f c0374f2 = null;
        if (c0374f == null) {
            S1.k.n("databaseConfiguration");
            c0374f = null;
        }
        p005b0.a aVar = new p005b0.a(databaseName, this.f6240a.getFilesDir(), c0374f.f6319s);
        try {
            p005b0.a.c(aVar, false, 1, null);
            if (!databasePath.exists()) {
                try {
                    S1.k.d(databasePath, "databaseFile");
                    t(databasePath, z3);
                    aVar.d();
                    return;
                } catch (IOException e3) {
                    throw new RuntimeException("Unable to copy database file.", e3);
                }
            }
            try {
                S1.k.d(databasePath, "databaseFile");
                int iC = X.b.c(databasePath);
                if (iC == this.f6244e) {
                    aVar.d();
                    return;
                }
                C0374f c0374f3 = this.f6246g;
                if (c0374f3 == null) {
                    S1.k.n("databaseConfiguration");
                } else {
                    c0374f2 = c0374f3;
                }
                if (c0374f2.a(iC, this.f6244e)) {
                    aVar.d();
                    return;
                }
                if (this.f6240a.deleteDatabase(databaseName)) {
                    try {
                        t(databasePath, z3);
                    } catch (IOException e4) {
                        Log.w("ROOM", "Unable to copy database file.", e4);
                    }
                } else {
                    Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                aVar.d();
                return;
            } catch (IOException e5) {
                Log.w("ROOM", "Unable to read database version.", e5);
                aVar.d();
                return;
            }
        } catch (Throwable th) {
            aVar.d();
            throw th;
        }
        aVar.d();
        throw th;
    }

    private final void t(File file, boolean z3) throws IOException {
        ReadableByteChannel readableByteChannelNewChannel;
        if (this.f6241b != null) {
            readableByteChannelNewChannel = Channels.newChannel(this.f6240a.getAssets().open(this.f6241b));
            S1.k.d(readableByteChannelNewChannel, "newChannel(context.assets.open(copyFromAssetPath))");
        } else if (this.f6242c != null) {
            readableByteChannelNewChannel = new FileInputStream(this.f6242c).getChannel();
            S1.k.d(readableByteChannelNewChannel, "FileInputStream(copyFromFile).channel");
        } else {
            Callable callable = this.f6243d;
            if (callable == null) {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
            try {
                readableByteChannelNewChannel = Channels.newChannel((InputStream) callable.call());
                S1.k.d(readableByteChannelNewChannel, "newChannel(inputStream)");
            } catch (Exception e3) {
                throw new IOException("inputStreamCallable exception on call", e3);
            }
        }
        File fileCreateTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f6240a.getCacheDir());
        fileCreateTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(fileCreateTempFile).getChannel();
        S1.k.d(channel, "output");
        X.c.a(readableByteChannelNewChannel, channel);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        S1.k.d(fileCreateTempFile, "intermediateFile");
        y(fileCreateTempFile, z3);
        if (fileCreateTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + fileCreateTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    private final void y(File file, boolean z3) {
        C0374f c0374f = this.f6246g;
        if (c0374f == null) {
            S1.k.n("databaseConfiguration");
            c0374f = null;
        }
        c0374f.getClass();
    }

    @Override // Z.h
    public Z.g A() {
        if (!this.f6247h) {
            I(true);
            this.f6247h = true;
        }
        return g().A();
    }

    public final void G(C0374f c0374f) {
        S1.k.e(c0374f, "databaseConfiguration");
        this.f6246g = c0374f;
    }

    @Override // Z.h, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        g().close();
        this.f6247h = false;
    }

    @Override // androidx.room.g
    public Z.h g() {
        return this.f6245f;
    }

    @Override // Z.h
    public String getDatabaseName() {
        return g().getDatabaseName();
    }

    @Override // Z.h
    public void setWriteAheadLoggingEnabled(boolean z3) {
        g().setWriteAheadLoggingEnabled(z3);
    }
}
