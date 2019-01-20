package net.fexcraft.mod.fvtm.api.capability;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerHolder;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.api.*;
import net.minecraft.command.ICommandSender;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * @author Ferdinand Calo' (FEX___96)
 * 
 * World Capability to get or init/load various FVTM Resources.
 * **/
public interface Resources {

	public void setWorld(World world);
	
	public World getWorld();
	
	public VehicleData getVehicleDataFromNBT(NBTTagCompound compound);
	
	public PartData getPartDataFromNBT(NBTTagCompound compound);
	
	public PartData getPartDataFromResourceLocation(ResourceLocation resloc);
	
	public ContainerData getContainerDataFromNBT(NBTTagCompound compound);
	
	public BlockData getBlockDataFromNBT(NBTTagCompound compound);
	
	public Collection<Vehicle> getVehiclesByType(VehicleType type);
	
	public Collection<Vehicle> getVehiclesByAddon(Addon addon);
	
	public IForgeRegistry<Addon> getAddons();
	
	public IForgeRegistry<Material> getMaterials();
	
	public IForgeRegistry<Part> getParts();
	
	public IForgeRegistry<Vehicle> getVehicles();

	public IForgeRegistry<Container> getContainers();

	public IForgeRegistry<Block> getBlocks();

	public IForgeRegistry<Consumable> getConsumables();
	
	public IForgeRegistry<Attribute> getPartAttributes();
	
	public Map<String, Model<?, ?>> getModels();
	
	public Map<String, JsonObject> getPresets();
	
	//
	
	public @Nullable BlockPos getNextRailCoordinate(BlockPos current_dest, BlockPos previous_dest);
	
	public @Nullable ContainerHolder getContainerAt(@Nullable ICommandSender receiver, BlockPos pos);
	
}