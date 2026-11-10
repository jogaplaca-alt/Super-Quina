package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f4355e = {"_display_name", "_size"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final File f4356f = new File("/");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final HashMap f4357g = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f4358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f4360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f4361d;

    static class a {
        static File[] a(Context context) {
            return context.getExternalMediaDirs();
        }
    }

    interface b {
        File a(Uri uri);

        Uri b(File file);
    }

    static class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HashMap f4363b = new HashMap();

        c(String str) {
            this.f4362a = str;
        }

        private boolean d(String str, String str2) {
            String strK = FileProvider.k(str);
            String strK2 = FileProvider.k(str2);
            if (!strK.equals(strK2)) {
                if (!strK.startsWith(strK2 + '/')) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.core.content.FileProvider.b
        public File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = (File) this.f4363b.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (d(canonicalFile.getPath(), file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }

        @Override // androidx.core.content.FileProvider.b
        public Uri b(File file) {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry entry = null;
                for (Map.Entry entry2 : this.f4363b.entrySet()) {
                    String path = ((File) entry2.getValue()).getPath();
                    if (d(canonicalPath, path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                String path2 = ((File) entry.getValue()).getPath();
                return new Uri.Builder().scheme("content").authority(this.f4362a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        void c(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.f4363b.put(str, file.getCanonicalFile());
            } catch (IOException e3) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e3);
            }
        }
    }

    public FileProvider() {
        this(0);
    }

    private static File b(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static Object[] c(Object[] objArr, int i3) {
        Object[] objArr2 = new Object[i3];
        System.arraycopy(objArr, 0, objArr2, 0, i3);
        return objArr2;
    }

    private static String[] d(String[] strArr, int i3) {
        String[] strArr2 = new String[i3];
        System.arraycopy(strArr, 0, strArr2, 0, i3);
        return strArr2;
    }

    static XmlResourceParser e(Context context, String str, ProviderInfo providerInfo, int i3) {
        if (providerInfo == null) {
            throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
        }
        if (providerInfo.metaData == null && i3 != 0) {
            Bundle bundle = new Bundle(1);
            providerInfo.metaData = bundle;
            bundle.putInt("android.support.FILE_PROVIDER_PATHS", i3);
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlResourceParserLoadXmlMetaData != null) {
            return xmlResourceParserLoadXmlMetaData;
        }
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }

    private b f() {
        b bVar;
        synchronized (this.f4358a) {
            try {
                p082z.c.d(this.f4359b, "mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
                if (this.f4360c == null) {
                    this.f4360c = g(getContext(), this.f4359b, this.f4361d);
                }
                bVar = this.f4360c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private static b g(Context context, String str, int i3) {
        b bVarJ;
        HashMap map = f4357g;
        synchronized (map) {
            try {
                bVarJ = (b) map.get(str);
                if (bVarJ == null) {
                    try {
                        try {
                            bVarJ = j(context, str, i3);
                            map.put(str, bVarJ);
                        } catch (IOException e3) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e3);
                        }
                    } catch (XmlPullParserException e4) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e4);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVarJ;
    }

    public static Uri h(Context context, String str, File file) {
        return g(context, str, 0).b(file);
    }

    private static int i(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    private static b j(Context context, String str, int i3) throws XmlPullParserException, IOException {
        c cVar = new c(str);
        XmlResourceParser xmlResourceParserE = e(context, str, context.getPackageManager().resolveContentProvider(str, 128), i3);
        while (true) {
            int next = xmlResourceParserE.next();
            if (next == 1) {
                return cVar;
            }
            if (next == 2) {
                String name = xmlResourceParserE.getName();
                File externalStorageDirectory = null;
                String attributeValue = xmlResourceParserE.getAttributeValue(null, "name");
                String attributeValue2 = xmlResourceParserE.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    externalStorageDirectory = f4356f;
                } else if ("files-path".equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    externalStorageDirectory = Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    File[] fileArrF = androidx.core.content.a.f(context, null);
                    if (fileArrF.length > 0) {
                        externalStorageDirectory = fileArrF[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] fileArrE = androidx.core.content.a.e(context);
                    if (fileArrE.length > 0) {
                        externalStorageDirectory = fileArrE[0];
                    }
                } else if (Build.VERSION.SDK_INT >= 21 && "external-media-path".equals(name)) {
                    File[] fileArrA = a.a(context);
                    if (fileArrA.length > 0) {
                        externalStorageDirectory = fileArrA[0];
                    }
                }
                if (externalStorageDirectory != null) {
                    cVar.c(attributeValue, b(externalStorageDirectory, attributeValue2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String k(String str) {
        return (str.length() <= 0 || str.charAt(str.length() + (-1)) != '/') ? str : str.substring(0, str.length() - 1);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        String str = providerInfo.authority.split(";")[0];
        synchronized (this.f4358a) {
            this.f4359b = str;
        }
        HashMap map = f4357g;
        synchronized (map) {
            map.remove(str);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return f().a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File fileA = f().a(uri);
        int iLastIndexOf = fileA.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileA.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public String getTypeAnonymous(Uri uri) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(f().a(uri), i(str));
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i3;
        File fileA = f().a(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = f4355e;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i4 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i4] = "_display_name";
                i3 = i4 + 1;
                objArr[i4] = queryParameter == null ? fileA.getName() : queryParameter;
            } else {
                if ("_size".equals(str3)) {
                    strArr3[i4] = "_size";
                    i3 = i4 + 1;
                    objArr[i4] = Long.valueOf(fileA.length());
                }
            }
            i4 = i3;
        }
        String[] strArrD = d(strArr3, i4);
        Object[] objArrC = c(objArr, i4);
        MatrixCursor matrixCursor = new MatrixCursor(strArrD, 1);
        matrixCursor.addRow(objArrC);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    protected FileProvider(int i3) {
        this.f4358a = new Object();
        this.f4361d = i3;
    }
}
