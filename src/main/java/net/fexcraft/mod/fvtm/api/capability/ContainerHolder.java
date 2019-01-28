package net.fexcraft.mod.fvtm.api.capability;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Ferdinand Calo' (FEX___96)
 * 
 * General capability to be attached to Entities which can hold containers.
 */
public interface ContainerHolder {
	
	// General
	
	/** Method to get a specific container or the only available one.
	 * @param id the requested container, leave null if the entity only has one
	 * @return null, if there is no container in this entity, or with that id
	 * */ @Nullable
	public ContainerData getContainer(@Nullable String id);
		
	/** Method to get the type of a specific container or of the only available one.
	 * @param id the requested container, leave null if the entity only has one
	 * @return null, if there is no container in this entity, or with that id
	 * */ @Nullable
	public ContainerType getContainerType(@Nullable String id);
	
	/** Return false if the entity holds more than one container. Default: true; */
	public default boolean hasOnlyOneContainer(){ return true; }
	
	/** Gets a list/collection of container "slots" in this entity, returns null if this is a single-container entity.
	 * @param oftype filter option, shouldn't be null for cross-compatible container-slot entities
	 * */ @Nullable
	public Collection<String> getContainerIDs(@Nullable ContainerType oftype);
	
	/** Returns a list of all Container AABBs in this entity (usually 1m³ large, center of the container).
	 * @param oftype filter option, shouldn't be null for cross-compatible container-slot entities
	 * @return map of AABBs of this entity's container slots.
	 */
	public Map<String, AxisAlignedBB> getContainerAABBs(@Nullable ContainerType oftype);
	
	/** Method to get the AABB of a specific container, or of the only one.
	 * @param id the id of the wanted container AABB, ignored if single container entity
	 * @return AABB of the requested container.
	 */
	public AxisAlignedBB getContainerAABB(@Nullable String id);
	
	/** Tries to update the Entity's ContainerData
	 * @param id the to be changed ContainerData, ignored if single container entity.
	 * @param data the ContainerData to be set, can be null.
	 * @return if the process did succeed.
	 * */
	public boolean setContainer(@Nullable String id, @Nullable ContainerData data);
	
	// Entity Stuff
	
	/** Internal method, do not use! */
	public ContainerHolder setEntity(Entity entity);
	
	/** Returns the entity this capability is bound to. */
	public Entity getEntity();
	
	/** To be used by the ContainerHolderEntity on capability init. */
	public void setOnlyOneContainer(boolean value);
	
	/** To be used by the ContainerHolderEntity, will not work if "hasOnlyOneContainer" is set to true!
	 * @param id the ID for the slot
	 * @param relpos relative position for the container (to the center of the entity)
	 * @param deftype the default type of the slot
	 * @param rotangle Y angle under with the container is placed on the vehicle
	 * @param supported sub-types the slot can hold, e.g. if the type is LARGE and supported has MEDIUM, 2 medium instead one large container can be placed
	 * */
	public void addContainerSlot(String id, Vec3d relpos, ContainerType deftype, float rotangle, ContainerType... supported);

	/** To be used when the entity is being removed (e.g. Entity.setDead();) */
	public void dropContents();
	
	/** To be used to open the dedicated FVTM GUI. */
	public void openGui(EntityPlayer player, String slot);
	
	/** Generic boolean if the Capability has already data set or not. */
	public boolean isSetup();
	
	/** Set if the capability is setup or not, if not, it will listen to setOnlyOneContainer/addContainerSlot calls. */
	public boolean setSetup(boolean bool);
	
	// Rendering
	
	/** Client Side Method for rendering the Container(s). */
	@SideOnly(Side.CLIENT) public void render();

	public void sync(boolean tellserver);
	
	//Moved from Container.class
    
    public static interface ContainerHolderEntity {
    	
    	public void setupCapability(ContainerHolder cap);
    	
    	public float[] getEntityRotationForContainer();
    	
    }

}