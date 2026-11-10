package rawbt.api.command;

import android.os.Parcelable;
import rawbt.api.Constant;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesPdf;
import rawbt.api.attributes.AttributesString;

/* JADX INFO: loaded from: classes.dex */
public class CommandParcelable implements RawbtCommand {
    public static final String TAG = "stream";
    String parcelable;
    Constant.RAWBT_CONTENT_TYPE type;
    String command = TAG;
    AttributesImage attributesImage = null;
    AttributesPdf attributesPdf = null;
    AttributesString attributesString = null;

    public CommandParcelable(Parcelable parcelable, Constant.RAWBT_CONTENT_TYPE rawbt_content_type) {
        this.type = rawbt_content_type;
        this.parcelable = parcelable.toString();
    }

    public AttributesImage getAttributesImage() {
        return this.attributesImage;
    }

    public AttributesPdf getAttributesPdf() {
        return this.attributesPdf;
    }

    public AttributesString getAttributesString() {
        return this.attributesString;
    }

    public String getParcelable() {
        return this.parcelable;
    }

    public Constant.RAWBT_CONTENT_TYPE getType() {
        return this.type;
    }

    public void setAttributesImage(AttributesImage attributesImage) {
        this.attributesImage = attributesImage;
    }

    public void setAttributesPdf(AttributesPdf attributesPdf) {
        this.attributesPdf = attributesPdf;
    }

    public void setAttributesString(AttributesString attributesString) {
        this.attributesString = attributesString;
    }

    public void setParcelable(String str) {
        this.parcelable = str;
    }

    public void setType(Constant.RAWBT_CONTENT_TYPE rawbt_content_type) {
        this.type = rawbt_content_type;
    }
}
