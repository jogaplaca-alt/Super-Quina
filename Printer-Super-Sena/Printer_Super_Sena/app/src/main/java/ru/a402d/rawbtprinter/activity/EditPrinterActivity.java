package ru.a402d.rawbtprinter.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.InterfaceC0363v;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import rawbt.api.RawbtApiHelper;
import rawbt.api.attributes.AttributesImage;
import rawbt.sdk.AbstractRawBtPrintService;
import rawbt.sdk.ICallback;
import rawbt.sdk.IConsole;
import rawbt.sdk.IRawBtPrintService;
import rawbt.sdk.RawbtPrintJob;
import rawbt.sdk.dao.PrinterEntity;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
public class EditPrinterActivity extends AbstractActivityC0634m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    t2.a f11335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    MenuItem f11336f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Intent f11341k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    TextView f11344n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    TextView f11345o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ProgressBar f11346p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    View f11347q;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11334d = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ICallback f11337g = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final IConsole f11338h = new b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f11339i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f11340j = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    String f11342l = "ahz";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected boolean f11343m = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public IRawBtPrintService f11348r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ServiceConnection f11349s = new c();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    p004b.c f11350t = registerForActivityResult(new p008c.e(), new p004b.b() { // from class: r2.o0
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            this.f11069a.R((p004b.a) obj);
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    p004b.c f11351u = registerForActivityResult(new p008c.e(), new p004b.b() { // from class: r2.p0
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            this.f11075a.S((p004b.a) obj);
        }
    });

    class a extends ICallback.Stub {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void R() {
            EditPrinterActivity.this.f11347q.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void S() {
            EditPrinterActivity.this.f11347q.setVisibility(8);
            EditPrinterActivity editPrinterActivity = EditPrinterActivity.this;
            editPrinterActivity.startActivity(editPrinterActivity.f11341k);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void T() {
            EditPrinterActivity.this.f11347q.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void U(float f3) {
            EditPrinterActivity.this.f11346p.setVisibility(0);
            EditPrinterActivity.this.f11346p.setProgress((int) (f3 * 100.0f));
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintCancel(String str) {
            EditPrinterActivity editPrinterActivity = EditPrinterActivity.this;
            editPrinterActivity.f11343m = false;
            if (editPrinterActivity.f11342l.equals(str)) {
                EditPrinterActivity.this.f11570b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11574a.R();
                    }
                });
            }
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintError(String str, String str2) {
            EditPrinterActivity editPrinterActivity = EditPrinterActivity.this;
            editPrinterActivity.f11343m = false;
            if (editPrinterActivity.f11342l.equals(str)) {
                EditPrinterActivity.this.f11341k.setFlags(269025280);
                EditPrinterActivity.this.f11341k.putExtra("android.intent.extra.SUBJECT", str2);
                EditPrinterActivity.this.f11570b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11573a.S();
                    }
                });
            }
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintSuccess(String str) {
            EditPrinterActivity editPrinterActivity = EditPrinterActivity.this;
            editPrinterActivity.f11343m = false;
            if (editPrinterActivity.f11342l.equals(str)) {
                EditPrinterActivity.this.f11570b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11572a.T();
                    }
                });
            }
        }

        @Override // rawbt.sdk.ICallback
        public void onProgress(String str, final float f3) {
            if (EditPrinterActivity.this.f11342l.equals(str)) {
                EditPrinterActivity.this.f11570b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11575a.U(f3);
                    }
                });
            }
        }
    }

    class b extends IConsole.Stub {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void R() {
            EditPrinterActivity editPrinterActivity = EditPrinterActivity.this;
            editPrinterActivity.f11345o.setText(String.format(Locale.US, "Sent: %s / Received: %s", Long.valueOf(editPrinterActivity.f11339i), Long.valueOf(EditPrinterActivity.this.f11340j)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void S() {
            EditPrinterActivity editPrinterActivity = EditPrinterActivity.this;
            editPrinterActivity.f11345o.setText(String.format(Locale.US, "Sent: %s / Received: %s", Long.valueOf(editPrinterActivity.f11339i), Long.valueOf(EditPrinterActivity.this.f11340j)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void T(String str) {
            EditPrinterActivity.this.f11344n.setText(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void U() {
            EditPrinterActivity.this.f11344n.setText(R.string.connected);
        }

        @Override // rawbt.sdk.IConsole
        public void onDeviceReceived(byte[] bArr) {
            EditPrinterActivity editPrinterActivity = EditPrinterActivity.this;
            editPrinterActivity.f11340j += (long) bArr.length;
            editPrinterActivity.f11570b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11578a.R();
                }
            });
        }

        @Override // rawbt.sdk.IConsole
        public void onDeviceSent(byte[] bArr) {
            EditPrinterActivity editPrinterActivity = EditPrinterActivity.this;
            editPrinterActivity.f11339i += (long) bArr.length;
            editPrinterActivity.f11570b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.r
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11577a.S();
                }
            });
        }

        @Override // rawbt.sdk.IConsole
        public void onError(String str) {
        }

        @Override // rawbt.sdk.IConsole
        public void onNotify(final String str) {
            EditPrinterActivity.this.f11570b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11579a.T(str);
                }
            });
        }

        @Override // rawbt.sdk.IConsole
        public void onPrinterConnect() {
            EditPrinterActivity.this.f11570b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11581a.U();
                }
            });
        }

        @Override // rawbt.sdk.IConsole
        public void onPrinterDisconnect() {
            EditPrinterActivity.this.f11344n.setText(R.string.printer_not_connected);
        }
    }

    class c implements ServiceConnection {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            EditPrinterActivity.this.f11344n.setText(str);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            EditPrinterActivity.this.f11348r = IRawBtPrintService.Stub.asInterface(iBinder);
            try {
                EditPrinterActivity editPrinterActivity = EditPrinterActivity.this;
                editPrinterActivity.f11348r.registerCallback(editPrinterActivity.f11337g);
                EditPrinterActivity editPrinterActivity2 = EditPrinterActivity.this;
                editPrinterActivity2.f11348r.registerConsole(editPrinterActivity2.f11338h);
            } catch (Exception e3) {
                final String localizedMessage = e3.getLocalizedMessage();
                EditPrinterActivity.this.f11570b.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11582a.b(localizedMessage);
                    }
                });
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            EditPrinterActivity.this.f11348r = null;
        }
    }

    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(EditPrinterActivity.this.getResources().getColor(R.color.colorAccent));
                EditPrinterActivity.this.f11571c.Q0((String) B2.b.f90a.get(i3));
            } catch (Exception unused) {
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    private void M() {
        final PrinterEntity printerEntity = (PrinterEntity) this.f11571c.P().e();
        this.f11569a.execute(new Runnable() { // from class: r2.m0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11055a.Q(printerEntity);
            }
        });
    }

    private void N() {
        PrinterEntity printerEntity;
        try {
            if (Build.VERSION.SDK_INT >= 26 && (printerEntity = (PrinterEntity) this.f11571c.P().e()) != null) {
                if (printerEntity.getProtocol() == 1 || printerEntity.getProtocol() == 6) {
                    rawbt.sdk.btpair.h.a(getSystemService(rawbt.sdk.btpair.f.a())).disassociate(printerEntity.getMac());
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x002b  */
    private void O() {
        Intent intent;
        PrinterEntity printerEntity = (PrinterEntity) this.f11571c.P().e();
        if (printerEntity.getProtocol() == 4) {
            intent = new Intent(this, (Class<?>) ProfileMinimalActivity.class);
        } else {
            String profileClass = printerEntity.getProfileClass();
            profileClass.hashCode();
            switch (profileClass) {
                case "cpcl_general":
                case "epl_general":
                case "zpl_general":
                case "tspl_general":
                    intent = new Intent(this, (Class<?>) ProfileZplActivity.class);
                    break;
                case "cat_printer":
                    intent = new Intent(this, (Class<?>) ProfileCatActivity.class);
                    break;
                case "paperang2":
                case "paperang":
                    intent = new Intent(this, (Class<?>) ProfilePaperangActivity.class);
                    break;
                case "peripage":
                    intent = new Intent(this, (Class<?>) ProfilePeripageActivity.class);
                    break;
                case "esc_general":
                case "esc_gs_v_0":
                    intent = new Intent(this, (Class<?>) ProfileEscActivity.class);
                    break;
                case "dothan_printer":
                    intent = new Intent(this, (Class<?>) ProfileMediumActivity.class);
                    break;
                default:
                    RawPrinterApp.r("Unknown driver");
                    return;
            }
        }
        intent.putExtra("id", this.f11334d);
        this.f11350t.a(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(Bitmap bitmap) {
        this.f11335e.f11770p.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(PrinterEntity printerEntity) {
        final Bitmap bitmapJ0 = j0(printerEntity);
        this.f11570b.post(new Runnable() { // from class: r2.n0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11062a.P(bitmapJ0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(p004b.a aVar) {
        this.f11571c.v0(this.f11334d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(p004b.a aVar) {
        Intent intentC;
        Bundle extras;
        if (aVar.d() != -1 || (intentC = aVar.c()) == null || (extras = intentC.getExtras()) == null) {
            return;
        }
        k0(extras.getInt("dots"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(CompoundButton compoundButton, boolean z3) {
        this.f11571c.x0(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(View view) {
        this.f11571c.G0(203);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view) {
        this.f11571c.G0(304);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        h0("***** Short Test *****\nABCDEFGHIJKLMNOPRSTUVWXYZ\n0123456789~!@#$%^&*`{}=|№\n" + B2.b.b(((PrinterEntity) this.f11571c.P().e()).getPrintLanguage()) + "\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(View view) {
        h0("***** Test codepage *****\nABCDEFGHIJKLMNOPRSTUVWXYZ\n0123456789~!@#$%^&*`{}=|№\n" + B2.b.b(((PrinterEntity) this.f11571c.P().e()).getPrintLanguage()) + "\n" + B2.b.b(((PrinterEntity) this.f11571c.P().e()).getPrintLanguage()).toUpperCase() + "\n" + B2.b.b(((PrinterEntity) this.f11571c.P().e()).getPrintLanguage()).toLowerCase() + "\n---------------------------\nGRAVE:\nà, è, ì, ò, ù, À, È, Ì, Ò, Ù \nACUTE:\ná, é, í, ó, ú, ý, Á, É, Í, Ó, Ú, Ý\nCARET or CIRCUMFLEX:\nâ, ê, î, ô, û, ð, Â, Ê, Î, Ô, Û, Ð\nTILDE:\nã, ñ, õ, Ã, Ñ, Õ\nUMLAUT or DIAERESIS:\nä, ë, ï, ö, ü, ÿ, Ä, Ë, Ï, Ö, Ü, Ÿ\nANGSTROM:\nå, Å\nLIGATURES:\næ, œ, Æ, Œ or ß\nCARON - CEDILLA:\nç, Ç\nPUNCTUATION:\n¿ , ¡ \n---------------------------\nInternational characters\n#$@[\\]^{|}~\n---------------------------\n\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(Intent intent, View view) {
        intent.putExtra("id", ((PrinterEntity) this.f11571c.P().e()).getId());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(View view) {
        this.f11344n.setText(R.string.wait);
        if (!this.f11343m) {
            this.f11347q.setVisibility(8);
            return;
        }
        Intent intent = new Intent();
        intent.setAction(AbstractRawBtPrintService.ACTION_CANCEL);
        sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(CompoundButton compoundButton, boolean z3) {
        if (z3) {
            this.f11571c.y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(View view) {
        try {
            k0(Integer.parseInt(this.f11335e.f11764j.getText().toString()));
        } catch (Exception e3) {
            Toast.makeText(this, getString(R.string.wrong_input), 0).show();
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(RawbtPrintJob rawbtPrintJob) {
        try {
            Bitmap bitmapJ0 = j0((PrinterEntity) this.f11571c.P().e());
            if (bitmapJ0 != null) {
                Context contextG = RawPrinterApp.g();
                Objects.requireNonNull(contextG);
                File file = new File(contextG.getCacheDir().toString(), "/test.png");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmapJ0.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                bitmapJ0.recycle();
                rawbtPrintJob.image(Uri.fromFile(file), new AttributesImage());
                rawbtPrintJob.ln(((PrinterEntity) this.f11571c.P().e()).getSkipLinesAfterJob());
                this.f11348r.printRawbtPrintJob(rawbtPrintJob.GSON());
            }
        } catch (Exception | OutOfMemoryError e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(View view) {
        final RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
        rawbtPrintJob.setIdJob(UUID.randomUUID().toString());
        l0(rawbtPrintJob.getIdJob());
        rawbtPrintJob.setPrinter(((PrinterEntity) this.f11571c.P().e()).getName());
        rawbtPrintJob.setCopies(1);
        rawbtPrintJob.setTemplate("none");
        AsyncTask.execute(new Runnable() { // from class: r2.l0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11050a.d0(rawbtPrintJob);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(Intent intent, View view) {
        intent.putExtra("printer", (Parcelable) this.f11571c.P().e());
        this.f11351u.a(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(View view) {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", "file:///android_asset/tpm.html");
        intent.setType("text/html");
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(PrinterEntity printerEntity) {
        if (printerEntity == null) {
            finish();
            return;
        }
        this.f11334d = printerEntity.getId();
        this.f11335e.f11778x.setText(printerEntity.getConnecting());
        this.f11335e.f11751C.setText(printerEntity.getDescription());
        this.f11335e.f11752D.setText(printerEntity.getName());
        this.f11335e.f11773s.setChecked(printerEntity.isCurrent());
        this.f11335e.f11773s.setEnabled(!printerEntity.isCurrent());
        this.f11335e.f11780z.setText(printerEntity.getProfileClass());
        if ("raw_transfer".equals(printerEntity.getProfileClass())) {
            this.f11335e.f11779y.setVisibility(8);
            this.f11335e.f11759e.setVisibility(8);
            this.f11335e.f11754F.setVisibility(8);
            this.f11335e.f11762h.setVisibility(8);
            this.f11335e.f11758d.setVisibility(8);
            this.f11335e.f11750B.setVisibility(8);
            this.f11335e.f11772r.setVisibility(8);
            this.f11335e.f11761g.setVisibility(8);
            this.f11335e.f11753E.setVisibility(8);
            this.f11335e.f11760f.setVisibility(8);
            this.f11335e.f11777w.setVisibility(8);
            this.f11335e.f11757c.setVisibility(0);
            return;
        }
        M();
        if (printerEntity.getDensity() == 304) {
            this.f11335e.f11768n.setChecked(true);
        } else {
            this.f11335e.f11767m.setChecked(true);
        }
        this.f11335e.f11776v.setVisibility(printerEntity.getId() > 2 ? 0 : 8);
        this.f11335e.f11769o.setVisibility(printerEntity.getId() > 2 ? 0 : 8);
        this.f11335e.f11779y.setVisibility(printerEntity.getId() < 3 ? 0 : 8);
        this.f11335e.f11765k.setVisibility(printerEntity.getId() > 2 ? 0 : 8);
        this.f11335e.f11760f.setVisibility(printerEntity.getId() < 2 ? 0 : 8);
        this.f11335e.f11777w.setVisibility(printerEntity.getId() < 3 ? 0 : 8);
        this.f11335e.f11757c.setVisibility(printerEntity.getId() <= 2 ? 8 : 0);
        this.f11335e.f11772r.setSelection(B2.b.f90a.indexOf(printerEntity.getPrintLanguage()));
        this.f11335e.f11764j.setText("" + printerEntity.getDots_per_line());
        this.f11335e.f11763i.setChecked(printerEntity.isAddFrame());
    }

    static Bitmap j0(PrinterEntity printerEntity) {
        int i3;
        int i4;
        int dots_per_line = printerEntity.getDots_per_line();
        int i5 = printerEntity.getDensity() == 304 ? 12 : 8;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dots_per_line, 120, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.setDensity(72);
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(14.0f);
        paint.setColor(-16777216);
        paint.setAntiAlias(false);
        paint.setSubpixelText(false);
        paint.setDither(false);
        float f3 = dots_per_line - 1;
        canvas.drawLine(0.0f, 0.0f, f3, 0.0f, paint);
        float f4 = 119;
        canvas.drawLine(0.0f, f4, f3, f4, paint);
        canvas.drawLine(0.0f, 0.0f, 0.0f, f4, paint);
        canvas.drawLine(f3, 0.0f, f3, f4, paint);
        int i6 = i5;
        while (true) {
            i3 = 108;
            if (i6 >= dots_per_line) {
                break;
            }
            float f5 = i6 - 1;
            canvas.drawLine(f5, 108, f5, f4, paint);
            i6 += i5;
        }
        int i7 = i5 * 5;
        int i8 = i7;
        while (true) {
            i4 = 96;
            if (i8 >= dots_per_line) {
                break;
            }
            float f6 = i8 - 1;
            canvas.drawLine(f6, 96, f6, i3, paint);
            i8 += i7;
            i3 = 108;
        }
        int i9 = i5 * 10;
        int i10 = i9;
        int i11 = 10;
        while (i10 < dots_per_line) {
            float f7 = i10 - 1;
            float f8 = i4;
            int i12 = i11;
            canvas.drawLine(f7, 84, f7, f8, paint);
            canvas.drawText("" + i12, i10 - 20, f8, paint);
            i11 = i12 + 10;
            i10 += i9;
            i4 = 96;
        }
        canvas.drawText("mm", 8.0f, 88, paint);
        int density = printerEntity.getDensity();
        int i13 = 1;
        for (int i14 = density; i14 < dots_per_line; i14 += density) {
            float f9 = i14 - 1;
            int i15 = i13;
            canvas.drawLine(f9, 0.0f, f9, 47, paint);
            canvas.drawText("" + i15, i14 - 16, 40, paint);
            i13 = i15 + 1;
        }
        for (int i16 = 0; i16 < dots_per_line; i16 += density) {
            float f10 = ((density / 2) + i16) - 1;
            canvas.drawLine(f10, 0.0f, f10, 36.0f, paint);
            float f11 = ((density / 4) + i16) - 1;
            canvas.drawLine(f11, 0.0f, f11, 24.0f, paint);
            float f12 = (((density * 3) / 4) + i16) - 1;
            canvas.drawLine(f12, 0.0f, f12, 24.0f, paint);
        }
        canvas.drawText("inches", 8.0f, 40.0f, paint);
        float f13 = 62;
        canvas.drawLine(200.0f, f13, f3, f13, paint);
        for (int i17 = 200; i17 < dots_per_line; i17 += 10) {
            float f14 = i17 - 1;
            canvas.drawLine(f14, f13, f14, 56, paint);
        }
        for (int i18 = 200; i18 < dots_per_line; i18 += 50) {
            float f15 = i18 - 1;
            canvas.drawLine(f15, 62, f15, 52, paint);
        }
        for (int i19 = 200; i19 < dots_per_line; i19 += 100) {
            float f16 = i19 - 1;
            canvas.drawLine(f16, 72, f16, 52, paint);
        }
        canvas.drawText("200", 170.0f, 68.0f, paint);
        return bitmapCreateBitmap;
    }

    private void k0(int i3) {
        boolean z3;
        if (i3 < 200) {
            Toast.makeText(this, "min 200", 0).show();
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3 && i3 > 2000) {
            Toast.makeText(this, "max 2000", 0).show();
            z3 = false;
        }
        int i4 = ((PrinterEntity) this.f11571c.P().e()).getDensity() == 304 ? 12 : 8;
        int i5 = i3 % i4;
        if (z3 && i5 != 0) {
            Toast.makeText(this, "not a multiple of " + i4, 0).show();
            z3 = false;
        }
        if (z3) {
            this.f11571c.I0(i3);
            Toast.makeText(this, R.string.Saved, 0).show();
            RawPrinterApp.k(this.f11335e.f11764j, this);
        }
    }

    public void h0(String str) {
        try {
            PrinterEntity printerEntity = (PrinterEntity) this.f11571c.P().e();
            RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
            rawbtPrintJob.setIdJob(UUID.randomUUID().toString());
            l0(rawbtPrintJob.getIdJob());
            rawbtPrintJob.setPrinter(printerEntity.getName());
            rawbtPrintJob.setTemplate(rawbt.api.RawbtPrintJob.TEMPLATE_SIMPLE);
            rawbtPrintJob.setCopies(1);
            rawbtPrintJob.println(str, printerEntity.getAttributesString());
            this.f11348r.printRawbtPrintJob(rawbtPrintJob.GSON());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void l0(String str) {
        this.f11343m = true;
        this.f11342l = str;
        this.f11340j = 0L;
        this.f11339i = 0L;
        this.f11346p.setProgress(0);
        this.f11345o.setText(String.format(Locale.US, "Sent: %s / Received: %s", Long.valueOf(this.f11339i), Long.valueOf(this.f11340j)));
        this.f11347q.setVisibility(0);
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0634m, androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        t2.a aVarC = t2.a.c(getLayoutInflater());
        this.f11335e = aVarC;
        setContentView(aVarC.b());
        this.f11341k = new Intent(this, (Class<?>) ErrorActivity.class);
        this.f11344n = (TextView) findViewById(R.id.txtProgress);
        this.f11346p = (ProgressBar) findViewById(R.id.progressPercent);
        this.f11345o = (TextView) findViewById(R.id.txtStat);
        this.f11347q = findViewById(R.id.panel_progress);
        findViewById(R.id.btnProgressClose).setOnClickListener(new View.OnClickListener() { // from class: r2.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11079a.Z(view);
            }
        });
        if (this.f11348r == null) {
            bindService(RawbtApiHelper.createExplicitIntent(), this.f11349s, 1);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().s(true);
            getSupportActionBar().t(true);
        }
        this.f11335e.f11773s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: r2.v0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                this.f11105a.a0(compoundButton, z3);
            }
        });
        this.f11335e.f11765k.setOnClickListener(new View.OnClickListener() { // from class: r2.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11014a.b0(view);
            }
        });
        this.f11571c.P().g(this, new InterfaceC0363v() { // from class: r2.e0
            @Override // androidx.lifecycle.InterfaceC0363v
            public final void a(Object obj) {
                this.f11018a.i0((PrinterEntity) obj);
            }
        });
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this, R.array.LanguageName, android.R.layout.simple_spinner_item);
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11335e.f11772r.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
        this.f11335e.f11772r.setOnItemSelectedListener(new d());
        this.f11335e.f11771q.setOnClickListener(new View.OnClickListener() { // from class: r2.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11022a.c0(view);
            }
        });
        findViewById(R.id.btnPrintRuler).setOnClickListener(new View.OnClickListener() { // from class: r2.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11026a.e0(view);
            }
        });
        final Intent intent = new Intent(this, (Class<?>) CalcDotsActivity.class);
        this.f11335e.f11756b.setOnClickListener(new View.OnClickListener() { // from class: r2.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11030a.f0(intent, view);
            }
        });
        this.f11335e.f11766l.setOnClickListener(new View.OnClickListener() { // from class: r2.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11036a.g0(view);
            }
        });
        this.f11335e.f11763i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: r2.j0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                this.f11040a.T(compoundButton, z3);
            }
        });
        this.f11335e.f11767m.setOnClickListener(new View.OnClickListener() { // from class: r2.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11045a.U(view);
            }
        });
        this.f11335e.f11768n.setOnClickListener(new View.OnClickListener() { // from class: r2.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11083a.V(view);
            }
        });
        this.f11335e.f11779y.setText(getResources().getText(R.string._203dpi));
        findViewById(R.id.textDemoPrintSimple).setOnClickListener(new View.OnClickListener() { // from class: r2.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11088a.W(view);
            }
        });
        findViewById(R.id.textDemoPrint).setOnClickListener(new View.OnClickListener() { // from class: r2.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11093a.X(view);
            }
        });
        final Intent intent2 = new Intent(this, (Class<?>) DebugActivity.class);
        this.f11335e.f11757c.setOnClickListener(new View.OnClickListener() { // from class: r2.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11100a.Y(intent2, view);
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.printer, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.printerDelete);
        this.f11336f = menuItemFindItem;
        menuItemFindItem.setVisible(this.f11334d > 2);
        return true;
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onDestroy() {
        if (this.f11348r != null) {
            unbindService(this.f11349s);
        }
        super.onDestroy();
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0634m, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.printerDelete) {
            N();
            this.f11571c.J();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
