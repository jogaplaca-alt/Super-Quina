package p053p0;

import android.content.Context;
import p080y0.a;

/* JADX INFO: loaded from: classes.dex */
final class c extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f10470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f10471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10472d;

    c(Context context, a aVar, a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f10469a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f10470b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f10471c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f10472d = str;
    }

    @Override // p053p0.h
    public Context b() {
        return this.f10469a;
    }

    @Override // p053p0.h
    public String c() {
        return this.f10472d;
    }

    @Override // p053p0.h
    public a d() {
        return this.f10471c;
    }

    @Override // p053p0.h
    public a e() {
        return this.f10470b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f10469a.equals(hVar.b()) && this.f10470b.equals(hVar.e()) && this.f10471c.equals(hVar.d()) && this.f10472d.equals(hVar.c());
    }

    public int hashCode() {
        return ((((((this.f10469a.hashCode() ^ 1000003) * 1000003) ^ this.f10470b.hashCode()) * 1000003) ^ this.f10471c.hashCode()) * 1000003) ^ this.f10472d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f10469a + ", wallClock=" + this.f10470b + ", monotonicClock=" + this.f10471c + ", backendName=" + this.f10472d + "}";
    }
}
