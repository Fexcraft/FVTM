package net.fexcraft.mod.fvtm.data;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.minecraft.item.ItemStack;

/**
 * @author Ferdinand Calo' (FEX___96)
 * 
 * Capability to create temporary copies of data stored in FVTM (some) items,
 * to prevent re-parsing every tick from NBT (e.g. when viewing the tooltip).
 */
public interface VehicleAndPartDataCache {

	public void setStack(ItemStack stack);

	public @Nullable VehicleData getVehicleData();

	public @Nullable PartData getPartData();

	public @Nullable ContainerData getContainerData();

	public @Nullable BlockData getBlockData();
	
	public boolean overridesLang(boolean bool);

}