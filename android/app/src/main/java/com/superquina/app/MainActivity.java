package com.superquina.app;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

import androidx.activity.OnBackPressedCallback;

import com.getcapacitor.BridgeWebViewClient;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    private static final String CASHIER_APP_PATH = "/cashier-app";
    private static final String CASHIER_LOGIN_PATH = "/cashier-app-login";
    private static final String CASHIER_PASSWORD_PATH = "/cashier-app-change-password";
    private static final String RECEIPT_VERIFICATION_PATH = "/verificar-recibo/";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        registerPlugin(BluetoothPrinterPlugin.class);
        super.onCreate(savedInstanceState);

        // Keep Capacitor's own WebView behavior (including API interception and plugins),
        // while refusing top-level navigation outside the cashier workflow.
        getBridge().getWebView().setWebViewClient(new CashierOnlyWebViewClient());

        // The cashier leaves the app only through the explicit logout action.
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Intentionally consume Android back navigation.
            }
        });
    }

    private final class CashierOnlyWebViewClient extends BridgeWebViewClient {
        CashierOnlyWebViewClient() {
            super(getBridge());
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (!request.isForMainFrame()) {
                return super.shouldOverrideUrlLoading(view, request);
            }
            return shouldBlockNavigation(request.getUrl()) || super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        @SuppressWarnings("deprecation")
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Uri uri = Uri.parse(url);
            return shouldBlockNavigation(uri) || super.shouldOverrideUrlLoading(view, url);
        }

        private boolean shouldBlockNavigation(Uri target) {
            Uri app = Uri.parse(getBridge().getAppUrl());
            String appHost = app.getHost();
            String appScheme = app.getScheme();
            String targetPath = target.getPath();

            if (appHost == null || target.getHost() == null
                    || !appHost.equalsIgnoreCase(target.getHost())
                    || appScheme == null || !appScheme.equalsIgnoreCase(target.getScheme())) {
                return true;
            }

            if (targetPath == null) {
                return true;
            }

            return !(targetPath.equals(CASHIER_LOGIN_PATH)
                    || targetPath.equals(CASHIER_PASSWORD_PATH)
                    || targetPath.equals(CASHIER_APP_PATH)
                    || targetPath.startsWith(CASHIER_APP_PATH + "/")
                    || targetPath.startsWith(RECEIPT_VERIFICATION_PATH));
        }
    }
}
