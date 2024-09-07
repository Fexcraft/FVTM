package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.MessageSender;
import net.minecraft.entity.Entity;

public interface PassCap {
	
	public void set(int veh, int seat);
	
	public int vehicle();
	
	public int seat();

	public Entity entity();

	public void update_packet();

	public void reconn(boolean skipcheck);

	public MessageSender asSender();

	public Passenger asWrapper();

}
