package rawbt.sdk;

import java.lang.reflect.Type;
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
import rawbt.api.command.CommandPdfInBase64;
import rawbt.api.command.CommandQRcode;
import rawbt.api.command.CommandString;
import rawbt.api.command.RawbtCommand;

/* JADX INFO: loaded from: classes.dex */
public class RawbtCommandInstanceCreator implements p075w1.h {
    private static final String CLASSNAME = "command";

    public Class<? extends RawbtCommand> getObjectClass(String str) {
        if (CommandBytesInBase64.TAG.equals(str)) {
            return CommandBytesInBase64.class;
        }
        if (CommandImageInBase64.TAG.equals(str)) {
            return CommandImageInBase64.class;
        }
        if (CommandNewLine.TAG.equals(str)) {
            return CommandNewLine.class;
        }
        if (CommandParcelable.TAG.equals(str)) {
            return CommandParcelable.class;
        }
        if (CommandPdfInBase64.TAG.equals(str)) {
            return CommandPdfInBase64.class;
        }
        if (CommandString.TAG.equals(str)) {
            return CommandString.class;
        }
        if (CommandDelimiterImages.TAG.equals(str)) {
            return CommandDelimiterImages.class;
        }
        if (CommandCut.TAG.equals(str)) {
            return CommandCut.class;
        }
        if (CommandBarcode.TAG.equals(str)) {
            return CommandBarcode.class;
        }
        if (CommandQRcode.TAG.equals(str)) {
            return CommandQRcode.class;
        }
        if (CommandDrawLine.TAG.equals(str)) {
            return CommandDrawLine.class;
        }
        if (CommandLeftRightText.TAG.equals(str)) {
            return CommandLeftRightText.class;
        }
        if (CommandEmulate.TAG.equals(str)) {
            return CommandEmulate.class;
        }
        throw new p075w1.m("RawbtCommand not recognized");
    }

    @Override // p075w1.h
    public RawbtCommand deserialize(p075w1.i iVar, Type type, p075w1.g gVar) {
        p075w1.l lVarK = iVar.k();
        return (RawbtCommand) gVar.a(lVarK, getObjectClass(((p075w1.n) lVarK.s(CLASSNAME)).v()));
    }
}
