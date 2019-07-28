package net.fexcraft.mod.fvtm.model;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class PartModel extends GenericModel<VehicleData, String> {

	public static final PartModel EMPTY = new PartModel();
    public static final RGB windowcolor = new RGB(0x007208).setAlpha(0.3f);
	public static final String[] defval = new String[]{
		"body", "body_colored_primary", "body_colored_secondary", "body_door_open", "body_door_close",
		"body_door_open_colored_primary", "body_door_close_colored_primary", "turret", "steering",
		//
		"wheels", "wheel_front", "wheel_back",
		"wheel_front_left", "wheel_back_left", "wheel_front_right", "wheel_back_right", 
		//
		"track_wheels", "track_wheels_right", "track_wheels_left",
		//
		"lights", "front_lights", "back_lights", "reverse_lights",
		"fog_lights", "turn_signal_left", "turn_signal_right",
		//
		"windows", "windows_door_open", "windows_door_close"
	};
	public static final String[] defval_bogie = new String[]{ "chassis", "axle0", "axle1", "axle2", "axle3" };
	
	////-///---/---///-////
	
	public PartModel(){ super(); }
	
	public PartModel(JsonObject obj){ super(obj); }
	
	public PartModel(String type, ResourceLocation loc){ super(type, loc); }

	@Override
	public void render(VehicleData data, String key){
		for(TurboList list : groups){
			list.render(null, data, data, key);
		}
	}

	@Override
	public void render(VehicleData data, String key, Entity ent, int meta){
		for(TurboList list : groups){
			list.render(ent, data, data, key);
		}
	}
	
}