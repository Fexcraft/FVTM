package net.fexcraft.mod.fvtm.sys.signs;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SignInstance {

	public SignRegion region;
	public QV3D vec;

	public SignInstance(SignRegion reg){
		region = reg;
	}

	public SignInstance(SignRegion reg, QV3D pos){
		this(reg);
		vec = pos;
	}

	public void read(TagCW com){
		vec = new QV3D(com, "pos");

	}

	public TagCW write(){
		TagCW com = TagCW.create();
		vec.write(com, "pos");
		return com;
	}

	public void update(){
		//
	}

	public void delete(){
		//
	}

}
