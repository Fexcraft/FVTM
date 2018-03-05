package net.fexcraft.mod.fvtm.api.compatibility;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3d;

public class FMSeat {

	private Pos pos;
	private int id;
	public double maxyaw, minyaw;
	public double maxpitch, minpitch;
	public boolean sitting;
	
	public FMSeat(JsonObject obj){
		pos = Pos.fromJSON(obj);
		id = JsonUtil.getIfExists(obj, "id", -1).intValue();
		if(obj.has("driver") && obj.get("driver").getAsBoolean()){
			id = 0;
		}
		maxyaw = JsonUtil.getIfExists(obj, "max_yaw", 360).doubleValue();
		minyaw = JsonUtil.getIfExists(obj, "min_yaw", -360).doubleValue();
		maxpitch = JsonUtil.getIfExists(obj, "max_pitch", 89).doubleValue();
		minpitch = JsonUtil.getIfExists(obj, "min_pitch", -89).doubleValue();
		sitting = JsonUtil.getIfExists(obj, "sitting", true);
	}

	public Pos getPos(){
		return pos;
	}
	
	public int getId(){
		return id;
	}
	
	public boolean isDriver(){
		return id == 0;
	}
	
	@Override
	public final String toString(){
		return new Vec3d(pos.x, pos.y, pos.z).toString();
	}

	public NBTTagCompound write(NBTTagCompound nbt){
		nbt.setFloat("posx", pos.x);
		nbt.setFloat("posy", pos.y);
		nbt.setFloat("posz", pos.z);
		nbt.setDouble("maxyaw", maxyaw);
		nbt.setDouble("minyaw", minyaw);
		nbt.setDouble("maxpitch", maxpitch);
		nbt.setDouble("minpitch", minpitch);
		nbt.setBoolean("sitting", sitting);
		return nbt;
	}
	
	public FMSeat(NBTTagCompound nbt){
		pos = new Pos(nbt.getFloat("posx"), nbt.getFloat("posy"), nbt.getFloat("posz"));
		maxyaw = nbt.getDouble("maxyaw");
		minyaw = nbt.getDouble("minyaw");
		maxpitch = nbt.getDouble("maxpitch");
		minpitch = nbt.getDouble("minpitch");
		sitting = nbt.getBoolean("sitting");
	}
	
}