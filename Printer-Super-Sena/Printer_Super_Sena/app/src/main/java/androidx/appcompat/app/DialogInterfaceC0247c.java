package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

/* JADX INFO: renamed from: androidx.appcompat.app.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class DialogInterfaceC0247c extends z implements DialogInterface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AlertController f2520f;

    /* JADX INFO: renamed from: androidx.appcompat.app.c$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AlertController.f f2521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2522b;

        public a(Context context) {
            this(context, DialogInterfaceC0247c.i(context, 0));
        }

        public DialogInterfaceC0247c a() {
            DialogInterfaceC0247c dialogInterfaceC0247c = new DialogInterfaceC0247c(this.f2521a.f2386a, this.f2522b);
            this.f2521a.a(dialogInterfaceC0247c.f2520f);
            dialogInterfaceC0247c.setCancelable(this.f2521a.f2403r);
            if (this.f2521a.f2403r) {
                dialogInterfaceC0247c.setCanceledOnTouchOutside(true);
            }
            dialogInterfaceC0247c.setOnCancelListener(this.f2521a.f2404s);
            dialogInterfaceC0247c.setOnDismissListener(this.f2521a.f2405t);
            DialogInterface.OnKeyListener onKeyListener = this.f2521a.f2406u;
            if (onKeyListener != null) {
                dialogInterfaceC0247c.setOnKeyListener(onKeyListener);
            }
            return dialogInterfaceC0247c;
        }

        public Context b() {
            return this.f2521a.f2386a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f2521a;
            fVar.f2408w = listAdapter;
            fVar.f2409x = onClickListener;
            return this;
        }

        public a d(View view) {
            this.f2521a.f2392g = view;
            return this;
        }

        public a e(Drawable drawable) {
            this.f2521a.f2389d = drawable;
            return this;
        }

        public a f(int i3) {
            AlertController.f fVar = this.f2521a;
            fVar.f2393h = fVar.f2386a.getText(i3);
            return this;
        }

        public a g(DialogInterface.OnKeyListener onKeyListener) {
            this.f2521a.f2406u = onKeyListener;
            return this;
        }

        public a h(int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f2521a;
            fVar.f2394i = fVar.f2386a.getText(i3);
            this.f2521a.f2396k = onClickListener;
            return this;
        }

        public a i(ListAdapter listAdapter, int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f2521a;
            fVar.f2408w = listAdapter;
            fVar.f2409x = onClickListener;
            fVar.f2379I = i3;
            fVar.f2378H = true;
            return this;
        }

        public a j(CharSequence charSequence) {
            this.f2521a.f2391f = charSequence;
            return this;
        }

        public a k(View view) {
            AlertController.f fVar = this.f2521a;
            fVar.f2411z = view;
            fVar.f2410y = 0;
            fVar.f2375E = false;
            return this;
        }

        public a(Context context, int i3) {
            this.f2521a = new AlertController.f(new ContextThemeWrapper(context, DialogInterfaceC0247c.i(context, i3)));
            this.f2522b = i3;
        }
    }

    protected DialogInterfaceC0247c(Context context, int i3) {
        super(context, i(context, i3));
        this.f2520f = new AlertController(getContext(), this, getWindow());
    }

    static int i(Context context, int i3) {
        if (((i3 >>> 24) & 255) >= 1) {
            return i3;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(p012d.a.f9094l, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView h() {
        return this.f2520f.d();
    }

    @Override // androidx.appcompat.app.z, androidx.activity.l, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2520f.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (this.f2520f.g(i3, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        if (this.f2520f.h(i3, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // androidx.appcompat.app.z, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f2520f.q(charSequence);
    }
}
