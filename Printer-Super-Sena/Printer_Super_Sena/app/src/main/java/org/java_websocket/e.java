package org.java_websocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import p023f2.h;
import p027g2.f;
import p027g2.i;

/* JADX INFO: loaded from: classes.dex */
public interface e {
    InetSocketAddress getLocalSocketAddress(b bVar);

    InetSocketAddress getRemoteSocketAddress(b bVar);

    h onPreparePing(b bVar);

    void onWebsocketClose(b bVar, int i3, String str, boolean z3);

    void onWebsocketCloseInitiated(b bVar, int i3, String str);

    void onWebsocketClosing(b bVar, int i3, String str, boolean z3);

    void onWebsocketError(b bVar, Exception exc);

    void onWebsocketHandshakeReceivedAsClient(b bVar, p027g2.a aVar, p027g2.h hVar);

    i onWebsocketHandshakeReceivedAsServer(b bVar, p007b2.a aVar, p027g2.a aVar2);

    void onWebsocketHandshakeSentAsClient(b bVar, p027g2.a aVar);

    void onWebsocketMessage(b bVar, String str);

    void onWebsocketMessage(b bVar, ByteBuffer byteBuffer);

    void onWebsocketOpen(b bVar, f fVar);

    void onWebsocketPing(b bVar, p023f2.f fVar);

    void onWebsocketPong(b bVar, p023f2.f fVar);

    void onWriteDemand(b bVar);
}
