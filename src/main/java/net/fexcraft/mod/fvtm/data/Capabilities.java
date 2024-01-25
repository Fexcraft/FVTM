package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fvtm.data.block.MultiBlockCache;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSigns;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

/** @author Ferdinand Calo' (FEX___96) */
public class Capabilities {
	
	/** For Vehicle, Part and Container Items. */
	@CapabilityInject(VehicleAndPartDataCache.class)
	public static final Capability<VehicleAndPartDataCache> VAPDATA = null;
	
	/** For VehicleEntities and eventually other, client side only.  */
	@CapabilityInject(RenderCache.class)
	public static final Capability<RenderCache> RENDERCACHE = null;
	
	/** For Vehicles which can transport Containers */
	@CapabilityInject(ContainerHolder.class)
	public static final Capability<ContainerHolder> CONTAINER = null;
	
	/** Per-World MultiBlock Access Cache */
	@CapabilityInject(MultiBlockCache.class)
	public static final Capability<MultiBlockCache> MULTIBLOCKS = null;
	
	/** Player-Specific Data */
	@CapabilityInject(PlayerData.class)
	public static final Capability<PlayerData> PLAYERDATA = null;
	
	/** Optional Passenger Capability */
	@CapabilityInject(Passenger.class)
	public static final Capability<Passenger> PASSENGER = null;
	
	/** TrafficSign Chunk Storage */
	@CapabilityInject(TrafficSigns.class)
	public static final Capability<TrafficSigns> TRAFFIC_SIGNS = null;
	
}