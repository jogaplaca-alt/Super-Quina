package ru.a402d.rawbtprinter.printservice;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AbstractActivityC0248d;
import ru.a402d.rawbtprinter.activity.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public class SettingsActivity extends AbstractActivityC0248d {
    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.setAction("rawbtprinter.a402d.ru.CONFIG");
        intent.setFlags(65536);
        startActivity(intent);
        finish();
    }
}
