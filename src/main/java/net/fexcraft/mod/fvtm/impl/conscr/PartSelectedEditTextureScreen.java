package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import java.util.Map;

public class PartSelectedEditTextureScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args) {
		if(button.isReturn()){
			tileentity.updateScreenId("part_view_selected");
		}
		if(button.isVerticalArrow()){
			tileentity.updateSelection(button == ConstructorButton.ARROW_UP ? -1 : 1);
		}
		if(button.isSelect()){
			Part.PartData data = ((Map.Entry<String, Part.PartData>)tileentity.getVehicleData().getParts().entrySet().toArray()[tileentity.getSelPart()]).getValue();
			switch(tileentity.getSelection()){
				case 6:{
					String str = data.getSelectedTexture() < 0 ? data.isTextureExternal() ? "external" : "internal" : "supplied";
					//Print.debug("PR: " + str);
					switch(str){
						case "external":{
							data.setSelectedTexture(-1);
							data.setCustomTexture("minecraft:stone", false);
							//set to internal
							break;
						}
						case "internal":{
							data.setSelectedTexture(0);
							data.setCustomTexture("minecraft:stone", false);
							//set to normal
							break;
						}
						case "supplied":{
							data.setSelectedTexture(-1);
							data.setCustomTexture("http://fexcraft.net/webfiles/img/deftex.png", true);
							//set to external
							break;
						}
					}
					//Print.debug("AF: " + (data.getSelectedTexture() < 0 ? data.isTextureExternal() ? "external" : "custom" : "supplied"));
					break;
				}
				case 7:{
					tileentity.openInputGui(player);
				}
			}
			tileentity.updateScreenId(tileentity.getScreenId(), false);
		}
		if(button.isHorizontalArrow() && tileentity.getSelection() == 7){
			Part.PartData data = ((Map.Entry<String, Part.PartData>)tileentity.getVehicleData().getParts().entrySet().toArray()[tileentity.getSelPart()]).getValue();
			String str = data.getSelectedTexture() < 0 ? data.isTextureExternal() ? "external" : "internal" : "supplied";
			switch(str){
				case "external":{
					Print.chat(player, "Use the select key to open the input window.");
					break;
				}
				case "internal":{
					Print.chat(player, "Use the select key to open the input window.");
					break;
				}
				case "supplied":{
					int i = data.getSelectedTexture();
					i += button.isLeftArrow() ? -1 : 1;
					if(i < 0){
						i = 0;
					}
					if(i >= data.getPart().getTextures().size()){
						i = data.getPart().getTextures().size() - 1;
					}
					data.setSelectedTexture(i);
					break;
				}
			}
			tileentity.updateScreenId(tileentity.getScreenId(), false);
		}
		if(button.isInput() && tileentity.getSelection() == 7){
			Part.PartData data = ((Map.Entry<String, Part.PartData>) tileentity.getVehicleData().getParts().entrySet().toArray()[tileentity.getSelPart()]).getValue();
			String str = data.getSelectedTexture() < 0 ? data.isTextureExternal() ? "external" : "internal" : "supplied";
			switch(str){
				case "external":{
					data.setCustomTexture(args[0], true);
					break;
				}
				case "internal":{
					data.setCustomTexture(args[0], false);
					break;
				}
				case "supplied":{
					try{
						int i = Integer.parseInt(args[0]);
						if(i < 0){
							i = 0;
						}
						if(i >= data.getPart().getTextures().size()){
							i = data.getPart().getTextures().size() - 1;
						}
						data.setSelectedTexture(i);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					break;
				}
			}
			tileentity.updateScreenId(tileentity.getScreenId(), false);
		}
		tileentity.updateVehicleData(tileentity.getVehicleData());
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound) {
		Map.Entry<String, Part.PartData> entry = (Map.Entry<String, Part.PartData>) tileentity.getVehicleData().getParts().entrySet().toArray()[tileentity.getSelPart()];
		if(entry == null){
			compound.setString("Text0", "ERROR: NO PART");
			fill(tileentity, 1, compound);
			return;
		}
		Part.PartData data = entry.getValue();
		compound.setString("Text0", "Part Texture Editor");
		compound.setString("Text1", "- - - - - - - - - -");
		compound.setString("Text2", "Current Type: &3" + (data.getSelectedTexture() < 0 ? data.isTextureExternal() ? "external" : "internal" : "supplied"));
		compound.setString("Text3", "Selected Texture: &3" + (data.getSelectedTexture() < 0 ? data.isTextureExternal() ? "external" : "internal" : data.getSelectedTexture()));
		String str = data.getTexture().toString();
		compound.setString("Text4", "&e" + (str.length() > 27 ? ("..." + str.substring(str.length() - 27, str.length())) : str));
		compound.setString("Text5", "- - - - - - - - - -");
		compound.setString("Text6", "Change Type... &3(" + (data.getSelectedTexture() < 0 ? data.isTextureExternal() ? "e" : "c" : "s") + ")");
		compound.setString("Text7", (data.getSelectedTexture() < 0 ? data.isTextureExternal() ? "Enter URL..." : "Enter RS..." : (" &7[<[ &6" + (data.getSelectedTexture() + 1) + " / " + data.getPart().getTextures().size() + " &7]>]")));
	}

}
