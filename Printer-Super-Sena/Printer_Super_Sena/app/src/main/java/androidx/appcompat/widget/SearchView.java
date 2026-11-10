package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends W implements androidx.appcompat.view.c {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    static final o f3132n0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private Rect f3133A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private int[] f3134B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private int[] f3135C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private final ImageView f3136D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private final Drawable f3137E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private final int f3138F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private final int f3139G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private final Intent f3140H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private final Intent f3141I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final CharSequence f3142J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    View.OnFocusChangeListener f3143K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private View.OnClickListener f3144L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private boolean f3145M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private boolean f3146N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    E.a f3147O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private boolean f3148P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private CharSequence f3149Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private boolean f3150R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private boolean f3151S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private int f3152T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private boolean f3153U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private CharSequence f3154V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private CharSequence f3155W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f3156a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private int f3157b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    SearchableInfo f3158c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private Bundle f3159d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final Runnable f3160e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private Runnable f3161f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final WeakHashMap f3162g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final View.OnClickListener f3163h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    View.OnKeyListener f3164i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private final TextView.OnEditorActionListener f3165j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final AdapterView.OnItemClickListener f3166k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f3167l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private TextWatcher f3168m0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final SearchAutoComplete f3169p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final View f3170q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final View f3171r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final View f3172s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final ImageView f3173t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final ImageView f3174u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final ImageView f3175v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final ImageView f3176w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final View f3177x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private q f3178y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Rect f3179z;

    public static class SearchAutoComplete extends C0260d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f3180e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private SearchView f3181f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f3182g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Runnable f3183h;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.d();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, p012d.a.f9095m);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i3 = configuration.screenWidthDp;
            int i4 = configuration.screenHeightDp;
            if (i3 >= 960 && i4 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i3 < 600) {
                return (i3 < 640 || i4 < 480) ? 160 : 192;
            }
            return 192;
        }

        void b() {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.f3132n0.c(this);
                return;
            }
            k.b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        boolean c() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void d() {
            if (this.f3182g) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f3182g = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f3180e <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.C0260d, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f3182g) {
                removeCallbacks(this.f3183h);
                post(this.f3183h);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z3, int i3, Rect rect) {
            super.onFocusChanged(z3, i3, rect);
            this.f3181f.Z();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
            if (i3 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f3181f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i3, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z3) {
            super.onWindowFocusChanged(z3);
            if (z3 && this.f3181f.hasFocus() && getVisibility() == 0) {
                this.f3182g = true;
                if (SearchView.M(getContext())) {
                    b();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z3) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z3) {
                this.f3182g = false;
                removeCallbacks(this.f3183h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f3182g = true;
                    return;
                }
                this.f3182g = false;
                removeCallbacks(this.f3183h);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.f3181f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i3) {
            super.setThreshold(i3);
            this.f3180e = i3;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            this.f3183h = new a();
            this.f3180e = getThreshold();
        }
    }

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            SearchView.this.Y(charSequence);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.f0();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            E.a aVar = SearchView.this.f3147O;
            if (aVar instanceof e0) {
                aVar.b(null);
            }
        }
    }

    class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z3) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f3143K;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z3);
            }
        }
    }

    class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            SearchView.this.B();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f3173t) {
                searchView.V();
                return;
            }
            if (view == searchView.f3175v) {
                searchView.R();
                return;
            }
            if (view == searchView.f3174u) {
                searchView.W();
            } else if (view == searchView.f3176w) {
                searchView.a0();
            } else if (view == searchView.f3169p) {
                searchView.H();
            }
        }
    }

    class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f3158c0 == null) {
                return false;
            }
            if (searchView.f3169p.isPopupShowing() && SearchView.this.f3169p.getListSelection() != -1) {
                return SearchView.this.X(view, i3, keyEvent);
            }
            if (SearchView.this.f3169p.c() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i3 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.P(0, null, searchView2.f3169p.getText().toString());
            return true;
        }
    }

    class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            SearchView.this.W();
            return true;
        }
    }

    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            SearchView.this.S(i3, 0, null);
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            SearchView.this.T(i3);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    static class k {
        static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        static void b(SearchAutoComplete searchAutoComplete, int i3) {
            searchAutoComplete.setInputMethodMode(i3);
        }
    }

    public interface l {
    }

    public interface m {
    }

    public interface n {
    }

    private static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Method f3195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Method f3196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f3197c;

        o() {
            this.f3195a = null;
            this.f3196b = null;
            this.f3197c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                this.f3195a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                this.f3196b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f3197c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f3196b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f3195a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f3197c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    static class p extends F.a {
        public static final Parcelable.Creator<p> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f3198c;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public p createFromParcel(Parcel parcel) {
                return new p(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public p createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new p(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public p[] newArray(int i3) {
                return new p[i3];
            }
        }

        p(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f3198c + "}";
        }

        @Override // F.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeValue(Boolean.valueOf(this.f3198c));
        }

        public p(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3198c = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    private static class q extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f3199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f3200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Rect f3201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Rect f3202d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f3203e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f3204f;

        public q(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f3203e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f3200b = new Rect();
            this.f3202d = new Rect();
            this.f3201c = new Rect();
            a(rect, rect2);
            this.f3199a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f3200b.set(rect);
            this.f3202d.set(rect);
            Rect rect3 = this.f3202d;
            int i3 = this.f3203e;
            rect3.inset(-i3, -i3);
            this.f3201c.set(rect2);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x003c  */
        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z3;
            boolean z4;
            int x3 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z5 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z4 = this.f3204f;
                    if (z4 && !this.f3202d.contains(x3, y3)) {
                        z5 = z4;
                        z3 = false;
                    }
                } else if (action != 3) {
                    z3 = true;
                    z5 = false;
                } else {
                    z4 = this.f3204f;
                    this.f3204f = false;
                }
                z5 = z4;
                z3 = true;
            } else if (this.f3200b.contains(x3, y3)) {
                this.f3204f = true;
                z3 = true;
            } else {
                z3 = true;
                z5 = false;
            }
            if (!z5) {
                return false;
            }
            if (!z3 || this.f3201c.contains(x3, y3)) {
                Rect rect = this.f3201c;
                motionEvent.setLocation(x3 - rect.left, y3 - rect.top);
            } else {
                motionEvent.setLocation(this.f3199a.getWidth() / 2, this.f3199a.getHeight() / 2);
            }
            return this.f3199a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        f3132n0 = Build.VERSION.SDK_INT < 29 ? new o() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private Intent C(String str, Uri uri, String str2, String str3, int i3, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f3155W);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f3159d0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i3 != 0) {
            intent.putExtra("action_key", i3);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f3158c0.getSearchActivity());
        return intent;
    }

    private Intent D(Cursor cursor, int i3, String str) {
        int position;
        String strO;
        try {
            String strO2 = e0.o(cursor, "suggest_intent_action");
            if (strO2 == null) {
                strO2 = this.f3158c0.getSuggestIntentAction();
            }
            if (strO2 == null) {
                strO2 = "android.intent.action.SEARCH";
            }
            String str2 = strO2;
            String strO3 = e0.o(cursor, "suggest_intent_data");
            if (strO3 == null) {
                strO3 = this.f3158c0.getSuggestIntentData();
            }
            if (strO3 != null && (strO = e0.o(cursor, "suggest_intent_data_id")) != null) {
                strO3 = strO3 + "/" + Uri.encode(strO);
            }
            return C(str2, strO3 == null ? null : Uri.parse(strO3), e0.o(cursor, "suggest_intent_extra_data"), e0.o(cursor, "suggest_intent_query"), i3, str);
        } catch (RuntimeException e3) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e3);
            return null;
        }
    }

    private Intent E(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f3159d0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent F(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void G() {
        this.f3169p.dismissDropDown();
    }

    private void I(View view, Rect rect) {
        view.getLocationInWindow(this.f3134B);
        getLocationInWindow(this.f3135C);
        int[] iArr = this.f3134B;
        int i3 = iArr[1];
        int[] iArr2 = this.f3135C;
        int i4 = i3 - iArr2[1];
        int i5 = iArr[0] - iArr2[0];
        rect.set(i5, i4, view.getWidth() + i5, view.getHeight() + i4);
    }

    private CharSequence J(CharSequence charSequence) {
        if (!this.f3145M || this.f3137E == null) {
            return charSequence;
        }
        double textSize = this.f3169p.getTextSize();
        Double.isNaN(textSize);
        int i3 = (int) (textSize * 1.25d);
        this.f3137E.setBounds(0, 0, i3, i3);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f3137E), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean K() {
        Intent intent;
        SearchableInfo searchableInfo = this.f3158c0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        if (this.f3158c0.getVoiceSearchLaunchWebSearch()) {
            intent = this.f3140H;
        } else {
            intent = this.f3158c0.getVoiceSearchLaunchRecognizer() ? this.f3141I : null;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    static boolean M(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean N() {
        return (this.f3148P || this.f3153U) && !L();
    }

    private void O(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e3) {
            Log.e("SearchView", "Failed launch activity: " + intent, e3);
        }
    }

    private boolean Q(int i3, int i4, String str) {
        Cursor cursorC = this.f3147O.c();
        if (cursorC == null || !cursorC.moveToPosition(i3)) {
            return false;
        }
        O(D(cursorC, i4, str));
        return true;
    }

    private void b0() {
        post(this.f3160e0);
    }

    private void c0(int i3) {
        Editable text = this.f3169p.getText();
        Cursor cursorC = this.f3147O.c();
        if (cursorC == null) {
            return;
        }
        if (!cursorC.moveToPosition(i3)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceA = this.f3147O.a(cursorC);
        if (charSequenceA != null) {
            setQuery(charSequenceA);
        } else {
            setQuery(text);
        }
    }

    private void e0() {
        boolean zIsEmpty = TextUtils.isEmpty(this.f3169p.getText());
        this.f3175v.setVisibility(!zIsEmpty || (this.f3145M && !this.f3156a0) ? 0 : 8);
        Drawable drawable = this.f3175v.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void g0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f3169p;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(J(queryHint));
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(p012d.d.f9122e);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(p012d.d.f9123f);
    }

    private void h0() {
        this.f3169p.setThreshold(this.f3158c0.getSuggestThreshold());
        this.f3169p.setImeOptions(this.f3158c0.getImeOptions());
        int inputType = this.f3158c0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f3158c0.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.f3169p.setInputType(inputType);
        E.a aVar = this.f3147O;
        if (aVar != null) {
            aVar.b(null);
        }
        if (this.f3158c0.getSuggestAuthority() != null) {
            e0 e0Var = new e0(getContext(), this, this.f3158c0, this.f3162g0);
            this.f3147O = e0Var;
            this.f3169p.setAdapter(e0Var);
            ((e0) this.f3147O).x(this.f3150R ? 2 : 1);
        }
    }

    private void i0() {
        this.f3172s.setVisibility((N() && (this.f3174u.getVisibility() == 0 || this.f3176w.getVisibility() == 0)) ? 0 : 8);
    }

    private void j0(boolean z3) {
        this.f3174u.setVisibility((this.f3148P && N() && hasFocus() && (z3 || !this.f3153U)) ? 0 : 8);
    }

    private void k0(boolean z3) {
        this.f3146N = z3;
        int i3 = 8;
        int i4 = z3 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.f3169p.getText());
        this.f3173t.setVisibility(i4);
        j0(!zIsEmpty);
        this.f3170q.setVisibility(z3 ? 8 : 0);
        if (this.f3136D.getDrawable() != null && !this.f3145M) {
            i3 = 0;
        }
        this.f3136D.setVisibility(i3);
        e0();
        l0(zIsEmpty);
        i0();
    }

    private void l0(boolean z3) {
        int i3 = 8;
        if (this.f3153U && !L() && z3) {
            this.f3174u.setVisibility(8);
            i3 = 0;
        }
        this.f3176w.setVisibility(i3);
    }

    private void setQuery(CharSequence charSequence) {
        this.f3169p.setText(charSequence);
        this.f3169p.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void B() {
        if (this.f3177x.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f3171r.getPaddingLeft();
            Rect rect = new Rect();
            boolean zB = u0.b(this);
            int dimensionPixelSize = this.f3145M ? resources.getDimensionPixelSize(p012d.d.f9120c) + resources.getDimensionPixelSize(p012d.d.f9121d) : 0;
            this.f3169p.getDropDownBackground().getPadding(rect);
            this.f3169p.setDropDownHorizontalOffset(zB ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f3169p.setDropDownWidth((((this.f3177x.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    void H() {
        if (Build.VERSION.SDK_INT >= 29) {
            k.a(this.f3169p);
            return;
        }
        o oVar = f3132n0;
        oVar.b(this.f3169p);
        oVar.a(this.f3169p);
    }

    public boolean L() {
        return this.f3146N;
    }

    void P(int i3, String str, String str2) {
        getContext().startActivity(C("android.intent.action.SEARCH", null, null, str2, i3, str));
    }

    void R() {
        if (!TextUtils.isEmpty(this.f3169p.getText())) {
            this.f3169p.setText("");
            this.f3169p.requestFocus();
            this.f3169p.setImeVisibility(true);
        } else if (this.f3145M) {
            clearFocus();
            k0(true);
        }
    }

    boolean S(int i3, int i4, String str) {
        Q(i3, 0, null);
        this.f3169p.setImeVisibility(false);
        G();
        return true;
    }

    boolean T(int i3) {
        c0(i3);
        return true;
    }

    protected void U(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void V() {
        k0(false);
        this.f3169p.requestFocus();
        this.f3169p.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f3144L;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void W() {
        Editable text = this.f3169p.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f3158c0 != null) {
            P(0, null, text.toString());
        }
        this.f3169p.setImeVisibility(false);
        G();
    }

    boolean X(View view, int i3, KeyEvent keyEvent) {
        if (this.f3158c0 != null && this.f3147O != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i3 == 66 || i3 == 84 || i3 == 61) {
                return S(this.f3169p.getListSelection(), 0, null);
            }
            if (i3 == 21 || i3 == 22) {
                this.f3169p.setSelection(i3 == 21 ? 0 : this.f3169p.length());
                this.f3169p.setListSelection(0);
                this.f3169p.clearListSelection();
                this.f3169p.b();
                return true;
            }
            if (i3 == 19) {
                this.f3169p.getListSelection();
                return false;
            }
        }
        return false;
    }

    void Y(CharSequence charSequence) {
        Editable text = this.f3169p.getText();
        this.f3155W = text;
        boolean zIsEmpty = TextUtils.isEmpty(text);
        j0(!zIsEmpty);
        l0(zIsEmpty);
        e0();
        i0();
        this.f3154V = charSequence.toString();
    }

    void Z() {
        k0(L());
        b0();
        if (this.f3169p.hasFocus()) {
            H();
        }
    }

    void a0() {
        SearchableInfo searchableInfo = this.f3158c0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(F(this.f3140H, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(E(this.f3141I, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    @Override // androidx.appcompat.view.c
    public void c() {
        if (this.f3156a0) {
            return;
        }
        this.f3156a0 = true;
        int imeOptions = this.f3169p.getImeOptions();
        this.f3157b0 = imeOptions;
        this.f3169p.setImeOptions(imeOptions | 33554432);
        this.f3169p.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f3151S = true;
        super.clearFocus();
        this.f3169p.clearFocus();
        this.f3169p.setImeVisibility(false);
        this.f3151S = false;
    }

    public void d0(CharSequence charSequence, boolean z3) {
        this.f3169p.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f3169p;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f3155W = charSequence;
        }
        if (!z3 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        W();
    }

    @Override // androidx.appcompat.view.c
    public void f() {
        d0("", false);
        clearFocus();
        k0(true);
        this.f3169p.setImeOptions(this.f3157b0);
        this.f3156a0 = false;
    }

    void f0() {
        int[] iArr = this.f3169p.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f3171r.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f3172s.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public int getImeOptions() {
        return this.f3169p.getImeOptions();
    }

    public int getInputType() {
        return this.f3169p.getInputType();
    }

    public int getMaxWidth() {
        return this.f3152T;
    }

    public CharSequence getQuery() {
        return this.f3169p.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f3149Q;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f3158c0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f3142J : getContext().getText(this.f3158c0.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.f3139G;
    }

    int getSuggestionRowLayout() {
        return this.f3138F;
    }

    public E.a getSuggestionsAdapter() {
        return this.f3147O;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f3160e0);
        post(this.f3161f0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.W, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        if (z3) {
            I(this.f3169p, this.f3179z);
            Rect rect = this.f3133A;
            Rect rect2 = this.f3179z;
            rect.set(rect2.left, 0, rect2.right, i6 - i4);
            q qVar = this.f3178y;
            if (qVar != null) {
                qVar.a(this.f3133A, this.f3179z);
                return;
            }
            q qVar2 = new q(this.f3133A, this.f3179z, this.f3169p);
            this.f3178y = qVar2;
            setTouchDelegate(qVar2);
        }
    }

    @Override // androidx.appcompat.widget.W, android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        if (L()) {
            super.onMeasure(i3, i4);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            int i6 = this.f3152T;
            size = i6 > 0 ? Math.min(i6, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f3152T;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i5 = this.f3152T) > 0) {
            size = Math.min(i5, size);
        }
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof p)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        p pVar = (p) parcelable;
        super.onRestoreInstanceState(pVar.c());
        k0(pVar.f3198c);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        p pVar = new p(super.onSaveInstanceState());
        pVar.f3198c = L();
        return pVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        b0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i3, Rect rect) {
        if (this.f3151S || !isFocusable()) {
            return false;
        }
        if (L()) {
            return super.requestFocus(i3, rect);
        }
        boolean zRequestFocus = this.f3169p.requestFocus(i3, rect);
        if (zRequestFocus) {
            k0(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f3159d0 = bundle;
    }

    public void setIconified(boolean z3) {
        if (z3) {
            R();
        } else {
            V();
        }
    }

    public void setIconifiedByDefault(boolean z3) {
        if (this.f3145M == z3) {
            return;
        }
        this.f3145M = z3;
        k0(z3);
        g0();
    }

    public void setImeOptions(int i3) {
        this.f3169p.setImeOptions(i3);
    }

    public void setInputType(int i3) {
        this.f3169p.setInputType(i3);
    }

    public void setMaxWidth(int i3) {
        this.f3152T = i3;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f3143K = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f3144L = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f3149Q = charSequence;
        g0();
    }

    public void setQueryRefinementEnabled(boolean z3) {
        this.f3150R = z3;
        E.a aVar = this.f3147O;
        if (aVar instanceof e0) {
            ((e0) aVar).x(z3 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f3158c0 = searchableInfo;
        if (searchableInfo != null) {
            h0();
            g0();
        }
        boolean zK = K();
        this.f3153U = zK;
        if (zK) {
            this.f3169p.setPrivateImeOptions("nm");
        }
        k0(L());
    }

    public void setSubmitButtonEnabled(boolean z3) {
        this.f3148P = z3;
        k0(L());
    }

    public void setSuggestionsAdapter(E.a aVar) {
        this.f3147O = aVar;
        this.f3169p.setAdapter(aVar);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p012d.a.f9076I);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3179z = new Rect();
        this.f3133A = new Rect();
        this.f3134B = new int[2];
        this.f3135C = new int[2];
        this.f3160e0 = new b();
        this.f3161f0 = new c();
        this.f3162g0 = new WeakHashMap();
        f fVar = new f();
        this.f3163h0 = fVar;
        this.f3164i0 = new g();
        h hVar = new h();
        this.f3165j0 = hVar;
        i iVar = new i();
        this.f3166k0 = iVar;
        j jVar = new j();
        this.f3167l0 = jVar;
        this.f3168m0 = new a();
        int[] iArr = p012d.j.f9397n2;
        j0 j0VarV = j0.v(context, attributeSet, iArr, i3, 0);
        androidx.core.view.Z.o0(this, context, iArr, attributeSet, j0VarV.r(), i3, 0);
        LayoutInflater.from(context).inflate(j0VarV.n(p012d.j.f9437x2, p012d.g.f9235r), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(p012d.f.f9179D);
        this.f3169p = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f3170q = findViewById(p012d.f.f9217z);
        View viewFindViewById = findViewById(p012d.f.f9178C);
        this.f3171r = viewFindViewById;
        View viewFindViewById2 = findViewById(p012d.f.f9185J);
        this.f3172s = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(p012d.f.f9215x);
        this.f3173t = imageView;
        ImageView imageView2 = (ImageView) findViewById(p012d.f.f9176A);
        this.f3174u = imageView2;
        ImageView imageView3 = (ImageView) findViewById(p012d.f.f9216y);
        this.f3175v = imageView3;
        ImageView imageView4 = (ImageView) findViewById(p012d.f.f9180E);
        this.f3176w = imageView4;
        ImageView imageView5 = (ImageView) findViewById(p012d.f.f9177B);
        this.f3136D = imageView5;
        androidx.core.view.Z.u0(viewFindViewById, j0VarV.g(p012d.j.f9441y2));
        androidx.core.view.Z.u0(viewFindViewById2, j0VarV.g(p012d.j.f9268C2));
        int i4 = p012d.j.f9264B2;
        imageView.setImageDrawable(j0VarV.g(i4));
        imageView2.setImageDrawable(j0VarV.g(p012d.j.f9429v2));
        imageView3.setImageDrawable(j0VarV.g(p012d.j.f9417s2));
        imageView4.setImageDrawable(j0VarV.g(p012d.j.f9276E2));
        imageView5.setImageDrawable(j0VarV.g(i4));
        this.f3137E = j0VarV.g(p012d.j.f9260A2);
        o0.a(imageView, getResources().getString(p012d.h.f9251n));
        this.f3138F = j0VarV.n(p012d.j.f9272D2, p012d.g.f9234q);
        this.f3139G = j0VarV.n(p012d.j.f9421t2, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f3168m0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f3164i0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(j0VarV.a(p012d.j.f9433w2, true));
        int iF = j0VarV.f(p012d.j.f9405p2, -1);
        if (iF != -1) {
            setMaxWidth(iF);
        }
        this.f3142J = j0VarV.p(p012d.j.f9425u2);
        this.f3149Q = j0VarV.p(p012d.j.f9445z2);
        int iK = j0VarV.k(p012d.j.f9413r2, -1);
        if (iK != -1) {
            setImeOptions(iK);
        }
        int iK2 = j0VarV.k(p012d.j.f9409q2, -1);
        if (iK2 != -1) {
            setInputType(iK2);
        }
        setFocusable(j0VarV.a(p012d.j.f9401o2, true));
        j0VarV.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f3140H = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f3141I = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f3177x = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new e());
        }
        k0(this.f3145M);
        g0();
    }
}
