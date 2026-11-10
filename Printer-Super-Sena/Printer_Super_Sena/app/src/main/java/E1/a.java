package E1;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import p081y1.f;

/* JADX INFO: loaded from: classes.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Reader f248a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f256i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f257j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f258k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int[] f259l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String[] f261n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int[] f262o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f249b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char[] f250c = new char[1024];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f251d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f252e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f253f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f254g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f255h = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f260m = 1;

    /* JADX INFO: renamed from: E1.a$a, reason: collision with other inner class name */
    class C0008a extends f {
        C0008a() {
        }

        @Override // p081y1.f
        public void a(a aVar) throws IOException {
            if (aVar instanceof p084z1.f) {
                ((p084z1.f) aVar).t0();
                return;
            }
            int I2 = aVar.f255h;
            if (I2 == 0) {
                I2 = aVar.I();
            }
            if (I2 == 13) {
                aVar.f255h = 9;
                return;
            }
            if (I2 == 12) {
                aVar.f255h = 8;
                return;
            }
            if (I2 == 14) {
                aVar.f255h = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + aVar.c0() + aVar.R());
        }
    }

    static {
        f.f12859a = new C0008a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f259l = iArr;
        iArr[0] = 6;
        this.f261n = new String[32];
        this.f262o = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f248a = reader;
    }

    private void G() throws IOException {
        X(true);
        int i3 = this.f251d;
        this.f251d = i3 - 1;
        if (i3 + 4 <= this.f252e || L(5)) {
            int i4 = this.f251d;
            char[] cArr = this.f250c;
            if (cArr[i4] == ')' && cArr[i4 + 1] == ']' && cArr[i4 + 2] == '}' && cArr[i4 + 3] == '\'' && cArr[i4 + 4] == '\n') {
                this.f251d = i4 + 5;
            }
        }
    }

    private boolean L(int i3) throws IOException {
        int i4;
        int i5;
        char[] cArr = this.f250c;
        int i6 = this.f254g;
        int i7 = this.f251d;
        this.f254g = i6 - i7;
        int i8 = this.f252e;
        if (i8 != i7) {
            int i9 = i8 - i7;
            this.f252e = i9;
            System.arraycopy(cArr, i7, cArr, 0, i9);
        } else {
            this.f252e = 0;
        }
        this.f251d = 0;
        do {
            Reader reader = this.f248a;
            int i10 = this.f252e;
            int i11 = reader.read(cArr, i10, cArr.length - i10);
            if (i11 == -1) {
                return false;
            }
            i4 = this.f252e + i11;
            this.f252e = i4;
            if (this.f253f == 0 && (i5 = this.f254g) == 0 && i4 > 0 && cArr[0] == 65279) {
                this.f251d++;
                this.f254g = i5 + 1;
                i3++;
            }
        } while (i4 < i3);
        return true;
    }

    private String M(boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i3 = 0;
        while (true) {
            int i4 = this.f260m;
            if (i3 >= i4) {
                return sb.toString();
            }
            int i5 = this.f259l[i3];
            if (i5 == 1 || i5 == 2) {
                int i6 = this.f262o[i3];
                if (z3 && i6 > 0 && i3 == i4 - 1) {
                    i6--;
                }
                sb.append('[');
                sb.append(i6);
                sb.append(']');
            } else if (i5 == 3 || i5 == 4 || i5 == 5) {
                sb.append('.');
                String str = this.f261n[i3];
                if (str != null) {
                    sb.append(str);
                }
            }
            i3++;
        }
    }

    private boolean Q(char c3) throws IOException {
        if (c3 == '\t' || c3 == '\n' || c3 == '\f' || c3 == '\r' || c3 == ' ') {
            return false;
        }
        if (c3 != '#') {
            if (c3 == ',') {
                return false;
            }
            if (c3 != '/' && c3 != '=') {
                if (c3 == '{' || c3 == '}' || c3 == ':') {
                    return false;
                }
                if (c3 != ';') {
                    switch (c3) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        y();
        return false;
    }

    private int X(boolean z3) throws IOException {
        char[] cArr = this.f250c;
        int i3 = this.f251d;
        int i4 = this.f252e;
        while (true) {
            if (i3 == i4) {
                this.f251d = i3;
                if (!L(1)) {
                    if (!z3) {
                        return -1;
                    }
                    throw new EOFException("End of input" + R());
                }
                i3 = this.f251d;
                i4 = this.f252e;
            }
            int i5 = i3 + 1;
            char c3 = cArr[i3];
            if (c3 == '\n') {
                this.f253f++;
                this.f254g = i5;
            } else if (c3 != ' ' && c3 != '\r' && c3 != '\t') {
                if (c3 == '/') {
                    this.f251d = i5;
                    if (i5 == i4) {
                        this.f251d = i3;
                        boolean zL = L(2);
                        this.f251d++;
                        if (!zL) {
                            return c3;
                        }
                    }
                    y();
                    int i6 = this.f251d;
                    char c4 = cArr[i6];
                    if (c4 == '*') {
                        this.f251d = i6 + 1;
                        if (!j0("*/")) {
                            throw n0("Unterminated comment");
                        }
                        i3 = this.f251d + 2;
                        i4 = this.f252e;
                    } else {
                        if (c4 != '/') {
                            return c3;
                        }
                        this.f251d = i6 + 1;
                        k0();
                        i3 = this.f251d;
                        i4 = this.f252e;
                    }
                } else {
                    if (c3 != '#') {
                        this.f251d = i5;
                        return c3;
                    }
                    this.f251d = i5;
                    y();
                    k0();
                    i3 = this.f251d;
                    i4 = this.f252e;
                }
            }
            i3 = i5;
        }
    }

    private String Z(char c3) throws IOException {
        int i3;
        char[] cArr = this.f250c;
        StringBuilder sb = null;
        do {
            int i4 = this.f251d;
            int i5 = this.f252e;
            while (true) {
                int i6 = i5;
                i3 = i4;
                while (true) {
                    if (i4 < i6) {
                        int i7 = i4 + 1;
                        char c4 = cArr[i4];
                        if (c4 == c3) {
                            this.f251d = i7;
                            int i8 = (i7 - i3) - 1;
                            if (sb == null) {
                                return new String(cArr, i3, i8);
                            }
                            sb.append(cArr, i3, i8);
                            return sb.toString();
                        }
                        if (c4 == '\\') {
                            this.f251d = i7;
                            int i9 = i7 - i3;
                            int i10 = i9 - 1;
                            if (sb == null) {
                                sb = new StringBuilder(Math.max(i9 * 2, 16));
                            }
                            sb.append(cArr, i3, i10);
                            sb.append(g0());
                            i4 = this.f251d;
                            i5 = this.f252e;
                        } else {
                            if (c4 == '\n') {
                                this.f253f++;
                                this.f254g = i7;
                            }
                            i4 = i7;
                        }
                    }
                }
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i4 - i3) * 2, 16));
            }
            sb.append(cArr, i3, i4 - i3);
            this.f251d = i4;
        } while (L(1));
        throw n0("Unterminated string");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    private String b0() throws IOException {
        String string;
        StringBuilder sb = null;
        int i3 = 0;
        while (true) {
            int i4 = 0;
            while (true) {
                int i5 = this.f251d;
                if (i5 + i4 < this.f252e) {
                    char c3 = this.f250c[i5 + i4];
                    if (c3 != '\t' && c3 != '\n' && c3 != '\f' && c3 != '\r' && c3 != ' ') {
                        if (c3 != '#') {
                            if (c3 != ',') {
                                if (c3 != '/' && c3 != '=') {
                                    if (c3 != '{' && c3 != '}' && c3 != ':') {
                                        if (c3 != ';') {
                                            switch (c3) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i4++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        y();
                    }
                    i3 = i4;
                } else if (i4 >= this.f250c.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i4, 16));
                    }
                    sb.append(this.f250c, this.f251d, i4);
                    this.f251d += i4;
                    if (!L(1)) {
                    }
                } else if (!L(i4 + 1)) {
                    i3 = i4;
                }
                if (sb == null) {
                    string = new String(this.f250c, this.f251d, i3);
                } else {
                    sb.append(this.f250c, this.f251d, i3);
                    string = sb.toString();
                }
                this.f251d += i3;
                return string;
            }
        }
    }

    private int d0() {
        String str;
        String str2;
        int i3;
        char c3 = this.f250c[this.f251d];
        if (c3 == 't' || c3 == 'T') {
            str = "true";
            str2 = "TRUE";
            i3 = 5;
        } else if (c3 == 'f' || c3 == 'F') {
            str = "false";
            str2 = "FALSE";
            i3 = 6;
        } else {
            if (c3 != 'n' && c3 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i3 = 7;
        }
        int length = str.length();
        for (int i4 = 1; i4 < length; i4++) {
            if (this.f251d + i4 >= this.f252e && !L(i4 + 1)) {
                return 0;
            }
            char c4 = this.f250c[this.f251d + i4];
            if (c4 != str.charAt(i4) && c4 != str2.charAt(i4)) {
                return 0;
            }
        }
        if ((this.f251d + length < this.f252e || L(length + 1)) && Q(this.f250c[this.f251d + length])) {
            return 0;
        }
        this.f251d += length;
        this.f255h = i3;
        return i3;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x00fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    /* JADX WARN: Code duplicated, block: B:91:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:93:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:98:0x00f1  */
    private int e0() {
        char c3;
        char[] cArr = this.f250c;
        int i3 = this.f251d;
        int i4 = this.f252e;
        int i5 = 0;
        int i6 = 0;
        char c4 = 0;
        boolean z3 = true;
        long j3 = 0;
        boolean z4 = false;
        while (true) {
            if (i3 + i6 != i4) {
                c3 = cArr[i3 + i6];
                if (c3 != '+') {
                    if (c3 != 'E' || c3 == 'e') {
                        i5 = 0;
                        if (c4 == 2 && c4 != 4) {
                            return 0;
                        }
                        c4 = 5;
                    } else if (c3 == '-') {
                        i5 = 0;
                        if (c4 == 0) {
                            c4 = 1;
                            z4 = true;
                        } else if (c4 != 5) {
                            return 0;
                        }
                    } else if (c3 == '.') {
                        i5 = 0;
                        if (c4 != 2) {
                            return 0;
                        }
                        c4 = 3;
                    } else {
                        if (c3 < '0' || c3 > '9') {
                            if (!Q(c3)) {
                                break;
                            }
                            return 0;
                        }
                        if (c4 == 1 || c4 == 0) {
                            j3 = -(c3 - '0');
                            i5 = 0;
                            c4 = 2;
                        } else {
                            if (c4 == 2) {
                                if (j3 == 0) {
                                    return 0;
                                }
                                long j4 = (10 * j3) - ((long) (c3 - '0'));
                                z3 &= j3 > -922337203685477580L || (j3 == -922337203685477580L && j4 < j3);
                                j3 = j4;
                            } else if (c4 == 3) {
                                i5 = 0;
                                c4 = 4;
                            } else if (c4 == 5 || c4 == 6) {
                                i5 = 0;
                                c4 = 7;
                            }
                            i5 = 0;
                        }
                    }
                    i6++;
                } else {
                    i5 = 0;
                    if (c4 != 5) {
                        return 0;
                    }
                }
                c4 = 6;
                i6++;
            } else {
                if (i6 == cArr.length) {
                    return i5;
                }
                if (!L(i6 + 1)) {
                    break;
                }
                i3 = this.f251d;
                i4 = this.f252e;
                c3 = cArr[i3 + i6];
                if (c3 != '+') {
                    if (c3 != 'E') {
                        i5 = 0;
                        if (c4 == 2) {
                        }
                        c4 = 5;
                    } else {
                        i5 = 0;
                        if (c4 == 2) {
                        }
                        c4 = 5;
                    }
                    i6++;
                } else {
                    i5 = 0;
                    if (c4 != 5) {
                        return 0;
                    }
                }
                c4 = 6;
                i6++;
            }
        }
        if (c4 == 2 && z3 && ((j3 != Long.MIN_VALUE || z4) && (j3 != 0 || !z4))) {
            if (!z4) {
                j3 = -j3;
            }
            this.f256i = j3;
            this.f251d += i6;
            this.f255h = 15;
            return 15;
        }
        if (c4 != 2 && c4 != 4 && c4 != 7) {
            return 0;
        }
        this.f257j = i6;
        this.f255h = 16;
        return 16;
    }

    private void f0(int i3) {
        int i4 = this.f260m;
        int[] iArr = this.f259l;
        if (i4 == iArr.length) {
            int i5 = i4 * 2;
            this.f259l = Arrays.copyOf(iArr, i5);
            this.f262o = Arrays.copyOf(this.f262o, i5);
            this.f261n = (String[]) Arrays.copyOf(this.f261n, i5);
        }
        int[] iArr2 = this.f259l;
        int i6 = this.f260m;
        this.f260m = i6 + 1;
        iArr2[i6] = i3;
    }

    private char g0() throws IOException {
        int i3;
        if (this.f251d == this.f252e && !L(1)) {
            throw n0("Unterminated escape sequence");
        }
        char[] cArr = this.f250c;
        int i4 = this.f251d;
        int i5 = i4 + 1;
        this.f251d = i5;
        char c3 = cArr[i4];
        if (c3 == '\n') {
            this.f253f++;
            this.f254g = i5;
        } else if (c3 != '\"' && c3 != '\'' && c3 != '/' && c3 != '\\') {
            if (c3 == 'b') {
                return '\b';
            }
            if (c3 == 'f') {
                return '\f';
            }
            if (c3 == 'n') {
                return '\n';
            }
            if (c3 == 'r') {
                return '\r';
            }
            if (c3 == 't') {
                return '\t';
            }
            if (c3 != 'u') {
                throw n0("Invalid escape sequence");
            }
            if (i4 + 5 > this.f252e && !L(4)) {
                throw n0("Unterminated escape sequence");
            }
            int i6 = this.f251d;
            int i7 = i6 + 4;
            char c4 = 0;
            while (i6 < i7) {
                char c5 = this.f250c[i6];
                char c6 = (char) (c4 << 4);
                if (c5 >= '0' && c5 <= '9') {
                    i3 = c5 - '0';
                } else if (c5 >= 'a' && c5 <= 'f') {
                    i3 = c5 - 'W';
                } else {
                    if (c5 < 'A' || c5 > 'F') {
                        throw new NumberFormatException("\\u" + new String(this.f250c, this.f251d, 4));
                    }
                    i3 = c5 - '7';
                }
                c4 = (char) (c6 + i3);
                i6++;
            }
            this.f251d += 4;
            return c4;
        }
        return c3;
    }

    private void i0(char c3) throws IOException {
        char[] cArr = this.f250c;
        do {
            int i3 = this.f251d;
            int i4 = this.f252e;
            while (i3 < i4) {
                int i5 = i3 + 1;
                char c4 = cArr[i3];
                if (c4 == c3) {
                    this.f251d = i5;
                    return;
                }
                if (c4 == '\\') {
                    this.f251d = i5;
                    g0();
                    i3 = this.f251d;
                    i4 = this.f252e;
                } else {
                    if (c4 == '\n') {
                        this.f253f++;
                        this.f254g = i5;
                    }
                    i3 = i5;
                }
            }
            this.f251d = i3;
        } while (L(1));
        throw n0("Unterminated string");
    }

    private boolean j0(String str) {
        int length = str.length();
        while (true) {
            if (this.f251d + length > this.f252e && !L(length)) {
                return false;
            }
            char[] cArr = this.f250c;
            int i3 = this.f251d;
            if (cArr[i3] != '\n') {
                for (int i4 = 0; i4 < length; i4++) {
                    if (this.f250c[this.f251d + i4] == str.charAt(i4)) {
                    }
                }
                return true;
            }
            this.f253f++;
            this.f254g = i3 + 1;
            this.f251d++;
        }
    }

    private void k0() {
        char c3;
        do {
            if (this.f251d >= this.f252e && !L(1)) {
                return;
            }
            char[] cArr = this.f250c;
            int i3 = this.f251d;
            int i4 = i3 + 1;
            this.f251d = i4;
            c3 = cArr[i3];
            if (c3 == '\n') {
                this.f253f++;
                this.f254g = i4;
                return;
            }
        } while (c3 != '\r');
    }

    private void l0() throws IOException {
        do {
            int i3 = 0;
            while (true) {
                int i4 = this.f251d;
                if (i4 + i3 < this.f252e) {
                    char c3 = this.f250c[i4 + i3];
                    if (c3 != '\t' && c3 != '\n' && c3 != '\f' && c3 != '\r' && c3 != ' ') {
                        if (c3 != '#') {
                            if (c3 != ',') {
                                if (c3 != '/' && c3 != '=') {
                                    if (c3 != '{' && c3 != '}' && c3 != ':') {
                                        if (c3 != ';') {
                                            switch (c3) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i3++;
                                                    break;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        y();
                    }
                    this.f251d += i3;
                    return;
                }
                this.f251d = i4 + i3;
            }
        } while (L(1));
    }

    private IOException n0(String str) throws d {
        throw new d(str + R());
    }

    private void y() throws IOException {
        if (!this.f249b) {
            throw n0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    public String E() {
        return M(false);
    }

    int I() throws IOException {
        int iX;
        int[] iArr = this.f259l;
        int i3 = this.f260m;
        int i4 = iArr[i3 - 1];
        if (i4 == 1) {
            iArr[i3 - 1] = 2;
        } else if (i4 == 2) {
            int iX2 = X(true);
            if (iX2 != 44) {
                if (iX2 != 59) {
                    if (iX2 != 93) {
                        throw n0("Unterminated array");
                    }
                    this.f255h = 4;
                    return 4;
                }
                y();
            }
        } else {
            if (i4 == 3 || i4 == 5) {
                iArr[i3 - 1] = 4;
                if (i4 == 5 && (iX = X(true)) != 44) {
                    if (iX != 59) {
                        if (iX != 125) {
                            throw n0("Unterminated object");
                        }
                        this.f255h = 2;
                        return 2;
                    }
                    y();
                }
                int iX3 = X(true);
                if (iX3 == 34) {
                    this.f255h = 13;
                    return 13;
                }
                if (iX3 == 39) {
                    y();
                    this.f255h = 12;
                    return 12;
                }
                if (iX3 == 125) {
                    if (i4 == 5) {
                        throw n0("Expected name");
                    }
                    this.f255h = 2;
                    return 2;
                }
                y();
                this.f251d--;
                if (!Q((char) iX3)) {
                    throw n0("Expected name");
                }
                this.f255h = 14;
                return 14;
            }
            if (i4 == 4) {
                iArr[i3 - 1] = 5;
                int iX4 = X(true);
                if (iX4 != 58) {
                    if (iX4 != 61) {
                        throw n0("Expected ':'");
                    }
                    y();
                    if (this.f251d < this.f252e || L(1)) {
                        char[] cArr = this.f250c;
                        int i5 = this.f251d;
                        if (cArr[i5] == '>') {
                            this.f251d = i5 + 1;
                        }
                    }
                }
            } else if (i4 == 6) {
                if (this.f249b) {
                    G();
                }
                this.f259l[this.f260m - 1] = 7;
            } else if (i4 == 7) {
                if (X(false) == -1) {
                    this.f255h = 17;
                    return 17;
                }
                y();
                this.f251d--;
            } else if (i4 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iX5 = X(true);
        if (iX5 == 34) {
            this.f255h = 9;
            return 9;
        }
        if (iX5 == 39) {
            y();
            this.f255h = 8;
            return 8;
        }
        if (iX5 != 44 && iX5 != 59) {
            if (iX5 == 91) {
                this.f255h = 3;
                return 3;
            }
            if (iX5 != 93) {
                if (iX5 == 123) {
                    this.f255h = 1;
                    return 1;
                }
                this.f251d--;
                int iD0 = d0();
                if (iD0 != 0) {
                    return iD0;
                }
                int iE0 = e0();
                if (iE0 != 0) {
                    return iE0;
                }
                if (!Q(this.f250c[this.f251d])) {
                    throw n0("Expected value");
                }
                y();
                this.f255h = 10;
                return 10;
            }
            if (i4 == 1) {
                this.f255h = 4;
                return 4;
            }
        }
        if (i4 != 1 && i4 != 2) {
            throw n0("Unexpected value");
        }
        y();
        this.f251d--;
        this.f255h = 7;
        return 7;
    }

    public void J() throws IOException {
        int I2 = this.f255h;
        if (I2 == 0) {
            I2 = I();
        }
        if (I2 != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + c0() + R());
        }
        int i3 = this.f260m;
        this.f260m = i3 - 1;
        int[] iArr = this.f262o;
        int i4 = i3 - 2;
        iArr[i4] = iArr[i4] + 1;
        this.f255h = 0;
    }

    public void K() throws IOException {
        int I2 = this.f255h;
        if (I2 == 0) {
            I2 = I();
        }
        if (I2 != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + c0() + R());
        }
        int i3 = this.f260m;
        int i4 = i3 - 1;
        this.f260m = i4;
        this.f261n[i4] = null;
        int[] iArr = this.f262o;
        int i5 = i3 - 2;
        iArr[i5] = iArr[i5] + 1;
        this.f255h = 0;
    }

    public String N() {
        return M(true);
    }

    public boolean O() throws IOException {
        int I2 = this.f255h;
        if (I2 == 0) {
            I2 = I();
        }
        return (I2 == 2 || I2 == 4 || I2 == 17) ? false : true;
    }

    public final boolean P() {
        return this.f249b;
    }

    String R() {
        return " at line " + (this.f253f + 1) + " column " + ((this.f251d - this.f254g) + 1) + " path " + E();
    }

    public boolean S() throws IOException {
        int I2 = this.f255h;
        if (I2 == 0) {
            I2 = I();
        }
        if (I2 == 5) {
            this.f255h = 0;
            int[] iArr = this.f262o;
            int i3 = this.f260m - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        }
        if (I2 == 6) {
            this.f255h = 0;
            int[] iArr2 = this.f262o;
            int i4 = this.f260m - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + c0() + R());
    }

    public double T() throws IOException {
        int I2 = this.f255h;
        if (I2 == 0) {
            I2 = I();
        }
        if (I2 == 15) {
            this.f255h = 0;
            int[] iArr = this.f262o;
            int i3 = this.f260m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f256i;
        }
        if (I2 == 16) {
            this.f258k = new String(this.f250c, this.f251d, this.f257j);
            this.f251d += this.f257j;
        } else if (I2 == 8 || I2 == 9) {
            this.f258k = Z(I2 == 8 ? '\'' : '\"');
        } else if (I2 == 10) {
            this.f258k = b0();
        } else if (I2 != 11) {
            throw new IllegalStateException("Expected a double but was " + c0() + R());
        }
        this.f255h = 11;
        double d3 = Double.parseDouble(this.f258k);
        if (!this.f249b && (Double.isNaN(d3) || Double.isInfinite(d3))) {
            throw new d("JSON forbids NaN and infinities: " + d3 + R());
        }
        this.f258k = null;
        this.f255h = 0;
        int[] iArr2 = this.f262o;
        int i4 = this.f260m - 1;
        iArr2[i4] = iArr2[i4] + 1;
        return d3;
    }

    public int U() throws IOException {
        int I2 = this.f255h;
        if (I2 == 0) {
            I2 = I();
        }
        if (I2 == 15) {
            long j3 = this.f256i;
            int i3 = (int) j3;
            if (j3 == i3) {
                this.f255h = 0;
                int[] iArr = this.f262o;
                int i4 = this.f260m - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.f256i + R());
        }
        if (I2 == 16) {
            this.f258k = new String(this.f250c, this.f251d, this.f257j);
            this.f251d += this.f257j;
        } else {
            if (I2 != 8 && I2 != 9 && I2 != 10) {
                throw new IllegalStateException("Expected an int but was " + c0() + R());
            }
            if (I2 == 10) {
                this.f258k = b0();
            } else {
                this.f258k = Z(I2 == 8 ? '\'' : '\"');
            }
            try {
                int i5 = Integer.parseInt(this.f258k);
                this.f255h = 0;
                int[] iArr2 = this.f262o;
                int i6 = this.f260m - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return i5;
            } catch (NumberFormatException unused) {
            }
        }
        this.f255h = 11;
        double d3 = Double.parseDouble(this.f258k);
        int i7 = (int) d3;
        if (i7 != d3) {
            throw new NumberFormatException("Expected an int but was " + this.f258k + R());
        }
        this.f258k = null;
        this.f255h = 0;
        int[] iArr3 = this.f262o;
        int i8 = this.f260m - 1;
        iArr3[i8] = iArr3[i8] + 1;
        return i7;
    }

    public long V() throws IOException {
        int I2 = this.f255h;
        if (I2 == 0) {
            I2 = I();
        }
        if (I2 == 15) {
            this.f255h = 0;
            int[] iArr = this.f262o;
            int i3 = this.f260m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f256i;
        }
        if (I2 == 16) {
            this.f258k = new String(this.f250c, this.f251d, this.f257j);
            this.f251d += this.f257j;
        } else {
            if (I2 != 8 && I2 != 9 && I2 != 10) {
                throw new IllegalStateException("Expected a long but was " + c0() + R());
            }
            if (I2 == 10) {
                this.f258k = b0();
            } else {
                this.f258k = Z(I2 == 8 ? '\'' : '\"');
            }
            try {
                long j3 = Long.parseLong(this.f258k);
                this.f255h = 0;
                int[] iArr2 = this.f262o;
                int i4 = this.f260m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return j3;
            } catch (NumberFormatException unused) {
            }
        }
        this.f255h = 11;
        double d3 = Double.parseDouble(this.f258k);
        long j4 = (long) d3;
        if (j4 != d3) {
            throw new NumberFormatException("Expected a long but was " + this.f258k + R());
        }
        this.f258k = null;
        this.f255h = 0;
        int[] iArr3 = this.f262o;
        int i5 = this.f260m - 1;
        iArr3[i5] = iArr3[i5] + 1;
        return j4;
    }

    public String W() throws IOException {
        String strZ;
        int I2 = this.f255h;
        if (I2 == 0) {
            I2 = I();
        }
        if (I2 == 14) {
            strZ = b0();
        } else if (I2 == 12) {
            strZ = Z('\'');
        } else {
            if (I2 != 13) {
                throw new IllegalStateException("Expected a name but was " + c0() + R());
            }
            strZ = Z('\"');
        }
        this.f255h = 0;
        this.f261n[this.f260m - 1] = strZ;
        return strZ;
    }

    public void Y() throws IOException {
        int I2 = this.f255h;
        if (I2 == 0) {
            I2 = I();
        }
        if (I2 == 7) {
            this.f255h = 0;
            int[] iArr = this.f262o;
            int i3 = this.f260m - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + c0() + R());
    }

    public String a0() throws IOException {
        String str;
        int I2 = this.f255h;
        if (I2 == 0) {
            I2 = I();
        }
        if (I2 == 10) {
            str = b0();
        } else if (I2 == 8) {
            str = Z('\'');
        } else if (I2 == 9) {
            str = Z('\"');
        } else if (I2 == 11) {
            str = this.f258k;
            this.f258k = null;
        } else if (I2 == 15) {
            str = Long.toString(this.f256i);
        } else {
            if (I2 != 16) {
                throw new IllegalStateException("Expected a string but was " + c0() + R());
            }
            str = new String(this.f250c, this.f251d, this.f257j);
            this.f251d += this.f257j;
        }
        this.f255h = 0;
        int[] iArr = this.f262o;
        int i3 = this.f260m - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public b c0() throws IOException {
        int I2 = this.f255h;
        if (I2 == 0) {
            I2 = I();
        }
        switch (I2) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f255h = 0;
        this.f259l[0] = 8;
        this.f260m = 1;
        this.f248a.close();
    }

    public void g() throws IOException {
        int I2 = this.f255h;
        if (I2 == 0) {
            I2 = I();
        }
        if (I2 == 3) {
            f0(1);
            this.f262o[this.f260m - 1] = 0;
            this.f255h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + c0() + R());
        }
    }

    public final void h0(boolean z3) {
        this.f249b = z3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void m0() throws IOException {
        int i3 = 0;
        do {
            int I2 = this.f255h;
            if (I2 == 0) {
                I2 = I();
            }
            switch (I2) {
                case 1:
                    f0(3);
                    i3++;
                    this.f255h = 0;
                    break;
                case 2:
                    if (i3 == 0) {
                        this.f261n[this.f260m - 1] = null;
                    }
                    this.f260m--;
                    i3--;
                    this.f255h = 0;
                    break;
                case 3:
                    f0(1);
                    i3++;
                    this.f255h = 0;
                    break;
                case 4:
                    this.f260m--;
                    i3--;
                    this.f255h = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f255h = 0;
                    break;
                case 8:
                    i0('\'');
                    this.f255h = 0;
                    break;
                case 9:
                    i0('\"');
                    this.f255h = 0;
                    break;
                case 10:
                    l0();
                    this.f255h = 0;
                    break;
                case 12:
                    i0('\'');
                    if (i3 == 0) {
                        this.f261n[this.f260m - 1] = "<skipped>";
                    }
                    this.f255h = 0;
                    break;
                case 13:
                    i0('\"');
                    if (i3 == 0) {
                        this.f261n[this.f260m - 1] = "<skipped>";
                    }
                    this.f255h = 0;
                    break;
                case 14:
                    l0();
                    if (i3 == 0) {
                        this.f261n[this.f260m - 1] = "<skipped>";
                    }
                    this.f255h = 0;
                    break;
                case 16:
                    this.f251d += this.f257j;
                    this.f255h = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i3 > 0);
        int[] iArr = this.f262o;
        int i4 = this.f260m - 1;
        iArr[i4] = iArr[i4] + 1;
    }

    public void t() throws IOException {
        int I2 = this.f255h;
        if (I2 == 0) {
            I2 = I();
        }
        if (I2 == 1) {
            f0(3);
            this.f255h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + c0() + R());
        }
    }

    public String toString() {
        return getClass().getSimpleName() + R();
    }
}
