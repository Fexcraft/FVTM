package net.fexcraft.mod.fvtm.sys.wire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.WireDeco;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.render.PathModelPositioned;
import net.fexcraft.mod.fvtm.sys.uni.Path;
import net.fexcraft.mod.fvtm.sys.uni.PathType;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Wire {

	public WireKey key, okey;
	public V3D start, end;
	public V3D[] rootpath = new V3D[3], vecpath;
	public float length;
	protected WireUnit unit;
	protected WireRelay relay;
	protected WireType type;
	public boolean copy;
	public float slack = 0;
	//
	public PathModelPositioned wiremodel;
	public double model_start_angle, model_end_angle;
	public double model_start_angle_down, model_end_angle_down;
	public WireDeco deco_s, deco_e;
	public String deco_start, deco_end;
	public HashMap<String, WireDeco> decos;
	public HashMap<String, HashMap<String, ArrayList<V3D>>> deco_d;
	public HashMap<String, HashMap<String, ArrayList<net.fexcraft.lib.tmt.ModelRendererTurbo>>> deco_g;
	
	public Wire(WireRelay relay, WireRelay relay0, WireType wiretype, V3D s_v, V3D e_v){
		key = new WireKey(relay, relay0);
		okey = new WireKey(relay0, relay);
		type = wiretype;
		slack = type.getDefaultSlack();
		rootpath = new V3D[]{ s_v, null, e_v };
		start = s_v;
		end = e_v;
		reslack();
	}

	public void reslack(){
		rootpath[0] = start;
		rootpath[1] = start.middle(end).add(0, -slack, 0);
		rootpath[2] = end;
		vecpath = new V3D[rootpath.length];
		construct();
	}
	
	public void construct(){
		vecpath = new V3D[rootpath.length];
		for(int i = 0; i < rootpath.length; i++){
			vecpath[i] = rootpath[i];
		}
		V3D[] vecs = curve(vecpath);
		vecpath = new V3D[vecs.length + 2];
		vecpath[0] = rootpath[0];
		for(int i = 0; i < vecs.length; i++){
			vecpath[i + 1] = vecs[i];
		}
		vecpath[vecpath.length - 1] = rootpath[2];
		this.length = this.calcLength();
	}
	
	public float getLength(V3D[] vecs){
		vecs = vecs == null ? vecpath : vecs;
		float temp = 0;
		for(int i = 0; i < vecs.length - 1; i++){
			temp += vecs[i].dis(vecs[i + 1]);
		}
		return temp;
	}
	
	protected float calcLength(){
		return getLength(null);
	}
	
	/** 
	 * Based on Curve method from Path.class
	 * @param vecpoints
	 * @return
	 */
	private V3D[] curve(V3D[] vecpoints){
		ArrayList<V3D> vecs = new ArrayList<V3D>();
		float length = getLength(vecpoints);
		float increment = 1 / length / type.getSegmentation();
		double d = 0; while(d < 1){
			V3D[] moved = vecpoints;
			while(moved.length > 2){
				V3D[] arr = new V3D[moved.length - 1];
				for(int i = 0; i < moved.length - 1; i++){
					arr[i] = Path.move(moved[i], moved[i + 1], moved[i].dis(moved[i + 1]) * d);
				}
				moved = arr;
			}
			d += increment;//0.0625//0.05;
			vecs.add(Path.move(moved[0], moved[1], moved[0].dis(moved[1]) * d));
		}
		return vecs.toArray(new V3D[0]);
	}

	/** Only for the READ process. @param relay just to make sure it's not used elsewhere */
	public Wire(WireRelay relay){
		super();
		this.relay = relay;
	}

	public Wire read(TagCW compound){
		if(compound.has("wiretype")) type = FvtmRegistry.WIRES.get(compound.getString("wiretype"));
		start = new V3D(compound.getFloat("sx"), compound.getFloat("sy"), compound.getFloat("sz"));
		end = new V3D(compound.getFloat("ex"), compound.getFloat("ey"), compound.getFloat("ez"));
		if(compound.has("slack")) slack = compound.getFloat("slack");
		reslack();
		construct();
		key = new WireKey(compound);
		okey = key.opposite();
		copy = compound.has("copy") && compound.getBoolean("copy");
		this.length = compound.has("length") ? compound.getFloat("length") : calcLength();
		//TODO if(relay != null) unit = getUnit(compound.getLong("section"));
		deco_start = compound.has("deco_start") ? compound.getString("deco_start") : null;
		deco_end = compound.has("deco_end") ? compound.getString("deco_end") : null;
		if(compound.has("decos")){
			if(decos == null) decos = new HashMap<>();
			TagLW list = compound.getList("decos");
			for(int i = 0; i < list.size(); i++){
				String[] split = list.getString(i).split(";");
				WireDeco deco = FvtmRegistry.WIREDECOS.get(split[1]);
				if(deco == null) continue;;
				decos.put(split[0], deco);
			}
		}
		else{
			if(decos != null) decos.clear();
		}
		if(relay.holder.getRegion().system.isRemote()){
			deco_d = null;
		}
		return this;
	}

	/*public WireUnit getUnit(Long knownid){
		WireUnit unit = relay.holder.region.system.getWireUnits().get(id.toUnitId(copy), knownid, true);
		if(copy) unit.copy = this;
		else unit.orig = this;
		return unit;
	}*///TODO

	public TagCW write(TagCW compound){
		if(compound == null) compound = TagCW.create();
		compound.set("sx", start.x);
		compound.set("sy", start.y);
		compound.set("sz", start.z);
		compound.set("ex", end.x);
		compound.set("ey", end.y);
		compound.set("ez", end.z);
		compound.set("slack", slack);
		compound.set("length", length);
		key.save(compound);
		if(copy) compound.set("copy", copy);
		if(type != null) compound.set("wiretype", type.getIDS());
		//TODO if(unit != null) compound.setLong("section", unit.getSectionId());
		if(deco_start != null) compound.set("deco_start", deco_start);
		if(deco_end != null) compound.set("deco_end", deco_end);
		if(decos != null && decos.size() > 0){
			TagLW list = TagLW.create();
			for(Entry<String, WireDeco> entry : decos.entrySet()){
				list.add(entry.getKey() + ";" + entry.getValue().getIDS());
			}
			compound.set("decos", list);
		}
		return compound;
	}
	
	public Wire copyTo(Wire wire){
		wire.key = okey;
		wire.okey = key;
		wire.start = end;
		wire.end = start;
		wire.copy = true;
		wire.type = type;
		wire.rootpath = new V3D[rootpath.length];
		wire.rootpath[0] = rootpath[2];
		wire.rootpath[1] = rootpath[1];
		wire.rootpath[2] = rootpath[0];
		wire.construct();
		wire.length = wire.calcLength();
		wire.slack = slack;
		return wire;
	}
	
	public Wire createOppositeCopy(){
		Wire wire = copyTo(new Wire(relay));
		wire.unit = unit;
		return wire;
	}
	
	public V3D getVectorPosition(double distance, boolean reverse){
		if(reverse) distance = this.oppositePassed(distance);
		if(distance >= this.length){
			return new V3D(vecpath[vecpath.length - 1]);
		}
		double traveled = 0, temp, multi;
		for(int i = 0; i < vecpath.length - 1; i++){
			temp = traveled + (multi = vecpath[i].dis(vecpath[i + 1]));
			if(temp >= distance){
				if(temp == distance) return new V3D(vecpath[i + 1]);
				return vecpath[i + 1].distance(vecpath[i], temp - distance);
			}
			else{
				traveled += multi;
			}
		}
		return new V3D(vecpath[0]);
	}

	public double oppositePassed(double sec){
		return sec >= length ? 0 : sec <= 0 ? length : this.length - sec;
	}
	
	@Override
	public String toString(){
		return String.format("Wire[%s-%s, %s, %s, %s]", start, end, vecpath.length, unit == null ? "n/u" : unit.getSectionId(), copy ? "copy" : "original");
	}
	
	public WireUnit getUnit(){
		return unit;
	}

	public PathType getType(){
		return PathType.WIRE;
	}
	
	public WireRelay getRelay(){
		return relay;
	}
	
	public WireType getWireType(){
		return type;
	}

	public V3D getVectorOnWire(V3D ext){
		V3D at = vecpath[0];
		double dis = ext.dis(vecpath[0]), tes;
		for(V3D vec : vecpath){
			if((tes = vec.dis(ext)) < dis){
				dis = tes;
				at = vec;
			}
		}
		return at;
	}
	
	public float getPassedOnWire(V3D ext){
		float passed = 0;
		V3D at = getVectorOnWire(ext), last = at;
		for(int i = 1; i < vecpath.length; i++){
			double dis = last.dis(vecpath[i]);
			if(dis < 0.001f) break;
			passed += dis;
		}
		return passed;
	}

}
