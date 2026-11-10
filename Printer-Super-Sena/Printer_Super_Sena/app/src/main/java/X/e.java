package X;

import K1.D;
import K1.J;
import K1.n;
import S1.k;
import Z.g;
import android.database.Cursor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    private static final Map a(g gVar, String str) throws IOException {
        Cursor cursorD = gVar.D("PRAGMA table_info(`" + str + "`)");
        try {
            if (cursorD.getColumnCount() <= 0) {
                Map mapG = D.g();
                P1.a.a(cursorD, null);
                return mapG;
            }
            int columnIndex = cursorD.getColumnIndex("name");
            int columnIndex2 = cursorD.getColumnIndex("type");
            int columnIndex3 = cursorD.getColumnIndex("notnull");
            int columnIndex4 = cursorD.getColumnIndex("pk");
            int columnIndex5 = cursorD.getColumnIndex("dflt_value");
            Map mapC = D.c();
            while (cursorD.moveToNext()) {
                String string = cursorD.getString(columnIndex);
                String string2 = cursorD.getString(columnIndex2);
                boolean z3 = cursorD.getInt(columnIndex3) != 0;
                int i3 = cursorD.getInt(columnIndex4);
                String string3 = cursorD.getString(columnIndex5);
                k.d(string, "name");
                k.d(string2, "type");
                mapC.put(string, new d.a(string, string2, z3, i3, string3, 2));
            }
            Map mapB = D.b(mapC);
            P1.a.a(cursorD, null);
            return mapB;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                P1.a.a(cursorD, th);
                throw th2;
            }
        }
    }

    private static final List b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        List listC = n.c();
        while (cursor.moveToNext()) {
            int i3 = cursor.getInt(columnIndex);
            int i4 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            k.d(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            k.d(string2, "cursor.getString(toColumnIndex)");
            listC.add(new d.C0030d(i3, i4, string, string2));
        }
        return n.m(n.a(listC));
    }

    private static final Set c(g gVar, String str) throws IOException {
        Cursor cursorD = gVar.D("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = cursorD.getColumnIndex("id");
            int columnIndex2 = cursorD.getColumnIndex("seq");
            int columnIndex3 = cursorD.getColumnIndex("table");
            int columnIndex4 = cursorD.getColumnIndex("on_delete");
            int columnIndex5 = cursorD.getColumnIndex("on_update");
            List listB = b(cursorD);
            cursorD.moveToPosition(-1);
            Set setB = J.b();
            while (cursorD.moveToNext()) {
                if (cursorD.getInt(columnIndex2) == 0) {
                    int i3 = cursorD.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<d.C0030d> arrayList3 = new ArrayList();
                    for (Object obj : listB) {
                        if (((d.C0030d) obj).c() == i3) {
                            arrayList3.add(obj);
                        }
                    }
                    for (d.C0030d c0030d : arrayList3) {
                        arrayList.add(c0030d.b());
                        arrayList2.add(c0030d.d());
                    }
                    String string = cursorD.getString(columnIndex3);
                    k.d(string, "cursor.getString(tableColumnIndex)");
                    String string2 = cursorD.getString(columnIndex4);
                    k.d(string2, "cursor.getString(onDeleteColumnIndex)");
                    String string3 = cursorD.getString(columnIndex5);
                    k.d(string3, "cursor.getString(onUpdateColumnIndex)");
                    setB.add(new d.c(string, string2, string3, arrayList, arrayList2));
                }
            }
            Set setA = J.a(setB);
            P1.a.a(cursorD, null);
            return setA;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                P1.a.a(cursorD, th);
                throw th2;
            }
        }
    }

    private static final d.e d(g gVar, String str, boolean z3) throws IOException {
        Cursor cursorD = gVar.D("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorD.getColumnIndex("seqno");
            int columnIndex2 = cursorD.getColumnIndex("cid");
            int columnIndex3 = cursorD.getColumnIndex("name");
            int columnIndex4 = cursorD.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursorD.moveToNext()) {
                    if (cursorD.getInt(columnIndex2) >= 0) {
                        int i3 = cursorD.getInt(columnIndex);
                        String string = cursorD.getString(columnIndex3);
                        String str2 = cursorD.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        Integer numValueOf = Integer.valueOf(i3);
                        k.d(string, "columnName");
                        treeMap.put(numValueOf, string);
                        treeMap2.put(Integer.valueOf(i3), str2);
                    }
                }
                Collection collectionValues = treeMap.values();
                k.d(collectionValues, "columnsMap.values");
                List listP = n.p(collectionValues);
                Collection collectionValues2 = treeMap2.values();
                k.d(collectionValues2, "ordersMap.values");
                d.e eVar = new d.e(str, z3, listP, n.p(collectionValues2));
                P1.a.a(cursorD, null);
                return eVar;
            }
            P1.a.a(cursorD, null);
            return null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                P1.a.a(cursorD, th);
                throw th2;
            }
        }
    }

    private static final Set e(g gVar, String str) throws IOException {
        Cursor cursorD = gVar.D("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = cursorD.getColumnIndex("name");
            int columnIndex2 = cursorD.getColumnIndex("origin");
            int columnIndex3 = cursorD.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                Set setB = J.b();
                while (cursorD.moveToNext()) {
                    if (k.a("c", cursorD.getString(columnIndex2))) {
                        String string = cursorD.getString(columnIndex);
                        boolean z3 = true;
                        if (cursorD.getInt(columnIndex3) != 1) {
                            z3 = false;
                        }
                        k.d(string, "name");
                        d.e eVarD = d(gVar, string, z3);
                        if (eVarD == null) {
                            P1.a.a(cursorD, null);
                            return null;
                        }
                        setB.add(eVarD);
                    }
                }
                Set setA = J.a(setB);
                P1.a.a(cursorD, null);
                return setA;
            }
            P1.a.a(cursorD, null);
            return null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                P1.a.a(cursorD, th);
                throw th2;
            }
        }
    }

    public static final d f(g gVar, String str) {
        k.e(gVar, "database");
        k.e(str, "tableName");
        return new d(str, a(gVar, str), c(gVar, str), e(gVar, str));
    }
}
