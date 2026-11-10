package u2;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesPdf;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: renamed from: u2.h1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0660h1 extends AbstractComponentCallbacksC0337e {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    AttributesImage f12205e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    AttributesPdf f12206f0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private ImageView f12208h0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    ExecutorService f12202b0 = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    Handler f12203c0 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f12204d0 = 0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private boolean f12207g0 = true;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(z2.f fVar) {
        final Bitmap bitmapCall = fVar.call();
        this.f12203c0.post(new Runnable() { // from class: u2.g1
            @Override // java.lang.Runnable
            public final void run() {
                this.f12197a.S1(bitmapCall);
            }
        });
    }

    public static C0660h1 U1(int i3, boolean z3, AttributesPdf attributesPdf, AttributesImage attributesImage) {
        C0660h1 c0660h1 = new C0660h1();
        Bundle bundle = new Bundle();
        bundle.putInt("arg_page_number", i3);
        bundle.putBoolean("arg_no_frame", z3);
        bundle.putParcelable("arg_attr_pdf", attributesPdf);
        bundle.putParcelable("arg_attr_img", attributesImage);
        c0660h1.A1(bundle);
        return c0660h1;
    }

    /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
    public void S1(Bitmap bitmap) {
        this.f12208h0.setImageBitmap(bitmap);
        this.f12208h0.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void p0(Bundle bundle) {
        super.p0(bundle);
        if (r() != null) {
            this.f12204d0 = r().getInt("arg_page_number");
            this.f12207g0 = r().getBoolean("arg_no_frame");
            this.f12205e0 = (AttributesImage) r().getParcelable("arg_attr_img");
            this.f12206f0 = (AttributesPdf) r().getParcelable("arg_attr_pdf");
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        z2.g gVar;
        final z2.f fVar;
        View viewInflate = layoutInflater.inflate(R.layout.fragment_pdf_page, viewGroup, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.imageView);
        this.f12208h0 = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        if (this.f12207g0) {
            fVar = new z2.f(this, this.f12204d0);
        } else {
            gVar = new z2.g(this, this.f12204d0);
            gVar.h(y2.b.w().o());
            gVar.d(this.f12205e0);
            gVar.e(this.f12206f0);
            if ((r1().getResources().getConfiguration().uiMode & 48) == 32) {
                fVar = gVar;
                gVar.f(-16777216);
                gVar.g(-12303292);
                fVar = gVar;
            }
        }
        fVar = gVar;
        this.f12202b0.execute(new Runnable() { // from class: u2.f1
            @Override // java.lang.Runnable
            public final void run() {
                this.f12192a.T1(fVar);
            }
        });
        return viewInflate;
    }
}
