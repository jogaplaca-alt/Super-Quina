package u2;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.activity.MainActivity;
import ru.a402d.rawbtprinter.activity.PermissionsActivity;

/* JADX INFO: renamed from: u2.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0650e0 extends AbstractComponentCallbacksC0337e {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    View f12159b0;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(View view) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:rawbt@402d.ru"));
        intent.putExtra("subject", "RawBT ESC/POS");
        try {
            L1(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(r1(), "NO EMAIL APP", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y1(View view) {
        ((MainActivity) r1()).B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(View view) {
        ((MainActivity) r1()).z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a2(View view) {
        ((MainActivity) r1()).A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b2(View view) {
        L1(new Intent(r1(), (Class<?>) PermissionsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c2(View view) {
        ((MainActivity) r1()).a0("https://www.youtube.com/watch?v=AFjY6DX6y0I");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(View view) {
        ((MainActivity) r1()).a0("https://4pda.to/forum/index.php?showtopic=886170");
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_faq, viewGroup, false);
        this.f12159b0 = viewInflate;
        viewInflate.findViewById(R.id.sendEmail).setOnClickListener(new View.OnClickListener() { // from class: u2.X
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12122a.X1(view);
            }
        });
        this.f12159b0.findViewById(R.id.link_faq_license).setOnClickListener(new View.OnClickListener() { // from class: u2.Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12126a.Y1(view);
            }
        });
        this.f12159b0.findViewById(R.id.faq_connect).setOnClickListener(new View.OnClickListener() { // from class: u2.Z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12130a.Z1(view);
            }
        });
        this.f12159b0.findViewById(R.id.faq_error).setOnClickListener(new View.OnClickListener() { // from class: u2.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12140a.a2(view);
            }
        });
        this.f12159b0.findViewById(R.id.settings_permissions).setOnClickListener(new View.OnClickListener() { // from class: u2.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12148a.b2(view);
            }
        });
        this.f12159b0.findViewById(R.id.link_youtube_chrome_bag).setOnClickListener(new View.OnClickListener() { // from class: u2.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12151a.c2(view);
            }
        });
        this.f12159b0.findViewById(R.id.link_4pda).setOnClickListener(new View.OnClickListener() { // from class: u2.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12155a.d2(view);
            }
        });
        return this.f12159b0;
    }
}
