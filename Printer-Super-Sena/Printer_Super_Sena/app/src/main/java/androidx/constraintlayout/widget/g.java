package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f3847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f3848b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f3849c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SparseArray f3850d = new SparseArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SparseArray f3851e = new SparseArray();

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList f3853b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3854c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        j f3855d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f3854c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), m.f7);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == m.g7) {
                    this.f3852a = typedArrayObtainStyledAttributes.getResourceId(index, this.f3852a);
                } else if (index == m.h7) {
                    this.f3854c = typedArrayObtainStyledAttributes.getResourceId(index, this.f3854c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f3854c);
                    context.getResources().getResourceName(this.f3854c);
                    if ("layout".equals(resourceTypeName)) {
                        j jVar = new j();
                        this.f3855d = jVar;
                        jVar.e(context, this.f3854c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        void a(b bVar) {
            this.f3853b.add(bVar);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f3856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f3857b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f3858c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f3859d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f3860e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        j f3861f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f3856a = Float.NaN;
            this.f3857b = Float.NaN;
            this.f3858c = Float.NaN;
            this.f3859d = Float.NaN;
            this.f3860e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), m.D7);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == m.E7) {
                    this.f3860e = typedArrayObtainStyledAttributes.getResourceId(index, this.f3860e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f3860e);
                    context.getResources().getResourceName(this.f3860e);
                    if ("layout".equals(resourceTypeName)) {
                        j jVar = new j();
                        this.f3861f = jVar;
                        jVar.e(context, this.f3860e);
                    }
                } else if (index == m.F7) {
                    this.f3859d = typedArrayObtainStyledAttributes.getDimension(index, this.f3859d);
                } else if (index == m.G7) {
                    this.f3857b = typedArrayObtainStyledAttributes.getDimension(index, this.f3857b);
                } else if (index == m.H7) {
                    this.f3858c = typedArrayObtainStyledAttributes.getDimension(index, this.f3858c);
                } else if (index == m.I7) {
                    this.f3856a = typedArrayObtainStyledAttributes.getDimension(index, this.f3856a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    g(Context context, ConstraintLayout constraintLayout, int i3) {
        this.f3847a = constraintLayout;
        a(context, i3);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x005a  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void a(Context context, int i3) {
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            int eventType = xml.getEventType();
            a aVar = null;
            while (true) {
                byte b3 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (!name.equals("ConstraintSet")) {
                                b3 = -1;
                            } else {
                                b3 = 4;
                            }
                            break;
                        case 80204913:
                            if (!name.equals("State")) {
                                b3 = -1;
                            } else {
                                b3 = 2;
                            }
                            break;
                        case 1382829617:
                            if (!name.equals("StateSet")) {
                                b3 = -1;
                            }
                            break;
                        case 1657696882:
                            if (!name.equals("layoutDescription")) {
                                b3 = -1;
                            } else {
                                b3 = 0;
                            }
                            break;
                        case 1901439077:
                            if (!name.equals("Variant")) {
                                b3 = -1;
                            } else {
                                b3 = 3;
                            }
                            break;
                        default:
                            b3 = -1;
                            break;
                    }
                    if (b3 == 2) {
                        aVar = new a(context, xml);
                        this.f3850d.put(aVar.f3852a, aVar);
                    } else if (b3 == 3) {
                        b bVar = new b(context, xml);
                        if (aVar != null) {
                            aVar.a(bVar);
                        }
                    } else if (b3 == 4) {
                        b(context, xml);
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        j jVar = new j();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                jVar.l(context, xmlPullParser);
                this.f3851e.put(identifier, jVar);
                return;
            }
        }
    }

    public void c(k kVar) {
    }
}
