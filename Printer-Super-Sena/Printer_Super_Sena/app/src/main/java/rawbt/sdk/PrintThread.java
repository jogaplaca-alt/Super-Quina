package rawbt.sdk;

import android.content.Context;
import android.os.Looper;
import rawbt.sdk.drivers.PosDriverInterface;
import rawbt.sdk.utils.File;

/* JADX INFO: loaded from: classes.dex */
class PrintThread implements Runnable, RawbtPrintJob.RawbtPrintJobCallback {
    private final AbstractRawBtPrintService callback;
    private final RawbtPrintJob job;

    PrintThread(RawbtPrintJob rawbtPrintJob, AbstractRawBtPrintService abstractRawBtPrintService) {
        this.callback = abstractRawBtPrintService;
        this.job = rawbtPrintJob;
    }

    @Override // rawbt.sdk.RawbtPrintJob.RawbtPrintJobCallback
    public PosDriverInterface driver_get(String str) {
        return this.callback.driver_get(str);
    }

    public AbstractRawBtPrintService getCallback() {
        return this.callback;
    }

    @Override // rawbt.sdk.RawbtPrintJob.RawbtPrintJobCallback
    public Context getContext() {
        return this.callback.getContext();
    }

    @Override // rawbt.sdk.RawbtPrintJob.RawbtPrintJobCallback
    public int getLimitFileSize() {
        return this.callback.getLimitFileSizes();
    }

    @Override // rawbt.sdk.RawbtPrintJob.RawbtPrintJobCallback
    public int getLimitPages() {
        return this.callback.getLimitPages();
    }

    @Override // rawbt.sdk.RawbtPrintJob.RawbtPrintJobCallback
    public boolean isCancelled() {
        return this.callback.isCancelled();
    }

    @Override // rawbt.sdk.RawbtPrintJob.RawbtPrintJobCallback
    public boolean isFreeVersion() {
        return this.callback.isFreeVersion();
    }

    @Override // rawbt.sdk.RawbtPrintJob.RawbtPrintJobCallback
    public boolean isPrintAfterPageCut() {
        return this.callback.isPrintAfterPageCut();
    }

    @Override // rawbt.sdk.RawbtPrintJob.RawbtPrintJobCallback
    public void jobCancelled(String str) {
        this.callback.mHandler.sendMessageDelayed(this.callback.mHandler.obtainMessage(62, str), 0L);
    }

    @Override // rawbt.sdk.RawbtPrintJob.RawbtPrintJobCallback
    public void jobSuccess(String str) {
        this.callback.mHandler.sendMessageDelayed(this.callback.mHandler.obtainMessage(61, str), 0L);
    }

    @Override // rawbt.sdk.RawbtPrintJob.RawbtPrintJobCallback
    public void print_footer(PosDriverInterface posDriverInterface, String str) {
        this.callback.get_template(str).footer(posDriverInterface);
    }

    @Override // rawbt.sdk.RawbtPrintJob.RawbtPrintJobCallback
    public void print_free_note(PosDriverInterface posDriverInterface) {
        this.callback.print_free_note(posDriverInterface);
    }

    @Override // rawbt.sdk.RawbtPrintJob.RawbtPrintJobCallback
    public void print_header(PosDriverInterface posDriverInterface, String str) {
        this.callback.get_template(str).head(posDriverInterface);
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        try {
            this.job.execute(this);
        } catch (Exception e3) {
            e3.printStackTrace();
            this.callback.showError(this.job.getIdJob(), e3.getLocalizedMessage());
        }
        File.deleteTempFiles(this.job);
        this.callback.onFinishThread();
    }

    @Override // rawbt.sdk.RawbtPrintJob.RawbtPrintJobCallback
    public void setProgress(String str, float f3) {
        this.callback.mHandler.sendMessageDelayed(this.callback.mHandler.obtainMessage(53, new AbstractRawBtPrintService.JobInfo(str, Float.valueOf(f3))), 0L);
    }

    @Override // rawbt.sdk.RawbtPrintJob.RawbtPrintJobCallback
    public void showError(String str, String str2) {
        this.callback.showError(str, str2);
    }

    @Override // rawbt.sdk.RawbtPrintJob.RawbtPrintJobCallback
    public void showProgress(String str) {
        this.callback.mHandler.sendMessageDelayed(this.callback.mHandler.obtainMessage(31, str), 0L);
    }
}
