package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.Decoration;
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
		String task = com.getString("task");
		if(task.equals("import_all")){
			try{
				JsonArray arr = JsonHandler.parse(com.getString("cb"), true).asMap().getArray("decos");
				for(JsonValue<?> jsn : arr.value){
					try{
						JsonMap map = jsn.asMap();
						Decoration dt = FvtmRegistry.DECORATIONS.get(map.get("type").string_value());
						DecorationData nd = new DecorationData(dt).parse(map);
						inst.decorations.add(nd);
						decos.add(nd);
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				if(!client) mirror(com);
				else editor.select(decos.size() - 1);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return;
		}
		if(decos.isEmpty()) return;
		DecorationData deco = decos.get(com.getInteger("deco"));
		switch(task){
			case "rem":{
				int idx = com.getInteger("deco");
				if(deco != null){
					inst.decorations.remove(deco);
					if(!client && !player.entity.isCreative()){
						player.entity.getWorld().drop(deco.getNewStack(), inst.vec.vec);
					}
				}
				if(!client) mirror(com);
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
				if(!client) mirror(com);
				else editor.select(decos.size() - 1);
				return;
			}
			case "tex":{
				int sel = com.getInteger("sel");
				if(sel >= 0 && sel < deco.getType().getDefaultTextures().size()){
					deco.getTexture().setSelectedTexture(sel, null, false);
					if(!client) mirror(com);
					else editor.updateTexture();
				}
				break;
			}
			case "tex_ext":{
				deco.getTexture().setSelectedTexture(deco.getSelectedTexture(), deco.getCustomTexture(), com.getBoolean("ext"));
				if(!client) mirror(com);
				else editor.updateTexture();
				break;
			}
			case "tex_cus":{
				deco.getTexture().setSelectedTexture(-1, com.getString("custom"), deco.getTexture().isExternal());
				if(!client) mirror(com);
				else editor.updateTexture();
				break;
			}
			case "color":{
				RGB ch = deco.getColorChannel(com.getString("channel"));
				ch.packed = com.getInteger("rgb");
				if(!client) mirror(com);
				else editor.updateColor(ch, true);
				break;
			}
			case "rem_all":{
				if(!client && !player.entity.isCreative()){
					for(DecorationData d : inst.decorations){
						player.entity.getWorld().drop(d.getNewStack(), inst.vec.vec);
					}
				}
				inst.decorations.clear();
				decos.clear();
				if(!client) mirror(com);
				else editor.select(-1);
				break;
			}
			case "pos":{
				V3D pos;
				switch(com.getString("axe")){
					case "x": pos = new V3D(com.getFloat("val"), deco.offset.y, deco.offset.z); break;
					case "y": pos = new V3D(deco.offset.x, com.getFloat("val"), deco.offset.z); break;
					case "z": pos = new V3D(deco.offset.x, deco.offset.y, com.getFloat("val")); break;
					default: return;
				}
				deco.offset = pos;
				if(!client) mirror(com);
				break;
			}
			case "rot":{
				switch(com.getString("axe")){
					case "x": deco.rotx = com.getFloat("val"); break;
					case "y": deco.roty = com.getFloat("val"); break;
					case "z": deco.rotz = com.getFloat("val"); break;
					default: return;
				}
				if(!client) mirror(com);
				break;
			}
			case "scl":{
				switch(com.getString("axe")){
					case "x": deco.sclx = com.getFloat("val"); break;
					case "y": deco.scly = com.getFloat("val"); break;
					case "z": deco.sclz = com.getFloat("val"); break;
					default: return;
				}
				if(!client) mirror(com);
				break;
			}
			case "reset":{
				deco.offset.set(0, 0, 0);
				deco.rotx = deco.roty = deco.rotz = 0;
				deco.sclx = deco.scly = deco.sclz = 1;
				if(!client) mirror(com);
				else editor.select(editor.sel_idx);
				break;
			}
			case "import_val":{
				try{
					deco.readTransformJson(JsonHandler.parse(com.getString("cb"), true).asMap());
					if(!client) mirror(com);
					else editor.select(editor.sel_idx);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			}
		}
	}

	private void mirror(TagCW com){
		SEND_TO_CLIENT.accept(com, player);
	}

	@Override
	public void onClosed(){
		super.onClosed();
		if(inst != null && !player.entity.isOnClient()) inst.updateClient();
	}

}
