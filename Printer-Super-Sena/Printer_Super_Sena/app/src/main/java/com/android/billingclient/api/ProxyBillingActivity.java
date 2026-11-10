package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.AbstractC0439k;

/* JADX INFO: loaded from: classes.dex */
public class ProxyBillingActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ResultReceiver f7021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ResultReceiver f7022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7024d;

    private Intent a(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        intent.putExtra("BROADCAST_RECEIVER_LOGGING_PAYLOAD", o.d(3, AbstractC0439k.t(o.a(intent.getAction()))).h());
        return intent;
    }

    private Intent b() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("BROADCAST_RECEIVER_LOGGING_PAYLOAD", o.d(3, AbstractC0439k.t(o.a(intent.getAction()))).h());
        return intent;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        Intent intentB;
        super.onActivityResult(i3, i4, intent);
        if (i3 == 100 || i3 == 110) {
            int iB = com.google.android.gms.internal.play_billing.C.d(intent, "ProxyBillingActivity").b();
            if (i4 != -1) {
                com.google.android.gms.internal.play_billing.C.i("ProxyBillingActivity", "Activity finished with resultCode " + i4 + " and billing's responseCode: " + iB);
            } else if (iB != 0) {
                i4 = -1;
                com.google.android.gms.internal.play_billing.C.i("ProxyBillingActivity", "Activity finished with resultCode " + i4 + " and billing's responseCode: " + iB);
            } else {
                iB = 0;
            }
            ResultReceiver resultReceiver = this.f7021a;
            if (resultReceiver != null) {
                resultReceiver.send(iB, intent != null ? intent.getExtras() : null);
            } else {
                if (intent == null) {
                    intentB = b();
                } else if (intent.getExtras() != null) {
                    String string = intent.getExtras().getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                    if (string != null) {
                        intentB = a(string);
                        intentB.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                    } else {
                        intentB = b();
                        intentB.putExtras(intent.getExtras());
                        intentB.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                    }
                } else {
                    intentB = b();
                    com.google.android.gms.internal.play_billing.C.i("ProxyBillingActivity", "Got null bundle!");
                    intentB.putExtra("RESPONSE_CODE", 6);
                    intentB.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    C0394e.a aVarC = C0394e.c();
                    aVarC.c(6);
                    aVarC.b("An internal error occurred.");
                    intentB.putExtra("FAILURE_LOGGING_PAYLOAD", o.b(22, 2, aVarC.a()).h());
                    intentB.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                }
                if (i3 == 110) {
                    intentB.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                }
                sendBroadcast(intentB);
            }
        } else if (i3 == 101) {
            int iA = com.google.android.gms.internal.play_billing.C.a(intent, "ProxyBillingActivity");
            ResultReceiver resultReceiver2 = this.f7022b;
            if (resultReceiver2 != null) {
                resultReceiver2.send(iA, intent != null ? intent.getExtras() : null);
            }
        } else {
            com.google.android.gms.internal.play_billing.C.i("ProxyBillingActivity", "Got onActivityResult with wrong requestCode: " + i3 + "; skipping...");
        }
        this.f7023c = false;
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        int i3;
        super.onCreate(bundle);
        if (bundle != null) {
            com.google.android.gms.internal.play_billing.C.h("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.f7023c = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey("result_receiver")) {
                this.f7021a = (ResultReceiver) bundle.getParcelable("result_receiver");
            } else if (bundle.containsKey("in_app_message_result_receiver")) {
                this.f7022b = (ResultReceiver) bundle.getParcelable("in_app_message_result_receiver");
            }
            this.f7024d = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            return;
        }
        com.google.android.gms.internal.play_billing.C.h("ProxyBillingActivity", "Launching Play Store billing flow");
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.f7024d = true;
                i3 = 110;
            } else {
                i3 = 100;
            }
        } else {
            if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
                this.f7021a = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
            } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
                this.f7022b = (ResultReceiver) getIntent().getParcelableExtra("in_app_message_result_receiver");
                i3 = 101;
            } else {
                pendingIntent = null;
            }
            i3 = 100;
        }
        try {
            this.f7023c = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), i3, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e3) {
            com.google.android.gms.internal.play_billing.C.j("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", e3);
            ResultReceiver resultReceiver = this.f7021a;
            if (resultReceiver != null) {
                resultReceiver.send(6, null);
            } else {
                ResultReceiver resultReceiver2 = this.f7022b;
                if (resultReceiver2 != null) {
                    resultReceiver2.send(0, null);
                } else {
                    Intent intentB = b();
                    if (this.f7024d) {
                        intentB.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                    }
                    intentB.putExtra("RESPONSE_CODE", 6);
                    intentB.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    sendBroadcast(intentB);
                }
            }
            this.f7023c = false;
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.f7023c) {
            Intent intentB = b();
            intentB.putExtra("RESPONSE_CODE", 1);
            intentB.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            sendBroadcast(intentB);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.f7021a;
        if (resultReceiver != null) {
            bundle.putParcelable("result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.f7022b;
        if (resultReceiver2 != null) {
            bundle.putParcelable("in_app_message_result_receiver", resultReceiver2);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.f7023c);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.f7024d);
    }
}
