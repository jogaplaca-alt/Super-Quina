package p083z0;

import android.util.SparseArray;
import java.util.HashMap;
import p044m0.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SparseArray f12982a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HashMap f12983b;

    static {
        HashMap map = new HashMap();
        f12983b = map;
        map.put(d.DEFAULT, 0);
        f12983b.put(d.VERY_LOW, 1);
        f12983b.put(d.HIGHEST, 2);
        for (d dVar : f12983b.keySet()) {
            f12982a.append(((Integer) f12983b.get(dVar)).intValue(), dVar);
        }
    }

    public static int a(d dVar) {
        Integer num = (Integer) f12983b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    public static d b(int i3) {
        d dVar = (d) f12982a.get(i3);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i3);
    }
}
