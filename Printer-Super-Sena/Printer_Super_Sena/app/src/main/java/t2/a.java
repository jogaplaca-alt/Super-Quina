package t2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textfield.TextInputEditText;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final TextView f11749A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final TextView f11750B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final TextView f11751C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final TextView f11752D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final TextView f11753E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final TextView f11754F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f11755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageButton f11756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f11757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f11758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CardView f11759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CardView f11760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConstraintLayout f11761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CardView f11762h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CheckBox f11763i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextInputEditText f11764j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Button f11765k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f11766l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RadioButton f11767m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RadioButton f11768n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RadioGroup f11769o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImageView f11770p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final TextView f11771q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Spinner f11772r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final SwitchCompat f11773s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TextView f11774t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextView f11775u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TextView f11776v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final TextView f11777w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final TextView f11778x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final TextView f11779y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextView f11780z;

    private a(ConstraintLayout constraintLayout, ImageButton imageButton, TextView textView, TextView textView2, CardView cardView, CardView cardView2, ConstraintLayout constraintLayout2, CardView cardView3, CheckBox checkBox, TextInputEditText textInputEditText, Button button, TextView textView3, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, ImageView imageView, TextView textView4, Spinner spinner, SwitchCompat switchCompat, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17) {
        this.f11755a = constraintLayout;
        this.f11756b = imageButton;
        this.f11757c = textView;
        this.f11758d = textView2;
        this.f11759e = cardView;
        this.f11760f = cardView2;
        this.f11761g = constraintLayout2;
        this.f11762h = cardView3;
        this.f11763i = checkBox;
        this.f11764j = textInputEditText;
        this.f11765k = button;
        this.f11766l = textView3;
        this.f11767m = radioButton;
        this.f11768n = radioButton2;
        this.f11769o = radioGroup;
        this.f11770p = imageView;
        this.f11771q = textView4;
        this.f11772r = spinner;
        this.f11773s = switchCompat;
        this.f11774t = textView5;
        this.f11775u = textView6;
        this.f11776v = textView7;
        this.f11777w = textView8;
        this.f11778x = textView9;
        this.f11779y = textView10;
        this.f11780z = textView11;
        this.f11749A = textView12;
        this.f11750B = textView13;
        this.f11751C = textView14;
        this.f11752D = textView15;
        this.f11753E = textView16;
        this.f11754F = textView17;
    }

    public static a a(View view) {
        int i3 = R.id.btnCalcWidth;
        ImageButton imageButton = (ImageButton) p025g0.a.a(view, R.id.btnCalcWidth);
        if (imageButton != null) {
            i3 = R.id.btnDebug;
            TextView textView = (TextView) p025g0.a.a(view, R.id.btnDebug);
            if (textView != null) {
                i3 = R.id.btnPrintRuler;
                TextView textView2 = (TextView) p025g0.a.a(view, R.id.btnPrintRuler);
                if (textView2 != null) {
                    i3 = R.id.cardDpi;
                    CardView cardView = (CardView) p025g0.a.a(view, R.id.cardDpi);
                    if (cardView != null) {
                        i3 = R.id.cardForVirtual;
                        CardView cardView2 = (CardView) p025g0.a.a(view, R.id.cardForVirtual);
                        if (cardView2 != null) {
                            i3 = R.id.cardTestPrint;
                            ConstraintLayout constraintLayout = (ConstraintLayout) p025g0.a.a(view, R.id.cardTestPrint);
                            if (constraintLayout != null) {
                                i3 = R.id.cardWidth;
                                CardView cardView3 = (CardView) p025g0.a.a(view, R.id.cardWidth);
                                if (cardView3 != null) {
                                    i3 = R.id.chkPreviewFrame;
                                    CheckBox checkBox = (CheckBox) p025g0.a.a(view, R.id.chkPreviewFrame);
                                    if (checkBox != null) {
                                        i3 = R.id.editPixelsWidth;
                                        TextInputEditText textInputEditText = (TextInputEditText) p025g0.a.a(view, R.id.editPixelsWidth);
                                        if (textInputEditText != null) {
                                            i3 = R.id.gotoPrinterConfigure;
                                            Button button = (Button) p025g0.a.a(view, R.id.gotoPrinterConfigure);
                                            if (button != null) {
                                                i3 = R.id.helpMoreWidth;
                                                TextView textView3 = (TextView) p025g0.a.a(view, R.id.helpMoreWidth);
                                                if (textView3 != null) {
                                                    i3 = R.id.radioDpi203;
                                                    RadioButton radioButton = (RadioButton) p025g0.a.a(view, R.id.radioDpi203);
                                                    if (radioButton != null) {
                                                        i3 = R.id.radioDpi304;
                                                        RadioButton radioButton2 = (RadioButton) p025g0.a.a(view, R.id.radioDpi304);
                                                        if (radioButton2 != null) {
                                                            i3 = R.id.radioGroupDpi;
                                                            RadioGroup radioGroup = (RadioGroup) p025g0.a.a(view, R.id.radioGroupDpi);
                                                            if (radioGroup != null) {
                                                                i3 = R.id.ruler;
                                                                ImageView imageView = (ImageView) p025g0.a.a(view, R.id.ruler);
                                                                if (imageView != null) {
                                                                    i3 = R.id.saveGraphics;
                                                                    TextView textView4 = (TextView) p025g0.a.a(view, R.id.saveGraphics);
                                                                    if (textView4 != null) {
                                                                        i3 = R.id.spinnerLang;
                                                                        Spinner spinner = (Spinner) p025g0.a.a(view, R.id.spinnerLang);
                                                                        if (spinner != null) {
                                                                            i3 = R.id.switchUseAsDefault;
                                                                            SwitchCompat switchCompat = (SwitchCompat) p025g0.a.a(view, R.id.switchUseAsDefault);
                                                                            if (switchCompat != null) {
                                                                                i3 = R.id.textDemoPrint;
                                                                                TextView textView5 = (TextView) p025g0.a.a(view, R.id.textDemoPrint);
                                                                                if (textView5 != null) {
                                                                                    i3 = R.id.textDemoPrintSimple;
                                                                                    TextView textView6 = (TextView) p025g0.a.a(view, R.id.textDemoPrintSimple);
                                                                                    if (textView6 != null) {
                                                                                        i3 = R.id.textDpi;
                                                                                        TextView textView7 = (TextView) p025g0.a.a(view, R.id.textDpi);
                                                                                        if (textView7 != null) {
                                                                                            i3 = R.id.textForVirtual;
                                                                                            TextView textView8 = (TextView) p025g0.a.a(view, R.id.textForVirtual);
                                                                                            if (textView8 != null) {
                                                                                                i3 = R.id.txtConnectParam;
                                                                                                TextView textView9 = (TextView) p025g0.a.a(view, R.id.txtConnectParam);
                                                                                                if (textView9 != null) {
                                                                                                    i3 = R.id.txtDpi;
                                                                                                    TextView textView10 = (TextView) p025g0.a.a(view, R.id.txtDpi);
                                                                                                    if (textView10 != null) {
                                                                                                        i3 = R.id.txtDriver;
                                                                                                        TextView textView11 = (TextView) p025g0.a.a(view, R.id.txtDriver);
                                                                                                        if (textView11 != null) {
                                                                                                            i3 = R.id.txtDriverTitle;
                                                                                                            TextView textView12 = (TextView) p025g0.a.a(view, R.id.txtDriverTitle);
                                                                                                            if (textView12 != null) {
                                                                                                                i3 = R.id.txtInternalization;
                                                                                                                TextView textView13 = (TextView) p025g0.a.a(view, R.id.txtInternalization);
                                                                                                                if (textView13 != null) {
                                                                                                                    i3 = R.id.txtPrinterDescription;
                                                                                                                    TextView textView14 = (TextView) p025g0.a.a(view, R.id.txtPrinterDescription);
                                                                                                                    if (textView14 != null) {
                                                                                                                        i3 = R.id.txtPrinterName;
                                                                                                                        TextView textView15 = (TextView) p025g0.a.a(view, R.id.txtPrinterName);
                                                                                                                        if (textView15 != null) {
                                                                                                                            i3 = R.id.txtUseMore;
                                                                                                                            TextView textView16 = (TextView) p025g0.a.a(view, R.id.txtUseMore);
                                                                                                                            if (textView16 != null) {
                                                                                                                                i3 = R.id.txtWidth;
                                                                                                                                TextView textView17 = (TextView) p025g0.a.a(view, R.id.txtWidth);
                                                                                                                                if (textView17 != null) {
                                                                                                                                    return new a((ConstraintLayout) view, imageButton, textView, textView2, cardView, cardView2, constraintLayout, cardView3, checkBox, textInputEditText, button, textView3, radioButton, radioButton2, radioGroup, imageView, textView4, spinner, switchCompat, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z3) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_edit_printer, viewGroup, false);
        if (z3) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public ConstraintLayout b() {
        return this.f11755a;
    }
}
