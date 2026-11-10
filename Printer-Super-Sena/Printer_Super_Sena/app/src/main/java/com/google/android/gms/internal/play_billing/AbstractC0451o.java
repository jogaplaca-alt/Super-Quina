package com.google.android.gms.internal.play_billing;

import java.util.Set;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0451o extends AbstractC0428h implements Set {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient AbstractC0439k f7482b;

    AbstractC0451o() {
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return AbstractC0477x.a(this);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h
    public AbstractC0439k m() {
        AbstractC0439k abstractC0439k = this.f7482b;
        if (abstractC0439k != null) {
            return abstractC0439k;
        }
        AbstractC0439k abstractC0439kP = p();
        this.f7482b = abstractC0439kP;
        return abstractC0439kP;
    }

    AbstractC0439k p() {
        Object[] array = toArray();
        int i3 = AbstractC0439k.f7457c;
        return AbstractC0439k.q(array, array.length);
    }
}
