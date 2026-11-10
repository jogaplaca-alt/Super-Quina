package androidx.loader.app;

import androidx.lifecycle.InterfaceC0358p;
import androidx.lifecycle.U;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static a b(InterfaceC0358p interfaceC0358p) {
        return new b(interfaceC0358p, ((U) interfaceC0358p).getViewModelStore());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();
}
