package rawbt.api.command;

import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesPdf;

/* JADX INFO: loaded from: classes.dex */
public class CommandPdfInBase64 implements RawbtCommand {
    public static final String TAG = "pdf64";
    AttributesImage attributesImage;
    AttributesPdf attributesPdf;
    String base64;
    String command;

    public CommandPdfInBase64() {
        this.command = TAG;
        this.attributesPdf = null;
        this.attributesImage = null;
    }

    public AttributesImage getAttributesImage() {
        return this.attributesImage;
    }

    public AttributesPdf getAttributesPdf() {
        return this.attributesPdf;
    }

    public String getBase64() {
        return this.base64;
    }

    public void setAttributesImage(AttributesImage attributesImage) {
        this.attributesImage = attributesImage;
    }

    public void setAttributesPdf(AttributesPdf attributesPdf) {
        this.attributesPdf = attributesPdf;
    }

    public void setBase64(String str) {
        this.base64 = str;
    }

    public CommandPdfInBase64(String str, AttributesPdf attributesPdf) {
        this.command = TAG;
        this.attributesImage = null;
        this.base64 = str;
        this.attributesPdf = attributesPdf;
        this.attributesImage = new AttributesImage(1);
    }

    public CommandPdfInBase64(String str, AttributesPdf attributesPdf, AttributesImage attributesImage) {
        this.command = TAG;
        this.base64 = str;
        this.attributesPdf = attributesPdf;
        this.attributesImage = attributesImage;
    }
}
