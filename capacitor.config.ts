const config = {
  appId: "com.superquina.app",
  appName: "Super Quina",
  // Capacitor requires a webDir even when loading the hosted Next.js application.
  // Keep a minimal directory available for native project synchronization.
  webDir: "www",
  server: {
    // The Next.js application and its API routes remain hosted on the server.
    url: "https://superquina.com/cashier-app-login",
    // Identifies the dedicated cashier WebView so the server can keep app navigation scoped.
    appendUserAgent: " SuperQuinaCashierApp/1",
    cleartext: false,
  },
  android: {
    allowMixedContent: false,
  },
};

export default config;
