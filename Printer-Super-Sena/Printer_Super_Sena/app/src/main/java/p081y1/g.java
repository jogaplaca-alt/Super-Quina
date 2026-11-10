package p081y1;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class g extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12860a;

    public g(String str) {
        this.f12860a = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f12860a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        String str = this.f12860a;
        String str2 = ((g) obj).f12860a;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f12860a);
    }

    public int hashCode() {
        return this.f12860a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f12860a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f12860a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f12860a).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f12860a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f12860a).longValue();
        }
    }

    public String toString() {
        return this.f12860a;
    }
}
