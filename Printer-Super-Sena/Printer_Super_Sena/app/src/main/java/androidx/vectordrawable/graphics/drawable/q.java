package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class q extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f6751k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f6752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuffColorFilter f6753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ColorFilter f6754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable.ConstantState f6757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f6758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Matrix f6759i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Rect f6760j;

    private static class b extends f {
        b() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f6787b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f6786a = androidx.core.graphics.g.d(string2);
            }
            this.f6788c = androidx.core.content.res.k.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // androidx.vectordrawable.graphics.drawable.q.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (androidx.core.content.res.k.j(xmlPullParser, "pathData")) {
                TypedArray typedArrayK = androidx.core.content.res.k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f6720d);
                f(typedArrayK, xmlPullParser);
                typedArrayK.recycle();
            }
        }

        b(b bVar) {
            super(bVar);
        }
    }

    private static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    private static class h extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        g f6808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ColorStateList f6809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f6810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f6811e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Bitmap f6812f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ColorStateList f6813g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        PorterDuff.Mode f6814h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f6815i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f6816j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f6817k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Paint f6818l;

        public h(h hVar) {
            this.f6809c = null;
            this.f6810d = q.f6751k;
            if (hVar != null) {
                this.f6807a = hVar.f6807a;
                g gVar = new g(hVar.f6808b);
                this.f6808b = gVar;
                if (hVar.f6808b.f6795e != null) {
                    gVar.f6795e = new Paint(hVar.f6808b.f6795e);
                }
                if (hVar.f6808b.f6794d != null) {
                    this.f6808b.f6794d = new Paint(hVar.f6808b.f6794d);
                }
                this.f6809c = hVar.f6809c;
                this.f6810d = hVar.f6810d;
                this.f6811e = hVar.f6811e;
            }
        }

        public boolean a(int i3, int i4) {
            return i3 == this.f6812f.getWidth() && i4 == this.f6812f.getHeight();
        }

        public boolean b() {
            return !this.f6817k && this.f6813g == this.f6809c && this.f6814h == this.f6810d && this.f6816j == this.f6811e && this.f6815i == this.f6808b.getRootAlpha();
        }

        public void c(int i3, int i4) {
            if (this.f6812f == null || !a(i3, i4)) {
                this.f6812f = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
                this.f6817k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f6812f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f6818l == null) {
                Paint paint = new Paint();
                this.f6818l = paint;
                paint.setFilterBitmap(true);
            }
            this.f6818l.setAlpha(this.f6808b.getRootAlpha());
            this.f6818l.setColorFilter(colorFilter);
            return this.f6818l;
        }

        public boolean f() {
            return this.f6808b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f6808b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f6807a;
        }

        public boolean h(int[] iArr) {
            boolean zG = this.f6808b.g(iArr);
            this.f6817k |= zG;
            return zG;
        }

        public void i() {
            this.f6813g = this.f6809c;
            this.f6814h = this.f6810d;
            this.f6815i = this.f6808b.getRootAlpha();
            this.f6816j = this.f6811e;
            this.f6817k = false;
        }

        public void j(int i3, int i4) {
            this.f6812f.eraseColor(0);
            this.f6808b.b(new Canvas(this.f6812f), i3, i4, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new q(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new q(this);
        }

        public h() {
            this.f6809c = null;
            this.f6810d = q.f6751k;
            this.f6808b = new g();
        }
    }

    q() {
        this.f6756f = true;
        this.f6758h = new float[9];
        this.f6759i = new Matrix();
        this.f6760j = new Rect();
        this.f6752b = new h();
    }

    static int a(int i3, float f3) {
        return (i3 & 16777215) | (((int) (Color.alpha(i3) * f3)) << 24);
    }

    public static q b(Resources resources, int i3, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            q qVar = new q();
            qVar.f6750a = androidx.core.content.res.h.e(resources, i3, theme);
            qVar.f6757g = new i(qVar.f6750a.getConstantState());
            return qVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i3);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return c(resources, xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        } catch (XmlPullParserException e4) {
            Log.e("VectorDrawableCompat", "parser error", e4);
            return null;
        }
    }

    public static q c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        q qVar = new q();
        qVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return qVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.f6752b;
        g gVar = hVar.f6808b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f6798h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z3 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f6774b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f6806p.put(cVar.getPathName(), cVar);
                    }
                    hVar.f6807a = cVar.f6789d | hVar.f6807a;
                    z3 = false;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f6774b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f6806p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f6807a = bVar.f6789d | hVar.f6807a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f6774b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f6806p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f6807a = dVar2.f6783k | hVar.f6807a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z3) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.f(this) == 1;
    }

    private static PorterDuff.Mode g(int i3, PorterDuff.Mode mode) {
        if (i3 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i3 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i3 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i3) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f6752b;
        g gVar = hVar.f6808b;
        hVar.f6810d = g(androidx.core.content.res.k.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListC = androidx.core.content.res.k.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListC != null) {
            hVar.f6809c = colorStateListC;
        }
        hVar.f6811e = androidx.core.content.res.k.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f6811e);
        gVar.f6801k = androidx.core.content.res.k.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f6801k);
        float f3 = androidx.core.content.res.k.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f6802l);
        gVar.f6802l = f3;
        if (gVar.f6801k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f3 <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        gVar.f6799i = typedArray.getDimension(3, gVar.f6799i);
        float dimension = typedArray.getDimension(2, gVar.f6800j);
        gVar.f6800j = dimension;
        if (gVar.f6799i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        gVar.setAlpha(androidx.core.content.res.k.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            gVar.f6804n = string;
            gVar.f6806p.put(string, gVar);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f6750a;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable);
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    Object d(String str) {
        return this.f6752b.f6808b.f6806p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f6760j);
        if (this.f6760j.width() <= 0 || this.f6760j.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f6754d;
        if (colorFilter == null) {
            colorFilter = this.f6753c;
        }
        canvas.getMatrix(this.f6759i);
        this.f6759i.getValues(this.f6758h);
        float fAbs = Math.abs(this.f6758h[0]);
        float fAbs2 = Math.abs(this.f6758h[4]);
        float fAbs3 = Math.abs(this.f6758h[1]);
        float fAbs4 = Math.abs(this.f6758h[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (this.f6760j.width() * fAbs);
        int iHeight = (int) (this.f6760j.height() * fAbs2);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, iHeight);
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f6760j;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.f6760j.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f6760j.offsetTo(0, 0);
        this.f6752b.c(iMin, iMin2);
        if (!this.f6756f) {
            this.f6752b.j(iMin, iMin2);
        } else if (!this.f6752b.b()) {
            this.f6752b.j(iMin, iMin2);
            this.f6752b.i();
        }
        this.f6752b.d(canvas, colorFilter, this.f6760j);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f6750a;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f6752b.f6808b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f6750a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f6752b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f6750a;
        return drawable != null ? androidx.core.graphics.drawable.a.e(drawable) : this.f6754d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f6750a != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f6750a.getConstantState());
        }
        this.f6752b.f6807a = getChangingConfigurations();
        return this.f6752b;
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f6750a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f6752b.f6808b.f6800j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f6750a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f6752b.f6808b.f6799i;
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    void h(boolean z3) {
        this.f6756f = z3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f6750a;
        return drawable != null ? androidx.core.graphics.drawable.a.h(drawable) : this.f6752b.f6811e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((hVar = this.f6752b) != null && (hVar.g() || ((colorStateList = this.f6752b.f6809c) != null && colorStateList.isStateful())));
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f6755e && super.mutate() == this) {
            this.f6752b = new h(this.f6752b);
            this.f6755e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z3;
        PorterDuff.Mode mode;
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        h hVar = this.f6752b;
        ColorStateList colorStateList = hVar.f6809c;
        if (colorStateList == null || (mode = hVar.f6810d) == null) {
            z3 = false;
        } else {
            this.f6753c = j(this.f6753c, colorStateList, mode);
            invalidateSelf();
            z3 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z3;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j3) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j3);
        } else {
            super.scheduleSelf(runnable, j3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            drawable.setAlpha(i3);
        } else if (this.f6752b.f6808b.getRootAlpha() != i3) {
            this.f6752b.f6808b.setRootAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z3) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z3);
        } else {
            this.f6752b.f6811e = z3;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i3) {
        super.setChangingConfigurations(i3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i3, PorterDuff.Mode mode) {
        super.setColorFilter(i3, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z3) {
        super.setFilterBitmap(z3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f3, float f4) {
        super.setHotspot(f3, f4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i3, int i4, int i5, int i6) {
        super.setHotspotBounds(i3, i4, i5, i6);
    }

    @Override // androidx.vectordrawable.graphics.drawable.p, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i3) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i3);
        } else {
            setTintList(ColorStateList.valueOf(i3));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f6752b;
        if (hVar.f6809c != colorStateList) {
            hVar.f6809c = colorStateList;
            this.f6753c = j(this.f6753c, colorStateList, hVar.f6810d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
            return;
        }
        h hVar = this.f6752b;
        if (hVar.f6810d != mode) {
            hVar.f6810d = mode;
            this.f6753c = j(this.f6753c, hVar.f6809c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        Drawable drawable = this.f6750a;
        return drawable != null ? drawable.setVisible(z3, z4) : super.setVisible(z3, z4);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    private static class i extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f6819a;

        public i(Drawable.ConstantState constantState) {
            this.f6819a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f6819a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f6819a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            q qVar = new q();
            qVar.f6750a = r.a(this.f6819a.newDrawable());
            return qVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            q qVar = new q();
            qVar.f6750a = r.a(this.f6819a.newDrawable(resources));
            return qVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            q qVar = new q();
            qVar.f6750a = r.a(this.f6819a.newDrawable(resources, theme));
            return qVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f6754d = colorFilter;
            invalidateSelf();
        }
    }

    private static abstract class f extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected androidx.core.graphics.g.b[] f6786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f6787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f6788c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f6789d;

        public f() {
            super();
            this.f6786a = null;
            this.f6788c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            androidx.core.graphics.g.b[] bVarArr = this.f6786a;
            if (bVarArr != null) {
                androidx.core.graphics.g.b.i(bVarArr, path);
            }
        }

        public androidx.core.graphics.g.b[] getPathData() {
            return this.f6786a;
        }

        public String getPathName() {
            return this.f6787b;
        }

        public void setPathData(androidx.core.graphics.g.b[] bVarArr) {
            if (androidx.core.graphics.g.b(this.f6786a, bVarArr)) {
                androidx.core.graphics.g.k(this.f6786a, bVarArr);
            } else {
                this.f6786a = androidx.core.graphics.g.f(bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.f6786a = null;
            this.f6788c = 0;
            this.f6787b = fVar.f6787b;
            this.f6789d = fVar.f6789d;
            this.f6786a = androidx.core.graphics.g.f(fVar.f6786a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f6750a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f6752b;
        hVar.f6808b = new g();
        TypedArray typedArrayK = androidx.core.content.res.k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f6717a);
        i(typedArrayK, xmlPullParser, theme);
        typedArrayK.recycle();
        hVar.f6807a = getChangingConfigurations();
        hVar.f6817k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f6753c = j(this.f6753c, hVar.f6809c, hVar.f6810d);
    }

    q(h hVar) {
        this.f6756f = true;
        this.f6758h = new float[9];
        this.f6759i = new Matrix();
        this.f6760j = new Rect();
        this.f6752b = hVar;
        this.f6753c = j(this.f6753c, hVar.f6809c, hVar.f6810d);
    }

    private static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int[] f6761e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        androidx.core.content.res.d f6762f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f6763g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        androidx.core.content.res.d f6764h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float f6765i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f6766j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f6767k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f6768l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        float f6769m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Paint.Cap f6770n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Paint.Join f6771o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        float f6772p;

        c() {
            this.f6763g = 0.0f;
            this.f6765i = 1.0f;
            this.f6766j = 1.0f;
            this.f6767k = 0.0f;
            this.f6768l = 1.0f;
            this.f6769m = 0.0f;
            this.f6770n = Paint.Cap.BUTT;
            this.f6771o = Paint.Join.MITER;
            this.f6772p = 4.0f;
        }

        private Paint.Cap e(int i3, Paint.Cap cap) {
            if (i3 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i3 != 1) {
                return i3 != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        private Paint.Join f(int i3, Paint.Join join) {
            if (i3 == 0) {
                return Paint.Join.MITER;
            }
            if (i3 != 1) {
                return i3 != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f6761e = null;
            if (androidx.core.content.res.k.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f6787b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f6786a = androidx.core.graphics.g.d(string2);
                }
                this.f6764h = androidx.core.content.res.k.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f6766j = androidx.core.content.res.k.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f6766j);
                this.f6770n = e(androidx.core.content.res.k.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f6770n);
                this.f6771o = f(androidx.core.content.res.k.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f6771o);
                this.f6772p = androidx.core.content.res.k.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f6772p);
                this.f6762f = androidx.core.content.res.k.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f6765i = androidx.core.content.res.k.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f6765i);
                this.f6763g = androidx.core.content.res.k.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f6763g);
                this.f6768l = androidx.core.content.res.k.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f6768l);
                this.f6769m = androidx.core.content.res.k.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f6769m);
                this.f6767k = androidx.core.content.res.k.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f6767k);
                this.f6788c = androidx.core.content.res.k.g(typedArray, xmlPullParser, "fillType", 13, this.f6788c);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.q.e
        public boolean a() {
            return this.f6764h.i() || this.f6762f.i();
        }

        @Override // androidx.vectordrawable.graphics.drawable.q.e
        public boolean b(int[] iArr) {
            return this.f6762f.j(iArr) | this.f6764h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayK = androidx.core.content.res.k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f6719c);
            h(typedArrayK, xmlPullParser, theme);
            typedArrayK.recycle();
        }

        float getFillAlpha() {
            return this.f6766j;
        }

        int getFillColor() {
            return this.f6764h.e();
        }

        float getStrokeAlpha() {
            return this.f6765i;
        }

        int getStrokeColor() {
            return this.f6762f.e();
        }

        float getStrokeWidth() {
            return this.f6763g;
        }

        float getTrimPathEnd() {
            return this.f6768l;
        }

        float getTrimPathOffset() {
            return this.f6769m;
        }

        float getTrimPathStart() {
            return this.f6767k;
        }

        void setFillAlpha(float f3) {
            this.f6766j = f3;
        }

        void setFillColor(int i3) {
            this.f6764h.k(i3);
        }

        void setStrokeAlpha(float f3) {
            this.f6765i = f3;
        }

        void setStrokeColor(int i3) {
            this.f6762f.k(i3);
        }

        void setStrokeWidth(float f3) {
            this.f6763g = f3;
        }

        void setTrimPathEnd(float f3) {
            this.f6768l = f3;
        }

        void setTrimPathOffset(float f3) {
            this.f6769m = f3;
        }

        void setTrimPathStart(float f3) {
            this.f6767k = f3;
        }

        c(c cVar) {
            super(cVar);
            this.f6763g = 0.0f;
            this.f6765i = 1.0f;
            this.f6766j = 1.0f;
            this.f6767k = 0.0f;
            this.f6768l = 1.0f;
            this.f6769m = 0.0f;
            this.f6770n = Paint.Cap.BUTT;
            this.f6771o = Paint.Join.MITER;
            this.f6772p = 4.0f;
            this.f6761e = cVar.f6761e;
            this.f6762f = cVar.f6762f;
            this.f6763g = cVar.f6763g;
            this.f6765i = cVar.f6765i;
            this.f6764h = cVar.f6764h;
            this.f6788c = cVar.f6788c;
            this.f6766j = cVar.f6766j;
            this.f6767k = cVar.f6767k;
            this.f6768l = cVar.f6768l;
            this.f6769m = cVar.f6769m;
            this.f6770n = cVar.f6770n;
            this.f6771o = cVar.f6771o;
            this.f6772p = cVar.f6772p;
        }
    }

    private static class g {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final Matrix f6790q = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Path f6791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Path f6792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Matrix f6793c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Paint f6794d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Paint f6795e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private PathMeasure f6796f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f6797g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final d f6798h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float f6799i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f6800j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f6801k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f6802l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f6803m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        String f6804n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Boolean f6805o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final p046n.a f6806p;

        public g() {
            this.f6793c = new Matrix();
            this.f6799i = 0.0f;
            this.f6800j = 0.0f;
            this.f6801k = 0.0f;
            this.f6802l = 0.0f;
            this.f6803m = 255;
            this.f6804n = null;
            this.f6805o = null;
            this.f6806p = new p046n.a();
            this.f6798h = new d();
            this.f6791a = new Path();
            this.f6792b = new Path();
        }

        private static float a(float f3, float f4, float f5, float f6) {
            return (f3 * f6) - (f4 * f5);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i3, int i4, ColorFilter colorFilter) {
            dVar.f6773a.set(matrix);
            dVar.f6773a.preConcat(dVar.f6782j);
            canvas.save();
            for (int i5 = 0; i5 < dVar.f6774b.size(); i5++) {
                e eVar = (e) dVar.f6774b.get(i5);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f6773a, canvas, i3, i4, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i3, i4, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i3, int i4, ColorFilter colorFilter) {
            float f3 = i3 / this.f6801k;
            float f4 = i4 / this.f6802l;
            float fMin = Math.min(f3, f4);
            Matrix matrix = dVar.f6773a;
            this.f6793c.set(matrix);
            this.f6793c.postScale(f3, f4);
            float fE = e(matrix);
            if (fE == 0.0f) {
                return;
            }
            fVar.d(this.f6791a);
            Path path = this.f6791a;
            this.f6792b.reset();
            if (fVar.c()) {
                this.f6792b.setFillType(fVar.f6788c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f6792b.addPath(path, this.f6793c);
                canvas.clipPath(this.f6792b);
                return;
            }
            c cVar = (c) fVar;
            float f5 = cVar.f6767k;
            if (f5 != 0.0f || cVar.f6768l != 1.0f) {
                float f6 = cVar.f6769m;
                float f7 = (f5 + f6) % 1.0f;
                float f8 = (cVar.f6768l + f6) % 1.0f;
                if (this.f6796f == null) {
                    this.f6796f = new PathMeasure();
                }
                this.f6796f.setPath(this.f6791a, false);
                float length = this.f6796f.getLength();
                float f9 = f7 * length;
                float f10 = f8 * length;
                path.reset();
                if (f9 > f10) {
                    this.f6796f.getSegment(f9, length, path, true);
                    this.f6796f.getSegment(0.0f, f10, path, true);
                } else {
                    this.f6796f.getSegment(f9, f10, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f6792b.addPath(path, this.f6793c);
            if (cVar.f6764h.l()) {
                androidx.core.content.res.d dVar2 = cVar.f6764h;
                if (this.f6795e == null) {
                    Paint paint = new Paint(1);
                    this.f6795e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f6795e;
                if (dVar2.h()) {
                    Shader shaderF = dVar2.f();
                    shaderF.setLocalMatrix(this.f6793c);
                    paint2.setShader(shaderF);
                    paint2.setAlpha(Math.round(cVar.f6766j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(q.a(dVar2.e(), cVar.f6766j));
                }
                paint2.setColorFilter(colorFilter);
                this.f6792b.setFillType(cVar.f6788c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f6792b, paint2);
            }
            if (cVar.f6762f.l()) {
                androidx.core.content.res.d dVar3 = cVar.f6762f;
                if (this.f6794d == null) {
                    Paint paint3 = new Paint(1);
                    this.f6794d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f6794d;
                Paint.Join join = cVar.f6771o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f6770n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f6772p);
                if (dVar3.h()) {
                    Shader shaderF2 = dVar3.f();
                    shaderF2.setLocalMatrix(this.f6793c);
                    paint4.setShader(shaderF2);
                    paint4.setAlpha(Math.round(cVar.f6765i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(q.a(dVar3.e(), cVar.f6765i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f6763g * fMin * fE);
                canvas.drawPath(this.f6792b, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fA) / fMax;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i3, int i4, ColorFilter colorFilter) {
            c(this.f6798h, f6790q, canvas, i3, i4, colorFilter);
        }

        public boolean f() {
            if (this.f6805o == null) {
                this.f6805o = Boolean.valueOf(this.f6798h.a());
            }
            return this.f6805o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f6798h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f6803m;
        }

        public void setAlpha(float f3) {
            setRootAlpha((int) (f3 * 255.0f));
        }

        public void setRootAlpha(int i3) {
            this.f6803m = i3;
        }

        public g(g gVar) {
            this.f6793c = new Matrix();
            this.f6799i = 0.0f;
            this.f6800j = 0.0f;
            this.f6801k = 0.0f;
            this.f6802l = 0.0f;
            this.f6803m = 255;
            this.f6804n = null;
            this.f6805o = null;
            p046n.a aVar = new p046n.a();
            this.f6806p = aVar;
            this.f6798h = new d(gVar.f6798h, aVar);
            this.f6791a = new Path(gVar.f6791a);
            this.f6792b = new Path(gVar.f6792b);
            this.f6799i = gVar.f6799i;
            this.f6800j = gVar.f6800j;
            this.f6801k = gVar.f6801k;
            this.f6802l = gVar.f6802l;
            this.f6797g = gVar.f6797g;
            this.f6803m = gVar.f6803m;
            this.f6804n = gVar.f6804n;
            String str = gVar.f6804n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f6805o = gVar.f6805o;
        }
    }

    private static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Matrix f6773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayList f6774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f6775c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f6776d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f6777e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f6778f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f6779g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f6780h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f6781i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Matrix f6782j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f6783k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int[] f6784l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f6785m;

        public d(d dVar, p046n.a aVar) {
            f bVar;
            super();
            this.f6773a = new Matrix();
            this.f6774b = new ArrayList();
            this.f6775c = 0.0f;
            this.f6776d = 0.0f;
            this.f6777e = 0.0f;
            this.f6778f = 1.0f;
            this.f6779g = 1.0f;
            this.f6780h = 0.0f;
            this.f6781i = 0.0f;
            Matrix matrix = new Matrix();
            this.f6782j = matrix;
            this.f6785m = null;
            this.f6775c = dVar.f6775c;
            this.f6776d = dVar.f6776d;
            this.f6777e = dVar.f6777e;
            this.f6778f = dVar.f6778f;
            this.f6779g = dVar.f6779g;
            this.f6780h = dVar.f6780h;
            this.f6781i = dVar.f6781i;
            this.f6784l = dVar.f6784l;
            String str = dVar.f6785m;
            this.f6785m = str;
            this.f6783k = dVar.f6783k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f6782j);
            ArrayList arrayList = dVar.f6774b;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Object obj = arrayList.get(i3);
                if (obj instanceof d) {
                    this.f6774b.add(new d((d) obj, aVar));
                } else {
                    if (obj instanceof c) {
                        bVar = new c((c) obj);
                    } else {
                        if (!(obj instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) obj);
                    }
                    this.f6774b.add(bVar);
                    Object obj2 = bVar.f6787b;
                    if (obj2 != null) {
                        aVar.put(obj2, bVar);
                    }
                }
            }
        }

        private void d() {
            this.f6782j.reset();
            this.f6782j.postTranslate(-this.f6776d, -this.f6777e);
            this.f6782j.postScale(this.f6778f, this.f6779g);
            this.f6782j.postRotate(this.f6775c, 0.0f, 0.0f);
            this.f6782j.postTranslate(this.f6780h + this.f6776d, this.f6781i + this.f6777e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f6784l = null;
            this.f6775c = androidx.core.content.res.k.f(typedArray, xmlPullParser, "rotation", 5, this.f6775c);
            this.f6776d = typedArray.getFloat(1, this.f6776d);
            this.f6777e = typedArray.getFloat(2, this.f6777e);
            this.f6778f = androidx.core.content.res.k.f(typedArray, xmlPullParser, "scaleX", 3, this.f6778f);
            this.f6779g = androidx.core.content.res.k.f(typedArray, xmlPullParser, "scaleY", 4, this.f6779g);
            this.f6780h = androidx.core.content.res.k.f(typedArray, xmlPullParser, "translateX", 6, this.f6780h);
            this.f6781i = androidx.core.content.res.k.f(typedArray, xmlPullParser, "translateY", 7, this.f6781i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f6785m = string;
            }
            d();
        }

        @Override // androidx.vectordrawable.graphics.drawable.q.e
        public boolean a() {
            for (int i3 = 0; i3 < this.f6774b.size(); i3++) {
                if (((e) this.f6774b.get(i3)).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.q.e
        public boolean b(int[] iArr) {
            boolean zB = false;
            for (int i3 = 0; i3 < this.f6774b.size(); i3++) {
                zB |= ((e) this.f6774b.get(i3)).b(iArr);
            }
            return zB;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayK = androidx.core.content.res.k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f6718b);
            e(typedArrayK, xmlPullParser);
            typedArrayK.recycle();
        }

        public String getGroupName() {
            return this.f6785m;
        }

        public Matrix getLocalMatrix() {
            return this.f6782j;
        }

        public float getPivotX() {
            return this.f6776d;
        }

        public float getPivotY() {
            return this.f6777e;
        }

        public float getRotation() {
            return this.f6775c;
        }

        public float getScaleX() {
            return this.f6778f;
        }

        public float getScaleY() {
            return this.f6779g;
        }

        public float getTranslateX() {
            return this.f6780h;
        }

        public float getTranslateY() {
            return this.f6781i;
        }

        public void setPivotX(float f3) {
            if (f3 != this.f6776d) {
                this.f6776d = f3;
                d();
            }
        }

        public void setPivotY(float f3) {
            if (f3 != this.f6777e) {
                this.f6777e = f3;
                d();
            }
        }

        public void setRotation(float f3) {
            if (f3 != this.f6775c) {
                this.f6775c = f3;
                d();
            }
        }

        public void setScaleX(float f3) {
            if (f3 != this.f6778f) {
                this.f6778f = f3;
                d();
            }
        }

        public void setScaleY(float f3) {
            if (f3 != this.f6779g) {
                this.f6779g = f3;
                d();
            }
        }

        public void setTranslateX(float f3) {
            if (f3 != this.f6780h) {
                this.f6780h = f3;
                d();
            }
        }

        public void setTranslateY(float f3) {
            if (f3 != this.f6781i) {
                this.f6781i = f3;
                d();
            }
        }

        public d() {
            super();
            this.f6773a = new Matrix();
            this.f6774b = new ArrayList();
            this.f6775c = 0.0f;
            this.f6776d = 0.0f;
            this.f6777e = 0.0f;
            this.f6778f = 1.0f;
            this.f6779g = 1.0f;
            this.f6780h = 0.0f;
            this.f6781i = 0.0f;
            this.f6782j = new Matrix();
            this.f6785m = null;
        }
    }
}
