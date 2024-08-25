package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.entity.DecorationEntity;
import net.fexcraft.mod.uni.Pos;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecoContainer extends ContainerInterface {

	protected DecorationEntity entity;
	protected DecorationData selected;

	public DecoContainer(JsonMap map, EntityPlayer player, int entid){
		super(map, UniEntity.get(player), new V3I(entid, 0, 0));
		entity = (DecorationEntity)player.world.getEntityByID(entid);
	}

	@Override
	public Object get(String key, Object... objs){
		switch(key){
			case "decos.size":{
				return entity.decos.size();
			}
			case "decos.key":{
				return entity.decos.get((int)objs[0]).getType().getIDS();
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
				/*DecorationData deco = DECORATIONS.get(com.getString("key"));
				entity.decos.add(deco.copy());
				if(!client){
					SEND_TO_CLIENT.accept(com, player);
				}
				else{
					entity.decos.get(entity.decos.size() - 1).copy(deco);
					((DecoEditor)ui).updateEntries();
				}*///TODO
				return;
			}
			case "rem":{
				entity.decos.remove(com.getInteger("idx"));
				if(!client){
					SEND_TO_CLIENT.accept(com, player);
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
				if(!client) SEND_TO_CLIENT.accept(com, player);
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
				if(!client) SEND_TO_CLIENT.accept(com, player);
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
				if(!client) SEND_TO_CLIENT.accept(com, player);
				break;
			}
			case "tex":{
				DecorationData deco = entity.decos.get(com.getInteger("idx"));
				int sel = com.getInteger("sel");
				if(sel >= 0 && sel < deco.getType().getDefaultTextures().size()){
					deco.getTexture().setSelectedTexture(sel, null, false);
					if(!client) SEND_TO_CLIENT.accept(com, player);
					else{
						DecoEditor editor = (DecoEditor)ui;
						editor.select(editor.selected, editor.selcol);
					}
				}
				break;
			}
			case "color":{
				DecorationData deco = entity.decos.get(com.getInteger("idx"));
				deco.getColorChannel(com.getString("channel")).packed = com.getInteger("rgb");
				if(!client) SEND_TO_CLIENT.accept(com, player);
				else{
					DecoEditor editor = (DecoEditor)ui;
					editor.select(editor.selected, editor.selcol);
				}
				break;
			}
		}
	}

	@Override
	public void onClosed(){
		if(entity != null && !entity.world.isRemote){
			entity.updateClient();
		}
	}

}
