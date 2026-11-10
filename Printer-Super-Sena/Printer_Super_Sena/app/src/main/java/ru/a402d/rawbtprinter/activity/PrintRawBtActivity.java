package ru.a402d.rawbtprinter.activity;

import android.content.Intent;
import android.net.Uri;
import rawbt.api.command.RawbtCommand;
import rawbt.sdk.RawbtCommandInstanceCreator;
import rawbt.sdk.RawbtPrintJob;

/* JADX INFO: loaded from: classes.dex */
public class PrintRawBtActivity extends AbstractActivityC0623b {
    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0623b
    protected boolean G() {
        return false;
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0623b
    protected RawbtPrintJob O() {
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("android.intent.action.VIEW".equals(action)) {
            Uri data = intent.getData();
            if (data == null) {
                return null;
            }
            return Q(data.getEncodedSchemeSpecificPart());
        }
        if ("ru.a402d.rawbtprinter.action.PRINT_RAWBT".equals(action)) {
            return Q(intent.getStringExtra("ru.a402d.rawbtprinter.extra.DATA"));
        }
        if (!rawbt.api.RawbtPrintJob.ACTION_PRINT_JOB.equals(action)) {
            return null;
        }
        p075w1.e eVar = new p075w1.e();
        eVar.c(RawbtCommand.class, new RawbtCommandInstanceCreator());
        return (RawbtPrintJob) eVar.b().j(intent.getStringExtra(rawbt.api.RawbtPrintJob.EXTRA_JOB), RawbtPrintJob.class);
    }
}
