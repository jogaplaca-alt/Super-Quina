# Super Quina Bluetooth Printer

Standalone Android app whose only purpose is to connect to a paired Bluetooth Classic thermal printer and print receipt data sent by the website.

## Required user experience (direct print; no PDF)

1. Install the app and pair the 58 mm ESC/POS printer in Android Bluetooth settings.
2. Open Super Quina in Chrome.
3. Generate a receipt and tap the site's **Print** button.
4. The website launches this app through an Android intent/deep link and passes structured receipt data.
5. The app sends ESC/POS bytes directly to the selected paired printer over Bluetooth SPP/RFCOMM.

No PDF is downloaded, saved, opened, or sent to this app. The app does not host the website and does not implement login, sales, payments, or receipt generation.

## Important Android distinction

The standard Chrome **system print dialog** uses Android's Print Framework and a document spool (typically PDF internally). That is a different integration and cannot satisfy the strict no-document-spool requirement. This project therefore targets a direct website-to-app Android intent integration. The website's print button must explicitly launch the app; merely tapping Chrome's generic system print command will not invoke this direct protocol.

## Components

- Android manifest and runtime Bluetooth permissions, including Android 12+ `BLUETOOTH_CONNECT`.
- Deep-link receiver for `superquina-printer://print` (initial protocol; production hardening required).
- Paired Bluetooth Classic device selection and SPP/RFCOMM connection.
- ESC/POS receipt encoder for 58 mm printers.
- Job state, error handling, and safe retry behavior.

## Payload contract (draft)

The website launches a user-initiated Android intent with a URL-safe Base64-encoded UTF-8 JSON receipt payload. The payload should contain only receipt content and formatting data (text lines, emphasis, alignment, QR/barcode data, feed/cut options), never credentials or payment secrets. Keep payloads small; for large jobs use a short-lived authenticated fetch token instead of embedding the whole receipt in the URI. Validate origin/authorization and payload schema before printing.

## Scope and licensing

RawBT source/assets are not copied. This is an independent implementation of the required Android/Bluetooth/ESC/POS behavior. Third-party code may be included only after checking that its license permits the intended use and preserving required notices.

## Current status

This branch contains an initial Android project scaffold and an intent entry point. Bluetooth connection, real ESC/POS encoding, robust payload validation, website integration, and physical-device testing are still pending. Do not treat the current scaffold as a finished or tested APK.
