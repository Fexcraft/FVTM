package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

/** @author Ferdinand Calo' (FEX___96) */
public class Capabilities {
	
	/** For Vehicle, Part and Container Items. */
	@CapabilityInject(VehicleAndPartDataCache.class)
	public static final Capability<VehicleAndPartDataCache> VAPDATA = null;
	
	/** Usually stored in the World. */
	/*@CapabilityInject(Resources.class)
	public static final Capability<Resources> RESOURCES = null;*/
	
	/** For Vehicles which can transport Containers */
	@CapabilityInject(ContainerHolder.class)
	public static final Capability<ContainerHolder> CONTAINER = null;
	
	/** Per-World RailSystem container. */
	@CapabilityInject(RailSystem.class)
	public static final Capability<RailSystem> RAILSYSTEM = null;
	
}