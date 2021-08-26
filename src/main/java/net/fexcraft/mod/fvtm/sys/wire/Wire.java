package net.fexcraft.mod.fvtm.sys.wire;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.render.RailRenderer.TurboArrayPositioned;
import net.fexcraft.mod.fvtm.sys.uni.Path;
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
	
	protected WireUnit unit;
	protected WireBlock block;
	@SideOnly(Side.CLIENT)
	public TurboArrayPositioned wiremodel;
	
	public Wire(WireBlock block, Vec316f[] vec316fs, Vec316f vector){
		super(vec316fs, vector);
		this.block = block;
		if(block != null) unit = getUnit(block.size() == 0 ? null : block.wires.get(0).unit.getSectionId());
	}
	
	public Wire(WireBlock block, Vec316f[] vec316fs){
		super(vec316fs);
		this.block = block;
		if(block != null) unit = getUnit(block.size() == 0 ? null : block.wires.get(0).unit.getSectionId());
	}
	
	/** Only for the READ process. @param junk just to make sure it's not used elsewhere */
	public Wire(WireBlock junk){
		super();
		this.block = junk;
	}

	@Override
	public Wire read(NBTTagCompound compound){
		super.read(compound);
		if(block != null) unit = getUnit(compound.getLong("section"));
		return this;
	}

	public WireUnit getUnit(Long knownid){
		WireUnit unit = block.system.getWireUnits().get(id.toUnitId(copy), knownid, true);
		if(copy) unit.copy = this;
		else unit.orig = this;
		return unit;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		compound = super.write(compound);
		if(unit != null) compound.setLong("section", unit.getSectionId());
		return compound;
	}
	
	public Wire createOppositeCopy(){
		Wire track = super.createOppositeCopy(new Wire(block));
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
	
	public WireBlock getBlock(){
		return block;
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
