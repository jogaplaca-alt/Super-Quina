# Implementation plan — direct Bluetooth print (no PDF)

## Milestone 1 — Android app and direct handoff
- [x] Standalone Android Gradle project scaffold.
- [x] Android Bluetooth permissions declared.
- [ ] Implement deep-link/intent receiver for website print requests.
- [ ] Validate and parse receipt payload; reject malformed/oversized requests.
- [ ] Provide app setup screen to grant runtime permissions and select a paired printer.

## Milestone 2 — Bluetooth
- [ ] Enumerate paired Bluetooth Classic devices after BLUETOOTH_CONNECT permission.
- [ ] Let user select and persist the printer.
- [ ] Connect using BluetoothSocket with the printer's supported SPP UUID.
- [ ] Handle disabled Bluetooth, disconnects, timeouts and unsupported devices.

## Milestone 3 — Direct receipt encoding
- [ ] Define a stable JSON receipt contract shared with the website.
- [ ] Convert text, alignment, emphasis, QR/barcode and feed/cut options to ESC/POS.
- [ ] Support 58 mm width and printer-specific printable columns.
- [ ] Send bytes directly to the Bluetooth socket; no PDF, Android Print Framework or file download.

## Milestone 4 — Website handoff and reliability
- [ ] Change the website's explicit receipt Print button to launch the Android intent only on Android.
- [ ] Add fallback/help text if app is not installed; preserve browser printing on other platforms.
- [ ] Prevent duplicate print requests; use unique job IDs and explicit result acknowledgement.
- [ ] Never claim a receipt physically printed solely because socket write completed.
- [ ] Test on physical Android devices and actual 58 mm printers.

## Acceptance test
1. Install app and pair printer.
2. Select printer once in app.
3. Open site in Chrome, generate receipt and tap its Print button.
4. App receives receipt data without downloading/opening a PDF.
5. App sends ESC/POS over Bluetooth and reports connection/send errors clearly.
