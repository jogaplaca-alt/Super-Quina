package com.google.android.material.button;

import A.T;
import S0.j;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.core.view.AbstractC0321u;
import androidx.core.view.C0282a;
import androidx.core.view.Z;
import com.google.android.material.internal.C;
import com.google.android.material.internal.F;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import p042l1.k;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f7816k = j.f1734u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f7817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f7818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedHashSet f7819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Comparator f7820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer[] f7821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f7823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f7825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Set f7826j;

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    class b extends C0282a {
        b() {
        }

        @Override // androidx.core.view.C0282a
        public void g(View view, T t3) {
            super.g(view, t3);
            t3.p0(T.f.a(0, 1, MaterialButtonToggleGroup.this.i(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    private static class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final p042l1.c f7829e = new p042l1.a(0.0f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        p042l1.c f7830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        p042l1.c f7831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        p042l1.c f7832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        p042l1.c f7833d;

        c(p042l1.c cVar, p042l1.c cVar2, p042l1.c cVar3, p042l1.c cVar4) {
            this.f7830a = cVar;
            this.f7831b = cVar3;
            this.f7832c = cVar4;
            this.f7833d = cVar2;
        }

        public static c a(c cVar) {
            p042l1.c cVar2 = f7829e;
            return new c(cVar2, cVar.f7833d, cVar2, cVar.f7832c);
        }

        public static c b(c cVar, View view) {
            return F.g(view) ? c(cVar) : d(cVar);
        }

        public static c c(c cVar) {
            p042l1.c cVar2 = cVar.f7830a;
            p042l1.c cVar3 = cVar.f7833d;
            p042l1.c cVar4 = f7829e;
            return new c(cVar2, cVar3, cVar4, cVar4);
        }

        public static c d(c cVar) {
            p042l1.c cVar2 = f7829e;
            return new c(cVar2, cVar2, cVar.f7831b, cVar.f7832c);
        }

        public static c e(c cVar, View view) {
            return F.g(view) ? d(cVar) : c(cVar);
        }

        public static c f(c cVar) {
            p042l1.c cVar2 = cVar.f7830a;
            p042l1.c cVar3 = f7829e;
            return new c(cVar2, cVar3, cVar.f7831b, cVar3);
        }
    }

    public interface d {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i3, boolean z3);
    }

    private class e implements MaterialButton.a {
        private e() {
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(MaterialButton materialButton, boolean z3) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ e(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, S0.a.f1529u);
    }

    private void c() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i3 = firstVisibleChildIndex + 1; i3 < getChildCount(); i3++) {
            MaterialButton materialButtonH = h(i3);
            int iMin = Math.min(materialButtonH.getStrokeWidth(), h(i3 - 1).getStrokeWidth());
            LinearLayout.LayoutParams layoutParamsD = d(materialButtonH);
            if (getOrientation() == 0) {
                AbstractC0321u.c(layoutParamsD, 0);
                AbstractC0321u.d(layoutParamsD, -iMin);
                layoutParamsD.topMargin = 0;
            } else {
                layoutParamsD.bottomMargin = 0;
                layoutParamsD.topMargin = -iMin;
                AbstractC0321u.d(layoutParamsD, 0);
            }
            materialButtonH.setLayoutParams(layoutParamsD);
        }
        n(firstVisibleChildIndex);
    }

    private LinearLayout.LayoutParams d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void e(int i3, boolean z3) {
        if (i3 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i3);
            return;
        }
        HashSet hashSet = new HashSet(this.f7826j);
        if (z3 && !hashSet.contains(Integer.valueOf(i3))) {
            if (this.f7823g && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i3));
        } else {
            if (z3 || !hashSet.contains(Integer.valueOf(i3))) {
                return;
            }
            if (!this.f7824h || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i3));
            }
        }
        q(hashSet);
    }

    private void g(int i3, boolean z3) {
        Iterator it = this.f7819c.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(this, i3, z3);
        }
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (k(i3)) {
                return i3;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (k(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if ((getChildAt(i4) instanceof MaterialButton) && k(i4)) {
                i3++;
            }
        }
        return i3;
    }

    private MaterialButton h(int i3) {
        return (MaterialButton) getChildAt(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == view) {
                return i3;
            }
            if ((getChildAt(i4) instanceof MaterialButton) && k(i4)) {
                i3++;
            }
        }
        return -1;
    }

    private c j(int i3, int i4, int i5) {
        c cVar = (c) this.f7817a.get(i3);
        if (i4 == i5) {
            return cVar;
        }
        boolean z3 = getOrientation() == 0;
        if (i3 == i4) {
            return z3 ? c.e(cVar, this) : c.f(cVar);
        }
        if (i3 == i5) {
            return z3 ? c.b(cVar, this) : c.a(cVar);
        }
        return null;
    }

    private boolean k(int i3) {
        return getChildAt(i3).getVisibility() != 8;
    }

    private void n(int i3) {
        if (getChildCount() == 0 || i3 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) h(i3).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            AbstractC0321u.c(layoutParams, 0);
            AbstractC0321u.d(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void o(int i3, boolean z3) {
        View viewFindViewById = findViewById(i3);
        if (viewFindViewById instanceof MaterialButton) {
            this.f7822f = true;
            ((MaterialButton) viewFindViewById).setChecked(z3);
            this.f7822f = false;
        }
    }

    private static void p(k.b bVar, c cVar) {
        if (cVar == null) {
            bVar.o(0.0f);
        } else {
            bVar.B(cVar.f7830a).t(cVar.f7833d).F(cVar.f7831b).x(cVar.f7832c);
        }
    }

    private void q(Set set) {
        Set set2 = this.f7826j;
        this.f7826j = new HashSet(set);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            int id = h(i3).getId();
            o(id, set.contains(Integer.valueOf(id)));
            if (set2.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                g(id, set.contains(Integer.valueOf(id)));
            }
        }
        invalidate();
    }

    private void r() {
        TreeMap treeMap = new TreeMap(this.f7820d);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            treeMap.put(h(i3), Integer.valueOf(i3));
        }
        this.f7821e = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(Z.m());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f7818b);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private void t() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            h(i3).setA11yClassName((this.f7823g ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i3, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        e(materialButton.getId(), materialButton.isChecked());
        k shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f7817a.add(new c(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        materialButton.setEnabled(isEnabled());
        Z.q0(materialButton, new b());
    }

    public void b(d dVar) {
        this.f7819c.add(dVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        r();
        super.dispatchDraw(canvas);
    }

    public void f() {
        q(new HashSet());
    }

    public int getCheckedButtonId() {
        if (!this.f7823g || this.f7826j.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f7826j.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            int id = h(i3).getId();
            if (this.f7826j.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i4) {
        Integer[] numArr = this.f7821e;
        if (numArr != null && i4 < numArr.length) {
            return numArr[i4].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i4;
    }

    public boolean l() {
        return this.f7823g;
    }

    void m(MaterialButton materialButton, boolean z3) {
        if (this.f7822f) {
            return;
        }
        e(materialButton.getId(), z3);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i3 = this.f7825i;
        if (i3 != -1) {
            q(Collections.singleton(Integer.valueOf(i3)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        T.P0(accessibilityNodeInfo).o0(T.e.b(1, getVisibleButtonCount(), false, l() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        s();
        c();
        super.onMeasure(i3, i4);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f7817a.remove(iIndexOfChild);
        }
        s();
        c();
    }

    void s() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i3 = 0; i3 < childCount; i3++) {
            MaterialButton materialButtonH = h(i3);
            if (materialButtonH.getVisibility() != 8) {
                k.b bVarV = materialButtonH.getShapeAppearanceModel().v();
                p(bVarV, j(i3, firstVisibleChildIndex, lastVisibleChildIndex));
                materialButtonH.setShapeAppearanceModel(bVarV.m());
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            h(i3).setEnabled(z3);
        }
    }

    public void setSelectionRequired(boolean z3) {
        this.f7824h = z3;
    }

    public void setSingleSelection(boolean z3) {
        if (this.f7823g != z3) {
            this.f7823g = z3;
            f();
        }
        t();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f7816k;
        super(p051o1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f7817a = new ArrayList();
        this.f7818b = new e(this, null);
        this.f7819c = new LinkedHashSet();
        this.f7820d = new a();
        this.f7822f = false;
        this.f7826j = new HashSet();
        TypedArray typedArrayI = C.i(getContext(), attributeSet, S0.k.j3, i3, i4, new int[0]);
        setSingleSelection(typedArrayI.getBoolean(S0.k.n3, false));
        this.f7825i = typedArrayI.getResourceId(S0.k.l3, -1);
        this.f7824h = typedArrayI.getBoolean(S0.k.m3, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayI.getBoolean(S0.k.k3, true));
        typedArrayI.recycle();
        Z.z0(this, 1);
    }

    public void setSingleSelection(int i3) {
        setSingleSelection(getResources().getBoolean(i3));
    }
}
