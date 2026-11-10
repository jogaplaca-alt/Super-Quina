package B2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;
import rawbt.api.Constant;
import rawbt.api.RawbtMediaTypes;
import rawbt.api.command.CommandImageInBase64;
import rawbt.api.command.CommandParcelable;
import rawbt.api.command.CommandPdfInBase64;
import rawbt.api.command.CommandString;
import rawbt.sdk.RawbtPrintJob;
import ru.a402d.rawbtprinter.R;
import ru.a402d.rawbtprinter.RawPrinterApp;
import ru.a402d.rawbtprinter.activity.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f90a;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f91a;

        static {
            int[] iArr = new int[Constant.RAWBT_CONTENT_TYPE.values().length];
            f91a = iArr;
            try {
                iArr[Constant.RAWBT_CONTENT_TYPE.txt.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f91a[Constant.RAWBT_CONTENT_TYPE.pdf.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f91a[Constant.RAWBT_CONTENT_TYPE.image.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: renamed from: B2.b$b, reason: collision with other inner class name */
    public static class C0001b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Constant.RAWBT_CONTENT_TYPE f92a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Uri f93b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f94c = null;
    }

    static {
        Context contextG = RawPrinterApp.g();
        Objects.requireNonNull(contextG);
        f90a = Arrays.asList(contextG.getResources().getStringArray(R.array.LanguageKey));
    }

    private static JSONArray a(Context context, int i3) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:137:0x0207  */
    public static String b(String str) {
        switch (str) {
            case "bn":
                return "হৃদয়ের চঞ্চলতা বন্ধে ব্রতী হলে\nজীবন পরিপূর্ণ হবে নানা রঙের ফুলে।\nকুঞ্ঝটিকা প্রভঞ্জন শঙ্কার কারণ\nলণ্ডভণ্ড করে যায় ধরার অঙ্গন।\nক্ষিপ্ত হলে সাঙ্গ হবে বিজ্ঞজনে বলে\nশান্ত হলে এ ব্রহ্মাণ্ডে বাঞ্ছিতফল মেলে।\nআষাঢ়ে ঈশান কোনে হঠাৎ ঝড় উঠে\nগগন মেঘেতে ঢাকে বৃষ্টি নামে মাঠে\nঊষার আকাশে নামে সন্ধ্যার ছায়া\nঐ দেখো থেমে গেছে পারাপারে খেয়া।\nশরৎ ঋতুতে চাঁদ আলোয় অংশুমান\nসুখ দুঃখ পাশা পাশি সহ অবস্থান।\nযে জলেতে ঈশ্বর তৃষ্ণা মেটায়\nসেই জলেতে জীবকুলে বিনাশ ঘটায়।\nরোগ যদি দেহ ছেড়ে মনে গিয়ে ধরে\nঔষধের সাধ্য কি বা তারে সুস্থ করে?";
            case "ja":
                return "以呂波耳本部止\n千利奴流乎和加\n餘多連曽津祢那\n良牟有為能於久\n耶万計不己衣天\n阿佐伎喩女美之\n恵比毛勢須";
            case "hy":
                return "Կրնամ ապակի ուտել և ինծի անհանգիստ չըներ։";
            case "ar":
                return "صِف خَلقَ خَودِ كَمِثلِ الشَمسِ إِذ بَزَغَت — يَحظى الضَجيعُ بِها نَجلاءَ مِعطارِ (A poem by Al Farāhīdi)";
            case "sq":
                return "Unë mund të ha qelq dhe nuk më gjen gjë.";
            case "bg":
                return "Мога да ям стъкло, то не ми вреди.";
            case "ca":
                return "Puc menjar vidre, que no em fa mal.";
            case "hr":
                return "Ja mogu jesti staklo, i to mi ne šteti.";
            case "cs":
                return "Mohu jíst sklo, neublíží mi.";
            case "da":
                return "Jeg kan spise glas, det gør ikke ondt på mig.";
            case "nl":
                return "Ik kan glas eten, het doet mĳ geen kwaad.";
            case "et":
                return "Ma võin klaasi süüa, see ei tee mulle midagi.";
            case "ph":
                return "-unknown-";
            case "fi":
                return "Voin syödä lasia, se ei vahingoita minua.";
            case "fr":
                return "Je peux manger du verre, ça ne me fait pas mal.";
            case "ka":
                return "მინას ვჭამ და არა მტკივა.";
            case "ko":
                return "키스의 고유조건은 입술끼리 만나야 하고 특별한 기술은 필요치 않다";
            case "de":
                return "Ich kann Glas essen, ohne mir zu schaden.";
            case "el":
                return "Μπορώ να φάω σπασμένα γυαλιά χωρίς να πάθω τίποτα.";
            case "fa":
                return "ابپچ جدژ هوز حطی کلمن سعفگ صقرش تثخذ ضظغ";
            case "hi":
                return "मैं काँच खा सकता हूँ, मुझे उस से कोई पीडा नहीं होती.";
            case "hu":
                return "Árvíztűrő tükörfúrógép.";
            case "id":
                return "Cwm fjordbank glyphs vext quiz.";
            case "it":
                return "Posso mangiare il vetro e non mi fa male.";
            case "lv":
                return "Es varu ēst stiklu, tas man nekaitē.";
            case "lt":
                return "Aš galiu valgyti stiklą ir jis manęs nežeidžia";
            case "mk":
                return "Можам да јадам стакло, а не ме штета.";
            case "ms":
                return "Saya boleh makan kaca dan ia tidak mencederakan saya.";
            case "no":
                return "Eg kan eta glas utan å skada meg. Jeg kan spise glass uten å skade meg.";
            case "pl":
                return "Pchnąć w tę łódź jeża lub ośm skrzyń fig.";
            case "pt":
                return "O próximo vôo à noite sobre o Atlântico, põe freqüentemente o único médico.";
            case "ro":
                return "Pot să mănânc sticlă și ea nu mă rănește.";
            case "ru":
                return "В чащах юга жил бы цитрус? Да, но фальшивый экземпляр!";
            case "sr":
                return "Ја могу јести стакло, и то ми не штети. Ja mogu jesti staklo, i to mi ne šteti.";
            case "sk":
                return "Starý kôň na hŕbe kníh žuje tíško povädnuté ruže, na stĺpe sa ďateľ učí kvákať novú ódu o živote.";
            case "sl":
                return "Lahko jem steklo, ne da bi mi škodovalo.";
            case "es":
                return "Puedo comer vidrio, no me hace daño.";
            case "sv":
                return "Jag kan äta glas utan att skada mig.";
            case "th":
                return "ฉันกินกระจกได้ แต่มันไม่ทำให้ฉันเจ็บ";
            case "tr":
                return "Pijamalı hasta, yağız şoföre çabucak güvendi.";
            case "uk":
                return "Чуєш їх, доцю, га? Кумедна ж ти, прощайся без ґольфів!";
            case "vi":
                return "Tôi có thể ăn thủy tinh mà không hại gì.";
            case "zh":
                return "恭喜您!\n您已经成功的连接上了我们的便携式蓝牙打印机！\n";
            case "en":
            default:
                return "A quick brown fox jumps over the lazy dog";
        }
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:65:0x0110  */
    public static RawbtPrintJob c(Intent intent, y2.b bVar) {
        Bundle extras;
        String string;
        CharSequence charSequenceExtra;
        Constant.RAWBT_CONTENT_TYPE rawbt_content_typeDetectContentType;
        Uri data = null;
        if (intent == null) {
            return null;
        }
        RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
        String action = intent.getAction();
        String type = intent.getType();
        if (action == null || action.equals("android.intent.action.MAIN")) {
            return null;
        }
        if (!"android.intent.action.SEND_MULTIPLE".equals(action) || type == null) {
            if (action.equals("android.intent.action.VIEW")) {
                data = intent.getData();
                string = null;
            } else if (action.equals("android.intent.action.PROCESS_TEXT")) {
                if (Build.VERSION.SDK_INT >= 23) {
                    string = intent.getStringExtra("android.intent.extra.PROCESS_TEXT");
                }
            } else if ((action.equals("android.intent.action.SEND") || action.equals("android.intent.action.SENDTO")) && (extras = intent.getExtras()) != null) {
                data = (Uri) extras.getParcelable("android.intent.extra.STREAM");
                String string2 = extras.getString("android.intent.extra.TEXT");
                string = (string2 != null || (charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TEXT")) == null) ? string2 : charSequenceExtra.toString();
            }
            if (data != null) {
                rawbt_content_typeDetectContentType = RawbtMediaTypes.detectContentType(RawPrinterApp.g(), data, type);
                if (!bVar.t0() && rawbt_content_typeDetectContentType == Constant.RAWBT_CONTENT_TYPE.txt) {
                    rawbt_content_typeDetectContentType = Constant.RAWBT_CONTENT_TYPE.prn;
                }
                rawbtPrintJob.add(new CommandParcelable(data, rawbt_content_typeDetectContentType));
            } else if (string != null && string.trim().length() > 0) {
                rawbtPrintJob.println(string);
            }
            return rawbtPrintJob;
        }
        ArrayList<Uri> parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        if (parcelableArrayListExtra == null) {
            return null;
        }
        if (parcelableArrayListExtra.size() > bVar.E()) {
            Context contextG = RawPrinterApp.g();
            Objects.requireNonNull(contextG);
            RawPrinterApp.r(contextG.getString(R.string.ErrorOverImages));
            return null;
        }
        boolean z3 = false;
        for (Uri uri : parcelableArrayListExtra) {
            if (z3) {
                rawbtPrintJob.delimiterImages();
            }
            int i3 = a.f91a[RawbtMediaTypes.detectContentType(RawPrinterApp.g(), uri, type).ordinal()];
            if (i3 == 1) {
                rawbtPrintJob.text(uri);
            } else if (i3 == 2) {
                rawbtPrintJob.pdf(uri, bVar.b(), bVar.a());
            } else if (i3 != 3) {
                rawbtPrintJob.println("Media type not supported");
            } else {
                rawbtPrintJob.image(uri, bVar.a());
            }
            z3 = true;
        }
        string = null;
        if (data != null) {
            rawbt_content_typeDetectContentType = RawbtMediaTypes.detectContentType(RawPrinterApp.g(), data, type);
            if (!bVar.t0()) {
                rawbt_content_typeDetectContentType = Constant.RAWBT_CONTENT_TYPE.prn;
            }
            rawbtPrintJob.add(new CommandParcelable(data, rawbt_content_typeDetectContentType));
        } else if (string != null) {
            rawbtPrintJob.println(string);
        }
        return rawbtPrintJob;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x008e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0092  */
    /* JADX WARN: Code duplicated, block: B:42:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e2 A[LOOP:0: B:43:0x00cf->B:47:0x00e2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:48:0x00e6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d5 A[SYNTHETIC] */
    public static C0001b d(Intent intent) {
        Bundle extras;
        String string;
        Uri data;
        CharSequence charSequenceExtra;
        InputStream inputStreamOpenInputStream;
        File file;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        byte[] bArr;
        int i3;
        if (intent == null) {
            return null;
        }
        C0001b c0001b = new C0001b();
        String action = intent.getAction();
        String type = intent.getType();
        if (action != null && !action.equals("android.intent.action.MAIN")) {
            if (!"android.intent.action.SEND_MULTIPLE".equals(action) || type == null) {
                if (action.equals("android.intent.action.VIEW")) {
                    data = intent.getData();
                } else if (action.equals("android.intent.action.PROCESS_TEXT")) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        string = intent.getStringExtra("android.intent.extra.PROCESS_TEXT");
                        data = null;
                    } else {
                        data = null;
                        string = null;
                    }
                } else if ((action.equals("android.intent.action.SEND") || action.equals("android.intent.action.SENDTO")) && (extras = intent.getExtras()) != null) {
                    Uri uri = (Uri) extras.getParcelable("android.intent.extra.STREAM");
                    string = extras.getString("android.intent.extra.TEXT");
                    if (string == null && (charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TEXT")) != null) {
                        string = charSequenceExtra.toString();
                    }
                    data = uri;
                } else {
                    data = null;
                    string = null;
                }
                if (data != null) {
                    c0001b.f92a = RawbtMediaTypes.detectContentType(RawPrinterApp.g(), data, type);
                    inputStreamOpenInputStream = RawPrinterApp.g().getContentResolver().openInputStream(data);
                    if (inputStreamOpenInputStream != null) {
                        return null;
                    }
                    Context contextG = RawPrinterApp.g();
                    Objects.requireNonNull(contextG);
                    file = new File(contextG.getCacheDir(), "preview_temp");
                    bufferedInputStream = new BufferedInputStream(inputStreamOpenInputStream);
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    bArr = new byte[8192];
                    while (true) {
                        i3 = bufferedInputStream.read(bArr);
                        if (i3 < 0) {
                            bufferedInputStream.close();
                            bufferedOutputStream.close();
                            c0001b.f93b = Uri.fromFile(file);
                            return c0001b;
                        }
                        bufferedOutputStream.write(bArr, 0, i3);
                    }
                } else if (string != null && string.trim().length() > 0) {
                    c0001b.f94c = string;
                    return c0001b;
                }
            } else {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
                if (parcelableArrayListExtra == null) {
                    return null;
                }
                data = (Uri) parcelableArrayListExtra.get(0);
            }
            string = null;
            if (data != null) {
                c0001b.f92a = RawbtMediaTypes.detectContentType(RawPrinterApp.g(), data, type);
                inputStreamOpenInputStream = RawPrinterApp.g().getContentResolver().openInputStream(data);
                if (inputStreamOpenInputStream != null) {
                    return null;
                }
                Context contextG2 = RawPrinterApp.g();
                Objects.requireNonNull(contextG2);
                file = new File(contextG2.getCacheDir(), "preview_temp");
                bufferedInputStream = new BufferedInputStream(inputStreamOpenInputStream);
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                bArr = new byte[8192];
                while (true) {
                    i3 = bufferedInputStream.read(bArr);
                    if (i3 < 0) {
                        bufferedInputStream.close();
                        bufferedOutputStream.close();
                        c0001b.f93b = Uri.fromFile(file);
                        return c0001b;
                    }
                    bufferedOutputStream.write(bArr, 0, i3);
                }
            } else if (string != null) {
                c0001b.f94c = string;
                return c0001b;
            }
        }
        return null;
    }

    public static RawbtPrintJob e(String str, y2.b bVar, Activity activity) {
        RawbtPrintJob rawbtPrintJob = new RawbtPrintJob();
        rawbtPrintJob.setTemplate(rawbt.api.RawbtPrintJob.TEMPLATE_DEFAULT);
        rawbtPrintJob.setCopies(bVar.i());
        rawbtPrintJob.setDefaultAttrImage(bVar.a());
        rawbtPrintJob.setDefaultAttrPdf(bVar.b());
        rawbtPrintJob.setDefaultAttrString(bVar.c());
        if (str.startsWith("base64,")) {
            rawbtPrintJob.sendBytes(str.substring(7));
        } else {
            String str2 = "Error text decode \n";
            if (str.startsWith("data:")) {
                String[] strArrSplit = str.substring(5).split(",", 2);
                if (strArrSplit[0].startsWith(CommandImageInBase64.TAG)) {
                    rawbtPrintJob.add(new CommandImageInBase64(strArrSplit[1], bVar.a()));
                } else if (strArrSplit[0].startsWith("text/html")) {
                    if (activity != null) {
                        try {
                            Intent intent = new Intent(activity.getApplicationContext(), (Class<?>) MainActivity.class);
                            intent.setAction("android.intent.action.SEND");
                            intent.setFlags(269025280);
                            intent.setType("text/html");
                            intent.putExtra("android.intent.extra.TEXT", new String(Base64.decode(strArrSplit[1], 0)));
                            activity.startActivity(intent);
                            return null;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return null;
                        }
                    }
                } else if (strArrSplit[0].startsWith("application/pdf")) {
                    rawbtPrintJob.add(new CommandPdfInBase64(strArrSplit[1], bVar.b()));
                } else if (strArrSplit[0].startsWith("text/plain")) {
                    try {
                        str2 = new String(Base64.decode(strArrSplit[1], 0)) + "\n";
                    } catch (Exception unused) {
                    }
                    rawbtPrintJob.add(new CommandString(str2, bVar.c()));
                }
            } else {
                try {
                    str2 = URLDecoder.decode(str, "UTF-8") + "\n";
                } catch (Exception unused2) {
                }
                rawbtPrintJob.add(new CommandString(str2, bVar.c()));
            }
        }
        rawbtPrintJob.setPrinter(rawbt.api.RawbtPrintJob.PRINTER_CURRENT);
        return rawbtPrintJob;
    }

    public static String[][] f(Context context, int i3) {
        JSONArray jSONArrayA = a(context, i3);
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, 2, jSONArrayA.length());
        for (int i4 = 0; i4 < jSONArrayA.length(); i4++) {
            try {
                JSONArray jSONArray = jSONArrayA.getJSONArray(i4);
                String string = jSONArray.getString(0);
                String string2 = jSONArray.getString(1);
                strArr[0][i4] = string;
                strArr[1][i4] = string2;
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return strArr;
    }

    public static ArrayMap g(Context context, int i3) {
        ArrayMap arrayMap = new ArrayMap();
        JSONArray jSONArrayA = a(context, i3);
        for (int i4 = 0; i4 < jSONArrayA.length(); i4++) {
            try {
                JSONArray jSONArray = jSONArrayA.getJSONArray(i4);
                arrayMap.put(jSONArray.getString(0), jSONArray.getString(1));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return arrayMap;
    }
}
