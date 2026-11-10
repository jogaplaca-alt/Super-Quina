package u2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.AbstractActivityC0338f;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import androidx.gridlayout.widget.GridLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;
import ru.a402d.rawbtprinter.activity.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public class Q0 extends AbstractComponentCallbacksC0337e {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    final ExecutorService f12079b0 = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    final Handler f12080c0 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    GridLayout f12081d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    View f12082e0;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a2(View view) {
        ((MainActivity) r1()).F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b2(View view) {
        ((MainActivity) r1()).J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c2(View view) {
        ((MainActivity) r1()).R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(View view) {
        ((MainActivity) r1()).N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e2(View view) {
        ((MainActivity) r1()).D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f2(View view) {
        ((MainActivity) r1()).Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g2(DialogInterface dialogInterface, int i3) {
        try {
            ((MainActivity) r1()).L();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(m());
        builder.setTitle(R.string.faq_lic_how_remove);
        builder.setMessage(R.string.faq_lic_how_remove_ans);
        builder.setNegativeButton(S(R.string.dialog_cancel), (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(S(R.string.mitem_license), new DialogInterface.OnClickListener() { // from class: u2.P0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f12076a.g2(dialogInterface, i3);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2(boolean z3) {
        if (z3) {
            k2(0);
        } else {
            k2(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j2() {
        final boolean zL = RawPrinterApp.l();
        this.f12080c0.post(new Runnable() { // from class: u2.O0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12073a.i2(zL);
            }
        });
    }

    private void k2(int i3) {
        this.f12082e0.findViewById(R.id.text_free1).setVisibility(i3);
        this.f12082e0.findViewById(R.id.text_free2).setVisibility(i3);
        this.f12082e0.findViewById(R.id.text_free3).setVisibility(i3);
        this.f12082e0.findViewById(R.id.text_free_click).setVisibility(i3);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void K0() {
        super.K0();
        this.f12079b0.execute(new Runnable() { // from class: u2.G0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12016a.j2();
            }
        });
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        int childCount = this.f12081d0.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            this.f12081d0.getChildAt(i3).setLayoutParams(new GridLayout.o());
        }
        this.f12081d0.setColumnCount(configuration.orientation == 2 ? 3 : 2);
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_main, viewGroup, false);
        this.f12082e0 = viewInflate;
        viewInflate.findViewById(R.id.btn_main_home).setOnClickListener(new View.OnClickListener() { // from class: u2.H0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12022a.a2(view);
            }
        });
        this.f12082e0.findViewById(R.id.btn_main_edit).setOnClickListener(new View.OnClickListener() { // from class: u2.I0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12029a.b2(view);
            }
        });
        this.f12082e0.findViewById(R.id.btn_main_txt).setOnClickListener(new View.OnClickListener() { // from class: u2.J0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12034a.c2(view);
            }
        });
        this.f12082e0.findViewById(R.id.btn_main_pdf).setOnClickListener(new View.OnClickListener() { // from class: u2.K0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12037a.d2(view);
            }
        });
        this.f12082e0.findViewById(R.id.btn_main_img).setOnClickListener(new View.OnClickListener() { // from class: u2.L0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12042a.e2(view);
            }
        });
        this.f12082e0.findViewById(R.id.btn_main_setting).setOnClickListener(new View.OnClickListener() { // from class: u2.M0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12069a.f2(view);
            }
        });
        this.f12082e0.findViewById(R.id.btn_main_home).requestFocus();
        AbstractActivityC0338f abstractActivityC0338fR1 = r1();
        new Intent().setPackage(abstractActivityC0338fR1.getPackageName());
        this.f12082e0.findViewById(R.id.text_free_click).setOnClickListener(new View.OnClickListener() { // from class: u2.N0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12071a.h2(view);
            }
        });
        this.f12081d0 = (GridLayout) this.f12082e0.findViewById(R.id.grid_view);
        int i3 = abstractActivityC0338fR1.getResources().getDisplayMetrics().heightPixels;
        float f3 = i3 <= 1024 ? 0.4f : 0.5f;
        if (i3 <= 800) {
            f3 = 0.05f;
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) this.f12081d0.getLayoutParams();
        bVar.f3739H = f3;
        this.f12081d0.setLayoutParams(bVar);
        return this.f12082e0;
    }
}
