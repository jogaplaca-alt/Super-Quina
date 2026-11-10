package p001a0;

import Z.k;
import android.database.sqlite.SQLiteStatement;

/* JADX INFO: loaded from: classes.dex */
public final class h extends g implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SQLiteStatement f2219b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        S1.k.e(sQLiteStatement, "delegate");
        this.f2219b = sQLiteStatement;
    }

    @Override // Z.k
    public long B() {
        return this.f2219b.executeInsert();
    }

    @Override // Z.k
    public int n() {
        return this.f2219b.executeUpdateDelete();
    }
}
