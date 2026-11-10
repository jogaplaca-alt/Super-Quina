package com.hoho.android.usbserial.driver;

import android.util.Pair;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ProbeTable {
    private final Map<Pair<Integer, Integer>, Class<? extends UsbSerialDriver>> mProbeTable = new LinkedHashMap();

    ProbeTable addDriver(Class<? extends UsbSerialDriver> cls) {
        try {
            try {
                for (Map.Entry entry : ((Map) cls.getMethod("getSupportedDevices", null).invoke(null, null)).entrySet()) {
                    int iIntValue = ((Integer) entry.getKey()).intValue();
                    for (int i3 : (int[]) entry.getValue()) {
                        addProduct(iIntValue, i3, cls);
                    }
                }
                return this;
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
                throw new RuntimeException(e3);
            }
        } catch (NoSuchMethodException | SecurityException e4) {
            throw new RuntimeException(e4);
        }
    }

    public ProbeTable addProduct(int i3, int i4, Class<? extends UsbSerialDriver> cls) {
        this.mProbeTable.put(Pair.create(Integer.valueOf(i3), Integer.valueOf(i4)), cls);
        return this;
    }

    public Class<? extends UsbSerialDriver> findDriver(int i3, int i4) {
        return this.mProbeTable.get(Pair.create(Integer.valueOf(i3), Integer.valueOf(i4)));
    }
}
