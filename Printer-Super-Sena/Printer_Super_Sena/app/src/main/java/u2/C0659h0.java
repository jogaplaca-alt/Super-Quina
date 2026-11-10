package u2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import rawbt.sdk.PrinterEncoding;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.activity.MainActivity;

/* JADX INFO: renamed from: u2.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0659h0 extends AbstractComponentCallbacksC0337e {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    View f12201b0;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S1(View view) {
        String language = PrinterEncoding.getCurrentLocale(t()).getLanguage();
        ((MainActivity) r1()).a0("https://support.google.com/googleplay/answer/1267137?co=GENIE.Platform%3DAndroid&hl=" + language);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(View view) {
        String language = PrinterEncoding.getCurrentLocale(t()).getLanguage();
        ((MainActivity) r1()).a0("https://support.google.com/googleplay/answer/2479637?hl=" + language);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_faq_lic, viewGroup, false);
        this.f12201b0 = viewInflate;
        viewInflate.findViewById(R.id.link_faq_google_payments).setOnClickListener(new View.OnClickListener() { // from class: u2.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12191a.S1(view);
            }
        });
        this.f12201b0.findViewById(R.id.link_faq_google_refunds).setOnClickListener(new View.OnClickListener() { // from class: u2.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12196a.T1(view);
            }
        });
        return this.f12201b0;
    }
}
