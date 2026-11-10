package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
abstract class b0 extends Resources {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f3428a;

    public b0(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f3428a = resources;
    }

    final Drawable a(int i3) {
        return super.getDrawable(i3);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i3) {
        return this.f3428a.getAnimation(i3);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i3) {
        return this.f3428a.getBoolean(i3);
    }

    @Override // android.content.res.Resources
    public int getColor(int i3) {
        return this.f3428a.getColor(i3);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i3) {
        return this.f3428a.getColorStateList(i3);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f3428a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i3) {
        return this.f3428a.getDimension(i3);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i3) {
        return this.f3428a.getDimensionPixelOffset(i3);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i3) {
        return this.f3428a.getDimensionPixelSize(i3);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f3428a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i3, Resources.Theme theme) {
        return androidx.core.content.res.h.e(this.f3428a, i3, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i3, int i4) {
        return androidx.core.content.res.h.f(this.f3428a, i3, i4, null);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i3, int i4, int i5) {
        return this.f3428a.getFraction(i3, i4, i5);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f3428a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i3) {
        return this.f3428a.getIntArray(i3);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i3) {
        return this.f3428a.getInteger(i3);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i3) {
        return this.f3428a.getLayout(i3);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i3) {
        return this.f3428a.getMovie(i3);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i3, int i4, Object... objArr) {
        return this.f3428a.getQuantityString(i3, i4, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i3, int i4) {
        return this.f3428a.getQuantityText(i3, i4);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i3) {
        return this.f3428a.getResourceEntryName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i3) {
        return this.f3428a.getResourceName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i3) {
        return this.f3428a.getResourcePackageName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i3) {
        return this.f3428a.getResourceTypeName(i3);
    }

    @Override // android.content.res.Resources
    public String getString(int i3) {
        return this.f3428a.getString(i3);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i3) {
        return this.f3428a.getStringArray(i3);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i3) {
        return this.f3428a.getText(i3);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i3) {
        return this.f3428a.getTextArray(i3);
    }

    @Override // android.content.res.Resources
    public void getValue(int i3, TypedValue typedValue, boolean z3) {
        this.f3428a.getValue(i3, typedValue, z3);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i3, int i4, TypedValue typedValue, boolean z3) {
        p024g.a.a(this.f3428a, i3, i4, typedValue, z3);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i3) {
        return this.f3428a.getXml(i3);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f3428a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i3) {
        return this.f3428a.obtainTypedArray(i3);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i3) {
        return this.f3428a.openRawResource(i3);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i3) {
        return this.f3428a.openRawResourceFd(i3);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f3428a.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f3428a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f3428a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i3, int i4, Resources.Theme theme) {
        return androidx.core.content.res.h.f(this.f3428a, i3, i4, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i3, int i4) {
        return this.f3428a.getQuantityString(i3, i4);
    }

    @Override // android.content.res.Resources
    public String getString(int i3, Object... objArr) {
        return this.f3428a.getString(i3, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i3, CharSequence charSequence) {
        return this.f3428a.getText(i3, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z3) {
        this.f3428a.getValue(str, typedValue, z3);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i3, TypedValue typedValue) {
        return this.f3428a.openRawResource(i3, typedValue);
    }
}
