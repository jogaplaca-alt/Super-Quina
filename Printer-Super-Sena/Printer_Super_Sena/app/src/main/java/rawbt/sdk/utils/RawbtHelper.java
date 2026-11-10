package rawbt.sdk.utils;

import android.content.Context;
import android.net.Uri;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;
import rawbt.api.command.CommandParcelable;
import rawbt.api.command.RawbtCommand;
import rawbt.sdk.RawbtPrintJob;

/* JADX INFO: loaded from: classes.dex */
public class RawbtHelper {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bArr, int i3) {
        char[] cArr = new char[i3 * 2];
        for (int i4 = 0; i4 < i3; i4++) {
            byte b3 = bArr[i4];
            int i5 = i4 * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i5] = cArr2[(b3 & 255) >>> 4];
            cArr[i5 + 1] = cArr2[b3 & 15];
        }
        return new String(cArr);
    }

    public static String bytesToHexFormatted(byte[] bArr, int i3) {
        char[] cArr = new char[i3 * 3];
        for (int i4 = 0; i4 < i3; i4++) {
            byte b3 = bArr[i4];
            int i5 = i4 * 3;
            char[] cArr2 = HEX_ARRAY;
            cArr[i5] = cArr2[(b3 & 255) >>> 4];
            cArr[i5 + 1] = cArr2[b3 & 15];
            cArr[i5 + 2] = ' ';
        }
        return new String(cArr);
    }

    public static String bytesToHexWithAscii(byte[] bArr, int i3) {
        char[] cArr = new char[38];
        Arrays.fill(cArr, ' ');
        cArr[24] = '|';
        for (int i4 = 0; i4 < i3; i4++) {
            byte b3 = bArr[i4];
            int i5 = b3 & 255;
            int i6 = i4 * 3;
            char[] cArr2 = HEX_ARRAY;
            cArr[i6] = cArr2[i5 >>> 4];
            cArr[i6 + 1] = cArr2[b3 & 15];
            if (i5 > 31 && i5 < 127) {
                cArr[i4 + 25] = (char) b3;
            } else if (i5 == 27) {
                cArr[i4 + 25] = 8592;
            } else if (i5 == 28) {
                cArr[i4 + 25] = 8735;
            } else if (i5 == 29) {
                cArr[i4 + 25] = 8596;
            } else {
                cArr[i4 + 25] = '.';
            }
        }
        return new String(cArr);
    }

    public static byte[] getBytes(String str) {
        return getBytesWithCp(str, "UTF-8");
    }

    public static byte[] getBytesWithCp(String str, String str2) {
        ArrayList<byte[]> arrayList = new ArrayList();
        for (String str3 : str.split(";")) {
            String strTrim = str3.trim();
            if ("ESC".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{27});
            } else if ("SCH".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{1});
            } else if ("STX".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{2});
            } else if ("ETX".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{3});
            } else if ("EOT".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{4});
            } else if ("ENQ".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{5});
            } else if ("ACK".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{6});
            } else if ("BEL".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{7});
            } else if ("BS".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{8});
            } else if ("HT".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{9});
            } else if ("LF".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{10});
            } else if ("VT".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{11});
            } else if ("CR".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{13});
            } else if ("SO".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{14});
            } else if ("SI".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{15});
            } else if ("DLE".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{16});
            } else if ("DC1".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{17});
            } else if ("DC2".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{18});
            } else if ("DC3".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{19});
            } else if ("DC4".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{20});
            } else if ("NAK".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{21});
            } else if ("SYN".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{22});
            } else if ("ETB".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{23});
            } else if ("CAN".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{24});
            } else if ("EM".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{25});
            } else if ("SUB".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{26});
            } else if ("FS".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{28});
            } else if ("GS".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{29});
            } else if ("RS".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{30});
            } else if ("US".equalsIgnoreCase(strTrim)) {
                arrayList.add(new byte[]{31});
            } else if (strTrim.length() == 2 && pregMatch("|^[0-9A-Fa-f]{2}$|", strTrim)) {
                arrayList.add(new byte[]{(byte) (((byte) (((byte) Character.digit(strTrim.charAt(0), 16)) << 4)) + ((byte) Character.digit(strTrim.charAt(1), 16)))});
            } else {
                try {
                    arrayList.add(strTrim.getBytes(str2));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        Iterator it = arrayList.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += ((byte[]) it.next()).length;
        }
        byte[] bArr = new byte[length];
        int i3 = 0;
        for (byte[] bArr2 : arrayList) {
            for (byte b3 : bArr2) {
                bArr[i3] = b3;
                i3++;
            }
        }
        return bArr;
    }

    private static boolean pregMatch(String str, String str2) {
        return Pattern.compile(str).matcher(str2).matches();
    }

    public static RawbtPrintJob prepareJob(RawbtPrintJob rawbtPrintJob, Context context) throws IOException {
        ArrayList<RawbtCommand> commands = rawbtPrintJob.getCommands();
        for (RawbtCommand rawbtCommand : commands) {
            if (rawbtCommand instanceof CommandParcelable) {
                CommandParcelable commandParcelable = (CommandParcelable) rawbtCommand;
                Uri uriCacheUri = File.cacheUri(Uri.parse(commandParcelable.getParcelable()), context);
                if (uriCacheUri == null) {
                    return null;
                }
                commandParcelable.setParcelable(uriCacheUri.toString());
            }
        }
        rawbtPrintJob.setCommands(commands);
        return rawbtPrintJob;
    }
}
