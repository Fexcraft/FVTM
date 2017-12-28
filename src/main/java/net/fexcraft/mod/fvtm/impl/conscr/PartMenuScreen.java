package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class PartMenuScreen extends ConstructorScreen {

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
				case 2:{
					tileentity.updateScreenId("part_view_installed");
					break;
				}
				case 3:{
					tileentity.updateScreenId("part_view_required");
					break;
				}
				case 5:{
					if(tileentity.getPartData() != null){
						Print.chat(player, "Please drop the current part first.");
					}
					else{
						tileentity.updateScreenId("part_add_new");
					}
					break;
				}
				case 6:{
					tileentity.updateScreenId("part_view_cache");
					break;
				}
				case 7:{
					if(tileentity.getPartData() == null){
						Print.chat(player, "No part in constructor to drop.");
					}
					else{
						tileentity.getWorld().spawnEntity(new EntityItem(tileentity.getWorld(),
								tileentity.getPos().getX(), tileentity.getPos().getY() + 1.5f, tileentity.getPos().getZ(),
								tileentity.getPartData().getPart().getItemStack(tileentity.getPartData())));
						tileentity.setPartData(null);
						Print.chat(player, "Cache cleared.");
					}
					break;
				}
			}
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound) {
		compound.setString("Text0", "Part Editor");
		compound.setString("Text1", "- - - - - - - - - -");
		compound.setString("Text2", "View Installed Parts");
		compound.setString("Text3", "View Required Parts");
		compound.setString("Text4", "- - - - - - - - - -");
		compound.setString("Text5", "Select new Part");
		compound.setString("Text6", "Edit Selected Part");
		compound.setString("Text7", "Drop Selected Part");
	}

}
