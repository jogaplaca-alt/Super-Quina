package com.theartofdev.edmodo.cropper;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AbstractActivityC0248d;
import androidx.appcompat.app.AbstractC0245a;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class CropImageActivity extends AbstractActivityC0248d implements CropImageView.i, CropImageView.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CropImageView f8836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Uri f8837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f8838c;

    private void y(Menu menu, int i3, int i4) {
        Drawable icon;
        MenuItem menuItemFindItem = menu.findItem(i3);
        if (menuItemFindItem == null || (icon = menuItemFindItem.getIcon()) == null) {
            return;
        }
        try {
            icon.mutate();
            icon.setColorFilter(i4, PorterDuff.Mode.SRC_ATOP);
            menuItemFindItem.setIcon(icon);
        } catch (Exception e3) {
            Log.w("AIC", "Failed to update menu item color", e3);
        }
    }

    @Override // com.theartofdev.edmodo.cropper.CropImageView.e
    public void a(CropImageView cropImageView, CropImageView.b bVar) {
        w(bVar.i(), bVar.e(), bVar.h());
    }

    @Override // com.theartofdev.edmodo.cropper.CropImageView.i
    public void e(CropImageView cropImageView, Uri uri, Exception exc) {
        if (exc != null) {
            w(null, exc, 1);
            return;
        }
        Rect rect = this.f8838c.f9002M;
        if (rect != null) {
            this.f8836a.setCropRect(rect);
        }
        int i3 = this.f8838c.f9003N;
        if (i3 > -1) {
            this.f8836a.setRotatedDegrees(i3);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        if (i3 == 200) {
            if (i4 == 0) {
                x();
            }
            if (i4 == -1) {
                Uri uriH = d.h(this, intent);
                this.f8837b = uriH;
                if (d.k(this, uriH)) {
                    requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
                } else {
                    this.f8836a.setImageUriAsync(this.f8837b);
                }
            }
        }
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        x();
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        CharSequence charSequence;
        super.onCreate(bundle);
        setContentView(H1.d.f1093a);
        this.f8836a = (CropImageView) findViewById(H1.c.f1086d);
        Bundle bundleExtra = getIntent().getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE");
        this.f8837b = (Uri) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_SOURCE");
        this.f8838c = (f) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
        if (bundle == null) {
            Uri uri = this.f8837b;
            if (uri == null || uri.equals(Uri.EMPTY)) {
                if (d.j(this)) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, 2011);
                } else {
                    d.m(this);
                }
            } else if (d.k(this, this.f8837b)) {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
            } else {
                this.f8836a.setImageUriAsync(this.f8837b);
            }
        }
        AbstractC0245a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            f fVar = this.f8838c;
            supportActionBar.x((fVar == null || (charSequence = fVar.f8993D) == null || charSequence.length() <= 0) ? getResources().getString(H1.f.f1097b) : this.f8838c.f8993D);
            supportActionBar.s(true);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(H1.e.f1095a, menu);
        f fVar = this.f8838c;
        if (!fVar.f9004O) {
            menu.removeItem(H1.c.f1091i);
            menu.removeItem(H1.c.f1092j);
        } else if (fVar.f9006Q) {
            menu.findItem(H1.c.f1091i).setVisible(true);
        }
        if (!this.f8838c.f9005P) {
            menu.removeItem(H1.c.f1088f);
        }
        if (this.f8838c.f9010U != null) {
            menu.findItem(H1.c.f1087e).setTitle(this.f8838c.f9010U);
        }
        Drawable drawableD = null;
        try {
            int i3 = this.f8838c.f9011V;
            if (i3 != 0) {
                drawableD = androidx.core.content.a.d(this, i3);
                menu.findItem(H1.c.f1087e).setIcon(drawableD);
            }
        } catch (Exception e3) {
            Log.w("AIC", "Failed to read menu crop drawable", e3);
        }
        int i4 = this.f8838c.f8994E;
        if (i4 != 0) {
            y(menu, H1.c.f1091i, i4);
            y(menu, H1.c.f1092j, this.f8838c.f8994E);
            y(menu, H1.c.f1088f, this.f8838c.f8994E);
            if (drawableD != null) {
                y(menu, H1.c.f1087e, this.f8838c.f8994E);
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == H1.c.f1087e) {
            s();
            return true;
        }
        if (menuItem.getItemId() == H1.c.f1091i) {
            v(-this.f8838c.f9007R);
            return true;
        }
        if (menuItem.getItemId() == H1.c.f1092j) {
            v(this.f8838c.f9007R);
            return true;
        }
        if (menuItem.getItemId() == H1.c.f1089g) {
            this.f8836a.f();
            return true;
        }
        if (menuItem.getItemId() == H1.c.f1090h) {
            this.f8836a.g();
            return true;
        }
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        x();
        return true;
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        if (i3 == 201) {
            Uri uri = this.f8837b;
            if (uri == null || iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, H1.f.f1096a, 1).show();
                x();
            } else {
                this.f8836a.setImageUriAsync(uri);
            }
        }
        if (i3 == 2011) {
            d.m(this);
        }
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f8836a.setOnSetImageUriCompleteListener(this);
        this.f8836a.setOnCropImageCompleteListener(this);
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f8836a.setOnSetImageUriCompleteListener(null);
        this.f8836a.setOnCropImageCompleteListener(null);
    }

    protected void s() {
        if (this.f8838c.f9001L) {
            w(null, null, 1);
            return;
        }
        Uri uriT = t();
        CropImageView cropImageView = this.f8836a;
        f fVar = this.f8838c;
        cropImageView.p(uriT, fVar.f8996G, fVar.f8997H, fVar.f8998I, fVar.f8999J, fVar.f9000K);
    }

    protected Uri t() {
        String str;
        Uri uri = this.f8838c.f8995F;
        if (uri != null && !uri.equals(Uri.EMPTY)) {
            return uri;
        }
        try {
            Bitmap.CompressFormat compressFormat = this.f8838c.f8996G;
            if (compressFormat == Bitmap.CompressFormat.JPEG) {
                str = ".jpg";
            } else {
                str = compressFormat == Bitmap.CompressFormat.PNG ? ".png" : ".webp";
            }
            return Uri.fromFile(File.createTempFile("cropped", str, getCacheDir()));
        } catch (IOException e3) {
            throw new RuntimeException("Failed to create temp file for output image", e3);
        }
    }

    protected Intent u(Uri uri, Exception exc, int i3) {
        d.c cVar = new d.c(this.f8836a.getImageUri(), uri, exc, this.f8836a.getCropPoints(), this.f8836a.getCropRect(), this.f8836a.getRotatedDegrees(), this.f8836a.getWholeImageRect(), i3);
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        intent.putExtra("CROP_IMAGE_EXTRA_RESULT", cVar);
        return intent;
    }

    protected void v(int i3) {
        this.f8836a.o(i3);
    }

    protected void w(Uri uri, Exception exc, int i3) {
        setResult(exc == null ? -1 : 204, u(uri, exc, i3));
        finish();
    }

    protected void x() {
        setResult(0);
        finish();
    }
}
