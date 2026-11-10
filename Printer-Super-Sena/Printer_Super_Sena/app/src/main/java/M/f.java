package M;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f1276a;

    private static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextView f1277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f1278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1279c = true;

        a(TextView textView) {
            this.f1277a = textView;
            this.f1278b = new d(textView);
        }

        private InputFilter[] f(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f1278b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f1278b;
            return inputFilterArr2;
        }

        private SparseArray g(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i3 = 0; i3 < inputFilterArr.length; i3++) {
                InputFilter inputFilter = inputFilterArr[i3];
                if (inputFilter instanceof d) {
                    sparseArray.put(i3, inputFilter);
                }
            }
            return sparseArray;
        }

        private InputFilter[] h(InputFilter[] inputFilterArr) {
            SparseArray sparseArrayG = g(inputFilterArr);
            if (sparseArrayG.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArrayG.size()];
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                if (sparseArrayG.indexOfKey(i4) < 0) {
                    inputFilterArr2[i3] = inputFilterArr[i4];
                    i3++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        private void k() {
            this.f1277a.setFilters(a(this.f1277a.getFilters()));
        }

        private TransformationMethod m(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod);
        }

        @Override // M.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.f1279c ? h(inputFilterArr) : f(inputFilterArr);
        }

        @Override // M.f.b
        public boolean b() {
            return this.f1279c;
        }

        @Override // M.f.b
        void c(boolean z3) {
            if (z3) {
                l();
            }
        }

        @Override // M.f.b
        void d(boolean z3) {
            this.f1279c = z3;
            l();
            k();
        }

        @Override // M.f.b
        TransformationMethod e(TransformationMethod transformationMethod) {
            return this.f1279c ? m(transformationMethod) : j(transformationMethod);
        }

        void i(boolean z3) {
            this.f1279c = z3;
        }

        void l() {
            this.f1277a.setTransformationMethod(e(this.f1277a.getTransformationMethod()));
        }
    }

    static class b {
        b() {
        }

        abstract InputFilter[] a(InputFilter[] inputFilterArr);

        public abstract boolean b();

        abstract void c(boolean z3);

        abstract void d(boolean z3);

        abstract TransformationMethod e(TransformationMethod transformationMethod);
    }

    private static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f1280a;

        c(TextView textView) {
            this.f1280a = new a(textView);
        }

        private boolean f() {
            return !androidx.emoji2.text.e.h();
        }

        @Override // M.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.f1280a.a(inputFilterArr);
        }

        @Override // M.f.b
        public boolean b() {
            return this.f1280a.b();
        }

        @Override // M.f.b
        void c(boolean z3) {
            if (f()) {
                return;
            }
            this.f1280a.c(z3);
        }

        @Override // M.f.b
        void d(boolean z3) {
            if (f()) {
                this.f1280a.i(z3);
            } else {
                this.f1280a.d(z3);
            }
        }

        @Override // M.f.b
        TransformationMethod e(TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.f1280a.e(transformationMethod);
        }
    }

    public f(TextView textView, boolean z3) {
        p082z.h.h(textView, "textView cannot be null");
        if (z3) {
            this.f1276a = new a(textView);
        } else {
            this.f1276a = new c(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f1276a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f1276a.b();
    }

    public void c(boolean z3) {
        this.f1276a.c(z3);
    }

    public void d(boolean z3) {
        this.f1276a.d(z3);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f1276a.e(transformationMethod);
    }
}
