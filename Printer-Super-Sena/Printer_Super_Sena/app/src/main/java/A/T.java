package A;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class T {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccessibilityNodeInfo f1a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3c = -1;

    public static class a {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public static final a f4A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public static final a f5B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public static final a f6C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public static final a f7D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public static final a f8E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public static final a f9F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public static final a f10G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public static final a f11H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public static final a f12I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public static final a f13J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public static final a f14K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public static final a f15L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public static final a f16M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public static final a f17N;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public static final a f18O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public static final a f19P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public static final a f20Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public static final a f21R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public static final a f22S;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public static final a f23T;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public static final a f24U;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        public static final a f25V;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f26e = new a(1, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f27f = new a(2, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f28g = new a(4, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f29h = new a(8, null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f30i = new a(16, null);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f31j = new a(32, null);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f32k = new a(64, null);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f33l = new a(128, null);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f34m = new a(256, (CharSequence) null, Y.b.class);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f35n = new a(512, (CharSequence) null, Y.b.class);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f36o = new a(1024, (CharSequence) null, Y.c.class);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f37p = new a(2048, (CharSequence) null, Y.c.class);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f38q = new a(4096, null);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f39r = new a(8192, null);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a f40s = new a(16384, null);

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final a f41t = new a(32768, null);

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final a f42u = new a(65536, null);

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final a f43v = new a(131072, (CharSequence) null, Y.g.class);

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final a f44w = new a(262144, null);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final a f45x = new a(524288, null);

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final a f46y = new a(1048576, null);

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final a f47z = new a(2097152, (CharSequence) null, Y.h.class);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f48a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f49b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class f50c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final Y f51d;

        static {
            int i3 = Build.VERSION.SDK_INT;
            f4A = new a(i3 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            f5B = new a(i3 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, Y.e.class);
            f6C = new a(i3 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            f7D = new a(i3 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            f8E = new a(i3 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            f9F = new a(i3 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            f10G = new a(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            f11H = new a(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            f12I = new a(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            f13J = new a(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            f14K = new a(i3 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            f15L = new a(i3 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, Y.f.class);
            f16M = new a(i3 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, Y.d.class);
            f17N = new a(i3 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            f18O = new a(i3 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            f19P = new a(i3 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            f20Q = new a(i3 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            f21R = new a(i3 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            f22S = new a(i3 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            f23T = new a(i3 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            f24U = new a(i3 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            f25V = new a(i3 >= 34 ? d.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        public a(int i3, CharSequence charSequence) {
            this(null, i3, charSequence, null, null);
        }

        public a a(CharSequence charSequence, Y y3) {
            return new a(null, this.f49b, charSequence, y3, this.f50c);
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return r.a(this.f48a).getId();
            }
            return 0;
        }

        public CharSequence c() {
            if (Build.VERSION.SDK_INT >= 21) {
                return r.a(this.f48a).getLabel();
            }
            return null;
        }

        public boolean d(View view, Bundle bundle) {
            if (this.f51d == null) {
                return false;
            }
            Class cls = this.f50c;
            if (cls != null) {
                try {
                    androidx.appcompat.app.H.a(cls.getDeclaredConstructor(null).newInstance(null));
                    throw null;
                } catch (Exception e3) {
                    Class cls2 = this.f50c;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e3);
                }
            }
            return this.f51d.a(view, null);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f48a;
            if (obj2 == null) {
                return aVar.f48a == null;
            }
            return obj2.equals(aVar.f48a);
        }

        public int hashCode() {
            Object obj = this.f48a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String strJ = T.j(this.f49b);
            if (strJ.equals("ACTION_UNKNOWN") && c() != null) {
                strJ = c().toString();
            }
            sb.append(strJ);
            return sb.toString();
        }

        public a(int i3, CharSequence charSequence, Y y3) {
            this(null, i3, charSequence, y3, null);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i3, CharSequence charSequence, Class cls) {
            this(null, i3, charSequence, null, cls);
        }

        a(Object obj, int i3, CharSequence charSequence, Y y3, Class cls) {
            this.f49b = i3;
            this.f51d = y3;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.f48a = new AccessibilityNodeInfo.AccessibilityAction(i3, charSequence);
            } else {
                this.f48a = obj;
            }
            this.f50c = cls;
        }
    }

    private static class b {
        public static Object a(int i3, float f3, float f4, float f5) {
            return new AccessibilityNodeInfo.RangeInfo(i3, f3, f4, f5);
        }

        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    private static class c {
        public static f a(boolean z3, int i3, int i4, int i5, int i6, boolean z4, String str, String str2) {
            return new f(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z3).setColumnIndex(i3).setRowIndex(i4).setColumnSpan(i5).setRowSpan(i6).setSelected(z4).setRowTitle(str).setColumnTitle(str2).build());
        }

        public static T b(AccessibilityNodeInfo accessibilityNodeInfo, int i3, int i4) {
            return T.Q0(accessibilityNodeInfo.getChild(i3, i4));
        }

        public static String c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        public static String d(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        public static T f(AccessibilityNodeInfo accessibilityNodeInfo, int i3) {
            return T.Q0(accessibilityNodeInfo.getParent(i3));
        }

        public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z3) {
            accessibilityNodeInfo.setTextSelectable(z3);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }
    }

    private static class d {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static long d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        public static boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        public static void g(AccessibilityNodeInfo accessibilityNodeInfo, boolean z3) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z3);
        }

        public static void h(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, long j3) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j3));
        }

        public static void k(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z3) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z3);
        }

        public static void l(AccessibilityNodeInfo accessibilityNodeInfo, boolean z3) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z3);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f52a;

        e(Object obj) {
            this.f52a = obj;
        }

        public static e a(int i3, int i4, boolean z3) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i3, i4, z3));
        }

        public static e b(int i3, int i4, boolean z3, int i5) {
            return Build.VERSION.SDK_INT >= 21 ? new e(AccessibilityNodeInfo.CollectionInfo.obtain(i3, i4, z3, i5)) : new e(AccessibilityNodeInfo.CollectionInfo.obtain(i3, i4, z3));
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f53a;

        f(Object obj) {
            this.f53a = obj;
        }

        public static f a(int i3, int i4, int i5, int i6, boolean z3, boolean z4) {
            return Build.VERSION.SDK_INT >= 21 ? new f(AccessibilityNodeInfo.CollectionItemInfo.obtain(i3, i4, i5, i6, z3, z4)) : new f(AccessibilityNodeInfo.CollectionItemInfo.obtain(i3, i4, i5, i6, z3));
        }
    }

    public T(Object obj) {
        this.f1a = (AccessibilityNodeInfo) obj;
    }

    private boolean F() {
        return !h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int G(ClickableSpan clickableSpan, SparseArray sparseArray) {
        if (sparseArray != null) {
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray.valueAt(i3)).get())) {
                    return sparseArray.keyAt(i3);
                }
            }
        }
        int i4 = f0d;
        f0d = i4 + 1;
        return i4;
    }

    public static T P0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new T(accessibilityNodeInfo);
    }

    static T Q0(Object obj) {
        if (obj != null) {
            return new T(obj);
        }
        return null;
    }

    public static T Z() {
        return P0(AccessibilityNodeInfo.obtain());
    }

    public static T a0(T t3) {
        return P0(AccessibilityNodeInfo.obtain(t3.f1a));
    }

    public static T b0(View view) {
        return P0(AccessibilityNodeInfo.obtain(view));
    }

    private void e(ClickableSpan clickableSpan, Spanned spanned, int i3) {
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i3));
    }

    private void f0(View view) {
        SparseArray sparseArrayZ = z(view);
        if (sparseArrayZ != null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArrayZ.size(); i3++) {
                if (((WeakReference) sparseArrayZ.valueAt(i3)).get() == null) {
                    arrayList.add(Integer.valueOf(i3));
                }
            }
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                sparseArrayZ.remove(((Integer) arrayList.get(i4)).intValue());
            }
        }
    }

    private void g() {
        this.f1a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f1a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f1a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f1a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private List h(String str) {
        ArrayList<Integer> integerArrayList = this.f1a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f1a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private void h0(int i3, boolean z3) {
        Bundle bundleV = v();
        if (bundleV != null) {
            int i4 = bundleV.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i3 ^ (-1));
            if (!z3) {
                i3 = 0;
            }
            bundleV.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i3 | i4);
        }
    }

    static String j(int i3) {
        if (i3 == 1) {
            return "ACTION_FOCUS";
        }
        if (i3 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i3) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionScrollInDirection:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i3) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i3) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i3) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    private boolean l(int i3) {
        Bundle bundleV = v();
        return bundleV != null && (bundleV.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i3) == i3;
    }

    public static ClickableSpan[] r(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray x(View view) {
        SparseArray sparseArrayZ = z(view);
        if (sparseArrayZ != null) {
            return sparseArrayZ;
        }
        SparseArray sparseArray = new SparseArray();
        view.setTag(p070v.b.f12351I, sparseArray);
        return sparseArray;
    }

    private SparseArray z(View view) {
        return (SparseArray) view.getTag(p070v.b.f12351I);
    }

    public CharSequence A() {
        return Build.VERSION.SDK_INT >= 30 ? b.b(this.f1a) : this.f1a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public void A0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1a.setPaneTitle(charSequence);
        } else {
            this.f1a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public CharSequence B() {
        if (!F()) {
            return this.f1a.getText();
        }
        List listH = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List listH2 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List listH3 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List listH4 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f1a.getText(), 0, this.f1a.getText().length()));
        for (int i3 = 0; i3 < listH.size(); i3++) {
            spannableString.setSpan(new C0155a(((Integer) listH4.get(i3)).intValue(), this, v().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) listH.get(i3)).intValue(), ((Integer) listH2.get(i3)).intValue(), ((Integer) listH3.get(i3)).intValue());
        }
        return spannableString;
    }

    public void B0(View view) {
        this.f2b = -1;
        this.f1a.setParent(view);
    }

    public CharSequence C() {
        return Build.VERSION.SDK_INT >= 28 ? this.f1a.getTooltipText() : this.f1a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public void C0(View view, int i3) {
        this.f2b = i3;
        this.f1a.setParent(view, i3);
    }

    public String D() {
        return Build.VERSION.SDK_INT >= 33 ? c.g(this.f1a) : this.f1a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public void D0(CharSequence charSequence) {
        this.f1a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    public String E() {
        return this.f1a.getViewIdResourceName();
    }

    public void E0(boolean z3) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1a.setScreenReaderFocusable(z3);
        } else {
            h0(1, z3);
        }
    }

    public void F0(boolean z3) {
        this.f1a.setScrollable(z3);
    }

    public void G0(boolean z3) {
        this.f1a.setSelected(z3);
    }

    public boolean H() {
        return Build.VERSION.SDK_INT >= 34 ? d.f(this.f1a) : l(64);
    }

    public void H0(boolean z3) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1a.setShowingHintText(z3);
        } else {
            h0(4, z3);
        }
    }

    public boolean I() {
        return this.f1a.isAccessibilityFocused();
    }

    public void I0(View view) {
        this.f3c = -1;
        this.f1a.setSource(view);
    }

    public boolean J() {
        return this.f1a.isCheckable();
    }

    public void J0(View view, int i3) {
        this.f3c = i3;
        this.f1a.setSource(view, i3);
    }

    public boolean K() {
        return this.f1a.isChecked();
    }

    public void K0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.c(this.f1a, charSequence);
        } else {
            this.f1a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public boolean L() {
        return this.f1a.isClickable();
    }

    public void L0(CharSequence charSequence) {
        this.f1a.setText(charSequence);
    }

    public boolean M() {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.f1a.isContextClickable();
        }
        return false;
    }

    public void M0(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f1a.setTraversalAfter(view);
        }
    }

    public boolean N() {
        return this.f1a.isEnabled();
    }

    public void N0(boolean z3) {
        this.f1a.setVisibleToUser(z3);
    }

    public boolean O() {
        return this.f1a.isFocusable();
    }

    public AccessibilityNodeInfo O0() {
        return this.f1a;
    }

    public boolean P() {
        return this.f1a.isFocused();
    }

    public boolean Q() {
        return l(67108864);
    }

    public boolean R() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f1a.isImportantForAccessibility();
        }
        return true;
    }

    public boolean S() {
        return this.f1a.isLongClickable();
    }

    public boolean T() {
        return this.f1a.isPassword();
    }

    public boolean U() {
        return this.f1a.isScrollable();
    }

    public boolean V() {
        return this.f1a.isSelected();
    }

    public boolean W() {
        return Build.VERSION.SDK_INT >= 26 ? this.f1a.isShowingHintText() : l(4);
    }

    public boolean X() {
        return Build.VERSION.SDK_INT >= 33 ? c.h(this.f1a) : l(8388608);
    }

    public boolean Y() {
        return this.f1a.isVisibleToUser();
    }

    public void a(int i3) {
        this.f1a.addAction(i3);
    }

    public void b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1a.addAction(r.a(aVar.f48a));
        }
    }

    public void c(View view) {
        this.f1a.addChild(view);
    }

    public boolean c0(int i3, Bundle bundle) {
        return this.f1a.performAction(i3, bundle);
    }

    public void d(View view, int i3) {
        this.f1a.addChild(view, i3);
    }

    public boolean e0(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f1a.removeAction(r.a(aVar.f48a));
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof T)) {
            return false;
        }
        T t3 = (T) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1a;
        if (accessibilityNodeInfo == null) {
            if (t3.f1a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(t3.f1a)) {
            return false;
        }
        return this.f3c == t3.f3c && this.f2b == t3.f2b;
    }

    public void f(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            g();
            f0(view);
            ClickableSpan[] clickableSpanArrR = r(charSequence);
            if (clickableSpanArrR == null || clickableSpanArrR.length <= 0) {
                return;
            }
            v().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", p070v.b.f12363a);
            SparseArray sparseArrayX = x(view);
            for (int i3 = 0; i3 < clickableSpanArrR.length; i3++) {
                int iG = G(clickableSpanArrR[i3], sparseArrayX);
                sparseArrayX.put(iG, new WeakReference(clickableSpanArrR[i3]));
                e(clickableSpanArrR[i3], (Spanned) charSequence, iG);
            }
        }
    }

    public void g0(boolean z3) {
        this.f1a.setAccessibilityFocused(z3);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public List i() {
        List actionList = Build.VERSION.SDK_INT >= 21 ? this.f1a.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new a(actionList.get(i3)));
        }
        return arrayList;
    }

    public void i0(Rect rect) {
        this.f1a.setBoundsInParent(rect);
    }

    public void j0(Rect rect) {
        this.f1a.setBoundsInScreen(rect);
    }

    public int k() {
        return this.f1a.getActions();
    }

    public void k0(boolean z3) {
        this.f1a.setCheckable(z3);
    }

    public void l0(boolean z3) {
        this.f1a.setChecked(z3);
    }

    public void m(Rect rect) {
        this.f1a.getBoundsInParent(rect);
    }

    public void m0(CharSequence charSequence) {
        this.f1a.setClassName(charSequence);
    }

    public void n(Rect rect) {
        this.f1a.getBoundsInScreen(rect);
    }

    public void n0(boolean z3) {
        this.f1a.setClickable(z3);
    }

    public void o(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.b(this.f1a, rect);
            return;
        }
        Rect rect2 = (Rect) this.f1a.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void o0(Object obj) {
        this.f1a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((e) obj).f52a);
    }

    public int p() {
        return this.f1a.getChildCount();
    }

    public void p0(Object obj) {
        this.f1a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((f) obj).f53a);
    }

    public CharSequence q() {
        return this.f1a.getClassName();
    }

    public void q0(CharSequence charSequence) {
        this.f1a.setContentDescription(charSequence);
    }

    public void r0(boolean z3) {
        this.f1a.setEnabled(z3);
    }

    public CharSequence s() {
        return Build.VERSION.SDK_INT >= 34 ? d.c(this.f1a) : this.f1a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public void s0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1a.setError(charSequence);
        }
    }

    public CharSequence t() {
        return this.f1a.getContentDescription();
    }

    public void t0(boolean z3) {
        this.f1a.setFocusable(z3);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        m(rect);
        sb.append("; boundsInParent: " + rect);
        n(rect);
        sb.append("; boundsInScreen: " + rect);
        o(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(y());
        sb.append("; className: ");
        sb.append(q());
        sb.append("; text: ");
        sb.append(B());
        sb.append("; error: ");
        sb.append(u());
        sb.append("; maxTextLength: ");
        sb.append(w());
        sb.append("; stateDescription: ");
        sb.append(A());
        sb.append("; contentDescription: ");
        sb.append(t());
        sb.append("; tooltipText: ");
        sb.append(C());
        sb.append("; viewIdResName: ");
        sb.append(E());
        sb.append("; uniqueId: ");
        sb.append(D());
        sb.append("; checkable: ");
        sb.append(J());
        sb.append("; checked: ");
        sb.append(K());
        sb.append("; focusable: ");
        sb.append(O());
        sb.append("; focused: ");
        sb.append(P());
        sb.append("; selected: ");
        sb.append(V());
        sb.append("; clickable: ");
        sb.append(L());
        sb.append("; longClickable: ");
        sb.append(S());
        sb.append("; contextClickable: ");
        sb.append(M());
        sb.append("; enabled: ");
        sb.append(N());
        sb.append("; password: ");
        sb.append(T());
        sb.append("; scrollable: " + U());
        sb.append("; containerTitle: ");
        sb.append(s());
        sb.append("; granularScrollingSupported: ");
        sb.append(Q());
        sb.append("; importantForAccessibility: ");
        sb.append(R());
        sb.append("; visible: ");
        sb.append(Y());
        sb.append("; isTextSelectable: ");
        sb.append(X());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(H());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List listI = i();
            for (int i3 = 0; i3 < listI.size(); i3++) {
                a aVar = (a) listI.get(i3);
                String strJ = j(aVar.b());
                if (strJ.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                    strJ = aVar.c().toString();
                }
                sb.append(strJ);
                if (i3 != listI.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int iK = k();
            while (iK != 0) {
                int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(iK);
                iK &= iNumberOfTrailingZeros ^ (-1);
                sb.append(j(iNumberOfTrailingZeros));
                if (iK != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public CharSequence u() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f1a.getError();
        }
        return null;
    }

    public void u0(boolean z3) {
        this.f1a.setFocused(z3);
    }

    public Bundle v() {
        return this.f1a.getExtras();
    }

    public void v0(boolean z3) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1a.setHeading(z3);
        } else {
            h0(2, z3);
        }
    }

    public int w() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f1a.getMaxTextLength();
        }
        return -1;
    }

    public void w0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1a.setHintText(charSequence);
        } else {
            this.f1a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void x0(View view) {
        this.f1a.setLabelFor(view);
    }

    public CharSequence y() {
        return this.f1a.getPackageName();
    }

    public void y0(int i3) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1a.setMaxTextLength(i3);
        }
    }

    public void z0(CharSequence charSequence) {
        this.f1a.setPackageName(charSequence);
    }

    private T(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f1a = accessibilityNodeInfo;
    }

    public void d0() {
    }
}
