package ru.a402d.rawbtprinter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AbstractC0245a;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.InterfaceC0363v;
import rawbt.sdk.dao.PrinterEntity;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class ProfileCatActivity extends AbstractActivityC0634m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Spinner f11418d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayAdapter f11420f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayAdapter f11422h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Spinner f11419e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Spinner f11421g = null;

    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            ProfileCatActivity.this.f11571c.M0(Integer.parseInt(adapterView.getSelectedItem().toString()));
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
            ((TextView) adapterView.getChildAt(0)).setTextColor(ProfileCatActivity.this.getResources().getColor(R.color.colorAccent));
            ProfileCatActivity.this.f11571c.W0(Integer.parseInt(adapterView.getSelectedItem().toString()) * 1000);
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
                ((TextView) adapterView.getChildAt(0)).setTextColor(ProfileCatActivity.this.getResources().getColor(R.color.colorAccent));
            } catch (Exception unused) {
            }
            ProfileCatActivity.this.f11571c.V0(i3);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public /* synthetic */ void A(View view) {
        try {
            this.f11571c.w0(((SwitchCompat) findViewById(R.id.chkAllowGSr)).isChecked() ? 1 : 0);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public /* synthetic */ void B(View view) {
        try {
            this.f11571c.K0(((CheckBox) findViewById(R.id.chkUseCompress)).isChecked() ? 1 : 0);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(PrinterEntity printerEntity) {
        this.f11418d.setSelection(printerEntity.getSkipLinesAfterJob());
        ((CheckBox) findViewById(R.id.chkUseCompress)).setChecked(printerEntity.getGraphicsCommand() == 1);
        ((SwitchCompat) findViewById(R.id.chkAllowGSr)).setChecked(printerEntity.get_abs_mode() == 1);
        int darkness = printerEntity.getDarkness();
        if (darkness == 0) {
            ((RadioButton) findViewById(R.id.dark0)).setChecked(true);
        } else if (darkness == 1) {
            ((RadioButton) findViewById(R.id.dark1)).setChecked(true);
        } else if (darkness == 2) {
            ((RadioButton) findViewById(R.id.dark2)).setChecked(true);
        }
        try {
            this.f11419e.setSelection(this.f11420f.getPosition("" + printerEntity.get_lan_delay()));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            this.f11421g.setSelection(this.f11422h.getPosition("" + (printerEntity.getSleepAfter() / 1000)));
        } catch (Exception e4) {
            e4.printStackTrace();
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
    public /* synthetic */ void z(View view) {
        this.f11571c.F0(2);
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0634m, androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_profile_cats);
        setTitle("Meow or Cats printer");
        AbstractC0245a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.s(true);
        }
        findViewById(R.id.dark0).setOnClickListener(new View.OnClickListener() { // from class: r2.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11122a.lambda$onCreate$0(view);
            }
        });
        findViewById(R.id.dark1).setOnClickListener(new View.OnClickListener() { // from class: r2.A1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10877a.lambda$onCreate$1(view);
            }
        });
        findViewById(R.id.dark2).setOnClickListener(new View.OnClickListener() { // from class: r2.B1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10881a.z(view);
            }
        });
        this.f11418d = (Spinner) findViewById(R.id.spinnerLines);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this, R.array.skipLines, android.R.layout.simple_spinner_item);
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11418d.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
        this.f11418d.setOnItemSelectedListener(new c());
        findViewById(R.id.chkAllowGSr).setOnClickListener(new View.OnClickListener() { // from class: r2.C1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10885a.A(view);
            }
        });
        findViewById(R.id.chkUseCompress).setOnClickListener(new View.OnClickListener() { // from class: r2.D1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10890a.B(view);
            }
        });
        this.f11419e = (Spinner) findViewById(R.id.lanDelaySpinner);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this, R.array.lanDelayMS, android.R.layout.simple_spinner_item);
        this.f11420f = arrayAdapterCreateFromResource2;
        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11419e.setAdapter((SpinnerAdapter) this.f11420f);
        this.f11419e.setOnItemSelectedListener(new a());
        this.f11421g = (Spinner) findViewById(R.id.delayBeforeDisconnect);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource3 = ArrayAdapter.createFromResource(this, R.array.lanDelayAfter, android.R.layout.simple_spinner_item);
        this.f11422h = arrayAdapterCreateFromResource3;
        arrayAdapterCreateFromResource3.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11421g.setAdapter((SpinnerAdapter) this.f11422h);
        this.f11421g.setOnItemSelectedListener(new b());
        this.f11571c.P().g(this, new InterfaceC0363v() { // from class: r2.E1
            @Override // androidx.lifecycle.InterfaceC0363v
            public final void a(Object obj) {
                this.f10895a.C((PrinterEntity) obj);
            }
        });
    }
}
