package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class FvtmInv {

	public ArrayList<String> access;
	public final InvType type;
	public String point;
	public V3D pos;

	protected FvtmInv(InvType type){
		this.type = type;
	}

	public void init0(JsonMap map){
		if(map.has("access")) access = map.getArray("access").toStringList();
		else access = new ArrayList<>();
	}

	public abstract <Inv extends FvtmInv> Inv init(JsonMap map);

	public abstract TagCW save(TagCW com, String ctag);

	public abstract void load(TagCW com, String ctag);

	public abstract <Inv extends FvtmInv> Inv copy();

	/** Drops inventory's content at this entity's location. */
	public abstract void clearAt(EntityW entity);

}
