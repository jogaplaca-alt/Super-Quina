package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
final class M extends B implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MessageDigest f7345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f7347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f7348d;

    M(String str, String str2) {
        MessageDigest messageDigestC = c("SHA-256");
        this.f7345a = messageDigestC;
        this.f7346b = messageDigestC.getDigestLength();
        this.f7348d = "Hashing.sha256()";
        this.f7347c = d(messageDigestC);
    }

    private static MessageDigest c(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e3) {
            throw new AssertionError(e3);
        }
    }

    private static boolean d(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G
    public final H a() {
        K k3 = null;
        if (this.f7347c) {
            try {
                return new L((MessageDigest) this.f7345a.clone(), this.f7346b, k3);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new L(c(this.f7345a.getAlgorithm()), this.f7346b, k3);
    }

    public final String toString() {
        return this.f7348d;
    }
}
