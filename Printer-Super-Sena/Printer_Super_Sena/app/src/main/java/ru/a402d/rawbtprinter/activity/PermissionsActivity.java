package ru.a402d.rawbtprinter.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AbstractActivityC0248d;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.activity.PermissionsActivity;

/* JADX INFO: loaded from: classes.dex */
public class PermissionsActivity extends AbstractActivityC0248d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p004b.c f11414a = registerForActivityResult(new p008c.d(), new p004b.b() { // from class: r2.q1
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            PermissionsActivity.x((Boolean) obj);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(View view) {
        if (checkSelfPermission("android.permission.BLUETOOTH_CONNECT") != 0) {
            this.f11414a.a("android.permission.BLUETOOTH_CONNECT");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("package:" + getPackageName()));
        intent.addFlags(268435456);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            this.f11414a.a("android.permission.READ_EXTERNAL_STORAGE");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            this.f11414a.a("android.permission.WRITE_EXTERNAL_STORAGE");
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_permissions);
        setTitle(R.string.required_permissions);
        if (getSupportActionBar() != null) {
            getSupportActionBar().s(true);
            getSupportActionBar().t(true);
        }
        findViewById(R.id.goSystemSettings).setOnClickListener(new View.OnClickListener() { // from class: r2.r1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11084a.lambda$onCreate$1(view);
            }
        });
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            findViewById(R.id.request_READ_EXTERNAL).setOnClickListener(new View.OnClickListener() { // from class: r2.s1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f11089a.y(view);
                }
            });
            if (i3 < 29) {
                findViewById(R.id.request_WRITE_EXTERNAL).setOnClickListener(new View.OnClickListener() { // from class: r2.t1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f11094a.z(view);
                    }
                });
            }
        }
        if (i3 >= 31) {
            findViewById(R.id.request_BT_12).setOnClickListener(new View.OnClickListener() { // from class: r2.u1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f11102a.A(view);
                }
            });
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onResume() {
        super.onResume();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
                ((TextView) findViewById(R.id.title_permission_READ_EXTERNAL)).setTextColor(-65536);
                findViewById(R.id.request_READ_EXTERNAL).setVisibility(0);
            } else {
                ((TextView) findViewById(R.id.title_permission_READ_EXTERNAL)).setTextColor(Color.parseColor("#478d5e"));
                findViewById(R.id.request_READ_EXTERNAL).setVisibility(8);
            }
            if (i3 < 29) {
                if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    ((TextView) findViewById(R.id.title_permission_WRITE_EXTERNAL)).setTextColor(-65536);
                    findViewById(R.id.request_WRITE_EXTERNAL).setVisibility(0);
                } else {
                    ((TextView) findViewById(R.id.title_permission_WRITE_EXTERNAL)).setTextColor(Color.parseColor("#478d5e"));
                    findViewById(R.id.request_WRITE_EXTERNAL).setVisibility(8);
                }
            }
        }
        if (i3 >= 31) {
            if (checkSelfPermission("android.permission.BLUETOOTH_CONNECT") != 0) {
                ((TextView) findViewById(R.id.title_permission_BT_12)).setTextColor(-65536);
                findViewById(R.id.request_BT_12).setVisibility(0);
            } else {
                ((TextView) findViewById(R.id.title_permission_BT_12)).setTextColor(Color.parseColor("#478d5e"));
                findViewById(R.id.request_BT_12).setVisibility(8);
            }
        }
    }
}
