package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class InfoScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args){
		if(button.isReturn()){
			tileentity.updateScreenId("main");
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound) {
		compound.setString("Text0", "Welcome to the FVTM");
		compound.setString("Text1", "Vehicle Constructor!");
		compound.setString("Text2", "");
		compound.setString("Text3", "You can use this Block to");
		compound.setString("Text4", "build FVTM Land Vehicles.");
		fill(tileentity, 5, compound);
	}
	
}