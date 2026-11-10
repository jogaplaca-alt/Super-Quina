package A1;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TimeZone f64a = TimeZone.getTimeZone("UTC");

    private static boolean a(String str, int i3, char c3) {
        return i3 < str.length() && str.charAt(i3) == c3;
    }

    private static int b(String str, int i3) {
        while (i3 < str.length()) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < '0' || cCharAt > '9') {
                return i3;
            }
            i3++;
        }
        return str.length();
    }

    /* JADX WARN: Code duplicated, block: B:85:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:86:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:89:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:91:0x01f5  */
    /* JADX WARN: Instruction removed from duplicated block: B:86:0x01d5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:91:0x01f5, please report this as an issue */
    public static Date c(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        String message;
        int i3;
        int i4;
        int i5;
        int iD;
        int length;
        TimeZone timeZone;
        char cCharAt;
        try {
            int index = parsePosition.getIndex();
            int i6 = index + 4;
            int iD2 = d(str, index, i6);
            if (a(str, i6, '-')) {
                i6 = index + 5;
            }
            int i7 = i6 + 2;
            int iD3 = d(str, i6, i7);
            if (a(str, i7, '-')) {
                i7 = i6 + 3;
            }
            int i8 = i7 + 2;
            int iD4 = d(str, i7, i8);
            boolean zA = a(str, i8, 'T');
            if (!zA && str.length() <= i8) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(iD2, iD3 - 1, iD4);
                gregorianCalendar.setLenient(false);
                parsePosition.setIndex(i8);
                return gregorianCalendar.getTime();
            }
            if (zA) {
                int i9 = i7 + 5;
                int iD5 = d(str, i7 + 3, i9);
                if (a(str, i9, ':')) {
                    i9 = i7 + 6;
                }
                int i10 = i9 + 2;
                int iD6 = d(str, i9, i10);
                if (a(str, i10, ':')) {
                    i10 = i9 + 3;
                }
                if (str.length() <= i10 || (cCharAt = str.charAt(i10)) == 'Z' || cCharAt == '+' || cCharAt == '-') {
                    i4 = iD6;
                    i5 = 0;
                    iD = 0;
                    i8 = i10;
                    i3 = iD5;
                } else {
                    int i11 = i10 + 2;
                    iD = d(str, i10, i11);
                    if (iD > 59 && iD < 63) {
                        iD = 59;
                    }
                    if (a(str, i11, '.')) {
                        int i12 = i10 + 3;
                        int iB = b(str, i10 + 4);
                        int iMin = Math.min(iB, i10 + 6);
                        int iD7 = d(str, i12, iMin);
                        int i13 = iMin - i12;
                        if (i13 == 1) {
                            iD7 *= 100;
                        } else if (i13 == 2) {
                            iD7 *= 10;
                        }
                        i3 = iD5;
                        i8 = iB;
                        i4 = iD6;
                        i5 = iD7;
                    } else {
                        i3 = iD5;
                        i8 = i11;
                        i4 = iD6;
                        i5 = 0;
                    }
                }
            } else {
                i3 = 0;
                i4 = 0;
                i5 = 0;
                iD = 0;
            }
            if (str.length() <= i8) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char cCharAt2 = str.charAt(i8);
            if (cCharAt2 == 'Z') {
                timeZone = f64a;
                length = i8 + 1;
            } else {
                if (cCharAt2 != '+' && cCharAt2 != '-') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt2 + "'");
                }
                String strSubstring = str.substring(i8);
                if (strSubstring.length() < 5) {
                    strSubstring = strSubstring + "00";
                }
                length = i8 + strSubstring.length();
                if ("+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                    timeZone = f64a;
                } else {
                    String str3 = "GMT" + strSubstring;
                    TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                    String id = timeZone2.getID();
                    if (!id.equals(str3) && !id.replace(":", "").equals(str3)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                    }
                    timeZone = timeZone2;
                }
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
            gregorianCalendar2.setLenient(false);
            gregorianCalendar2.set(1, iD2);
            gregorianCalendar2.set(2, iD3 - 1);
            gregorianCalendar2.set(5, iD4);
            gregorianCalendar2.set(11, i3);
            gregorianCalendar2.set(12, i4);
            gregorianCalendar2.set(13, iD);
            gregorianCalendar2.set(14, i5);
            parsePosition.setIndex(length);
            return gregorianCalendar2.getTime();
        } catch (IndexOutOfBoundsException e3) {
            e = e3;
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + '\"';
            }
            message = e.getMessage();
            if (message != null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        } catch (NumberFormatException e4) {
            e = e4;
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + '\"';
            }
            message = e.getMessage();
            if (message != null) {
                message = "(" + e.getClass().getName() + ")";
            } else {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException2 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException2.initCause(e);
            throw parseException2;
        } catch (IllegalArgumentException e5) {
            e = e5;
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + '\"';
            }
            message = e.getMessage();
            if (message != null) {
                message = "(" + e.getClass().getName() + ")";
            } else {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException3 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException3.initCause(e);
            throw parseException3;
        }
    }

    private static int d(String str, int i3, int i4) {
        int i5;
        int i6;
        if (i3 < 0 || i4 > str.length() || i3 > i4) {
            throw new NumberFormatException(str);
        }
        if (i3 < i4) {
            i6 = i3 + 1;
            int iDigit = Character.digit(str.charAt(i3), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i3, i4));
            }
            i5 = -iDigit;
        } else {
            i5 = 0;
            i6 = i3;
        }
        while (i6 < i4) {
            int i7 = i6 + 1;
            int iDigit2 = Character.digit(str.charAt(i6), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i3, i4));
            }
            i5 = (i5 * 10) - iDigit2;
            i6 = i7;
        }
        return -i5;
    }
}
