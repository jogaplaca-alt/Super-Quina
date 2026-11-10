package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class P implements InterfaceC0418e1 {
    protected int zza = 0;

    /* JADX WARN: Multi-variable type inference failed */
    protected static void g(Iterable iterable, List list) {
        byte[] bArr = J0.f7336d;
        iterable.getClass();
        if (iterable instanceof O0) {
            List listF = ((O0) iterable).f();
            O0 o3 = (O0) list;
            int size = list.size();
            for (Object obj : listF) {
                if (obj == null) {
                    String str = "Element at index " + (o3.size() - size) + " is null.";
                    int size2 = o3.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            throw new NullPointerException(str);
                        }
                        o3.remove(size2);
                    }
                } else if (obj instanceof AbstractC0421f0) {
                    o3.i((AbstractC0421f0) obj);
                } else {
                    o3.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof InterfaceC0444l1) {
            list.addAll(iterable);
            return;
        }
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + iterable.size());
        }
        int size3 = list.size();
        for (Object obj2 : iterable) {
            if (obj2 == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 < size3) {
                        throw new NullPointerException(str2);
                    }
                    list.remove(size4);
                }
            } else {
                list.add(obj2);
            }
        }
    }

    abstract int f(InterfaceC0456p1 interfaceC0456p1);

    public final byte[] h() {
        try {
            int iE = e();
            byte[] bArr = new byte[iE];
            AbstractC0449n0 abstractC0449n0Y = AbstractC0449n0.y(bArr, 0, iE);
            a(abstractC0449n0Y);
            abstractC0449n0Y.z();
            return bArr;
        } catch (IOException e3) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e3);
        }
    }
}
