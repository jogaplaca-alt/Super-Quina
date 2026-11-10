package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.C0260d;
import androidx.appcompat.widget.C0262f;
import androidx.appcompat.widget.C0263g;
import androidx.appcompat.widget.C0267k;
import androidx.appcompat.widget.C0271o;
import androidx.appcompat.widget.C0274s;
import androidx.appcompat.widget.C0277v;
import androidx.appcompat.widget.C0278w;
import androidx.appcompat.widget.C0280y;
import androidx.appcompat.widget.g0;
import androidx.core.view.Z;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class A {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class[] f2299b = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f2300c = {R.attr.onClick};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f2301d = {R.attr.accessibilityHeading};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f2302e = {R.attr.accessibilityPaneTitle};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f2303f = {R.attr.screenReaderFocusable};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f2304g = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final p046n.g f2305h = new p046n.g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f2306a = new Object[2];

    private static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f2307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f2308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f2309c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Context f2310d;

        public a(View view, String str) {
            this.f2307a = view;
            this.f2308b = str;
        }

        private void a(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f2308b, View.class)) != null) {
                        this.f2309c = method;
                        this.f2310d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f2307a.getId();
            if (id == -1) {
                str = "";
            } else {
                str = " with id '" + this.f2307a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f2308b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f2307a.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f2309c == null) {
                a(this.f2307a.getContext());
            }
            try {
                this.f2309c.invoke(this.f2310d, view);
            } catch (IllegalAccessException e3) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e3);
            } catch (InvocationTargetException e4) {
                throw new IllegalStateException("Could not execute method for android:onClick", e4);
            }
        }
    }

    private void a(Context context, View view, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2301d);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            Z.r0(view, typedArrayObtainStyledAttributes.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f2302e);
        if (typedArrayObtainStyledAttributes2.hasValue(0)) {
            Z.t0(view, typedArrayObtainStyledAttributes2.getString(0));
        }
        typedArrayObtainStyledAttributes2.recycle();
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f2303f);
        if (typedArrayObtainStyledAttributes3.hasValue(0)) {
            Z.G0(view, typedArrayObtainStyledAttributes3.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes3.recycle();
    }

    private void b(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && Z.Q(view)) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2300c);
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private View s(Context context, String str, String str2) {
        String str3;
        p046n.g gVar = f2305h;
        Constructor constructor = (Constructor) gVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f2299b);
            gVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f2306a);
    }

    private View t(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.f2306a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return s(context, str, null);
            }
            int i3 = 0;
            while (true) {
                String[] strArr = f2304g;
                if (i3 >= strArr.length) {
                    return null;
                }
                View viewS = s(context, str, strArr[i3]);
                if (viewS != null) {
                    return viewS;
                }
                i3++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f2306a;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static Context u(Context context, AttributeSet attributeSet, boolean z3, boolean z4) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p012d.j.R3, 0, 0);
        int resourceId = z3 ? typedArrayObtainStyledAttributes.getResourceId(p012d.j.S3, 0) : 0;
        if (z4 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(p012d.j.T3, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        if (resourceId != 0) {
            return ((context instanceof androidx.appcompat.view.d) && ((androidx.appcompat.view.d) context).c() == resourceId) ? context : new androidx.appcompat.view.d(context, resourceId);
        }
        return context;
    }

    private void v(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    protected C0260d c(Context context, AttributeSet attributeSet) {
        return new C0260d(context, attributeSet);
    }

    protected AppCompatButton d(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    protected C0262f e(Context context, AttributeSet attributeSet) {
        return new C0262f(context, attributeSet);
    }

    protected C0263g f(Context context, AttributeSet attributeSet) {
        return new C0263g(context, attributeSet);
    }

    protected C0267k g(Context context, AttributeSet attributeSet) {
        return new C0267k(context, attributeSet);
    }

    protected C0271o h(Context context, AttributeSet attributeSet) {
        return new C0271o(context, attributeSet);
    }

    protected androidx.appcompat.widget.r i(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.r(context, attributeSet);
    }

    protected C0274s j(Context context, AttributeSet attributeSet) {
        return new C0274s(context, attributeSet);
    }

    protected C0277v k(Context context, AttributeSet attributeSet) {
        return new C0277v(context, attributeSet);
    }

    protected C0278w l(Context context, AttributeSet attributeSet) {
        return new C0278w(context, attributeSet);
    }

    protected C0280y m(Context context, AttributeSet attributeSet) {
        return new C0280y(context, attributeSet);
    }

    protected androidx.appcompat.widget.A n(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.A(context, attributeSet);
    }

    protected androidx.appcompat.widget.F o(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.F(context, attributeSet);
    }

    protected androidx.appcompat.widget.K p(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.K(context, attributeSet);
    }

    protected View q(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    public final View r(View view, String str, Context context, AttributeSet attributeSet, boolean z3, boolean z4, boolean z5, boolean z6) {
        View viewL;
        Context context2 = (!z3 || view == null) ? context : view.getContext();
        if (z4 || z5) {
            context2 = u(context2, attributeSet, z4, z5);
        }
        if (z6) {
            context2 = g0.b(context2);
        }
        str.hashCode();
        switch (str) {
            case "RatingBar":
                viewL = l(context2, attributeSet);
                v(viewL, str);
                break;
            case "CheckedTextView":
                viewL = f(context2, attributeSet);
                v(viewL, str);
                break;
            case "MultiAutoCompleteTextView":
                viewL = j(context2, attributeSet);
                v(viewL, str);
                break;
            case "TextView":
                viewL = o(context2, attributeSet);
                v(viewL, str);
                break;
            case "ImageButton":
                viewL = h(context2, attributeSet);
                v(viewL, str);
                break;
            case "SeekBar":
                viewL = m(context2, attributeSet);
                v(viewL, str);
                break;
            case "Spinner":
                viewL = n(context2, attributeSet);
                v(viewL, str);
                break;
            case "RadioButton":
                viewL = k(context2, attributeSet);
                v(viewL, str);
                break;
            case "ToggleButton":
                viewL = p(context2, attributeSet);
                v(viewL, str);
                break;
            case "ImageView":
                viewL = i(context2, attributeSet);
                v(viewL, str);
                break;
            case "AutoCompleteTextView":
                viewL = c(context2, attributeSet);
                v(viewL, str);
                break;
            case "CheckBox":
                viewL = e(context2, attributeSet);
                v(viewL, str);
                break;
            case "EditText":
                viewL = g(context2, attributeSet);
                v(viewL, str);
                break;
            case "Button":
                viewL = d(context2, attributeSet);
                v(viewL, str);
                break;
            default:
                viewL = q(context2, str, attributeSet);
                break;
        }
        if (viewL == null && context != context2) {
            viewL = t(context2, str, attributeSet);
        }
        if (viewL != null) {
            b(viewL, attributeSet);
            a(context2, viewL, attributeSet);
        }
        return viewL;
    }
}
