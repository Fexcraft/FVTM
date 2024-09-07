package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ToolboxTexture extends UserInterface {

	private ToolboxTextureContainer menu;

	public ToolboxTexture(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		menu = (ToolboxTextureContainer)con;
	}

	@Override
	public void init(){
		updateStatus();
	}

	protected void updateStatus(){
		if(menu.textureable.getSelected() < 0){
			texts.get("selected").value("...");
		}
		else{
			texts.get("selected").value(menu.texroot.getDefaultTextures().get(menu.textureable.getSelected()).name());
		}
		if(menu.textureable.isExternal()){
			fields.get("pack").text("");
			fields.get("url").text(menu.textureable.getCustom());
		}
		else{
			fields.get("pack").text(menu.textureable.getCustom());
			fields.get("url").text("");
		}
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int mb){
		switch(id){
			case "prev":{
				int sel = menu.textureable.getSelected();
				if(sel < 0) sel = 0;
				else if(sel == 0) sel = menu.texroot.getDefaultTextures().size() - 1;
				else sel--;
				TagCW com = TagCW.create();
				com.set("task", "select");
				com.set("sel", sel);
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			case "next":{
				int sel = menu.textureable.getSelected();
				if(sel < 0) sel = 0;
				else if(sel >= menu.texroot.getDefaultTextures().size() - 1) sel = 0;
				else sel++;
				TagCW com = TagCW.create();
				com.set("task", "select");
				com.set("sel", sel);
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			case "pack": {
				TagCW com = TagCW.create();
				com.set("task", "select");
				com.set("sel", -1);
				com.set("ext", false);
				com.set("tex", fields.get("pack").text());
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			case "url":{
				TagCW com = TagCW.create();
				com.set("task", "select");
				com.set("sel", -1);
				com.set("ext", true);
				com.set("tex", fields.get("url").text());
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			case "help":{
				container.get("open_wiki");
				break;
			}
			default:{
				break;
			}
		}
		return false;
	}

}
