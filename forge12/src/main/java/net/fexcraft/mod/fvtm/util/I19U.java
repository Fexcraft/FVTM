package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.utils.Formatter;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * I18n Util -> I19U
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class I19U {
	
	@SideOnly(Side.CLIENT)
	public static String trsc(String str, Object... args){
		return Formatter.format(net.minecraft.client.resources.I18n.format(str, args));
	}
	
	@SuppressWarnings("deprecation")
	public static String trss(String str, Object... args){
		return Formatter.format(net.minecraft.util.text.translation.I18n.translateToLocalFormatted(str, args));
	}

}
