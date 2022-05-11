package net.fexcraft.mod.fvtm.data;

import java.util.ArrayList;
import java.util.TreeMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
import net.fexcraft.mod.fvtm.util.Axes;
import net.fexcraft.mod.fvtm.util.handler.SPM_DI;
import net.fexcraft.mod.fvtm.util.packet.PKT_SPUpdate;
import net.fexcraft.mod.fvtm.util.packet.Packets;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

/**
 * Part of first Prototype of "Swivel/Rotation Point" System.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class SwivelPoint {

	public static final String DEFAULT = "vehicle";
	//
	public final String id, parid;
	public String origin;
	public SwivelPoint parent;
	protected Vec3d position, prevpos;//, prerot;
	private Axes axe = new Axes(), prevaxe = new Axes();
	// sync
	private static final int ticker = LandVehicle.servtick;
	private int servticker;
	private Vec3d servpos, servrot;
	//
	public ArrayList<SwivelPointMover> movers;

	public SwivelPoint(JsonObject obj){
		this.id = JsonUtil.getIfExists(obj, "id", DEFAULT);
		this.position = obj.has("pos") ? Pos.fromJson(obj.get("pos"), true).to16Double() : new Vec3d(0, 0, 0);
		this.prevpos = new Vec3d(position.x, position.y, position.z);
		this.parid = obj.has("parent") ? obj.get("parent").getAsString() : DEFAULT;
		axe.set_rotation(JsonUtil.getIfExists(obj, "yaw", 0).floatValue(), JsonUtil.getIfExists(obj, "pitch", 0).floatValue(), JsonUtil.getIfExists(obj, "roll", 0).floatValue(), true);
		if(obj.has("movers")){
			movers = new ArrayList<>();
			JsonElement movs = obj.get("movers");
			if(movs.isJsonObject()){
				movs.getAsJsonObject().entrySet().forEach(entry -> {
					parseMover(entry.getKey(), entry.getValue());
				});
			}
			else if(movs.isJsonArray()){
				movs.getAsJsonArray().forEach(elm -> {
					parseMover(null, elm);
				});
			}
		}
	}

	private void parseMover(String key, JsonElement elm){
		if(elm.isJsonPrimitive()){
			if(elm.getAsString().endsWith(".class")){
	            try{
	            	Class<? extends SwivelPointMover> clazz = (Class<? extends SwivelPointMover>)Class.forName(elm.getAsString().replace(".class", ""));
	            	movers.add(clazz.newInstance());
	            }
	            catch(Exception e){
	            	e.printStackTrace();
	            }
			}
			else movers.add(new SPM_DI(key == null ? "arrinit" : key, elm.getAsString()));
		}
		if(elm.isJsonObject()){
			JsonObject json = elm.getAsJsonObject();
			if(json.has("class")){
	            try{
	            	Class<? extends SwivelPointMover> clazz = (Class<? extends SwivelPointMover>)Class.forName(json.get("class").getAsString().replace(".class", ""));
	            	movers.add(clazz.getConstructor(JsonObject.class).newInstance(json));
	            }
	            catch(Exception e){
	            	e.printStackTrace();
	            }
			}
			else movers.add(new SPM_DI(json.getAsJsonObject()));
		}
	}

	public SwivelPoint(String id, String parid){
		this.id = id;
		this.parid = parid;
		position = new Vec3d(0, 0, 0);
		prevpos = new Vec3d(0, 0, 0);
	}

	public SwivelPoint(VehicleData data, NBTTagCompound com){
		this.id = com.getString("id");
		this.parid = com.hasKey("parent") ? com.getString("parent") : null;
		this.read(this, data, com);
	}

	public Axes getAxes(){
		return axe;
	}

	public Axes getPrevAxes(){
		return prevaxe;
	}

	public void updatePrevAxe(){
		prevaxe = axe.clone();
	}

	public void loadAxes(Entity entityfrom, NBTTagCompound compound){
		updatePrevAxe();
		axe = Axes.read(entityfrom, compound);
	}

	public NBTTagCompound saveAxes(Entity entityfrom, NBTTagCompound compound){
		return axe.write(entityfrom, compound);
	}

	public NBTTagCompound write(NBTTagCompound compound){
		compound.setString("id", id);
		compound.setString("parent", parent == null ? parid : parent.id);
		if(origin != null) compound.setString("origin", origin);
		axe.write(null, compound);
		compound.setDouble("pos_x", position.x);
		compound.setDouble("pos_y", position.y);
		compound.setDouble("pos_z", position.z);
		return compound;
	}

	public SwivelPoint read(SwivelPoint point, VehicleData data, NBTTagCompound com){
		if(point == null) point = new SwivelPoint(com.getString("id"), com.getString("parent"));
		point.origin = com.hasKey("origin") ? com.getString("origin") : null;
		point.position = new Vec3d(com.getDouble("pos_x"), com.getDouble("pos_y"), com.getDouble("pos_z"));
		point.prevpos = new Vec3d(point.position.x, point.position.y, point.position.z);
		point.axe = Axes.read(null, com);
		point.prevaxe = point.axe.clone();
		if(origin != null){
			PartData part = data.getPart(origin.split("\\|")[0]);
			if(part != null){
				cloneMovers(part.getType().getDefaultSwivelPoints());
			}
		}
		else{
			cloneMovers(data.getType().getDefaultSwivelPoints());
		}
		return point;
	}

	private void cloneMovers(TreeMap<String, SwivelPoint> points){
		SwivelPoint orig = points.get(id);
		if(orig != null){
			movers = orig.movers == null ? null : new ArrayList<>();
			if(movers != null){
				orig.movers.forEach(mover -> movers.add(mover.clone()));
			}
		}
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
		if(movers != null){
			point.movers = new ArrayList<>();
			for(SwivelPointMover mover : movers){
				point.movers.add(mover.clone());
			}
		}
		return point;
	}

	public Vec3d getPos(){
		return position;
	}

	public Vec3d getPrevPos(){
		return prevpos;
	}

	public void setPos(double posX, double posY, double posZ){
		prevpos = new Vec3d(position.x, position.y, position.z);
		position = new Vec3d(posX, posY, posZ);
	}

	public void updateClient(Entity entity){
		if(entity.world.isRemote) return;
		Packets.sendToAllAround(new PKT_SPUpdate(entity, this), entity);
	}

	public void update(VehicleEntity entity){
		if(isVehicle()) return;
		this.updatePrevAxe();
		prevpos = position;
		if(parent != null){
			//precalc = parent.getRelativeVector(position, false, false);
			//prerot = calcRelativeRot(null);
		}
		if(!entity.getEntity().world.isRemote && movers != null){
			for(SwivelPointMover mover : movers) mover.update(entity, this);
		}
		if(servticker <= 0) return;
		//Print.debug("update: " + servticker);
		//Print.debug(position + " / " + servpos);
		double x = position.x + (servpos.x - position.x) / servticker;
		double y = position.y + (servpos.y - position.y) / servticker;
		double z = position.z + (servpos.z - position.z) / servticker;
		setPos(x, y, z);
		double yaw = MathHelper.wrapDegrees(servrot.x - axe.deg_yaw());
		double pitch = MathHelper.wrapDegrees(servrot.y - axe.deg_pitch());
		double roll = MathHelper.wrapDegrees(servrot.z - axe.deg_roll());
		axe.set_rotation(axe.deg_yaw() + yaw / servticker, axe.deg_pitch() + pitch / servticker, axe.deg_roll() + roll / servticker, true);
		--servticker;
	}

	public void processPacket(PKT_SPUpdate pkt, boolean side){
		if(side){
			servpos = new Vec3d(pkt.posX, pkt.posY, pkt.posZ);
			servrot = new Vec3d(pkt.yaw, pkt.pitch, pkt.roll);
			servticker = ticker;
		}
		else{
			setPos(pkt.posX, pkt.posY, pkt.posZ);
			updatePrevAxe();
			getAxes().set_rotation(pkt.yaw, pkt.pitch, pkt.roll, true);
		}
	}

	public Vec3d getRelativeVector(double x, double y, double z){
		Vec3d rel = axe.get_vector((float)x, (float)y, (float)z);
		if(parent != null){
			return parent.getRelativeVector(position.x + rel.x, position.y + rel.y, position.z + rel.z);
		}
		return rel;
	}

	public Vec3d getRelativeVector(Vec3d vec){
		return getRelativeVector(vec.x, vec.y, vec.z);
	}

	public Vec3d getRelativeVector(Vec3d root, boolean render){
		Vec3d rel = axe.get_vector(root, isVehicle() ? 90 : 0);
		if(parent != null){
			Vec3d new0 = position.add(rel);
			if(parent.isVehicle() && render) return new0;
			return parent.getRelativeVector(new0, render);
		}
		return rel;
	}

	public Vec3d getPrevRelativeVector(Vec3d root, boolean render){
		Vec3d rel = prevaxe.get_vector(root, isVehicle() ? 90 : 0);
		if(parent != null){
			Vec3d new0 = prevpos.add(rel);
			if(parent.isVehicle() && render) return new0;
			return parent.getPrevRelativeVector(new0, render);
		}
		return rel;
	}

	// UNTESTED
	/*private Vec3d calcRelativeRot(Vec3d root){
		if(root == null){
			root = new Vec3d(axe.getYaw(), axe.getPitch(), axe.getRoll());
		}
		else{
			root = root.add(axe.getYaw(), axe.getPitch(), axe.getRoll());
		}
		if(parent != null && !parent.isVehicle()) root = parent.calcRelativeRot(root);
		return root;
	}

	public Vec3d getRelativeRot(){
		if(prerot == null) prerot = calcRelativeRot(null);
		return prerot;
	}*/

	public final boolean isVehicle(){
		return id.equals(DEFAULT);
	}

	public void sendClientUpdate(Entity entity){
    	if(movers == null) return;
    	boolean should = false;
    	for(SwivelPointMover mover : movers){
    		if(mover.shouldSendPacket()) should = true;
    	}
    	if(should) this.updateClient(entity);
	}

}
