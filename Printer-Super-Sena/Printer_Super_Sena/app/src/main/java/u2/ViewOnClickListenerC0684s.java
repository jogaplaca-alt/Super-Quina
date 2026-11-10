package u2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
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
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.AbstractActivityC0338f;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.File;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import r2.W2;
import r2.X2;
import rawbt.api.Constant;
import rawbt.api.attributes.AttributesImage;
import rawbt.sdk.RawbtPrintJob;
import rawbt.sdk.utils.PreviewImageTask;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;
import ru.a402d.rawbtprinter.activity.MainActivity;

/* JADX INFO: renamed from: u2.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC0684s extends AbstractComponentCallbacksC0337e implements View.OnClickListener, AdapterView.OnItemSelectedListener, X2, W2 {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private View f12298d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private ImageView f12299e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    Parcelable f12300f0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private y2.b f12303i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private AttributesImage f12304j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final RawbtPrintJob f12305k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private MenuItem f12306l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    final ExecutorService f12307m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    final Handler f12308n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private long f12309o0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final p004b.c f12296b0 = p1(new p008c.b(), new p004b.b() { // from class: u2.l
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            this.f12246a.Y1((Uri) obj);
        }
    });

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private Spinner f12297c0 = null;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private Parcelable f12301g0 = null;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private boolean f12302h0 = false;

    public ViewOnClickListenerC0684s() {
        y2.b bVarW = y2.b.w();
        this.f12303i0 = bVarW;
        this.f12304j0 = bVarW.a();
        this.f12305k0 = new RawbtPrintJob();
        this.f12307m0 = Executors.newSingleThreadExecutor();
        this.f12308n0 = new Handler(Looper.getMainLooper());
        this.f12309o0 = 0L;
        StringBuilder sb = new StringBuilder();
        sb.append("android.resource://");
        Context contextG = RawPrinterApp.g();
        Objects.requireNonNull(contextG);
        sb.append(contextG.getPackageName());
        sb.append("/");
        sb.append(R.raw.mainlogo);
        this.f12300f0 = Uri.parse(sb.toString());
    }

    private void X1(Parcelable parcelable) {
        ImageView imageView = this.f12299e0;
        StringBuilder sb = new StringBuilder();
        sb.append("android.resource://");
        Context contextG = RawPrinterApp.g();
        Objects.requireNonNull(contextG);
        sb.append(contextG.getPackageName());
        sb.append("/");
        sb.append(R.mipmap.ic_launcher);
        imageView.setImageURI(Uri.parse(sb.toString()));
        this.f12299e0.setScaleType(ImageView.ScaleType.CENTER);
        this.f12300f0 = parcelable;
        if (!(parcelable instanceof Uri)) {
            this.f12300f0 = Uri.parse(parcelable.toString());
        }
        Z1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y1(Parcelable parcelable) {
        if (parcelable == null) {
            return;
        }
        ImageView imageView = this.f12299e0;
        StringBuilder sb = new StringBuilder();
        sb.append("android.resource://");
        Context contextG = RawPrinterApp.g();
        Objects.requireNonNull(contextG);
        sb.append(contextG.getPackageName());
        sb.append("/");
        sb.append(R.mipmap.ic_launcher);
        imageView.setImageURI(Uri.parse(sb.toString()));
        this.f12299e0.setScaleType(ImageView.ScaleType.CENTER);
        this.f12300f0 = parcelable;
        if (!(parcelable instanceof Uri)) {
            this.f12300f0 = Uri.parse(parcelable.toString());
        }
        this.f12301g0 = this.f12300f0;
        Z1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1() {
        ImageView imageView = this.f12299e0;
        StringBuilder sb = new StringBuilder();
        sb.append("android.resource://");
        Context contextG = RawPrinterApp.g();
        Objects.requireNonNull(contextG);
        sb.append(contextG.getPackageName());
        sb.append("/");
        sb.append(R.mipmap.ic_launcher);
        imageView.setImageURI(Uri.parse(sb.toString()));
        this.f12299e0.setScaleType(ImageView.ScaleType.CENTER);
        final PreviewImageTask previewImageTask = new PreviewImageTask(r1(), this.f12300f0, this.f12303i0.o(), this.f12304j0.getGraphicFilter());
        if (this.f12304j0.isInverseColor()) {
            previewImageTask.inverseColor();
        }
        if (this.f12304j0.isRotateImage()) {
            previewImageTask.imgRotate();
        }
        previewImageTask.setAlign(this.f12304j0.getAlignment());
        previewImageTask.setScale(this.f12304j0.getScale());
        if ((r1().getResources().getConfiguration().uiMode & 48) == 32) {
            previewImageTask.setColorBurn(-16777216);
            previewImageTask.setColorPaper(-12303292);
        }
        this.f12307m0.execute(new Runnable() { // from class: u2.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f12249a.h2(previewImageTask);
            }
        });
    }

    private void e2() {
        AbstractActivityC0338f abstractActivityC0338fM = m();
        if (abstractActivityC0338fM == null) {
            return;
        }
        if (this.f12301g0 == null) {
            this.f12301g0 = this.f12300f0;
        }
        com.theartofdev.edmodo.cropper.d.a((Uri) this.f12301g0).c(R.color.colorPrimaryDark).d(Uri.fromFile(new File(abstractActivityC0338fM.getCacheDir(), "cropped-for-rawbt.png"))).e(abstractActivityC0338fM, this);
    }

    private void f2() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, this.f12303i0.s());
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.f12297c0.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f12297c0.setSelection(this.f12304j0.getGraphicFilter());
        this.f12297c0.setOnItemSelectedListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h2(PreviewImageTask previewImageTask) {
        final Bitmap bitmapCall = previewImageTask.call();
        this.f12308n0.post(new Runnable() { // from class: u2.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f12291a.g2(bitmapCall);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2(View view) {
        this.f12304j0.setInverseColor(((SwitchCompat) view).isChecked());
        Z1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j2(View view) {
        this.f12304j0.setAlignment(Constant.ALIGNMENT_LEFT);
        Z1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(View view) {
        this.f12304j0.setAlignment(Constant.ALIGNMENT_CENTER);
        Z1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(View view) {
        this.f12304j0.setAlignment(Constant.ALIGNMENT_RIGHT);
        Z1();
    }

    public static ViewOnClickListenerC0684s m2(Parcelable parcelable) {
        ViewOnClickListenerC0684s viewOnClickListenerC0684s = new ViewOnClickListenerC0684s();
        viewOnClickListenerC0684s.f12300f0 = parcelable;
        viewOnClickListenerC0684s.f12301g0 = parcelable;
        viewOnClickListenerC0684s.f12302h0 = true;
        return viewOnClickListenerC0684s;
    }

    public static ViewOnClickListenerC0684s n2(Parcelable parcelable) {
        ViewOnClickListenerC0684s viewOnClickListenerC0684s = new ViewOnClickListenerC0684s();
        viewOnClickListenerC0684s.f12300f0 = parcelable;
        viewOnClickListenerC0684s.f12301g0 = parcelable;
        viewOnClickListenerC0684s.f12302h0 = false;
        return viewOnClickListenerC0684s;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public boolean D0(MenuItem menuItem) {
        AbstractActivityC0338f abstractActivityC0338fM = m();
        if (abstractActivityC0338fM != null) {
            try {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.texttoprint) {
                    b();
                    return true;
                }
                if (itemId == R.id.crop_image_menu_rotate_right) {
                    AttributesImage attributesImage = this.f12304j0;
                    attributesImage.setRotateImage(!attributesImage.isRotateImage());
                    if (this.f12304j0.isRotateImage()) {
                        this.f12306l0.setIcon(androidx.core.content.a.d(abstractActivityC0338fM, R.drawable.crop_image_menu_rotate_left));
                        this.f12306l0.setTitle(R.string.crop_image_menu_rotate_left);
                    } else {
                        this.f12306l0.setIcon(androidx.core.content.a.d(abstractActivityC0338fM, R.drawable.crop_image_menu_rotate_right));
                        this.f12306l0.setTitle(R.string.crop_image_menu_rotate_right);
                    }
                    Z1();
                }
                if (itemId == R.id.crop_image_menu_crop) {
                    e2();
                    return true;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return super.D0(menuItem);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void L0(Bundle bundle) {
        super.L0(bundle);
        bundle.putParcelable("parcel", this.f12300f0);
        bundle.putParcelable("original", this.f12301g0);
        bundle.putBoolean("finish", this.f12302h0);
        bundle.putParcelable("attrImg", this.f12304j0);
    }

    @Override // r2.X2
    public void b() {
        AbstractActivityC0338f abstractActivityC0338fM = m();
        if (abstractActivityC0338fM != null && SystemClock.uptimeMillis() - this.f12309o0 >= 800) {
            this.f12309o0 = SystemClock.uptimeMillis();
            try {
                AttributesImage attributesImage = new AttributesImage();
                attributesImage.setGraphicFilter(this.f12304j0.getGraphicFilter());
                attributesImage.setInverseColor(this.f12304j0.isInverseColor());
                attributesImage.setRotateImage(this.f12304j0.isRotateImage());
                attributesImage.setScale(this.f12304j0.getScale());
                attributesImage.setAlignment(this.f12304j0.getAlignment());
                RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
                rawbtPrintJob.setTemplate(this.f12305k0.getTemplate());
                rawbtPrintJob.setPrinter(this.f12305k0.getPrinter());
                rawbtPrintJob.setCopies(this.f12305k0.getCopies());
                rawbtPrintJob.setIdJob(UUID.randomUUID().toString());
                ((MainActivity) abstractActivityC0338fM).h0(rawbtPrintJob.getIdJob(), rawbtPrintJob.getPrinter());
                rawbtPrintJob.image(this.f12300f0, attributesImage);
                try {
                    ((MainActivity) r1()).f11399o.printRawbtPrintJob(rawbtPrintJob.GSON());
                } catch (Exception e3) {
                    Toast.makeText(r1(), e3.getLocalizedMessage(), 0).show();
                }
                if (this.f12302h0) {
                    abstractActivityC0338fM.finish();
                }
            } catch (Exception e4) {
                RawPrinterApp.r(e4.getLocalizedMessage());
            }
        }
    }

    @Override // r2.W2
    public void d() {
        try {
            this.f12296b0.a("image/*");
        } catch (Exception unused) {
            Toast.makeText(m(), R.string.need_external_fm, 1).show();
        }
    }

    /* JADX INFO: renamed from: d2, reason: merged with bridge method [inline-methods] */
    public void g2(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.f12299e0.setImageBitmap(bitmap);
        if (bitmap.getHeight() > 1000) {
            this.f12299e0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            this.f12299e0.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        this.f12298d0.findViewById(R.id.btnBmpPrint).setVisibility(0);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void k0(int i3, int i4, Intent intent) {
        if (-1 == i4 && 203 == i3) {
            X1(com.theartofdev.edmodo.cropper.d.b(intent).i());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            int id = view.getId();
            if (id == R.id.btnBmpSelect) {
                d();
            } else if (id == R.id.btnBmpPrint) {
                b();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
        try {
            ((TextView) adapterView.getChildAt(0)).setTextColor(M().getColor(R.color.colorAccent));
        } catch (Exception unused) {
        }
        this.f12304j0.setGraphicFilter(i3);
        Z1();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void p0(Bundle bundle) {
        super.p0(bundle);
        if (bundle != null) {
            this.f12300f0 = bundle.getParcelable("parcel");
            this.f12301g0 = bundle.getParcelable("original");
            this.f12302h0 = bundle.getBoolean("finish");
            this.f12304j0 = (AttributesImage) bundle.getParcelable("attrImg");
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void s0(Menu menu, MenuInflater menuInflater) {
        AbstractActivityC0338f abstractActivityC0338fM = m();
        if (abstractActivityC0338fM == null) {
            return;
        }
        menu.add(0, R.id.crop_image_menu_crop, 1, S(R.string.crop_image_menu_crop));
        MenuItem item = menu.getItem(0);
        item.setIcon(androidx.core.content.a.d(abstractActivityC0338fM, R.drawable.ic_crop_white_24dp));
        item.setShowAsAction(1);
        menu.add(0, R.id.crop_image_menu_rotate_right, 2, S(R.string.crop_image_menu_rotate_right));
        MenuItem item2 = menu.getItem(1);
        this.f12306l0 = item2;
        item2.setIcon(androidx.core.content.a.d(abstractActivityC0338fM, R.drawable.crop_image_menu_rotate_right));
        this.f12306l0.setShowAsAction(1);
        menu.add(0, R.id.texttoprint, 3, S(R.string.btnTxtPrint));
        MenuItem item3 = menu.getItem(2);
        item3.setIcon(androidx.core.content.a.d(abstractActivityC0338fM, R.drawable.ic_stat_print));
        item3.setShowAsAction(1);
        super.s0(menu, menuInflater);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1(true);
        if (m() == null) {
            return null;
        }
        View viewInflate = layoutInflater.inflate(R.layout.fragment_bmp, viewGroup, false);
        this.f12298d0 = viewInflate;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.imageViewBmp);
        this.f12299e0 = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        ImageView imageView2 = this.f12299e0;
        StringBuilder sb = new StringBuilder();
        sb.append("android.resource://");
        Context contextG = RawPrinterApp.g();
        Objects.requireNonNull(contextG);
        sb.append(contextG.getPackageName());
        sb.append("/");
        sb.append(R.mipmap.ic_launcher);
        imageView2.setImageURI(Uri.parse(sb.toString()));
        this.f12297c0 = (Spinner) this.f12298d0.findViewById(R.id.spinnerGraph);
        f2();
        this.f12298d0.findViewById(R.id.chk_inverse_colors).setOnClickListener(new View.OnClickListener() { // from class: u2.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12253a.i2(view);
            }
        });
        ConstraintLayout constraintLayout = (ConstraintLayout) this.f12298d0.findViewById(R.id.bottom_sheet);
        BottomSheetBehavior.q0(constraintLayout).O0((int) ((M().getDisplayMetrics().densityDpi / 160.0f) * 52.0f));
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        layoutParams.height = (int) ((M().getDisplayMetrics().densityDpi / 160.0f) * 220.0f);
        constraintLayout.setLayoutParams(layoutParams);
        Button button = (Button) this.f12298d0.findViewById(R.id.btnBmpPrint);
        Button button2 = (Button) this.f12298d0.findViewById(R.id.btnBmpSelect);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button2.requestFocus();
        this.f12298d0.findViewById(R.id.rbAlignLeft).setOnClickListener(new View.OnClickListener() { // from class: u2.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12258a.j2(view);
            }
        });
        this.f12298d0.findViewById(R.id.rbAlignCenter).setOnClickListener(new View.OnClickListener() { // from class: u2.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12262a.k2(view);
            }
        });
        this.f12298d0.findViewById(R.id.rbAlignRight).setOnClickListener(new View.OnClickListener() { // from class: u2.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12266a.l2(view);
            }
        });
        Spinner spinner = (Spinner) this.f12298d0.findViewById(R.id.spinnerScale);
        ArrayAdapter arrayAdapter = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, y2.b.v());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setSelection(this.f12304j0.getScale() - 1);
        spinner.setOnItemSelectedListener(new a());
        this.f12305k0.setCopies(this.f12303i0.i());
        s2.g.c(r1(), (Spinner) this.f12298d0.findViewById(R.id.spinnerSelectPrinter), this.f12305k0);
        Spinner spinner2 = (Spinner) this.f12298d0.findViewById(R.id.spinnerSelectTemplate);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, y2.b.S());
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter2);
        spinner2.setOnItemSelectedListener(new b());
        Spinner spinner3 = (Spinner) this.f12298d0.findViewById(R.id.spinnerNumbersCopies);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(r1(), android.R.layout.simple_spinner_item, y2.b.H());
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner3.setAdapter((SpinnerAdapter) arrayAdapter3);
        spinner3.setSelection(this.f12305k0.getCopies() - 1);
        spinner3.setOnItemSelectedListener(new c());
        Z1();
        return this.f12298d0;
    }

    /* JADX INFO: renamed from: u2.s$a */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            ViewOnClickListenerC0684s.this.f12304j0.setScale(i3 + 1);
            ViewOnClickListenerC0684s.this.Z1();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: renamed from: u2.s$b */
    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            if (i3 == 1) {
                ViewOnClickListenerC0684s.this.f12305k0.setTemplate("none");
            } else {
                ViewOnClickListenerC0684s.this.f12305k0.setTemplate(rawbt.api.RawbtPrintJob.TEMPLATE_DEFAULT);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: renamed from: u2.s$c */
    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            ViewOnClickListenerC0684s.this.f12305k0.setCopies(i3 + 1);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }
}
