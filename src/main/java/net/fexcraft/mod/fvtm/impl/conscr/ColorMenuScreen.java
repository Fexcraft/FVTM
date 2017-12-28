package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class ColorMenuScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args){
		if(button.isReturn()){
			tileentity.updateScreenId("main");
		}
		if(button.isVerticalArrow()){
			tileentity.updateSelection(button == ConstructorButton.ARROW_UP ? -1 : 1);
		}
		if(button.isSelect()){
			switch(tileentity.getSelection()){
				case 2:{
					tileentity.updateScreenId("colour_edit_primary");
					break;
				}
				case 3:{
					tileentity.updateScreenId("colour_edit_secondary");
					break;
				}
				case 4: case 5:{
					tileentity.updateScreenId("colour_unavailable");
					break;
				}
				case 7:{
					tileentity.updateScreenId("main");
					break;
				}
			}
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound) {
		compound.setString("Text0", "Vehicle Color Editor");
		compound.setString("Text1", "- - - - - - - - - -");
		compound.setString("Text2", "Primary");
		compound.setString("Text3", "Secondary");
		compound.setString("Text4", "Tertiary");
		compound.setString("Text5", "Quaternary");
		compound.setString("Text6", "- - - - - - - - - -");
		compound.setString("Text7", "Main Menu");
	}
	
}