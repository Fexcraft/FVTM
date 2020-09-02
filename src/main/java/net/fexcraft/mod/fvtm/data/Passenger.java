package net.fexcraft.mod.fvtm.data;

import net.minecraft.entity.Entity;

public interface Passenger {
	
	public void set(int veh, int seat, boolean sync);
	
	public int vehicle();
	
	public int seat();

	public Entity entity();

}
