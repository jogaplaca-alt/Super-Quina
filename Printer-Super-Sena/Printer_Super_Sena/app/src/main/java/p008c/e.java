package p008c;

import S1.g;
import S1.k;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class e extends p008c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6959a = new a(null);

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    @Override // p008c.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Intent intent) {
        k.e(context, "context");
        k.e(intent, "input");
        return intent;
    }

    @Override // p008c.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public p004b.a c(int i3, Intent intent) {
        return new p004b.a(i3, intent);
    }
}
