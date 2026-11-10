package o2;

import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class b extends PrintDocumentAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ExecutorService f10427a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InputStream f10429c;

    public b(String str, InputStream inputStream) {
        this.f10429c = inputStream;
        this.f10428b = str;
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
        layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f10428b).setContentType(0).setPageCount(-1).build(), false);
    }

    @Override // android.print.PrintDocumentAdapter
    public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        final c cVar = new c(cancellationSignal, this.f10429c, parcelFileDescriptor, writeResultCallback);
        this.f10427a.execute(new Runnable() { // from class: o2.a
            @Override // java.lang.Runnable
            public final void run() {
                cVar.call();
            }
        });
    }
}
