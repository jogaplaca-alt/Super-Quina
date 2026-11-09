# Implementation plan and acceptance criteria

## Milestone 1 — System print integration
- [x] Standalone Android Gradle project scaffold.
- [x] Declare Android PrintService and Bluetooth permissions.
- [x] Add paired-device discovery entry point.
- [ ] Add first-run setup activity for Android 12+ runtime permission requests.
- [ ] Verify service appears in Android Settings > Connected devices/Printing > Print services (menu wording varies by Android vendor).

## Milestone 2 — Real printer discovery
- [ ] Publish printer capabilities (58 mm media, supported resolutions, margins, monochrome).
- [ ] Filter paired devices to supported Bluetooth Classic SPP printers.
- [ ] Add printer status and reconnect handling.
- [ ] Test on physical Android device and 58 mm printer.

## Milestone 3 — PDF spool to ESC/POS
- [ ] Read Android Print Framework PDF spool from PrintDocument.
- [ ] Render PDF pages with Android PdfRenderer.
- [ ] Scale to 58 mm printable width and dither to monochrome.
- [ ] Encode ESC/POS raster image commands, line feed and optional cut command (only if printer supports it).

## Milestone 4 — Job lifecycle and reliability
- [ ] Process jobs off the main thread.
- [ ] Support cancellation and disconnect/error reporting.
- [ ] Never report success before transport write completes.
- [ ] Avoid silent automatic reprints after uncertain disconnects.

## Acceptance test
1. Install APK on Android.
2. Pair the thermal printer in Android Bluetooth settings.
3. Grant Bluetooth permissions and enable this print service.
4. Open the site in Chrome and invoke Print.
5. Confirm the service and printer appear in Android's print UI.
6. Print a test page and then a real receipt.
7. Verify text, alignment, QR code, paper width and feed/cut behavior.
