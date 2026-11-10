package A2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.drivers.PosDriverInterface;
import rawbt.sdk.templates.DocumentTemplate;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
public class a implements DocumentTemplate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final y2.b f65a = y2.b.w();

    @Override // rawbt.sdk.templates.DocumentTemplate
    public void footer(PosDriverInterface posDriverInterface) {
        AttributesString attributesString = posDriverInterface.getPrinterProfile().getAttributesString();
        String strE = this.f65a.e();
        if (strE != null && strE.length() > 0) {
            if (posDriverInterface.getPrinterProfile().isPrintTextAsImage() || attributesString.getPrinterFont() == 4) {
                posDriverInterface.text_as_image(strE, attributesString);
            } else {
                posDriverInterface.text(strE + "\n", attributesString);
            }
        }
        if (this.f65a.o0()) {
            Date date = new Date();
            String str = "\n" + DateFormat.getDateInstance(3, new Locale(this.f65a.K())).format(date) + " " + android.text.format.DateFormat.getTimeFormat(RawPrinterApp.g()).format(date) + "\n";
            if (posDriverInterface.getPrinterProfile().isPrintTextAsImage() || attributesString.getPrinterFont() == 4) {
                posDriverInterface.text_as_image(str, attributesString);
            } else {
                posDriverInterface.text(str, attributesString);
            }
        }
        posDriverInterface.scrollPaper(posDriverInterface.getPrinterProfile().getSkipLinesAfterJob());
        if (this.f65a.s0()) {
            posDriverInterface.cutPaper();
        }
    }

    @Override // rawbt.sdk.templates.DocumentTemplate
    public void head(PosDriverInterface posDriverInterface) {
        if (this.f65a.p0()) {
            posDriverInterface.text("\n", new AttributesString());
            Bitmap bitmap = ((BitmapDrawable) this.f65a.G()).getBitmap();
            AttributesImage attributesImageA = this.f65a.a();
            attributesImageA.setScale(16);
            posDriverInterface.printImage(bitmap, attributesImageA);
        }
        AttributesString attributesString = posDriverInterface.getPrinterProfile().getAttributesString();
        String strT = this.f65a.T();
        if (strT == null || strT.length() <= 0) {
            return;
        }
        if (posDriverInterface.getPrinterProfile().isPrintTextAsImage() || attributesString.getPrinterFont() == 4) {
            posDriverInterface.text_as_image(strT, attributesString);
            return;
        }
        posDriverInterface.text(strT + "\n", attributesString);
    }
}
