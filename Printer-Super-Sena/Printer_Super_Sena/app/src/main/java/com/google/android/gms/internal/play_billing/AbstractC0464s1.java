package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.s1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0464s1 {
    static String a(AbstractC0421f0 abstractC0421f0) {
        StringBuilder sb = new StringBuilder(abstractC0421f0.l());
        for (int i3 = 0; i3 < abstractC0421f0.l(); i3++) {
            byte bJ = abstractC0421f0.j(i3);
            if (bJ == 34) {
                sb.append("\\\"");
            } else if (bJ == 39) {
                sb.append("\\'");
            } else if (bJ != 92) {
                switch (bJ) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bJ < 32 || bJ > 126) {
                            sb.append('\\');
                            sb.append((char) (((bJ >>> 6) & 3) + 48));
                            sb.append((char) (((bJ >>> 3) & 7) + 48));
                            sb.append((char) ((bJ & 7) + 48));
                        } else {
                            sb.append((char) bJ);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
