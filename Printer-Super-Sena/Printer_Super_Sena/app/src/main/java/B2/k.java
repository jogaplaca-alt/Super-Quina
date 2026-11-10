package B2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;
import java.util.Objects;
import rawbt.api.RawbtApiHelper;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.activity.PrintDownloadActivity;
import ru.a402d.rawbtprinter.activity.PrintRawBtActivity;

/* JADX INFO: loaded from: classes.dex */
public abstract class k extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final WebView f109b;

    protected k(Activity activity, WebView webView) {
        this.f108a = activity;
        this.f109b = webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String str, DialogInterface dialogInterface, int i3) {
        Intent intent = new Intent(this.f108a, (Class<?>) PrintDownloadActivity.class);
        intent.setData(Uri.parse(str));
        this.f108a.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(String str, DialogInterface dialogInterface, int i3) {
        this.f109b.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Uri uri, DialogInterface dialogInterface, int i3) {
        PackageManager packageManager = this.f108a.getPackageManager();
        Intent data = new Intent("android.intent.action.VIEW").setData(uri);
        Intent intentCreateChooser = Intent.createChooser(data, this.f108a.getString(R.string.open_url));
        if (data.resolveActivity(packageManager) != null) {
            this.f108a.startActivity(intentCreateChooser);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(AlertDialog alertDialog, DialogInterface dialogInterface) {
        try {
            Button button = alertDialog.getButton(-1);
            button.setFocusable(true);
            button.setFocusableInTouchMode(true);
            button.requestFocus();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i3, String str, String str2) {
        Toast.makeText(this.f108a, str, 0).show();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, final String str) {
        Activity activity = this.f108a;
        if (activity != null && !activity.isFinishing()) {
            if (str.startsWith("rawbt:")) {
                Intent intent = new Intent(this.f108a, (Class<?>) PrintRawBtActivity.class);
                intent.setData(Uri.parse(str));
                this.f108a.startActivity(intent);
                return true;
            }
            if (!str.endsWith(".txt") && !str.endsWith(".pdf") && !str.endsWith(".png") && !str.endsWith(".jpg") && !str.endsWith(".jpeg") && !str.endsWith(".webp") && !str.endsWith(".prn")) {
                if (str.startsWith("intent:")) {
                    try {
                        Intent uri = Intent.parseUri(str, 1);
                        if (uri.resolveActivity(this.f108a.getPackageManager()) != null) {
                            String str2 = uri.getPackage();
                            Objects.requireNonNull(str2);
                            if (!str2.equals(RawbtApiHelper.SERVICE_PACKAGE)) {
                                uri.addCategory("android.intent.category.BROWSABLE");
                                uri.setComponent(null);
                                uri.setSelector(null);
                            }
                            this.f108a.startActivity(uri);
                            return true;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                final Uri uri2 = Uri.parse(str);
                final AlertDialog alertDialogCreate = new AlertDialog.Builder(this.f108a).setIcon(R.mipmap.alert).setTitle(this.f108a.getString(R.string.open_url)).setMessage(str).setNegativeButton(this.f108a.getString(R.string.btn_no), (DialogInterface.OnClickListener) null).setPositiveButton(this.f108a.getString(R.string.btn_yes), new DialogInterface.OnClickListener() { // from class: B2.h
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.f103a.f(str, dialogInterface, i3);
                    }
                }).create();
                alertDialogCreate.setButton(-3, this.f108a.getString(R.string.reSelectTxt), new DialogInterface.OnClickListener() { // from class: B2.i
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.f105a.g(uri2, dialogInterface, i3);
                    }
                });
                alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: B2.j
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        k.h(alertDialogCreate, dialogInterface);
                    }
                });
                alertDialogCreate.show();
                return true;
            }
            new AlertDialog.Builder(this.f108a).setIcon(R.mipmap.ic_launcher).setTitle("DOWNLOAD & PRINT").setMessage(str).setNegativeButton(R.string.dialog_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.btnTxtPrint, new DialogInterface.OnClickListener() { // from class: B2.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f101a.e(str, dialogInterface, i3);
                }
            }).show();
        }
        return true;
    }
}
