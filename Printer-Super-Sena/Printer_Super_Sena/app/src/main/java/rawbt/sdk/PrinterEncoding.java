package rawbt.sdk;

import android.content.Context;
import android.os.Build;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes.dex */
public class PrinterEncoding {
    private String encoding = "Cp1251";
    private String name = "CP1251";
    private int value = 73;

    static class EncodingList extends ArrayList<PrinterEncoding> {
        EncodingList(Context context) {
            if ("ru".equals(PrinterEncoding.getCurrentLocale(context).getLanguage())) {
                PrinterEncoding printerEncoding = new PrinterEncoding();
                printerEncoding.setName("CP1251 Russian #12");
                printerEncoding.setValue(12);
                printerEncoding.setEncoding("Cp1251");
                add(printerEncoding);
                PrinterEncoding printerEncoding2 = new PrinterEncoding();
                printerEncoding2.setName("CP1251 Russian  #17");
                printerEncoding2.setValue(17);
                printerEncoding2.setEncoding("Cp1251");
                add(printerEncoding2);
                PrinterEncoding printerEncoding3 = new PrinterEncoding();
                printerEncoding3.setName("CP1251 Russian  #34");
                printerEncoding3.setValue(34);
                printerEncoding3.setEncoding("Cp1251");
                add(printerEncoding3);
                PrinterEncoding printerEncoding4 = new PrinterEncoding();
                printerEncoding4.setName("CP1251 Russian  #46");
                printerEncoding4.setValue(46);
                printerEncoding4.setEncoding("Cp1251");
                add(printerEncoding4);
                PrinterEncoding printerEncoding5 = new PrinterEncoding();
                printerEncoding5.setName("CP1251 Russian  #73");
                printerEncoding5.setValue(73);
                printerEncoding5.setEncoding("Cp1251");
                add(printerEncoding5);
                PrinterEncoding printerEncoding6 = new PrinterEncoding();
                printerEncoding6.setName("CP866 Russian  #11");
                printerEncoding6.setValue(11);
                printerEncoding6.setEncoding("Cp866");
                add(printerEncoding6);
                PrinterEncoding printerEncoding7 = new PrinterEncoding();
                printerEncoding7.setName("CP866 Russian  #17");
                printerEncoding7.setValue(17);
                printerEncoding7.setEncoding("Cp866");
                add(printerEncoding7);
                PrinterEncoding printerEncoding8 = new PrinterEncoding();
                printerEncoding8.setName("CP866 Russian  #59");
                printerEncoding8.setValue(59);
                printerEncoding8.setEncoding("Cp866");
                add(printerEncoding8);
            }
            PrinterEncoding printerEncoding9 = new PrinterEncoding();
            printerEncoding9.setName("BIG5");
            printerEncoding9.setValue(-1);
            printerEncoding9.setEncoding("BIG5");
            add(printerEncoding9);
            PrinterEncoding printerEncoding10 = new PrinterEncoding();
            printerEncoding10.setName("EUC-KR");
            printerEncoding10.setValue(-1);
            printerEncoding10.setEncoding("EUC-KR");
            add(printerEncoding10);
            PrinterEncoding printerEncoding11 = new PrinterEncoding();
            printerEncoding11.setName("GBK");
            printerEncoding11.setValue(-1);
            printerEncoding11.setEncoding("GBK");
            add(printerEncoding11);
            PrinterEncoding printerEncoding12 = new PrinterEncoding();
            printerEncoding12.setName("UTF-8");
            printerEncoding12.setValue(-1);
            printerEncoding12.setEncoding("UTF-8");
            add(printerEncoding12);
            PrinterEncoding printerEncoding13 = new PrinterEncoding();
            printerEncoding13.setName("UTF-8 #128");
            printerEncoding13.setValue(128);
            printerEncoding13.setEncoding("UTF-8");
            add(printerEncoding13);
            PrinterEncoding printerEncoding14 = new PrinterEncoding();
            printerEncoding14.setName("OEM437 Std.Europe #0");
            printerEncoding14.setValue(0);
            printerEncoding14.setEncoding("Cp437");
            add(printerEncoding14);
            PrinterEncoding printerEncoding15 = new PrinterEncoding();
            printerEncoding15.setName("OEM437 Std.Europe #1");
            printerEncoding15.setValue(1);
            printerEncoding15.setEncoding("Cp437");
            add(printerEncoding15);
            PrinterEncoding printerEncoding16 = new PrinterEncoding();
            printerEncoding16.setName("Katakana #1");
            printerEncoding16.setValue(1);
            printerEncoding16.setEncoding("Cp932");
            add(printerEncoding16);
            PrinterEncoding printerEncoding17 = new PrinterEncoding();
            printerEncoding17.setName("Katakana #2");
            printerEncoding17.setValue(2);
            printerEncoding17.setEncoding("Cp932");
            add(printerEncoding17);
            PrinterEncoding printerEncoding18 = new PrinterEncoding();
            printerEncoding18.setName("OEM437 Std.Europe #3");
            printerEncoding18.setValue(3);
            printerEncoding18.setEncoding("Cp437");
            add(printerEncoding18);
            PrinterEncoding printerEncoding19 = new PrinterEncoding();
            printerEncoding19.setName("OEM850 Multilingual #2");
            printerEncoding19.setValue(2);
            printerEncoding19.setEncoding("Cp850");
            add(printerEncoding19);
            PrinterEncoding printerEncoding20 = new PrinterEncoding();
            printerEncoding20.setName("OEM860 Portuguese #3");
            printerEncoding20.setValue(3);
            printerEncoding20.setEncoding("Cp860");
            add(printerEncoding20);
            PrinterEncoding printerEncoding21 = new PrinterEncoding();
            printerEncoding21.setName("CP858 #4");
            printerEncoding21.setValue(4);
            printerEncoding21.setEncoding("Cp858");
            add(printerEncoding21);
            PrinterEncoding printerEncoding22 = new PrinterEncoding();
            printerEncoding22.setName("OEM863 Canadian #4");
            printerEncoding22.setValue(4);
            printerEncoding22.setEncoding("Cp863");
            add(printerEncoding22);
            PrinterEncoding printerEncoding23 = new PrinterEncoding();
            printerEncoding23.setName("OEM852 West Europe  #5");
            printerEncoding23.setValue(5);
            printerEncoding23.setEncoding("Cp852");
            add(printerEncoding23);
            PrinterEncoding printerEncoding24 = new PrinterEncoding();
            printerEncoding24.setName("OEM865 Nordic #5");
            printerEncoding24.setValue(5);
            printerEncoding24.setEncoding("Cp865");
            add(printerEncoding24);
            PrinterEncoding printerEncoding25 = new PrinterEncoding();
            printerEncoding25.setName("CP1252 #6");
            printerEncoding25.setValue(6);
            printerEncoding25.setEncoding("Cp1252");
            add(printerEncoding25);
            PrinterEncoding printerEncoding26 = new PrinterEncoding();
            printerEncoding26.setName("OEM852 West Europe  #6");
            printerEncoding26.setValue(6);
            printerEncoding26.setEncoding("Cp852");
            add(printerEncoding26);
            PrinterEncoding printerEncoding27 = new PrinterEncoding();
            printerEncoding27.setName("OEM860 Portuguese #6");
            printerEncoding27.setValue(6);
            printerEncoding27.setEncoding("Cp860");
            add(printerEncoding27);
            PrinterEncoding printerEncoding28 = new PrinterEncoding();
            printerEncoding28.setName("Cp861 Icelandic #7");
            printerEncoding28.setValue(7);
            printerEncoding28.setEncoding("Cp861");
            add(printerEncoding28);
            PrinterEncoding printerEncoding29 = new PrinterEncoding();
            printerEncoding29.setName("CP866 Citizen  #7");
            printerEncoding29.setValue(7);
            printerEncoding29.setEncoding("Cp866");
            add(printerEncoding29);
            PrinterEncoding printerEncoding30 = new PrinterEncoding();
            printerEncoding30.setName("ISO Greek #7");
            printerEncoding30.setValue(7);
            printerEncoding30.setEncoding("iso8859-7");
            add(printerEncoding30);
            PrinterEncoding printerEncoding31 = new PrinterEncoding();
            printerEncoding31.setName("ISO Hebrew #8");
            printerEncoding31.setValue(8);
            printerEncoding31.setEncoding("iso8859-8");
            add(printerEncoding31);
            PrinterEncoding printerEncoding32 = new PrinterEncoding();
            printerEncoding32.setName("CP852 #8");
            printerEncoding32.setValue(8);
            printerEncoding32.setEncoding("Cp852");
            add(printerEncoding32);
            PrinterEncoding printerEncoding33 = new PrinterEncoding();
            printerEncoding33.setName("CP863 Canadian #8");
            printerEncoding33.setValue(8);
            printerEncoding33.setEncoding("Cp863");
            add(printerEncoding33);
            PrinterEncoding printerEncoding34 = new PrinterEncoding();
            printerEncoding34.setName("CP858 #9");
            printerEncoding34.setValue(9);
            printerEncoding34.setEncoding("Cp858");
            add(printerEncoding34);
            PrinterEncoding printerEncoding35 = new PrinterEncoding();
            printerEncoding35.setName("CP865 Nordic #9");
            printerEncoding35.setValue(9);
            printerEncoding35.setEncoding("Cp865");
            add(printerEncoding35);
            PrinterEncoding printerEncoding36 = new PrinterEncoding();
            printerEncoding36.setName("CP1253 #10");
            printerEncoding36.setValue(10);
            printerEncoding36.setEncoding("Cp1253");
            add(printerEncoding36);
            PrinterEncoding printerEncoding37 = new PrinterEncoding();
            printerEncoding37.setName("CP866 Russian  #10");
            printerEncoding37.setValue(10);
            printerEncoding37.setEncoding("Cp866");
            add(printerEncoding37);
            PrinterEncoding printerEncoding38 = new PrinterEncoding();
            printerEncoding38.setName("CP737 #11");
            printerEncoding38.setValue(11);
            printerEncoding38.setEncoding("Cp737");
            add(printerEncoding38);
            PrinterEncoding printerEncoding39 = new PrinterEncoding();
            printerEncoding39.setName("PC851 Greek #11");
            printerEncoding39.setValue(11);
            printerEncoding39.setEncoding("Cp851");
            add(printerEncoding39);
            PrinterEncoding printerEncoding40 = new PrinterEncoding();
            printerEncoding40.setName("CP855 Cyrillic #11");
            printerEncoding40.setValue(11);
            printerEncoding40.setEncoding("Cp855");
            add(printerEncoding40);
            PrinterEncoding printerEncoding41 = new PrinterEncoding();
            printerEncoding41.setName("CP857 #12");
            printerEncoding41.setValue(12);
            printerEncoding41.setEncoding("Cp857");
            add(printerEncoding41);
            PrinterEncoding printerEncoding42 = new PrinterEncoding();
            printerEncoding42.setName("PC853 Turkish #12");
            printerEncoding42.setValue(12);
            printerEncoding42.setEncoding("Cp853");
            add(printerEncoding42);
            PrinterEncoding printerEncoding43 = new PrinterEncoding();
            printerEncoding43.setName("ISO8859-9 #13");
            printerEncoding43.setValue(13);
            printerEncoding43.setEncoding("iso8859-9");
            add(printerEncoding43);
            PrinterEncoding printerEncoding44 = new PrinterEncoding();
            printerEncoding44.setName("PC857 Turkish #13");
            printerEncoding44.setValue(13);
            printerEncoding44.setEncoding("Cp857");
            add(printerEncoding44);
            PrinterEncoding printerEncoding45 = new PrinterEncoding();
            printerEncoding45.setName("CP862 Israel  #13");
            printerEncoding45.setValue(13);
            printerEncoding45.setEncoding("Cp862");
            add(printerEncoding45);
            PrinterEncoding printerEncoding46 = new PrinterEncoding();
            printerEncoding46.setName("PC737 Greek #14");
            printerEncoding46.setValue(14);
            printerEncoding46.setEncoding("Cp737");
            add(printerEncoding46);
            PrinterEncoding printerEncoding47 = new PrinterEncoding();
            printerEncoding47.setName("CP864 #14");
            printerEncoding47.setValue(14);
            printerEncoding47.setEncoding("Cp864");
            add(printerEncoding47);
            PrinterEncoding printerEncoding48 = new PrinterEncoding();
            printerEncoding48.setName("ISO8859-7 Greek #15");
            printerEncoding48.setValue(15);
            printerEncoding48.setEncoding("iso8859-7");
            add(printerEncoding48);
            PrinterEncoding printerEncoding49 = new PrinterEncoding();
            printerEncoding49.setName("CP862 Citizen  #15");
            printerEncoding49.setValue(15);
            printerEncoding49.setEncoding("Cp862");
            add(printerEncoding49);
            PrinterEncoding printerEncoding50 = new PrinterEncoding();
            printerEncoding50.setName("CP737 #15");
            printerEncoding50.setValue(15);
            printerEncoding50.setEncoding("Cp737");
            add(printerEncoding50);
            PrinterEncoding printerEncoding51 = new PrinterEncoding();
            printerEncoding51.setName("ISO8859-2 #16");
            printerEncoding51.setValue(16);
            printerEncoding51.setEncoding("iso8859-2");
            add(printerEncoding51);
            PrinterEncoding printerEncoding52 = new PrinterEncoding();
            printerEncoding52.setName("CP851 Greek #16");
            printerEncoding52.setValue(16);
            printerEncoding52.setEncoding("Cp851");
            add(printerEncoding52);
            PrinterEncoding printerEncoding53 = new PrinterEncoding();
            printerEncoding53.setName("WCP1252 LATIN #16");
            printerEncoding53.setValue(16);
            printerEncoding53.setEncoding("Cp1252");
            add(printerEncoding53);
            PrinterEncoding printerEncoding54 = new PrinterEncoding();
            printerEncoding54.setName("OEM866 Cyrillic #17");
            printerEncoding54.setValue(17);
            printerEncoding54.setEncoding("Cp866");
            add(printerEncoding54);
            PrinterEncoding printerEncoding55 = new PrinterEncoding();
            printerEncoding55.setName("OEM852 LATIN2 #18");
            printerEncoding55.setValue(18);
            printerEncoding55.setEncoding("Cp852");
            add(printerEncoding55);
            PrinterEncoding printerEncoding56 = new PrinterEncoding();
            printerEncoding56.setName("OEM858 Euro #19");
            printerEncoding56.setValue(19);
            printerEncoding56.setEncoding("Cp858");
            add(printerEncoding56);
            PrinterEncoding printerEncoding57 = new PrinterEncoding();
            printerEncoding57.setName("OEM747 #24");
            printerEncoding57.setValue(24);
            printerEncoding57.setEncoding("Cp747");
            add(printerEncoding57);
            PrinterEncoding printerEncoding58 = new PrinterEncoding();
            printerEncoding58.setName("WPC1257 #25");
            printerEncoding58.setValue(25);
            printerEncoding58.setEncoding("Cp1257");
            add(printerEncoding58);
            PrinterEncoding printerEncoding59 = new PrinterEncoding();
            printerEncoding59.setName("OEM864 #28");
            printerEncoding59.setValue(28);
            printerEncoding59.setEncoding("Cp864");
            add(printerEncoding59);
            PrinterEncoding printerEncoding60 = new PrinterEncoding();
            printerEncoding60.setName("WPC1255 Israel #32");
            printerEncoding60.setValue(32);
            printerEncoding60.setEncoding("Cp1255");
            add(printerEncoding60);
            PrinterEncoding printerEncoding61 = new PrinterEncoding();
            printerEncoding61.setName("PC720 Arabic #32");
            printerEncoding61.setValue(32);
            printerEncoding61.setEncoding("Cp720");
            add(printerEncoding61);
            PrinterEncoding printerEncoding62 = new PrinterEncoding();
            printerEncoding62.setName("CP1252 LATIN #32");
            printerEncoding62.setValue(32);
            printerEncoding62.setEncoding("Cp1252");
            add(printerEncoding62);
            PrinterEncoding printerEncoding63 = new PrinterEncoding();
            printerEncoding63.setName("WPC775 Baltic Rim #33");
            printerEncoding63.setValue(33);
            printerEncoding63.setEncoding("Cp775");
            add(printerEncoding63);
            PrinterEncoding printerEncoding64 = new PrinterEncoding();
            printerEncoding64.setName("CP1250 Latin 2 #33");
            printerEncoding64.setValue(33);
            printerEncoding64.setEncoding("Cp1250");
            add(printerEncoding64);
            PrinterEncoding printerEncoding65 = new PrinterEncoding();
            printerEncoding65.setName("PC855 Cyrillic #34");
            printerEncoding65.setValue(34);
            printerEncoding65.setEncoding("Cp855");
            add(printerEncoding65);
            PrinterEncoding printerEncoding66 = new PrinterEncoding();
            printerEncoding66.setName("C1251 Cyrillic #34");
            printerEncoding66.setValue(34);
            printerEncoding66.setEncoding("Cp1251");
            add(printerEncoding66);
            PrinterEncoding printerEncoding67 = new PrinterEncoding();
            printerEncoding67.setName("PC861 Icelandic #35");
            printerEncoding67.setValue(35);
            printerEncoding67.setEncoding("Cp861");
            add(printerEncoding67);
            PrinterEncoding printerEncoding68 = new PrinterEncoding();
            printerEncoding68.setName("PC862 Hebrew #36");
            printerEncoding68.setValue(36);
            printerEncoding68.setEncoding("Cp862");
            add(printerEncoding68);
            PrinterEncoding printerEncoding69 = new PrinterEncoding();
            printerEncoding69.setName("PC864 Arabic #37");
            printerEncoding69.setValue(37);
            printerEncoding69.setEncoding("Cp864");
            add(printerEncoding69);
            PrinterEncoding printerEncoding70 = new PrinterEncoding();
            printerEncoding70.setName("PC869 Greek #38");
            printerEncoding70.setValue(38);
            printerEncoding70.setEncoding("Cp869");
            add(printerEncoding70);
            PrinterEncoding printerEncoding71 = new PrinterEncoding();
            printerEncoding71.setName("ISO8859-2 Latin 2 #39");
            printerEncoding71.setValue(39);
            printerEncoding71.setEncoding("ISO8859-2");
            add(printerEncoding71);
            PrinterEncoding printerEncoding72 = new PrinterEncoding();
            printerEncoding72.setName("ISO8859-15 Latin 9 #40");
            printerEncoding72.setValue(40);
            printerEncoding72.setEncoding("ISO8859-15");
            add(printerEncoding72);
            PrinterEncoding printerEncoding73 = new PrinterEncoding();
            printerEncoding73.setName("PC1098 Farsi #41");
            printerEncoding73.setValue(41);
            printerEncoding73.setEncoding("Cp1098");
            add(printerEncoding73);
            PrinterEncoding printerEncoding74 = new PrinterEncoding();
            printerEncoding74.setName("PC1118 Lithuanian #42");
            printerEncoding74.setValue(42);
            printerEncoding74.setEncoding("Cp1118");
            add(printerEncoding74);
            PrinterEncoding printerEncoding75 = new PrinterEncoding();
            printerEncoding75.setName("PC1119 Lithuanian #43");
            printerEncoding75.setValue(43);
            printerEncoding75.setEncoding("Cp1119");
            add(printerEncoding75);
            PrinterEncoding printerEncoding76 = new PrinterEncoding();
            printerEncoding76.setName("PC1125 Ukrainian #44");
            printerEncoding76.setValue(44);
            printerEncoding76.setEncoding("Cp1125");
            add(printerEncoding76);
            PrinterEncoding printerEncoding77 = new PrinterEncoding();
            printerEncoding77.setName("WPC1250 Latin 2 #45");
            printerEncoding77.setValue(45);
            printerEncoding77.setEncoding("Cp1250");
            add(printerEncoding77);
            PrinterEncoding printerEncoding78 = new PrinterEncoding();
            printerEncoding78.setName("WPC1251 Cyrillic #46");
            printerEncoding78.setValue(46);
            printerEncoding78.setEncoding("Cp1251");
            add(printerEncoding78);
            PrinterEncoding printerEncoding79 = new PrinterEncoding();
            printerEncoding79.setName("WPC1253 Greek #47");
            printerEncoding79.setValue(47);
            printerEncoding79.setEncoding("Cp1253");
            add(printerEncoding79);
            PrinterEncoding printerEncoding80 = new PrinterEncoding();
            printerEncoding80.setName("WPC1254 Turkish #48");
            printerEncoding80.setValue(48);
            printerEncoding80.setEncoding("Cp1254");
            add(printerEncoding80);
            PrinterEncoding printerEncoding81 = new PrinterEncoding();
            printerEncoding81.setName("WPC1255 Hebrew #49");
            printerEncoding81.setValue(49);
            printerEncoding81.setEncoding("Cp1255");
            add(printerEncoding81);
            PrinterEncoding printerEncoding82 = new PrinterEncoding();
            printerEncoding82.setName("WPC1256 Arabic #50");
            printerEncoding82.setValue(50);
            printerEncoding82.setEncoding("Cp1256");
            add(printerEncoding82);
            PrinterEncoding printerEncoding83 = new PrinterEncoding();
            printerEncoding83.setName("WPC1257 Baltic Rim #51");
            printerEncoding83.setValue(51);
            printerEncoding83.setEncoding("Cp1257");
            add(printerEncoding83);
            PrinterEncoding printerEncoding84 = new PrinterEncoding();
            printerEncoding84.setName("WPC1258 Vietnamese #52");
            printerEncoding84.setValue(52);
            printerEncoding84.setEncoding("Cp1258");
            add(printerEncoding84);
            PrinterEncoding printerEncoding85 = new PrinterEncoding();
            printerEncoding85.setName("OEM861 Icelandic #56");
            printerEncoding85.setValue(56);
            printerEncoding85.setEncoding("Cp861");
            add(printerEncoding85);
            PrinterEncoding printerEncoding86 = new PrinterEncoding();
            printerEncoding86.setName("OEM863 Canadian #57");
            printerEncoding86.setValue(57);
            printerEncoding86.setEncoding("Cp863");
            add(printerEncoding86);
            PrinterEncoding printerEncoding87 = new PrinterEncoding();
            printerEncoding87.setName("OEM855 Bulgarian #60");
            printerEncoding87.setValue(60);
            printerEncoding87.setEncoding("Cp855");
            add(printerEncoding87);
            PrinterEncoding printerEncoding88 = new PrinterEncoding();
            printerEncoding88.setName("OEM857 Turkey #61");
            printerEncoding88.setValue(61);
            printerEncoding88.setEncoding("Cp857");
            add(printerEncoding88);
            PrinterEncoding printerEncoding89 = new PrinterEncoding();
            printerEncoding89.setName("OEM862 Hebrew #62");
            printerEncoding89.setValue(62);
            printerEncoding89.setEncoding("Cp862");
            add(printerEncoding89);
            PrinterEncoding printerEncoding90 = new PrinterEncoding();
            printerEncoding90.setName("OEM864 Arabic #63");
            printerEncoding90.setValue(63);
            printerEncoding90.setEncoding("Cp864");
            add(printerEncoding90);
            PrinterEncoding printerEncoding91 = new PrinterEncoding();
            printerEncoding91.setName("OEM737 Greek #64");
            printerEncoding91.setValue(64);
            printerEncoding91.setEncoding("Cp737");
            add(printerEncoding91);
            PrinterEncoding printerEncoding92 = new PrinterEncoding();
            printerEncoding92.setName("OEM851 Greek #65");
            printerEncoding92.setValue(65);
            printerEncoding92.setEncoding("Cp851");
            add(printerEncoding92);
            PrinterEncoding printerEncoding93 = new PrinterEncoding();
            printerEncoding93.setName("OEM869 Greek #66");
            printerEncoding93.setValue(66);
            printerEncoding93.setEncoding("Cp869");
            add(printerEncoding93);
            PrinterEncoding printerEncoding94 = new PrinterEncoding();
            printerEncoding94.setName("Devanagari #66");
            printerEncoding94.setValue(66);
            printerEncoding94.setEncoding("x-iscii-de");
            add(printerEncoding94);
            PrinterEncoding printerEncoding95 = new PrinterEncoding();
            printerEncoding95.setName("Bengali #67");
            printerEncoding95.setValue(67);
            printerEncoding95.setEncoding("x-iscii-be");
            add(printerEncoding95);
            PrinterEncoding printerEncoding96 = new PrinterEncoding();
            printerEncoding96.setName("Tamil #68");
            printerEncoding96.setValue(68);
            printerEncoding96.setEncoding("x-iscii-ta");
            add(printerEncoding96);
            PrinterEncoding printerEncoding97 = new PrinterEncoding();
            printerEncoding97.setName("OEM772 Lithuanian #68");
            printerEncoding97.setValue(68);
            printerEncoding97.setEncoding("Cp772");
            add(printerEncoding97);
            PrinterEncoding printerEncoding98 = new PrinterEncoding();
            printerEncoding98.setName("Telugu #69");
            printerEncoding98.setValue(69);
            printerEncoding98.setEncoding("x-iscii-te");
            add(printerEncoding98);
            PrinterEncoding printerEncoding99 = new PrinterEncoding();
            printerEncoding99.setName("OEM774 Lithuanian #69");
            printerEncoding99.setValue(69);
            printerEncoding99.setEncoding("Cp774");
            add(printerEncoding99);
            PrinterEncoding printerEncoding100 = new PrinterEncoding();
            printerEncoding100.setName("Assamese #70");
            printerEncoding100.setValue(70);
            printerEncoding100.setEncoding("x-iscii-as");
            add(printerEncoding100);
            PrinterEncoding printerEncoding101 = new PrinterEncoding();
            printerEncoding101.setName("Oriya #71");
            printerEncoding101.setValue(71);
            printerEncoding101.setEncoding("x-iscii-or");
            add(printerEncoding101);
            PrinterEncoding printerEncoding102 = new PrinterEncoding();
            printerEncoding102.setName("Kannada #72");
            printerEncoding102.setValue(72);
            printerEncoding102.setEncoding("x-iscii-ka");
            add(printerEncoding102);
            PrinterEncoding printerEncoding103 = new PrinterEncoding();
            printerEncoding103.setName("WCP1250 Latin-2 #72");
            printerEncoding103.setValue(72);
            printerEncoding103.setEncoding("Cp1250");
            add(printerEncoding103);
            PrinterEncoding printerEncoding104 = new PrinterEncoding();
            printerEncoding104.setName("WCP1251 Cyrillic #73");
            printerEncoding104.setValue(73);
            printerEncoding104.setEncoding("Cp1251");
            add(printerEncoding104);
            PrinterEncoding printerEncoding105 = new PrinterEncoding();
            printerEncoding105.setName("Malayalam #73");
            printerEncoding105.setValue(73);
            printerEncoding105.setEncoding("x-iscii-ma");
            add(printerEncoding105);
            PrinterEncoding printerEncoding106 = new PrinterEncoding();
            printerEncoding106.setName("Gujarati #74");
            printerEncoding106.setValue(74);
            printerEncoding106.setEncoding("x-iscii-gu");
            add(printerEncoding106);
            PrinterEncoding printerEncoding107 = new PrinterEncoding();
            printerEncoding107.setName("Punjabi #75");
            printerEncoding107.setValue(75);
            printerEncoding107.setEncoding("x-iscii-pu");
            add(printerEncoding107);
            PrinterEncoding printerEncoding108 = new PrinterEncoding();
            printerEncoding108.setName("WCP1253 Greek #90");
            printerEncoding108.setValue(90);
            printerEncoding108.setEncoding("Cp1253");
            add(printerEncoding108);
            PrinterEncoding printerEncoding109 = new PrinterEncoding();
            printerEncoding109.setName("WCP1254 Turkish #91");
            printerEncoding109.setValue(91);
            printerEncoding109.setEncoding("Cp1254");
            add(printerEncoding109);
            PrinterEncoding printerEncoding110 = new PrinterEncoding();
            printerEncoding110.setName("WCP1256 Arabic #92");
            printerEncoding110.setValue(92);
            printerEncoding110.setEncoding("Cp1256");
            add(printerEncoding110);
            PrinterEncoding printerEncoding111 = new PrinterEncoding();
            printerEncoding111.setName("OEM720 Arabic #93");
            printerEncoding111.setValue(93);
            printerEncoding111.setEncoding("Cp720");
            add(printerEncoding111);
            PrinterEncoding printerEncoding112 = new PrinterEncoding();
            printerEncoding112.setName("WCP1258 Vietnam #94");
            printerEncoding112.setValue(94);
            printerEncoding112.setEncoding("Cp1258");
            add(printerEncoding112);
        }
    }

    private static JSONArray createJSONFromFile(Context context, int i3) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i3)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return new JSONArray(new JSONTokener(sb.toString()));
                }
                sb.append(line);
                sb.append("\n");
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static PrinterEncoding getByLanguage(String str, Context context) {
        int i3;
        PrinterEncoding printerEncoding = new PrinterEncoding();
        printerEncoding.setName("auto");
        String str2 = readHashMap(context, R.raw.default_cp).get(str);
        if (str2 == null) {
            str2 = "graphics";
        }
        printerEncoding.setEncoding(str2);
        try {
            String str3 = readHashMap(context, R.raw.cp_to_page).get(str2.toUpperCase());
            Objects.requireNonNull(str3);
            i3 = Integer.parseInt(str3);
        } catch (Exception e3) {
            e3.printStackTrace();
            i3 = 0;
        }
        printerEncoding.setValue(i3);
        return printerEncoding;
    }

    public static PrinterEncoding getByLanguageForVirtual(String str, Context context) {
        int i3;
        PrinterEncoding printerEncoding = new PrinterEncoding();
        printerEncoding.setName("auto");
        String str2 = readHashMap(context, R.raw.default_cp).get(str);
        if (str2 == null) {
            str2 = "graphics";
        }
        printerEncoding.setEncoding(str2);
        try {
            String str3 = readHashMap(context, R.raw.cp_to_page_virtual).get(str2.toUpperCase());
            Objects.requireNonNull(str3);
            i3 = Integer.parseInt(str3);
        } catch (Exception unused) {
            printerEncoding.setName("graphics");
            i3 = 24;
        }
        printerEncoding.setValue(i3);
        return printerEncoding;
    }

    public static PrinterEncoding getByLanguageGoojprt(String str, Context context) {
        int i3;
        PrinterEncoding printerEncoding = new PrinterEncoding();
        printerEncoding.setName("auto");
        String str2 = readHashMap(context, R.raw.default_cp).get(str);
        if (str2 == null) {
            str2 = "graphics";
        }
        printerEncoding.setEncoding(str2);
        try {
            String str3 = readHashMap(context, R.raw.cp_to_page_pt210).get(str2.toUpperCase());
            Objects.requireNonNull(str3);
            i3 = Integer.parseInt(str3);
        } catch (Exception e3) {
            e3.printStackTrace();
            i3 = 0;
        }
        printerEncoding.setValue(i3);
        return printerEncoding;
    }

    public static PrinterEncoding getByLanguageStar(String str, Context context) {
        int i3;
        PrinterEncoding printerEncoding = new PrinterEncoding();
        printerEncoding.setName("auto");
        String str2 = readHashMap(context, R.raw.default_cp).get(str);
        if (str2 == null) {
            str2 = "graphics";
        }
        printerEncoding.setEncoding(str2);
        try {
            String str3 = readHashMap(context, R.raw.cp_to_star).get(str2.toUpperCase());
            Objects.requireNonNull(str3);
            i3 = Integer.parseInt(str3);
        } catch (Exception e3) {
            e3.printStackTrace();
            i3 = 0;
        }
        printerEncoding.setValue(i3);
        return printerEncoding;
    }

    public static PrinterEncoding getByName(String str, Context context) {
        for (PrinterEncoding printerEncoding : getCodePages(context)) {
            if (printerEncoding.getName().equalsIgnoreCase(str)) {
                return printerEncoding;
            }
        }
        PrinterEncoding printerEncoding2 = new PrinterEncoding();
        printerEncoding2.setName("OEM437 Std.Europe #0");
        printerEncoding2.setValue(0);
        printerEncoding2.setEncoding("Cp437");
        return printerEncoding2;
    }

    public static List<PrinterEncoding> getCodePages(Context context) {
        return Collections.unmodifiableList(new EncodingList(context));
    }

    public static Locale getCurrentLocale(Context context) {
        if (context == null) {
            return Locale.ENGLISH;
        }
        return Build.VERSION.SDK_INT >= 24 ? context.getResources().getConfiguration().getLocales().get(0) : context.getResources().getConfiguration().locale;
    }

    public static HashMap<String, String> readHashMap(Context context, int i3) {
        HashMap<String, String> map = new HashMap<>();
        JSONArray jSONArrayCreateJSONFromFile = createJSONFromFile(context, i3);
        for (int i4 = 0; i4 < jSONArrayCreateJSONFromFile.length(); i4++) {
            try {
                JSONArray jSONArray = jSONArrayCreateJSONFromFile.getJSONArray(i4);
                map.put(jSONArray.getString(0), jSONArray.getString(1));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return map;
    }

    public String getEncoding() {
        String str = this.encoding;
        return str == null ? "Cp437" : str;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(int i3) {
        this.value = i3;
    }
}
