package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.t0;
import androidx.fragment.app.AbstractActivityC0338f;
import androidx.lifecycle.V;
import androidx.lifecycle.W;

/* JADX INFO: renamed from: androidx.appcompat.app.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractActivityC0248d extends AbstractActivityC0338f implements InterfaceC0249e, androidx.core.app.s.a, C0246b.c {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AbstractC0251g mDelegate;
    private Resources mResources;

    /* JADX INFO: renamed from: androidx.appcompat.app.d$a */
    class a implements Y.d.c {
        a() {
        }

        @Override // Y.d.c
        public Bundle a() {
            Bundle bundle = new Bundle();
            AbstractActivityC0248d.this.getDelegate().C(bundle);
            return bundle;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.d$b */
    class b implements p000a.b {
        b() {
        }

        @Override // p000a.b
        public void a(Context context) {
            AbstractC0251g delegate = AbstractActivityC0248d.this.getDelegate();
            delegate.t();
            delegate.y(AbstractActivityC0248d.this.getSavedStateRegistry().b(AbstractActivityC0248d.DELEGATE_TAG));
        }
    }

    public AbstractActivityC0248d() {
        p();
    }

    private void p() {
        getSavedStateRegistry().h(DELEGATE_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private void q() {
        V.a(getWindow().getDecorView(), this);
        W.a(getWindow().getDecorView(), this);
        Y.g.a(getWindow().getDecorView(), this);
        androidx.activity.w.a(getWindow().getDecorView(), this);
    }

    private boolean r(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // androidx.activity.h, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        q();
        getDelegate().e(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().g(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        AbstractC0245a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.f, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        AbstractC0245a supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.p(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i3) {
        return (T) getDelegate().j(i3);
    }

    public AbstractC0251g getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = AbstractC0251g.h(this, this);
        }
        return this.mDelegate;
    }

    @Override // androidx.appcompat.app.C0246b.c
    public C0246b.InterfaceC0041b getDrawerToggleDelegate() {
        return getDelegate().n();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return getDelegate().q();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.mResources == null && t0.c()) {
            this.mResources = new t0(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public AbstractC0245a getSupportActionBar() {
        return getDelegate().s();
    }

    @Override // androidx.core.app.s.a
    public Intent getSupportParentActivityIntent() {
        return androidx.core.app.h.a(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().u();
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getDelegate().x(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(androidx.core.app.s sVar) {
        sVar.k(this);
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        getDelegate().z();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (r(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    protected void onLocalesChanged(androidx.core.os.j jVar) {
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        if (super.onMenuItemSelected(i3, menuItem)) {
            return true;
        }
        AbstractC0245a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.j() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i3, Menu menu) {
        return super.onMenuOpened(i3, menu);
    }

    protected void onNightModeChanged(int i3) {
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        super.onPanelClosed(i3, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().A(bundle);
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        getDelegate().B();
    }

    public void onPrepareSupportNavigateUpTaskStack(androidx.core.app.s sVar) {
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onStart() {
        super.onStart();
        getDelegate().D();
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onStop() {
        super.onStop();
        getDelegate().E();
    }

    @Override // androidx.appcompat.app.InterfaceC0249e
    public void onSupportActionModeFinished(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.InterfaceC0249e
    public void onSupportActionModeStarted(androidx.appcompat.view.b bVar) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (!supportShouldUpRecreateTask(supportParentActivityIntent)) {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
        androidx.core.app.s sVarM = androidx.core.app.s.m(this);
        onCreateSupportNavigateUpTaskStack(sVarM);
        onPrepareSupportNavigateUpTaskStack(sVarM);
        sVarM.n();
        try {
            androidx.core.app.b.l(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i3) {
        super.onTitleChanged(charSequence, i3);
        getDelegate().O(charSequence);
    }

    @Override // androidx.appcompat.app.InterfaceC0249e
    public androidx.appcompat.view.b onWindowStartingSupportActionMode(androidx.appcompat.view.b.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        AbstractC0245a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.q()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.h, android.app.Activity
    public void setContentView(int i3) {
        q();
        getDelegate().I(i3);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().M(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i3) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z3) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z3) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z3) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        super.setTheme(i3);
        getDelegate().N(i3);
    }

    public androidx.appcompat.view.b startSupportActionMode(androidx.appcompat.view.b.a aVar) {
        return getDelegate().P(aVar);
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f
    public void supportInvalidateOptionsMenu() {
        getDelegate().u();
    }

    public void supportNavigateUpTo(Intent intent) {
        androidx.core.app.h.e(this, intent);
    }

    public boolean supportRequestWindowFeature(int i3) {
        return getDelegate().H(i3);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return androidx.core.app.h.f(this, intent);
    }

    @Override // androidx.activity.h, android.app.Activity
    public void setContentView(View view) {
        q();
        getDelegate().J(view);
    }

    @Override // androidx.activity.h, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        q();
        getDelegate().K(view, layoutParams);
    }
}
