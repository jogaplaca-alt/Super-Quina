package ru.a402d.rawbtprinter.printservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.print.PrintAttributes;
import android.printservice.PrintJob;
import android.printservice.PrintService;
import android.printservice.PrinterDiscoverySession;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rawbt.api.RawbtApiHelper;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesPdf;
import rawbt.sdk.ICallback;
import rawbt.sdk.IRawBtPrintService;
import rawbt.sdk.RawbtConstants;
import rawbt.sdk.RawbtPrintJob;
import rawbt.sdk.utils.RawbtHelper;
import ru.a402d.rawbtprinter.RawPrinterApp;
import ru.a402d.rawbtprinter.printservice.RawBtService;

/* JADX INFO: loaded from: classes.dex */
public class RawBtService extends PrintService {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f11589g = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f11591b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    RawBtService f11594e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ExecutorService f11590a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IRawBtPrintService f11592c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ServiceConnection f11593d = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final ICallback f11595f = new b();

    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            RawBtService.this.f11592c = IRawBtPrintService.Stub.asInterface(iBinder);
            try {
                RawBtService.this.f11592c.registerCallback(RawBtService.this.f11595f);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            RawBtService.this.f11592c = null;
        }
    }

    class b extends ICallback.Stub {
        b() {
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintCancel(String str) {
            RawBtService.this.f11591b.sendMessageDelayed(RawBtService.this.f11591b.obtainMessage(35, new e(str, "cancel")), 0L);
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintError(String str, String str2) {
            RawBtService.this.f11591b.sendMessageDelayed(RawBtService.this.f11591b.obtainMessage(34, new e(str, str2)), 0L);
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintSuccess(String str) {
            RawBtService.this.f11591b.sendMessageDelayed(RawBtService.this.f11591b.obtainMessage(32, new e(str, RawbtConstants.OK)), 0L);
        }

        @Override // rawbt.sdk.ICallback
        public void onProgress(String str, float f3) {
            RawBtService.this.f11591b.sendMessageDelayed(RawBtService.this.f11591b.obtainMessage(33, new d(str, f3)), 0L);
        }
    }

    private final class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            try {
                switch (message.what) {
                    case 31:
                        RawBtService.this.h((PrintJob) message.obj);
                        return;
                    case 32:
                        PrintJob printJobG = RawBtService.this.g(((e) message.obj).f11601a);
                        Objects.requireNonNull(printJobG);
                        printJobG.complete();
                        break;
                    case 33:
                        d dVar = (d) message.obj;
                        RawBtService rawBtService = RawBtService.this;
                        rawBtService.i(dVar.f11600b, rawBtService.g(dVar.f11599a));
                        return;
                    case 34:
                        e eVar = (e) message.obj;
                        PrintJob printJobG2 = RawBtService.this.g(eVar.f11601a);
                        Objects.requireNonNull(printJobG2);
                        printJobG2.fail(eVar.f11602b);
                        break;
                    case 35:
                        PrintJob printJobG3 = RawBtService.this.g(((e) message.obj).f11601a);
                        Objects.requireNonNull(printJobG3);
                        printJobG3.cancel();
                        break;
                    default:
                        return;
                }
            } catch (Exception unused) {
            }
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f11599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f11600b;

        d(String str, float f3) {
            this.f11599a = str;
            this.f11600b = f3;
        }
    }

    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f11601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f11602b;

        e(String str, String str2) {
            this.f11601a = str;
            this.f11602b = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x01c4 A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0094 A[Catch: Exception -> 0x005e, TRY_ENTER, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0099 A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x009e A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a6 A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00c5 A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ca A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:68:0x00fe A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0102 A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0108 A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x011d A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0141 A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0184 A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x018a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x018c A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0194 A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01b2 A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x01b7 A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x01bc A[Catch: Exception -> 0x005e, TryCatch #1 {Exception -> 0x005e, blocks: (B:5:0x0009, B:15:0x004a, B:16:0x0059, B:53:0x00aa, B:55:0x00c5, B:57:0x00ca, B:58:0x00cd, B:59:0x00d1, B:66:0x00ed, B:68:0x00fe, B:73:0x010f, B:75:0x011d, B:78:0x0124, B:80:0x012c, B:83:0x0135, B:86:0x0144, B:88:0x0184, B:92:0x0199, B:90:0x018c, B:91:0x0194, B:84:0x013b, B:85:0x0141, B:69:0x0102, B:71:0x0108, B:72:0x010c, B:94:0x01b2, B:96:0x01b7, B:98:0x01bc, B:100:0x01c4, B:101:0x01ca, B:46:0x0094, B:48:0x0099, B:50:0x009e, B:52:0x00a6), top: B:104:0x0009 }] */
    /* JADX WARN: Multi-variable type inference failed */
    public void h(PrintJob printJob) throws Throwable {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        Exception e3;
        BufferedInputStream bufferedInputStream;
        Object obj;
        AttributesImage attributesImageA;
        int colorMode;
        AttributesPdf attributesPdfB;
        final String id;
        final boolean z3;
        PrintAttributes.MediaSize mediaSize;
        RawbtPrintJob rawbtPrintJobPrepareJob;
        IRawBtPrintService iRawBtPrintService;
        if (printJob.isQueued()) {
            printJob.start();
        }
        try {
            Context contextG = RawPrinterApp.g();
            Objects.requireNonNull(contextG);
            File file = new File(contextG.getCacheDir(), "for_debug.pdf");
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    try {
                        ParcelFileDescriptor data = printJob.getDocument().getData();
                        Objects.requireNonNull(data);
                        fileInputStream = new FileInputStream(data.getFileDescriptor());
                        try {
                            bufferedInputStream = new BufferedInputStream(fileInputStream);
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                                    try {
                                        byte[] bArr = new byte[8192];
                                        while (true) {
                                            int i3 = bufferedInputStream.read(bArr);
                                            if (i3 < 0) {
                                                break;
                                            } else {
                                                bufferedOutputStream2.write(bArr, 0, i3);
                                            }
                                        }
                                        bufferedInputStream.close();
                                        fileInputStream.close();
                                        bufferedOutputStream2.flush();
                                        bufferedOutputStream2.close();
                                        fileOutputStream.flush();
                                    } catch (Exception e4) {
                                        e3 = e4;
                                        e3.printStackTrace();
                                        if (bufferedInputStream != 0) {
                                            bufferedInputStream.close();
                                        }
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                        if (bufferedOutputStream2 != 0) {
                                            bufferedOutputStream2.flush();
                                            bufferedOutputStream2.close();
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.flush();
                                        }
                                        y2.b bVarW = y2.b.w();
                                        attributesImageA = bVarW.a();
                                        colorMode = printJob.getInfo().getAttributes().getColorMode();
                                        if (attributesImageA.getGraphicFilter() == 0) {
                                            attributesImageA.setGraphicFilter(1);
                                        }
                                        if (colorMode == 1) {
                                            attributesImageA.setGraphicFilter(0);
                                        }
                                        attributesPdfB = bVarW.b();
                                        PrintAttributes.MediaSize mediaSize2 = printJob.getInfo().getAttributes().getMediaSize();
                                        Objects.requireNonNull(mediaSize2);
                                        id = mediaSize2.getId();
                                        if (colorMode == 2) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        attributesPdfB.setRoll(id.contains("Roll"));
                                        if (id.contains("not_cut")) {
                                            attributesPdfB.setWidthTruncateMode(0);
                                        } else {
                                            attributesPdfB.setWidthTruncateMode(attributesPdfB.getWidthTruncateMode() != 0 ? attributesPdfB.getWidthTruncateMode() : 2);
                                        }
                                        mediaSize = printJob.getInfo().getAttributes().getMediaSize();
                                        if (mediaSize != null) {
                                            attributesPdfB.setRotate(0);
                                        } else {
                                            attributesPdfB.setRotate(0);
                                        }
                                        RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
                                        rawbtPrintJob.setIdJob(printJob.getId().toString());
                                        rawbtPrintJob.setPremium(true);
                                        rawbtPrintJob.setCopies(printJob.getInfo().getCopies());
                                        rawbtPrintJob.setPrinter(printJob.getInfo().getPrinterId().getLocalId());
                                        rawbtPrintJob.pdf(Uri.fromFile(file), attributesPdfB, attributesImageA);
                                        rawbtPrintJobPrepareJob = RawbtHelper.prepareJob(rawbtPrintJob, RawPrinterApp.g());
                                        iRawBtPrintService = this.f11592c;
                                        if (iRawBtPrintService == null) {
                                            printJob.fail("RawBT service is unavailable");
                                        } else if (rawbtPrintJobPrepareJob != null) {
                                            iRawBtPrintService.printRawbtPrintJob(rawbtPrintJobPrepareJob.GSON());
                                        } else {
                                            printJob.fail("prepare job return null");
                                        }
                                        final String localId = printJob.getInfo().getPrinterId().getLocalId();
                                        this.f11590a.execute(new Runnable() { // from class: x2.c
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                RawBtService.j(localId, id, z3);
                                            }
                                        });
                                    }
                                } catch (Exception e5) {
                                    bufferedOutputStream2 = 0;
                                    e3 = e5;
                                } catch (Throwable th) {
                                    th = th;
                                    obj = null;
                                    bufferedInputStream2 = bufferedInputStream;
                                    bufferedOutputStream = obj;
                                    if (bufferedInputStream2 != null) {
                                        bufferedInputStream2.close();
                                    }
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    if (bufferedOutputStream != 0) {
                                        bufferedOutputStream.flush();
                                        bufferedOutputStream.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.flush();
                                        fileOutputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception e6) {
                                bufferedOutputStream2 = 0;
                                e3 = e6;
                                fileOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = null;
                                obj = null;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            fileOutputStream = null;
                            bufferedOutputStream2 = fileOutputStream;
                            e3 = e;
                            bufferedInputStream = bufferedOutputStream2;
                            e3.printStackTrace();
                            if (bufferedInputStream != 0) {
                                bufferedInputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (bufferedOutputStream2 != 0) {
                                bufferedOutputStream2.flush();
                                bufferedOutputStream2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            }
                            y2.b bVarW2 = y2.b.w();
                            attributesImageA = bVarW2.a();
                            colorMode = printJob.getInfo().getAttributes().getColorMode();
                            if (attributesImageA.getGraphicFilter() == 0) {
                                attributesImageA.setGraphicFilter(1);
                            }
                            if (colorMode == 1) {
                                attributesImageA.setGraphicFilter(0);
                            }
                            attributesPdfB = bVarW2.b();
                            PrintAttributes.MediaSize mediaSize3 = printJob.getInfo().getAttributes().getMediaSize();
                            Objects.requireNonNull(mediaSize3);
                            id = mediaSize3.getId();
                            if (colorMode == 2) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            attributesPdfB.setRoll(id.contains("Roll"));
                            if (id.contains("not_cut")) {
                                attributesPdfB.setWidthTruncateMode(0);
                            } else {
                                attributesPdfB.setWidthTruncateMode(attributesPdfB.getWidthTruncateMode() != 0 ? attributesPdfB.getWidthTruncateMode() : 2);
                            }
                            mediaSize = printJob.getInfo().getAttributes().getMediaSize();
                            if (mediaSize != null) {
                                attributesPdfB.setRotate(0);
                            } else {
                                attributesPdfB.setRotate(0);
                            }
                            RawbtPrintJob rawbtPrintJob2 = new RawbtPrintJob();
                            rawbtPrintJob2.setIdJob(printJob.getId().toString());
                            rawbtPrintJob2.setPremium(true);
                            rawbtPrintJob2.setCopies(printJob.getInfo().getCopies());
                            rawbtPrintJob2.setPrinter(printJob.getInfo().getPrinterId().getLocalId());
                            rawbtPrintJob2.pdf(Uri.fromFile(file), attributesPdfB, attributesImageA);
                            rawbtPrintJobPrepareJob = RawbtHelper.prepareJob(rawbtPrintJob2, RawPrinterApp.g());
                            iRawBtPrintService = this.f11592c;
                            if (iRawBtPrintService == null) {
                                printJob.fail("RawBT service is unavailable");
                            } else if (rawbtPrintJobPrepareJob != null) {
                                iRawBtPrintService.printRawbtPrintJob(rawbtPrintJobPrepareJob.GSON());
                            } else {
                                printJob.fail("prepare job return null");
                            }
                            final String localId2 = printJob.getInfo().getPrinterId().getLocalId();
                            this.f11590a.execute(new Runnable() { // from class: x2.c
                                @Override // java.lang.Runnable
                                public final void run() {
                                    RawBtService.j(localId2, id, z3);
                                }
                            });
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                            bufferedOutputStream = fileOutputStream;
                            if (bufferedInputStream2 != null) {
                                bufferedInputStream2.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (bufferedOutputStream != 0) {
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Exception e8) {
                    e = e8;
                    fileInputStream = null;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = null;
                    fileOutputStream = null;
                }
                PrintAttributes.MediaSize mediaSize4 = printJob.getInfo().getAttributes().getMediaSize();
                Objects.requireNonNull(mediaSize4);
                id = mediaSize4.getId();
            } catch (NullPointerException unused) {
                id = "Paper Roll";
            }
            fileOutputStream.close();
            y2.b bVarW3 = y2.b.w();
            attributesImageA = bVarW3.a();
            colorMode = printJob.getInfo().getAttributes().getColorMode();
            if (attributesImageA.getGraphicFilter() == 0) {
                attributesImageA.setGraphicFilter(1);
            }
            if (colorMode == 1) {
                attributesImageA.setGraphicFilter(0);
            }
            attributesPdfB = bVarW3.b();
            if (colorMode == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            attributesPdfB.setRoll(id.contains("Roll"));
            if (id.contains("not_cut")) {
                attributesPdfB.setWidthTruncateMode(0);
            } else {
                attributesPdfB.setWidthTruncateMode(attributesPdfB.getWidthTruncateMode() != 0 ? attributesPdfB.getWidthTruncateMode() : 2);
            }
            mediaSize = printJob.getInfo().getAttributes().getMediaSize();
            if (mediaSize != null || mediaSize.isPortrait()) {
                attributesPdfB.setRotate(0);
            } else if (id.contains("square") || id.contains("photo")) {
                attributesPdfB.setRotate(270);
            } else {
                attributesPdfB.setRotate(90);
            }
            RawbtPrintJob rawbtPrintJob3 = new RawbtPrintJob();
            rawbtPrintJob3.setIdJob(printJob.getId().toString());
            rawbtPrintJob3.setPremium(true);
            rawbtPrintJob3.setCopies(printJob.getInfo().getCopies());
            rawbtPrintJob3.setPrinter(printJob.getInfo().getPrinterId().getLocalId());
            rawbtPrintJob3.pdf(Uri.fromFile(file), attributesPdfB, attributesImageA);
            rawbtPrintJobPrepareJob = RawbtHelper.prepareJob(rawbtPrintJob3, RawPrinterApp.g());
            iRawBtPrintService = this.f11592c;
            if (iRawBtPrintService == null) {
                printJob.fail("RawBT service is unavailable");
            } else if (rawbtPrintJobPrepareJob != null) {
                iRawBtPrintService.printRawbtPrintJob(rawbtPrintJobPrepareJob.GSON());
            } else {
                printJob.fail("prepare job return null");
            }
            final String localId3 = printJob.getInfo().getPrinterId().getLocalId();
            this.f11590a.execute(new Runnable() { // from class: x2.c
                @Override // java.lang.Runnable
                public final void run() {
                    RawBtService.j(localId3, id, z3);
                }
            });
        } catch (Exception e9) {
            printJob.fail(e9.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(float f3, PrintJob printJob) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                printJob.setProgress(f3);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(String str, String str2, boolean z3) {
        RawPrinterApp.h().D().storeLastPrintParam(str, str2, z3);
    }

    PrintJob g(String str) {
        if (str == null) {
            return null;
        }
        List<PrintJob> activePrintJobs = getActivePrintJobs();
        for (int i3 = 0; i3 < activePrintJobs.size(); i3++) {
            PrintJob printJob = activePrintJobs.get(i3);
            if (printJob.getId().toString().equals(str)) {
                return printJob;
            }
        }
        return null;
    }

    @Override // android.printservice.PrintService
    protected void onConnected() {
        super.onConnected();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f11594e = this;
        this.f11591b = new c(getMainLooper());
        if (this.f11592c == null) {
            bindService(RawbtApiHelper.createExplicitIntent(), this.f11593d, 1);
        }
    }

    @Override // android.printservice.PrintService
    protected PrinterDiscoverySession onCreatePrinterDiscoverySession() {
        ru.a402d.rawbtprinter.printservice.d dVar;
        synchronized (f11589g) {
            dVar = new ru.a402d.rawbtprinter.printservice.d(this, null);
        }
        return dVar;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        IRawBtPrintService iRawBtPrintService = this.f11592c;
        if (iRawBtPrintService != null) {
            try {
                iRawBtPrintService.unregisterCallback(this.f11595f);
            } catch (RemoteException e3) {
                e3.printStackTrace();
            }
            unbindService(this.f11593d);
        }
    }

    @Override // android.printservice.PrintService
    public void onPrintJobQueued(PrintJob printJob) {
        this.f11591b.sendMessageDelayed(this.f11591b.obtainMessage(31, printJob), 0L);
    }

    @Override // android.printservice.PrintService
    protected void onRequestCancelPrintJob(PrintJob printJob) {
        try {
            printJob.cancel();
            if (this.f11591b.hasMessages(31)) {
                this.f11591b.removeMessages(31);
            }
        } catch (Exception unused) {
        }
    }
}
