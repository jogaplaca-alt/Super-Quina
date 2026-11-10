package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Bundle f4271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private IconCompat f4272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final q[] f4273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final q[] f4274d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f4275e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f4276f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f4277g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f4278h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f4279i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CharSequence f4280j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public PendingIntent f4281k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f4282l;

        public a(int i3, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i3 != 0 ? IconCompat.b(null, "", i3) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f4281k;
        }

        public boolean b() {
            return this.f4275e;
        }

        public q[] c() {
            return this.f4274d;
        }

        public Bundle d() {
            return this.f4271a;
        }

        public IconCompat e() {
            int i3;
            if (this.f4272b == null && (i3 = this.f4279i) != 0) {
                this.f4272b = IconCompat.b(null, "", i3);
            }
            return this.f4272b;
        }

        public q[] f() {
            return this.f4273c;
        }

        public int g() {
            return this.f4277g;
        }

        public boolean h() {
            return this.f4276f;
        }

        public CharSequence i() {
            return this.f4280j;
        }

        public boolean j() {
            return this.f4282l;
        }

        public boolean k() {
            return this.f4278h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, q[] qVarArr, q[] qVarArr2, boolean z3, int i3, boolean z4, boolean z5, boolean z6) {
            this.f4276f = true;
            this.f4272b = iconCompat;
            if (iconCompat != null && iconCompat.f() == 2) {
                this.f4279i = iconCompat.d();
            }
            this.f4280j = d.d(charSequence);
            this.f4281k = pendingIntent;
            this.f4271a = bundle == null ? new Bundle() : bundle;
            this.f4273c = qVarArr;
            this.f4274d = qVarArr2;
            this.f4275e = z3;
            this.f4277g = i3;
            this.f4276f = z4;
            this.f4278h = z5;
            this.f4282l = z6;
        }
    }

    public static class b extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CharSequence f4283e;

        @Override // androidx.core.app.j.e
        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.f4283e);
            }
        }

        @Override // androidx.core.app.j.e
        public void b(i iVar) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(iVar.a()).setBigContentTitle(this.f4332b).bigText(this.f4283e);
            if (this.f4334d) {
                bigTextStyleBigText.setSummaryText(this.f4333c);
            }
        }

        @Override // androidx.core.app.j.e
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public b h(CharSequence charSequence) {
            this.f4283e = d.d(charSequence);
            return this;
        }
    }

    public static final class c {
        public static Notification.BubbleMetadata a(c cVar) {
            return null;
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected d f4331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        CharSequence f4332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CharSequence f4333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f4334d = false;

        public void a(Bundle bundle) {
            if (this.f4334d) {
                bundle.putCharSequence("android.summaryText", this.f4333c);
            }
            CharSequence charSequence = this.f4332b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strC = c();
            if (strC != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strC);
            }
        }

        public abstract void b(i iVar);

        protected abstract String c();

        public RemoteViews d(i iVar) {
            return null;
        }

        public RemoteViews e(i iVar) {
            return null;
        }

        public RemoteViews f(i iVar) {
            return null;
        }

        public void g(d dVar) {
            if (this.f4331a != dVar) {
                this.f4331a = dVar;
                if (dVar != null) {
                    dVar.n(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }

    public static class d {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        boolean f4284A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        boolean f4285B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        String f4286C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        Bundle f4287D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        int f4288E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        int f4289F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        Notification f4290G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        RemoteViews f4291H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        RemoteViews f4292I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        RemoteViews f4293J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        String f4294K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        int f4295L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        String f4296M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        long f4297N;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        int f4298O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        int f4299P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        boolean f4300Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        Notification f4301R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        boolean f4302S;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        Object f4303T;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public ArrayList f4304U;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f4305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f4306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList f4307c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList f4308d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        CharSequence f4309e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        CharSequence f4310f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        PendingIntent f4311g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        PendingIntent f4312h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        RemoteViews f4313i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        IconCompat f4314j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        CharSequence f4315k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f4316l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f4317m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f4318n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f4319o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        e f4320p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        CharSequence f4321q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        CharSequence f4322r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        CharSequence[] f4323s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f4324t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        int f4325u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        boolean f4326v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        String f4327w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        boolean f4328x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        String f4329y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        boolean f4330z;

        public d(Context context, String str) {
            this.f4306b = new ArrayList();
            this.f4307c = new ArrayList();
            this.f4308d = new ArrayList();
            this.f4318n = true;
            this.f4330z = false;
            this.f4288E = 0;
            this.f4289F = 0;
            this.f4295L = 0;
            this.f4298O = 0;
            this.f4299P = 0;
            Notification notification = new Notification();
            this.f4301R = notification;
            this.f4305a = context;
            this.f4294K = str;
            notification.when = System.currentTimeMillis();
            this.f4301R.audioStreamType = -1;
            this.f4317m = 0;
            this.f4304U = new ArrayList();
            this.f4300Q = true;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private void j(int i3, boolean z3) {
            if (z3) {
                Notification notification = this.f4301R;
                notification.flags = i3 | notification.flags;
            } else {
                Notification notification2 = this.f4301R;
                notification2.flags = (i3 ^ (-1)) & notification2.flags;
            }
        }

        public d a(int i3, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f4306b.add(new a(i3, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new m(this).c();
        }

        public Bundle c() {
            if (this.f4287D == null) {
                this.f4287D = new Bundle();
            }
            return this.f4287D;
        }

        public d e(boolean z3) {
            j(16, z3);
            return this;
        }

        public d f(String str) {
            this.f4294K = str;
            return this;
        }

        public d g(PendingIntent pendingIntent) {
            this.f4311g = pendingIntent;
            return this;
        }

        public d h(CharSequence charSequence) {
            this.f4310f = d(charSequence);
            return this;
        }

        public d i(CharSequence charSequence) {
            this.f4309e = d(charSequence);
            return this;
        }

        public d k(boolean z3) {
            this.f4330z = z3;
            return this;
        }

        public d l(int i3) {
            this.f4317m = i3;
            return this;
        }

        public d m(int i3) {
            this.f4301R.icon = i3;
            return this;
        }

        public d n(e eVar) {
            if (this.f4320p != eVar) {
                this.f4320p = eVar;
                if (eVar != null) {
                    eVar.g(this);
                }
            }
            return this;
        }

        public d o(CharSequence charSequence) {
            this.f4301R.tickerText = d(charSequence);
            return this;
        }

        public d p(long j3) {
            this.f4301R.when = j3;
            return this;
        }

        public d(Context context) {
            this(context, null);
        }
    }
}
