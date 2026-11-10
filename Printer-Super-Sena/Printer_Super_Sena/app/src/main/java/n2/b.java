package n2;

import Z.k;
import android.database.Cursor;
import androidx.room.h;
import androidx.room.i;
import androidx.room.u;
import androidx.room.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b implements n2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u f10227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f10228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f10229c;

    class a extends i {
        a(u uVar) {
            super(uVar);
        }

        @Override // androidx.room.D
        protected String createQuery() {
            return "INSERT OR REPLACE INTO `console_history` (`data`,`codePage`,`mode`,`howLF`,`hash`,`lastSend`) VALUES (?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void bind(k kVar, c cVar) {
            String str = cVar.f10232a;
            if (str == null) {
                kVar.x(1);
            } else {
                kVar.k(1, str);
            }
            String str2 = cVar.f10233b;
            if (str2 == null) {
                kVar.x(2);
            } else {
                kVar.k(2, str2);
            }
            kVar.l(3, cVar.f10234c);
            kVar.l(4, cVar.f10235d);
            kVar.l(5, cVar.f10236e);
            kVar.l(6, cVar.f10237f);
        }
    }

    /* JADX INFO: renamed from: n2.b$b, reason: collision with other inner class name */
    class C0126b extends h {
        C0126b(u uVar) {
            super(uVar);
        }

        @Override // androidx.room.D
        protected String createQuery() {
            return "DELETE FROM `console_history` WHERE `hash` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.h
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void bind(k kVar, c cVar) {
            kVar.l(1, cVar.f10236e);
        }
    }

    public b(u uVar) {
        this.f10227a = uVar;
        this.f10228b = new a(uVar);
        this.f10229c = new C0126b(uVar);
    }

    public static List e() {
        return Collections.emptyList();
    }

    @Override // n2.a
    public List a(int i3) {
        x xVarY = x.y("select * from console_history order by lastSend desc limit 999 offset ?", 1);
        xVarY.l(1, i3);
        this.f10227a.d();
        Cursor cursorB = X.b.b(this.f10227a, xVarY, false, null);
        try {
            int iE = X.a.e(cursorB, "data");
            int iE2 = X.a.e(cursorB, "codePage");
            int iE3 = X.a.e(cursorB, "mode");
            int iE4 = X.a.e(cursorB, "howLF");
            int iE5 = X.a.e(cursorB, "hash");
            int iE6 = X.a.e(cursorB, "lastSend");
            ArrayList arrayList = new ArrayList(cursorB.getCount());
            while (cursorB.moveToNext()) {
                c cVar = new c(cursorB.isNull(iE) ? null : cursorB.getString(iE), cursorB.isNull(iE2) ? null : cursorB.getString(iE2), cursorB.getInt(iE3), cursorB.getInt(iE4));
                cVar.f10236e = cursorB.getInt(iE5);
                cVar.f10237f = cursorB.getLong(iE6);
                arrayList.add(cVar);
            }
            return arrayList;
        } finally {
            cursorB.close();
            xVarY.J();
        }
    }

    @Override // n2.a
    public List b(int i3) {
        x xVarY = x.y("select * from console_history order by lastSend desc limit ?", 1);
        xVarY.l(1, i3);
        this.f10227a.d();
        Cursor cursorB = X.b.b(this.f10227a, xVarY, false, null);
        try {
            int iE = X.a.e(cursorB, "data");
            int iE2 = X.a.e(cursorB, "codePage");
            int iE3 = X.a.e(cursorB, "mode");
            int iE4 = X.a.e(cursorB, "howLF");
            int iE5 = X.a.e(cursorB, "hash");
            int iE6 = X.a.e(cursorB, "lastSend");
            ArrayList arrayList = new ArrayList(cursorB.getCount());
            while (cursorB.moveToNext()) {
                c cVar = new c(cursorB.isNull(iE) ? null : cursorB.getString(iE), cursorB.isNull(iE2) ? null : cursorB.getString(iE2), cursorB.getInt(iE3), cursorB.getInt(iE4));
                cVar.f10236e = cursorB.getInt(iE5);
                cVar.f10237f = cursorB.getLong(iE6);
                arrayList.add(cVar);
            }
            return arrayList;
        } finally {
            cursorB.close();
            xVarY.J();
        }
    }

    @Override // n2.a
    public void c(c cVar) {
        this.f10227a.d();
        this.f10227a.e();
        try {
            this.f10228b.insert(cVar);
            this.f10227a.A();
        } finally {
            this.f10227a.i();
        }
    }

    @Override // n2.a
    public void d(c cVar) {
        this.f10227a.d();
        this.f10227a.e();
        try {
            this.f10229c.handle(cVar);
            this.f10227a.A();
        } finally {
            this.f10227a.i();
        }
    }
}
