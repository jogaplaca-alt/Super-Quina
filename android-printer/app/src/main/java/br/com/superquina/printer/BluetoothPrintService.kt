package br.com.superquina.printer

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.pm.PackageManager
import android.os.Build
import android.print.PrintAttributes
import android.print.PrinterCapabilitiesInfo
import android.print.PrinterId
import android.print.PrinterInfo
import android.print.PrintJob
import android.printservice.PrintService
import android.printservice.PrinterDiscoverySession

/**
 * Exposes paired Bluetooth Classic printers to Android's system print UI.
 * Android owns preview/document creation. This service will render the queued
 * job in memory, encode ESC/POS raster data and send it over Bluetooth.
 */
class BluetoothPrintService : PrintService() {
    override fun onCreatePrinterDiscoverySession(): PrinterDiscoverySession =
        BluetoothPrinterDiscoverySession(this)

    override fun onPrintJobQueued(printJob: PrintJob) {
        printJob.start()
        // Rendering, ESC/POS encoding and Bluetooth transport are not implemented yet.
        printJob.fail("A impressão Bluetooth ainda está sendo implementada.")
    }

    override fun onRequestCancelPrintJob(printJob: PrintJob) {
        if (printJob.isQueued || printJob.isStarted) printJob.cancel()
    }

    internal fun hasBluetoothConnectPermission(): Boolean =
        Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
            checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED
}

private class BluetoothPrinterDiscoverySession(
    private val service: BluetoothPrintService
) : PrinterDiscoverySession() {
    override fun onStartPrinterDiscovery(priorityList: MutableList<PrinterId>) = discoverPairedPrinters()
    override fun onStopPrinterDiscovery() = Unit
    override fun onValidatePrinters(printerIds: MutableList<PrinterId>) = discoverPairedPrinters()
    override fun onStartPrinterStateTracking(printerId: PrinterId) = discoverPairedPrinters()
    override fun onStopPrinterStateTracking(printerId: PrinterId) = Unit
    override fun onDestroy() = Unit

    private fun discoverPairedPrinters() {
        val adapter = BluetoothAdapter.getDefaultAdapter()
        if (adapter == null || !adapter.isEnabled || !service.hasBluetoothConnectPermission()) {
            addPrinters(emptyList())
            return
        }
        try {
            val printers = adapter.bondedDevices.map { device ->
                val id = service.generatePrinterId(device.address)
                val capabilities = PrinterCapabilitiesInfo.Builder(id)
                    .addMediaSize(
                        PrintAttributes.MediaSize("ROLL_58MM", "Bobina térmica 58 mm", 2283, 11000),
                        true
                    )
                    .addResolution(PrintAttributes.Resolution("R203", "203 dpi", 203, 203), true)
                    .setColorModes(
                        PrintAttributes.COLOR_MODE_MONOCHROME,
                        PrintAttributes.COLOR_MODE_MONOCHROME
                    )
                    .build()
                PrinterInfo.Builder(
                    id,
                    device.name ?: "Impressora Bluetooth",
                    PrinterInfo.STATUS_IDLE
                ).setCapabilities(capabilities).build()
            }
            addPrinters(printers)
        } catch (_: SecurityException) {
            addPrinters(emptyList())
        }
    }
}