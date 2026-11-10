package E1;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f274j = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f275k = new String[128];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f276l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Writer f277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f278b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f279c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f285i;

    static {
        for (int i3 = 0; i3 <= 31; i3++) {
            f275k[i3] = String.format("\\u%04x", Integer.valueOf(i3));
        }
        String[] strArr = f275k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f276l = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        U(6);
        this.f281e = ":";
        this.f285i = true;
        Objects.requireNonNull(writer, "out == null");
        this.f277a = writer;
    }

    private c I(int i3, int i4, char c3) throws IOException {
        int iT = T();
        if (iT != i4 && iT != i3) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f284h != null) {
            throw new IllegalStateException("Dangling name: " + this.f284h);
        }
        this.f279c--;
        if (iT == i4) {
            Q();
        }
        this.f277a.write(c3);
        return this;
    }

    private static boolean O(Class cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    private void Q() throws IOException {
        if (this.f280d == null) {
            return;
        }
        this.f277a.write(10);
        int i3 = this.f279c;
        for (int i4 = 1; i4 < i3; i4++) {
            this.f277a.write(this.f280d);
        }
    }

    private c S(int i3, char c3) throws IOException {
        t();
        U(i3);
        this.f277a.write(c3);
        return this;
    }

    private int T() {
        int i3 = this.f279c;
        if (i3 != 0) {
            return this.f278b[i3 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void U(int i3) {
        int i4 = this.f279c;
        int[] iArr = this.f278b;
        if (i4 == iArr.length) {
            this.f278b = Arrays.copyOf(iArr, i4 * 2);
        }
        int[] iArr2 = this.f278b;
        int i5 = this.f279c;
        this.f279c = i5 + 1;
        iArr2[i5] = i3;
    }

    private void V(int i3) {
        this.f278b[this.f279c - 1] = i3;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    private void a0(String str) throws IOException {
        String str2;
        String[] strArr = this.f283g ? f276l : f275k;
        this.f277a.write(34);
        int length = str.length();
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i3 < i4) {
                        this.f277a.write(str, i3, i4 - i3);
                    }
                    this.f277a.write(str2);
                    i3 = i4 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i3 < i4) {
                    this.f277a.write(str, i3, i4 - i3);
                }
                this.f277a.write(str2);
                i3 = i4 + 1;
            }
        }
        if (i3 < length) {
            this.f277a.write(str, i3, length - i3);
        }
        this.f277a.write(34);
    }

    private void g() throws IOException {
        int iT = T();
        if (iT == 5) {
            this.f277a.write(44);
        } else if (iT != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        Q();
        V(4);
    }

    private void h0() throws IOException {
        if (this.f284h != null) {
            g();
            a0(this.f284h);
            this.f284h = null;
        }
    }

    private void t() throws IOException {
        int iT = T();
        if (iT == 1) {
            V(2);
            Q();
            return;
        }
        if (iT == 2) {
            this.f277a.append(',');
            Q();
        } else {
            if (iT == 4) {
                this.f277a.append((CharSequence) this.f281e);
                V(5);
                return;
            }
            if (iT != 6) {
                if (iT != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f282f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            V(7);
        }
    }

    public c G() throws IOException {
        h0();
        return S(3, '{');
    }

    public c J() {
        return I(1, 2, ']');
    }

    public c K() {
        return I(3, 5, '}');
    }

    public final boolean L() {
        return this.f285i;
    }

    public final boolean M() {
        return this.f283g;
    }

    public boolean N() {
        return this.f282f;
    }

    public c P(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f284h != null) {
            throw new IllegalStateException();
        }
        if (this.f279c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f284h = str;
        return this;
    }

    public c R() throws IOException {
        if (this.f284h != null) {
            if (!this.f285i) {
                this.f284h = null;
                return this;
            }
            h0();
        }
        t();
        this.f277a.write("null");
        return this;
    }

    public final void W(boolean z3) {
        this.f283g = z3;
    }

    public final void X(String str) {
        if (str.length() == 0) {
            this.f280d = null;
            this.f281e = ":";
        } else {
            this.f280d = str;
            this.f281e = ": ";
        }
    }

    public final void Y(boolean z3) {
        this.f282f = z3;
    }

    public final void Z(boolean z3) {
        this.f285i = z3;
    }

    public c b0(double d3) throws IOException {
        h0();
        if (this.f282f || !(Double.isNaN(d3) || Double.isInfinite(d3))) {
            t();
            this.f277a.append((CharSequence) Double.toString(d3));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d3);
    }

    public c c0(long j3) throws IOException {
        h0();
        t();
        this.f277a.write(Long.toString(j3));
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f277a.close();
        int i3 = this.f279c;
        if (i3 > 1 || (i3 == 1 && this.f278b[i3 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f279c = 0;
    }

    public c d0(Boolean bool) throws IOException {
        if (bool == null) {
            return R();
        }
        h0();
        t();
        this.f277a.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c e0(Number number) throws IOException {
        if (number == null) {
            return R();
        }
        h0();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!O(cls) && !f274j.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (!this.f282f) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
        }
        t();
        this.f277a.append((CharSequence) string);
        return this;
    }

    public c f0(String str) throws IOException {
        if (str == null) {
            return R();
        }
        h0();
        t();
        a0(str);
        return this;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f279c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f277a.flush();
    }

    public c g0(boolean z3) throws IOException {
        h0();
        t();
        this.f277a.write(z3 ? "true" : "false");
        return this;
    }

    public c y() throws IOException {
        h0();
        return S(1, '[');
    }
}
