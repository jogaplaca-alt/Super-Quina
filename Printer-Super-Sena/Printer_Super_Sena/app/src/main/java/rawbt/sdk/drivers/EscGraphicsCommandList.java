package rawbt.sdk.drivers;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class EscGraphicsCommandList extends ArrayList<String> {
    public EscGraphicsCommandList() {
        add("GS v 0 - default");
        add("ESC * 33 - (24 dot)If GSv0 does not work");
        add("GS * - Attention! Read the printer manual before.");
        add("ESC X - STAR (24 dot) fine density bit image");
        add("ESC X 4 - STAR Define user-defined bit image ");
        add("ESC k - STAR (24 dot) fine density bit image");
        add("ESC * 39 - Epson 180x180 dpi");
        add("ESC * 0 - (8 dot) matrix printers");
        add("ESC * 5 - (8 dot) matrix printers");
        add("ESC * 73 - 48 dots printers");
        add("ESC GS S - starPRNT");
        add("GSv0 Alternative ");
        add("GS 8 L - Epson modern ");
        add("GS ( L - Epson modern ");
        add("ESC * a - raster format ");
        add("GSv0 and Esc J");
    }
}
