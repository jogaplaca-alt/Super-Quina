package com.google.android.gms.internal.play_billing;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.g1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0426g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f7425a;

    static {
        char[] cArr = new char[80];
        f7425a = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String a(InterfaceC0418e1 interfaceC0418e1, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        d(interfaceC0418e1, sb, 0);
        return sb.toString();
    }

    static void b(StringBuilder sb, int i3, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                b(sb, i3, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                b(sb, i3, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        c(i3, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i4 = 1; i4 < str.length(); i4++) {
                char cCharAt = str.charAt(i4);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(AbstractC0464s1.a(new C0409c0(((String) obj).getBytes(J0.f7334b))));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC0421f0) {
            sb.append(": \"");
            sb.append(AbstractC0464s1.a((AbstractC0421f0) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof B0) {
            sb.append(" {");
            d((B0) obj, sb, i3 + 2);
            sb.append("\n");
            c(i3, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i5 = i3 + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        b(sb, i5, "key", entry.getKey());
        b(sb, i5, "value", entry.getValue());
        sb.append("\n");
        c(i3, sb);
        sb.append("}");
    }

    private static void c(int i3, StringBuilder sb) {
        while (i3 > 0) {
            int i4 = 80;
            if (i3 <= 80) {
                i4 = i3;
            }
            sb.append(f7425a, 0, i4);
            i3 -= i4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01fa  */
    private static void d(InterfaceC0418e1 interfaceC0418e1, StringBuilder sb, int i3) {
        int i4;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = interfaceC0418e1.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i5 = 0;
        while (true) {
            i4 = 3;
            if (i5 >= length) {
                break;
            }
            Method method3 = declaredMethods[i5];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        map.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i5++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i4);
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                b(sb, i3, strSubstring.substring(0, strSubstring.length() - 4), B0.r(method2, interfaceC0418e1, new Object[0]));
            } else if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                b(sb, i3, strSubstring.substring(0, strSubstring.length() - 3), B0.r(method, interfaceC0418e1, new Object[0]));
            } else if (hashSet.contains("set".concat(strSubstring)) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objR = B0.r(method4, interfaceC0418e1, new Object[0]);
                    if (method5 == null) {
                        if (objR instanceof Boolean) {
                            if (((Boolean) objR).booleanValue()) {
                                b(sb, i3, strSubstring, objR);
                            }
                        } else if (objR instanceof Integer) {
                            if (((Integer) objR).intValue() != 0) {
                                b(sb, i3, strSubstring, objR);
                            }
                        } else if (objR instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objR).floatValue()) != 0) {
                                b(sb, i3, strSubstring, objR);
                            }
                        } else if (!(objR instanceof Double)) {
                            if (objR instanceof String) {
                                zEquals = objR.equals("");
                            } else if (objR instanceof AbstractC0421f0) {
                                zEquals = objR.equals(AbstractC0421f0.f7421b);
                            } else if (objR instanceof InterfaceC0418e1) {
                                if (objR != ((InterfaceC0418e1) objR).b()) {
                                    b(sb, i3, strSubstring, objR);
                                }
                            } else if (!(objR instanceof Enum) || ((Enum) objR).ordinal() != 0) {
                                b(sb, i3, strSubstring, objR);
                            }
                            if (!zEquals) {
                                b(sb, i3, strSubstring, objR);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objR).doubleValue()) != 0) {
                            b(sb, i3, strSubstring, objR);
                        }
                    } else if (((Boolean) B0.r(method5, interfaceC0418e1, new Object[0])).booleanValue()) {
                        b(sb, i3, strSubstring, objR);
                    }
                }
            }
            i4 = 3;
        }
        C0473v1 c0473v1 = ((B0) interfaceC0418e1).zzc;
        if (c0473v1 != null) {
            c0473v1.i(sb, i3);
        }
    }
}
