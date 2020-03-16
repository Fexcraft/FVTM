package net.fexcraft.mod.addons.hcp.scripts;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleScript;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class LCCScript extends VehicleScript {
	
	public boolean alright;

	@Override
	public String getId(){
		return "hcp:lcc";
	}

	@Override
	public String getName(){
		return "HCP LCC Script";
	}
	
	@Override
	public void onAttributeToggle(Entity entity, Attribute<?> attr, Object oldvalue, EntityPlayer player){
		if(entity.world.isRemote || attr == null) return;
		boolean bool;
		if(!attr.id().equals("lcc_catch")){
			if(!attr.id().equals("lcc_release")){
				return;
			}
			else bool = false;
		}
		else bool = true;
    	VehicleEntity ent = (VehicleEntity)entity;
    	if(ent.getVehicleData().getThrottle() > 0){
    		Print.chat(player, "&6Please stop the vehicle first!");
    		return;
    	}
    	if((int)(ent.getRotPoint().getAxes().getYaw()) % 90 != 0){
    		Print.chat(player, "&6Please make sure the crane is in a valid 90\u00B0 rotation!");
    		return;
    	}
    	if(bool){
    		tryCatch(ent, player);
    	}
    	else{
    		tryRelease(ent, player);
    	}
	}

	private void tryCatch(VehicleEntity ent, EntityPlayer player){
		// TODO Auto-generated method stub
		
	}

	private void tryRelease(VehicleEntity ent, EntityPlayer player){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpdate(Entity entity, VehicleData data){
    	VehicleEntity ent = (VehicleEntity)entity;
    	if(ent.getVehicleData().getThrottle() > 0){
    		alright = false;
    	}
	}
	
	

}
