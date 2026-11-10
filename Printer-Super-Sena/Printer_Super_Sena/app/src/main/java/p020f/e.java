package p020f;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private a f9536m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f9537n;

    static class a extends b.d {

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        int[][] f9538J;

        a(a aVar, e eVar, Resources resources) {
            super(aVar, eVar, resources);
            if (aVar != null) {
                this.f9538J = aVar.f9538J;
            } else {
                this.f9538J = new int[f()][];
            }
        }

        int A(int[] iArr) {
            int[][] iArr2 = this.f9538J;
            int iH = h();
            for (int i3 = 0; i3 < iH; i3++) {
                if (StateSet.stateSetMatches(iArr2[i3], iArr)) {
                    return i3;
                }
            }
            return -1;
        }

        @Override // f.b.d
        public void o(int i3, int i4) {
            super.o(i3, i4);
            int[][] iArr = new int[i4][];
            System.arraycopy(this.f9538J, 0, iArr, 0, i3);
            this.f9538J = iArr;
        }

        @Override // f.b.d
        abstract void r();

        int z(int[] iArr, Drawable drawable) {
            int iA = a(drawable);
            this.f9538J[iA] = iArr;
            return iA;
        }
    }

    e(a aVar) {
        if (aVar != null) {
            h(aVar);
        }
    }

    @Override // p020f.b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // p020f.b
    void h(b.d dVar) {
        super.h(dVar);
        if (dVar instanceof a) {
            this.f9536m = (a) dVar;
        }
    }

    int[] j(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i3 = 0;
        for (int i4 = 0; i4 < attributeCount; i4++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i4);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i5 = i3 + 1;
                if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i3] = attributeNameResource;
                i3 = i5;
            }
        }
        return StateSet.trimStateSet(iArr, i3);
    }

    @Override // p020f.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f9537n && super.mutate() == this) {
            this.f9536m.r();
            this.f9537n = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected abstract boolean onStateChange(int[] iArr);
}
