package p033i1;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import p042l1.g;
import p042l1.k;
import p042l1.n;

/* JADX INFO: loaded from: classes.dex */
public class a extends Drawable implements n, androidx.core.graphics.drawable.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f9647a;

    @Override // android.graphics.drawable.Drawable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mutate() {
        this.f9647a = new b(this.f9647a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f9647a;
        if (bVar.f9649b) {
            bVar.f9648a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f9647a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f9647a.f9648a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f9647a.f9648a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f9647a.f9648a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zF = p033i1.b.f(iArr);
        b bVar = this.f9647a;
        if (bVar.f9649b == zF) {
            return zOnStateChange;
        }
        bVar.f9649b = zF;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f9647a.f9648a.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9647a.f9648a.setColorFilter(colorFilter);
    }

    @Override // p042l1.n
    public void setShapeAppearanceModel(k kVar) {
        this.f9647a.f9648a.setShapeAppearanceModel(kVar);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i3) {
        this.f9647a.f9648a.setTint(i3);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f9647a.f9648a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f9647a.f9648a.setTintMode(mode);
    }

    public a(k kVar) {
        this(new b(new g(kVar)));
    }

    static final class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        g f9648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f9649b;

        public b(g gVar) {
            this.f9648a = gVar;
            this.f9649b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(b bVar) {
            this.f9648a = (g) bVar.f9648a.getConstantState().newDrawable();
            this.f9649b = bVar.f9649b;
        }
    }

    private a(b bVar) {
        this.f9647a = bVar;
    }
}
