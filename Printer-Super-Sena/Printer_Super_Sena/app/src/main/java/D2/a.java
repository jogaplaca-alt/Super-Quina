package D2;

import E2.A;
import E2.B;
import E2.C;
import E2.C0185a;
import E2.C0186b;
import E2.C0187c;
import E2.C0188d;
import E2.C0189e;
import E2.C0190f;
import E2.C0191g;
import E2.C0192h;
import E2.C0193i;
import E2.C0194j;
import E2.C0195k;
import E2.C0196l;
import E2.C0197m;
import E2.C0198n;
import E2.C0199o;
import E2.C0200p;
import E2.C0201q;
import E2.C0202s;
import E2.C0203t;
import E2.C0204u;
import E2.C0205v;
import E2.D;
import E2.E;
import E2.F;
import E2.G;
import E2.I;
import E2.J;
import E2.K;
import E2.L;
import E2.M;
import E2.N;
import E2.P;
import E2.Q;
import E2.S;
import E2.U;
import E2.V;
import E2.W;
import E2.r;
import E2.x;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static Q a(int i3) {
        I i4;
        Q q3;
        switch (i3) {
            case 1:
                return new C0191g();
            case 2:
                C0194j c0194j = new C0194j();
                c0194j.V(C0194j.a.MATRIX);
                return c0194j;
            case 3:
                C0194j c0194j2 = new C0194j();
                c0194j2.V(C0194j.a.INTERLEAVED);
                return c0194j2;
            case 4:
                C0194j c0194j3 = new C0194j();
                c0194j3.V(C0194j.a.IATA);
                return c0194j3;
            case 5:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 19:
            case 26:
            case 27:
            case 28:
            case 33:
            case 35:
            case 36:
            case 38:
            case 39:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
            case 52:
            case 57:
            case 59:
            case 61:
            case 62:
            case 64:
            case 65:
            case 69:
            case 72:
            case 73:
            case 78:
            case 83:
            case 86:
            case 88:
            case 91:
            case 94:
            case 95:
            case 96:
            case 100:
            case 101:
            case 103:
            case 105:
            case 107:
            case 109:
            case 111:
            case 114:
            case 115:
            case 116:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 129:
            default:
                return null;
            case 6:
                C0194j c0194j4 = new C0194j();
                c0194j4.V(C0194j.a.DATA_LOGIC);
                return c0194j4;
            case 7:
                C0194j c0194j5 = new C0194j();
                c0194j5.V(C0194j.a.INDUSTRIAL);
                return c0194j5;
            case 8:
            case 99:
                C0196l c0196l = new C0196l();
                q3 = c0196l;
                if (i3 == 99) {
                    c0196l.D(Q.a.HIBC);
                    q3 = c0196l;
                }
                break;
            case 9:
                return new C0197m();
            case 13:
                return new C0205v();
            case 18:
                return new C0189e();
            case 20:
                C0192h c0192h = new C0192h();
                c0192h.V();
                return c0192h;
            case 21:
                C0194j c0194j6 = new C0194j();
                c0194j6.V(C0194j.a.DP_LEITCODE);
                return c0194j6;
            case 22:
                C0194j c0194j7 = new C0194j();
                c0194j7.V(C0194j.a.DP_IDENTCODE);
                return c0194j7;
            case 23:
                C0193i c0193i = new C0193i();
                c0193i.D(Q.a.GS1);
                return c0193i;
            case 24:
                return new C0198n();
            case 25:
                return new C0199o();
            case 29:
                r rVar = new r();
                rVar.M(r.a.LINEAR);
                return rVar;
            case 30:
                return new C0203t();
            case 31:
                C0202s c0202s = new C0202s();
                c0202s.T(false);
                return c0202s;
            case 32:
                S s3 = new S();
                s3.N(S.a.NORMAL);
                return s3;
            case 34:
                U u3 = new U();
                u3.R(U.a.UPCA);
                return u3;
            case 37:
                U u4 = new U();
                u4.R(U.a.UPCE);
                return u4;
            case 40:
            case 54:
                M m3 = new M();
                m3.M(M.a.POSTNET);
                return m3;
            case 47:
                return new F();
            case 50:
                return new D();
            case 51:
                return new K();
            case 53:
                return new J();
            case 55:
            case 56:
            case 106:
                i4 = new I();
                i4.D(Q.a.GS1);
                if (i3 == 106) {
                    i4.D(Q.a.HIBC);
                    q3 = i4;
                } else if (i3 == 56) {
                    q3 = i4;
                    i4.V(I.c.TRUNCATED);
                    q3 = i4;
                }
                break;
            case 58:
                return new N();
            case 60:
                C0192h c0192h2 = new C0192h();
                c0192h2.V();
                c0192h2.U(true);
                return c0192h2;
            case 63:
                C0185a c0185a = new C0185a();
                c0185a.N();
                return c0185a;
            case 66:
                C0185a c0185a2 = new C0185a();
                c0185a2.P();
                return c0185a2;
            case 67:
                C0185a c0185a3 = new C0185a();
                c0185a3.Q();
                return c0185a3;
            case 68:
                C0185a c0185a4 = new C0185a();
                c0185a4.O();
                return c0185a4;
            case 70:
                return new P();
            case 71:
            case 102:
                C0204u c0204u = new C0204u();
                c0204u.D(Q.a.GS1);
                q3 = c0204u;
                if (i3 == 102) {
                    c0204u.D(Q.a.HIBC);
                    q3 = c0204u;
                }
                break;
            case 74:
            case 110:
                C0190f c0190f = new C0190f();
                c0190f.D(Q.a.GS1);
                q3 = c0190f;
                if (i3 == 110) {
                    c0190f.D(Q.a.HIBC);
                    q3 = c0190f;
                }
                break;
            case 75:
                return new G();
            case 76:
                return new A();
            case 77:
                return new C();
            case 79:
                r rVar2 = new r();
                rVar2.M(r.a.STACKED);
                return rVar2;
            case 80:
                r rVar3 = new r();
                rVar3.M(r.a.OMNI);
                return rVar3;
            case 81:
                C0202s c0202s2 = new C0202s();
                c0202s2.T(true);
                return c0202s2;
            case 82:
                M m4 = new M();
                m4.M(M.a.PLANET);
                return m4;
            case 84:
            case 108:
                I i5 = new I();
                i5.V(I.c.MICRO);
                i5.D(Q.a.GS1);
                q3 = i5;
                if (i3 == 108) {
                    i5.D(Q.a.HIBC);
                    q3 = i5;
                }
                break;
            case 85:
                return new V();
            case 87:
                S s4 = new S();
                s4.N(S.a.NUMERIC);
                return s4;
            case 89:
                C0194j c0194j8 = new C0194j();
                c0194j8.V(C0194j.a.ITF14);
                return c0194j8;
            case 90:
                return new B();
            case 92:
            case 112:
                C0186b c0186b = new C0186b();
                c0186b.D(Q.a.GS1);
                q3 = c0186b;
                if (i3 == 112) {
                    c0186b.D(Q.a.HIBC);
                    q3 = c0186b;
                }
                break;
            case 93:
                return new C0195k();
            case 97:
                return new E();
            case 98:
                C0192h c0192h3 = new C0192h();
                c0192h3.V();
                c0192h3.U(true);
                c0192h3.D(Q.a.HIBC);
                return c0192h3;
            case 104:
                N n3 = new N();
                n3.D(Q.a.HIBC);
                return n3;
            case 113:
                return new L();
            case 117:
                return new W();
            case 128:
                return new C0187c();
            case 130:
                C0201q c0201q = new C0201q();
                c0201q.a0(C0201q.c.EAN);
                return c0201q;
            case 131:
                C0201q c0201q2 = new C0201q();
                c0201q2.a0(C0201q.c.CODE_128);
                return c0201q2;
            case 132:
                C0201q c0201q3 = new C0201q();
                c0201q3.a0(C0201q.c.DATABAR_14);
                return c0201q3;
            case 133:
                C0201q c0201q4 = new C0201q();
                c0201q4.a0(C0201q.c.DATABAR_LIMITED);
                return c0201q4;
            case 134:
                C0201q c0201q5 = new C0201q();
                c0201q5.a0(C0201q.c.DATABAR_EXPANDED);
                return c0201q5;
            case 135:
                C0201q c0201q6 = new C0201q();
                c0201q6.a0(C0201q.c.UPCA);
                return c0201q6;
            case 136:
                C0201q c0201q7 = new C0201q();
                c0201q7.a0(C0201q.c.UPCE);
                return c0201q7;
            case 137:
                C0201q c0201q8 = new C0201q();
                c0201q8.a0(C0201q.c.DATABAR_14_STACK);
                return c0201q8;
            case 138:
                C0201q c0201q9 = new C0201q();
                c0201q9.a0(C0201q.c.DATABAR_14_STACK_OMNI);
                return c0201q9;
            case 139:
                C0201q c0201q10 = new C0201q();
                c0201q10.a0(C0201q.c.DATABAR_EXPANDED_STACK);
                return c0201q10;
            case 140:
                return new C0188d();
            case 141:
                C0200p c0200p = new C0200p();
                c0200p.D(Q.a.GS1);
                return c0200p;
            case 142:
                x xVar = new x();
                xVar.D(Q.a.GS1);
                return xVar;
        }
        q3 = i4;
        return q3;
    }
}
