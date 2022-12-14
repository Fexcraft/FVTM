package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.utils.Formatter;
import net.minecraft.client.resources.I18n;
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
	public static String trs(String str, Object... args){
		return Formatter.format(I18n.format(str, args));
	}

}
