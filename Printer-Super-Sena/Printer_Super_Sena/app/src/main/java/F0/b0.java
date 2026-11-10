package F0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Uri f872f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ComponentName f875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f877e;

    public b0(String str, String str2, int i3, boolean z3) {
        AbstractC0220n.d(str);
        this.f873a = str;
        AbstractC0220n.d(str2);
        this.f874b = str2;
        this.f875c = null;
        this.f876d = 4225;
        this.f877e = z3;
    }

    public final ComponentName a() {
        return this.f875c;
    }

    public final Intent b(Context context) {
        Bundle bundleCall;
        if (this.f873a == null) {
            return new Intent().setComponent(this.f875c);
        }
        Intent intent = null;
        if (this.f877e) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", this.f873a);
            try {
                bundleCall = context.getContentResolver().call(f872f, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e3) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e3.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f873a)));
            }
        }
        return intent == null ? new Intent(this.f873a).setPackage(this.f874b) : intent;
    }

    public final String c() {
        return this.f874b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return AbstractC0219m.a(this.f873a, b0Var.f873a) && AbstractC0219m.a(this.f874b, b0Var.f874b) && AbstractC0219m.a(this.f875c, b0Var.f875c) && this.f877e == b0Var.f877e;
    }

    public final int hashCode() {
        return AbstractC0219m.b(this.f873a, this.f874b, this.f875c, 4225, Boolean.valueOf(this.f877e));
    }

    public final String toString() {
        String str = this.f873a;
        if (str != null) {
            return str;
        }
        AbstractC0220n.f(this.f875c);
        return this.f875c.flattenToString();
    }
}
