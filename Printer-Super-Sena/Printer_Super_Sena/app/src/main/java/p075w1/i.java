package p075w1;

import E1.c;
import java.io.IOException;
import java.io.StringWriter;
import p081y1.m;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public f j() {
        if (m()) {
            return (f) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public l k() {
        if (o()) {
            return (l) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public n l() {
        if (p()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean m() {
        return this instanceof f;
    }

    public boolean n() {
        return this instanceof k;
    }

    public boolean o() {
        return this instanceof l;
    }

    public boolean p() {
        return this instanceof n;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            c cVar = new c(stringWriter);
            cVar.Y(true);
            m.b(this, cVar);
            return stringWriter.toString();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }
}
