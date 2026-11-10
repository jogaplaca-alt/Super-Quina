package rawbt.sdk.dao;

import androidx.lifecycle.AbstractC0360s;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface PrintersModel {
    void delete(PrinterEntity printerEntity);

    List<PrinterEntity> getAll();

    AbstractC0360s getAllLive();

    PrinterEntity getById(int i3);

    PrinterEntity getByName(String str);

    PrinterEntity getByUsbParam(String str, String str2);

    PrinterEntity getDefault();

    List<PrinterEntity> getReal();

    long insert(PrinterEntity printerEntity);

    void setDefault(int i3);

    void storeLastPrintParam(String str, String str2, boolean z3);

    void update(PrinterEntity printerEntity);
}
