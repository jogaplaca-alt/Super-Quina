package S1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class l implements h, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1947a;

    public l(int i3) {
        this.f1947a = i3;
    }

    public String toString() {
        String strD = n.d(this);
        k.d(strD, "renderLambdaToString(this)");
        return strD;
    }
}
