package rawbt.api.command;

import rawbt.api.attributes.AttributesString;

/* JADX INFO: loaded from: classes.dex */
public class CommandLeftRightText implements RawbtCommand {
    public static final String TAG = "leftRightText";
    String command;
    AttributesString leftAttr;
    int leftIndent;
    String leftText;
    AttributesString rightAttr;
    int rightIndent;
    String rightText;

    public CommandLeftRightText() {
        this.command = TAG;
        this.leftText = "";
        this.rightText = "";
        this.leftIndent = 0;
        this.rightIndent = 0;
        this.leftAttr = null;
        this.rightAttr = null;
    }

    public AttributesString getLeftAttr() {
        return this.leftAttr;
    }

    public int getLeftIndent() {
        return this.leftIndent;
    }

    public String getLeftText() {
        return this.leftText;
    }

    public AttributesString getRightAttr() {
        return this.rightAttr;
    }

    public int getRightIndent() {
        return this.rightIndent;
    }

    public String getRightText() {
        return this.rightText;
    }

    public CommandLeftRightText setLeftAttr(AttributesString attributesString) {
        this.leftAttr = attributesString;
        return this;
    }

    public CommandLeftRightText setLeftIndent(int i3) {
        this.leftIndent = i3;
        return this;
    }

    public CommandLeftRightText setLeftText(String str) {
        this.leftText = str;
        return this;
    }

    public CommandLeftRightText setRightAttr(AttributesString attributesString) {
        this.rightAttr = attributesString;
        return this;
    }

    public CommandLeftRightText setRightIndent(int i3) {
        this.rightIndent = i3;
        return this;
    }

    public CommandLeftRightText setRightText(String str) {
        this.rightText = str;
        return this;
    }

    public CommandLeftRightText(String str, String str2, AttributesString attributesString) {
        this.command = TAG;
        this.leftIndent = 0;
        this.rightIndent = 0;
        this.leftText = str;
        this.rightText = str2;
        this.leftAttr = attributesString;
        this.rightAttr = attributesString;
    }

    public CommandLeftRightText(String str, String str2, int i3, int i4, AttributesString attributesString, AttributesString attributesString2) {
        this.command = TAG;
        this.leftText = str;
        this.rightText = str2;
        this.leftIndent = i3;
        this.rightIndent = i4;
        this.leftAttr = attributesString;
        this.rightAttr = attributesString2;
    }
}
