package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.appcompat.app.H;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class m implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Notification.Builder f4336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j.d f4337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RemoteViews f4338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RemoteViews f4339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f4340f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Bundle f4341g = new Bundle();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4342h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RemoteViews f4343i;

    static class a {
        static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        static Notification.Action.Builder e(int i3, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i3, charSequence, pendingIntent);
        }

        static String f(Notification notification) {
            return notification.getGroup();
        }

        static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        static Notification.Builder h(Notification.Builder builder, boolean z3) {
            return builder.setGroupSummary(z3);
        }

        static Notification.Builder i(Notification.Builder builder, boolean z3) {
            return builder.setLocalOnly(z3);
        }

        static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    static class b {
        static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        static Notification.Builder c(Notification.Builder builder, int i3) {
            return builder.setColor(i3);
        }

        static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        static Notification.Builder f(Notification.Builder builder, int i3) {
            return builder.setVisibility(i3);
        }
    }

    static class c {
        static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    static class d {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z3) {
            return builder.setAllowGeneratedReplies(z3);
        }

        static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    static class e {
        static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        static Notification.Builder b(Notification.Builder builder, int i3) {
            return builder.setBadgeIconType(i3);
        }

        static Notification.Builder c(Notification.Builder builder, boolean z3) {
            return builder.setColorized(z3);
        }

        static Notification.Builder d(Notification.Builder builder, int i3) {
            return builder.setGroupAlertBehavior(i3);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        static Notification.Builder g(Notification.Builder builder, long j3) {
            return builder.setTimeoutAfter(j3);
        }
    }

    static class f {
        static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, int i3) {
            return builder.setSemanticAction(i3);
        }
    }

    static class g {
        static Notification.Builder a(Notification.Builder builder, boolean z3) {
            return builder.setAllowSystemGeneratedContextualActions(z3);
        }

        static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z3) {
            return builder.setContextual(z3);
        }

        static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    static class h {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z3) {
            return builder.setAuthenticationRequired(z3);
        }

        static Notification.Builder b(Notification.Builder builder, int i3) {
            return builder.setForegroundServiceBehavior(i3);
        }
    }

    m(j.d dVar) {
        int i3;
        Object obj;
        List listE;
        this.f4337c = dVar;
        Context context = dVar.f4305a;
        this.f4335a = context;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            this.f4336b = e.a(context, dVar.f4294K);
        } else {
            this.f4336b = new Notification.Builder(dVar.f4305a);
        }
        Notification notification = dVar.f4301R;
        this.f4336b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.f4313i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f4309e).setContentText(dVar.f4310f).setContentInfo(dVar.f4315k).setContentIntent(dVar.f4311g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f4312h, (notification.flags & 128) != 0).setNumber(dVar.f4316l).setProgress(dVar.f4324t, dVar.f4325u, dVar.f4326v);
        if (i4 < 23) {
            Notification.Builder builder = this.f4336b;
            IconCompat iconCompat = dVar.f4314j;
            builder.setLargeIcon(iconCompat == null ? null : iconCompat.c());
        } else {
            Notification.Builder builder2 = this.f4336b;
            IconCompat iconCompat2 = dVar.f4314j;
            c.b(builder2, iconCompat2 == null ? null : iconCompat2.l(context));
        }
        if (i4 < 21) {
            this.f4336b.setSound(notification.sound, notification.audioStreamType);
        }
        this.f4336b.setSubText(dVar.f4321q).setUsesChronometer(dVar.f4319o).setPriority(dVar.f4317m);
        Iterator it = dVar.f4306b.iterator();
        while (it.hasNext()) {
            b((j.a) it.next());
        }
        Bundle bundle = dVar.f4287D;
        if (bundle != null) {
            this.f4341g.putAll(bundle);
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 20) {
            if (dVar.f4330z) {
                this.f4341g.putBoolean("android.support.localOnly", true);
            }
            String str = dVar.f4327w;
            if (str != null) {
                this.f4341g.putString("android.support.groupKey", str);
                if (dVar.f4328x) {
                    this.f4341g.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f4341g.putBoolean("android.support.useSideChannel", true);
                }
            }
            String str2 = dVar.f4329y;
            if (str2 != null) {
                this.f4341g.putString("android.support.sortKey", str2);
            }
        }
        this.f4338d = dVar.f4291H;
        this.f4339e = dVar.f4292I;
        this.f4336b.setShowWhen(dVar.f4318n);
        if (i5 < 21 && (listE = e(f(dVar.f4307c), dVar.f4304U)) != null && !listE.isEmpty()) {
            this.f4341g.putStringArray("android.people", (String[]) listE.toArray(new String[listE.size()]));
        }
        if (i5 >= 20) {
            a.i(this.f4336b, dVar.f4330z);
            a.g(this.f4336b, dVar.f4327w);
            a.j(this.f4336b, dVar.f4329y);
            a.h(this.f4336b, dVar.f4328x);
            this.f4342h = dVar.f4298O;
        }
        if (i5 >= 21) {
            b.b(this.f4336b, dVar.f4286C);
            b.c(this.f4336b, dVar.f4288E);
            b.f(this.f4336b, dVar.f4289F);
            b.d(this.f4336b, dVar.f4290G);
            b.e(this.f4336b, notification.sound, notification.audioAttributes);
            List listE2 = i5 < 28 ? e(f(dVar.f4307c), dVar.f4304U) : dVar.f4304U;
            if (listE2 != null && !listE2.isEmpty()) {
                Iterator it2 = listE2.iterator();
                while (it2.hasNext()) {
                    b.a(this.f4336b, (String) it2.next());
                }
            }
            this.f4343i = dVar.f4293J;
            if (dVar.f4308d.size() > 0) {
                Bundle bundle2 = dVar.c().getBundle("android.car.EXTENSIONS");
                bundle2 = bundle2 == null ? new Bundle() : bundle2;
                Bundle bundle3 = new Bundle(bundle2);
                Bundle bundle4 = new Bundle();
                for (int i6 = 0; i6 < dVar.f4308d.size(); i6++) {
                    bundle4.putBundle(Integer.toString(i6), n.b((j.a) dVar.f4308d.get(i6)));
                }
                bundle2.putBundle("invisible_actions", bundle4);
                bundle3.putBundle("invisible_actions", bundle4);
                dVar.c().putBundle("android.car.EXTENSIONS", bundle2);
                this.f4341g.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 23 && (obj = dVar.f4303T) != null) {
            c.c(this.f4336b, obj);
        }
        if (i7 >= 24) {
            this.f4336b.setExtras(dVar.f4287D);
            d.e(this.f4336b, dVar.f4323s);
            RemoteViews remoteViews = dVar.f4291H;
            if (remoteViews != null) {
                d.c(this.f4336b, remoteViews);
            }
            RemoteViews remoteViews2 = dVar.f4292I;
            if (remoteViews2 != null) {
                d.b(this.f4336b, remoteViews2);
            }
            RemoteViews remoteViews3 = dVar.f4293J;
            if (remoteViews3 != null) {
                d.d(this.f4336b, remoteViews3);
            }
        }
        if (i7 >= 26) {
            e.b(this.f4336b, dVar.f4295L);
            e.e(this.f4336b, dVar.f4322r);
            e.f(this.f4336b, dVar.f4296M);
            e.g(this.f4336b, dVar.f4297N);
            e.d(this.f4336b, dVar.f4298O);
            if (dVar.f4285B) {
                e.c(this.f4336b, dVar.f4284A);
            }
            if (!TextUtils.isEmpty(dVar.f4294K)) {
                this.f4336b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i7 >= 28) {
            Iterator it3 = dVar.f4307c.iterator();
            if (it3.hasNext()) {
                H.a(it3.next());
                throw null;
            }
        }
        if (i7 >= 29) {
            g.a(this.f4336b, dVar.f4300Q);
            g.b(this.f4336b, j.c.a(null));
        }
        if (i7 >= 31 && (i3 = dVar.f4299P) != 0) {
            h.b(this.f4336b, i3);
        }
        if (dVar.f4302S) {
            if (this.f4337c.f4328x) {
                this.f4342h = 2;
            } else {
                this.f4342h = 1;
            }
            this.f4336b.setVibrate(null);
            this.f4336b.setSound(null);
            int i8 = notification.defaults & (-4);
            notification.defaults = i8;
            this.f4336b.setDefaults(i8);
            if (i7 >= 26) {
                if (TextUtils.isEmpty(this.f4337c.f4327w)) {
                    a.g(this.f4336b, "silent");
                }
                e.d(this.f4336b, this.f4342h);
            }
        }
    }

    private void b(j.a aVar) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 20) {
            this.f4340f.add(n.e(this.f4336b, aVar));
            return;
        }
        IconCompat iconCompatE = aVar.e();
        Notification.Action.Builder builderA = i3 >= 23 ? c.a(iconCompatE != null ? iconCompatE.k() : null, aVar.i(), aVar.a()) : a.e(iconCompatE != null ? iconCompatE.d() : 0, aVar.i(), aVar.a());
        if (aVar.f() != null) {
            for (RemoteInput remoteInput : q.b(aVar.f())) {
                a.c(builderA, remoteInput);
            }
        }
        Bundle bundle = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 24) {
            d.a(builderA, aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.g());
        if (i4 >= 28) {
            f.b(builderA, aVar.g());
        }
        if (i4 >= 29) {
            g.c(builderA, aVar.k());
        }
        if (i4 >= 31) {
            h.a(builderA, aVar.j());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
        a.b(builderA, bundle);
        a.a(this.f4336b, a.d(builderA));
    }

    private static List e(List list, List list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        p046n.b bVar = new p046n.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List f(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        H.a(it.next());
        throw null;
    }

    private void g(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }

    @Override // androidx.core.app.i
    public Notification.Builder a() {
        return this.f4336b;
    }

    public Notification c() {
        Bundle bundleA;
        RemoteViews remoteViewsF;
        RemoteViews remoteViewsD;
        j.e eVar = this.f4337c.f4320p;
        if (eVar != null) {
            eVar.b(this);
        }
        RemoteViews remoteViewsE = eVar != null ? eVar.e(this) : null;
        Notification notificationD = d();
        if (remoteViewsE != null) {
            notificationD.contentView = remoteViewsE;
        } else {
            RemoteViews remoteViews = this.f4337c.f4291H;
            if (remoteViews != null) {
                notificationD.contentView = remoteViews;
            }
        }
        if (eVar != null && (remoteViewsD = eVar.d(this)) != null) {
            notificationD.bigContentView = remoteViewsD;
        }
        if (Build.VERSION.SDK_INT >= 21 && eVar != null && (remoteViewsF = this.f4337c.f4320p.f(this)) != null) {
            notificationD.headsUpContentView = remoteViewsF;
        }
        if (eVar != null && (bundleA = j.a(notificationD)) != null) {
            eVar.a(bundleA);
        }
        return notificationD;
    }

    protected Notification d() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            return this.f4336b.build();
        }
        if (i3 >= 24) {
            Notification notificationBuild = this.f4336b.build();
            if (this.f4342h != 0) {
                if (a.f(notificationBuild) != null && (notificationBuild.flags & 512) != 0 && this.f4342h == 2) {
                    g(notificationBuild);
                }
                if (a.f(notificationBuild) != null && (notificationBuild.flags & 512) == 0 && this.f4342h == 1) {
                    g(notificationBuild);
                }
            }
            return notificationBuild;
        }
        if (i3 >= 21) {
            this.f4336b.setExtras(this.f4341g);
            Notification notificationBuild2 = this.f4336b.build();
            RemoteViews remoteViews = this.f4338d;
            if (remoteViews != null) {
                notificationBuild2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f4339e;
            if (remoteViews2 != null) {
                notificationBuild2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f4343i;
            if (remoteViews3 != null) {
                notificationBuild2.headsUpContentView = remoteViews3;
            }
            if (this.f4342h != 0) {
                if (a.f(notificationBuild2) != null && (notificationBuild2.flags & 512) != 0 && this.f4342h == 2) {
                    g(notificationBuild2);
                }
                if (a.f(notificationBuild2) != null && (notificationBuild2.flags & 512) == 0 && this.f4342h == 1) {
                    g(notificationBuild2);
                }
            }
            return notificationBuild2;
        }
        if (i3 < 20) {
            SparseArray<? extends Parcelable> sparseArrayA = n.a(this.f4340f);
            if (sparseArrayA != null) {
                this.f4341g.putSparseParcelableArray("android.support.actionExtras", sparseArrayA);
            }
            this.f4336b.setExtras(this.f4341g);
            Notification notificationBuild3 = this.f4336b.build();
            RemoteViews remoteViews4 = this.f4338d;
            if (remoteViews4 != null) {
                notificationBuild3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f4339e;
            if (remoteViews5 != null) {
                notificationBuild3.bigContentView = remoteViews5;
            }
            return notificationBuild3;
        }
        this.f4336b.setExtras(this.f4341g);
        Notification notificationBuild4 = this.f4336b.build();
        RemoteViews remoteViews6 = this.f4338d;
        if (remoteViews6 != null) {
            notificationBuild4.contentView = remoteViews6;
        }
        RemoteViews remoteViews7 = this.f4339e;
        if (remoteViews7 != null) {
            notificationBuild4.bigContentView = remoteViews7;
        }
        if (this.f4342h != 0) {
            if (a.f(notificationBuild4) != null && (notificationBuild4.flags & 512) != 0 && this.f4342h == 2) {
                g(notificationBuild4);
            }
            if (a.f(notificationBuild4) != null && (notificationBuild4.flags & 512) == 0 && this.f4342h == 1) {
                g(notificationBuild4);
            }
        }
        return notificationBuild4;
    }
}
