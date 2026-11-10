package rawbt.sdk.emulator.escpos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.Objects;
import rawbt.sdk.emulator.R;

/* JADX INFO: loaded from: classes.dex */
class BitmapFont {
    private static Bitmap bitmap = null;
    private static Bitmap bitmap_ascii = null;
    private static Bitmap bitmap_ascii_bold = null;
    private static Bitmap bitmap_b = null;
    private static String fontCp = "unknown";
    private static int fontSize = -1;

    BitmapFont() {
    }

    static int[] getPixels(int i3, EscPosEmulator escPosEmulator, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        if (i4 != fontSize) {
            Bitmap bitmap2 = bitmap_ascii;
            if (bitmap2 != null) {
                bitmap2.recycle();
                bitmap_ascii = null;
            }
            Bitmap bitmap3 = bitmap_ascii_bold;
            if (bitmap3 != null) {
                bitmap3.recycle();
                bitmap_ascii_bold = null;
            }
            if (i4 == 0) {
                Context context = escPosEmulator.getContext();
                Objects.requireNonNull(context);
                bitmap_ascii = BitmapFactory.decodeResource(context.getResources(), R.drawable.ascii_ar);
                Context context2 = escPosEmulator.getContext();
                Objects.requireNonNull(context2);
                bitmap_ascii_bold = BitmapFactory.decodeResource(context2.getResources(), R.drawable.ascii_ab);
            } else {
                Context context3 = escPosEmulator.getContext();
                Objects.requireNonNull(context3);
                bitmap_ascii = BitmapFactory.decodeResource(context3.getResources(), R.drawable.ascii_br);
                Context context4 = escPosEmulator.getContext();
                Objects.requireNonNull(context4);
                bitmap_ascii_bold = BitmapFactory.decodeResource(context4.getResources(), R.drawable.ascii_bb);
            }
        }
        if (bitmap == null || !escPosEmulator.codePageName.equals(fontCp) || i4 != fontSize) {
            String str = escPosEmulator.codePageName;
            str.hashCode();
            switch (str) {
                case "cp1251":
                    if (i4 != 0) {
                        i5 = R.drawable.cp1251_bb;
                        i6 = R.drawable.cp1251_br;
                        break;
                    } else {
                        i5 = R.drawable.cp1251_ab;
                        i6 = R.drawable.cp1251_ar;
                        break;
                    }
                    break;
                case "cp1252":
                    if (i4 != 0) {
                        i5 = R.drawable.cp1252_bb;
                        i6 = R.drawable.cp1252_br;
                        break;
                    } else {
                        i5 = R.drawable.cp1252_ab;
                        i6 = R.drawable.cp1252_ar;
                        break;
                    }
                    break;
                case "cp1253":
                    if (i4 != 0) {
                        i5 = R.drawable.cp1253_bb;
                        i6 = R.drawable.cp1253_br;
                        break;
                    } else {
                        i5 = R.drawable.cp1253_ab;
                        i6 = R.drawable.cp1253_ar;
                        break;
                    }
                    break;
                case "cp1257":
                    if (i4 != 0) {
                        i5 = R.drawable.cp1257_bb;
                        i6 = R.drawable.cp1257_br;
                        break;
                    } else {
                        i5 = R.drawable.cp1257_ab;
                        i6 = R.drawable.cp1257_ar;
                        break;
                    }
                    break;
                case "cp737":
                    if (i4 != 0) {
                        i5 = R.drawable.cp737_bb;
                        i6 = R.drawable.cp737_br;
                        break;
                    } else {
                        i5 = R.drawable.cp737_ab;
                        i6 = R.drawable.cp737_ar;
                        break;
                    }
                    break;
                case "cp775":
                    if (i4 != 0) {
                        i5 = R.drawable.cp775_bb;
                        i6 = R.drawable.cp775_br;
                        break;
                    } else {
                        i5 = R.drawable.cp775_ab;
                        i6 = R.drawable.cp775_ar;
                        break;
                    }
                    break;
                case "cp850":
                    if (i4 != 0) {
                        i5 = R.drawable.cp850_bb;
                        i6 = R.drawable.cp850_br;
                        break;
                    } else {
                        i5 = R.drawable.cp850_ab;
                        i6 = R.drawable.cp850_ar;
                        break;
                    }
                    break;
                case "cp852":
                    if (i4 != 0) {
                        i5 = R.drawable.cp852_bb;
                        i6 = R.drawable.cp852_br;
                        break;
                    } else {
                        i5 = R.drawable.cp852_ab;
                        i6 = R.drawable.cp852_ar;
                        break;
                    }
                    break;
                case "cp858":
                    if (i4 != 0) {
                        i5 = R.drawable.cp858_bb;
                        i6 = R.drawable.cp858_br;
                        break;
                    } else {
                        i5 = R.drawable.cp858_ab;
                        i6 = R.drawable.cp858_ar;
                        break;
                    }
                    break;
                case "cp860":
                    if (i4 != 0) {
                        i5 = R.drawable.cp860_bb;
                        i6 = R.drawable.cp860_br;
                        break;
                    } else {
                        i5 = R.drawable.cp860_ab;
                        i6 = R.drawable.cp860_ar;
                        break;
                    }
                    break;
                case "cp863":
                    if (i4 != 0) {
                        i5 = R.drawable.cp863_bb;
                        i6 = R.drawable.cp863_br;
                        break;
                    } else {
                        i5 = R.drawable.cp863_ab;
                        i6 = R.drawable.cp863_ar;
                        break;
                    }
                    break;
                case "cp865":
                    if (i4 != 0) {
                        i5 = R.drawable.cp865_bb;
                        i6 = R.drawable.cp865_br;
                        break;
                    } else {
                        i5 = R.drawable.cp865_ab;
                        i6 = R.drawable.cp865_ar;
                        break;
                    }
                    break;
                case "cp866":
                    if (i4 != 0) {
                        i5 = R.drawable.cp866_bb;
                        i6 = R.drawable.cp866_br;
                        break;
                    } else {
                        i5 = R.drawable.cp866_ab;
                        i6 = R.drawable.cp866_ar;
                        break;
                    }
                    break;
                default:
                    if (i4 != 0) {
                        i5 = R.drawable.cp437_bb;
                        i6 = R.drawable.cp437_br;
                        break;
                    } else {
                        i5 = R.drawable.cp437_ab;
                        i6 = R.drawable.cp437_ar;
                        break;
                    }
                    break;
            }
            Bitmap bitmap4 = bitmap;
            if (bitmap4 != null) {
                bitmap4.recycle();
                bitmap = null;
            }
            Bitmap bitmap5 = bitmap_b;
            if (bitmap5 != null) {
                bitmap5.recycle();
                bitmap_b = null;
            }
            Context context5 = escPosEmulator.getContext();
            Objects.requireNonNull(context5);
            bitmap = BitmapFactory.decodeResource(context5.getResources(), i6);
            Context context6 = escPosEmulator.getContext();
            Objects.requireNonNull(context6);
            bitmap_b = BitmapFactory.decodeResource(context6.getResources(), i5);
        }
        fontCp = escPosEmulator.codePageName;
        fontSize = i4;
        if (i4 == 0) {
            i7 = 12;
            i8 = 32;
        } else {
            i7 = 9;
            i8 = 22;
        }
        int[] iArr = new int[i8 * i7];
        if (i3 < 128) {
            if (escPosEmulator.bold) {
                bitmap_ascii_bold.getPixels(iArr, 0, i7, i3 * i7, 0, i7, i8);
            } else {
                bitmap_ascii.getPixels(iArr, 0, i7, i3 * i7, 0, i7, i8);
            }
        } else if (escPosEmulator.bold) {
            bitmap_b.getPixels(iArr, 0, i7, (i3 - 128) * i7, 0, i7, i8);
        } else {
            bitmap.getPixels(iArr, 0, i7, (i3 - 128) * i7, 0, i7, i8);
        }
        return iArr;
    }
}
