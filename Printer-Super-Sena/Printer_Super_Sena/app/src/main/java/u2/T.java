package u2;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.DialogInterfaceC0247c;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import r2.W2;
import r2.X2;
import rawbt.api.Constant;
import rawbt.api.RawbtMediaTypes;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.RawbtPrintJob;
import rawbt.sdk.utils.File;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;
import ru.a402d.rawbtprinter.activity.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public class T extends AbstractComponentCallbacksC0337e implements X2, W2 {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    static int f12089r0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private SeekBar f12094f0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private EditText f12097i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private final y2.b f12098j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private AttributesString f12099k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final RawbtPrintJob f12100l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private Spinner f12101m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final p004b.c f12102n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    View f12103o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    ScrollView f12104p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    ConstraintLayout f12105q0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    final ExecutorService f12090b0 = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    final Handler f12091c0 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    final int f12092d0 = 16;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    final int f12093e0 = 96;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final p004b.c f12095g0 = p1(new p008c.b(), new p004b.b() { // from class: u2.N
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            this.f12070a.d2((Uri) obj);
        }
    });

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final p004b.c f12096h0 = p1(new p008c.e(), new p004b.b() { // from class: u2.O
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            this.f12072a.w2((p004b.a) obj);
        }
    });

    class a extends BottomSheetBehavior.g {
        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View view, float f3) {
            T.this.i2();
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void c(View view, int i3) {
            T.this.i2();
        }
    }

    public T() {
        y2.b bVarW = y2.b.w();
        this.f12098j0 = bVarW;
        this.f12099k0 = bVarW.c();
        this.f12100l0 = new RawbtPrintJob();
        this.f12102n0 = p1(new p008c.e(), new p004b.b() { // from class: u2.P
            @Override // p004b.b
            public final void onActivityResult(Object obj) {
                this.f12075a.n2((p004b.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d2(final Uri uri) {
        if (uri == null) {
            return;
        }
        if (RawbtMediaTypes.detectContentType(r1(), uri, "text/plain") != Constant.RAWBT_CONTENT_TYPE.txt) {
            Toast.makeText(r1(), "Not allowed media type", 0).show();
        } else {
            this.f12090b0.execute(new Runnable() { // from class: u2.S
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12084a.l2(uri);
                }
            });
        }
    }

    private void h2() {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        try {
            this.f12102n0.a(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(t(), S(R.string.need_speach_engine), 1).show();
        }
    }

    private void j2() {
        ArrayList arrayListY = this.f12098j0.y();
        arrayListY.add("TrueType");
        ArrayAdapter arrayAdapter = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, arrayListY);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f12101m0.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f12101m0.setSelection(this.f12099k0.getPrinterFont());
        this.f12101m0.setOnItemSelectedListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(String str) {
        this.f12097i0.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(Uri uri) {
        try {
            final String txtFile = File.readTxtFile(r1().getContentResolver().openInputStream(uri), 999999, t());
            this.f12091c0.post(new Runnable() { // from class: u2.I
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12027a.k2(txtFile);
                }
            });
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m2(int i3) {
        ViewGroup.LayoutParams layoutParams = this.f12104p0.getLayoutParams();
        layoutParams.height = i3;
        this.f12104p0.setLayoutParams(layoutParams);
        f12089r0 = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n2(p004b.a aVar) {
        if (aVar.d() == -1) {
            try {
                Intent intentC = aVar.c();
                Objects.requireNonNull(intentC);
                ArrayList<String> stringArrayListExtra = intentC.getStringArrayListExtra("android.speech.extra.RESULTS");
                Objects.requireNonNull(stringArrayListExtra);
                String str = stringArrayListExtra.get(0);
                this.f12097i0.getText().insert(this.f12097i0.getSelectionStart(), str + " ");
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o2(String str) {
        this.f12097i0.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p2(Bundle bundle) {
        final String string = "";
        if (bundle != null) {
            string = bundle.getString("text");
        } else {
            try {
                string = r1().getPreferences(0).getString("saved_text", "");
            } catch (Exception unused) {
            }
        }
        this.f12091c0.post(new Runnable() { // from class: u2.G
            @Override // java.lang.Runnable
            public final void run() {
                this.f12014a.o2(string);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q2(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        i2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(View view) {
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s2(View view) {
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2(DialogInterface dialogInterface, int i3) {
        try {
            L1(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=ru.a402d.texttoprint")));
        } catch (ActivityNotFoundException unused) {
            L1(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=ru.a402d.texttoprint")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u2(Uri uri, String str) {
        try {
            OutputStream outputStreamOpenOutputStream = r1().getContentResolver().openOutputStream(uri);
            outputStreamOpenOutputStream.write(str.getBytes());
            outputStreamOpenOutputStream.flush();
            outputStreamOpenOutputStream.close();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static AbstractComponentCallbacksC0337e v2(String str) {
        T t3 = new T();
        Bundle bundle = new Bundle();
        bundle.putString("text", str);
        t3.A1(bundle);
        return t3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w2(p004b.a aVar) {
        Intent intentC;
        if (aVar.d() != -1 || (intentC = aVar.c()) == null) {
            return;
        }
        final Uri data = intentC.getData();
        final String string = this.f12097i0.getText().toString();
        this.f12090b0.execute(new Runnable() { // from class: u2.H
            @Override // java.lang.Runnable
            public final void run() {
                this.f12019a.u2(data, string);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00e8 A[Catch: Exception -> 0x0070, TRY_LEAVE, TryCatch #0 {Exception -> 0x0070, blocks: (B:20:0x003a, B:24:0x006b, B:36:0x00e8, B:35:0x00dc, B:29:0x0074, B:32:0x007a), top: B:52:0x003a, inners: #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public boolean D0(MenuItem menuItem) {
        PackageInfo packageInfo;
        int itemId = menuItem.getItemId();
        if (itemId == R.id.texttoprint) {
            b();
            return true;
        }
        if (itemId == R.id.speechrequest) {
            h2();
            return true;
        }
        if (itemId == R.id.opentext) {
            d();
            return true;
        }
        if (itemId == R.id.cleartext) {
            this.f12097i0.setText("");
            return true;
        }
        if (itemId != R.id.texttoprintapp) {
            if (itemId == R.id.saveText) {
                String str = new SimpleDateFormat("yyyy-MM-dd_HH-mm", Locale.getDefault()).format(new Date());
                Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TITLE", str + ".txt");
                this.f12096h0.a(intent);
            } else if (itemId == R.id.shareText) {
                try {
                    String str2 = this.f12097i0.getText().toString() + "\n";
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.setType("text/plain");
                    intent2.putExtra("android.intent.extra.TEXT", str2);
                    L1(intent2);
                } catch (Exception e3) {
                    RawPrinterApp.r(e3.getClass().getSimpleName());
                }
                return true;
            }
            return super.D0(menuItem);
        }
        try {
            String str3 = this.f12097i0.getText().toString() + "\n";
            Intent intent3 = new Intent("android.intent.action.SEND");
            intent3.setType("text/plain");
            intent3.putExtra("android.intent.extra.TEXT", str3);
            PackageManager packageManager = s1().getPackageManager();
            if (packageManager != null) {
                try {
                    packageInfo = packageManager.getPackageInfo("ru.a402d.texttoprint", 0);
                } catch (PackageManager.NameNotFoundException e4) {
                    e4.printStackTrace();
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    try {
                        DialogInterfaceC0247c.a aVar = new DialogInterfaceC0247c.a(r1());
                        TextView textView = new TextView(m());
                        textView.setText(R.string.install_dialog_title);
                        textView.setBackgroundColor(-12303292);
                        textView.setPadding(10, 10, 10, 10);
                        textView.setGravity(17);
                        textView.setTextColor(-1);
                        textView.setTextSize(14.0f);
                        ImageView imageView = new ImageView(m());
                        imageView.setImageResource(R.mipmap.ic_launcher);
                        aVar.f(R.string.install_dialog_message).k(imageView).d(textView);
                        aVar.h(R.string.install_dialog_btn, new DialogInterface.OnClickListener() { // from class: u2.F
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                this.f12001a.t2(dialogInterface, i3);
                            }
                        });
                        aVar.a().show();
                    } catch (Exception e5) {
                        RawPrinterApp.r(e5.getClass().getSimpleName());
                    }
                } else {
                    intent3.setPackage("ru.a402d.texttoprint");
                    L1(intent3);
                }
            } else {
                packageInfo = null;
                if (packageInfo == null) {
                    DialogInterfaceC0247c.a aVar2 = new DialogInterfaceC0247c.a(r1());
                    TextView textView2 = new TextView(m());
                    textView2.setText(R.string.install_dialog_title);
                    textView2.setBackgroundColor(-12303292);
                    textView2.setPadding(10, 10, 10, 10);
                    textView2.setGravity(17);
                    textView2.setTextColor(-1);
                    textView2.setTextSize(14.0f);
                    ImageView imageView2 = new ImageView(m());
                    imageView2.setImageResource(R.mipmap.ic_launcher);
                    aVar2.f(R.string.install_dialog_message).k(imageView2).d(textView2);
                    aVar2.h(R.string.install_dialog_btn, new DialogInterface.OnClickListener() { // from class: u2.F
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            this.f12001a.t2(dialogInterface, i3);
                        }
                    });
                    aVar2.a().show();
                } else {
                    intent3.setPackage("ru.a402d.texttoprint");
                    L1(intent3);
                }
            }
        } catch (Exception e6) {
            RawPrinterApp.r(e6.getClass().getSimpleName());
        }
        return true;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void L0(Bundle bundle) {
        super.L0(bundle);
        bundle.putString("text", this.f12097i0.getText().toString());
        bundle.putParcelable("attrStr", this.f12099k0);
    }

    @Override // r2.X2
    public void b() {
        RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
        rawbtPrintJob.setTemplate(this.f12100l0.getTemplate());
        rawbtPrintJob.setPrinter(this.f12100l0.getPrinter());
        rawbtPrintJob.setCopies(this.f12100l0.getCopies());
        rawbtPrintJob.setIdJob(UUID.randomUUID().toString());
        ((MainActivity) r1()).h0(rawbtPrintJob.getIdJob(), rawbtPrintJob.getPrinter());
        rawbtPrintJob.println(this.f12097i0.getText().toString() + "\n", this.f12099k0);
        try {
            ((MainActivity) r1()).f11399o.printRawbtPrintJob(rawbtPrintJob.GSON());
        } catch (Exception e3) {
            Toast.makeText(r1(), e3.getLocalizedMessage(), 0).show();
        }
    }

    @Override // r2.W2
    public void d() {
        try {
            this.f12095g0.a("*/*");
        } catch (Exception unused) {
            Toast.makeText(m(), R.string.need_external_fm, 1).show();
        }
    }

    void i2() {
        final int y3 = ((int) this.f12105q0.getY()) - 1;
        if (f12089r0 != y3) {
            this.f12091c0.post(new Runnable() { // from class: u2.Q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12077a.m2(y3);
                }
            });
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void s0(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.edit, menu);
        super.s0(menu, menuInflater);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1(true);
        t2.c cVar = (t2.c) androidx.databinding.f.d(layoutInflater, R.layout.fragment_editor, viewGroup, false);
        cVar.A(this.f12099k0);
        View viewP = cVar.p();
        this.f12103o0 = viewP;
        this.f12097i0 = (EditText) viewP.findViewById(R.id.input_area);
        this.f12104p0 = (ScrollView) this.f12103o0.findViewById(R.id.scrollBlock);
        if (bundle != null) {
            this.f12097i0.setText(bundle.getString("text"));
            this.f12099k0 = (AttributesString) bundle.getParcelable("attrStr");
        } else {
            final Bundle bundleR = r();
            this.f12090b0.execute(new Runnable() { // from class: u2.J
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12032a.p2(bundleR);
                }
            });
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) this.f12103o0.findViewById(R.id.bottom_sheet);
        this.f12105q0 = constraintLayout;
        BottomSheetBehavior bottomSheetBehaviorQ0 = BottomSheetBehavior.q0(constraintLayout);
        bottomSheetBehaviorQ0.O0((int) ((M().getDisplayMetrics().densityDpi / 160.0f) * 52.0f));
        bottomSheetBehaviorQ0.c0(new a());
        this.f12103o0.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: u2.K
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                this.f12036a.q2(view, i3, i4, i5, i6, i7, i8, i9, i10);
            }
        });
        ViewGroup.LayoutParams layoutParams = this.f12105q0.getLayoutParams();
        layoutParams.height = (int) ((M().getDisplayMetrics().densityDpi / 160.0f) * 320.0f);
        this.f12105q0.setLayoutParams(layoutParams);
        this.f12103o0.findViewById(R.id.btnEditSelect).setOnClickListener(new View.OnClickListener() { // from class: u2.L
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12041a.r2(view);
            }
        });
        this.f12103o0.findViewById(R.id.btnEditPrint).setOnClickListener(new View.OnClickListener() { // from class: u2.M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12068a.s2(view);
            }
        });
        this.f12101m0 = (Spinner) this.f12103o0.findViewById(R.id.spinnerFontType);
        j2();
        SeekBar seekBar = (SeekBar) this.f12103o0.findViewById(R.id.seekBarFont);
        this.f12094f0 = seekBar;
        seekBar.setMax(80);
        this.f12094f0.setProgress(this.f12099k0.getTruetypeFontSize() - 16);
        this.f12094f0.setOnSeekBarChangeListener(new b());
        this.f12100l0.setCopies(this.f12098j0.i());
        s2.g.c(r1(), (Spinner) this.f12103o0.findViewById(R.id.spinnerSelectPrinter), this.f12100l0);
        Spinner spinner = (Spinner) this.f12103o0.findViewById(R.id.spinnerSelectTemplate);
        ArrayAdapter arrayAdapter = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, y2.b.S());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setOnItemSelectedListener(new c());
        Spinner spinner2 = (Spinner) this.f12103o0.findViewById(R.id.spinnerNumbersCopies);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, y2.b.H());
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter2);
        spinner2.setSelection(this.f12100l0.getCopies() - 1);
        spinner2.setOnItemSelectedListener(new d());
        this.f12103o0.findViewById(R.id.btnEditSelect).requestFocus();
        return this.f12103o0;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void u0() {
        try {
            SharedPreferences.Editor editorEdit = r1().getPreferences(0).edit();
            editorEdit.putString("saved_text", this.f12097i0.getText().toString());
            editorEdit.apply();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        super.u0();
    }

    class b implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f12107a;

        b() {
            this.f12107a = T.this.f12099k0.getTruetypeFontSize() - 16;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z3) {
            this.f12107a = i3;
            ((TextView) T.this.f12103o0.findViewById(R.id.textGraphFontSize)).setText(String.format(T.this.S(R.string.current_font_size), Integer.valueOf(i3 + 16)));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            T.this.f12099k0.setTruetypeFontSize(this.f12107a + 16);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
    }

    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            if (i3 == 1) {
                T.this.f12100l0.setTemplate("none");
            } else {
                T.this.f12100l0.setTemplate(rawbt.api.RawbtPrintJob.TEMPLATE_DEFAULT);
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
            T.this.f12100l0.setCopies(i3 + 1);
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
            int truetypeFontSize;
            T.this.f12099k0.setPrinterFont(i3);
            T.this.f12094f0.setVisibility(4);
            if (i3 == 2) {
                truetypeFontSize = 17;
            } else if (i3 == 3) {
                truetypeFontSize = 16;
            } else if (i3 != 4) {
                truetypeFontSize = 24;
            } else {
                truetypeFontSize = T.this.f12099k0.getTruetypeFontSize();
                T.this.f12094f0.setVisibility(0);
            }
            ((TextView) T.this.f12103o0.findViewById(R.id.textGraphFontSize)).setText(String.format(T.this.S(R.string.current_font_size), Integer.valueOf(truetypeFontSize)));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }
}
