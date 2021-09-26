package net.fexcraft.mod.fvtm.sys.wire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.model.WireModel;
import net.fexcraft.mod.fvtm.render.RailRenderer.TurboArrayPositioned;
import net.fexcraft.mod.fvtm.sys.uni.Path;
import net.fexcraft.mod.fvtm.sys.uni.PathType;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Wire {

	public WireKey key, okey;
	public Vec3f start, end;
	public Vec3f[] rootpath = new Vec3f[3], vecpath;
	public float length;
	protected WireUnit unit;
	protected WireRelay relay;
	protected WireType type;
	public boolean copy;
	//
	@SideOnly(Side.CLIENT)
	public TurboArrayPositioned wiremodel;
	public float model_start_angle, model_end_angle;
	public float model_start_angle_down, model_end_angle_down;
	@SideOnly(Side.CLIENT)
	public WireModel deco_s, deco_e;
	public String deco_start, deco_end;
	public HashMap<String, String> decos;
	@SideOnly(Side.CLIENT)
	public HashMap<String, WireModel> deco_m;
	@SideOnly(Side.CLIENT)
	public HashMap<String, HashMap<String, ArrayList<Vec3f>>> deco_d;
	@SideOnly(Side.CLIENT)
	public HashMap<String, HashMap<String, ArrayList<ModelRendererTurbo>>> deco_g;
	public float slack = 1;
	
	public Wire(WireRelay relay, WireRelay relay0, WireType wiretype, Vec3f s_v, Vec3f e_v){
		key = new WireKey(relay, relay0);
		okey = new WireKey(relay0, relay);
		type = wiretype;
		slack = type.default_slack();
		rootpath = new Vec3f[]{ s_v, null, e_v };
		start = s_v;
		end = e_v;
		reslack();
	}

	public void reslack(){
		rootpath[0] = start;
		rootpath[1] = start.middle(end).add(0, -slack, 0);
		rootpath[2] = end;
		vecpath = new Vec3f[rootpath.length];
		construct();
	}
	
	public void construct(){
		vecpath = new Vec3f[rootpath.length];
		for(int i = 0; i < rootpath.length; i++){
			vecpath[i] = rootpath[i];
		}
		Vec3f[] vecs = curve(vecpath);
		vecpath = new Vec3f[vecs.length + 2];
		vecpath[0] = rootpath[0];
		for(int i = 0; i < vecs.length; i++){
			vecpath[i + 1] = vecs[i];
		}
		vecpath[vecpath.length - 1] = rootpath[2];
		this.length = this.calcLength();
	}
	
	public float getLength(Vec3f[] vecs){
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
	private Vec3f[] curve(Vec3f[] vecpoints){
		ArrayList<Vec3f> vecs = new ArrayList<Vec3f>();
		float length = getLength(vecpoints);
		float increment = 1 / length / Config.WIRE_SEGMENTATOR;
		double d = 0; while(d < 1){
			Vec3f[] moved = vecpoints;
			while(moved.length > 2){
				Vec3f[] arr = new Vec3f[moved.length - 1];
				for(int i = 0; i < moved.length - 1; i++){
					arr[i] = Path.move(moved[i], moved[i + 1], moved[i].dis(moved[i + 1]) * d);
				}
				moved = arr;
			}
			d += increment;//0.0625//0.05;
			vecs.add(Path.move(moved[0], moved[1], moved[0].dis(moved[1]) * d));
		}
		return vecs.toArray(new Vec3f[0]);
	}

	/** Only for the READ process. @param relay just to make sure it's not used elsewhere */
	public Wire(WireRelay relay){
		super();
		this.relay = relay;
	}

	public Wire read(NBTTagCompound compound){
		if(compound.hasKey("wiretype")) type = Resources.WIRES.getValue(new ResourceLocation(compound.getString("wiretype")));
		start = new Vec3f(compound.getFloat("sx"), compound.getFloat("sy"), compound.getFloat("sz"));
		end = new Vec3f(compound.getFloat("ex"), compound.getFloat("ey"), compound.getFloat("ez"));
		if(compound.hasKey("slack")) slack = compound.getFloat("slack");
		reslack();
		construct();
		key = new WireKey(compound);
		okey = key.opposite();
		this.length = compound.hasKey("length") ? compound.getFloat("length") : calcLength();
		//TODO if(relay != null) unit = getUnit(compound.getLong("section"));
		deco_start = compound.hasKey("deco_start") ? compound.getString("deco_start") : null;
		deco_end = compound.hasKey("deco_end") ? compound.getString("deco_end") : null;
		if(compound.hasKey("decos")){
			if(decos == null) decos = new HashMap<>();
			NBTTagList list = (NBTTagList)compound.getTag("decos");
			for(NBTBase base : list){
				String[] split = ((NBTTagString)base).getString().split(";");
				decos.put(split[0], split[1]);
			}
		}
		else{
			if(decos != null) decos.clear();
		}
		if(relay.holder.region.system.isRemote()){
			deco_m = null;
		}
		return this;
	}

	/*public WireUnit getUnit(Long knownid){
		WireUnit unit = relay.holder.region.system.getWireUnits().get(id.toUnitId(copy), knownid, true);
		if(copy) unit.copy = this;
		else unit.orig = this;
		return unit;
	}*///TODO

	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setFloat("sx", start.x);
		compound.setFloat("sy", start.y);
		compound.setFloat("sz", start.z);
		compound.setFloat("ex", end.x);
		compound.setFloat("ey", end.y);
		compound.setFloat("ez", end.z);
		compound.setFloat("slack", slack);
		compound.setFloat("length", length);
		key.save(compound);
		if(type != null) compound.setString("wiretype", type.getRegistryName().toString());
		//TODO if(unit != null) compound.setLong("section", unit.getSectionId());
		if(deco_start != null) compound.setString("deco_start", deco_start);
		if(deco_end != null) compound.setString("deco_end", deco_end);
		if(decos != null && decos.size() > 0){
			NBTTagList list = new NBTTagList();
			for(Entry<String, String> entry : decos.entrySet()){
				list.appendTag(new NBTTagString(entry.getKey() + ";" + entry.getValue()));
			}
			compound.setTag("decos", list);
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
		wire.rootpath = new Vec3f[rootpath.length];
		wire.rootpath[0] = rootpath[2];
		wire.rootpath[1] = rootpath[1];
		wire.rootpath[2] = rootpath[0];
		wire.construct();
		wire.length = wire.calcLength();
		return wire;
	}
	
	public Wire createOppositeCopy(){
		Wire wire = copyTo(new Wire(relay));
		wire.unit = unit;
		return wire;
	}
	
	public Vec3f getVectorPosition(float distance, boolean reverse){
		if(reverse) distance = (float)this.oppositePassed(distance);
		if(distance >= this.length){
			return new Vec3f(vecpath[vecpath.length - 1]);
		}
		float traveled = 0, temp, multi;
		for(int i = 0; i < vecpath.length - 1; i++){
			temp = traveled + (multi = vecpath[i].dis(vecpath[i + 1]));
			if(temp >= distance){
				if(temp == distance) return new Vec3f(vecpath[i + 1]);
				return vecpath[i + 1].distance(vecpath[i], temp - distance);
			}
			else{
				traveled += multi;
			}
		}
		return new Vec3f(vecpath[0]);
	}

	public float oppositePassed(float sec){
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

	public Vec3f getVectorOnWire(Vec3f ext){
		Vec3f at = vecpath[0];
		float dis = ext.dis(vecpath[0]), tes;
		for(Vec3f vec : vecpath){
			if((tes = vec.dis(ext)) < dis){
				dis = tes;
				at = vec;
			}
		}
		return at;
	}
	
	public float getPassedOnWire(Vec3f ext){
		float passed = 0;
		Vec3f at = getVectorOnWire(ext), last = at;
		for(int i = 1; i < vecpath.length; i++){
			float dis = last.dis(vecpath[i]);
			if(dis < 0.001f) break;
			passed += dis;
		}
		return passed;
	}

}
