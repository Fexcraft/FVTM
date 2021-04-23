package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ResizeUtil {

	public static final float SITH = 0.25f;//0.1875f;
	
    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event) throws Exception {
    	//if(event.phase == Phase.END) return;
		if(!resize(event.player, true)) event.player.eyeHeight = event.player.getDefaultEyeHeight();
    }
    
    @SubscribeEvent
    public void onTick(LivingEvent.LivingUpdateEvent event) throws Exception {
    	//if(event.phase == Phase.END) return;
		if(event.getEntity() instanceof EntityPlayer == false) resize(event.getEntity(), false);
    }
    
    private boolean resize(Entity entity, boolean eyes) throws Exception {
    	if(entity.getRidingEntity() instanceof GenericVehicle == false) return false;
    	SeatCache cache = ((GenericVehicle)entity.getRidingEntity()).getSeatOf(entity);
    	if(cache == null || cache.seatdata == null || cache.seatdata.scale == null) return false;
    	float width = entity.width *= cache.seatdata.scale;
		float height = entity.height *= cache.seatdata.scale;
		float hw = width * 0.5f;
		entity.setEntityBoundingBox(new AxisAlignedBB(entity.posX - hw, entity.posY + SITH, entity.posZ - hw, entity.posX + hw, entity.posY + height + SITH, entity.posZ + hw));
        //getMethod().invoke(player, width, height);
        if(eyes && entity instanceof EntityPlayer){
        	EntityPlayer player = (EntityPlayer)entity;
			player.eyeHeight = player.getDefaultEyeHeight() * cache.seatdata.scale;
			player.eyeHeight += SITH;
        }
        return true;
	}
	
	/*private static Method method = null;
	
	public static Method getMethod() throws NoSuchMethodException, SecurityException{
		if(method == null){
	        method = Entity.class.getDeclaredMethod(Static.dev() ? "setSize" : "func_70105_a", new Class[]{ float.class, float.class });
	        method.setAccessible(true);
		}
		return method;
	}*/

	public static float getScale(Entity entity){
    	if(entity.getRidingEntity() instanceof GenericVehicle == false) return 1f;
    	SeatCache cache = ((GenericVehicle)entity.getRidingEntity()).getSeatOf(entity);
    	if(cache == null || cache.seatdata == null || cache.seatdata.scale == null) return 1f;
    	return cache.seatdata.scale;
	}
	
}
