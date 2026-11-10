package ru.a402d.rawbtprinter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AbstractC0245a;
import androidx.lifecycle.InterfaceC0363v;
import rawbt.sdk.dao.PrinterEntity;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class ProfileMinimalActivity extends AbstractActivityC0634m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Spinner f11450d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayAdapter f11451e;

    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            ((TextView) adapterView.getChildAt(0)).setTextColor(ProfileMinimalActivity.this.getResources().getColor(R.color.colorAccent));
            ProfileMinimalActivity.this.f11571c.W0(Integer.parseInt(adapterView.getSelectedItem().toString()) * 1000);
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
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(ProfileMinimalActivity.this.getResources().getColor(R.color.colorAccent));
            } catch (Exception unused) {
            }
            ProfileMinimalActivity.this.f11571c.V0(i3);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(Spinner spinner, PrinterEntity printerEntity) {
        try {
            this.f11450d.setSelection(this.f11451e.getPosition("" + (printerEntity.getSleepAfter() / 1000)));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        spinner.setSelection(printerEntity.getSkipLinesAfterJob());
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0634m, androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_profile_minimal);
        setTitle("Base profile");
        AbstractC0245a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.s(true);
        }
        this.f11450d = (Spinner) findViewById(R.id.delayBeforeDisconnect);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this, R.array.lanDelayAfter, android.R.layout.simple_spinner_item);
        this.f11451e = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11450d.setAdapter((SpinnerAdapter) this.f11451e);
        this.f11450d.setOnItemSelectedListener(new a());
        final Spinner spinner = (Spinner) findViewById(R.id.spinnerLines);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this, R.array.skipLines, android.R.layout.simple_spinner_item);
        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource2);
        spinner.setOnItemSelectedListener(new b());
        this.f11571c.P().g(this, new InterfaceC0363v() { // from class: r2.Z1
            @Override // androidx.lifecycle.InterfaceC0363v
            public final void a(Object obj) {
                this.f10998a.u(spinner, (PrinterEntity) obj);
            }
        });
    }
}
