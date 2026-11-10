package A;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: renamed from: A.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0155a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f56a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f57b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f58c;

    public C0155a(int i3, T t3, int i4) {
        this.f56a = i3;
        this.f57b = t3;
        this.f58c = i4;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f56a);
        this.f57b.c0(this.f58c, bundle);
    }
}
