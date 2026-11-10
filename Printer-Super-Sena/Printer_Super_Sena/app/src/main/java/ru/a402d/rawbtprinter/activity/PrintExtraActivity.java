package ru.a402d.rawbtprinter.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import rawbt.sdk.RawbtPrintJob;
import rawbt.sdk.utils.RawbtHelper;

/* JADX INFO: loaded from: classes.dex */
public class PrintExtraActivity extends AbstractActivityC0623b {
    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0623b
    protected boolean G() {
        return this.f11543n.n0();
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0623b
    protected RawbtPrintJob O() {
        CharSequence charSequenceExtra;
        RawbtPrintJob rawbtPrintJobC;
        Intent intent = getIntent();
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey("rawbt")) {
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SENDTO".equals(action)) {
                String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
                if (stringExtra == null && (charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TEXT")) != null) {
                    stringExtra = charSequenceExtra.toString();
                }
                if (stringExtra != null && (stringExtra.startsWith("http://") || stringExtra.startsWith("https://"))) {
                    Intent intent2 = new Intent(this, (Class<?>) MainActivity.class);
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(stringExtra));
                    startActivity(intent2);
                    this.f11534e.post(new Runnable() { // from class: r2.y1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11118a.finish();
                        }
                    });
                    return null;
                }
            }
            rawbtPrintJobC = B2.b.c(intent, this.f11543n);
        } else {
            String string = extras.getString("rawbt");
            rawbtPrintJobC = string != null ? Q(string) : null;
        }
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
