package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Purchase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JSONObject f7031c;

    public Purchase(String str, String str2) {
        this.f7029a = str;
        this.f7030b = str2;
        this.f7031c = new JSONObject(str);
    }

    private final ArrayList k() {
        ArrayList arrayList = new ArrayList();
        if (this.f7031c.has("productIds")) {
            JSONArray jSONArrayOptJSONArray = this.f7031c.optJSONArray("productIds");
            if (jSONArrayOptJSONArray != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i3));
                }
            }
        } else if (this.f7031c.has("productId")) {
            arrayList.add(this.f7031c.optString("productId"));
        }
        return arrayList;
    }

    public String a() {
        String strOptString = this.f7031c.optString("orderId");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return strOptString;
    }

    public String b() {
        return this.f7029a;
    }

    public String c() {
        return this.f7031c.optString("packageName");
    }

    public List d() {
        return k();
    }

    public int e() {
        return this.f7031c.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.f7029a, purchase.b()) && TextUtils.equals(this.f7030b, purchase.h());
    }

    public long f() {
        return this.f7031c.optLong("purchaseTime");
    }

    public String g() {
        JSONObject jSONObject = this.f7031c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public String h() {
        return this.f7030b;
    }

    public int hashCode() {
        return this.f7029a.hashCode();
    }

    public ArrayList i() {
        return k();
    }

    public boolean j() {
        return this.f7031c.optBoolean("acknowledged", true);
    }

    public String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.f7029a));
    }
}
