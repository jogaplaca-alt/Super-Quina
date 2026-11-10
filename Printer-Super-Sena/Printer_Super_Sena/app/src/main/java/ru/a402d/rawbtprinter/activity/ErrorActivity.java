package ru.a402d.rawbtprinter.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class ErrorActivity extends Activity {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.setAction("rawbtprinter.a402d.ru.FAQ_ERROR");
        startActivity(intent);
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_error);
        ((TextView) findViewById(R.id.textViewError)).setText(getIntent().getStringExtra("android.intent.extra.SUBJECT"));
        findViewById(R.id.btnErrorClose).setOnClickListener(new View.OnClickListener() { // from class: r2.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11109a.c(view);
            }
        });
        findViewById(R.id.btnHelp).setOnClickListener(new View.OnClickListener() { // from class: r2.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11114a.d(view);
            }
        });
    }
}
