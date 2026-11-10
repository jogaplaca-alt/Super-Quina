package p042l1;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f9847a;

    public a(float f3) {
        this.f9847a = f3;
    }

    @Override // p042l1.c
    public float a(RectF rectF) {
        return this.f9847a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f9847a == ((a) obj).f9847a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f9847a)});
    }
}
