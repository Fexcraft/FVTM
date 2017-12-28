package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class ConstructorMenuScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args) {
		if(button.isReturn()){
			tileentity.updateScreenId("main");
		}
		if(button.isVerticalArrow()){
			tileentity.updateSelection(button == ConstructorButton.ARROW_UP ? -1 : 1);
		}
		if(button.isSelect() && tileentity.getSelection() == 7){
			tileentity.updateScreenId("constructor_connect_center");
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound) {
		compound.setString("Text0", "BlockPos: " + Static.toString(tileentity.getPos()));
		compound.setString("Text1", "Center Conn.: " + !(tileentity.getCenterPos() == null));
		compound.setString("Text2", "Center Pos: " + (tileentity.getCenterPos() == null ? "null" : Static.toString(tileentity.getCenterPos())));
		compound.setString("Text3", "- - - - - - - - - -");
		compound.setString("Text4", "Vehicle: " + (tileentity.getVehicleData() == null ? "null" : tileentity.getVehicleData().getVehicle().getName()));
		compound.setString("Text5", "Price: soon?");
		compound.setString("Text6", "- - - - - - - - - -");
		compound.setString("Text7", "Connect Center Block...");
	}

}
