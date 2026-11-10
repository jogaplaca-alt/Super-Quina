package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f4454k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f4456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f4457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f4458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f4461g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f4462h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4463i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f4464j;

    static class a {
        static int a(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e3) {
                Log.e("IconCompat", "Unable to get icon resource", e3);
                return 0;
            } catch (NoSuchMethodException e4) {
                Log.e("IconCompat", "Unable to get icon resource", e4);
                return 0;
            } catch (InvocationTargetException e5) {
                Log.e("IconCompat", "Unable to get icon resource", e5);
                return 0;
            }
        }

        static String b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
            } catch (IllegalAccessException e3) {
                Log.e("IconCompat", "Unable to get icon package", e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.e("IconCompat", "Unable to get icon package", e4);
                return null;
            } catch (InvocationTargetException e5) {
                Log.e("IconCompat", "Unable to get icon package", e5);
                return null;
            }
        }

        static int c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e3) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e3);
                return -1;
            } catch (NoSuchMethodException e4) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e4);
                return -1;
            } catch (InvocationTargetException e5) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e5);
                return -1;
            }
        }

        static Uri d(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
            } catch (IllegalAccessException e3) {
                Log.e("IconCompat", "Unable to get icon uri", e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.e("IconCompat", "Unable to get icon uri", e4);
                return null;
            } catch (InvocationTargetException e5) {
                Log.e("IconCompat", "Unable to get icon uri", e5);
                return null;
            }
        }

        static Drawable e(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        static Icon f(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f4455a) {
                case -1:
                    return (Icon) iconCompat.f4456b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f4456b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.e(), iconCompat.f4459e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f4456b, iconCompat.f4459e, iconCompat.f4460f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f4456b);
                    break;
                case 5:
                    iconCreateWithBitmap = Build.VERSION.SDK_INT < 26 ? Icon.createWithBitmap(IconCompat.a((Bitmap) iconCompat.f4456b, false)) : b.b((Bitmap) iconCompat.f4456b);
                    break;
                case 6:
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 >= 30) {
                        iconCreateWithBitmap = d.a(iconCompat.g());
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.g());
                        }
                        InputStream inputStreamH = iconCompat.h(context);
                        if (inputStreamH == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.g());
                        }
                        if (i3 < 26) {
                            iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.a(BitmapFactory.decodeStream(inputStreamH), false));
                        } else {
                            iconCreateWithBitmap = b.b(BitmapFactory.decodeStream(inputStreamH));
                        }
                    }
                    break;
            }
            ColorStateList colorStateList = iconCompat.f4461g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f4462h;
            if (mode != IconCompat.f4454k) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    static class b {
        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    static class c {
        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    static class d {
        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f4455a = -1;
        this.f4457c = null;
        this.f4458d = null;
        this.f4459e = 0;
        this.f4460f = 0;
        this.f4461g = null;
        this.f4462h = f4454k;
        this.f4463i = null;
    }

    static Bitmap a(Bitmap bitmap, boolean z3) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f3 = iMin;
        float f4 = 0.5f * f3;
        float f5 = 0.9166667f * f4;
        if (z3) {
            float f6 = 0.010416667f * f3;
            paint.setColor(0);
            paint.setShadowLayer(f6, 0.0f, f3 * 0.020833334f, 1023410176);
            canvas.drawCircle(f4, f4, f5, paint);
            paint.setShadowLayer(f6, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f4, f4, f5, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f4, f4, f5, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat b(Resources resources, String str, int i3) {
        p082z.c.c(str);
        if (i3 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f4459e = i3;
        if (resources != null) {
            try {
                iconCompat.f4456b = resources.getResourceName(i3);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f4456b = str;
        }
        iconCompat.f4464j = str;
        return iconCompat;
    }

    private static String m(int i3) {
        switch (i3) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap c() {
        int i3 = this.f4455a;
        if (i3 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f4456b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i3 == 1) {
            return (Bitmap) this.f4456b;
        }
        if (i3 == 5) {
            return a((Bitmap) this.f4456b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int d() {
        int i3 = this.f4455a;
        if (i3 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.a(this.f4456b);
        }
        if (i3 == 2) {
            return this.f4459e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String e() {
        int i3 = this.f4455a;
        if (i3 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.b(this.f4456b);
        }
        if (i3 == 2) {
            String str = this.f4464j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f4456b).split(":", -1)[0] : this.f4464j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int f() {
        int i3 = this.f4455a;
        return (i3 != -1 || Build.VERSION.SDK_INT < 23) ? i3 : a.c(this.f4456b);
    }

    public Uri g() {
        int i3 = this.f4455a;
        if (i3 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.d(this.f4456b);
        }
        if (i3 == 4 || i3 == 6) {
            return Uri.parse((String) this.f4456b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream h(Context context) {
        Uri uriG = g();
        String scheme = uriG.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriG);
            } catch (Exception e3) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriG, e3);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f4456b));
        } catch (FileNotFoundException e4) {
            Log.w("IconCompat", "Unable to load image from path: " + uriG, e4);
            return null;
        }
    }

    public void i() {
        this.f4462h = PorterDuff.Mode.valueOf(this.f4463i);
        switch (this.f4455a) {
            case -1:
                Parcelable parcelable = this.f4458d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f4456b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f4458d;
                if (parcelable2 != null) {
                    this.f4456b = parcelable2;
                    return;
                }
                byte[] bArr = this.f4457c;
                this.f4456b = bArr;
                this.f4455a = 3;
                this.f4459e = 0;
                this.f4460f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f4457c, Charset.forName("UTF-16"));
                this.f4456b = str;
                if (this.f4455a == 2 && this.f4464j == null) {
                    this.f4464j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f4456b = this.f4457c;
                return;
        }
    }

    public void j(boolean z3) {
        this.f4463i = this.f4462h.name();
        switch (this.f4455a) {
            case -1:
                if (z3) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f4458d = (Parcelable) this.f4456b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z3) {
                    this.f4458d = (Parcelable) this.f4456b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f4456b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f4457c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f4457c = ((String) this.f4456b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f4457c = (byte[]) this.f4456b;
                return;
            case 4:
            case 6:
                this.f4457c = this.f4456b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public Icon k() {
        return l(null);
    }

    public Icon l(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.f(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public String toString() {
        if (this.f4455a == -1) {
            return String.valueOf(this.f4456b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(m(this.f4455a));
        switch (this.f4455a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f4456b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f4456b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f4464j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(d())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f4459e);
                if (this.f4460f != 0) {
                    sb.append(" off=");
                    sb.append(this.f4460f);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f4456b);
                break;
        }
        if (this.f4461g != null) {
            sb.append(" tint=");
            sb.append(this.f4461g);
        }
        if (this.f4462h != f4454k) {
            sb.append(" mode=");
            sb.append(this.f4462h);
        }
        sb.append(")");
        return sb.toString();
    }

    IconCompat(int i3) {
        this.f4457c = null;
        this.f4458d = null;
        this.f4459e = 0;
        this.f4460f = 0;
        this.f4461g = null;
        this.f4462h = f4454k;
        this.f4463i = null;
        this.f4455a = i3;
    }
}
