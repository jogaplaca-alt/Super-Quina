package s2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.android.billingclient.api.Purchase;
import java.util.ArrayList;
import java.util.List;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class d extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f11723b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LayoutInflater f11724c;

    public d(Context context) {
        this.f11722a = context;
        this.f11724c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public void a(List list) {
        this.f11723b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11723b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f11723b.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x002a  */
    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        String string;
        if (view == null) {
            view = this.f11724c.inflate(R.layout.purchase_item, viewGroup, false);
        }
        Purchase purchase = (Purchase) this.f11723b.get(i3);
        String str = (String) purchase.i().get(0);
        str.hashCode();
        switch (str) {
            case "year":
                string = this.f11722a.getString(R.string._1_year);
                break;
            case "month":
                string = this.f11722a.getString(R.string._1_month);
                break;
            case "quarter":
                string = this.f11722a.getString(R.string._3_months);
                break;
            case "lifetime":
                string = this.f11722a.getString(R.string.forever);
                break;
            default:
                string = "wrong";
                break;
        }
        String strA = purchase.a();
        if (purchase.e() == 2) {
            strA = this.f11722a.getString(R.string.pending_payment);
        }
        ((TextView) view.findViewById(R.id.sku_name)).setText(string);
        ((TextView) view.findViewById(R.id.sku_note)).setText(strA);
        return view;
    }
}
