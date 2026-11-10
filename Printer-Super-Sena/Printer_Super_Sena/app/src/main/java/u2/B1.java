package u2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import androidx.lifecycle.InterfaceC0363v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;
import rawbt.api.RawbtApiHelper;
import rawbt.sdk.dao.PrinterEntity;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.activity.EditPrinterActivity;
import ru.a402d.rawbtprinter.activity.Magic;
import ru.a402d.rawbtprinter.activity.PermissionsActivity;
import ru.a402d.rawbtprinter.activity.SettingExtActivity;
import ru.a402d.rawbtprinter.activity.TemplatesActivity;

/* JADX INFO: loaded from: classes.dex */
public class B1 extends AbstractComponentCallbacksC0337e {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private y2.b f11970b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private View f11971c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    final s2.b.a f11972d0 = new s2.b.a() { // from class: u2.A1
        @Override // s2.b.a
        public final void a(PrinterEntity printerEntity) {
            this.f11965a.a2(printerEntity);
        }
    };

    private boolean Z1() {
        try {
            if (Build.VERSION.SDK_INT <= 23) {
                String string = Settings.Secure.getString(r1().getContentResolver(), "enabled_print_services");
                if (string != null) {
                    return string.toLowerCase().contains(RawbtApiHelper.SERVICE_PACKAGE.toLowerCase());
                }
                return false;
            }
            String string2 = Settings.Secure.getString(r1().getContentResolver(), "disabled_print_services");
            if (string2 != null) {
                return !string2.toLowerCase().contains(RawbtApiHelper.SERVICE_PACKAGE.toLowerCase());
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a2(PrinterEntity printerEntity) {
        Intent intent = new Intent(r1(), (Class<?>) EditPrinterActivity.class);
        intent.putExtra("id", printerEntity.getId());
        r1().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b2(View view) {
        L1(new Intent(r1(), (Class<?>) Magic.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c2(View view) {
        Toast.makeText(m(), "Use external app", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(View view) {
        L1(new Intent(r1(), (Class<?>) PermissionsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e2(View view) {
        r1().startActivity(new Intent(m(), (Class<?>) SettingExtActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f2(View view) {
        r1().startActivity(new Intent(m(), (Class<?>) TemplatesActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g2(View view) {
        PackageManager packageManager = r1().getPackageManager();
        Intent intent = new Intent("android.settings.ACTION_PRINT_SETTINGS");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        try {
            if (listQueryIntentActivities.size() > 1) {
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    ActivityInfo activityInfo = it.next().activityInfo;
                    if (activityInfo != null) {
                        String str = activityInfo.applicationInfo.packageName;
                        if (!"com.android.settings".equals(str)) {
                            intent.setPackage(str);
                            break;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        try {
            L1(intent);
        } catch (Exception unused2) {
            Toast.makeText(r1(), R.string.Oopppsss, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h2(View view) {
        try {
            boolean zIsChecked = ((CheckBox) this.f11971c0.findViewById(R.id.chkPreviewMode)).isChecked();
            this.f11970b0.O0(zIsChecked);
            if (zIsChecked) {
                this.f11970b0.T0(false);
                ((CheckBox) this.f11971c0.findViewById(R.id.chkStartPrint)).setChecked(false);
            }
        } catch (Exception unused) {
            k2(S(R.string.wrong_input));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2(View view) {
        try {
            boolean zIsChecked = ((CheckBox) this.f11971c0.findViewById(R.id.chkStartPrint)).isChecked();
            this.f11970b0.T0(zIsChecked);
            if (zIsChecked) {
                this.f11970b0.O0(false);
                ((CheckBox) this.f11971c0.findViewById(R.id.chkPreviewMode)).setChecked(false);
            }
        } catch (Exception unused) {
            k2(S(R.string.wrong_input));
        }
    }

    private void j2(View view) {
        ((SwitchCompat) view.findViewById(R.id.turnOn)).setChecked(Z1());
        ((CheckBox) view.findViewById(R.id.chkPreviewMode)).setChecked(this.f11970b0.n0());
        ((CheckBox) view.findViewById(R.id.chkStartPrint)).setChecked(this.f11970b0.r0());
    }

    private void k2(String str) {
        Toast.makeText(m(), str, 1).show();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void K0() {
        super.K0();
        j2(this.f11971c0);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (m() == null) {
            return null;
        }
        this.f11970b0 = y2.b.w();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_settings, viewGroup, false);
        this.f11971c0 = viewInflate;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.rvPrinters);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(r1());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new androidx.recyclerview.widget.c());
        recyclerView.h(new androidx.recyclerview.widget.d(r1(), linearLayoutManager.t2()));
        recyclerView.setHasFixedSize(true);
        final s2.b bVar = new s2.b(r1());
        bVar.A(this.f11972d0);
        recyclerView.setAdapter(bVar);
        ((w2.D) new androidx.lifecycle.P(r1()).a(w2.D.class)).O().g(r1(), new InterfaceC0363v() { // from class: u2.r1
            @Override // androidx.lifecycle.InterfaceC0363v
            public final void a(Object obj) {
                bVar.z((List) obj);
            }
        });
        this.f11971c0.findViewById(R.id.btnAddPrinter).setOnClickListener(new View.OnClickListener() { // from class: u2.s1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12315a.b2(view);
            }
        });
        this.f11971c0.findViewById(R.id.otherServices).setOnClickListener(new View.OnClickListener() { // from class: u2.t1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12317a.c2(view);
            }
        });
        this.f11971c0.findViewById(R.id.goPermissions).setOnClickListener(new View.OnClickListener() { // from class: u2.u1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12320a.d2(view);
            }
        });
        this.f11971c0.findViewById(R.id.goExtSettings).setOnClickListener(new View.OnClickListener() { // from class: u2.v1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12323a.e2(view);
            }
        });
        this.f11971c0.findViewById(R.id.goTemplate).setOnClickListener(new View.OnClickListener() { // from class: u2.w1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12326a.f2(view);
            }
        });
        this.f11971c0.findViewById(R.id.turnOn).setOnClickListener(new View.OnClickListener() { // from class: u2.x1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12331a.g2(view);
            }
        });
        this.f11971c0.findViewById(R.id.chkPreviewMode).setOnClickListener(new View.OnClickListener() { // from class: u2.y1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12335a.h2(view);
            }
        });
        this.f11971c0.findViewById(R.id.chkStartPrint).setOnClickListener(new View.OnClickListener() { // from class: u2.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12339a.i2(view);
            }
        });
        return this.f11971c0;
    }
}
