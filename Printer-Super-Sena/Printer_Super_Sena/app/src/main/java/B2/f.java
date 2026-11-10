package B2;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.C0362u;
import java.util.Locale;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static f f97d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f98a = "0";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View.OnClickListener f100c = new View.OnClickListener() { // from class: B2.d
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f95a.i(view);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0362u f99b = new C0362u(this.f98a);

    private f() {
    }

    private void d() {
        if (this.f98a.length() > 1 && this.f98a.startsWith("0")) {
            this.f98a = this.f98a.substring(1);
        }
        if (this.f98a.length() < 1) {
            this.f98a = "0";
        }
        if (this.f98a.length() > 3) {
            this.f98a = (String) this.f99b.e();
        } else {
            this.f99b.m(this.f98a);
        }
    }

    public static f e() {
        if (f97d == null) {
            f97d = new f();
        }
        return f97d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        this.f98a = "0";
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        this.f98a += ((TextView) view).getText().toString();
        d();
    }

    public void c(ConstraintLayout constraintLayout) {
        constraintLayout.findViewById(R.id.button1).setOnClickListener(this.f100c);
        constraintLayout.findViewById(R.id.button2).setOnClickListener(this.f100c);
        constraintLayout.findViewById(R.id.button3).setOnClickListener(this.f100c);
        constraintLayout.findViewById(R.id.button4).setOnClickListener(this.f100c);
        constraintLayout.findViewById(R.id.button5).setOnClickListener(this.f100c);
        constraintLayout.findViewById(R.id.button6).setOnClickListener(this.f100c);
        constraintLayout.findViewById(R.id.button7).setOnClickListener(this.f100c);
        constraintLayout.findViewById(R.id.button8).setOnClickListener(this.f100c);
        constraintLayout.findViewById(R.id.button9).setOnClickListener(this.f100c);
        constraintLayout.findViewById(R.id.button0).setOnClickListener(this.f100c);
        constraintLayout.findViewById(R.id.buttonCls).setOnClickListener(new View.OnClickListener() { // from class: B2.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f96a.h(view);
            }
        });
    }

    public int f() {
        return Integer.parseInt(this.f98a);
    }

    public C0362u g() {
        return this.f99b;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002d  */
    /* JADX WARN: Code duplicated, block: B:17:0x0044  */
    /* JADX WARN: Code duplicated, block: B:18:0x005b  */
    /* JADX WARN: Code duplicated, block: B:19:0x0072  */
    /* JADX WARN: Code duplicated, block: B:20:0x0089  */
    /* JADX WARN: Code duplicated, block: B:21:0x009f  */
    /* JADX WARN: Code duplicated, block: B:22:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:23:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:24:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:25:0x00f7  */
    /* JADX WARN: Instruction removed from duplicated block: B:16:0x002d, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:17:0x0044, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:18:0x005b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:19:0x0072, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:20:0x0089, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x009f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:22:0x00b5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:23:0x00cb, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:24:0x00e1, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:25:0x00f7, please report this as an issue */
    public boolean j(KeyEvent keyEvent) {
        boolean z3 = true;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode >= 144 && keyCode <= 153 && (keyEvent.getMetaState() & 2097152) != 2097152) {
                return false;
            }
            if (keyCode != 67) {
                switch (keyCode) {
                    case 7:
                        this.f98a += "0";
                        break;
                    case 8:
                        this.f98a += "1";
                        break;
                    case 9:
                        this.f98a += "2";
                        break;
                    case 10:
                        this.f98a += "3";
                        break;
                    case 11:
                        this.f98a += "4";
                        break;
                    case 12:
                        this.f98a += "5";
                        break;
                    case 13:
                        this.f98a += "6";
                        break;
                    case 14:
                        this.f98a += "7";
                        break;
                    case 15:
                        this.f98a += "8";
                        break;
                    case 16:
                        this.f98a += "9";
                        break;
                    default:
                        switch (keyCode) {
                            case 144:
                                this.f98a += "0";
                                break;
                            case 145:
                                this.f98a += "1";
                                break;
                            case 146:
                                this.f98a += "2";
                                break;
                            case 147:
                                this.f98a += "3";
                                break;
                            case 148:
                                this.f98a += "4";
                                break;
                            case 149:
                                this.f98a += "5";
                                break;
                            case 150:
                                this.f98a += "6";
                                break;
                            case 151:
                                this.f98a += "7";
                                break;
                            case 152:
                                this.f98a += "8";
                                break;
                            case 153:
                                this.f98a += "9";
                                break;
                            default:
                                z3 = false;
                                break;
                        }
                        break;
                }
            } else {
                this.f98a = "0";
            }
            d();
        }
        return z3;
    }

    public void k(int i3) {
        String str = String.format(Locale.ENGLISH, "%d", Integer.valueOf(i3));
        this.f98a = str;
        this.f99b.m(str);
    }
}
