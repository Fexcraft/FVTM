package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ResizeUtil {

	public static final float SITH = 0.25f;//0.1875f;
	
    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event) throws Exception {
    	//if(event.phase == Phase.END) return;
		if(!resize(event.player, true)) event.player.eyeHeight = event.player.getDefaultEyeHeight();
    }
    
    private boolean resize(EntityPlayer player, boolean eyes) throws Exception {
    	if(player.getRidingEntity() instanceof GenericVehicle == false) return false;
    	SeatCache cache = ((GenericVehicle)player.getRidingEntity()).getSeatOf(player);
    	if(cache == null || cache.seatdata == null || cache.seatdata.scale == null) return false;
    	float width = player.width *= cache.seatdata.scale;
		float height = player.height *= cache.seatdata.scale;
		float hw = width * 0.5f;
		player.setEntityBoundingBox(new AxisAlignedBB(player.posX - hw, player.posY + SITH, player.posZ - hw, player.posX + hw, player.posY + height + SITH, player.posZ + hw));
        //getMethod().invoke(player, width, height);
        if(eyes){
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

	public static float getScale(EntityPlayer player){
    	if(player.getRidingEntity() instanceof GenericVehicle == false) return 1f;
    	SeatCache cache = ((GenericVehicle)player.getRidingEntity()).getSeatOf(player);
    	if(cache == null || cache.seatdata == null || cache.seatdata.scale == null) return 1f;
    	return cache.seatdata.scale;
	}
	
}
