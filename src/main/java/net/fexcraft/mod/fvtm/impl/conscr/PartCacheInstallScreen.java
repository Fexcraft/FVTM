package net.fexcraft.mod.fvtm.impl.conscr;

import jdk.nashorn.internal.objects.annotations.Constructor;
import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class PartCacheInstallScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args) {
		if(button.isReturn()){
			tileentity.updateScreenId("part_view_cache");
		}
		if(button.isVerticalArrow()){
			tileentity.updateSelection(button == ConstructorButton.ARROW_UP ? -1 : 1, true);
		}
		if(button.isSelect()){
			int sel = tileentity.getScroll() + tileentity.getSelection();
			Part.PartData data = tileentity.getPartData();
			if(sel >= data.getPart().getCategories().size()){
				return;
			}
			if(tileentity.getVehicleData().getParts().containsKey(data.getPart().getCategories().get(sel))){
				Print.chat(player, "Part of that category already installed.");
				return;
			}
			if(data.getPart().canInstall(data.getPart().getCategories().get(sel), tileentity.getVehicleData(), player)){
				tileentity.getVehicleData().installPart(data.getPart().getCategories().get(sel), data);
				tileentity.setPartData(null);
				tileentity.updateVehicleData(null);
				tileentity.updateScreenId("part_menu");
			}
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound) {
		if(tileentity.getPartData() == null){
			compound.setString("Text0", "ERROR: NO PART");
			fill(tileentity,1, compound);
			return;
		}
		//
		for(int i = 0; i < tileentity.getRows(); i++){
			int j = i + tileentity.getScroll();
			if(j >= tileentity.getPartData().getPart().getCategories().size()){
				compound.setString("Text" + i, "[" + j + "]");
			}
			else{
				compound.setString("Text" + i, "[" + j + "] " + tileentity.getPartData().getPart().getCategories().get(j));
			}
		}
	}

}
