package com.superquina.printer;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.pdf.PdfRenderer;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.print.PrintAttributes;
import android.print.PrintJob;
import android.print.PrinterCapabilitiesInfo;
import android.print.PrinterId;
import android.print.PrinterInfo;
import android.printservice.PrintDocument;
import android.printservice.PrintService;
import android.printservice.PrinterDiscoverySession;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class SuperQuinaPrintService extends PrintService {
    private static final String TAG = "SuperQuinaPrint";
    private static final UUID SPP_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final int MAX_PDF_BYTES = 20 * 1024 * 1024;
    private static final int MAX_ESC_POS_BYTES = 32 * 1024 * 1024;
    private final ExecutorService printExecutor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Override
    protected PrinterDiscoverySession onCreatePrinterDiscoverySession() {
        return new BluetoothPrinterDiscoverySession();
    }

    @Override
    protected void onPrintJobQueued(PrintJob job) {
        if (job == null || !job.isQueued()) return;
        final String address = job.getInfo().getPrinterId().getLocalId();
        final PrintDocument document = job.getDocument();
        final PrintAttributes attributes = job.getInfo().getAttributes();
        final PrintAttributes.MediaSize selectedMedia = attributes == null ? null : attributes.getMediaSize();
        final PrintAttributes.Resolution selectedResolution = attributes == null ? null : attributes.getResolution();
        if (selectedMedia == null || selectedResolution == null) {
            job.fail("Selecione o tamanho do papel e a resolução nas opções de impressão.");
            return;
        }
        final int paperWidthDots = Math.round(
            selectedMedia.getWidthMils() * selectedResolution.getHorizontalDpi() / 1000f
        );
        if (paperWidthDots < 160 || paperWidthDots > 1200) {
            job.fail("A largura selecionada não é compatível com a impressão térmica.");
            return;
        }
        final ParcelFileDescriptor source = document == null ? null : document.getData();
        if (source == null) {
            job.fail("O Android não forneceu o documento para impressão.");
            return;
        }
        if (address == null || !address.matches("(?i)[0-9A-F]{2}(:[0-9A-F]{2}){5}")) {
            try { source.close(); } catch (IOException ignored) { }
            job.fail("Impressora Bluetooth inválida. Remova e adicione a impressora novamente.");
            return;
        }

        job.start();
        job.setStatus("Preparando recibo para impressão térmica...");
        printExecutor.execute(() -> {
            File pdfFile = null;
            BluetoothSocket socket = null;
            try {
                pdfFile = copyDocumentToCache(source);
                byte[] escpos = renderPdfToEscPos(pdfFile, paperWidthDots);
                socket = connect(address);
                OutputStream output = socket.getOutputStream();
                output.write(escpos);
                output.flush();
                closeQuietly(socket);
                socket = null;
                final File completedFile = pdfFile;
                mainHandler.post(() -> {
                    job.setProgress(1f);
                    job.complete();
                    if (completedFile != null) completedFile.delete();
                });
            } catch (Exception error) {
                Log.e(TAG, "Print job failed", error);
                closeQuietly(socket);
                final File failedFile = pdfFile;
                mainHandler.post(() -> {
                    if (!job.isCompleted() && !job.isCancelled() && !job.isFailed()) {
                        job.fail(messageFor(error));
                    }
                    if (failedFile != null) failedFile.delete();
                });
            }
        });
    }

    @Override
    protected void onRequestCancelPrintJob(PrintJob job) {
        if (job != null && (job.isQueued() || job.isStarted())) job.cancel();
    }

    @Override
    public void onDestroy() {
        printExecutor.shutdownNow();
        super.onDestroy();
    }

    private File copyDocumentToCache(ParcelFileDescriptor source) throws IOException {
        File target = File.createTempFile("superquina-print-", ".pdf", getCacheDir());
        int total = 0;
        try (ParcelFileDescriptor descriptor = source;
             InputStream input = new FileInputStream(descriptor.getFileDescriptor());
             OutputStream output = new FileOutputStream(target)) {
            byte[] buffer = new byte[8192];
            int read;
            while ((read = input.read(buffer)) != -1) {
                total += read;
                if (total > MAX_PDF_BYTES) throw new IOException("O documento excede o limite de 20 MB.");
                output.write(buffer, 0, read);
            }
            output.flush();
        } catch (Exception error) {
            target.delete();
            throw error;
        }
        if (total == 0) {
            target.delete();
            throw new IOException("O documento recebido está vazio.");
        }
        return target;
    }

    private byte[] renderPdfToEscPos(File file, int paperWidthDots) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        append(output, new byte[]{0x1b, 0x40}); // ESC @ initialize
        append(output, new byte[]{0x1b, 0x61, 0x00}); // left align
        try (ParcelFileDescriptor descriptor = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY);
             PdfRenderer renderer = new PdfRenderer(descriptor)) {
            if (renderer.getPageCount() < 1 || renderer.getPageCount() > 100) {
                throw new IOException("Quantidade de páginas inválida para impressão térmica.");
            }
            for (int index = 0; index < renderer.getPageCount(); index++) {
                PdfRenderer.Page page = renderer.openPage(index);
                int height = Math.max(1, Math.round((float) page.getHeight() * paperWidthDots / page.getWidth()));
                if ((long) paperWidthDots * height > 24_000_000L) {
                    page.close();
                    throw new IOException("A página é grande demais para conversão térmica.");
                }
                Bitmap bitmap = Bitmap.createBitmap(paperWidthDots, height, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.drawColor(Color.WHITE);
                Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
                Matrix matrix = new Matrix();
                matrix.setScale((float) paperWidthDots / page.getWidth(), (float) height / page.getHeight());
                page.render(bitmap, null, matrix, PdfRenderer.Page.RENDER_MODE_FOR_PRINT);
                page.close();
                appendRaster(output, bitmap);
                bitmap.recycle();
                append(output, new byte[]{0x0a, 0x0a});
            }
        } catch (SecurityException error) {
            throw new IOException("Não foi possível ler o documento PDF.", error);
        }
        append(output, new byte[]{0x1b, 0x64, 0x03}); // feed 3 lines, no cutter assumed
        return output.toByteArray();
    }

    private void appendRaster(ByteArrayOutputStream output, Bitmap bitmap) {
        int widthBytes = (bitmap.getWidth() + 7) / 8;
        for (int top = 0; top < bitmap.getHeight(); top += 256) {
            int rows = Math.min(256, bitmap.getHeight() - top);
            output.write(0x1d); output.write(0x76); output.write(0x30); output.write(0x00);
            output.write(widthBytes & 0xff); output.write((widthBytes >> 8) & 0xff);
            output.write(rows & 0xff); output.write((rows >> 8) & 0xff);
            for (int y = top; y < top + rows; y++) {
                for (int byteX = 0; byteX < widthBytes; byteX++) {
                    int value = 0;
                    for (int bit = 0; bit < 8; bit++) {
                        int x = byteX * 8 + bit;
                        if (x < bitmap.getWidth()) {
                            int color = bitmap.getPixel(x, y);
                            int luminance = (Color.red(color) * 299 + Color.green(color) * 587 + Color.blue(color) * 114) / 1000;
                            if (luminance < 180) value |= (0x80 >> bit);
                        }
                    }
                    output.write(value);
                }
            }
            if (output.size() > MAX_ESC_POS_BYTES) throw new IllegalArgumentException("O trabalho convertido excede 32 MB.");
        }
    }

    private BluetoothSocket connect(String address) throws Exception {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter == null || !adapter.isEnabled()) throw new IOException("Ative o Bluetooth do Android.");
        BluetoothDevice device = adapter.getRemoteDevice(address);
        BluetoothSocket socket = null;
        try {
            socket = device.createRfcommSocketToServiceRecord(SPP_UUID);
            socket.connect();
            return socket;
        } catch (IOException secureError) {
            closeQuietly(socket);
            socket = device.createInsecureRfcommSocketToServiceRecord(SPP_UUID);
            socket.connect();
            return socket;
        }
    }

    private static void append(ByteArrayOutputStream output, byte[] bytes) {
        output.write(bytes, 0, bytes.length);
    }

    private static void closeQuietly(BluetoothSocket socket) {
        if (socket != null) try { socket.close(); } catch (IOException ignored) { }
    }

    private static String messageFor(Exception error) {
        String message = error.getMessage();
        if (message == null || message.trim().isEmpty()) return "Falha ao processar ou enviar o documento à impressora.";
        return message;
    }

    private final class BluetoothPrinterDiscoverySession extends PrinterDiscoverySession {
        private final Map<String, PrinterInfo> known = new HashMap<>();

        @Override
        public void onStartPrinterDiscovery(List<PrinterId> priorityList) { refresh(); }

        @Override
        public void onStopPrinterDiscovery() { }

        @Override
        public void onValidatePrinters(List<PrinterId> printerIds) { refresh(); }

        @Override
        public void onStartPrinterStateTracking(PrinterId printerId) { refresh(); }

        @Override
        public void onStopPrinterStateTracking(PrinterId printerId) { }

        @Override
        public void onDestroy() { known.clear(); }

        private void refresh() {
            Map<String, PrinterInfo> current = new HashMap<>();
            BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
            if (adapter != null && adapter.isEnabled()) {
                try {
                    Set<BluetoothDevice> paired = adapter.getBondedDevices();
                    for (BluetoothDevice device : paired) {
                        String address = device.getAddress();
                        String name = device.getName();
                        PrinterId id = generatePrinterId(address);
                        PrinterInfo info = new PrinterInfo.Builder(
                            id,
                            name == null || name.trim().isEmpty() ? "Impressora Bluetooth" : name,
                            PrinterInfo.STATUS_IDLE
                        ).setDescription("Bluetooth clássico · papel configurável nas opções de impressão")
                         .setCapabilities(capabilities(id)).build();
                        current.put(address, info);
                    }
                } catch (SecurityException error) {
                    Log.e(TAG, "Bluetooth permission missing during discovery", error);
                }
            }

            List<PrinterId> removed = new ArrayList<>();
            for (Map.Entry<String, PrinterInfo> entry : known.entrySet()) {
                if (!current.containsKey(entry.getKey())) removed.add(entry.getValue().getId());
            }
            if (!removed.isEmpty()) removePrinters(removed);

            List<PrinterInfo> added = new ArrayList<>();
            List<PrinterInfo> updated = new ArrayList<>();
            for (Map.Entry<String, PrinterInfo> entry : current.entrySet()) {
                if (known.containsKey(entry.getKey())) updated.add(entry.getValue());
                else added.add(entry.getValue());
            }
            if (!added.isEmpty()) addPrinters(added);
            if (!updated.isEmpty()) updatePrinters(updated);
            known.clear();
            known.putAll(current);
        }

        private PrinterCapabilitiesInfo capabilities(PrinterId id) {
            PrintAttributes.MediaSize roll48 = new PrintAttributes.MediaSize(
                "SUPERQUINA_ROLL_48", "Bobina térmica 48 mm", 1889, 1000000);
            PrintAttributes.MediaSize roll58 = new PrintAttributes.MediaSize(
                "SUPERQUINA_ROLL_58", "Bobina térmica 58 mm", 2283, 1000000);
            PrintAttributes.MediaSize roll72 = new PrintAttributes.MediaSize(
                "SUPERQUINA_ROLL_72", "Bobina térmica 72 mm", 2835, 1000000);
            PrintAttributes.MediaSize roll80 = new PrintAttributes.MediaSize(
                "SUPERQUINA_ROLL_80", "Bobina térmica 80 mm", 3150, 1000000);
            PrintAttributes.MediaSize roll100 = new PrintAttributes.MediaSize(
                "SUPERQUINA_ROLL_100", "Bobina térmica 100 mm", 3937, 1000000);
            PrintAttributes.Resolution dpi203 = new PrintAttributes.Resolution(
                "THERMAL_203", "Térmica 203 dpi", 203, 203);
            PrintAttributes.Resolution dpi300 = new PrintAttributes.Resolution(
                "THERMAL_300", "Térmica 300 dpi", 300, 300);
            return new PrinterCapabilitiesInfo.Builder(id)
                .addMediaSize(roll58, true)
                .addMediaSize(roll48, false)
                .addMediaSize(roll72, false)
                .addMediaSize(roll80, false)
                .addMediaSize(roll100, false)
                .addResolution(dpi203, true)
                .addResolution(dpi300, false)
                .setColorModes(PrintAttributes.COLOR_MODE_MONOCHROME, PrintAttributes.COLOR_MODE_MONOCHROME)
                .setMinMargins(PrintAttributes.Margins.NO_MARGINS)
                .build();
        }
    }
}
