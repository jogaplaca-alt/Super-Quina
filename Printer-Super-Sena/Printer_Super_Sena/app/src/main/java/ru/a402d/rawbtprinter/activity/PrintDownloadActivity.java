package ru.a402d.rawbtprinter.activity;

import android.content.Context;
import android.content.Intent;
import android.net.TrafficStats;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import rawbt.api.Constant;
import rawbt.api.RawbtMediaTypes;
import rawbt.api.RawbtResponse;
import rawbt.api.command.CommandParcelable;
import rawbt.sdk.AbstractRawBtPrintService;
import rawbt.sdk.RawbtPrintJob;
import rawbt.sdk.utils.File;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
public class PrintDownloadActivity extends AbstractActivityC0623b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f11415v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f11416w = false;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11417a;

        static {
            int[] iArr = new int[Constant.RAWBT_CONTENT_TYPE.values().length];
            f11417a = iArr;
            try {
                iArr[Constant.RAWBT_CONTENT_TYPE.image.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11417a[Constant.RAWBT_CONTENT_TYPE.txt.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11417a[Constant.RAWBT_CONTENT_TYPE.pdf.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private boolean U() {
        return !this.f11415v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V() {
        this.f11545p.setText("Downloading ...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(String str) {
        this.f11545p.setText("Load: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X() {
        N(false, RawbtResponse.RESPONSE_CANCELED);
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0623b
    protected void F() {
        this.f11415v = true;
        this.f11545p.setText(R.string.wait);
        if (this.f11550u) {
            Intent intent = new Intent();
            intent.setAction(AbstractRawBtPrintService.ACTION_CANCEL);
            sendBroadcast(intent);
        } else {
            if (this.f11416w) {
                return;
            }
            N(false, RawbtResponse.RESPONSE_CANCELED);
        }
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0623b
    protected boolean G() {
        return false;
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0623b
    void N(boolean z3, String str) {
        Intent intent = new Intent();
        intent.putExtra("result", z3);
        intent.putExtra("message", str);
        setResult(-1, intent);
        finish();
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0623b
    protected RawbtPrintJob O() {
        Uri data;
        int i3;
        Intent intent = getIntent();
        if (intent == null || (data = intent.getData()) == null) {
            return null;
        }
        try {
            this.f11416w = true;
            this.f11534e.post(new Runnable() { // from class: r2.v1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11106a.V();
                }
            });
            URL url = new URL(data.getScheme(), data.getHost(), data.getPath());
            TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            try {
                String fileExtension = File.getFileExtension(data, "unknown", RawPrinterApp.g());
                if (fileExtension.isEmpty() || fileExtension.length() > 7) {
                    fileExtension = "prn";
                }
                Context contextG = RawPrinterApp.g();
                Objects.requireNonNull(contextG);
                java.io.File file = new java.io.File(contextG.getCacheDir(), "download_temp." + fileExtension);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                byte[] bArr = new byte[8192];
                long j3 = 0;
                while (true) {
                    if (!U()) {
                        break;
                    }
                    int i4 = bufferedInputStream.read(bArr);
                    j3 += (long) i4;
                    if (j3 > this.f11543n.D()) {
                        Context contextG2 = RawPrinterApp.g();
                        Objects.requireNonNull(contextG2);
                        RawPrinterApp.r(contextG2.getString(R.string.ErrorOverFileSize));
                    }
                    if (i4 < 0) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, i4);
                    final String str = "Load: " + j3;
                    this.f11534e.post(new Runnable() { // from class: r2.w1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11110a.W(str);
                        }
                    });
                    Thread.sleep(10L);
                }
                bufferedInputStream.close();
                bufferedOutputStream.close();
                this.f11416w = false;
                if (!U()) {
                    this.f11534e.post(new Runnable() { // from class: r2.x1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11115a.X();
                        }
                    });
                    return null;
                }
                Uri uriFromFile = Uri.fromFile(file);
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension);
                String contentType = httpURLConnection.getContentType();
                if (contentType != null) {
                    for (String str2 : contentType.split(";")) {
                        String lowerCase = str2.trim().toLowerCase();
                        if (lowerCase.startsWith("image/") || lowerCase.startsWith("text/") || "application/pdf".equals(lowerCase)) {
                            mimeTypeFromExtension = lowerCase;
                        }
                    }
                }
                RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
                rawbtPrintJob.setCopies(this.f11543n.i());
                rawbtPrintJob.setDefaultAttrImage(this.f11543n.a());
                rawbtPrintJob.setDefaultAttrPdf(this.f11543n.b());
                rawbtPrintJob.setDefaultAttrString(this.f11543n.c());
                Constant.RAWBT_CONTENT_TYPE rawbt_content_typeDetectContentType = RawbtMediaTypes.detectContentType(RawPrinterApp.g(), uriFromFile, mimeTypeFromExtension);
                if (!this.f11543n.t0() && rawbt_content_typeDetectContentType == Constant.RAWBT_CONTENT_TYPE.txt) {
                    rawbt_content_typeDetectContentType = Constant.RAWBT_CONTENT_TYPE.prn;
                }
                CommandParcelable commandParcelable = new CommandParcelable(uriFromFile, rawbt_content_typeDetectContentType);
                int i5 = a.f11417a[rawbt_content_typeDetectContentType.ordinal()];
                if (i5 == 1) {
                    commandParcelable.setAttributesImage(this.f11543n.a());
                } else if (i5 == 2) {
                    commandParcelable.setAttributesString(this.f11543n.c());
                } else if (i5 == 3) {
                    commandParcelable.setAttributesPdf(this.f11543n.b());
                }
                rawbtPrintJob.add(commandParcelable);
                return rawbtPrintJob;
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (FileNotFoundException e3) {
            Context contextG3 = RawPrinterApp.g();
            Objects.requireNonNull(contextG3);
            RawPrinterApp.r(contextG3.getString(R.string.error_not_found));
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
            String localizedMessage = e4.getLocalizedMessage();
            if (localizedMessage != null) {
                RawPrinterApp.r(localizedMessage);
            }
        }
    }
}
