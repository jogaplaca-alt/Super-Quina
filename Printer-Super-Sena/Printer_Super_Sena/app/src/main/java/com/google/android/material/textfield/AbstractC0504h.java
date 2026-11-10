package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: renamed from: com.google.android.material.textfield.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0504h extends p042l1.g {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    b f8648z;

    /* JADX INFO: renamed from: com.google.android.material.textfield.h$c */
    private static class c extends AbstractC0504h {
        c(b bVar) {
            super(bVar);
        }

        @Override // p042l1.g
        protected void r(Canvas canvas) {
            if (this.f8648z.f8649w.isEmpty()) {
                super.r(canvas);
                return;
            }
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutRect(this.f8648z.f8649w);
            } else {
                canvas.clipRect(this.f8648z.f8649w, Region.Op.DIFFERENCE);
            }
            super.r(canvas);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AbstractC0504h h0(b bVar) {
        return new c(bVar);
    }

    static AbstractC0504h i0(p042l1.k kVar) {
        if (kVar == null) {
            kVar = new p042l1.k();
        }
        return h0(new b(kVar, new RectF()));
    }

    boolean j0() {
        return !this.f8648z.f8649w.isEmpty();
    }

    void k0() {
        l0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void l0(float f3, float f4, float f5, float f6) {
        if (f3 == this.f8648z.f8649w.left && f4 == this.f8648z.f8649w.top && f5 == this.f8648z.f8649w.right && f6 == this.f8648z.f8649w.bottom) {
            return;
        }
        this.f8648z.f8649w.set(f3, f4, f5, f6);
        invalidateSelf();
    }

    void m0(RectF rectF) {
        l0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // p042l1.g, android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f8648z = new b(this.f8648z);
        return this;
    }

    /* JADX INFO: renamed from: com.google.android.material.textfield.h$b */
    private static final class b extends l1.g.c {

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final RectF f8649w;

        @Override // l1.g.c, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            AbstractC0504h abstractC0504hH0 = AbstractC0504h.h0(this);
            abstractC0504hH0.invalidateSelf();
            return abstractC0504hH0;
        }

        private b(p042l1.k kVar, RectF rectF) {
            super(kVar, null);
            this.f8649w = rectF;
        }

        private b(b bVar) {
            super(bVar);
            this.f8649w = bVar.f8649w;
        }
    }

    private AbstractC0504h(b bVar) {
        super(bVar);
        this.f8648z = bVar;
    }
}
