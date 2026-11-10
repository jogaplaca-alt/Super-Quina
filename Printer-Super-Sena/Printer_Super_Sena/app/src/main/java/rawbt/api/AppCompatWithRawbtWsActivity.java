package rawbt.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Spinner;
import androidx.appcompat.app.AbstractActivityC0248d;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rawbt.sdk.PrinterInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppCompatWithRawbtWsActivity extends AbstractActivityC0248d {
    protected SelectPrinterAdapter adapterSelectPrinter;
    org.java_websocket.client.c client;
    protected Spinner spinnerSelectPrinter;
    protected final Handler handler = new Handler(Looper.getMainLooper());
    final ExecutorService executor = Executors.newSingleThreadExecutor();
    boolean isConnected = false;

    class RawbtWebSocketClient extends org.java_websocket.client.c {
        public RawbtWebSocketClient(URI uri) {
            super(uri);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$6(Exception exc) {
            AppCompatWithRawbtWsActivity.this.handlePrintError(null, exc.getClass().getSimpleName());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onMessage$0(RawbtResponse rawbtResponse) {
            AppCompatWithRawbtWsActivity.this.handlePrintSuccess(rawbtResponse.getJobId());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onMessage$1(RawbtResponse rawbtResponse) {
            AppCompatWithRawbtWsActivity.this.handlePrintCancel(rawbtResponse.getJobId());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onMessage$2(RawbtResponse rawbtResponse) {
            AppCompatWithRawbtWsActivity.this.handlePrintError(rawbtResponse.getJobId(), rawbtResponse.getErrorMessage());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onMessage$3(RawbtResponse rawbtResponse) {
            AppCompatWithRawbtWsActivity.this.handlePrintProgress(rawbtResponse.getJobId(), rawbtResponse.getProgress());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onMessage$4(RawbtResponse rawbtResponse) {
            AppCompatWithRawbtWsActivity appCompatWithRawbtWsActivity = AppCompatWithRawbtWsActivity.this;
            if (appCompatWithRawbtWsActivity.adapterSelectPrinter == null) {
                return;
            }
            String selectedPrinterName = appCompatWithRawbtWsActivity.getSelectedPrinterName();
            AppCompatWithRawbtWsActivity.this.adapterSelectPrinter.clear();
            PrinterInfo printerInfo = new PrinterInfo();
            printerInfo.name = RawbtPrintJob.PRINTER_CURRENT;
            printerInfo.description = "Default";
            AppCompatWithRawbtWsActivity.this.adapterSelectPrinter.add(printerInfo);
            int i3 = -1;
            int i4 = 1;
            for (PrinterInfo printerInfo2 : rawbtResponse.getPrinters()) {
                AppCompatWithRawbtWsActivity.this.adapterSelectPrinter.add(printerInfo2);
                if (selectedPrinterName.equals(printerInfo2.name)) {
                    i3 = i4;
                }
                i4++;
            }
            AppCompatWithRawbtWsActivity.this.adapterSelectPrinter.notifyDataSetChanged();
            if (i3 > -1) {
                AppCompatWithRawbtWsActivity.this.spinnerSelectPrinter.setSelection(i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onMessage$5(Exception exc) {
            AppCompatWithRawbtWsActivity.this.handlePrintError(null, exc.getClass().getSimpleName());
        }

        @Override // org.java_websocket.client.c
        public void onClose(int i3, String str, boolean z3) {
            AppCompatWithRawbtWsActivity.this.isConnected = false;
        }

        @Override // org.java_websocket.client.c
        public void onError(final Exception exc) {
            AppCompatWithRawbtWsActivity appCompatWithRawbtWsActivity = AppCompatWithRawbtWsActivity.this;
            appCompatWithRawbtWsActivity.isConnected = false;
            appCompatWithRawbtWsActivity.handler.post(new Runnable() { // from class: rawbt.api.r
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11155a.lambda$onError$6(exc);
                }
            });
        }

        @Override // org.java_websocket.client.c
        public void onMessage(String str) {
            try {
                final RawbtResponse rawbtResponse = (RawbtResponse) new p075w1.e().b().j(str, RawbtResponse.class);
                if (RawbtResponse.RESPONSE_SUCCESS.equals(rawbtResponse.getResponseType())) {
                    AppCompatWithRawbtWsActivity.this.handler.post(new Runnable() { // from class: rawbt.api.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11158a.lambda$onMessage$0(rawbtResponse);
                        }
                    });
                } else if (RawbtResponse.RESPONSE_CANCELED.equals(rawbtResponse.getResponseType())) {
                    AppCompatWithRawbtWsActivity.this.handler.post(new Runnable() { // from class: rawbt.api.u
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11160a.lambda$onMessage$1(rawbtResponse);
                        }
                    });
                } else if (RawbtResponse.RESPONSE_ERROR.equals(rawbtResponse.getResponseType())) {
                    AppCompatWithRawbtWsActivity.this.handler.post(new Runnable() { // from class: rawbt.api.v
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11162a.lambda$onMessage$2(rawbtResponse);
                        }
                    });
                } else if (RawbtResponse.RESPONSE_PROGRESS.equals(rawbtResponse.getResponseType())) {
                    AppCompatWithRawbtWsActivity.this.handler.post(new Runnable() { // from class: rawbt.api.w
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11164a.lambda$onMessage$3(rawbtResponse);
                        }
                    });
                } else if (RawbtResponse.RESPONSE_PRINTERS.equals(rawbtResponse.getResponseType())) {
                    AppCompatWithRawbtWsActivity.this.handler.post(new Runnable() { // from class: rawbt.api.x
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11166a.lambda$onMessage$4(rawbtResponse);
                        }
                    });
                }
            } catch (Exception e3) {
                AppCompatWithRawbtWsActivity.this.handler.post(new Runnable() { // from class: rawbt.api.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11168a.lambda$onMessage$5(e3);
                    }
                });
            }
        }

        @Override // org.java_websocket.client.c
        public void onOpen(p027g2.h hVar) {
            final AppCompatWithRawbtWsActivity appCompatWithRawbtWsActivity = AppCompatWithRawbtWsActivity.this;
            appCompatWithRawbtWsActivity.isConnected = true;
            appCompatWithRawbtWsActivity.handler.post(new Runnable() { // from class: rawbt.api.s
                @Override // java.lang.Runnable
                public final void run() {
                    appCompatWithRawbtWsActivity.handleServiceConnected();
                }
            });
            AppCompatWithRawbtWsActivity.this.getPrinters();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$printJob$0(RawbtPrintJob rawbtPrintJob) {
        handlePrintError(rawbtPrintJob.getIdJob(), "Try again later");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$printJob$1(RawbtPrintJob rawbtPrintJob, Exception exc) {
        handlePrintError(rawbtPrintJob.getIdJob(), exc.getClass().getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$printJob$2(final RawbtPrintJob rawbtPrintJob) {
        if (!this.isConnected) {
            this.handler.post(new Runnable() { // from class: rawbt.api.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11150a.lambda$printJob$0(rawbtPrintJob);
                }
            });
            myConnect();
        } else {
            try {
                this.client.send(rawbtPrintJob.GSON());
            } catch (Exception e3) {
                this.handler.post(new Runnable() { // from class: rawbt.api.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11152a.lambda$printJob$1(rawbtPrintJob, e3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void myConnect() {
        try {
            RawbtWebSocketClient rawbtWebSocketClient = new RawbtWebSocketClient(new URI("ws://localhost:40213/"));
            this.client = rawbtWebSocketClient;
            rawbtWebSocketClient.connect();
        } catch (URISyntaxException e3) {
            e3.printStackTrace();
        }
    }

    protected void getPrinters() {
        try {
            this.client.send("GET_PRINTERS");
        } catch (Exception unused) {
        }
    }

    protected abstract String getSelectedPrinterName();

    protected abstract void handlePrintCancel(String str);

    protected abstract void handlePrintError(String str, String str2);

    protected abstract void handlePrintProgress(String str, Float f3);

    protected abstract void handlePrintSuccess(String str);

    protected abstract void handleServiceConnected();

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.handler.postDelayed(new Runnable() { // from class: rawbt.api.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f11149a.myConnect();
            }
        }, 500L);
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void printJob(final RawbtPrintJob rawbtPrintJob) {
        this.executor.execute(new Runnable() { // from class: rawbt.api.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f11147a.lambda$printJob$2(rawbtPrintJob);
            }
        });
    }
}
