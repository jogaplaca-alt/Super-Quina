package rawbt.sdk.transport;

import android.net.TrafficStats;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import rawbt.sdk.RawbtConstants;

/* JADX INFO: loaded from: classes.dex */
public class P910nd implements Transport {
    private static final int BUF_SIZE = 32375;
    private DataInputStream dataInputStream;
    private String host;
    private DataOutputStream stream;
    Transport.CallBack driver = null;
    private int port = 9100;
    private boolean isConnect = false;
    private Socket socket = null;
    private final Object _locker = new Object();
    private Thread _readingThread = null;
    boolean isReadCancel = true;
    private final Runnable readerReceiver = new Runnable() { // from class: rawbt.sdk.transport.P910nd.1
        @Override // java.lang.Runnable
        public void run() {
            if (P910nd.this.dataInputStream == null) {
                return;
            }
            while (true) {
                try {
                    P910nd p910nd = P910nd.this;
                    if (p910nd.isReadCancel) {
                        return;
                    }
                    synchronized (p910nd._locker) {
                        try {
                            byte[] bArr = new byte[1024];
                            int inputStreamWithTimeout = P910nd.readInputStreamWithTimeout(P910nd.this.dataInputStream, bArr, 50);
                            if (inputStreamWithTimeout > 0) {
                                byte[] bArr2 = new byte[inputStreamWithTimeout];
                                System.arraycopy(bArr, 0, bArr2, 0, inputStreamWithTimeout);
                                P910nd.this.driver.receiveFromDevice(bArr2);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    P910nd.this.Sleep(10);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    P910nd.this.isReadCancel = true;
                    return;
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Sleep(int i3) {
        try {
            Thread.sleep(i3);
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
    }

    private String _connect() {
        if (this.socket != null) {
            showToast("Connect reuse open socket");
            return RawbtConstants.OK;
        }
        showToast("Connecting");
        try {
            TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
            int i3 = 5000;
            try {
                if (InetAddress.getByName(this.host).isReachable(1000)) {
                    i3 = 30000;
                }
            } catch (Exception unused) {
            }
            Socket socket = new Socket();
            this.socket = socket;
            socket.connect(new InetSocketAddress(this.host, this.port), i3);
            this.socket.setKeepAlive(true);
            this.socket.setReuseAddress(false);
            this.stream = new DataOutputStream(this.socket.getOutputStream());
            showToast("Connected");
            try {
                this.dataInputStream = new DataInputStream(this.socket.getInputStream());
                StartReadingThread();
                return RawbtConstants.OK;
            } catch (Exception e3) {
                e3.printStackTrace();
                return RawbtConstants.OK;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            return e4.getLocalizedMessage();
        }
    }

    static int readInputStreamWithTimeout(InputStream inputStream, byte[] bArr, int i3) {
        long jCurrentTimeMillis = System.currentTimeMillis() + ((long) i3);
        int i4 = 0;
        while (System.currentTimeMillis() < jCurrentTimeMillis && i4 < 1) {
            int iMin = Math.min(inputStream.available(), bArr.length - i4);
            if (iMin > 0) {
                i4 += inputStream.read(bArr, i4, iMin);
            } else {
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        return i4;
    }

    public void StartReadingThread() {
        if (this._readingThread == null) {
            this.isReadCancel = false;
            Thread thread = new Thread(this.readerReceiver);
            this._readingThread = thread;
            thread.start();
        }
    }

    @Override // rawbt.sdk.transport.Transport
    public String connect() {
        this.isConnect = true;
        return _connect();
    }

    @Override // rawbt.sdk.transport.Transport
    public void disconnect() {
        this.isConnect = false;
        this.isReadCancel = true;
        Sleep(200);
        DataInputStream dataInputStream = this.dataInputStream;
        if (dataInputStream != null) {
            try {
                dataInputStream.close();
            } catch (Exception unused) {
            }
        }
        DataOutputStream dataOutputStream = this.stream;
        if (dataOutputStream != null) {
            try {
                dataOutputStream.flush();
                this.stream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.stream = null;
        }
        Socket socket = this.socket;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            this.socket = null;
        }
    }

    @Override // rawbt.sdk.transport.Transport
    public void injectDriver(Transport.CallBack callBack) {
        this.driver = callBack;
    }

    @Override // rawbt.sdk.transport.Transport
    public boolean isConnected() {
        return this.isConnect;
    }

    public void setConnectParam(String str, String str2) {
        this.host = str;
        this.port = Integer.parseInt(str2);
    }

    void showToast(String str) {
        Transport.CallBack callBack = this.driver;
        if (callBack != null) {
            callBack.transportMessage(str);
        }
    }

    @Override // rawbt.sdk.transport.Transport
    public String write(byte[] bArr) {
        try {
            if (!this.isConnect) {
                String str_connect = _connect();
                if (!RawbtConstants.OK.equals(str_connect)) {
                    return str_connect;
                }
            }
            if (this.stream != null) {
                synchronized (this._locker) {
                    try {
                        int length = bArr.length;
                        byte[] bArr2 = new byte[BUF_SIZE];
                        long size = 1;
                        int i3 = 0;
                        while (length > 0 && i3 < length && size > 0) {
                            int iMin = Math.min(BUF_SIZE, length - i3);
                            System.arraycopy(bArr, i3, bArr2, 0, iMin);
                            try {
                                long size2 = this.stream.size();
                                this.stream.write(bArr2, 0, iMin);
                                size = ((long) this.stream.size()) - size2;
                                int i4 = (int) size;
                                i3 += i4;
                                if (size > 0) {
                                    byte[] bArr3 = new byte[i4];
                                    System.arraycopy(bArr2, 0, bArr3, 0, i4);
                                    this.driver.sentToDevice(bArr3);
                                }
                            } catch (SocketException e3) {
                                e3.printStackTrace();
                                disconnect();
                                return e3.getLocalizedMessage();
                            }
                        }
                        try {
                            this.stream.flush();
                        } catch (Exception unused) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (this.isConnect) {
                return RawbtConstants.OK;
            }
            DataOutputStream dataOutputStream = this.stream;
            if (dataOutputStream != null) {
                dataOutputStream.flush();
            }
            disconnect();
            return RawbtConstants.OK;
        } catch (Exception e4) {
            String localizedMessage = e4.getLocalizedMessage();
            e4.printStackTrace();
            return localizedMessage;
        }
    }
}
