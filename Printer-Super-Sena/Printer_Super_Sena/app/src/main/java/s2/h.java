package s2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class h extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f11742a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LayoutInflater f11743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference f11744c;

    public h(Context context) {
        this.f11744c = new WeakReference(context);
        this.f11743b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public void a(List list) {
        this.f11742a = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11742a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f11742a.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return ((n2.c) this.f11742a.get(i3)).f10236e;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        String str;
        if (view == null) {
            view = this.f11743b.inflate(R.layout.history_item, viewGroup, false);
        }
        n2.c cVar = (n2.c) getItem(i3);
        ((TextView) view.findViewById(R.id.h_data)).setText(cVar.f10232a);
        TextView textView = (TextView) view.findViewById(R.id.h_note);
        if (cVar.f10234c == 0) {
            str = "" + ((Context) this.f11744c.get()).getString(R.string.hex);
        } else {
            str = "" + ((Context) this.f11744c.get()).getString(R.string.ascii) + " " + cVar.f10233b;
        }
        textView.setText(str);
        return view;
    }
}
