package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class Guideline extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3816a;

    public Guideline(Context context) {
        super(context);
        this.f3816a = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z3) {
        this.f3816a = z3;
    }

    public void setGuidelineBegin(int i3) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        if (this.f3816a && bVar.f3758a == i3) {
            return;
        }
        bVar.f3758a = i3;
        setLayoutParams(bVar);
    }

    public void setGuidelineEnd(int i3) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        if (this.f3816a && bVar.f3760b == i3) {
            return;
        }
        bVar.f3760b = i3;
        setLayoutParams(bVar);
    }

    public void setGuidelinePercent(float f3) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        if (this.f3816a && bVar.f3762c == f3) {
            return;
        }
        bVar.f3762c = f3;
        setLayoutParams(bVar);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3816a = true;
        super.setVisibility(8);
    }
}
