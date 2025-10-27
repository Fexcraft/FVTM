package net.fexcraft.mod.fvtm.data.vehicle;

import java.util.ArrayList;
import java.util.Map;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.packet.Packet_SPUpdate;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.fvtm.util.Pivot;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;

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
	public boolean detached;
	// sync
	private static final int ticker = 5;
	private int servticker;
	private V3D servpos, servrot;
	//
	public ArrayList<SwivelPointMover> movers;

	public SwivelPoint(String id, JsonMap map){
		this.id = id;
		position = map.has("pos") ? ContentConfigUtil.getVector(map.getArray("pos")) : new V3D();
		prevpos = position.copy();
		rid = map.getString("parent", DEFAULT);
		detached = map.getBoolean("detached", false);
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
			String type = map.getString("type", "default");
			switch(type){
				case "z_hyd":{
					movers.add(new ZHydSwivelPointMover(map));
					break;
				}
				case "default":
				default:
					movers.add(new DefaultSwivelPointMover(map));
					break;
			}
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
			else movers.add(new DefaultSwivelPointMover(key == null ? "arrinit" : key, json.string_value()));
		}
	}

	public SwivelPoint(String id, String rid){
		this.id = id;
		this.rid = rid;
		position = new V3D();
		prevpos = new V3D();
	}

	public SwivelPoint(VehicleData data, String id, TagCW com){
		this.id = id;
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
		cpivot = Pivot.load(com);
		updatePrevAxe();
	}

	public void savePivot(TagCW com){
		cpivot.save(com);
	}

	public TagCW write(TagCW compound){
		//compound.set("id", id);
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

	private void cloneMovers(Map<String, SwivelPoint> points){
		SwivelPoint orig = points.get(id);
		if(orig != null){
			movers = orig.movers == null ? null : new ArrayList<>();
			if(movers != null){
				orig.movers.forEach(mover -> movers.add(mover.clone()));
			}
		}
	}

	public void linkToParent(VehicleData data){
		if(isVehicle()) return;
		parent = data.getRotationPoint(rid);
		if(parent.id.equals(id)) parent = null;
		if(detached){
			if(!data.getRotationPoint(DEFAULT).subs.contains(this)){
				data.getRotationPoint(DEFAULT).subs.add(this);
			}
		}
		else{
			if(parent != null && !parent.subs.contains(this)) parent.subs.add(this);
		}
	}

	public SwivelPoint clone(String string){
		SwivelPoint point = new SwivelPoint(id, rid);
		point.position = new V3D(position.x, position.y, position.z);
		point.prevpos = new V3D(prevpos.x, prevpos.y, prevpos.z);
		point.detached = detached;
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

	public void update(VehicleInstance vehicle){
		if(this == vehicle.point) return;
		updatePrevAxe();
		prevpos = position;
		if(!vehicle.entity.isOnClient() && movers != null){
			for(SwivelPointMover mover : movers) mover.update(vehicle, this);
		}
		if(servticker <= 0) return;
		double x = position.x + (servpos.x - position.x) / servticker;
		double y = position.y + (servpos.y - position.y) / servticker;
		double z = position.z + (servpos.z - position.z) / servticker;
		setPos(x, y, z);
		double yaw = wrapdeg(servrot.x - cpivot.deg_yaw());
		double pitch = wrapdeg(servrot.y - cpivot.deg_pitch());
		double roll = wrapdeg(servrot.z - cpivot.deg_roll());
		cpivot.set_rotation(cpivot.deg_yaw() + yaw / servticker, cpivot.deg_pitch() + pitch / servticker, cpivot.deg_roll() + roll / servticker, true);
		--servticker;
	}

	private double wrapdeg(double deg){
		while(deg > 180f) deg -= 360f;
		while(deg < -180f) deg += 360f;
		return deg;
	}

	public void processPacket(Packet_SPUpdate pkt, boolean side){
		if(side){
			servpos = new V3D(pkt.posX, pkt.posY, pkt.posZ);
			servrot = new V3D(pkt.yaw, pkt.pitch, pkt.roll);
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

	public void sendUpdatePacket(EntityW entity){
    	if(movers == null) return;
    	boolean should = false;
    	for(SwivelPointMover mover : movers){
    		if(mover.shouldUpdate()){
				should = true;
				break;
			}
    	}
		if(!should) return;
		Packets.sendToAllTrackingEnt(Packet_SPUpdate.class, entity, entity, this);
	}

}
