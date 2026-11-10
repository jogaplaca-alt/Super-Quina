package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

/* JADX INFO: loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private final ClockHandView f8801A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private final ClockFaceView f8802B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private final MaterialButtonToggleGroup f8803C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private final View.OnClickListener f8804D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Chip f8805y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Chip f8806z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePickerView.C(TimePickerView.this);
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            TimePickerView.D(TimePickerView.this);
            return false;
        }
    }

    class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ GestureDetector f8809a;

        c(GestureDetector gestureDetector) {
            this.f8809a = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f8809a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    interface d {
    }

    interface e {
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static /* synthetic */ e C(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    static /* synthetic */ d D(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(MaterialButtonToggleGroup materialButtonToggleGroup, int i3, boolean z3) {
    }

    private void F() {
        Chip chip = this.f8805y;
        int i3 = S0.e.f1620F;
        chip.setTag(i3, 12);
        this.f8806z.setTag(i3, 10);
        this.f8805y.setOnClickListener(this.f8804D);
        this.f8806z.setOnClickListener(this.f8804D);
        this.f8805y.setAccessibilityClassName("android.view.View");
        this.f8806z.setAccessibilityClassName("android.view.View");
    }

    private void G() {
        c cVar = new c(new GestureDetector(getContext(), new b()));
        this.f8805y.setOnTouchListener(cVar);
        this.f8806z.setOnTouchListener(cVar);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (view == this && i3 == 0) {
            this.f8806z.sendAccessibilityEvent(8);
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8804D = new a();
        LayoutInflater.from(context).inflate(S0.g.f1675p, this);
        this.f8802B = (ClockFaceView) findViewById(S0.e.f1640i);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(S0.e.f1643l);
        this.f8803C = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new MaterialButtonToggleGroup.d() { // from class: com.google.android.material.timepicker.g
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.d
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i4, boolean z3) {
                this.f8824a.E(materialButtonToggleGroup2, i4, z3);
            }
        });
        this.f8805y = (Chip) findViewById(S0.e.f1646o);
        this.f8806z = (Chip) findViewById(S0.e.f1644m);
        this.f8801A = (ClockHandView) findViewById(S0.e.f1641j);
        G();
        F();
    }
}
