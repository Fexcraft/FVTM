package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.V3D;
import org.lwjgl.opengl.GL11;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class GLUtils112 {

	public static void translate(V3D vec){
		GL11.glTranslated(vec.x, vec.y, vec.z);
	}

	public static void translateR(V3D vec){
		GL11.glTranslated(-vec.x, -vec.y, -vec.z);
	}

}
