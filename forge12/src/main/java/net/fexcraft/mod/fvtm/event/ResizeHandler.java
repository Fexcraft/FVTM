package net.fexcraft.mod.fvtm.event;

import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ResizeHandler {

	public static final float SITH = 0.25f;//0.1875f;
	
    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event) throws Exception {
    	//if(event.phase == Phase.END) return;
		if(!resize(event.player)) event.player.eyeHeight = event.player.getDefaultEyeHeight();
    }
    
    @SubscribeEvent
    public void onTick(LivingEvent.LivingUpdateEvent event) throws Exception {
    	//if(event.phase == Phase.END) return;
		if(event.getEntity() instanceof EntityPlayer == false) resize(event.getEntity());
    }
    
    private boolean resize(Entity entity) throws Exception {
    	if(entity.getRidingEntity() instanceof GenericVehicle == false) return false;
    	SeatCache cache = null;//TODO ((GenericVehicle)entity.getRidingEntity()).getSeatOf(entity);
    	if(cache == null || cache.seatdata == null || cache.seatdata.scale == null) return false;
    	float width = entity.width * cache.seatdata.scale;
		float height = entity.height * cache.seatdata.scale;
		entity.ignoreFrustumCheck = true;
		boolean isplayer = entity instanceof EntityPlayer;
		if(isplayer){
			entity.width = width;
			entity.height = height;
		}
		float hw = width * 0.5f;
		entity.setEntityBoundingBox(new AxisAlignedBB(entity.posX - hw, entity.posY + (isplayer ? SITH : 0), entity.posZ - hw, entity.posX + hw, entity.posY + height + (isplayer ? SITH : 0), entity.posZ + hw));
        if(isplayer){
        	EntityPlayer player = (EntityPlayer)entity;
			player.eyeHeight = player.getDefaultEyeHeight() * cache.seatdata.scale;
			player.eyeHeight += SITH;
        }
        return true;
	}

	public static float getScale(Entity entity){
    	if(entity.getRidingEntity() instanceof GenericVehicle == false) return 1f;
    	SeatCache cache = null;//TODO ((GenericVehicle)entity.getRidingEntity()).getSeatOf(entity);
    	if(cache == null || cache.seatdata == null || cache.seatdata.scale == null) return 1f;
    	return cache.seatdata.scale;
	}
	
}
