package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f3072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextClassifier f3073b;

    private static final class a {
        static TextClassifier a(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    D(TextView textView) {
        this.f3072a = (TextView) p082z.h.g(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f3073b;
        return textClassifier == null ? a.a(this.f3072a) : textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f3073b = textClassifier;
    }
}
