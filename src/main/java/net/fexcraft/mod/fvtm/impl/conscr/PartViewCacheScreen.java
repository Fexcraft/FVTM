package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class PartViewCacheScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args) {
		if(button.isReturn()){
			tileentity.updateScreenId("part_menu");
		}
		if(button.isVerticalArrow()){
			tileentity.updateSelection(button == ConstructorButton.ARROW_UP ? -1 : 1);
		}
		if(button.isSelect()){
			switch(tileentity.getSelection()){
				case 4:{
					//
					break;
				}
				case 5:{
					//
					break;
				}
				case 6:{
					//
					break;
				}
				case 7:{
					tileentity.updateScreenId("part_cache_install");
					break;
				}
			}
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound) {
		if(tileentity.getPartData() == null){
			compound.setString("Text0", "ERROR: NO PART");
			fill(tileentity, 1, compound);
			return;
		}
		compound.setString("Text0", "ID: " + tileentity.getPartData().getPart().getName());
		compound.setString("Text1", "RG: " + tileentity.getPartData().getPart().getRegistryName().toString());
		compound.setString("Text2", "MC: " + tileentity.getPartData().getPart().getCategory());
		compound.setString("Text3", "- - - - - - - - - -");
		compound.setString("Text4", "Edit Texture Settings");
		compound.setString("Text5", "Edit Attribute Settings");
		compound.setString("Text6", "Edit Offset");
		compound.setString("Text7", "Install as...");
	}

}
