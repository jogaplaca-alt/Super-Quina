package t2;

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

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends androidx.databinding.h {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final ImageView f11829A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final RadioButton f11830B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final RadioButton f11831C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final RadioButton f11832D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final SeekBar f11833E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final Spinner f11834F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final Spinner f11835G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final Spinner f11836H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final Spinner f11837I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final TextView f11838J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    protected AttributesString f11839K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    protected Constant f11840L;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LinearLayout f11841v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ConstraintLayout f11842w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Button f11843x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Button f11844y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final CheckBox f11845z;

    protected e(Object obj, View view, int i3, LinearLayout linearLayout, ConstraintLayout constraintLayout, Button button, Button button2, CheckBox checkBox, ImageView imageView, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, SeekBar seekBar, Spinner spinner, Spinner spinner2, Spinner spinner3, Spinner spinner4, TextView textView) {
        super(obj, view, i3);
        this.f11841v = linearLayout;
        this.f11842w = constraintLayout;
        this.f11843x = button;
        this.f11844y = button2;
        this.f11845z = checkBox;
        this.f11829A = imageView;
        this.f11830B = radioButton;
        this.f11831C = radioButton2;
        this.f11832D = radioButton3;
        this.f11833E = seekBar;
        this.f11834F = spinner;
        this.f11835G = spinner2;
        this.f11836H = spinner3;
        this.f11837I = spinner4;
        this.f11838J = textView;
    }

    public abstract void A(AttributesString attributesString);

    public abstract void B(Constant constant);
}
