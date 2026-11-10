package p025g0;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static View a(View view, int i3) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View viewFindViewById = viewGroup.getChildAt(i4).findViewById(i3);
            if (viewFindViewById != null) {
                return viewFindViewById;
            }
        }
        return null;
    }
}
