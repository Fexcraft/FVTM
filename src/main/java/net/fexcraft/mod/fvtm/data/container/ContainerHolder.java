package net.fexcraft.mod.fvtm.data.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** 
 * @author Ferdinand Calo' (FEX___96)
 */
public interface ContainerHolder {
	
	public ContainerSlot[] getContainerSlots();
	
	public ContainerSlot getContainerSlot(String id);
	
	public String[] getContainerSlotIds();
	
	/** Works only during setup. */
	public void addContainerSlot(ContainerSlot slot);
	
	/** Opens the dedicated universal FVTM ContainerHolder GUI.
	 * @param player - can be null on client side */
	public void openGUI(EntityPlayer player);

	/** Drops the loaded containers, use e.g. before removing an entity. */
	public void dropContents();

	/** Sends a whole copy from server side to clients, use when necessary. */
	public void sync(boolean fromside);
	
	@SideOnly(Side.CLIENT) /** Call in entity rendering, with the parameters being entity position. */
	public void render(double x, double y, double z, double yaw, double pitch, double roll);
	
	public static interface ContainerHoldingEntity {
		
		public void setupCapability(ContainerHolder capability);
		
		public double[] getEntityRotationForFvtmContainers();
		
		public Vec3d getContainerSlotPosition(String slot, ContainerHolder capability);
		
		public Vec3d getContainerInSlotPosition(String slot, ContainerHolder capability, ContainerType type, int index);
		
	}
	
}