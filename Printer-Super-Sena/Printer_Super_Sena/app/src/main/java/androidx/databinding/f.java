package androidx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f4833a = new DataBinderMapperImpl();

    static h a(e eVar, View view, int i3) {
        return f4833a.b(eVar, view, i3);
    }

    static h b(e eVar, View[] viewArr, int i3) {
        return f4833a.c(eVar, viewArr, i3);
    }

    private static h c(e eVar, ViewGroup viewGroup, int i3, int i4) {
        int childCount = viewGroup.getChildCount();
        int i5 = childCount - i3;
        if (i5 == 1) {
            return a(eVar, viewGroup.getChildAt(childCount - 1), i4);
        }
        View[] viewArr = new View[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            viewArr[i6] = viewGroup.getChildAt(i6 + i3);
        }
        return b(eVar, viewArr, i4);
    }

    public static h d(LayoutInflater layoutInflater, int i3, ViewGroup viewGroup, boolean z3) {
        return e(layoutInflater, i3, viewGroup, z3, null);
    }

    public static h e(LayoutInflater layoutInflater, int i3, ViewGroup viewGroup, boolean z3, e eVar) {
        boolean z4 = viewGroup != null && z3;
        return z4 ? c(eVar, viewGroup, z4 ? viewGroup.getChildCount() : 0, i3) : a(eVar, layoutInflater.inflate(i3, viewGroup, z3), i3);
    }
}
