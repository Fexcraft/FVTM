package net.fexcraft.mod.fvtm.gui.block;

public enum GBCElm {

    HEAD(false, 0, 16, true),
    SPACER(false, 106, 14, true),
    FOOTER(false, 120, 23, true),
    ITEMVIEW(false, 86, 20, true),
    //
    ELM_FULL_TEXT(false, 16, 14, true),
    ELM_LEFT_TEXT(false, 30, 14, false),
    ELM_RIGHT_TEXT(true, 30, 14, false),
    //ELM_TWO_BUTTONS(false, 58, 14, true),
    ELM_LEFT_BUTTON(false, 58, 14, false),
    ELM_RIGHT_BUTTON(true, 58, 14, false),
    ELM_FULL_CLEAR(false, 72, 14, true),
    ELM_LEFT_CLEAR(false, 72, 14, false),
    ELM_RIGHT_CLEAR(true, 72, 14, false),
    //ELM_TWO_PROGRESS(false, 44, 14, true),
    ELM_LEFT_PROGRESS(false, 44, 14, false),
    ELM_RIGHT_PROGRESS(true, 44, 14, false),
    ;

    public int x, y, h;
    public boolean middle, full;

    GBCElm(boolean central, int sy, int sh, boolean isfull){
        x = (middle = central) ? 128 : 0;
        y = sy;
        h = sh;
        full = isfull;
    }

    public static GBCElm by(String str){
        if(!str.startsWith("ELM_")) str = "ELM_" + str;
        for(GBCElm elm : GBCElm.values()){
            if(elm.name().equalsIgnoreCase(str)) return elm;
        }
        return null;
    }
}
