package u2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import r2.X2;
import rawbt.api.Constant;
import rawbt.api.attributes.AttributesBarcode;
import rawbt.sdk.RawbtPrintJob;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;
import ru.a402d.rawbtprinter.activity.MainActivity;

/* JADX INFO: renamed from: u2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0667k extends AbstractComponentCallbacksC0337e implements X2 {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private View f12219e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private TextInputLayout f12220f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private TextView f12221g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private ImageView f12222h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private TextView f12223i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    Spinner f12224j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    Spinner f12225k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    Spinner f12226l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    Spinner f12227m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    Spinner f12228n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    Spinner f12229o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    Spinner f12230p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    Spinner f12231q0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    final ExecutorService f12216b0 = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    final Handler f12217c0 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private boolean f12218d0 = false;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private final y2.b f12232r0 = y2.b.w();

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private AttributesBarcode f12233s0 = new AttributesBarcode().setType(Constant.BARCODE_UPC_A);

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private final RawbtPrintJob f12234t0 = new RawbtPrintJob();

    /* JADX INFO: Access modifiers changed from: private */
    public void f2() {
        if (this.f12218d0) {
            return;
        }
        ImageView imageView = this.f12222h0;
        StringBuilder sb = new StringBuilder();
        sb.append("android.resource://");
        Context contextG = RawPrinterApp.g();
        Objects.requireNonNull(contextG);
        sb.append(contextG.getPackageName());
        sb.append("/");
        sb.append(R.drawable.navlogo);
        imageView.setImageURI(Uri.parse(sb.toString()));
        String strTrim = this.f12221g0.getText().toString().trim();
        if (strTrim.length() == 0) {
            this.f12223i0.setText(R.string.input_barcode_value);
            return;
        }
        final z2.b bVar = new z2.b(strTrim, this.f12233s0, t());
        bVar.d(this.f12232r0.o());
        if ((r1().getResources().getConfiguration().uiMode & 48) == 32) {
            bVar.b(-16777216);
            bVar.c(-12303292);
        }
        this.f12216b0.execute(new Runnable() { // from class: u2.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f12194a.i2(bVar);
            }
        });
    }

    private void g2() {
        if (r2()) {
            return;
        }
        final ProgressDialog progressDialogShow = ProgressDialog.show(r1(), "", S(R.string.generating_wait), true);
        final z2.a aVar = new z2.a(this.f12221g0.getText().toString().trim(), this.f12233s0);
        this.f12216b0.execute(new Runnable() { // from class: u2.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f12137a.l2(aVar, progressDialogShow);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h2(z2.b.a aVar) {
        e2(aVar.f13141a, aVar.f13142b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2(z2.b bVar) {
        final z2.b.a aVarCall = bVar.call();
        this.f12217c0.post(new Runnable() { // from class: u2.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f12199a.h2(aVarCall);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j2() {
        Toast.makeText(r1(), S(R.string.wrong_input), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(String str) {
        Toast.makeText(r1(), str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(z2.a aVar, ProgressDialog progressDialog) {
        try {
            Bitmap bitmapCall = aVar.call();
            if (bitmapCall == null) {
                progressDialog.dismiss();
                this.f12217c0.post(new Runnable() { // from class: u2.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12209a.j2();
                    }
                });
                return;
            }
            File file = new File(r1().getCacheDir(), "share");
            file.mkdir();
            File file2 = new File(file.getPath(), "barcode.png");
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmapCall.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Uri uriH = FileProvider.h(r1(), "ru.a402d.rawbtprinter.fileprovider", file2);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uriH);
            intent.setType("image/png");
            L1(intent);
            progressDialog.dismiss();
        } catch (Exception e3) {
            e3.printStackTrace();
            final String localizedMessage = e3.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = e3.getClass().getSimpleName();
            }
            this.f12217c0.post(new Runnable() { // from class: u2.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12212a.k2(localizedMessage);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m2(View view) {
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n2(View view) {
        f2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o2(View view) {
        this.f12233s0.setAlignment(Constant.ALIGNMENT_LEFT);
        f2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p2(View view) {
        this.f12233s0.setAlignment(Constant.ALIGNMENT_CENTER);
        f2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q2(View view) {
        this.f12233s0.setAlignment(Constant.ALIGNMENT_RIGHT);
        f2();
    }

    private boolean r2() {
        if (this.f12233s0.getType() == null) {
            Toast.makeText(r1(), S(R.string.type_is_required), 0).show();
            return true;
        }
        if (this.f12221g0.getText().toString().length() >= 1) {
            return false;
        }
        Toast.makeText(r1(), S(R.string.value_is_required), 0).show();
        return true;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public boolean D0(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_print) {
            b();
            return true;
        }
        if (itemId != R.id.action_share) {
            return super.D0(menuItem);
        }
        g2();
        return true;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void K0() {
        super.K0();
        this.f12218d0 = true;
        this.f12226l0.setSelection(this.f12233s0.getFont() - 1);
        this.f12225k0.setSelection(this.f12233s0.getWidth());
        if (this.f12233s0.getHeight() == 162) {
            this.f12224j0.setSelection(0);
        } else {
            this.f12224j0.setSelection(this.f12233s0.getHeight() / 12);
        }
        try {
            Spinner spinner = this.f12227m0;
            Integer num = (Integer) B2.a.f89b.get(this.f12233s0.getType());
            Objects.requireNonNull(num);
            spinner.setSelection(num.intValue());
            Spinner spinner2 = this.f12228n0;
            Integer num2 = (Integer) B2.a.f88a.get(this.f12233s0.getHri());
            Objects.requireNonNull(num2);
            spinner2.setSelection(num2.intValue());
        } catch (Exception unused) {
        }
        this.f12218d0 = false;
        f2();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void L0(Bundle bundle) {
        super.L0(bundle);
        bundle.putString("text", this.f12221g0.getText().toString());
        bundle.putParcelable("attrBarcode", this.f12233s0);
    }

    @Override // r2.X2
    public void b() {
        if (r2()) {
            return;
        }
        RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
        rawbtPrintJob.setTemplate(this.f12234t0.getTemplate());
        rawbtPrintJob.setPrinter(this.f12234t0.getPrinter());
        rawbtPrintJob.setCopies(this.f12234t0.getCopies());
        rawbtPrintJob.setIdJob(UUID.randomUUID().toString());
        ((MainActivity) r1()).h0(rawbtPrintJob.getIdJob(), rawbtPrintJob.getPrinter());
        rawbtPrintJob.barcode(this.f12221g0.getText().toString().trim(), this.f12233s0);
        try {
            ((MainActivity) r1()).f11399o.printRawbtPrintJob(rawbtPrintJob.GSON());
        } catch (Exception e3) {
            String localizedMessage = e3.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = e3.getClass().getSimpleName();
            }
            Toast.makeText(r1(), localizedMessage, 0).show();
        }
    }

    public void e2(Bitmap bitmap, String str) {
        if (bitmap != null) {
            this.f12223i0.setText("");
            bitmap.setDensity(this.f12232r0.n());
            this.f12222h0.setImageBitmap(bitmap);
            this.f12219e0.findViewById(R.id.btnBarcodePrint).setVisibility(0);
            return;
        }
        if (str == null) {
            this.f12223i0.setText(R.string.unknown_error);
            return;
        }
        if (str.startsWith("Invalid character")) {
            str = S(R.string.invalid_characters);
        } else if (str.contains("too long")) {
            str = S(R.string.too_long);
        }
        this.f12223i0.setText(str);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void s0(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.barcode, menu);
        super.s0(menu, menuInflater);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1(true);
        if (m() == null) {
            return null;
        }
        View viewInflate = layoutInflater.inflate(R.layout.fragment_barcode, viewGroup, false);
        this.f12219e0 = viewInflate;
        this.f12220f0 = (TextInputLayout) viewInflate.findViewById(R.id.barcode_hint);
        this.f12221g0 = (TextView) this.f12219e0.findViewById(R.id.inputArea);
        this.f12222h0 = (ImageView) this.f12219e0.findViewById(R.id.imageBarcode);
        this.f12223i0 = (TextView) this.f12219e0.findViewById(R.id.text_error);
        if (bundle != null) {
            this.f12221g0.setText(bundle.getString("text"));
            this.f12233s0 = (AttributesBarcode) bundle.getParcelable("attrBarcode");
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) this.f12219e0.findViewById(R.id.bottom_sheet);
        BottomSheetBehavior.q0(constraintLayout).O0((int) ((M().getDisplayMetrics().densityDpi / 160.0f) * 52.0f));
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        layoutParams.height = (int) ((M().getDisplayMetrics().densityDpi / 160.0f) * 280.0f);
        constraintLayout.setLayoutParams(layoutParams);
        ((Button) this.f12219e0.findViewById(R.id.btnBarcodePrint)).setOnClickListener(new View.OnClickListener() { // from class: u2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12147a.m2(view);
            }
        });
        ((Button) this.f12219e0.findViewById(R.id.btnGenerate)).setOnClickListener(new View.OnClickListener() { // from class: u2.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12150a.n2(view);
            }
        });
        this.f12219e0.findViewById(R.id.rbAlignLeft).setOnClickListener(new View.OnClickListener() { // from class: u2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12154a.o2(view);
            }
        });
        this.f12219e0.findViewById(R.id.rbAlignCenter).setOnClickListener(new View.OnClickListener() { // from class: u2.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12158a.p2(view);
            }
        });
        this.f12219e0.findViewById(R.id.rbAlignRight).setOnClickListener(new View.OnClickListener() { // from class: u2.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12190a.q2(view);
            }
        });
        this.f12224j0 = (Spinner) this.f12219e0.findViewById(R.id.spinnerBarcodeHeight);
        ArrayAdapter arrayAdapter = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, B2.a.b());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f12224j0.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f12224j0.setOnItemSelectedListener(new a());
        this.f12225k0 = (Spinner) this.f12219e0.findViewById(R.id.spinnerBarcodeWidth);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, B2.a.e());
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f12225k0.setAdapter((SpinnerAdapter) arrayAdapter2);
        this.f12225k0.setOnItemSelectedListener(new b());
        this.f12226l0 = (Spinner) this.f12219e0.findViewById(R.id.spinnerBarcodeFont);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, B2.a.a());
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f12226l0.setAdapter((SpinnerAdapter) arrayAdapter3);
        this.f12226l0.setOnItemSelectedListener(new c());
        this.f12227m0 = (Spinner) this.f12219e0.findViewById(R.id.spinnerBarcodeType);
        ArrayAdapter arrayAdapter4 = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, B2.a.d());
        arrayAdapter4.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.f12227m0.setAdapter((SpinnerAdapter) arrayAdapter4);
        this.f12227m0.setOnItemSelectedListener(new d(arrayAdapter4));
        this.f12228n0 = (Spinner) this.f12219e0.findViewById(R.id.spinnerBarcodeHri);
        ArrayAdapter arrayAdapter5 = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, B2.a.c());
        arrayAdapter5.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.f12228n0.setAdapter((SpinnerAdapter) arrayAdapter5);
        this.f12228n0.setOnItemSelectedListener(new e(arrayAdapter5));
        this.f12231q0 = (Spinner) this.f12219e0.findViewById(R.id.spinnerSelectPrinter);
        s2.g.c(r1(), this.f12231q0, this.f12234t0);
        this.f12230p0 = (Spinner) this.f12219e0.findViewById(R.id.spinnerSelectTemplate);
        ArrayAdapter arrayAdapter6 = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, y2.b.S());
        arrayAdapter6.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f12230p0.setAdapter((SpinnerAdapter) arrayAdapter6);
        this.f12230p0.setOnItemSelectedListener(new f());
        this.f12229o0 = (Spinner) this.f12219e0.findViewById(R.id.spinnerNumbersCopies);
        ArrayAdapter arrayAdapter7 = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, y2.b.H());
        arrayAdapter7.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f12229o0.setAdapter((SpinnerAdapter) arrayAdapter7);
        this.f12229o0.setSelection(this.f12234t0.getCopies() - 1);
        this.f12229o0.setOnItemSelectedListener(new g());
        return this.f12219e0;
    }

    /* JADX INFO: renamed from: u2.k$a */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            int i4 = i3 * 12;
            if (i4 == 0) {
                i4 = 162;
            }
            C0667k.this.f12233s0.setHeight(i4);
            C0667k.this.f2();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: renamed from: u2.k$b */
    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            if (i3 == 0) {
                i3 = 3;
            }
            C0667k.this.f12233s0.setWidth(i3);
            C0667k.this.f2();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: renamed from: u2.k$c */
    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            C0667k.this.f12233s0.setFont(i3 + 1);
            C0667k.this.f2();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: renamed from: u2.k$d */
    class d implements AdapterView.OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayAdapter f12238a;

        d(ArrayAdapter arrayAdapter) {
            this.f12238a = arrayAdapter;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            C0667k.this.f12233s0.setType((String) this.f12238a.getItem(i3));
            C0667k.this.f12220f0.setHint((CharSequence) this.f12238a.getItem(i3));
            C0667k.this.f2();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: renamed from: u2.k$e */
    class e implements AdapterView.OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayAdapter f12240a;

        e(ArrayAdapter arrayAdapter) {
            this.f12240a = arrayAdapter;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            C0667k.this.f12233s0.setHri((String) this.f12240a.getItem(i3));
            C0667k.this.f2();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: renamed from: u2.k$f */
    class f implements AdapterView.OnItemSelectedListener {
        f() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            if (i3 == 1) {
                C0667k.this.f12234t0.setTemplate("none");
            } else {
                C0667k.this.f12234t0.setTemplate(rawbt.api.RawbtPrintJob.TEMPLATE_DEFAULT);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: renamed from: u2.k$g */
    class g implements AdapterView.OnItemSelectedListener {
        g() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            C0667k.this.f12234t0.setCopies(i3 + 1);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }
}
