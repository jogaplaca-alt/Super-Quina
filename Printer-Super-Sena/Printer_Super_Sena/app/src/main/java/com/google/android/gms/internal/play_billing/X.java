package com.google.android.gms.internal.play_billing;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class X implements Comparator {
    X() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AbstractC0421f0 abstractC0421f0 = (AbstractC0421f0) obj;
        AbstractC0421f0 abstractC0421f1 = (AbstractC0421f0) obj2;
        W w3 = new W(abstractC0421f0);
        W w4 = new W(abstractC0421f1);
        while (w3.hasNext() && w4.hasNext()) {
            int iCompareTo = Integer.valueOf(w3.c() & 255).compareTo(Integer.valueOf(w4.c() & 255));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(abstractC0421f0.l()).compareTo(Integer.valueOf(abstractC0421f1.l()));
    }
}
