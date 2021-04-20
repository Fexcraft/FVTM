package net.fexcraft.mod.fvtm.util;

import java.lang.reflect.Method;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ResizeUtil {

	public static final float SITH = 0.1875f;
	
    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event) throws Exception {
    	//if(event.phase == Phase.END) return;
		resize(event.player, true);
    }
    
    private void resize(EntityPlayer player, boolean eyes) throws Exception {
    	if(player.getRidingEntity() instanceof GenericVehicle == false) return;
    	SeatCache cache = ((GenericVehicle)player.getRidingEntity()).getSeatOf(player);
    	if(cache == null || cache.seatdata == null || cache.seatdata.scale == null) return;
    	float width = player.width * cache.seatdata.scale;
		float height = player.height * cache.seatdata.scale;
        getMethod().invoke(player, width, height);
        if(eyes){
			player.eyeHeight = player.getDefaultEyeHeight() * cache.seatdata.scale;
			player.eyeHeight += SITH;
        }
	}
	
	private static Method method = null;
	
	public static Method getMethod() throws NoSuchMethodException, SecurityException{
		if(method == null){
	        method = Entity.class.getDeclaredMethod(Static.dev() ? "setSize" : "func_70105_a", new Class[]{ float.class, float.class });
	        method.setAccessible(true);
		}
		return method;
	}

	public static float getScale(EntityPlayer player){
    	if(player.getRidingEntity() instanceof GenericVehicle == false) return 1f;
    	SeatCache cache = ((GenericVehicle)player.getRidingEntity()).getSeatOf(player);
    	if(cache == null || cache.seatdata == null || cache.seatdata.scale == null) return 1f;
    	return cache.seatdata.scale;
	}
	
}
