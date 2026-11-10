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
import rawbt.api.attributes.AttributesQRcode;
import rawbt.api.command.CommandQRcode;
import rawbt.sdk.RawbtPrintJob;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;
import ru.a402d.rawbtprinter.activity.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public class q1 extends AbstractComponentCallbacksC0337e implements X2 {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private View f12272e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private TextInputLayout f12273f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private TextView f12274g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private ImageView f12275h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private TextView f12276i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    Spinner f12277j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    Spinner f12278k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    Spinner f12279l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    Spinner f12280m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    Spinner f12281n0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    final ExecutorService f12269b0 = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    final Handler f12270c0 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private boolean f12271d0 = false;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f12282o0 = 0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private final y2.b f12283p0 = y2.b.w();

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private AttributesQRcode f12284q0 = new AttributesQRcode();

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private final RawbtPrintJob f12285r0 = new RawbtPrintJob();

    private void e2() {
        if (o2()) {
            return;
        }
        final ProgressDialog progressDialogShow = ProgressDialog.show(r1(), "", S(R.string.generating_wait), true);
        final z2.d dVar = new z2.d(new CommandQRcode(f2(), this.f12284q0));
        this.f12269b0.execute(new Runnable() { // from class: u2.n1
            @Override // java.lang.Runnable
            public final void run() {
                this.f12255a.g2(dVar, progressDialogShow);
            }
        });
    }

    private String f2() {
        String strTrim = this.f12274g0.getText().toString().trim();
        if (this.f12282o0 == 1 && !strTrim.startsWith("http")) {
            strTrim = "http://" + strTrim;
        }
        if (this.f12282o0 == 2) {
            strTrim = "instagram://user?username=" + strTrim;
        }
        if (this.f12282o0 == 4) {
            strTrim = "https://www.paypal.me/" + strTrim;
        }
        if (this.f12282o0 != 3) {
            return strTrim;
        }
        return "whatsapp://send?phone=" + strTrim;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g2(z2.d dVar, ProgressDialog progressDialog) {
        Bitmap bitmapCall = dVar.call();
        try {
            File file = new File(r1().getCacheDir(), "share");
            file.mkdir();
            File file2 = new File(file.getPath(), "qr_code.png");
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmapCall.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Uri uriH = FileProvider.h(r1(), "ru.a402d.rawbtprinter.fileprovider", file2);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uriH);
            intent.setType("image/png");
            L1(intent);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        progressDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h2(View view) {
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2(View view) {
        p2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j2(View view) {
        this.f12284q0.setAlignment(Constant.ALIGNMENT_LEFT);
        p2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(View view) {
        this.f12284q0.setAlignment(Constant.ALIGNMENT_CENTER);
        p2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(View view) {
        this.f12284q0.setAlignment(Constant.ALIGNMENT_RIGHT);
        p2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m2(z2.e.a aVar) {
        d2(aVar.f13154a, aVar.f13155b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n2(z2.e eVar) {
        final z2.e.a aVarCall = eVar.call();
        this.f12270c0.post(new Runnable() { // from class: u2.p1
            @Override // java.lang.Runnable
            public final void run() {
                this.f12264a.m2(aVarCall);
            }
        });
    }

    private boolean o2() {
        if (this.f12274g0.getText().toString().length() >= 1) {
            return false;
        }
        Toast.makeText(r1(), S(R.string.value_is_required), 0).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p2() {
        if (this.f12271d0) {
            return;
        }
        ImageView imageView = this.f12275h0;
        StringBuilder sb = new StringBuilder();
        sb.append("android.resource://");
        Context contextG = RawPrinterApp.g();
        Objects.requireNonNull(contextG);
        sb.append(contextG.getPackageName());
        sb.append("/");
        sb.append(R.drawable.qrlogo);
        imageView.setImageURI(Uri.parse(sb.toString()));
        String strF2 = f2();
        if (strF2.length() == 0) {
            this.f12276i0.setText(R.string.input_value);
            return;
        }
        final z2.e eVar = new z2.e(strF2, this.f12284q0);
        eVar.d(this.f12283p0.o());
        if ((r1().getResources().getConfiguration().uiMode & 48) == 32) {
            eVar.b(-16777216);
            eVar.c(-12303292);
        }
        this.f12269b0.execute(new Runnable() { // from class: u2.o1
            @Override // java.lang.Runnable
            public final void run() {
                this.f12260a.n2(eVar);
            }
        });
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
        e2();
        return true;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void K0() {
        super.K0();
        this.f12271d0 = true;
        try {
            this.f12277j0.setSelection(this.f12282o0);
        } catch (Exception unused) {
        }
        try {
            this.f12278k0.setSelection(this.f12284q0.getMultiply());
        } catch (Exception unused2) {
        }
        this.f12271d0 = false;
        p2();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void L0(Bundle bundle) {
        super.L0(bundle);
        bundle.putInt("typeQR", this.f12282o0);
        bundle.putString("text", this.f12274g0.getText().toString());
        bundle.putParcelable("attrQRcode", this.f12284q0);
    }

    @Override // r2.X2
    public void b() {
        if (o2()) {
            return;
        }
        RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
        rawbtPrintJob.setTemplate(this.f12285r0.getTemplate());
        rawbtPrintJob.setPrinter(this.f12285r0.getPrinter());
        rawbtPrintJob.setCopies(this.f12285r0.getCopies());
        rawbtPrintJob.setIdJob(UUID.randomUUID().toString());
        ((MainActivity) r1()).h0(rawbtPrintJob.getIdJob(), rawbtPrintJob.getPrinter());
        rawbtPrintJob.qrcode(f2(), this.f12284q0);
        try {
            ((MainActivity) r1()).f11399o.printRawbtPrintJob(rawbtPrintJob.GSON());
        } catch (Exception e3) {
            Toast.makeText(r1(), e3.getLocalizedMessage(), 0).show();
        }
    }

    public void d2(Bitmap bitmap, String str) {
        if (bitmap != null) {
            this.f12276i0.setText(f2());
            bitmap.setDensity(this.f12283p0.n());
            this.f12275h0.setImageBitmap(bitmap);
            this.f12272e0.findViewById(R.id.btnQRcodePrint).setVisibility(0);
            return;
        }
        if (str == null) {
            this.f12276i0.setText(R.string.unknown_error);
            return;
        }
        if (str.startsWith("Invalid character")) {
            str = S(R.string.invalid_characters);
        } else if (str.contains("too long")) {
            str = S(R.string.too_long);
        }
        this.f12276i0.setText(str);
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
        View viewInflate = layoutInflater.inflate(R.layout.fragment_qrcode, viewGroup, false);
        this.f12272e0 = viewInflate;
        this.f12273f0 = (TextInputLayout) viewInflate.findViewById(R.id.qrcode_hint);
        this.f12274g0 = (TextView) this.f12272e0.findViewById(R.id.inputArea);
        this.f12275h0 = (ImageView) this.f12272e0.findViewById(R.id.imageQRcode);
        this.f12276i0 = (TextView) this.f12272e0.findViewById(R.id.text_error);
        if (bundle != null) {
            this.f12282o0 = bundle.getInt("typeQR");
            this.f12274g0.setText(bundle.getString("text"));
            this.f12284q0 = (AttributesQRcode) bundle.getParcelable("attrQRcode");
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) this.f12272e0.findViewById(R.id.bottom_sheet);
        BottomSheetBehavior.q0(constraintLayout).O0((int) ((M().getDisplayMetrics().densityDpi / 160.0f) * 52.0f));
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        layoutParams.height = (int) ((M().getDisplayMetrics().densityDpi / 160.0f) * 220.0f);
        constraintLayout.setLayoutParams(layoutParams);
        ((Button) this.f12272e0.findViewById(R.id.btnQRcodePrint)).setOnClickListener(new View.OnClickListener() { // from class: u2.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12211a.h2(view);
            }
        });
        ((Button) this.f12272e0.findViewById(R.id.btnGenerate)).setOnClickListener(new View.OnClickListener() { // from class: u2.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12215a.i2(view);
            }
        });
        this.f12272e0.findViewById(R.id.rbAlignLeft).setOnClickListener(new View.OnClickListener() { // from class: u2.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12245a.j2(view);
            }
        });
        this.f12272e0.findViewById(R.id.rbAlignCenter).setOnClickListener(new View.OnClickListener() { // from class: u2.l1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12248a.k2(view);
            }
        });
        this.f12272e0.findViewById(R.id.rbAlignRight).setOnClickListener(new View.OnClickListener() { // from class: u2.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12252a.l2(view);
            }
        });
        this.f12278k0 = (Spinner) this.f12272e0.findViewById(R.id.spinnerQrSize);
        ArrayAdapter arrayAdapter = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, B2.l.a());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f12278k0.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f12278k0.setOnItemSelectedListener(new a());
        this.f12277j0 = (Spinner) this.f12272e0.findViewById(R.id.spinnerQRcodeType);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, B2.l.b());
        arrayAdapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.f12277j0.setAdapter((SpinnerAdapter) arrayAdapter2);
        this.f12277j0.setOnItemSelectedListener(new b(arrayAdapter2));
        this.f12281n0 = (Spinner) this.f12272e0.findViewById(R.id.spinnerSelectPrinter);
        s2.g.c(r1(), this.f12281n0, this.f12285r0);
        this.f12280m0 = (Spinner) this.f12272e0.findViewById(R.id.spinnerSelectTemplate);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, y2.b.S());
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f12280m0.setAdapter((SpinnerAdapter) arrayAdapter3);
        this.f12280m0.setOnItemSelectedListener(new c());
        this.f12279l0 = (Spinner) this.f12272e0.findViewById(R.id.spinnerNumbersCopies);
        ArrayAdapter arrayAdapter4 = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, y2.b.H());
        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f12279l0.setAdapter((SpinnerAdapter) arrayAdapter4);
        this.f12279l0.setSelection(this.f12285r0.getCopies() - 1);
        this.f12279l0.setOnItemSelectedListener(new d());
        return this.f12272e0;
    }

    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            if (i3 == 0) {
                i3 = 3;
            }
            q1.this.f12284q0.setMultiply(i3);
            q1.this.p2();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class b implements AdapterView.OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayAdapter f12287a;

        b(ArrayAdapter arrayAdapter) {
            this.f12287a = arrayAdapter;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            q1.this.f12273f0.setHint((CharSequence) this.f12287a.getItem(i3));
            q1.this.f12282o0 = i3;
            q1.this.p2();
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
            if (i3 == 1) {
                q1.this.f12285r0.setTemplate("none");
            } else {
                q1.this.f12285r0.setTemplate(rawbt.api.RawbtPrintJob.TEMPLATE_DEFAULT);
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
            q1.this.f12285r0.setCopies(i3 + 1);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }
}
