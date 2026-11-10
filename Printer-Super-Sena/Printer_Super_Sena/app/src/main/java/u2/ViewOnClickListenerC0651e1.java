package u2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SystemClock;
import android.print.PrintManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.fragment.app.AbstractActivityC0338f;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import r2.W2;
import r2.X2;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesPdf;
import rawbt.api.command.CommandString;
import rawbt.sdk.RawbtPrintJob;
import rawbt.sdk.utils.File;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;
import ru.a402d.rawbtprinter.activity.MainActivity;

/* JADX INFO: renamed from: u2.e1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC0651e1 extends AbstractComponentCallbacksC0337e implements View.OnClickListener, X2, W2 {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    SharedPreferences f12162d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    int f12163e0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private View f12167i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private ImageView f12168j0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private ViewPager2 f12170l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private h f12171m0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private final y2.b f12174p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private AttributesImage f12175q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private AttributesPdf f12176r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private final RawbtPrintJob f12177s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private long f12178t0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    final ExecutorService f12160b0 = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    final Handler f12161c0 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private final p004b.c f12164f0 = p1(new p008c.b(), new p004b.b() { // from class: u2.b1
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            this.f12149a.d2((Uri) obj);
        }
    });

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private int f12165g0 = -1;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private int f12166h0 = -1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private String f12169k0 = "";

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private Spinner f12172n0 = null;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    Parcelable f12173o0 = null;

    /* JADX INFO: renamed from: u2.e1$b */
    class b extends ViewPager2.i {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void a(int i3) {
            super.a(i3);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void b(int i3, float f3, int i4) {
            super.b(i3, f3, i4);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i3) {
            super.c(i3);
            AbstractActivityC0338f abstractActivityC0338fM = ViewOnClickListenerC0651e1.this.m();
            if (abstractActivityC0338fM == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            int i4 = i3 + 1;
            sb.append(i4);
            sb.append("/");
            sb.append(ViewOnClickListenerC0651e1.this.f12171m0.e());
            sb.append("] ");
            sb.append(File.getFileName(ViewOnClickListenerC0651e1.this.f12169k0));
            abstractActivityC0338fM.setTitle(sb.toString());
            ((TextView) ViewOnClickListenerC0651e1.this.f12167i0.findViewById(R.id.textCurrentPosition)).setText(String.format(abstractActivityC0338fM.getString(R.string.goto_to_pag_n), Integer.valueOf(i4)));
            ((SeekBar) ViewOnClickListenerC0651e1.this.f12167i0.findViewById(R.id.seekBar)).setProgress(i3);
        }
    }

    /* JADX INFO: renamed from: u2.e1$h */
    private class h extends p035j0.a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f12188k;

        h(AbstractActivityC0338f abstractActivityC0338f) {
            super(abstractActivityC0338f);
            this.f12188k = 0;
        }

        void Q(int i3) {
            this.f12188k = i3;
            j();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int e() {
            return this.f12188k;
        }

        @Override // p035j0.a
        public AbstractComponentCallbacksC0337e y(int i3) {
            ViewOnClickListenerC0651e1 viewOnClickListenerC0651e1 = ViewOnClickListenerC0651e1.this;
            return C0660h1.U1(i3, viewOnClickListenerC0651e1.f12163e0 >= 3, viewOnClickListenerC0651e1.f12176r0, ViewOnClickListenerC0651e1.this.f12175q0);
        }
    }

    public ViewOnClickListenerC0651e1() {
        y2.b bVarW = y2.b.w();
        this.f12174p0 = bVarW;
        this.f12175q0 = bVarW.a();
        this.f12176r0 = bVarW.b();
        this.f12177s0 = new RawbtPrintJob();
        this.f12178t0 = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A2(z2.c cVar) {
        final z2.c.a aVarCall = cVar.call();
        this.f12161c0.post(new Runnable() { // from class: u2.d1
            @Override // java.lang.Runnable
            public final void run() {
                this.f12156a.z2(aVarCall);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B2(MainActivity mainActivity, String str) {
        java.io.File file = new java.io.File(mainActivity.getCacheDir(), str);
        RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
        rawbtPrintJob.setTemplate(this.f12177s0.getTemplate());
        rawbtPrintJob.setPrinter(this.f12177s0.getPrinter());
        rawbtPrintJob.setCopies(this.f12177s0.getCopies());
        this.f12176r0.setPage(-1);
        rawbtPrintJob.pdf(Uri.fromFile(file), this.f12176r0, this.f12175q0);
        K2(rawbtPrintJob);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C2(MainActivity mainActivity, String str) {
        java.io.File file = new java.io.File(mainActivity.getCacheDir(), str);
        RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
        rawbtPrintJob.setTemplate(this.f12177s0.getTemplate());
        rawbtPrintJob.setPrinter(this.f12177s0.getPrinter());
        rawbtPrintJob.setCopies(this.f12177s0.getCopies());
        this.f12176r0.setPage(this.f12170l0.getCurrentItem());
        rawbtPrintJob.pdf(Uri.fromFile(file), this.f12176r0, this.f12175q0);
        K2(rawbtPrintJob);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D2(java.io.File file, java.io.File file2, MainActivity mainActivity, ViewOnClickListenerC0651e1 viewOnClickListenerC0651e1, ProgressDialog progressDialog) {
        try {
            q2(file, file2);
            com.theartofdev.edmodo.cropper.d.a(Uri.fromFile(file2)).c(R.color.colorPrimaryDark).d(Uri.fromFile(new java.io.File(mainActivity.getCacheDir(), "cropped-for-rawbt.png"))).e(mainActivity, viewOnClickListenerC0651e1);
        } catch (Exception e3) {
            RawPrinterApp.r("error : " + e3.getLocalizedMessage());
            e3.printStackTrace();
        }
        progressDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E2(java.io.File file, java.io.File file2, ViewOnClickListenerC0651e1 viewOnClickListenerC0651e1, MainActivity mainActivity, ProgressDialog progressDialog) {
        try {
            q2(file, file2);
            Intent intent = new Intent(viewOnClickListenerC0651e1.r1(), (Class<?>) MainActivity.class);
            intent.setFlags(268435456);
            intent.setAction("rawbtprinter.a402d.ru.PREVIEW_IMAGE");
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file2));
            mainActivity.startActivity(intent);
        } catch (Exception e3) {
            RawPrinterApp.r(e3.getLocalizedMessage());
            e3.printStackTrace();
        }
        progressDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F2(MainActivity mainActivity, String str, RawbtPrintJob rawbtPrintJob) {
        mainActivity.h0(str, rawbtPrintJob.getPrinter());
    }

    public static ViewOnClickListenerC0651e1 G2(Parcelable parcelable, AttributesPdf attributesPdf, AttributesImage attributesImage) {
        ViewOnClickListenerC0651e1 viewOnClickListenerC0651e1 = new ViewOnClickListenerC0651e1();
        viewOnClickListenerC0651e1.f12173o0 = parcelable;
        if (!(parcelable instanceof Uri)) {
            viewOnClickListenerC0651e1.f12173o0 = Uri.parse(parcelable.toString());
        }
        viewOnClickListenerC0651e1.f12176r0 = attributesPdf;
        viewOnClickListenerC0651e1.f12175q0 = attributesImage;
        return viewOnClickListenerC0651e1;
    }

    private void H2(View view) {
        final MainActivity mainActivity = (MainActivity) m();
        if (mainActivity == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.btnPdfSelect) {
            d();
            return;
        }
        if (id == R.id.btnPdfPrint) {
            int i3 = this.f12162d0.getInt("APP_PDF_BUTTON_ACTION", 0);
            if (i3 == 0) {
                b();
                return;
            }
            final String str = "to_preview.pdf";
            if (i3 == 1) {
                this.f12160b0.execute(new Runnable() { // from class: u2.X0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12123a.B2(mainActivity, str);
                    }
                });
                return;
            }
            if (i3 == 2) {
                this.f12160b0.execute(new Runnable() { // from class: u2.Y0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12127a.C2(mainActivity, str);
                    }
                });
                return;
            }
            if (i3 == 3) {
                final ProgressDialog progressDialogShow = ProgressDialog.show(t(), "", S(R.string.generating_wait), true);
                final java.io.File file = new java.io.File(mainActivity.getCacheDir(), "to_preview.pdf");
                final java.io.File file2 = new java.io.File(mainActivity.getCacheDir(), "to_edit.png");
                this.f12160b0.execute(new Runnable() { // from class: u2.Z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12131a.D2(file, file2, mainActivity, this, progressDialogShow);
                    }
                });
                return;
            }
            if (i3 != 4) {
                return;
            }
            final ProgressDialog progressDialogShow2 = ProgressDialog.show(t(), "", S(R.string.generating_wait), true);
            final java.io.File file3 = new java.io.File(r1().getCacheDir(), "to_preview.pdf");
            final java.io.File file4 = new java.io.File(r1().getCacheDir(), "to_edit.png");
            this.f12160b0.execute(new Runnable() { // from class: u2.a1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12141a.E2(file3, file4, this, mainActivity, progressDialogShow2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2() {
        this.f12166h0 = this.f12170l0.getCurrentItem();
        this.f12170l0.setAdapter(this.f12171m0);
        this.f12170l0.setCurrentItem(this.f12166h0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2(int i3) {
        if (i3 == this.f12163e0) {
            return;
        }
        this.f12163e0 = i3;
        try {
            SharedPreferences.Editor editorEdit = this.f12162d0.edit();
            editorEdit.putInt("APP_PDF_BUTTON_ACTION", i3);
            editorEdit.apply();
            I2();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void K2(final RawbtPrintJob rawbtPrintJob) {
        final MainActivity mainActivity = (MainActivity) r1();
        final String string = UUID.randomUUID().toString();
        rawbtPrintJob.setIdJob(string);
        this.f12161c0.post(new Runnable() { // from class: u2.S0
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0651e1.F2(mainActivity, string, rawbtPrintJob);
            }
        });
        try {
            mainActivity.f11399o.printRawbtPrintJob(rawbtPrintJob.GSON());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d2(Parcelable parcelable) {
        if (Build.VERSION.SDK_INT < 21) {
            RawPrinterApp.r(S(R.string.letter50));
            return;
        }
        if (parcelable == null) {
            return;
        }
        this.f12165g0 = -1;
        this.f12168j0.setVisibility(0);
        this.f12173o0 = parcelable;
        if (!(parcelable instanceof Uri)) {
            this.f12173o0 = Uri.parse(parcelable.toString());
        }
        r1().setTitle(S(R.string.wait));
        this.f12166h0 = -1;
        this.f12168j0.setVisibility(0);
        final z2.c cVar = new z2.c(m(), this.f12173o0);
        this.f12160b0.execute(new Runnable() { // from class: u2.T0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12112a.v2(cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o2() {
        this.f12167i0.findViewById(R.id.panelPrint).setVisibility(8);
        int i3 = this.f12163e0;
        if (i3 == 0) {
            ((Button) this.f12167i0.findViewById(R.id.btnPdfPrint)).setText(R.string.btnTxtPrint);
            return;
        }
        if (i3 == 1 || i3 == 2) {
            ((Button) this.f12167i0.findViewById(R.id.btnPdfPrint)).setText(R.string.btnTxtPrint);
            this.f12167i0.findViewById(R.id.panelPrint).setVisibility(0);
        } else if (i3 == 3) {
            ((Button) this.f12167i0.findViewById(R.id.btnPdfPrint)).setText(R.string.crop_image_menu_crop);
        } else {
            if (i3 != 4) {
                return;
            }
            ((Button) this.f12167i0.findViewById(R.id.btnPdfPrint)).setText(R.string.Export);
        }
    }

    private void q2(java.io.File file, java.io.File file2) {
        Bitmap bitmapCreateBitmap;
        try {
            if (Build.VERSION.SDK_INT < 21 || this.f12165g0 == this.f12170l0.getCurrentItem()) {
                return;
            }
            PdfRenderer pdfRenderer = new PdfRenderer(ParcelFileDescriptor.open(file, 268435456));
            PdfRenderer.Page pageOpenPage = pdfRenderer.openPage(this.f12170l0.getCurrentItem());
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(pageOpenPage.getWidth() * 6, pageOpenPage.getHeight() * 6, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                bitmapCreateBitmap = Bitmap.createBitmap(pageOpenPage.getWidth() * 3, pageOpenPage.getHeight() * 3, Bitmap.Config.ARGB_8888);
            }
            bitmapCreateBitmap.setHasAlpha(false);
            bitmapCreateBitmap.eraseColor(-1);
            pageOpenPage.render(bitmapCreateBitmap, null, null, 2);
            pageOpenPage.close();
            pdfRenderer.close();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            this.f12165g0 = this.f12170l0.getCurrentItem();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void r2() {
        final AbstractActivityC0338f abstractActivityC0338fR1 = r1();
        if (!(this.f12173o0 instanceof Uri)) {
            Toast.makeText(abstractActivityC0338fR1, R.string.not_selected, 0).show();
        } else {
            Toast.makeText(abstractActivityC0338fR1, R.string.wait, 0).show();
            this.f12160b0.execute(new Runnable() { // from class: u2.c1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12152a.w2(abstractActivityC0338fR1);
                }
            });
        }
    }

    private ArrayList s2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(S(R.string.use_default_android_print_service));
        arrayList.add(S(R.string.print_the_whole_file));
        arrayList.add(S(R.string.print_current_page));
        arrayList.add(S(R.string.clipping_part_of_page));
        arrayList.add(S(R.string.export_page_as_image));
        return arrayList;
    }

    private void t2() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, this.f12174p0.s());
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.f12172n0.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f12172n0.setSelection(this.f12175q0.getGraphicFilter());
        this.f12172n0.setOnItemSelectedListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u2(z2.c.a aVar) {
        p2(aVar.f13145a, aVar.f13146b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v2(z2.c cVar) {
        final z2.c.a aVarCall = cVar.call();
        this.f12161c0.post(new Runnable() { // from class: u2.U0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12115a.u2(aVarCall);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w2(Context context) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        try {
            java.io.File file = new java.io.File(context.getCacheDir(), "to_preview.pdf");
            java.io.File file2 = new java.io.File(context.getCacheDir(), "share");
            file2.mkdir();
            java.io.File file3 = new java.io.File(file2.getPath(), "to_share.pdf");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
            byte[] bArr = new byte[8192];
            while (true) {
                int i3 = bufferedInputStream.read(bArr);
                if (i3 < 0) {
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                    Uri uriH = FileProvider.h(context, "ru.a402d.rawbtprinter.fileprovider", file3);
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.STREAM", uriH);
                    intent.setType("application/pdf");
                    try {
                        L1(intent);
                        return;
                    } catch (Exception unused) {
                        Toast.makeText(context, R.string.no_app_for_action, 0).show();
                        return;
                    }
                }
                bufferedOutputStream.write(bArr, 0, i3);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            Toast.makeText(context, "Error", 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x2(View view) {
        this.f12176r0.setRotate(((SwitchCompat) this.f12167i0.findViewById(R.id.chk_rotate)).isChecked() ? 90 : 0);
        I2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y2(View view) {
        this.f12176r0.setRoll(((CheckBox) this.f12167i0.findViewById(R.id.chkRoll)).isChecked());
        I2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z2(z2.c.a aVar) {
        p2(aVar.f13145a, aVar.f13146b);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public boolean D0(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.texttoprint) {
            b();
            return true;
        }
        if (itemId != R.id.action_share) {
            return super.D0(menuItem);
        }
        r2();
        return true;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void K0() {
        super.K0();
        o2();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void L0(Bundle bundle) {
        super.L0(bundle);
        bundle.putParcelable("parcel", this.f12173o0);
        bundle.putInt("page", this.f12170l0.getCurrentItem());
    }

    @Override // r2.X2
    public void b() {
        if (Build.VERSION.SDK_INT < 21) {
            RawPrinterApp.r(S(R.string.letter50));
            return;
        }
        try {
            if (this.f12173o0 instanceof Uri) {
                AbstractActivityC0338f abstractActivityC0338fM = m();
                Objects.requireNonNull(abstractActivityC0338fM);
                PrintManager printManager = (PrintManager) abstractActivityC0338fM.getSystemService(CommandString.TAG);
                if (printManager != null) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(new java.io.File(abstractActivityC0338fM.getCacheDir(), "to_preview.pdf"));
                        String str = S(R.string.app_name) + " Document";
                        printManager.print(str, new o2.b(str, fileInputStream), null);
                    } catch (Exception unused) {
                        Toast.makeText(t(), r1().getString(R.string.Oopppsss), 1).show();
                    }
                } else {
                    Toast.makeText(t(), S(R.string.not_selected), 0).show();
                }
            } else {
                Toast.makeText(t(), R.string.not_selected, 0).show();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // r2.W2
    public void d() {
        try {
            this.f12164f0.a("application/pdf");
        } catch (Exception unused) {
            Toast.makeText(m(), R.string.need_external_fm, 1).show();
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void k0(int i3, int i4, Intent intent) {
        if (((MainActivity) m()) != null && intent != null && i4 == -1 && i3 == 203) {
            Uri uriI = com.theartofdev.edmodo.cropper.d.b(intent).i();
            RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
            rawbtPrintJob.image(uriI, this.f12175q0);
            K2(rawbtPrintJob);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (SystemClock.uptimeMillis() - this.f12178t0 < 800) {
            return;
        }
        this.f12178t0 = SystemClock.uptimeMillis();
        H2(view);
    }

    public void p2(String str, int i3) {
        AbstractActivityC0338f abstractActivityC0338fM = m();
        if (abstractActivityC0338fM == null) {
            return;
        }
        this.f12171m0 = null;
        this.f12170l0.setAdapter(null);
        if (i3 < 1) {
            abstractActivityC0338fM.setTitle(S(R.string.open_txt));
            Toast.makeText(abstractActivityC0338fM, "Wrong PDF file", 0).show();
            return;
        }
        h hVar = new h(abstractActivityC0338fM);
        this.f12171m0 = hVar;
        hVar.Q(i3);
        this.f12170l0.setAdapter(this.f12171m0);
        this.f12169k0 = str;
        int i4 = this.f12166h0;
        if (i4 > 0) {
            this.f12170l0.setCurrentItem(i4);
        } else {
            i4 = 0;
        }
        abstractActivityC0338fM.setTitle("[" + (i4 + 1) + "/" + i3 + "] " + File.getFileName(str));
        ((TextView) this.f12167i0.findViewById(R.id.textCurrentPosition)).setText(String.format(abstractActivityC0338fM.getString(R.string.goto_to_pag_n), 1));
        ((SeekBar) this.f12167i0.findViewById(R.id.seekBar)).setMax(i3 - 1);
        ((SeekBar) this.f12167i0.findViewById(R.id.seekBar)).setProgress(i4);
        this.f12167i0.findViewById(R.id.btnPdfPrint).setVisibility(0);
        this.f12167i0.findViewById(R.id.imageViewBottomSwipe).setVisibility(0);
        ConstraintLayout constraintLayout = (ConstraintLayout) this.f12167i0.findViewById(R.id.bottom_sheet);
        BottomSheetBehavior.q0(constraintLayout).O0((int) ((((float) M().getDisplayMetrics().densityDpi) / 160.0f) * 52.0f));
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        layoutParams.height = (int) ((M().getDisplayMetrics().densityDpi / 160.0f) * 380.0f);
        constraintLayout.setLayoutParams(layoutParams);
        this.f12168j0.setVisibility(8);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void s0(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.pdf_frame, menu);
        super.s0(menu, menuInflater);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle != null) {
            this.f12173o0 = bundle.getParcelable("parcel");
            this.f12166h0 = bundle.getInt("page");
        }
        SharedPreferences preferences = r1().getPreferences(0);
        this.f12162d0 = preferences;
        this.f12163e0 = preferences.getInt("APP_PDF_BUTTON_ACTION", 0);
        AbstractActivityC0338f abstractActivityC0338fM = m();
        if (abstractActivityC0338fM == null) {
            return null;
        }
        abstractActivityC0338fM.setTitle(S(R.string.open_txt));
        C1(true);
        View viewInflate = layoutInflater.inflate(R.layout.fragment_pdf, viewGroup, false);
        this.f12167i0 = viewInflate;
        Button button = (Button) viewInflate.findViewById(R.id.btnPdfPrint);
        Button button2 = (Button) this.f12167i0.findViewById(R.id.btnPdfSelect);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button2.requestFocus();
        button.setVisibility(8);
        this.f12168j0 = (ImageView) this.f12167i0.findViewById(R.id.imageView);
        this.f12172n0 = (Spinner) this.f12167i0.findViewById(R.id.spinnerGraph);
        t2();
        this.f12167i0.findViewById(R.id.chk_rotate).setOnClickListener(new View.OnClickListener() { // from class: u2.R0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12083a.x2(view);
            }
        });
        Spinner spinner = (Spinner) this.f12167i0.findViewById(R.id.spinnerWidthTruncate);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(r1(), R.array.WidthTruncateModeNames, android.R.layout.simple_spinner_item);
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
        spinner.setSelection(this.f12176r0.getWidthTruncateMode());
        spinner.setOnItemSelectedListener(new a());
        this.f12167i0.findViewById(R.id.chkRoll).setOnClickListener(new View.OnClickListener() { // from class: u2.V0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12118a.y2(view);
            }
        });
        ViewPager2 viewPager2 = (ViewPager2) this.f12167i0.findViewById(R.id.pager);
        this.f12170l0 = viewPager2;
        viewPager2.g(new b());
        ((SeekBar) this.f12167i0.findViewById(R.id.seekBar)).setOnSeekBarChangeListener(new c(abstractActivityC0338fM));
        Spinner spinner2 = (Spinner) this.f12167i0.findViewById(R.id.pdfBtnActionSelect);
        ArrayAdapter arrayAdapter = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, s2());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner2.setSelection(this.f12163e0);
        spinner2.setOnItemSelectedListener(new d());
        s2.g.c(r1(), (Spinner) this.f12167i0.findViewById(R.id.spinnerSelectPrinter), this.f12177s0);
        Spinner spinner3 = (Spinner) this.f12167i0.findViewById(R.id.spinnerSelectTemplate);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, y2.b.S());
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner3.setAdapter((SpinnerAdapter) arrayAdapter2);
        spinner3.setOnItemSelectedListener(new e());
        Spinner spinner4 = (Spinner) this.f12167i0.findViewById(R.id.spinnerNumbersCopies);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, y2.b.H());
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner4.setAdapter((SpinnerAdapter) arrayAdapter3);
        spinner4.setSelection(this.f12177s0.getCopies() - 1);
        spinner4.setOnItemSelectedListener(new f());
        if (Build.VERSION.SDK_INT < 21) {
            button2.setVisibility(4);
            abstractActivityC0338fM.setTitle(R.string.letter50);
        } else if (this.f12173o0 != null) {
            final z2.c cVar = new z2.c(m(), this.f12173o0);
            this.f12160b0.execute(new Runnable() { // from class: u2.W0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12120a.A2(cVar);
                }
            });
        }
        return this.f12167i0;
    }

    /* JADX INFO: renamed from: u2.e1$a */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(ViewOnClickListenerC0651e1.this.M().getColor(R.color.colorAccent));
                ViewOnClickListenerC0651e1.this.f12176r0.setWidthTruncateMode(i3);
                ViewOnClickListenerC0651e1.this.I2();
            } catch (Exception unused) {
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: renamed from: u2.e1$c */
    class c implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f12181a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f12182b;

        c(Activity activity) {
            this.f12182b = activity;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z3) {
            ((TextView) ViewOnClickListenerC0651e1.this.f12167i0.findViewById(R.id.textCurrentPosition)).setText(String.format(this.f12182b.getString(R.string.goto_to_pag_n), Integer.valueOf(i3 + 1)));
            this.f12181a = i3;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            ViewOnClickListenerC0651e1.this.f12170l0.setCurrentItem(this.f12181a);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
    }

    /* JADX INFO: renamed from: u2.e1$d */
    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            ViewOnClickListenerC0651e1.this.J2(i3);
            ViewOnClickListenerC0651e1.this.o2();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: renamed from: u2.e1$e */
    class e implements AdapterView.OnItemSelectedListener {
        e() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            if (i3 == 1) {
                ViewOnClickListenerC0651e1.this.f12177s0.setTemplate("none");
            } else {
                ViewOnClickListenerC0651e1.this.f12177s0.setTemplate(rawbt.api.RawbtPrintJob.TEMPLATE_DEFAULT);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: renamed from: u2.e1$f */
    class f implements AdapterView.OnItemSelectedListener {
        f() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            ViewOnClickListenerC0651e1.this.f12177s0.setCopies(i3 + 1);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: renamed from: u2.e1$g */
    class g implements AdapterView.OnItemSelectedListener {
        g() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            try {
                ((TextView) adapterView.getChildAt(0)).setTextColor(ViewOnClickListenerC0651e1.this.M().getColor(R.color.colorAccent));
                if (ViewOnClickListenerC0651e1.this.f12175q0.getGraphicFilter() != i3) {
                    ViewOnClickListenerC0651e1.this.f12175q0.setGraphicFilter(i3);
                    ViewOnClickListenerC0651e1.this.I2();
                }
            } catch (Exception unused) {
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }
}
