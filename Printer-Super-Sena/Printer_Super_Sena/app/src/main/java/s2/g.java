package s2;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rawbt.sdk.RawbtPrintJob;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.dao.PrintersModel;
import ru.a402d.rawbtprinter.AppDatabase;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
public class g extends ArrayAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final ExecutorService f11734e = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Handler f11735f = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f11736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LayoutInflater f11737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f11738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final List f11739d;

    public g(Context context, int i3, List list) {
        super(context, i3);
        this.f11736a = context;
        this.f11738c = i3;
        this.f11737b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f11739d = list;
    }

    public static void c(final Context context, final Spinner spinner, final RawbtPrintJob rawbtPrintJob) {
        AppDatabase appDatabaseH = RawPrinterApp.h();
        Objects.requireNonNull(appDatabaseH);
        final PrintersModel printersModelD = appDatabaseH.D();
        f11734e.execute(new Runnable() { // from class: s2.e
            @Override // java.lang.Runnable
            public final void run() {
                g.e(printersModelD, context, spinner, rawbtPrintJob);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(Context context, List list, Spinner spinner, RawbtPrintJob rawbtPrintJob, int i3) {
        g gVar = new g(context, R.layout.simple_spinner_item, list);
        gVar.setDropDownViewResource(R.layout.simple_list_item_single_choice);
        spinner.setAdapter((SpinnerAdapter) gVar);
        spinner.setOnItemSelectedListener(new a(rawbtPrintJob, gVar));
        gVar.clear();
        gVar.addAll(list);
        gVar.notifyDataSetChanged();
        spinner.setSelection(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(PrintersModel printersModel, final Context context, final Spinner spinner, final RawbtPrintJob rawbtPrintJob) {
        try {
            final List<PrinterEntity> all = printersModel.getAll();
            PrinterEntity printerEntity = printersModel.getDefault();
            Iterator<PrinterEntity> it = all.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                } else if (it.next().getName().equals(printerEntity.getName())) {
                    break;
                } else {
                    i3++;
                }
            }
            final int i4 = i3 == -1 ? 0 : i3;
            f11735f.post(new Runnable() { // from class: s2.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.d(context, all, spinner, rawbtPrintJob, i4);
                }
            });
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f11737b.inflate(R.layout.simple_list_item_single_choice, viewGroup, false);
        }
        ((TextView) view).setText(((PrinterEntity) this.f11739d.get(i3)).getDescription());
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f11737b.inflate(this.f11738c, viewGroup, false);
        }
        ((TextView) view).setText(((PrinterEntity) this.f11739d.get(i3)).getDescription());
        return view;
    }

    class a implements AdapterView.OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RawbtPrintJob f11740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f11741b;

        a(RawbtPrintJob rawbtPrintJob, g gVar) {
            this.f11740a = rawbtPrintJob;
            this.f11741b = gVar;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            this.f11740a.setPrinter(((PrinterEntity) this.f11741b.getItem(i3)).getName());
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }
}
