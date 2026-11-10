package rawbt.api.command;

import rawbt.api.attributes.AttributesString;

/* JADX INFO: loaded from: classes.dex */
public class CommandDrawLine implements RawbtCommand {
    public static final String TAG = "line";
    AttributesString attributesString;
    Character ch;
    String command;

    public CommandDrawLine() {
        this.command = TAG;
        this.ch = '-';
        this.attributesString = new AttributesString();
    }

    public AttributesString getAttributesString() {
        return this.attributesString;
    }

    public Character getCh() {
        return this.ch;
    }

    public CommandDrawLine setAttributesString(AttributesString attributesString) {
        this.attributesString = attributesString;
        return this;
    }

    public CommandDrawLine setCh(Character ch) {
        this.ch = ch;
        return this;
    }

    public CommandDrawLine(Character ch, AttributesString attributesString) {
        this.command = TAG;
        this.ch = '-';
        new AttributesString();
        this.ch = ch;
        this.attributesString = attributesString;
    }
}
