package p023f2;

import p011c2.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends g {
    public d(c cVar) {
        super(cVar);
    }

    @Override // p023f2.g
    public void h() throws p015d2.d {
        if (!d()) {
            throw new p015d2.d("Control frame can't have fin==false set");
        }
        if (b()) {
            throw new p015d2.d("Control frame can't have rsv1==true set");
        }
        if (e()) {
            throw new p015d2.d("Control frame can't have rsv2==true set");
        }
        if (c()) {
            throw new p015d2.d("Control frame can't have rsv3==true set");
        }
    }
}
