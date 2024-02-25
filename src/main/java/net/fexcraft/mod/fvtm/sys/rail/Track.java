package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.render.RailRenderer.TurboArrayPositioned;
import net.fexcraft.mod.fvtm.sys.uni.Path;
import net.fexcraft.mod.fvtm.sys.uni.PathType;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.NBTTagCompound;
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
	public String preset;
	public int items;
	
	public Track(Junction junction, QV3D[] gridvecs, QV3D vector, RailGauge gauge){
		super(gridvecs, vector);
		this.junction = junction;
		this.gauge = gauge;
		setunit();
	}

	public Track(Junction junction, QV3D[] gridvecs, RailGauge gauge){
		super(gridvecs);
		this.junction = junction;
		this.gauge = gauge;
		setunit();
	}
	
	private void setunit(){
		if(junction == null) return;
		Long id = null;
		if(junction.size() == 0){
			junction = junction.root.getJunction(end);
			id = junction.size() == 0 ? null : junction.tracks.get(0).unit.getSectionId();
		}
		else id = junction.tracks.get(0).unit.getSectionId();
		unit = getUnit(id);
	}
	
	/** Only for the READ process. @param junc just to make sure it's not used elsewhere */
	public Track(Junction junc){ super(); this.junction = junc; }

	@Override
	public Track read(TagCW compound){
		super.read(compound);
		if(junction != null) unit = getUnit(compound.getLong("section"));
		if(compound.has("gauge")){
			gauge = FvtmRegistry.RAILGAUGES.get(compound.getString("gauge"));
		}
		if(gauge == null){
			gauge = FvtmRegistry.RAILGAUGES.get(InternalAddon.STANDARD_GAUGE);
		}
		if(junction == null || junction.root.getWorld().isRemote){
			railmodel = null; restmodel = null;
		}
		if(compound.has("preset")) preset = compound.getString("preset");
		//if(compound.hasKey("blockless")) blockless = compound.getBoolean("blockless");
		if(compound.has("items")) items = compound.getInteger("items");
		return this;
	}

	public TrackUnit getUnit(Long knownid){
		TrackUnit unit = junction.root.getTrackUnits().get(id.toUnitId(copy), knownid, true);
		if(copy) unit.copy = this; else unit.orig = this; return unit;
	}

	@Override
	public TagCW write(TagCW compound){
		compound = super.write(compound);
		if(unit != null) compound.set("section", unit.getSectionId());
		compound.set("gauge", (gauge == null ? InternalAddon.STANDARD_GAUGE : gauge.getIDS()).toString());
		if(preset != null) compound.set("preset", preset);
		//if(blockless) compound.setBoolean("blockless", true);
		if(items > 0) compound.set("items", items);
		return compound;
	}
	
	public Track createOppositeCopy(){
		Track track = super.createOppositeCopy(new Track(junction));
		track.unit = unit;
		track.gauge = gauge;
		//track.blockless = blockless;
		track.preset = preset;
		track.items = items;
		return track;
	}

	public boolean isCompatibleGauge(RailGauge gauge){
		return this.gauge.width() == gauge.width() || this.gauge.getCompatible().contains(gauge.getIDS().toString());
	}

	public RailGauge getGauge(){
		return gauge;
	}

	@Override
	public V3D getVectorPosition(double distance, boolean reverse){
		V3D vec = this.getVectorPosition0(distance, reverse);
		vec.y += gauge.height16();
		return vec;
	}
	
	@Override
	public String toString(){
		return String.format("Track[%s-%s, %s, %s, %s, %s]", start, end, vecpath.length, unit == null ? "n/u" : unit.getSectionId() + "/s", copy ? "copy" : "original", items);
	}
	
	public TrackUnit getUnit(){
		return unit;
	}

	@Override
	public PathType getType(){
		return PathType.RAIL;
	}
	
	public Junction getJunction(){
		return junction;
	}

	public V3D getVectorOnTrack(V3D ext){
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
	
	public double getPassedOnTrack(V3D ext){
		float passed = 0;
		V3D at = getVectorOnTrack(ext), last = at;
		for(int i = 1; i < vecpath.length; i++){
			double dis = last.dis(vecpath[i]);
			if(dis < 0.001f) break;
			passed += dis;
		}
		return passed;
	}

	public Track withPreset(String string){
		this.preset = string;
		return this;
	}

}
