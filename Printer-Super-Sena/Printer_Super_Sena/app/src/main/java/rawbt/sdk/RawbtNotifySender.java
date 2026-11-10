package rawbt.sdk;

import android.os.RemoteCallbackList;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class RawbtNotifySender {
    final RemoteCallbackList<ICallback> mCallbacks = new RemoteCallbackList<>();
    final RemoteCallbackList<IConsole> mConsoles = new RemoteCallbackList<>();

    public void sendDataSent(byte[] bArr) {
        try {
            int iBeginBroadcast = this.mConsoles.beginBroadcast();
            for (int i3 = 0; i3 < iBeginBroadcast; i3++) {
                try {
                    ((IConsole) this.mConsoles.getBroadcastItem(i3)).onDeviceSent(bArr);
                } catch (Exception unused) {
                }
            }
            this.mConsoles.finishBroadcast();
        } catch (Exception unused2) {
        }
    }

    public void sendError(String str) {
        try {
            int iBeginBroadcast = this.mConsoles.beginBroadcast();
            for (int i3 = 0; i3 < iBeginBroadcast; i3++) {
                try {
                    ((IConsole) this.mConsoles.getBroadcastItem(i3)).onError(str);
                } catch (RemoteException unused) {
                }
            }
            this.mConsoles.finishBroadcast();
        } catch (Exception unused2) {
        }
    }

    public void sendJobCancelled(String str) {
        try {
            int iBeginBroadcast = this.mCallbacks.beginBroadcast();
            for (int i3 = 0; i3 < iBeginBroadcast; i3++) {
                try {
                    ((ICallback) this.mCallbacks.getBroadcastItem(i3)).onPrintCancel(str);
                } catch (RemoteException unused) {
                }
            }
            this.mCallbacks.finishBroadcast();
        } catch (Exception unused2) {
        }
    }

    public void sendJobError(String str, String str2) {
        sendError(str2);
        try {
            int iBeginBroadcast = this.mCallbacks.beginBroadcast();
            for (int i3 = 0; i3 < iBeginBroadcast; i3++) {
                try {
                    ((ICallback) this.mCallbacks.getBroadcastItem(i3)).onPrintError(str, str2);
                } catch (RemoteException unused) {
                }
            }
            this.mCallbacks.finishBroadcast();
        } catch (Exception unused2) {
        }
    }

    public void sendJobSuccess(String str) {
        try {
            int iBeginBroadcast = this.mCallbacks.beginBroadcast();
            for (int i3 = 0; i3 < iBeginBroadcast; i3++) {
                try {
                    ((ICallback) this.mCallbacks.getBroadcastItem(i3)).onPrintSuccess(str);
                } catch (RemoteException unused) {
                }
            }
            this.mCallbacks.finishBroadcast();
        } catch (Exception unused2) {
        }
    }

    public void sendNotify(String str) {
        try {
            int iBeginBroadcast = this.mConsoles.beginBroadcast();
            for (int i3 = 0; i3 < iBeginBroadcast; i3++) {
                try {
                    ((IConsole) this.mConsoles.getBroadcastItem(i3)).onNotify(str);
                } catch (RemoteException unused) {
                }
            }
            this.mConsoles.finishBroadcast();
        } catch (Exception unused2) {
        }
    }

    void sendOnPrinterConnect() {
        try {
            int iBeginBroadcast = this.mConsoles.beginBroadcast();
            for (int i3 = 0; i3 < iBeginBroadcast; i3++) {
                try {
                    ((IConsole) this.mConsoles.getBroadcastItem(i3)).onPrinterConnect();
                } catch (RemoteException unused) {
                }
            }
            this.mConsoles.finishBroadcast();
        } catch (Exception unused2) {
        }
    }

    void sendOnPrinterDisConnect() {
        try {
            int iBeginBroadcast = this.mConsoles.beginBroadcast();
            for (int i3 = 0; i3 < iBeginBroadcast; i3++) {
                try {
                    ((IConsole) this.mConsoles.getBroadcastItem(i3)).onPrinterDisconnect();
                } catch (RemoteException unused) {
                }
            }
            this.mConsoles.finishBroadcast();
        } catch (Exception unused2) {
        }
    }

    public void sendReceived(byte[] bArr) {
        try {
            int iBeginBroadcast = this.mConsoles.beginBroadcast();
            for (int i3 = 0; i3 < iBeginBroadcast; i3++) {
                try {
                    ((IConsole) this.mConsoles.getBroadcastItem(i3)).onDeviceReceived(bArr);
                } catch (RemoteException unused) {
                }
            }
            this.mConsoles.finishBroadcast();
        } catch (Exception unused2) {
        }
    }

    public void sendSetProgress(String str, float f3) {
        try {
            int iBeginBroadcast = this.mCallbacks.beginBroadcast();
            for (int i3 = 0; i3 < iBeginBroadcast; i3++) {
                try {
                    ((ICallback) this.mCallbacks.getBroadcastItem(i3)).onProgress(str, f3);
                } catch (RemoteException unused) {
                }
            }
            this.mCallbacks.finishBroadcast();
        } catch (Exception unused2) {
        }
    }
}
