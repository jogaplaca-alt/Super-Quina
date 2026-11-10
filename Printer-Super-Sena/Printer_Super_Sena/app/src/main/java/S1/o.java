package S1;

/* JADX INFO: loaded from: classes.dex */
public class o {
    public W1.b b(Class cls) {
        return new e(cls);
    }

    public W1.c c(Class cls, String str) {
        return new m(cls, str);
    }

    public String d(h hVar) {
        String string = hVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String e(l lVar) {
        return d(lVar);
    }

    public W1.d a(i iVar) {
        return iVar;
    }
}
