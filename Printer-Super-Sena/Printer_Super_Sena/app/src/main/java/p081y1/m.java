package p081y1;

import E1.c;
import E1.d;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;
import p075w1.i;
import p075w1.j;
import p075w1.k;
import p075w1.p;
import p084z1.o;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static i a(E1.a aVar) {
        boolean z3;
        try {
            try {
                aVar.c0();
                z3 = false;
                try {
                    return (i) o.f13085V.b(aVar);
                } catch (EOFException e3) {
                    e = e3;
                    if (z3) {
                        return k.f12683a;
                    }
                    throw new p(e);
                }
            } catch (EOFException e4) {
                e = e4;
                z3 = true;
            }
        } catch (d e5) {
            throw new p(e5);
        } catch (IOException e6) {
            throw new j(e6);
        } catch (NumberFormatException e7) {
            throw new p(e7);
        }
    }

    public static void b(i iVar, c cVar) {
        o.f13085V.d(cVar, iVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }

    private static final class b extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Appendable f12889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f12890b = new a();

        private static class a implements CharSequence {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private char[] f12891a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f12892b;

            private a() {
            }

            void a(char[] cArr) {
                this.f12891a = cArr;
                this.f12892b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i3) {
                return this.f12891a[i3];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f12891a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i3, int i4) {
                return new String(this.f12891a, i3, i4 - i3);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f12892b == null) {
                    this.f12892b = new String(this.f12891a);
                }
                return this.f12892b;
            }
        }

        b(Appendable appendable) {
            this.f12889a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i3, int i4) throws IOException {
            this.f12890b.a(cArr);
            this.f12889a.append(this.f12890b, i3, i4 + i3);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.f12889a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(int i3) throws IOException {
            this.f12889a.append((char) i3);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i3, int i4) throws IOException {
            this.f12889a.append(charSequence, i3, i4);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i3, int i4) throws IOException {
            Objects.requireNonNull(str);
            this.f12889a.append(str, i3, i4 + i3);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }
}
