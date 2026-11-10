package com.android.billingclient.api;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.android.billingclient.api.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0392c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f7068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f7069c;

    C0392c(String str) {
        this.f7067a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f7068b = jSONObject;
        this.f7069c = jSONObject.optString("countryCode");
    }

    public String a() {
        return this.f7069c;
    }
}
