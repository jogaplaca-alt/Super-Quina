package p004b;

import S1.g;
import S1.k;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntentSender f6922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Intent f6923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f6925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f6921e = new c(null);
    public static final Parcelable.Creator<f> CREATOR = new b();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IntentSender f6926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Intent f6927b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f6928c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f6929d;

        public a(IntentSender intentSender) {
            k.e(intentSender, "intentSender");
            this.f6926a = intentSender;
        }

        public final f a() {
            return new f(this.f6926a, this.f6927b, this.f6928c, this.f6929d);
        }

        public final a b(Intent intent) {
            this.f6927b = intent;
            return this;
        }

        public final a c(int i3, int i4) {
            this.f6929d = i3;
            this.f6928c = i4;
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(PendingIntent pendingIntent) {
            k.e(pendingIntent, "pendingIntent");
            IntentSender intentSender = pendingIntent.getIntentSender();
            k.d(intentSender, "pendingIntent.intentSender");
            this(intentSender);
        }
    }

    public static final class b implements Parcelable.Creator {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            k.e(parcel, "inParcel");
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i3) {
            return new f[i3];
        }
    }

    public static final class c {
        public /* synthetic */ c(g gVar) {
            this();
        }

        private c() {
        }
    }

    public f(IntentSender intentSender, Intent intent, int i3, int i4) {
        k.e(intentSender, "intentSender");
        this.f6922a = intentSender;
        this.f6923b = intent;
        this.f6924c = i3;
        this.f6925d = i4;
    }

    public final Intent c() {
        return this.f6923b;
    }

    public final int d() {
        return this.f6924c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f6925d;
    }

    public final IntentSender f() {
        return this.f6922a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        k.e(parcel, "dest");
        parcel.writeParcelable(this.f6922a, i3);
        parcel.writeParcelable(this.f6923b, i3);
        parcel.writeInt(this.f6924c);
        parcel.writeInt(this.f6925d);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f(Parcel parcel) {
        k.e(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        k.b(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
