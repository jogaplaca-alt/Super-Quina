package t2;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import rawbt.api.Constant;
import rawbt.api.attributes.AttributesString;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class f extends e implements v2.a.InterfaceC0136a {

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    private static final androidx.databinding.h.i f11846X = null;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    private static final SparseIntArray f11847Y;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private final CheckBox f11848M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private final CheckBox f11849N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private final CheckBox f11850O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private final View.OnClickListener f11851P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private final View.OnClickListener f11852Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private final View.OnClickListener f11853R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private androidx.databinding.g f11854S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private androidx.databinding.g f11855T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private androidx.databinding.g f11856U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private androidx.databinding.g f11857V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private long f11858W;

    class a implements androidx.databinding.g {
        a() {
        }

        @Override // androidx.databinding.g
        public void a() {
            boolean zIsChecked = f.this.f11845z.isChecked();
            AttributesString attributesString = f.this.f11839K;
            if (attributesString != null) {
                attributesString.setDoubleWidth(zIsChecked);
            }
        }
    }

    class b implements androidx.databinding.g {
        b() {
        }

        @Override // androidx.databinding.g
        public void a() {
            boolean zIsChecked = f.this.f11848M.isChecked();
            AttributesString attributesString = f.this.f11839K;
            if (attributesString != null) {
                attributesString.setDoubleHeight(zIsChecked);
            }
        }
    }

    class c implements androidx.databinding.g {
        c() {
        }

        @Override // androidx.databinding.g
        public void a() {
            boolean zIsChecked = f.this.f11849N.isChecked();
            AttributesString attributesString = f.this.f11839K;
            if (attributesString != null) {
                attributesString.setBold(zIsChecked);
            }
        }
    }

    class d implements androidx.databinding.g {
        d() {
        }

        @Override // androidx.databinding.g
        public void a() {
            boolean zIsChecked = f.this.f11850O.isChecked();
            AttributesString attributesString = f.this.f11839K;
            if (attributesString != null) {
                attributesString.setUnderline(zIsChecked);
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f11847Y = sparseIntArray;
        sparseIntArray.put(R.id.bottomBtn, 8);
        sparseIntArray.put(R.id.btnEditSelect, 9);
        sparseIntArray.put(R.id.btnEditPrint, 10);
        sparseIntArray.put(R.id.imageViewBottomSwipe, 11);
        sparseIntArray.put(R.id.spinnerFontType, 12);
        sparseIntArray.put(R.id.textGraphFontSize, 13);
        sparseIntArray.put(R.id.seekBarFont, 14);
        sparseIntArray.put(R.id.spinnerSelectPrinter, 15);
        sparseIntArray.put(R.id.spinnerSelectTemplate, 16);
        sparseIntArray.put(R.id.spinnerNumbersCopies, 17);
    }

    public f(androidx.databinding.e eVar, View view) {
        this(eVar, view, androidx.databinding.h.u(eVar, view, 18, f11846X, f11847Y));
    }

    @Override // t2.e
    public void A(AttributesString attributesString) {
        this.f11839K = attributesString;
        synchronized (this) {
            this.f11858W |= 2;
        }
        b(1);
        super.x();
    }

    @Override // t2.e
    public void B(Constant constant) {
        this.f11840L = constant;
        synchronized (this) {
            this.f11858W |= 1;
        }
        b(2);
        super.x();
    }

    @Override // v2.a.InterfaceC0136a
    public final void a(int i3, View view) {
        AttributesString attributesString;
        if (i3 == 1) {
            AttributesString attributesString2 = this.f11839K;
            if (attributesString2 != null) {
                attributesString2.setAlignment(Constant.ALIGNMENT_LEFT);
                return;
            }
            return;
        }
        if (i3 != 2) {
            if (i3 == 3 && (attributesString = this.f11839K) != null) {
                attributesString.setAlignment(Constant.ALIGNMENT_RIGHT);
                return;
            }
            return;
        }
        AttributesString attributesString3 = this.f11839K;
        if (attributesString3 != null) {
            attributesString3.setAlignment(Constant.ALIGNMENT_CENTER);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005a  */
    /* JADX WARN: Code duplicated, block: B:21:0x0084  */
    /* JADX WARN: Code duplicated, block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.h
    protected void i() {
        long j3;
        boolean zIsDoubleHeight;
        boolean z3;
        boolean zIsUnderline;
        boolean zEquals;
        boolean zIsBold;
        boolean zEquals2;
        String alignment;
        boolean zIsDoubleWidth;
        synchronized (this) {
            j3 = this.f11858W;
            this.f11858W = 0L;
        }
        AttributesString attributesString = this.f11839K;
        long j4 = 6 & j3;
        boolean z4 = false;
        if (j4 != 0) {
            if (attributesString != null) {
                zIsDoubleWidth = attributesString.isDoubleWidth();
                zIsUnderline = attributesString.isUnderline();
                alignment = attributesString.getAlignment();
                zIsBold = attributesString.isBold();
                zIsDoubleHeight = attributesString.isDoubleHeight();
            } else {
                alignment = null;
                zIsDoubleHeight = false;
                zIsDoubleWidth = false;
                zIsUnderline = false;
                zIsBold = false;
            }
            if (alignment != null) {
                boolean zEquals3 = alignment.equals(Constant.ALIGNMENT_LEFT);
                zEquals2 = alignment.equals(Constant.ALIGNMENT_RIGHT);
                zEquals = alignment.equals(Constant.ALIGNMENT_CENTER);
                boolean z5 = zIsDoubleWidth;
                z3 = zEquals3;
                z4 = z5;
            } else {
                z4 = zIsDoubleWidth;
                z3 = false;
                zEquals = false;
            }
            if (j4 != 0) {
                H.a.a(this.f11845z, z4);
                H.a.a(this.f11848M, zIsDoubleHeight);
                H.a.a(this.f11849N, zIsBold);
                H.a.a(this.f11850O, zIsUnderline);
                H.a.a(this.f11830B, zEquals);
                H.a.a(this.f11831C, z3);
                H.a.a(this.f11832D, zEquals2);
            }
            if ((j3 & 4) != 0) {
                H.a.b(this.f11845z, null, this.f11854S);
                H.a.b(this.f11848M, null, this.f11855T);
                H.a.b(this.f11849N, null, this.f11856U);
                H.a.b(this.f11850O, null, this.f11857V);
                this.f11830B.setOnClickListener(this.f11853R);
                this.f11831C.setOnClickListener(this.f11852Q);
                this.f11832D.setOnClickListener(this.f11851P);
            }
        }
        zIsDoubleHeight = false;
        z3 = false;
        zIsUnderline = false;
        zEquals = false;
        zIsBold = false;
        zEquals2 = false;
        if (j4 != 0) {
            H.a.a(this.f11845z, z4);
            H.a.a(this.f11848M, zIsDoubleHeight);
            H.a.a(this.f11849N, zIsBold);
            H.a.a(this.f11850O, zIsUnderline);
            H.a.a(this.f11830B, zEquals);
            H.a.a(this.f11831C, z3);
            H.a.a(this.f11832D, zEquals2);
        }
        if ((j3 & 4) != 0) {
            H.a.b(this.f11845z, null, this.f11854S);
            H.a.b(this.f11848M, null, this.f11855T);
            H.a.b(this.f11849N, null, this.f11856U);
            H.a.b(this.f11850O, null, this.f11857V);
            this.f11830B.setOnClickListener(this.f11853R);
            this.f11831C.setOnClickListener(this.f11852Q);
            this.f11832D.setOnClickListener(this.f11851P);
        }
    }

    @Override // androidx.databinding.h
    public boolean q() {
        synchronized (this) {
            try {
                return this.f11858W != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.h
    public void r() {
        synchronized (this) {
            this.f11858W = 4L;
        }
        x();
    }

    private f(androidx.databinding.e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, (LinearLayout) objArr[8], (ConstraintLayout) objArr[0], (Button) objArr[10], (Button) objArr[9], (CheckBox) objArr[4], (ImageView) objArr[11], (RadioButton) objArr[2], (RadioButton) objArr[1], (RadioButton) objArr[3], (SeekBar) objArr[14], (Spinner) objArr[12], (Spinner) objArr[17], (Spinner) objArr[15], (Spinner) objArr[16], (TextView) objArr[13]);
        this.f11854S = new a();
        this.f11855T = new b();
        this.f11856U = new c();
        this.f11857V = new d();
        this.f11858W = -1L;
        this.f11842w.setTag(null);
        this.f11845z.setTag(null);
        CheckBox checkBox = (CheckBox) objArr[5];
        this.f11848M = checkBox;
        checkBox.setTag(null);
        CheckBox checkBox2 = (CheckBox) objArr[6];
        this.f11849N = checkBox2;
        checkBox2.setTag(null);
        CheckBox checkBox3 = (CheckBox) objArr[7];
        this.f11850O = checkBox3;
        checkBox3.setTag(null);
        this.f11830B.setTag(null);
        this.f11831C.setTag(null);
        this.f11832D.setTag(null);
        z(view);
        this.f11851P = new v2.a(this, 3);
        this.f11852Q = new v2.a(this, 1);
        this.f11853R = new v2.a(this, 2);
        r();
    }
}
