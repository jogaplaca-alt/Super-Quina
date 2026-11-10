package p072v1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import p063s1.d;
import p063s1.e;
import p066t1.b;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f12527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f12528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f12529c;

    public static final class a implements b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final d f12530d = new d() { // from class: v1.g
            @Override // p063s1.d
            public final void a(Object obj, Object obj2) {
                h.a.e(obj, (e) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f12531a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f12532b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private d f12533c = f12530d;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(Object obj, e eVar) {
            throw new p063s1.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public h c() {
            return new h(new HashMap(this.f12531a), new HashMap(this.f12532b), this.f12533c);
        }

        public a d(p066t1.a aVar) {
            aVar.a(this);
            return this;
        }

        @Override // p066t1.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a a(Class cls, d dVar) {
            this.f12531a.put(cls, dVar);
            this.f12532b.remove(cls);
            return this;
        }
    }

    h(Map map, Map map2, d dVar) {
        this.f12527a = map;
        this.f12528b = map2;
        this.f12529c = dVar;
    }

    public static a a() {
        return new a();
    }

    public void b(Object obj, OutputStream outputStream) {
        new f(outputStream, this.f12527a, this.f12528b, this.f12529c).p(obj);
    }

    public byte[] c(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
