package ru.a402d.rawbtprinter.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AbstractActivityC0248d;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rawbt.api.RawbtApiHelper;
import rawbt.sdk.IRawBtPrintService;
import rawbt.sdk.RawbtPrintJob;
import rawbt.sdk.utils.PreviewImageTask;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
public class TemplatesActivity extends AbstractActivityC0248d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private y2.b f11509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TemplatesActivity f11510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f11511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f11512e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p004b.c f11508a = registerForActivityResult(new p008c.b(), new p004b.b() { // from class: r2.B2
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            this.f10882a.W((Uri) obj);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IRawBtPrintService f11513f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ServiceConnection f11514g = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final ExecutorService f11515h = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Handler f11516i = new Handler(Looper.getMainLooper());

    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            TemplatesActivity.this.f11513f = IRawBtPrintService.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            TemplatesActivity.this.f11513f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(PreviewImageTask previewImageTask) {
        final Bitmap bitmapCall = previewImageTask.call();
        this.f11516i.post(new Runnable() { // from class: r2.G2
            @Override // java.lang.Runnable
            public final void run() {
                this.f10906a.J(bitmapCall);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(View view) {
        Toast.makeText(this, getString(R.string.btnTxtPrint), 0).show();
        try {
            RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
            rawbtPrintJob.setTemplate(rawbt.api.RawbtPrintJob.TEMPLATE_DEFAULT);
            rawbtPrintJob.setPrinter(rawbt.api.RawbtPrintJob.PRINTER_CURRENT);
            rawbtPrintJob.setCopies(1);
            rawbtPrintJob.println(B2.b.b(this.f11509b.K()));
            this.f11513f.printRawbtPrintJob(rawbtPrintJob.GSON());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(PreviewImageTask previewImageTask) {
        final Bitmap bitmapCall = previewImageTask.call();
        this.f11516i.post(new Runnable() { // from class: r2.E2
            @Override // java.lang.Runnable
            public final void run() {
                this.f10896a.M(bitmapCall);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(View view) {
        try {
            this.f11509b.v0(((TextView) findViewById(R.id.text_bottom)).getText().toString());
        } catch (Exception unused) {
            X(getString(R.string.wrong_input));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(View view) {
        try {
            this.f11509b.P0(((CheckBox) findViewById(R.id.chkPrintDate)).isChecked());
        } catch (Exception unused) {
            X(getString(R.string.wrong_input));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(View view) {
        try {
            this.f11509b.V0(((CheckBox) findViewById(R.id.chkPaperCut)).isChecked());
        } catch (Exception unused) {
            X(getString(R.string.wrong_input));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(PreviewImageTask previewImageTask) {
        final Bitmap bitmapCall = previewImageTask.call();
        this.f11516i.post(new Runnable() { // from class: r2.H2
            @Override // java.lang.Runnable
            public final void run() {
                this.f10912a.R(bitmapCall);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(View view) {
        new File(this.f11509b.I()).delete();
        refresh();
        final PreviewImageTask previewImageTask = new PreviewImageTask(this.f11510c, this.f11509b.G(), this.f11509b.o(), this.f11509b.t());
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            previewImageTask.setColorBurn(-16777216);
            previewImageTask.setColorPaper(-12303292);
        }
        this.f11515h.execute(new Runnable() { // from class: r2.F2
            @Override // java.lang.Runnable
            public final void run() {
                this.f10901a.S(previewImageTask);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(View view) {
        try {
            this.f11508a.a("image/*");
        } catch (Exception unused) {
            Toast.makeText(this, R.string.need_external_fm, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view) {
        Intent intent = new Intent(this.f11510c, (Class<?>) MainActivity.class);
        intent.setAction("rawbtprinter.a402d.ru.LICENSE");
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Uri uri) {
        if (uri == null) {
            return;
        }
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                File file = new File(this.f11509b.I());
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStreamOpenInputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                byte[] bArr = new byte[8192];
                while (true) {
                    int i3 = bufferedInputStream.read(bArr);
                    if (i3 < 0) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, i3);
                    }
                }
                bufferedInputStream.close();
                bufferedOutputStream.close();
                final PreviewImageTask previewImageTask = new PreviewImageTask(this, this.f11509b.G(), this.f11509b.o(), this.f11509b.t());
                if ((getResources().getConfiguration().uiMode & 48) == 32) {
                    previewImageTask.setColorBurn(-16777216);
                    previewImageTask.setColorPaper(-12303292);
                }
                this.f11515h.execute(new Runnable() { // from class: r2.D2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10891a.K(previewImageTask);
                    }
                });
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void X(String str) {
        Toast.makeText(this, str, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        try {
            this.f11509b.Q0(((CheckBox) findViewById(R.id.chkPrintLogo)).isChecked());
        } catch (Exception unused) {
            X(getString(R.string.wrong_input));
        }
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        try {
            this.f11509b.W0(((TextView) findViewById(R.id.text_top)).getText().toString());
        } catch (Exception unused) {
            X(getString(R.string.wrong_input));
        }
    }

    private void refresh() {
        if (this.f11509b.l0()) {
            this.f11511d.setVisibility(0);
        } else {
            this.f11511d.setVisibility(8);
        }
        ((CheckBox) findViewById(R.id.chkPrintLogo)).setChecked(this.f11509b.p0());
        ((CheckBox) findViewById(R.id.chkPrintDate)).setChecked(this.f11509b.o0());
        ((CheckBox) findViewById(R.id.chkPaperCut)).setChecked(this.f11509b.s0());
        ((TextView) findViewById(R.id.text_top)).setText(this.f11509b.T());
        ((TextView) findViewById(R.id.text_bottom)).setText(this.f11509b.e());
        if (RawPrinterApp.l()) {
            findViewById(R.id.notPremiumBlock).setVisibility(0);
            findViewById(R.id.premiumBlock).setVisibility(8);
        } else {
            findViewById(R.id.notPremiumBlock).setVisibility(8);
            findViewById(R.id.premiumBlock).setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void R(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.f11512e.setImageBitmap(bitmap);
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_templates);
        this.f11510c = this;
        if (this.f11513f == null) {
            bindService(RawbtApiHelper.createExplicitIntent(), this.f11514g, 1);
        }
        this.f11509b = y2.b.w();
        setTitle(getString(R.string.document_template));
        if (getSupportActionBar() != null) {
            getSupportActionBar().s(true);
            getSupportActionBar().t(true);
        }
        this.f11512e = (ImageView) findViewById(R.id.check_logo);
        findViewById(R.id.chkPrintLogo).setOnClickListener(new View.OnClickListener() { // from class: r2.I2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10917a.lambda$onCreate$0(view);
            }
        });
        findViewById(R.id.saveTopText).setOnClickListener(new View.OnClickListener() { // from class: r2.J2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10921a.lambda$onCreate$1(view);
            }
        });
        findViewById(R.id.saveBottomText).setOnClickListener(new View.OnClickListener() { // from class: r2.K2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10927a.O(view);
            }
        });
        findViewById(R.id.chkPrintDate).setOnClickListener(new View.OnClickListener() { // from class: r2.L2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10931a.P(view);
            }
        });
        findViewById(R.id.chkPaperCut).setOnClickListener(new View.OnClickListener() { // from class: r2.M2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10936a.Q(view);
            }
        });
        TextView textView = (TextView) findViewById(R.id.btnDeleteLogo);
        this.f11511d = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: r2.N2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10943a.T(view);
            }
        });
        findViewById(R.id.btnSelectLogo).setOnClickListener(new View.OnClickListener() { // from class: r2.O2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10949a.U(view);
            }
        });
        findViewById(R.id.btnOpenLic).setOnClickListener(new View.OnClickListener() { // from class: r2.P2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10954a.V(view);
            }
        });
        findViewById(R.id.textDemoPrint).setOnClickListener(new View.OnClickListener() { // from class: r2.Q2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10959a.L(view);
            }
        });
        final PreviewImageTask previewImageTask = new PreviewImageTask(this, this.f11509b.G(), this.f11509b.o(), this.f11509b.t());
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            previewImageTask.setColorBurn(-16777216);
            previewImageTask.setColorPaper(-12303292);
        }
        this.f11515h.execute(new Runnable() { // from class: r2.C2
            @Override // java.lang.Runnable
            public final void run() {
                this.f10886a.N(previewImageTask);
            }
        });
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onDestroy() {
        if (this.f11513f != null) {
            unbindService(this.f11514g);
        }
        super.onDestroy();
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
