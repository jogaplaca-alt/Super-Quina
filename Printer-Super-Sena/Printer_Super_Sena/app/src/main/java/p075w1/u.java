package p075w1;

import E1.b;
import E1.c;
import java.io.IOException;
import p084z1.g;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {

    class a extends u {
        a() {
        }

        @Override // p075w1.u
        public Object b(E1.a aVar) throws IOException {
            if (aVar.c0() != b.NULL) {
                return u.this.b(aVar);
            }
            aVar.Y();
            return null;
        }

        @Override // p075w1.u
        public void d(c cVar, Object obj) throws IOException {
            if (obj == null) {
                cVar.R();
            } else {
                u.this.d(cVar, obj);
            }
        }
    }

    public final u a() {
        return new a();
    }

    public abstract Object b(E1.a aVar);

    public final i c(Object obj) {
        try {
            g gVar = new g();
            d(gVar, obj);
            return gVar.i0();
        } catch (IOException e3) {
            throw new j(e3);
        }
    }

    public abstract void d(c cVar, Object obj);
}
