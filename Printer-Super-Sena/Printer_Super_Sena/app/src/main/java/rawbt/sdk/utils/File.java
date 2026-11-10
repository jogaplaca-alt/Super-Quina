package rawbt.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import rawbt.api.RawbtMediaTypes;
import rawbt.api.RawbtPrintJob;
import rawbt.api.command.CommandParcelable;
import rawbt.api.command.RawbtCommand;
import rawbt.sdk.R;

/* JADX INFO: loaded from: classes.dex */
public class File {
    public static Uri cacheUri(Uri uri, Context context) throws IOException {
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        if (inputStreamOpenInputStream == null) {
            return null;
        }
        java.io.File fileCreateTempFile = java.io.File.createTempFile("spool_job_", "", context.getCacheDir());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStreamOpenInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileCreateTempFile));
        byte[] bArr = new byte[8192];
        while (true) {
            int i3 = bufferedInputStream.read(bArr);
            if (i3 < 0) {
                bufferedInputStream.close();
                bufferedOutputStream.close();
                return Uri.fromFile(fileCreateTempFile);
            }
            bufferedOutputStream.write(bArr, 0, i3);
        }
    }

    public static void deleteTempFiles(RawbtPrintJob rawbtPrintJob) {
        for (RawbtCommand rawbtCommand : rawbtPrintJob.getCommands()) {
            try {
                if (rawbtCommand instanceof CommandParcelable) {
                    String parcelable = ((CommandParcelable) rawbtCommand).getParcelable();
                    if (parcelable.contains("spool_job_") || parcelable.contains("rawbt_temp_")) {
                        String path = Uri.parse(parcelable).getPath();
                        Objects.requireNonNull(path);
                        new java.io.File(path).delete();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static String getFileExtension(Uri uri, String str, Context context) {
        String lowerCase = uri.toString().toLowerCase();
        if (lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".png") || lowerCase.endsWith(".webp") || lowerCase.endsWith(".gif") || lowerCase.endsWith(".bmp")) {
            return "jpg";
        }
        if (lowerCase.endsWith(".pdf")) {
            return "pdf";
        }
        if (lowerCase.endsWith(".txt")) {
            return "txt";
        }
        if (lowerCase.endsWith(".prn")) {
            return "prn";
        }
        if (lowerCase.endsWith(".htm") || lowerCase.endsWith(".html")) {
            return "htm";
        }
        String fileMimeType = RawbtMediaTypes.getFileMimeType(context, uri);
        if (fileMimeType != null) {
            str = fileMimeType;
        }
        if (str == null) {
            return "txt";
        }
        if (str.startsWith("image/")) {
            return "png";
        }
        if (str.equals("application/pdf")) {
            return "pdf";
        }
        return str.equals("text/html") ? "htm" : "txt";
    }

    public static String getFileName(String str) {
        if (str == null) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf("/");
        return iLastIndexOf != -1 ? str.substring(iLastIndexOf + 1) : str;
    }

    public static String getFilePath(Uri uri, Context context) {
        String path;
        int iLastIndexOf;
        String string;
        if (uri == null) {
            return "";
        }
        try {
            if (!"content".equalsIgnoreCase(uri.getScheme())) {
                return (!"file".equalsIgnoreCase(uri.getScheme()) || (path = uri.getPath()) == null || (iLastIndexOf = path.lastIndexOf("/")) == -1) ? "" : path.substring(iLastIndexOf + 1);
            }
            String[] strArr = {"_display_name"};
            try {
                Objects.requireNonNull(context);
                Cursor cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
                Objects.requireNonNull(cursorQuery);
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_display_name");
                if (!cursorQuery.moveToFirst() || (string = cursorQuery.getString(columnIndexOrThrow)) == null) {
                    return "";
                }
                String fileExtension = getFileExtension(uri, "", context);
                if (!string.endsWith(fileExtension)) {
                    string = string + "." + fileExtension;
                }
                cursorQuery.close();
                return string;
            } catch (Exception e3) {
                e3.printStackTrace();
                return "";
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return "";
    }

    public static byte[] readBinary(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = inputStream.read();
            while (i3 != -1) {
                byteArrayOutputStream.write(i3);
                i3 = inputStream.read();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            return new byte[]{32};
        }
    }

    public static String readTxtFile(InputStream inputStream, int i3, Context context) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                    long length = 0;
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                bufferedReader2.close();
                                break;
                            }
                            length += (long) line.length();
                            if (length > i3) {
                                String str = context.getString(R.string.ErrorOverFileSize) + "\n\n";
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                                return str;
                            }
                            sb.append(line);
                            sb.append("\n");
                        } catch (Exception e4) {
                            e = e4;
                            bufferedReader = bufferedReader2;
                            if (e.getLocalizedMessage() != null) {
                                sb.append("\nERROR\n");
                                sb.append(e.getLocalizedMessage());
                                sb.append("\n");
                            }
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                }
                return sb.toString();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e7) {
            e7.printStackTrace();
        }
    }
}
