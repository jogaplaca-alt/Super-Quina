package rawbt.api;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import java.util.ArrayList;
import rawbt.api.attributes.AttributesBarcode;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesPdf;
import rawbt.api.attributes.AttributesQRcode;
import rawbt.api.attributes.AttributesString;
import rawbt.api.command.CommandBarcode;
import rawbt.api.command.CommandBytesInBase64;
import rawbt.api.command.CommandCut;
import rawbt.api.command.CommandDelimiterImages;
import rawbt.api.command.CommandDrawLine;
import rawbt.api.command.CommandEmulate;
import rawbt.api.command.CommandImageInBase64;
import rawbt.api.command.CommandLeftRightText;
import rawbt.api.command.CommandNewLine;
import rawbt.api.command.CommandParcelable;
import rawbt.api.command.CommandQRcode;
import rawbt.api.command.CommandString;
import rawbt.api.command.RawbtCommand;

/* JADX INFO: loaded from: classes.dex */
public class RawbtPrintJob {
    public static final String ACTION_PRINT_JOB = "rawbt.action.PRINT";
    public static final String EXTRA_JOB = "rawbt.action.extra.JOB_JSON";
    public static final String PRINTER_CURRENT = "current";
    public static final String PRINTER_GALLERY = "save_into_gallery";
    public static final String PRINTER_RAW_TRANSFER = "raw_transfer";
    public static final String PRINTER_VIRTUAL = "virtual";
    public static final String TEMPLATE_DEFAULT = "default";
    public static final String TEMPLATE_NONE = "none";
    public static final String TEMPLATE_SIMPLE = "simple";
    String idJob = null;
    ArrayList<RawbtCommand> commands = new ArrayList<>();
    int copies = 1;
    String template = TEMPLATE_DEFAULT;
    String printer = PRINTER_CURRENT;
    AttributesString defaultAttrString = null;
    AttributesImage defaultAttrImage = null;
    AttributesPdf defaultAttrPdf = null;
    boolean premium = false;

    public String GSON() {
        return new p075w1.d().s(this);
    }

    public void add(RawbtCommand rawbtCommand) {
        this.commands.add(rawbtCommand);
    }

    public void barcode(CommandBarcode commandBarcode) {
        this.commands.add(commandBarcode);
    }

    public void bytes(Parcelable parcelable) {
        this.commands.add(new CommandParcelable(parcelable, Constant.RAWBT_CONTENT_TYPE.prn));
    }

    public void cut() {
        this.commands.add(new CommandCut());
    }

    public void delimiterImages() {
        add(new CommandDelimiterImages());
    }

    public void drawLine(Character ch) {
        this.commands.add(new CommandDrawLine(ch, getDefaultAttrString()));
    }

    public void emulate(Parcelable parcelable, String str) {
        this.commands.add(new CommandEmulate(parcelable, str));
    }

    public ArrayList<RawbtCommand> getCommands() {
        return this.commands;
    }

    public int getCopies() {
        return this.copies;
    }

    public AttributesImage getDefaultAttrImage() {
        AttributesImage attributesImage = this.defaultAttrImage;
        return attributesImage == null ? new AttributesImage() : attributesImage;
    }

    public AttributesPdf getDefaultAttrPdf() {
        AttributesPdf attributesPdf = this.defaultAttrPdf;
        return attributesPdf == null ? new AttributesPdf() : attributesPdf;
    }

    public AttributesString getDefaultAttrString() {
        AttributesString attributesString = this.defaultAttrString;
        return attributesString == null ? new AttributesString() : attributesString;
    }

    public String getIdJob() {
        return this.idJob;
    }

    public String getPrinter() {
        return this.printer;
    }

    public String getTemplate() {
        return this.template;
    }

    public void image(Parcelable parcelable) {
        image(parcelable, getDefaultAttrImage());
    }

    public void image64(Context context, Uri uri) {
        image64(context, uri, getDefaultAttrImage());
    }

    public boolean isNullDefaultAttrImage() {
        return this.defaultAttrImage == null;
    }

    public boolean isNullDefaultAttrPdf() {
        return this.defaultAttrPdf == null;
    }

    public boolean isNullDefaultAttrString() {
        return this.defaultAttrString == null;
    }

    public boolean isPremium() {
        return this.premium;
    }

    public void leftIndentRightText(int i3, String str, String str2) {
        CommandLeftRightText commandLeftRightText = new CommandLeftRightText(str, str2, getDefaultAttrString());
        commandLeftRightText.setLeftIndent(i3);
        this.commands.add(commandLeftRightText);
    }

    public void leftIndentRightTextWithFormat(int i3, String str, String str2, AttributesString attributesString) {
        CommandLeftRightText commandLeftRightText = new CommandLeftRightText(str, str2, attributesString);
        commandLeftRightText.setLeftIndent(i3);
        this.commands.add(commandLeftRightText);
    }

    public void leftRightIndentText(int i3, String str, String str2) {
        CommandLeftRightText commandLeftRightText = new CommandLeftRightText(str, str2, getDefaultAttrString());
        commandLeftRightText.setRightIndent(i3);
        this.commands.add(commandLeftRightText);
    }

    public void leftRightIndentTextWithFormat(int i3, String str, String str2, AttributesString attributesString) {
        CommandLeftRightText commandLeftRightText = new CommandLeftRightText(str, str2, attributesString);
        commandLeftRightText.setRightIndent(i3);
        this.commands.add(commandLeftRightText);
    }

    public void leftRightText(String str, String str2) {
        this.commands.add(new CommandLeftRightText(str, str2, getDefaultAttrString()));
    }

    public void leftRightTextWithBothFormat(String str, String str2, AttributesString attributesString, AttributesString attributesString2) {
        this.commands.add(new CommandLeftRightText(str, str2, 0, 0, attributesString, attributesString2));
    }

    public void leftRightTextWithFormat(String str, String str2, AttributesString attributesString) {
        this.commands.add(new CommandLeftRightText(str, str2, attributesString));
    }

    public void ln() {
        this.commands.add(new CommandNewLine(1));
    }

    public void pdf(Parcelable parcelable, AttributesPdf attributesPdf) {
        CommandParcelable commandParcelable = new CommandParcelable(parcelable, Constant.RAWBT_CONTENT_TYPE.pdf);
        commandParcelable.setAttributesPdf(attributesPdf);
        commandParcelable.setAttributesImage(getDefaultAttrImage());
        this.commands.add(commandParcelable);
    }

    public void println(String str) {
        this.commands.add(new CommandString(str, getDefaultAttrString()));
    }

    public void qrcode(CommandQRcode commandQRcode) {
        this.commands.add(commandQRcode);
    }

    public void sendBytes(String str) {
        this.commands.add(new CommandBytesInBase64(str));
    }

    public void setCommands(ArrayList<RawbtCommand> arrayList) {
        this.commands = arrayList;
    }

    public void setCopies(int i3) {
        this.copies = i3;
    }

    public void setDefaultAttrImage(AttributesImage attributesImage) {
        this.defaultAttrImage = attributesImage;
    }

    public void setDefaultAttrPdf(AttributesPdf attributesPdf) {
        this.defaultAttrPdf = attributesPdf;
    }

    public void setDefaultAttrString(AttributesString attributesString) {
        this.defaultAttrString = attributesString;
    }

    public void setIdJob(String str) {
        this.idJob = str;
    }

    public void setPremium(boolean z3) {
        this.premium = z3;
    }

    public void setPrinter(String str) {
        this.printer = str;
    }

    public void setTemplate(String str) {
        this.template = str;
    }

    public void text(Parcelable parcelable) {
        text(parcelable, getDefaultAttrString());
    }

    public void barcode(String str, AttributesBarcode attributesBarcode) {
        this.commands.add(new CommandBarcode(str, attributesBarcode));
    }

    public void drawLine(Character ch, AttributesString attributesString) {
        this.commands.add(new CommandDrawLine(ch, attributesString));
    }

    public void image(Parcelable parcelable, AttributesImage attributesImage) {
        CommandParcelable commandParcelable = new CommandParcelable(parcelable, Constant.RAWBT_CONTENT_TYPE.image);
        commandParcelable.setAttributesImage(attributesImage);
        this.commands.add(commandParcelable);
    }

    public void image64(Context context, Uri uri, AttributesImage attributesImage) {
        this.commands.add(new CommandImageInBase64(context, uri, attributesImage));
    }

    public void ln(int i3) {
        this.commands.add(new CommandNewLine(i3));
    }

    public void println(String str, AttributesString attributesString) {
        this.commands.add(new CommandString(str, attributesString));
    }

    public void qrcode(String str, AttributesQRcode attributesQRcode) {
        this.commands.add(new CommandQRcode(str, attributesQRcode));
    }

    public void text(Parcelable parcelable, AttributesString attributesString) {
        CommandParcelable commandParcelable = new CommandParcelable(parcelable, Constant.RAWBT_CONTENT_TYPE.txt);
        commandParcelable.setAttributesString(attributesString);
        this.commands.add(commandParcelable);
    }

    public void pdf(Parcelable parcelable, AttributesPdf attributesPdf, AttributesImage attributesImage) {
        CommandParcelable commandParcelable = new CommandParcelable(parcelable, Constant.RAWBT_CONTENT_TYPE.pdf);
        commandParcelable.setAttributesPdf(attributesPdf);
        commandParcelable.setAttributesImage(attributesImage);
        this.commands.add(commandParcelable);
    }
}
