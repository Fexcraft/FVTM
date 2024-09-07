package net.fexcraft.mod.fvtm.data.root;

import java.util.Map;

import net.fexcraft.lib.common.math.RGB;

public interface Colorable {
	
	@Deprecated
	public default RGB getPrimaryColor(){
		return getColorChannel("primary");
	}

	@Deprecated
	public default RGB getSecondaryColor(){
		return getColorChannel("secondary");
	}
	
	public RGB getColorChannel(String channel);
	
	public void setColorChannel(String channel, RGB color);
	
	public Map<String, RGB> getColorChannels();
	
	public static interface ColorHolder {
		
		public RGB getDefaultColorChannel(String channel);
		
		public Map<String, RGB> getDefaultColorChannels();
		
	}

}
