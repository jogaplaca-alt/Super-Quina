package u2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class U extends AbstractComponentCallbacksC0337e {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    View f12114b0;

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_faq_connect, viewGroup, false);
        this.f12114b0 = viewInflate;
        return viewInflate;
    }
}
