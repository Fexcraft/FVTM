package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.*;
import net.fexcraft.mod.fvtm.entities.LandVehicleEntity;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpawnAsScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args){
		if(button.isReturn()){
			tileentity.updateScreenId("main");
		}
		if(button.isVerticalArrow()){
			tileentity.updateSelection(button == ConstructorButton.ARROW_UP ? -1 : 1, true);
			return;
		}
		if(!button.isSelect()){
			return;
		}
		EntityType type = EntityType.byIndex((tileentity.getSelection() + tileentity.getScroll()) - 1);
		if(type == null || type == EntityType.NONE){
			Print.chat(player, "No Entity Type selected.");
			return;
		}
		try{
			Vehicle.VehicleData data = tileentity.getVehicleData();
			if(data == null){
				Print.chat(player, "ERROR NO DATA;");
				return;
			}
			if(!data.getVehicle().canSpawnAs(type)){
				Print.chat(player, "This vehicle cannot be spawned in the selected Entity Type.");
				return;
			}
			if(!data.getVehicle().getType().isLandVehicle()){
				Print.chat(player, "Currently only land vehicles can be spawned directly from Constructor.");
				return;
			}
			if(!data.readyToSpawn()){
				Print.chat(player, "&7Vehicle can not be spawned yet.");
				Print.chat(player, "&7Check if all &erequired &7parts are installed!");
				return;
			}
			if(data.getVehicle().isTrailerOrWagon()){
				Print.chat(player, "&7Cannot spawn Trailers from Constructor.");
				return;
			}
			if(data == null){
				Print.chat(player, "ER: C#NULL");
			}
			switch(type){
				case NONE:
					Print.chat(player, "Nothing to spawn.");
					break;
				case INTERNAL:{
					BlockPos center = tileentity.getCenterPos();
					World world = tileentity.getWorld();
					LandVehicleEntity ent = new LandVehicleEntity(world, center.getX() + 0.5d, center.getY() + (data.getVehicle().getYAxisConstructorOffset() / 16) + 1.5d, center.getZ() + 0.5d, world.getTileEntity(center).getBlockMetadata() + 1, data);
					world.spawnEntity(ent);
					tileentity.setVehicleData(null);
					tileentity.updateVehicleData(null);
					break;
				}
				case PROTOTYPE:{
					Print.chat(player, "Not available yet.");
					break;
				}
				default:{
					Print.chat(player, "&7Not available yet, use &aINTERNAL&7 instead!");
					break;
				}
			}

			/*this.liftstate = 0;
			this.updateLiftState();
			this.lift = 0;
			this.updateLift();*///TODO
			tileentity.updateScreenId("main");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound){
		compound.setString("Text0", "&bSpawn as&0: &7(entity type)");
		for(int i = 1; i < tileentity.getRows(); i++){
			int j =  (i + tileentity.getScroll()) - 1;
			if(j >= EntityType.values().length){
				compound.setString("Text" + i, "&c[&e" + j + "&c]&7#");
				continue;
			}
			EntityType enttype = EntityType.byIndex(j);
			compound.setString("Text" + i, "&c[&e" + j + "&c]> &7" + enttype.name());
		}
	}

}
