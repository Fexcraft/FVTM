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
	public void openUI(String id, V3I pos){
		if(!id.startsWith("fvtm")){
			super.openUI(id, pos);
			return;
		}
		if(entity instanceof EntityPlayer == false) return;
		((EntityPlayer)entity).openGui(FVTM.getInstance(), UIKey.get(id), entity.world, pos.x, pos.y, pos.z);
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

	@Override
	public V3D getEyeVec(){
		Vec3d vec = Minecraft.getMinecraft().getRenderViewEntity().getPositionEyes(Minecraft.getMinecraft().getRenderPartialTicks());
		return new V3D(vec.x, vec.y, vec.z);
	}

	@Override
	public V3D getLookVec(){
		Vec3d vec = Minecraft.getMinecraft().getRenderViewEntity().getLook(Minecraft.getMinecraft().getRenderPartialTicks());
		return new V3D(vec.x, vec.y, vec.z);
	}

	@Override
	public boolean isShiftDown(){
		return entity.isSneaking();
	}

}
