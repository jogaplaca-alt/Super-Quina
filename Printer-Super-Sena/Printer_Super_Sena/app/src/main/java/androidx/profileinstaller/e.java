package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AssetManager f5687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f5688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k.c f5689c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f5691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f5692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f5693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f5694h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private f[] f5696j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f5697k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f5695i = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f5690d = d();

    public e(AssetManager assetManager, Executor executor, k.c cVar, String str, String str2, String str3, File file) {
        this.f5687a = assetManager;
        this.f5688b = executor;
        this.f5689c = cVar;
        this.f5692f = str;
        this.f5693g = str2;
        this.f5694h = str3;
        this.f5691e = file;
    }

    private e b(f[] fVarArr, byte[] bArr) {
        try {
            InputStream inputStreamH = h(this.f5687a, this.f5694h);
            if (inputStreamH == null) {
                if (inputStreamH != null) {
                    inputStreamH.close();
                }
                return null;
            }
            try {
                this.f5696j = p.q(inputStreamH, p.o(inputStreamH, p.f5725b), bArr, fVarArr);
                inputStreamH.close();
                return this;
            } catch (Throwable th) {
                try {
                    inputStreamH.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (FileNotFoundException e3) {
            this.f5689c.b(9, e3);
        } catch (IOException e4) {
            this.f5689c.b(7, e4);
        } catch (IllegalStateException e5) {
            this.f5696j = null;
            this.f5689c.b(8, e5);
        }
    }

    private void c() {
        if (!this.f5695i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] d() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 24 || i3 > 33) {
            return null;
        }
        switch (i3) {
            case 24:
            case 25:
                return r.f5740e;
            case 26:
                return r.f5739d;
            case 27:
                return r.f5738c;
            case 28:
            case 29:
            case 30:
                return r.f5737b;
            case 31:
            case 32:
            case 33:
                return r.f5736a;
            default:
                return null;
        }
    }

    private InputStream f(AssetManager assetManager) {
        try {
            return h(assetManager, this.f5693g);
        } catch (FileNotFoundException e3) {
            this.f5689c.b(6, e3);
            return null;
        } catch (IOException e4) {
            this.f5689c.b(7, e4);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i3, Object obj) {
        this.f5689c.b(i3, obj);
    }

    private InputStream h(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e3) {
            String message = e3.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f5689c.a(5, null);
            }
            return null;
        }
    }

    private f[] j(InputStream inputStream) {
        try {
            try {
                try {
                    try {
                        f[] fVarArrW = p.w(inputStream, p.o(inputStream, p.f5724a), this.f5692f);
                        try {
                            return fVarArrW;
                        } catch (IOException e3) {
                            return fVarArrW;
                        }
                    } catch (IOException e4) {
                        this.f5689c.b(7, e4);
                        return null;
                    }
                } catch (IllegalStateException e5) {
                    this.f5689c.b(8, e5);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e6) {
                this.f5689c.b(7, e6);
                inputStream.close();
                return null;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e7) {
                this.f5689c.b(7, e7);
            }
        }
    }

    private static boolean k() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 24 || i3 > 33) {
            return false;
        }
        if (i3 != 24 && i3 != 25) {
            switch (i3) {
                case 31:
                case 32:
                case 33:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private void l(final int i3, final Object obj) {
        this.f5688b.execute(new Runnable() { // from class: androidx.profileinstaller.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f5684a.g(i3, obj);
            }
        });
    }

    public boolean e() {
        if (this.f5690d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (this.f5691e.canWrite()) {
            this.f5695i = true;
            return true;
        }
        l(4, null);
        return false;
    }

    public e i() {
        e eVarB;
        c();
        if (this.f5690d == null) {
            return this;
        }
        InputStream inputStreamF = f(this.f5687a);
        if (inputStreamF != null) {
            this.f5696j = j(inputStreamF);
        }
        f[] fVarArr = this.f5696j;
        return (fVarArr == null || !k() || (eVarB = b(fVarArr, this.f5690d)) == null) ? this : eVarB;
    }

    public e m() {
        f[] fVarArr = this.f5696j;
        byte[] bArr = this.f5690d;
        if (fVarArr != null && bArr != null) {
            c();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    p.E(byteArrayOutputStream, bArr);
                    if (!p.B(byteArrayOutputStream, bArr, fVarArr)) {
                        this.f5689c.b(5, null);
                        this.f5696j = null;
                        byteArrayOutputStream.close();
                        return this;
                    }
                    this.f5697k = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    this.f5696j = null;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e3) {
                this.f5689c.b(7, e3);
            } catch (IllegalStateException e4) {
                this.f5689c.b(8, e4);
            }
        }
        return this;
    }

    public boolean n() {
        byte[] bArr = this.f5697k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f5691e);
                    try {
                        g.l(byteArrayInputStream, fileOutputStream);
                        l(1, null);
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        this.f5697k = null;
                        this.f5696j = null;
                        return true;
                    } catch (Throwable th) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                this.f5697k = null;
                this.f5696j = null;
                throw th5;
            }
        } catch (FileNotFoundException e3) {
            l(6, e3);
            this.f5697k = null;
            this.f5696j = null;
            return false;
        } catch (IOException e4) {
            l(7, e4);
            this.f5697k = null;
            this.f5696j = null;
            return false;
        }
    }
}
