package p035j0;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.Z;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class b extends RecyclerView.D {
    private b(FrameLayout frameLayout) {
        super(frameLayout);
    }

    static b M(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(Z.m());
        frameLayout.setSaveEnabled(false);
        return new b(frameLayout);
    }

    FrameLayout N() {
        return (FrameLayout) this.f5908a;
    }
}
