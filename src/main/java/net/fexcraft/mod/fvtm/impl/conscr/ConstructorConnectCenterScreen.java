package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class ConstructorConnectCenterScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args) {
		if(button.isReturn()){
			tileentity.updateScreenId("constructor_menu");
		}
		if(button.isVerticalArrow()){
			tileentity.updateSelection(button == ConstructorButton.ARROW_UP ? -1 : 1);
		}
		if(button.isSelect()){
			switch(tileentity.getSelection()){
				case 2:{
					if(tileentity.getCenterPos() != null && tileentity.getWorld().getTileEntity(tileentity.getCenterPos()) != null){
						Print.chat(player, "&7Old Connected Center Block still exists!");
						Print.chat(player, "&7Remove it to proceed.");
					}
					else{
						((ConstructorControllerEntity)tileentity).scanAndConnect(player);
					}
					break;
				}
				case 3:{
					Print.chat(player, "Method not avaiable yet.");
					//TO-DO
					break;
				}
				case 4:{
					if(tileentity.getCenterPos() != null && tileentity.getWorld().getTileEntity(tileentity.getCenterPos()) != null){
						Print.chat(player, "Resetting...");
						NBTTagCompound nbt = new NBTTagCompound();
						nbt.setBoolean("reset", true);
						ApiUtil.sendTileEntityUpdatePacket(tileentity.getWorld(), tileentity.getCenterPos(), nbt);
					}
					else{
						Print.chat(player, "No TileEntity at that position found!");
						Print.chat(player, "Clearing settings anyways.");
					}
					tileentity.updateScreenId("main");
					tileentity.setCenterPos(null);
					break;
				}
			}
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound) {
		compound.setString("Text0", "Constructor Connector");
		compound.setString("Text1", "- - - - - - - - - -");
		compound.setString("Text2", "Scan for Center Blocks");
		compound.setString("Text3", "Manual input");
		compound.setString("Text4", "Reset");
		fill(tileentity,5, compound);
	}

}
