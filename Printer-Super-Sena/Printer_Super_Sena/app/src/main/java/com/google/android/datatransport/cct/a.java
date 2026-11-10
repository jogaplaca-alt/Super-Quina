package com.google.android.datatransport.cct;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import p050o0.g;

/* JADX INFO: loaded from: classes.dex */
public final class a implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String f7168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String f7169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f7170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set f7171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f7172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f7173h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7175b;

    static {
        String strA = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f7168c = strA;
        String strA2 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f7169d = strA2;
        String strA3 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f7170e = strA3;
        f7171f = Collections.unmodifiableSet(new HashSet(Arrays.asList(p044m0.b.b("proto"), p044m0.b.b("json"))));
        f7172g = new a(strA, null);
        f7173h = new a(strA2, strA3);
    }

    public a(String str, String str2) {
        this.f7174a = str;
        this.f7175b = str2;
    }

    public static a c(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }

    @Override // p050o0.g
    public Set a() {
        return f7171f;
    }

    public byte[] b() {
        String str = this.f7175b;
        if (str == null && this.f7174a == null) {
            return null;
        }
        String str2 = this.f7174a;
        if (str == null) {
            str = "";
        }
        return String.format("%s%s%s%s", "1$", str2, "\\", str).getBytes(Charset.forName("UTF-8"));
    }

    public String d() {
        return this.f7175b;
    }

    public String e() {
        return this.f7174a;
    }

    @Override // p050o0.f
    public byte[] getExtras() {
        return b();
    }

    @Override // p050o0.f
    public String getName() {
        return "cct";
    }
}
