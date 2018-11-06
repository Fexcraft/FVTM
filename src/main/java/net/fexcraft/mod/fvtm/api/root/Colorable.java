package net.fexcraft.mod.fvtm.api.root;

import net.fexcraft.lib.common.math.RGB;

public interface Colorable {
	
	public static final Colorable DEFAULT_IMPL = new Colorable(){
		@Override public RGB getPrimaryColor(){ return RGB.WHITE; }
		@Override public RGB getSecondaryColor(){ return RGB.BLACK; }
	};

    public RGB getPrimaryColor();

    public RGB getSecondaryColor();

    //
    public static interface ColorHolder {

        public RGB getDefPrimaryColor();

        public RGB getDefSecondaryolor();

    }

}
