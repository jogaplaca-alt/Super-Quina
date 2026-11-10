package u2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;
import androidx.core.view.AbstractC0323v;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import r2.W2;
import r2.X2;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.command.CommandString;
import rawbt.sdk.RawbtPrintJob;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;
import ru.a402d.rawbtprinter.activity.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public class E extends AbstractComponentCallbacksC0337e implements SwipeRefreshLayout.j, X2, W2 {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    y2.b f11984d0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private Parcelable f11989i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private ProgressBar f11990j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private SwipeRefreshLayout f11991k0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    final ExecutorService f11982b0 = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    final Handler f11983c0 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final p004b.c f11985e0 = p1(new p008c.b(), new p004b.b() { // from class: u2.w
        @Override // p004b.b
        public final void onActivityResult(Object obj) throws Throwable {
            this.f12324a.e2((Uri) obj);
        }
    });

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private c f11986f0 = c.url;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private String f11987g0 = null;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private String f11988h0 = "";

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private boolean f11992l0 = false;

    class a extends WebChromeClient {
        a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            E.this.f11990j0.setProgress(i3);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (str.startsWith("data:")) {
                        E.this.r1().setTitle("In-APP browser");
                    } else {
                        E.this.r1().setTitle(str);
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    class b extends B2.k {
        b(Activity activity, WebView webView) {
            super(activity, webView);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            E.this.f11990j0.setVisibility(8);
            if (E.this.f11991k0 == null) {
                return;
            }
            E.this.f11991k0.setRefreshing(false);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            E.this.f11990j0.setVisibility(0);
        }

        @Override // B2.k, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String host;
            if (E.this.f11987g0 != null && (host = Uri.parse(E.this.f11987g0).getHost()) != null && host.length() > 1 && Objects.equals(Uri.parse(str).getHost(), Uri.parse(E.this.f11987g0).getHost())) {
                this.f109b.loadUrl(str);
                return true;
            }
            if (!E.this.f11984d0.k0() || str.startsWith("rawbt:") || str.startsWith("intent:")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            this.f109b.loadUrl(str);
            return true;
        }
    }

    enum c {
        url,
        content,
        html
    }

    private void c2(WebView webView) {
        try {
            PrintManager printManager = (PrintManager) s1().getSystemService(CommandString.TAG);
            PrintDocumentAdapter printDocumentAdapterCreatePrintDocumentAdapter = webView.createPrintDocumentAdapter();
            if (printDocumentAdapterCreatePrintDocumentAdapter == null) {
                Toast.makeText(r1(), "WebView not supported print adapter", 0).show();
            } else if (printManager != null) {
                printManager.print("Html2Print", printDocumentAdapterCreatePrintDocumentAdapter, new PrintAttributes.Builder().setMinMargins(new PrintAttributes.Margins(250, 250, 250, 250)).build());
            } else {
                Toast.makeText(r1(), "Print manager not present", 0).show();
            }
        } catch (Exception e3) {
            Toast.makeText(r1(), R.string.Oopppsss, 0).show();
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2(Uri uri) throws Throwable {
        if (uri == null) {
            return;
        }
        WebView webView = (WebView) t1().findViewById(R.id.web_view);
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    InputStream inputStreamOpenInputStream = r1().getContentResolver().openInputStream(uri);
                    Objects.requireNonNull(inputStreamOpenInputStream);
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStreamOpenInputStream));
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            } else {
                                sb.append(line);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            bufferedReader = bufferedReader2;
                            sb.append(e.getLocalizedMessage());
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            webView.loadData(sb.toString(), "text/html; charset=utf-8", "utf-8");
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            } catch (Exception e6) {
                e = e6;
            }
            webView.loadData(sb.toString(), "text/html; charset=utf-8", "utf-8");
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f2(ViewStub viewStub) throws Throwable {
        if (Build.VERSION.SDK_INT >= 21) {
            WebView.enableSlowWholeDocumentDraw();
        }
        if (!this.f11992l0) {
            viewStub.inflate();
        }
        this.f11992l0 = true;
        r2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g2(SeekBar seekBar, WebView webView, DialogInterface dialogInterface, int i3) {
        webView.getSettings().setDefaultFontSize((int) (((webView.getSettings().getDefaultFontSize() * 1.0f) * (seekBar.getProgress() + 3)) / 4.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h2(AlertDialog alertDialog, DialogInterface dialogInterface) {
        Button button = alertDialog.getButton(-2);
        button.setFocusable(true);
        button.setFocusableInTouchMode(true);
        button.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2(EditText editText, WebView webView, DialogInterface dialogInterface, int i3) {
        String string = editText.getText().toString();
        this.f11987g0 = string;
        webView.loadUrl(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k2(AlertDialog alertDialog, final EditText editText, DialogInterface dialogInterface) {
        alertDialog.getButton(-3).setOnClickListener(new View.OnClickListener() { // from class: u2.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                editText.setText("");
            }
        });
        Button button = alertDialog.getButton(-2);
        button.setFocusable(true);
        button.setFocusableInTouchMode(true);
        button.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(boolean z3, File file) {
        try {
            if (z3) {
                ((MainActivity) r1()).E(Uri.fromFile(file), false);
            } else {
                AttributesImage attributesImage = new AttributesImage();
                attributesImage.setGraphicFilter(this.f11984d0.t());
                RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
                rawbtPrintJob.setIdJob(UUID.randomUUID().toString());
                ((MainActivity) r1()).h0(rawbtPrintJob.getIdJob(), rawbtPrintJob.getPrinter());
                rawbtPrintJob.setPremium(true);
                rawbtPrintJob.image(Uri.fromFile(file), attributesImage);
                try {
                    ((MainActivity) r1()).f11399o.printRawbtPrintJob(rawbtPrintJob.GSON());
                } catch (Exception e3) {
                    Toast.makeText(r1(), e3.getLocalizedMessage(), 0).show();
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        u2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m2(Bitmap bitmap, final boolean z3) {
        if (bitmap != null) {
            Context contextG = RawPrinterApp.g();
            Objects.requireNonNull(contextG);
            final File file = new File(contextG.getCacheDir().toString(), "/screenshot.png");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
                    fileOutputStream.flush();
                    this.f11983c0.post(new Runnable() { // from class: u2.B
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11966a.l2(z3, file);
                        }
                    });
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Exception unused) {
            }
            bitmap.recycle();
        }
    }

    public static E n2(String str) {
        E e3 = new E();
        e3.f11986f0 = c.html;
        e3.f11988h0 = str;
        return e3;
    }

    public static E o2(Uri uri) {
        E e3 = new E();
        e3.f11986f0 = c.content;
        e3.f11989i0 = uri;
        return e3;
    }

    public static E p2(String str) {
        E e3 = new E();
        e3.f11986f0 = c.url;
        e3.f11987g0 = str;
        return e3;
    }

    private void r2() throws Throwable {
        u2(false);
        try {
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) t1().findViewById(R.id.swipe);
            this.f11991k0 = swipeRefreshLayout;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setOnRefreshListener(this);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            WebView webView = (WebView) t1().findViewById(R.id.web_view);
            if (this.f11992l0 && webView != null) {
                t2(webView);
                int iOrdinal = this.f11986f0.ordinal();
                if (iOrdinal == 0) {
                    webView.loadUrl(this.f11987g0);
                } else if (iOrdinal == 1) {
                    e2((Uri) this.f11989i0);
                } else if (iOrdinal == 2) {
                    webView.loadData(this.f11988h0, "text/html; charset=utf-8", "utf-8");
                }
                webView.requestFocus();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void s2(final boolean z3) {
        WebView webView = (WebView) t1().findViewById(R.id.web_view);
        u2(true);
        try {
            float fO = this.f11984d0.o();
            final Bitmap bitmapA = B2.m.a(webView, fO, (((webView.getContentHeight() * B2.m.b(r1())) * 1.0f) * fO) / B2.m.c(r1()));
            this.f11982b0.execute(new Runnable() { // from class: u2.x
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12327a.m2(bitmapA, z3);
                }
            });
        } catch (Exception e3) {
            u2(false);
            RawPrinterApp.r(e3.getClass().getSimpleName());
            e3.printStackTrace();
        }
    }

    private void t2(WebView webView) {
        webView.setLayerType(1, null);
        webView.setDrawingCacheEnabled(true);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            settings.setSafeBrowsingEnabled(true);
        }
        webView.setWebChromeClient(new a());
        webView.setWebViewClient(new b(m(), webView));
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public boolean D0(MenuItem menuItem) {
        final WebView webView = (WebView) t1().findViewById(R.id.web_view);
        int itemId = menuItem.getItemId();
        if (!this.f11992l0 || webView == null) {
            return super.D0(menuItem);
        }
        if (itemId == R.id.texttoprint) {
            c2(webView);
            return true;
        }
        if (itemId == R.id.reload_url) {
            webView.reload();
            return true;
        }
        if (itemId == R.id.restore_default_url) {
            this.f11987g0 = "file:///android_asset/app/index.html";
            this.f11984d0.U0("file:///android_asset/app/index.html");
            webView.loadUrl(this.f11987g0);
            return true;
        }
        if (itemId == R.id.set_default_url) {
            String url = webView.getUrl();
            this.f11987g0 = url;
            this.f11984d0.U0(url);
            return true;
        }
        if (itemId == R.id.webscreenshot) {
            s2(false);
            return true;
        }
        if (itemId == R.id.web_screenshot_preview) {
            s2(true);
            return true;
        }
        if (itemId == R.id.back_url) {
            return d2();
        }
        if (itemId == R.id.change_font_size) {
            final SeekBar seekBar = new SeekBar(t());
            seekBar.setMax(2);
            seekBar.setProgress(1);
            seekBar.setPadding(16, 32, 16, 8);
            final AlertDialog alertDialogCreate = new AlertDialog.Builder(m()).setTitle(R.string.change_font_size).setView(seekBar).setPositiveButton(S(R.string.reSelectTxt), new DialogInterface.OnClickListener() { // from class: u2.z
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    E.g2(seekBar, webView, dialogInterface, i3);
                }
            }).setNegativeButton(S(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).create();
            alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: u2.A
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    E.h2(alertDialogCreate, dialogInterface);
                }
            });
            alertDialogCreate.show();
        } else if (itemId == R.id.open_url) {
            q2();
        }
        return super.D0(menuItem);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void F0() {
        u2(false);
        super.F0();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void L0(Bundle bundle) {
        super.L0(bundle);
        WebView webView = (WebView) t1().findViewById(R.id.web_view);
        if (webView != null) {
            this.f11987g0 = webView.getUrl();
        }
        bundle.putString("url", this.f11987g0);
        bundle.putString("html", this.f11988h0);
        bundle.putParcelable("uri", this.f11989i0);
        bundle.putSerializable("mode", this.f11986f0);
    }

    @Override // r2.X2
    public void b() {
        s2(false);
    }

    @Override // r2.W2
    public void d() {
        try {
            this.f11985e0.a("text/html");
        } catch (Exception unused) {
            Toast.makeText(m(), R.string.need_external_fm, 1).show();
        }
    }

    public boolean d2() {
        WebView webView = (WebView) t1().findViewById(R.id.web_view);
        if (!this.f11992l0 || webView == null || !webView.canGoBack()) {
            return true;
        }
        webView.goBack();
        return false;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void f() {
        SwipeRefreshLayout swipeRefreshLayout;
        if (!this.f11992l0 || (swipeRefreshLayout = this.f11991k0) == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(true);
        this.f11990j0.setVisibility(0);
        ((WebView) t1().findViewById(R.id.web_view)).reload();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void p0(Bundle bundle) {
        super.p0(bundle);
        if (bundle != null) {
            this.f11987g0 = bundle.getString("url");
            this.f11988h0 = bundle.getString("html");
            this.f11989i0 = bundle.getParcelable("uri");
            this.f11986f0 = (c) bundle.get("mode");
        }
        y2.b bVarW = y2.b.w();
        this.f11984d0 = bVarW;
        if (this.f11986f0 == c.url && this.f11987g0 == null) {
            this.f11987g0 = bVarW.R();
        }
    }

    public void q2() {
        final WebView webView = (WebView) t1().findViewById(R.id.web_view);
        this.f11987g0 = webView.getUrl();
        final EditText editText = new EditText(t());
        editText.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        editText.setText(this.f11987g0);
        editText.setInputType(16);
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(m()).setTitle(S(R.string.open_url)).setView(editText).setPositiveButton(S(R.string.install_dialog_btn), new DialogInterface.OnClickListener() { // from class: u2.C
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f11973a.i2(editText, webView, dialogInterface, i3);
            }
        }).setNegativeButton(S(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).setNeutralButton(S(R.string.clear_text), (DialogInterface.OnClickListener) null).create();
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: u2.D
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                E.k2(alertDialogCreate, editText, dialogInterface);
            }
        });
        alertDialogCreate.show();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void s0(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.browser, menu);
        AbstractC0323v.a(menu, true);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (viewGroup == null) {
            return null;
        }
        C1(true);
        View viewInflate = layoutInflater.inflate(R.layout.fragment_browser, viewGroup, false);
        this.f11990j0 = (ProgressBar) viewInflate.findViewById(R.id.pb_print_web_page_progress_bar);
        u2(true);
        final ViewStub viewStub = (ViewStub) viewInflate.findViewById(R.id.webview_stub);
        this.f11983c0.postDelayed(new Runnable() { // from class: u2.y
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f12332a.f2(viewStub);
            }
        }, 1000L);
        return viewInflate;
    }

    public void u2(boolean z3) {
        View viewU = U();
        if (viewU == null) {
            return;
        }
        viewU.findViewById(R.id.splash).setVisibility(z3 ? 0 : 4);
    }
}
