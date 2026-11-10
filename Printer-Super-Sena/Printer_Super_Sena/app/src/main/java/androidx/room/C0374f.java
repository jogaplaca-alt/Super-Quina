package androidx.room;

import android.content.Context;
import android.content.Intent;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: androidx.room.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0374f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Z.h.c f6303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u.d f6304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f6305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f6306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u.c f6307g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f6308h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f6309i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Intent f6310j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f6311k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f6312l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Set f6313m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f6314n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final File f6315o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Callable f6316p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List f6317q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f6318r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f6319s;

    public C0374f(Context context, String str, Z.h.c cVar, u.d dVar, List list, boolean z3, u.c cVar2, Executor executor, Executor executor2, Intent intent, boolean z4, boolean z5, Set set, String str2, File file, Callable callable, u.e eVar, List list2, List list3) {
        S1.k.e(context, "context");
        S1.k.e(cVar, "sqliteOpenHelperFactory");
        S1.k.e(dVar, "migrationContainer");
        S1.k.e(cVar2, "journalMode");
        S1.k.e(executor, "queryExecutor");
        S1.k.e(executor2, "transactionExecutor");
        S1.k.e(list2, "typeConverters");
        S1.k.e(list3, "autoMigrationSpecs");
        this.f6301a = context;
        this.f6302b = str;
        this.f6303c = cVar;
        this.f6304d = dVar;
        this.f6305e = list;
        this.f6306f = z3;
        this.f6307g = cVar2;
        this.f6308h = executor;
        this.f6309i = executor2;
        this.f6310j = intent;
        this.f6311k = z4;
        this.f6312l = z5;
        this.f6313m = set;
        this.f6314n = str2;
        this.f6315o = file;
        this.f6316p = callable;
        this.f6317q = list2;
        this.f6318r = list3;
        this.f6319s = intent != null;
    }

    public boolean a(int i3, int i4) {
        if ((i3 > i4 && this.f6312l) || !this.f6311k) {
            return false;
        }
        Set set = this.f6313m;
        return set == null || !set.contains(Integer.valueOf(i3));
    }
}
