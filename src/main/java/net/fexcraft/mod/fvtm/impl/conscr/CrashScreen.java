package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class CrashScreen extends ConstructorScreen{

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
				case 2: case 4:{
					if(Static.side().isServer()){
						NBTTagCompound compound = new NBTTagCompound();
						compound.setString("task", "crash_menu_request");
						compound.setString("Message", "Sorry, this feature is disabled on Servers ;)");
						ApiUtil.sendTileEntityUpdatePacket((TileEntity)tileentity, compound, 256);
					}
					else{
						Static.halt();
					}
				}
				case 3:{
					tileentity.updateScreenId("null");
				}
			}
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound) {
		compound.setString("Text0", "Are you sure?");
		compound.setString("Text1", "- - - - - - - - - -");
		compound.setString("Text2", "Yes!");
		compound.setString("Text3", "No.");
		compound.setString("Text4", "I'd like to consult my Doc.");
		compound.setString("Text5", "- - - - - - - - - -");
		fill(tileentity,6, compound);
	}
}
