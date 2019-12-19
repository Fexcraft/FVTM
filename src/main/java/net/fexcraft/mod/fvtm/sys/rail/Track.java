package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.render.RailRenderer.TurboArrayPositioned;
import net.fexcraft.mod.fvtm.sys.uni.Path;
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
public class Track extends Path {
	
	public RailGauge gauge;
	protected TrackUnit unit;
	protected Junction junction;
	@SideOnly(Side.CLIENT)
	public TurboArrayPositioned railmodel;
	@SideOnly(Side.CLIENT)
	public TurboArrayPositioned restmodel;
	
	public Track(Junction junction, Vec316f[] vec316fs, Vec316f vector, RailGauge gauge){
		super(vec316fs, vector); this.junction = junction; this.gauge = gauge;
		if(junction != null) unit = getUnit(junction.size() == 0 ? null : junction.tracks.get(0).unit.getSectionId());
	}
	
	public Track(Junction junction, Vec316f[] vec316fs, RailGauge gauge){
		super(vec316fs); this.junction = junction; this.gauge = gauge;
		if(junction != null) unit = getUnit(junction.size() == 0 ? null : junction.tracks.get(0).unit.getSectionId());
	}
	
	/** Only for the READ process. @param junk just to make sure it's not used elsewhere */
	public Track(Junction junk){ super(); this.junction = junk; }

	@Override
	public Track read(NBTTagCompound compound){
		super.read(compound);
		unit = getUnit(compound.getLong("section"));
		if(compound.hasKey("gauge")){
			gauge = Resources.RAILGAUGES.getValue(new ResourceLocation(compound.getString("gauge")));
		}
		if(gauge == null){
			gauge = Resources.RAILGAUGES.getValue(InternalAddon.STANDARD_GAUGE);
		}
		if(junction.root.getWorld().isRemote){
			railmodel = null; restmodel = null;
		}
		return this;
	}

	public TrackUnit getUnit(Long knownid){
		TrackUnit unit = junction.root.getTrackUnits().get(id.toUnitId(copy), knownid, true);
		if(copy) unit.copy = this; else unit.orig = this; return unit;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		compound = super.write(compound);
		if(unit != null) compound.setLong("section", unit.getSectionId());
		compound.setString("gauge", (gauge == null ? InternalAddon.STANDARD_GAUGE : gauge.getRegistryName()).toString());
		return compound;
	}
	
	public Track createOppositeCopy(){
		Track track = super.createOppositeCopy(Track.class);
		track.unit = unit; track.gauge = gauge;
		return track;
	}

	public boolean isCompatibleGauge(RailGauge gauge){
		return this.gauge.width() == gauge.width() || this.gauge.getCompatible().contains(gauge.getRegistryName().toString());
	}

	public RailGauge getGauge(){
		return gauge;
	}
	
	public Vec3f getVectorPosition(float distance, boolean reverse){
		Vec3f vec = this.getVectorPosition0(distance, reverse);
		vec.yCoord += gauge.height16(); return vec;
	}
	
	@Override
	public String toString(){
		return String.format("Track[%s-%s, %s, %s]", start, end, vecpath.length, copy ? "copy" : "original");
	}
	
	public TrackUnit getUnit(){
		return unit;
	}

	@Override
	public PathType getType(){
		return PathType.RAIL;
	}

}
