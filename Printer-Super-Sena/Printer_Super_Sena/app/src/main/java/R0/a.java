package R0;

/* JADX INFO: loaded from: classes.dex */
public final class a extends IllegalStateException {
    private a(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException a(d dVar) {
        String strConcat;
        if (!dVar.f()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception excC = dVar.c();
        if (excC != null) {
            strConcat = "failure";
        } else if (dVar.g()) {
            strConcat = "result ".concat(String.valueOf(dVar.d()));
        } else {
            strConcat = dVar.e() ? "cancellation" : "unknown issue";
        }
        return new a("Complete with: ".concat(strConcat), excC);
    }
}
