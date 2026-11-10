package p042l1;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes.dex */
class t extends o {

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (t.this.f9978e.isEmpty()) {
                return;
            }
            outline.setPath(t.this.f9978e);
        }
    }

    t(View view) {
        k(view);
    }

    private void k(View view) {
        view.setOutlineProvider(new a());
    }

    @Override // p042l1.o
    void b(View view) {
        view.setClipToOutline(!i());
        if (i()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    @Override // p042l1.o
    boolean i() {
        return this.f9974a;
    }
}
