package net.fexcraft.mod.fvtm.sys.wire;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.render.RailRenderer.TurboArrayPositioned;
import net.fexcraft.mod.fvtm.sys.uni.Path;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.sys.uni.PathType;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.nbt.NBTTagCompound;
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
	@SideOnly(Side.CLIENT)
	public TurboArrayPositioned wiremodel;
	
	public Wire(WireRelay relay, Object wiretype, Vec3f[] vecs){
		this.start = new Vec316f(vecs[0]);
		this.end = new Vec316f(vecs[2]);
		id = new PathKey(start, end);
		op = new PathKey(id, true);
		rootpath = new Vec316f[]{ start, end };
		rootpath0 = vecs;
		vecpath = new Vec3f[rootpath.length];
	}
	
	@Override
	protected void construct(){
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
		this.rootpath = new Vec316f[compound.getInteger("vectors0")];
		for(int i = 0; i < rootpath0.length; i++){
			rootpath0[i] = new Vec3f();
			rootpath0[i].x = compound.getFloat("vector0-" + i + "x");
			rootpath0[i].y = compound.getFloat("vector0-" + i + "y");
			rootpath0[i].z = compound.getFloat("vector0-" + i + "z");
		}
		super.read(compound);
		if(relay != null) unit = getUnit(compound.getLong("section"));
		return this;
	}

	public WireUnit getUnit(Long knownid){
		WireUnit unit = relay.system.getWireUnits().get(id.toUnitId(copy), knownid, true);
		if(copy) unit.copy = this;
		else unit.orig = this;
		return unit;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		compound = super.write(compound);
		compound.setInteger("vectors0", rootpath0.length);
		for(int i = 0; i < rootpath0.length; i++){
			compound.setFloat("vector0-" + i + "x", rootpath0[i].x);
			compound.setFloat("vector0-" + i + "y", rootpath0[i].y);
			compound.setFloat("vector0-" + i + "z", rootpath0[i].z);
		}
		if(unit != null) compound.setLong("section", unit.getSectionId());
		return compound;
	}
	
	public Wire createOppositeCopy(){
		Wire track = super.createOppositeCopy(new Wire(relay));
		track.unit = unit;
		return track;
	}
	
	public Vec3f getVectorPosition(float distance, boolean reverse){
		Vec3f vec = this.getVectorPosition0(distance, reverse);
		//vec.y += offset;
		return vec;
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
