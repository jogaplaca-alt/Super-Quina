package s2;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class i extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UsbManager f11745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f11746b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LayoutInflater f11747c;

    public i(Context context, UsbManager usbManager) {
        this.f11745a = usbManager;
        this.f11747c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public UsbDevice getItem(int i3) {
        return (UsbDevice) this.f11746b.get(i3);
    }

    public void b(HashMap map) {
        this.f11746b.clear();
        this.f11746b.addAll(map.values());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11746b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f11747c.inflate(R.layout.btdev_item, viewGroup, false);
        }
        UsbDevice item = getItem(i3);
        TextView textView = (TextView) view.findViewById(R.id.bt_name);
        textView.setText(B2.c.b(Build.VERSION.SDK_INT >= 21 ? String.format("%s", item.getProductName()) : String.format("%s", item.getDeviceName())));
        TextView textView2 = (TextView) view.findViewById(R.id.bt_mac);
        textView2.setText(String.format("VID: %s PID: %s Class: %s", Integer.valueOf(item.getVendorId()), Integer.valueOf(item.getProductId()), Integer.valueOf(item.getInterface(0).getInterfaceClass())));
        ImageView imageView = (ImageView) view.findViewById(R.id.bt_class);
        if (item.getInterface(0).getInterfaceClass() == 7) {
            textView.setTextColor(view.getResources().getColor(R.color.color_important));
            textView2.setTextColor(view.getResources().getColor(R.color.color_important));
            imageView.setImageResource(R.drawable.class_printer);
        } else {
            textView.setTextColor(view.getResources().getColor(R.color.gray));
            textView2.setTextColor(view.getResources().getColor(R.color.gray));
            imageView.setImageResource(R.drawable.class_unknown);
        }
        return view;
    }
}
