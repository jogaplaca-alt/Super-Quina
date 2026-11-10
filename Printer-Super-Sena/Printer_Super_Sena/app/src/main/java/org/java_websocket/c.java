package org.java_websocket;

import p023f2.f;
import p023f2.h;
import p027g2.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements e {
    private h pingFrame;

    @Override // org.java_websocket.e
    public h onPreparePing(b bVar) {
        if (this.pingFrame == null) {
            this.pingFrame = new h();
        }
        return this.pingFrame;
    }

    @Override // org.java_websocket.e
    public i onWebsocketHandshakeReceivedAsServer(b bVar, p007b2.a aVar, p027g2.a aVar2) {
        return new p027g2.e();
    }

    @Override // org.java_websocket.e
    public void onWebsocketPing(b bVar, f fVar) {
        bVar.sendFrame(new p023f2.i((h) fVar));
    }

    @Override // org.java_websocket.e
    public void onWebsocketHandshakeSentAsClient(b bVar, p027g2.a aVar) {
    }

    @Override // org.java_websocket.e
    public void onWebsocketPong(b bVar, f fVar) {
    }

    @Override // org.java_websocket.e
    public void onWebsocketHandshakeReceivedAsClient(b bVar, p027g2.a aVar, p027g2.h hVar) {
    }
}
