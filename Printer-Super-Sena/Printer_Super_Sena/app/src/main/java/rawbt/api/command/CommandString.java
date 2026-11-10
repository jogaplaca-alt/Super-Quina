package rawbt.api.command;

import rawbt.api.attributes.AttributesString;

/* JADX INFO: loaded from: classes.dex */
public class CommandString implements RawbtCommand {
    public static final String TAG = "print";
    AttributesString attributesString;
    String command;
    String text;

    public CommandString() {
        this.command = TAG;
        this.text = "";
        this.attributesString = null;
    }

    public AttributesString getAttributesString() {
        return this.attributesString;
    }

    public String getText() {
        return this.text;
    }

    public void setAttributesString(AttributesString attributesString) {
        this.attributesString = attributesString;
    }

    public void setText(String str) {
        this.text = str;
    }

    public CommandString(String str, AttributesString attributesString) {
        this.command = TAG;
        this.text = str;
        this.attributesString = attributesString;
    }
}
