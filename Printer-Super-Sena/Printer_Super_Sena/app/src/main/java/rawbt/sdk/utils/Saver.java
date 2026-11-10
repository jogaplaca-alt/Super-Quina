package rawbt.sdk.utils;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class Saver {
    private final Context mContext;

    public Saver(Context context) {
        this.mContext = context;
    }

    private ContentValues getContentValues(String str) {
        ContentValues contentValues = new ContentValues();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("datetaken", Long.valueOf(jCurrentTimeMillis));
        }
        long j3 = jCurrentTimeMillis / 1000;
        contentValues.put("date_added", Long.valueOf(j3));
        contentValues.put("date_modified", Long.valueOf(j3));
        contentValues.put("mime_type", "image/jpg");
        contentValues.put("_display_name", str);
        return contentValues;
    }

    private void storeBitmapToStream(Bitmap bitmap, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                outputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public String saveToGallery(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            String str = "vrt_prn_" + System.currentTimeMillis() + ".png";
            if (Build.VERSION.SDK_INT >= 29) {
                ContentValues contentValues = getContentValues(str);
                contentValues.put("relative_path", "Pictures/RawBT");
                contentValues.put("is_pending", Boolean.TRUE);
                Uri uriInsert = this.mContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                if (uriInsert == null) {
                    return null;
                }
                storeBitmapToStream(bitmap, this.mContext.getContentResolver().openOutputStream(uriInsert));
                contentValues.put("is_pending", Boolean.FALSE);
                this.mContext.getContentResolver().update(uriInsert, contentValues, null, null);
                return uriInsert.toString();
            }
            java.io.File file = new java.io.File(Environment.getExternalStorageDirectory().toString() + java.io.File.separator + "RawBT");
            if (!file.exists()) {
                file.mkdirs();
            }
            java.io.File file2 = new java.io.File(file, str);
            storeBitmapToStream(bitmap, new FileOutputStream(file2));
            ContentValues contentValues2 = getContentValues(str);
            contentValues2.put("_data", file2.getAbsolutePath());
            this.mContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues2);
            return file2.getAbsolutePath();
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
