package p075w1;

import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Field f12619a;

    public a(Field field) {
        Objects.requireNonNull(field);
        this.f12619a = field;
    }

    public String toString() {
        return this.f12619a.toString();
    }
}
