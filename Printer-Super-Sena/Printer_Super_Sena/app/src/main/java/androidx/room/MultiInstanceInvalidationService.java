package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f6260b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RemoteCallbackList f6261c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k.a f6262d = new a();

    public static final class a extends k.a {
        a() {
        }

        @Override // androidx.room.k
        public void C(int i3, String[] strArr) {
            S1.k.e(strArr, "tables");
            RemoteCallbackList remoteCallbackListA = MultiInstanceInvalidationService.this.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (remoteCallbackListA) {
                String str = (String) multiInstanceInvalidationService.b().get(Integer.valueOf(i3));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int iBeginBroadcast = multiInstanceInvalidationService.a().beginBroadcast();
                for (int i4 = 0; i4 < iBeginBroadcast; i4++) {
                    try {
                        Object broadcastCookie = multiInstanceInvalidationService.a().getBroadcastCookie(i4);
                        S1.k.c(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                        Integer num = (Integer) broadcastCookie;
                        int iIntValue = num.intValue();
                        String str2 = (String) multiInstanceInvalidationService.b().get(num);
                        if (i3 != iIntValue && S1.k.a(str, str2)) {
                            try {
                                ((j) multiInstanceInvalidationService.a().getBroadcastItem(i4)).I(strArr);
                            } catch (RemoteException e3) {
                                Log.w("ROOM", "Error invoking a remote callback", e3);
                            }
                        }
                    } catch (Throwable th) {
                        multiInstanceInvalidationService.a().finishBroadcast();
                        throw th;
                    }
                }
                multiInstanceInvalidationService.a().finishBroadcast();
                J1.l lVar = J1.l.f1194a;
            }
        }

        @Override // androidx.room.k
        public void L(j jVar, int i3) {
            S1.k.e(jVar, "callback");
            RemoteCallbackList remoteCallbackListA = MultiInstanceInvalidationService.this.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (remoteCallbackListA) {
                multiInstanceInvalidationService.a().unregister(jVar);
            }
        }

        @Override // androidx.room.k
        public int g(j jVar, String str) {
            S1.k.e(jVar, "callback");
            int i3 = 0;
            if (str == null) {
                return 0;
            }
            RemoteCallbackList remoteCallbackListA = MultiInstanceInvalidationService.this.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (remoteCallbackListA) {
                try {
                    multiInstanceInvalidationService.d(multiInstanceInvalidationService.c() + 1);
                    int iC = multiInstanceInvalidationService.c();
                    if (multiInstanceInvalidationService.a().register(jVar, Integer.valueOf(iC))) {
                        multiInstanceInvalidationService.b().put(Integer.valueOf(iC), str);
                        i3 = iC;
                    } else {
                        multiInstanceInvalidationService.d(multiInstanceInvalidationService.c() - 1);
                        multiInstanceInvalidationService.c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i3;
        }
    }

    public static final class b extends RemoteCallbackList {
        b() {
        }

        @Override // android.os.RemoteCallbackList
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(j jVar, Object obj) {
            S1.k.e(jVar, "callback");
            S1.k.e(obj, "cookie");
            MultiInstanceInvalidationService.this.b().remove((Integer) obj);
        }
    }

    public final RemoteCallbackList a() {
        return this.f6261c;
    }

    public final Map b() {
        return this.f6260b;
    }

    public final int c() {
        return this.f6259a;
    }

    public final void d(int i3) {
        this.f6259a = i3;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        S1.k.e(intent, "intent");
        return this.f6262d;
    }
}
