package com.theartofdev.edmodo.cropper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f8990A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f8991B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f8992C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public CharSequence f8993D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f8994E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public Uri f8995F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public Bitmap.CompressFormat f8996G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public int f8997H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int f8998I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f8999J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public CropImageView.j f9000K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public boolean f9001L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public Rect f9002M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public int f9003N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public boolean f9004O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f9005P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public boolean f9006Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public int f9007R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public boolean f9008S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public boolean f9009T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public CharSequence f9010U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public int f9011V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CropImageView.c f9012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f9013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f9014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CropImageView.d f9015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CropImageView.k f9016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f9017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f9020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9021j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f9022k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f9023l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9024m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9025n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f9026o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f9027p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f9028q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f9029r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f9030s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f9031t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f9032u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f9033v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f9034w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f9035x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f9036y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f9037z;

    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i3) {
            return new f[i3];
        }
    }

    public f() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        this.f9012a = CropImageView.c.RECTANGLE;
        this.f9013b = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.f9014c = TypedValue.applyDimension(1, 24.0f, displayMetrics);
        this.f9015d = CropImageView.d.ON_TOUCH;
        this.f9016e = CropImageView.k.FIT_CENTER;
        this.f9017f = true;
        this.f9018g = true;
        this.f9019h = true;
        this.f9020i = false;
        this.f9021j = 4;
        this.f9022k = 0.1f;
        this.f9023l = false;
        this.f9024m = 1;
        this.f9025n = 1;
        this.f9026o = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.f9027p = Color.argb(170, 255, 255, 255);
        this.f9028q = TypedValue.applyDimension(1, 2.0f, displayMetrics);
        this.f9029r = TypedValue.applyDimension(1, 5.0f, displayMetrics);
        this.f9030s = TypedValue.applyDimension(1, 14.0f, displayMetrics);
        this.f9031t = -1;
        this.f9032u = TypedValue.applyDimension(1, 1.0f, displayMetrics);
        this.f9033v = Color.argb(170, 255, 255, 255);
        this.f9034w = Color.argb(119, 0, 0, 0);
        this.f9035x = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.f9036y = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.f9037z = 40;
        this.f8990A = 40;
        this.f8991B = 99999;
        this.f8992C = 99999;
        this.f8993D = "";
        this.f8994E = 0;
        this.f8995F = Uri.EMPTY;
        this.f8996G = Bitmap.CompressFormat.JPEG;
        this.f8997H = 90;
        this.f8998I = 0;
        this.f8999J = 0;
        this.f9000K = CropImageView.j.NONE;
        this.f9001L = false;
        this.f9002M = null;
        this.f9003N = -1;
        this.f9004O = true;
        this.f9005P = true;
        this.f9006Q = false;
        this.f9007R = 90;
        this.f9008S = false;
        this.f9009T = false;
        this.f9010U = null;
        this.f9011V = 0;
    }

    public void c() {
        if (this.f9021j < 0) {
            throw new IllegalArgumentException("Cannot set max zoom to a number < 1");
        }
        if (this.f9014c < 0.0f) {
            throw new IllegalArgumentException("Cannot set touch radius value to a number <= 0 ");
        }
        float f3 = this.f9022k;
        if (f3 < 0.0f || f3 >= 0.5d) {
            throw new IllegalArgumentException("Cannot set initial crop window padding value to a number < 0 or >= 0.5");
        }
        if (this.f9024m <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.f9025n <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.f9026o < 0.0f) {
            throw new IllegalArgumentException("Cannot set line thickness value to a number less than 0.");
        }
        if (this.f9028q < 0.0f) {
            throw new IllegalArgumentException("Cannot set corner thickness value to a number less than 0.");
        }
        if (this.f9032u < 0.0f) {
            throw new IllegalArgumentException("Cannot set guidelines thickness value to a number less than 0.");
        }
        if (this.f9036y < 0) {
            throw new IllegalArgumentException("Cannot set min crop window height value to a number < 0 ");
        }
        int i3 = this.f9037z;
        if (i3 < 0) {
            throw new IllegalArgumentException("Cannot set min crop result width value to a number < 0 ");
        }
        int i4 = this.f8990A;
        if (i4 < 0) {
            throw new IllegalArgumentException("Cannot set min crop result height value to a number < 0 ");
        }
        if (this.f8991B < i3) {
            throw new IllegalArgumentException("Cannot set max crop result width to smaller value than min crop result width");
        }
        if (this.f8992C < i4) {
            throw new IllegalArgumentException("Cannot set max crop result height to smaller value than min crop result height");
        }
        if (this.f8998I < 0) {
            throw new IllegalArgumentException("Cannot set request width value to a number < 0 ");
        }
        if (this.f8999J < 0) {
            throw new IllegalArgumentException("Cannot set request height value to a number < 0 ");
        }
        int i5 = this.f9007R;
        if (i5 < 0 || i5 > 360) {
            throw new IllegalArgumentException("Cannot set rotation degrees value to a number < 0 or > 360");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f9012a.ordinal());
        parcel.writeFloat(this.f9013b);
        parcel.writeFloat(this.f9014c);
        parcel.writeInt(this.f9015d.ordinal());
        parcel.writeInt(this.f9016e.ordinal());
        parcel.writeByte(this.f9017f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9018g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9019h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9020i ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f9021j);
        parcel.writeFloat(this.f9022k);
        parcel.writeByte(this.f9023l ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f9024m);
        parcel.writeInt(this.f9025n);
        parcel.writeFloat(this.f9026o);
        parcel.writeInt(this.f9027p);
        parcel.writeFloat(this.f9028q);
        parcel.writeFloat(this.f9029r);
        parcel.writeFloat(this.f9030s);
        parcel.writeInt(this.f9031t);
        parcel.writeFloat(this.f9032u);
        parcel.writeInt(this.f9033v);
        parcel.writeInt(this.f9034w);
        parcel.writeInt(this.f9035x);
        parcel.writeInt(this.f9036y);
        parcel.writeInt(this.f9037z);
        parcel.writeInt(this.f8990A);
        parcel.writeInt(this.f8991B);
        parcel.writeInt(this.f8992C);
        TextUtils.writeToParcel(this.f8993D, parcel, i3);
        parcel.writeInt(this.f8994E);
        parcel.writeParcelable(this.f8995F, i3);
        parcel.writeString(this.f8996G.name());
        parcel.writeInt(this.f8997H);
        parcel.writeInt(this.f8998I);
        parcel.writeInt(this.f8999J);
        parcel.writeInt(this.f9000K.ordinal());
        parcel.writeInt(this.f9001L ? 1 : 0);
        parcel.writeParcelable(this.f9002M, i3);
        parcel.writeInt(this.f9003N);
        parcel.writeByte(this.f9004O ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9005P ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9006Q ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f9007R);
        parcel.writeByte(this.f9008S ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9009T ? (byte) 1 : (byte) 0);
        TextUtils.writeToParcel(this.f9010U, parcel, i3);
        parcel.writeInt(this.f9011V);
    }

    protected f(Parcel parcel) {
        this.f9012a = CropImageView.c.values()[parcel.readInt()];
        this.f9013b = parcel.readFloat();
        this.f9014c = parcel.readFloat();
        this.f9015d = CropImageView.d.values()[parcel.readInt()];
        this.f9016e = CropImageView.k.values()[parcel.readInt()];
        this.f9017f = parcel.readByte() != 0;
        this.f9018g = parcel.readByte() != 0;
        this.f9019h = parcel.readByte() != 0;
        this.f9020i = parcel.readByte() != 0;
        this.f9021j = parcel.readInt();
        this.f9022k = parcel.readFloat();
        this.f9023l = parcel.readByte() != 0;
        this.f9024m = parcel.readInt();
        this.f9025n = parcel.readInt();
        this.f9026o = parcel.readFloat();
        this.f9027p = parcel.readInt();
        this.f9028q = parcel.readFloat();
        this.f9029r = parcel.readFloat();
        this.f9030s = parcel.readFloat();
        this.f9031t = parcel.readInt();
        this.f9032u = parcel.readFloat();
        this.f9033v = parcel.readInt();
        this.f9034w = parcel.readInt();
        this.f9035x = parcel.readInt();
        this.f9036y = parcel.readInt();
        this.f9037z = parcel.readInt();
        this.f8990A = parcel.readInt();
        this.f8991B = parcel.readInt();
        this.f8992C = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f8993D = (CharSequence) creator.createFromParcel(parcel);
        this.f8994E = parcel.readInt();
        this.f8995F = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f8996G = Bitmap.CompressFormat.valueOf(parcel.readString());
        this.f8997H = parcel.readInt();
        this.f8998I = parcel.readInt();
        this.f8999J = parcel.readInt();
        this.f9000K = CropImageView.j.values()[parcel.readInt()];
        this.f9001L = parcel.readByte() != 0;
        this.f9002M = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.f9003N = parcel.readInt();
        this.f9004O = parcel.readByte() != 0;
        this.f9005P = parcel.readByte() != 0;
        this.f9006Q = parcel.readByte() != 0;
        this.f9007R = parcel.readInt();
        this.f9008S = parcel.readByte() != 0;
        this.f9009T = parcel.readByte() != 0;
        this.f9010U = (CharSequence) creator.createFromParcel(parcel);
        this.f9011V = parcel.readInt();
    }
}
