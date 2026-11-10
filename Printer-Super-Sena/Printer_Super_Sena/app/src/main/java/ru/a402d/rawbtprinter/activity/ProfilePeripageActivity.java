package ru.a402d.rawbtprinter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AbstractC0245a;
import androidx.lifecycle.InterfaceC0363v;
import rawbt.sdk.dao.PrinterEntity;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class ProfilePeripageActivity extends AbstractActivityC0634m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayAdapter f11470e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayAdapter f11472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Spinner f11473h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Spinner f11469d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Spinner f11471f = null;

    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            ProfilePeripageActivity.this.f11571c.M0(Integer.parseInt(adapterView.getSelectedItem().toString()));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            ((TextView) adapterView.getChildAt(0)).setTextColor(ProfilePeripageActivity.this.getResources().getColor(R.color.colorAccent));
            ProfilePeripageActivity.this.f11571c.W0(Integer.parseInt(adapterView.getSelectedItem().toString()) * 1000);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(ProfilePeripageActivity.this.getResources().getColor(R.color.colorAccent));
            } catch (Exception unused) {
            }
            ProfilePeripageActivity.this.f11571c.V0(i3);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        this.f11571c.F0(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        this.f11571c.F0(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(View view) {
        this.f11571c.F0(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(PrinterEntity printerEntity) {
        this.f11473h.setSelection(printerEntity.getSkipLinesAfterJob());
        int darkness = printerEntity.getDarkness();
        if (darkness == 0) {
            ((RadioButton) findViewById(R.id.dark0)).setChecked(true);
        } else if (darkness == 1) {
            ((RadioButton) findViewById(R.id.dark1)).setChecked(true);
        } else if (darkness == 2) {
            ((RadioButton) findViewById(R.id.dark2)).setChecked(true);
        }
        try {
            this.f11469d.setSelection(this.f11470e.getPosition("" + printerEntity.get_lan_delay()));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            this.f11471f.setSelection(this.f11472g.getPosition("" + (printerEntity.getSleepAfter() / 1000)));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0634m, androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_profile_peripage);
        setTitle("PeriPage profile");
        AbstractC0245a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.s(true);
        }
        findViewById(R.id.dark0).setOnClickListener(new View.OnClickListener() { // from class: r2.k2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11047a.lambda$onCreate$0(view);
            }
        });
        findViewById(R.id.dark1).setOnClickListener(new View.OnClickListener() { // from class: r2.l2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11052a.lambda$onCreate$1(view);
            }
        });
        findViewById(R.id.dark2).setOnClickListener(new View.OnClickListener() { // from class: r2.m2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11059a.x(view);
            }
        });
        this.f11469d = (Spinner) findViewById(R.id.lanDelaySpinner);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this, R.array.lanDelayMS, android.R.layout.simple_spinner_item);
        this.f11470e = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11469d.setAdapter((SpinnerAdapter) this.f11470e);
        this.f11469d.setOnItemSelectedListener(new a());
        this.f11471f = (Spinner) findViewById(R.id.delayBeforeDisconnect);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this, R.array.lanDelayAfter, android.R.layout.simple_spinner_item);
        this.f11472g = arrayAdapterCreateFromResource2;
        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11471f.setAdapter((SpinnerAdapter) this.f11472g);
        this.f11471f.setOnItemSelectedListener(new b());
        this.f11473h = (Spinner) findViewById(R.id.spinnerLines);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource3 = ArrayAdapter.createFromResource(this, R.array.skipLines, android.R.layout.simple_spinner_item);
        arrayAdapterCreateFromResource3.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11473h.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource3);
        this.f11473h.setOnItemSelectedListener(new c());
        this.f11571c.P().g(this, new InterfaceC0363v() { // from class: r2.n2
            @Override // androidx.lifecycle.InterfaceC0363v
            public final void a(Object obj) {
                this.f11066a.y((PrinterEntity) obj);
            }
        });
    }
}
