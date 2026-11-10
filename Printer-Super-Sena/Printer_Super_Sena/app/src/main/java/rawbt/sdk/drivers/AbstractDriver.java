package rawbt.sdk.drivers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import rawbt.api.Constant;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.api.command.CommandBarcode;
import rawbt.api.command.CommandDrawLine;
import rawbt.api.command.CommandLeftRightText;
import rawbt.api.command.CommandQRcode;
import rawbt.sdk.R;
import rawbt.sdk.barcode.BarCodeDraw;
import rawbt.sdk.barcode.QrCodeDraw;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.transport.ConnectParameters;
import rawbt.sdk.utils.GraphLibrary;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDriver implements PosDriverInterface {
    PrinterEntity PrinterEntity;
    private Context context;
    private boolean errorPresent = false;
    private String errMsg = null;
    protected PosDriverInterface.TaskForTransport jobTask = null;
    long prevSent = 0;

    /* JADX WARN: Code duplicated, block: B:31:0x00a1  */
    private static Bitmap _drawText(String str, AttributesString attributesString, PrinterEntity printerEntity, int i3) {
        int density;
        byte b3;
        Layout.Alignment alignment;
        int printerFont = attributesString.getPrinterFont();
        if (printerFont == 2) {
            density = (printerEntity.getDensity() * 19) / 203;
        } else if (printerFont != 3) {
            density = printerFont != 4 ? (printerEntity.getDensity() * 21) / 203 : (attributesString.getTruetypeFontSize() * printerEntity.getDensity()) / 203;
        } else {
            density = (printerEntity.getDensity() * 17) / 203;
        }
        Typeface typeface = Typeface.MONOSPACE;
        TextPaint textPaint = new TextPaint();
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(-16777216);
        textPaint.setTextSize(density);
        textPaint.setAntiAlias(false);
        textPaint.setSubpixelText(false);
        textPaint.setDither(false);
        textPaint.setTypeface(Typeface.create(typeface, attributesString.isBold() ? 1 : 0));
        if (attributesString.isUnderline()) {
            textPaint.setFlags(8);
        }
        String alignment2 = attributesString.getAlignment();
        int iHashCode = alignment2.hashCode();
        if (iHashCode != -1364013995) {
            if (iHashCode != 3317767) {
                if (iHashCode == 108511772 && alignment2.equals(Constant.ALIGNMENT_RIGHT)) {
                    b3 = 0;
                } else {
                    b3 = -1;
                }
            } else if (alignment2.equals(Constant.ALIGNMENT_LEFT)) {
                b3 = 2;
            } else {
                b3 = -1;
            }
        } else if (alignment2.equals(Constant.ALIGNMENT_CENTER)) {
            b3 = 1;
        } else {
            b3 = -1;
        }
        if (b3 != 0) {
            alignment = b3 != 1 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
        } else {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        Layout.Alignment alignment3 = alignment;
        int dots_per_line = i3 > 0 ? i3 : printerEntity.getDots_per_line();
        if (attributesString.isDoubleWidth()) {
            dots_per_line /= 2;
        }
        StaticLayout staticLayoutBuild = Build.VERSION.SDK_INT >= 23 ? StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, dots_per_line).setAlignment(alignment3).build() : new StaticLayout(str, textPaint, dots_per_line, alignment3, 1.0f, 0.0f, false);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dots_per_line, staticLayoutBuild.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        bitmapCreateBitmap.eraseColor(-1);
        canvas.translate(0.0f, 0.0f);
        staticLayoutBuild.draw(canvas);
        if (attributesString.isDoubleWidth() || attributesString.isDoubleHeight()) {
            return Bitmap.createScaledBitmap(bitmapCreateBitmap, bitmapCreateBitmap.getWidth() * (attributesString.isDoubleWidth() ? 2 : 1), bitmapCreateBitmap.getHeight() * (attributesString.isDoubleHeight() ? 2 : 1), false);
        }
        return bitmapCreateBitmap;
    }

    private int calcWidth(String str, AttributesString attributesString, PrinterEntity printerEntity) {
        int density;
        if (!printerEntity.isPrintTextAsImage() && attributesString.getPrinterFont() != 4) {
            int printerFont = attributesString.getPrinterFont();
            if (printerFont == 2) {
                return (((attributesString.isDoubleWidth() ? 2 : 1) * 9) * printerEntity.getDensity()) / 203;
            }
            if (printerFont != 3) {
                return (((attributesString.isDoubleWidth() ? 2 : 1) * 12) * printerEntity.getDensity()) / 203;
            }
            return (((attributesString.isDoubleWidth() ? 2 : 1) * 8) * printerEntity.getDensity()) / 203;
        }
        int printerFont2 = attributesString.getPrinterFont();
        if (printerFont2 == 2) {
            density = (printerEntity.getDensity() * 19) / 203;
        } else if (printerFont2 != 3) {
            density = printerFont2 != 4 ? (printerEntity.getDensity() * 21) / 203 : (attributesString.getTruetypeFontSize() * printerEntity.getDensity()) / 203;
        } else {
            density = (printerEntity.getDensity() * 17) / 203;
        }
        Typeface typeface = Typeface.MONOSPACE;
        TextPaint textPaint = new TextPaint();
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(-16777216);
        textPaint.setTextSize(density);
        textPaint.setAntiAlias(false);
        textPaint.setSubpixelText(false);
        textPaint.setDither(false);
        textPaint.setTypeface(Typeface.create(typeface, attributesString.isBold() ? 1 : 0));
        if (attributesString.isUnderline()) {
            textPaint.setFlags(8);
        }
        float[] fArr = new float[1];
        textPaint.getTextWidths(str, 0, 1, fArr);
        int iCeil = (int) Math.ceil(fArr[0]);
        return attributesString.isDoubleWidth() ? iCeil * 2 : iCeil;
    }

    public static Bitmap drawText(String str, AttributesString attributesString, PrinterEntity printerEntity) {
        return _drawText(str, attributesString, printerEntity, 0);
    }

    private String repeatText(String str, int i3) {
        if (i3 < 1) {
            return "";
        }
        return String.format("%0" + i3 + "d", 0).replace("0", str);
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public final void barcode(CommandBarcode commandBarcode) {
        Bitmap bitmapBarcodeDraw = barcodeDraw(commandBarcode);
        if (bitmapBarcodeDraw != null) {
            AttributesImage attributesImage = new AttributesImage(9);
            attributesImage.setAlignment(commandBarcode.getAlignment());
            attributesImage.setDoScale(false);
            printImage(bitmapBarcodeDraw, attributesImage);
        }
    }

    public final Bitmap barcodeDraw(CommandBarcode commandBarcode) {
        return BarCodeDraw.drawCode(commandBarcode, getPrinterProfile().getDots_per_line(), -1, -16777216);
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public abstract void bytes(byte[] bArr);

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public final void clearBuf() {
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public abstract String connectPrinter(ConnectParameters connectParameters);

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public abstract void cutPaper();

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public abstract void disconnectPrinter();

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public final void drawCharLine(CommandDrawLine commandDrawLine) {
        PrinterEntity printerProfile = getPrinterProfile();
        AttributesString attributesString = commandDrawLine.getAttributesString();
        String string = Character.toString(commandDrawLine.getCh().charValue());
        String strRepeatText = repeatText(string, printerProfile.getDots_per_line() / calcWidth(string, attributesString, printerProfile));
        if (printerProfile.isPrintTextAsImage() || attributesString.getPrinterFont() == 4) {
            printImage(drawText(strRepeatText, attributesString, printerProfile), new AttributesImage(9).setAlignment(Constant.ALIGNMENT_CENTER));
        } else {
            text(strRepeatText + "\n", attributesString);
        }
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public abstract void finish();

    @Override // rawbt.sdk.transport.Transport.CallBack
    public final Context getContext() {
        return this.context;
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public final String getErrorMessage() {
        return this.errMsg;
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface, rawbt.sdk.transport.Transport.CallBack
    public PrinterEntity getPrinterProfile() {
        return this.PrinterEntity;
    }

    protected abstract void graphics(byte[] bArr, int i3, int i4);

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public abstract void initialize();

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public final void interactiveTask(PosDriverInterface.TaskForTransport taskForTransport) {
        this.jobTask = taskForTransport;
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface, rawbt.sdk.transport.Transport.CallBack
    public final boolean isCancelled() {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport == null) {
            return false;
        }
        return taskForTransport.isCancelled();
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface, rawbt.sdk.transport.Transport.CallBack
    public boolean isError() {
        return this.errorPresent;
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public final void leftRight(CommandLeftRightText commandLeftRightText) {
        String strRepeatText;
        String strRepeatText2;
        AttributesImage attributesImage;
        AttributesImage alignment = new AttributesImage(9).setAlignment(Constant.ALIGNMENT_CENTER);
        PrinterEntity printerProfile = getPrinterProfile();
        String strRepeatText3 = repeatText(" ", commandLeftRightText.getLeftIndent());
        String leftText = commandLeftRightText.getLeftText();
        AttributesString alignment2 = commandLeftRightText.getLeftAttr().build().setAlignment(Constant.ALIGNMENT_LEFT);
        int iCalcWidth = calcWidth(leftText, alignment2, printerProfile);
        int leftIndent = (commandLeftRightText.getLeftIndent() + leftText.length()) * iCalcWidth;
        String strRepeatText4 = repeatText(" ", commandLeftRightText.getRightIndent());
        String rightText = commandLeftRightText.getRightText();
        AttributesString alignment3 = commandLeftRightText.getRightAttr().build().setAlignment(Constant.ALIGNMENT_RIGHT);
        int iCalcWidth2 = calcWidth(rightText, commandLeftRightText.getRightAttr(), printerProfile);
        int rightIndent = (commandLeftRightText.getRightIndent() + rightText.length()) * iCalcWidth2;
        int dots_per_line = printerProfile.getDots_per_line();
        if (leftIndent + rightIndent > dots_per_line) {
            if (printerProfile.isPrintTextAsImage() || alignment2.getPrinterFont() == 4 || alignment3.getPrinterFont() == 4) {
                printImage(drawText(strRepeatText3 + leftText, alignment2, printerProfile), alignment);
                printImage(drawText(rightText + strRepeatText4, alignment3, printerProfile), alignment);
                return;
            }
            text(strRepeatText3 + leftText + "\n", alignment2);
            text(rightText + strRepeatText4 + "\n", alignment3);
            return;
        }
        int i3 = (dots_per_line - leftIndent) - rightIndent;
        if (iCalcWidth <= iCalcWidth2) {
            strRepeatText2 = repeatText(" ", i3 / iCalcWidth);
            strRepeatText = "";
        } else {
            strRepeatText = repeatText(" ", i3 / iCalcWidth2);
            strRepeatText2 = "";
        }
        if (printerProfile.isPrintTextAsImage()) {
            attributesImage = alignment;
        } else {
            attributesImage = alignment;
            if (alignment2.getPrinterFont() != 4 && alignment3.getPrinterFont() != 4) {
                alignment3.setAlignment(Constant.ALIGNMENT_LEFT);
                text(strRepeatText3 + leftText + strRepeatText2, alignment2);
                text(strRepeatText + rightText + strRepeatText4 + "\n", alignment3);
                return;
            }
        }
        Bitmap bitmap_drawText = _drawText(strRepeatText3 + leftText, alignment2, printerProfile, leftIndent);
        Bitmap bitmap_drawText2 = _drawText(rightText + strRepeatText4, alignment3, printerProfile, rightIndent);
        int iMax = Math.max(bitmap_drawText.getHeight(), bitmap_drawText2.getHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dots_per_line, iMax, Bitmap.Config.RGB_565);
        bitmapCreateBitmap.eraseColor(-1);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap_drawText, 0.0f, iMax - bitmap_drawText.getHeight(), (Paint) null);
        canvas.drawBitmap(bitmap_drawText2, dots_per_line - bitmap_drawText2.getWidth(), iMax - bitmap_drawText2.getHeight(), (Paint) null);
        printImage(bitmapCreateBitmap, attributesImage);
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void printImage(Bitmap bitmap, AttributesImage attributesImage) {
        int i3;
        int i4;
        int dots_per_line = (getPrinterProfile().getDots_per_line() * attributesImage.getScale()) / 16;
        int dots_per_line2 = getPrinterProfile().getDots_per_line();
        if (bitmap != null) {
            Bitmap.Config config = bitmap.getConfig();
            try {
                Bitmap bitmapRotateBitmap = attributesImage.isRotateImage() ? GraphLibrary.rotateBitmap(bitmap) : bitmap;
                boolean zIsDoScale = attributesImage.isDoScale();
                if (!attributesImage.isDoScale() && bitmapRotateBitmap.getWidth() > dots_per_line) {
                    zIsDoScale = true;
                }
                if (zIsDoScale) {
                    bitmapRotateBitmap = GraphLibrary.resizeImage(bitmapRotateBitmap, dots_per_line, (bitmapRotateBitmap.getHeight() * dots_per_line) / bitmapRotateBitmap.getWidth());
                }
                Bitmap bitmapCreateBitmap = bitmapRotateBitmap;
                int height = bitmapCreateBitmap.getHeight();
                if (attributesImage.getScale() < 16 || !attributesImage.isDoScale()) {
                    int width = bitmapCreateBitmap.getWidth();
                    int[] iArr = new int[width * height];
                    bitmapCreateBitmap.getPixels(iArr, 0, bitmapCreateBitmap.getWidth(), 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                    bitmapCreateBitmap = Bitmap.createBitmap(dots_per_line2, height, config);
                    bitmapCreateBitmap.eraseColor(attributesImage.isInverseColor() ? -16777216 : -1);
                    if (Constant.ALIGNMENT_RIGHT.equals(attributesImage.getAlignment())) {
                        i4 = dots_per_line2 - width;
                    } else {
                        if (Constant.ALIGNMENT_CENTER.equals(attributesImage.getAlignment())) {
                            i4 = (dots_per_line2 - width) / 2;
                        } else {
                            i3 = 0;
                        }
                        bitmapCreateBitmap.setPixels(iArr, 0, width, i3, 0, width, height);
                    }
                    i3 = i4;
                    bitmapCreateBitmap.setPixels(iArr, 0, width, i3, 0, width, height);
                }
                int[] iArr2 = new int[((height + 1) * dots_per_line2) + 1];
                if (attributesImage.getGraphicFilter() == 0 || attributesImage.getGraphicFilter() == 8) {
                    bitmapCreateBitmap = GraphLibrary.toGrayscale(bitmapCreateBitmap);
                }
                bitmapCreateBitmap.getPixels(iArr2, 0, bitmapCreateBitmap.getWidth(), 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                byte[] bArrDithering = GraphLibrary.dithering(iArr2, height, dots_per_line2, attributesImage.getGraphicFilter(), this.context);
                bitmapCreateBitmap.recycle();
                if (attributesImage.isInverseColor()) {
                    for (int i5 = 0; i5 < bArrDithering.length; i5++) {
                        if (bArrDithering[i5] == 1) {
                            bArrDithering[i5] = 0;
                        } else {
                            bArrDithering[i5] = 1;
                        }
                    }
                }
                graphics(bArrDithering, dots_per_line2, height);
            } catch (Exception e3) {
                setErrorMessage(e3.getLocalizedMessage());
                e3.printStackTrace();
                PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
                if (taskForTransport != null) {
                    taskForTransport.deviceError(e3.getLocalizedMessage());
                }
            } catch (OutOfMemoryError e4) {
                Context context = this.context;
                int i6 = R.string.out_of_memory;
                setErrorMessage(context.getString(i6));
                PosDriverInterface.TaskForTransport taskForTransport2 = this.jobTask;
                if (taskForTransport2 != null) {
                    taskForTransport2.deviceError(this.context.getString(i6));
                }
                e4.printStackTrace();
            }
        }
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public final void qrcode(CommandQRcode commandQRcode) {
        Bitmap bitmapDrawQR = QrCodeDraw.drawQR(commandQRcode, getPrinterProfile().getDots_per_line(), -1, -16777216);
        if (bitmapDrawQR != null) {
            AttributesImage attributesImage = new AttributesImage(9);
            attributesImage.setAlignment(commandQRcode.getAlignment());
            attributesImage.setDoScale(false);
            printImage(bitmapDrawQR, attributesImage);
        }
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void resetError() {
        this.errorPresent = false;
        this.errMsg = null;
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public abstract void scrollPaper(int i3);

    public final void setContext(Context context) {
        this.context = context;
    }

    public final void setErrorMessage(String str) {
        this.errorPresent = true;
        this.errMsg = str;
    }

    public void setPrinterEntity(PrinterEntity printerEntity) {
        this.PrinterEntity = printerEntity;
    }

    public final void stepPercent(int i3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.prevSent > 50) {
            PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
            if (taskForTransport != null) {
                taskForTransport.stepPercent(i3);
            }
            this.prevSent = jCurrentTimeMillis;
        }
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public abstract void text(String str, AttributesString attributesString);

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void text_as_image(String str, AttributesString attributesString) {
        AttributesImage attributesImage = new AttributesImage(9);
        if ("\n".equals(str)) {
            bytes(new byte[]{10});
        } else if ("\n\n".equals(str)) {
            bytes(new byte[]{10, 10});
        } else {
            printImage(drawText(str, attributesString, getPrinterProfile()), attributesImage);
        }
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public final void transportError(String str) {
        this.errorPresent = true;
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.deviceError(str);
        }
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public final void transportMessage(String str) {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.deviceProgress(str);
        }
    }
}
