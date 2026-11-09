package br.com.superquina.printer

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.pm.PackageManager
import android.os.Build
import android.print.PrintJob
import android.print.PrinterId
import android.printservice.PrintService
import android.printservice.PrinterDiscoverySession
import androidx.annotation.RequiresApi

/**
 * Android Print Framework entry point.
 *
 * Chrome/system print UI discovers this service because it is declared as a
 * PrintService in AndroidManifest.xml. The service must advertise printers;
 * pairing a device alone does not make it appear in the print picker.
 */
class BluetoothPrintService : PrintService() {
    override fun onCreatePrinterDiscoverySession(): PrinterDiscoverySession =
        BluetoothPrinterDiscoverySession(this)

    override fun onPrintJobQueued(printJob: PrintJob) {
        // TODO: Implement the complete pipeline:
        // 1. Open printJob.document data (Android PDF spool).
        // 2. Render pages at the selected printer's 58 mm printable width.
        // 3. Encode raster rows as ESC/POS.
        // 4. Connect to the selected paired device using BluetoothSocket/RFCOMM.
        // 5. Stream bytes, close socket and report completed/failed state.
        //
        // Do not mark a job complete until bytes have been sent successfully.
        printJob.fail("Impressão térmica ainda não implementada nesta etapa.")
    }

    override fun onRequestCancelPrintJob(printJob: PrintJob) {
        // TODO: Cancel active socket/write operation and update job state.
        if (printJob.isQueued || printJob.isStarted) {
            printJob.cancel()
        }
    }
}

private class BluetoothPrinterDiscoverySession(
    private val service: BluetoothPrintService
) : PrinterDiscoverySession() {

    override fun onStartPrinterDiscovery(priorityList: MutableList<PrinterId>) {
        discoverPairedPrinters()
    }

    override fun onStopPrinterDiscovery() = Unit

    override fun onValidatePrinters(printerIds: MutableList<PrinterId>) {
        discoverPairedPrinters()
    }

    override fun onStartPrinterStateTracking(printerId: PrinterId) {
        discoverPairedPrinters()
    }

    override fun onStopPrinterStateTracking(printerId: PrinterId) = Unit

    override fun onDestroy() = Unit

    private fun discoverPairedPrinters() {
        val adapter = BluetoothAdapter.getDefaultAdapter()
        if (adapter == null || !adapter.isEnabled) {
            addPrinters(emptyList())
            return
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
            service.checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED
        ) {
            // The app's setup screen must request BLUETOOTH_CONNECT at runtime.
            addPrinters(emptyList())
            return
        }

        try {
            val printers = adapter.bondedDevices.map { device ->
                val id = service.generatePrinterId(device.address)
                android.print.PrinterInfo.Builder(
                    id,
                    device.name ?: "Impressora Bluetooth",
                    android.print.PrinterInfo.STATUS_IDLE
                ).build()
            }
            addPrinters(printers)
        } catch (_: SecurityException) {
            addPrinters(emptyList())
        }
    }
}
