package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Shader f4380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f4381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4382c;

    private d(Shader shader, ColorStateList colorStateList, int i3) {
        this.f4380a = shader;
        this.f4381b = colorStateList;
        this.f4382c = i3;
    }

    private static d a(Resources resources, int i3, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        XmlResourceParser xml = resources.getXml(i3);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.hashCode();
        if (name.equals("gradient")) {
            return d(f.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return c(c.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    static d b(int i3) {
        return new d(null, null, i3);
    }

    static d c(ColorStateList colorStateList) {
        return new d(null, colorStateList, colorStateList.getDefaultColor());
    }

    static d d(Shader shader) {
        return new d(shader, null, 0);
    }

    public static d g(Resources resources, int i3, Resources.Theme theme) {
        try {
            return a(resources, i3, theme);
        } catch (Exception e3) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e3);
            return null;
        }
    }

    public int e() {
        return this.f4382c;
    }

    public Shader f() {
        return this.f4380a;
    }

    public boolean h() {
        return this.f4380a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.f4380a == null && (colorStateList = this.f4381b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f4381b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f4382c) {
                this.f4382c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(int i3) {
        this.f4382c = i3;
    }

    public boolean l() {
        return h() || this.f4382c != 0;
    }
}
