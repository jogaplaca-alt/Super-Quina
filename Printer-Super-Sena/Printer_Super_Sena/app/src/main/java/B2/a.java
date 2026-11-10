package B2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import rawbt.api.Constant;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f88a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f89b;

    static {
        HashMap map = new HashMap();
        f88a = map;
        map.put("none", 0);
        map.put(Constant.HRI_ABOVE, 1);
        map.put(Constant.HRI_BELOW, 2);
        map.put(Constant.HRI_BOTH, 3);
        HashMap map2 = new HashMap();
        f89b = map2;
        map2.put(Constant.BARCODE_UPC_A, 0);
        map2.put(Constant.BARCODE_UPC_E, 1);
        map2.put(Constant.BARCODE_EAN13, 2);
        map2.put(Constant.BARCODE_EAN8, 3);
        map2.put(Constant.BARCODE_CODE39, 4);
        map2.put(Constant.BARCODE_ITF, 5);
        map2.put(Constant.BARCODE_CODABAR, 6);
        map2.put(Constant.BARCODE_CODE93, 7);
        map2.put(Constant.BARCODE_CODE128, 8);
        map2.put(Constant.BARCODE_GS1_128, 9);
        map2.put(Constant.BARCODE_GS1_DATABAR_OMNIDIRECTIONAL, 10);
        map2.put(Constant.BARCODE_GS1_DATABAR_TRUNCATED, 11);
        map2.put(Constant.BARCODE_GS1_DATABAR_LIMITED, 12);
        map2.put(Constant.BARCODE_GS1_DATABAR_EXPANDED, 13);
    }

    public static ArrayList a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Font A");
        arrayList.add("Font B");
        return arrayList;
    }

    public static ArrayList b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("default / don't send");
        arrayList.add("12");
        arrayList.add("24");
        arrayList.add("36");
        arrayList.add("48");
        arrayList.add("60");
        arrayList.add("72");
        arrayList.add("84");
        arrayList.add("96");
        arrayList.add("108");
        arrayList.add("120");
        arrayList.add("132");
        arrayList.add("144");
        arrayList.add("156");
        arrayList.add("168");
        arrayList.add("180");
        arrayList.add("192");
        arrayList.add("204");
        arrayList.add("216");
        arrayList.add("228");
        arrayList.add("240");
        arrayList.add("252");
        return arrayList;
    }

    public static ArrayList c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("none");
        arrayList.add(Constant.HRI_ABOVE);
        arrayList.add(Constant.HRI_BELOW);
        arrayList.add(Constant.HRI_BOTH);
        return arrayList;
    }

    public static ArrayList d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Constant.BARCODE_UPC_A);
        arrayList.add(Constant.BARCODE_UPC_E);
        arrayList.add(Constant.BARCODE_EAN13);
        arrayList.add(Constant.BARCODE_EAN8);
        arrayList.add(Constant.BARCODE_CODE39);
        arrayList.add(Constant.BARCODE_ITF);
        arrayList.add(Constant.BARCODE_CODABAR);
        arrayList.add(Constant.BARCODE_CODE93);
        arrayList.add(Constant.BARCODE_CODE128);
        return arrayList;
    }

    public static ArrayList e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("default / don't send");
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");
        arrayList.add("11");
        arrayList.add("12");
        return arrayList;
    }
}
