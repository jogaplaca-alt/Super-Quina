package com.google.android.material.internal;

import A.T;
import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.widget.C0271o;
import androidx.core.view.C0282a;
import androidx.core.view.Z;

/* JADX INFO: loaded from: classes.dex */
public class CheckableImageButton extends C0271o implements Checkable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f8178g = {R.attr.state_checked};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8181f;

    class a extends C0282a {
        a() {
        }

        @Override // androidx.core.view.C0282a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // androidx.core.view.C0282a
        public void g(View view, T t3) {
            super.g(view, t3);
            t3.k0(CheckableImageButton.this.a());
            t3.l0(CheckableImageButton.this.isChecked());
        }
    }

    static class b extends F.a {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f8183c;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        private void d(Parcel parcel) {
            this.f8183c = parcel.readInt() == 1;
        }

        @Override // F.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f8183c ? 1 : 0);
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            d(parcel);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p012d.a.f9070C);
    }

    public boolean a() {
        return this.f8180e;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f8179d;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i3) {
        if (!this.f8179d) {
            return super.onCreateDrawableState(i3);
        }
        int[] iArr = f8178g;
        return View.mergeDrawableStates(super.onCreateDrawableState(i3 + iArr.length), iArr);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.c());
        setChecked(bVar.f8183c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f8183c = this.f8179d;
        return bVar;
    }

    public void setCheckable(boolean z3) {
        if (this.f8180e != z3) {
            this.f8180e = z3;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z3) {
        if (!this.f8180e || this.f8179d == z3) {
            return;
        }
        this.f8179d = z3;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z3) {
        this.f8181f = z3;
    }

    @Override // android.view.View
    public void setPressed(boolean z3) {
        if (this.f8181f) {
            super.setPressed(z3);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f8179d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8180e = true;
        this.f8181f = true;
        Z.q0(this, new a());
    }
}
