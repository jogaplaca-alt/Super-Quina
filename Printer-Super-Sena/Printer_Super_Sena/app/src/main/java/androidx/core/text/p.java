package androidx.core.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class p implements Spannable {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextPaint f4558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextDirectionHeuristic f4559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f4560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f4561d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final PrecomputedText.Params f4562e;

        /* JADX INFO: renamed from: androidx.core.text.p$a$a, reason: collision with other inner class name */
        public static class C0059a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final TextPaint f4563a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private TextDirectionHeuristic f4564b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f4565c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f4566d;

            public C0059a(TextPaint textPaint) {
                this.f4563a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f4565c = 1;
                    this.f4566d = 1;
                } else {
                    this.f4566d = 0;
                    this.f4565c = 0;
                }
                this.f4564b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            public a a() {
                return new a(this.f4563a, this.f4564b, this.f4565c, this.f4566d);
            }

            public C0059a b(int i3) {
                this.f4565c = i3;
                return this;
            }

            public C0059a c(int i3) {
                this.f4566d = i3;
                return this;
            }

            public C0059a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f4564b = textDirectionHeuristic;
                return this;
            }
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i3, int i4) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f4562e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i3).setHyphenationFrequency(i4).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f4562e = null;
            }
            this.f4558a = textPaint;
            this.f4559b = textDirectionHeuristic;
            this.f4560c = i3;
            this.f4561d = i4;
        }

        public boolean a(a aVar) {
            int i3 = Build.VERSION.SDK_INT;
            if ((i3 >= 23 && (this.f4560c != aVar.b() || this.f4561d != aVar.c())) || this.f4558a.getTextSize() != aVar.e().getTextSize() || this.f4558a.getTextScaleX() != aVar.e().getTextScaleX() || this.f4558a.getTextSkewX() != aVar.e().getTextSkewX()) {
                return false;
            }
            if ((i3 >= 21 && (this.f4558a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f4558a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()))) || this.f4558a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i3 >= 24) {
                if (!this.f4558a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (!this.f4558a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            if (this.f4558a.getTypeface() == null) {
                return aVar.e().getTypeface() == null;
            }
            return this.f4558a.getTypeface().equals(aVar.e().getTypeface());
        }

        public int b() {
            return this.f4560c;
        }

        public int c() {
            return this.f4561d;
        }

        public TextDirectionHeuristic d() {
            return this.f4559b;
        }

        public TextPaint e() {
            return this.f4558a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f4559b == aVar.d();
        }

        public int hashCode() {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 24) {
                return p082z.c.b(Float.valueOf(this.f4558a.getTextSize()), Float.valueOf(this.f4558a.getTextScaleX()), Float.valueOf(this.f4558a.getTextSkewX()), Float.valueOf(this.f4558a.getLetterSpacing()), Integer.valueOf(this.f4558a.getFlags()), this.f4558a.getTextLocales(), this.f4558a.getTypeface(), Boolean.valueOf(this.f4558a.isElegantTextHeight()), this.f4559b, Integer.valueOf(this.f4560c), Integer.valueOf(this.f4561d));
            }
            return i3 >= 21 ? p082z.c.b(Float.valueOf(this.f4558a.getTextSize()), Float.valueOf(this.f4558a.getTextScaleX()), Float.valueOf(this.f4558a.getTextSkewX()), Float.valueOf(this.f4558a.getLetterSpacing()), Integer.valueOf(this.f4558a.getFlags()), this.f4558a.getTextLocale(), this.f4558a.getTypeface(), Boolean.valueOf(this.f4558a.isElegantTextHeight()), this.f4559b, Integer.valueOf(this.f4560c), Integer.valueOf(this.f4561d)) : p082z.c.b(Float.valueOf(this.f4558a.getTextSize()), Float.valueOf(this.f4558a.getTextScaleX()), Float.valueOf(this.f4558a.getTextSkewX()), Integer.valueOf(this.f4558a.getFlags()), this.f4558a.getTextLocale(), this.f4558a.getTypeface(), this.f4559b, Integer.valueOf(this.f4560c), Integer.valueOf(this.f4561d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f4558a.getTextSize());
            sb.append(", textScaleX=" + this.f4558a.getTextScaleX());
            sb.append(", textSkewX=" + this.f4558a.getTextSkewX());
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 21) {
                sb.append(", letterSpacing=" + this.f4558a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f4558a.isElegantTextHeight());
            }
            if (i3 >= 24) {
                sb.append(", textLocale=" + this.f4558a.getTextLocales());
            } else {
                sb.append(", textLocale=" + this.f4558a.getTextLocale());
            }
            sb.append(", typeface=" + this.f4558a.getTypeface());
            if (i3 >= 26) {
                sb.append(", variationSettings=" + this.f4558a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f4559b);
            sb.append(", breakStrategy=" + this.f4560c);
            sb.append(", hyphenationFrequency=" + this.f4561d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f4558a = params.getTextPaint();
            this.f4559b = params.getTextDirection();
            this.f4560c = params.getBreakStrategy();
            this.f4561d = params.getHyphenationFrequency();
            this.f4562e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
