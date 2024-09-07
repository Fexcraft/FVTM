package net.fexcraft.mod.uni.world;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.uni.ui.UIKey;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EntityWIE extends EntityWI implements Passenger {

	public EntityWIE(Entity ent){
		super(ent);
	}

	@Override
	public SeatInstance getSeatOn(){
		if(entity.getRidingEntity() instanceof RootVehicle == false) return null;
		return ((RootVehicle)entity.getRidingEntity()).getSeatOf(entity);
	}

	@Override
	public void set(int veh, int seatid){
		//
	}

	@Override
	public int vehicle(){
		return 0;
	}

	@Override
	public int seat(){
		return 0;
	}

}
