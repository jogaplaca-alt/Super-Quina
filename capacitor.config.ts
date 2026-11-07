const config = {
  appId: "com.superquina.app.publico",
  appName: "Super Quina",
  // Public application uses the full Super Quina experience.
  webDir: "www",
  server: {
    url: "https://superquina.com",
    cleartext: false,
  },
  android: {
    allowMixedContent: false,
  },
};

export default config;
