package u2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.activity.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public class W extends AbstractComponentCallbacksC0337e {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    View f12119b0;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R1(View view) {
        ((MainActivity) r1()).z();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_faq_error, viewGroup, false);
        this.f12119b0 = viewInflate;
        viewInflate.findViewById(R.id.faq_connect).setOnClickListener(new View.OnClickListener() { // from class: u2.V
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12117a.R1(view);
            }
        });
        return this.f12119b0;
    }
}
