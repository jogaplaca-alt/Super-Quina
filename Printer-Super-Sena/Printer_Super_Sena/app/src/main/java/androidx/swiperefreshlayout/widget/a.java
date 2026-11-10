package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.Z;

/* JADX INFO: loaded from: classes.dex */
class a extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animation.AnimationListener f6505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6507c;

    /* JADX INFO: renamed from: androidx.swiperefreshlayout.widget.a$a, reason: collision with other inner class name */
    private static class C0091a extends OvalShape {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Paint f6508a = new Paint();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f6509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private a f6510c;

        C0091a(a aVar, int i3) {
            this.f6510c = aVar;
            this.f6509b = i3;
            a((int) rect().width());
        }

        private void a(int i3) {
            float f3 = i3 / 2;
            this.f6508a.setShader(new RadialGradient(f3, f3, this.f6509b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP));
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            int width = this.f6510c.getWidth() / 2;
            float f3 = width;
            float height = this.f6510c.getHeight() / 2;
            canvas.drawCircle(f3, height, f3, this.f6508a);
            canvas.drawCircle(f3, height, width - this.f6509b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f3, float f4) {
            super.onResize(f3, f4);
            a((int) f3);
        }
    }

    a(Context context) {
        ShapeDrawable shapeDrawable;
        super(context);
        float f3 = getContext().getResources().getDisplayMetrics().density;
        int i3 = (int) (1.75f * f3);
        int i4 = (int) (0.0f * f3);
        this.f6506b = (int) (3.5f * f3);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(p013d0.a.f9451f);
        this.f6507c = typedArrayObtainStyledAttributes.getColor(p013d0.a.f9452g, -328966);
        typedArrayObtainStyledAttributes.recycle();
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            Z.y0(this, f3 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0091a(this, this.f6506b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f6506b, i4, i3, 503316480);
            int i5 = this.f6506b;
            setPadding(i5, i5, i5, i5);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(this.f6507c);
        Z.u0(this, shapeDrawable);
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public void b(Animation.AnimationListener animationListener) {
        this.f6505a = animationListener;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f6505a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f6505a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f6506b * 2), getMeasuredHeight() + (this.f6506b * 2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i3);
            this.f6507c = i3;
        }
    }
}
