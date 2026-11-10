package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4585b;

    public H(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f4584a | this.f4585b;
    }

    public void b(View view, View view2, int i3) {
        c(view, view2, i3, 0);
    }

    public void c(View view, View view2, int i3, int i4) {
        if (i4 == 1) {
            this.f4585b = i3;
        } else {
            this.f4584a = i3;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i3) {
        if (i3 == 1) {
            this.f4585b = 0;
        } else {
            this.f4584a = 0;
        }
    }
}
