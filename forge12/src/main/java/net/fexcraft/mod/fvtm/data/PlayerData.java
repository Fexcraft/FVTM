package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;

/** @author Ferdinand Calo' (FEX___96) **/
public interface PlayerData {

	public void setPlayer(EntityPlayer player);
	
	public EntityPlayer getPlayer();
	
	public String getFavoriteSpawnSystemFor(VehicleType type);
	
	public boolean setFavoriteSpawnSystemFor(VehicleType type, String systemid);
	
	public void setActiveSpawnPoint(Vec3d vector);
	
	public Vec3d getActiveSpawnPoint();
	
}