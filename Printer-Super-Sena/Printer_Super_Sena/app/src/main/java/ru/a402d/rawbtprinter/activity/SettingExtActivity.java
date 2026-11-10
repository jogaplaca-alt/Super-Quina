package ru.a402d.rawbtprinter.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AbstractActivityC0248d;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
public class SettingExtActivity extends AbstractActivityC0248d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SeekBar f11487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f11488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private y2.b f11489e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map f11491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map f11492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Spinner f11493i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Spinner f11494j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Spinner f11495k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f11485a = 16;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f11486b = 96;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Spinner f11490f = null;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z3) {
            if (i3 < 1) {
                i3 = 1;
            }
            if (z3) {
                try {
                    SettingExtActivity.this.f11489e.x0(i3);
                } catch (Exception unused) {
                    SettingExtActivity settingExtActivity = SettingExtActivity.this;
                    settingExtActivity.U(settingExtActivity.getString(R.string.wrong_input));
                }
            }
            SettingExtActivity.this.refresh();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    class b implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11497a;

        b() {
            this.f11497a = SettingExtActivity.this.f11489e.U() - 16;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z3) {
            this.f11497a = i3;
            ((TextView) SettingExtActivity.this.findViewById(R.id.textGraphFontSize)).setText(String.format(SettingExtActivity.this.getString(R.string.current_font_size), Integer.valueOf(i3 + 16)));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SettingExtActivity.this.f11489e.X0(this.f11497a + 16);
        }
    }

    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(SettingExtActivity.this.getResources().getColor(R.color.colorAccent));
                SettingExtActivity.this.f11489e.Z0(i3);
            } catch (Exception unused) {
            }
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
                ((TextView) adapterView.getChildAt(0)).setTextColor(SettingExtActivity.this.getResources().getColor(R.color.colorAccent));
                SettingExtActivity.this.f11489e.F0(i3);
            } catch (Exception unused) {
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class e implements AdapterView.OnItemSelectedListener {
        e() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(SettingExtActivity.this.getResources().getColor(R.color.colorAccent));
                SettingExtActivity.this.f11489e.H0(i3);
            } catch (Exception unused) {
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class f implements AdapterView.OnItemSelectedListener {
        f() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(SettingExtActivity.this.getResources().getColor(R.color.colorAccent));
                SettingExtActivity.this.f11489e.G0(i3);
            } catch (Exception unused) {
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class g implements AdapterView.OnItemSelectedListener {
        g() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(SettingExtActivity.this.getResources().getColor(R.color.colorAccent));
                SettingExtActivity.this.f11489e.I0(Integer.parseInt((String) new ArrayList(SettingExtActivity.this.f11491g.keySet()).get(i3)));
            } catch (Exception unused) {
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class h implements AdapterView.OnItemSelectedListener {
        h() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(SettingExtActivity.this.getResources().getColor(R.color.colorAccent));
                SettingExtActivity.this.f11489e.J0(Integer.parseInt((String) new ArrayList(SettingExtActivity.this.f11491g.keySet()).get(i3)));
            } catch (Exception unused) {
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class i implements AdapterView.OnItemSelectedListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(SettingExtActivity.this.getResources().getColor(R.color.colorAccent));
                SettingExtActivity.this.f11489e.E0(i3);
            } catch (Exception unused) {
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(SettingExtActivity.this.getResources().getColor(R.color.colorAccent));
                SettingExtActivity.this.f11489e.K0(Integer.parseInt((String) new ArrayList(SettingExtActivity.this.f11492h.keySet()).get(i3)));
            } catch (Exception unused) {
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class k implements AdapterView.OnItemSelectedListener {
        k() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(SettingExtActivity.this.getResources().getColor(R.color.colorAccent));
                SettingExtActivity.this.f11489e.L0(Integer.parseInt((String) new ArrayList(SettingExtActivity.this.f11492h.keySet()).get(i3)));
            } catch (Exception unused) {
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    private void H() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, this.f11489e.x());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11494j.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f11494j.setSelection(this.f11489e.z());
        this.f11494j.setOnItemSelectedListener(new d());
    }

    private void I() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, this.f11489e.r());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11495k.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f11495k.setSelection(this.f11489e.B());
        this.f11495k.setOnItemSelectedListener(new e());
    }

    private void J() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, this.f11489e.y());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11493i.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f11493i.setSelection(this.f11489e.A());
        this.f11493i.setOnItemSelectedListener(new f());
    }

    private void K() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, this.f11489e.s());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11490f.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f11490f.setSelection(this.f11489e.t());
        this.f11490f.setOnItemSelectedListener(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(View view) {
        try {
            this.f11489e.w0(((CheckBox) findViewById(R.id.chkTruncateMozila)).isChecked());
        } catch (Exception unused) {
            U(getString(R.string.wrong_input));
        }
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(View view) {
        try {
            this.f11489e.S0(((CheckBox) findViewById(R.id.chkRoll)).isChecked());
        } catch (Exception unused) {
            U(getString(R.string.wrong_input));
        }
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(View view) {
        try {
            this.f11489e.B0(((CheckBox) findViewById(R.id.chkTruncateTopOnFirst)).isChecked());
            refresh();
        } catch (Exception e3) {
            U(getString(R.string.wrong_input));
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(View view) {
        try {
            this.f11489e.C0(Integer.parseInt(((EditText) findViewById(R.id.editTopCrop)).getText().toString()));
            Toast.makeText(this.f11488d, R.string.Saved, 0).show();
            RawPrinterApp.k((EditText) findViewById(R.id.editTopCrop), (Activity) this.f11488d);
        } catch (Exception unused) {
            U(getString(R.string.wrong_input));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(View view) {
        try {
            this.f11489e.z0(((CheckBox) findViewById(R.id.chkTruncateFrame)).isChecked());
            refresh();
        } catch (Exception e3) {
            U(getString(R.string.wrong_input));
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(View view) {
        try {
            this.f11489e.A0(Integer.parseInt(((EditText) findViewById(R.id.editTruncateFrame)).getText().toString()));
            Toast.makeText(this.f11488d, R.string.Saved, 0).show();
            RawPrinterApp.k((EditText) findViewById(R.id.editTruncateFrame), (Activity) this.f11488d);
        } catch (Exception unused) {
            U(getString(R.string.wrong_input));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(View view) {
        try {
            this.f11489e.N0(((CheckBox) findViewById(R.id.chkCutBetween)).isChecked());
        } catch (Exception unused) {
            U(getString(R.string.wrong_input));
        }
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view) {
        T("https://www.youtube.com/watch?v=Cv7L17o-Ecg");
    }

    private void T(String str) {
        Uri uri = Uri.parse(str);
        PackageManager packageManager = getPackageManager();
        Intent data = new Intent("android.intent.action.VIEW").setData(uri);
        Intent intentCreateChooser = Intent.createChooser(data, getString(R.string.open_url_with));
        if (data.resolveActivity(packageManager) != null) {
            startActivity(intentCreateChooser);
        } else {
            Toast.makeText(this, getString(R.string.browser_not_found), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(String str) {
        Toast.makeText(this, str, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        try {
            this.f11489e.Y0(((CheckBox) findViewById(R.id.chkUTF)).isChecked());
        } catch (Exception unused) {
            U(getString(R.string.wrong_input));
        }
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        try {
            this.f11489e.D0(((CheckBox) findViewById(R.id.chkDontAsk)).isChecked());
        } catch (Exception unused) {
            U(getString(R.string.wrong_input));
        }
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        J();
        H();
        I();
        ((CheckBox) findViewById(R.id.chkUTF)).setChecked(this.f11489e.t0());
        ((CheckBox) findViewById(R.id.chkDontAsk)).setChecked(this.f11489e.k0());
        ((SeekBar) findViewById(R.id.seekCopies)).setProgress(this.f11489e.i());
        ((CheckBox) findViewById(R.id.chkTruncateMozila)).setChecked(this.f11489e.h0());
        ((CheckBox) findViewById(R.id.chkRoll)).setChecked(this.f11489e.q0());
        Spinner spinner = (Spinner) findViewById(R.id.spinnerWidthTruncate);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this, R.array.WidthTruncateModeNames, android.R.layout.simple_spinner_item);
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
        spinner.setSelection(this.f11489e.V());
        spinner.setOnItemSelectedListener(new c());
        ((CheckBox) findViewById(R.id.chkTruncateTopOnFirst)).setChecked(this.f11489e.j0());
        findViewById(R.id.pnlTopCut).setVisibility(this.f11489e.j0() ? 0 : 8);
        ((EditText) findViewById(R.id.editTopCrop)).setText(String.format("%d", Integer.valueOf(this.f11489e.l())));
        ((CheckBox) findViewById(R.id.chkTruncateFrame)).setChecked(this.f11489e.i0());
        findViewById(R.id.pnlTruncateFrame).setVisibility(this.f11489e.i0() ? 0 : 8);
        ((EditText) findViewById(R.id.editTruncateFrame)).setText(String.format("%d", Integer.valueOf(this.f11489e.k())));
        ((CheckBox) findViewById(R.id.chkCutBetween)).setChecked(this.f11489e.m0());
        Spinner spinner2 = (Spinner) findViewById(R.id.limitPages);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new ArrayList(this.f11492h.values()));
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new ArrayList(this.f11492h.keySet()));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner2.setSelection(arrayAdapter2.getPosition(String.format("%03d", Integer.valueOf(this.f11489e.F()))));
        spinner2.setOnItemSelectedListener(new k());
        Spinner spinner3 = (Spinner) findViewById(R.id.limitFiles);
        spinner3.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner3.setSelection(arrayAdapter2.getPosition(String.format("%03d", Integer.valueOf(this.f11489e.E()))));
        spinner3.setOnItemSelectedListener(new j());
        Spinner spinner4 = (Spinner) findViewById(R.id.limitFileSize);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new ArrayList(this.f11491g.values()));
        ArrayAdapter arrayAdapter4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new ArrayList(this.f11491g.keySet()));
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner4.setAdapter((SpinnerAdapter) arrayAdapter3);
        spinner4.setSelection(arrayAdapter4.getPosition(String.format("%07d", Integer.valueOf(this.f11489e.D()))));
        spinner4.setOnItemSelectedListener(new h());
        Spinner spinner5 = (Spinner) findViewById(R.id.limitDownload);
        ArrayAdapter arrayAdapter5 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new ArrayList(this.f11491g.values()));
        ArrayAdapter arrayAdapter6 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new ArrayList(this.f11491g.keySet()));
        arrayAdapter5.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner5.setAdapter((SpinnerAdapter) arrayAdapter5);
        spinner5.setSelection(arrayAdapter6.getPosition(String.format("%07d", Integer.valueOf(this.f11489e.C()))));
        spinner5.setOnItemSelectedListener(new g());
        ((TextView) findViewById(R.id.textGraphFontSize)).setText(String.format(getString(R.string.current_font_size), Integer.valueOf(this.f11489e.U())));
        this.f11487c.setProgress(this.f11489e.U() - 16);
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11488d = this;
        this.f11489e = y2.b.w();
        this.f11491g = new TreeMap(B2.b.g(this, R.raw.limit_file_sizes));
        this.f11492h = new TreeMap(B2.b.g(this, R.raw.limits_counts));
        setContentView(R.layout.activity_setting_ext);
        setTitle(getString(R.string.settings_ext));
        if (getSupportActionBar() != null) {
            getSupportActionBar().s(true);
            getSupportActionBar().t(true);
        }
        this.f11493i = (Spinner) findViewById(R.id.spinnerFontSize);
        this.f11494j = (Spinner) findViewById(R.id.spinnerCPI);
        this.f11495k = (Spinner) findViewById(R.id.spinnerEscR);
        findViewById(R.id.chkUTF).setOnClickListener(new View.OnClickListener() { // from class: r2.r2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11085a.lambda$onCreate$0(view);
            }
        });
        findViewById(R.id.chkDontAsk).setOnClickListener(new View.OnClickListener() { // from class: r2.s2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11090a.lambda$onCreate$1(view);
            }
        });
        ((SeekBar) findViewById(R.id.seekCopies)).setOnSeekBarChangeListener(new a());
        findViewById(R.id.chkTruncateMozila).setOnClickListener(new View.OnClickListener() { // from class: r2.t2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11095a.L(view);
            }
        });
        findViewById(R.id.chkRoll).setOnClickListener(new View.OnClickListener() { // from class: r2.u2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11103a.M(view);
            }
        });
        findViewById(R.id.chkTruncateTopOnFirst).setOnClickListener(new View.OnClickListener() { // from class: r2.v2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11107a.N(view);
            }
        });
        findViewById(R.id.saveTopCrop).setOnClickListener(new View.OnClickListener() { // from class: r2.w2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11112a.O(view);
            }
        });
        findViewById(R.id.chkTruncateFrame).setOnClickListener(new View.OnClickListener() { // from class: r2.x2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11116a.P(view);
            }
        });
        findViewById(R.id.saveTruncateFrame).setOnClickListener(new View.OnClickListener() { // from class: r2.y2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11119a.Q(view);
            }
        });
        findViewById(R.id.chkCutBetween).setOnClickListener(new View.OnClickListener() { // from class: r2.z2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11123a.R(view);
            }
        });
        this.f11490f = (Spinner) findViewById(R.id.spinnerGraph);
        K();
        findViewById(R.id.youtubeFilters).setOnClickListener(new View.OnClickListener() { // from class: r2.A2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10878a.S(view);
            }
        });
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBarFont);
        this.f11487c = seekBar;
        seekBar.setMax(80);
        this.f11487c.setOnSeekBarChangeListener(new b());
        refresh();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    public void onResume() {
        super.onResume();
        refresh();
    }
}
