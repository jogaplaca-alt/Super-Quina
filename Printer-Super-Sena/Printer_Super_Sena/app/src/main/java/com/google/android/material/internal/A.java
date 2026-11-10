package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class A {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f8169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f8170d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private p030h1.d f8173g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextPaint f8167a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p030h1.f f8168b = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8171e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WeakReference f8172f = new WeakReference(null);

    class a extends p030h1.f {
        a() {
        }

        @Override // p030h1.f
        public void a(int i3) {
            A.this.f8171e = true;
            b bVar = (b) A.this.f8172f.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // p030h1.f
        public void b(Typeface typeface, boolean z3) {
            if (z3) {
                return;
            }
            A.this.f8171e = true;
            b bVar = (b) A.this.f8172f.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public A(b bVar) {
        j(bVar);
    }

    private float c(String str) {
        if (str == null) {
            return 0.0f;
        }
        return Math.abs(this.f8167a.getFontMetrics().ascent);
    }

    private float d(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f8167a.measureText(charSequence, 0, charSequence.length());
    }

    private void i(String str) {
        this.f8169c = d(str);
        this.f8170d = c(str);
        this.f8171e = false;
    }

    public p030h1.d e() {
        return this.f8173g;
    }

    public float f(String str) {
        if (!this.f8171e) {
            return this.f8170d;
        }
        i(str);
        return this.f8170d;
    }

    public TextPaint g() {
        return this.f8167a;
    }

    public float h(String str) {
        if (!this.f8171e) {
            return this.f8169c;
        }
        i(str);
        return this.f8169c;
    }

    public void j(b bVar) {
        this.f8172f = new WeakReference(bVar);
    }

    public void k(p030h1.d dVar, Context context) {
        if (this.f8173g != dVar) {
            this.f8173g = dVar;
            if (dVar != null) {
                dVar.o(context, this.f8167a, this.f8168b);
                b bVar = (b) this.f8172f.get();
                if (bVar != null) {
                    this.f8167a.drawableState = bVar.getState();
                }
                dVar.n(context, this.f8167a, this.f8168b);
                this.f8171e = true;
            }
            b bVar2 = (b) this.f8172f.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void l(boolean z3) {
        this.f8171e = z3;
    }

    public void m(boolean z3) {
        this.f8171e = z3;
    }

    public void n(Context context) {
        this.f8173g.n(context, this.f8167a, this.f8168b);
    }
}
