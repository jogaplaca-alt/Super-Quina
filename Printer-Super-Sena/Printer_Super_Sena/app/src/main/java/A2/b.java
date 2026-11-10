package A2;

import rawbt.sdk.drivers.PosDriverInterface;
import rawbt.sdk.templates.DocumentTemplate;

/* JADX INFO: loaded from: classes.dex */
public class b implements DocumentTemplate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final y2.b f66a = y2.b.w();

    @Override // rawbt.sdk.templates.DocumentTemplate
    public void footer(PosDriverInterface posDriverInterface) {
        posDriverInterface.scrollPaper(posDriverInterface.getPrinterProfile().getSkipLinesAfterJob());
        if (this.f66a.s0()) {
            posDriverInterface.cutPaper();
        }
    }

    @Override // rawbt.sdk.templates.DocumentTemplate
    public void head(PosDriverInterface posDriverInterface) {
    }
}
