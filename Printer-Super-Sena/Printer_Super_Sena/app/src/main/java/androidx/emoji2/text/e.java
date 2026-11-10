package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Object f4933n = new Object();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Object f4934o = new Object();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static volatile e f4935p;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f4937b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f4940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final g f4941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f4942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f4943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int[] f4944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f4945j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f4946k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f4947l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final d f4948m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReadWriteLock f4936a = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f4938c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f4939d = new Handler(Looper.getMainLooper());

    private static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile androidx.emoji2.text.h f4949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile l f4950c;

        /* JADX INFO: renamed from: androidx.emoji2.text.e$a$a, reason: collision with other inner class name */
        class C0068a extends h {
            C0068a() {
            }

            @Override // androidx.emoji2.text.e.h
            public void a(Throwable th) {
                a.this.f4952a.m(th);
            }

            @Override // androidx.emoji2.text.e.h
            public void b(l lVar) {
                a.this.d(lVar);
            }
        }

        a(e eVar) {
            super(eVar);
        }

        @Override // androidx.emoji2.text.e.b
        void a() {
            try {
                this.f4952a.f4941f.a(new C0068a());
            } catch (Throwable th) {
                this.f4952a.m(th);
            }
        }

        @Override // androidx.emoji2.text.e.b
        CharSequence b(CharSequence charSequence, int i3, int i4, int i5, boolean z3) {
            return this.f4949b.h(charSequence, i3, i4, i5, z3);
        }

        @Override // androidx.emoji2.text.e.b
        void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f4950c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f4952a.f4942g);
        }

        void d(l lVar) {
            if (lVar == null) {
                this.f4952a.m(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f4950c = lVar;
            l lVar2 = this.f4950c;
            i iVar = new i();
            d dVar = this.f4952a.f4948m;
            e eVar = this.f4952a;
            this.f4949b = new androidx.emoji2.text.h(lVar2, iVar, dVar, eVar.f4943h, eVar.f4944i);
            this.f4952a.n();
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final e f4952a;

        b(e eVar) {
            this.f4952a = eVar;
        }

        abstract void a();

        abstract CharSequence b(CharSequence charSequence, int i3, int i4, int i5, boolean z3);

        abstract void c(EditorInfo editorInfo);
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g f4953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f4954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f4955c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int[] f4956d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Set f4957e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f4958f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f4959g = -16711936;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f4960h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        d f4961i = new androidx.emoji2.text.d();

        protected c(g gVar) {
            p082z.h.h(gVar, "metadataLoader cannot be null.");
            this.f4953a = gVar;
        }

        protected final g a() {
            return this.f4953a;
        }

        public c b(int i3) {
            this.f4960h = i3;
            return this;
        }
    }

    public interface d {
        boolean a(CharSequence charSequence, int i3, int i4, int i5);
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.e$e, reason: collision with other inner class name */
    public static abstract class AbstractC0069e {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    private static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f4962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Throwable f4963b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f4964c;

        f(AbstractC0069e abstractC0069e, int i3) {
            this(Arrays.asList((AbstractC0069e) p082z.h.h(abstractC0069e, "initCallback cannot be null")), i3, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f4962a.size();
            int i3 = 0;
            if (this.f4964c != 1) {
                while (i3 < size) {
                    ((AbstractC0069e) this.f4962a.get(i3)).a(this.f4963b);
                    i3++;
                }
            } else {
                while (i3 < size) {
                    ((AbstractC0069e) this.f4962a.get(i3)).b();
                    i3++;
                }
            }
        }

        f(Collection collection, int i3) {
            this(collection, i3, null);
        }

        f(Collection collection, int i3, Throwable th) {
            p082z.h.h(collection, "initCallbacks cannot be null");
            this.f4962a = new ArrayList(collection);
            this.f4964c = i3;
            this.f4963b = th;
        }
    }

    public interface g {
        void a(h hVar);
    }

    public static abstract class h {
        public abstract void a(Throwable th);

        public abstract void b(l lVar);
    }

    static class i {
        i() {
        }

        K.b a(androidx.emoji2.text.g gVar) {
            return new K.d(gVar);
        }
    }

    private e(c cVar) {
        this.f4942g = cVar.f4954b;
        this.f4943h = cVar.f4955c;
        this.f4944i = cVar.f4956d;
        this.f4945j = cVar.f4958f;
        this.f4946k = cVar.f4959g;
        this.f4941f = cVar.f4953a;
        this.f4947l = cVar.f4960h;
        this.f4948m = cVar.f4961i;
        p046n.b bVar = new p046n.b();
        this.f4937b = bVar;
        Set set = cVar.f4957e;
        if (set != null && !set.isEmpty()) {
            bVar.addAll(cVar.f4957e);
        }
        this.f4940e = new a(this);
        l();
    }

    public static e b() {
        e eVar;
        synchronized (f4933n) {
            eVar = f4935p;
            p082z.h.i(eVar != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return eVar;
    }

    public static boolean e(InputConnection inputConnection, Editable editable, int i3, int i4, boolean z3) {
        return androidx.emoji2.text.h.c(inputConnection, editable, i3, i4, z3);
    }

    public static boolean f(Editable editable, int i3, KeyEvent keyEvent) {
        return androidx.emoji2.text.h.d(editable, i3, keyEvent);
    }

    public static e g(c cVar) {
        e eVar = f4935p;
        if (eVar == null) {
            synchronized (f4933n) {
                try {
                    eVar = f4935p;
                    if (eVar == null) {
                        eVar = new e(cVar);
                        f4935p = eVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return eVar;
    }

    public static boolean h() {
        return f4935p != null;
    }

    private boolean j() {
        return d() == 1;
    }

    private void l() {
        this.f4936a.writeLock().lock();
        try {
            if (this.f4947l == 0) {
                this.f4938c = 0;
            }
            this.f4936a.writeLock().unlock();
            if (d() == 0) {
                this.f4940e.a();
            }
        } catch (Throwable th) {
            this.f4936a.writeLock().unlock();
            throw th;
        }
    }

    public int c() {
        return this.f4946k;
    }

    public int d() {
        this.f4936a.readLock().lock();
        try {
            return this.f4938c;
        } finally {
            this.f4936a.readLock().unlock();
        }
    }

    public boolean i() {
        return this.f4945j;
    }

    public void k() {
        p082z.h.i(this.f4947l == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (j()) {
            return;
        }
        this.f4936a.writeLock().lock();
        try {
            if (this.f4938c == 0) {
                this.f4936a.writeLock().unlock();
                return;
            }
            this.f4938c = 0;
            this.f4936a.writeLock().unlock();
            this.f4940e.a();
        } catch (Throwable th) {
            this.f4936a.writeLock().unlock();
            throw th;
        }
    }

    void m(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f4936a.writeLock().lock();
        try {
            this.f4938c = 2;
            arrayList.addAll(this.f4937b);
            this.f4937b.clear();
            this.f4936a.writeLock().unlock();
            this.f4939d.post(new f(arrayList, this.f4938c, th));
        } catch (Throwable th2) {
            this.f4936a.writeLock().unlock();
            throw th2;
        }
    }

    void n() {
        ArrayList arrayList = new ArrayList();
        this.f4936a.writeLock().lock();
        try {
            this.f4938c = 1;
            arrayList.addAll(this.f4937b);
            this.f4937b.clear();
            this.f4936a.writeLock().unlock();
            this.f4939d.post(new f(arrayList, this.f4938c));
        } catch (Throwable th) {
            this.f4936a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence o(CharSequence charSequence) {
        return p(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence p(CharSequence charSequence, int i3, int i4) {
        return q(charSequence, i3, i4, Integer.MAX_VALUE);
    }

    public CharSequence q(CharSequence charSequence, int i3, int i4, int i5) {
        return r(charSequence, i3, i4, i5, 0);
    }

    public CharSequence r(CharSequence charSequence, int i3, int i4, int i5, int i6) {
        boolean z3;
        p082z.h.i(j(), "Not initialized yet");
        p082z.h.e(i3, "start cannot be negative");
        p082z.h.e(i4, "end cannot be negative");
        p082z.h.e(i5, "maxEmojiCount cannot be negative");
        p082z.h.b(i3 <= i4, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        p082z.h.b(i3 <= charSequence.length(), "start should be < than charSequence length");
        p082z.h.b(i4 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i3 == i4) {
            return charSequence;
        }
        if (i6 != 1) {
            z3 = i6 != 2 ? this.f4942g : false;
        } else {
            z3 = true;
        }
        return this.f4940e.b(charSequence, i3, i4, i5, z3);
    }

    public void s(AbstractC0069e abstractC0069e) {
        p082z.h.h(abstractC0069e, "initCallback cannot be null");
        this.f4936a.writeLock().lock();
        try {
            if (this.f4938c == 1 || this.f4938c == 2) {
                this.f4939d.post(new f(abstractC0069e, this.f4938c));
            } else {
                this.f4937b.add(abstractC0069e);
            }
        } finally {
            this.f4936a.writeLock().unlock();
        }
    }

    public void t(AbstractC0069e abstractC0069e) {
        p082z.h.h(abstractC0069e, "initCallback cannot be null");
        this.f4936a.writeLock().lock();
        try {
            this.f4937b.remove(abstractC0069e);
        } finally {
            this.f4936a.writeLock().unlock();
        }
    }

    public void u(EditorInfo editorInfo) {
        if (!j() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f4940e.c(editorInfo);
    }
}
