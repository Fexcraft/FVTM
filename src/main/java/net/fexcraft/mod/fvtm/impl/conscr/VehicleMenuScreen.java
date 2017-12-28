package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class VehicleMenuScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args) {
		if(button.isReturn()){
			tileentity.updateScreenId("main");
		}
		if(button.isVerticalArrow()){
			tileentity.updateSelection(button == ConstructorButton.ARROW_UP ? -1 : 1);
		}
		if(button.isSelect()){
			switch(tileentity.getSelection()){
				case 5:{
					tileentity.updateScreenId("vehicle_edit_texture");
					break;
				}
				case 6:{
					tileentity.updateScreenId("vehicle_edit_wheelpos");
					break;
				}
				case 7:{
					Print.chat(player, "Empty Field.");
					break;
				}
			}
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound) {
		compound.setString("Text0", "Vehicle Editor");
		compound.setString("Text1", "- - - - - - - - - -");
		compound.setString("Text2", "ID: " + tileentity.getVehicleData().getVehicle().getName());
		compound.setString("Text3", "RG: " + tileentity.getVehicleData().getVehicle().getRegistryName().toString());
		compound.setString("Text4", "- - - - - - - - - -");
		compound.setString("Text5", "Edit Texture Settings");
		compound.setString("Text6", "Edit WheelPos");
		compound.setString("Text7", "Empty Field");
	}

}
