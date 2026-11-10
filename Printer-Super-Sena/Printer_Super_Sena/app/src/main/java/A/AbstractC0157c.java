package A;

import android.view.accessibility.AccessibilityManager;

/* JADX INFO: renamed from: A.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0157c {

    /* JADX INFO: renamed from: A.c$a */
    public interface a {
        void onTouchExplorationStateChanged(boolean z3);
    }

    /* JADX INFO: renamed from: A.c$b */
    private static final class b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f59a;

        b(a aVar) {
            this.f59a = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f59a.equals(((b) obj).f59a);
            }
            return false;
        }

        public int hashCode() {
            return this.f59a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z3) {
            this.f59a.onTouchExplorationStateChanged(z3);
        }
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        return accessibilityManager.addTouchExplorationStateChangeListener(new b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        return accessibilityManager.removeTouchExplorationStateChangeListener(new b(aVar));
    }
}
