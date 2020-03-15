package net.fexcraft.mod.addons.hcp.scripts;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleScript;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class LCCScript extends VehicleScript {

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
		if(entity.world.isRemote) Print.chat(player, "toggled: " + attr.getStringValue() + " != " + oldvalue);
	};

}
