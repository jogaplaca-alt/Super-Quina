package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.graphics.o;
import androidx.core.os.t;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class i extends e.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final a f4985j = new a();

    public static class a {
        public Typeface a(Context context, y.h.b bVar) {
            return p079y.h.a(context, null, new y.h.b[]{bVar});
        }

        public y.h.a b(Context context, p079y.f fVar) {
            return p079y.h.b(context, null, fVar);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements e.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f4986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final p079y.f f4987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final a f4988c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f4989d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Handler f4990e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Executor f4991f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private ThreadPoolExecutor f4992g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        e.h f4993h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private ContentObserver f4994i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Runnable f4995j;

        b(Context context, p079y.f fVar, a aVar) {
            p082z.h.h(context, "Context cannot be null");
            p082z.h.h(fVar, "FontRequest cannot be null");
            this.f4986a = context.getApplicationContext();
            this.f4987b = fVar;
            this.f4988c = aVar;
        }

        private void b() {
            synchronized (this.f4989d) {
                try {
                    this.f4993h = null;
                    ContentObserver contentObserver = this.f4994i;
                    if (contentObserver != null) {
                        this.f4988c.c(this.f4986a, contentObserver);
                        this.f4994i = null;
                    }
                    Handler handler = this.f4990e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f4995j);
                    }
                    this.f4990e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f4992g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f4991f = null;
                    this.f4992g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private y.h.b e() {
            try {
                y.h.a aVarB = this.f4988c.b(this.f4986a, this.f4987b);
                if (aVarB.c() == 0) {
                    y.h.b[] bVarArrB = aVarB.b();
                    if (bVarArrB == null || bVarArrB.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return bVarArrB[0];
                }
                throw new RuntimeException("fetchFonts failed (" + aVarB.c() + ")");
            } catch (PackageManager.NameNotFoundException e3) {
                throw new RuntimeException("provider not found", e3);
            }
        }

        @Override // androidx.emoji2.text.e.g
        public void a(e.h hVar) {
            p082z.h.h(hVar, "LoaderCallback cannot be null");
            synchronized (this.f4989d) {
                this.f4993h = hVar;
            }
            d();
        }

        void c() {
            synchronized (this.f4989d) {
                try {
                    if (this.f4993h == null) {
                        return;
                    }
                    try {
                        y.h.b bVarE = e();
                        int iB = bVarE.b();
                        if (iB == 2) {
                            synchronized (this.f4989d) {
                            }
                        }
                        if (iB != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iB + ")");
                        }
                        try {
                            t.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceA = this.f4988c.a(this.f4986a, bVarE);
                            ByteBuffer byteBufferF = o.f(this.f4986a, null, bVarE.d());
                            if (byteBufferF == null || typefaceA == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            l lVarB = l.b(typefaceA, byteBufferF);
                            t.b();
                            synchronized (this.f4989d) {
                                try {
                                    e.h hVar = this.f4993h;
                                    if (hVar != null) {
                                        hVar.b(lVarB);
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            b();
                        } catch (Throwable th2) {
                            t.b();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        synchronized (this.f4989d) {
                            try {
                                e.h hVar2 = this.f4993h;
                                if (hVar2 != null) {
                                    hVar2.a(th3);
                                }
                                b();
                            } catch (Throwable th4) {
                                throw th4;
                            }
                        }
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
        }

        void d() {
            synchronized (this.f4989d) {
                try {
                    if (this.f4993h == null) {
                        return;
                    }
                    if (this.f4991f == null) {
                        ThreadPoolExecutor threadPoolExecutorB = androidx.emoji2.text.b.b("emojiCompat");
                        this.f4992g = threadPoolExecutorB;
                        this.f4991f = threadPoolExecutorB;
                    }
                    this.f4991f.execute(new Runnable() { // from class: androidx.emoji2.text.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f4996a.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void f(Executor executor) {
            synchronized (this.f4989d) {
                this.f4991f = executor;
            }
        }
    }

    public i(Context context, p079y.f fVar) {
        super(new b(context, fVar, f4985j));
    }

    public i c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
