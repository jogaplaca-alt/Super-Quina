package N;

import android.content.res.AssetManager;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final c[] f1303D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final c[] f1304E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private static final c[] f1305F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static final c[] f1306G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static final c[] f1307H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private static final c f1308I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final c[] f1309J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private static final c[] f1310K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private static final c[] f1311L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private static final c[] f1312M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    static final c[][] f1313N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private static final c[] f1314O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private static final c f1315P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private static final c f1316Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private static final HashMap[] f1317R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private static final HashMap[] f1318S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private static final HashSet f1319T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private static final HashMap f1320U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    static final Charset f1321V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    static final byte[] f1322W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    private static final Pattern f1323X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    private static final Pattern f1324Y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static SimpleDateFormat f1333z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager.AssetInputStream f1335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap[] f1337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set f1338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ByteOrder f1339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1341h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1342i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[] f1343j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1344k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1345l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1346m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f1347n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f1348o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f1349p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f1350q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final List f1325r = Arrays.asList(1, 6, 3, 8);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final List f1326s = Arrays.asList(2, 7, 4, 5);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int[] f1327t = {8, 8, 8};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int[] f1328u = {4};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int[] f1329v = {8};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final byte[] f1330w = {-1, -40, -1};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final byte[] f1331x = {79, 76, 89, 77, 80, 0};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final byte[] f1332y = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    static final String[] f1300A = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    static final int[] f1301B = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    static final byte[] f1302C = {65, 83, 67, 73, 73, 0, 0, 0};

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f1359c;

        b(int i3, int i4, byte[] bArr) {
            this.f1357a = i3;
            this.f1358b = i4;
            this.f1359c = bArr;
        }

        public static b a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.f1321V);
            return new b(2, bytes.length, bytes);
        }

        public static b b(long j3, ByteOrder byteOrder) {
            return c(new long[]{j3}, byteOrder);
        }

        public static b c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.f1301B[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j3 : jArr) {
                byteBufferWrap.putInt((int) j3);
            }
            return new b(4, jArr.length, byteBufferWrap.array());
        }

        public static b d(d dVar, ByteOrder byteOrder) {
            return e(new d[]{dVar}, byteOrder);
        }

        public static b e(d[] dVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.f1301B[5] * dVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (d dVar : dVarArr) {
                byteBufferWrap.putInt((int) dVar.f1364a);
                byteBufferWrap.putInt((int) dVar.f1365b);
            }
            return new b(5, dVarArr.length, byteBufferWrap.array());
        }

        public static b f(int i3, ByteOrder byteOrder) {
            return g(new int[]{i3}, byteOrder);
        }

        public static b g(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.f1301B[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i3 : iArr) {
                byteBufferWrap.putShort((short) i3);
            }
            return new b(3, iArr.length, byteBufferWrap.array());
        }

        public double h(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objK instanceof String) {
                return Double.parseDouble((String) objK);
            }
            if (objK instanceof long[]) {
                long[] jArr = (long[]) objK;
                if (jArr.length == 1) {
                    return jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objK instanceof int[]) {
                int[] iArr = (int[]) objK;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objK instanceof double[]) {
                double[] dArr = (double[]) objK;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objK instanceof d[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            d[] dVarArr = (d[]) objK;
            if (dVarArr.length == 1) {
                return dVarArr[0].a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int i(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objK instanceof String) {
                return Integer.parseInt((String) objK);
            }
            if (objK instanceof long[]) {
                long[] jArr = (long[]) objK;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objK instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objK;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String j(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                return null;
            }
            if (objK instanceof String) {
                return (String) objK;
            }
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            if (objK instanceof long[]) {
                long[] jArr = (long[]) objK;
                while (i3 < jArr.length) {
                    sb.append(jArr[i3]);
                    i3++;
                    if (i3 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objK instanceof int[]) {
                int[] iArr = (int[]) objK;
                while (i3 < iArr.length) {
                    sb.append(iArr[i3]);
                    i3++;
                    if (i3 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objK instanceof double[]) {
                double[] dArr = (double[]) objK;
                while (i3 < dArr.length) {
                    sb.append(dArr[i3]);
                    i3++;
                    if (i3 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(objK instanceof d[])) {
                return null;
            }
            d[] dVarArr = (d[]) objK;
            while (i3 < dVarArr.length) {
                sb.append(dVarArr[i3].f1364a);
                sb.append('/');
                sb.append(dVarArr[i3].f1365b);
                i3++;
                if (i3 != dVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Code duplicated, block: B:164:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Not initialized variable reg: 5, insn: 0x0030: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:49), block:B:17:0x0030 */
        Object k(ByteOrder byteOrder) throws Throwable {
            C0021a c0021a;
            InputStream inputStream;
            byte b3;
            byte b4;
            int length = 0;
            InputStream inputStream2 = null;
            try {
                try {
                    c0021a = new C0021a(this.f1359c);
                    try {
                        c0021a.G(byteOrder);
                        switch (this.f1357a) {
                            case 1:
                            case 6:
                                byte[] bArr = this.f1359c;
                                if (bArr.length != 1 || (b3 = bArr[0]) < 0 || b3 > 1) {
                                    String str = new String(bArr, a.f1321V);
                                    try {
                                        c0021a.close();
                                        break;
                                    } catch (IOException e3) {
                                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e3);
                                    }
                                    return str;
                                }
                                String str2 = new String(new char[]{(char) (b3 + 48)});
                                try {
                                    c0021a.close();
                                    break;
                                } catch (IOException e4) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e4);
                                }
                                return str2;
                            case 2:
                            case 7:
                                if (this.f1358b >= a.f1302C.length) {
                                    int i3 = 0;
                                    while (true) {
                                        byte[] bArr2 = a.f1302C;
                                        if (i3 >= bArr2.length) {
                                            length = bArr2.length;
                                        } else if (this.f1359c[i3] == bArr2[i3]) {
                                            i3++;
                                        }
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                while (length < this.f1358b && (b4 = this.f1359c[length]) != 0) {
                                    if (b4 >= 32) {
                                        sb.append((char) b4);
                                    } else {
                                        sb.append('?');
                                    }
                                    length++;
                                }
                                String string = sb.toString();
                                try {
                                    c0021a.close();
                                    break;
                                } catch (IOException e5) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                                }
                                return string;
                            case 3:
                                int[] iArr = new int[this.f1358b];
                                while (length < this.f1358b) {
                                    iArr[length] = c0021a.readUnsignedShort();
                                    length++;
                                }
                                try {
                                    c0021a.close();
                                    break;
                                } catch (IOException e6) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                                }
                                return iArr;
                            case 4:
                                long[] jArr = new long[this.f1358b];
                                while (length < this.f1358b) {
                                    jArr[length] = c0021a.t();
                                    length++;
                                }
                                try {
                                    c0021a.close();
                                    break;
                                } catch (IOException e7) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e7);
                                }
                                return jArr;
                            case 5:
                                d[] dVarArr = new d[this.f1358b];
                                while (length < this.f1358b) {
                                    dVarArr[length] = new d(c0021a.t(), c0021a.t());
                                    length++;
                                }
                                try {
                                    c0021a.close();
                                    break;
                                } catch (IOException e8) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e8);
                                }
                                return dVarArr;
                            case 8:
                                int[] iArr2 = new int[this.f1358b];
                                while (length < this.f1358b) {
                                    iArr2[length] = c0021a.readShort();
                                    length++;
                                }
                                try {
                                    c0021a.close();
                                    break;
                                } catch (IOException e9) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e9);
                                }
                                return iArr2;
                            case 9:
                                int[] iArr3 = new int[this.f1358b];
                                while (length < this.f1358b) {
                                    iArr3[length] = c0021a.readInt();
                                    length++;
                                }
                                try {
                                    c0021a.close();
                                    break;
                                } catch (IOException e10) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e10);
                                }
                                return iArr3;
                            case 10:
                                d[] dVarArr2 = new d[this.f1358b];
                                while (length < this.f1358b) {
                                    dVarArr2[length] = new d(c0021a.readInt(), c0021a.readInt());
                                    length++;
                                }
                                try {
                                    c0021a.close();
                                    break;
                                } catch (IOException e11) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                                }
                                return dVarArr2;
                            case 11:
                                double[] dArr = new double[this.f1358b];
                                while (length < this.f1358b) {
                                    dArr[length] = c0021a.readFloat();
                                    length++;
                                }
                                try {
                                    c0021a.close();
                                    break;
                                } catch (IOException e12) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                                }
                                return dArr;
                            case 12:
                                double[] dArr2 = new double[this.f1358b];
                                while (length < this.f1358b) {
                                    dArr2[length] = c0021a.readDouble();
                                    length++;
                                }
                                try {
                                    c0021a.close();
                                    break;
                                } catch (IOException e13) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e13);
                                }
                                return dArr2;
                            default:
                                try {
                                    c0021a.close();
                                    break;
                                } catch (IOException e14) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e14);
                                }
                                return null;
                        }
                    } catch (IOException e15) {
                        e = e15;
                        Log.w("ExifInterface", "IOException occurred during reading a value", e);
                        if (c0021a != null) {
                            try {
                                c0021a.close();
                            } catch (IOException e16) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e16);
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e17) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e17);
                        }
                    }
                    throw th;
                }
            } catch (IOException e18) {
                e = e18;
                c0021a = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                throw th;
            }
        }

        public String toString() {
            return "(" + a.f1300A[this.f1357a] + ", data length:" + this.f1359c.length + ")";
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f1364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1365b;

        d(long j3, long j4) {
            if (j4 == 0) {
                this.f1364a = 0L;
                this.f1365b = 1L;
            } else {
                this.f1364a = j3;
                this.f1365b = j4;
            }
        }

        public double a() {
            double d3 = this.f1364a;
            double d4 = this.f1365b;
            Double.isNaN(d3);
            Double.isNaN(d4);
            return d3 / d4;
        }

        public String toString() {
            return this.f1364a + "/" + this.f1365b;
        }
    }

    static {
        c[] cVarArr = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ImageWidth", 256, 3, 4), new c("ImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7)};
        f1303D = cVarArr;
        c[] cVarArr2 = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962, 3, 4), new c("PixelYDimension", 40963, 3, 4), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        f1304E = cVarArr2;
        c[] cVarArr3 = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
        f1305F = cVarArr3;
        c[] cVarArr4 = {new c("InteroperabilityIndex", 1, 2)};
        f1306G = cVarArr4;
        c[] cVarArr5 = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ThumbnailImageWidth", 256, 3, 4), new c("ThumbnailImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        f1307H = cVarArr5;
        f1308I = new c("StripOffsets", 273, 3);
        c[] cVarArr6 = {new c("ThumbnailImage", 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)};
        f1309J = cVarArr6;
        c[] cVarArr7 = {new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)};
        f1310K = cVarArr7;
        c[] cVarArr8 = {new c("AspectFrame", 4371, 3)};
        f1311L = cVarArr8;
        c[] cVarArr9 = {new c("ColorSpace", 55, 3)};
        f1312M = cVarArr9;
        c[][] cVarArr10 = {cVarArr, cVarArr2, cVarArr3, cVarArr4, cVarArr5, cVarArr, cVarArr6, cVarArr7, cVarArr8, cVarArr9};
        f1313N = cVarArr10;
        f1314O = new c[]{new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
        f1315P = new c("JPEGInterchangeFormat", 513, 4);
        f1316Q = new c("JPEGInterchangeFormatLength", 514, 4);
        f1317R = new HashMap[cVarArr10.length];
        f1318S = new HashMap[cVarArr10.length];
        f1319T = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f1320U = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        f1321V = charsetForName;
        f1322W = "Exif\u0000\u0000".getBytes(charsetForName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        f1333z = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i3 = 0;
        while (true) {
            c[][] cVarArr11 = f1313N;
            if (i3 >= cVarArr11.length) {
                HashMap map = f1320U;
                c[] cVarArr12 = f1314O;
                map.put(Integer.valueOf(cVarArr12[0].f1360a), 5);
                map.put(Integer.valueOf(cVarArr12[1].f1360a), 1);
                map.put(Integer.valueOf(cVarArr12[2].f1360a), 2);
                map.put(Integer.valueOf(cVarArr12[3].f1360a), 3);
                map.put(Integer.valueOf(cVarArr12[4].f1360a), 7);
                map.put(Integer.valueOf(cVarArr12[5].f1360a), 8);
                f1323X = Pattern.compile(".*[1-9].*");
                f1324Y = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
            f1317R[i3] = new HashMap();
            f1318S[i3] = new HashMap();
            for (c cVar : cVarArr11[i3]) {
                f1317R[i3].put(Integer.valueOf(cVar.f1360a), cVar);
                f1318S[i3].put(cVar.f1361b, cVar);
            }
            i3++;
        }
    }

    public a(InputStream inputStream) {
        c[][] cVarArr = f1313N;
        this.f1337d = new HashMap[cVarArr.length];
        this.f1338e = new HashSet(cVarArr.length);
        this.f1339f = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null");
        }
        this.f1334a = null;
        if (inputStream instanceof AssetManager.AssetInputStream) {
            this.f1335b = (AssetManager.AssetInputStream) inputStream;
        } else {
            this.f1335b = null;
        }
        t(inputStream);
    }

    private void A(int i3, int i4) throws Throwable {
        if (this.f1337d[i3].isEmpty() || this.f1337d[i4].isEmpty()) {
            return;
        }
        b bVar = (b) this.f1337d[i3].get("ImageLength");
        b bVar2 = (b) this.f1337d[i3].get("ImageWidth");
        b bVar3 = (b) this.f1337d[i4].get("ImageLength");
        b bVar4 = (b) this.f1337d[i4].get("ImageWidth");
        if (bVar == null || bVar2 == null || bVar3 == null || bVar4 == null) {
            return;
        }
        int i5 = bVar.i(this.f1339f);
        int i6 = bVar2.i(this.f1339f);
        int i7 = bVar3.i(this.f1339f);
        int i8 = bVar4.i(this.f1339f);
        if (i5 >= i7 || i6 >= i8) {
            return;
        }
        HashMap[] mapArr = this.f1337d;
        HashMap map = mapArr[i3];
        mapArr[i3] = mapArr[i4];
        mapArr[i4] = map;
    }

    private void B(C0021a c0021a, int i3) throws Throwable {
        b bVarF;
        b bVarF2;
        b bVar = (b) this.f1337d[i3].get("DefaultCropSize");
        b bVar2 = (b) this.f1337d[i3].get("SensorTopBorder");
        b bVar3 = (b) this.f1337d[i3].get("SensorLeftBorder");
        b bVar4 = (b) this.f1337d[i3].get("SensorBottomBorder");
        b bVar5 = (b) this.f1337d[i3].get("SensorRightBorder");
        if (bVar == null) {
            if (bVar2 == null || bVar3 == null || bVar4 == null || bVar5 == null) {
                y(c0021a, i3);
                return;
            }
            int i4 = bVar2.i(this.f1339f);
            int i5 = bVar4.i(this.f1339f);
            int i6 = bVar5.i(this.f1339f);
            int i7 = bVar3.i(this.f1339f);
            if (i5 <= i4 || i6 <= i7) {
                return;
            }
            b bVarF3 = b.f(i5 - i4, this.f1339f);
            b bVarF4 = b.f(i6 - i7, this.f1339f);
            this.f1337d[i3].put("ImageLength", bVarF3);
            this.f1337d[i3].put("ImageWidth", bVarF4);
            return;
        }
        if (bVar.f1357a == 5) {
            d[] dVarArr = (d[]) bVar.k(this.f1339f);
            if (dVarArr == null || dVarArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(dVarArr));
                return;
            }
            bVarF = b.d(dVarArr[0], this.f1339f);
            bVarF2 = b.d(dVarArr[1], this.f1339f);
        } else {
            int[] iArr = (int[]) bVar.k(this.f1339f);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            bVarF = b.f(iArr[0], this.f1339f);
            bVarF2 = b.f(iArr[1], this.f1339f);
        }
        this.f1337d[i3].put("ImageWidth", bVarF);
        this.f1337d[i3].put("ImageLength", bVarF2);
    }

    private void C(InputStream inputStream) throws Throwable {
        A(0, 5);
        A(0, 4);
        A(5, 4);
        b bVar = (b) this.f1337d[1].get("PixelXDimension");
        b bVar2 = (b) this.f1337d[1].get("PixelYDimension");
        if (bVar != null && bVar2 != null) {
            this.f1337d[0].put("ImageWidth", bVar);
            this.f1337d[0].put("ImageLength", bVar2);
        }
        if (this.f1337d[4].isEmpty() && s(this.f1337d[5])) {
            HashMap[] mapArr = this.f1337d;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (s(this.f1337d[4])) {
            return;
        }
        Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
    }

    private void a() {
        String strC = c("DateTimeOriginal");
        if (strC != null && c("DateTime") == null) {
            this.f1337d[0].put("DateTime", b.a(strC));
        }
        if (c("ImageWidth") == null) {
            this.f1337d[0].put("ImageWidth", b.b(0L, this.f1339f));
        }
        if (c("ImageLength") == null) {
            this.f1337d[0].put("ImageLength", b.b(0L, this.f1339f));
        }
        if (c("Orientation") == null) {
            this.f1337d[0].put("Orientation", b.b(0L, this.f1339f));
        }
        if (c("LightSource") == null) {
            this.f1337d[1].put("LightSource", b.b(0L, this.f1339f));
        }
    }

    private static long[] b(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            jArr[i3] = iArr[i3];
        }
        return jArr;
    }

    private b e(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i3 = 0; i3 < f1313N.length; i3++) {
            b bVar = (b) this.f1337d[i3].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0055 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    /* JADX WARN: Code duplicated, block: B:79:0x0086 A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    private void f(N.a.C0021a r10, int r11, int r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N.a.f(N.a$a, int, int):void");
    }

    private int g(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (n(bArr)) {
            return 4;
        }
        if (p(bArr)) {
            return 9;
        }
        if (o(bArr)) {
            return 7;
        }
        return q(bArr) ? 10 : 0;
    }

    private void h(C0021a c0021a) throws Throwable {
        int i3;
        int i4;
        j(c0021a);
        b bVar = (b) this.f1337d[1].get("MakerNote");
        if (bVar != null) {
            C0021a c0021a2 = new C0021a(bVar.f1359c);
            c0021a2.G(this.f1339f);
            byte[] bArr = f1331x;
            byte[] bArr2 = new byte[bArr.length];
            c0021a2.readFully(bArr2);
            c0021a2.y(0L);
            byte[] bArr3 = f1332y;
            byte[] bArr4 = new byte[bArr3.length];
            c0021a2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                c0021a2.y(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                c0021a2.y(12L);
            }
            x(c0021a2, 6);
            b bVar2 = (b) this.f1337d[7].get("PreviewImageStart");
            b bVar3 = (b) this.f1337d[7].get("PreviewImageLength");
            if (bVar2 != null && bVar3 != null) {
                this.f1337d[5].put("JPEGInterchangeFormat", bVar2);
                this.f1337d[5].put("JPEGInterchangeFormatLength", bVar3);
            }
            b bVar4 = (b) this.f1337d[8].get("AspectFrame");
            if (bVar4 != null) {
                int[] iArr = (int[]) bVar4.k(this.f1339f);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i5 = iArr[2];
                int i6 = iArr[0];
                if (i5 <= i6 || (i3 = iArr[3]) <= (i4 = iArr[1])) {
                    return;
                }
                int i7 = (i5 - i6) + 1;
                int i8 = (i3 - i4) + 1;
                if (i7 < i8) {
                    int i9 = i7 + i8;
                    i8 = i9 - i8;
                    i7 = i9 - i8;
                }
                b bVarF = b.f(i7, this.f1339f);
                b bVarF2 = b.f(i8, this.f1339f);
                this.f1337d[0].put("ImageWidth", bVarF);
                this.f1337d[0].put("ImageLength", bVarF2);
            }
        }
    }

    private void i(C0021a c0021a) throws IOException {
        c0021a.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        c0021a.read(bArr);
        c0021a.skipBytes(4);
        c0021a.read(bArr2);
        int i3 = ByteBuffer.wrap(bArr).getInt();
        int i4 = ByteBuffer.wrap(bArr2).getInt();
        f(c0021a, i3, 5);
        c0021a.y(i4);
        c0021a.G(ByteOrder.BIG_ENDIAN);
        int i5 = c0021a.readInt();
        for (int i6 = 0; i6 < i5; i6++) {
            int unsignedShort = c0021a.readUnsignedShort();
            int unsignedShort2 = c0021a.readUnsignedShort();
            if (unsignedShort == f1308I.f1360a) {
                short s3 = c0021a.readShort();
                short s4 = c0021a.readShort();
                b bVarF = b.f(s3, this.f1339f);
                b bVarF2 = b.f(s4, this.f1339f);
                this.f1337d[0].put("ImageLength", bVarF);
                this.f1337d[0].put("ImageWidth", bVarF2);
                return;
            }
            c0021a.skipBytes(unsignedShort2);
        }
    }

    private void j(C0021a c0021a) throws Throwable {
        b bVar;
        u(c0021a, c0021a.available());
        x(c0021a, 0);
        B(c0021a, 0);
        B(c0021a, 5);
        B(c0021a, 4);
        C(c0021a);
        if (this.f1336c != 8 || (bVar = (b) this.f1337d[1].get("MakerNote")) == null) {
            return;
        }
        C0021a c0021a2 = new C0021a(bVar.f1359c);
        c0021a2.G(this.f1339f);
        c0021a2.y(6L);
        x(c0021a2, 9);
        b bVar2 = (b) this.f1337d[9].get("ColorSpace");
        if (bVar2 != null) {
            this.f1337d[1].put("ColorSpace", bVar2);
        }
    }

    private void k(C0021a c0021a) throws Throwable {
        j(c0021a);
        if (((b) this.f1337d[0].get("JpgFromRaw")) != null) {
            f(c0021a, this.f1349p, 5);
        }
        b bVar = (b) this.f1337d[0].get("ISO");
        b bVar2 = (b) this.f1337d[1].get("PhotographicSensitivity");
        if (bVar == null || bVar2 != null) {
            return;
        }
        this.f1337d[1].put("PhotographicSensitivity", bVar);
    }

    private void l(C0021a c0021a, HashMap map) throws Throwable {
        int i3;
        b bVar = (b) map.get("JPEGInterchangeFormat");
        b bVar2 = (b) map.get("JPEGInterchangeFormatLength");
        if (bVar == null || bVar2 == null) {
            return;
        }
        int i4 = bVar.i(this.f1339f);
        int iMin = Math.min(bVar2.i(this.f1339f), c0021a.available() - i4);
        int i5 = this.f1336c;
        if (i5 != 4 && i5 != 9 && i5 != 10) {
            if (i5 == 7) {
                i3 = this.f1346m;
            }
            if (i4 > 0 || iMin <= 0) {
            }
            this.f1340g = true;
            this.f1341h = i4;
            this.f1342i = iMin;
            if (this.f1334a == null && this.f1335b == null) {
                byte[] bArr = new byte[iMin];
                c0021a.y(i4);
                c0021a.readFully(bArr);
                this.f1343j = bArr;
                return;
            }
            return;
        }
        i3 = this.f1345l;
        i4 += i3;
        if (i4 > 0) {
        }
    }

    private void m(C0021a c0021a, HashMap map) throws IOException {
        b bVar = (b) map.get("StripOffsets");
        b bVar2 = (b) map.get("StripByteCounts");
        if (bVar == null || bVar2 == null) {
            return;
        }
        long[] jArrB = b(bVar.k(this.f1339f));
        long[] jArrB2 = b(bVar2.k(this.f1339f));
        if (jArrB == null) {
            Log.w("ExifInterface", "stripOffsets should not be null.");
            return;
        }
        if (jArrB2 == null) {
            Log.w("ExifInterface", "stripByteCounts should not be null.");
            return;
        }
        long j3 = 0;
        for (long j4 : jArrB2) {
            j3 += j4;
        }
        int i3 = (int) j3;
        byte[] bArr = new byte[i3];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < jArrB.length; i6++) {
            int i7 = (int) jArrB[i6];
            int i8 = (int) jArrB2[i6];
            int i9 = i7 - i4;
            if (i9 < 0) {
                Log.d("ExifInterface", "Invalid strip offset value");
            }
            c0021a.y(i9);
            int i10 = i4 + i9;
            byte[] bArr2 = new byte[i8];
            c0021a.read(bArr2);
            i4 = i10 + i8;
            System.arraycopy(bArr2, 0, bArr, i5, i8);
            i5 += i8;
        }
        this.f1340g = true;
        this.f1343j = bArr;
        this.f1342i = i3;
    }

    private static boolean n(byte[] bArr) {
        int i3 = 0;
        while (true) {
            byte[] bArr2 = f1330w;
            if (i3 >= bArr2.length) {
                return true;
            }
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    private boolean o(byte[] bArr) throws IOException {
        C0021a c0021a = new C0021a(bArr);
        ByteOrder byteOrderV = v(c0021a);
        this.f1339f = byteOrderV;
        c0021a.G(byteOrderV);
        short s3 = c0021a.readShort();
        c0021a.close();
        return s3 == 20306 || s3 == 21330;
    }

    private boolean p(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i3 = 0; i3 < bytes.length; i3++) {
            if (bArr[i3] != bytes[i3]) {
                return false;
            }
        }
        return true;
    }

    private boolean q(byte[] bArr) throws IOException {
        C0021a c0021a = new C0021a(bArr);
        ByteOrder byteOrderV = v(c0021a);
        this.f1339f = byteOrderV;
        c0021a.G(byteOrderV);
        short s3 = c0021a.readShort();
        c0021a.close();
        return s3 == 85;
    }

    private boolean r(HashMap map) throws Throwable {
        b bVar;
        b bVar2 = (b) map.get("BitsPerSample");
        if (bVar2 == null) {
            return false;
        }
        int[] iArr = (int[]) bVar2.k(this.f1339f);
        int[] iArr2 = f1327t;
        if (Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.f1336c != 3 || (bVar = (b) map.get("PhotometricInterpretation")) == null) {
            return false;
        }
        int i3 = bVar.i(this.f1339f);
        return (i3 == 1 && Arrays.equals(iArr, f1329v)) || (i3 == 6 && Arrays.equals(iArr, iArr2));
    }

    private boolean s(HashMap map) {
        b bVar = (b) map.get("ImageLength");
        b bVar2 = (b) map.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.i(this.f1339f) <= 512 && bVar2.i(this.f1339f) <= 512;
    }

    private void t(InputStream inputStream) {
        for (int i3 = 0; i3 < f1313N.length; i3++) {
            try {
                try {
                    this.f1337d[i3] = new HashMap();
                } catch (IOException unused) {
                    this.f1350q = false;
                }
            } catch (Throwable th) {
                a();
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.f1336c = g(bufferedInputStream);
        C0021a c0021a = new C0021a(bufferedInputStream);
        switch (this.f1336c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                j(c0021a);
                break;
            case 4:
                f(c0021a, 0, 0);
                break;
            case 7:
                h(c0021a);
                break;
            case 9:
                i(c0021a);
                break;
            case 10:
                k(c0021a);
                break;
        }
        z(c0021a);
        this.f1350q = true;
        a();
    }

    private void u(C0021a c0021a, int i3) throws IOException {
        ByteOrder byteOrderV = v(c0021a);
        this.f1339f = byteOrderV;
        c0021a.G(byteOrderV);
        int unsignedShort = c0021a.readUnsignedShort();
        int i4 = this.f1336c;
        if (i4 != 7 && i4 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i5 = c0021a.readInt();
        if (i5 < 8 || i5 >= i3) {
            throw new IOException("Invalid first Ifd offset: " + i5);
        }
        int i6 = i5 - 8;
        if (i6 <= 0 || c0021a.skipBytes(i6) == i6) {
            return;
        }
        throw new IOException("Couldn't jump to first Ifd: " + i6);
    }

    private ByteOrder v(C0021a c0021a) throws IOException {
        short s3 = c0021a.readShort();
        if (s3 == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s3 == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s3));
    }

    private void w(byte[] bArr, int i3) throws IOException {
        C0021a c0021a = new C0021a(bArr);
        u(c0021a, bArr.length);
        x(c0021a, i3);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:128:0x02b0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:37:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:41:0x0108  */
    /* JADX WARN: Code duplicated, block: B:43:0x0112  */
    /* JADX WARN: Code duplicated, block: B:45:0x011b  */
    /* JADX WARN: Code duplicated, block: B:47:0x011e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0166  */
    /* JADX WARN: Code duplicated, block: B:52:0x0170  */
    /* JADX WARN: Code duplicated, block: B:57:0x0187  */
    /* JADX WARN: Code duplicated, block: B:58:0x018d  */
    /* JADX WARN: Code duplicated, block: B:59:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:64:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:66:0x01c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:69:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:75:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:76:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:77:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:80:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:86:0x0230  */
    /* JADX WARN: Code duplicated, block: B:88:0x0248  */
    /* JADX WARN: Code duplicated, block: B:90:0x026b  */
    /* JADX WARN: Code duplicated, block: B:93:0x0277  */
    /* JADX WARN: Code duplicated, block: B:95:0x0281  */
    /* JADX WARN: Instruction removed from duplicated block: B:58:0x018d, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:86:0x0230, please report this as an issue */
    private void x(C0021a c0021a, int i3) throws IOException {
        String str;
        long j3;
        boolean z3;
        short s3;
        int i4;
        int i5;
        Integer num;
        int i6;
        int unsignedShort;
        long jT;
        int i7;
        int i8;
        long j4;
        long j5;
        this.f1338e.add(Integer.valueOf(c0021a.f1356d));
        if (c0021a.f1356d + 2 > c0021a.f1355c) {
            return;
        }
        short s4 = c0021a.readShort();
        if (c0021a.f1356d + (s4 * 12) > c0021a.f1355c || s4 <= 0) {
            return;
        }
        short s5 = 0;
        while (s5 < s4) {
            int unsignedShort2 = c0021a.readUnsignedShort();
            int unsignedShort3 = c0021a.readUnsignedShort();
            int i9 = c0021a.readInt();
            long jG = ((long) c0021a.g()) + 4;
            c cVar = (c) f1317R[i3].get(Integer.valueOf(unsignedShort2));
            if (cVar == null) {
                Log.w("ExifInterface", "Skip the tag entry since tag number is not defined: " + unsignedShort2);
            } else {
                if (unsignedShort3 > 0) {
                    int[] iArr = f1301B;
                    if (unsignedShort3 < iArr.length) {
                        if (cVar.a(unsignedShort3)) {
                            if (unsignedShort3 == 7) {
                                unsignedShort3 = cVar.f1362c;
                            }
                            str = "ExifInterface";
                            s5 = s5;
                            j3 = ((long) iArr[unsignedShort3]) * ((long) i9);
                            if (j3 < 0 || j3 > 2147483647L) {
                                Log.w(str, "Skip the tag entry since the number of components is invalid: " + i9);
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                        } else {
                            Log.w("ExifInterface", "Skip the tag entry since data format (" + f1300A[unsignedShort3] + ") is unexpected for tag: " + cVar.f1361b);
                        }
                    }
                    if (z3) {
                        if (j3 > 4) {
                            i7 = c0021a.readInt();
                            i8 = this.f1336c;
                            s3 = s4;
                            if (i8 == 7) {
                                if ("MakerNote".equals(cVar.f1361b)) {
                                    this.f1346m = i7;
                                } else if (i3 != 6 && "ThumbnailImage".equals(cVar.f1361b)) {
                                    this.f1347n = i7;
                                    this.f1348o = i9;
                                    b bVarF = b.f(6, this.f1339f);
                                    i4 = unsignedShort3;
                                    i5 = i9;
                                    b bVarB = b.b(this.f1347n, this.f1339f);
                                    j4 = jG;
                                    b bVarB2 = b.b(this.f1348o, this.f1339f);
                                    this.f1337d[4].put("Compression", bVarF);
                                    this.f1337d[4].put("JPEGInterchangeFormat", bVarB);
                                    this.f1337d[4].put("JPEGInterchangeFormatLength", bVarB2);
                                }
                                i4 = unsignedShort3;
                                i5 = i9;
                                j4 = jG;
                            } else {
                                i4 = unsignedShort3;
                                i5 = i9;
                                j4 = jG;
                                if (i8 == 10 && "JpgFromRaw".equals(cVar.f1361b)) {
                                    this.f1349p = i7;
                                }
                            }
                            j5 = i7;
                            if (j5 + j3 <= c0021a.f1355c) {
                                c0021a.y(j5);
                                jG = j4;
                            } else {
                                Log.w(str, "Skip the tag entry since data offset is invalid: " + i7);
                                c0021a.y(j4);
                            }
                        } else {
                            s3 = s4;
                            i4 = unsignedShort3;
                            i5 = i9;
                        }
                        num = (Integer) f1320U.get(Integer.valueOf(unsignedShort2));
                        if (num != null) {
                            i6 = i4;
                            if (i6 != 3) {
                                if (i6 == 4) {
                                    jT = c0021a.t();
                                } else if (i6 == 8) {
                                    unsignedShort = c0021a.readShort();
                                } else if (i6 != 9 || i6 == 13) {
                                    unsignedShort = c0021a.readInt();
                                } else {
                                    jT = -1;
                                }
                                if (jT > 0 || jT >= c0021a.f1355c) {
                                    Log.w(str, "Skip jump into the IFD since its offset is invalid: " + jT);
                                } else if (this.f1338e.contains(Integer.valueOf((int) jT))) {
                                    Log.w(str, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + jT + ")");
                                } else {
                                    c0021a.y(jT);
                                    x(c0021a, num.intValue());
                                }
                                c0021a.y(jG);
                            } else {
                                unsignedShort = c0021a.readUnsignedShort();
                            }
                            jT = unsignedShort;
                            if (jT > 0) {
                                Log.w(str, "Skip jump into the IFD since its offset is invalid: " + jT);
                            } else {
                                Log.w(str, "Skip jump into the IFD since its offset is invalid: " + jT);
                            }
                            c0021a.y(jG);
                        } else {
                            byte[] bArr = new byte[(int) j3];
                            c0021a.readFully(bArr);
                            b bVar = new b(i4, i5, bArr);
                            this.f1337d[i3].put(cVar.f1361b, bVar);
                            if ("DNGVersion".equals(cVar.f1361b)) {
                                this.f1336c = 3;
                            }
                            if (((!"Make".equals(cVar.f1361b) || "Model".equals(cVar.f1361b)) && bVar.j(this.f1339f).contains("PENTAX")) || ("Compression".equals(cVar.f1361b) && bVar.i(this.f1339f) == 65535)) {
                                this.f1336c = 8;
                            }
                            if (c0021a.g() != jG) {
                                c0021a.y(jG);
                            }
                        }
                    } else {
                        c0021a.y(jG);
                        s3 = s4;
                    }
                    s5 = (short) (s5 + 1);
                    s4 = s3;
                }
                str = "ExifInterface";
                Log.w(str, "Skip the tag entry since data format is invalid: " + unsignedShort3);
                j3 = 0;
                z3 = false;
                if (z3) {
                    c0021a.y(jG);
                    s3 = s4;
                } else {
                    if (j3 > 4) {
                        i7 = c0021a.readInt();
                        i8 = this.f1336c;
                        s3 = s4;
                        if (i8 == 7) {
                            if ("MakerNote".equals(cVar.f1361b)) {
                                this.f1346m = i7;
                            } else if (i3 != 6) {
                            }
                            i4 = unsignedShort3;
                            i5 = i9;
                            j4 = jG;
                        } else {
                            i4 = unsignedShort3;
                            i5 = i9;
                            j4 = jG;
                            if (i8 == 10) {
                                this.f1349p = i7;
                            }
                        }
                        j5 = i7;
                        if (j5 + j3 <= c0021a.f1355c) {
                            c0021a.y(j5);
                            jG = j4;
                        } else {
                            Log.w(str, "Skip the tag entry since data offset is invalid: " + i7);
                            c0021a.y(j4);
                        }
                    } else {
                        s3 = s4;
                        i4 = unsignedShort3;
                        i5 = i9;
                    }
                    num = (Integer) f1320U.get(Integer.valueOf(unsignedShort2));
                    if (num != null) {
                        i6 = i4;
                        if (i6 != 3) {
                            if (i6 == 4) {
                                jT = c0021a.t();
                            } else if (i6 == 8) {
                                if (i6 != 9) {
                                }
                                unsignedShort = c0021a.readInt();
                            } else {
                                unsignedShort = c0021a.readShort();
                            }
                            if (jT > 0) {
                                Log.w(str, "Skip jump into the IFD since its offset is invalid: " + jT);
                            } else {
                                Log.w(str, "Skip jump into the IFD since its offset is invalid: " + jT);
                            }
                            c0021a.y(jG);
                        } else {
                            unsignedShort = c0021a.readUnsignedShort();
                        }
                        jT = unsignedShort;
                        if (jT > 0) {
                            Log.w(str, "Skip jump into the IFD since its offset is invalid: " + jT);
                        } else {
                            Log.w(str, "Skip jump into the IFD since its offset is invalid: " + jT);
                        }
                        c0021a.y(jG);
                    } else {
                        byte[] bArr2 = new byte[(int) j3];
                        c0021a.readFully(bArr2);
                        b bVar2 = new b(i4, i5, bArr2);
                        this.f1337d[i3].put(cVar.f1361b, bVar2);
                        if ("DNGVersion".equals(cVar.f1361b)) {
                            this.f1336c = 3;
                        }
                        if (!"Make".equals(cVar.f1361b)) {
                        }
                        this.f1336c = 8;
                        if (c0021a.g() != jG) {
                            c0021a.y(jG);
                        }
                    }
                }
                s5 = (short) (s5 + 1);
                s4 = s3;
            }
            str = "ExifInterface";
            j3 = 0;
            z3 = false;
            if (z3) {
                c0021a.y(jG);
                s3 = s4;
            } else {
                if (j3 > 4) {
                    i7 = c0021a.readInt();
                    i8 = this.f1336c;
                    s3 = s4;
                    if (i8 == 7) {
                        if ("MakerNote".equals(cVar.f1361b)) {
                            this.f1346m = i7;
                        } else if (i3 != 6) {
                        }
                        i4 = unsignedShort3;
                        i5 = i9;
                        j4 = jG;
                    } else {
                        i4 = unsignedShort3;
                        i5 = i9;
                        j4 = jG;
                        if (i8 == 10) {
                            this.f1349p = i7;
                        }
                    }
                    j5 = i7;
                    if (j5 + j3 <= c0021a.f1355c) {
                        c0021a.y(j5);
                        jG = j4;
                    } else {
                        Log.w(str, "Skip the tag entry since data offset is invalid: " + i7);
                        c0021a.y(j4);
                    }
                } else {
                    s3 = s4;
                    i4 = unsignedShort3;
                    i5 = i9;
                }
                num = (Integer) f1320U.get(Integer.valueOf(unsignedShort2));
                if (num != null) {
                    i6 = i4;
                    if (i6 != 3) {
                        if (i6 == 4) {
                            jT = c0021a.t();
                        } else if (i6 == 8) {
                            if (i6 != 9) {
                            }
                            unsignedShort = c0021a.readInt();
                        } else {
                            unsignedShort = c0021a.readShort();
                        }
                        if (jT > 0) {
                            Log.w(str, "Skip jump into the IFD since its offset is invalid: " + jT);
                        } else {
                            Log.w(str, "Skip jump into the IFD since its offset is invalid: " + jT);
                        }
                        c0021a.y(jG);
                    } else {
                        unsignedShort = c0021a.readUnsignedShort();
                    }
                    jT = unsignedShort;
                    if (jT > 0) {
                        Log.w(str, "Skip jump into the IFD since its offset is invalid: " + jT);
                    } else {
                        Log.w(str, "Skip jump into the IFD since its offset is invalid: " + jT);
                    }
                    c0021a.y(jG);
                } else {
                    byte[] bArr3 = new byte[(int) j3];
                    c0021a.readFully(bArr3);
                    b bVar3 = new b(i4, i5, bArr3);
                    this.f1337d[i3].put(cVar.f1361b, bVar3);
                    if ("DNGVersion".equals(cVar.f1361b)) {
                        this.f1336c = 3;
                    }
                    if (!"Make".equals(cVar.f1361b)) {
                    }
                    this.f1336c = 8;
                    if (c0021a.g() != jG) {
                        c0021a.y(jG);
                    }
                }
            }
            s5 = (short) (s5 + 1);
            s4 = s3;
        }
        if (c0021a.g() + 4 <= c0021a.f1355c) {
            int i10 = c0021a.readInt();
            long j6 = i10;
            if (j6 <= 0 || i10 >= c0021a.f1355c) {
                Log.w("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: " + i10);
                return;
            }
            if (this.f1338e.contains(Integer.valueOf(i10))) {
                Log.w("ExifInterface", "Stop reading file since re-reading an IFD may cause an infinite loop: " + i10);
                return;
            }
            c0021a.y(j6);
            if (this.f1337d[4].isEmpty()) {
                x(c0021a, 4);
            } else if (this.f1337d[5].isEmpty()) {
                x(c0021a, 5);
            }
        }
    }

    private void y(C0021a c0021a, int i3) throws IOException {
        b bVar;
        b bVar2 = (b) this.f1337d[i3].get("ImageLength");
        b bVar3 = (b) this.f1337d[i3].get("ImageWidth");
        if ((bVar2 == null || bVar3 == null) && (bVar = (b) this.f1337d[i3].get("JPEGInterchangeFormat")) != null) {
            f(c0021a, bVar.i(this.f1339f), i3);
        }
    }

    private void z(C0021a c0021a) throws Throwable {
        HashMap map = this.f1337d[4];
        b bVar = (b) map.get("Compression");
        if (bVar == null) {
            this.f1344k = 6;
            l(c0021a, map);
            return;
        }
        int i3 = bVar.i(this.f1339f);
        this.f1344k = i3;
        if (i3 != 1) {
            if (i3 == 6) {
                l(c0021a, map);
                return;
            } else if (i3 != 7) {
                return;
            }
        }
        if (r(map)) {
            m(c0021a, map);
        }
    }

    public String c(String str) {
        b bVarE = e(str);
        if (bVarE != null) {
            if (!f1319T.contains(str)) {
                return bVarE.j(this.f1339f);
            }
            if (str.equals("GPSTimeStamp")) {
                int i3 = bVarE.f1357a;
                if (i3 != 5 && i3 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + bVarE.f1357a);
                    return null;
                }
                d[] dVarArr = (d[]) bVarE.k(this.f1339f);
                if (dVarArr == null || dVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(dVarArr));
                    return null;
                }
                d dVar = dVarArr[0];
                Integer numValueOf = Integer.valueOf((int) (dVar.f1364a / dVar.f1365b));
                d dVar2 = dVarArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (dVar2.f1364a / dVar2.f1365b));
                d dVar3 = dVarArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (dVar3.f1364a / dVar3.f1365b)));
            }
            try {
                return Double.toString(bVarE.h(this.f1339f));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int d(String str, int i3) {
        b bVarE = e(str);
        if (bVarE == null) {
            return i3;
        }
        try {
            return bVarE.i(this.f1339f);
        } catch (NumberFormatException unused) {
            return i3;
        }
    }

    /* JADX INFO: renamed from: N.a$a, reason: collision with other inner class name */
    private static class C0021a extends InputStream implements DataInput {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final ByteOrder f1351e = ByteOrder.LITTLE_ENDIAN;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final ByteOrder f1352f = ByteOrder.BIG_ENDIAN;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private DataInputStream f1353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ByteOrder f1354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f1355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1356d;

        public C0021a(InputStream inputStream) throws IOException {
            this.f1354b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f1353a = dataInputStream;
            int iAvailable = dataInputStream.available();
            this.f1355c = iAvailable;
            this.f1356d = 0;
            this.f1353a.mark(iAvailable);
        }

        public void G(ByteOrder byteOrder) {
            this.f1354b = byteOrder;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f1353a.available();
        }

        public int g() {
            return this.f1356d;
        }

        @Override // java.io.InputStream
        public int read() {
            this.f1356d++;
            return this.f1353a.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f1356d++;
            return this.f1353a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int i3 = this.f1356d + 1;
            this.f1356d = i3;
            if (i3 > this.f1355c) {
                throw new EOFException();
            }
            int i4 = this.f1353a.read();
            if (i4 >= 0) {
                return (byte) i4;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f1356d += 2;
            return this.f1353a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i3, int i4) throws IOException {
            int i5 = this.f1356d + i4;
            this.f1356d = i5;
            if (i5 > this.f1355c) {
                throw new EOFException();
            }
            if (this.f1353a.read(bArr, i3, i4) != i4) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int i3 = this.f1356d + 4;
            this.f1356d = i3;
            if (i3 > this.f1355c) {
                throw new EOFException();
            }
            int i4 = this.f1353a.read();
            int i5 = this.f1353a.read();
            int i6 = this.f1353a.read();
            int i7 = this.f1353a.read();
            if ((i4 | i5 | i6 | i7) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f1354b;
            if (byteOrder == f1351e) {
                return (i7 << 24) + (i6 << 16) + (i5 << 8) + i4;
            }
            if (byteOrder == f1352f) {
                return (i4 << 24) + (i5 << 16) + (i6 << 8) + i7;
            }
            throw new IOException("Invalid byte order: " + this.f1354b);
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int i3 = this.f1356d + 8;
            this.f1356d = i3;
            if (i3 > this.f1355c) {
                throw new EOFException();
            }
            int i4 = this.f1353a.read();
            int i5 = this.f1353a.read();
            int i6 = this.f1353a.read();
            int i7 = this.f1353a.read();
            int i8 = this.f1353a.read();
            int i9 = this.f1353a.read();
            int i10 = this.f1353a.read();
            int i11 = this.f1353a.read();
            if ((i4 | i5 | i6 | i7 | i8 | i9 | i10 | i11) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f1354b;
            if (byteOrder == f1351e) {
                return (((long) i11) << 56) + (((long) i10) << 48) + (((long) i9) << 40) + (((long) i8) << 32) + (((long) i7) << 24) + (((long) i6) << 16) + (((long) i5) << 8) + ((long) i4);
            }
            if (byteOrder == f1352f) {
                return (((long) i4) << 56) + (((long) i5) << 48) + (((long) i6) << 40) + (((long) i7) << 32) + (((long) i8) << 24) + (((long) i9) << 16) + (((long) i10) << 8) + ((long) i11);
            }
            throw new IOException("Invalid byte order: " + this.f1354b);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i3 = this.f1356d + 2;
            this.f1356d = i3;
            if (i3 > this.f1355c) {
                throw new EOFException();
            }
            int i4 = this.f1353a.read();
            int i5 = this.f1353a.read();
            if ((i4 | i5) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f1354b;
            if (byteOrder == f1351e) {
                return (short) ((i5 << 8) + i4);
            }
            if (byteOrder == f1352f) {
                return (short) ((i4 << 8) + i5);
            }
            throw new IOException("Invalid byte order: " + this.f1354b);
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f1356d += 2;
            return this.f1353a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f1356d++;
            return this.f1353a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int i3 = this.f1356d + 2;
            this.f1356d = i3;
            if (i3 > this.f1355c) {
                throw new EOFException();
            }
            int i4 = this.f1353a.read();
            int i5 = this.f1353a.read();
            if ((i4 | i5) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f1354b;
            if (byteOrder == f1351e) {
                return (i5 << 8) + i4;
            }
            if (byteOrder == f1352f) {
                return (i4 << 8) + i5;
            }
            throw new IOException("Invalid byte order: " + this.f1354b);
        }

        @Override // java.io.DataInput
        public int skipBytes(int i3) {
            int iMin = Math.min(i3, this.f1355c - this.f1356d);
            int iSkipBytes = 0;
            while (iSkipBytes < iMin) {
                iSkipBytes += this.f1353a.skipBytes(iMin - iSkipBytes);
            }
            this.f1356d += iSkipBytes;
            return iSkipBytes;
        }

        public long t() {
            return ((long) readInt()) & 4294967295L;
        }

        public void y(long j3) throws IOException {
            int i3 = this.f1356d;
            if (i3 > j3) {
                this.f1356d = 0;
                this.f1353a.reset();
                this.f1353a.mark(this.f1355c);
            } else {
                j3 -= (long) i3;
            }
            int i4 = (int) j3;
            if (skipBytes(i4) != i4) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) throws IOException {
            int i5 = this.f1353a.read(bArr, i3, i4);
            this.f1356d += i5;
            return i5;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            int length = this.f1356d + bArr.length;
            this.f1356d = length;
            if (length <= this.f1355c) {
                if (this.f1353a.read(bArr, 0, bArr.length) != bArr.length) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        public C0021a(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1362c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f1363d;

        c(String str, int i3, int i4) {
            this.f1361b = str;
            this.f1360a = i3;
            this.f1362c = i4;
            this.f1363d = -1;
        }

        boolean a(int i3) {
            int i4;
            int i5 = this.f1362c;
            if (i5 == 7 || i3 == 7 || i5 == i3 || (i4 = this.f1363d) == i3) {
                return true;
            }
            if ((i5 == 4 || i4 == 4) && i3 == 3) {
                return true;
            }
            if ((i5 == 9 || i4 == 9) && i3 == 8) {
                return true;
            }
            return (i5 == 12 || i4 == 12) && i3 == 11;
        }

        c(String str, int i3, int i4, int i5) {
            this.f1361b = str;
            this.f1360a = i3;
            this.f1362c = i4;
            this.f1363d = i5;
        }
    }
}
