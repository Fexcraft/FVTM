package net.fexcraft.mod.fvtm.gui.deco;

import static net.fexcraft.mod.fvtm.FvtmRegistry.DECORATIONS;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.entity.Decoration;
import net.fexcraft.mod.fvtm.ui.DecoEditor;
import net.fexcraft.mod.uni.tag.TagCW;
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
			case "decos.at":{
				return entity.decos.get((int)objs[0]);
			}
		}
		return null;
	}

	@Override
	public void packet(TagCW com, boolean client){
		String task = com.getString("task");
		switch(task){
			case "add":{
				DecorationData deco = DECORATIONS.get(com.getString("key"));
				entity.decos.add(deco.copy());
				if(!client){
					SEND_TO_CLIENT.accept(com);
				}
				else{
					entity.decos.get(entity.decos.size() - 1).copy(deco);
					((DecoEditor)ui).updateEntries();
				}
				return;
			}
			case "rem":{
				entity.decos.remove(com.getInteger("idx"));
				if(!client){
					SEND_TO_CLIENT.accept(com);
				}
				else{
					((DecoEditor)ui).updateEntries();
					((DecoEditor)ui).select(-1, -1);
				}
				return;
			}
		}
	}

}
