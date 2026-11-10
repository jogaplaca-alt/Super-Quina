package o2;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintDocumentAdapter;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class c implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParcelFileDescriptor f10430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PrintDocumentAdapter.WriteResultCallback f10431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InputStream f10432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f10433d = new AtomicBoolean();

    static final class a implements CancellationSignal.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f10434a;

        a(c cVar) {
            this.f10434a = cVar;
        }

        @Override // android.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            this.f10434a.c();
        }
    }

    c(CancellationSignal cancellationSignal, InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        this.f10432c = inputStream;
        this.f10430a = parcelFileDescriptor;
        this.f10431b = writeResultCallback;
        cancellationSignal.setOnCancelListener(new a(this));
    }

    private void a(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] bArr = new byte[8192];
            while (!e()) {
                int i3 = inputStream.read(bArr);
                if (i3 <= 0) {
                    outputStream.flush();
                    break;
                }
                outputStream.write(bArr, 0, i3);
            }
        } finally {
            d(inputStream);
            d(outputStream);
        }
    }

    private static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void call() {
        try {
            a(this.f10432c, new ParcelFileDescriptor.AutoCloseOutputStream(this.f10430a));
            this.f10431b.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            this.f10431b.onWriteFailed("error_loading_for_printing");
            return null;
        }
    }

    public final void c() {
        this.f10433d.set(true);
    }

    public final boolean e() {
        return this.f10433d.get();
    }
}
