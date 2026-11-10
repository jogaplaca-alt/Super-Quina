package p065t0;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static Object a(int i3, Object obj, a aVar, c cVar) {
        Object objA;
        if (i3 < 1) {
            return aVar.a(obj);
        }
        do {
            objA = aVar.a(obj);
            obj = cVar.a(obj, objA);
            if (obj == null) {
                break;
            }
            i3--;
        } while (i3 >= 1);
        return objA;
    }
}
