package p027g2;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class g implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f9596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TreeMap f9597b = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    @Override // p027g2.f
    public boolean a(String str) {
        return this.f9597b.containsKey(str);
    }

    @Override // p027g2.c
    public void b(String str, String str2) {
        this.f9597b.put(str, str2);
    }

    @Override // p027g2.f
    public Iterator d() {
        return Collections.unmodifiableSet(this.f9597b.keySet()).iterator();
    }

    @Override // p027g2.f
    public String h(String str) {
        String str2 = (String) this.f9597b.get(str);
        return str2 == null ? "" : str2;
    }

    @Override // p027g2.f
    public byte[] i() {
        return this.f9596a;
    }
}
