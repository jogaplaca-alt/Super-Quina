package p050o0;

import android.content.Context;
import p053p0.j;
import p053p0.l;
import p056q0.c;
import p056q0.d;
import p068u0.g;
import p068u0.i;
import p071v0.M;
import p071v0.Q;
import p074w0.C0724g;
import p074w0.C0725h;
import p074w0.C0726i;
import p074w0.C0727j;
import p074w0.InterfaceC0721d;
import p074w0.N;
import p074w0.V;

/* JADX INFO: loaded from: classes.dex */
final class e extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private I1.a f10386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private I1.a f10387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private I1.a f10388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private I1.a f10389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private I1.a f10390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private I1.a f10391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private I1.a f10392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private I1.a f10393h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private I1.a f10394i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private I1.a f10395j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private I1.a f10396k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private I1.a f10397l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private I1.a f10398m;

    private static final class b implements u.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f10399a;

        private b() {
        }

        @Override // o0.u.a
        public u a() {
            d.a(this.f10399a, Context.class);
            return new e(this.f10399a);
        }

        @Override // o0.u.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public b b(Context context) {
            this.f10399a = (Context) d.b(context);
            return this;
        }
    }

    private void G(Context context) {
        this.f10386a = p056q0.a.a(k.a());
        p056q0.b bVarA = c.a(context);
        this.f10387b = bVarA;
        j jVarA = j.a(bVarA, p080y0.c.a(), p080y0.d.a());
        this.f10388c = jVarA;
        this.f10389d = p056q0.a.a(l.a(this.f10387b, jVarA));
        this.f10390e = V.a(this.f10387b, C0724g.a(), C0726i.a());
        this.f10391f = p056q0.a.a(C0725h.a(this.f10387b));
        this.f10392g = p056q0.a.a(N.a(p080y0.c.a(), p080y0.d.a(), C0727j.a(), this.f10390e, this.f10391f));
        g gVarB = g.b(p080y0.c.a());
        this.f10393h = gVarB;
        i iVarA = i.a(this.f10387b, this.f10392g, gVarB, p080y0.d.a());
        this.f10394i = iVarA;
        I1.a aVar = this.f10386a;
        I1.a aVar2 = this.f10389d;
        I1.a aVar3 = this.f10392g;
        this.f10395j = p068u0.d.a(aVar, aVar2, iVarA, aVar3, aVar3);
        I1.a aVar4 = this.f10387b;
        I1.a aVar5 = this.f10389d;
        I1.a aVar6 = this.f10392g;
        this.f10396k = M.a(aVar4, aVar5, aVar6, this.f10394i, this.f10386a, aVar6, p080y0.c.a(), p080y0.d.a(), this.f10392g);
        I1.a aVar7 = this.f10386a;
        I1.a aVar8 = this.f10392g;
        this.f10397l = Q.a(aVar7, aVar8, this.f10394i, aVar8);
        this.f10398m = p056q0.a.a(v.a(p080y0.c.a(), p080y0.d.a(), this.f10395j, this.f10396k, this.f10397l));
    }

    public static u.a y() {
        return new b();
    }

    @Override // p050o0.u
    InterfaceC0721d g() {
        return (InterfaceC0721d) this.f10392g.get();
    }

    @Override // p050o0.u
    t t() {
        return (t) this.f10398m.get();
    }

    private e(Context context) {
        G(context);
    }
}
