package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f5724a = {112, 114, 111, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final byte[] f5725b = {112, 114, 109, 0};

    private static void A(InputStream inputStream) {
        g.h(inputStream);
        int iJ = g.j(inputStream);
        if (iJ == 6 || iJ == 7) {
            return;
        }
        while (iJ > 0) {
            g.j(inputStream);
            for (int iJ2 = g.j(inputStream); iJ2 > 0; iJ2--) {
                g.h(inputStream);
            }
            iJ--;
        }
    }

    static boolean B(OutputStream outputStream, byte[] bArr, f[] fVarArr) throws IOException {
        if (Arrays.equals(bArr, r.f5736a)) {
            N(outputStream, fVarArr);
            return true;
        }
        if (Arrays.equals(bArr, r.f5737b)) {
            M(outputStream, fVarArr);
            return true;
        }
        if (Arrays.equals(bArr, r.f5739d)) {
            K(outputStream, fVarArr);
            return true;
        }
        if (Arrays.equals(bArr, r.f5738c)) {
            L(outputStream, fVarArr);
            return true;
        }
        if (!Arrays.equals(bArr, r.f5740e)) {
            return false;
        }
        J(outputStream, fVarArr);
        return true;
    }

    private static void C(OutputStream outputStream, f fVar) throws IOException {
        int[] iArr = fVar.f5705h;
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            g.p(outputStream, i5 - i4);
            i3++;
            i4 = i5;
        }
    }

    private static s D(f[] fVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            g.p(byteArrayOutputStream, fVarArr.length);
            int i3 = 2;
            for (f fVar : fVarArr) {
                g.q(byteArrayOutputStream, fVar.f5700c);
                g.q(byteArrayOutputStream, fVar.f5701d);
                g.q(byteArrayOutputStream, fVar.f5704g);
                String strJ = j(fVar.f5698a, fVar.f5699b, r.f5736a);
                int iK = g.k(strJ);
                g.p(byteArrayOutputStream, iK);
                i3 = i3 + 14 + iK;
                g.n(byteArrayOutputStream, strJ);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i3 == byteArray.length) {
                s sVar = new s(h.DEX_FILES, i3, byteArray, false);
                byteArrayOutputStream.close();
                return sVar;
            }
            throw g.c("Expected size " + i3 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    static void E(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f5724a);
        outputStream.write(bArr);
    }

    private static void F(OutputStream outputStream, f fVar) throws IOException {
        I(outputStream, fVar);
        C(outputStream, fVar);
        H(outputStream, fVar);
    }

    private static void G(OutputStream outputStream, f fVar, String str) throws IOException {
        g.p(outputStream, g.k(str));
        g.p(outputStream, fVar.f5702e);
        g.q(outputStream, fVar.f5703f);
        g.q(outputStream, fVar.f5700c);
        g.q(outputStream, fVar.f5704g);
        g.n(outputStream, str);
    }

    private static void H(OutputStream outputStream, f fVar) throws IOException {
        byte[] bArr = new byte[k(fVar.f5704g)];
        for (Map.Entry entry : fVar.f5706i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                z(bArr, 2, iIntValue, fVar);
            }
            if ((iIntValue2 & 4) != 0) {
                z(bArr, 4, iIntValue, fVar);
            }
        }
        outputStream.write(bArr);
    }

    private static void I(OutputStream outputStream, f fVar) throws IOException {
        int i3 = 0;
        for (Map.Entry entry : fVar.f5706i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                g.p(outputStream, iIntValue - i3);
                g.p(outputStream, 0);
                i3 = iIntValue;
            }
        }
    }

    private static void J(OutputStream outputStream, f[] fVarArr) throws IOException {
        g.p(outputStream, fVarArr.length);
        for (f fVar : fVarArr) {
            String strJ = j(fVar.f5698a, fVar.f5699b, r.f5740e);
            g.p(outputStream, g.k(strJ));
            g.p(outputStream, fVar.f5706i.size());
            g.p(outputStream, fVar.f5705h.length);
            g.q(outputStream, fVar.f5700c);
            g.n(outputStream, strJ);
            Iterator it = fVar.f5706i.keySet().iterator();
            while (it.hasNext()) {
                g.p(outputStream, ((Integer) it.next()).intValue());
            }
            for (int i3 : fVar.f5705h) {
                g.p(outputStream, i3);
            }
        }
    }

    private static void K(OutputStream outputStream, f[] fVarArr) throws IOException {
        g.r(outputStream, fVarArr.length);
        for (f fVar : fVarArr) {
            int size = fVar.f5706i.size() * 4;
            String strJ = j(fVar.f5698a, fVar.f5699b, r.f5739d);
            g.p(outputStream, g.k(strJ));
            g.p(outputStream, fVar.f5705h.length);
            g.q(outputStream, size);
            g.q(outputStream, fVar.f5700c);
            g.n(outputStream, strJ);
            Iterator it = fVar.f5706i.keySet().iterator();
            while (it.hasNext()) {
                g.p(outputStream, ((Integer) it.next()).intValue());
                g.p(outputStream, 0);
            }
            for (int i3 : fVar.f5705h) {
                g.p(outputStream, i3);
            }
        }
    }

    private static void L(OutputStream outputStream, f[] fVarArr) throws IOException {
        byte[] bArrB = b(fVarArr, r.f5738c);
        g.r(outputStream, fVarArr.length);
        g.m(outputStream, bArrB);
    }

    private static void M(OutputStream outputStream, f[] fVarArr) throws IOException {
        byte[] bArrB = b(fVarArr, r.f5737b);
        g.r(outputStream, fVarArr.length);
        g.m(outputStream, bArrB);
    }

    private static void N(OutputStream outputStream, f[] fVarArr) throws IOException {
        O(outputStream, fVarArr);
    }

    private static void O(OutputStream outputStream, f[] fVarArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(fVarArr));
        arrayList.add(c(fVarArr));
        arrayList.add(d(fVarArr));
        long length2 = ((long) r.f5736a.length) + ((long) f5724a.length) + 4 + ((long) (arrayList.size() * 16));
        g.q(outputStream, arrayList.size());
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            s sVar = (s) arrayList.get(i3);
            g.q(outputStream, sVar.f5743a.b());
            g.q(outputStream, length2);
            if (sVar.f5746d) {
                byte[] bArr = sVar.f5745c;
                long length3 = bArr.length;
                byte[] bArrB = g.b(bArr);
                arrayList2.add(bArrB);
                g.q(outputStream, bArrB.length);
                g.q(outputStream, length3);
                length = bArrB.length;
            } else {
                arrayList2.add(sVar.f5745c);
                g.q(outputStream, sVar.f5745c.length);
                g.q(outputStream, 0L);
                length = sVar.f5745c.length;
            }
            length2 += (long) length;
        }
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            outputStream.write((byte[]) arrayList2.get(i4));
        }
    }

    private static int a(f fVar) {
        Iterator it = fVar.f5706i.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
        }
        return iIntValue;
    }

    private static byte[] b(f[] fVarArr, byte[] bArr) throws IOException {
        int i3 = 0;
        int iK = 0;
        for (f fVar : fVarArr) {
            iK += g.k(j(fVar.f5698a, fVar.f5699b, bArr)) + 16 + (fVar.f5702e * 2) + fVar.f5703f + k(fVar.f5704g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iK);
        if (Arrays.equals(bArr, r.f5738c)) {
            int length = fVarArr.length;
            while (i3 < length) {
                f fVar2 = fVarArr[i3];
                G(byteArrayOutputStream, fVar2, j(fVar2.f5698a, fVar2.f5699b, bArr));
                F(byteArrayOutputStream, fVar2);
                i3++;
            }
        } else {
            for (f fVar3 : fVarArr) {
                G(byteArrayOutputStream, fVar3, j(fVar3.f5698a, fVar3.f5699b, bArr));
            }
            int length2 = fVarArr.length;
            while (i3 < length2) {
                F(byteArrayOutputStream, fVarArr[i3]);
                i3++;
            }
        }
        if (byteArrayOutputStream.size() == iK) {
            return byteArrayOutputStream.toByteArray();
        }
        throw g.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iK);
    }

    private static s c(f[] fVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        for (int i4 = 0; i4 < fVarArr.length; i4++) {
            try {
                f fVar = fVarArr[i4];
                g.p(byteArrayOutputStream, i4);
                g.p(byteArrayOutputStream, fVar.f5702e);
                i3 = i3 + 4 + (fVar.f5702e * 2);
                C(byteArrayOutputStream, fVar);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i3 == byteArray.length) {
            s sVar = new s(h.CLASSES, i3, byteArray, true);
            byteArrayOutputStream.close();
            return sVar;
        }
        throw g.c("Expected size " + i3 + ", does not match actual size " + byteArray.length);
    }

    private static s d(f[] fVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        for (int i4 = 0; i4 < fVarArr.length; i4++) {
            try {
                f fVar = fVarArr[i4];
                int iA = a(fVar);
                byte[] bArrE = e(fVar);
                byte[] bArrF = f(fVar);
                g.p(byteArrayOutputStream, i4);
                int length = bArrE.length + 2 + bArrF.length;
                g.q(byteArrayOutputStream, length);
                g.p(byteArrayOutputStream, iA);
                byteArrayOutputStream.write(bArrE);
                byteArrayOutputStream.write(bArrF);
                i3 = i3 + 6 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i3 == byteArray.length) {
            s sVar = new s(h.METHODS, i3, byteArray, true);
            byteArrayOutputStream.close();
            return sVar;
        }
        throw g.c("Expected size " + i3 + ", does not match actual size " + byteArray.length);
    }

    private static byte[] e(f fVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, fVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static byte[] f(f fVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, fVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static String g(String str, String str2) {
        if ("!".equals(str2)) {
            return str.replace(":", "!");
        }
        return ":".equals(str2) ? str.replace("!", ":") : str;
    }

    private static String h(String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(":");
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    private static f i(f[] fVarArr, String str) {
        if (fVarArr.length <= 0) {
            return null;
        }
        String strH = h(str);
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            if (fVarArr[i3].f5699b.equals(strH)) {
                return fVarArr[i3];
            }
        }
        return null;
    }

    private static String j(String str, String str2, byte[] bArr) {
        String strA = r.a(bArr);
        if (str.length() <= 0) {
            return g(str2, strA);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, strA);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + r.a(bArr) + str2;
    }

    private static int k(int i3) {
        return y(i3 * 2) / 8;
    }

    private static int l(int i3, int i4, int i5) {
        if (i3 == 1) {
            throw g.c("HOT methods are not stored in the bitmap");
        }
        if (i3 == 2) {
            return i4;
        }
        if (i3 == 4) {
            return i4 + i5;
        }
        throw g.c("Unexpected flag: " + i3);
    }

    private static int[] m(InputStream inputStream, int i3) {
        int[] iArr = new int[i3];
        int iH = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            iH += g.h(inputStream);
            iArr[i4] = iH;
        }
        return iArr;
    }

    private static int n(BitSet bitSet, int i3, int i4) {
        int i5 = bitSet.get(l(2, i3, i4)) ? 2 : 0;
        return bitSet.get(l(4, i3, i4)) ? i5 | 4 : i5;
    }

    static byte[] o(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, g.d(inputStream, bArr.length))) {
            return g.d(inputStream, r.f5737b.length);
        }
        throw g.c("Invalid magic");
    }

    private static void p(InputStream inputStream, f fVar) {
        int iAvailable = inputStream.available() - fVar.f5703f;
        int iH = 0;
        while (inputStream.available() > iAvailable) {
            iH += g.h(inputStream);
            fVar.f5706i.put(Integer.valueOf(iH), 1);
            for (int iH2 = g.h(inputStream); iH2 > 0; iH2--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw g.c("Read too much data during profile line parse");
        }
    }

    static f[] q(InputStream inputStream, byte[] bArr, byte[] bArr2, f[] fVarArr) {
        if (Arrays.equals(bArr, r.f5741f)) {
            if (Arrays.equals(r.f5736a, bArr2)) {
                throw g.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return r(inputStream, bArr, fVarArr);
        }
        if (Arrays.equals(bArr, r.f5742g)) {
            return t(inputStream, bArr2, fVarArr);
        }
        throw g.c("Unsupported meta version");
    }

    static f[] r(InputStream inputStream, byte[] bArr, f[] fVarArr) throws IOException {
        if (!Arrays.equals(bArr, r.f5741f)) {
            throw g.c("Unsupported meta version");
        }
        int iJ = g.j(inputStream);
        byte[] bArrE = g.e(inputStream, (int) g.i(inputStream), (int) g.i(inputStream));
        if (inputStream.read() > 0) {
            throw g.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            f[] fVarArrS = s(byteArrayInputStream, iJ, fVarArr);
            byteArrayInputStream.close();
            return fVarArrS;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static f[] s(InputStream inputStream, int i3, f[] fVarArr) {
        if (inputStream.available() == 0) {
            return new f[0];
        }
        if (i3 != fVarArr.length) {
            throw g.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i3];
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int iH = g.h(inputStream);
            iArr[i4] = g.h(inputStream);
            strArr[i4] = g.f(inputStream, iH);
        }
        for (int i5 = 0; i5 < i3; i5++) {
            f fVar = fVarArr[i5];
            if (!fVar.f5699b.equals(strArr[i5])) {
                throw g.c("Order of dexfiles in metadata did not match baseline");
            }
            int i6 = iArr[i5];
            fVar.f5702e = i6;
            fVar.f5705h = m(inputStream, i6);
        }
        return fVarArr;
    }

    static f[] t(InputStream inputStream, byte[] bArr, f[] fVarArr) throws IOException {
        int iH = g.h(inputStream);
        byte[] bArrE = g.e(inputStream, (int) g.i(inputStream), (int) g.i(inputStream));
        if (inputStream.read() > 0) {
            throw g.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            f[] fVarArrU = u(byteArrayInputStream, bArr, iH, fVarArr);
            byteArrayInputStream.close();
            return fVarArrU;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static f[] u(InputStream inputStream, byte[] bArr, int i3, f[] fVarArr) {
        if (inputStream.available() == 0) {
            return new f[0];
        }
        if (i3 != fVarArr.length) {
            throw g.c("Mismatched number of dex files found in metadata");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            g.h(inputStream);
            String strF = g.f(inputStream, g.h(inputStream));
            long jI = g.i(inputStream);
            int iH = g.h(inputStream);
            f fVarI = i(fVarArr, strF);
            if (fVarI == null) {
                throw g.c("Missing profile key: " + strF);
            }
            fVarI.f5701d = jI;
            int[] iArrM = m(inputStream, iH);
            if (Arrays.equals(bArr, r.f5740e)) {
                fVarI.f5702e = iH;
                fVarI.f5705h = iArrM;
            }
        }
        return fVarArr;
    }

    private static void v(InputStream inputStream, f fVar) {
        BitSet bitSetValueOf = BitSet.valueOf(g.d(inputStream, g.a(fVar.f5704g * 2)));
        int i3 = 0;
        while (true) {
            int i4 = fVar.f5704g;
            if (i3 >= i4) {
                return;
            }
            int iN = n(bitSetValueOf, i3, i4);
            if (iN != 0) {
                Integer num = (Integer) fVar.f5706i.get(Integer.valueOf(i3));
                if (num == null) {
                    num = 0;
                }
                fVar.f5706i.put(Integer.valueOf(i3), Integer.valueOf(iN | num.intValue()));
            }
            i3++;
        }
    }

    static f[] w(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, r.f5737b)) {
            throw g.c("Unsupported version");
        }
        int iJ = g.j(inputStream);
        byte[] bArrE = g.e(inputStream, (int) g.i(inputStream), (int) g.i(inputStream));
        if (inputStream.read() > 0) {
            throw g.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            f[] fVarArrX = x(byteArrayInputStream, str, iJ);
            byteArrayInputStream.close();
            return fVarArrX;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static f[] x(InputStream inputStream, String str, int i3) {
        if (inputStream.available() == 0) {
            return new f[0];
        }
        f[] fVarArr = new f[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int iH = g.h(inputStream);
            int iH2 = g.h(inputStream);
            long jI = g.i(inputStream);
            fVarArr[i4] = new f(str, g.f(inputStream, iH), g.i(inputStream), 0L, iH2, (int) jI, (int) g.i(inputStream), new int[iH2], new TreeMap());
        }
        for (int i5 = 0; i5 < i3; i5++) {
            f fVar = fVarArr[i5];
            p(inputStream, fVar);
            fVar.f5705h = m(inputStream, fVar.f5702e);
            v(inputStream, fVar);
        }
        return fVarArr;
    }

    private static int y(int i3) {
        return (i3 + 7) & (-8);
    }

    private static void z(byte[] bArr, int i3, int i4, f fVar) {
        int iL = l(i3, i4, fVar.f5704g);
        int i5 = iL / 8;
        bArr[i5] = (byte) ((1 << (iL % 8)) | bArr[i5]);
    }
}
