package p058r;

import java.util.ArrayList;
import java.util.Arrays;
import p061s.i;
import p061s.o;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends e implements i {

    /* JADX INFO: renamed from: L0, reason: collision with root package name */
    public e[] f10815L0 = new e[4];

    /* JADX INFO: renamed from: M0, reason: collision with root package name */
    public int f10816M0 = 0;

    @Override // p058r.i
    public void b() {
        this.f10816M0 = 0;
        Arrays.fill(this.f10815L0, (Object) null);
    }

    @Override // p058r.i
    public void c(e eVar) {
        if (eVar == this || eVar == null) {
            return;
        }
        int i3 = this.f10816M0 + 1;
        e[] eVarArr = this.f10815L0;
        if (i3 > eVarArr.length) {
            this.f10815L0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
        }
        e[] eVarArr2 = this.f10815L0;
        int i4 = this.f10816M0;
        eVarArr2[i4] = eVar;
        this.f10816M0 = i4 + 1;
    }

    public void r1(ArrayList arrayList, int i3, o oVar) {
        for (int i4 = 0; i4 < this.f10816M0; i4++) {
            oVar.a(this.f10815L0[i4]);
        }
        for (int i5 = 0; i5 < this.f10816M0; i5++) {
            i.a(this.f10815L0[i5], i3, arrayList, oVar);
        }
    }

    public int s1(int i3) {
        int i4;
        int i5;
        for (int i6 = 0; i6 < this.f10816M0; i6++) {
            e eVar = this.f10815L0[i6];
            if (i3 == 0 && (i5 = eVar.f10655I0) != -1) {
                return i5;
            }
            if (i3 == 1 && (i4 = eVar.f10657J0) != -1) {
                return i4;
            }
        }
        return -1;
    }

    @Override // p058r.i
    public void a(f fVar) {
    }
}
