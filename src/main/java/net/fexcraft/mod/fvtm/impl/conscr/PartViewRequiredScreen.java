package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class PartViewRequiredScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args) {
		if(button.isReturn()){
			tileentity.updateScreenId("part_menu");
		}
		if(button.isVerticalArrow()){
			tileentity.updateSelection(button == ConstructorButton.ARROW_UP ? -1 : 1, true);
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound) {
		for(int i = 0; i < tileentity.getRows(); i++){
			int j = i + tileentity.getScroll();
			if(j >= tileentity.getVehicleData().getVehicle().getRequiredParts().size()){
				compound.setString("Text" + i, "&7[&e" + j + "&7]");
			}
			else{
				String str = tileentity.getVehicleData().getVehicle().getRequiredParts().get(j);
				compound.setString("Text" + i, "&7[&" + (tileentity.getVehicleData().getParts().containsKey(str) ? "a" : "c") + j + "&7] " + str);
			}
		}
	}

}
