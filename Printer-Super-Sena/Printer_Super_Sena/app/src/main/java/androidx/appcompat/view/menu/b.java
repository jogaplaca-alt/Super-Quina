package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f2768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f2769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected g f2770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected LayoutInflater f2771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected LayoutInflater f2772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private m.a f2773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected n f2776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2777j;

    public b(Context context, int i3, int i4) {
        this.f2768a = context;
        this.f2771d = LayoutInflater.from(context);
        this.f2774g = i3;
        this.f2775h = i4;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(g gVar, boolean z3) {
        m.a aVar = this.f2773f;
        if (aVar != null) {
            aVar.a(gVar, z3);
        }
    }

    protected void b(View view, int i3) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f2776i).addView(view, i3);
    }

    @Override // androidx.appcompat.view.menu.m
    public int c() {
        return this.f2777j;
    }

    public abstract void f(i iVar, n.a aVar);

    @Override // androidx.appcompat.view.menu.m
    public void g(Context context, g gVar) {
        this.f2769b = context;
        this.f2772e = LayoutInflater.from(context);
        this.f2770c = gVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean i(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean j(g gVar, i iVar) {
        return false;
    }

    public n.a k(ViewGroup viewGroup) {
        return (n.a) this.f2771d.inflate(this.f2775h, viewGroup, false);
    }

    @Override // androidx.appcompat.view.menu.m
    public void l(m.a aVar) {
        this.f2773f = aVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.view.menu.m
    public boolean m(r rVar) {
        m.a aVar = this.f2773f;
        g gVar = rVar;
        if (aVar == null) {
            return false;
        }
        if (rVar == null) {
            gVar = this.f2770c;
        }
        return aVar.b(gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.m
    public void n(boolean z3) {
        ViewGroup viewGroup = (ViewGroup) this.f2776i;
        if (viewGroup == null) {
            return;
        }
        g gVar = this.f2770c;
        int i3 = 0;
        if (gVar != null) {
            gVar.t();
            ArrayList arrayListG = this.f2770c.G();
            int size = arrayListG.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                i iVar = (i) arrayListG.get(i5);
                if (t(i4, iVar)) {
                    View childAt = viewGroup.getChildAt(i4);
                    i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                    View viewQ = q(iVar, childAt, viewGroup);
                    if (iVar != itemData) {
                        viewQ.setPressed(false);
                        viewQ.jumpDrawablesToCurrentState();
                    }
                    if (viewQ != childAt) {
                        b(viewQ, i4);
                    }
                    i4++;
                }
            }
            i3 = i4;
        }
        while (i3 < viewGroup.getChildCount()) {
            if (!o(viewGroup, i3)) {
                i3++;
            }
        }
    }

    protected boolean o(ViewGroup viewGroup, int i3) {
        viewGroup.removeViewAt(i3);
        return true;
    }

    public m.a p() {
        return this.f2773f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View q(i iVar, View view, ViewGroup viewGroup) {
        n.a aVarK = view instanceof n.a ? (n.a) view : k(viewGroup);
        f(iVar, aVarK);
        return (View) aVarK;
    }

    public n r(ViewGroup viewGroup) {
        if (this.f2776i == null) {
            n nVar = (n) this.f2771d.inflate(this.f2774g, viewGroup, false);
            this.f2776i = nVar;
            nVar.b(this.f2770c);
            n(true);
        }
        return this.f2776i;
    }

    public void s(int i3) {
        this.f2777j = i3;
    }

    public abstract boolean t(int i3, i iVar);
}
