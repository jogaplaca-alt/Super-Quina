package rawbt.sdk;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import rawbt.api.command.RawbtCommand;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.drivers.PosDriverInterface;
import rawbt.sdk.templates.DocumentTemplate;
import rawbt.sdk.utils.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractRawBtPrintService extends Service {
    MyHandler mHandler;
    protected AbstractRawBtPrintService self;
    public static final LinkedList<RawbtPrintJob> printQueue = new LinkedList<>();
    public static String ACTION_CANCEL = "ru.a402d.rawbtprinter.action.CANCEL";
    public static String ACTION_FINISH = "ru.a402d.rawbtprinter.action.FINISH";
    public static final AtomicBoolean isPrint = new AtomicBoolean();
    final ExecutorService executorPrint = Executors.newSingleThreadExecutor();
    final ExecutorService executorNotify = Executors.newSingleThreadExecutor();
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private final BroadcastReceiver mReceiver = new AnonymousClass1();
    public PosDriverInterface driverForConsole = null;
    private final RawbtNotifySender rawbtNotifySender = new RawbtNotifySender();
    final IBinder myBinder = new AnonymousClass2();
    long previousTaskFinished = 0;
    final long betweenTask = 5000;
    protected final PosDriverInterface.TaskForTransport taskIteration = new PosDriverInterface.TaskForTransport() { // from class: rawbt.sdk.AbstractRawBtPrintService.3
        @Override // rawbt.sdk.drivers.PosDriverInterface.TaskForTransport
        public void deviceError(String str) {
            if (str == null) {
                return;
            }
            AbstractRawBtPrintService.this.mHandler.sendMessageDelayed(AbstractRawBtPrintService.this.mHandler.obtainMessage(32, str), 0L);
        }

        @Override // rawbt.sdk.drivers.PosDriverInterface.TaskForTransport
        public void deviceProgress(String str) {
            if (str == null) {
                return;
            }
            AbstractRawBtPrintService.this.mHandler.sendMessageDelayed(AbstractRawBtPrintService.this.mHandler.obtainMessage(31, str), 0L);
        }

        @Override // rawbt.sdk.drivers.PosDriverInterface.TaskForTransport
        public boolean isCancelled() {
            return AbstractRawBtPrintService.this.self.isCancelled();
        }

        @Override // rawbt.sdk.drivers.PosDriverInterface.TaskForTransport
        public void receiveFromDevice(byte[] bArr) {
            if (bArr == null) {
                return;
            }
            AbstractRawBtPrintService.this.mHandler.sendMessageDelayed(AbstractRawBtPrintService.this.mHandler.obtainMessage(33, bArr), 0L);
        }

        @Override // rawbt.sdk.drivers.PosDriverInterface.TaskForTransport
        public void sentToDevice(byte[] bArr) {
            if (bArr == null) {
                return;
            }
            AbstractRawBtPrintService.this.mHandler.sendMessageDelayed(AbstractRawBtPrintService.this.mHandler.obtainMessage(34, bArr), 0L);
        }

        @Override // rawbt.sdk.drivers.PosDriverInterface.TaskForTransport
        public void stepPercent(int i3) {
            if (AbstractRawBtPrintService.this.step == 0.0d) {
                return;
            }
            double d3 = AbstractRawBtPrintService.this.start;
            double d4 = i3;
            double d5 = AbstractRawBtPrintService.this.step;
            Double.isNaN(d4);
            AbstractRawBtPrintService.this.mHandler.sendMessageDelayed(AbstractRawBtPrintService.this.mHandler.obtainMessage(53, new JobInfo(AbstractRawBtPrintService.this.jobID, Float.valueOf((float) (d3 + ((d4 * d5) / 100.0d))))), 0L);
        }
    };
    private double start = 0.0d;
    private double step = 0.0d;
    private String jobID = "";

    /* JADX INFO: renamed from: rawbt.sdk.AbstractRawBtPrintService$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceive$0() {
            AbstractRawBtPrintService.this.cancel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceive$1() {
            AbstractRawBtPrintService.this.finish();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AbstractRawBtPrintService.ACTION_CANCEL.equals(intent.getAction())) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: rawbt.sdk.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11182a.lambda$onReceive$0();
                    }
                }, 0L);
            }
            if (AbstractRawBtPrintService.ACTION_FINISH.equals(intent.getAction())) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: rawbt.sdk.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11183a.lambda$onReceive$1();
                    }
                }, 0L);
            }
        }
    }

    /* JADX INFO: renamed from: rawbt.sdk.AbstractRawBtPrintService$2, reason: invalid class name */
    class AnonymousClass2 extends IRawBtPrintService.Stub {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$getPrinters$0(IGetPrintersCallback iGetPrintersCallback) {
            List<PrinterEntity> printersList = AbstractRawBtPrintService.this.getPrintersList();
            PrinterInfo[] printerInfoArr = new PrinterInfo[printersList.size()];
            int i3 = 0;
            for (PrinterEntity printerEntity : printersList) {
                PrinterInfo printerInfo = new PrinterInfo();
                printerInfo.name = printerEntity.getName();
                printerInfo.description = printerEntity.getDescription();
                printerInfoArr[i3] = printerInfo;
                i3++;
            }
            try {
                iGetPrintersCallback.onResult(printerInfoArr);
            } catch (RemoteException e3) {
                e3.printStackTrace();
            }
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public boolean getPrinters(final IGetPrintersCallback iGetPrintersCallback) {
            if (iGetPrintersCallback == null) {
                return false;
            }
            AbstractRawBtPrintService.this.executorNotify.execute(new Runnable() { // from class: rawbt.sdk.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11193a.lambda$getPrinters$0(iGetPrintersCallback);
                }
            });
            return true;
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void printRawbtPrintJob(String str) {
            p075w1.e eVar = new p075w1.e();
            eVar.c(RawbtCommand.class, new RawbtCommandInstanceCreator());
            AbstractRawBtPrintService.printQueue.add(AbstractRawBtPrintService.this.injectDefaults((RawbtPrintJob) eVar.b().j(str, RawbtPrintJob.class)));
            if (AbstractRawBtPrintService.this.isCancelled()) {
                AbstractRawBtPrintService.this.mHandler.sendMessageDelayed(AbstractRawBtPrintService.this.mHandler.obtainMessage(51, 0), 0L);
                return;
            }
            if (AbstractRawBtPrintService.this.isPrint()) {
                AbstractRawBtPrintService abstractRawBtPrintService = AbstractRawBtPrintService.this;
                MyHandler myHandler = abstractRawBtPrintService.mHandler;
                myHandler.sendMessageDelayed(myHandler.obtainMessage(31, abstractRawBtPrintService.getString(R.string.new_task)), 0L);
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                AbstractRawBtPrintService abstractRawBtPrintService2 = AbstractRawBtPrintService.this;
                long j3 = jCurrentTimeMillis - abstractRawBtPrintService2.previousTaskFinished;
                AbstractRawBtPrintService.this.mHandler.sendMessageDelayed(abstractRawBtPrintService2.mHandler.obtainMessage(50, 0), j3 < 5000 ? 5000 - j3 : 0L);
            }
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void printerConnect() {
            AbstractRawBtPrintService.this.mHandler.sendMessageDelayed(AbstractRawBtPrintService.this.mHandler.obtainMessage(41), 0L);
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void printerConnectByName(String str) {
            AbstractRawBtPrintService.this.mHandler.sendMessageDelayed(AbstractRawBtPrintService.this.mHandler.obtainMessage(45, str), 0L);
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void printerDisconnect() {
            AbstractRawBtPrintService.this.mHandler.sendMessageDelayed(AbstractRawBtPrintService.this.mHandler.obtainMessage(42), 0L);
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void printerSend(byte[] bArr) {
            AbstractRawBtPrintService.this.mHandler.sendMessageDelayed(AbstractRawBtPrintService.this.mHandler.obtainMessage(43, bArr), 0L);
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void registerCallback(ICallback iCallback) {
            if (iCallback != null) {
                AbstractRawBtPrintService.this.rawbtNotifySender.mCallbacks.register(iCallback);
            }
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void registerConsole(IConsole iConsole) {
            if (iConsole != null) {
                AbstractRawBtPrintService.this.rawbtNotifySender.mConsoles.register(iConsole);
            }
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void sendFile(Uri uri, boolean z3, String str) {
            AbstractRawBtPrintService.this.mHandler.sendMessageDelayed(AbstractRawBtPrintService.this.mHandler.obtainMessage(43, new SendFileTask(uri, z3, str)), 0L);
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void unregisterCallback(ICallback iCallback) {
            if (iCallback != null) {
                AbstractRawBtPrintService.this.rawbtNotifySender.mCallbacks.unregister(iCallback);
            }
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void unregisterConsole(IConsole iConsole) {
            if (iConsole != null) {
                AbstractRawBtPrintService.this.rawbtNotifySender.mConsoles.unregister(iConsole);
            }
        }
    }

    public static class JobInfo {
        public final Object info;
        public final String jobId;

        public JobInfo(String str, Object obj) {
            this.jobId = str;
            this.info = obj;
        }
    }

    final class MyHandler extends Handler {
        static final int MSG_HANDLE_CONNECT = 41;
        static final int MSG_HANDLE_CONNECT_BY_NAME = 45;
        public static final int MSG_HANDLE_CONNECT_SUCCESS = 63;
        static final int MSG_HANDLE_DISCONNECT = 42;
        public static final int MSG_HANDLE_DISCONNECT_SUCCESS = 64;
        static final int MSG_HANDLE_ERR = 32;
        static final int MSG_HANDLE_JOBS_CANCEL = 51;
        public static final int MSG_HANDLE_JOBS_CANCELED = 62;
        static final int MSG_HANDLE_JOBS_ERROR = 52;
        static final int MSG_HANDLE_JOBS_PROGRESS = 53;
        static final int MSG_HANDLE_JOB_START = 50;
        public static final int MSG_HANDLE_JOB_SUCCESS = 61;
        static final int MSG_HANDLE_PRG = 31;
        static final int MSG_HANDLE_RCV = 33;
        static final int MSG_HANDLE_SEND = 43;
        static final int MSG_HANDLE_SEND_FILE = 44;
        static final int MSG_HANDLE_SND = 34;
        public static final int MSG_HANDLE_STOP = 99;

        MyHandler(Looper looper) {
            super(looper);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$0() {
            LinkedList<RawbtPrintJob> linkedList = AbstractRawBtPrintService.printQueue;
            if (linkedList.isEmpty() || AbstractRawBtPrintService.this.isPrint()) {
                return;
            }
            AbstractRawBtPrintService.isPrint.set(true);
            AbstractRawBtPrintService abstractRawBtPrintService = AbstractRawBtPrintService.this;
            MyHandler myHandler = abstractRawBtPrintService.mHandler;
            myHandler.sendMessageDelayed(myHandler.obtainMessage(31, abstractRawBtPrintService.getString(R.string.start_print_job)), 0L);
            new Thread(new PrintThread(linkedList.poll(), AbstractRawBtPrintService.this.self)).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$1() {
            if (AbstractRawBtPrintService.printQueue.isEmpty()) {
                return;
            }
            while (true) {
                LinkedList<RawbtPrintJob> linkedList = AbstractRawBtPrintService.printQueue;
                if (linkedList.isEmpty()) {
                    return;
                }
                RawbtPrintJob rawbtPrintJobPoll = linkedList.poll();
                if (rawbtPrintJobPoll != null) {
                    File.deleteTempFiles(rawbtPrintJobPoll);
                    MyHandler myHandler = AbstractRawBtPrintService.this.mHandler;
                    myHandler.sendMessageDelayed(myHandler.obtainMessage(62, rawbtPrintJobPoll.getIdJob()), 0L);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$10(String str) {
            AbstractRawBtPrintService.this.showError(null, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$11(byte[] bArr) {
            AbstractRawBtPrintService.this.rawbtNotifySender.sendReceived(bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$12(byte[] bArr) {
            AbstractRawBtPrintService.this.rawbtNotifySender.sendDataSent(bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$13(String str) {
            AbstractRawBtPrintService.this.rawbtNotifySender.sendJobSuccess(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$14(String str) {
            AbstractRawBtPrintService.this.rawbtNotifySender.sendJobCancelled(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$15(String str) {
            AbstractRawBtPrintService.this.rawbtNotifySender.sendNotify(String.format(AbstractRawBtPrintService.this.getString(R.string.namePrinter_connected), str));
            AbstractRawBtPrintService.this.rawbtNotifySender.sendOnPrinterConnect();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$16(String str) {
            AbstractRawBtPrintService.this.rawbtNotifySender.sendNotify(String.format(AbstractRawBtPrintService.this.getString(R.string.namePrinter_disconnected), str));
            AbstractRawBtPrintService.this.rawbtNotifySender.sendOnPrinterDisConnect();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$2(String str, String str2) {
            AbstractRawBtPrintService.this.rawbtNotifySender.sendJobError(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$3(String str, float f3) {
            AbstractRawBtPrintService.this.rawbtNotifySender.sendSetProgress(str, f3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$4() {
            AbstractRawBtPrintService abstractRawBtPrintService = AbstractRawBtPrintService.this;
            if (abstractRawBtPrintService.driverForConsole == null) {
                try {
                    abstractRawBtPrintService.driverForConsole = abstractRawBtPrintService.driver_get("raw_transfer");
                } catch (Exception e3) {
                    AbstractRawBtPrintService.this.showError(null, e3.getMessage());
                    return;
                }
            }
            if (AbstractRawBtPrintService.this.driverForConsole != null) {
                AbstractRawBtPrintService.isPrint.set(true);
                String name = AbstractRawBtPrintService.this.driverForConsole.getPrinterProfile().getName();
                MyHandler myHandler = AbstractRawBtPrintService.this.mHandler;
                myHandler.sendMessageDelayed(myHandler.obtainMessage(63, name), 0L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$5(String str) {
            AbstractRawBtPrintService abstractRawBtPrintService = AbstractRawBtPrintService.this;
            if (abstractRawBtPrintService.driverForConsole == null) {
                try {
                    abstractRawBtPrintService.driverForConsole = abstractRawBtPrintService.raw_driver_get(str);
                } catch (Exception e3) {
                    AbstractRawBtPrintService.this.showError(null, e3.getMessage());
                    return;
                }
            }
            if (AbstractRawBtPrintService.this.driverForConsole != null) {
                AbstractRawBtPrintService.isPrint.set(true);
                String name = AbstractRawBtPrintService.this.driverForConsole.getPrinterProfile().getName();
                MyHandler myHandler = AbstractRawBtPrintService.this.mHandler;
                myHandler.sendMessageDelayed(myHandler.obtainMessage(63, name), 0L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$6() {
            PosDriverInterface posDriverInterface = AbstractRawBtPrintService.this.driverForConsole;
            if (posDriverInterface != null) {
                posDriverInterface.disconnectPrinter();
                AbstractRawBtPrintService abstractRawBtPrintService = AbstractRawBtPrintService.this;
                MyHandler myHandler = abstractRawBtPrintService.mHandler;
                myHandler.sendMessageDelayed(myHandler.obtainMessage(64, abstractRawBtPrintService.driverForConsole.getPrinterProfile().getName()), 0L);
                AbstractRawBtPrintService.this.driverForConsole = null;
            }
            AbstractRawBtPrintService.isPrint.set(false);
            if (AbstractRawBtPrintService.printQueue.isEmpty()) {
                AbstractRawBtPrintService abstractRawBtPrintService2 = AbstractRawBtPrintService.this;
                MyHandler myHandler2 = abstractRawBtPrintService2.mHandler;
                myHandler2.sendMessageDelayed(myHandler2.obtainMessage(31, abstractRawBtPrintService2.getString(R.string.wait_task)), 1000L);
            } else {
                AbstractRawBtPrintService abstractRawBtPrintService3 = AbstractRawBtPrintService.this;
                MyHandler myHandler3 = abstractRawBtPrintService3.mHandler;
                myHandler3.sendMessageDelayed(myHandler3.obtainMessage(31, abstractRawBtPrintService3.getString(R.string.next_task)), 0L);
                AbstractRawBtPrintService.this.mHandler.sendMessageDelayed(AbstractRawBtPrintService.this.mHandler.obtainMessage(50, 0), 1000L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$7(byte[] bArr) {
            AbstractRawBtPrintService abstractRawBtPrintService = AbstractRawBtPrintService.this;
            PosDriverInterface posDriverInterface = abstractRawBtPrintService.driverForConsole;
            if (posDriverInterface == null) {
                MyHandler myHandler = abstractRawBtPrintService.mHandler;
                myHandler.sendMessageDelayed(myHandler.obtainMessage(32, abstractRawBtPrintService.getString(R.string.printer_not_connected)), 0L);
                return;
            }
            posDriverInterface.bytes(bArr);
            if (AbstractRawBtPrintService.this.driverForConsole.isError()) {
                AbstractRawBtPrintService abstractRawBtPrintService2 = AbstractRawBtPrintService.this;
                MyHandler myHandler2 = abstractRawBtPrintService2.mHandler;
                myHandler2.sendMessageDelayed(myHandler2.obtainMessage(32, abstractRawBtPrintService2.driverForConsole.getErrorMessage()), 0L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$8(SendFileTask sendFileTask) {
            AbstractRawBtPrintService abstractRawBtPrintService = AbstractRawBtPrintService.this;
            if (abstractRawBtPrintService.driverForConsole == null) {
                MyHandler myHandler = abstractRawBtPrintService.mHandler;
                myHandler.sendMessageDelayed(myHandler.obtainMessage(31, abstractRawBtPrintService.getString(R.string.printer_not_connected)), 0L);
                return;
            }
            try {
                InputStream inputStreamOpenInputStream = abstractRawBtPrintService.getContentResolver().openInputStream(sendFileTask.uri);
                try {
                    if (sendFileTask.isUtfText) {
                        Objects.requireNonNull(inputStreamOpenInputStream);
                        AbstractRawBtPrintService.this.driverForConsole.bytes(File.readTxtFile(inputStreamOpenInputStream, 1048576, AbstractRawBtPrintService.this.getContext()).getBytes(sendFileTask.needCP));
                    } else {
                        PosDriverInterface posDriverInterface = AbstractRawBtPrintService.this.driverForConsole;
                        Objects.requireNonNull(inputStreamOpenInputStream);
                        posDriverInterface.bytes(File.readBinary(inputStreamOpenInputStream));
                    }
                    if (AbstractRawBtPrintService.this.driverForConsole.isError()) {
                        AbstractRawBtPrintService abstractRawBtPrintService2 = AbstractRawBtPrintService.this;
                        MyHandler myHandler2 = abstractRawBtPrintService2.mHandler;
                        myHandler2.sendMessageDelayed(myHandler2.obtainMessage(32, abstractRawBtPrintService2.driverForConsole.getErrorMessage()), 0L);
                    }
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                    }
                } catch (Throwable th) {
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                AbstractRawBtPrintService.this.rawbtNotifySender.sendError(e3.getLocalizedMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$9(String str) {
            AbstractRawBtPrintService.this.rawbtNotifySender.sendNotify(str);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 99) {
                AbstractRawBtPrintService.this.stopSelf();
            }
            switch (i3) {
                case 31:
                    try {
                        final String str = (String) message.obj;
                        AbstractRawBtPrintService.this.executorNotify.execute(new Runnable() { // from class: rawbt.sdk.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f11209a.lambda$handleMessage$9(str);
                            }
                        });
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                    break;
                case 32:
                    try {
                        final String str2 = (String) message.obj;
                        AbstractRawBtPrintService.this.executorNotify.execute(new Runnable() { // from class: rawbt.sdk.n
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f11211a.lambda$handleMessage$10(str2);
                            }
                        });
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return;
                    }
                    break;
                case 33:
                    try {
                        final byte[] bArr = (byte[]) message.obj;
                        AbstractRawBtPrintService.this.executorNotify.execute(new Runnable() { // from class: rawbt.sdk.o
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f11213a.lambda$handleMessage$11(bArr);
                            }
                        });
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        return;
                    }
                    break;
                case 34:
                    try {
                        final byte[] bArr2 = (byte[]) message.obj;
                        AbstractRawBtPrintService.this.executorNotify.execute(new Runnable() { // from class: rawbt.sdk.p
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f11215a.lambda$handleMessage$12(bArr2);
                            }
                        });
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        return;
                    }
                    break;
                default:
                    switch (i3) {
                        case 41:
                            AbstractRawBtPrintService.this.executorPrint.execute(new Runnable() { // from class: rawbt.sdk.h
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f11201a.lambda$handleMessage$4();
                                }
                            });
                            break;
                        case 42:
                            AbstractRawBtPrintService.this.executorPrint.execute(new Runnable() { // from class: rawbt.sdk.j
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f11204a.lambda$handleMessage$6();
                                }
                            });
                            break;
                        case 43:
                            try {
                                final byte[] bArr3 = (byte[]) message.obj;
                                AbstractRawBtPrintService.this.executorPrint.execute(new Runnable() { // from class: rawbt.sdk.k
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f11205a.lambda$handleMessage$7(bArr3);
                                    }
                                });
                            } catch (Exception e7) {
                                e7.printStackTrace();
                                return;
                            }
                            break;
                        case 44:
                            try {
                                final SendFileTask sendFileTask = (SendFileTask) message.obj;
                                AbstractRawBtPrintService.this.executorPrint.execute(new Runnable() { // from class: rawbt.sdk.l
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f11207a.lambda$handleMessage$8(sendFileTask);
                                    }
                                });
                            } catch (Exception e8) {
                                e8.printStackTrace();
                                return;
                            }
                            break;
                        case 45:
                            final String str3 = (String) message.obj;
                            AbstractRawBtPrintService.this.executorPrint.execute(new Runnable() { // from class: rawbt.sdk.i
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f11202a.lambda$handleMessage$5(str3);
                                }
                            });
                            break;
                        default:
                            switch (i3) {
                                case 50:
                                    AbstractRawBtPrintService.this.executorPrint.execute(new Runnable() { // from class: rawbt.sdk.f
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.f11197a.lambda$handleMessage$0();
                                        }
                                    });
                                    break;
                                case 51:
                                    AbstractRawBtPrintService.this.executorPrint.execute(new Runnable() { // from class: rawbt.sdk.u
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.f11226a.lambda$handleMessage$1();
                                        }
                                    });
                                    break;
                                case 52:
                                    Object obj = message.obj;
                                    final String str4 = ((JobInfo) obj).jobId;
                                    final String str5 = (String) ((JobInfo) obj).info;
                                    AbstractRawBtPrintService.this.executorNotify.execute(new Runnable() { // from class: rawbt.sdk.v
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.f11230a.lambda$handleMessage$2(str4, str5);
                                        }
                                    });
                                    break;
                                case 53:
                                    Object obj2 = message.obj;
                                    final String str6 = ((JobInfo) obj2).jobId;
                                    final float fFloatValue = ((Float) ((JobInfo) obj2).info).floatValue();
                                    AbstractRawBtPrintService.this.executorNotify.execute(new Runnable() { // from class: rawbt.sdk.g
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.f11198a.lambda$handleMessage$3(str6, fFloatValue);
                                        }
                                    });
                                    break;
                                default:
                                    switch (i3) {
                                        case 61:
                                            try {
                                                final String str7 = (String) message.obj;
                                                AbstractRawBtPrintService.this.countSuccessJob();
                                                AbstractRawBtPrintService.this.executorNotify.execute(new Runnable() { // from class: rawbt.sdk.q
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        this.f11217a.lambda$handleMessage$13(str7);
                                                    }
                                                });
                                            } catch (Exception e9) {
                                                e9.printStackTrace();
                                                return;
                                            }
                                            break;
                                        case 62:
                                            try {
                                                final String str8 = (String) message.obj;
                                                AbstractRawBtPrintService.this.executorNotify.execute(new Runnable() { // from class: rawbt.sdk.r
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        this.f11219a.lambda$handleMessage$14(str8);
                                                    }
                                                });
                                            } catch (Exception e10) {
                                                e10.printStackTrace();
                                                return;
                                            }
                                            break;
                                        case 63:
                                            try {
                                                final String str9 = (String) message.obj;
                                                AbstractRawBtPrintService.this.executorNotify.execute(new Runnable() { // from class: rawbt.sdk.s
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        this.f11221a.lambda$handleMessage$15(str9);
                                                    }
                                                });
                                            } catch (Exception e11) {
                                                e11.printStackTrace();
                                                return;
                                            }
                                            break;
                                        case 64:
                                            try {
                                                final String str10 = (String) message.obj;
                                                AbstractRawBtPrintService.this.executorNotify.execute(new Runnable() { // from class: rawbt.sdk.t
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        this.f11223a.lambda$handleMessage$16(str10);
                                                    }
                                                });
                                            } catch (Exception e12) {
                                                e12.printStackTrace();
                                                return;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class SendFileTask {
        public final boolean isUtfText;
        public final String needCP;
        public final Uri uri;

        public SendFileTask(Uri uri, boolean z3, String str) {
            this.uri = uri;
            this.isUtfText = z3;
            this.needCP = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finish$0() {
        if (printQueue.isEmpty()) {
            return;
        }
        while (true) {
            LinkedList<RawbtPrintJob> linkedList = printQueue;
            if (linkedList.isEmpty()) {
                return;
            }
            RawbtPrintJob rawbtPrintJobPoll = linkedList.poll();
            if (rawbtPrintJobPoll != null) {
                File.deleteTempFiles(rawbtPrintJobPoll);
                MyHandler myHandler = this.mHandler;
                myHandler.sendMessageDelayed(myHandler.obtainMessage(62, rawbtPrintJobPoll.getIdJob()), 0L);
            }
        }
    }

    public final void cancel() {
        this.mCancelled.set(true);
        LinkedList<RawbtPrintJob> linkedList = printQueue;
        if (!linkedList.isEmpty()) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(51, 0), 0L);
        }
        if (isPrint() || !linkedList.isEmpty()) {
            return;
        }
        this.mCancelled.set(false);
    }

    protected abstract void countSuccessJob();

    public abstract PosDriverInterface driver_get(String str);

    public final void finish() {
        if (!printQueue.isEmpty()) {
            this.executorPrint.execute(new Runnable() { // from class: rawbt.sdk.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11170a.lambda$finish$0();
                }
            });
        }
        stopForeground(true);
        stopSelf();
    }

    public Context getContext() {
        return this;
    }

    public abstract int getLimitFileSizes();

    public abstract int getLimitPages();

    public abstract List<PrinterEntity> getPrintersList();

    public double getStart() {
        return this.start;
    }

    public double getStep() {
        return this.step;
    }

    public abstract DocumentTemplate get_template(String str);

    public void initCommandProgress(String str, double d3, double d4) {
        this.jobID = str;
        this.start = d3;
        this.step = d4;
    }

    protected RawbtPrintJob injectDefaults(RawbtPrintJob rawbtPrintJob) {
        return rawbtPrintJob;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public abstract boolean isFreeVersion();

    public final boolean isPrint() {
        return isPrint.get();
    }

    public abstract boolean isPrintAfterPageCut();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.d("RAWBT SERVICE", "bind");
        return this.myBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.self = this;
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        this.mHandler = new MyHandler(Looper.myLooper());
        this.mCancelled.set(false);
        isPrint.set(false);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_CANCEL);
        intentFilter.addAction(ACTION_FINISH);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            registerReceiver(this.mReceiver, intentFilter, i3 >= 33 ? 2 : 0);
        } else {
            registerReceiver(this.mReceiver, intentFilter);
        }
        Log.d("RAWBT SERVICE", "create");
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d("RAWBT SERVICE", "Destroy");
        PosDriverInterface posDriverInterface = this.driverForConsole;
        if (posDriverInterface != null) {
            posDriverInterface.disconnectPrinter();
            this.driverForConsole = null;
        }
        this.rawbtNotifySender.mCallbacks.kill();
        this.rawbtNotifySender.mConsoles.kill();
        unregisterReceiver(this.mReceiver);
        super.onDestroy();
    }

    public void onFinishThread() {
        this.previousTaskFinished = System.currentTimeMillis();
        isPrint.set(false);
        this.mCancelled.set(false);
        if (printQueue.isEmpty()) {
            MyHandler myHandler = this.mHandler;
            myHandler.sendMessageDelayed(myHandler.obtainMessage(31, getString(R.string.wait_task)), 1000L);
            MyHandler myHandler2 = this.mHandler;
            myHandler2.sendMessageDelayed(myHandler2.obtainMessage(99), 3000L);
            return;
        }
        MyHandler myHandler3 = this.mHandler;
        myHandler3.sendMessageDelayed(myHandler3.obtainMessage(31, getString(R.string.new_task)), 0L);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(50, 0), 5000L);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.d("RAWBT SERVICE", "Unbind");
        return super.onUnbind(intent);
    }

    public abstract void print_free_note(PosDriverInterface posDriverInterface);

    public abstract PosDriverInterface raw_driver_get(String str);

    public void setStep(double d3) {
        this.step = d3;
    }

    public void showError(String str, String str2) {
        MyHandler myHandler = this.mHandler;
        myHandler.sendMessageDelayed(myHandler.obtainMessage(52, new JobInfo(str, str2)), 0L);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(51, 0), 0L);
    }
}
