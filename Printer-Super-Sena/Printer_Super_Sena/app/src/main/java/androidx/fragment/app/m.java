package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
class m implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final o f5277a;

    class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f5278a;

        a(u uVar) {
            this.f5278a = uVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eK = this.f5278a.k();
            this.f5278a.m();
            H.n((ViewGroup) abstractComponentCallbacksC0337eK.f5165H.getParent(), m.this.f5277a).j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    m(o oVar) {
        this.f5277a = oVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        u uVarS;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f5277a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, O.c.f1385d);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(O.c.f1386e);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(O.c.f1387f, -1);
        String string = typedArrayObtainStyledAttributes.getString(O.c.f1388g);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !k.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eD0 = resourceId != -1 ? this.f5277a.d0(resourceId) : null;
        if (abstractComponentCallbacksC0337eD0 == null && string != null) {
            abstractComponentCallbacksC0337eD0 = this.f5277a.e0(string);
        }
        if (abstractComponentCallbacksC0337eD0 == null && id != -1) {
            abstractComponentCallbacksC0337eD0 = this.f5277a.d0(id);
        }
        if (abstractComponentCallbacksC0337eD0 == null) {
            abstractComponentCallbacksC0337eD0 = this.f5277a.n0().a(context.getClassLoader(), attributeValue);
            abstractComponentCallbacksC0337eD0.f5197n = true;
            abstractComponentCallbacksC0337eD0.f5206w = resourceId != 0 ? resourceId : id;
            abstractComponentCallbacksC0337eD0.f5207x = id;
            abstractComponentCallbacksC0337eD0.f5208y = string;
            abstractComponentCallbacksC0337eD0.f5198o = true;
            o oVar = this.f5277a;
            abstractComponentCallbacksC0337eD0.f5202s = oVar;
            abstractComponentCallbacksC0337eD0.f5203t = oVar.q0();
            abstractComponentCallbacksC0337eD0.B0(this.f5277a.q0().f(), attributeSet, abstractComponentCallbacksC0337eD0.f5185b);
            uVarS = this.f5277a.e(abstractComponentCallbacksC0337eD0);
            if (o.C0(2)) {
                Log.v("FragmentManager", "Fragment " + abstractComponentCallbacksC0337eD0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (abstractComponentCallbacksC0337eD0.f5198o) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            abstractComponentCallbacksC0337eD0.f5198o = true;
            o oVar2 = this.f5277a;
            abstractComponentCallbacksC0337eD0.f5202s = oVar2;
            abstractComponentCallbacksC0337eD0.f5203t = oVar2.q0();
            abstractComponentCallbacksC0337eD0.B0(this.f5277a.q0().f(), attributeSet, abstractComponentCallbacksC0337eD0.f5185b);
            uVarS = this.f5277a.s(abstractComponentCallbacksC0337eD0);
            if (o.C0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + abstractComponentCallbacksC0337eD0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        abstractComponentCallbacksC0337eD0.f5164G = (ViewGroup) view;
        uVarS.m();
        uVarS.j();
        View view2 = abstractComponentCallbacksC0337eD0.f5165H;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (abstractComponentCallbacksC0337eD0.f5165H.getTag() == null) {
            abstractComponentCallbacksC0337eD0.f5165H.setTag(string);
        }
        abstractComponentCallbacksC0337eD0.f5165H.addOnAttachStateChangeListener(new a(uVarS));
        return abstractComponentCallbacksC0337eD0.f5165H;
    }
}
