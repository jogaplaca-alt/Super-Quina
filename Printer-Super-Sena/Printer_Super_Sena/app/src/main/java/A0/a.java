package A0;

import F0.AbstractC0220n;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lock f60c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f61d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lock f62a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f63b;

    a(Context context) {
        this.f63b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        AbstractC0220n.f(context);
        f60c.lock();
        try {
            if (f61d == null) {
                f61d = new a(context.getApplicationContext());
            }
            return f61d;
        } finally {
            f60c.unlock();
        }
    }

    private static final String d(String str, String str2) {
        return str + ":" + str2;
    }

    public GoogleSignInAccount b() {
        String strC;
        String strC2 = c("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strC2) || (strC = c(d("googleSignInAccount", strC2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.m(strC);
        } catch (JSONException unused) {
            return null;
        }
    }

    protected final String c(String str) {
        this.f62a.lock();
        try {
            return this.f63b.getString(str, null);
        } finally {
            this.f62a.unlock();
        }
    }
}
