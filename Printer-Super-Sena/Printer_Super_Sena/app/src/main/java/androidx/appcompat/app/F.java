package androidx.appcompat.app;

import java.util.LinkedHashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
abstract class F {
    private static androidx.core.os.j a(androidx.core.os.j jVar, androidx.core.os.j jVar2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i3 = 0;
        while (i3 < jVar.g() + jVar2.g()) {
            Locale localeD = i3 < jVar.g() ? jVar.d(i3) : jVar2.d(i3 - jVar.g());
            if (localeD != null) {
                linkedHashSet.add(localeD);
            }
            i3++;
        }
        return androidx.core.os.j.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    static androidx.core.os.j b(androidx.core.os.j jVar, androidx.core.os.j jVar2) {
        return (jVar == null || jVar.f()) ? androidx.core.os.j.e() : a(jVar, jVar2);
    }
}
