package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.os.t;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final L.b f5000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char[] f5001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f5002c = new a(1024);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Typeface f5003d;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SparseArray f5004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private g f5005b;

        private a() {
            this(1);
        }

        a a(int i3) {
            SparseArray sparseArray = this.f5004a;
            if (sparseArray == null) {
                return null;
            }
            return (a) sparseArray.get(i3);
        }

        final g b() {
            return this.f5005b;
        }

        void c(g gVar, int i3, int i4) {
            a aVarA = a(gVar.b(i3));
            if (aVarA == null) {
                aVarA = new a();
                this.f5004a.put(gVar.b(i3), aVarA);
            }
            if (i4 > i3) {
                aVarA.c(gVar, i3 + 1, i4);
            } else {
                aVarA.f5005b = gVar;
            }
        }

        a(int i3) {
            this.f5004a = new SparseArray(i3);
        }
    }

    private l(Typeface typeface, L.b bVar) {
        this.f5003d = typeface;
        this.f5000a = bVar;
        this.f5001b = new char[bVar.k() * 2];
        a(bVar);
    }

    private void a(L.b bVar) {
        int iK = bVar.k();
        for (int i3 = 0; i3 < iK; i3++) {
            g gVar = new g(this, i3);
            Character.toChars(gVar.f(), this.f5001b, i3 * 2);
            h(gVar);
        }
    }

    public static l b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            t.a("EmojiCompat.MetadataRepo.create");
            return new l(typeface, k.b(byteBuffer));
        } finally {
            t.b();
        }
    }

    public char[] c() {
        return this.f5001b;
    }

    public L.b d() {
        return this.f5000a;
    }

    int e() {
        return this.f5000a.l();
    }

    a f() {
        return this.f5002c;
    }

    Typeface g() {
        return this.f5003d;
    }

    void h(g gVar) {
        p082z.h.h(gVar, "emoji metadata cannot be null");
        p082z.h.b(gVar.c() > 0, "invalid metadata codepoint length");
        this.f5002c.c(gVar, 0, gVar.c() - 1);
    }
}
