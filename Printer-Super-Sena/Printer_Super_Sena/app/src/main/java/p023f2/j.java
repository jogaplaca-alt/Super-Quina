package p023f2;

import p011c2.c;

/* JADX INFO: loaded from: classes.dex */
public class j extends e {
    public j() {
        super(c.TEXT);
    }

    @Override // p023f2.e, p023f2.g
    public void h() throws p015d2.c {
        super.h();
        if (!i2.c.b(f())) {
            throw new p015d2.c(1007, "Received text is no valid utf8 string!");
        }
    }
}
