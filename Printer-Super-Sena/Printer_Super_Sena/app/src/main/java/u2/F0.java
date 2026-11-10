package u2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.billingclient.api.C0393d;
import com.android.billingclient.api.C0394e;
import com.android.billingclient.api.C0395f;
import com.android.billingclient.api.SkuDetails;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;
import ru.a402d.rawbtprinter.activity.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public class F0 extends AbstractComponentCallbacksC0337e implements SwipeRefreshLayout.j {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private View f12004d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private SwipeRefreshLayout f12005e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private ListView f12006f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private s2.d f12007g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private Activity f12008h0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    final ExecutorService f12002b0 = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    final Handler f12003c0 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    volatile SkuDetails f12009i0 = null;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    volatile SkuDetails f12010j0 = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    volatile SkuDetails f12011k0 = null;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    volatile SkuDetails f12012l0 = null;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A2(View view) {
        if (this.f12009i0 != null) {
            this.f12002b0.execute(new Runnable() { // from class: u2.E0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11999a.z2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B2() {
        if (RawPrinterApp.f11272m.d(this.f12008h0, C0393d.a().b(this.f12010j0).a()).b() == 7) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C2(View view) {
        if (this.f12010j0 != null) {
            this.f12002b0.execute(new Runnable() { // from class: u2.n0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12254a.B2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D2() {
        if (RawPrinterApp.f11272m.d(this.f12008h0, C0393d.a().b(this.f12011k0).a()).b() == 7) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E2(View view) {
        if (this.f12011k0 != null) {
            this.f12002b0.execute(new Runnable() { // from class: u2.k0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12244a.D2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F2() {
        K2();
        this.f12005e0.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G2() {
        this.f12003c0.post(new Runnable() { // from class: u2.j0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12214a.F2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H2() {
        try {
            ViewGroup.LayoutParams layoutParams = this.f12006f0.getLayoutParams();
            int size = RawPrinterApp.f11273n.size();
            layoutParams.height = ((size * 68) * M().getDisplayMetrics().densityDpi) / 160;
            this.f12006f0.setLayoutParams(layoutParams);
            this.f12007g0.a(RawPrinterApp.f11273n);
            this.f12007g0.notifyDataSetChanged();
            int i3 = 0;
            if (size > 0 || RawPrinterApp.f11270k) {
                this.f12004d0.findViewById(R.id.skuList).setVisibility(8);
                this.f12006f0.setVisibility(0);
            } else {
                View viewFindViewById = this.f12004d0.findViewById(R.id.skuList);
                if (!RawPrinterApp.f11271l) {
                    i3 = 8;
                }
                viewFindViewById.setVisibility(i3);
                this.f12006f0.setVisibility(8);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I2() {
        if (RawPrinterApp.f11273n == null) {
            return;
        }
        this.f12003c0.post(new Runnable() { // from class: u2.w0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12325a.H2();
            }
        });
    }

    private void J2() {
        this.f12002b0.execute(new Runnable() { // from class: u2.m0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12251a.I2();
            }
        });
    }

    private void m2() {
        if (RawPrinterApp.f11271l && RawPrinterApp.f11272m.c()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("month");
            arrayList.add("quarter");
            arrayList.add("year");
            arrayList.add("lifetime");
            C0395f.a aVarC = C0395f.c();
            aVarC.b(arrayList).c("inapp");
            RawPrinterApp.f11272m.g(aVarC.a(), new p038k0.j() { // from class: u2.p0
                @Override // p038k0.j
                public final void a(C0394e c0394e, List list) {
                    this.f12263a.s2(c0394e, list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n2(SkuDetails skuDetails) {
        ((TextView) this.f12004d0.findViewById(R.id.sku_1_price)).setText(skuDetails.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o2(SkuDetails skuDetails) {
        ((TextView) this.f12004d0.findViewById(R.id.sku_3_price)).setText(skuDetails.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p2(SkuDetails skuDetails) {
        ((TextView) this.f12004d0.findViewById(R.id.sku_12_price)).setText(skuDetails.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q2(SkuDetails skuDetails) {
        ((TextView) this.f12004d0.findViewById(R.id.sku_lifetime)).setText(skuDetails.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2() {
        try {
            this.f12004d0.findViewById(R.id.skuList).setVisibility(8);
            Toast.makeText(r1(), S(R.string.lic_not_avaiable), 0).show();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s2(C0394e c0394e, List list) {
        if (c0394e.b() != 0 || list == null || list.size() != 4) {
            this.f12003c0.post(new Runnable() { // from class: u2.v0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12322a.r2();
                }
            });
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final SkuDetails skuDetails = (SkuDetails) it.next();
            String strB = skuDetails.b();
            strB.hashCode();
            switch (strB) {
                case "year":
                    this.f12011k0 = skuDetails;
                    this.f12003c0.post(new Runnable() { // from class: u2.s0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f12313a.p2(skuDetails);
                        }
                    });
                    break;
                case "month":
                    this.f12009i0 = skuDetails;
                    this.f12003c0.post(new Runnable() { // from class: u2.q0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f12267a.n2(skuDetails);
                        }
                    });
                    break;
                case "quarter":
                    this.f12010j0 = skuDetails;
                    this.f12003c0.post(new Runnable() { // from class: u2.r0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f12293a.o2(skuDetails);
                        }
                    });
                    break;
                case "lifetime":
                    this.f12012l0 = skuDetails;
                    this.f12003c0.post(new Runnable() { // from class: u2.u0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f12318a.q2(skuDetails);
                        }
                    });
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2() {
        if (RawPrinterApp.f11272m.d(this.f12008h0, C0393d.a().b(this.f12012l0).a()).b() == 7) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u2(View view) {
        if (this.f12012l0 != null) {
            this.f12002b0.execute(new Runnable() { // from class: u2.o0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12259a.t2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v2(View view) {
        ((MainActivity) r1()).B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w2(View view) {
        y2.b.w().y0(0);
        ((MainActivity) r1()).M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x2() {
        this.f12003c0.post(new Runnable() { // from class: u2.l0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12247a.K2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y2(View view) {
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z2() {
        if (RawPrinterApp.f11272m.d(this.f12008h0, C0393d.a().b(this.f12009i0).a()).b() == 7) {
            f();
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public boolean D0(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 1) {
            f();
        } else if (itemId == 2) {
            ((MainActivity) this.f12008h0).I("file:///android_asset/open_source_licenses.html");
        } else if (itemId == 3) {
            ((MainActivity) this.f12008h0).I("file:///android_asset/privacy_policy.html");
        }
        return super.D0(menuItem);
    }

    public void K2() {
        if (RawPrinterApp.l()) {
            this.f12004d0.findViewById(R.id.free_license).setVisibility(y2.b.w().j() <= 25 ? 8 : 0);
            if (RawPrinterApp.f11271l) {
                ((TextView) this.f12004d0.findViewById(R.id.textLicStatus)).setText(R.string.VER_FREE);
                ((TextView) this.f12004d0.findViewById(R.id.textLicEnd)).setText(R.string.why_buy);
            } else {
                ((TextView) this.f12004d0.findViewById(R.id.textLicStatus)).setText(R.string.lic_not_avaiable);
                ((TextView) this.f12004d0.findViewById(R.id.textLicEnd)).setText(R.string.In_app_is_unavailable);
            }
        } else {
            this.f12004d0.findViewById(R.id.free_license).setVisibility(8);
            ((TextView) this.f12004d0.findViewById(R.id.textLicStatus)).setText(R.string.VER_PREMIUM);
            if (RawPrinterApp.f11270k) {
                ((TextView) this.f12004d0.findViewById(R.id.textLicEnd)).setText("Спасибо автору можно сказать на 4pda");
            } else {
                ((TextView) this.f12004d0.findViewById(R.id.textLicEnd)).setText(String.format(S(R.string.expired_mask), DateFormat.getDateTimeInstance(3, 3, Locale.getDefault()).format(RawPrinterApp.i())));
            }
        }
        J2();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void f() {
        this.f12005e0.setRefreshing(true);
        m2();
        RawPrinterApp.q(new Runnable() { // from class: u2.i0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12210a.G2();
            }
        });
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void s0(Menu menu, MenuInflater menuInflater) {
        menu.add(0, 1, 1, S(R.string.refresh));
        menu.add(0, 2, 2, R.string.open_source_license);
        menu.add(0, 3, 3, S(R.string.mitem_policy));
        super.s0(menu, menuInflater);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1(true);
        this.f12008h0 = r1();
        View viewInflate = layoutInflater.inflate(R.layout.activity_license, viewGroup, false);
        this.f12004d0 = viewInflate;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(R.id.swipeLic);
        this.f12005e0 = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
        this.f12006f0 = (ListView) this.f12004d0.findViewById(R.id.purchases_list);
        s2.d dVar = new s2.d(r1());
        this.f12007g0 = dVar;
        this.f12006f0.setAdapter((ListAdapter) dVar);
        m2();
        K2();
        RawPrinterApp.q(new Runnable() { // from class: u2.t0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12316a.x2();
            }
        });
        this.f12004d0.findViewById(R.id.btnRefresh).setOnClickListener(new View.OnClickListener() { // from class: u2.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12330a.y2(view);
            }
        });
        this.f12004d0.findViewById(R.id.buy1).setOnClickListener(new View.OnClickListener() { // from class: u2.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12334a.A2(view);
            }
        });
        this.f12004d0.findViewById(R.id.buy3).setOnClickListener(new View.OnClickListener() { // from class: u2.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12338a.C2(view);
            }
        });
        this.f12004d0.findViewById(R.id.buy12).setOnClickListener(new View.OnClickListener() { // from class: u2.A0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11964a.E2(view);
            }
        });
        this.f12004d0.findViewById(R.id.buy_lifetime).setOnClickListener(new View.OnClickListener() { // from class: u2.B0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11969a.u2(view);
            }
        });
        this.f12004d0.findViewById(R.id.faq_license).setOnClickListener(new View.OnClickListener() { // from class: u2.C0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11976a.v2(view);
            }
        });
        this.f12004d0.findViewById(R.id.free_license).setOnClickListener(new View.OnClickListener() { // from class: u2.D0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11980a.w2(view);
            }
        });
        ((TextView) this.f12004d0.findViewById(R.id.textAppVersion)).setText(String.format(S(R.string.app_ver_mask), "7.0.2"));
        return this.f12004d0;
    }
}
