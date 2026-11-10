package ru.a402d.rawbtprinter.activity;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AbstractActivityC0248d;
import androidx.appcompat.app.AbstractC0245a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.lifecycle.InterfaceC0363v;
import androidx.lifecycle.P;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import r2.W2;
import rawbt.api.RawbtApiHelper;
import rawbt.sdk.IConsole;
import rawbt.sdk.IRawBtPrintService;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.utils.RawbtHelper;
import ru.a402d.rawbtprinter.AppDatabase;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
public class DebugActivity extends AbstractActivityC0248d implements W2 {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    static int f11299A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    w2.D f11300a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DebugActivity f11304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Spinner f11305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Spinner f11306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private s2.a f11307h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f11308i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    ArrayAdapter f11311l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    s2.h f11312m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    ListView f11313n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    LinearLayout f11314o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ConstraintLayout f11315p;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    SharedPreferences f11319t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f11320u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f11321v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f11322w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Handler f11323x;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    PrinterEntity f11301b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ExecutorService f11302c = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Handler f11303d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f11309j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f11310k = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final p004b.c f11316q = registerForActivityResult(new p008c.b(), new p004b.b() { // from class: r2.V
        @Override // p004b.b
        public final void onActivityResult(Object obj) {
            this.f10981a.S((Uri) obj);
        }
    });

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private IRawBtPrintService f11317r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ServiceConnection f11318s = new a();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final IConsole f11324y = new e();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f11325z = false;

    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            DebugActivity.this.f11317r = IRawBtPrintService.Stub.asInterface(iBinder);
            DebugActivity.this.setTitle("Debug console");
            try {
                DebugActivity.this.f11317r.registerConsole(DebugActivity.this.f11324y);
                DebugActivity.this.R0();
            } catch (RemoteException unused) {
                DebugActivity debugActivity = DebugActivity.this;
                debugActivity.l0(debugActivity.getString(R.string.fatal_unable_connect_console));
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            DebugActivity debugActivity = DebugActivity.this;
            debugActivity.l0(debugActivity.getString(R.string.service_disconected));
            DebugActivity.this.f11317r = null;
        }
    }

    class b extends BottomSheetBehavior.g {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View view, float f3) {
            DebugActivity.this.i0();
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void c(View view, int i3) {
            DebugActivity.this.i0();
        }
    }

    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            DebugActivity.this.W0(adapterView.getSelectedItem().toString());
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            DebugActivity.this.X0(i3);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class e extends IConsole.Stub {
        e() {
        }

        @Override // rawbt.sdk.IConsole
        public void onDeviceReceived(byte[] bArr) {
            DebugActivity.this.f11323x.sendMessageDelayed(DebugActivity.this.f11323x.obtainMessage(5, bArr), 0L);
        }

        @Override // rawbt.sdk.IConsole
        public void onDeviceSent(byte[] bArr) {
            DebugActivity.this.f11323x.sendMessageDelayed(DebugActivity.this.f11323x.obtainMessage(6, bArr), 0L);
        }

        @Override // rawbt.sdk.IConsole
        public void onError(String str) {
            DebugActivity.this.f11323x.sendMessageDelayed(DebugActivity.this.f11323x.obtainMessage(4, str), 0L);
        }

        @Override // rawbt.sdk.IConsole
        public void onNotify(String str) {
            DebugActivity.this.f11323x.sendMessageDelayed(DebugActivity.this.f11323x.obtainMessage(3, str), 0L);
        }

        @Override // rawbt.sdk.IConsole
        public void onPrinterConnect() {
            DebugActivity.this.f11323x.sendMessageDelayed(DebugActivity.this.f11323x.obtainMessage(1), 0L);
        }

        @Override // rawbt.sdk.IConsole
        public void onPrinterDisconnect() {
            DebugActivity.this.f11323x.sendMessageDelayed(DebugActivity.this.f11323x.obtainMessage(2), 0L);
        }
    }

    private final class f extends Handler {
        f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    DebugActivity.this.f11304e.o0();
                    break;
                case 2:
                    DebugActivity.this.f11304e.p0();
                    break;
                case 3:
                    DebugActivity.this.f11304e.n0((String) message.obj);
                    break;
                case 4:
                    DebugActivity.this.f11304e.l0((String) message.obj);
                    break;
                case 5:
                    DebugActivity.this.f11304e.q0((byte[]) message.obj);
                    break;
                case 6:
                    DebugActivity.this.f11304e.r0((byte[]) message.obj);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(View view) {
        final n2.c cVar = new n2.c(this.f11308i.getText().toString(), this.f11321v, this.f11320u, this.f11322w);
        AppDatabase appDatabaseH = RawPrinterApp.h();
        Objects.requireNonNull(appDatabaseH);
        final n2.a aVarC = appDatabaseH.C();
        this.f11302c.execute(new Runnable() { // from class: r2.K
            @Override // java.lang.Runnable
            public final void run() {
                this.f10922a.t0(aVarC, cVar);
            }
        });
        V0(cVar);
        this.f11303d.post(new Runnable() { // from class: r2.M
            @Override // java.lang.Runnable
            public final void run() {
                this.f10932a.u0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(View view) {
        this.f11308i.append("ESC;");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(View view) {
        this.f11308i.append("FS;");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(View view) {
        this.f11308i.append("GS;");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(View view) {
        this.f11308i.append("SOH;");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(View view) {
        this.f11308i.append("STX;");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(View view) {
        this.f11308i.append(";");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(View view) {
        this.f11308i.append("CR;");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0() {
        try {
            this.f11317r.printerConnectByName(this.f11301b.getName());
        } catch (RemoteException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0() {
        try {
            this.f11317r.printerDisconnect();
        } catch (RemoteException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0() {
        this.f11306g.setSelection(this.f11311l.getPosition(this.f11321v));
        this.f11305f.setSelection(this.f11322w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(List list) {
        this.f11312m.a(list);
        this.f11312m.notifyDataSetChanged();
        this.f11313n.setSelection(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(int i3) {
        AppDatabase appDatabaseH = RawPrinterApp.h();
        Objects.requireNonNull(appDatabaseH);
        n2.a aVarC = appDatabaseH.C();
        final List listB = aVarC.b(i3);
        if (RawPrinterApp.l() && listB != null) {
            listB.add(new n2.c(getString(R.string.buy_premium_from_console), "Cp437", 1, 0));
        }
        if (listB != null) {
            this.f11303d.post(new Runnable() { // from class: r2.Q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10955a.L0(listB);
                }
            });
            List listA = aVarC.a(100);
            if (listA != null) {
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    aVarC.d((n2.c) it.next());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(Uri uri, int i3, String str) {
        try {
            IRawBtPrintService iRawBtPrintService = this.f11317r;
            boolean z3 = true;
            if (i3 != 1) {
                z3 = false;
            }
            iRawBtPrintService.sendFile(uri, z3, str);
        } catch (Exception e3) {
            this.f11323x.sendMessageDelayed(this.f11323x.obtainMessage(4, e3.getLocalizedMessage()), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            this.f11317r.printerSend(byteArrayOutputStream.toByteArray());
        } catch (Exception e3) {
            this.f11323x.sendMessageDelayed(this.f11323x.obtainMessage(4, e3.getLocalizedMessage()), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(ProgressDialog progressDialog) {
        try {
            String str = "console_log_" + new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date(System.currentTimeMillis())) + ".txt";
            File file = new File(this.f11304e.getCacheDir(), "share");
            file.mkdir();
            File file2 = new File(file.getPath(), str);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            int count = this.f11307h.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                outputStreamWriter.write(this.f11307h.getItem(i3).toString() + "\n");
            }
            outputStreamWriter.close();
            fileOutputStream.close();
            Uri uriH = FileProvider.h(this.f11304e, "ru.a402d.rawbtprinter.fileprovider", file2);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uriH);
            intent.setType("text/plain");
            startActivity(intent);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        progressDialog.dismiss();
    }

    private void Q0() {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", "file:///android_asset/terminal.html");
        intent.setType("text/html");
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        if (this.f11317r == null || this.f11301b == null) {
            return;
        }
        this.f11302c.execute(new Runnable() { // from class: r2.L
            @Override // java.lang.Runnable
            public final void run() {
                this.f10928a.I0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Parcelable parcelable) {
        if (parcelable == null) {
            return;
        }
        if (!(parcelable instanceof Uri)) {
            parcelable = Uri.parse(parcelable.toString());
        }
        U0((Uri) parcelable, this.f11320u, this.f11321v);
    }

    private void S0() {
        this.f11302c.execute(new Runnable() { // from class: r2.A
            @Override // java.lang.Runnable
            public final void run() {
                this.f10875a.J0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        final int i3 = RawPrinterApp.l() ? 10 : 50;
        this.f11302c.execute(new Runnable() { // from class: r2.O
            @Override // java.lang.Runnable
            public final void run() {
                this.f10944a.M0(i3);
            }
        });
    }

    private void U0(final Uri uri, final int i3, final String str) {
        Toast.makeText(this, getString(R.string.sending), 0).show();
        this.f11302c.execute(new Runnable() { // from class: r2.N
            @Override // java.lang.Runnable
            public final void run() {
                this.f10937a.N0(uri, i3, str);
            }
        });
    }

    private void V0(n2.c cVar) {
        if (!this.f11325z) {
            Toast.makeText(this.f11304e, getString(R.string.printer_not_connected), 0).show();
            return;
        }
        String str = cVar.f10232a;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (cVar.f10234c == 1 && cVar.f10235d == 4) {
            byteArrayOutputStream.write(2);
        }
        try {
            if (cVar.f10234c == 1) {
                byteArrayOutputStream.write(str.getBytes(cVar.f10233b));
            } else {
                byteArrayOutputStream.write(RawbtHelper.getBytesWithCp(str, cVar.f10233b));
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        if (cVar.f10234c == 1) {
            int i3 = cVar.f10235d;
            if (i3 == 1) {
                byteArrayOutputStream.write(13);
                byteArrayOutputStream.write(10);
            } else if (i3 == 2) {
                byteArrayOutputStream.write(13);
            } else if (i3 == 3) {
                byteArrayOutputStream.write(10);
            } else if (i3 == 4) {
                byteArrayOutputStream.write(3);
            } else if (i3 == 5) {
                byteArrayOutputStream.write(0);
            }
        }
        this.f11302c.execute(new Runnable() { // from class: r2.P
            @Override // java.lang.Runnable
            public final void run() {
                this.f10950a.O0(byteArrayOutputStream);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(String str) {
        if (this.f11321v.equals(str)) {
            return;
        }
        this.f11321v = str;
        SharedPreferences.Editor editorEdit = this.f11319t.edit();
        editorEdit.putString("TERMINAL_CP", this.f11321v);
        editorEdit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(int i3) {
        if (this.f11322w == i3) {
            return;
        }
        this.f11322w = i3;
        SharedPreferences.Editor editorEdit = this.f11319t.edit();
        editorEdit.putInt("TERMINAL_LF", this.f11322w);
        editorEdit.commit();
    }

    private void Y0() {
        final ProgressDialog progressDialogShow = ProgressDialog.show(this.f11304e, "", getString(R.string.generating_wait), true);
        this.f11302c.execute(new Runnable() { // from class: r2.T
            @Override // java.lang.Runnable
            public final void run() {
                this.f10971a.P0(progressDialogShow);
            }
        });
    }

    private void Z0() {
        if (this.f11320u == 0) {
            this.f11320u = 1;
        } else {
            this.f11320u = 0;
        }
        SharedPreferences.Editor editorEdit = this.f11319t.edit();
        editorEdit.putInt("TERMINAL_MODE", this.f11320u);
        editorEdit.commit();
        invalidateOptionsMenu();
        refresh();
    }

    public static ArrayList j0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("UTF-8");
        arrayList.add("BIG5");
        arrayList.add("EUC-KR");
        arrayList.add("GBK");
        arrayList.add("Cp437");
        arrayList.add("Cp720");
        arrayList.add("Cp737");
        arrayList.add("Cp747");
        arrayList.add("Cp775");
        arrayList.add("Cp850");
        arrayList.add("Cp851");
        arrayList.add("Cp852");
        arrayList.add("Cp853");
        arrayList.add("Cp855");
        arrayList.add("Cp857");
        arrayList.add("Cp858");
        arrayList.add("Cp860");
        arrayList.add("Cp861");
        arrayList.add("Cp862");
        arrayList.add("Cp863");
        arrayList.add("Cp864");
        arrayList.add("Cp865");
        arrayList.add("Cp866");
        arrayList.add("Cp869");
        arrayList.add("Cp932");
        arrayList.add("Cp1251");
        arrayList.add("Cp1252");
        arrayList.add("Cp1253");
        arrayList.add("Cp1255");
        arrayList.add("Cp1257");
        arrayList.add("iso8859-2");
        arrayList.add("iso8859-7");
        arrayList.add("iso8859-8");
        arrayList.add("iso8859-9");
        return arrayList;
    }

    static ArrayList k0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("None");
        arrayList.add("CR/LF");
        arrayList.add("CR");
        arrayList.add("LF");
        arrayList.add("STX/ETX");
        arrayList.add("NUL");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(String str) {
        h0("ERR");
        if (str == null) {
            str = getString(R.string.unknown_error);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)), 0, spannableStringBuilder.length(), 33);
        this.f11307h.a(spannableStringBuilder);
        this.f11307h.notifyDataSetChanged();
    }

    private void m0() {
        int intExtra = getIntent().getIntExtra("id", 0);
        if (intExtra > 0) {
            this.f11300a.v0(intExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(String str) {
        h0("INFO");
        this.f11307h.b(str);
        this.f11307h.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        this.f11325z = true;
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        this.f11325z = false;
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(byte[] bArr) {
        int i3;
        h0("RCV");
        if (this.f11320u == 1) {
            try {
                this.f11307h.b(new String(bArr, this.f11321v));
                this.f11307h.notifyDataSetChanged();
                return;
            } catch (UnsupportedEncodingException unused) {
                this.f11307h.b(RawbtHelper.bytesToHexFormatted(bArr, bArr.length) + "\n");
            }
        } else {
            int length = bArr.length;
            byte[] bArr2 = new byte[8];
            int i4 = 0;
            while (true) {
                i3 = length - i4;
                if (i3 <= 8) {
                    break;
                }
                String str = String.format("%06X|", Long.valueOf(16777215 & this.f11310k));
                System.arraycopy(bArr, i4, bArr2, 0, 8);
                this.f11307h.b(str + RawbtHelper.bytesToHexWithAscii(bArr2, 8));
                i4 += 8;
                this.f11310k = this.f11310k + 8;
            }
            if (i3 > 0) {
                String str2 = String.format("%06X|", Long.valueOf(16777215 & this.f11310k));
                System.arraycopy(bArr, i4, bArr2, 0, i3);
                this.f11307h.b(str2 + RawbtHelper.bytesToHexWithAscii(bArr2, i3));
                this.f11310k = this.f11310k + ((long) i3);
            }
        }
        this.f11307h.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(byte[] bArr) {
        int i3;
        h0("SEND");
        if (this.f11320u == 1) {
            try {
                this.f11307h.b(new String(bArr, this.f11321v).replace('\r', ' ').replace('\n', ' '));
                this.f11307h.notifyDataSetChanged();
                return;
            } catch (UnsupportedEncodingException unused) {
            }
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[8];
        int i4 = 0;
        while (true) {
            i3 = length - i4;
            if (i3 <= 8) {
                break;
            }
            String str = String.format("%06X|", Long.valueOf(16777215 & this.f11309j));
            System.arraycopy(bArr, i4, bArr2, 0, 8);
            this.f11307h.b(str + RawbtHelper.bytesToHexWithAscii(bArr2, 8));
            i4 += 8;
            this.f11309j = this.f11309j + 8;
        }
        if (i3 > 0) {
            String str2 = String.format("%06X|", Long.valueOf(16777215 & this.f11309j));
            System.arraycopy(bArr, i4, bArr2, 0, i3);
            this.f11307h.b(str2 + RawbtHelper.bytesToHexWithAscii(bArr2, i3));
            this.f11309j = this.f11309j + ((long) i3);
        }
        this.f11307h.notifyDataSetChanged();
    }

    private void refresh() {
        if (this.f11320u == 0) {
            findViewById(R.id.escButtons).setVisibility(0);
            findViewById(R.id.asciiButtons).setVisibility(8);
            ((EditText) findViewById(R.id.send_text)).setHint(R.string.hex);
        }
        if (this.f11320u == 1) {
            findViewById(R.id.escButtons).setVisibility(8);
            findViewById(R.id.asciiButtons).setVisibility(0);
            ((EditText) findViewById(R.id.send_text)).setHint(R.string.ascii);
        }
        this.f11303d.post(new Runnable() { // from class: r2.W
            @Override // java.lang.Runnable
            public final void run() {
                this.f10986a.K0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(int i3, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParams2 = this.f11314o.getLayoutParams();
        layoutParams2.height = i3;
        this.f11314o.setLayoutParams(layoutParams2);
        f11299A = i3;
        this.f11315p.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(n2.a aVar, n2.c cVar) {
        aVar.c(cVar);
        this.f11303d.post(new Runnable() { // from class: r2.S
            @Override // java.lang.Runnable
            public final void run() {
                this.f10966a.T0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0() {
        this.f11308i.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(View view) {
        this.f11308i.append("^");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(View view) {
        this.f11308i.append("~");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(AdapterView adapterView, View view, int i3, long j3) {
        n2.c cVar = (n2.c) this.f11312m.getItem(i3);
        this.f11308i.setText(cVar.f10232a);
        W0(cVar.f10233b);
        X0(cVar.f10235d);
        if (this.f11320u != cVar.f10234c) {
            Z0();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(PrinterEntity printerEntity) {
        if (printerEntity != null && printerEntity.getId() >= 3) {
            boolean z3 = this.f11301b == null;
            this.f11301b = printerEntity;
            setTitle(printerEntity.getName());
            if (z3) {
                R0();
            }
        }
    }

    @Override // r2.W2
    public void d() {
        try {
            this.f11316q.a("*/*");
        } catch (Exception unused) {
            Toast.makeText(this, R.string.need_external_fm, 1).show();
        }
    }

    void h0(String str) {
        int color;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(DateFormat.getTimeInstance().format(new Date()) + " " + str + "> ");
        spannableStringBuilder.setSpan(new RelativeSizeSpan(0.75f), 0, spannableStringBuilder.length(), 33);
        if ("RCV".equals(str)) {
            color = getResources().getColor(R.color.colorReceivedText);
        } else if ("SEND".equals(str)) {
            color = getResources().getColor(R.color.colorSendText);
        } else {
            color = "ERR".equals(str) ? getResources().getColor(R.color.colorErrText) : getResources().getColor(R.color.colorStatusText);
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 33);
        this.f11307h.a(spannableStringBuilder);
    }

    void i0() {
        Rect rect = new Rect();
        findViewById(R.id.debug_view).getWindowVisibleDisplayFrame(rect);
        final ViewGroup.LayoutParams layoutParams = this.f11315p.getLayoutParams();
        layoutParams.height = (int) (rect.height() - ((getResources().getDisplayMetrics().densityDpi / 160.0f) * 200.0f));
        final int y3 = ((int) this.f11315p.getY()) - 1;
        if (f11299A != y3) {
            this.f11303d.post(new Runnable() { // from class: r2.U
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10976a.s0(y3, layoutParams);
                }
            });
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11300a = (w2.D) new P(this).a(w2.D.class);
        this.f11304e = this;
        setContentView(R.layout.activity_debug);
        AbstractC0245a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.s(true);
        }
        setTitle(R.string.wait);
        this.f11323x = new f(getMainLooper());
        SharedPreferences preferences = getPreferences(0);
        this.f11319t = preferences;
        this.f11320u = preferences.getInt("TERMINAL_MODE", 0);
        this.f11322w = this.f11319t.getInt("TERMINAL_LF", 1);
        this.f11321v = this.f11319t.getString("TERMINAL_CP", "Cp437");
        ListView listView = (ListView) findViewById(R.id.receive_text);
        s2.a aVar = new s2.a(this);
        this.f11307h = aVar;
        listView.setAdapter((ListAdapter) aVar);
        this.f11308i = (TextView) findViewById(R.id.send_text);
        findViewById(R.id.send_btn).setOnClickListener(new View.OnClickListener() { // from class: r2.X
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10989a.A0(view);
            }
        });
        this.f11314o = (LinearLayout) findViewById(R.id.scrollBlock);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.bottom_sheet);
        this.f11315p = constraintLayout;
        BottomSheetBehavior bottomSheetBehaviorQ0 = BottomSheetBehavior.q0(constraintLayout);
        bottomSheetBehaviorQ0.O0((int) ((getResources().getDisplayMetrics().densityDpi / 160.0f) * 128.0f));
        bottomSheetBehaviorQ0.c0(new b());
        ViewGroup.LayoutParams layoutParams = this.f11315p.getLayoutParams();
        layoutParams.height = (int) ((getResources().getDisplayMetrics().densityDpi / 160.0f) * 310.0f);
        this.f11315p.setLayoutParams(layoutParams);
        findViewById(R.id.btnESC).setOnClickListener(new View.OnClickListener() { // from class: r2.B
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10879a.B0(view);
            }
        });
        findViewById(R.id.btnFS).setOnClickListener(new View.OnClickListener() { // from class: r2.C
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10883a.C0(view);
            }
        });
        findViewById(R.id.btnGS).setOnClickListener(new View.OnClickListener() { // from class: r2.D
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10888a.D0(view);
            }
        });
        findViewById(R.id.btnSOH).setOnClickListener(new View.OnClickListener() { // from class: r2.E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10893a.E0(view);
            }
        });
        findViewById(R.id.btnSTX).setOnClickListener(new View.OnClickListener() { // from class: r2.F
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10898a.F0(view);
            }
        });
        findViewById(R.id.btnSemicolon).setOnClickListener(new View.OnClickListener() { // from class: r2.G
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10903a.G0(view);
            }
        });
        findViewById(R.id.btnCR).setOnClickListener(new View.OnClickListener() { // from class: r2.H
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10908a.H0(view);
            }
        });
        findViewById(R.id.btnCaret).setOnClickListener(new View.OnClickListener() { // from class: r2.I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10914a.v0(view);
            }
        });
        findViewById(R.id.btnTilda).setOnClickListener(new View.OnClickListener() { // from class: r2.J
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10918a.w0(view);
            }
        });
        this.f11306g = (Spinner) findViewById(R.id.encodeSpinner);
        this.f11305f = (Spinner) findViewById(R.id.lfSpinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, j0());
        this.f11311l = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11306g.setAdapter((SpinnerAdapter) this.f11311l);
        this.f11306g.setOnItemSelectedListener(new c());
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, k0());
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11305f.setAdapter((SpinnerAdapter) arrayAdapter2);
        this.f11305f.setOnItemSelectedListener(new d());
        this.f11312m = new s2.h(this);
        ListView listView2 = (ListView) findViewById(R.id.history_list);
        this.f11313n = listView2;
        listView2.setAdapter((ListAdapter) this.f11312m);
        this.f11313n.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: r2.Y
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
                this.f10992a.x0(adapterView, view, i3, j3);
            }
        });
        T0();
        findViewById(R.id.debug_view).addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: r2.Z
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                this.f10996a.y0(view, i3, i4, i5, i6, i7, i8, i9, i10);
            }
        });
        this.f11300a.P().g(this, new InterfaceC0363v() { // from class: r2.a0
            @Override // androidx.lifecycle.InterfaceC0363v
            public final void a(Object obj) {
                this.f11001a.z0((PrinterEntity) obj);
            }
        });
        if (bundle == null) {
            m0();
        }
        bindService(RawbtApiHelper.createExplicitIntent(), this.f11318s, 1);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.terminal, menu);
        return true;
    }

    @Override // androidx.appcompat.app.AbstractActivityC0248d, androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f11317r != null) {
            unbindService(this.f11318s);
        }
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i3, KeyEvent keyEvent) {
        if ((keyEvent.getMetaState() & 8192) == 0 || i3 != 43) {
            return super.onKeyShortcut(i3, keyEvent);
        }
        d();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.terminal_mode) {
            Z0();
        }
        if (itemId == R.id.terminal_connect) {
            R0();
        }
        if (itemId == R.id.terminal_disconnect) {
            S0();
        }
        if (itemId == R.id.terminal_clear) {
            this.f11307h.c();
            this.f11307h.notifyDataSetChanged();
        }
        if (itemId == R.id.terminal_send_file) {
            if (this.f11325z) {
                d();
            } else {
                Toast.makeText(this.f11304e, getString(R.string.printer_not_connected), 0).show();
            }
        }
        if (itemId == R.id.terminal_share) {
            Y0();
        }
        if (itemId == R.id.terminal_help) {
            Q0();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R.id.terminal_mode);
        if (this.f11320u == 0) {
            menuItemFindItem.setTitle("HEX");
        } else {
            menuItemFindItem.setTitle("ASCII");
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.terminal_connect);
        MenuItem menuItemFindItem3 = menu.findItem(R.id.terminal_disconnect);
        menuItemFindItem2.setVisible(!this.f11325z);
        menuItemFindItem3.setVisible(this.f11325z);
        return true;
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onResume() {
        super.onResume();
        refresh();
        i0();
    }
}
