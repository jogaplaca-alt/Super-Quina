package H;

import android.widget.CompoundButton;
import androidx.databinding.g;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: H.a$a, reason: collision with other inner class name */
    class C0016a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CompoundButton.OnCheckedChangeListener f1075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f1076b;

        C0016a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener, g gVar) {
            this.f1075a = onCheckedChangeListener;
            this.f1076b = gVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f1075a;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(compoundButton, z3);
            }
            this.f1076b.a();
        }
    }

    public static void a(CompoundButton compoundButton, boolean z3) {
        if (compoundButton.isChecked() != z3) {
            compoundButton.setChecked(z3);
        }
    }

    public static void b(CompoundButton compoundButton, CompoundButton.OnCheckedChangeListener onCheckedChangeListener, g gVar) {
        if (gVar == null) {
            compoundButton.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            compoundButton.setOnCheckedChangeListener(new C0016a(onCheckedChangeListener, gVar));
        }
    }
}
