package D0;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class b extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Status f175a;

    public b(Status status) {
        super(status.d() + ": " + (status.e() != null ? status.e() : ""));
        this.f175a = status;
    }

    public Status a() {
        return this.f175a;
    }
}
