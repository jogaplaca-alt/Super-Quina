package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.W;
import androidx.core.view.Z;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class AlertController {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    NestedScrollView f2311A;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private Drawable f2313C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private ImageView f2314D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private TextView f2315E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private TextView f2316F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private View f2317G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    ListAdapter f2318H;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f2320J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private int f2321K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    int f2322L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    int f2323M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    int f2324N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    int f2325O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private boolean f2326P;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    Handler f2328R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final z f2331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Window f2332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f2334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f2335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ListView f2336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f2337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f2340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f2341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f2342m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Button f2344o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f2345p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Message f2346q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Drawable f2347r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Button f2348s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private CharSequence f2349t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    Message f2350u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Drawable f2351v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Button f2352w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private CharSequence f2353x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Message f2354y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Drawable f2355z;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f2343n = false;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private int f2312B = 0;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    int f2319I = -1;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private int f2327Q = 0;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private final View.OnClickListener f2329S = new a();

    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2357b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p012d.j.f9385k2);
            this.f2357b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(p012d.j.f9389l2, -1);
            this.f2356a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(p012d.j.f9393m2, -1);
        }

        public void a(boolean z3, boolean z4) {
            if (z4 && z3) {
                return;
            }
            setPadding(getPaddingLeft(), z3 ? getPaddingTop() : this.f2356a, getPaddingRight(), z4 ? getPaddingBottom() : this.f2357b);
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message messageObtain;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view == alertController.f2344o && (message3 = alertController.f2346q) != null) {
                messageObtain = Message.obtain(message3);
            } else if (view != alertController.f2348s || (message2 = alertController.f2350u) == null) {
                messageObtain = (view != alertController.f2352w || (message = alertController.f2354y) == null) ? null : Message.obtain(message);
            } else {
                messageObtain = Message.obtain(message2);
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.f2328R.obtainMessage(1, alertController2.f2331b).sendToTarget();
        }
    }

    class b implements NestedScrollView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f2359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2360b;

        b(View view, View view2) {
            this.f2359a = view;
            this.f2360b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.d
        public void a(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
            AlertController.f(nestedScrollView, this.f2359a, this.f2360b);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f2362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2363b;

        c(View view, View view2) {
            this.f2362a = view;
            this.f2363b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.f2311A, this.f2362a, this.f2363b);
        }
    }

    class d implements AbsListView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f2365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2366b;

        d(View view, View view2) {
            this.f2365a = view;
            this.f2366b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
            AlertController.f(absListView, this.f2365a, this.f2366b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f2368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2369b;

        e(View view, View view2) {
            this.f2368a = view;
            this.f2369b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.f2336g, this.f2368a, this.f2369b);
        }
    }

    public static class f {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public int f2371A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public int f2372B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public int f2373C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public int f2374D;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public boolean[] f2376F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public boolean f2377G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public boolean f2378H;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public DialogInterface.OnMultiChoiceClickListener f2380J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public Cursor f2381K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public String f2382L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public String f2383M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public AdapterView.OnItemSelectedListener f2384N;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f2386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f2387b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f2389d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f2391f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View f2392g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f2393h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CharSequence f2394i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Drawable f2395j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f2396k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f2397l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Drawable f2398m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f2399n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public CharSequence f2400o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Drawable f2401p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f2402q;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f2404s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f2405t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f2406u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public CharSequence[] f2407v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public ListAdapter f2408w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f2409x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f2410y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public View f2411z;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2388c = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2390e = 0;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public boolean f2375E = false;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public int f2379I = -1;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public boolean f2385O = true;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f2403r = true;

        class a extends ArrayAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f2412a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i3, int i4, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i3, i4, charSequenceArr);
                this.f2412a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i3, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i3, view, viewGroup);
                boolean[] zArr = f.this.f2376F;
                if (zArr != null && zArr[i3]) {
                    this.f2412a.setItemChecked(i3, true);
                }
                return view2;
            }
        }

        class b extends CursorAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f2414a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f2415b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ RecycleListView f2416c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ AlertController f2417d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Context context, Cursor cursor, boolean z3, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z3);
                this.f2416c = recycleListView;
                this.f2417d = alertController;
                Cursor cursor2 = getCursor();
                this.f2414a = cursor2.getColumnIndexOrThrow(f.this.f2382L);
                this.f2415b = cursor2.getColumnIndexOrThrow(f.this.f2383M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f2414a));
                this.f2416c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f2415b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f2387b.inflate(this.f2417d.f2323M, viewGroup, false);
            }
        }

        class c implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AlertController f2419a;

            c(AlertController alertController) {
                this.f2419a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
                f.this.f2409x.onClick(this.f2419a.f2331b, i3);
                if (f.this.f2378H) {
                    return;
                }
                this.f2419a.f2331b.dismiss();
            }
        }

        class d implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f2421a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AlertController f2422b;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f2421a = recycleListView;
                this.f2422b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
                boolean[] zArr = f.this.f2376F;
                if (zArr != null) {
                    zArr[i3] = this.f2421a.isItemChecked(i3);
                }
                f.this.f2380J.onClick(this.f2422b.f2331b, i3, this.f2421a.isItemChecked(i3));
            }
        }

        public f(Context context) {
            this.f2386a = context;
            this.f2387b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            ListAdapter hVar;
            RecycleListView recycleListView = (RecycleListView) this.f2387b.inflate(alertController.f2322L, (ViewGroup) null);
            if (this.f2377G) {
                hVar = this.f2381K == null ? new a(this.f2386a, alertController.f2323M, R.id.text1, this.f2407v, recycleListView) : new b(this.f2386a, this.f2381K, false, recycleListView, alertController);
            } else {
                int i3 = this.f2378H ? alertController.f2324N : alertController.f2325O;
                if (this.f2381K != null) {
                    hVar = new SimpleCursorAdapter(this.f2386a, i3, this.f2381K, new String[]{this.f2382L}, new int[]{R.id.text1});
                } else {
                    hVar = this.f2408w;
                    if (hVar == null) {
                        hVar = new h(this.f2386a, i3, R.id.text1, this.f2407v);
                    }
                }
            }
            alertController.f2318H = hVar;
            alertController.f2319I = this.f2379I;
            if (this.f2409x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.f2380J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f2384N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.f2378H) {
                recycleListView.setChoiceMode(1);
            } else if (this.f2377G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f2336g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.f2392g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f2391f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f2389d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i3 = this.f2388c;
                if (i3 != 0) {
                    alertController.m(i3);
                }
                int i4 = this.f2390e;
                if (i4 != 0) {
                    alertController.m(alertController.c(i4));
                }
            }
            CharSequence charSequence2 = this.f2393h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f2394i;
            if (charSequence3 != null || this.f2395j != null) {
                alertController.k(-1, charSequence3, this.f2396k, null, this.f2395j);
            }
            CharSequence charSequence4 = this.f2397l;
            if (charSequence4 != null || this.f2398m != null) {
                alertController.k(-2, charSequence4, this.f2399n, null, this.f2398m);
            }
            CharSequence charSequence5 = this.f2400o;
            if (charSequence5 != null || this.f2401p != null) {
                alertController.k(-3, charSequence5, this.f2402q, null, this.f2401p);
            }
            if (this.f2407v != null || this.f2381K != null || this.f2408w != null) {
                b(alertController);
            }
            View view2 = this.f2411z;
            if (view2 != null) {
                if (this.f2375E) {
                    alertController.t(view2, this.f2371A, this.f2372B, this.f2373C, this.f2374D);
                    return;
                } else {
                    alertController.s(view2);
                    return;
                }
            }
            int i5 = this.f2410y;
            if (i5 != 0) {
                alertController.r(i5);
            }
        }
    }

    private static final class g extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference f2424a;

        public g(DialogInterface dialogInterface) {
            this.f2424a = new WeakReference(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == -3 || i3 == -2 || i3 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f2424a.get(), message.what);
            } else {
                if (i3 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class h extends ArrayAdapter {
        public h(Context context, int i3, int i4, CharSequence[] charSequenceArr) {
            super(context, i3, i4, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, z zVar, Window window) {
        this.f2330a = context;
        this.f2331b = zVar;
        this.f2332c = window;
        this.f2328R = new g(zVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, p012d.j.f9277F, p012d.a.f9093k, 0);
        this.f2320J = typedArrayObtainStyledAttributes.getResourceId(p012d.j.f9281G, 0);
        this.f2321K = typedArrayObtainStyledAttributes.getResourceId(p012d.j.f9288I, 0);
        this.f2322L = typedArrayObtainStyledAttributes.getResourceId(p012d.j.f9294K, 0);
        this.f2323M = typedArrayObtainStyledAttributes.getResourceId(p012d.j.f9297L, 0);
        this.f2324N = typedArrayObtainStyledAttributes.getResourceId(p012d.j.f9303N, 0);
        this.f2325O = typedArrayObtainStyledAttributes.getResourceId(p012d.j.f9291J, 0);
        this.f2326P = typedArrayObtainStyledAttributes.getBoolean(p012d.j.f9300M, true);
        this.f2333d = typedArrayObtainStyledAttributes.getDimensionPixelSize(p012d.j.f9285H, 0);
        typedArrayObtainStyledAttributes.recycle();
        zVar.g(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void f(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i3 = this.f2321K;
        if (i3 == 0) {
            return this.f2320J;
        }
        return this.f2327Q == 1 ? i3 : this.f2320J;
    }

    private void p(ViewGroup viewGroup, View view, int i3, int i4) {
        View viewFindViewById = this.f2332c.findViewById(p012d.f.f9213v);
        View viewFindViewById2 = this.f2332c.findViewById(p012d.f.f9212u);
        if (Build.VERSION.SDK_INT >= 23) {
            Z.H0(view, i3, i4);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        if (viewFindViewById != null && (i3 & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 != null && (i3 & 2) == 0) {
            viewGroup.removeView(viewFindViewById2);
            viewFindViewById2 = null;
        }
        if (viewFindViewById == null && viewFindViewById2 == null) {
            return;
        }
        if (this.f2335f != null) {
            this.f2311A.setOnScrollChangeListener(new b(viewFindViewById, viewFindViewById2));
            this.f2311A.post(new c(viewFindViewById, viewFindViewById2));
            return;
        }
        ListView listView = this.f2336g;
        if (listView != null) {
            listView.setOnScrollListener(new d(viewFindViewById, viewFindViewById2));
            this.f2336g.post(new e(viewFindViewById, viewFindViewById2));
            return;
        }
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    private void u(ViewGroup viewGroup) {
        int i3;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f2344o = button;
        button.setOnClickListener(this.f2329S);
        if (TextUtils.isEmpty(this.f2345p) && this.f2347r == null) {
            this.f2344o.setVisibility(8);
            i3 = 0;
        } else {
            this.f2344o.setText(this.f2345p);
            Drawable drawable = this.f2347r;
            if (drawable != null) {
                int i4 = this.f2333d;
                drawable.setBounds(0, 0, i4, i4);
                this.f2344o.setCompoundDrawables(this.f2347r, null, null, null);
            }
            this.f2344o.setVisibility(0);
            i3 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.f2348s = button2;
        button2.setOnClickListener(this.f2329S);
        if (TextUtils.isEmpty(this.f2349t) && this.f2351v == null) {
            this.f2348s.setVisibility(8);
        } else {
            this.f2348s.setText(this.f2349t);
            Drawable drawable2 = this.f2351v;
            if (drawable2 != null) {
                int i5 = this.f2333d;
                drawable2.setBounds(0, 0, i5, i5);
                this.f2348s.setCompoundDrawables(this.f2351v, null, null, null);
            }
            this.f2348s.setVisibility(0);
            i3 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f2352w = button3;
        button3.setOnClickListener(this.f2329S);
        if (TextUtils.isEmpty(this.f2353x) && this.f2355z == null) {
            this.f2352w.setVisibility(8);
        } else {
            this.f2352w.setText(this.f2353x);
            Drawable drawable3 = this.f2355z;
            if (drawable3 != null) {
                int i6 = this.f2333d;
                drawable3.setBounds(0, 0, i6, i6);
                this.f2352w.setCompoundDrawables(this.f2355z, null, null, null);
            }
            this.f2352w.setVisibility(0);
            i3 |= 4;
        }
        if (z(this.f2330a)) {
            if (i3 == 1) {
                b(this.f2344o);
            } else if (i3 == 2) {
                b(this.f2348s);
            } else if (i3 == 4) {
                b(this.f2352w);
            }
        }
        if (i3 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f2332c.findViewById(p012d.f.f9214w);
        this.f2311A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f2311A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.f2316F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f2335f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.f2311A.removeView(this.f2316F);
        if (this.f2336g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f2311A.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.f2311A);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f2336g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void w(ViewGroup viewGroup) {
        View viewInflate = this.f2337h;
        if (viewInflate == null) {
            viewInflate = this.f2338i != 0 ? LayoutInflater.from(this.f2330a).inflate(this.f2338i, viewGroup, false) : null;
        }
        boolean z3 = viewInflate != null;
        if (!z3 || !a(viewInflate)) {
            this.f2332c.setFlags(131072, 131072);
        }
        if (!z3) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f2332c.findViewById(p012d.f.f9205n);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f2343n) {
            frameLayout.setPadding(this.f2339j, this.f2340k, this.f2341l, this.f2342m);
        }
        if (this.f2336g != null) {
            ((LinearLayout.LayoutParams) ((W.a) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    private void x(ViewGroup viewGroup) {
        if (this.f2317G != null) {
            viewGroup.addView(this.f2317G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f2332c.findViewById(p012d.f.f9190O).setVisibility(8);
            return;
        }
        this.f2314D = (ImageView) this.f2332c.findViewById(R.id.icon);
        if (TextUtils.isEmpty(this.f2334e) || !this.f2326P) {
            this.f2332c.findViewById(p012d.f.f9190O).setVisibility(8);
            this.f2314D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f2332c.findViewById(p012d.f.f9201j);
        this.f2315E = textView;
        textView.setText(this.f2334e);
        int i3 = this.f2312B;
        if (i3 != 0) {
            this.f2314D.setImageResource(i3);
            return;
        }
        Drawable drawable = this.f2313C;
        if (drawable != null) {
            this.f2314D.setImageDrawable(drawable);
        } else {
            this.f2315E.setPadding(this.f2314D.getPaddingLeft(), this.f2314D.getPaddingTop(), this.f2314D.getPaddingRight(), this.f2314D.getPaddingBottom());
            this.f2314D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f2332c.findViewById(p012d.f.f9211t);
        int i3 = p012d.f.f9191P;
        View viewFindViewById4 = viewFindViewById3.findViewById(i3);
        int i4 = p012d.f.f9204m;
        View viewFindViewById5 = viewFindViewById3.findViewById(i4);
        int i5 = p012d.f.f9202k;
        View viewFindViewById6 = viewFindViewById3.findViewById(i5);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(p012d.f.f9206o);
        w(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(i3);
        View viewFindViewById8 = viewGroup.findViewById(i4);
        View viewFindViewById9 = viewGroup.findViewById(i5);
        ViewGroup viewGroupI = i(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupI2 = i(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupI3 = i(viewFindViewById9, viewFindViewById6);
        v(viewGroupI2);
        u(viewGroupI3);
        x(viewGroupI);
        boolean z3 = viewGroup.getVisibility() != 8;
        boolean z4 = (viewGroupI == null || viewGroupI.getVisibility() == 8) ? 0 : 1;
        boolean z5 = (viewGroupI3 == null || viewGroupI3.getVisibility() == 8) ? false : true;
        if (!z5 && viewGroupI2 != null && (viewFindViewById2 = viewGroupI2.findViewById(p012d.f.f9186K)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z4 != 0) {
            NestedScrollView nestedScrollView = this.f2311A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f2335f == null && this.f2336g == null) ? null : viewGroupI.findViewById(p012d.f.f9189N);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupI2 != null && (viewFindViewById = viewGroupI2.findViewById(p012d.f.f9187L)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f2336g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z4, z5);
        }
        if (!z3) {
            View view = this.f2336g;
            if (view == null) {
                view = this.f2311A;
            }
            if (view != null) {
                p(viewGroupI2, view, z4 | (z5 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f2336g;
        if (listView2 == null || (listAdapter = this.f2318H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i6 = this.f2319I;
        if (i6 > -1) {
            listView2.setItemChecked(i6, true);
            listView2.setSelection(i6);
        }
    }

    private static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(p012d.a.f9092j, typedValue, true);
        return typedValue.data != 0;
    }

    public int c(int i3) {
        TypedValue typedValue = new TypedValue();
        this.f2330a.getTheme().resolveAttribute(i3, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f2336g;
    }

    public void e() {
        this.f2331b.setContentView(j());
        y();
    }

    public boolean g(int i3, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f2311A;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public boolean h(int i3, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f2311A;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public void k(int i3, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f2328R.obtainMessage(i3, onClickListener);
        }
        if (i3 == -3) {
            this.f2353x = charSequence;
            this.f2354y = message;
            this.f2355z = drawable;
        } else if (i3 == -2) {
            this.f2349t = charSequence;
            this.f2350u = message;
            this.f2351v = drawable;
        } else {
            if (i3 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f2345p = charSequence;
            this.f2346q = message;
            this.f2347r = drawable;
        }
    }

    public void l(View view) {
        this.f2317G = view;
    }

    public void m(int i3) {
        this.f2313C = null;
        this.f2312B = i3;
        ImageView imageView = this.f2314D;
        if (imageView != null) {
            if (i3 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f2314D.setImageResource(this.f2312B);
            }
        }
    }

    public void n(Drawable drawable) {
        this.f2313C = drawable;
        this.f2312B = 0;
        ImageView imageView = this.f2314D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f2314D.setImageDrawable(drawable);
            }
        }
    }

    public void o(CharSequence charSequence) {
        this.f2335f = charSequence;
        TextView textView = this.f2316F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(CharSequence charSequence) {
        this.f2334e = charSequence;
        TextView textView = this.f2315E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i3) {
        this.f2337h = null;
        this.f2338i = i3;
        this.f2343n = false;
    }

    public void s(View view) {
        this.f2337h = view;
        this.f2338i = 0;
        this.f2343n = false;
    }

    public void t(View view, int i3, int i4, int i5, int i6) {
        this.f2337h = view;
        this.f2338i = 0;
        this.f2343n = true;
        this.f2339j = i3;
        this.f2340k = i4;
        this.f2341l = i5;
        this.f2342m = i6;
    }
}
