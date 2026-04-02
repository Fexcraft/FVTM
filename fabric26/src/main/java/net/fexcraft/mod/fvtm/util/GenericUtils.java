package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.utils.Formatter;
import net.minecraft.network.chat.Component;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class GenericUtils {

	public static Component format(String s){
		return Component.literal(Formatter.format(s));
	}

	public static Component format(String s, Object... args){
		return format(String.format(s, args));
	}

}