package G2;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static void a(StringBuilder sb, int i3, int i4) {
        int i5 = 1 << (i4 - 1);
        for (int i6 = 0; i6 < i4; i6++) {
            if (((i5 >> i6) & i3) == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
    }
}
