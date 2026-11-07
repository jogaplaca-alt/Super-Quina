const config = {
  appId: "com.superquina.cashier",
  appName: "Super Quina Cambista",
  // Capacitor loads the dedicated cashier entry point; server-side role checks remain authoritative.
  webDir: "www",
  server: {
    url: "https://superquina.com/cashier-app-login",
    cleartext: false,
  },
  android: {
    allowMixedContent: false,
  },
};

export default config;
