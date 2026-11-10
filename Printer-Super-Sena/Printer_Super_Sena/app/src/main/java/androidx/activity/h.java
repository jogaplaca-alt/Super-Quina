package androidx.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.core.view.A;
import androidx.core.view.C0329y;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.C0359q;
import androidx.lifecycle.I;
import androidx.lifecycle.InterfaceC0352j;
import androidx.lifecycle.InterfaceC0356n;
import androidx.lifecycle.InterfaceC0358p;
import androidx.lifecycle.L;
import androidx.lifecycle.P;
import androidx.lifecycle.T;
import androidx.lifecycle.U;
import androidx.lifecycle.V;
import androidx.lifecycle.W;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends androidx.core.app.f implements InterfaceC0358p, U, InterfaceC0352j, Y.f, t, p004b.e, o {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final p004b.d mActivityResultRegistry;
    private int mContentLayoutId;
    private P.b mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final n mFullyDrawnReporter;
    private final AtomicInteger mNextLocalRequestCode;
    private r mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<p082z.a> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<p082z.a> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<p082z.a> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<p082z.a> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<p082z.a> mOnTrimMemoryListeners;
    final j mReportFullyDrawnExecutor;
    final Y.e mSavedStateRegistryController;
    private T mViewModelStore;
    final p000a.a mContextAwareHelper = new p000a.a();
    private final C0329y mMenuHostHelper = new C0329y(new Runnable() { // from class: androidx.activity.d
        @Override // java.lang.Runnable
        public final void run() {
            this.f2227a.invalidateMenu();
        }
    });
    private final C0359q mLifecycleRegistry = new C0359q(this);

    class a extends p004b.d {

        /* JADX INFO: renamed from: androidx.activity.h$a$a, reason: collision with other inner class name */
        class RunnableC0038a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f2232a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ p008c.a.C0100a f2233b;

            RunnableC0038a(int i3, p008c.a.C0100a c0100a) {
                this.f2232a = i3;
                this.f2233b = c0100a;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.f2232a, this.f2233b.a());
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f2235a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ IntentSender.SendIntentException f2236b;

            b(int i3, IntentSender.SendIntentException sendIntentException) {
                this.f2235a = i3;
                this.f2236b = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b(this.f2235a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f2236b));
            }
        }

        a() {
        }

        @Override // p004b.d
        public void f(int i3, p008c.a aVar, Object obj, androidx.core.app.c cVar) {
            Bundle bundle;
            h hVar = h.this;
            p008c.a.C0100a c0100aB = aVar.b(hVar, obj);
            if (c0100aB != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0038a(i3, c0100aB));
                return;
            }
            Intent intentA = aVar.a(hVar, obj);
            if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
                intentA.setExtrasClassLoader(hVar.getClassLoader());
            }
            if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle = bundleExtra;
            } else {
                bundle = null;
            }
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
                String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                androidx.core.app.b.q(hVar, stringArrayExtra, i3);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
                androidx.core.app.b.t(hVar, intentA, i3, bundle);
                return;
            }
            p004b.f fVar = (p004b.f) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                androidx.core.app.b.u(hVar, fVar.f(), i3, fVar.c(), fVar.d(), fVar.e(), 0, bundle);
            } catch (IntentSender.SendIntentException e3) {
                new Handler(Looper.getMainLooper()).post(new b(i3, e3));
            }
        }
    }

    class b implements InterfaceC0356n {
        b() {
        }

        @Override // androidx.lifecycle.InterfaceC0356n
        public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
            if (aVar == AbstractC0354l.a.ON_STOP) {
                Window window = h.this.getWindow();
                View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                if (viewPeekDecorView != null) {
                    g.a(viewPeekDecorView);
                }
            }
        }
    }

    class c implements InterfaceC0356n {
        c() {
        }

        @Override // androidx.lifecycle.InterfaceC0356n
        public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
            if (aVar == AbstractC0354l.a.ON_DESTROY) {
                h.this.mContextAwareHelper.b();
                if (!h.this.isChangingConfigurations()) {
                    h.this.getViewModelStore().a();
                }
                h.this.mReportFullyDrawnExecutor.a();
            }
        }
    }

    class d implements InterfaceC0356n {
        d() {
        }

        @Override // androidx.lifecycle.InterfaceC0356n
        public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
            h.this.ensureViewModelStore();
            h.this.getLifecycle().c(this);
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h.super.onBackPressed();
            } catch (IllegalStateException e3) {
                if (!TextUtils.equals(e3.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e3;
                }
            } catch (NullPointerException e4) {
                if (!TextUtils.equals(e4.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e4;
                }
            }
        }
    }

    class f implements InterfaceC0356n {
        f() {
        }

        @Override // androidx.lifecycle.InterfaceC0356n
        public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
            if (aVar != AbstractC0354l.a.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                return;
            }
            h.this.mOnBackPressedDispatcher.n(C0039h.a((h) interfaceC0358p));
        }
    }

    static class g {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.h$h, reason: collision with other inner class name */
    static class C0039h {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f2243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        T f2244b;

        i() {
        }
    }

    private interface j extends Executor {
        void a();

        void b(View view);
    }

    class k implements j, ViewTreeObserver.OnDrawListener, Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Runnable f2246b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f2245a = SystemClock.uptimeMillis() + 10000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2247c = false;

        k() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            Runnable runnable = this.f2246b;
            if (runnable != null) {
                runnable.run();
                this.f2246b = null;
            }
        }

        @Override // androidx.activity.h.j
        public void a() {
            h.this.getWindow().getDecorView().removeCallbacks(this);
            h.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // androidx.activity.h.j
        public void b(View view) {
            if (this.f2247c) {
                return;
            }
            this.f2247c = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f2246b = runnable;
            View decorView = h.this.getWindow().getDecorView();
            if (!this.f2247c) {
                decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2249a.d();
                    }
                });
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f2246b;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.f2245a) {
                    this.f2247c = false;
                    h.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.f2246b = null;
            if (h.this.mFullyDrawnReporter.c()) {
                this.f2247c = false;
                h.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public h() {
        Y.e eVarA = Y.e.a(this);
        this.mSavedStateRegistryController = eVarA;
        this.mOnBackPressedDispatcher = null;
        j jVarJ = j();
        this.mReportFullyDrawnExecutor = jVarJ;
        this.mFullyDrawnReporter = new n(jVarJ, new R1.a() { // from class: androidx.activity.e
            @Override // R1.a
            public final Object a() {
                return this.f2228a.k();
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new a();
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i3 = Build.VERSION.SDK_INT;
        getLifecycle().a(new b());
        getLifecycle().a(new c());
        getLifecycle().a(new d());
        eVarA.c();
        I.c(this);
        if (i3 <= 23) {
            getLifecycle().a(new p(this));
        }
        getSavedStateRegistry().h(ACTIVITY_RESULT_TAG, new Y.d.c() { // from class: androidx.activity.f
            @Override // Y.d.c
            public final Bundle a() {
                return this.f2229a.l();
            }
        });
        addOnContextAvailableListener(new p000a.b() { // from class: androidx.activity.g
            @Override // p000a.b
            public final void a(Context context) {
                this.f2230a.m(context);
            }
        });
    }

    private j j() {
        return new k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ J1.l k() {
        reportFullyDrawn();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle l() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(Context context) {
        Bundle bundleB = getSavedStateRegistry().b(ACTIVITY_RESULT_TAG);
        if (bundleB != null) {
            this.mActivityResultRegistry.g(bundleB);
        }
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.b(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    public void addMenuProvider(A a3) {
        this.mMenuHostHelper.c(a3);
    }

    public final void addOnConfigurationChangedListener(p082z.a aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(p000a.b bVar) {
        this.mContextAwareHelper.a(bVar);
    }

    public final void addOnMultiWindowModeChangedListener(p082z.a aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(p082z.a aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    public final void addOnPictureInPictureModeChangedListener(p082z.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    public final void addOnTrimMemoryListener(p082z.a aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            i iVar = (i) getLastNonConfigurationInstance();
            if (iVar != null) {
                this.mViewModelStore = iVar.f2244b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new T();
            }
        }
    }

    @Override // p004b.e
    public final p004b.d getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.InterfaceC0352j
    public T.a getDefaultViewModelCreationExtras() {
        T.b bVar = new T.b();
        if (getApplication() != null) {
            bVar.c(P.a.f5595g, getApplication());
        }
        bVar.c(I.f5571a, this);
        bVar.c(I.f5572b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            bVar.c(I.f5573c, getIntent().getExtras());
        }
        return bVar;
    }

    @Override // androidx.lifecycle.InterfaceC0352j
    public P.b getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new L(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    public n getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        i iVar = (i) getLastNonConfigurationInstance();
        if (iVar != null) {
            return iVar.f2243a;
        }
        return null;
    }

    @Override // androidx.lifecycle.InterfaceC0358p
    public AbstractC0354l getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.t
    public final r getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new r(new e());
            getLifecycle().a(new f());
        }
        return this.mOnBackPressedDispatcher;
    }

    @Override // Y.f
    public final Y.d getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // androidx.lifecycle.U
    public T getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    public void initializeViewTreeOwners() {
        V.a(getWindow().getDecorView(), this);
        W.a(getWindow().getDecorView(), this);
        Y.g.a(getWindow().getDecorView(), this);
        w.a(getWindow().getDecorView(), this);
        v.a(getWindow().getDecorView(), this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        if (this.mActivityResultRegistry.b(i3, i4, intent)) {
            return;
        }
        super.onActivityResult(i3, i4, intent);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().k();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<p082z.a> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().a(configuration);
        }
    }

    @Override // androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        androidx.lifecycle.A.e(this);
        int i3 = this.mContentLayoutId;
        if (i3 != 0) {
            setContentView(i3);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i3, Menu menu) {
        if (i3 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i3, menu);
        this.mMenuHostHelper.h(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        if (super.onMenuItemSelected(i3, menuItem)) {
            return true;
        }
        if (i3 == 0) {
            return this.mMenuHostHelper.j(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z3) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<p082z.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().a(new androidx.core.app.g(z3));
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<p082z.a> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().a(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        this.mMenuHostHelper.i(menu);
        super.onPanelClosed(i3, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z3) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<p082z.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().a(new androidx.core.app.p(z3));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i3, View view, Menu menu) {
        if (i3 != 0) {
            return true;
        }
        super.onPreparePanel(i3, view, menu);
        this.mMenuHostHelper.k(menu);
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.b(i3, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        i iVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        T t3 = this.mViewModelStore;
        if (t3 == null && (iVar = (i) getLastNonConfigurationInstance()) != null) {
            t3 = iVar.f2244b;
        }
        if (t3 == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        i iVar2 = new i();
        iVar2.f2243a = objOnRetainCustomNonConfigurationInstance;
        iVar2.f2244b = t3;
        return iVar2;
    }

    @Override // androidx.core.app.f, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        AbstractC0354l lifecycle = getLifecycle();
        if (lifecycle instanceof C0359q) {
            ((C0359q) lifecycle).m(AbstractC0354l.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        super.onTrimMemory(i3);
        Iterator<p082z.a> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().a(Integer.valueOf(i3));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final <I, O> p004b.c registerForActivityResult(p008c.a aVar, p004b.d dVar, p004b.b bVar) {
        return dVar.i("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, aVar, bVar);
    }

    public void removeMenuProvider(A a3) {
        this.mMenuHostHelper.l(a3);
    }

    public final void removeOnConfigurationChangedListener(p082z.a aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(p000a.b bVar) {
        this.mContextAwareHelper.e(bVar);
    }

    public final void removeOnMultiWindowModeChangedListener(p082z.a aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(p082z.a aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    public final void removeOnPictureInPictureModeChangedListener(p082z.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    public final void removeOnTrimMemoryListener(p082z.a aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (p017e0.b.d()) {
                p017e0.b.a("reportFullyDrawn() for ComponentActivity");
            }
            int i3 = Build.VERSION.SDK_INT;
            if (i3 > 19) {
                super.reportFullyDrawn();
            } else if (i3 == 19 && androidx.core.content.a.a(this, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                super.reportFullyDrawn();
            }
            this.mFullyDrawnReporter.b();
        } finally {
            p017e0.b.b();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i3) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.b(getWindow().getDecorView());
        super.setContentView(i3);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i3) {
        super.startActivityForResult(intent, i3);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6);
    }

    public void addMenuProvider(A a3, InterfaceC0358p interfaceC0358p) {
        this.mMenuHostHelper.d(a3, interfaceC0358p);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        super.startActivityForResult(intent, i3, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6, bundle);
    }

    public void addMenuProvider(A a3, InterfaceC0358p interfaceC0358p, AbstractC0354l.b bVar) {
        this.mMenuHostHelper.e(a3, interfaceC0358p, bVar);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z3, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z3, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<p082z.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().a(new androidx.core.app.g(z3, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z3, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z3, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<p082z.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().a(new androidx.core.app.p(z3, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public final <I, O> p004b.c registerForActivityResult(p008c.a aVar, p004b.b bVar) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, bVar);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.b(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.b(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }
}
