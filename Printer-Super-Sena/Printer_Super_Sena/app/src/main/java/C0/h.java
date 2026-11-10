package C0;

import F0.AbstractC0220n;
import F0.AbstractC0229x;
import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.fragment.app.AbstractActivityC0338f;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: loaded from: classes.dex */
public class h extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f134c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f132e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final h f133f = new h();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f131d = i.f135a;

    public static h k() {
        return f133f;
    }

    @Override // C0.i
    public Intent a(Context context, int i3, String str) {
        return super.a(context, i3, str);
    }

    @Override // C0.i
    public PendingIntent b(Context context, int i3, int i4) {
        return super.b(context, i3, i4);
    }

    @Override // C0.i
    public final String d(int i3) {
        return super.d(i3);
    }

    @Override // C0.i
    public int e(Context context) {
        return super.e(context);
    }

    @Override // C0.i
    public int f(Context context, int i3) {
        return super.f(context, i3);
    }

    @Override // C0.i
    public final boolean h(int i3) {
        return super.h(i3);
    }

    public Dialog i(Activity activity, int i3, int i4, DialogInterface.OnCancelListener onCancelListener) {
        return n(activity, i3, F0.A.b(activity, a(activity, i3, "d"), i4), onCancelListener, null);
    }

    public PendingIntent j(Context context, C0179a c0179a) {
        return c0179a.f() ? c0179a.e() : b(context, c0179a.c(), 0);
    }

    public boolean l(Activity activity, int i3, int i4, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogI = i(activity, i3, i4, onCancelListener);
        if (dialogI == null) {
            return false;
        }
        q(activity, dialogI, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void m(Context context, int i3) {
        r(context, i3, null, c(context, i3, 0, "n"));
    }

    final Dialog n(Context context, int i3, F0.A a3, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder;
        AlertDialog.Builder builder2 = null;
        if (i3 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder2 == null) {
            builder2 = builder;
            builder2 = new AlertDialog.Builder(context);
        }
        builder2 = builder;
        builder2.setMessage(AbstractC0229x.c(context, i3));
        if (onCancelListener != null) {
            builder2.setOnCancelListener(onCancelListener);
        }
        String strB = AbstractC0229x.b(context, i3);
        DialogInterface.OnClickListener onClickListener2 = a3;
        if (strB != null) {
            if (a3 == null) {
                onClickListener2 = onClickListener;
            }
            builder2.setPositiveButton(strB, onClickListener2);
        }
        String strF = AbstractC0229x.f(context, i3);
        if (strF != null) {
            builder2.setTitle(strF);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i3)), new IllegalArgumentException());
        return builder2.create();
    }

    public final Dialog o(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(AbstractC0229x.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        q(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    public final E0.p p(Context context, E0.o oVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        E0.p pVar = new E0.p(oVar);
        M0.f.k(context, pVar, intentFilter);
        pVar.a(context);
        if (g(context, "com.google.android.gms")) {
            return pVar;
        }
        oVar.a();
        pVar.b();
        return null;
    }

    final void q(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof AbstractActivityC0338f) {
                r.e2(dialog, onCancelListener).d2(((AbstractActivityC0338f) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        DialogFragmentC0180b.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    final void r(Context context, int i3, String str, PendingIntent pendingIntent) {
        int i4;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i3), null), new IllegalArgumentException());
        if (i3 == 18) {
            s(context);
            return;
        }
        if (pendingIntent == null) {
            if (i3 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = AbstractC0229x.e(context, i3);
        String strD = AbstractC0229x.d(context, i3);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) AbstractC0220n.f(context.getSystemService("notification"));
        androidx.core.app.j.d dVarN = new androidx.core.app.j.d(context).k(true).e(true).i(strE).n(new androidx.core.app.j.b().h(strD));
        if (J0.d.b(context)) {
            AbstractC0220n.h(J0.e.c());
            dVarN.m(context.getApplicationInfo().icon).l(2);
            if (J0.d.c(context)) {
                dVarN.a(B0.a.f67a, resources.getString(B0.b.f82o), pendingIntent);
            } else {
                dVarN.g(pendingIntent);
            }
        } else {
            dVarN.m(R.drawable.stat_sys_warning).o(resources.getString(B0.b.f75h)).p(System.currentTimeMillis()).g(pendingIntent).h(strD);
        }
        if (J0.e.f()) {
            AbstractC0220n.h(J0.e.f());
            synchronized (f132e) {
                str2 = this.f134c;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string = context.getResources().getString(B0.b.f74g);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
                } else if (!string.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(string);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            dVarN.f(str2);
        }
        Notification notificationB = dVarN.b();
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            o.f139b.set(false);
            i4 = 10436;
        } else {
            i4 = 39789;
        }
        notificationManager.notify(i4, notificationB);
    }

    final void s(Context context) {
        new s(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean t(Activity activity, E0.e eVar, int i3, int i4, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogN = n(activity, i3, F0.A.c(eVar, a(activity, i3, "d"), 2), onCancelListener, null);
        if (dialogN == null) {
            return false;
        }
        q(activity, dialogN, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean u(Context context, C0179a c0179a, int i3) {
        PendingIntent pendingIntentJ;
        if (K0.b.a(context) || (pendingIntentJ = j(context, c0179a)) == null) {
            return false;
        }
        r(context, c0179a.c(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, pendingIntentJ, i3, true), M0.g.f1294a | 134217728));
        return true;
    }
}
