package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: androidx.core.view.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0282a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final View.AccessibilityDelegate f4622c = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View.AccessibilityDelegate f4623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View.AccessibilityDelegate f4624b;

    /* JADX INFO: renamed from: androidx.core.view.a$a, reason: collision with other inner class name */
    static final class C0060a extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final C0282a f4625a;

        C0060a(C0282a c0282a) {
            this.f4625a = c0282a;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f4625a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            A.W wB = this.f4625a.b(view);
            if (wB != null) {
                return (AccessibilityNodeProvider) wB.e();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f4625a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            A.T tP0 = A.T.P0(accessibilityNodeInfo);
            tP0.E0(Z.X(view));
            tP0.v0(Z.S(view));
            tP0.A0(Z.q(view));
            tP0.K0(Z.K(view));
            this.f4625a.g(view, tP0);
            tP0.f(accessibilityNodeInfo.getText(), view);
            List listC = C0282a.c(view);
            for (int i3 = 0; i3 < listC.size(); i3++) {
                tP0.b((A.T.a) listC.get(i3));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f4625a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f4625a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            return this.f4625a.j(view, i3, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i3) {
            this.f4625a.l(view, i3);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f4625a.m(view, accessibilityEvent);
        }
    }

    public C0282a() {
        this(f4622c);
    }

    static List c(View view) {
        List list = (List) view.getTag(p070v.b.f12350H);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrR = A.T.r(view.createAccessibilityNodeInfo().getText());
            for (int i3 = 0; clickableSpanArrR != null && i3 < clickableSpanArrR.length; i3++) {
                if (clickableSpan.equals(clickableSpanArrR[i3])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k(int i3, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(p070v.b.f12351I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i3)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f4623a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public A.W b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f4623a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new A.W(accessibilityNodeProvider);
        }
        return null;
    }

    View.AccessibilityDelegate d() {
        return this.f4624b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f4623a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, A.T t3) {
        this.f4623a.onInitializeAccessibilityNodeInfo(view, t3.O0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f4623a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f4623a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i3, Bundle bundle) {
        List listC = c(view);
        boolean zPerformAccessibilityAction = false;
        for (int i4 = 0; i4 < listC.size(); i4++) {
            A.T.a aVar = (A.T.a) listC.get(i4);
            if (aVar.b() == i3) {
                zPerformAccessibilityAction = aVar.d(view, bundle);
                break;
            }
        }
        if (!zPerformAccessibilityAction) {
            zPerformAccessibilityAction = this.f4623a.performAccessibilityAction(view, i3, bundle);
        }
        return (zPerformAccessibilityAction || i3 != p070v.b.f12363a || bundle == null) ? zPerformAccessibilityAction : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i3) {
        this.f4623a.sendAccessibilityEvent(view, i3);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f4623a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0282a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f4623a = accessibilityDelegate;
        this.f4624b = new C0060a(this);
    }
}
