package E;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f207i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f208j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private LayoutInflater f209k;

    public c(Context context, int i3, Cursor cursor, boolean z3) {
        super(context, cursor, z3);
        this.f208j = i3;
        this.f207i = i3;
        this.f209k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // E.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f209k.inflate(this.f208j, viewGroup, false);
    }

    @Override // E.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f209k.inflate(this.f207i, viewGroup, false);
    }
}
