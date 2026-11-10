package t2;

import android.util.SparseIntArray;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import rawbt.api.Constant;
import rawbt.api.attributes.AttributesString;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class d extends c {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final androidx.databinding.h.i f11823B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final SparseIntArray f11824C;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private long f11825A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final g f11826x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final CoordinatorLayout f11827y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final e f11828z;

    static {
        androidx.databinding.h.i iVar = new androidx.databinding.h.i(3);
        f11823B = iVar;
        iVar.a(0, new String[]{"fragment_editor_bottom"}, new int[]{2}, new int[]{R.layout.fragment_editor_bottom});
        f11824C = null;
    }

    public d(androidx.databinding.e eVar, View view) {
        this(eVar, view, androidx.databinding.h.u(eVar, view, 3, f11823B, f11824C));
    }

    @Override // t2.c
    public void A(AttributesString attributesString) {
        this.f11821v = attributesString;
        synchronized (this) {
            this.f11825A |= 1;
        }
        b(1);
        super.x();
    }

    @Override // androidx.databinding.h
    protected void i() {
        long j3;
        synchronized (this) {
            j3 = this.f11825A;
            this.f11825A = 0L;
        }
        AttributesString attributesString = this.f11821v;
        Constant constant = this.f11822w;
        long j4 = 5 & j3;
        if ((j3 & 6) != 0) {
            this.f11828z.B(constant);
        }
        if (j4 != 0) {
            this.f11828z.A(attributesString);
        }
        androidx.databinding.h.k(this.f11828z);
    }

    @Override // androidx.databinding.h
    public boolean q() {
        synchronized (this) {
            try {
                if (this.f11825A != 0) {
                    return true;
                }
                return this.f11828z.q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.h
    public void r() {
        synchronized (this) {
            this.f11825A = 4L;
        }
        this.f11828z.r();
        x();
    }

    private d(androidx.databinding.e eVar, View view, Object[] objArr) {
        super(eVar, view, 0);
        this.f11825A = -1L;
        Object obj = objArr[1];
        this.f11826x = obj != null ? g.a((View) obj) : null;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) objArr[0];
        this.f11827y = coordinatorLayout;
        coordinatorLayout.setTag(null);
        e eVar2 = (e) objArr[2];
        this.f11828z = eVar2;
        y(eVar2);
        z(view);
        r();
    }
}
