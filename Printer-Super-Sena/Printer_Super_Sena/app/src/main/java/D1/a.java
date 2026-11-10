package D1;

import java.lang.reflect.Type;
import java.util.Objects;
import p081y1.b;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f195c;

    private a(Type type) {
        Objects.requireNonNull(type);
        Type typeB = b.b(type);
        this.f194b = typeB;
        this.f193a = b.k(typeB);
        this.f195c = typeB.hashCode();
    }

    public static a a(Class cls) {
        return new a(cls);
    }

    public static a b(Type type) {
        return new a(type);
    }

    public final Class c() {
        return this.f193a;
    }

    public final Type d() {
        return this.f194b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.f(this.f194b, ((a) obj).f194b);
    }

    public final int hashCode() {
        return this.f195c;
    }

    public final String toString() {
        return b.t(this.f194b);
    }
}
