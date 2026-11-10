package rawbt.sdk.btpair;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BtDevAdapter extends BaseAdapter {
    private final String curMac;
    private List<BluetoothDevice> devices = new ArrayList();
    private final LayoutInflater lInflater;

    public BtDevAdapter(Context context, String str) {
        this.lInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.curMac = str;
    }

    public void add(BluetoothDevice bluetoothDevice) {
        this.devices.add(bluetoothDevice);
    }

    public void clear() {
        this.devices.clear();
    }

    public String getAddress(int i3) {
        return this.devices.get(i3).getAddress();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.devices.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.lInflater.inflate(R.layout.btdev_item, viewGroup, false);
        }
        BluetoothDevice item = getItem(i3);
        if (item == null) {
            return null;
        }
        try {
            TextView textView = (TextView) view.findViewById(R.id.bt_name);
            textView.setText(BtDeviceSelectHelper.fixDevName(item.getName()));
            TextView textView2 = (TextView) view.findViewById(R.id.bt_mac);
            String address = item.getAddress();
            textView2.setText(address);
            ImageView imageView = (ImageView) view.findViewById(R.id.bt_class);
            if (item.getBluetoothClass().getMajorDeviceClass() == 1536 && (item.getBluetoothClass().getDeviceClass() & 112) == 0) {
                Resources resources = view.getResources();
                int i4 = R.color.color_important;
                textView.setTextColor(resources.getColor(i4));
                textView2.setTextColor(view.getResources().getColor(i4));
                imageView.setImageResource(R.drawable.class_printer);
            } else {
                Resources resources2 = view.getResources();
                int i5 = R.color.gray;
                textView.setTextColor(resources2.getColor(i5));
                textView2.setTextColor(view.getResources().getColor(i5));
                imageView.setImageResource(R.drawable.class_unknown);
            }
            TextView textView3 = (TextView) view.findViewById(R.id.bt_type);
            int type = item.getType();
            if (type == 1) {
                textView3.setText(R.string.bt_spp);
            } else if (type == 2) {
                textView3.setText(R.string.bt_ble);
            } else if (type != 3) {
                textView3.setText(R.string.bt_unknown);
            } else {
                textView3.setText(R.string.bt_dual);
            }
            if (address.equals(this.curMac)) {
                textView.setTextColor(view.getResources().getColor(R.color.colorAccent));
            }
            return view;
        } catch (Exception unused) {
            return null;
        }
    }

    public void setList(List<BluetoothDevice> list) {
        this.devices = list;
    }

    @Override // android.widget.Adapter
    public BluetoothDevice getItem(int i3) {
        return this.devices.get(i3);
    }
}
