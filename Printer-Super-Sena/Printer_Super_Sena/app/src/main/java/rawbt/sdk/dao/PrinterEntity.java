package rawbt.sdk.dao;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.PrinterEncoding;
import rawbt.sdk.transport.ConnectParameters;
import rawbt.sdk.transport.Constant;

/* JADX INFO: loaded from: classes.dex */
public class PrinterEntity implements Parcelable {
    public static final Parcelable.Creator<PrinterEntity> CREATOR = new Parcelable.Creator<PrinterEntity>() { // from class: rawbt.sdk.dao.PrinterEntity.2
        @Override // android.os.Parcelable.Creator
        public PrinterEntity createFromParcel(Parcel parcel) {
            return new PrinterEntity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PrinterEntity[] newArray(int i3) {
            return new PrinterEntity[i3];
        }
    };
    public static final int LNG_TYPE_OLD_STYLE = 2;
    public static final int LNG_TYPE_PT210 = 3;
    public static final int LNG_TYPE_STAR = 4;
    public static final int LNG_TYPE_STAR_AUTO = 10;
    public static final int LNG_TYPE_TRUE_TYPE_FONT = 1;
    public static final int LNG_TYPE_TYPICAL = 0;
    public static final int LNG_TYPE_UTF = 5;
    public static final int LNG_TYPE_UTF_CITIZEN = 8;
    public static final int LNG_TYPE_UTF_EPSON = 6;
    public static final int LNG_TYPE_UTF_PT210 = 9;
    public static final int LNG_TYPE_UTF_STAR = 7;
    protected int abs;
    boolean addFrame;
    int baud;
    protected String bytes_finish;
    protected String bytes_init;
    protected String codePage;
    public ConnectParameters connectParameters;
    boolean current;
    protected int cutCommand;
    protected int darkness;
    String description;
    protected int dots;
    protected int dpi;
    PrinterEncoding encoding;
    protected int graphicsCommand;
    String host;
    int id;
    protected int lan_delayMS;
    String mac;
    String name;
    String pageName;
    String pid;
    int port;
    protected String printLanguage;
    protected int printLanguageType;
    String profileClass;
    int protocol;
    protected int pulseCommand;
    String serialComDriver;
    protected int skipLinesAfterJob;
    protected int sleepAfter;
    boolean useDithering;
    String vid;

    public PrinterEntity() {
        this.name = "new_printer";
        this.description = "unknown";
        this.current = false;
        this.protocol = 0;
        this.mac = "00:00:00:00:00:00";
        this.host = "192.168.1.1";
        this.port = 9100;
        this.vid = "";
        this.pid = "";
        this.baud = 115200;
        this.serialComDriver = Constant.COM_CdcAcm;
        this.connectParameters = new ConnectParameters() { // from class: rawbt.sdk.dao.PrinterEntity.1
            @Override // rawbt.sdk.transport.ConnectParameters
            public int getProtocol() {
                return PrinterEntity.this.protocol;
            }

            @Override // rawbt.sdk.transport.ConnectParameters
            public String getSerialComDriver() {
                return PrinterEntity.this.serialComDriver;
            }

            @Override // rawbt.sdk.transport.ConnectParameters
            public int get_baud() {
                return PrinterEntity.this.baud;
            }

            @Override // rawbt.sdk.transport.ConnectParameters
            public String get_host() {
                return PrinterEntity.this.host;
            }

            @Override // rawbt.sdk.transport.ConnectParameters
            public String get_mac() {
                return PrinterEntity.this.mac;
            }

            @Override // rawbt.sdk.transport.ConnectParameters
            public String get_pid() {
                return PrinterEntity.this.pid;
            }

            @Override // rawbt.sdk.transport.ConnectParameters
            public int get_port() {
                return PrinterEntity.this.port;
            }

            @Override // rawbt.sdk.transport.ConnectParameters
            public String get_vid() {
                return PrinterEntity.this.vid;
            }
        };
        this.profileClass = Constant.DRIVER_ESC_GENERAL;
        this.dots = 384;
        this.dpi = 203;
        this.printLanguageType = 0;
        this.printLanguage = "en";
        this.codePage = "cp437";
        this.graphicsCommand = 0;
        this.skipLinesAfterJob = 2;
        this.cutCommand = 0;
        this.pulseCommand = 0;
        this.addFrame = false;
        this.sleepAfter = 3000;
        this.lan_delayMS = 0;
        this.abs = 0;
        this.darkness = 1;
        this.bytes_init = "";
        this.bytes_finish = "";
        this.pageName = "80mm Roll";
        this.useDithering = true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AttributesString getAttributesString() {
        AttributesString attributesString = new AttributesString();
        attributesString.setPrinterFont(getPrintLanguageType() == 1 ? 4 : 1);
        return attributesString;
    }

    public int getBaud() {
        return this.baud;
    }

    public String getBytes_finish() {
        return this.bytes_finish;
    }

    public String getBytes_init() {
        return this.bytes_init;
    }

    public String getCodePage() {
        return this.codePage;
    }

    public String getConnecting() {
        int i3 = this.protocol;
        if (i3 == 1) {
            return "BT " + this.mac;
        }
        if (i3 == 2) {
            return "LAN " + this.host + ":" + this.port;
        }
        if (i3 == 3) {
            return "USB PID_" + this.pid + "&VID_" + this.vid;
        }
        if (i3 == 4) {
            return "AIDL";
        }
        if (i3 == 6) {
            return "BLE " + this.mac;
        }
        if (i3 != 8) {
            return "";
        }
        return "COM " + this.baud;
    }

    public int getCutCommand() {
        return this.cutCommand;
    }

    public int getDarkness() {
        return this.darkness;
    }

    public int getDensity() {
        return this.dpi;
    }

    public String getDescription() {
        return this.description;
    }

    public int getDots_per_line() {
        return this.dots;
    }

    public PrinterEncoding getEncoding() {
        return this.encoding;
    }

    public int getGraphicsCommand() {
        return this.graphicsCommand;
    }

    public String getHost() {
        return this.host;
    }

    public int getId() {
        return this.id;
    }

    public String getMac() {
        return this.mac;
    }

    public String getName() {
        return this.name;
    }

    public String getPageName() {
        return this.pageName;
    }

    public String getPid() {
        return this.pid;
    }

    public int getPort() {
        return this.port;
    }

    public String getPrintLanguage() {
        return this.printLanguage;
    }

    public int getPrintLanguageType() {
        return this.printLanguageType;
    }

    public String getProfileClass() {
        return this.profileClass;
    }

    public int getProtocol() {
        return this.protocol;
    }

    public String getSerialComDriver() {
        return this.serialComDriver;
    }

    public int getSkipLinesAfterJob() {
        return this.skipLinesAfterJob;
    }

    public long getSleepAfter() {
        return this.sleepAfter;
    }

    public String getVid() {
        return this.vid;
    }

    public int get_abs_mode() {
        return this.abs;
    }

    public int get_lan_delay() {
        return this.lan_delayMS;
    }

    public void initEncoding(Context context) {
        if (getId() < 3) {
            PrinterEncoding byLanguageForVirtual = PrinterEncoding.getByLanguageForVirtual(this.printLanguage, context);
            this.encoding = byLanguageForVirtual;
            if ("graphics".equals(byLanguageForVirtual.getName())) {
                this.printLanguageType = 1;
                return;
            }
            return;
        }
        if (getPrintLanguageType() == 2) {
            this.encoding = PrinterEncoding.getByName(this.codePage, context);
            return;
        }
        if (getPrintLanguageType() == 3) {
            this.encoding = PrinterEncoding.getByLanguageGoojprt(this.printLanguage, context);
        } else if (getPrintLanguageType() == 10) {
            this.encoding = PrinterEncoding.getByLanguageStar(this.printLanguage, context);
        } else {
            this.encoding = PrinterEncoding.getByLanguage(this.printLanguage, context);
        }
    }

    public boolean isAddFrame() {
        return this.addFrame;
    }

    public boolean isCurrent() {
        return this.current;
    }

    public boolean isPrintTextAsImage() {
        return !this.profileClass.equals(Constant.DRIVER_ESC_GENERAL);
    }

    public boolean isUseDithering() {
        return this.useDithering;
    }

    public void setAbs_mode(int i3) {
        this.abs = i3;
    }

    public void setAddFrame(boolean z3) {
        this.addFrame = z3;
    }

    public void setBaud(int i3) {
        this.baud = i3;
    }

    public void setBytes_finish(String str) {
        this.bytes_finish = str;
    }

    public void setBytes_init(String str) {
        this.bytes_init = str;
    }

    public void setCodePage(String str) {
        this.codePage = str;
    }

    public void setCurrent(boolean z3) {
        this.current = z3;
    }

    public void setCutCommand(int i3) {
        this.cutCommand = i3;
    }

    public void setDarkness(int i3) {
        this.darkness = i3;
    }

    public void setDensity(int i3) {
        this.dpi = i3;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDots_per_line(int i3) {
        this.dots = i3;
    }

    public void setEncoding(PrinterEncoding printerEncoding) {
        this.encoding = printerEncoding;
    }

    public void setGraphicsCommand(int i3) {
        this.graphicsCommand = i3;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setId(int i3) {
        this.id = i3;
    }

    public void setLan_delayMS(int i3) {
        this.lan_delayMS = i3;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPageName(String str) {
        this.pageName = str;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setPort(int i3) {
        this.port = i3;
    }

    public void setPrintLanguage(String str) {
        this.printLanguage = str;
    }

    public void setPrintLanguageType(int i3) {
        this.printLanguageType = i3;
    }

    public void setProfileClass(String str) {
        this.profileClass = str;
    }

    public void setProtocol(int i3) {
        this.protocol = i3;
    }

    public void setSerialComDriver(String str) {
        this.serialComDriver = str;
    }

    public void setSkipLinesAfterJob(int i3) {
        this.skipLinesAfterJob = i3;
    }

    public void setSleepAfter(int i3) {
        this.sleepAfter = i3;
    }

    public void setUseDithering(boolean z3) {
        this.useDithering = z3;
    }

    public void setVid(String str) {
        this.vid = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeByte(this.current ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.protocol);
        parcel.writeString(this.mac);
        parcel.writeString(this.host);
        parcel.writeInt(this.port);
        parcel.writeString(this.vid);
        parcel.writeString(this.pid);
        parcel.writeInt(this.baud);
        parcel.writeString(this.serialComDriver);
        parcel.writeString(this.profileClass);
        parcel.writeInt(this.dots);
        parcel.writeInt(this.dpi);
        parcel.writeInt(this.printLanguageType);
        parcel.writeString(this.printLanguage);
        parcel.writeString(this.codePage);
        parcel.writeInt(this.graphicsCommand);
        parcel.writeInt(this.skipLinesAfterJob);
        parcel.writeInt(this.cutCommand);
        parcel.writeInt(this.pulseCommand);
        parcel.writeInt(this.sleepAfter);
        parcel.writeInt(this.lan_delayMS);
        parcel.writeInt(this.abs);
        parcel.writeInt(this.darkness);
        parcel.writeString(this.bytes_init);
        parcel.writeString(this.bytes_finish);
        parcel.writeString(this.pageName);
        parcel.writeByte(this.useDithering ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.addFrame ? (byte) 1 : (byte) 0);
    }

    protected PrinterEntity(Parcel parcel) {
        this.name = "new_printer";
        this.description = "unknown";
        this.current = false;
        this.protocol = 0;
        this.mac = "00:00:00:00:00:00";
        this.host = "192.168.1.1";
        this.port = 9100;
        this.vid = "";
        this.pid = "";
        this.baud = 115200;
        this.serialComDriver = Constant.COM_CdcAcm;
        this.connectParameters = new ConnectParameters() { // from class: rawbt.sdk.dao.PrinterEntity.1
            @Override // rawbt.sdk.transport.ConnectParameters
            public int getProtocol() {
                return PrinterEntity.this.protocol;
            }

            @Override // rawbt.sdk.transport.ConnectParameters
            public String getSerialComDriver() {
                return PrinterEntity.this.serialComDriver;
            }

            @Override // rawbt.sdk.transport.ConnectParameters
            public int get_baud() {
                return PrinterEntity.this.baud;
            }

            @Override // rawbt.sdk.transport.ConnectParameters
            public String get_host() {
                return PrinterEntity.this.host;
            }

            @Override // rawbt.sdk.transport.ConnectParameters
            public String get_mac() {
                return PrinterEntity.this.mac;
            }

            @Override // rawbt.sdk.transport.ConnectParameters
            public String get_pid() {
                return PrinterEntity.this.pid;
            }

            @Override // rawbt.sdk.transport.ConnectParameters
            public int get_port() {
                return PrinterEntity.this.port;
            }

            @Override // rawbt.sdk.transport.ConnectParameters
            public String get_vid() {
                return PrinterEntity.this.vid;
            }
        };
        this.profileClass = Constant.DRIVER_ESC_GENERAL;
        this.dots = 384;
        this.dpi = 203;
        this.printLanguageType = 0;
        this.printLanguage = "en";
        this.codePage = "cp437";
        this.graphicsCommand = 0;
        this.skipLinesAfterJob = 2;
        this.cutCommand = 0;
        this.pulseCommand = 0;
        this.addFrame = false;
        this.sleepAfter = 3000;
        this.lan_delayMS = 0;
        this.abs = 0;
        this.darkness = 1;
        this.bytes_init = "";
        this.bytes_finish = "";
        this.pageName = "80mm Roll";
        this.useDithering = true;
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.current = parcel.readByte() != 0;
        this.protocol = parcel.readInt();
        this.mac = parcel.readString();
        this.host = parcel.readString();
        this.port = parcel.readInt();
        this.vid = parcel.readString();
        this.pid = parcel.readString();
        this.baud = parcel.readInt();
        this.serialComDriver = parcel.readString();
        this.profileClass = parcel.readString();
        this.dots = parcel.readInt();
        this.dpi = parcel.readInt();
        this.printLanguageType = parcel.readInt();
        this.printLanguage = parcel.readString();
        this.codePage = parcel.readString();
        this.graphicsCommand = parcel.readInt();
        this.skipLinesAfterJob = parcel.readInt();
        this.cutCommand = parcel.readInt();
        this.pulseCommand = parcel.readInt();
        this.sleepAfter = parcel.readInt();
        this.lan_delayMS = parcel.readInt();
        this.abs = parcel.readInt();
        this.darkness = parcel.readInt();
        this.bytes_init = parcel.readString();
        this.bytes_finish = parcel.readString();
        this.pageName = parcel.readString();
        this.useDithering = parcel.readByte() != 0;
        this.addFrame = parcel.readByte() != 0;
    }
}
