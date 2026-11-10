package E2;

/* JADX INFO: renamed from: E2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0197m extends Q {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final String[] f592A = {"%U", "$A", "$B", "$C", "$D", "$E", "$F", "$G", "$H", "$I", "$J", "$K", "$L", "$M", "$N", "$O", "$P", "$Q", "$R", "$S", "$T", "$U", "$V", "$W", "$X", "$Y", "$Z", "%A", "%B", "%C", "%D", "%E", " ", "/A", "/B", "/C", "/D", "/E", "/F", "/G", "/H", "/I", "/J", "/K", "/L", "-", ".", "/O", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "/Z", "%F", "%G", "%H", "%I", "%J", "%V", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "%K", "%L", "%M", "%N", "%O", "%W", "+A", "+B", "+C", "+D", "+E", "+F", "+G", "+H", "+I", "+J", "+K", "+L", "+M", "+N", "+O", "+P", "+Q", "+R", "+S", "+T", "+U", "+V", "+W", "+X", "+Y", "+Z", "%P", "%Q", "%R", "%S", "%T"};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private a f593z = a.NONE;

    /* JADX INFO: renamed from: E2.m$a */
    public enum a {
        NONE,
        MOD43
    }

    @Override // E2.Q
    protected void c() {
        int length = this.f413l.length();
        C0196l c0196l = new C0196l();
        if (this.f593z == a.MOD43) {
            c0196l.L(C0196l.a.MOD43);
        }
        if (!this.f413l.matches("[\u0000-\u007f]+")) {
            throw new H("Invalid characters in input data");
        }
        String str = "";
        for (int i3 = 0; i3 < length; i3++) {
            str = str + f592A[this.f413l.charAt(i3)];
        }
        c0196l.C(str);
        this.f416o = this.f413l;
        this.f417p = new String[]{c0196l.f417p[0]};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }
}
