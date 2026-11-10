package G2;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f1067c = new c(-1, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Charset f1069b;

    private c(int i3, Charset charset) {
        this.f1068a = i3;
        this.f1069b = charset;
    }

    public static c a(String str, String str2, int i3) {
        try {
            Charset charsetForName = Charset.forName(str2);
            return (charsetForName.canEncode() && charsetForName.newEncoder().canEncode(str)) ? new c(i3, charsetForName) : f1067c;
        } catch (UnsupportedCharsetException unused) {
            return f1067c;
        }
    }

    public c b(String str, String str2, int i3) {
        return !equals(f1067c) ? this : a(str, str2, i3);
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && ((c) obj).f1068a == this.f1068a;
    }

    public int hashCode() {
        return Integer.valueOf(this.f1068a).hashCode();
    }

    public String toString() {
        return "EciMode[mode=" + this.f1068a + ", charset=" + this.f1069b + "]";
    }
}
