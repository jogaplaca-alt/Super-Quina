package p042l1;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f9848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f9849b;

    public b(float f3, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f9848a;
            f3 += ((b) cVar).f9849b;
        }
        this.f9848a = cVar;
        this.f9849b = f3;
    }

    @Override // p042l1.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f9848a.a(rectF) + this.f9849b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f9848a.equals(bVar.f9848a) && this.f9849b == bVar.f9849b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9848a, Float.valueOf(this.f9849b)});
    }
}
