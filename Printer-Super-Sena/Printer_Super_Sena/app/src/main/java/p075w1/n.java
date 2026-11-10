package p075w1;

import java.math.BigInteger;
import java.util.Objects;
import p081y1.g;

/* JADX INFO: loaded from: classes.dex */
public final class n extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f12685a;

    public n(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f12685a = bool;
    }

    private static boolean x(n nVar) {
        Object obj = nVar.f12685a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f12685a == null) {
            return nVar.f12685a == null;
        }
        if (x(this) && x(nVar)) {
            return u().longValue() == nVar.u().longValue();
        }
        Object obj2 = this.f12685a;
        if (!(obj2 instanceof Number) || !(nVar.f12685a instanceof Number)) {
            return obj2.equals(nVar.f12685a);
        }
        double dDoubleValue = u().doubleValue();
        double dDoubleValue2 = nVar.u().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f12685a == null) {
            return 31;
        }
        if (x(this)) {
            jDoubleToLongBits = u().longValue();
        } else {
            Object obj = this.f12685a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(u().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public boolean q() {
        return w() ? ((Boolean) this.f12685a).booleanValue() : Boolean.parseBoolean(v());
    }

    public double r() {
        return y() ? u().doubleValue() : Double.parseDouble(v());
    }

    public int s() {
        return y() ? u().intValue() : Integer.parseInt(v());
    }

    public long t() {
        return y() ? u().longValue() : Long.parseLong(v());
    }

    public Number u() {
        Object obj = this.f12685a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new g((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public String v() {
        Object obj = this.f12685a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (y()) {
            return u().toString();
        }
        if (w()) {
            return ((Boolean) this.f12685a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f12685a.getClass());
    }

    public boolean w() {
        return this.f12685a instanceof Boolean;
    }

    public boolean y() {
        return this.f12685a instanceof Number;
    }

    public boolean z() {
        return this.f12685a instanceof String;
    }

    public n(Number number) {
        Objects.requireNonNull(number);
        this.f12685a = number;
    }

    public n(String str) {
        Objects.requireNonNull(str);
        this.f12685a = str;
    }
}
