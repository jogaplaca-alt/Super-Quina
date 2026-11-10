package U;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes.dex */
final class c implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f1973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f1974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f1975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RandomAccessFile f1976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FileChannel f1977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FileLock f1978f;

    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    private static class b extends File {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f1980a;

        public b(File file, String str) {
            super(file, str);
            this.f1980a = -1L;
        }
    }

    c(File file, File file2) throws Throwable {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f1973a = file;
        this.f1975c = file2;
        this.f1974b = J(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f1976d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f1977e = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f1978f = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e3) {
                e = e3;
                t(this.f1977e);
                throw e;
            } catch (Error e4) {
                e = e4;
                t(this.f1977e);
                throw e;
            } catch (RuntimeException e5) {
                e = e5;
                t(this.f1977e);
                throw e;
            }
        } catch (IOException e6) {
            e = e6;
            t(this.f1976d);
            throw e;
        } catch (Error e7) {
            e = e7;
            t(this.f1976d);
            throw e;
        } catch (RuntimeException e8) {
            e = e8;
            t(this.f1976d);
            throw e;
        }
    }

    private static SharedPreferences G(Context context) {
        return context.getSharedPreferences("multidex.version", 4);
    }

    private static long I(File file) {
        long jLastModified = file.lastModified();
        return jLastModified == -1 ? jLastModified - 1 : jLastModified;
    }

    private static long J(File file) throws IOException {
        long jC = d.c(file);
        return jC == -1 ? jC - 1 : jC;
    }

    private static boolean K(Context context, File file, long j3, String str) {
        SharedPreferences sharedPreferencesG = G(context);
        if (sharedPreferencesG.getLong(str + "timestamp", -1L) == I(file)) {
            if (sharedPreferencesG.getLong(str + "crc", -1L) == j3) {
                return false;
            }
        }
        return true;
    }

    private List M(Context context, String str) throws IOException {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = this.f1973a.getName() + ".classes";
        SharedPreferences sharedPreferencesG = G(context);
        int i3 = sharedPreferencesG.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i3 + (-1));
        int i4 = 2;
        while (i4 <= i3) {
            b bVar = new b(this.f1975c, str2 + i4 + ".zip");
            if (!bVar.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + bVar.getPath() + "'");
            }
            bVar.f1980a = J(bVar);
            long j3 = sharedPreferencesG.getLong(str + "dex.crc." + i4, -1L);
            long j4 = sharedPreferencesG.getLong(str + "dex.time." + i4, -1L);
            long jLastModified = bVar.lastModified();
            if (j4 == jLastModified) {
                String str3 = str2;
                SharedPreferences sharedPreferences = sharedPreferencesG;
                if (j3 == bVar.f1980a) {
                    arrayList.add(bVar);
                    i4++;
                    sharedPreferencesG = sharedPreferences;
                    str2 = str3;
                }
            }
            throw new IOException("Invalid extracted dex: " + bVar + " (key \"" + str + "\"), expected modification time: " + j4 + ", modification time: " + jLastModified + ", expected crc: " + j3 + ", file crc: " + bVar.f1980a);
        }
        return arrayList;
    }

    private List N() {
        boolean z3;
        String str = this.f1973a.getName() + ".classes";
        g();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f1973a);
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            int i3 = 2;
            while (entry != null) {
                b bVar = new b(this.f1975c, str + i3 + ".zip");
                arrayList.add(bVar);
                Log.i("MultiDex", "Extraction is needed for file " + bVar);
                int i4 = 0;
                boolean z4 = false;
                while (i4 < 3 && !z4) {
                    int i5 = i4 + 1;
                    y(zipFile, entry, bVar, str);
                    try {
                        bVar.f1980a = J(bVar);
                        z3 = true;
                    } catch (IOException e3) {
                        Log.w("MultiDex", "Failed to read crc from " + bVar.getAbsolutePath(), e3);
                        z3 = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z3 ? "succeeded" : "failed");
                    sb.append(" '");
                    sb.append(bVar.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(bVar.length());
                    sb.append(" - crc: ");
                    sb.append(bVar.f1980a);
                    Log.i("MultiDex", sb.toString());
                    if (!z3) {
                        bVar.delete();
                        if (bVar.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + bVar.getPath() + "'");
                        }
                    }
                    z4 = z3;
                    i4 = i5;
                }
                if (!z4) {
                    throw new IOException("Could not create zip file " + bVar.getAbsolutePath() + " for secondary dex (" + i3 + ")");
                }
                i3++;
                entry = zipFile.getEntry("classes" + i3 + ".dex");
            }
            try {
                zipFile.close();
            } catch (IOException e4) {
                Log.w("MultiDex", "Failed to close resource", e4);
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                zipFile.close();
                throw th;
            } catch (IOException e5) {
                Log.w("MultiDex", "Failed to close resource", e5);
                throw th;
            }
        }
    }

    private static void O(Context context, String str, long j3, long j4, List list) {
        SharedPreferences.Editor editorEdit = G(context).edit();
        editorEdit.putLong(str + "timestamp", j3);
        editorEdit.putLong(str + "crc", j4);
        editorEdit.putInt(str + "dex.number", list.size() + 1);
        Iterator it = list.iterator();
        int i3 = 2;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            editorEdit.putLong(str + "dex.crc." + i3, bVar.f1980a);
            editorEdit.putLong(str + "dex.time." + i3, bVar.lastModified());
            i3++;
        }
        editorEdit.commit();
    }

    private void g() {
        File[] fileArrListFiles = this.f1975c.listFiles(new a());
        if (fileArrListFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f1975c.getPath() + ").");
            return;
        }
        for (File file : fileArrListFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            }
        }
    }

    private static void t(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e3) {
            Log.w("MultiDex", "Failed to close resource", e3);
        }
    }

    private static void y(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + fileCreateTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(fileCreateTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int i3 = inputStream.read(bArr); i3 != -1; i3 = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, i3);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (!fileCreateTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
                }
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (fileCreateTempFile.renameTo(file)) {
                    t(inputStream);
                    fileCreateTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            t(inputStream);
            fileCreateTempFile.delete();
            throw th2;
        }
    }

    List L(Context context, String str, boolean z3) {
        List listN;
        List listM;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.f1973a.getPath() + ", " + z3 + ", " + str + ")");
        if (!this.f1978f.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        if (!z3 && !K(context, this.f1973a, this.f1974b, str)) {
            try {
                listM = M(context, str);
            } catch (IOException e3) {
                Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e3);
                listN = N();
                O(context, str, I(this.f1973a), this.f1974b, listN);
                listM = listN;
            }
            Log.i("MultiDex", "load found " + listM.size() + " secondary dex files");
            return listM;
        }
        if (z3) {
            Log.i("MultiDex", "Forced extraction must be performed.");
        } else {
            Log.i("MultiDex", "Detected that extraction must be performed.");
        }
        listN = N();
        O(context, str, I(this.f1973a), this.f1974b, listN);
        listM = listN;
        Log.i("MultiDex", "load found " + listM.size() + " secondary dex files");
        return listM;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1978f.release();
        this.f1977e.close();
        this.f1976d.close();
    }
}
