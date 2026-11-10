package rawbt.api.command;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import rawbt.api.attributes.AttributesImage;

/* JADX INFO: loaded from: classes.dex */
public class CommandImageInBase64 implements RawbtCommand {
    public static final String TAG = "image";
    AttributesImage attributesImage;
    String base64;
    String command;

    public CommandImageInBase64() {
        this.command = TAG;
        this.base64 = null;
        this.attributesImage = null;
    }

    private String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    private Bitmap getBitmapFromURL(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
            return bitmapDecodeStream;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private String getImageBase64String(Uri uri, Context context) {
        Bitmap bitmapFromURL;
        if ("https".equals(uri.getScheme()) || "http".equals(uri.getScheme())) {
            bitmapFromURL = getBitmapFromURL(uri.toString());
        } else {
            try {
                bitmapFromURL = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
            } catch (IOException unused) {
                return null;
            }
        }
        if (bitmapFromURL == null) {
            return null;
        }
        return bitmapToBase64(bitmapFromURL);
    }

    public AttributesImage getAttributesImage() {
        return this.attributesImage;
    }

    public String getBase64() {
        return this.base64;
    }

    public void setAttributesImage(AttributesImage attributesImage) {
        this.attributesImage = attributesImage;
    }

    public void setBase64(String str) {
        this.base64 = str;
    }

    public CommandImageInBase64(String str, AttributesImage attributesImage) {
        this.command = TAG;
        this.base64 = str;
        this.attributesImage = attributesImage;
    }

    public CommandImageInBase64(Context context, Uri uri, AttributesImage attributesImage) {
        this.command = TAG;
        this.base64 = null;
        this.attributesImage = null;
        this.base64 = getImageBase64String(uri, context);
        this.attributesImage = attributesImage;
    }
}
