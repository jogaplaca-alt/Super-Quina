package rawbt.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import rawbt.sdk.PrinterInfo;

/* JADX INFO: loaded from: classes.dex */
public class SelectPrinterAdapter extends ArrayAdapter<PrinterInfo> {
    private final LayoutInflater lInflater;
    Context mCTx;
    List<PrinterInfo> printerEntities;
    int resource;

    public SelectPrinterAdapter(Context context, int i3) {
        super(context, i3);
        this.mCTx = context;
        this.resource = i3;
        this.lInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.printerEntities = new ArrayList();
    }

    @Override // android.widget.ArrayAdapter
    public void clear() {
        this.printerEntities.clear();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.printerEntities.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.lInflater.inflate(android.R.layout.simple_list_item_single_choice, viewGroup, false);
        }
        ((TextView) view).setText(this.printerEntities.get(i3).description);
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.lInflater.inflate(this.resource, viewGroup, false);
        }
        ((TextView) view).setText(this.printerEntities.get(i3).description);
        return view;
    }

    @Override // android.widget.ArrayAdapter
    public void add(PrinterInfo printerInfo) {
        this.printerEntities.add(printerInfo);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public PrinterInfo getItem(int i3) {
        return this.printerEntities.get(i3);
    }
}
