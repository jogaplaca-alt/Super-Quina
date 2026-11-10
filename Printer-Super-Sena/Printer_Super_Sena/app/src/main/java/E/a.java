package E;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, E.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Cursor f198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Context f199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected C0007a f201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected DataSetObserver f202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected E.b f203h;

    /* JADX INFO: renamed from: E.a$a, reason: collision with other inner class name */
    private class C0007a extends ContentObserver {
        C0007a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3) {
            a.this.i();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f196a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f196a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z3) {
        f(context, cursor, z3 ? 1 : 2);
    }

    @Override // E.b.a
    public abstract CharSequence a(Cursor cursor);

    @Override // E.b.a
    public void b(Cursor cursor) {
        Cursor cursorJ = j(cursor);
        if (cursorJ != null) {
            cursorJ.close();
        }
    }

    @Override // E.b.a
    public Cursor c() {
        return this.f198c;
    }

    public abstract void e(View view, Context context, Cursor cursor);

    void f(Context context, Cursor cursor, int i3) {
        if ((i3 & 1) == 1) {
            i3 |= 2;
            this.f197b = true;
        } else {
            this.f197b = false;
        }
        boolean z3 = cursor != null;
        this.f198c = cursor;
        this.f196a = z3;
        this.f199d = context;
        this.f200e = z3 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i3 & 2) == 2) {
            this.f201f = new C0007a();
            this.f202g = new b();
        } else {
            this.f201f = null;
            this.f202g = null;
        }
        if (z3) {
            C0007a c0007a = this.f201f;
            if (c0007a != null) {
                cursor.registerContentObserver(c0007a);
            }
            DataSetObserver dataSetObserver = this.f202g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f196a || (cursor = this.f198c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        if (!this.f196a) {
            return null;
        }
        this.f198c.moveToPosition(i3);
        if (view == null) {
            view = g(this.f199d, this.f198c, viewGroup);
        }
        e(view, this.f199d, this.f198c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f203h == null) {
            this.f203h = new E.b(this);
        }
        return this.f203h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        Cursor cursor;
        if (!this.f196a || (cursor = this.f198c) == null) {
            return null;
        }
        cursor.moveToPosition(i3);
        return this.f198c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        Cursor cursor;
        if (this.f196a && (cursor = this.f198c) != null && cursor.moveToPosition(i3)) {
            return this.f198c.getLong(this.f200e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (!this.f196a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f198c.moveToPosition(i3)) {
            if (view == null) {
                view = h(this.f199d, this.f198c, viewGroup);
            }
            e(view, this.f199d, this.f198c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i3);
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void i() {
        Cursor cursor;
        if (!this.f197b || (cursor = this.f198c) == null || cursor.isClosed()) {
            return;
        }
        this.f196a = this.f198c.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f198c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0007a c0007a = this.f201f;
            if (c0007a != null) {
                cursor2.unregisterContentObserver(c0007a);
            }
            DataSetObserver dataSetObserver = this.f202g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f198c = cursor;
        if (cursor != null) {
            C0007a c0007a2 = this.f201f;
            if (c0007a2 != null) {
                cursor.registerContentObserver(c0007a2);
            }
            DataSetObserver dataSetObserver2 = this.f202g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f200e = cursor.getColumnIndexOrThrow("_id");
            this.f196a = true;
            notifyDataSetChanged();
        } else {
            this.f200e = -1;
            this.f196a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
