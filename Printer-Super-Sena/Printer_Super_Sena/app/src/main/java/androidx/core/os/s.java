package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class s implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocaleList f4533a;

    s(Object obj) {
        this.f4533a = r.a(obj);
    }

    @Override // androidx.core.os.l
    public Object a() {
        return this.f4533a;
    }

    @Override // androidx.core.os.l
    public String b() {
        return this.f4533a.toLanguageTags();
    }

    public boolean equals(Object obj) {
        return this.f4533a.equals(((l) obj).a());
    }

    @Override // androidx.core.os.l
    public Locale get(int i3) {
        return this.f4533a.get(i3);
    }

    public int hashCode() {
        return this.f4533a.hashCode();
    }

    @Override // androidx.core.os.l
    public boolean isEmpty() {
        return this.f4533a.isEmpty();
    }

    @Override // androidx.core.os.l
    public int size() {
        return this.f4533a.size();
    }

    public String toString() {
        return this.f4533a.toString();
    }
}
