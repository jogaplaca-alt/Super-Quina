package p079y;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator f12779a = new Comparator() { // from class: y.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return e.g((byte[]) obj, (byte[]) obj2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    interface a {
        Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        void close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentProviderClient f12780a;

        b(Context context, Uri uri) {
            this.f12780a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // y.e.a
        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f12780a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e3) {
                Log.w("FontsProvider", "Unable to query the content provider", e3);
                return null;
            }
        }

        @Override // y.e.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f12780a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentProviderClient f12781a;

        c(Context context, Uri uri) {
            this.f12781a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // y.e.a
        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f12781a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e3) {
                Log.w("FontsProvider", "Unable to query the content provider", e3);
                return null;
            }
        }

        @Override // y.e.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f12781a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    private static List b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!Arrays.equals((byte[]) list.get(i3), (byte[]) list2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private static List d(f fVar, Resources resources) {
        return fVar.b() != null ? fVar.b() : androidx.core.content.res.e.c(resources, fVar.c());
    }

    static h.a e(Context context, f fVar, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoF = f(context.getPackageManager(), fVar, context.getResources());
        return providerInfoF == null ? h.a.a(1, null) : h.a.a(0, h(context, fVar, providerInfoF.authority, cancellationSignal));
    }

    static ProviderInfo f(PackageManager packageManager, f fVar, Resources resources) throws PackageManager.NameNotFoundException {
        String strE = fVar.e();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strE, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strE);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(fVar.f())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strE + ", but package was not " + fVar.f());
        }
        List listB = b(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listB, f12779a);
        List listD = d(fVar, resources);
        for (int i3 = 0; i3 < listD.size(); i3++) {
            ArrayList arrayList = new ArrayList((Collection) listD.get(i3));
            Collections.sort(arrayList, f12779a);
            if (c(listB, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b3 = bArr[i3];
            byte b4 = bArr2[i3];
            if (b3 != b4) {
                return b3 - b4;
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00d1  */
    static h.b[] h(Context context, f fVar, String str, CancellationSignal cancellationSignal) {
        boolean z3;
        ArrayList arrayList = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        a aVarA = d.a(context, uriBuild);
        Cursor cursorA = null;
        try {
            cursorA = aVarA.a(uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{fVar.g()}, null, cancellationSignal);
            if (cursorA != null && cursorA.getCount() > 0) {
                int columnIndex = cursorA.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursorA.getColumnIndex("_id");
                int columnIndex3 = cursorA.getColumnIndex("file_id");
                int columnIndex4 = cursorA.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursorA.getColumnIndex("font_weight");
                int columnIndex6 = cursorA.getColumnIndex("font_italic");
                while (cursorA.moveToNext()) {
                    int i3 = columnIndex != -1 ? cursorA.getInt(columnIndex) : 0;
                    int i4 = columnIndex4 != -1 ? cursorA.getInt(columnIndex4) : 0;
                    Uri uriWithAppendedId = columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorA.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorA.getLong(columnIndex3));
                    int i5 = columnIndex5 != -1 ? cursorA.getInt(columnIndex5) : 400;
                    if (columnIndex6 != -1) {
                        z3 = true;
                        if (cursorA.getInt(columnIndex6) != 1) {
                            z3 = false;
                        }
                    } else {
                        z3 = false;
                    }
                    h.b bVarA = h.b.a(uriWithAppendedId, i4, i5, z3, i3);
                    arrayList2 = arrayList2;
                    arrayList2.add(bVarA);
                }
                arrayList = arrayList2;
            }
            return (h.b[]) arrayList.toArray(new h.b[0]);
        } finally {
            if (cursorA != null) {
                cursorA.close();
            }
            aVarA.close();
        }
    }
}
