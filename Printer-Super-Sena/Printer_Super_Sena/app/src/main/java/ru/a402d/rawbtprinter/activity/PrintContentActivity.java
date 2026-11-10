package ru.a402d.rawbtprinter.activity;

import rawbt.sdk.RawbtPrintJob;
import rawbt.sdk.utils.RawbtHelper;

/* JADX INFO: loaded from: classes.dex */
public class PrintContentActivity extends AbstractActivityC0623b {
    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0623b
    protected boolean G() {
        return this.f11543n.n0();
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0623b
    protected RawbtPrintJob O() {
        RawbtPrintJob rawbtPrintJobC = B2.b.c(getIntent(), this.f11543n);
        if (rawbtPrintJobC == null) {
            return null;
        }
        rawbtPrintJobC.setCopies(this.f11543n.i());
        rawbtPrintJobC.setDefaultAttrImage(this.f11543n.a());
        rawbtPrintJobC.setDefaultAttrPdf(this.f11543n.b());
        rawbtPrintJobC.setDefaultAttrString(this.f11543n.c());
        return RawbtHelper.prepareJob(rawbtPrintJobC, this);
    }
}
