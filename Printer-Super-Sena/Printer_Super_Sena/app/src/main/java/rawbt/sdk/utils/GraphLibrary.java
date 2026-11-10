package rawbt.sdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.pdf.PdfRenderer;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import java.nio.IntBuffer;
import java.util.Arrays;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesPdf;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.drivers.AbstractDriver;
import rawbt.sdk.drivers.PosDriverInterface;
import rawbt.sdk.profiles.FictivePrinterProfile;

/* JADX INFO: loaded from: classes.dex */
public final class GraphLibrary {

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private static final int[] f11227p0 = {0, 128};

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private static final int[] f11228p1 = {0, 64};

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    private static final int[] f11229p2 = {0, 32};
    private static final int[] p3 = {0, 16};
    private static final int[] p4 = {0, 8};
    private static final int[] p5 = {0, 4};
    private static final int[] p6 = {0, 2};
    private static final int[][] m_16 = {new int[]{0, 128, 32, 160, 8, 136, 40, 168, 2, 130, 34, 162, 10, 138, 42, 170}, new int[]{192, 64, 224, 96, 200, 72, 232, 104, 194, 66, 226, 98, 202, 74, 234, 106}, new int[]{48, 176, 16, 144, 56, 184, 24, 152, 50, 178, 18, 146, 58, 186, 26, 154}, new int[]{240, 112, 208, 80, 248, 120, 216, 88, 242, 114, 210, 82, 250, 122, 218, 90}, new int[]{12, 140, 44, 172, 4, 132, 36, 164, 14, 142, 46, 174, 6, 134, 38, 166}, new int[]{204, 76, 236, 108, 196, 68, 228, 100, 206, 78, 238, 110, 198, 70, 230, 102}, new int[]{60, 188, 28, 156, 52, 180, 20, 148, 62, 190, 30, 158, 54, 182, 22, 150}, new int[]{252, 124, 220, 92, 244, 116, 212, 84, 254, 126, 222, 94, 246, 118, 214, 86}, new int[]{3, 131, 35, 163, 11, 139, 43, 171, 1, 129, 33, 161, 9, 137, 41, 169}, new int[]{195, 67, 227, 99, 203, 75, 235, 107, 193, 65, 225, 97, 201, 73, 233, 105}, new int[]{51, 179, 19, 147, 59, 187, 27, 155, 49, 177, 17, 145, 57, 185, 25, 153}, new int[]{243, 115, 211, 83, 251, 123, 219, 91, 241, 113, 209, 81, 249, 121, 217, 89}, new int[]{15, 143, 47, 175, 7, 135, 39, 167, 13, 141, 45, 173, 5, 133, 37, 165}, new int[]{207, 79, 239, 111, 199, 71, 231, 103, 205, 77, 237, 109, 197, 69, 229, 101}, new int[]{63, 191, 31, 159, 55, 183, 23, 151, 61, 189, 29, 157, 53, 181, 21, 149}, new int[]{254, 127, 223, 95, 247, 119, 215, 87, 253, 125, 221, 93, 245, 117, 213, 85}};

    public static class SquareArea {
        public int height;
        public int left;
        public int top;
        public int width;
        public int right = 0;
        public int bottom = 0;

        public SquareArea(int i3, int i4, int i5, int i6) {
            this.left = i3;
            this.top = i4;
            this.width = i5;
            this.height = i6;
        }
    }

    private static byte[] bayerMatrix(int[] iArr, int i3, int i4) {
        toGray(iArr, i3, i4);
        byte[] bArr = new byte[i3 * i4];
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            for (int i7 = 0; i7 < i4; i7++) {
                if ((iArr[i5] & 255) > m_16[i7 & 15][i6 & 15]) {
                    bArr[i5] = 0;
                } else {
                    bArr[i5] = 1;
                }
                i5++;
            }
        }
        return bArr;
    }

    private static int[] bestContract(int[] iArr, int i3, int i4) {
        toGray(iArr, i3, i4);
        long[] jArr = new long[i3 * i4];
        for (int i5 = 0; i5 < i4; i5++) {
            long j3 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = (i6 * i4) + i5;
                j3 += (long) iArr[i7];
                if (i5 == 0) {
                    jArr[i7] = j3;
                } else {
                    jArr[i7] = jArr[i7 - 1] + j3;
                }
            }
        }
        int i8 = i4 / 16;
        for (int i9 = 0; i9 < i4; i9++) {
            for (int i10 = 0; i10 < i3; i10++) {
                int i11 = (i10 * i4) + i9;
                int i12 = i9 - i8;
                int i13 = i9 + i8;
                int i14 = i10 - i8;
                int i15 = i10 + i8;
                if (i12 < 0) {
                    i12 = 0;
                }
                if (i13 >= i4) {
                    i13 = i4 - 1;
                }
                if (i14 < 0) {
                    i14 = 0;
                }
                if (i15 >= i3) {
                    i15 = i3 - 1;
                }
                int i16 = (i13 - i12) * (i15 - i14);
                int i17 = i15 * i4;
                int i18 = i14 * i4;
                if (iArr[i11] * i16 < ((long) ((((jArr[i17 + i13] - jArr[i13 + i18]) - jArr[i17 + i12]) + jArr[i18 + i12]) * 0.85f))) {
                    iArr[i11] = 0;
                } else {
                    iArr[i11] = 255;
                }
            }
        }
        return iArr;
    }

    private static Bitmap colorDodgeBlend(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmapCopy = bitmap.copy(config, true);
        Bitmap bitmapCopy2 = bitmap2.copy(config, false);
        IntBuffer intBufferAllocate = IntBuffer.allocate(bitmapCopy.getWidth() * bitmapCopy.getHeight());
        bitmapCopy.copyPixelsToBuffer(intBufferAllocate);
        intBufferAllocate.rewind();
        IntBuffer intBufferAllocate2 = IntBuffer.allocate(bitmapCopy2.getWidth() * bitmapCopy2.getHeight());
        bitmapCopy2.copyPixelsToBuffer(intBufferAllocate2);
        intBufferAllocate2.rewind();
        IntBuffer intBufferAllocate3 = IntBuffer.allocate(bitmapCopy.getWidth() * bitmapCopy.getHeight());
        intBufferAllocate3.rewind();
        while (intBufferAllocate3.position() < intBufferAllocate3.limit()) {
            int i3 = intBufferAllocate2.get();
            int i4 = intBufferAllocate.get();
            int iRed = Color.red(i3);
            int iGreen = Color.green(i3);
            int iBlue = Color.blue(i3);
            intBufferAllocate3.put(Color.argb(255, colordodge(iRed, Color.red(i4)), colordodge(iGreen, Color.green(i4)), colordodge(iBlue, Color.blue(i4))));
        }
        intBufferAllocate3.rewind();
        bitmapCopy.copyPixelsFromBuffer(intBufferAllocate3);
        bitmapCopy2.recycle();
        return bitmapCopy;
    }

    private static int colordodge(int i3, int i4) {
        float fMin = i4;
        float f3 = i3;
        if (fMin != 255.0f) {
            fMin = Math.min(255.0f, (((long) f3) << 8) / (255.0f - fMin));
        }
        return (int) fMin;
    }

    public static byte[] dithering(int[] iArr, int i3, int i4, int i5, Context context) {
        int[] iArrDitheringAtkinson;
        if (i5 == 0) {
            return format_K_threshold(iArr, i4, i3);
        }
        if (i5 == 9) {
            return format_K_threshold127(iArr, i4, i3);
        }
        switch (i5) {
            case 2:
                iArrDitheringAtkinson = ditheringAtkinson(iArr, i3, i4);
                break;
            case 3:
                iArrDitheringAtkinson = ditheringBurkes(iArr, i3, i4);
                break;
            case 4:
                iArrDitheringAtkinson = ditheringSiera16(iArr, i3, i4);
                break;
            case 5:
                iArrDitheringAtkinson = sketchImage(iArr, i3, i4, context);
                break;
            case 6:
                iArrDitheringAtkinson = bestContract(iArr, i3, i4);
                break;
            case 7:
                return bayerMatrix(iArr, i3, i4);
            default:
                iArrDitheringAtkinson = ditheringSF_real(iArr, i3, i4);
                break;
        }
        byte[] bArr = new byte[i4 * i3];
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            for (int i8 = 0; i8 < i4; i8++) {
                if (iArrDitheringAtkinson[i6] > 127) {
                    bArr[i6] = 0;
                } else {
                    bArr[i6] = 1;
                }
                i6++;
            }
        }
        return bArr;
    }

    private static int[] ditheringAtkinson(int[] iArr, int i3, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = iArr[i5];
                iArr[i5] = ((((((((i8 >> 16) & 255) >> 2) + (((i8 >> 8) & 255) >> 1)) + ((i8 & 255) >> 2)) - 255) * ((i8 >> 24) & 255)) / 255) + 255;
                i5++;
            }
        }
        int i9 = 0;
        for (int i10 = 0; i10 < i3 - 1; i10++) {
            int i11 = 1;
            while (i11 < i4 - 1) {
                int i12 = iArr[i9];
                int i13 = i12 > 127 ? 255 : 0;
                iArr[i9] = i13;
                int i14 = i12 - i13;
                int i15 = i9 + 1;
                int i16 = i14 / 8;
                iArr[i15] = iArr[i15] + i16;
                int i17 = i9 + 2;
                iArr[i17] = iArr[i17] + i16;
                int i18 = i9 + i4;
                int i19 = i18 - 1;
                iArr[i19] = iArr[i19] + i16;
                iArr[i18] = iArr[i18] + i16;
                int i20 = i18 + 1;
                iArr[i20] = iArr[i20] + i16;
                if (i10 < i3 - 2) {
                    int i21 = i18 + i4;
                    iArr[i21] = iArr[i21] + i16;
                }
                i11++;
                i9 = i15;
            }
        }
        return iArr;
    }

    private static int[] ditheringBurkes(int[] iArr, int i3, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = iArr[i5];
                iArr[i5] = ((((((((i8 >> 16) & 255) >> 2) + (((i8 >> 8) & 255) >> 1)) + ((i8 & 255) >> 2)) - 255) * ((i8 >> 24) & 255)) / 255) + 255;
                i5++;
            }
        }
        int i9 = 0;
        for (int i10 = 0; i10 < i3 - 2; i10++) {
            for (int i11 = 0; i11 < i4; i11++) {
                int i12 = iArr[i9];
                int i13 = i12 > 127 ? 255 : 0;
                iArr[i9] = i13;
                if (i11 > 1 && i11 < i4 - 1) {
                    int i14 = i12 - i13;
                    int i15 = i9 + 1;
                    int i16 = (i14 * 8) / 32;
                    iArr[i15] = iArr[i15] + i16;
                    int i17 = i9 + 2;
                    int i18 = (i14 * 4) / 32;
                    iArr[i17] = iArr[i17] + i18;
                    int i19 = i9 + i4;
                    int i20 = i19 - 2;
                    iArr[i20] = iArr[i20] + ((i14 * 2) / 32);
                    int i21 = i19 - 1;
                    iArr[i21] = iArr[i21] + i18;
                    iArr[i19] = iArr[i19] + i16;
                    int i22 = i19 + 1;
                    iArr[i22] = iArr[i22] + i18;
                    int i23 = i19 + 2;
                    iArr[i23] = iArr[i23] + ((i14 * 3) / 32);
                }
                i9++;
            }
        }
        return iArr;
    }

    private static int[] ditheringSF_real(int[] iArr, int i3, int i4) {
        toGray(iArr, i3, i4);
        int i5 = 0;
        for (int i6 = 0; i6 < i3 - 1; i6++) {
            for (int i7 = 0; i7 < i4 - 1; i7++) {
                int i8 = iArr[i5];
                int i9 = i8 > 127 ? 255 : 0;
                iArr[i5] = i9;
                if (i7 > 0) {
                    int i10 = i8 - i9;
                    int i11 = i5 + 1;
                    iArr[i11] = iArr[i11] + ((i10 * 7) / 16);
                    int i12 = i5 + i4;
                    int i13 = i12 - 1;
                    iArr[i13] = iArr[i13] + ((i10 * 3) / 16);
                    iArr[i12] = iArr[i12] + ((i10 * 5) / 16);
                    int i14 = i12 + 1;
                    iArr[i14] = iArr[i14] + (i10 / 16);
                }
                i5++;
            }
        }
        return iArr;
    }

    private static int[] ditheringSiera16(int[] iArr, int i3, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = iArr[i5];
                iArr[i5] = ((((((((i8 >> 16) & 255) >> 2) + (((i8 >> 8) & 255) >> 1)) + ((i8 & 255) >> 2)) - 255) * ((i8 >> 24) & 255)) / 255) + 255;
                i5++;
            }
        }
        int i9 = 0;
        for (int i10 = 0; i10 < i3 - 2; i10++) {
            for (int i11 = 0; i11 < i4; i11++) {
                int i12 = iArr[i9];
                int i13 = i12 > 127 ? 255 : 0;
                iArr[i9] = i13;
                if (i11 > 1 && i11 < i4 - 1) {
                    int i14 = i12 - i13;
                    int i15 = i9 + 1;
                    iArr[i15] = iArr[i15] + ((i14 * 4) / 16);
                    int i16 = i9 + 2;
                    int i17 = (i14 * 2) / 16;
                    iArr[i16] = iArr[i16] + i17;
                    int i18 = i9 + i4;
                    int i19 = i18 - 2;
                    int i20 = i14 / 16;
                    iArr[i19] = iArr[i19] + i20;
                    int i21 = i18 - 1;
                    iArr[i21] = iArr[i21] + i17;
                    iArr[i18] = iArr[i18] + ((i14 * 3) / 16);
                    int i22 = i18 + 1;
                    iArr[i22] = iArr[i22] + i17;
                    int i23 = i18 + 2;
                    iArr[i23] = iArr[i23] + i20;
                }
                i9++;
            }
        }
        return iArr;
    }

    public static byte[] eachLinePixForStar(byte[] bArr, int i3) {
        int length = bArr.length / i3;
        int i4 = i3 / 8;
        int i5 = i4 + 9;
        byte[] bArr2 = new byte[i5 * length];
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 * i5;
            bArr2[i8] = 27;
            bArr2[i8 + 1] = 29;
            bArr2[i8 + 2] = 83;
            bArr2[i8 + 3] = 1;
            bArr2[i8 + 4] = (byte) (i4 % 256);
            bArr2[i8 + 5] = (byte) (i4 / 256);
            bArr2[i8 + 6] = 1;
            bArr2[i8 + 7] = 0;
            bArr2[i8 + 8] = 0;
            for (int i9 = 0; i9 < i4; i9++) {
                bArr2[i8 + 9 + i9] = (byte) (f11227p0[bArr[i6]] + f11228p1[bArr[i6 + 1]] + f11229p2[bArr[i6 + 2]] + p3[bArr[i6 + 3]] + p4[bArr[i6 + 4]] + p5[bArr[i6 + 5]] + p6[bArr[i6 + 6]] + bArr[i6 + 7]);
                i6 += 8;
            }
        }
        return bArr2;
    }

    public static SquareArea findFrame(Bitmap bitmap) {
        int i3;
        int i4;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width];
        int[] iArr2 = new int[width];
        int i5 = -1;
        Arrays.fill(iArr, -1);
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i3 = height - 1;
            if (i7 > i3) {
                i7 = -1;
                break;
            }
            bitmap.getPixels(iArr2, 0, width, 0, i7, width, 1);
            if (!Arrays.equals(iArr2, iArr)) {
                break;
            }
            i7++;
        }
        if (i7 == -1) {
            return new SquareArea(0, 0, 0, 0);
        }
        int i8 = i3;
        while (true) {
            if (i8 < 0) {
                i8 = -1;
                break;
            }
            bitmap.getPixels(iArr2, 0, width, 0, i8, width, 1);
            if (!Arrays.equals(iArr2, iArr)) {
                break;
            }
            i8--;
        }
        int[] iArr3 = new int[height];
        int[] iArr4 = new int[height];
        Arrays.fill(iArr3, -1);
        while (true) {
            i4 = width - 1;
            if (i6 > i4) {
                i6 = -1;
                break;
            }
            bitmap.getPixels(iArr4, 0, 1, i6, 0, 1, height);
            if (!Arrays.equals(iArr4, iArr3)) {
                break;
            }
            i6++;
        }
        for (int i9 = i4; i9 >= 0; i9--) {
            bitmap.getPixels(iArr4, 0, 1, i9, 0, 1, height);
            if (!Arrays.equals(iArr4, iArr3)) {
                i5 = i9;
                break;
            }
        }
        SquareArea squareArea = new SquareArea(i6, i7, (i5 - i6) + 1, (i8 - i7) + 1);
        squareArea.right = i4 - i5;
        squareArea.bottom = i3 - i8;
        return squareArea;
    }

    public static byte[] format_K_threshold(int[] iArr, int i3, int i4) {
        byte[] bArr = new byte[i3 * i4];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            for (int i8 = 0; i8 < i3; i8++) {
                i5 += iArr[i6] & 255;
                i6++;
            }
        }
        int i9 = (i5 / i4) / i3;
        if (i9 > 254) {
            i9 = 254;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < i4; i11++) {
            for (int i12 = 0; i12 < i3; i12++) {
                if ((iArr[i10] & 255) > i9) {
                    bArr[i10] = 0;
                } else {
                    bArr[i10] = 1;
                }
                i10++;
            }
        }
        return bArr;
    }

    public static byte[] format_K_threshold127(int[] iArr, int i3, int i4) {
        byte[] bArr = new byte[i3 * i4];
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            for (int i7 = 0; i7 < i3; i7++) {
                if ((iArr[i5] & 255) > 127) {
                    bArr[i5] = 0;
                } else {
                    bArr[i5] = 1;
                }
                i5++;
            }
        }
        return bArr;
    }

    public static byte[] graphicsFormat(byte[] bArr, int i3, int i4, int i5) throws Exception {
        if ((i4 / 8) * 8 != i4) {
            throw new Exception("height not multiple 8");
        }
        if ((i4 / i5) * i5 != i4) {
            throw new Exception("height not multiple bundleHeightInBytes");
        }
        byte[] bArr2 = new byte[(i4 * i3) / 8];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i3; i9++) {
            for (int i10 = 0; i10 < i4; i10++) {
                i7 = (i7 * 2) + bArr[(i10 * i3) + i9];
                i6++;
                if (i6 > 7) {
                    bArr2[i8] = (byte) i7;
                    i8++;
                    i6 = 0;
                    i7 = 0;
                }
            }
        }
        return bArr2;
    }

    public static Bitmap messageBmp(String str, int i3) {
        return AbstractDriver.drawText(str, new AttributesString(), new FictivePrinterProfile(i3, 0, 203, 0));
    }

    public static Bitmap myRenderPdfPage(Context context, PdfRenderer.Page page, AttributesPdf attributesPdf, AttributesImage attributesImage, int i3, int i4, int i5, PosDriverInterface posDriverInterface) {
        double d3;
        double d4;
        int width = page.getWidth();
        int height = page.getHeight();
        if (width < 108 || height < 108) {
            if (posDriverInterface != null) {
                return null;
            }
            return messageBmp("page is small (" + width + "x" + height + ")", i3);
        }
        int rotate = attributesPdf.getRotate();
        SquareArea squareArea = new SquareArea(0, 0, width, height);
        if (attributesPdf.isClearHeaderAndFooter()) {
            if (rotate == 0) {
                squareArea.top = 35;
                squareArea.bottom = 35;
                squareArea.height = height - 72;
            } else {
                squareArea.left = 35;
                squareArea.width = width - 72;
                squareArea.right = 35;
            }
        }
        if (attributesPdf.isCutFrame()) {
            int cutFrameVal = attributesPdf.getCutFrameVal();
            squareArea.top = cutFrameVal;
            squareArea.bottom = cutFrameVal;
            int i6 = cutFrameVal * 2;
            squareArea.height = height - i6;
            squareArea.left = cutFrameVal;
            squareArea.right = cutFrameVal;
            squareArea.width = width - i6;
        }
        if (page.getIndex() == 0 && attributesPdf.isCutTop()) {
            squareArea.height = (squareArea.height + squareArea.top) - attributesPdf.getCutTopVal();
            squareArea.top = attributesPdf.getCutTopVal();
        }
        if (attributesPdf.getWidthTruncateMode() == 1) {
            if (rotate == 0) {
                squareArea.left = 34;
                squareArea.right = 34;
                squareArea.width = width - 68;
                if (!attributesPdf.isRoll()) {
                    squareArea.top = 35;
                    squareArea.bottom = 36;
                    squareArea.height = height - 72;
                }
            } else {
                squareArea.top = 35;
                squareArea.bottom = 36;
                squareArea.height = height - 72;
                if (!attributesPdf.isRoll()) {
                    squareArea.left = 35;
                    squareArea.right = 36;
                    squareArea.width = width - 72;
                }
            }
        }
        if (attributesPdf.isRoll() || attributesPdf.getWidthTruncateMode() == 2) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(page.getWidth(), page.getHeight(), Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setHasAlpha(false);
            bitmapCreateBitmap.eraseColor(-1);
            page.render(bitmapCreateBitmap, null, null, 2);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(-1);
            paint.setAntiAlias(true);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawRect(new Rect(0, 0, squareArea.left, height), paint);
            canvas.drawRect(new Rect(width - squareArea.right, 0, width, height), paint);
            canvas.drawRect(new Rect(0, 0, width, squareArea.top), paint);
            canvas.drawRect(new Rect(0, height - squareArea.bottom, width, height), paint);
            SquareArea squareAreaFindFrame = findFrame(toLight(bitmapCreateBitmap));
            if (squareAreaFindFrame.width == 0) {
                return null;
            }
            if (attributesPdf.isRoll()) {
                if (rotate == 0) {
                    squareArea.top = squareAreaFindFrame.top;
                    squareArea.height = squareAreaFindFrame.height;
                    squareArea.bottom = squareAreaFindFrame.bottom;
                } else {
                    squareArea.left = squareAreaFindFrame.left;
                    squareArea.width = squareAreaFindFrame.width;
                    squareArea.right = squareAreaFindFrame.right;
                }
            }
            if (attributesPdf.getWidthTruncateMode() == 2) {
                if (rotate == 0) {
                    squareArea.left = squareAreaFindFrame.left;
                    squareArea.width = squareAreaFindFrame.width;
                    squareArea.right = squareAreaFindFrame.right;
                } else {
                    squareArea.top = squareAreaFindFrame.top;
                    squareArea.height = squareAreaFindFrame.height;
                    squareArea.bottom = squareAreaFindFrame.bottom;
                }
            }
        }
        if (rotate == 0) {
            double d5 = i3;
            Double.isNaN(d5);
            d3 = d5 * 1.0d;
            d4 = squareArea.width;
            Double.isNaN(d4);
        } else {
            double d6 = i3;
            Double.isNaN(d6);
            d3 = d6 * 1.0d;
            d4 = squareArea.height;
            Double.isNaN(d4);
        }
        double d7 = d3 / d4;
        double d8 = squareArea.left;
        Double.isNaN(d8);
        int i7 = (int) (d8 * d7);
        squareArea.left = i7;
        if (i7 > 0) {
            squareArea.left = i7 + 1;
        }
        double d9 = squareArea.width;
        Double.isNaN(d9);
        int i8 = (int) (d9 * d7);
        squareArea.width = i8;
        double d10 = squareArea.right;
        Double.isNaN(d10);
        int i9 = (int) (d10 * d7);
        squareArea.right = i9;
        double d11 = squareArea.top;
        Double.isNaN(d11);
        int i10 = (int) (d11 * d7);
        squareArea.top = i10;
        double d12 = squareArea.height;
        Double.isNaN(d12);
        int i11 = (int) (d12 * d7);
        squareArea.height = i11;
        double d13 = squareArea.bottom;
        Double.isNaN(d13);
        int i12 = (int) (d7 * d13);
        squareArea.bottom = i12;
        int i13 = i10 + i11 + i12;
        int i14 = squareArea.left + i8 + i9;
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i14, i13, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap2.setHasAlpha(false);
        bitmapCreateBitmap2.eraseColor(-1);
        page.render(bitmapCreateBitmap2, null, null, 2);
        int i15 = squareArea.width;
        int i16 = squareArea.height;
        int[] iArr = new int[((i16 + 1) * i15) + 1];
        Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(bitmapCreateBitmap2, squareArea.left, squareArea.top, i15, i16);
        if (posDriverInterface != null) {
            if (rotate != 0) {
                Matrix matrix = new Matrix();
                matrix.postRotate(rotate);
                bitmapCreateBitmap3 = Bitmap.createBitmap(bitmapCreateBitmap2, 0, 0, i14, i13, matrix, true);
            }
            posDriverInterface.printImage(bitmapCreateBitmap3, attributesImage);
            return bitmapCreateBitmap3;
        }
        bitmapCreateBitmap3.getPixels(iArr, 0, bitmapCreateBitmap3.getWidth(), 0, 0, bitmapCreateBitmap3.getWidth(), bitmapCreateBitmap3.getHeight());
        int graphicFilter = attributesImage.getGraphicFilter();
        if (graphicFilter != 8) {
            byte[] bArrDithering = dithering(iArr, squareArea.height, squareArea.width, graphicFilter, context);
            int i17 = 0;
            for (int i18 = 0; i18 < squareArea.height; i18++) {
                for (int i19 = 0; i19 < squareArea.width; i19++) {
                    if (bArrDithering[i17] == 0) {
                        iArr[i17] = i4;
                    } else {
                        iArr[i17] = i5;
                    }
                    i17++;
                }
            }
        }
        Bitmap dark = toDark(bitmapCreateBitmap2, i4);
        int i20 = squareArea.width;
        dark.setPixels(iArr, 0, i20, squareArea.left, squareArea.top, i20, squareArea.height);
        if (rotate != 0) {
            Matrix matrix2 = new Matrix();
            matrix2.postRotate(rotate);
            dark = Bitmap.createBitmap(dark, 0, 0, i14, i13, matrix2, true);
        }
        dark.setDensity(216);
        return dark;
    }

    public static byte[] rasterFormat(byte[] bArr, int i3, int i4) throws Exception {
        if ((i3 / 8) * 8 != i3) {
            throw new Exception("width not multiple 8");
        }
        byte[] bArr2 = new byte[(i4 * i3) / 8];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            for (int i8 = 0; i8 < i3; i8 += 8) {
                int i9 = i6 + i8;
                bArr2[i5] = (byte) (f11227p0[bArr[i9]] + f11228p1[bArr[i9 + 1]] + f11229p2[bArr[i9 + 2]] + p3[bArr[i9 + 3]] + p4[bArr[i9 + 4]] + p5[bArr[i9 + 5]] + p6[bArr[i9 + 6]] + bArr[i9 + 7]);
                i5++;
            }
            i6 += i3;
        }
        return bArr2;
    }

    public static Bitmap resizeImage(Bitmap bitmap, int i3, int i4) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i3 / width, i4 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = bitmap.getConfig();
        int i3 = width * height;
        int[] iArr = new int[i3];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        bitmap.recycle();
        int[] iArr2 = new int[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < height; i5++) {
            int i6 = (height - i5) - 1;
            for (int i7 = 0; i7 < width; i7++) {
                iArr2[i6] = iArr[i4];
                i6 += height;
                i4++;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(height, width, config);
        bitmapCreateBitmap.setPixels(iArr2, 0, height, 0, 0, height, width);
        return bitmapCreateBitmap;
    }

    private static int[] sketchImage(int[] iArr, int i3, int i4, Context context) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i4, i3, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, i4, 0, 0, i4, i3);
        Bitmap grayscale = toGrayscale(bitmapCreateBitmap, 1);
        Bitmap bitmapColorDodgeBlend = colorDodgeBlend(toBlur(toInverted(grayscale, 100), context), grayscale);
        bitmapColorDodgeBlend.getPixels(iArr, 0, bitmapColorDodgeBlend.getWidth(), 0, 0, bitmapColorDodgeBlend.getWidth(), bitmapColorDodgeBlend.getHeight());
        toGray(iArr, i3, i4);
        long j3 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            for (int i7 = 0; i7 < i4; i7++) {
                j3 += (long) (iArr[i5] & 255);
                i5++;
            }
        }
        int i8 = (int) ((j3 / ((long) i3)) / ((long) i4));
        int i9 = 0;
        for (int i10 = 0; i10 < i3; i10++) {
            for (int i11 = 0; i11 < i4; i11++) {
                if (iArr[i9] < i8) {
                    iArr[i9] = 0;
                } else {
                    iArr[i9] = 255;
                }
                i9++;
            }
        }
        return iArr;
    }

    private static Bitmap toBlur(Bitmap bitmap, Context context) {
        try {
            RenderScript renderScriptCreate = RenderScript.create(context);
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            scriptIntrinsicBlurCreate.setRadius(2.5f);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
            renderScriptCreate.destroy();
            allocationCreateFromBitmap2.destroy();
            allocationCreateFromBitmap.destroy();
            scriptIntrinsicBlurCreate.destroy();
            return bitmapCreateBitmap;
        } catch (Exception e3) {
            e3.printStackTrace();
            return bitmap;
        }
    }

    public static Bitmap toDark(Bitmap bitmap, int i3) {
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int i4 = width * height;
        int[] iArr = new int[i4];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i5 = i3 != -1 ? 2 : 1;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = iArr[i6];
            iArr[i6] = ((i7 & 255) >> i5) | ((((i7 >> 16) & 255) >> i5) << 16) | (-16777216) | ((((i7 >> 8) & 255) >> i5) << 8);
        }
        bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmapCreateBitmap;
    }

    private static void toGray(int[] iArr, int i3, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = iArr[i5];
                int i9 = (i8 >> 24) & 255;
                int i10 = (((i8 >> 16) & 255) >> 2) + (((i8 >> 8) & 255) >> 1) + ((i8 & 255) >> 2);
                if (i10 > 249) {
                    i10 = 255;
                }
                iArr[i5] = ((((i10 - 255) * i9) / 255) + 255) & 255;
                i5++;
            }
        }
    }

    public static Bitmap toGrayscale(Bitmap bitmap) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColor(-1);
        canvas.drawRect(0.0f, 0.0f, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), paint);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    private static Bitmap toInverted(Bitmap bitmap, float f3) {
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, f3 / 100.0f, 0.0f}));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    public static Bitmap toLight(Bitmap bitmap) {
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int i3 = width * height;
        int[] iArr = new int[i3];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            int i6 = 255;
            int i7 = (i5 >> 16) & 255;
            int i8 = (i5 >> 8) & 255;
            int i9 = i5 & 255;
            if (i7 + i8 + i9 > 720) {
                i9 = 255;
                i8 = 255;
            } else {
                i6 = i7;
            }
            iArr[i4] = i9 | (-16777216) | (i6 << 16) | (i8 << 8);
        }
        bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmapCreateBitmap;
    }

    private static Bitmap toGrayscale(Bitmap bitmap, float f3) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setHasAlpha(false);
        bitmapCreateBitmap.eraseColor(-1);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(f3 / 100.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }
}
