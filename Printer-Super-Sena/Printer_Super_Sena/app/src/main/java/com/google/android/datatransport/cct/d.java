package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import p047n0.j;
import p047n0.k;
import p047n0.l;
import p047n0.n;
import p047n0.o;
import p047n0.p;
import p050o0.h;
import p050o0.i;
import p053p0.f;
import p053p0.g;
import p053p0.m;
import rawbt.sdk.btpair.BtScanActivity;

/* JADX INFO: loaded from: classes.dex */
final class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p063s1.a f7177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConnectivityManager f7178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f7179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final URL f7180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final p080y0.a f7181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final p080y0.a f7182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f7183g;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final URL f7184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final j f7185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f7186c;

        a(URL url, j jVar, String str) {
            this.f7184a = url;
            this.f7185b = jVar;
            this.f7186c = str;
        }

        a a(URL url) {
            return new a(url, this.f7185b, this.f7186c);
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f7187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final URL f7188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f7189c;

        b(int i3, URL url, long j3) {
            this.f7187a = i3;
            this.f7188b = url;
            this.f7189c = j3;
        }
    }

    d(Context context, p080y0.a aVar, p080y0.a aVar2, int i3) {
        this.f7177a = j.b();
        this.f7179c = context;
        this.f7178b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f7180d = n(com.google.android.datatransport.cct.a.f7168c);
        this.f7181e = aVar2;
        this.f7182f = aVar;
        this.f7183g = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b e(a aVar) throws IOException {
        p062s0.a.f("CctTransportBackend", "Making request to: %s", aVar.f7184a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f7184a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f7183g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "3.1.8"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f7186c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f7177a.a(aVar.f7185b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    p062s0.a.f("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
                    p062s0.a.b("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    p062s0.a.b("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream inputStreamM = m(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                        try {
                            b bVar = new b(responseCode, null, n.b(new BufferedReader(new InputStreamReader(inputStreamM))).c());
                            if (inputStreamM != null) {
                                inputStreamM.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } catch (Throwable th) {
                            if (inputStreamM != null) {
                                try {
                                    inputStreamM.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                        }
                        throw th3;
                    }
                } catch (Throwable th5) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                    throw th5;
                }
            } catch (Throwable th7) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th8) {
                        th7.addSuppressed(th8);
                    }
                }
                throw th7;
            }
        } catch (ConnectException e3) {
            e = e3;
            p062s0.a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e4) {
            e = e4;
            p062s0.a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e5) {
            e = e5;
            p062s0.a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        } catch (p063s1.b e6) {
            e = e6;
            p062s0.a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        }
    }

    private static int f(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return o.b.UNKNOWN_MOBILE_SUBTYPE.b();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return o.b.COMBINED.b();
        }
        if (o.b.a(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private static int g(NetworkInfo networkInfo) {
        return networkInfo == null ? o.c.NONE.b() : networkInfo.getType();
    }

    private static int h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e3) {
            p062s0.a.d("CctTransportBackend", "Unable to find version code for package", e3);
            return -1;
        }
    }

    private j i(f fVar) {
        l.a aVarJ;
        HashMap map = new HashMap();
        for (i iVar : fVar.b()) {
            String strJ = iVar.j();
            if (map.containsKey(strJ)) {
                ((List) map.get(strJ)).add(iVar);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(iVar);
                map.put(strJ, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            i iVar2 = (i) ((List) entry.getValue()).get(0);
            n0.m.a aVarB = p047n0.m.a().f(p.DEFAULT).g(this.f7182f.a()).h(this.f7181e.a()).b(k.a().c(k.b.ANDROID_FIREBASE).b(p047n0.a.a().m(Integer.valueOf(iVar2.g("sdk-version"))).j(iVar2.b("model")).f(iVar2.b("hardware")).d(iVar2.b(BtScanActivity.RESULT_OK_EXTRA)).l(iVar2.b("product")).k(iVar2.b("os-uild")).h(iVar2.b("manufacturer")).e(iVar2.b("fingerprint")).c(iVar2.b("country")).g(iVar2.b("locale")).i(iVar2.b("mcc_mnc")).b(iVar2.b("application_build")).a()).a());
            try {
                aVarB.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                aVarB.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (i iVar3 : (List) entry.getValue()) {
                h hVarE = iVar3.e();
                p044m0.b bVarB = hVarE.b();
                if (bVarB.equals(p044m0.b.b("proto"))) {
                    aVarJ = l.j(hVarE.a());
                } else if (bVarB.equals(p044m0.b.b("json"))) {
                    aVarJ = l.i(new String(hVarE.a(), Charset.forName("UTF-8")));
                } else {
                    p062s0.a.g("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", bVarB);
                }
                aVarJ.c(iVar3.f()).d(iVar3.k()).h(iVar3.h("tz-offset")).e(o.a().c(o.c.a(iVar3.g("net-type"))).b(o.b.a(iVar3.g("mobile-subtype"))).a());
                if (iVar3.d() != null) {
                    aVarJ.b(iVar3.d());
                }
                arrayList3.add(aVarJ.a());
            }
            aVarB.c(arrayList3);
            arrayList2.add(aVarB.a());
        }
        return j.a(arrayList2);
    }

    private static TelephonyManager j(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    static long k() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ a l(a aVar, b bVar) {
        URL url = bVar.f7188b;
        if (url == null) {
            return null;
        }
        p062s0.a.b("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f7188b);
    }

    private static InputStream m(InputStream inputStream, String str) {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    private static URL n(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e3) {
            throw new IllegalArgumentException("Invalid url: " + str, e3);
        }
    }

    @Override // p053p0.m
    public g a(f fVar) {
        j jVarI = i(fVar);
        URL urlN = this.f7180d;
        String strD = null;
        if (fVar.c() != null) {
            try {
                com.google.android.datatransport.cct.a aVarC = com.google.android.datatransport.cct.a.c(fVar.c());
                strD = aVarC.d() != null ? aVarC.d() : null;
                if (aVarC.e() != null) {
                    urlN = n(aVarC.e());
                }
            } catch (IllegalArgumentException unused) {
                return g.a();
            }
        }
        try {
            b bVar = (b) p065t0.b.a(5, new a(urlN, jVarI, strD), new p065t0.a() { // from class: com.google.android.datatransport.cct.b
                @Override // p065t0.a
                public final Object a(Object obj) {
                    return this.f7176a.e((d.a) obj);
                }
            }, new p065t0.c() { // from class: com.google.android.datatransport.cct.c
                @Override // p065t0.c
                public final Object a(Object obj, Object obj2) {
                    return d.l((d.a) obj, (d.b) obj2);
                }
            });
            int i3 = bVar.f7187a;
            if (i3 == 200) {
                return g.e(bVar.f7189c);
            }
            if (i3 < 500 && i3 != 404) {
                return i3 == 400 ? g.d() : g.a();
            }
            return g.f();
        } catch (IOException e3) {
            p062s0.a.d("CctTransportBackend", "Could not make request to the backend", e3);
            return g.f();
        }
    }

    @Override // p053p0.m
    public i b(i iVar) {
        NetworkInfo activeNetworkInfo = this.f7178b.getActiveNetworkInfo();
        return iVar.l().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c(BtScanActivity.RESULT_OK_EXTRA, Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", k()).a("net-type", g(activeNetworkInfo)).a("mobile-subtype", f(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", j(this.f7179c).getSimOperator()).c("application_build", Integer.toString(h(this.f7179c))).d();
    }

    d(Context context, p080y0.a aVar, p080y0.a aVar2) {
        this(context, aVar, aVar2, 130000);
    }
}
