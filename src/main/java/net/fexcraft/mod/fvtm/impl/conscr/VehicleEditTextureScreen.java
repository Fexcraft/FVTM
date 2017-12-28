package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class VehicleEditTextureScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args){
		if(button.isReturn()){
			tileentity.updateScreenId("vehicle_menu");
		}
		if(button.isVerticalArrow()){
			tileentity.updateSelection(button == ConstructorButton.ARROW_UP ? -1 : 1);
		}
		Vehicle.VehicleData vehicledata = tileentity.getVehicleData();
		if(button.isSelect()){
			String str = vehicledata.getSelectedTexture() < 0 ? vehicledata.isTextureExternal() ? "external" : "internal" : "supplied";
			switch(tileentity.getSelection()){
				case 6:{
					switch(str){
						case "external":{
							vehicledata.setSelectedTexture(-1);
							vehicledata.setCustomTexture("minecraft:stone", false);
							//set to internal
							break;
						}
						case "internal":{
							vehicledata.setSelectedTexture(0);
							vehicledata.setCustomTexture("minecraft:stone", false);
							//set to normal
							break;
						}
						case "supplied":{
							vehicledata.setSelectedTexture(-1);
							vehicledata.setCustomTexture("http://fexcraft.net/webfiles/img/deftex.png", true);
							//set to external
							break;
						}
					}
					break;
				}
				case 7:{
					tileentity.openInputGui(player);
				}
			}
			tileentity.updateScreenId(tileentity.getScreenId(), false);
		}
		if(button.isHorizontalArrow() && tileentity.getSelection() == 7){
			String str = vehicledata.getSelectedTexture() < 0 ? vehicledata.isTextureExternal() ? "external" : "internal" : "supplied";
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
					int i = vehicledata.getSelectedTexture();
					i += button.isLeftArrow() ? -1 : 1;
					if(i < 0){
						i = 0;
					}
					if(i >= vehicledata.getVehicle().getTextures().size()){
						i = vehicledata.getVehicle().getTextures().size() - 1;
					}
					vehicledata.setSelectedTexture(i);
					break;
				}
			}
			tileentity.updateScreenId(tileentity.getScreenId(), false);
		}
		if(button.isInput() && tileentity.getSelection() == 7){
			String str = vehicledata.getSelectedTexture() < 0 ? vehicledata.isTextureExternal() ? "external" : "internal" : "supplied";
			switch(str){
				case "external":{
					vehicledata.setCustomTexture(args[0], true);
					break;
				}
				case "internal":{
					vehicledata.setCustomTexture(args[0], false);
					break;
				}
				case "supplied":{
					try{
						int i = Integer.parseInt(args[0]);
						if(i < 0){
							i = 0;
						}
						if(i >= vehicledata.getVehicle().getTextures().size()){
							i = vehicledata.getVehicle().getTextures().size() - 1;
						}
						vehicledata.setSelectedTexture(i);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					break;
				}
			}
			tileentity.updateScreenId(tileentity.getScreenId(), false);
		}
		tileentity.updateVehicleData(vehicledata);
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound){
		Vehicle.VehicleData vehicledata = tileentity.getVehicleData();
		compound.setString("Text0", "Vehicle Texture Editor");
		compound.setString("Text1", "- - - - - - - - - -");
		compound.setString("Text2", "Current Type: &3" + (vehicledata.getSelectedTexture() < 0 ? vehicledata.isTextureExternal() ? "external" : "internal" : "supplied"));
		compound.setString("Text3", "Selected Texture: &3" + (vehicledata.getSelectedTexture() < 0 ? vehicledata.isTextureExternal() ? "external" : "internal" : vehicledata.getSelectedTexture()));
		String str = vehicledata.getTexture().toString();
		compound.setString("Text4", "&e" + (str.length() > 27 ? ("..." + str.substring(str.length() - 27, str.length())) : str));
		compound.setString("Text5", "- - - - - - - - - -");
		compound.setString("Text6", "Change Type... &3(" + (vehicledata.getSelectedTexture() < 0 ? vehicledata.isTextureExternal() ? "e" : "c" : "s") + ")");
		compound.setString("Text7", (vehicledata.getSelectedTexture() < 0 ? vehicledata.isTextureExternal() ? "Enter URL..." : "Enter RS..." : (" &7[<[ &6" + (vehicledata.getSelectedTexture() + 1) + " / " + vehicledata.getVehicle().getTextures().size() + " &7]>]")));
	}

}
