package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f6711b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f6710a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList f6712c = new ArrayList();

    public y(View view) {
        this.f6711b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f6711b == yVar.f6711b && this.f6710a.equals(yVar.f6710a);
    }

    public int hashCode() {
        return (this.f6711b.hashCode() * 31) + this.f6710a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f6711b + "\n") + "    values:";
        for (String str2 : this.f6710a.keySet()) {
            str = str + "    " + str2 + ": " + this.f6710a.get(str2) + "\n";
        }
        return str;
    }
}
