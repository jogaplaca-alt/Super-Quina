package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final q f4539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f4540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f4541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final a f4542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final a f4543h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q f4546c;

    /* JADX INFO: renamed from: androidx.core.text.a$a, reason: collision with other inner class name */
    public static final class C0057a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f4547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private q f4549c;

        public C0057a() {
            c(a.e(Locale.getDefault()));
        }

        private static a b(boolean z3) {
            return z3 ? a.f4543h : a.f4542g;
        }

        private void c(boolean z3) {
            this.f4547a = z3;
            this.f4549c = a.f4539d;
            this.f4548b = 2;
        }

        public a a() {
            return (this.f4548b == 2 && this.f4549c == a.f4539d) ? b(this.f4547a) : new a(this.f4547a, this.f4548b, this.f4549c);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final byte[] f4550f = new byte[1792];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CharSequence f4551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f4552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f4553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f4554d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private char f4555e;

        static {
            for (int i3 = 0; i3 < 1792; i3++) {
                f4550f[i3] = Character.getDirectionality(i3);
            }
        }

        b(CharSequence charSequence, boolean z3) {
            this.f4551a = charSequence;
            this.f4552b = z3;
            this.f4553c = charSequence.length();
        }

        private static byte c(char c3) {
            return c3 < 1792 ? f4550f[c3] : Character.getDirectionality(c3);
        }

        private byte f() {
            char cCharAt;
            int i3 = this.f4554d;
            do {
                int i4 = this.f4554d;
                if (i4 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f4551a;
                int i5 = i4 - 1;
                this.f4554d = i5;
                cCharAt = charSequence.charAt(i5);
                this.f4555e = cCharAt;
                if (cCharAt == '&') {
                    return (byte) 12;
                }
            } while (cCharAt != ';');
            this.f4554d = i3;
            this.f4555e = ';';
            return (byte) 13;
        }

        private byte g() {
            char cCharAt;
            do {
                int i3 = this.f4554d;
                if (i3 >= this.f4553c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f4551a;
                this.f4554d = i3 + 1;
                cCharAt = charSequence.charAt(i3);
                this.f4555e = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char cCharAt;
            int i3 = this.f4554d;
            while (true) {
                int i4 = this.f4554d;
                if (i4 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f4551a;
                int i5 = i4 - 1;
                this.f4554d = i5;
                char cCharAt2 = charSequence.charAt(i5);
                this.f4555e = cCharAt2;
                if (cCharAt2 == '<') {
                    return (byte) 12;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i6 = this.f4554d;
                        if (i6 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f4551a;
                        int i7 = i6 - 1;
                        this.f4554d = i7;
                        cCharAt = charSequence2.charAt(i7);
                        this.f4555e = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
            this.f4554d = i3;
            this.f4555e = '>';
            return (byte) 13;
        }

        private byte i() {
            char cCharAt;
            int i3 = this.f4554d;
            while (true) {
                int i4 = this.f4554d;
                if (i4 >= this.f4553c) {
                    this.f4554d = i3;
                    this.f4555e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f4551a;
                this.f4554d = i4 + 1;
                char cCharAt2 = charSequence.charAt(i4);
                this.f4555e = cCharAt2;
                if (cCharAt2 == '>') {
                    return (byte) 12;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i5 = this.f4554d;
                        if (i5 >= this.f4553c) {
                            break;
                        }
                        CharSequence charSequence2 = this.f4551a;
                        this.f4554d = i5 + 1;
                        cCharAt = charSequence2.charAt(i5);
                        this.f4555e = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
        }

        byte a() {
            char cCharAt = this.f4551a.charAt(this.f4554d - 1);
            this.f4555e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.f4551a, this.f4554d);
                this.f4554d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f4554d--;
            byte bC = c(this.f4555e);
            if (!this.f4552b) {
                return bC;
            }
            char c3 = this.f4555e;
            if (c3 == '>') {
                return h();
            }
            return c3 == ';' ? f() : bC;
        }

        byte b() {
            char cCharAt = this.f4551a.charAt(this.f4554d);
            this.f4555e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.f4551a, this.f4554d);
                this.f4554d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f4554d++;
            byte bC = c(this.f4555e);
            if (!this.f4552b) {
                return bC;
            }
            char c3 = this.f4555e;
            if (c3 == '<') {
                return i();
            }
            return c3 == '&' ? g() : bC;
        }

        int d() {
            this.f4554d = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (this.f4554d < this.f4553c && i3 == 0) {
                byte b3 = b();
                if (b3 != 0) {
                    if (b3 == 1 || b3 == 2) {
                        if (i5 == 0) {
                            return 1;
                        }
                    } else if (b3 != 9) {
                        switch (b3) {
                            case 14:
                            case 15:
                                i5++;
                                i4 = -1;
                                continue;
                            case 16:
                            case 17:
                                i5++;
                                i4 = 1;
                                continue;
                            case 18:
                                i5--;
                                i4 = 0;
                                continue;
                        }
                    }
                } else if (i5 == 0) {
                    return -1;
                }
                i3 = i5;
            }
            if (i3 == 0) {
                return 0;
            }
            if (i4 != 0) {
                return i4;
            }
            while (this.f4554d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i3 == i5) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i3 == i5) {
                            return 1;
                        }
                        break;
                    case 18:
                        i5++;
                        continue;
                    default:
                        continue;
                }
                i5--;
            }
            return 0;
        }

        int e() {
            this.f4554d = this.f4553c;
            int i3 = 0;
            int i4 = 0;
            while (this.f4554d > 0) {
                byte bA = a();
                if (bA == 0) {
                    if (i3 == 0) {
                        return -1;
                    }
                    if (i4 == 0) {
                        i4 = i3;
                    }
                } else if (bA == 1 || bA == 2) {
                    if (i3 == 0) {
                        return 1;
                    }
                    if (i4 == 0) {
                        i4 = i3;
                    }
                } else if (bA != 9) {
                    switch (bA) {
                        case 14:
                        case 15:
                            if (i4 == i3) {
                                return -1;
                            }
                            i3--;
                            break;
                        case 16:
                        case 17:
                            if (i4 == i3) {
                                return 1;
                            }
                            i3--;
                            break;
                        case 18:
                            i3++;
                            break;
                        default:
                            if (i4 == 0) {
                                i4 = i3;
                            }
                            break;
                    }
                } else {
                    continue;
                }
            }
            return 0;
        }
    }

    static {
        q qVar = r.f4569c;
        f4539d = qVar;
        f4540e = Character.toString((char) 8206);
        f4541f = Character.toString((char) 8207);
        f4542g = new a(false, 2, qVar);
        f4543h = new a(true, 2, qVar);
    }

    a(boolean z3, int i3, q qVar) {
        this.f4544a = z3;
        this.f4545b = i3;
        this.f4546c = qVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0057a().a();
    }

    static boolean e(Locale locale) {
        return s.a(locale) == 1;
    }

    private String f(CharSequence charSequence, q qVar) {
        boolean zA = qVar.a(charSequence, 0, charSequence.length());
        if (!this.f4544a && (zA || b(charSequence) == 1)) {
            return f4540e;
        }
        if (this.f4544a) {
            return (!zA || b(charSequence) == -1) ? f4541f : "";
        }
        return "";
    }

    private String g(CharSequence charSequence, q qVar) {
        boolean zA = qVar.a(charSequence, 0, charSequence.length());
        if (!this.f4544a && (zA || a(charSequence) == 1)) {
            return f4540e;
        }
        if (this.f4544a) {
            return (!zA || a(charSequence) == -1) ? f4541f : "";
        }
        return "";
    }

    public boolean d() {
        return (this.f4545b & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f4546c, true);
    }

    public CharSequence i(CharSequence charSequence, q qVar, boolean z3) {
        if (charSequence == null) {
            return null;
        }
        boolean zA = qVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z3) {
            spannableStringBuilder.append((CharSequence) g(charSequence, zA ? r.f4568b : r.f4567a));
        }
        if (zA != this.f4544a) {
            spannableStringBuilder.append(zA ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z3) {
            spannableStringBuilder.append((CharSequence) f(charSequence, zA ? r.f4568b : r.f4567a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f4546c, true);
    }

    public String k(String str, q qVar, boolean z3) {
        if (str == null) {
            return null;
        }
        return i(str, qVar, z3).toString();
    }
}
