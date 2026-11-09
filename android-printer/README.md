# Super Quina Bluetooth Print Service

Standalone Android print intermediary. This app does **not** load the Super Quina website and does not contain site login, sales, payments, or receipt-generation logic.

## Intended user flow

1. Install this Android app.
2. Pair a Bluetooth Classic ESC/POS printer in Android Settings.
3. Enable **Super Quina Bluetooth Printer** under Android's Print Services settings.
4. Open the website in Chrome.
5. Use Chrome's Android print action. Android's system print UI should list this print service and its paired printer.
6. Select the printer and submit the job. The service receives the Android Print Framework document (PDF spool), rasterizes pages and sends ESC/POS data over Bluetooth SPP.

## Architecture

- Android `PrintService`: integration point with Android Print Framework; this is what makes the service appear in Android's system print UI.
- `PrinterDiscoverySession`: publishes paired Bluetooth printers to the system picker.
- Bluetooth Classic SPP/RFCOMM: transport to the selected printer.
- ESC/POS encoder: converts rendered page raster to printer commands (58 mm profile initially).
- Android permissions: Bluetooth permissions vary by OS version; runtime permission handling is required on Android 12+.

## Important distinction

This is **not** an Android Print Framework virtual printer that simply forwards a web page. Chrome submits a print document through Android; the print service receives a PDF spool and must render it for the thermal printer. A Bluetooth device merely being paired is not enough: the app must publish a valid `PrintService` and implement discovery, capabilities, job processing, cancellation and status.

## Scope for this branch

- Standalone app only.
- Bluetooth Classic SPP first; BLE/USB/network transports are out of initial scope.
- 58 mm thermal printer profile first.
- No changes to the website, production server, payment flow, or existing APK.
- RawBT code/assets are not copied into this project. Implementation is built independently; third-party components may be added only after license review.

## Build

Open this directory in Android Studio (or import the Gradle project). Initial project wiring is being established; printer discovery and PDF-to-ESC/POS job processing are the next implementation milestones.
