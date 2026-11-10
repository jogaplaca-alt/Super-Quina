package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.C0359q;
import androidx.lifecycle.T;
import androidx.lifecycle.U;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: renamed from: androidx.fragment.app.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractActivityC0338f extends androidx.activity.h implements androidx.core.app.b.d, androidx.core.app.b.e {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    boolean mResumed;
    final C0342j mFragments = C0342j.b(new c());
    final C0359q mFragmentLifecycleRegistry = new C0359q(this);
    boolean mStopped = true;

    /* JADX INFO: renamed from: androidx.fragment.app.f$a */
    class a implements Y.d.c {
        a() {
        }

        @Override // Y.d.c
        public Bundle a() {
            Bundle bundle = new Bundle();
            AbstractActivityC0338f.this.markFragmentsCreated();
            AbstractActivityC0338f.this.mFragmentLifecycleRegistry.h(AbstractC0354l.a.ON_STOP);
            Parcelable parcelableX = AbstractActivityC0338f.this.mFragments.x();
            if (parcelableX != null) {
                bundle.putParcelable(AbstractActivityC0338f.FRAGMENTS_TAG, parcelableX);
            }
            return bundle;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.f$b */
    class b implements p000a.b {
        b() {
        }

        @Override // p000a.b
        public void a(Context context) {
            AbstractActivityC0338f.this.mFragments.a(null);
            Bundle bundleB = AbstractActivityC0338f.this.getSavedStateRegistry().b(AbstractActivityC0338f.FRAGMENTS_TAG);
            if (bundleB != null) {
                AbstractActivityC0338f.this.mFragments.w(bundleB.getParcelable(AbstractActivityC0338f.FRAGMENTS_TAG));
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.f$c */
    class c extends l implements U, androidx.activity.t, p004b.e, s {
        public c() {
            super(AbstractActivityC0338f.this);
        }

        @Override // androidx.fragment.app.s
        public void a(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
            AbstractActivityC0338f.this.onAttachFragment(abstractComponentCallbacksC0337e);
        }

        @Override // androidx.fragment.app.AbstractC0340h
        public View c(int i3) {
            return AbstractActivityC0338f.this.findViewById(i3);
        }

        @Override // androidx.fragment.app.AbstractC0340h
        public boolean d() {
            Window window = AbstractActivityC0338f.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // p004b.e
        public p004b.d getActivityResultRegistry() {
            return AbstractActivityC0338f.this.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.InterfaceC0358p
        public AbstractC0354l getLifecycle() {
            return AbstractActivityC0338f.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.t
        public androidx.activity.r getOnBackPressedDispatcher() {
            return AbstractActivityC0338f.this.getOnBackPressedDispatcher();
        }

        @Override // androidx.lifecycle.U
        public T getViewModelStore() {
            return AbstractActivityC0338f.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.l
        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            AbstractActivityC0338f.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.l
        public LayoutInflater j() {
            return AbstractActivityC0338f.this.getLayoutInflater().cloneInContext(AbstractActivityC0338f.this);
        }

        @Override // androidx.fragment.app.l
        public boolean k(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
            return !AbstractActivityC0338f.this.isFinishing();
        }

        @Override // androidx.fragment.app.l
        public void n() {
            AbstractActivityC0338f.this.supportInvalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.l
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public AbstractActivityC0338f i() {
            return AbstractActivityC0338f.this;
        }
    }

    public AbstractActivityC0338f() {
        n();
    }

    private void n() {
        getSavedStateRegistry().h(FRAGMENTS_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private static boolean o(o oVar, AbstractC0354l.b bVar) {
        boolean zO = false;
        for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : oVar.p0()) {
            if (abstractComponentCallbacksC0337e != null) {
                if (abstractComponentCallbacksC0337e.B() != null) {
                    zO |= o(abstractComponentCallbacksC0337e.s(), bVar);
                }
                F f3 = abstractComponentCallbacksC0337e.f5177T;
                if (f3 != null && f3.getLifecycle().b().b(AbstractC0354l.b.STARTED)) {
                    abstractComponentCallbacksC0337e.f5177T.f(bVar);
                    zO = true;
                }
                if (abstractComponentCallbacksC0337e.f5176S.b().b(AbstractC0354l.b.STARTED)) {
                    abstractComponentCallbacksC0337e.f5176S.m(bVar);
                    zO = true;
                }
            }
        }
        return zO;
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.v(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.t().T(str, fileDescriptor, printWriter, strArr);
    }

    public o getSupportFragmentManager() {
        return this.mFragments.t();
    }

    @Deprecated
    public androidx.loader.app.a getSupportLoaderManager() {
        return androidx.loader.app.a.b(this);
    }

    void markFragmentsCreated() {
        while (o(getSupportFragmentManager(), AbstractC0354l.b.CREATED)) {
        }
    }

    @Override // androidx.activity.h, android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        this.mFragments.u();
        super.onActivityResult(i3, i4, intent);
    }

    @Deprecated
    public void onAttachFragment(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
    }

    @Override // androidx.activity.h, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.u();
        super.onConfigurationChanged(configuration);
        this.mFragments.d(configuration);
    }

    @Override // androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.h(AbstractC0354l.a.ON_CREATE);
        this.mFragments.f();
    }

    @Override // androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i3, Menu menu) {
        return i3 == 0 ? super.onCreatePanelMenu(i3, menu) | this.mFragments.g(menu, getMenuInflater()) : super.onCreatePanelMenu(i3, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.h(AbstractC0354l.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.i();
    }

    @Override // androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        if (super.onMenuItemSelected(i3, menuItem)) {
            return true;
        }
        if (i3 == 0) {
            return this.mFragments.k(menuItem);
        }
        if (i3 != 6) {
            return false;
        }
        return this.mFragments.e(menuItem);
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onMultiWindowModeChanged(boolean z3) {
        this.mFragments.j(z3);
    }

    @Override // androidx.activity.h, android.app.Activity
    protected void onNewIntent(Intent intent) {
        this.mFragments.u();
        super.onNewIntent(intent);
    }

    @Override // androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        if (i3 == 0) {
            this.mFragments.l(menu);
        }
        super.onPanelClosed(i3, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.m();
        this.mFragmentLifecycleRegistry.h(AbstractC0354l.a.ON_PAUSE);
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z3) {
        this.mFragments.n(z3);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i3, View view, Menu menu) {
        return i3 == 0 ? onPrepareOptionsPanel(view, menu) | this.mFragments.o(menu) : super.onPreparePanel(i3, view, menu);
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        this.mFragments.u();
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.mFragments.u();
        super.onResume();
        this.mResumed = true;
        this.mFragments.s();
    }

    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.h(AbstractC0354l.a.ON_RESUME);
        this.mFragments.p();
    }

    @Override // android.app.Activity
    protected void onStart() {
        this.mFragments.u();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.s();
        this.mFragmentLifecycleRegistry.h(AbstractC0354l.a.ON_START);
        this.mFragments.q();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.u();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.r();
        this.mFragmentLifecycleRegistry.h(AbstractC0354l.a.ON_STOP);
    }

    public void setEnterSharedElementCallback(androidx.core.app.r rVar) {
        androidx.core.app.b.r(this, rVar);
    }

    public void setExitSharedElementCallback(androidx.core.app.r rVar) {
        androidx.core.app.b.s(this, rVar);
    }

    public void startActivityFromFragment(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Intent intent, int i3) {
        startActivityFromFragment(abstractComponentCallbacksC0337e, intent, i3, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        if (i3 == -1) {
            androidx.core.app.b.u(this, intentSender, i3, intent, i4, i5, i6, bundle);
        } else {
            abstractComponentCallbacksC0337e.O1(intentSender, i3, intent, i4, i5, i6, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.b.m(this);
    }

    public abstract void supportInvalidateOptionsMenu();

    public void supportPostponeEnterTransition() {
        androidx.core.app.b.o(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.b.v(this);
    }

    @Override // androidx.core.app.b.e
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i3) {
    }

    public void startActivityFromFragment(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Intent intent, int i3, Bundle bundle) {
        if (i3 == -1) {
            androidx.core.app.b.t(this, intent, -1, bundle);
        } else {
            abstractComponentCallbacksC0337e.N1(intent, i3, bundle);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }
}
