package rawbt.api.command;

import rawbt.api.Constant;
import rawbt.api.attributes.AttributesQRcode;

/* JADX INFO: loaded from: classes.dex */
public class CommandQRcode implements RawbtCommand {
    public static final String TAG = "qrcode";
    String alignment;
    String command;
    String data;
    int multiply;

    public CommandQRcode() {
        this.command = TAG;
        this.alignment = Constant.ALIGNMENT_LEFT;
        this.multiply = 3;
    }

    public String getAlignment() {
        return this.alignment;
    }

    public String getData() {
        return this.data;
    }

    public int getMultiply() {
        return this.multiply;
    }

    public CommandQRcode setAlignment(String str) {
        this.alignment = str;
        return this;
    }

    public CommandQRcode setData(String str) {
        this.data = str;
        return this;
    }

    public CommandQRcode setMultiply(int i3) {
        this.multiply = i3;
        return this;
    }

    public CommandQRcode(String str, AttributesQRcode attributesQRcode) {
        this.command = TAG;
        this.alignment = Constant.ALIGNMENT_LEFT;
        this.multiply = 3;
        this.data = str;
        this.alignment = attributesQRcode.getAlignment();
        this.multiply = attributesQRcode.getMultiply();
    }
}
