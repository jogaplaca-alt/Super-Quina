package A;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f54a;

    static class a extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final W f55a;

        a(W w3) {
            this.f55a = w3;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i3) {
            T tB = this.f55a.b(i3);
            if (tB == null) {
                return null;
            }
            return tB.O0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List findAccessibilityNodeInfosByText(String str, int i3) {
            List listC = this.f55a.c(str, i3);
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listC.size();
            for (int i4 = 0; i4 < size; i4++) {
                arrayList.add(((T) listC.get(i4)).O0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i3) {
            T tD = this.f55a.d(i3);
            if (tD == null) {
                return null;
            }
            return tD.O0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i3, int i4, Bundle bundle) {
            return this.f55a.f(i3, i4, bundle);
        }
    }

    static class b extends a {
        b(W w3) {
            super(w3);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i3, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f55a.a(i3, T.P0(accessibilityNodeInfo), str, bundle);
        }
    }

    public W() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f54a = new b(this);
        } else {
            this.f54a = new a(this);
        }
    }

    public T b(int i3) {
        return null;
    }

    public List c(String str, int i3) {
        return null;
    }

    public T d(int i3) {
        return null;
    }

    public Object e() {
        return this.f54a;
    }

    public boolean f(int i3, int i4, Bundle bundle) {
        return false;
    }

    public W(Object obj) {
        this.f54a = obj;
    }

    public void a(int i3, T t3, String str, Bundle bundle) {
    }
}
