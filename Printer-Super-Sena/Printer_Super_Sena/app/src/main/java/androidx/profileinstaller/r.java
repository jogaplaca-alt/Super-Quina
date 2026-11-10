package androidx.profileinstaller;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f5736a = {48, 49, 53, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final byte[] f5737b = {48, 49, 48, 0};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final byte[] f5738c = {48, 48, 57, 0};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final byte[] f5739d = {48, 48, 53, 0};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final byte[] f5740e = {48, 48, 49, 0};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final byte[] f5741f = {48, 48, 49, 0};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final byte[] f5742g = {48, 48, 50, 0};

    static String a(byte[] bArr) {
        return (Arrays.equals(bArr, f5740e) || Arrays.equals(bArr, f5739d)) ? ":" : "!";
    }
}
