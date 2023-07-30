package net.fexcraft.mod.fvtm.gui.deco;

import static net.fexcraft.mod.fvtm.FvtmRegistry.DECORATIONS;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.entity.Decoration;
import net.fexcraft.mod.fvtm.ui.DecoEditor;
import net.fexcraft.mod.uni.Pos;
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
			case "pos":{
				DecorationData deco = entity.decos.get(com.getInteger("idx"));
				Pos pos = null;
				switch(com.getInteger("axis")){
					case 0: pos = new Pos(com.getFloat("value"), deco.offset.y, deco.offset.z); break;
					case 1: pos = new Pos(deco.offset.x, com.getFloat("value"), deco.offset.z); break;
					case 2: pos = new Pos(deco.offset.x, deco.offset.y, com.getFloat("value")); break;
					default: return;
				}
				deco.offset = pos;
				if(!client) SEND_TO_CLIENT.accept(com);
				break;
			}
			case "rot":{
				DecorationData deco = entity.decos.get(com.getInteger("idx"));
				switch(com.getInteger("axis")){
					case 0: deco.rotx = com.getFloat("value"); break;
					case 1: deco.roty = com.getFloat("value"); break;
					case 2: deco.rotz = com.getFloat("value"); break;
					default: return;
				}
				if(!client) SEND_TO_CLIENT.accept(com);
				break;
			}
			case "scale":{
				DecorationData deco = entity.decos.get(com.getInteger("idx"));
				switch(com.getInteger("axis")){
					case 0: deco.sclx = com.getFloat("value"); break;
					case 1: deco.scly = com.getFloat("value"); break;
					case 2: deco.sclz = com.getFloat("value"); break;
					default: return;
				}
				if(!client) SEND_TO_CLIENT.accept(com);
				break;
			}
		}
	}

}
