package K1;

import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class q extends p {
    public static int k(Iterable iterable, int i3) {
        S1.k.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i3;
    }
}
