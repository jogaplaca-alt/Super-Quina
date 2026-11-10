package ru.a402d.rawbtprinter.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AbstractC0245a;
import androidx.lifecycle.InterfaceC0363v;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rawbt.api.RawbtApiHelper;
import rawbt.sdk.IConsole;
import rawbt.sdk.IRawBtPrintService;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.drivers.PaperangP1Driver;
import rawbt.sdk.drivers.PaperangP2Driver;
import rawbt.sdk.drivers.responses.BatteryResponse;
import rawbt.sdk.drivers.responses.IResponse;
import rawbt.sdk.drivers.responses.ModelResponse;
import rawbt.sdk.drivers.responses.ModelVersionResponse;
import rawbt.sdk.drivers.responses.SerialNumberResponse;
import rawbt.sdk.profiles.PrinterProfilePaperang;
import rawbt.sdk.transport.Constant;
import rawbt.sdk.transport.PrintToMemory;
import rawbt.sdk.utils.BytesBuffer;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class ProfilePaperangActivity extends AbstractActivityC0634m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayAdapter f11457g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    volatile PaperangP1Driver f11464n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Context f11465o;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ExecutorService f11454d = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Handler f11455e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Spinner f11456f = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11458h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private IRawBtPrintService f11459i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ServiceConnection f11460j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final IConsole f11461k = new b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    PrintToMemory f11462l = new PrintToMemory();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    volatile BytesBuffer f11463m = new BytesBuffer();

    class a implements ServiceConnection {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            Toast.makeText(ProfilePaperangActivity.this.f11465o, "db model not response", 0).show();
            ProfilePaperangActivity.this.findViewById(R.id.progress_Paperang).setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            try {
                PrinterEntity printerEntity = (PrinterEntity) ProfilePaperangActivity.this.f11571c.P().e();
                for (int i3 = 0; printerEntity == null && i3 < 1000; i3++) {
                    Thread.sleep(10L);
                    printerEntity = (PrinterEntity) ProfilePaperangActivity.this.f11571c.P().e();
                }
                if (printerEntity == null) {
                    ProfilePaperangActivity.this.f11455e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.G
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11357a.c();
                        }
                    });
                    return;
                }
                if (Constant.DRIVER_PAPERANG.equals(printerEntity.getProfileClass())) {
                    ProfilePaperangActivity.this.f11458h = 1;
                    ProfilePaperangActivity.this.f11464n = new PaperangP1Driver(new PrinterProfilePaperang(), ProfilePaperangActivity.this);
                } else {
                    ProfilePaperangActivity.this.f11464n = new PaperangP2Driver(new PrinterProfilePaperang(), ProfilePaperangActivity.this);
                }
                ProfilePaperangActivity.this.f11464n.setTransport(ProfilePaperangActivity.this.f11462l);
                ProfilePaperangActivity.this.f11459i.printerConnectByName(printerEntity.getName());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ProfilePaperangActivity.this.f11459i = IRawBtPrintService.Stub.asInterface(iBinder);
            try {
                ProfilePaperangActivity.this.f11459i.registerConsole(ProfilePaperangActivity.this.f11461k);
                ProfilePaperangActivity.this.f11454d.execute(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.F
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11356a.d();
                    }
                });
            } catch (RemoteException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ProfilePaperangActivity.this.f11459i = null;
        }
    }

    class b extends IConsole.Stub {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void U(String str) {
            ((TextView) ProfilePaperangActivity.this.findViewById(R.id.info_paperang_sn)).setText(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void V(String str) {
            ((TextView) ProfilePaperangActivity.this.findViewById(R.id.info_paperang_model)).setText(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void W(String str) {
            ((TextView) ProfilePaperangActivity.this.findViewById(R.id.info_paperang_ver)).setText(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void X(int i3) {
            ((TextView) ProfilePaperangActivity.this.findViewById(R.id.info_paperang_bat)).setText(String.format(Locale.ENGLISH, "%d%%", Integer.valueOf(i3)));
            ProfilePaperangActivity.this.findViewById(R.id.progress_Paperang).setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void Y(String str) {
            Toast.makeText(ProfilePaperangActivity.this.f11465o, str, 0).show();
            ProfilePaperangActivity.this.findViewById(R.id.progress_Paperang).setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void Z() {
            try {
                ProfilePaperangActivity.this.f11463m.clear();
                ProfilePaperangActivity.this.f11464n.registerCrcKey();
                ProfilePaperangActivity.this.f11459i.printerSend(ProfilePaperangActivity.this.f11462l.getBuffer());
                Thread.sleep(200L);
                ProfilePaperangActivity.this.f11464n.getHardwareModel();
                ProfilePaperangActivity.this.f11459i.printerSend(ProfilePaperangActivity.this.f11462l.getBuffer());
                Thread.sleep(200L);
                ProfilePaperangActivity.this.f11464n.getHardwareVersion();
                ProfilePaperangActivity.this.f11459i.printerSend(ProfilePaperangActivity.this.f11462l.getBuffer());
                Thread.sleep(200L);
                ProfilePaperangActivity.this.f11464n.getBattery();
                ProfilePaperangActivity.this.f11459i.printerSend(ProfilePaperangActivity.this.f11462l.getBuffer());
                Thread.sleep(200L);
                ProfilePaperangActivity.this.f11464n.getSerialNumber();
                ProfilePaperangActivity.this.f11459i.printerSend(ProfilePaperangActivity.this.f11462l.getBuffer());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a0() {
            ProfilePaperangActivity.this.findViewById(R.id.selfTestPrint).setVisibility(8);
        }

        @Override // rawbt.sdk.IConsole
        public void onDeviceReceived(byte[] bArr) {
            ProfilePaperangActivity.this.f11463m.add(bArr);
            byte[] buffer = ProfilePaperangActivity.this.f11463m.getBuffer();
            for (IResponse iResponse : ProfilePaperangActivity.this.f11458h == 2 ? PaperangP2Driver.parseResponse(buffer) : PaperangP1Driver.parseResponse(buffer)) {
                if (iResponse instanceof SerialNumberResponse) {
                    final String sn = ((SerialNumberResponse) iResponse).getSn();
                    ProfilePaperangActivity.this.f11455e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.I
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11359a.U(sn);
                        }
                    });
                }
                if (iResponse instanceof ModelResponse) {
                    final String model = ((ModelResponse) iResponse).getModel();
                    ProfilePaperangActivity.this.f11455e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.J
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11361a.V(model);
                        }
                    });
                }
                if (iResponse instanceof ModelVersionResponse) {
                    final String modelVersion = ((ModelVersionResponse) iResponse).getModelVersion();
                    ProfilePaperangActivity.this.f11455e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.K
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11363a.W(modelVersion);
                        }
                    });
                }
                if (iResponse instanceof BatteryResponse) {
                    final int percent = ((BatteryResponse) iResponse).getPercent();
                    ProfilePaperangActivity.this.f11455e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.L
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11365a.X(percent);
                        }
                    });
                }
            }
        }

        @Override // rawbt.sdk.IConsole
        public void onDeviceSent(byte[] bArr) {
        }

        @Override // rawbt.sdk.IConsole
        public void onError(final String str) {
            ProfilePaperangActivity.this.f11455e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.N
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11411a.Y(str);
                }
            });
        }

        @Override // rawbt.sdk.IConsole
        public void onNotify(String str) {
        }

        @Override // rawbt.sdk.IConsole
        public void onPrinterConnect() {
            ProfilePaperangActivity.this.findViewById(R.id.selfTestPrint).setVisibility(8);
            ProfilePaperangActivity.this.f11454d.execute(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.M
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11367a.Z();
                }
            });
        }

        @Override // rawbt.sdk.IConsole
        public void onPrinterDisconnect() {
            ProfilePaperangActivity.this.f11455e.post(new Runnable() { // from class: ru.a402d.rawbtprinter.activity.H
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11358a.a0();
                }
            });
        }
    }

    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            ((TextView) adapterView.getChildAt(0)).setTextColor(ProfilePaperangActivity.this.getResources().getColor(R.color.colorAccent));
            ProfilePaperangActivity.this.f11571c.W0(Integer.parseInt(adapterView.getSelectedItem().toString()) * 1000);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(View view) {
        this.f11571c.G0(304);
        this.f11571c.W0(3000);
        this.f11571c.I0(576);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        this.f11571c.G0(304);
        this.f11571c.W0(5000);
        this.f11571c.I0(864);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view) {
        this.f11571c.F0(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(View view) {
        this.f11571c.F0(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(View view) {
        this.f11571c.F0(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        try {
            this.f11464n.testPage();
            this.f11459i.printerSend(this.f11462l.getBuffer());
        } catch (RemoteException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(View view) {
        this.f11454d.execute(new Runnable() { // from class: r2.j2
            @Override // java.lang.Runnable
            public final void run() {
                this.f11042a.N();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(PrinterEntity printerEntity) {
        int darkness = printerEntity.getDarkness();
        if (darkness == 0) {
            ((RadioButton) findViewById(R.id.dark0)).setChecked(true);
        } else if (darkness == 1) {
            ((RadioButton) findViewById(R.id.dark1)).setChecked(true);
        } else if (darkness == 2) {
            ((RadioButton) findViewById(R.id.dark2)).setChecked(true);
        }
        try {
            this.f11456f.setSelection(this.f11457g.getPosition("" + (printerEntity.getSleepAfter() / 1000)));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        this.f11571c.G0(304);
        this.f11571c.W0(6000);
        this.f11571c.I0(936);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        this.f11571c.G0(203);
        this.f11571c.W0(1000);
        this.f11571c.I0(384);
        finish();
    }

    @Override // ru.a402d.rawbtprinter.activity.AbstractActivityC0634m, androidx.fragment.app.AbstractActivityC0338f, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11465o = this;
        setContentView(R.layout.activity_profile_paperang);
        setTitle("Paperang profile");
        AbstractC0245a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.s(true);
        }
        findViewById(R.id.radioModelC1).setOnClickListener(new View.OnClickListener() { // from class: r2.a2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11005a.lambda$onCreate$0(view);
            }
        });
        findViewById(R.id.radioModelP1).setOnClickListener(new View.OnClickListener() { // from class: r2.b2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11009a.lambda$onCreate$1(view);
            }
        });
        findViewById(R.id.radioModelP2).setOnClickListener(new View.OnClickListener() { // from class: r2.c2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11012a.I(view);
            }
        });
        findViewById(R.id.radioModelP3).setOnClickListener(new View.OnClickListener() { // from class: r2.d2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11016a.J(view);
            }
        });
        findViewById(R.id.dark0).setOnClickListener(new View.OnClickListener() { // from class: r2.e2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11020a.K(view);
            }
        });
        findViewById(R.id.dark1).setOnClickListener(new View.OnClickListener() { // from class: r2.f2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11024a.L(view);
            }
        });
        findViewById(R.id.dark2).setOnClickListener(new View.OnClickListener() { // from class: r2.g2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11028a.M(view);
            }
        });
        this.f11456f = (Spinner) findViewById(R.id.delayBeforeDisconnect);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this, R.array.lanDelayAfter, android.R.layout.simple_spinner_item);
        this.f11457g = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.f11456f.setAdapter((SpinnerAdapter) this.f11457g);
        this.f11456f.setOnItemSelectedListener(new c());
        findViewById(R.id.selfTestPrint).setOnClickListener(new View.OnClickListener() { // from class: r2.h2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11033a.O(view);
            }
        });
        this.f11571c.P().g(this, new InterfaceC0363v() { // from class: r2.i2
            @Override // androidx.lifecycle.InterfaceC0363v
            public final void a(Object obj) {
                this.f11038a.P((PrinterEntity) obj);
            }
        });
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    protected void onPause() {
        super.onPause();
        IRawBtPrintService iRawBtPrintService = this.f11459i;
        if (iRawBtPrintService != null) {
            try {
                iRawBtPrintService.printerDisconnect();
            } catch (RemoteException e3) {
                e3.printStackTrace();
            }
            unbindService(this.f11460j);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0338f, android.app.Activity
    public void onResume() {
        super.onResume();
        findViewById(R.id.selfTestPrint).setVisibility(8);
        bindService(RawbtApiHelper.createExplicitIntent(), this.f11460j, 1);
    }
}
