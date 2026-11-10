package androidx.core.view;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes.dex */
public final class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f4591a;

    /* JADX INFO: Access modifiers changed from: private */
    static class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f4592a;

        a(View view) {
            this.f4592a = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(View view) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }

        @Override // androidx.core.view.O.c
        void a() {
            final View viewFindViewById = this.f4592a;
            if (viewFindViewById == null) {
                return;
            }
            if (viewFindViewById.isInEditMode() || viewFindViewById.onCheckIsTextEditor()) {
                viewFindViewById.requestFocus();
            } else {
                viewFindViewById = viewFindViewById.getRootView().findFocus();
            }
            if (viewFindViewById == null) {
                viewFindViewById = this.f4592a.getRootView().findViewById(R.id.content);
            }
            if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
                return;
            }
            viewFindViewById.post(new Runnable() { // from class: androidx.core.view.N
                @Override // java.lang.Runnable
                public final void run() {
                    O.a.c(viewFindViewById);
                }
            });
        }
    }

    private static class c {
        c() {
        }

        void a() {
        }
    }

    public O(View view) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            this.f4591a = new b(view);
        } else if (i3 >= 20) {
            this.f4591a = new a(view);
        } else {
            this.f4591a = new c();
        }
    }

    public void a() {
        this.f4591a.a();
    }

    private static class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private View f4593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WindowInsetsController f4594c;

        b(View view) {
            super(view);
            this.f4593b = view;
        }

        @Override // androidx.core.view.O.a, androidx.core.view.O.c
        void a() {
            View view = this.f4593b;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = this.f4594c;
            if (windowInsetsController == null) {
                View view2 = this.f4593b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            } else {
                super.a();
            }
        }

        b(WindowInsetsController windowInsetsController) {
            super(null);
            this.f4594c = windowInsetsController;
        }
    }

    O(WindowInsetsController windowInsetsController) {
        this.f4591a = new b(windowInsetsController);
    }
}
