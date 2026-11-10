package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.F;
import androidx.appcompat.widget.V;
import androidx.appcompat.widget.o0;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends F implements n.a, View.OnClickListener, ActionMenuView.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    i f2716h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CharSequence f2717i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Drawable f2718j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    g.b f2719k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private V f2720l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    b f2721m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f2722n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f2723o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f2724p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f2725q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f2726r;

    private class a extends V {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.V
        public p b() {
            b bVar = ActionMenuItemView.this.f2721m;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.V
        protected boolean c() {
            p pVarB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            g.b bVar = actionMenuItemView.f2719k;
            return bVar != null && bVar.a(actionMenuItemView.f2716h) && (pVarB = b()) != null && pVarB.b();
        }
    }

    public static abstract class b {
        public abstract p a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean s() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        return i3 >= 480 || (i3 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void t() {
        boolean z3 = true;
        boolean z4 = !TextUtils.isEmpty(this.f2717i);
        if (this.f2718j != null && (!this.f2716h.B() || (!this.f2722n && !this.f2723o))) {
            z3 = false;
        }
        boolean z5 = z4 & z3;
        setText(z5 ? this.f2717i : null);
        CharSequence contentDescription = this.f2716h.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z5 ? null : this.f2716h.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f2716h.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            o0.a(this, z5 ? null : this.f2716h.getTitle());
        } else {
            o0.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return r();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return r() && this.f2716h.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void e(i iVar, int i3) {
        this.f2716h = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.i(this));
        setId(iVar.getItemId());
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.f2720l == null) {
            this.f2720l = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.f2716h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar = this.f2719k;
        if (bVar != null) {
            bVar.a(this.f2716h);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2722n = s();
        t();
    }

    @Override // androidx.appcompat.widget.F, android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        boolean zR = r();
        if (zR && (i5 = this.f2725q) >= 0) {
            super.setPadding(i5, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i3, i4);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f2724p) : this.f2724p;
        if (mode != 1073741824 && this.f2724p > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i4);
        }
        if (zR || this.f2718j == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f2718j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        V v3;
        if (this.f2716h.hasSubMenu() && (v3 = this.f2720l) != null && v3.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean r() {
        return !TextUtils.isEmpty(getText());
    }

    public void setCheckable(boolean z3) {
    }

    public void setChecked(boolean z3) {
    }

    public void setExpandedFormat(boolean z3) {
        if (this.f2723o != z3) {
            this.f2723o = z3;
            i iVar = this.f2716h;
            if (iVar != null) {
                iVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f2718j = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i3 = this.f2726r;
            if (intrinsicWidth > i3) {
                intrinsicHeight = (int) (intrinsicHeight * (i3 / intrinsicWidth));
                intrinsicWidth = i3;
            }
            if (intrinsicHeight > i3) {
                intrinsicWidth = (int) (intrinsicWidth * (i3 / intrinsicHeight));
            } else {
                i3 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i3);
        }
        setCompoundDrawables(drawable, null, null, null);
        t();
    }

    public void setItemInvoker(g.b bVar) {
        this.f2719k = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i3, int i4, int i5, int i6) {
        this.f2725q = i3;
        super.setPadding(i3, i4, i5, i6);
    }

    public void setPopupCallback(b bVar) {
        this.f2721m = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f2717i = charSequence;
        t();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Resources resources = context.getResources();
        this.f2722n = s();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p012d.j.f9426v, i3, 0);
        this.f2724p = typedArrayObtainStyledAttributes.getDimensionPixelSize(p012d.j.f9430w, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f2726r = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f2725q = -1;
        setSaveEnabled(false);
    }
}
