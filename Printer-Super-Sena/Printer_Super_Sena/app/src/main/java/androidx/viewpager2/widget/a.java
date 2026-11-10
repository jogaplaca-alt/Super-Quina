package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f6874b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayoutManager f6875a;

    /* JADX INFO: renamed from: androidx.viewpager2.widget.a$a, reason: collision with other inner class name */
    class C0096a implements Comparator {
        C0096a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f6874b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    a(LinearLayoutManager linearLayoutManager) {
        this.f6875a = linearLayoutManager;
    }

    private boolean a() {
        int top;
        int i3;
        int bottom;
        int i4;
        int iO = this.f6875a.O();
        if (iO == 0) {
            return true;
        }
        boolean z3 = this.f6875a.t2() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iO, 2);
        for (int i5 = 0; i5 < iO; i5++) {
            View viewN = this.f6875a.N(i5);
            if (viewN == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = viewN.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f6874b;
            int[] iArr2 = iArr[i5];
            if (z3) {
                top = viewN.getLeft();
                i3 = marginLayoutParams.leftMargin;
            } else {
                top = viewN.getTop();
                i3 = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - i3;
            int[] iArr3 = iArr[i5];
            if (z3) {
                bottom = viewN.getRight();
                i4 = marginLayoutParams.rightMargin;
            } else {
                bottom = viewN.getBottom();
                i4 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i4;
        }
        Arrays.sort(iArr, new C0096a());
        for (int i6 = 1; i6 < iO; i6++) {
            if (iArr[i6 - 1][1] != iArr[i6][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i7 = iArr4[1];
        int i8 = iArr4[0];
        return i8 <= 0 && iArr[iO - 1][1] >= i7 - i8;
    }

    private boolean b() {
        int iO = this.f6875a.O();
        for (int i3 = 0; i3 < iO; i3++) {
            if (c(this.f6875a.N(i3))) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (c(viewGroup.getChildAt(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean d() {
        return (!a() || this.f6875a.O() <= 1) && b();
    }
}
