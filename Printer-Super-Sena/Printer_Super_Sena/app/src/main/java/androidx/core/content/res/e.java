package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    static class a {
        static int a(TypedArray typedArray, int i3) {
            return typedArray.getType(i3);
        }
    }

    public interface b {
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d[] f4383a;

        public c(d[] dVarArr) {
            this.f4383a = dVarArr;
        }

        public d[] a() {
            return this.f4383a;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f4385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f4386c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f4387d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f4388e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f4389f;

        public d(String str, int i3, boolean z3, String str2, int i4, int i5) {
            this.f4384a = str;
            this.f4385b = i3;
            this.f4386c = z3;
            this.f4387d = str2;
            this.f4388e = i4;
            this.f4389f = i5;
        }

        public String a() {
            return this.f4384a;
        }

        public int b() {
            return this.f4389f;
        }

        public int c() {
            return this.f4388e;
        }

        public String d() {
            return this.f4387d;
        }

        public int e() {
            return this.f4385b;
        }

        public boolean f() {
            return this.f4386c;
        }
    }

    /* JADX INFO: renamed from: androidx.core.content.res.e$e, reason: collision with other inner class name */
    public static final class C0053e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p079y.f f4390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f4391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f4392c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f4393d;

        public C0053e(p079y.f fVar, int i3, int i4, String str) {
            this.f4390a = fVar;
            this.f4392c = i3;
            this.f4391b = i4;
            this.f4393d = str;
        }

        public int a() {
            return this.f4392c;
        }

        public p079y.f b() {
            return this.f4390a;
        }

        public String c() {
            return this.f4393d;
        }

        public int d() {
            return this.f4391b;
        }
    }

    private static int a(TypedArray typedArray, int i3) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.a(typedArray, i3);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i3, typedValue);
        return typedValue.type;
    }

    public static b b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List c(Resources resources, int i3) {
        if (i3 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i3);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i4 = 0; i4 < typedArrayObtainTypedArray.length(); i4++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i4, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i3)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    private static b d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static b e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), p070v.c.f12412h);
        String string = typedArrayObtainAttributes.getString(p070v.c.f12413i);
        String string2 = typedArrayObtainAttributes.getString(p070v.c.f12417m);
        String string3 = typedArrayObtainAttributes.getString(p070v.c.f12418n);
        int resourceId = typedArrayObtainAttributes.getResourceId(p070v.c.f12414j, 0);
        int integer = typedArrayObtainAttributes.getInteger(p070v.c.f12415k, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(p070v.c.f12416l, 500);
        String string4 = typedArrayObtainAttributes.getString(p070v.c.f12419o);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new C0053e(new p079y.f(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((d[]) arrayList.toArray(new d[0]));
    }

    private static d f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), p070v.c.f12420p);
        int i3 = p070v.c.f12429y;
        if (!typedArrayObtainAttributes.hasValue(i3)) {
            i3 = p070v.c.f12422r;
        }
        int i4 = typedArrayObtainAttributes.getInt(i3, 400);
        int i5 = p070v.c.f12427w;
        if (!typedArrayObtainAttributes.hasValue(i5)) {
            i5 = p070v.c.f12423s;
        }
        boolean z3 = 1 == typedArrayObtainAttributes.getInt(i5, 0);
        int i6 = p070v.c.f12430z;
        if (!typedArrayObtainAttributes.hasValue(i6)) {
            i6 = p070v.c.f12424t;
        }
        int i7 = p070v.c.f12428x;
        if (!typedArrayObtainAttributes.hasValue(i7)) {
            i7 = p070v.c.f12425u;
        }
        String string = typedArrayObtainAttributes.getString(i7);
        int i8 = typedArrayObtainAttributes.getInt(i6, 0);
        int i9 = p070v.c.f12426v;
        if (!typedArrayObtainAttributes.hasValue(i9)) {
            i9 = p070v.c.f12421q;
        }
        int resourceId = typedArrayObtainAttributes.getResourceId(i9, 0);
        String string2 = typedArrayObtainAttributes.getString(i9);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i4, z3, string, i8, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i3 = 1;
        while (i3 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i3++;
            } else if (next == 3) {
                i3--;
            }
        }
    }

    private static List h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
