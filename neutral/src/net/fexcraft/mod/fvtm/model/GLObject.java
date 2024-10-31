package net.fexcraft.mod.fvtm.model;

import net.fexcraft.lib.frl.GLO;
import net.fexcraft.mod.uni.IDL;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class GLObject extends GLO<GLObject> {

	public boolean textured = true;

	@Override
	public void copy(GLObject from, boolean full){
		super.copy(from, full);
		textured = from.textured;
	}

}
