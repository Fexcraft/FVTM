package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.Sign;
import net.fexcraft.mod.fvtm.data.SignData;
import net.fexcraft.mod.fvtm.sys.sign.SignInstance;
import net.fexcraft.mod.fvtm.sys.sign.SignSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SignContainer extends ContainerInterface {

	protected SignSystem system;
	protected SignInstance inst;
	protected ArrayList<SignData> signs = new ArrayList<>();

	public SignContainer(JsonMap map, UniEntity player, V3I pos){
		super(map, player, pos);
		try{
			system = SystemManager.get(SystemManager.Systems.SIGN, player.entity.getWorld());
			inst = system.get(pos);
			signs.addAll(inst.components);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void packet(TagCW com, boolean client){
		FvtmLogger.debug(com);
		String task = com.getString("task");
		switch(task){
			case "rem":{
				SignData sign = signs.remove(com.getInteger("idx"));
				if(sign != null){
					inst.components.remove(sign);
				}
				mirror(com, client);
				return;
			}
			case "copy":{
				SignData sign = signs.get(com.getInteger("idx"));
				if(sign != null){
					SignData data = new SignData(sign.getType()).read(sign.write(TagCW.create()));
					inst.components.add(data);
					signs.add(data);
				}
				mirror(com, client);
				return;
			}
			case "pos":{
				SignData sign = signs.get(com.getInteger("idx"));
				switch(com.getInteger("axis")){
					case 0: sign.offset.x = com.getFloat("value"); break;
					case 1: sign.offset.y = com.getFloat("value"); break;
					case 2: sign.offset.z = com.getFloat("value"); break;
					default: return;
				}
				if(!client) SEND_TO_CLIENT.accept(com, player);
				break;
			}
			case "rot":{
				SignData sign = signs.get(com.getInteger("idx"));
				switch(com.getInteger("axis")){
					case 0: sign.rotx = com.getFloat("value"); break;
					case 1: sign.roty = com.getFloat("value"); break;
					case 2: sign.rotz = com.getFloat("value"); break;
					default: return;
				}
				if(!client) SEND_TO_CLIENT.accept(com, player);
				break;
			}
			case "scale":{
				SignData sign = signs.get(com.getInteger("idx"));
				switch(com.getInteger("axis")){
					case 0: sign.sclx = com.getFloat("value"); break;
					case 1: sign.scly = com.getFloat("value"); break;
					case 2: sign.sclz = com.getFloat("value"); break;
					default: return;
				}
				if(!client) SEND_TO_CLIENT.accept(com, player);
				break;
			}
			case "tex":{
				SignData sign = signs.get(com.getInteger("idx"));
				int sel = com.getInteger("sel");
				if(sel >= 0 && sel < sign.getType().getDefaultTextures().size()){
					sign.getTexture().setSelectedTexture(sel, null, false);
					mirror(com, client);
				}
				break;
			}
			case "color":{
				SignData sign = signs.get(com.getInteger("idx"));
				sign.getColorChannel(com.getString("channel")).packed = com.getInteger("rgb");
				mirror(com, client);
				break;
			}
			case "text_center":{
				SignData sign = signs.get(com.getInteger("idx"));
				if(!sign.getType().isText()) return;
				sign.centered = !sign.centered;
				mirror(com, client);
				break;
			}
			case "text":{
				SignData sign = signs.get(com.getInteger("idx"));
				if(!sign.getType().isText()) return;
				sign.form = sign.text = com.getString("text");
				mirror(com, client);
				break;
			}
			case "side":{
				SignData sign = signs.get(com.getInteger("idx"));
				if(!sign.getType().isBase()) return;
				int i = com.getInteger("side");
				sign.sides[i] = !sign.sides[i];
				mirror(com, client);
				break;
			}
			case "width":{
				SignData sign = signs.get(com.getInteger("idx"));
				if(!sign.getType().isBase()) return;
				sign.width = com.getFloat("val");
				mirror(com, client);
				break;
			}
			case "height":{
				SignData sign = signs.get(com.getInteger("idx"));
				if(!sign.getType().isBase()) return;
				sign.height = com.getFloat("val");
				mirror(com, client);
				break;
			}
			case "rem_all":{
				inst.components.clear();
				inst.updateClient();
				signs.clear();
				mirror(com, client);
				break;
			}
			case "import":{
				Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
				Transferable data = cp.getContents(null);
				if(!data.isDataFlavorSupported(DataFlavor.stringFlavor)) return;
				try{
					String str = data.getTransferData(DataFlavor.stringFlavor).toString();
					if(!str.startsWith("[")) return;
					inst.components.clear();
					JsonArray array = JsonHandler.parse(str, false).asArray();
					for(JsonValue<?> val : array.value){
						try{
							JsonMap map = val.asMap();
							Sign type = FvtmRegistry.SIGNS.get(map.get("type").string_value());
							SignData sign = new SignData(type).parse(map);
							inst.components.add(sign);
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
					inst.updateClient();
					player.entity.openUI(UIKeys.SIGN_EDITOR, pos);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			}
			case "export":{
				try{
					JsonArray array = new JsonArray();
					for(SignData sign : signs){
						array.add(sign.toJson());
					}
					Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
					StringSelection sel = new StringSelection(JsonHandler.toString(array, JsonHandler.PrintOption.FLAT));
					cp.setContents(sel, new StringSelection("fvtm:sign"));
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			}
		}
	}

	private void mirror(TagCW com, boolean client){
		if(!client) SEND_TO_CLIENT.accept(com, player);
		else{
			((SignEditor)ui).select(0);
		}
	}

	@Override
	public void onClosed(){
		super.onClosed();
		if(inst != null && !player.entity.isOnClient()) inst.updateClient();
	}

}
