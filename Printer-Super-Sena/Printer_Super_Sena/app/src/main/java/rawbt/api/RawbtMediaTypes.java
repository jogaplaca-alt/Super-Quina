package rawbt.api;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import rawbt.api.command.CommandImageInBase64;

/* JADX INFO: loaded from: classes.dex */
public class RawbtMediaTypes {
    public static Constant.RAWBT_CONTENT_TYPE detectContentType(Context context, Uri uri, String str) {
        if (uri == null) {
            return Constant.RAWBT_CONTENT_TYPE.unsupported;
        }
        String fileMimeType = getFileMimeType(context, uri);
        if (fileMimeType != null) {
            str = fileMimeType;
        } else if (str == null) {
            return Constant.RAWBT_CONTENT_TYPE.unsupported;
        }
        if (str.equals("application/pdf")) {
            return Constant.RAWBT_CONTENT_TYPE.pdf;
        }
        if (str.startsWith("video") || str.startsWith("audio") || str.startsWith("model") || str.startsWith("multipart")) {
            return Constant.RAWBT_CONTENT_TYPE.unsupported;
        }
        if (str.startsWith(CommandImageInBase64.TAG)) {
            return Constant.RAWBT_CONTENT_TYPE.image;
        }
        if (str.equals("text/html")) {
            return Constant.RAWBT_CONTENT_TYPE.html;
        }
        return str.equals("text/prn") ? Constant.RAWBT_CONTENT_TYPE.prn : Constant.RAWBT_CONTENT_TYPE.txt;
    }

    public static String getFileMimeType(Context context, Uri uri) {
        Cursor cursorQuery;
        try {
            String lowerCase = uri.toString().toLowerCase();
            if ("content".equalsIgnoreCase(uri.getScheme()) && (cursorQuery = context.getContentResolver().query(uri, null, null, null, null)) != null) {
                int columnIndex = cursorQuery.getColumnIndex("mime_type");
                cursorQuery.moveToFirst();
                if (columnIndex > -1) {
                    try {
                        String string = cursorQuery.getString(columnIndex);
                        if (!"application/octet-stream".equals(string)) {
                            cursorQuery.close();
                            return string;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    e.printStackTrace();
                    return null;
                }
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_display_name");
                cursorQuery.moveToFirst();
                try {
                    lowerCase = cursorQuery.getString(columnIndexOrThrow);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                cursorQuery.close();
            }
            if (!lowerCase.endsWith(".jpg") && !lowerCase.endsWith(".jpeg") && !lowerCase.endsWith(".png") && !lowerCase.endsWith(".webp") && !lowerCase.endsWith(".gif") && !lowerCase.endsWith(".bmp")) {
                if (lowerCase.endsWith(".pdf")) {
                    return "application/pdf";
                }
                if (lowerCase.endsWith(".txt")) {
                    return "text/plain";
                }
                if (lowerCase.endsWith(".prn")) {
                    return "text/prn";
                }
                if (lowerCase.endsWith(".htm") || lowerCase.endsWith(".html")) {
                    return "text/html";
                }
                return null;
            }
            return "image/*";
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
