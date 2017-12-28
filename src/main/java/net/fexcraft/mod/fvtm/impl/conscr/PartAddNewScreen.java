package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class PartAddNewScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args) {
		if(button.isReturn()){
			tileentity.updateScreenId("part_menu");
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound) {
		compound.setString("Text0", "- - - - - - - - - -");
		compound.setString("Text1", "Rightclick constructor with");
		compound.setString("Text2", "the part you want to adjust.");
		compound.setString("Text3", "(\"select part\")");
		compound.setString("Text4", "- - - - - - - - - -");
		fill(tileentity,5, compound);
		tileentity.setScroll(-1);
	}

}
