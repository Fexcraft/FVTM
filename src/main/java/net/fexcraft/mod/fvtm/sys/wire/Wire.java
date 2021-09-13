package net.fexcraft.mod.fvtm.sys.wire;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.model.WireModel;
import net.fexcraft.mod.fvtm.render.RailRenderer.TurboArrayPositioned;
import net.fexcraft.mod.fvtm.sys.uni.Path;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.sys.uni.PathType;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Wire extends Path {

	public Vec3f[] rootpath0;
	protected WireUnit unit;
	protected WireRelay relay;
	protected WireType type;
	//
	@SideOnly(Side.CLIENT)
	public TurboArrayPositioned wiremodel;
	public float model_start_angle, model_end_angle;
	public float model_start_angle_down, model_end_angle_down;
	@SideOnly(Side.CLIENT)
	public WireModel deco_s, deco_e;
	public String deco_start, deco_end;
	public float slack = 1;
	
	public Wire(WireRelay relay, WireRelay relay0, WireType wiretype, Vec3f... vecs){
		this.start = relay.getVec316f().copy();
		this.end = relay0.getVec316f().copy();
		id = new PathKey(start, end);
		op = new PathKey(id, true);
		rootpath = new Vec316f[]{ start, end };
		rootpath0 = vecs;
		vecpath = new Vec3f[rootpath0.length];
		type = wiretype;
		slack = type.default_slack();
	}
	
	@Override
	public void construct(){
		vecpath = new Vec3f[rootpath0.length];
		for(int i = 0; i < rootpath0.length; i++){
			vecpath[i] = rootpath0[i];
		}
		Vec3f[] vecs = curve(vecpath);
		vecpath = new Vec3f[vecs.length + 2];
		vecpath[0] = rootpath0[0];
		for(int i = 0; i < vecs.length; i++){
			vecpath[i + 1] = vecs[i];
		}
		vecpath[vecpath.length - 1] = rootpath0[2];
		this.length = this.calcLength();
	}
	
	/** Only for the READ process. @param relay just to make sure it's not used elsewhere */
	public Wire(WireRelay relay){
		super();
		this.relay = relay;
	}

	@Override
	public Wire read(NBTTagCompound compound){
		if(compound.hasKey("wiretype")) type = Resources.WIRES.getValue(new ResourceLocation(compound.getString("wiretype")));
		this.rootpath0 = new Vec3f[compound.getInteger("vectors0")];
		for(int i = 0; i < rootpath0.length; i++){
			rootpath0[i] = new Vec3f();
			rootpath0[i].x = compound.getFloat("vector0-" + i + "x");
			rootpath0[i].y = compound.getFloat("vector0-" + i + "y");
			rootpath0[i].z = compound.getFloat("vector0-" + i + "z");
		}
		super.read(compound);
		if(relay != null) unit = getUnit(compound.getLong("section"));
		deco_start = compound.hasKey("deco_start") ? compound.getString("deco_start") : null;
		deco_end = compound.hasKey("deco_end") ? compound.getString("deco_end") : null;
		if(compound.hasKey("slack")) slack = compound.getFloat("slack");
		return this;
	}

	public WireUnit getUnit(Long knownid){
		WireUnit unit = relay.holder.region.system.getWireUnits().get(id.toUnitId(copy), knownid, true);
		if(copy) unit.copy = this;
		else unit.orig = this;
		return unit;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		compound = super.write(compound);
		if(type != null) compound.setString("wiretype", type.getRegistryName().toString());
		compound.setInteger("vectors0", rootpath0.length);
		for(int i = 0; i < rootpath0.length; i++){
			compound.setFloat("vector0-" + i + "x", rootpath0[i].x);
			compound.setFloat("vector0-" + i + "y", rootpath0[i].y);
			compound.setFloat("vector0-" + i + "z", rootpath0[i].z);
		}
		if(unit != null) compound.setLong("section", unit.getSectionId());
		if(deco_start != null) compound.setString("deco_start", deco_start);
		if(deco_end != null) compound.setString("deco_end", deco_end);
		compound.setFloat("slack", slack);
		return compound;
	}
	
	@Override
	public <T extends Path> T createOppositeCopy(T instance){
		Wire wire = (Wire)instance;
		wire.id = new PathKey(id, true);
		wire.op = new PathKey(id, false);
		wire.start = end;
		wire.end = start;
		wire.copy = true;
		wire.rootpath = new Vec316f[rootpath.length];
		int j = rootpath.length - 1;
		for(int i = 0; i < wire.rootpath.length; i++){
			wire.rootpath[i] = rootpath[j--].copy();
		}
		wire.rootpath0 = new Vec3f[rootpath0.length];
		j = rootpath0.length - 1;
		for(int i = 0; i < wire.rootpath0.length; i++){
			wire.rootpath0[i] = new Vec3f(rootpath0[j--]);
		}
		wire.construct();
		wire.length = wire.calcLength();
		return (T)wire;
	}
	
	public Wire createOppositeCopy(){
		Wire wire = createOppositeCopy(new Wire(relay));
		wire.unit = unit;
		return wire;
	}
	
	public Vec3f getVectorPosition(float distance, boolean reverse){
		return getVectorPosition0(distance, reverse);
	}
	
	@Override
	public String toString(){
		return String.format("Wire[%s-%s, %s, %s, %s]", start, end, vecpath.length, unit == null ? "n/u" : unit.getSectionId(), copy ? "copy" : "original");
	}
	
	public WireUnit getUnit(){
		return unit;
	}

	@Override
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
