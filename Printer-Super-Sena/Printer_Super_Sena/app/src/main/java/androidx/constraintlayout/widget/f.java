package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int[] f3838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f3839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Context f3840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected p058r.i f3841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f3842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f3843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String f3844g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View[] f3845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected HashMap f3846i;

    public f(Context context) {
        super(context);
        this.f3838a = new int[32];
        this.f3842e = false;
        this.f3845h = null;
        this.f3846i = new HashMap();
        this.f3840c = context;
        i(null);
    }

    private void a(String str) {
        if (str == null || str.length() == 0 || this.f3840c == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int iH = h(strTrim);
        if (iH != 0) {
            this.f3846i.put(Integer.valueOf(iH), strTrim);
            b(iH);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    private void b(int i3) {
        if (i3 == getId()) {
            return;
        }
        int i4 = this.f3839b + 1;
        int[] iArr = this.f3838a;
        if (i4 > iArr.length) {
            this.f3838a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f3838a;
        int i5 = this.f3839b;
        iArr2[i5] = i3;
        this.f3839b = i5 + 1;
    }

    private void c(String str) {
        if (str == null || str.length() == 0 || this.f3840c == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.b) && strTrim.equals(((ConstraintLayout.b) layoutParams).f3763c0)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    b(childAt.getId());
                }
            }
        }
    }

    private int g(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.f3840c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            if (childAt.getId() != -1) {
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = null;
                }
                if (str.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int h(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iG = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object objG = constraintLayout.g(0, str);
            if (objG instanceof Integer) {
                iG = ((Integer) objG).intValue();
            }
        }
        if (iG == 0 && constraintLayout != null) {
            iG = g(constraintLayout, str);
        }
        if (iG == 0) {
            try {
                iG = l.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iG == 0 ? this.f3840c.getResources().getIdentifier(str, "id", this.f3840c.getPackageName()) : iG;
    }

    protected void d() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        e((ConstraintLayout) parent);
    }

    protected void e(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        for (int i3 = 0; i3 < this.f3839b; i3++) {
            View viewL = constraintLayout.l(this.f3838a[i3]);
            if (viewL != null) {
                viewL.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    viewL.setTranslationZ(viewL.getTranslationZ() + elevation);
                }
            }
        }
    }

    protected void f(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f3838a, this.f3839b);
    }

    protected void i(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m.f4134n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == m.f4021G1) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f3843f = string;
                    setIds(string);
                } else if (index == m.f4025H1) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f3844g = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public abstract void j(p058r.e eVar, boolean z3);

    public void k(ConstraintLayout constraintLayout) {
    }

    public void l(ConstraintLayout constraintLayout) {
    }

    public void m(ConstraintLayout constraintLayout) {
    }

    public void n(ConstraintLayout constraintLayout) {
        String str;
        int iG;
        if (isInEditMode()) {
            setIds(this.f3843f);
        }
        p058r.i iVar = this.f3841d;
        if (iVar == null) {
            return;
        }
        iVar.b();
        for (int i3 = 0; i3 < this.f3839b; i3++) {
            int i4 = this.f3838a[i3];
            View viewL = constraintLayout.l(i4);
            if (viewL == null && (iG = g(constraintLayout, (str = (String) this.f3846i.get(Integer.valueOf(i4))))) != 0) {
                this.f3838a[i3] = iG;
                this.f3846i.put(Integer.valueOf(iG), str);
                viewL = constraintLayout.l(iG);
            }
            if (viewL != null) {
                this.f3841d.c(constraintLayout.p(viewL));
            }
        }
        this.f3841d.a(constraintLayout.f3710c);
    }

    public void o() {
        if (this.f3841d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).f3801v0 = (p058r.e) this.f3841d;
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f3843f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f3844g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.f3842e) {
            super.onMeasure(i3, i4);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    protected void setIds(String str) {
        this.f3843f = str;
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.f3839b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i3);
            if (iIndexOf == -1) {
                a(str.substring(i3));
                return;
            } else {
                a(str.substring(i3, iIndexOf));
                i3 = iIndexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.f3844g = str;
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.f3839b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i3);
            if (iIndexOf == -1) {
                c(str.substring(i3));
                return;
            } else {
                c(str.substring(i3, iIndexOf));
                i3 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f3843f = null;
        this.f3839b = 0;
        for (int i3 : iArr) {
            b(i3);
        }
    }

    @Override // android.view.View
    public void setTag(int i3, Object obj) {
        super.setTag(i3, obj);
        if (obj == null && this.f3843f == null) {
            b(i3);
        }
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3838a = new int[32];
        this.f3842e = false;
        this.f3845h = null;
        this.f3846i = new HashMap();
        this.f3840c = context;
        i(attributeSet);
    }
}
