package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f2659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final b f2660b;

    public static class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f2661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Context f2662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayList f2663c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final p046n.g f2664d = new p046n.g();

        public a(Context context, ActionMode.Callback callback) {
            this.f2662b = context;
            this.f2661a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = (Menu) this.f2664d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            o oVar = new o(this.f2662b, (p073w.a) menu);
            this.f2664d.put(menu, oVar);
            return oVar;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f2661a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(b bVar, MenuItem menuItem) {
            return this.f2661a.onActionItemClicked(e(bVar), new j(this.f2662b, (p073w.b) menuItem));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(b bVar, Menu menu) {
            return this.f2661a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public void d(b bVar) {
            this.f2661a.onDestroyActionMode(e(bVar));
        }

        public ActionMode e(b bVar) {
            int size = this.f2663c.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = (f) this.f2663c.get(i3);
                if (fVar != null && fVar.f2660b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f2662b, bVar);
            this.f2663c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f2659a = context;
        this.f2660b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f2660b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f2660b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new o(this.f2659a, (p073w.a) this.f2660b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f2660b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f2660b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f2660b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f2660b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f2660b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f2660b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f2660b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f2660b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f2660b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f2660b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f2660b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z3) {
        this.f2660b.s(z3);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i3) {
        this.f2660b.n(i3);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i3) {
        this.f2660b.q(i3);
    }
}
