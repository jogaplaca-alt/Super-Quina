package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
class e0 extends E.c implements View.OnClickListener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final SearchView f3477l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final SearchableInfo f3478m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Context f3479n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final WeakHashMap f3480o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f3481p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f3482q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f3483r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ColorStateList f3484s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f3485t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f3486u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f3487v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f3488w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f3489x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f3490y;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f3491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f3492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f3493c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f3494d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f3495e;

        public a(View view) {
            this.f3491a = (TextView) view.findViewById(R.id.text1);
            this.f3492b = (TextView) view.findViewById(R.id.text2);
            this.f3493c = (ImageView) view.findViewById(R.id.icon1);
            this.f3494d = (ImageView) view.findViewById(R.id.icon2);
            this.f3495e = (ImageView) view.findViewById(p012d.f.f9208q);
        }
    }

    public e0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f3482q = false;
        this.f3483r = 1;
        this.f3485t = -1;
        this.f3486u = -1;
        this.f3487v = -1;
        this.f3488w = -1;
        this.f3489x = -1;
        this.f3490y = -1;
        this.f3477l = searchView;
        this.f3478m = searchableInfo;
        this.f3481p = searchView.getSuggestionCommitIconResId();
        this.f3479n = context;
        this.f3480o = weakHashMap;
    }

    private void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f3480o.put(str, drawable.getConstantState());
        }
    }

    private void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    private Drawable k(String str) {
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f3480o.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence l(CharSequence charSequence) {
        if (this.f3484s == null) {
            TypedValue typedValue = new TypedValue();
            this.f3479n.getTheme().resolveAttribute(p012d.a.f9080M, typedValue, true);
            this.f3484s = this.f3479n.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f3484s, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable m(ComponentName componentName) {
        PackageManager packageManager = this.f3479n.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w("SuggestionsAdapter", e3.toString());
            return null;
        }
    }

    private Drawable n(ComponentName componentName) {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f3480o.containsKey(strFlattenToShortString)) {
            Drawable drawableM = m(componentName);
            this.f3480o.put(strFlattenToShortString, drawableM != null ? drawableM.getConstantState() : null);
            return drawableM;
        }
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f3480o.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f3479n.getResources());
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    private Drawable p() {
        Drawable drawableN = n(this.f3478m.getSearchActivity());
        return drawableN != null ? drawableN : this.f3479n.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable q(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f3479n.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamOpenInputStream, null);
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e3) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e3);
                }
                return drawableCreateFromStream;
            } catch (Throwable th) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e4) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e5.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e5.getMessage());
        return null;
    }

    private Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i3 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f3479n.getPackageName() + "/" + i3;
            Drawable drawableK = k(str2);
            if (drawableK != null) {
                return drawableK;
            }
            Drawable drawableD = androidx.core.content.a.d(this.f3479n, i3);
            A(str2, drawableD);
            return drawableD;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableK2 = k(str);
            if (drawableK2 != null) {
                return drawableK2;
            }
            Drawable drawableQ = q(Uri.parse(str));
            A(str, drawableQ);
            return drawableQ;
        }
    }

    private Drawable t(Cursor cursor) {
        int i3 = this.f3488w;
        if (i3 == -1) {
            return null;
        }
        Drawable drawableS = s(cursor.getString(i3));
        return drawableS != null ? drawableS : p();
    }

    private Drawable u(Cursor cursor) {
        int i3 = this.f3489x;
        if (i3 == -1) {
            return null;
        }
        return s(cursor.getString(i3));
    }

    private static String w(Cursor cursor, int i3) {
        if (i3 == -1) {
            return null;
        }
        try {
            return cursor.getString(i3);
        } catch (Exception e3) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e3);
            return null;
        }
    }

    private void y(ImageView imageView, Drawable drawable, int i3) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i3);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    @Override // E.a, E.b.a
    public CharSequence a(Cursor cursor) {
        String strO;
        String strO2;
        if (cursor == null) {
            return null;
        }
        String strO3 = o(cursor, "suggest_intent_query");
        if (strO3 != null) {
            return strO3;
        }
        if (this.f3478m.shouldRewriteQueryFromData() && (strO2 = o(cursor, "suggest_intent_data")) != null) {
            return strO2;
        }
        if (!this.f3478m.shouldRewriteQueryFromText() || (strO = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strO;
    }

    @Override // E.a, E.b.a
    public void b(Cursor cursor) {
        if (this.f3482q) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.b(cursor);
            if (cursor != null) {
                this.f3485t = cursor.getColumnIndex("suggest_text_1");
                this.f3486u = cursor.getColumnIndex("suggest_text_2");
                this.f3487v = cursor.getColumnIndex("suggest_text_2_url");
                this.f3488w = cursor.getColumnIndex("suggest_icon_1");
                this.f3489x = cursor.getColumnIndex("suggest_icon_2");
                this.f3490y = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e3) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e3);
        }
    }

    @Override // E.b.a
    public Cursor d(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f3477l.getVisibility() == 0 && this.f3477l.getWindowVisibility() == 0) {
            try {
                Cursor cursorV = v(this.f3478m, string, 50);
                if (cursorV != null) {
                    cursorV.getCount();
                    return cursorV;
                }
            } catch (RuntimeException e3) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e3);
            }
        }
        return null;
    }

    @Override // E.a
    public void e(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i3 = this.f3490y;
        int i4 = i3 != -1 ? cursor.getInt(i3) : 0;
        if (aVar.f3491a != null) {
            z(aVar.f3491a, w(cursor, this.f3485t));
        }
        if (aVar.f3492b != null) {
            String strW = w(cursor, this.f3487v);
            CharSequence charSequenceL = strW != null ? l(strW) : w(cursor, this.f3486u);
            if (TextUtils.isEmpty(charSequenceL)) {
                TextView textView = aVar.f3491a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f3491a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f3491a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f3491a.setMaxLines(1);
                }
            }
            z(aVar.f3492b, charSequenceL);
        }
        ImageView imageView = aVar.f3493c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f3494d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i5 = this.f3483r;
        if (i5 != 2 && (i5 != 1 || (i4 & 1) == 0)) {
            aVar.f3495e.setVisibility(8);
            return;
        }
        aVar.f3495e.setVisibility(0);
        aVar.f3495e.setTag(aVar.f3491a.getText());
        aVar.f3495e.setOnClickListener(this);
    }

    @Override // E.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i3, view, viewGroup);
        } catch (RuntimeException e3) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e3);
            View viewG = g(this.f3479n, c(), viewGroup);
            if (viewG != null) {
                ((a) viewG.getTag()).f3491a.setText(e3.toString());
            }
            return viewG;
        }
    }

    @Override // E.a, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i3, view, viewGroup);
        } catch (RuntimeException e3) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e3);
            View viewH = h(this.f3479n, c(), viewGroup);
            if (viewH != null) {
                ((a) viewH.getTag()).f3491a.setText(e3.toString());
            }
            return viewH;
        }
    }

    @Override // E.c, E.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewH = super.h(context, cursor, viewGroup);
        viewH.setTag(new a(viewH));
        ((ImageView) viewH.findViewById(p012d.f.f9208q)).setImageResource(this.f3481p);
        return viewH;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(c());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f3477l.U((CharSequence) tag);
        }
    }

    Drawable r(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f3479n.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor v(SearchableInfo searchableInfo, String str, int i3) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i3 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i3));
        }
        return this.f3479n.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    public void x(int i3) {
        this.f3483r = i3;
    }
}
