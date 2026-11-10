package rawbt.api.command;

import rawbt.api.Constant;
import rawbt.api.attributes.AttributesBarcode;

/* JADX INFO: loaded from: classes.dex */
public class CommandBarcode implements RawbtCommand {
    public static final String TAG = "barcode";
    String alignment;
    String command;
    String data;
    int font;
    int height;
    String hri;
    String type;
    int width;

    public CommandBarcode(String str, String str2) {
        this.command = TAG;
        this.hri = "none";
        this.font = 1;
        this.height = 162;
        this.width = 3;
        this.alignment = Constant.ALIGNMENT_LEFT;
        this.type = str;
        this.data = str2;
    }

    public String getAlignment() {
        return this.alignment;
    }

    public String getData() {
        return this.data;
    }

    public int getFont() {
        return this.font;
    }

    public int getHeight() {
        return this.height;
    }

    public String getHri() {
        return this.hri;
    }

    public String getType() {
        return this.type;
    }

    public int getWidth() {
        return this.width;
    }

    public CommandBarcode setAlignment(String str) {
        this.alignment = str;
        return this;
    }

    public CommandBarcode setData(String str) {
        this.data = str;
        return this;
    }

    public CommandBarcode setFont(int i3) {
        this.font = i3;
        return this;
    }

    public CommandBarcode setHeight(int i3) {
        this.height = i3;
        return this;
    }

    public CommandBarcode setHri(String str) {
        this.hri = str;
        return this;
    }

    public CommandBarcode setType(String str) {
        this.type = str;
        return this;
    }

    public CommandBarcode setWidth(int i3) {
        this.width = i3;
        return this;
    }

    public CommandBarcode(String str, AttributesBarcode attributesBarcode) {
        this.command = TAG;
        this.hri = "none";
        this.font = 1;
        this.height = 162;
        this.width = 3;
        this.alignment = Constant.ALIGNMENT_LEFT;
        this.data = str;
        this.type = attributesBarcode.getType();
        this.hri = attributesBarcode.getHri();
        this.font = attributesBarcode.getFont();
        this.height = attributesBarcode.getHeight();
        this.width = attributesBarcode.getWidth();
        this.alignment = attributesBarcode.getAlignment();
    }
}
