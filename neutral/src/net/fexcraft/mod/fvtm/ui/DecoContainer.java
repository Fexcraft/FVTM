package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.sys.deco.DecoInstance;
import net.fexcraft.mod.fvtm.sys.deco.DecoSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecoContainer extends ContainerInterface {

	protected DecoSystem system;
	protected ArrayList<DecorationData> decos = new ArrayList<>();
	protected DecoInstance inst;

	public DecoContainer(JsonMap map, UniEntity player, V3I pos){
		super(map, player, pos);
		try{
			system = SystemManager.get(SystemManager.Systems.DECO, player.entity.getWorld());
			inst = system.get(pos);
			decos.addAll(inst.decorations);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Object get(String key, Object... objs){
		switch(key){
			case "decos.size":{
				return decos.size();
			}
			case "decos.key":{
				return decos.get((int)objs[0]).getType().getIDS();
			}
			case "decos.at":{
				return decos.get((int)objs[0]);
			}
		}
		return null;
	}

	@Override
	public void packet(TagCW com, boolean client){
		String task = com.getString("task");
		switch(task){
			case "rem":{
				DecorationData deco = decos.remove(com.getInteger("idx"));
				if(deco != null) inst.decorations.remove(deco);
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
				DecorationData deco = decos.get(com.getInteger("idx"));
				V3D pos = null;
				switch(com.getInteger("axis")){
					case 0: pos = new V3D(com.getFloat("value"), deco.offset.y, deco.offset.z); break;
					case 1: pos = new V3D(deco.offset.x, com.getFloat("value"), deco.offset.z); break;
					case 2: pos = new V3D(deco.offset.x, deco.offset.y, com.getFloat("value")); break;
					default: return;
				}
				deco.offset = pos;
				if(!client) SEND_TO_CLIENT.accept(com, player);
				break;
			}
			case "rot":{
				DecorationData deco = decos.get(com.getInteger("idx"));
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
				DecorationData deco = decos.get(com.getInteger("idx"));
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
				DecorationData deco = decos.get(com.getInteger("idx"));
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
				DecorationData deco = decos.get(com.getInteger("idx"));
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
		super.onClosed();
		if(inst != null && !player.entity.isOnClient()) inst.updateClient();
	}

}
