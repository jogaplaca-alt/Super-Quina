package ru.a402d.rawbtprinter.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.InterfaceC0363v;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rawbt.api.RawbtApiHelper;
import rawbt.api.attributes.AttributesImage;
import rawbt.sdk.IRawBtPrintService;
import rawbt.sdk.PrinterEncoding;
import rawbt.sdk.RawbtPrintJob;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.drivers.EscGraphicsCommandList;
import rawbt.sdk.transport.Constant;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
public class ProfileEscActivity extends AbstractActivityC0634m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayAdapter f11431i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayAdapter f11432j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ExecutorService f11426d = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Spinner f11427e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Spinner f11428f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Spinner f11429g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Spinner f11430h = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IRawBtPrintService f11433k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ServiceConnection f11434l = new a();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ProfileEscActivity f11435m = this;

    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ProfileEscActivity.this.f11433k = IRawBtPrintService.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ProfileEscActivity.this.f11433k = null;
        }
    }

    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            ProfileEscActivity.this.f11571c.M0(Integer.parseInt(adapterView.getSelectedItem().toString()));
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
            ProfileEscActivity.this.f11571c.W0(Integer.parseInt(adapterView.getSelectedItem().toString()) * 1000);
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
                ((TextView) adapterView.getChildAt(0)).setTextColor(ProfileEscActivity.this.getResources().getColor(R.color.colorAccent));
            } catch (Exception unused) {
            }
            ProfileEscActivity.this.f11571c.C0(PrinterEncoding.getCodePages(ProfileEscActivity.this.f11435m).get(i3).getName());
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
                ((TextView) adapterView.getChildAt(0)).setTextColor(ProfileEscActivity.this.getResources().getColor(R.color.colorAccent));
            } catch (Exception unused) {
            }
            ProfileEscActivity.this.f11571c.E0(i3);
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
                ((TextView) adapterView.getChildAt(0)).setTextColor(ProfileEscActivity.this.getResources().getColor(R.color.colorAccent));
            } catch (Exception unused) {
            }
            ProfileEscActivity.this.f11571c.K0(i3);
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
                ((TextView) adapterView.getChildAt(0)).setTextColor(ProfileEscActivity.this.getResources().getColor(R.color.colorAccent));
            } catch (Exception unused) {
            }
            ProfileEscActivity.this.f11571c.V0(i3);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    private void N() {
        ArrayList arrayList = new ArrayList();
        List<PrinterEncoding> codePages = PrinterEncoding.getCodePages(this);
        int size = codePages.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            PrinterEncoding printerEncoding = codePages.get(i4);
            arrayList.add(printerEncoding.getName());
            if (((PrinterEntity) this.f11571c.P().e()).getCodePage().equals(printerEncoding.getName())) {
                i3 = i4;
            }
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11427e.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f11427e.setSelection(i3);
        this.f11427e.setOnItemSelectedListener(new d());
    }

    private void O() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new EscGraphicsCommandList());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11428f.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f11428f.setOnItemSelectedListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(View view) {
        this.f11571c.R0(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(View view) {
        try {
            this.f11571c.B0(((EditText) findViewById(R.id.editBytesInit)).getText().toString(), ((EditText) findViewById(R.id.editBytesFinish)).getText().toString());
        } catch (Exception unused) {
            i0(getString(R.string.wrong_input));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(View view) {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", "file:///android_asset/how_bytes.html");
        intent.setType("text/html");
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view) {
        f0("https://www.youtube.com/watch?v=i6ozxCm3wtE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T() {
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(getAssets().open("test-circle.png"));
            if (bitmapDecodeStream != null) {
                Context contextG = RawPrinterApp.g();
                Objects.requireNonNull(contextG);
                File file = new File(contextG.getCacheDir().toString(), "/test.png");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                bitmapDecodeStream.recycle();
                RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
                rawbtPrintJob.setCopies(1);
                rawbtPrintJob.setTemplate(rawbt.api.RawbtPrintJob.TEMPLATE_SIMPLE);
                rawbtPrintJob.setPrinter(((PrinterEntity) this.f11571c.P().e()).getName());
                AttributesImage attributesImage = new AttributesImage();
                attributesImage.setDoScale(false);
                attributesImage.setGraphicFilter(9);
                rawbtPrintJob.image(Uri.fromFile(file), attributesImage);
                this.f11433k.printRawbtPrintJob(rawbtPrintJob.GSON());
            }
        } catch (Exception | OutOfMemoryError e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(View view) {
        Toast.makeText(this, getString(R.string.btnTxtPrint), 0).show();
        this.f11426d.execute(new Runnable() { // from class: r2.O1
            @Override // java.lang.Runnable
            public final void run() {
                this.f10948a.T();
            }
        });
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
    public /* synthetic */ void V(View view) {
        try {
            this.f11571c.w0(((SwitchCompat) findViewById(R.id.chkAllowGSr)).isChecked() ? 1 : 0);
        } catch (Exception unused) {
            i0(getString(R.string.wrong_input));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        Toast.makeText(this, getString(R.string.btnTxtPrint), 0).show();
        g0("***** Short Test *****\nABCDEFGHIJKLMNOPRSTUVWXYZ\n0123456789~!@#$%^&*`{}=|№\n" + B2.b.b(((PrinterEntity) this.f11571c.P().e()).getPrintLanguage()) + "\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(View view) {
        this.f11571c.R0(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(View view) {
        this.f11571c.R0(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(View view) {
        this.f11571c.R0(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(View view) {
        this.f11571c.R0(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        this.f11571c.R0(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(View view) {
        this.f11571c.R0(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(View view) {
        this.f11571c.R0(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(View view) {
        this.f11571c.R0(9);
    }

    private void f0(String str) {
        Uri uri = Uri.parse(str);
        PackageManager packageManager = getPackageManager();
        Intent data = new Intent("android.intent.action.VIEW").setData(uri);
        Intent intentCreateChooser = Intent.createChooser(data, "Open url with ..");
        if (data.resolveActivity(packageManager) != null) {
            startActivity(intentCreateChooser);
        } else {
            Toast.makeText(this, "BROWSER NOT FOUND", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(PrinterEntity printerEntity) {
        N();
        ((RadioButton) findViewById(R.id.cpType0)).setChecked(false);
        ((RadioButton) findViewById(R.id.cpType1)).setChecked(false);
        ((RadioButton) findViewById(R.id.cpType2)).setChecked(false);
        ((RadioButton) findViewById(R.id.cpType3)).setChecked(false);
        ((RadioButton) findViewById(R.id.cpType4)).setChecked(false);
        ((RadioButton) findViewById(R.id.cpType5)).setChecked(false);
        ((RadioButton) findViewById(R.id.cpType6)).setChecked(false);
        ((RadioButton) findViewById(R.id.cpType7)).setChecked(false);
        ((RadioButton) findViewById(R.id.cpType8)).setChecked(false);
        ((RadioButton) findViewById(R.id.cpType9)).setChecked(false);
        ((RadioButton) findViewById(R.id.cpType10)).setChecked(false);
        switch (printerEntity.getPrintLanguageType()) {
            case 0:
                ((RadioButton) findViewById(R.id.cpType0)).setChecked(true);
                break;
            case 1:
                ((RadioButton) findViewById(R.id.cpType1)).setChecked(true);
                break;
            case 2:
                ((RadioButton) findViewById(R.id.cpType2)).setChecked(true);
                break;
            case 3:
                ((RadioButton) findViewById(R.id.cpType3)).setChecked(true);
                break;
            case 4:
                ((RadioButton) findViewById(R.id.cpType4)).setChecked(true);
                break;
            case 5:
                ((RadioButton) findViewById(R.id.cpType5)).setChecked(true);
                break;
            case 6:
                ((RadioButton) findViewById(R.id.cpType6)).setChecked(true);
                break;
            case 7:
                ((RadioButton) findViewById(R.id.cpType7)).setChecked(true);
                break;
            case 8:
                ((RadioButton) findViewById(R.id.cpType8)).setChecked(true);
                break;
            case 9:
                ((RadioButton) findViewById(R.id.cpType9)).setChecked(true);
                break;
            case 10:
                ((RadioButton) findViewById(R.id.cpType10)).setChecked(true);
                break;
        }
        ((EditText) findViewById(R.id.editBytesInit)).setText(printerEntity.getBytes_init());
        ((EditText) findViewById(R.id.editBytesFinish)).setText(printerEntity.getBytes_finish());
        this.f11428f.setSelection(printerEntity.getGraphicsCommand());
        ((SwitchCompat) findViewById(R.id.chkAllowGSr)).setChecked(printerEntity.get_abs_mode() == 1);
        try {
            this.f11429g.setSelection(this.f11431i.getPosition("" + printerEntity.get_lan_delay()));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            this.f11430h.setSelection(this.f11432j.getPosition("" + (printerEntity.getSleepAfter() / 1000)));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        Spinner spinner = (Spinner) findViewById(R.id.spinnerCut);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this, R.array.cutTypes, android.R.layout.simple_spinner_item);
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
        spinner.setSelection(printerEntity.getCutCommand());
        spinner.setOnItemSelectedListener(new e());
        Spinner spinner2 = (Spinner) findViewById(R.id.spinnerLines);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this, R.array.skipLines, android.R.layout.simple_spinner_item);
        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource2);
        spinner2.setSelection(printerEntity.getSkipLinesAfterJob());
        spinner2.setOnItemSelectedListener(new g());
        if (Constant.DRIVER_GSv0.equals(printerEntity.getProfileClass())) {
            findViewById(R.id.titleGraphicCommand).setVisibility(8);
            findViewById(R.id.cardGraph).setVisibility(8);
            findViewById(R.id.titleLang1).setVisibility(8);
            findViewById(R.id.cardLang1).setVisibility(8);
            findViewById(R.id.titleLang2).setVisibility(8);
            findViewById(R.id.cardLang2).setVisibility(8);
            findViewById(R.id.titleCutCommand).setVisibility(8);
            findViewById(R.id.spinnerCut).setVisibility(8);
        }
    }

    private void i0(String str) {
        Toast.makeText(this, str, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        this.f11571c.R0(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        this.f11571c.R0(1);
    }

    public void g0(String str) {
        try {
            PrinterEntity printerEntity = (PrinterEntity) this.f11571c.P().e();
            RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
            rawbtPrintJob.setPrinter(printerEntity.getName());
            rawbtPrintJob.setTemplate(rawbt.api.RawbtPrintJob.TEMPLATE_SIMPLE);
            rawbtPrintJob.setCopies(1);
            rawbtPrintJob.println(str, printerEntity.getAttributesString());
            this.f11433k.printRawbtPrintJob(rawbtPrintJob.GSON());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0634m, androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_profile_esc);
        setTitle("ESC general profile");
        if (this.f11433k == null) {
            bindService(RawbtApiHelper.createExplicitIntent(), this.f11434l, 1);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().s(true);
            getSupportActionBar().t(true);
        }
        findViewById(R.id.cpType0).setOnClickListener(new View.OnClickListener() { // from class: r2.F1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10900a.lambda$onCreate$0(view);
            }
        });
        findViewById(R.id.cpType1).setOnClickListener(new View.OnClickListener() { // from class: r2.X1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10991a.lambda$onCreate$1(view);
            }
        });
        findViewById(R.id.cpType2).setOnClickListener(new View.OnClickListener() { // from class: r2.G1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10905a.X(view);
            }
        });
        findViewById(R.id.cpType3).setOnClickListener(new View.OnClickListener() { // from class: r2.H1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10911a.Y(view);
            }
        });
        findViewById(R.id.cpType4).setOnClickListener(new View.OnClickListener() { // from class: r2.I1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10916a.Z(view);
            }
        });
        findViewById(R.id.cpType5).setOnClickListener(new View.OnClickListener() { // from class: r2.J1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10920a.a0(view);
            }
        });
        findViewById(R.id.cpType6).setOnClickListener(new View.OnClickListener() { // from class: r2.K1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10926a.b0(view);
            }
        });
        findViewById(R.id.cpType7).setOnClickListener(new View.OnClickListener() { // from class: r2.L1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10930a.c0(view);
            }
        });
        findViewById(R.id.cpType8).setOnClickListener(new View.OnClickListener() { // from class: r2.M1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10935a.d0(view);
            }
        });
        findViewById(R.id.cpType9).setOnClickListener(new View.OnClickListener() { // from class: r2.N1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10942a.e0(view);
            }
        });
        findViewById(R.id.cpType10).setOnClickListener(new View.OnClickListener() { // from class: r2.P1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10953a.P(view);
            }
        });
        findViewById(R.id.saveBytes).setOnClickListener(new View.OnClickListener() { // from class: r2.Q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10958a.Q(view);
            }
        });
        findViewById(R.id.btnHelpBytes).setOnClickListener(new View.OnClickListener() { // from class: r2.R1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10963a.R(view);
            }
        });
        this.f11428f = (Spinner) findViewById(R.id.spinnerDriver);
        this.f11427e = (Spinner) findViewById(R.id.spinnerCP);
        findViewById(R.id.youtubeFlowControl).setOnClickListener(new View.OnClickListener() { // from class: r2.S1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10969a.S(view);
            }
        });
        findViewById(R.id.graphDemoPrint).setOnClickListener(new View.OnClickListener() { // from class: r2.T1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10974a.U(view);
            }
        });
        this.f11429g = (Spinner) findViewById(R.id.lanDelaySpinner);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this, R.array.lanDelayMS, android.R.layout.simple_spinner_item);
        this.f11431i = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11429g.setAdapter((SpinnerAdapter) this.f11431i);
        this.f11429g.setOnItemSelectedListener(new b());
        this.f11430h = (Spinner) findViewById(R.id.delayBeforeDisconect);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this, R.array.lanDelayAfter, android.R.layout.simple_spinner_item);
        this.f11432j = arrayAdapterCreateFromResource2;
        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11430h.setAdapter((SpinnerAdapter) this.f11432j);
        this.f11430h.setOnItemSelectedListener(new c());
        findViewById(R.id.chkAllowGSr).setOnClickListener(new View.OnClickListener() { // from class: r2.U1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10980a.V(view);
            }
        });
        findViewById(R.id.textDemoPrintSimple).setOnClickListener(new View.OnClickListener() { // from class: r2.V1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10984a.W(view);
            }
        });
        O();
        this.f11571c.P().g(this, new InterfaceC0363v() { // from class: r2.W1
            @Override // androidx.lifecycle.InterfaceC0363v
            public final void a(Object obj) {
                this.f10988a.h0((PrinterEntity) obj);
            }
        });
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onDestroy() {
        if (this.f11433k != null) {
            unbindService(this.f11434l);
        }
        super.onDestroy();
    }
}
