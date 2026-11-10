package ru.a402d.rawbtprinter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AbstractActivityC0248d;
import androidx.appcompat.app.AbstractC0245a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.InterfaceC0363v;
import java.util.Locale;
import rawbt.sdk.dao.PrinterEntity;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class CalcDotsActivity extends AbstractActivityC0248d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f11292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f11293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f11294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private B2.f f11295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11296e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    PrinterEntity f11297f;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(View view) {
        C(72);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(View view) {
        C(104);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        C(this.f11295d.f());
    }

    private void x() {
        PrinterEntity printerEntity = (PrinterEntity) getIntent().getParcelableExtra("printer");
        this.f11297f = printerEntity;
        if (printerEntity.getDensity() == 304) {
            this.f11296e = 12;
        }
        if (this.f11297f.getDensity() == 203) {
            this.f11296e = 8;
        }
        this.f11295d.k(this.f11297f.getDots_per_line() / this.f11296e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(String str) {
        this.f11292a.setText(str);
        TextView textView = this.f11293b;
        Locale locale = Locale.ENGLISH;
        textView.setText(String.format(locale, "%d *", Integer.valueOf(this.f11296e)));
        this.f11294c.setText(String.format(locale, "mm = %d", Integer.valueOf(this.f11296e * Integer.parseInt(str))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        C(48);
    }

    void C(int i3) {
        Intent intent = new Intent();
        intent.putExtra("dots", i3 * this.f11296e);
        setResult(-1, intent);
        finish();
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_calc_dots);
        AbstractC0245a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.s(true);
        }
        this.f11292a = (TextView) findViewById(R.id.mm_value);
        this.f11293b = (TextView) findViewById(R.id.dpi_mult);
        this.f11294c = (TextView) findViewById(R.id.dots_count);
        B2.f fVarE = B2.f.e();
        this.f11295d = fVarE;
        fVarE.c((ConstraintLayout) findViewById(R.id.layoutKeyboard));
        this.f11295d.g().g(this, new InterfaceC0363v() { // from class: r2.v
            @Override // androidx.lifecycle.InterfaceC0363v
            public final void a(Object obj) {
                this.f11104a.y((String) obj);
            }
        });
        findViewById(R.id.buttonEnter).setOnClickListener(new View.OnClickListener() { // from class: r2.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11108a.lambda$onCreate$1(view);
            }
        });
        findViewById(R.id.button2fn).setOnClickListener(new View.OnClickListener() { // from class: r2.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11113a.z(view);
            }
        });
        findViewById(R.id.button3fn).setOnClickListener(new View.OnClickListener() { // from class: r2.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11117a.A(view);
            }
        });
        findViewById(R.id.button4fn).setOnClickListener(new View.OnClickListener() { // from class: r2.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11120a.B(view);
            }
        });
        if (bundle == null) {
            x();
        }
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i3 != 66) {
            return B2.f.e().j(keyEvent);
        }
        C(this.f11295d.f());
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        this.f11296e = bundle.getInt("dpi", 1);
        super.onRestoreInstanceState(bundle);
        String str = (String) this.f11295d.g().e();
        TextView textView = this.f11293b;
        Locale locale = Locale.ENGLISH;
        textView.setText(String.format(locale, "%d *", Integer.valueOf(this.f11296e)));
        this.f11294c.setText(String.format(locale, "mm = %d", Integer.valueOf(this.f11296e * Integer.parseInt(str))));
    }

    @Override // androidx.activity.h, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("dpi", this.f11296e);
    }
}
