package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.sys.deco.DecoInstance;
import net.fexcraft.mod.fvtm.sys.deco.DecoSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecoContainer extends ContainerInterface {

	protected DecoSystem system;
	protected ArrayList<DecorationData> decos = new ArrayList<>();
	protected DecoInstance inst;
	protected DecoEditor editor;

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
	public ContainerInterface set(UserInterface ui){
		editor = (DecoEditor)ui;
		return super.set(ui);
	}

	@Override
	public void packet(TagCW com, boolean client){
		if(decos.isEmpty()) return;
		String task = com.getString("task");
		DecorationData deco = decos.get(com.getInteger("deco"));
		switch(task){
			case "rem":{
				int idx = com.getInteger("deco");
				if(deco != null) inst.decorations.remove(deco);
				if(!client) SEND_TO_CLIENT.accept(com, player);
				else editor.select(idx >= decos.size() ? decos.size() - 1 : idx);
				return;
			}
			case "copy":{
				if(!player.entity.isCreative()){
					player.entity.send("ui.fvtm.decoration_editor.creative_only");
					return;
				}//TODO consume item
				if(deco != null){
					DecorationData data = new DecorationData(deco.getType()).read(deco.write(null));
					inst.decorations.add(data);
					decos.add(data);
				}
				if(!client) SEND_TO_CLIENT.accept(com, player);
				else editor.select(decos.size() - 1);
				return;
			}
			case "tex":{
				int sel = com.getInteger("sel");
				if(sel >= 0 && sel < deco.getType().getDefaultTextures().size()){
					deco.getTexture().setSelectedTexture(sel, null, false);
					if(!client) SEND_TO_CLIENT.accept(com, player);
					else editor.updateTexture();
				}
				break;
			}
			case "tex_ext":{
				deco.getTexture().setSelectedTexture(deco.getSelectedTexture(), deco.getCustomTexture(), com.getBoolean("ext"));
				if(!client) SEND_TO_CLIENT.accept(com, player);
				else editor.updateTexture();
				break;
			}
			case "tex_cus":{
				deco.getTexture().setSelectedTexture(-1, com.getString("custom"), deco.getTexture().isExternal());
				if(!client) SEND_TO_CLIENT.accept(com, player);
				else editor.updateTexture();
				break;
			}
			case "color":{
				RGB ch = deco.getColorChannel(com.getString("channel"));
				ch.packed = com.getInteger("rgb");
				if(!client) SEND_TO_CLIENT.accept(com, player);
				else editor.updateColor(ch, true);
				break;
			}
			case "pos":{
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
				switch(com.getInteger("axis")){
					case 0: deco.sclx = com.getFloat("value"); break;
					case 1: deco.scly = com.getFloat("value"); break;
					case 2: deco.sclz = com.getFloat("value"); break;
					default: return;
				}
				if(!client) SEND_TO_CLIENT.accept(com, player);
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
