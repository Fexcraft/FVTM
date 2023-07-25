package net.fexcraft.mod.fvtm.gui.deco;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.entity.Decoration;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecoContainer extends ContainerInterface {

	protected Decoration entity;
	protected DecorationData selected;

	public DecoContainer(JsonMap map, World world, int entid) {
		super(map);
		entity = (Decoration)world.getEntityByID(entid);
	}

	@Override
	public Object get(String key, Object... objs){
		switch(key){
			case "decos.size":{
				return entity.decos.size();
			}
			case "decos.key":{
				return entity.decos.get((int)objs[0]).key();
			}
		}
		return null;
	}

}
