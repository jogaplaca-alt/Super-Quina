const config = {
  appId: "com.superquina.app.cashier",
  appName: "Super Quina Cambista",
  // Dedicated APK identity, retaining the complete public app experience.
  webDir: "www",
  server: {
    url: "https://superquina.com/login?app=cashier",
    cleartext: false,
  },
  android: {
    allowMixedContent: false,
  },
};

export default config;
