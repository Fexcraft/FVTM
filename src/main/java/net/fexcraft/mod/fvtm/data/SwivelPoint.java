package net.fexcraft.mod.fvtm.data;

import java.util.ArrayList;
import java.util.TreeMap;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.util.Pivot;
import net.fexcraft.mod.fvtm.util.handler.SPM_DI;
import net.fexcraft.mod.fvtm.util.packet.PKT_SPUpdate;
import net.fexcraft.mod.fvtm.util.packet.Packets;
import net.fexcraft.mod.uni.Pos;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.entity.Entity;
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
	public final String id;
	public final String rid;
	public String origin;
	public SwivelPoint parent;
	public V3D position;
	public V3D prevpos;
	private Pivot cpivot = new Pivot();
	private Pivot ppivot = new Pivot();
	public ArrayList<SwivelPoint> subs = new ArrayList<>();
	// sync
	private static final int ticker = 5;
	private int servticker;
	private Vec3d servpos, servrot;
	//
	public ArrayList<SwivelPointMover> movers;

	public SwivelPoint(JsonMap map){
		id = map.getString("id", DEFAULT);
		position = map.has("pos") ? Pos.frJson(map.get("pos"), true).toV3D() : new V3D();
		prevpos = position.copy();
		rid = map.getString("parent", DEFAULT);
		cpivot.set_rotation(map.getFloat("yaw", 0), map.getFloat("pitch", 0), map.getFloat("roll", 0), true);
		if(map.has("movers")){
			movers = new ArrayList<>();
			JsonValue movs = map.get("movers");
			if(movs.isMap()){
				movs.asMap().entries().forEach(entry -> {
					parseMover(entry.getKey(), entry.getValue());
				});
			}
			else if(movs.isArray()){
				movs.asArray().value.forEach(val -> {
					parseMover(null, val);
				});
			}
		}
	}

	private void parseMover(String key, JsonValue json){
		if(json.isMap()){
			JsonMap map = json.asMap();
			if(map.has("class")){
	            try{
	            	Class<? extends SwivelPointMover> clazz = (Class<? extends SwivelPointMover>)Class.forName(map.get("class").string_value().replace(".class", ""));
	            	movers.add(clazz.getConstructor(JsonValue.class).newInstance(map));
	            }
	            catch(Exception e){
	            	e.printStackTrace();
	            }
			}
			else movers.add(new SPM_DI(map));
		}
		else if(!json.isArray()){
			if(json.string_value().endsWith(".class")){
				try{
					Class<? extends SwivelPointMover> clazz = (Class<? extends SwivelPointMover>)Class.forName(json.string_value().replace(".class", ""));
					movers.add(clazz.newInstance());
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			else movers.add(new SPM_DI(key == null ? "arrinit" : key, json.string_value()));
		}
	}

	public SwivelPoint(String id, String rid){
		this.id = id;
		this.rid = rid;
		position = new V3D();
		prevpos = new V3D();
	}

	public SwivelPoint(VehicleData data, TagCW com){
		id = com.getString("id");
		rid = com.has("parent") ? com.getString("parent") : null;
		read(this, data, com);
	}

	public Pivot getPivot(){
		return cpivot;
	}

	public Pivot getPrevPivot(){
		return ppivot;
	}

	public void updatePrevAxe(){
		ppivot.copy(cpivot);
	}

	public void loadPivot(TagCW com){
		updatePrevAxe();
		cpivot = Pivot.load(com);
	}

	public void savePivot(TagCW com){
		cpivot.save(com);
	}

	public TagCW write(TagCW compound){
		compound.set("id", id);
		compound.set("parent", parent == null ? rid : parent.id);
		if(origin != null) compound.set("origin", origin);
		cpivot.save(compound);
		compound.set("pos_x", position.x);
		compound.set("pos_y", position.y);
		compound.set("pos_z", position.z);
		return compound;
	}

	public SwivelPoint read(SwivelPoint point, VehicleData data, TagCW com){
		if(point == null) point = new SwivelPoint(com.getString("id"), com.getString("parent"));
		point.origin = com.has("origin") ? com.getString("origin") : null;
		point.position = new V3D(com.getDouble("pos_x"), com.getDouble("pos_y"), com.getDouble("pos_z"));
		point.prevpos = new V3D(point.position.x, point.position.y, point.position.z);
		point.cpivot = Pivot.load(com);
		point.ppivot.copy(cpivot);
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
		parent = data.getRotationPoint(rid);
		if(parent.id.equals(id)) parent = null;
		if(parent != null && !parent.subs.contains(this)) parent.subs.add(this);
	}

	public SwivelPoint clone(String string){
		SwivelPoint point = new SwivelPoint(id, rid);
		point.position = new V3D(position.x, position.y, position.z);
		point.prevpos = new V3D(prevpos.x, prevpos.y, prevpos.z);
		point.origin = string;
		point.cpivot = cpivot.copy();
		point.ppivot = ppivot.copy();
		if(movers != null){
			point.movers = new ArrayList<>();
			for(SwivelPointMover mover : movers){
				point.movers.add(mover.clone());
			}
		}
		return point;
	}

	public V3D getPos(){
		return position;
	}

	public V3D getPrevPos(){
		return prevpos;
	}

	public void setPos(double posX, double posY, double posZ){
		prevpos = new V3D(position.x, position.y, position.z);
		position = new V3D(posX, posY, posZ);
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
		double yaw = MathHelper.wrapDegrees(servrot.x - cpivot.deg_yaw());
		double pitch = MathHelper.wrapDegrees(servrot.y - cpivot.deg_pitch());
		double roll = MathHelper.wrapDegrees(servrot.z - cpivot.deg_roll());
		cpivot.set_rotation(cpivot.deg_yaw() + yaw / servticker, cpivot.deg_pitch() + pitch / servticker, cpivot.deg_roll() + roll / servticker, true);
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
			cpivot.set_rotation(pkt.yaw, pkt.pitch, pkt.roll, true);
		}
	}

	public V3D getRelativeVector(double x, double y, double z){
		V3D rel = cpivot.get_vector(x, y, z);
		if(parent != null){
			return parent.getRelativeVector(position.x + rel.x, position.y + rel.y, position.z + rel.z);
		}
		return rel;
	}

	public V3D getRelativeVector(V3D vec){
		return getRelativeVector(vec.x, vec.y, vec.z);
	}

	public V3D getPrevRelativeVector(V3D root){
		V3D rel = ppivot.get_vector(root);
		if(parent != null){
			return parent.getPrevRelativeVector(prevpos.add(rel));
		}
		return rel;
	}

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
