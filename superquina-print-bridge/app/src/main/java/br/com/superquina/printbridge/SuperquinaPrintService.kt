package br.com.superquina.printbridge

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.pdf.PdfRenderer
import android.os.Build
import android.print.PrintAttributes
import android.print.PrinterCapabilitiesInfo
import android.print.PrinterId
import android.print.PrinterInfo
import android.printservice.PrinterDiscoverySession
import android.printservice.PrintJob
import android.printservice.PrintService
import android.util.Log
import java.io.IOException
import java.util.UUID
import kotlin.concurrent.thread

/**
 * Android Print Framework destination. Chrome and other Android apps can send
 * a PDF print job here; each page is rasterized and sent to the paired SPP printer.
 */
class SuperquinaPrintService : PrintService() {
    override fun onCreatePrinterDiscoverySession(): PrinterDiscoverySession {
        return object : PrinterDiscoverySession() {
            private val printerId: PrinterId = generatePrinterId("superquina-thermal")

            override fun onStartPrinterDiscovery(priorityList: MutableList<PrinterId>) {
                val capabilities = PrinterCapabilitiesInfo.Builder(printerId)
                    .addMediaSize(PrintAttributes.MediaSize("superquina_58mm", "Bobina térmica 58 mm", 2283, 7874), true)
                    .addResolution(PrintAttributes.Resolution("thermal203", "Thermal 203 dpi", 203, 203), true)
                    .setMinMargins(PrintAttributes.Margins.NO_MARGINS)
                    .setColorModes(PrintAttributes.COLOR_MODE_MONOCHROME, PrintAttributes.COLOR_MODE_MONOCHROME)
                    .build()
                addPrinters(listOf(
                    PrinterInfo.Builder(printerId, "Super Quina Bluetooth", PrinterInfo.STATUS_IDLE)
                        .setCapabilities(capabilities)
                        .build()
                ))
            }

            override fun onStopPrinterDiscovery() = Unit
            override fun onValidatePrinters(printerIds: MutableList<PrinterId>) {
                onStartPrinterDiscovery(printerIds)
            }
            override fun onStartPrinterStateTracking(printerId: PrinterId) = Unit
            override fun onStopPrinterStateTracking(printerId: PrinterId) = Unit
            override fun onDestroy() = Unit
        }
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onPrintJobQueued(printJob: PrintJob) {
        thread(name = "superquina-print-job") {
            try {
                printJob.start()
                val address = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                    .getString(KEY_PRINTER_ADDRESS, null)
                    ?: throw IOException("Nenhuma impressora selecionada no app Super Quina Impressão.")

                val adapter = BluetoothAdapter.getDefaultAdapter()
                    ?: throw IOException("Bluetooth não disponível neste aparelho.")
                if (!adapter.isEnabled) throw IOException("Ative o Bluetooth do aparelho.")

                @Suppress("MissingPermission")
                val device = adapter.getRemoteDevice(address)
                val socket = connect(device)
                try {
                    val documentFd = printJob.document.data ?: throw IOException("Documento PDF vazio recebido do Android.")
                    val renderer = PdfRenderer(documentFd)
                    try {
                        for (pageIndex in 0 until renderer.pageCount) {
                            val page = renderer.openPage(pageIndex)
                            try {
                                val width = PAPER_DOTS
                                val height = (page.height.toFloat() * width / page.width).toInt().coerceAtLeast(1)
                                val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
                                try {
                                    bitmap.eraseColor(Color.WHITE)
                                    page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_PRINT)
                                    socket.outputStream.write(encodeRaster(bitmap))
                                    socket.outputStream.flush()
                                } finally {
                                    bitmap.recycle()
                                }
                            } finally {
                                page.close()
                            }
                        }
                        socket.outputStream.write(byteArrayOf(0x1B, 0x64, 0x03))
                        socket.outputStream.flush()
                    } finally {
                        renderer.close()
                    }
                } finally {
                    try { socket.close() } catch (_: IOException) { }
                }
                printJob.complete()
            } catch (error: SecurityException) {
                Log.e(TAG, "Bluetooth permission missing", error)
                printJob.fail("Permissão Bluetooth ausente. Abra Superquina Impressão e conceda a permissão.")
            } catch (error: Exception) {
                Log.e(TAG, "Print job failed", error)
                printJob.fail(error.message ?: "Falha ao imprimir. Verifique a conexão Bluetooth.")
            }
        }
    }

    override fun onRequestCancelPrintJob(printJob: PrintJob) {
        // The current RFCOMM write is finite; cancellation is reflected by Android
        // when the job is no longer active. Socket teardown occurs in finally.
        if (printJob.isQueued) printJob.cancel()
    }

    @Suppress("MissingPermission")
    private fun connect(device: BluetoothDevice): BluetoothSocket {
        val socket = device.createRfcommSocketToServiceRecord(SPP_UUID)
        try {
            socket.connect()
            return socket
        } catch (error: IOException) {
            try { socket.close() } catch (_: IOException) { }
            throw error
        }
    }

    private fun encodeRaster(bitmap: Bitmap): ByteArray {
        val widthBytes = (bitmap.width + 7) / 8
        val pixels = IntArray(bitmap.width)
        val out = java.io.ByteArrayOutputStream()
        out.write(byteArrayOf(0x1B, 0x40))
        var y = 0
        while (y < bitmap.height) {
            val rows = minOf(256, bitmap.height - y)
            out.write(byteArrayOf(
                0x1D, 0x76, 0x30, 0x00,
                (widthBytes and 0xFF).toByte(), ((widthBytes shr 8) and 0xFF).toByte(),
                (rows and 0xFF).toByte(), ((rows shr 8) and 0xFF).toByte()
            ))
            for (row in y until y + rows) {
                bitmap.getPixels(pixels, 0, bitmap.width, 0, row, bitmap.width, 1)
                for (byteIndex in 0 until widthBytes) {
                    var value = 0
                    for (bit in 0..7) {
                        val x = byteIndex * 8 + bit
                        if (x < bitmap.width) {
                            val color = pixels[x]
                            val luminance = (Color.red(color) * 299 + Color.green(color) * 587 + Color.blue(color) * 114) / 1000
                            if (luminance < 170) value = value or (0x80 shr bit)
                        }
                    }
                    out.write(value)
                }
            }
            y += rows
        }
        return out.toByteArray()
    }

    override fun onConnected() { super.onConnected() }
    override fun onDisconnected() { super.onDisconnected() }

    companion object {
        private const val TAG = "SuperquinaPrint"
        private const val PREFS = "superquina_print_bridge"
        private const val KEY_PRINTER_ADDRESS = "selected_printer_address"
        private const val PAPER_DOTS = 384 // Initial 58 mm profile; verify on the user's OY-581P.
        private val SPP_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
    }
}
