package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import java.util.Map;

public class PartViewInstalledScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args){
		if(button.isReturn()){
			tileentity.updateScreenId("part_menu");
		}
		if(button.isVerticalArrow()){
			tileentity.updateSelection(button == ConstructorButton.ARROW_UP ? -1 : 1, true);
		}
		if(button.isSelect()){
			int sel = tileentity.getSelection() + tileentity.getScroll();
			Part.PartData data = (PartData)tileentity.getVehicleData().getParts().values().toArray()[sel];
			if(data != null){
				tileentity.setSelPart(sel);
				tileentity.updateScreenId("part_view_selected");
			}
		}
		if(button.isReset()){
			@SuppressWarnings("unchecked")
			Map.Entry<String, Part.PartData> entry = (Map.Entry<String, Part.PartData>) tileentity.getVehicleData().getParts().values().toArray()[tileentity.getSelPart()];
			if(entry.getValue().getPart().isRemovable()){
				tileentity.getVehicleData().getParts().remove(entry.getKey());
				//
				Part.PartData data = entry.getValue();
				Print.chat(player, "&7Part &c'" + data.getPart().getName() + "' &7removed from vehicle!");
				EntityItem item = new EntityItem(tileentity.getWorld());
				item.setItem(data.getPart().getItemStack(data));
				item.setPosition(tileentity.getPos().getX() + 0.5, tileentity.getPos().getY() + 1.5, tileentity.getPos().getZ() + 0.5);
				tileentity.getWorld().spawnEntity(item);
				tileentity.updateVehicleData(null);
			}
			else{
				Print.chat(player, "Part is marked as non-removable.");
			}
			tileentity.updateScreenId("part_view_installed");
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound){
		Object[] values = tileentity.getVehicleData().getParts().values().toArray();
		for(int i = 0; i < tileentity.getRows(); i++){
			int j = i + tileentity.getScroll();
			if(j >= tileentity.getVehicleData().getParts().size()){
				compound.setString("Text" + i, "[" + j + "]");
			}
			else{
				PartData data = (PartData)values[i];
				compound.setString("Text" + i, "[" + j + "] " + data.getPart().getName());
			}
		}
	}

}
