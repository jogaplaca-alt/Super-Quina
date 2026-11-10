package w2;

import android.bluetooth.BluetoothDevice;
import android.hardware.usb.UsbDevice;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.AbstractC0360s;
import androidx.lifecycle.C0362u;
import androidx.lifecycle.O;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.dao.PrintersModel;
import rawbt.sdk.drivers.PosDriverInterface;
import ru.a402d.rawbtprinter.AppDatabase;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
public class D extends O {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PrintersModel f12708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private C0362u f12709g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final C0362u f12713k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final C0362u f12714l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ExecutorService f12706d = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Handler f12707e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final C0362u f12710h = new C0362u();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final C0362u f12711i = new C0362u();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final C0362u f12712j = new C0362u();

    public D() {
        Boolean bool = Boolean.FALSE;
        this.f12713k = new C0362u(bool);
        this.f12714l = new C0362u(bool);
        AppDatabase appDatabaseH = RawPrinterApp.h();
        Objects.requireNonNull(appDatabaseH);
        this.f12708f = appDatabaseH.D();
        PrinterEntity printerEntity = new PrinterEntity();
        printerEntity.initEncoding(RawPrinterApp.g());
        this.f12709g = new C0362u(printerEntity);
    }

    private void I() {
        int protocol = ((PrinterEntity) this.f12709g.e()).getProtocol();
        if (protocol == 1 || protocol == 6) {
            this.f12714l.m(Boolean.valueOf(this.f12710h.e() != null));
        } else if (protocol == 3 || protocol == 8) {
            this.f12714l.m(Boolean.valueOf(this.f12711i.e() != null));
        } else {
            this.f12714l.m(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
        this.f12709g.m(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T() {
        if (((PrinterEntity) this.f12709g.e()).isCurrent()) {
            this.f12708f.setDefault(1);
        }
        this.f12708f.delete((PrinterEntity) this.f12709g.e());
        this.f12707e.post(new Runnable() { // from class: w2.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f12739a.S();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(PrinterEntity printerEntity) {
        this.f12709g.m(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(int i3) {
        final PrinterEntity byId = this.f12708f.getById(i3);
        this.f12707e.post(new Runnable() { // from class: w2.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f12750a.U(byId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y() {
        RawPrinterApp.h().D().setDefault(((PrinterEntity) this.f12709g.e()).getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(PrinterEntity printerEntity) {
        this.f12708f.update(printerEntity);
    }

    public void A0(BluetoothDevice bluetoothDevice) {
        I();
        this.f12710h.m(bluetoothDevice);
    }

    public void B0(String str, String str2) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null) {
            return;
        }
        if (str.equals(printerEntity.getBytes_init()) && str2.equals(printerEntity.getBytes_finish())) {
            return;
        }
        printerEntity.setBytes_init(str);
        printerEntity.setBytes_finish(str2);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f12744a.a0(printerEntity);
            }
        });
    }

    public void C0(String str) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getCodePage().equals(str)) {
            return;
        }
        printerEntity.setCodePage(str);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f12727a.b0(printerEntity);
            }
        });
    }

    public void D0(Boolean bool) {
        this.f12713k.m(bool);
    }

    public void E0(int i3) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getCutCommand() == i3) {
            return;
        }
        printerEntity.setCutCommand(i3);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f12758a.c0(printerEntity);
            }
        });
    }

    public void F0(int i3) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getDarkness() == i3) {
            return;
        }
        printerEntity.setDarkness(i3);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f12731a.d0(printerEntity);
            }
        });
    }

    public void G0(int i3) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getDensity() == i3) {
            return;
        }
        printerEntity.setDensity(i3);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f12748a.e0(printerEntity);
            }
        });
    }

    public void H0(String str) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getDescription().equals(str)) {
            return;
        }
        printerEntity.setDescription(str);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f12742a.f0(printerEntity);
            }
        });
    }

    public void I0(int i3) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getDots_per_line() == i3) {
            return;
        }
        printerEntity.setDots_per_line(i3);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.C
            @Override // java.lang.Runnable
            public final void run() {
                this.f12704a.g0(printerEntity);
            }
        });
    }

    public void J() {
        if (((PrinterEntity) this.f12709g.e()).getId() < 3) {
            return;
        }
        this.f12706d.execute(new Runnable() { // from class: w2.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f12715a.T();
            }
        });
    }

    public void J0(PosDriverInterface posDriverInterface) {
        this.f12712j.m(posDriverInterface);
    }

    public C0362u K() {
        return this.f12710h;
    }

    public void K0(int i3) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getGraphicsCommand() == i3) {
            return;
        }
        printerEntity.setGraphicsCommand(i3);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f12746a.h0(printerEntity);
            }
        });
    }

    public C0362u L() {
        return this.f12713k;
    }

    public void L0(String str) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getHost().equals(str)) {
            return;
        }
        printerEntity.setHost(str);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f12754a.i0(printerEntity);
            }
        });
    }

    public C0362u M() {
        return this.f12714l;
    }

    public void M0(int i3) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.get_lan_delay() == i3) {
            return;
        }
        printerEntity.setLan_delayMS(i3);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f12725a.j0(printerEntity);
            }
        });
    }

    public PosDriverInterface N() {
        return (PosDriverInterface) this.f12712j.e();
    }

    public void N0(String str) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getMac().equals(str)) {
            return;
        }
        printerEntity.setMac(str);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.A
            @Override // java.lang.Runnable
            public final void run() {
                this.f12700a.k0(printerEntity);
            }
        });
    }

    public AbstractC0360s O() {
        return this.f12708f.getAllLive();
    }

    public void O0(String str) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getName().equals(str)) {
            return;
        }
        printerEntity.setName(str);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f12735a.l0(printerEntity);
            }
        });
    }

    public C0362u P() {
        return this.f12709g;
    }

    public void P0(int i3) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getPort() == i3) {
            return;
        }
        printerEntity.setPort(i3);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f12733a.m0(printerEntity);
            }
        });
    }

    public C0362u Q() {
        return this.f12711i;
    }

    public void Q0(String str) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getPrintLanguage().equals(str)) {
            return;
        }
        printerEntity.setPrintLanguage(str);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f12729a.n0(printerEntity);
            }
        });
    }

    public Boolean R() {
        return (Boolean) this.f12713k.e();
    }

    public void R0(int i3) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getPrintLanguageType() == i3) {
            return;
        }
        printerEntity.setPrintLanguageType(i3);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f12720a.o0(printerEntity);
            }
        });
    }

    public void S0(String str) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getProfileClass().equals(str)) {
            return;
        }
        printerEntity.setProfileClass(str);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f12762a.p0(printerEntity);
            }
        });
    }

    public void T0(int i3) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null) {
            return;
        }
        if (printerEntity.getProtocol() != i3) {
            printerEntity.setProtocol(i3);
            this.f12709g.m(printerEntity);
            this.f12706d.execute(new Runnable() { // from class: w2.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12716a.q0(printerEntity);
                }
            });
        }
        I();
    }

    public void U0(String str) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getSerialComDriver().equals(str)) {
            return;
        }
        printerEntity.setSerialComDriver(str);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f12723a.r0(printerEntity);
            }
        });
    }

    public void V0(int i3) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getSkipLinesAfterJob() == i3) {
            return;
        }
        printerEntity.setSkipLinesAfterJob(i3);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f12737a.s0(printerEntity);
            }
        });
    }

    public void W0(int i3) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getSleepAfter() == i3) {
            return;
        }
        printerEntity.setSleepAfter(i3);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f12718a.t0(printerEntity);
            }
        });
    }

    public void X0(UsbDevice usbDevice) {
        I();
        this.f12711i.m(usbDevice);
    }

    public void Y0(String str, String str2) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null) {
            return;
        }
        if (printerEntity.getPid().equals(str2) && printerEntity.getVid().equals(str)) {
            return;
        }
        printerEntity.setPid(str2);
        printerEntity.setVid(str);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f12752a.u0(printerEntity);
            }
        });
    }

    public void v0(final int i3) {
        this.f12706d.execute(new Runnable() { // from class: w2.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f12740a.V(i3);
            }
        });
    }

    public void w0(int i3) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.get_abs_mode() == i3) {
            return;
        }
        printerEntity.setAbs_mode(i3);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f12760a.W(printerEntity);
            }
        });
    }

    public void x0(boolean z3) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.isAddFrame() == z3) {
            return;
        }
        printerEntity.setAddFrame(z3);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f12756a.X(printerEntity);
            }
        });
    }

    public void y0() {
        PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.isCurrent()) {
            return;
        }
        printerEntity.setCurrent(true);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f12722a.Y();
            }
        });
    }

    public void z0(int i3) {
        final PrinterEntity printerEntity = (PrinterEntity) this.f12709g.e();
        if (printerEntity == null || printerEntity.getBaud() == i3) {
            return;
        }
        printerEntity.setBaud(i3);
        this.f12709g.m(printerEntity);
        this.f12706d.execute(new Runnable() { // from class: w2.B
            @Override // java.lang.Runnable
            public final void run() {
                this.f12702a.Z(printerEntity);
            }
        });
    }
}
