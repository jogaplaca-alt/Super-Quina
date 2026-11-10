package ru.a402d.prnviewer;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.text.Html;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AbstractActivityC0248d;
import androidx.appcompat.app.AbstractC0245a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.core.view.AbstractC0323v;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import r2.W2;
import r2.X2;
import rawbt.api.Constant;
import rawbt.api.RawbtApiHelper;
import rawbt.api.RawbtMediaTypes;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.command.CommandImageInBase64;
import rawbt.api.command.CommandParcelable;
import rawbt.sdk.IRawBtPrintService;
import rawbt.sdk.RawbtPrintJob;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.emulator.common.PreviewTask;
import rawbt.sdk.emulator.common.PreviewTaskCallback;
import rawbt.sdk.transport.PrintToFile;
import rawbt.sdk.utils.RawbtHelper;
import rawbt.sdk.utils.Saver;
import ru.a402d.prnviewer.ViewActivity;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;
import ru.a402d.rawbtprinter.activity.EditPrinterActivity;

/* JADX INFO: loaded from: classes.dex */
public class ViewActivity extends AbstractActivityC0248d implements W2, X2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    SharedPreferences f11233a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PhotoView f11236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ScrollView f11237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ScrollView f11238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ProgressBar f11239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f11240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f11241i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p004b.c f11234b = registerForActivityResult(new p008c.b(), new p004b.b() { // from class: p2.m
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            this.f10530a.G((Uri) obj);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Parcelable f11235c = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f11242j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IRawBtPrintService f11243k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ServiceConnection f11244l = new a();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final PreviewTaskCallback f11245m = new c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final ExecutorService f11246n = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final Handler f11247o = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Bitmap f11248p = null;

    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ViewActivity.this.f11243k = IRawBtPrintService.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ViewActivity.this.f11243k = null;
        }
    }

    class b implements TabLayout.c {
        b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void a(TabLayout.e eVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void b(TabLayout.e eVar) {
            ViewActivity.this.d0(eVar.g());
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void c(TabLayout.e eVar) {
        }
    }

    class c implements PreviewTaskCallback {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str, String str2, int i3, int i4) {
            if (str != null) {
                ViewActivity.this.f11241i.append(Html.fromHtml(str));
            }
            if (str2 != null) {
                ViewActivity.this.f11240h.append(Html.fromHtml(str2));
            }
            ViewActivity.this.f11239g.setMax(i3);
            ViewActivity.this.f11239g.setProgress(i4);
        }

        @Override // rawbt.sdk.emulator.common.PreviewTaskCallback
        public void updateProgress(final int i3, final int i4, final String str, final String str2) {
            ViewActivity.this.runOnUiThread(new Runnable() { // from class: ru.a402d.prnviewer.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11252a.b(str2, str, i4, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(Parcelable parcelable) {
        if (parcelable == null) {
            return;
        }
        if (!(parcelable instanceof Uri)) {
            parcelable = Uri.parse(parcelable.toString());
        }
        if (RawbtMediaTypes.detectContentType(this, (Uri) parcelable, null) != Constant.RAWBT_CONTENT_TYPE.prn) {
            Toast.makeText(this, getString(R.string.not_allowed_media_type), 0).show();
        } else {
            this.f11235c = parcelable;
            b0();
        }
    }

    private void L() {
        int i3 = this.f11233a.getInt("APP_PRN_BUTTON_ACTION", 0);
        if (i3 == 0) {
            ((RadioButton) findViewById(R.id.prnBtnActionPrintPrn)).setChecked(true);
        } else {
            if (i3 != 1) {
                return;
            }
            ((RadioButton) findViewById(R.id.prnBtnActionPrintImage)).setChecked(true);
        }
    }

    private void N() {
        this.f11246n.execute(new Runnable() { // from class: p2.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f10518a.S(this);
            }
        });
    }

    private void O() {
        final ProgressDialog progressDialogShow = ProgressDialog.show(this, "", getString(R.string.generating_wait), true);
        int i3 = this.f11242j;
        if (i3 == 0) {
            this.f11246n.execute(new Runnable() { // from class: p2.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10509a.T(this, progressDialogShow);
                }
            });
        } else if (i3 == 1) {
            this.f11246n.execute(new Runnable() { // from class: p2.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10512a.U(this, progressDialogShow);
                }
            });
        } else if (i3 == 2) {
            this.f11246n.execute(new Runnable() { // from class: p2.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10515a.V(this, progressDialogShow);
                }
            });
        }
    }

    private void P(Intent intent) {
        try {
            String action = intent.getAction();
            if (action != null && !action.equals("android.intent.action.MAIN")) {
                if ("android.intent.action.VIEW".equals(action)) {
                    this.f11235c = intent.getData();
                    return;
                }
                if (PrintToFile.ACTION_PRN_VIEW.equals(action) || "android.intent.action.SEND".equals(action) || "android.intent.action.SENDTO".equals(action)) {
                    Bundle extras = intent.getExtras();
                    if (extras == null) {
                        return;
                    }
                    Uri uri = (Uri) extras.getParcelable("android.intent.extra.STREAM");
                    if (uri != null) {
                        this.f11235c = uri;
                    }
                }
                b0();
            }
        } catch (Exception e3) {
            e = e3;
            RawPrinterApp.r(e.getLocalizedMessage());
        } catch (OutOfMemoryError e4) {
            e = e4;
            RawPrinterApp.r(e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        try {
            RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
            int i3 = this.f11233a.getInt("APP_PRN_BUTTON_ACTION", 0);
            if (i3 == 0) {
                rawbtPrintJob.add(new CommandParcelable(this.f11235c, Constant.RAWBT_CONTENT_TYPE.prn));
                RawbtHelper.prepareJob(rawbtPrintJob, this);
            } else if (i3 == 1) {
                if (this.f11248p == null) {
                    return;
                }
                CommandImageInBase64 commandImageInBase64 = new CommandImageInBase64();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                this.f11248p.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                commandImageInBase64.setBase64(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                AttributesImage attributesImage = new AttributesImage();
                attributesImage.setGraphicFilter(0);
                commandImageInBase64.setAttributesImage(attributesImage);
                rawbtPrintJob.add(commandImageInBase64);
            }
            this.f11243k.printRawbtPrintJob(rawbtPrintJob.GSON());
        } catch (Exception e3) {
            RawPrinterApp.r(e3.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(ViewActivity viewActivity, String str) {
        Toast.makeText(viewActivity, String.format(getString(R.string.save_as_mask), str), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(final ViewActivity viewActivity) {
        final String strSaveToGallery = new Saver(viewActivity).saveToGallery(this.f11248p);
        if (strSaveToGallery != null) {
            this.f11247o.post(new Runnable() { // from class: p2.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10522a.R(viewActivity, strSaveToGallery);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(ViewActivity viewActivity, ProgressDialog progressDialog) {
        try {
            File file = new File(viewActivity.getCacheDir(), "share");
            file.mkdir();
            File file2 = new File(file.getPath(), "preview_prn.png");
            Bitmap bitmap = ((BitmapDrawable) this.f11236d.getDrawable()).getBitmap();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Uri uriH = FileProvider.h(viewActivity, "ru.a402d.rawbtprinter.fileprovider", file2);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uriH);
            intent.setType("image/png");
            startActivity(intent);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        progressDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(ViewActivity viewActivity, ProgressDialog progressDialog) {
        try {
            File file = new File(viewActivity.getCacheDir(), "share");
            file.mkdir();
            File file2 = new File(file.getPath(), "hex_log.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(this.f11240h.getText().toString());
            outputStreamWriter.close();
            fileOutputStream.close();
            Uri uriH = FileProvider.h(viewActivity, "ru.a402d.rawbtprinter.fileprovider", file2);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uriH);
            intent.setType("text/plain");
            startActivity(intent);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        progressDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(ViewActivity viewActivity, ProgressDialog progressDialog) {
        try {
            File file = new File(viewActivity.getCacheDir(), "share");
            file.mkdir();
            File file2 = new File(file.getPath(), "parse_log.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(this.f11241i.getText().toString());
            outputStreamWriter.close();
            fileOutputStream.close();
            Uri uriH = FileProvider.h(viewActivity, "ru.a402d.rawbtprinter.fileprovider", file2);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uriH);
            intent.setType("text/plain");
            startActivity(intent);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        progressDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(RadioGroup radioGroup, int i3) {
        if (i3 == R.id.prnBtnActionPrintPrn) {
            c0(0);
        } else if (i3 == R.id.prnBtnActionPrintImage) {
            c0(1);
        }
        L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(DialogInterface dialogInterface, int i3) {
        requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(AlertDialog alertDialog, DialogInterface dialogInterface) {
        Button button = alertDialog.getButton(-1);
        button.setFocusable(true);
        button.setFocusableInTouchMode(true);
        button.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(Context context) {
        PrinterEntity byId = RawPrinterApp.h().D().getById(1);
        byId.initEncoding(context);
        final Bitmap bitmapCall = new PreviewTask(this.f11245m, this.f11235c, byId.getDots_per_line(), byId.getEncoding().getEncoding(), byId.isAddFrame(), context, RawPrinterApp.l()).call();
        this.f11247o.post(new Runnable() { // from class: p2.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f10520a.Z(bitmapCall);
            }
        });
    }

    private void b0() {
        if (this.f11235c == null) {
            return;
        }
        this.f11236d.setImageResource(R.mipmap.ic_wait);
        this.f11239g.setProgress(0);
        this.f11239g.setVisibility(0);
        this.f11241i.setText("");
        this.f11240h.setText("");
        this.f11246n.execute(new Runnable() { // from class: p2.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f10525a.a0(this);
            }
        });
    }

    private void c0(int i3) {
        if (i3 == this.f11233a.getInt("APP_PRN_BUTTON_ACTION", 0)) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = this.f11233a.edit();
            editorEdit.putInt("APP_PRN_BUTTON_ACTION", i3);
            editorEdit.apply();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(int i3) {
        if (i3 == 1) {
            this.f11242j = 1;
            this.f11237e.setVisibility(0);
            this.f11238f.setVisibility(8);
            this.f11236d.setVisibility(8);
            return;
        }
        if (i3 != 2) {
            this.f11242j = 0;
            this.f11236d.setVisibility(0);
            this.f11237e.setVisibility(8);
            this.f11238f.setVisibility(8);
            return;
        }
        this.f11242j = 2;
        this.f11238f.setVisibility(0);
        this.f11237e.setVisibility(8);
        this.f11236d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        d();
    }

    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public void Z(Bitmap bitmap) {
        this.f11239g.setVisibility(8);
        this.f11248p = bitmap;
        this.f11236d.setImageBitmap(bitmap);
    }

    @Override // r2.X2
    public void b() {
        Toast.makeText(this, getString(R.string.btnTxtPrint), 0).show();
        this.f11246n.execute(new Runnable() { // from class: p2.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f10533a.Q();
            }
        });
    }

    @Override // r2.W2
    public void d() {
        try {
            this.f11234b.a("*/*");
        } catch (Exception unused) {
            Toast.makeText(this, R.string.need_external_fm, 1).show();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_prnview);
        if (this.f11243k == null) {
            bindService(RawbtApiHelper.createExplicitIntent(), this.f11244l, 1);
        }
        this.f11233a = getPreferences(0);
        AbstractC0245a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.s(true);
        }
        this.f11236d = (PhotoView) findViewById(R.id.photo_view);
        this.f11237e = (ScrollView) findViewById(R.id.tab_hex_view);
        this.f11238f = (ScrollView) findViewById(R.id.tab_log_view);
        ((TabLayout) findViewById(R.id.tab_layout)).h(new b());
        this.f11239g = (ProgressBar) findViewById(R.id.task_progress_bar);
        this.f11240h = (TextView) findViewById(R.id.hex_view);
        this.f11241i = (TextView) findViewById(R.id.log_view);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.bottom_sheet);
        BottomSheetBehavior.q0(constraintLayout).O0((int) ((getResources().getDisplayMetrics().densityDpi / 160.0f) * 52.0f));
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        layoutParams.height = (int) ((getResources().getDisplayMetrics().densityDpi / 160.0f) * 300.0f);
        constraintLayout.setLayoutParams(layoutParams);
        Button button = (Button) findViewById(R.id.btnPrnPrint);
        button.setOnClickListener(new View.OnClickListener() { // from class: p2.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10527a.lambda$onCreate$0(view);
            }
        });
        button.requestFocus();
        ((Button) findViewById(R.id.btnPrnSelect)).setOnClickListener(new View.OnClickListener() { // from class: p2.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10528a.lambda$onCreate$1(view);
            }
        });
        ((RadioGroup) findViewById(R.id.btnPrnActionSelect)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: p2.l
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i3) {
                this.f10529a.W(radioGroup, i3);
            }
        });
        if (bundle == null) {
            P(getIntent());
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_prnview, menu);
        AbstractC0323v.a(menu, true);
        return true;
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onDestroy() {
        if (this.f11243k != null) {
            unbindService(this.f11244l);
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            int id = currentFocus.getId();
            if (id == R.id.prnBtnActionPrintPrn && i3 == 19) {
                BottomSheetBehavior.q0(findViewById(R.id.bottom_sheet)).T0(4);
                findViewById(R.id.btnPrnPrint).requestFocus();
                return true;
            }
            if ((id == R.id.btnPrnPrint || id == R.id.btnPrnSelect) && i3 == 20) {
                BottomSheetBehavior.q0(findViewById(R.id.bottom_sheet)).T0(3);
                findViewById(R.id.prnBtnActionPrintPrn).requestFocus();
                return true;
            }
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i3, KeyEvent keyEvent) {
        if ((keyEvent.getMetaState() & 8192) != 0) {
            if (i3 == 44) {
                b();
                return true;
            }
            if (i3 == 43) {
                d();
                return true;
            }
        }
        return super.onKeyShortcut(i3, keyEvent);
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        P(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        try {
            int itemId = menuItem.getItemId();
            if (itemId == 16908332) {
                finish();
                return true;
            }
            if (itemId == R.id.action_prn_open) {
                d();
            } else if (itemId == R.id.action_settings) {
                Intent intent = new Intent(this, (Class<?>) EditPrinterActivity.class);
                intent.putExtra("id", 1);
                startActivity(intent);
            } else if (itemId == R.id.action_share) {
                O();
            } else if (itemId == R.id.action_save_into_gallery) {
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 29) {
                    N();
                } else if (i3 >= 23) {
                    if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                        N();
                    } else {
                        final AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(R.string.required_permissions).setMessage(getString(R.string.faq_WRITE_EXTERNAL_STORAGE)).setPositiveButton(getString(R.string.btn_grant), new DialogInterface.OnClickListener() { // from class: p2.n
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i4) {
                                this.f10531a.X(dialogInterface, i4);
                            }
                        }).setNegativeButton(getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).create();
                        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: p2.o
                            @Override // android.content.DialogInterface.OnShowListener
                            public final void onShow(DialogInterface dialogInterface) {
                                ViewActivity.Y(alertDialogCreate, dialogInterface);
                            }
                        });
                        alertDialogCreate.show();
                    }
                }
            } else {
                if (itemId == R.id.menu_scale_fit_center) {
                    this.f11236d.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    return true;
                }
                if (itemId == R.id.menu_scale_scale_center) {
                    this.f11236d.setScaleType(ImageView.ScaleType.CENTER);
                    return true;
                }
                if (itemId == R.id.menu_scale_scale_center_crop) {
                    this.f11236d.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    return true;
                }
                if (itemId == R.id.menu_scale_scale_center_inside) {
                    this.f11236d.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    return true;
                }
            }
            return super.onOptionsItemSelected(menuItem);
        } catch (Exception e3) {
            RawPrinterApp.r(e3.getLocalizedMessage());
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onResume() {
        super.onResume();
        L();
    }
}
