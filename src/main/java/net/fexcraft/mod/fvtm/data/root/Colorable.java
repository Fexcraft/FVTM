package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.lib.common.math.RGB;

public interface Colorable {
	
	public RGB getPrimaryColor();
	
	public RGB getSecondaryColor();
	
	public void setPrimaryColor(RGB color);
	
	public void setSecondaryColor(RGB color);
	
	public static interface ColorHolder {
		
		public RGB getDefaultPrimaryColor();
		
		public RGB getDefaultSecondaryColor();
		
	}

}
