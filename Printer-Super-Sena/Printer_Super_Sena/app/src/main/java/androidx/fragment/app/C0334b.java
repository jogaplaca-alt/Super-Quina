package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.AbstractC0354l;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.fragment.app.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0334b implements Parcelable {
    public static final Parcelable.Creator<C0334b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int[] f5079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList f5080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int[] f5081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int[] f5082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f5083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String f5084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f5085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f5086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final CharSequence f5087i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final int f5088j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final CharSequence f5089k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final ArrayList f5090l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final ArrayList f5091m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final boolean f5092n;

    /* JADX INFO: renamed from: androidx.fragment.app.b$a */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0334b createFromParcel(Parcel parcel) {
            return new C0334b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0334b[] newArray(int i3) {
            return new C0334b[i3];
        }
    }

    public C0334b(C0333a c0333a) {
        int size = c0333a.f5391c.size();
        this.f5079a = new int[size * 5];
        if (!c0333a.f5397i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f5080b = new ArrayList(size);
        this.f5081c = new int[size];
        this.f5082d = new int[size];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            w.a aVar = (w.a) c0333a.f5391c.get(i4);
            int i5 = i3 + 1;
            this.f5079a[i3] = aVar.f5408a;
            ArrayList arrayList = this.f5080b;
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = aVar.f5409b;
            arrayList.add(abstractComponentCallbacksC0337e != null ? abstractComponentCallbacksC0337e.f5189f : null);
            int[] iArr = this.f5079a;
            iArr[i5] = aVar.f5410c;
            iArr[i3 + 2] = aVar.f5411d;
            int i6 = i3 + 4;
            iArr[i3 + 3] = aVar.f5412e;
            i3 += 5;
            iArr[i6] = aVar.f5413f;
            this.f5081c[i4] = aVar.f5414g.ordinal();
            this.f5082d[i4] = aVar.f5415h.ordinal();
        }
        this.f5083e = c0333a.f5396h;
        this.f5084f = c0333a.f5399k;
        this.f5085g = c0333a.f5078v;
        this.f5086h = c0333a.f5400l;
        this.f5087i = c0333a.f5401m;
        this.f5088j = c0333a.f5402n;
        this.f5089k = c0333a.f5403o;
        this.f5090l = c0333a.f5404p;
        this.f5091m = c0333a.f5405q;
        this.f5092n = c0333a.f5406r;
    }

    public C0333a c(o oVar) {
        C0333a c0333a = new C0333a(oVar);
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.f5079a.length) {
            w.a aVar = new w.a();
            int i5 = i3 + 1;
            aVar.f5408a = this.f5079a[i3];
            if (o.C0(2)) {
                Log.v("FragmentManager", "Instantiate " + c0333a + " op #" + i4 + " base fragment #" + this.f5079a[i5]);
            }
            String str = (String) this.f5080b.get(i4);
            if (str != null) {
                aVar.f5409b = oVar.c0(str);
            } else {
                aVar.f5409b = null;
            }
            aVar.f5414g = AbstractC0354l.b.values()[this.f5081c[i4]];
            aVar.f5415h = AbstractC0354l.b.values()[this.f5082d[i4]];
            int[] iArr = this.f5079a;
            int i6 = iArr[i5];
            aVar.f5410c = i6;
            int i7 = iArr[i3 + 2];
            aVar.f5411d = i7;
            int i8 = i3 + 4;
            int i9 = iArr[i3 + 3];
            aVar.f5412e = i9;
            i3 += 5;
            int i10 = iArr[i8];
            aVar.f5413f = i10;
            c0333a.f5392d = i6;
            c0333a.f5393e = i7;
            c0333a.f5394f = i9;
            c0333a.f5395g = i10;
            c0333a.e(aVar);
            i4++;
        }
        c0333a.f5396h = this.f5083e;
        c0333a.f5399k = this.f5084f;
        c0333a.f5078v = this.f5085g;
        c0333a.f5397i = true;
        c0333a.f5400l = this.f5086h;
        c0333a.f5401m = this.f5087i;
        c0333a.f5402n = this.f5088j;
        c0333a.f5403o = this.f5089k;
        c0333a.f5404p = this.f5090l;
        c0333a.f5405q = this.f5091m;
        c0333a.f5406r = this.f5092n;
        c0333a.r(1);
        return c0333a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeIntArray(this.f5079a);
        parcel.writeStringList(this.f5080b);
        parcel.writeIntArray(this.f5081c);
        parcel.writeIntArray(this.f5082d);
        parcel.writeInt(this.f5083e);
        parcel.writeString(this.f5084f);
        parcel.writeInt(this.f5085g);
        parcel.writeInt(this.f5086h);
        TextUtils.writeToParcel(this.f5087i, parcel, 0);
        parcel.writeInt(this.f5088j);
        TextUtils.writeToParcel(this.f5089k, parcel, 0);
        parcel.writeStringList(this.f5090l);
        parcel.writeStringList(this.f5091m);
        parcel.writeInt(this.f5092n ? 1 : 0);
    }

    public C0334b(Parcel parcel) {
        this.f5079a = parcel.createIntArray();
        this.f5080b = parcel.createStringArrayList();
        this.f5081c = parcel.createIntArray();
        this.f5082d = parcel.createIntArray();
        this.f5083e = parcel.readInt();
        this.f5084f = parcel.readString();
        this.f5085g = parcel.readInt();
        this.f5086h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f5087i = (CharSequence) creator.createFromParcel(parcel);
        this.f5088j = parcel.readInt();
        this.f5089k = (CharSequence) creator.createFromParcel(parcel);
        this.f5090l = parcel.createStringArrayList();
        this.f5091m = parcel.createStringArrayList();
        this.f5092n = parcel.readInt() != 0;
    }
}
