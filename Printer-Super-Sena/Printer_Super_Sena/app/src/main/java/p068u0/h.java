package p068u0;

import android.content.Context;
import android.os.Build;
import p071v0.C0700a;
import p071v0.C0715p;
import p071v0.S;
import p071v0.z;
import p074w0.InterfaceC0721d;
import p080y0.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    static S a(Context context, InterfaceC0721d interfaceC0721d, z zVar, a aVar) {
        return Build.VERSION.SDK_INT >= 21 ? new C0715p(context, interfaceC0721d, zVar) : new C0700a(context, interfaceC0721d, aVar, zVar);
    }
}
