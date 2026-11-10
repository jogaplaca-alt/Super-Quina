package p075w1;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements p075w1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f12621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f12622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f12623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f12624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f12625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f12626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ b[] f12627h;

    final enum a extends b {
        a(String str, int i3) {
            super(str, i3, null);
        }

        @Override // p075w1.c
        public String a(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        f12620a = aVar;
        b bVar = new b("UPPER_CAMEL_CASE", 1) { // from class: w1.b.b
            {
                a aVar2 = null;
            }

            @Override // p075w1.c
            public String a(Field field) {
                return b.c(field.getName());
            }
        };
        f12621b = bVar;
        b bVar2 = new b("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: w1.b.c
            {
                a aVar2 = null;
            }

            @Override // p075w1.c
            public String a(Field field) {
                return b.c(b.b(field.getName(), ' '));
            }
        };
        f12622c = bVar2;
        b bVar3 = new b("UPPER_CASE_WITH_UNDERSCORES", 3) { // from class: w1.b.d
            {
                a aVar2 = null;
            }

            @Override // p075w1.c
            public String a(Field field) {
                return b.b(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        };
        f12623d = bVar3;
        b bVar4 = new b("LOWER_CASE_WITH_UNDERSCORES", 4) { // from class: w1.b.e
            {
                a aVar2 = null;
            }

            @Override // p075w1.c
            public String a(Field field) {
                return b.b(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        };
        f12624e = bVar4;
        b bVar5 = new b("LOWER_CASE_WITH_DASHES", 5) { // from class: w1.b.f
            {
                a aVar2 = null;
            }

            @Override // p075w1.c
            public String a(Field field) {
                return b.b(field.getName(), '-').toLowerCase(Locale.ENGLISH);
            }
        };
        f12625f = bVar5;
        b bVar6 = new b("LOWER_CASE_WITH_DOTS", 6) { // from class: w1.b.g
            {
                a aVar2 = null;
            }

            @Override // p075w1.c
            public String a(Field field) {
                return b.b(field.getName(), '.').toLowerCase(Locale.ENGLISH);
            }
        };
        f12626g = bVar6;
        f12627h = new b[]{aVar, bVar, bVar2, bVar3, bVar4, bVar5, bVar6};
    }

    private b(String str, int i3) {
        super(str, i3);
    }

    static String b(String str, char c3) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c3);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    static String c(String str) {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (Character.isLetter(cCharAt)) {
                if (Character.isUpperCase(cCharAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                if (i3 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i3) + upperCase + str.substring(i3 + 1);
            }
        }
        return str;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f12627h.clone();
    }

    /* synthetic */ b(String str, int i3, a aVar) {
        this(str, i3);
    }
}
