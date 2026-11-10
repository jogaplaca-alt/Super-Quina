package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SkuDetails {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f7033b;

    public SkuDetails(String str) {
        this.f7032a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f7033b = jSONObject;
        if (TextUtils.isEmpty(jSONObject.optString("productId"))) {
            throw new IllegalArgumentException("SKU cannot be empty.");
        }
        if (TextUtils.isEmpty(jSONObject.optString("type"))) {
            throw new IllegalArgumentException("SkuType cannot be empty.");
        }
    }

    public String a() {
        return this.f7033b.optString("price");
    }

    public String b() {
        return this.f7033b.optString("productId");
    }

    public String c() {
        return this.f7033b.optString("type");
    }

    public int d() {
        return this.f7033b.optInt("offer_type");
    }

    public String e() {
        return this.f7033b.optString("offer_id");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkuDetails) {
            return TextUtils.equals(this.f7032a, ((SkuDetails) obj).f7032a);
        }
        return false;
    }

    public String f() {
        String strOptString = this.f7033b.optString("offerIdToken");
        return strOptString.isEmpty() ? this.f7033b.optString("offer_id_token") : strOptString;
    }

    public final String g() {
        return this.f7033b.optString("packageName");
    }

    public String h() {
        return this.f7033b.optString("serializedDocid");
    }

    public int hashCode() {
        return this.f7032a.hashCode();
    }

    final String i() {
        return this.f7033b.optString("skuDetailsToken");
    }

    public String toString() {
        return "SkuDetails: ".concat(String.valueOf(this.f7032a));
    }
}
