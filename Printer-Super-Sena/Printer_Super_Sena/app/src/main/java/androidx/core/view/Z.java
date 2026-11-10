package androidx.core.view;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static WeakHashMap f4601a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakHashMap f4602b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f4603c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f4604d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ThreadLocal f4605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f4606f = {p070v.b.f12364b, p070v.b.f12365c, p070v.b.f12376n, p070v.b.f12387y, p070v.b.f12344B, p070v.b.f12345C, p070v.b.f12346D, p070v.b.f12347E, p070v.b.f12348F, p070v.b.f12349G, p070v.b.f12366d, p070v.b.f12367e, p070v.b.f12368f, p070v.b.f12369g, p070v.b.f12370h, p070v.b.f12371i, p070v.b.f12372j, p070v.b.f12373k, p070v.b.f12374l, p070v.b.f12375m, p070v.b.f12377o, p070v.b.f12378p, p070v.b.f12379q, p070v.b.f12380r, p070v.b.f12381s, p070v.b.f12382t, p070v.b.f12383u, p070v.b.f12384v, p070v.b.f12385w, p070v.b.f12386x, p070v.b.f12388z, p070v.b.f12343A};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final K f4607g = new K() { // from class: androidx.core.view.Y
        @Override // androidx.core.view.K
        public final C0288d a(C0288d c0288d) {
            return Z.Y(c0288d);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final e f4608h = new e();

    class a extends f {
        a(int i3, Class cls, int i4) {
            super(i3, cls, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.Z.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(l.d(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.Z.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            l.j(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.Z.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    class b extends f {
        b(int i3, Class cls, int i4, int i5) {
            super(i3, cls, i4, i5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.Z.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return l.b(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.Z.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            l.h(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.Z.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class c extends f {
        c(int i3, Class cls, int i4, int i5) {
            super(i3, cls, i4, i5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.Z.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return n.b(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.Z.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            n.f(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.Z.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class d extends f {
        d(int i3, Class cls, int i4) {
            super(i3, cls, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.Z.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(l.c(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.Z.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            l.g(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.Z.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakHashMap f4609a = new WeakHashMap();

        e() {
        }

        private void b(Map.Entry entry) {
            View view = (View) entry.getKey();
            boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
            boolean z3 = view.isShown() && view.getWindowVisibility() == 0;
            if (zBooleanValue != z3) {
                Z.Z(view, z3 ? 16 : 32);
                entry.setValue(Boolean.valueOf(z3));
            }
        }

        private void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void e(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        void a(View view) {
            this.f4609a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                c(view);
            }
        }

        void d(View view) {
            this.f4609a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                Iterator it = this.f4609a.entrySet().iterator();
                while (it.hasNext()) {
                    b((Map.Entry) it.next());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f4610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class f4611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f4612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f4613d;

        f(int i3, Class cls, int i4) {
            this(i3, cls, 0, i4);
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= this.f4612c;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        abstract Object c(View view);

        abstract void d(View view, Object obj);

        Object e(View view) {
            if (b()) {
                return c(view);
            }
            Object tag = view.getTag(this.f4610a);
            if (this.f4611b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        void f(View view, Object obj) {
            if (b()) {
                d(view, obj);
            } else if (g(e(view), obj)) {
                Z.l(view);
                view.setTag(this.f4610a, obj);
                Z.Z(view, this.f4613d);
            }
        }

        abstract boolean g(Object obj, Object obj2);

        f(int i3, Class cls, int i4, int i5) {
            this.f4610a = i3;
            this.f4611b = cls;
            this.f4613d = i4;
            this.f4612c = i5;
        }
    }

    static class g {
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    private static class h {

        class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            C0332z0 f4614a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f4615b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ I f4616c;

            a(View view, I i3) {
                this.f4615b = view;
                this.f4616c = i3;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                C0332z0 c0332z0Y = C0332z0.y(windowInsets, view);
                int i3 = Build.VERSION.SDK_INT;
                if (i3 < 30) {
                    h.a(windowInsets, this.f4615b);
                    if (c0332z0Y.equals(this.f4614a)) {
                        return this.f4616c.a(view, c0332z0Y).w();
                    }
                }
                this.f4614a = c0332z0Y;
                C0332z0 c0332z0A = this.f4616c.a(view, c0332z0Y);
                if (i3 >= 30) {
                    return c0332z0A.w();
                }
                Z.n0(view);
                return c0332z0A.w();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(p070v.b.f12362T);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static C0332z0 b(View view, C0332z0 c0332z0, Rect rect) {
            WindowInsets windowInsetsW = c0332z0.w();
            if (windowInsetsW != null) {
                return C0332z0.y(view.computeSystemWindowInsets(windowInsetsW, rect), view);
            }
            rect.setEmpty();
            return c0332z0;
        }

        static boolean c(View view, float f3, float f4, boolean z3) {
            return view.dispatchNestedFling(f3, f4, z3);
        }

        static boolean d(View view, float f3, float f4) {
            return view.dispatchNestedPreFling(f3, f4);
        }

        static boolean e(View view, int i3, int i4, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i3, i4, iArr, iArr2);
        }

        static boolean f(View view, int i3, int i4, int i5, int i6, int[] iArr) {
            return view.dispatchNestedScroll(i3, i4, i5, i6, iArr);
        }

        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        static float i(View view) {
            return view.getElevation();
        }

        public static C0332z0 j(View view) {
            return C0332z0.a.a(view);
        }

        static String k(View view) {
            return view.getTransitionName();
        }

        static float l(View view) {
            return view.getTranslationZ();
        }

        static float m(View view) {
            return view.getZ();
        }

        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void s(View view, float f3) {
            view.setElevation(f3);
        }

        static void t(View view, boolean z3) {
            view.setNestedScrollingEnabled(z3);
        }

        static void u(View view, I i3) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(p070v.b.f12354L, i3);
            }
            if (i3 == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(p070v.b.f12362T));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, i3));
            }
        }

        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        static void w(View view, float f3) {
            view.setTranslationZ(f3);
        }

        static void x(View view, float f3) {
            view.setZ(f3);
        }

        static boolean y(View view, int i3) {
            return view.startNestedScroll(i3);
        }

        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    private static class i {
        public static C0332z0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            C0332z0 c0332z0X = C0332z0.x(rootWindowInsets);
            c0332z0X.u(c0332z0X);
            c0332z0X.d(view.getRootView());
            return c0332z0X;
        }

        static int b(View view) {
            return view.getScrollIndicators();
        }

        static void c(View view, int i3) {
            view.setScrollIndicators(i3);
        }

        static void d(View view, int i3, int i4) {
            view.setScrollIndicators(i3, i4);
        }
    }

    static class j {
        static void a(View view) {
            view.cancelDragAndDrop();
        }

        static void b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        static void c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        static void d(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        static boolean e(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i3) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i3);
        }

        static void f(View view, View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    static class k {
        static void a(View view, Collection<View> collection, int i3) {
            view.addKeyboardNavigationClusters(collection, i3);
        }

        public static AutofillId b(View view) {
            return view.getAutofillId();
        }

        static int c(View view) {
            return view.getImportantForAutofill();
        }

        static int d(View view) {
            return view.getNextClusterForwardId();
        }

        static boolean e(View view) {
            return view.hasExplicitFocusable();
        }

        static boolean f(View view) {
            return view.isFocusedByDefault();
        }

        static boolean g(View view) {
            return view.isImportantForAutofill();
        }

        static boolean h(View view) {
            return view.isKeyboardNavigationCluster();
        }

        static View i(View view, View view2, int i3) {
            return view.keyboardNavigationClusterSearch(view2, i3);
        }

        static boolean j(View view) {
            return view.restoreDefaultFocus();
        }

        static void k(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        static void l(View view, boolean z3) {
            view.setFocusedByDefault(z3);
        }

        static void m(View view, int i3) {
            view.setImportantForAutofill(i3);
        }

        static void n(View view, boolean z3) {
            view.setKeyboardNavigationCluster(z3);
        }

        static void o(View view, int i3) {
            view.setNextClusterForwardId(i3);
        }

        static void p(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    static class l {
        static void a(View view, final q qVar) {
            int i3 = p070v.b.f12361S;
            p046n.g gVar = (p046n.g) view.getTag(i3);
            if (gVar == null) {
                gVar = new p046n.g();
                view.setTag(i3, gVar);
            }
            Objects.requireNonNull(qVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener(qVar) { // from class: androidx.core.view.a0
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    throw null;
                }
            };
            gVar.put(qVar, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        static void e(View view, q qVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            p046n.g gVar = (p046n.g) view.getTag(p070v.b.f12361S);
            if (gVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) gVar.get(qVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static <T> T f(View view, int i3) {
            return (T) view.requireViewById(i3);
        }

        static void g(View view, boolean z3) {
            view.setAccessibilityHeading(z3);
        }

        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, B.a aVar) {
            view.setAutofillId(null);
        }

        static void j(View view, boolean z3) {
            view.setScreenReaderFocusable(z3);
        }
    }

    private static class m {
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        static ContentCaptureSession b(View view) {
            return view.getContentCaptureSession();
        }

        static List<Rect> c(View view) {
            return view.getSystemGestureExclusionRects();
        }

        static void d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i3, int i4) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i3, i4);
        }

        static void e(View view, C.a aVar) {
            view.setContentCaptureSession(null);
        }

        static void f(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    private static class n {
        static int a(View view) {
            return view.getImportantForContentCapture();
        }

        static CharSequence b(View view) {
            return view.getStateDescription();
        }

        public static l1 c(View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return l1.d(windowInsetsController);
            }
            return null;
        }

        static boolean d(View view) {
            return view.isImportantForContentCapture();
        }

        static void e(View view, int i3) {
            view.setImportantForContentCapture(i3);
        }

        static void f(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    private static final class o {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static C0288d b(View view, C0288d c0288d) {
            ContentInfo contentInfoF = c0288d.f();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoF);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoF ? c0288d : C0288d.g(contentInfoPerformReceiveContent);
        }

        public static void c(View view, String[] strArr, J j3) {
            if (j3 == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new p(j3));
            }
        }
    }

    private static final class p implements OnReceiveContentListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final J f4617a;

        p(J j3) {
            this.f4617a = j3;
        }

        @Override // android.view.OnReceiveContentListener
        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            C0288d c0288dG = C0288d.g(contentInfo);
            C0288d c0288dA = this.f4617a.a(view, c0288dG);
            if (c0288dA == null) {
                return null;
            }
            return c0288dA == c0288dG ? contentInfo : c0288dA.f();
        }
    }

    public interface q {
    }

    static class r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final ArrayList f4618d = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakHashMap f4619a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SparseArray f4620b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WeakReference f4621c = null;

        r() {
        }

        static r a(View view) {
            int i3 = p070v.b.f12360R;
            r rVar = (r) view.getTag(i3);
            if (rVar != null) {
                return rVar;
            }
            r rVar2 = new r();
            view.setTag(i3, rVar2);
            return rVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.f4619a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewC != null) {
                            return viewC;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray d() {
            if (this.f4620b == null) {
                this.f4620b = new SparseArray();
            }
            return this.f4620b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(p070v.b.f12361S);
            if (arrayList == null || (size = arrayList.size() - 1) < 0) {
                return false;
            }
            androidx.appcompat.app.H.a(arrayList.get(size));
            throw null;
        }

        private void g() {
            WeakHashMap weakHashMap = this.f4619a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = f4618d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                try {
                    if (this.f4619a == null) {
                        this.f4619a = new WeakHashMap();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = f4618d;
                        View view = (View) ((WeakReference) arrayList2.get(size)).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f4619a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f4619a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(viewC));
                }
            }
            return viewC != null;
        }

        boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int iIndexOfKey;
            WeakReference weakReference2 = this.f4621c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.f4621c = new WeakReference(keyEvent);
            SparseArray sparseArrayD = d();
            if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = (WeakReference) sparseArrayD.valueAt(iIndexOfKey);
                sparseArrayD.removeAt(iIndexOfKey);
            }
            if (weakReference == null) {
                weakReference = (WeakReference) sparseArrayD.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && view.isAttachedToWindow()) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    public static int A(View view) {
        return view.getImportantForAccessibility();
    }

    private static void A0(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static int B(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return k.c(view);
        }
        return 0;
    }

    public static void B0(View view, int i3) {
        if (Build.VERSION.SDK_INT >= 26) {
            k.m(view, i3);
        }
    }

    public static int C(View view) {
        return view.getLayoutDirection();
    }

    public static void C0(View view, int i3) {
        view.setLabelFor(i3);
    }

    public static int D(View view) {
        return view.getMinimumHeight();
    }

    public static void D0(View view, I i3) {
        if (Build.VERSION.SDK_INT >= 21) {
            h.u(view, i3);
        }
    }

    public static int E(View view) {
        return view.getMinimumWidth();
    }

    public static void E0(View view, int i3, int i4, int i5, int i6) {
        view.setPaddingRelative(i3, i4, i5, i6);
    }

    public static String[] F(View view) {
        return Build.VERSION.SDK_INT >= 31 ? o.a(view) : (String[]) view.getTag(p070v.b.f12356N);
    }

    public static void F0(View view, M m3) {
        if (Build.VERSION.SDK_INT >= 24) {
            j.d(view, X.a(m3 != null ? m3.a() : null));
        }
    }

    public static int G(View view) {
        return view.getPaddingEnd();
    }

    public static void G0(View view, boolean z3) {
        p0().f(view, Boolean.valueOf(z3));
    }

    public static int H(View view) {
        return view.getPaddingStart();
    }

    public static void H0(View view, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 23) {
            i.d(view, i3, i4);
        }
    }

    public static ViewParent I(View view) {
        return view.getParentForAccessibility();
    }

    public static void I0(View view, CharSequence charSequence) {
        L0().f(view, charSequence);
    }

    public static C0332z0 J(View view) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            return i.a(view);
        }
        if (i3 >= 21) {
            return h.j(view);
        }
        return null;
    }

    public static void J0(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            h.v(view, str);
            return;
        }
        if (f4601a == null) {
            f4601a = new WeakHashMap();
        }
        f4601a.put(view, str);
    }

    public static CharSequence K(View view) {
        return (CharSequence) L0().e(view);
    }

    public static void K0(View view, C0307m0.b bVar) {
        C0307m0.d(view, bVar);
    }

    public static String L(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return h.k(view);
        }
        WeakHashMap weakHashMap = f4601a;
        if (weakHashMap == null) {
            return null;
        }
        return (String) weakHashMap.get(view);
    }

    private static f L0() {
        return new c(p070v.b.f12358P, CharSequence.class, 64, 30);
    }

    public static l1 M(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return n.c(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return AbstractC0305l0.a(window, view);
                }
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void M0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            h.z(view);
        } else if (view instanceof C) {
            ((C) view).stopNestedScroll();
        }
    }

    public static int N(View view) {
        return view.getWindowSystemUiVisibility();
    }

    private static void N0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static float O(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return h.m(view);
        }
        return 0.0f;
    }

    public static boolean P(View view) {
        return o(view) != null;
    }

    public static boolean Q(View view) {
        return view.hasOnClickListeners();
    }

    public static boolean R(View view) {
        return view.hasTransientState();
    }

    public static boolean S(View view) {
        Boolean bool = (Boolean) b().e(view);
        return bool != null && bool.booleanValue();
    }

    public static boolean T(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean U(View view) {
        return view.isLaidOut();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean V(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return h.p(view);
        }
        if (view instanceof C) {
            return ((C) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean W(View view) {
        return view.isPaddingRelative();
    }

    public static boolean X(View view) {
        Boolean bool = (Boolean) p0().e(view);
        return bool != null && bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C0288d Y(C0288d c0288d) {
        return c0288d;
    }

    static void Z(View view, int i3) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z3 = q(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z3) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z3 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i3);
                if (z3) {
                    accessibilityEventObtain.getText().add(q(view));
                    A0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i3 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i3);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(q(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i3);
                } catch (AbstractMethodError e3) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e3);
                }
            }
        }
    }

    public static void a0(View view, int i3) {
        boolean z3;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            view.offsetLeftAndRight(i3);
            return;
        }
        if (i4 < 21) {
            f(view, i3);
            return;
        }
        Rect rectX = x();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectX.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z3 = !rectX.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z3 = false;
        }
        f(view, i3);
        if (z3 && rectX.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectX);
        }
    }

    private static f b() {
        return new d(p070v.b.f12352J, Boolean.class, 28);
    }

    public static void b0(View view, int i3) {
        boolean z3;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            view.offsetTopAndBottom(i3);
            return;
        }
        if (i4 < 21) {
            g(view, i3);
            return;
        }
        Rect rectX = x();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectX.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z3 = !rectX.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z3 = false;
        }
        g(view, i3);
        if (z3 && rectX.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectX);
        }
    }

    public static int c(View view, CharSequence charSequence, A.Y y3) {
        int iS = s(view, charSequence);
        if (iS != -1) {
            d(view, new A.T.a(iS, charSequence, y3));
        }
        return iS;
    }

    public static C0332z0 c0(View view, C0332z0 c0332z0) {
        WindowInsets windowInsetsW;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsetsW = c0332z0.w()) != null) {
            WindowInsets windowInsetsB = g.b(view, windowInsetsW);
            if (!windowInsetsB.equals(windowInsetsW)) {
                return C0332z0.y(windowInsetsB, view);
            }
        }
        return c0332z0;
    }

    private static void d(View view, A.T.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            l(view);
            l0(aVar.b(), view);
            r(view).add(aVar);
            Z(view, 0);
        }
    }

    public static void d0(View view, A.T t3) {
        view.onInitializeAccessibilityNodeInfo(t3.O0());
    }

    public static C0297h0 e(View view) {
        if (f4602b == null) {
            f4602b = new WeakHashMap();
        }
        C0297h0 c0297h0 = (C0297h0) f4602b.get(view);
        if (c0297h0 != null) {
            return c0297h0;
        }
        C0297h0 c0297h1 = new C0297h0(view);
        f4602b.put(view, c0297h1);
        return c0297h1;
    }

    private static f e0() {
        return new b(p070v.b.f12353K, CharSequence.class, 8, 28);
    }

    private static void f(View view, int i3) {
        view.offsetLeftAndRight(i3);
        if (view.getVisibility() == 0) {
            N0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                N0((View) parent);
            }
        }
    }

    public static boolean f0(View view, int i3, Bundle bundle) {
        return view.performAccessibilityAction(i3, bundle);
    }

    private static void g(View view, int i3) {
        view.offsetTopAndBottom(i3);
        if (view.getVisibility() == 0) {
            N0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                N0((View) parent);
            }
        }
    }

    public static C0288d g0(View view, C0288d c0288d) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + c0288d + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return o.b(view, c0288d);
        }
        J j3 = (J) view.getTag(p070v.b.f12355M);
        if (j3 == null) {
            return y(view).a(c0288d);
        }
        C0288d c0288dA = j3.a(view, c0288d);
        if (c0288dA == null) {
            return null;
        }
        return y(view).a(c0288dA);
    }

    public static C0332z0 h(View view, C0332z0 c0332z0, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? h.b(view, c0332z0, rect) : c0332z0;
    }

    public static void h0(View view) {
        view.postInvalidateOnAnimation();
    }

    public static C0332z0 i(View view, C0332z0 c0332z0) {
        WindowInsets windowInsetsW;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsetsW = c0332z0.w()) != null) {
            WindowInsets windowInsetsA = g.a(view, windowInsetsW);
            if (!windowInsetsA.equals(windowInsetsW)) {
                return C0332z0.y(windowInsetsA, view);
            }
        }
        return c0332z0;
    }

    public static void i0(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    static boolean j(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return r.a(view).b(view, keyEvent);
    }

    public static void j0(View view, Runnable runnable, long j3) {
        view.postOnAnimationDelayed(runnable, j3);
    }

    static boolean k(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return r.a(view).f(keyEvent);
    }

    public static void k0(View view, int i3) {
        if (Build.VERSION.SDK_INT >= 21) {
            l0(i3, view);
            Z(view, 0);
        }
    }

    static void l(View view) {
        C0282a c0282aN = n(view);
        if (c0282aN == null) {
            c0282aN = new C0282a();
        }
        q0(view, c0282aN);
    }

    private static void l0(int i3, View view) {
        List listR = r(view);
        for (int i4 = 0; i4 < listR.size(); i4++) {
            if (((A.T.a) listR.get(i4)).b() == i3) {
                listR.remove(i4);
                return;
            }
        }
    }

    public static int m() {
        return View.generateViewId();
    }

    public static void m0(View view, A.T.a aVar, CharSequence charSequence, A.Y y3) {
        if (y3 == null && charSequence == null) {
            k0(view, aVar.b());
        } else {
            d(view, aVar.a(charSequence, y3));
        }
    }

    public static C0282a n(View view) {
        View.AccessibilityDelegate accessibilityDelegateO = o(view);
        if (accessibilityDelegateO == null) {
            return null;
        }
        return accessibilityDelegateO instanceof C0282a.C0060a ? ((C0282a.C0060a) accessibilityDelegateO).f4625a : new C0282a(accessibilityDelegateO);
    }

    public static void n0(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            g.c(view);
        } else {
            view.requestFitSystemWindows();
        }
    }

    private static View.AccessibilityDelegate o(View view) {
        return Build.VERSION.SDK_INT >= 29 ? m.a(view) : p(view);
    }

    public static void o0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 29) {
            m.d(view, context, iArr, attributeSet, typedArray, i3, i4);
        }
    }

    private static View.AccessibilityDelegate p(View view) {
        if (f4604d) {
            return null;
        }
        if (f4603c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f4603c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f4604d = true;
                return null;
            }
        }
        try {
            Object obj = f4603c.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f4604d = true;
            return null;
        }
    }

    private static f p0() {
        return new a(p070v.b.f12357O, Boolean.class, 28);
    }

    public static CharSequence q(View view) {
        return (CharSequence) e0().e(view);
    }

    public static void q0(View view, C0282a c0282a) {
        if (c0282a == null && (o(view) instanceof C0282a.C0060a)) {
            c0282a = new C0282a();
        }
        A0(view);
        view.setAccessibilityDelegate(c0282a == null ? null : c0282a.d());
    }

    private static List r(View view) {
        int i3 = p070v.b.f12350H;
        ArrayList arrayList = (ArrayList) view.getTag(i3);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i3, arrayList2);
        return arrayList2;
    }

    public static void r0(View view, boolean z3) {
        b().f(view, Boolean.valueOf(z3));
    }

    private static int s(View view, CharSequence charSequence) {
        List listR = r(view);
        for (int i3 = 0; i3 < listR.size(); i3++) {
            if (TextUtils.equals(charSequence, ((A.T.a) listR.get(i3)).c())) {
                return ((A.T.a) listR.get(i3)).b();
            }
        }
        int i4 = 0;
        int i5 = -1;
        while (true) {
            int[] iArr = f4606f;
            if (i4 >= iArr.length || i5 != -1) {
                break;
            }
            int i6 = iArr[i4];
            boolean z3 = true;
            for (int i7 = 0; i7 < listR.size(); i7++) {
                z3 &= ((A.T.a) listR.get(i7)).b() != i6;
            }
            if (z3) {
                i5 = i6;
            }
            i4++;
        }
        return i5;
    }

    public static void s0(View view, int i3) {
        view.setAccessibilityLiveRegion(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList t(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return h.g(view);
        }
        if (view instanceof T) {
            return ((T) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void t0(View view, CharSequence charSequence) {
        e0().f(view, charSequence);
        if (charSequence != null) {
            f4608h.a(view);
        } else {
            f4608h.d(view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode u(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return h.h(view);
        }
        if (view instanceof T) {
            return ((T) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void u0(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static Display v(View view) {
        return view.getDisplay();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void v0(View view, ColorStateList colorStateList) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 21) {
            if (view instanceof T) {
                ((T) view).setSupportBackgroundTintList(colorStateList);
                return;
            }
            return;
        }
        h.q(view, colorStateList);
        if (i3 == 21) {
            Drawable background = view.getBackground();
            boolean z3 = (h.g(view) == null && h.h(view) == null) ? false : true;
            if (background == null || !z3) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    public static float w(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return h.i(view);
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void w0(View view, PorterDuff.Mode mode) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 21) {
            if (view instanceof T) {
                ((T) view).setSupportBackgroundTintMode(mode);
                return;
            }
            return;
        }
        h.r(view, mode);
        if (i3 == 21) {
            Drawable background = view.getBackground();
            boolean z3 = (h.g(view) == null && h.h(view) == null) ? false : true;
            if (background == null || !z3) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    private static Rect x() {
        if (f4605e == null) {
            f4605e = new ThreadLocal();
        }
        Rect rect = (Rect) f4605e.get();
        if (rect == null) {
            rect = new Rect();
            f4605e.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void x0(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static K y(View view) {
        return view instanceof K ? (K) view : f4607g;
    }

    public static void y0(View view, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            h.s(view, f3);
        }
    }

    public static boolean z(View view) {
        return view.getFitsSystemWindows();
    }

    public static void z0(View view, int i3) {
        view.setImportantForAccessibility(i3);
    }
}
