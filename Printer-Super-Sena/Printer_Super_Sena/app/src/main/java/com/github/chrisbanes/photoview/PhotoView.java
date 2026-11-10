package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.r;
import p041l0.d;
import p041l0.e;
import p041l0.f;
import p041l0.g;
import p041l0.h;
import p041l0.i;
import p041l0.j;
import p041l0.k;

/* JADX INFO: loaded from: classes.dex */
public class PhotoView extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private k f7166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView.ScaleType f7167e;

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c() {
        this.f7166d = new k(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f7167e;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f7167e = null;
        }
    }

    public k getAttacher() {
        return this.f7166d;
    }

    public RectF getDisplayRect() {
        return this.f7166d.B();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f7166d.E();
    }

    public float getMaximumScale() {
        return this.f7166d.H();
    }

    public float getMediumScale() {
        return this.f7166d.I();
    }

    public float getMinimumScale() {
        return this.f7166d.J();
    }

    public float getScale() {
        return this.f7166d.K();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f7166d.L();
    }

    public void setAllowParentInterceptOnEdge(boolean z3) {
        this.f7166d.O(z3);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i3, int i4, int i5, int i6) {
        boolean frame = super.setFrame(i3, i4, i5, i6);
        if (frame) {
            this.f7166d.l0();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.r, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        k kVar = this.f7166d;
        if (kVar != null) {
            kVar.l0();
        }
    }

    @Override // androidx.appcompat.widget.r, android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        k kVar = this.f7166d;
        if (kVar != null) {
            kVar.l0();
        }
    }

    @Override // androidx.appcompat.widget.r, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        k kVar = this.f7166d;
        if (kVar != null) {
            kVar.l0();
        }
    }

    public void setMaximumScale(float f3) {
        this.f7166d.Q(f3);
    }

    public void setMediumScale(float f3) {
        this.f7166d.R(f3);
    }

    public void setMinimumScale(float f3) {
        this.f7166d.S(f3);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f7166d.T(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f7166d.U(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f7166d.V(onLongClickListener);
    }

    public void setOnMatrixChangeListener(d dVar) {
        this.f7166d.W(dVar);
    }

    public void setOnOutsidePhotoTapListener(e eVar) {
        this.f7166d.X(eVar);
    }

    public void setOnPhotoTapListener(f fVar) {
        this.f7166d.Y(fVar);
    }

    public void setOnScaleChangeListener(g gVar) {
        this.f7166d.Z(gVar);
    }

    public void setOnSingleFlingListener(h hVar) {
        this.f7166d.a0(hVar);
    }

    public void setOnViewDragListener(i iVar) {
        this.f7166d.b0(iVar);
    }

    public void setOnViewTapListener(j jVar) {
        this.f7166d.c0(jVar);
    }

    public void setRotationBy(float f3) {
        this.f7166d.d0(f3);
    }

    public void setRotationTo(float f3) {
        this.f7166d.e0(f3);
    }

    public void setScale(float f3) {
        this.f7166d.f0(f3);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        k kVar = this.f7166d;
        if (kVar == null) {
            this.f7167e = scaleType;
        } else {
            kVar.i0(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i3) {
        this.f7166d.j0(i3);
    }

    public void setZoomable(boolean z3) {
        this.f7166d.k0(z3);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c();
    }
}
