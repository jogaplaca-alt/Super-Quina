package p075w1;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p081y1.a;
import p081y1.d;
import p084z1.m;
import p084z1.o;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f12662a = d.f12845g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private q f12663b = q.f12686a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f12664c = b.f12620a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f12665d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f12666e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f12667f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f12668g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f12669h = d.f12631z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12670i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f12671j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f12672k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f12673l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f12674m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f12675n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f12676o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f12677p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f12678q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private t f12679r = d.f12629B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private t f12680s = d.f12630C;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final LinkedList f12681t = new LinkedList();

    private void a(String str, int i3, int i4, List list) {
        v vVarB;
        v vVarB2;
        boolean z3 = C1.d.f156a;
        v vVarA = null;
        if (str != null && !str.trim().isEmpty()) {
            vVarB = z1.d.b.f12994b.b(str);
            if (z3) {
                vVarA = C1.d.f158c.b(str);
                vVarB2 = C1.d.f157b.b(str);
            } else {
                vVarB2 = null;
            }
        } else {
            if (i3 == 2 || i4 == 2) {
                return;
            }
            v vVarA2 = z1.d.b.f12994b.a(i3, i4);
            if (z3) {
                vVarA = C1.d.f158c.a(i3, i4);
                v vVarA3 = C1.d.f157b.a(i3, i4);
                vVarB = vVarA2;
                vVarB2 = vVarA3;
            } else {
                vVarB = vVarA2;
                vVarB2 = null;
            }
        }
        list.add(vVarB);
        if (z3) {
            list.add(vVarA);
            list.add(vVarB2);
        }
    }

    public d b() {
        ArrayList arrayList = new ArrayList(this.f12666e.size() + this.f12667f.size() + 3);
        arrayList.addAll(this.f12666e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f12667f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f12669h, this.f12670i, this.f12671j, arrayList);
        return new d(this.f12662a, this.f12664c, new HashMap(this.f12665d), this.f12668g, this.f12672k, this.f12676o, this.f12674m, this.f12675n, this.f12677p, this.f12673l, this.f12678q, this.f12663b, this.f12669h, this.f12670i, this.f12671j, new ArrayList(this.f12666e), new ArrayList(this.f12667f), arrayList, this.f12679r, this.f12680s, new ArrayList(this.f12681t));
    }

    public e c(Type type, Object obj) {
        Objects.requireNonNull(type);
        a.a((obj instanceof h) || (obj instanceof u));
        if (obj instanceof h) {
            this.f12666e.add(m.g(D1.a.b(type), obj));
        }
        if (obj instanceof u) {
            this.f12666e.add(o.a(D1.a.b(type), (u) obj));
        }
        return this;
    }
}
