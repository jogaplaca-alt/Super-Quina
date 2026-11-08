package com.superquina.printer;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.print.PrintAttributes;
import android.print.PrintJob;
import android.print.PrinterCapabilitiesInfo;
import android.print.PrinterId;
import android.print.PrinterInfo;
import android.printservice.PrintService;
import android.printservice.PrinterDiscoverySession;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.printservice.PrintDocument;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Android Print Framework entry point. This is intentionally a separate native
 * service, following the RawBT architectural pattern. Transport and document
 * rendering are added in the next implementation stage.
 */
public final class SuperQuinaPrintService extends PrintService {
    private static final String TAG = "SuperQuinaPrint";
    private static final String SERVICE_ID = "superquina-bt-spp";

    @Override
    protected PrinterDiscoverySession onCreatePrinterDiscoverySession() {
        return new BluetoothPrinterDiscoverySession(this);
    }

    @Override
    protected void onPrintJobQueued(PrintJob printJob) {
        // Do not report success until a physical transport has accepted the job.
        // This initial stage fails explicitly rather than silently discarding it.
        Log.w(TAG, "Print job received; document transport pipeline is not enabled yet: " + printJob.getId());
        printJob.fail("A impressão Bluetooth ainda não está disponível nesta versão. Atualize o aplicativo.");
    }

    @Override
    protected void onRequestCancelPrintJob(PrintJob printJob) {
        if (!printJob.isCompleted()) {
            printJob.cancel();
        }
    }

    private static final class BluetoothPrinterDiscoverySession extends PrinterDiscoverySession {
        private final Context context;
        private final List<PrinterInfo> discovered = new ArrayList<>();

        BluetoothPrinterDiscoverySession(Context context) {
            this.context = context.getApplicationContext();
        }

        @Override
        public void onStartPrinterDiscovery(List<PrinterId> priorityList) {
            refresh();
        }

        @Override
        public void onStopPrinterDiscovery() {
            // No active scan is started: only already-paired Bluetooth devices
            // are exposed in this first SPP-only implementation.
        }

        @Override
        public void onValidatePrinters(List<PrinterId> printerIds) {
            refresh();
        }

        @Override
        public void onStartPrinterStateTracking(PrinterId printerId) {
            refresh();
        }

        @Override
        public void onStopPrinterStateTracking(PrinterId printerId) {
        }

        @Override
        public void onDestroy() {
            discovered.clear();
        }

        private void refresh() {
            List<PrinterInfo> next = new ArrayList<>();
            BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
            if (adapter != null && adapter.isEnabled()) {
                try {
                    Set<BluetoothDevice> paired = adapter.getBondedDevices();
                    for (BluetoothDevice device : paired) {
                        String address = device.getAddress();
                        String name = device.getName();
                        PrinterId id = generatePrinterId(address);
                        PrinterInfo.Builder printer = new PrinterInfo.Builder(
                            id,
                            name == null || name.trim().isEmpty() ? "Impressora Bluetooth" : name,
                            PrinterInfo.STATUS_IDLE
                        );
                        printer.setDescription("Bluetooth clássico · perfil térmico 58 mm");
                        printer.setCapabilities(capabilities(id));
                        next.add(printer.build());
                    }
                } catch (SecurityException error) {
                    Log.e(TAG, "Bluetooth permission missing during printer discovery", error);
                }
            }
            List<PrinterId> removed = new ArrayList<>();
            for (PrinterInfo old : discovered) {
                boolean exists = false;
                for (PrinterInfo current : next) {
                    if (old.getId().equals(current.getId())) { exists = true; break; }
                }
                if (!exists) removed.add(old.getId());
            }
            if (!removed.isEmpty()) removePrinters(removed);
            if (!next.isEmpty()) addPrinters(next);
            discovered.clear();
            discovered.addAll(next);
        }

        private PrinterCapabilitiesInfo capabilities(PrinterId id) {
            PrintAttributes.MediaSize roll = new PrintAttributes.MediaSize(
                "SUPERQUINA_ROLL_58",
                "Bobina térmica 58 mm",
                2280,
                1000000
            );
            PrintAttributes.Resolution resolution = new PrintAttributes.Resolution(
                "THERMAL_203",
                "Térmica 203 dpi",
                203,
                203
            );
            return new PrinterCapabilitiesInfo.Builder(id)
                .addMediaSize(roll, true)
                .addResolution(resolution, true)
                .setColorModes(PrintAttributes.COLOR_MODE_MONOCHROME, PrintAttributes.COLOR_MODE_MONOCHROME)
                .setMinMargins(PrintAttributes.Margins.NO_MARGINS)
                .build();
        }
    }
}
