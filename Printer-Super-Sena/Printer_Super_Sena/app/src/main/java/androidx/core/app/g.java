package androidx.core.app;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Configuration f4270b;

    public g(boolean z3) {
        this.f4269a = z3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(boolean z3, Configuration configuration) {
        this(z3);
        S1.k.e(configuration, "newConfig");
        this.f4270b = configuration;
    }
}
