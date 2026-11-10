package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f3613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextView f3614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WindowManager.LayoutParams f3615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f3616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f3617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f3618g;

    s0(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f3615d = layoutParams;
        this.f3616e = new Rect();
        this.f3617f = new int[2];
        this.f3618g = new int[2];
        this.f3612a = context;
        View viewInflate = LayoutInflater.from(context).inflate(p012d.g.f9236s, (ViewGroup) null);
        this.f3613b = viewInflate;
        this.f3614c = (TextView) viewInflate.findViewById(p012d.f.f9210s);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = p012d.i.f9252a;
        layoutParams.flags = 24;
    }

    private void a(View view, int i3, int i4, boolean z3, WindowManager.LayoutParams layoutParams) {
        int height;
        int i5;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f3612a.getResources().getDimensionPixelOffset(p012d.d.f9128k);
        if (view.getWidth() < dimensionPixelOffset) {
            i3 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f3612a.getResources().getDimensionPixelOffset(p012d.d.f9127j);
            height = i4 + dimensionPixelOffset2;
            i5 = i4 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i5 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f3612a.getResources().getDimensionPixelOffset(z3 ? p012d.d.f9130m : p012d.d.f9129l);
        View viewB = b(view);
        if (viewB == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewB.getWindowVisibleDisplayFrame(this.f3616e);
        Rect rect = this.f3616e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f3612a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f3616e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewB.getLocationOnScreen(this.f3618g);
        view.getLocationOnScreen(this.f3617f);
        int[] iArr = this.f3617f;
        int i6 = iArr[0];
        int[] iArr2 = this.f3618g;
        int i7 = i6 - iArr2[0];
        iArr[0] = i7;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i7 + i3) - (viewB.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f3613b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f3613b.getMeasuredHeight();
        int i8 = this.f3617f[1];
        int i9 = ((i5 + i8) - dimensionPixelOffset3) - measuredHeight;
        int i10 = i8 + height + dimensionPixelOffset3;
        if (z3) {
            if (i9 >= 0) {
                layoutParams.y = i9;
                return;
            } else {
                layoutParams.y = i10;
                return;
            }
        }
        if (measuredHeight + i10 <= this.f3616e.height()) {
            layoutParams.y = i10;
        } else {
            layoutParams.y = i9;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    void c() {
        if (d()) {
            ((WindowManager) this.f3612a.getSystemService("window")).removeView(this.f3613b);
        }
    }

    boolean d() {
        return this.f3613b.getParent() != null;
    }

    void e(View view, int i3, int i4, boolean z3, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f3614c.setText(charSequence);
        a(view, i3, i4, z3, this.f3615d);
        ((WindowManager) this.f3612a.getSystemService("window")).addView(this.f3613b, this.f3615d);
    }
}
