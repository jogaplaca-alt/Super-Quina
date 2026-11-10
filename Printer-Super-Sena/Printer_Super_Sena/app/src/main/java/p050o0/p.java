package p050o0;

import java.util.Set;
import p044m0.b;
import p044m0.e;
import p044m0.f;
import p044m0.g;

/* JADX INFO: loaded from: classes.dex */
final class p implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f10406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f10407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s f10408c;

    p(Set set, o oVar, s sVar) {
        this.f10406a = set;
        this.f10407b = oVar;
        this.f10408c = sVar;
    }

    @Override // p044m0.g
    public f a(String str, Class cls, b bVar, e eVar) {
        if (this.f10406a.contains(bVar)) {
            return new r(this.f10407b, str, bVar, eVar, this.f10408c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, this.f10406a));
    }
}
