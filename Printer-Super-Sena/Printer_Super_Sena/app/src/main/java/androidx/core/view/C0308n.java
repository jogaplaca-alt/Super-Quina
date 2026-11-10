package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: renamed from: androidx.core.view.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0308n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0310o f4696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f4697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f4698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private VelocityTracker f4699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f4700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f4704j;

    /* JADX INFO: renamed from: androidx.core.view.n$a */
    interface a {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i3);
    }

    /* JADX INFO: renamed from: androidx.core.view.n$b */
    interface b {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i3);
    }

    public C0308n(Context context, InterfaceC0310o interfaceC0310o) {
        this(context, interfaceC0310o, new b() { // from class: androidx.core.view.l
            @Override // androidx.core.view.C0308n.b
            public final void a(Context context2, int[] iArr, MotionEvent motionEvent, int i3) {
                C0308n.c(context2, iArr, motionEvent, i3);
            }
        }, new a() { // from class: androidx.core.view.m
            @Override // androidx.core.view.C0308n.a
            public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i3) {
                return C0308n.f(velocityTracker, motionEvent, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i3) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = AbstractC0289d0.i(context, viewConfiguration, motionEvent.getDeviceId(), i3, motionEvent.getSource());
        iArr[1] = AbstractC0289d0.h(context, viewConfiguration, motionEvent.getDeviceId(), i3, motionEvent.getSource());
    }

    private boolean d(MotionEvent motionEvent, int i3) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.f4702h == source && this.f4703i == deviceId && this.f4701g == i3) {
            return false;
        }
        this.f4697c.a(this.f4695a, this.f4704j, motionEvent, i3);
        this.f4702h = source;
        this.f4703i = deviceId;
        this.f4701g = i3;
        return true;
    }

    private float e(MotionEvent motionEvent, int i3) {
        if (this.f4699e == null) {
            this.f4699e = VelocityTracker.obtain();
        }
        return this.f4698d.a(this.f4699e, motionEvent, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i3) {
        U.a(velocityTracker, motionEvent);
        U.b(velocityTracker, 1000);
        return U.d(velocityTracker, i3);
    }

    public void g(MotionEvent motionEvent, int i3) {
        boolean zD = d(motionEvent, i3);
        if (this.f4704j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f4699e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f4699e = null;
                return;
            }
            return;
        }
        float fE = e(motionEvent, i3) * this.f4696b.b();
        float fSignum = Math.signum(fE);
        if (zD || (fSignum != Math.signum(this.f4700f) && fSignum != 0.0f)) {
            this.f4696b.c();
        }
        float fAbs = Math.abs(fE);
        int[] iArr = this.f4704j;
        if (fAbs < iArr[0]) {
            return;
        }
        int i4 = iArr[1];
        float fMax = Math.max(-i4, Math.min(fE, i4));
        this.f4700f = this.f4696b.a(fMax) ? fMax : 0.0f;
    }

    C0308n(Context context, InterfaceC0310o interfaceC0310o, b bVar, a aVar) {
        this.f4701g = -1;
        this.f4702h = -1;
        this.f4703i = -1;
        this.f4704j = new int[]{Integer.MAX_VALUE, 0};
        this.f4695a = context;
        this.f4696b = interfaceC0310o;
        this.f4697c = bVar;
        this.f4698d = aVar;
    }
}
