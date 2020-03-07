package net.fexcraft.mod.fvtm.data.root;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.Axis3D;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3d;

/**
 * Part of first Prototype of "Swivel/Rotation Point" System.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class SwivelPoint {

	public final String id, parid;
	public String origin;
	public SwivelPoint parent;
	protected Vec3d position, prevpos; 
	private Axis3D axe = new Axis3D(), prevaxe = new Axis3D();

	public SwivelPoint(JsonObject obj){
		this.id = JsonUtil.getIfExists(obj, "id", "vehicle");
		this.position = obj.has("pos") ? Pos.fromJson(obj.get("pos"), true).to16Double() : new Vec3d(0, 0, 0);
		this.prevpos = new Vec3d(position.x, position.y, position.z);
		this.parid = obj.has("parent") ? obj.get("parent").getAsString() : "vehicle";
	}

	public SwivelPoint(String id, String parid){
		this.id = id;
		this.parid = parid;
		position = new Vec3d(0, 0, 0);
		prevpos = new Vec3d(0, 0, 0);
	}
	
	public SwivelPoint(NBTTagCompound com){
		this.id = com.getString("id");
		this.parid = com.hasKey("parent") ? com.getString("parent") : null;
		this.read(com);
	}

	public Axis3D getAxes(){
		return axe;
	}
	
	public Axis3D getPrevAxes(){
		return prevaxe;
	}

	public void updatePrevAxe(){
		prevaxe = axe.clone();
	}

	public void loadAxes(Entity entityfrom, NBTTagCompound compound){
		updatePrevAxe();
		axe = Axis3D.read(entityfrom, compound);
	}

	public NBTTagCompound saveAxes(Entity entityfrom, NBTTagCompound compound){
		return axe.write(entityfrom, compound);
	}

	public NBTTagCompound write(NBTTagCompound compound){
		compound.setString("id", id);
		compound.setString("parent", parent == null ? parid : parent.id);
		axe.write(null, compound);
		compound.setDouble("pos_x", position.x);
		compound.setDouble("pos_y", position.y);
		compound.setDouble("pos_z", position.z);
		return null;
	}

	public SwivelPoint read(NBTTagCompound com){
		SwivelPoint point = new SwivelPoint(com.getString("id"), com.getString("parent"));
		point.position = new Vec3d(com.getDouble("pos_x"), com.getDouble("pos_y"), com.getDouble("pos_z"));
		point.prevpos = new Vec3d(position.x, position.y, position.z);
		point.axe = Axis3D.read(null, com); point.prevaxe = point.axe.clone();
		return point;
	}

	public void linkToParent(VehicleData data){
		parent = data.getRotationPoint(parid);
		if(parent.id.equals(id)) parent = null;
	}

	public SwivelPoint clone(String string){
		SwivelPoint point = new SwivelPoint(id, parid);
		point.position = new Vec3d(position.x, position.y, position.z);
		point.prevpos = new Vec3d(prevpos.x, prevpos.y, prevpos.z);
		point.origin = string;
		point.axe = this.axe.clone();
		point.prevaxe = this.prevaxe.clone();
		return point;
	}

}
