package rawbt.sdk.emulator.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import rawbt.sdk.emulator.escpos.EscPosEmulator;

/* JADX INFO: loaded from: classes.dex */
public class ParserPrn {
    private static StringBuilder hex_notify;
    private static long lastNotifyTime;
    private static StringBuilder log_notify;
    private static int outNumber;
    private static int outhNumber;
    final Context context;
    final boolean isFree;

    public ParserPrn(Context context, boolean z3) {
        this.context = context;
        this.isFree = z3;
    }

    public void notify(PreviewTaskCallback previewTaskCallback, int i3, int i4, String str, String str2) {
        if (previewTaskCallback != null) {
            if (str != null) {
                if (this.isFree && outhNumber % 2 == 1) {
                    hex_notify.append(String.format("<span style='color:blue'>%06X</span>|<span style='color:red'>%s</span><br/>", Integer.valueOf(i3 & 16777215), "You are using the free version"));
                } else {
                    hex_notify.append(String.format("<pre><span style='color:blue'>%06X</span>|%s</pre><br/>", Integer.valueOf(i3 & 16777215), str.replaceAll("←", "<span style='color:magenta'>*</span>").replaceAll("∟", "<span style='color:#000000'>*</span>").replaceAll("↔", "<span style='color:blue'>*</span>").replaceAll("1B ", "<span style='color:magenta'>1B</span> ").replaceAll("1C ", "<span style='color:#000000'>1C</span> ").replaceAll("1D ", "<span style='color:blue'>1D</span> ")));
                }
                outhNumber++;
            }
            if (str2 != null) {
                if (this.isFree && outNumber % 2 == 1) {
                    log_notify.append(String.format("<span style='color:blue'>%06X</span>|%s<br/>", Integer.valueOf(i3 & 16777215), "<span style='color:red'>* Buy license for full access *</span>"));
                } else {
                    log_notify.append(String.format("<span style='color:blue'>%06X</span>|%s<br/>", Integer.valueOf(16777215 & i3), str2));
                }
                outNumber++;
            }
            if (System.currentTimeMillis() - lastNotifyTime > 200) {
                previewTaskCallback.updateProgress(i3, i4, hex_notify.toString(), log_notify.toString());
                lastNotifyTime = System.currentTimeMillis();
                hex_notify = new StringBuilder();
                log_notify = new StringBuilder();
            }
        }
    }

    public Bitmap parse(final PreviewTaskCallback previewTaskCallback, byte[] bArr, int i3, String str, boolean z3) {
        outNumber = 0;
        outhNumber = 0;
        lastNotifyTime = -1L;
        hex_notify = new StringBuilder();
        log_notify = new StringBuilder();
        notify(previewTaskCallback, 0, bArr.length, null, "Received bytes:" + bArr.length);
        try {
            EscPosEmulator escPosEmulator = new EscPosEmulator(this.context, bArr, str, i3);
            escPosEmulator.parse(new Debugger() { // from class: rawbt.sdk.emulator.common.ParserPrn.1
                int current = 0;
                int total = 0;

                @Override // rawbt.sdk.emulator.common.Debugger
                public void hexLog(String str2) {
                    this.notify(previewTaskCallback, this.current, this.total, str2, null);
                }

                @Override // rawbt.sdk.emulator.common.Debugger
                public void infoLog(String str2) {
                    this.notify(previewTaskCallback, this.current, this.total, null, str2);
                }

                @Override // rawbt.sdk.emulator.common.Debugger
                public void sendNow() {
                    long unused = ParserPrn.lastNotifyTime = 0L;
                }

                @Override // rawbt.sdk.emulator.common.Debugger
                public void setParsePoint(int i4) {
                    this.current = i4;
                }

                @Override // rawbt.sdk.emulator.common.Debugger
                public void setTotalProgress(int i4) {
                    this.total = i4;
                }
            });
            lastNotifyTime = -1L;
            notify(previewTaskCallback, 0, 1, null, "OutBmp w " + i3 + " h:" + escPosEmulator.getOutput_height());
            Bitmap preview = escPosEmulator.getPreview();
            if (preview == null) {
                return null;
            }
            ArrayList<Integer> cut_pos = escPosEmulator.getCut_pos();
            if (!z3) {
                return preview;
            }
            int i4 = cut_pos.size() > 0 ? 5 : 2;
            int width = preview.getWidth() + 96;
            int i5 = i4 * 32;
            int height = preview.getHeight() + i5 + 56;
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, config);
            bitmapCreateBitmap.eraseColor(-7829368);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            int[] iArr = {-16776961, 0, 0, 0, 0, -16776961, 0, -16776961, 0, 0, -16776961, 0};
            paint.setColor(-16776961);
            canvas.drawRect(new Rect(0, (bitmapCreateBitmap.getHeight() - 48) - i5, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight()), paint);
            Rect rect = new Rect(8, 8, preview.getWidth() + 88, preview.getHeight() + 8 + i5);
            paint.setColor(-460552);
            paint.setTextSize(21.0f);
            canvas.drawRect(rect, paint);
            canvas.drawText("RAWBT.APP", (bitmapCreateBitmap.getWidth() / 2) - 60.0f, bitmapCreateBitmap.getHeight() - 12, paint);
            float f3 = i5 + 8;
            canvas.drawBitmap(preview, 48.0f, f3, paint);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(4, 3, config);
            bitmapCreateBitmap2.setPixels(new int[]{-7829368, 0, 0, 0, 0, -7829368, 0, -7829368, 0, 0, -7829368, 0}, 0, 4, 0, 0, 4, 3);
            for (int width2 = 0; width2 < bitmapCreateBitmap.getWidth() - 16; width2 += bitmapCreateBitmap2.getWidth()) {
                canvas.drawBitmap(bitmapCreateBitmap2, width2 + 8, f3, paint);
            }
            bitmapCreateBitmap2.setPixels(iArr, 0, 4, 0, 0, 4, 3);
            for (int width3 = 0; width3 < bitmapCreateBitmap.getWidth() - 16; width3 += bitmapCreateBitmap2.getWidth()) {
                canvas.drawBitmap(bitmapCreateBitmap2, width3 + 8, (bitmapCreateBitmap.getHeight() - 48) - i5, paint);
            }
            if (cut_pos.size() > 0) {
                Iterator<Integer> it = cut_pos.iterator();
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    for (int width4 = 0; width4 < bitmapCreateBitmap.getWidth() - 16; width4 += bitmapCreateBitmap2.getWidth()) {
                        canvas.drawBitmap(bitmapCreateBitmap2, width4 + 8, (iIntValue - 94) + i5, paint);
                    }
                }
            }
            lastNotifyTime = -1L;
            notify(previewTaskCallback, 1, 1, null, "*** END ***");
            return bitmapCreateBitmap;
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            lastNotifyTime = -1L;
            notify(previewTaskCallback, 0, 1, null, "!! " + e3.getLocalizedMessage());
            return null;
        }
    }
}
