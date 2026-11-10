package s2;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList f11711a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f11712b;

    public a(Context context) {
        this.f11712b = context;
    }

    public void a(SpannableStringBuilder spannableStringBuilder) {
        this.f11711a.add(spannableStringBuilder);
    }

    public void b(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        this.f11711a.add(spannableStringBuilder);
    }

    public void c() {
        this.f11711a.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11711a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f11711a.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (textView == null) {
            textView = new TextView(this.f11712b);
            textView.setIncludeFontPadding(false);
            textView.setTypeface(Typeface.MONOSPACE);
        }
        textView.setText((CharSequence) this.f11711a.get(i3));
        return textView;
    }
}
