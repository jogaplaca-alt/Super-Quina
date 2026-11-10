package p042l1;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class p extends o {
    p() {
    }

    @Override // p042l1.o
    void b(View view) {
        if (this.f9976c == null || this.f9977d.isEmpty() || !i()) {
            return;
        }
        view.invalidate();
    }

    @Override // p042l1.o
    boolean i() {
        return true;
    }
}
