package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.lib.common.math.RGB;

public interface Colorable {
	
	public RGB getPrimaryColor();
	
	public RGB getSecondaryColor();
	
	public void setPrimaryColor(RGB color);
	
	public void setSecondaryColor(RGB color);

}
