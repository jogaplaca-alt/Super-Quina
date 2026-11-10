package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.j0;
import androidx.core.view.Z;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements n.a, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i f2731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f2732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RadioButton f2733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f2734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CheckBox f2735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f2736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f2737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f2738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LinearLayout f2739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Drawable f2740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f2741k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Context f2742l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f2743m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Drawable f2744n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f2745o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private LayoutInflater f2746p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f2747q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p012d.a.f9071D);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i3) {
        LinearLayout linearLayout = this.f2739i;
        if (linearLayout != null) {
            linearLayout.addView(view, i3);
        } else {
            addView(view, i3);
        }
    }

    private void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(p012d.g.f9225h, (ViewGroup) this, false);
        this.f2735e = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(p012d.g.f9226i, (ViewGroup) this, false);
        this.f2732b = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(p012d.g.f9228k, (ViewGroup) this, false);
        this.f2733c = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f2746p == null) {
            this.f2746p = LayoutInflater.from(getContext());
        }
        return this.f2746p;
    }

    private void setSubMenuArrowVisible(boolean z3) {
        ImageView imageView = this.f2737g;
        if (imageView != null) {
            imageView.setVisibility(z3 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f2738h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2738h.getLayoutParams();
        rect.top += this.f2738h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void e(i iVar, int i3) {
        this.f2731a = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        setTitle(iVar.i(this));
        setCheckable(iVar.isCheckable());
        h(iVar.A(), iVar.g());
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.f2731a;
    }

    public void h(boolean z3, char c3) {
        int i3 = (z3 && this.f2731a.A()) ? 0 : 8;
        if (i3 == 0) {
            this.f2736f.setText(this.f2731a.h());
        }
        if (this.f2736f.getVisibility() != i3) {
            this.f2736f.setVisibility(i3);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        Z.u0(this, this.f2740j);
        TextView textView = (TextView) findViewById(p012d.f.f9188M);
        this.f2734d = textView;
        int i3 = this.f2741k;
        if (i3 != -1) {
            textView.setTextAppearance(this.f2742l, i3);
        }
        this.f2736f = (TextView) findViewById(p012d.f.f9181F);
        ImageView imageView = (ImageView) findViewById(p012d.f.f9184I);
        this.f2737g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f2744n);
        }
        this.f2738h = (ImageView) findViewById(p012d.f.f9209r);
        this.f2739i = (LinearLayout) findViewById(p012d.f.f9203l);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.f2732b != null && this.f2743m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2732b.getLayoutParams();
            int i5 = layoutParams.height;
            if (i5 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i5;
            }
        }
        super.onMeasure(i3, i4);
    }

    public void setCheckable(boolean z3) {
        CompoundButton compoundButton;
        View view;
        if (!z3 && this.f2733c == null && this.f2735e == null) {
            return;
        }
        if (this.f2731a.m()) {
            if (this.f2733c == null) {
                g();
            }
            compoundButton = this.f2733c;
            view = this.f2735e;
        } else {
            if (this.f2735e == null) {
                c();
            }
            compoundButton = this.f2735e;
            view = this.f2733c;
        }
        if (z3) {
            compoundButton.setChecked(this.f2731a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f2735e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f2733c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z3) {
        CompoundButton compoundButton;
        if (this.f2731a.m()) {
            if (this.f2733c == null) {
                g();
            }
            compoundButton = this.f2733c;
        } else {
            if (this.f2735e == null) {
                c();
            }
            compoundButton = this.f2735e;
        }
        compoundButton.setChecked(z3);
    }

    public void setForceShowIcon(boolean z3) {
        this.f2747q = z3;
        this.f2743m = z3;
    }

    public void setGroupDividerEnabled(boolean z3) {
        ImageView imageView = this.f2738h;
        if (imageView != null) {
            imageView.setVisibility((this.f2745o || !z3) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z3 = this.f2731a.z() || this.f2747q;
        if (z3 || this.f2743m) {
            ImageView imageView = this.f2732b;
            if (imageView == null && drawable == null && !this.f2743m) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.f2743m) {
                this.f2732b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f2732b;
            if (!z3) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f2732b.getVisibility() != 0) {
                this.f2732b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f2734d.getVisibility() != 8) {
                this.f2734d.setVisibility(8);
            }
        } else {
            this.f2734d.setText(charSequence);
            if (this.f2734d.getVisibility() != 0) {
                this.f2734d.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        j0 j0VarV = j0.v(getContext(), attributeSet, p012d.j.f9349b2, i3, 0);
        this.f2740j = j0VarV.g(p012d.j.f9357d2);
        this.f2741k = j0VarV.n(p012d.j.f9353c2, -1);
        this.f2743m = j0VarV.a(p012d.j.f9361e2, false);
        this.f2742l = context;
        this.f2744n = j0VarV.g(p012d.j.f9365f2);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, p012d.a.f9108z, 0);
        this.f2745o = typedArrayObtainStyledAttributes.hasValue(0);
        j0VarV.w();
        typedArrayObtainStyledAttributes.recycle();
    }
}
