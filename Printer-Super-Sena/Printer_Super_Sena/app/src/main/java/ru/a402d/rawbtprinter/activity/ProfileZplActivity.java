package ru.a402d.rawbtprinter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AbstractC0245a;
import androidx.lifecycle.InterfaceC0363v;
import rawbt.sdk.dao.PrinterEntity;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class ProfileZplActivity extends AbstractActivityC0634m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayAdapter f11478e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayAdapter f11480g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Spinner f11477d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Spinner f11479f = null;

    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            ProfileZplActivity.this.f11571c.M0(Integer.parseInt(adapterView.getSelectedItem().toString()));
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
            ((TextView) adapterView.getChildAt(0)).setTextColor(ProfileZplActivity.this.getResources().getColor(R.color.colorAccent));
            ProfileZplActivity.this.f11571c.W0(Integer.parseInt(adapterView.getSelectedItem().toString()) * 1000);
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
                ((TextView) adapterView.getChildAt(0)).setTextColor(ProfileZplActivity.this.getResources().getColor(R.color.colorAccent));
            } catch (Exception unused) {
            }
            ProfileZplActivity.this.f11571c.E0(i3);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(ProfileZplActivity.this.getResources().getColor(R.color.colorAccent));
            } catch (Exception unused) {
            }
            ProfileZplActivity.this.f11571c.V0(i3);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        try {
            this.f11571c.B0(((EditText) findViewById(R.id.editBytesInit)).getText().toString(), ((EditText) findViewById(R.id.editBytesFinish)).getText().toString());
        } catch (Exception unused) {
            x(getString(R.string.wrong_input));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", "file:///android_asset/how_bytes.html");
        intent.setType("text/html");
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(PrinterEntity printerEntity) {
        try {
            this.f11479f.setSelection(this.f11480g.getPosition("" + printerEntity.get_lan_delay()));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            this.f11477d.setSelection(this.f11478e.getPosition("" + (printerEntity.getSleepAfter() / 1000)));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        Spinner spinner = (Spinner) findViewById(R.id.spinnerCut);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this, R.array.cutTypesLabel, android.R.layout.simple_spinner_item);
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
        spinner.setSelection(printerEntity.getCutCommand());
        spinner.setOnItemSelectedListener(new c());
        Spinner spinner2 = (Spinner) findViewById(R.id.spinnerLines);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this, R.array.skipLines, android.R.layout.simple_spinner_item);
        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource2);
        spinner2.setSelection(printerEntity.getSkipLinesAfterJob());
        spinner2.setOnItemSelectedListener(new d());
        ((EditText) findViewById(R.id.editBytesInit)).setText(printerEntity.getBytes_init());
        ((EditText) findViewById(R.id.editBytesFinish)).setText(printerEntity.getBytes_finish());
    }

    private void x(String str) {
        Toast.makeText(this, str, 1).show();
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0634m, androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_profile_zpl);
        setTitle("Printer profile");
        AbstractC0245a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.s(true);
        }
        this.f11479f = (Spinner) findViewById(R.id.lanDelaySpinner);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this, R.array.lanDelayMS, android.R.layout.simple_spinner_item);
        this.f11480g = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11479f.setAdapter((SpinnerAdapter) this.f11480g);
        this.f11479f.setOnItemSelectedListener(new a());
        this.f11477d = (Spinner) findViewById(R.id.delayBeforeDisconnect);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this, R.array.lanDelayAfter, android.R.layout.simple_spinner_item);
        this.f11478e = arrayAdapterCreateFromResource2;
        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11477d.setAdapter((SpinnerAdapter) this.f11478e);
        this.f11477d.setOnItemSelectedListener(new b());
        findViewById(R.id.saveBytes).setOnClickListener(new View.OnClickListener() { // from class: r2.o2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11072a.lambda$onCreate$0(view);
            }
        });
        findViewById(R.id.btnHelpBytes).setOnClickListener(new View.OnClickListener() { // from class: r2.p2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11076a.lambda$onCreate$1(view);
            }
        });
        this.f11571c.P().g(this, new InterfaceC0363v() { // from class: r2.q2
            @Override // androidx.lifecycle.InterfaceC0363v
            public final void a(Object obj) {
                this.f11080a.w((PrinterEntity) obj);
            }
        });
    }
}
