package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: renamed from: androidx.transition.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0382h extends Property {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Property f6631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PathMeasure f6632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f6633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f6634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PointF f6635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f6636f;

    C0382h(Property property, Path path) {
        super(Float.class, property.getName());
        this.f6634d = new float[2];
        this.f6635e = new PointF();
        this.f6631a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f6632b = pathMeasure;
        this.f6633c = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(Object obj) {
        return Float.valueOf(this.f6636f);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(Object obj, Float f3) {
        this.f6636f = f3.floatValue();
        this.f6632b.getPosTan(this.f6633c * f3.floatValue(), this.f6634d, null);
        PointF pointF = this.f6635e;
        float[] fArr = this.f6634d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f6631a.set(obj, pointF);
    }
}
