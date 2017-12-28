package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import java.util.Map;

public class PartViewSelectedScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args) {
		if(button.isReturn()){
			tileentity.updateScreenId("part_view_installed");
		}
		if(button.isVerticalArrow()){
			tileentity.updateSelection(button == ConstructorButton.ARROW_UP ? -1 : 1);
		}
		if(button.isSelect()){
			Map.Entry<String, Part.PartData> entry = (Map.Entry<String, Part.PartData>)tileentity.getVehicleData().getParts().entrySet().toArray()[tileentity.getSelPart()];
			switch(tileentity.getSelection()){
				case 4:{
					tileentity.updateScreenId("part_selected_edit_texture");
					break;
				}
				case 5:{
					tileentity.updateScreenId("part_selected_view_attributes");
					break;
				}
				case 6:{
					tileentity.updateScreenId("part_selected_edit_offset");
					break;
				}
				case 7:{
					//this.updateScreenId("part_selected_remove");
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
					break;
				}
			}
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound) {
		Map.Entry<String, Part.PartData> entry = (Map.Entry<String, Part.PartData>)tileentity.getVehicleData().getParts().entrySet().toArray()[tileentity.getSelPart()];
		if(entry == null){
			compound.setString("Text0", "ERROR: NO PART");
			fill(tileentity, 1, compound);
			return;
		}
		Part.PartData data = entry.getValue();
		compound.setString("Text0", "ID: " + data.getPart().getName());
		compound.setString("Text1", "RG: " + data.getPart().getRegistryName().toString());
		compound.setString("Text2", "IS: " + entry.getKey());
		compound.setString("Text3", "- - - - - - - - - -");
		compound.setString("Text4", "Edit Texture Settings");
		compound.setString("Text5", "Edit Attribute Settings");
		compound.setString("Text6", "Edit Offset");
		compound.setString("Text7", "Remove");
	}

}
