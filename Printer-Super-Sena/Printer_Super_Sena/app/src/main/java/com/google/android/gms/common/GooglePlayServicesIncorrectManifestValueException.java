package com.google.android.gms.common;

import C0.i;

/* JADX INFO: loaded from: classes.dex */
public final class GooglePlayServicesIncorrectManifestValueException extends GooglePlayServicesManifestException {
    public GooglePlayServicesIncorrectManifestValueException(int i3) {
        super(i3, "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + i.f135a + " but found " + i3 + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
    }
}
