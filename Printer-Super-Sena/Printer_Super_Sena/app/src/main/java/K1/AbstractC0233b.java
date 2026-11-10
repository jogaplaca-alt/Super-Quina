package K1;

import java.util.List;

/* JADX INFO: renamed from: K1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0233b extends AbstractC0232a implements List {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1212a = new a(null);

    /* JADX INFO: renamed from: K1.b$a */
    public static final class a {
        public /* synthetic */ a(S1.g gVar) {
            this();
        }

        public final void a(int i3, int i4) {
            if (i3 < 0 || i3 >= i4) {
                throw new IndexOutOfBoundsException("index: " + i3 + ", size: " + i4);
            }
        }

        public final void b(int i3, int i4) {
            if (i3 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("index: " + i3 + ", size: " + i4);
            }
        }

        public final void c(int i3, int i4, int i5) {
            if (i3 < 0 || i4 > i5) {
                throw new IndexOutOfBoundsException("fromIndex: " + i3 + ", toIndex: " + i4 + ", size: " + i5);
            }
            if (i3 <= i4) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i3 + " > toIndex: " + i4);
        }

        private a() {
        }
    }
}
