package rawbt.sdk.transport;

/* JADX INFO: loaded from: classes.dex */
public interface ConnectParameters {
    int getProtocol();

    String getSerialComDriver();

    int get_baud();

    String get_host();

    String get_mac();

    String get_pid();

    int get_port();

    String get_vid();
}
