package t2;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import rawbt.api.Constant;
import rawbt.api.attributes.AttributesString;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class i extends h implements v2.a.InterfaceC0136a {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private static final androidx.databinding.h.i f11891h0 = null;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final SparseIntArray f11892i0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private final CoordinatorLayout f11893U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private final CheckBox f11894V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private final CheckBox f11895W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    private final CheckBox f11896X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    private final CheckBox f11897Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    private final View.OnClickListener f11898Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final View.OnClickListener f11899a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final View.OnClickListener f11900b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private androidx.databinding.g f11901c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private androidx.databinding.g f11902d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private androidx.databinding.g f11903e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private androidx.databinding.g f11904f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private long f11905g0;

    class a implements androidx.databinding.g {
        a() {
        }

        @Override // androidx.databinding.g
        public void a() {
            boolean zIsChecked = i.this.f11894V.isChecked();
            AttributesString attributesString = i.this.f11885T;
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
            boolean zIsChecked = i.this.f11895W.isChecked();
            AttributesString attributesString = i.this.f11885T;
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
            boolean zIsChecked = i.this.f11896X.isChecked();
            AttributesString attributesString = i.this.f11885T;
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
            boolean zIsChecked = i.this.f11897Y.isChecked();
            AttributesString attributesString = i.this.f11885T;
            if (attributesString != null) {
                attributesString.setUnderline(zIsChecked);
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f11892i0 = sparseIntArray;
        sparseIntArray.put(R.id.intro, 8);
        sparseIntArray.put(R.id.imageView, 9);
        sparseIntArray.put(R.id.textViewFileName, 10);
        sparseIntArray.put(R.id.textViewFileSize, 11);
        sparseIntArray.put(R.id.tab_text, 12);
        sparseIntArray.put(R.id.view_txt, 13);
        sparseIntArray.put(R.id.ln2, 14);
        sparseIntArray.put(R.id.radioUseUtf, 15);
        sparseIntArray.put(R.id.radioLocalCP, 16);
        sparseIntArray.put(R.id.bottom_sheet, 17);
        sparseIntArray.put(R.id.bottomBtn, 18);
        sparseIntArray.put(R.id.btnSelectTxt, 19);
        sparseIntArray.put(R.id.btnTxtPrint, 20);
        sparseIntArray.put(R.id.imageViewBottomSwipe, 21);
        sparseIntArray.put(R.id.spinnerFontType, 22);
        sparseIntArray.put(R.id.textGraphFontSize, 23);
        sparseIntArray.put(R.id.seekBarFont, 24);
        sparseIntArray.put(R.id.spinnerSelectPrinter, 25);
        sparseIntArray.put(R.id.spinnerSelectTemplate, 26);
        sparseIntArray.put(R.id.spinnerNumbersCopies, 27);
        sparseIntArray.put(R.id.task_progress_bar, 28);
    }

    public i(androidx.databinding.e eVar, View view) {
        this(eVar, view, androidx.databinding.h.u(eVar, view, 29, f11891h0, f11892i0));
    }

    @Override // t2.h
    public void A(AttributesString attributesString) {
        this.f11885T = attributesString;
        synchronized (this) {
            this.f11905g0 |= 2;
        }
        b(1);
        super.x();
    }

    @Override // v2.a.InterfaceC0136a
    public final void a(int i3, View view) {
        AttributesString attributesString;
        if (i3 == 1) {
            AttributesString attributesString2 = this.f11885T;
            if (attributesString2 != null) {
                attributesString2.setAlignment(Constant.ALIGNMENT_LEFT);
                return;
            }
            return;
        }
        if (i3 != 2) {
            if (i3 == 3 && (attributesString = this.f11885T) != null) {
                attributesString.setAlignment(Constant.ALIGNMENT_RIGHT);
                return;
            }
            return;
        }
        AttributesString attributesString3 = this.f11885T;
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
        boolean zEquals;
        boolean z3;
        boolean zIsBold;
        boolean zIsDoubleHeight;
        boolean zIsUnderline;
        boolean zEquals2;
        String alignment;
        boolean zIsDoubleWidth;
        synchronized (this) {
            j3 = this.f11905g0;
            this.f11905g0 = 0L;
        }
        AttributesString attributesString = this.f11885T;
        long j4 = 6 & j3;
        boolean z4 = false;
        if (j4 != 0) {
            if (attributesString != null) {
                zIsDoubleWidth = attributesString.isDoubleWidth();
                zIsBold = attributesString.isBold();
                zIsDoubleHeight = attributesString.isDoubleHeight();
                zIsUnderline = attributesString.isUnderline();
                alignment = attributesString.getAlignment();
            } else {
                alignment = null;
                zIsDoubleWidth = false;
                zIsBold = false;
                zIsDoubleHeight = false;
                zIsUnderline = false;
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
                zEquals = false;
                z3 = false;
            }
            if (j4 != 0) {
                H.a.a(this.f11894V, z4);
                H.a.a(this.f11895W, zIsDoubleHeight);
                H.a.a(this.f11896X, zIsBold);
                H.a.a(this.f11897Y, zIsUnderline);
                H.a.a(this.f11871F, zEquals);
                H.a.a(this.f11872G, z3);
                H.a.a(this.f11873H, zEquals2);
            }
            if ((j3 & 4) != 0) {
                H.a.b(this.f11894V, null, this.f11901c0);
                H.a.b(this.f11895W, null, this.f11902d0);
                H.a.b(this.f11896X, null, this.f11903e0);
                H.a.b(this.f11897Y, null, this.f11904f0);
                this.f11871F.setOnClickListener(this.f11898Z);
                this.f11872G.setOnClickListener(this.f11899a0);
                this.f11873H.setOnClickListener(this.f11900b0);
            }
        }
        zEquals = false;
        z3 = false;
        zIsBold = false;
        zIsDoubleHeight = false;
        zIsUnderline = false;
        zEquals2 = false;
        if (j4 != 0) {
            H.a.a(this.f11894V, z4);
            H.a.a(this.f11895W, zIsDoubleHeight);
            H.a.a(this.f11896X, zIsBold);
            H.a.a(this.f11897Y, zIsUnderline);
            H.a.a(this.f11871F, zEquals);
            H.a.a(this.f11872G, z3);
            H.a.a(this.f11873H, zEquals2);
        }
        if ((j3 & 4) != 0) {
            H.a.b(this.f11894V, null, this.f11901c0);
            H.a.b(this.f11895W, null, this.f11902d0);
            H.a.b(this.f11896X, null, this.f11903e0);
            H.a.b(this.f11897Y, null, this.f11904f0);
            this.f11871F.setOnClickListener(this.f11898Z);
            this.f11872G.setOnClickListener(this.f11899a0);
            this.f11873H.setOnClickListener(this.f11900b0);
        }
    }

    @Override // androidx.databinding.h
    public boolean q() {
        synchronized (this) {
            try {
                return this.f11905g0 != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.h
    public void r() {
        synchronized (this) {
            this.f11905g0 = 4L;
        }
        x();
    }

    private i(androidx.databinding.e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, (LinearLayout) objArr[18], (ConstraintLayout) objArr[17], (Button) objArr[19], (Button) objArr[20], (ImageView) objArr[9], (ImageView) objArr[21], (ScrollView) objArr[8], (RadioGroup) objArr[14], (RadioButton) objArr[16], (RadioButton) objArr[15], (RadioButton) objArr[2], (RadioButton) objArr[1], (RadioButton) objArr[3], (SeekBar) objArr[24], (Spinner) objArr[22], (Spinner) objArr[27], (Spinner) objArr[25], (Spinner) objArr[26], (ScrollView) objArr[12], (ProgressBar) objArr[28], (TextView) objArr[23], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[13]);
        this.f11901c0 = new a();
        this.f11902d0 = new b();
        this.f11903e0 = new c();
        this.f11904f0 = new d();
        this.f11905g0 = -1L;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) objArr[0];
        this.f11893U = coordinatorLayout;
        coordinatorLayout.setTag(null);
        CheckBox checkBox = (CheckBox) objArr[4];
        this.f11894V = checkBox;
        checkBox.setTag(null);
        CheckBox checkBox2 = (CheckBox) objArr[5];
        this.f11895W = checkBox2;
        checkBox2.setTag(null);
        CheckBox checkBox3 = (CheckBox) objArr[6];
        this.f11896X = checkBox3;
        checkBox3.setTag(null);
        CheckBox checkBox4 = (CheckBox) objArr[7];
        this.f11897Y = checkBox4;
        checkBox4.setTag(null);
        this.f11871F.setTag(null);
        this.f11872G.setTag(null);
        this.f11873H.setTag(null);
        z(view);
        this.f11898Z = new v2.a(this, 2);
        this.f11899a0 = new v2.a(this, 1);
        this.f11900b0 = new v2.a(this, 3);
        r();
    }
}
