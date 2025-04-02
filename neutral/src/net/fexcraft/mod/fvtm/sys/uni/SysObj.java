package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.mod.uni.tag.TagCW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface SysObj {

	public TagCW write();

	public void read(TagCW com);

	public void update();

	public void delete();

}
