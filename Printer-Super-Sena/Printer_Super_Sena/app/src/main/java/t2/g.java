package t2;

import android.view.View;
import android.widget.ScrollView;
import com.google.android.material.textfield.TextInputEditText;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScrollView f11863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextInputEditText f11864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScrollView f11865c;

    private g(ScrollView scrollView, TextInputEditText textInputEditText, ScrollView scrollView2) {
        this.f11863a = scrollView;
        this.f11864b = textInputEditText;
        this.f11865c = scrollView2;
    }

    public static g a(View view) {
        TextInputEditText textInputEditText = (TextInputEditText) p025g0.a.a(view, R.id.input_area);
        if (textInputEditText == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.input_area)));
        }
        ScrollView scrollView = (ScrollView) view;
        return new g(scrollView, textInputEditText, scrollView);
    }
}
