package com.google.android.gms.auth.api.signin;

import F0.AbstractC0220n;
import J0.b;
import J0.c;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInAccount extends G0.a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f7190n = c.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f7191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f7193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f7194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f7195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Uri f7196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f7197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f7198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f7199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final List f7200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f7201k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f7202l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Set f7203m = new HashSet();

    GoogleSignInAccount(int i3, String str, String str2, String str3, String str4, Uri uri, String str5, long j3, String str6, List list, String str7, String str8) {
        this.f7191a = i3;
        this.f7192b = str;
        this.f7193c = str2;
        this.f7194d = str3;
        this.f7195e = str4;
        this.f7196f = uri;
        this.f7197g = str5;
        this.f7198h = j3;
        this.f7199i = str6;
        this.f7200j = list;
        this.f7201k = str7;
        this.f7202l = str8;
    }

    public static GoogleSignInAccount l(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l3, String str7, Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l3.longValue(), AbstractC0220n.d(str7), new ArrayList((Collection) AbstractC0220n.f(set)), str5, str6);
    }

    public static GoogleSignInAccount m(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j3 = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            hashSet.add(new Scope(jSONArray.getString(i3)));
        }
        GoogleSignInAccount googleSignInAccountL = l(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, uri, Long.valueOf(j3), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        googleSignInAccountL.f7197g = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccountL;
    }

    public String c() {
        return this.f7195e;
    }

    public String d() {
        return this.f7194d;
    }

    public String e() {
        return this.f7202l;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f7199i.equals(this.f7199i) && googleSignInAccount.j().equals(j());
    }

    public String f() {
        return this.f7201k;
    }

    public String g() {
        return this.f7192b;
    }

    public String h() {
        return this.f7193c;
    }

    public int hashCode() {
        return ((this.f7199i.hashCode() + 527) * 31) + j().hashCode();
    }

    public Uri i() {
        return this.f7196f;
    }

    public Set j() {
        HashSet hashSet = new HashSet(this.f7200j);
        hashSet.addAll(this.f7203m);
        return hashSet;
    }

    public String k() {
        return this.f7197g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = G0.c.a(parcel);
        G0.c.f(parcel, 1, this.f7191a);
        G0.c.j(parcel, 2, g(), false);
        G0.c.j(parcel, 3, h(), false);
        G0.c.j(parcel, 4, d(), false);
        G0.c.j(parcel, 5, c(), false);
        G0.c.i(parcel, 6, i(), i3, false);
        G0.c.j(parcel, 7, k(), false);
        G0.c.h(parcel, 8, this.f7198h);
        G0.c.j(parcel, 9, this.f7199i, false);
        G0.c.m(parcel, 10, this.f7200j, false);
        G0.c.j(parcel, 11, f(), false);
        G0.c.j(parcel, 12, e(), false);
        G0.c.b(parcel, iA);
    }
}
