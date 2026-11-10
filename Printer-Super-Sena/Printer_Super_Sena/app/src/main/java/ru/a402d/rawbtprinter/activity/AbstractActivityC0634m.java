package ru.a402d.rawbtprinter.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import androidx.appcompat.app.AbstractActivityC0248d;
import androidx.lifecycle.P;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: ru.a402d.rawbtprinter.activity.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractActivityC0634m extends AbstractActivityC0248d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ExecutorService f11569a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Handler f11570b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    w2.D f11571c;

    private void s() {
        int intExtra = getIntent().getIntExtra("id", 0);
        if (intExtra > 0) {
            this.f11571c.v0(intExtra);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11571c = (w2.D) new P(this).a(w2.D.class);
        if (bundle == null) {
            s();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
