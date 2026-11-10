package X;

import K1.AbstractC0239h;
import S1.k;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final Cursor a(Cursor cursor) throws IOException {
        k.e(cursor, "c");
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                int columnCount = cursor.getColumnCount();
                for (int i3 = 0; i3 < columnCount; i3++) {
                    int type = cursor.getType(i3);
                    if (type == 0) {
                        objArr[i3] = null;
                    } else if (type == 1) {
                        objArr[i3] = Long.valueOf(cursor.getLong(i3));
                    } else if (type == 2) {
                        objArr[i3] = Double.valueOf(cursor.getDouble(i3));
                    } else if (type == 3) {
                        objArr[i3] = cursor.getString(i3);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i3] = cursor.getBlob(i3);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            P1.a.a(cursor, null);
            return matrixCursor;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                P1.a.a(cursor, th);
                throw th2;
            }
        }
    }

    private static final int b(Cursor cursor, String str) {
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        k.d(columnNames, "columnNames");
        return c(columnNames, str);
    }

    public static final int c(String[] strArr, String str) {
        k.e(strArr, "columnNames");
        k.e(str, "name");
        String str2 = '.' + str;
        String str3 = '.' + str + '`';
        int length = strArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            String str4 = strArr[i3];
            int i5 = i4 + 1;
            if (str4.length() >= str.length() + 2) {
                if (X1.c.c(str4, str2, false, 2, null)) {
                    return i4;
                }
                if (str4.charAt(0) == '`' && X1.c.c(str4, str3, false, 2, null)) {
                    return i4;
                }
            }
            i3++;
            i4 = i5;
        }
        return -1;
    }

    public static final int d(Cursor cursor, String str) {
        k.e(cursor, "c");
        k.e(str, "name");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex('`' + str + '`');
        return columnIndex2 >= 0 ? columnIndex2 : b(cursor, str);
    }

    public static final int e(Cursor cursor, String str) {
        String strQ;
        k.e(cursor, "c");
        k.e(str, "name");
        int iD = d(cursor, str);
        if (iD >= 0) {
            return iD;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            k.d(columnNames, "c.columnNames");
            strQ = AbstractC0239h.q(columnNames, null, null, null, 0, null, null, 63, null);
        } catch (Exception e3) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e3);
            strQ = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + strQ);
    }
}
