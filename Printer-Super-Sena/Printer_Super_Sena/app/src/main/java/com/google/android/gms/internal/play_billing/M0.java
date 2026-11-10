package com.google.android.gms.internal.play_billing;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes.dex */
public final class M0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final M0 f7349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final M0 f7350e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final M0 f7351f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final M0 f7352g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final M0 f7353h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final M0 f7354i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final M0 f7355j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final M0 f7356k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final M0 f7357l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final M0 f7358m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final /* synthetic */ M0[] f7359n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f7360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f7361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f7362c;

    static {
        M0 m3 = new M0("VOID", 0, Void.class, Void.class, null);
        f7349d = m3;
        Class cls = Integer.TYPE;
        M0 m4 = new M0("INT", 1, cls, Integer.class, 0);
        f7350e = m4;
        M0 m5 = new M0("LONG", 2, Long.TYPE, Long.class, 0L);
        f7351f = m5;
        M0 m6 = new M0("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f7352g = m6;
        M0 m7 = new M0("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f7353h = m7;
        M0 m8 = new M0("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f7354i = m8;
        M0 m9 = new M0("STRING", 6, String.class, String.class, "");
        f7355j = m9;
        M0 m10 = new M0("BYTE_STRING", 7, AbstractC0421f0.class, AbstractC0421f0.class, AbstractC0421f0.f7421b);
        f7356k = m10;
        M0 m11 = new M0("ENUM", 8, cls, Integer.class, null);
        f7357l = m11;
        M0 m12 = new M0("MESSAGE", 9, Object.class, Object.class, null);
        f7358m = m12;
        f7359n = new M0[]{m3, m4, m5, m6, m7, m8, m9, m10, m11, m12};
    }

    private M0(String str, int i3, Class cls, Class cls2, Object obj) {
        super(str, i3);
        this.f7360a = cls;
        this.f7361b = cls2;
        this.f7362c = obj;
    }

    public static M0[] values() {
        return (M0[]) f7359n.clone();
    }

    public final Class a() {
        return this.f7361b;
    }
}
