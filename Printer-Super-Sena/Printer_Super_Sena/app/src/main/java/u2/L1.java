package u2;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.AbstractActivityC0338f;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import r2.W2;
import r2.X2;
import rawbt.api.Constant;
import rawbt.api.RawbtMediaTypes;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.PrinterEncoding;
import rawbt.sdk.RawbtPrintJob;
import rawbt.sdk.utils.File;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;
import ru.a402d.rawbtprinter.activity.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public class L1 extends AbstractComponentCallbacksC0337e implements View.OnClickListener, X2, W2 {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    final ExecutorService f12043b0 = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    final Handler f12044c0 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    final int f12045d0 = 16;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    final int f12046e0 = 96;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private final y2.b f12047f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final RawbtPrintJob f12048g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private View f12049h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private ScrollView f12050i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private ScrollView f12051j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private TextView f12052k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private ProgressBar f12053l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private Parcelable f12054m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final p004b.c f12055n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private String f12056o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private String f12057p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f12058q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private SeekBar f12059r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private AttributesString f12060s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private Spinner f12061t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private long f12062u0;

    public L1() {
        y2.b bVarW = y2.b.w();
        this.f12047f0 = bVarW;
        this.f12048g0 = new RawbtPrintJob();
        this.f12054m0 = null;
        this.f12055n0 = p1(new p008c.b(), new p004b.b() { // from class: u2.C1
            @Override // p004b.b
            public final void onActivityResult(Object obj) {
                this.f11977a.Z1((Uri) obj);
            }
        });
        this.f12056o0 = "Cp437";
        this.f12057p0 = "";
        this.f12058q0 = 1;
        this.f12060s0 = bVarW.c();
        this.f12062u0 = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1(Parcelable parcelable) {
        if (parcelable == null) {
            return;
        }
        this.f12054m0 = parcelable;
        if (!(parcelable instanceof Uri)) {
            this.f12054m0 = Uri.parse(parcelable.toString());
        }
        Constant.RAWBT_CONTENT_TYPE rawbt_content_typeDetectContentType = RawbtMediaTypes.detectContentType(r1(), (Uri) this.f12054m0, "text/plain");
        if (rawbt_content_typeDetectContentType != Constant.RAWBT_CONTENT_TYPE.txt) {
            if (rawbt_content_typeDetectContentType == Constant.RAWBT_CONTENT_TYPE.unsupported) {
                Toast.makeText(r1(), S(R.string.not_allowed_media_type), 0).show();
            } else {
                ((MainActivity) r1()).b0((Uri) this.f12054m0);
            }
        }
    }

    private void a2() {
        final AbstractActivityC0338f abstractActivityC0338fM = m();
        if (abstractActivityC0338fM == null) {
            return;
        }
        if (this.f12054m0 instanceof Uri) {
            this.f12043b0.execute(new Runnable() { // from class: u2.G1
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f12017a.j2(abstractActivityC0338fM);
                }
            });
            return;
        }
        ((TextView) this.f12049h0.findViewById(R.id.textViewFileSize)).setText(R.string.not_selected);
        this.f12049h0.findViewById(R.id.btnTxtPrint).setVisibility(8);
        this.f12050i0.setVisibility(0);
        this.f12051j0.setVisibility(4);
        this.f12053l0.setVisibility(8);
    }

    private void f2() {
        ArrayList arrayListY = this.f12047f0.y();
        arrayListY.add("TrueType");
        ArrayAdapter arrayAdapter = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, arrayListY);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f12061t0.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f12061t0.setSelection(this.f12060s0.getPrinterFont());
        this.f12061t0.setOnItemSelectedListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g2(Activity activity, String str, long j3) {
        activity.setTitle(File.getFileName(str));
        this.f12049h0.findViewById(R.id.btnTxtPrint).setVisibility(8);
        ((TextView) this.f12049h0.findViewById(R.id.textViewFileSize)).setText(String.format(activity.getString(R.string.kb_size), Long.valueOf(j3 / 1024)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h2(long j3) {
        this.f12053l0.setMax((int) j3);
        this.f12053l0.setProgress(1);
        this.f12053l0.setVisibility(0);
        this.f12057p0 = this.f12056o0;
        this.f12052k0.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2() {
        this.f12049h0.findViewById(R.id.btnTxtPrint).setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:75:0x0175  */
    /* JADX WARN: Code duplicated, block: B:76:0x017b  */
    public /* synthetic */ void j2(final Activity activity) throws Throwable {
        long j3;
        final long j4;
        Throwable th;
        IOException iOException;
        final String filePath = File.getFilePath((Uri) this.f12054m0, activity);
        if (filePath.length() <= 0) {
            return;
        }
        try {
            Cursor cursorQuery = activity.getContentResolver().query((Uri) this.f12054m0, null, null, null, null);
            Objects.requireNonNull(cursorQuery);
            int columnIndex = cursorQuery.getColumnIndex("_size");
            cursorQuery.moveToFirst();
            j3 = cursorQuery.getLong(columnIndex);
            cursorQuery.close();
        } catch (NullPointerException e3) {
            if (this.f12054m0.toString().endsWith("preview_temp")) {
                j4 = 1;
            } else {
                e3.printStackTrace();
                j3 = -1;
            }
            final long j5 = j4;
            this.f12044c0.post(new Runnable() { // from class: u2.H1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12023a.g2(activity, filePath, j5);
                }
            });
            q2();
            if (j4 > 0) {
            }
            if (j4 < 1) {
                r2(-10, "File is empty");
                return;
            } else {
                r2(-10, "Over 128Kb. It is very long roll.");
                return;
            }
        }
        j4 = j3;
        final long j6 = j4;
        this.f12044c0.post(new Runnable() { // from class: u2.H1
            @Override // java.lang.Runnable
            public final void run() {
                this.f12023a.g2(activity, filePath, j6);
            }
        });
        q2();
        if (j4 > 0 || j4 > 131072) {
            if (j4 < 1) {
                r2(-10, "File is empty");
                return;
            } else {
                r2(-10, "Over 128Kb. It is very long roll.");
                return;
            }
        }
        this.f12044c0.post(new Runnable() { // from class: u2.I1
            @Override // java.lang.Runnable
            public final void run() {
                this.f12030a.h2(j4);
            }
        });
        q2();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            InputStream inputStreamOpenInputStream = r1().getContentResolver().openInputStream((Uri) this.f12054m0);
            if (inputStreamOpenInputStream == null) {
                r2(-10, "Empty input stream\n\n\n");
                return;
            }
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStreamOpenInputStream, this.f12058q0 == 1 ? "UTF-8" : this.f12056o0), 65535);
                    int i3 = 0;
                    boolean z3 = true;
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line != null) {
                                int length = line.length();
                                int i4 = i3 + length;
                                if (length > 0) {
                                    sb.append(line);
                                }
                                sb.append("\n");
                                i3 = i4 + 1;
                                if (z3 && i3 > 4096) {
                                    r2(i3, sb.toString());
                                    jCurrentTimeMillis = System.currentTimeMillis();
                                    z3 = false;
                                } else if (System.currentTimeMillis() - jCurrentTimeMillis > 50) {
                                    r2(i3, null);
                                    jCurrentTimeMillis = System.currentTimeMillis();
                                }
                            } else {
                                r2(i3, null);
                                r2(-10, sb.toString());
                                this.f12044c0.post(new Runnable() { // from class: u2.J1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f12035a.i2();
                                    }
                                });
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e4) {
                                    iOException = e4;
                                }
                            }
                        } catch (IOException e5) {
                            e = e5;
                            bufferedReader = bufferedReader2;
                            r2(-10, "\n\n\n" + e.getLocalizedMessage());
                            if (bufferedReader == null) {
                                return;
                            }
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e6) {
                                iOException = e6;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader == null) {
                                throw th;
                            }
                            try {
                                bufferedReader.close();
                                throw th;
                            } catch (IOException e7) {
                                e7.printStackTrace();
                                throw th;
                            }
                        }
                        iOException.printStackTrace();
                        return;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e8) {
                e = e8;
            }
        } catch (Exception e9) {
            r2(-10, "\n\n\n" + e9.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(View view) {
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(View view) {
        this.f12058q0 = 0;
        a2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m2(View view) {
        this.f12058q0 = 1;
        a2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n2(int i3, String str) {
        this.f12053l0.setProgress(i3);
        if (str != null) {
            this.f12052k0.setText(str);
            this.f12050i0.setVisibility(4);
            this.f12051j0.setVisibility(0);
        }
        if (i3 == -10) {
            this.f12053l0.setVisibility(8);
        }
    }

    public static L1 o2(Parcelable parcelable) {
        L1 l3 = new L1();
        l3.f12054m0 = parcelable;
        return l3;
    }

    private void p2(View view) {
        int id = view.getId();
        if (id == R.id.btnSelectTxt) {
            d();
        } else if (id == R.id.btnTxtPrint) {
            b();
        }
    }

    private void q2() {
        try {
            Thread.sleep(10L);
        } catch (InterruptedException unused) {
        }
    }

    private void r2(final int i3, final String str) {
        this.f12044c0.post(new Runnable() { // from class: u2.K1
            @Override // java.lang.Runnable
            public final void run() {
                this.f12038a.n2(i3, str);
            }
        });
        q2();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void F0() {
        this.f12052k0.setText("");
        super.F0();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void K0() {
        PrinterEncoding byName;
        super.K0();
        if (this.f12047f0.L() == 2) {
            byName = PrinterEncoding.getByName(this.f12047f0.h(), r1());
        } else if (this.f12047f0.L() == 3) {
            byName = PrinterEncoding.getByLanguageGoojprt(this.f12047f0.K(), r1());
        } else if (this.f12047f0.L() == 10) {
            byName = PrinterEncoding.getByLanguageStar(this.f12047f0.K(), r1());
        } else {
            byName = (this.f12047f0.L() == 5 || this.f12047f0.L() == 9 || this.f12047f0.L() == 8 || this.f12047f0.L() == 7 || this.f12047f0.L() == 6) ? PrinterEncoding.getByName("UTF-8", r1()) : PrinterEncoding.getByLanguage(this.f12047f0.K(), r1());
        }
        String encoding = byName.getEncoding();
        this.f12056o0 = encoding;
        this.f12057p0 = encoding;
        ((RadioButton) this.f12049h0.findViewById(R.id.radioLocalCP)).setText(this.f12056o0);
        this.f12049h0.findViewById(R.id.radioLocalCP).setOnClickListener(new View.OnClickListener() { // from class: u2.E1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12000a.l2(view);
            }
        });
        if (this.f12056o0.equals("UTF-8")) {
            this.f12049h0.findViewById(R.id.radioLocalCP).setVisibility(8);
        }
        this.f12049h0.findViewById(R.id.radioUseUtf).setOnClickListener(new View.OnClickListener() { // from class: u2.F1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12013a.m2(view);
            }
        });
        if (this.f12058q0 == 1) {
            ((RadioButton) this.f12049h0.findViewById(R.id.radioUseUtf)).setChecked(true);
        } else {
            ((RadioButton) this.f12049h0.findViewById(R.id.radioLocalCP)).setChecked(true);
        }
        a2();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void L0(Bundle bundle) {
        super.L0(bundle);
        bundle.putParcelable("parcel", this.f12054m0);
        bundle.putParcelable("attrStr", this.f12060s0);
    }

    @Override // r2.X2
    public void b() {
        try {
            RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
            rawbtPrintJob.setTemplate(this.f12048g0.getTemplate());
            rawbtPrintJob.setPrinter(this.f12048g0.getPrinter());
            rawbtPrintJob.setCopies(this.f12048g0.getCopies());
            rawbtPrintJob.setIdJob(UUID.randomUUID().toString());
            ((MainActivity) r1()).h0(rawbtPrintJob.getIdJob(), rawbtPrintJob.getPrinter());
            if (((RadioButton) this.f12049h0.findViewById(R.id.radioLocalCP)).isChecked()) {
                rawbtPrintJob.println(this.f12052k0.getText().toString(), this.f12060s0);
            } else {
                rawbtPrintJob.text(this.f12054m0, this.f12060s0);
            }
            ((MainActivity) r1()).f11399o.printRawbtPrintJob(rawbtPrintJob.GSON());
        } catch (Exception e3) {
            RawPrinterApp.r(e3.getLocalizedMessage());
        }
    }

    @Override // r2.W2
    public void d() {
        try {
            this.f12055n0.a("*/*");
        } catch (Exception unused) {
            Toast.makeText(m(), R.string.need_external_fm, 1).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (SystemClock.uptimeMillis() - this.f12062u0 < 800) {
            return;
        }
        this.f12062u0 = SystemClock.uptimeMillis();
        p2(view);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void p0(Bundle bundle) {
        super.p0(bundle);
        if (bundle != null) {
            this.f12054m0 = bundle.getParcelable("parcel");
            this.f12060s0 = (AttributesString) bundle.getParcelable("attrStr");
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1(true);
        if (m() == null) {
            return null;
        }
        t2.h hVar = (t2.h) androidx.databinding.f.d(layoutInflater, R.layout.fragment_file, viewGroup, false);
        hVar.A(this.f12060s0);
        View viewP = hVar.p();
        this.f12049h0 = viewP;
        Button button = (Button) viewP.findViewById(R.id.btnTxtPrint);
        Button button2 = (Button) this.f12049h0.findViewById(R.id.btnSelectTxt);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        ((ImageView) this.f12049h0.findViewById(R.id.imageView)).setOnClickListener(new View.OnClickListener() { // from class: u2.D1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11981a.k2(view);
            }
        });
        this.f12050i0 = (ScrollView) this.f12049h0.findViewById(R.id.intro);
        this.f12051j0 = (ScrollView) this.f12049h0.findViewById(R.id.tab_text);
        this.f12052k0 = (TextView) this.f12049h0.findViewById(R.id.view_txt);
        this.f12053l0 = (ProgressBar) this.f12049h0.findViewById(R.id.task_progress_bar);
        ConstraintLayout constraintLayout = (ConstraintLayout) this.f12049h0.findViewById(R.id.bottom_sheet);
        BottomSheetBehavior.q0(constraintLayout).O0((int) ((M().getDisplayMetrics().densityDpi / 160.0f) * 52.0f));
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        layoutParams.height = (int) ((M().getDisplayMetrics().densityDpi / 160.0f) * 320.0f);
        constraintLayout.setLayoutParams(layoutParams);
        this.f12061t0 = (Spinner) this.f12049h0.findViewById(R.id.spinnerFontType);
        f2();
        SeekBar seekBar = (SeekBar) this.f12049h0.findViewById(R.id.seekBarFont);
        this.f12059r0 = seekBar;
        seekBar.setMax(80);
        this.f12059r0.setProgress(this.f12060s0.getTruetypeFontSize() - 16);
        this.f12059r0.setOnSeekBarChangeListener(new a());
        this.f12048g0.setCopies(this.f12047f0.i());
        s2.g.c(r1(), (Spinner) this.f12049h0.findViewById(R.id.spinnerSelectPrinter), this.f12048g0);
        Spinner spinner = (Spinner) this.f12049h0.findViewById(R.id.spinnerSelectTemplate);
        ArrayAdapter arrayAdapter = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, y2.b.S());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setOnItemSelectedListener(new b());
        Spinner spinner2 = (Spinner) this.f12049h0.findViewById(R.id.spinnerNumbersCopies);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, y2.b.H());
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter2);
        spinner2.setSelection(this.f12048g0.getCopies() - 1);
        spinner2.setOnItemSelectedListener(new c());
        Parcelable parcelable = this.f12054m0;
        if (parcelable != null) {
            Z1(parcelable);
        }
        button2.requestFocus();
        return this.f12049h0;
    }

    class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f12063a;

        a() {
            this.f12063a = L1.this.f12060s0.getTruetypeFontSize() - 16;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z3) {
            this.f12063a = i3;
            ((TextView) L1.this.f12049h0.findViewById(R.id.textGraphFontSize)).setText(String.format(L1.this.S(R.string.current_font_size), Integer.valueOf(i3 + 16)));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            L1.this.f12060s0.setTruetypeFontSize(this.f12063a + 16);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
    }

    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            if (i3 == 1) {
                L1.this.f12048g0.setTemplate("none");
            } else {
                L1.this.f12048g0.setTemplate(rawbt.api.RawbtPrintJob.TEMPLATE_DEFAULT);
            }
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
            L1.this.f12048g0.setCopies(i3 + 1);
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
            int truetypeFontSize;
            L1.this.f12060s0.setPrinterFont(i3);
            L1.this.f12059r0.setVisibility(4);
            if (i3 == 2) {
                truetypeFontSize = 17;
            } else if (i3 == 3) {
                truetypeFontSize = 16;
            } else if (i3 != 4) {
                truetypeFontSize = 24;
            } else {
                truetypeFontSize = L1.this.f12060s0.getTruetypeFontSize();
                L1.this.f12059r0.setVisibility(0);
            }
            ((TextView) L1.this.f12049h0.findViewById(R.id.textGraphFontSize)).setText(String.format(L1.this.S(R.string.current_font_size), Integer.valueOf(truetypeFontSize)));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }
}
